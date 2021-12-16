/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aecas.managed;

import com.aees.pojos.TaskCardPojo;
import com.aeroman.aees.entities.EngEsrDocument;
import com.aeroman.aees.entities.EngReqTaskCard;
import com.aeroman.aees.entities.EngRequest;
import com.aeroman.aees.entities.EngTaskCard;
import com.aeroman.aees.entities.grant.ContCheck;
import com.aeroman.aees.entities.grant.RptEsquemas; 
import com.aeroman.aees.facades.EngReqTaskCardFacade;
import com.aeroman.aees.facades.EngReqTaskCardIniFacade;
import com.aeroman.aees.facades.EngTaskCardFacade;
import com.aeroman.aees.facades.Sequences;
import com.aeroman.aees.facades.grant.ContCheckFacade;
import com.aeroman.aees.facades.grant.PrcDetparamFacade;
import com.aeroman.aees.facades.grant.RptEsquemasFacade;
import com.aeroman.reportingserviceae.util.Utils;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author Saplic16
 */
@ManagedBean(name = "taskReqCardBean")
@SessionScoped
public class TaskReqCardBean extends CrudBean<EngReqTaskCard> implements Serializable {

    @EJB
    private EngReqTaskCardFacade engReqTaskCardFacade;//declaracion de clases Facade

    @EJB
    private EngTaskCardFacade engTaskCardFacade;//declaracion de clases Facade
    
    @EJB
    private ContCheckFacade contfacade;//declaracion de clases Facade
    
    @EJB
    private EngReqTaskCardIniFacade engReqTaskCardIniFacade;//declaracion de clases Facade

    @EJB
    private Sequences seq;//declaracion de clases Facade
    
    @EJB
    private PrcDetparamFacade prcDetparamFacade;//declaracion de clases Facade

    @EJB
    private engBIReport wsBIReport;
    
    @EJB
    private RptEsquemasFacade esquemafacade;
      
    private StreamedContent pdfRender;
    
    private EsrBean esr;
    private boolean existeLista;
    
    private List<EngTaskCard> taskCards = new ArrayList<>();
    private List<String> tasks = new ArrayList<>();
    private EngRequest er;
    private String logpage;
    private String tkyear;
    private String tkcorr;
    private String principal;
    private String tc;
    private EngTaskCard taskcard;
    private String descripcion;
    private String utf="application/pdf;charset=utf-8";
    private String contedis = "Content-Disposition";
    static final String VAL_FIRMA = "http://esbt2.aeroman.com.sv:7080/brk/dev/aeroman/v100/stepapi/countLaborStep?taskCard=";
    static final String GET_TASK = "http://esbt2.aeroman.com.sv:7080/brk/dev/getTaskCard/";
    private int idFirma;
    
    
    
    @ManagedProperty(value = "#{engReqTaskJobcardBean}")
    private EngReqTaskJobcardBean engReqTaskJobcardBean;
    
    private boolean encontrarRepetido ;
    /*variables para poder consumir todos los webservices necesarios*/
    Gson gson;
    HttpClient httpClient;
    HttpPost post;
    HttpGet get;
    HttpResponse response;
    
    private static final String UTF="UTF-8";
    
    private TaskCardPojo taskCardinfo;

    @Override
    @PostConstruct
    public void init() {
        elemento = new EngReqTaskCard();
        elemento.setIdCard(new EngTaskCard());
        listado = new ArrayList<>();
        edit = false;
        er = new EngRequest();
        setearAnioTaskCard();
    }
    
    public void setearAnioTaskCard(){
        extendtime();
        Date dateactual = new Date();
        SimpleDateFormat getanio = new SimpleDateFormat("yyyy");
        String anio = getanio.format(dateactual.getTime());
        setTkyear(anio);
    }

    public void agregarESR(EngRequest req) {
        extendtime();
        elemento = new EngReqTaskCard();
        listado = engReqTaskCardFacade.findByEngRequest(req);
        if (listado.size() != 0){
            setDescripcion(listado.get(0).getErtLogpage());
        }
        engReqTaskJobcardBean.selectJobCard(req);
        setEr(req);
        taskCards = engTaskCardFacade.findByChkId(req.getChkCheckid());

    }

