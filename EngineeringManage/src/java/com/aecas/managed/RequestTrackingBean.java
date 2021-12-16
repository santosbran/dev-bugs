/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aecas.managed;

import static com.aecas.managed.EaPdfBean.getSubmittedFileName;
import com.aees.session.SessionBean;
import com.aeroman.aees.entities.EngEaPdf;
import com.aeroman.aees.entities.EngReqResponses;
import com.aeroman.aees.entities.EngRequest;
import com.aeroman.aees.entities.EngTasksByUserMngVw;
import com.aeroman.aees.entities.MsjAdjuntos;
import com.aeroman.aees.entities.ResponsesNameVw;
import com.aeroman.aees.entities.engSeguimiento;
import com.aeroman.aees.entities.grant.ContCheckEmails;
import com.aeroman.aees.entities.grant.SgrOptionRole;
import com.aeroman.aees.entities.grant.SgrRole;
import com.aeroman.aees.facades.EngEaGeneralFacade;
import com.aeroman.aees.facades.EngEaPdfFacade;
import com.aeroman.aees.facades.EngReqResponsesFacade;
import com.aeroman.aees.facades.EngRequestFacade;
import com.aeroman.aees.facades.EngTasksByUserMngVwFacade;
import com.aeroman.aees.facades.MsjAdjuntosFacade;
import com.aeroman.aees.facades.ResponsesNameVwFacade;
import com.aeroman.aees.facades.Sequences;
import com.aeroman.aees.facades.SgrUrsRoleFacade;
import com.aeroman.aees.facades.SgrUserFacade;
import com.aeroman.aees.facades.engSeguimientoFacade;
import com.aeroman.aees.facades.grant.ContCheckEmailsFacade;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.util.IOUtils;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIInput;
import javax.faces.component.UIViewRoot;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import javax.faces.context.ExternalContext;
import static org.apache.soap.server.InvokeBSF.service;
import org.primefaces.model.StreamedContent;
import javax.servlet.http.HttpSession;

/**
 *
 * @author saplic
 */
@ManagedBean(name = "RequestTracking")
@SessionScoped
public class RequestTrackingBean extends CrudBean<EngReqResponses> implements Serializable {

    @EJB
    private EngReqResponsesFacade engReqResponsesFacade;
    @EJB
    private EngRequestFacade requestFacade;
    
    @EJB
    private ResponsesNameVwFacade responsesNameVwFacade;

    @EJB
    private ContCheckEmailsFacade contCheckEmailsFacade;

    @EJB
    private MsjAdjuntosFacade msjAdjuntosFacade;
    
    @EJB
    private EngEaGeneralFacade engEaGeneralFacade;
    @EJB
    private EngEaPdfFacade engEaPdfFacade;
    
    @EJB
    private engSeguimientoFacade engSegFacade;
    
    
    @EJB
    private SgrUrsRoleFacade engValidarRol;

    private EngEaPdf elements;

    private MsjAdjuntos elements2;

    private String messageId;

    private Part file;
    private String[] count;
    private List<String> emails = new ArrayList<>();
    private List<String> nameemails = new ArrayList<>();
    private int id;
    private byte[] docEa;
    private int pdfId;
    private boolean existExtensionFile;
    private int errorFile;
    private EngReqResponses elementoAdj;
    private String idReqResponse;
    private UploadedFile filex;
    private List<UploadedFile> uploadedFiles;
    private boolean disable;
    private boolean disables;
    private String idDocument;
    transient List<ResponsesNameVw> listResponsesNameVw = new ArrayList<>();
    private boolean existeLista;
    private String esESR;
    private boolean errorMail;
    private String emailAssigned;
    private String tipoSocilictudTracking="";
    //14/05/2021 : SB
    private String users;
    private String usertem;
    private String selectOption;
    transient List<SgrRole> rol = new ArrayList<>();
    private String roles;

    private String base64Pdf;
    private boolean fileNotFound;
    private HttpSession sessions = SessionBean.getSession();
    private int numESR= 0;
    private String reCorr = "";
    private String reqYear = "";
    private int maxValor;
    //Check
     private Boolean resRespPri = false;
     private Boolean resFirstResp = false;
     
     private String txtFirstResp = "N";
     private String txtRespPri = "N";

     
    transient List<EngTasksByUserMngVw> user = new ArrayList();//27/05/2021, validar el Rol.
    transient List<engSeguimiento> lstSeguimiento = new ArrayList<>();
    
    private String ocultaBtn;
    @EJB
    private Sequences numax;

    @ManagedProperty(value = "#{AdjuntosBean}")
    private AdjuntosBean adjuntosBean;

    @ManagedProperty(value = "#{eaPdfBean}")
    private EaPdfBean aaPdfBean;
    
    @ManagedProperty(value = "#{engAutorizationBean}")
    private EngAutorizationBean eaBean;
    
    private String rolUser;
    private String userTabEsr = "username";
    private String display;
    private String pointer;
    //adjuntar
    public String getBase64Pdf() {
        return base64Pdf;
    }

    public void setBase64Pdf(String base64Pdf) {
        this.base64Pdf = base64Pdf;
    }

    public boolean isFileNotFound() {
        return fileNotFound;
    }

    public void setFileNotFound(boolean fileNotFound) {
        this.fileNotFound = fileNotFound;
    }

    private boolean checkBoxValue;

    @Override
    @PostConstruct
    public void init() {
        elemento = new EngReqResponses();
        listado2 = new ArrayList<>();
        listado = new ArrayList<>();
        elemento.getReqMessageid();
        elementoAdj = new EngReqResponses();
        uploadedFiles = new ArrayList<>();
        disable=true;
        listResponsesNameVw = new ArrayList<>();
        existeLista=false;
        errorMail=true;
        
        FacesContext facesContextB = FacesContext.getCurrentInstance();
        ExternalContext externalContextB = facesContextB.getExternalContext();
        Map paramsB = externalContextB.getRequestParameterMap();
        String users = ((String) paramsB.get("user"));
        
        display = validaDis(engValidarRol.validarRol(users));
         
    }

    //04/06/2021:
    public boolean validaRol(List<SgrRole> lsRol) {
        boolean val = false;
        int valRol = 0;
        //Recorrer listado de roles:
        //Then  you can use "foreache" loop to iterate. 01/06/2021
        for (SgrRole item : lsRol) {
            valRol = Integer.parseInt(item.getSgrRolePK().getRoleCode());
            if (valRol == 7) {
                val = true;
                break;
            }
        }
        return val;
    }

    //Display:
    public String validaDis(List<SgrOptionRole> lsRol) {
        String disp = " ";
        int valRol = 0;
        for (SgrOptionRole item : lsRol) {
            valRol = Integer.parseInt(item.getRolecode());
            if (valRol == 7) {
                disp = "display:none;";
                break;
            }
        }
        return disp;
    }
    //Validar Msj ROL
    public String validarRol(List<SgrOptionRole> lsRol) {
        String disp = "ECO";
        int valRol = 0;
        for (SgrOptionRole item : lsRol) {
            valRol = Integer.parseInt(item.getRolecode());
            if (valRol == 7) {
                disp = "M";
                break;
            }
        }
        return disp;
    }
    
    public boolean isDisables() {
        return disables;
    }

    public void setDisables(boolean disables) {
        this.disables = disables;
    }
    
     public void valCheck()
    {
        
    }

    //Validar ESR cerrada:
    public boolean validaEsr() {
        boolean habilita = true;
        int validar = 0;
        if (validar > 0) {
            habilita = true;
        } else {
            habilita = false;
        }
        return habilita;
    }

    @Override
    public void limpiar() {
        extendtime();
        this.elemento = new EngReqResponses();
        edit = false;
        adjuntosBean.elemento = new MsjAdjuntos();
        adjuntosBean.listado= new ArrayList<>();
        errorFile = 0;
        existeLista=false;
    }

    public void limpiarformTracking() {
        extendtime();
        FacesContext contexteve = FacesContext.getCurrentInstance();
        UIViewRoot root = contexteve.getViewRoot();
        UIInput to = (UIInput) root.findComponent("inputFormtra:to");
        UIInput cc = (UIInput) root.findComponent("inputFormtra:CC");
        UIInput asunto = (UIInput) root.findComponent("inputFormtra:Asunto");
        UIInput messageIdform = (UIInput) root.findComponent("inputFormtra:messageId");
        UIInput genUpdate = (UIInput) root.findComponent("inputFormtra:btnUpdate");
        to.resetValue();
        cc.resetValue();
        asunto.resetValue();
        messageIdform.resetValue();
        genUpdate.resetValue();
        existeLista=false;
        setOcultaBtn("visibility:visible;");
        System.out.println("CARGANDO LOS DATOS PANEL IZQUIERDO.");
    }
    