    public void filtroTaskCard(String o) {
        extendtime();
        Short wo = new Short(o);
        if (wo > 0) {
            taskCards = engTaskCardFacade.findByChkId(wo);
        } else {
            taskCards = null;
        }
    }

    public void concatenar() {
        extendtime();

        taskcard = engTaskCardFacade.findByYearCorr(tkyear, tkcorr);
        elemento.setIdCard(taskcard);
        String n;

        elemento.setErtLogpage(taskcard.getTcYear() + "-" + taskcard.getTcCorr());
        n = String.valueOf(taskcard.getTcYear());
        elemento.setErtTkYear(new BigInteger(n));
        n = String.valueOf(taskcard.getTcCorr());
        elemento.setErtTkCorr(new BigInteger(n));

    }
    
    public String infoTaskCard(String woEsr){
        extendtime();
        String mensaje = "";
        try {
            ContCheck cck = new ContCheck();
            cck=contfacade.find(new BigDecimal(woEsr));
            woEsr=cck.getChkWo();
            String tail = cck.getChkRegistry();
            //url desa "http://esbt.aeroman.com.sv:7080/brk/dev/getTaskCard/"   
            //url test "http://web1salwlt.aeroman.com.sv:8004/brk/test/getTaskCard/"  
            //url prod "http://web1salwlp.aeroman.com.sv:8002/brk/prod/getTaskCard/"  
            String anioBueno = validarAnio(tkyear);
            String correlativo = validarTaskCorr(tkcorr);
            String  respuesta;
            String taskWebService=prcDetparamFacade.findByLiksWeb("TASK").getValor();
            // VALIDACION DE FIRMA:
            idFirma = validarFirma(correlativo,anioBueno);
            //String postUrl = GET_TASK+anioBueno+"/"+ correlativo+"/AEIS";
            String postUrl = taskWebService+anioBueno+"/"+ correlativo+"/AEIS";
            gson = new Gson();
            httpClient = new DefaultHttpClient();
            post = new HttpPost(postUrl);
            String[] wosplit;
            String workorder;
            response = httpClient.execute(post);
            try (BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), UTF))) {
                respuesta = br.readLine();
                JSONObject json = (JSONObject) new JSONParser().parse(respuesta);
                taskCardinfo = gson.fromJson(json.toJSONString(), TaskCardPojo.class);

                if ("0".equals(taskCardinfo.getResponse().getErrorCode())) {
                    taskCardinfo.getResponse().getMsg().setWo(taskCardinfo.getResponse().getMsg().getWo().replace(" ", ""));
                    wosplit = taskCardinfo.getResponse().getMsg().getWo().split("-");
                    workorder = wosplit[0] + "-" + wosplit[1].replaceFirst("^0*", "");
                    wosplit = workorder.split("/");
                    workorder = wosplit[0] + "/" + wosplit[1].replaceFirst("^0*", "");
                    String tailFromService = taskCardinfo.getResponse().getMsg().getTail();
                    boolean perteneceAlAvion = tail.equals(tailFromService);
                    boolean perteneceAlaWo = woEsr.equals(workorder);
                    mensaje = perteneceAlAvion ? "continue":"tajeta no pertenece";
                    //Generar PDF:
                    if(idFirma==1){
                        String comp = taskCardinfo.getResponse().getMsg().getCus().toUpperCase();
                        String nReport = prcDetparamFacade.findByRpENGESR(comp).getValor();
    //                    if (taskCardinfo.getResponse().getMsg().getCus().equals("DELTA")) {
    //                        nReport = "/DESA/AENRS/discrepancydelta/discrepancydelta.xdo";
    //                    }
    //                    if (taskCardinfo.getResponse().getMsg().getCus().equals("JETBLUE")) {
    //                        nReport = "/DESA/AENRS/discrepancyjetblue/discrepancyjetblue.xdo";
    //                    }
    //                    if (taskCardinfo.getResponse().getMsg().getCus().equals("AA")) {
    //                        nReport = "/DESA/AENRS/discrepancyus/discrepancyus.xdo";
    //                    }
    //                    if (taskCardinfo.getResponse().getMsg().getCus().equals("FDX")) {
    //                        nReport = "/DESA/AENRS/discrepancyfedex/discrepancyfedex.xdo";
    //                    }

                        try {
                            GeneraRpt(nReport);

                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    }
                    
                    if (perteneceAlAvion && !engTaskCardFacade.findTaskByYearCorr(tkyear, tkcorr)) {
                    //if (perteneceAlAvion && engTaskCardFacade.findTaskByYearCorr(tkyear, tkcorr)) {   
                        List<ContCheck> listaWo = new ArrayList<>();
                        listaWo = contfacade.findByidchekforwo(woEsr);
                        if (!listaWo.isEmpty()){
                            ContCheck cont = listaWo.get(0);
                            taskcard = new EngTaskCard();
                            taskcard.setIdCard(engTaskCardFacade.idTaskcard());
                            taskcard.setTcCorr(Integer.parseInt(tkcorr));
                            taskcard.setTcYear(new Short(tkyear));
                            taskcard.setTcDescription(taskCardinfo.getResponse().getMsg().getShortDesc());
                            taskcard.setChkCheckid(cont.getContCheckId().intValue());
                            //Agregar complementarios, para poder cargar en listado:
                            taskcard.setTcSTAT(taskCardinfo.getResponse().getMsg().getEstado());
                            taskcard.setTcTC(taskCardinfo.getResponse().getMsg().getTc());
                            taskcard.setTcCRT(taskCardinfo.getResponse().getMsg().getCrt());
                            taskcard.setTcDESCRIPT(taskCardinfo.getResponse().getMsg().getDescription());
                            taskcard.setTcFLOTA(taskCardinfo.getResponse().getMsg().getFlota());
                            taskcard.setTcWC(taskCardinfo.getResponse().getMsg().getWc());
                            taskcard.setTcEST(taskCardinfo.getResponse().getMsg().getEst());
                            taskcard.setTcJOBC(taskCardinfo.getResponse().getMsg().getEst());
                            taskcard.setTcWO(taskCardinfo.getResponse().getMsg().getWo());
                            taskcard.setTcCUS(taskCardinfo.getResponse().getMsg().getCus());
                            taskcard.setTcTAIL(taskCardinfo.getResponse().getMsg().getTail());
                            taskcard.setTcTASKCARDTYPE(taskCardinfo.getResponse().getMsg().getTaskCardType());
                            taskcard.setTcROUTINE(taskCardinfo.getResponse().getMsg().getRoutine());
                            taskcard.setTcOPERATOR(taskCardinfo.getResponse().getMsg().getOperator());
                            taskcard.setTcDISCREPANCYID(taskCardinfo.getResponse().getMsg().getDiscrepancyId());
                            taskcard.setTcCORRECTIVEID(taskCardinfo.getResponse().getMsg().getCorrectiveId());
                            
                            engTaskCardFacade.create(taskcard);
                        }
                        
                    }
                }else{
                    mensaje = "no existe";
                }

            }
        } catch (IOException | ParseException ex) {
            Logger.getLogger(TaskReqCardBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mensaje;
    }
    
    public String validarAnio(String dato) {
        extendtime();
        String leng = String.valueOf(dato);
        switch (leng.length()) {
            case 1:
                leng = "000" + leng;
                break;
            case 2:
                leng = "00" + leng;
                break;
            case 3:
                leng = "0" + leng;
                break;
            default:

        }
        return leng;
    }
    
    public String validarTaskCorr(String dato) {
        extendtime();
        String lengC = dato;
        String cero1 = "0";
        String cero2 = "00";
        String cero3 = "000";
        String cero4 = "0000";
        String cero5 = "00000";
        String cero6 = "000000";
        if (lengC != null) {
            try {
                switch (dato.length()) {
                    
                    case 1:
                        lengC = cero6 + dato;
                        break;
                    case 2:
                        lengC = cero5 + dato;
                        break;
                    case 3:
                        lengC = cero4 + dato;
                        break;
                    case 4:
                        lengC = cero3 + dato;
                        break;
                    case 5:
                        lengC = cero2 + dato;
                        break;
                    case 6:
                        lengC = cero1 + dato;
                        break;
                    default:

                }
            } catch (Exception e) {
                Logger.getLogger(TaskReqCardBean.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return lengC;
    }
    
    //
        public int validarFirma(String correlativo, String anio) {
        int result = 0;
        String  respuesta;
        try 
        {
            gson = new Gson();
            httpClient = new DefaultHttpClient();
            String signatureWebService=prcDetparamFacade.findByLiksWeb("SIGNATURE").getValor();
            get = new HttpGet(signatureWebService + correlativo +"&year=" + anio);
            response = httpClient.execute(get);
            BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), UTF));
            respuesta = br.readLine();
            JSONObject json = (JSONObject) new JSONParser().parse(respuesta);
            String valTotal = (String) json.get("total");
            if (valTotal.equals("0")) {
                result=0;
            }
            else
            {
                result=1;
            }
            
        } 
            catch (Exception ex) 
        {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
        
        
//Cargar PDF:
    public void GeneraRpt(String nReport)
    {
        
        try {
            /*
            String repor64;
            HttpServletResponse response =(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse(); 
            response.setContentType(utf);
            response.setHeader(contedis, "inline; filename=discrepancydelta.pdf");  
            RptEsquemas report = esquemafacade.findbyname("AEIS");
            String wsdl=report.getRuta();
            String absolutePath=report.getRutaJasper()+"/DESA/AENRS/discrepancydelta/discrepancydelta.xdo";
            String user=report.getUsuario();
            String pass=report.getClave();
            repor64=String.valueOf(Utils.downloadPDF2("01",wsdl,absolutePath,user,pass));
            */
            pdfRender = wsBIReport.runReport(tkyear, tkcorr, nReport);
                byte[] decoder = Base64.getDecoder().decode(wsBIReport.getBase64PdfWs());
                SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyHHmm");
                String nomb = (sdf.format(new Date())).toString();
                Short idDoc= 7777;
                for (int i = 0; i < 1; i++) 
                {
                    EngEsrDocument lisAdjsj = new EngEsrDocument();
                    lisAdjsj.setNombreAcotado(nomb);
                    lisAdjsj.setNameDocu(nomb);
                    lisAdjsj.setExtenDocu(".pdf");
                    lisAdjsj.setBodyDocu(decoder);
                    lisAdjsj.setExtension(".pdf");
                    lisAdjsj.setIdDocu(idDoc);
                    lisAdjsj.setReqMessageid(idDoc);
                    esr.getEsrDocumentBean().listado.add(lisAdjsj);
                    setExisteLista(true);
                    lisAdjsj = new EngEsrDocument();
                }
                
                
                
        } catch (Exception e) {
             System.out.println(e);
        }
               
    }
        

    @Override
    public void limpiar() {
        extendtime();
        elemento = new EngReqTaskCard();
        descripcion="";
        logpage = "";
        tkyear = "";
        tkcorr = "";
        principal = "";
        tc = "";
        taskcard = null;
        edit = false;
        encontrarRepetido = false;
        setearAnioTaskCard();
    }

    @Override
    public void actualizar() {
        extendtime();
        try {
            taskcard = engTaskCardFacade.find(Integer.parseInt(tc));
            elemento.setIdCard(taskcard);
            engReqTaskCardFacade.edit(elemento);
        } catch (Exception e) {
            Logger.getLogger(TaskReqCardBean.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            limpiar();
        }

    }

    @Override
    public void agregar() {
        extendtime();
        try {
            encontrarRepetido = false;
            elemento.setIdCard(taskcard);
            elemento.setReqMessageid(er); //id de ESR
            if (listado.size() > 0) {
                elemento.setErtPrincipal("N");
            } else {
                elemento.setErtPrincipal("Y");
            }
            List<EngReqTaskCard> otroEliminar = listado;
            for (EngReqTaskCard lis : otroEliminar) {
                if (lis.getIdCard().getIdCard().toString().equals(elemento.getIdCard().getIdCard().toString())) {
                    encontrarRepetido = true;
                    break;
                }
            }
            if (!encontrarRepetido) {
                if (elemento.getReqMessageid() != null && elemento.getReqMessageid().getReqMessageid() != null) {
                    elemento.setErtIdReg(seq.maxCodIdErt());
                    engReqTaskCardFacade.create(elemento);
                     
                }
                listado.add(elemento);
                if (listado.size() != 0){
                    setDescripcion(listado.get(0).getErtLogpage());
                }
                setTkcorr(null);
                setearAnioTaskCard();
                elemento = new EngReqTaskCard();
            }
            
        } catch (Exception e) {
            Logger.getLogger(TaskReqCardBean.class.getName()).log(Level.SEVERE, null, e);
        } 

    }

    @Override
    public void eliminar(EngReqTaskCard elementovista) {
        extendtime();
        try {
            if (elementovista.getErtIdReg() != null) {
                engReqTaskCardFacade.remove(elementovista);
            }
            List<EngReqTaskCard> otroEliminar = listado;
            listado = new ArrayList<>();
            for (EngReqTaskCard lis : otroEliminar) {
                if (!lis.getIdCard().getIdCard().toString().equals(elementovista.getIdCard().getIdCard().toString())) {
                    listado.add(lis);
                }
            }
            if (listado.size() != 0){
            setDescripcion(listado.get(0).getErtLogpage());
            }
            else{
                setDescripcion("");
            }

        } catch (Exception e) {
            Logger.getLogger(TaskReqCardBean.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    @Override
    public EngReqTaskCard nuevoElemento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<EngTaskCard> getTaskCards() {
        return taskCards;
    }

    public void setTaskCards(List<EngTaskCard> taskCards) {
        this.taskCards = taskCards;
    }

    public EngRequest getEr() {
        return er;
    }

    public void setEr(EngRequest er) {
        this.er = er;
    }

    public String getLogpage() {
        return logpage;
    }

    public void setLogpage(String logpage) {
        this.logpage = logpage;
    }

    public String getTkyear() {
        return tkyear;
    }

    public void setTkyear(String tkyear) {
        this.tkyear = tkyear;
    }

    public String getTkcorr() {
        return tkcorr;
    }

    public void setTkcorr(String tkcorr) {
        this.tkcorr = tkcorr;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public EngTaskCard getTaskcard() {
        return taskcard;
    }

    public void setTaskcard(EngTaskCard taskcard) {
        this.taskcard = taskcard;
    }

    public String getTc() {
        if (elemento.getIdCard() != null) {
            if (elemento.getIdCard().getIdCard() != null) {
                tc = elemento.getIdCard().getIdCard().toString();
            } else {
                tc = "";
            }

        } else {
            tc = "";
        }
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

    public List<String> getTasks() {
        tasks.clear();
        for (EngTaskCard t : taskCards) {
            tasks.add("\"" + t.getTcYear() + "-" + t.getTcCorr() + "\"");
        }
        return tasks;
    }

    public void setTasks(List<String> tasks) {
        this.tasks = tasks;
    }

    public boolean isEncontrarRepetido() {
        return encontrarRepetido;
    }

    public void setEncontrarRepetido(boolean encontrarRepetido) {
        this.encontrarRepetido = encontrarRepetido;
    }

    public EngReqTaskJobcardBean getEngReqTaskJobcardBean() {
        return engReqTaskJobcardBean;
    }

    public void setEngReqTaskJobcardBean(EngReqTaskJobcardBean engReqTaskJobcardBean) {
        this.engReqTaskJobcardBean = engReqTaskJobcardBean;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    } 
    public boolean isExisteLista() {
        return existeLista;
    }

    public void setExisteLista(boolean existeLista) {
        this.existeLista = existeLista;
    }

    public int getIdFirma() {
        return idFirma;
    }

    public void setIdFirma(int idFirma) {
        this.idFirma = idFirma;
    }
}