    public void findMailSend(){
        
        existeLista=false;
        extendtime();
        elemento = new EngReqResponses();
        elemento = engReqResponsesFacade.find(new BigDecimal(adjuntosBean.getIdReqResponse()));
        try 
        {
            int val = 0;
            val = engReqResponsesFacade.valMayor(elemento.getReqMessageid());
            BigInteger value = elemento.getResCorrEsr();
            if (!(value != null && !value.equals(BigInteger.ZERO)))
            {
                elemento.setResCorrEsr(BigInteger.valueOf(val));
            }
            lstSeguimiento = engSegFacade.lsSeguimiento(elemento.getReqMessageid(), elemento.getResId());
        } 
        catch (Exception e) 
        {
            Logger.getLogger(RequestTrackingBean.class.getName()).log(Level.SEVERE, null, e);
        }
        
        if (!rolUser.equals(elemento.getResRolUser()) && elemento.getResCheck().equals("NO")){
            elemento.setResCheck("YES");
            engReqResponsesFacade.edit(elemento);
            listResponsesNameVw = responsesNameVwFacade.findTrackingsByEsr(elemento.getReqMessageid());
            recortarTxto(listResponsesNameVw);
        }
        adjuntosBean.listado = new ArrayList<>();
        adjuntosBean.listado2 = new ArrayList<>();
        adjuntosBean.findAdjunto();
        if(adjuntosBean.listado.size()>0){
            existeLista=true;
        }
        
     
        try 
        {
        if (elemento.getResRespPri().equals("Y")) 
        {
            resRespPri = true;
            txtRespPri = "Y";
        } else 
        {
            resRespPri = false;
            txtRespPri = "N";
        }
        if (elemento.getResFirstResp().equals("Y")) 
        {
                resFirstResp = true;
                txtFirstResp = "Y";
        } else 
        {
               resFirstResp = false;
               txtFirstResp = "N";
        }
        
        } 
        catch (Exception e) 
        {
        }
        
        
        //elemento.getResFirstResp()
        /*
        resRespPri = false;
        txtRespPri = "N";
        
        resFirstResp = false;
        txtFirstResp = "N";
        
        */
        
        
        //Enviar valoree.
        
    }
    
    
    @Override
    void actualizar() {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void agregar() {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void enviarEA(BigDecimal idpf, BigInteger esr){
        extendtime();
        setExisteLista(false);
        EngRequest esrEA = new EngRequest(); 
        listResponsesNameVw = new ArrayList<>();        
        esrEA = requestFacade.find(esr);
        elemento.setReqMessageid(esr);
        setearTo(esrEA.getChkCheckid());
        listResponsesNameVw = responsesNameVwFacade.findTrackingsByEsr(elemento.getReqMessageid());
        recortarTxto(listResponsesNameVw);
        extendtime();
        aaPdfBean.setEsrid(esr.toString());   
        aaPdfBean.setElements2(engEaPdfFacade.find(idpf)); ;
        adjuntosBean.listado= new ArrayList<>(); 
        MsjAdjuntos msjAd = new MsjAdjuntos();
        msjAd.setMsgExtension(aaPdfBean.getElements2().getPdfFilename().substring(aaPdfBean.getElements2().getPdfFilename().indexOf('.'),aaPdfBean.getElements2().getPdfFilename().length()));
        msjAd.setMsgNombreArchivo(aaPdfBean.getElements2().getPdfFilename().substring(0,aaPdfBean.getElements2().getPdfFilename().lastIndexOf('.')));
        msjAd.setNombreAcotado(aaPdfBean.getElements2().getPdfFilename());
        if (msjAd.getNombreAcotado().length()>22) {
            msjAd.setNombreAcotado(msjAd.getMsgNombreArchivo().substring(0,19)+"...");
        }
        msjAd.setMsgAdjunto(aaPdfBean.getElements2().getPdfFile());
         msjAd.setExtension("error");
        switch (msjAd.getMsgExtension().toUpperCase()) {
                      case ".PDF":
                          msjAd.setExtension("pdf");
                          break;
                      case ".PNG":
                          msjAd.setExtension("png");
                          break;
                      case ".JPG":
                      case ".JPEG":
                          msjAd.setExtension("jpg");
                          break;
                      case ".GIF":
                          msjAd.setExtension("gif");
                          break;
                      case ".DOC":
                      case ".DOCX":
                          msjAd.setExtension("doc");
                          break;
                      case ".XLS":
                      case ".XLSX":
                          msjAd.setExtension("xls");
                          break;
                      default:
                      case ".TXT":
                          msjAd.setExtension("txt");
                          break;
                  }
        
        adjuntosBean.setEsEA(true);        
        adjuntosBean.listado.add(msjAd);    
        pdfId = idpf.intValue();
        eliminar(elemento);
        if (adjuntosBean.listado.size() >0){
            setExisteLista(true);
        }
    }
    
    public void handleFileUpload(FileUploadEvent event) {
        extendtime();
        setExisteLista(false);
        MsjAdjuntos lisMsj2 = new MsjAdjuntos();
        adjuntosBean.listado2 = new ArrayList<>();
        adjuntosBean.listado = new ArrayList<>();
        try{
          uploadedFiles.add(event.getFile());
          disable=false;
          if(uploadedFiles.isEmpty()){
            FacesMessage message = new FacesMessage("Choose Documents");
            FacesContext.getCurrentInstance().addMessage(null, message);  
          }else{
              
              for (UploadedFile lisUpload : uploadedFiles) {
                  lisMsj2.setNombreAcotado(lisUpload.getFileName());
                  lisMsj2.setMsgNombreArchivo(lisUpload.getFileName().substring(0,lisUpload.getFileName().lastIndexOf(".")));
                  lisMsj2.setMsgExtension(lisUpload.getFileName().substring(lisUpload.getFileName().lastIndexOf("."), lisUpload.getFileName().length()));
                  lisMsj2.setMsgAdjunto(lisUpload.getContents());
                  lisMsj2.setExtension("error");
                  if (lisMsj2.getNombreAcotado().length()>22) {
                      lisMsj2.setNombreAcotado(lisMsj2.getNombreAcotado().substring(0,19)+"...");
                  }
                  switch (lisMsj2.getMsgExtension().toUpperCase()) {
                      case ".PDF":
                          lisMsj2.setExtension("pdf");
                          break;
                      case ".PNG":
                          lisMsj2.setExtension("png");
                          break;
                      case ".JPG":
                      case ".JPEG":
                          lisMsj2.setExtension("jpg");
                          break;
                      case ".GIF":
                          lisMsj2.setExtension("gif");
                          break;
                      case ".DOC":
                      case ".DOCX":
                          lisMsj2.setExtension("doc");
                          break;
                      case ".XLS":
                      case ".XLSX":
                          lisMsj2.setExtension("xls");
                          break;
                      default:
                      case ".TXT":
                          lisMsj2.setExtension("txt");
                          break;
                  }
                  adjuntosBean.listado2.add(lisMsj2);
                  if (adjuntosBean.listado2.size() >0){
                    setExisteLista(true);
                  }
                    lisMsj2 = new MsjAdjuntos();     
              }
          }
          
        }catch(Exception e){
            Logger.getLogger(RequestTrackingBean.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
    
    public void resetDisable(){
        try 
        {
            lstSeguimiento = new ArrayList<>();
            lstSeguimiento = engSegFacade.lsSeguimiento(elemento.getReqMessageid(), BigDecimal.ZERO);
            elemento.setResSubject(null);
            elemento.setResBody(null);
            elemento.setResEmailsCc(null);
            elemento.setResEmailsTo(null);
            elemento.setResId(null);
            EngRequest esr = new EngRequest(); 
            esr = requestFacade.find(elemento.getReqMessageid());
            setearTo(esr.getChkCheckid());
            adjuntosBean.listado = new ArrayList<>();
            adjuntosBean.listado2 = new ArrayList<>();
            adjuntosBean.setEsEA(false);
            disable=true;
            uploadedFiles = new ArrayList<>();
            existeLista=false;
            ocultaBtn="visibility:hidden";
            
            resRespPri = false;
            resFirstResp = false;
            txtFirstResp = "N";
            txtRespPri = "N";
            
            elemento.setResCodMsj("");
            BigInteger IdMg = BigInteger.valueOf(0);
            elemento.setResCorrEsr(IdMg);
            
        } 
        catch (Exception e) 
        {
            Logger.getLogger(RequestTrackingBean.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
    
    //Realizar Update a campos agregagos sin realizar un nuevo Insert a Tabla: ENG_REQ_RESPONSES
    public void updateMj() {
        String vl,val,vMstr = "";
        try {
            
        EngRequest esr = new EngRequest();
        esr = requestFacade.find(elemento.getReqMessageid());

        HttpSession sessions = SessionBean.getSession();
        int vMessId = (int) sessions.getAttribute("vMessagId");
       
        BigInteger idMg = BigInteger.valueOf(vMessId);
        int vMx =  engReqResponsesFacade.valMayor(idMg);

        vMstr = String.valueOf(vMx);
        
        if ((resFirstResp==true) && (resFirstResp != null))
        {
            vl="Y";
        }
        else
        {
            vl="N";
        }
        
        if((resRespPri==true) && (resRespPri != null))
        {
            val="Y";
        }
        else
        {
            val="N";
        }
        
        engReqResponsesFacade.updateReq("4",vMessId,vMstr,val,"5",vl);
           
        } catch (Exception e) {
             Logger.getLogger(RequestTrackingBean.class.getName()).log(Level.SEVERE, null, e);
        }
  
    }
    
    public void deleteBlod() {        
        extendtime();
        int ids = Integer.parseInt(adjuntosBean.getIdDocument());
        BigDecimal idd = new BigDecimal(ids);
        adjuntosBean.listado2.remove(ids);
        uploadedFiles.remove(ids);
        if (adjuntosBean.listado2.isEmpty()) {
            existeLista=false;            
        }
    }
    
   @SuppressWarnings("empty-statement")
    public void updateMsj()
    {    
        extendtime();
        try 
        {
            if (txtFirstResp.equals("Y")) {
                 elemento.setResFirstResp("Y");
            } else {
                elemento.setResFirstResp("N");
            }
            if (txtRespPri.equals("Y")) {
                elemento.setResRespPri("Y");
            } else {
                elemento.setResRespPri("N");
            }
            
            engReqResponsesFacade.edit(elemento);
            resetDisable();
            elemento.setResCodMsj("");
            
            
            BigInteger idMg = BigInteger.valueOf(0);
            elemento.setResCorrEsr(idMg);
            lstSeguimiento = new ArrayList<>();

        } catch (Exception e) {
            Logger.getLogger(RequestTrackingBean.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
            
    @SuppressWarnings("empty-statement")
    public void sendMail() {
        extendtime();
        EngReqResponses engReqResP = new EngReqResponses();
        ArrayList<String> filex = new ArrayList<>();
        ArrayList<String> namex = new ArrayList<>();
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        existExtensionFile = false;
        Sequences sec = new Sequences();
        id = sec.email();
        BigDecimal idd = new BigDecimal(id);
        elemento.setResId(idd);
        BigInteger idm = new BigInteger(String.valueOf(id));
        boolean nohayarchivo = true;
        HttpSession session = SessionBean.getSession();
        String iduser = session.getAttribute("username").toString();
        elemento.setResCodUsrMsg(iduser);
        Calendar fecha = new GregorianCalendar();
        elemento.setResDateMsg(fecha.getTime());
        elemento.setResEmailsTo(elemento.getResEmailsToMos().replace(", ",","));
        elemento.setResEmailsTo(elemento.getResEmailsToMos().replace(" ",""));
        elemento.setResEmailsToMos(elemento.getResEmailsTo().replace(",",", "));
        elemento.setResCheck("NO");
        elemento.setResRolUser(getRolUser());
        //Validar Mensaje:
        String msjEc  = validarRol(engValidarRol.validarRol(iduser));
        
        int vMx =  engReqResponsesFacade.valMayor(elemento.getReqMessageid());
        BigInteger idMxEsr = new BigInteger(String.valueOf(vMx));
        elemento.setResCodMsj(msjEc);
        elemento.setResCorrEsr(idMxEsr);
        
        String[] parts = elemento.getResEmailsTo().split(",");
        /*confirmar corre*/
        for (String part : parts) {
           errorMail= validarStringMail(part);
            if (!errorMail) {
                break;
            }
        }
        if (errorMail){
            if (txtFirstResp.equals("Y")) {
                 elemento.setResFirstResp("Y");
            } else {
                elemento.setResFirstResp("N");
            }
            if (txtRespPri.equals("Y")) {
                elemento.setResRespPri("Y");
            } else {
                elemento.setResRespPri("N");
            }
            engReqResponsesFacade.create(elemento);
            lstSeguimiento = new ArrayList<>();
           if (!adjuntosBean.isEsEA()){
           try {
                for (UploadedFile uploadedFile : uploadedFiles) {
                    // Process them all here.
                    String fileName =uploadedFile.getFileName();
                    if (uploadedFile.getFileName() != null) {
                        if (verifyValue(fileName)) {
                            String nameF = fileName.substring(0, fileName.lastIndexOf('.'));
                            String mime = fileName.substring(fileName.lastIndexOf('.'), fileName.length());
                            String[] formatos = new String[]{".PDF", ".PNG", ".JPG",".JPEG",".GIF", ".DOC", ".DOCX", ".TXT",".PNG",".XLS",".pdf", ".png", ".jpg",".jpeg",".gif", ".doc", ".docx", ".txt",".PNG",".xls"};
                            for (int i = 0; i < formatos.length; i++) {
                                if (formatos[i].equals(mime)) {
                                    existExtensionFile = true;
                                    adjuntosBean.elemento = new MsjAdjuntos();
                                    namex.add(nameF + "" + mime + "");
                                    //insetar archivos a la base
                                    adjuntosBean.elemento.setMsgCodEsr(elemento.getReqMessageid());
                                    adjuntosBean.elemento.setMsgCodResponse(elemento);
                                    adjuntosBean.elemento.setMsgExtension(mime);
                                    adjuntosBean.elemento.setMsgNombreArchivo(nameF);
                                    adjuntosBean.elemento.setMsgAdjunto(uploadedFile.getContents());
                                    adjuntosBean.elemento.setMsgCodigo(null);

                                    if (adjuntosBean.elemento.getMsgAdjunto() != null) {
                                        adjuntosBean.agregar();
                                        elemento.setResAttachFile("Y");
                                    }
                                    break;
                                }
                            }
                        }else{
                            nohayarchivo = false;
                        }
                      }else{
                         FacesMessage message = new FacesMessage("Choose Documents");
                         FacesContext.getCurrentInstance().addMessage(null, message);
                      }
                }
                //limpiando la lista 
               

            } catch (Exception e) {
                Logger.getLogger(RequestTrackingBean.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        else{
           copiarArchivo(getPdfId());                   
        }
               try{
                    engReqResponsesFacade.executeEnvioCorreoTracking(elemento, iduser);
                    uploadedFiles = new ArrayList<>();
                    adjuntosBean.listado = new ArrayList<>();
                    adjuntosBean.listado2 = new ArrayList<>();
                    String listaTo = elemento.getResEmailsTo();
                    String listaCc = elemento.getResEmailsCc();
                    BigInteger messageIdActual = elemento.getReqMessageid();

                    elemento = new EngReqResponses();
                    elemento.setResEmailsTo(listaTo);
                    elemento.setResEmailsCc(listaCc);
                    elemento.setReqMessageid(messageIdActual);
                    resetDisable();
                    listResponsesNameVw = responsesNameVwFacade.findTrackingsByEsr(elemento.getReqMessageid());
                    recortarTxto(listResponsesNameVw);
                }catch (Exception e) {
                    Logger.getLogger(RequestTrackingBean.class.getName()).log(Level.SEVERE, null, e);
                    FacesContext.getCurrentInstance().getResponseComplete();
                    errorFile = 1;
            }
        } else{
            elemento.setResId(null);
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Mail Invalid"));
        } 
    } 
    public boolean validarStringMail(String email) {
        boolean valMail=false;
 
        // Patrón para validar el email
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(email);
 
        if (mather.find() == true) {
            valMail=true;
        } else {
            valMail=false;
        }
        return valMail;
        
    }
  
    public void copiarArchivo(int idPDF){
        extendtime();
        try{
            EngEaPdf documento = engEaPdfFacade.find(new BigDecimal(pdfId));            
            adjuntosBean.elemento.setMsgCodEsr(elemento.getReqMessageid());
            adjuntosBean.elemento.setMsgCodResponse(elemento);
            String archi = documento.getPdfFilename();
            String nomb=archi.substring(0, archi.lastIndexOf('.'));
            String ext=archi.substring(archi.lastIndexOf('.'), archi.length());
            adjuntosBean.elemento.setMsgExtension(ext);
            adjuntosBean.elemento.setMsgNombreArchivo(nomb);
            adjuntosBean.elemento.setMsgAdjunto(documento.getPdfFile());
            adjuntosBean.elemento.setMsgCodigo(null);
            if (adjuntosBean.elemento.getMsgAdjunto() != null) {
                adjuntosBean.agregar();
            }
            documento.setPdfEstatusEnviado("ENVIADO");
            engEaPdfFacade.edit(documento);
            if (documento.getPdfType() == (short) 1){
                eaBean.finalizarEA(documento.getEagId());
            }
        } catch (Exception e) {
            Logger.getLogger(RequestTrackingBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    @SuppressWarnings("empty-statement")
    public void subirarchivo(){
        extendtime();
        ArrayList<String> filex = new ArrayList<>();
        ArrayList<String> namex = new ArrayList<>();
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        existExtensionFile = false;
        boolean nohayarchivo = true;
        HttpSession session = SessionBean.getSession();
                String iduser = session.getAttribute("username").toString();           
        try {
            byte[] contenido;
            Collection<Part> parts = request.getParts();
            for (Part cur : parts) {
                if (cur.getSubmittedFileName() != null) {                    
                    InputStream input = cur.getInputStream();
                    Part uploadedFile = cur;
                    FilenameUtils.getName(getSubmittedFileName(uploadedFile));
                    String fileName = FilenameUtils.getName(getSubmittedFileName(cur));
                    if (verifyValue(fileName)) {                        
                        String nameF = fileName.substring(0, fileName.lastIndexOf('.'));
                        String mime = fileName.substring(fileName.lastIndexOf('.'), fileName.length());
                        String[] formatos = new String[]{".PDF", ".PNG", ".JPG",".JPEG",".GIF", ".DOC", ".DOCX", ".TXT",".PNG",".XLS",".pdf", ".png", ".jpg",".jpeg",".gif", ".doc", ".docx", ".txt",".PNG",".xls"};
                        for (int i = 0; i < formatos.length; i++) {
                            if (formatos[i].equals(mime)) {
                                existExtensionFile = true;
                                contenido = IOUtils.toByteArray(input);
                                namex.add(nameF + "" + mime + "");
                                //insetar archivos a la base
                                adjuntosBean.elemento.setMsgCodEsr(elemento.getReqMessageid());
                                adjuntosBean.elemento.setMsgCodResponse(elemento);
                                adjuntosBean.elemento.setMsgExtension(mime);
                                adjuntosBean.elemento.setMsgNombreArchivo(nameF);
                                adjuntosBean.elemento.setMsgAdjunto(contenido);
                                adjuntosBean.elemento.setMsgCodigo(null);
                                if (adjuntosBean.elemento.getMsgAdjunto() != null) {
                                    adjuntosBean.agregar();
                                    elemento.setResAttachFile("Y");
                                }
                                break;
                            }
                        }
                    }else{
                        nohayarchivo = false;
                    }
                }
            }

        } catch (Exception e) {
            Logger.getLogger(RequestTrackingBean.class.getName()).log(Level.SEVERE, null, e);
        }

    }   
    
    public void findEA(){
        extendtime();
         try{
            EngReqResponses idRR = new EngReqResponses();
            idRR.setResId(new BigDecimal(getIdReqResponse()));
            listado=engReqResponsesFacade.findAdj(idRR.getResId());            
            
            for (EngReqResponses e : listado) {
                String[] img = new String[4];
                img[0] = e.getResEmailsTo();
                img[1] = e.getResSubject();
                img[2] = e.getResBody();
                elemento.setResEmailsTo(img[0]);
                elemento.setResSubject(img[1]);
                elemento.setResBody(img[2]);
            }
            
         }catch (Exception e) {
            Logger.getLogger(RequestTrackingBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public Boolean verifyValue(Object val) {
        extendtime();
        Boolean verifyNotNull = true;
        Integer esp = 0;
        String evaluar;
        if (val == null) {
            verifyNotNull = false;
            return verifyNotNull;
        }
        evaluar = val.toString();
        if (evaluar.isEmpty()) {
            verifyNotNull = false;
            return verifyNotNull;
        }
        for (int i = 0; i < evaluar.length(); i++) {
            if (evaluar.charAt(i) == ' ') {
                esp++;
            }
        }
        if (evaluar.length() == esp) {
            verifyNotNull = false;
            return verifyNotNull;
        }
        return verifyNotNull;
    }

    public void recuperarBlob() {
        extendtime();
        BigDecimal idd = new BigDecimal(getIdReqResponse());
        MsjAdjuntos elemAdj= new MsjAdjuntos();
        elemAdj = msjAdjuntosFacade.find(idd);
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=" + elemAdj.getMsgNombreArchivo().replace(",", "_") + elemAdj.getMsgExtension());
        int bit = 512;
        try (InputStream in = new ByteArrayInputStream(elemAdj.getMsgAdjunto())) {

            ServletOutputStream outs = response.getOutputStream();
            while ((bit) >= 0) {
                bit = in.read();
                outs.write(bit);
            }
            outs.flush();
            outs.close();
            in.close();
            response.getOutputStream().close();
            FacesContext.getCurrentInstance().getResponseComplete();
            } catch (IOException e) {
                Logger.getLogger(RequestTrackingBean.class.getName()).log(Level.SEVERE, null, e);
            } finally {
                FacesContext.getCurrentInstance().getResponseComplete();
            }
        
    }

    public void setearTo(Short checkId) {
        extendtime();
        //Validar ESR:
        try 
        {
            if ((sessions.getAttribute("Re_numESR") != null) || ((sessions.getAttribute("Re_reCorr") != null) 
                    ||(sessions.getAttribute("Re_reCorr").toString().trim().isEmpty())) || ((sessions.getAttribute("Re_reqYear") != null) 
                    ||(sessions.getAttribute("Re_reqYear").toString().trim().isEmpty())))
            {
                numESR = (int) sessions.getAttribute("Re_numESR");
                reCorr = (String) sessions.getAttribute("Re_reCorr");
                reqYear = (String) sessions.getAttribute("Re_reqYear");
            }
        } catch (Exception e) 
        {
             Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
        }
            
        adjuntosBean.setListimage(new ArrayList());
        List<ContCheckEmails> listEmails = contCheckEmailsFacade.findbywo(checkId);
        String stringEmails = "";
        StringBuilder sb = new StringBuilder();
        for (ContCheckEmails checkEmailsE : listEmails) {
            sb.append(stringEmails);
            sb.append(checkEmailsE.getCemEmail());
            sb.append(", ");
        }
        stringEmails = sb.toString();
        
        BigInteger v1;
        v1 = elemento.getReqMessageid();
        int messageId =  v1.intValue();
        HttpSession sessions = SessionBean.getSession();
        sessions.setAttribute("vMessagId", messageId);

        elemento.setResEmailsToMos(stringEmails);
        elemento.setResSubject(requestFacade.findTitleByReq(elemento.getReqMessageid()));
        listResponsesNameVw = responsesNameVwFacade.findTrackingsByEsr(elemento.getReqMessageid());
        recortarTxto(listResponsesNameVw);
    }
    
    public void recortarTxto(List<ResponsesNameVw>  lisResponsesNameVw){
        List<ResponsesNameVw> listaRedu = new ArrayList<>();        
        for (ResponsesNameVw responsesNameVwLis : lisResponsesNameVw) {
            if (responsesNameVwLis.getResBody().length()>=50){
                responsesNameVwLis.setResBody(responsesNameVwLis.getResBody().substring(0, 47)+"...");
            }
            if (responsesNameVwLis.getResEmailsTo().length()>=50){
                responsesNameVwLis.setResEmailsTo(responsesNameVwLis.getResEmailsTo().substring(0, 47)+"...");
            }
            if (responsesNameVwLis.getResSubject().length()>=50){
                responsesNameVwLis.setResSubject(responsesNameVwLis.getResSubject().substring(0, 47)+"...");
            }
            listaRedu.add(responsesNameVwLis);
            
        }
        listResponsesNameVw=listaRedu;
        listaRedu = new ArrayList<>();
    }

    @Override
    void eliminar(EngReqResponses elemento) {
        elemento.setResBody("");
        elemento.setResSubject("");
        
    }

    @Override
    EngReqResponses nuevoElemento() {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String[] getCount() {
        return count;
    }

    public void setCount(String[] count) {
        this.count = count;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public List<String> getNameemails() {
        return nameemails;
    }

    public void setNameemails(List<String> nameemails) {
        this.nameemails = nameemails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AdjuntosBean getAdjuntosBean() {
        return adjuntosBean;
    }

    public void setAdjuntosBean(AdjuntosBean adjuntosBean) {
        this.adjuntosBean = adjuntosBean;
    }

    public byte[] getDocEa() {
        return docEa;
    }

    public void setDocEa(byte[] docEa) {
        this.docEa = docEa;
    }

    public int getPdfId() {
        return pdfId;
    }

    public void setPdfId(int pdfId) {
        this.pdfId = pdfId;
    }

    public EaPdfBean getAaPdfBean() {
        return aaPdfBean;
    }

    public void setAaPdfBean(EaPdfBean aaPdfBean) {
        this.aaPdfBean = aaPdfBean;
    }

    public EngEaPdf getElements() {
        return elements;
    }

    public void setElements(EngEaPdf elements) {
        this.elements = elements;
    }

    public MsjAdjuntos getElements2() {
        return elements2;
    }

    public void setElements2(MsjAdjuntos elements2) {
        this.elements2 = elements2;
    }

    public boolean isExistExtensionFile() {
        return existExtensionFile;
    }

    public void setExistExtensionFile(boolean existExtensionFile) {
        this.existExtensionFile = existExtensionFile;
    }

    public int getErrorFile() {
        return errorFile;
    }

    public void setErrorFile(int errorFile) {
        this.errorFile = errorFile;
    }

    public EngAutorizationBean getEaBean() {
        return eaBean;
    }

    public void setEaBean(EngAutorizationBean eaBean) {
        this.eaBean = eaBean;
    }

    public EngReqResponses getElementoAdj() {
        return elementoAdj;
    }

    public void setElementoAdj(EngReqResponses elementoAdj) {
        this.elementoAdj = elementoAdj;
    }

    public String getIdReqResponse() {
        return idReqResponse;
    }

    public void setIdReqResponse(String idReqResponse) {
        this.idReqResponse = idReqResponse;
    }

    public UploadedFile getFilex() {
        return filex;
    }

    public void setFilex(UploadedFile filex) {
        this.filex = filex;
    }

    public List<UploadedFile> getUploadedFiles() {
        return uploadedFiles;
    }

    public void setUploadedFiles(List<UploadedFile> uploadedFiles) {
        this.uploadedFiles = uploadedFiles;
    }

    public boolean isDisable() {
        return disable;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
    }

    public List<ResponsesNameVw> getListResponsesNameVw() {
        return listResponsesNameVw;
    }

    public void setListResponsesNameVw(List<ResponsesNameVw> listResponsesNameVw) {
        this.listResponsesNameVw = listResponsesNameVw;
    }

    
    

    public String getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(String idDocument) {
        this.idDocument = idDocument;
    }

    public boolean isExisteLista() {
        return existeLista;
    }

    public void setExisteLista(boolean existeLista) {
        this.existeLista = existeLista;
    }

    public String getEsESR() {
        return esESR;
    }

    public void setEsESR(String esESR) {
        this.esESR = esESR;
    }

    public boolean getErrorMail() {
        return errorMail;
    }

    public void setErrorMail(boolean errorMail) {
        this.errorMail = errorMail;
    }

    public String getEmailAssigned() {
        return emailAssigned;
    }

    public void setEmailAssigned(String emailAssigned) {
        this.emailAssigned = emailAssigned;
    } 

    public String getRolUser() {
        return rolUser;
    }

    public void setRolUser(String rolUser) {
        this.rolUser = rolUser;
    }
    
    public String getSelectOption() {
        return selectOption;
    }

    public void setSelectOption(String selectOption) {
        this.selectOption = selectOption;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getUsertem() {
        return usertem;
    }

    public void setUsertem(String usertem) {
        this.usertem = usertem;
    }

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
    }

    public HttpSession getSessions() {
        return sessions;
    }

    public void setSessions(HttpSession sessions) {
        this.sessions = sessions;
    }
    
        public int getNumESR() {
        return numESR;
    }

    public void setNumESR(int numESR) {
        this.numESR = numESR;
    }

    public String getReCorr() {
        return reCorr;
    }

    public void setReCorr(String reCorr) {
        this.reCorr = reCorr;
    }

    public String getReqYear() {
        return reqYear;
    }

    public void setReqYear(String reqYear) {
        this.reqYear = reqYear;
    }

    public String getPointer() {
        return pointer;
    }

    public void setPointer(String pointer) {
        this.pointer = pointer;
    }
    
    public Boolean getResRespPri() {
        return resRespPri;
    }
    public void setResRespPri(Boolean resRespPri) {
        this.resRespPri = resRespPri;
    }

    
    public Boolean getResFirstResp() {
        return resFirstResp;
    }
    public void setResFirstResp(Boolean resFirstResp) {
        this.resFirstResp = resFirstResp;
    }
    

    public int getMaxValor() {
        return maxValor;
    }

    public void setMaxValor(int maxValor) {
        this.maxValor = maxValor;
    }
    
    public boolean isCheckBoxValue() {
		return checkBoxValue;
	}

	public void setCheckBoxValue(boolean checkBoxValue) {
		this.checkBoxValue = checkBoxValue;
	}
        
        
        

    public List<engSeguimiento> getLstSeguimiento() {
        return lstSeguimiento;
    }

    public void setLstSeguimiento(List<engSeguimiento> lstSeguimiento) {
        this.lstSeguimiento = lstSeguimiento;
    }

    public String getTxtFirstResp() {
        return txtFirstResp;
    }

    public void setTxtFirstResp(String txtFirstResp) {
        this.txtFirstResp = txtFirstResp;
    }

    public String getTxtRespPri() {
        return txtRespPri;
    }

    public void setTxtRespPri(String txtRespPri) {
        this.txtRespPri = txtRespPri;
    }
    
    public String getOcultaBtn() {
        return ocultaBtn;
    }

    public void setOcultaBtn(String ocultaBtn) {
        this.ocultaBtn = ocultaBtn;
    }
    
    public String getTipoSocilictudTracking() {
        return tipoSocilictudTracking;
    }

    public void setTipoSocilictudTracking(String tipoSocilictudTracking) {
        this.tipoSocilictudTracking = tipoSocilictudTracking;
    }
    //Clase adjuntar base64:
    public StreamedContent runReport(String yearTk, String correlativeTk) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        /*
        try {
            setFileNotFound(false);
            //com.oracle.xmlns.oxp.service.v2.ReportRequest reportRequest = parametrosReporte(yearTk, correlativeTk);
            //com.oracle.xmlns.oxp.service.v2.ReportService port = service.getReportService();
           // pdfResponse = port.runReport(reportRequest, USER_WS, PASS_REPORT_WS);

           
            if (pdfResponse == null) {
                pdfRender = fileNotFound();
                setFileNotFound(true);
            } else {
                pdfRender = new DefaultStreamedContent(new ByteArrayInputStream(pdfResponse.getReportBytes()), pdfResponse.getReportContentType());
                byte[] byteStreamed = toByteArray(new ByteArrayInputStream(pdfResponse.getReportBytes()));
                base64Pdf = DatatypeConverter.printBase64Binary(byteStreamed);
            }
            return pdfRender;
        } catch (Exception ex) {
            Logger.getLogger(WsBIReport.class.getName()).log(Level.SEVERE, null, ex);
            pdfRender = fileNotFound();
            setFileNotFound(true);
            return pdfRender;
          
        }*/
        return null;
    }

    //Parametros reporte:
    /*
         public ReportRequest parametrosReporte(String yearTk, String corrTk) {

        ParamNameValues paramReport = new ParamNameValues();
        ReportRequest reportParam = new ReportRequest();
        ArrayOfParamNameValue arrayParam = new ArrayOfParamNameValue();

        String parametro1 = "id"; //correlativo
        String parametro2 = "year"; //year
        ParamNameValue yearParam = new ParamNameValue();
        ParamNameValue tkYearParam = new ParamNameValue();

        ArrayOfString corrVal = new ArrayOfString();
        ArrayOfString tkYearVal = new ArrayOfString();
        try {

            //Obtner la ruta de Global Parameters: parameter_value. Filtros parameter_key='QA-002/21-AEM-F', parameter_app='8300'
            String valor;
            parameterList = SwParameterMaintenixFacade.findParameterMaint("QA-002/21-AEM-F");
            if (!parameterList.isEmpty()) {
                valor = parameterList.get(0).getParamValue();
            } else {
                valor = "";
            }

            reportParam.setReportAbsolutePath(valor);// Asignar aqui el valor recuperado.

            corrVal.getItem().add(corrTk); // YEAR TASKCARD
            yearParam.setName(parametro1); //year
            yearParam.setValues(corrVal);
            arrayParam.getItem().add(yearParam);

            tkYearVal.getItem().add(yearTk);
            tkYearParam.setName(parametro2); // tkYear
            tkYearParam.setValues(tkYearVal);
            arrayParam.getItem().add(tkYearParam);

            paramReport.setListOfParamNameValues(arrayParam);
            reportParam.setParameterNameValues(paramReport);
            reportParam.setSizeOfDataChunkDownload(-1);// Parametro necesario

        } catch (Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return reportParam;
    }*/
    
}
