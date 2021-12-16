 // To change this license header, choose License Headers in Project Properties.
 // To change this template file, choose Tools | Templates
 // and open the template in the editor.
package com.aecas.managed;// paquete manage

import com.aees.session.SessionBean;// importacion de clase
import com.aeroman.aees.entities.EngListView;// importacion de clase
import com.aeroman.aees.entities.EngRequest;// importacion de clase
import com.aeroman.aees.entities.EngTasksByCustomerCiaVw;// importacion de clase
import com.aeroman.aees.entities.SearchEsr;
import com.aeroman.aees.entities.grant.ContAtas;// importacion de clase
import com.aeroman.aees.entities.grant.ContCheck;// importacion de clase
import com.aeroman.aees.entities.grant.SgrCia;
import com.aeroman.aees.facades.CoreAircraftTypeFacade;// importacion de clase
import com.aeroman.aees.facades.EngListViewFacade;// importacion de clase
import com.aeroman.aees.facades.EngRequestFacade;// importacion de clase
import com.aeroman.aees.facades.EngTasksByCustomerCiaVwFacade;// importacion de clase
import com.aeroman.aees.facades.SearchEsrFacade;
import com.aeroman.aees.facades.grant.ContAtasFacade;// importacion de clase
import com.aeroman.aees.facades.grant.ContCheckFacade;// importacion de clase
import com.aeroman.aees.facades.grant.SgrCiaFacade;
import com.aeroman.aees.facades.grant.SgrUserFacades;
import java.io.Serializable;// libreria Serializable
import java.math.BigDecimal;// libreria BigDecimal
import java.math.BigInteger;// libreria BigInteger
import java.text.ParseException;// libreria ParseException
import java.text.SimpleDateFormat;// libreria SimpleDateFormat
import java.util.ArrayList;// libreria ArrayList
import java.util.Date;// libreria Date
import java.util.HashMap;// libreria HashMap
import java.util.List;// libreria List
import java.util.Map;// libreria Map
import java.util.logging.Level;// libreria Level
import java.util.logging.Logger;// libreria Logger
import javax.annotation.PostConstruct;// libreria PostConstruct
import javax.ejb.EJB;// libreria EJB
import javax.faces.bean.ManagedBean;// libreria ManagedBean
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;// libreria ViewScoped
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;// libreria FacesContext
import javax.persistence.NoResultException;// libreria NoResultException
import javax.servlet.http.HttpSession;// libreria HttpSession

/**
 *
 * @author hjuarez
 */
@ManagedBean(name = "motorBusquedaEsrBean")//nombre de clase en mageBean
@SessionScoped//tipo de clase
//clase EsrBean con extends al crud
public class MotorBusquedaEsrBean extends CrudBean<EngRequest> implements Serializable {

    
    private EngRequest engRequest;//declaracion de clases Facade
    @EJB
    private EngTasksByCustomerCiaVwFacade customerciaFacade;//declaracion de clases Facade
    
    @EJB
    private SearchEsrFacade searchEsrFacade;//declaracion de clases Facade

    private String coAvion;//declaracion de variable
    private String owSelected;//declaracion de variable
    private String esrSelected;//declaracion de variable
    private String eaSelected;//declaracion de variable
    private String avionModel;//declaracion de variable
    private String ingenieroBusq;//declaracion de variable
    private String ataBusq;//declaracion de variable
    private Integer ataSelected;//declaracion de variable
    private Integer id;//declaracion de variable
    private String avion;//declaracion de variable
    private String woESR;//declaracion de variable
    private boolean duplicado;//declaracion de variable
    private int    validarDate;//declaracion de variable

    private List<ContCheck> oworks = new ArrayList<>();//declaracion de variable
    private List<String> aviones = new ArrayList<>();//declaracion de variable
    private List<ContCheck> workOders = new ArrayList<>();//declaracion de variable
    private List<ContCheck> listFiltro = new ArrayList<>();//declaracion de variable
    private List<Integer> atasG = new ArrayList<>();//declaracion de variable
    private List<EngRequest> esrs = new ArrayList<>();//declaracion de variable
    private List<String> colaAviones = new ArrayList<>();//declaracion de variable
    private List<SearchEsr> esrResultados = new ArrayList<>();//declaracion de variable
    private List<EngListView> ingenieros = new ArrayList<>();//declaracion de variable
    private List<ContAtas> todasAtas = new ArrayList<>();//declaracion de variable
    private boolean camposvacios;//declaracion de variable
    private boolean nodatafound;//declaracion de variable
    private String colAvionSearch;//declaracion de variable
    private String numESRSearch;//declaracion de variable
    private String ataSearch;//declaracion de variable
    private String modelAirpSearch;//declaracion de variable
    private String workOrderSearch;//declaracion de variable
    private String customerSearch;//declaracion de variable
    private String solicitedSearch;//declaracion de variable
    private String partNumberSearch;//declaracion de variable
    private String reqSearchAffectedPartSearch;//declaracion de variable
    private Boolean esStringESR;//declaracion de variable
    private Boolean esWorkOrder;//declaracion de variable

    @EJB
    private ContCheckFacade cont;//declaracion de clases Facade
    @EJB
    private EngRequestFacade engRequestFacade;//declaracion de clases Facade
    @EJB
    private SgrUserFacades sgrUser;//declaracion de clases Facade
    @EJB
    private SgrUserFacades sgrUserFacades;//declaracion de clases Facade
    @EJB
    private SgrCiaFacade companyFacade;//declaracion de clases Facade
    @EJB
    private EngListViewFacade usersFacade;//declaracion de clases Facade

    @EJB
    private ContAtasFacade contAtasFacade;//declaracion de clases Facade

    private List<String> convertida = new ArrayList<>();//declaracion de variable
    private List<String> easStr = new ArrayList<>();//declaracion de variable
    private List<String> owStr = new ArrayList<>();//declaracion de variable
    private List<String> esrStr = new ArrayList<>();//declaracion de variable
    private List<String> titulos = new ArrayList<>();//declaracion de variable
    private List<String> atasStr = new ArrayList<>();//declaracion de variable
    private List<String> avionModels = new ArrayList<>();//declaracion de variable
    private List<String> listaClientes = new ArrayList<>();//declaracion de variable
    private Map<String, BigInteger> mapEsr = new HashMap<>();//declaracion de variable
    private List<String> clientesAutoc;//declaracion de variable

    private String pn;//declaracion de variable
    private String sn;//declaracion de variable
    private String titulo;//declaracion de variable
    private Integer añoSelect;//declaracion de variable
    private Boolean buscado = false;//declaracion de variable
    private String workorderBusqueda;//campo para buscar la WO en el motor de busqueda
    private String clienteBusq;//campo para buscar cliente
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yy");//declaracion de variable
    String esrSelTabla;//declaracion de variable
    private String status;//declaracion de variable
    private String workOrder;//declaracion de variable
    private String workOrderTr;//declaracion de variable
    private Date fstrart;//declaracion de variable
    private Date ffinal;//declaracion de variable
    private String codeuser;//declaracion de variable
    private String nrESR;//declaracion de variable
    private String users;//declaracion de variable
    private String companyUser;//declarion de variable
    private SgrCia sgrCia;//declaracion de variable

    

    @Override//metodo generado por implements Serializable
    @PostConstruct//metodo constructor
    public void init() {
        esStringESR=true;
        esWorkOrder=true;
        HttpSession session = SessionBean.getSession();
        users =(String) session.getAttribute("username");
        companyUser = sgrUserFacades.findSelectUser(users).getCiaDefault();
    } 
    public List<String> searchPlaneTail(String varSearch){
       extendtime();//extiende el tiempo de sesion
       List<String> listPlaneTail = new ArrayList<>();
        if (varSearch!=null) {
            if (varSearch.length()>3) {
                listPlaneTail=engRequestFacade.findByPlaneTail(varSearch);
            }
        }
        return listPlaneTail;
    }
    
    public List<Object[]> searchNrESR(String varSearch){
       extendtime();//extiende el tiempo de sesion
       esStringESR=true;
       List<Object[]> listNrESR = new ArrayList<Object[]>();
        if (varSearch!=null) { 
            if (varSearch.length()>3) {
                listNrESR=engRequestFacade.findByESRNumber(varSearch);
            }
        }
        return listNrESR;
    }
    
    public List<String> searchATAs(String varSearch){
       extendtime();//extiende el tiempo de sesion
       List<String> listATAs = new ArrayList<>();
        if (varSearch!=null) {
            if (varSearch.length()>3) {
                listATAs=engRequestFacade.findByATAs(varSearch);
            }
        }
        return listATAs;
    }
    
    public List<String> searchAirplaneModel(String varSearch){
       extendtime();//extiende el tiempo de sesion
       List<String> listAirplaneModelae = new ArrayList<>();
        if (varSearch!=null) {
            if (varSearch.length()>3) {
                listAirplaneModelae=engRequestFacade.findByAirplaneModel(varSearch);
            }
        }
        return listAirplaneModelae;
    }
    public List<Object[]> searchWorkOrder(String varSearch){
       extendtime();//extiende el tiempo de sesion
       esWorkOrder=true;
       List<Object[]> listWorkOrder = new ArrayList<>();
        if (varSearch!=null) {
            if (varSearch.length()>3) {
                listWorkOrder=engRequestFacade.findByWorkOrder(varSearch);
            }
        }
        return listWorkOrder;
    }
    
    public List<String> searchCustomer(String varSearch){
       extendtime();//extiende el tiempo de sesion
       List<String> listCustomer = new ArrayList<>();
        if (varSearch!=null) {
            if (varSearch.length()>3) {
                listCustomer=engRequestFacade.findByCustomer(varSearch);
            }
        }
        return listCustomer;
    }
    
    public List<String> searchEngineerAttendant(String varSearch){
       extendtime();//extiende el tiempo de sesion
       List<String> listEngineerAttendant = new ArrayList<>();
        if (varSearch!=null) {
            if (varSearch.length()>3) {
                listEngineerAttendant=engRequestFacade.findByEngineerAttendant(varSearch);
            }
        }
        return listEngineerAttendant;
    }
    public List<String> searchPartNumber(String varSearch){
       extendtime();//extiende el tiempo de sesion
       List<String> listPartNumber = new ArrayList<>();
        if (varSearch!=null) {
            if (varSearch.length()>3) {
                listPartNumber=engRequestFacade.findByPartNumber(varSearch);
            }
        }
        return listPartNumber;
    }
    public List<String> searchAffectedPart(String varSearch){
       extendtime();//extiende el tiempo de sesion
       List<String> listAffectedPart = new ArrayList<>();
        if (varSearch!=null) {
            if (varSearch.length()>3) {
                listAffectedPart=engRequestFacade.findByAffectedPart(varSearch);
            }
        }
        return listAffectedPart;
    }
    

   public void setCoAvion(String coAvion) {
        extendtime();//extiende el tiempo de sesion
        this.coAvion = coAvion.trim();
        this.engRequest.setReqRegistry(this.coAvion);
        ordenWork();
    }

    public void ordenWork() {
        extendtime();//extiende el tiempo de sesion
        List<ContCheck> temp = new ArrayList<ContCheck>();
        if (coAvion != null) {
            for (ContCheck t : oworks) {
                if (t.getChkRegistry().equals(coAvion)) {
                    temp.add(t);
                }
            }
            oworks = temp;
        } else {
            try {
                temp = cont.findAll();
                oworks = temp;
            } catch (Exception e) {
                Logger.getLogger(MotorBusquedaEsrBean.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    public void atas() {
        extendtime();//extiende el tiempo de sesion
        for (ContAtas atasTemp : todasAtas) {
            atasStr.add("" + atasTemp.getAtaNumata() + "." + atasTemp.getAtaDescription().replaceAll("\\x1C", "").trim() + "");
        }

    }

    public void cAvion() {
        extendtime();//extiende el tiempo de sesion
        List<String> aviones = new ArrayList<>();
        try {
            for (ContCheck avione : oworks) {
                if (!aviones.contains(avione.getChkRegistry())) {
                    aviones.add(avione.getChkRegistry());
                }
            }
            colaAviones = aviones;
        } catch (Exception e) {
            Logger.getLogger(MotorBusquedaEsrBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }
     public Boolean valESR(Object valESR) {
        extendtime();//extiende el tiempo de sesion
        Boolean isNotNullESR = true;
        Integer esp = 0;
        String evaluarESR;
        if (valESR == null) {
            return isNotNullESR = false;
        }
        evaluarESR = valESR.toString();
        if (evaluarESR.isEmpty()) {
            return isNotNullESR = false;
        }
        for (int i = 0; i < evaluarESR.length(); i++) {
            if (evaluarESR.charAt(i) == ' ') {
                esp++;
            }
        }
        if (evaluarESR.length() == esp) {
            return isNotNullESR = false;
        }
        return isNotNullESR;
    }

    public void buscar() {    
        extendtime();//extiende el tiempo de sesion
        esStringESR=false;
        esrResultados = new ArrayList<>();
        try {
            Object[] valABusc = new Object[9];
        if (valESR(numESRSearch)) {
            valABusc[0] = numESRSearch;
            esStringESR=false;
            EngRequest reqTem2 = engRequestFacade.find(new BigInteger(numESRSearch));
            numESRSearch = "ESR-" + reqTem2.getAtaNumata() + "-" + reqTem2.getReqCorr() + "/" + sdf2.format(sdf.parse(reqTem2.getReqYear()));
        }
        if (valESR(colAvionSearch)) {
            valABusc[1] = colAvionSearch;                 
        }
        if (valESR(ataSearch)) {
            boolean resultado = ataSearch.contains("-");
            if (resultado){
                valABusc[2] = ataSearch.substring(0, ataSearch.indexOf('-'));   
            }
        }
        if (valESR(modelAirpSearch)) {
            valABusc[3] = modelAirpSearch;
        }
        if (valESR(workOrderSearch)) {
            valABusc[4] = workOrderSearch;
            esWorkOrder=false;
            ContCheck conVar = cont.find(new BigDecimal(workOrderSearch));
            workOrderSearch=conVar.getChkWo();
        }
        if (valESR(customerSearch)) {
            boolean resultado = customerSearch.contains("-");
            if (resultado){
                valABusc[5] = customerSearch.substring(0, customerSearch.indexOf('-'));   
            }
            else{
                valABusc[5] = customerSearch;
            }
            
        }
        if (valESR(solicitedSearch)) {
            boolean resultado = solicitedSearch.contains("-");
            if (resultado){
                valABusc[6] = solicitedSearch.substring(0, solicitedSearch.indexOf('-'));  
            }
            else{
                valABusc[6] = solicitedSearch;
            }
              
        }
        if (valESR(partNumberSearch)) {
            valABusc[7] = partNumberSearch;
        }
        if (valESR(reqSearchAffectedPartSearch)) {
            boolean resultado = reqSearchAffectedPartSearch.contains("-");
            if (resultado){
                valABusc[8] = reqSearchAffectedPartSearch.substring(0, reqSearchAffectedPartSearch.indexOf('-')); 
            }
            
        }
        
        sgrCia = companyFacade.find(companyUser);
        if(sgrCia.getCiaAcceso().intValue()==1){
            esrResultados = searchEsrFacade.findFromMotorBusquedaCia(valABusc,companyUser);
        }else{
            esrResultados = searchEsrFacade.findFromMotorBusqueda(valABusc);
        }
        } catch (Exception e) {
            Logger.getLogger(MotorBusquedaBean.class.getName()).log(Level.SEVERE, null, e);//captura de error
            FacesContext.getCurrentInstance().validationFailed();
        } 
        
    }

    public void cModal() {
        extendtime();//extiende el tiempo de sesion
        this.edit = true;
        if (this.id != null) {
            BigDecimal idc = new BigDecimal(this.id);
            this.elemento = engRequestFacade.find(idc);
        }
    }

    public void limpiarCamps() {
        extendtime();//extiende el tiempo de sesion
        
        numESRSearch= "";
        esStringESR=false;
        colAvionSearch= "";
        ataSearch= "";
        modelAirpSearch= "";
        workOrderSearch= "";
        esWorkOrder=false;
        customerSearch= "";
        solicitedSearch= "";
        partNumberSearch= "";
        reqSearchAffectedPartSearch= "";
        esrResultados = new ArrayList<>();
                
       /* this.ataSelected = null;
        this.avionModel = "";
        this.coAvion = "";
        this.eaSelected = "";
        this.eaSelected = "";
        this.esrSelected = "";
        this.owSelected = "";
        workorderBusqueda = "";
        ataBusq = "";
        ingenieroBusq = "";
        clienteBusq = "";
        this.engRequest = new EngRequest();
        this.engRequest.setReqRegistry("");
        this.engRequest.setReqMessageid(BigInteger.ZERO);
        this.engRequest.setReqModel("");
        this.buscado = false;
        esrResultados = new ArrayList<>();
        camposvacios = false;
        nodatafound = false;*/
    }

    public void convertidas() {
        extendtime();//extiende el tiempo de sesion
        convertida.clear();
        for (String uno : colaAviones) {
            if (!convertida.contains("" + uno + "")) {
                convertida.add("" + uno + "");
            }
        }
        //return convertida;
    }

    public void esrTodas() {
        extendtime();//extiende el tiempo de sesion
        if (esrStr != null) {
            esrStr.clear();

            for (EngRequest ob : esrs) {
                try {
                    if (!esrStr.contains("ESR-" + ob.getAtaNumata() + "-" + (ob.getReqCorr() != null ? ob.getReqCorr() : "NA") + "/" + ob.getReqYear() != null ? sdf2.format(sdf.parse(ob.getReqYear())) : "NA" + "")) {

                        String guaReqCorr = ob.getReqCorr() != null ? ob.getReqCorr() : "NA";
                        String guaReqYear = ob.getReqYear() != null ? sdf2.format(sdf.parse(ob.getReqYear())) : "NA";

                        mapEsr.put("ESR-" + ob.getAtaNumata() + "-" + guaReqCorr + "/" + guaReqYear, ob.getReqMessageid());
                        esrStr.add("ESR-" + ob.getAtaNumata() + "-" + guaReqCorr + "/" + guaReqYear + "");
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(MotorBusquedaEsrBean.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    public void setDatosIngenieroBusqueda(String nombre, String codigo86) {
        extendtime();//extiende el tiempo de sesion
        this.ingenieroBusq = nombre;
        this.engRequest.setUsrCoduser(codigo86);
    }

    public void obtenerClientes() {
        extendtime();//extiende el tiempo de sesion
        List<ContCheck> cheqs = cont.findAll();
        Map<String, String> listCliMap = new HashMap<String, String>();

        for (ContCheck checktemp : cheqs) {
            if (!listCliMap.containsKey(checktemp.getChkCucod())) {
                listaClientes.add(checktemp.getChkCucod());
                listCliMap.put(checktemp.getChkCucod(), checktemp.getChkCucod());
            }
        }
    }
    
    public void findTrackingDisposition(){
        extendtime();//extiende el tiempo de sesion
        HttpSession session = SessionBean.getSession();
        String user = (String) session.getAttribute("username");
        codeuser=user;
        workOrder="";
        for (ContCheck lisWO : listFiltro) {
            workOrder=workOrder.concat("'"+lisWO.getChkWo()+"',");
        }
        if(workOrder.length()>0){
            workOrder = workOrder.concat("reemplazar");
            workOrder = workOrder.replace(",reemplazar","");  
        }
        if (status.length()==0){
            status="T";
        }
        
        customerciaFacade.spDisposotionWO(status, workOrder, fstrart, ffinal, codeuser);
    }
    
     public void findTrackingReport(){
        extendtime();//extiende el tiempo de sesion
        HttpSession session = SessionBean.getSession();
        String userD = (String) session.getAttribute("username");
        workOrderTr="";
        codeuser=userD;
        
        for (ContCheck lisWO : listFiltro) {
            workOrderTr=workOrderTr.concat("'"+lisWO.getChkWo()+"',");
        }
        if(workOrderTr.length()>0){
            workOrderTr = workOrderTr.concat("reemplazar");
            workOrderTr = workOrderTr.replace(",reemplazar","");  
        }
        if (status.length()==0){
            status="T";
        }
        
        customerciaFacade.spTrackingWO(status, workOrderTr, fstrart, ffinal, codeuser);
    }
    
    public void findWorkOrderTrackingESR(){
        extendtime();//extiende el tiempo de sesion
        if (fstrart == null || ffinal == null  ){
            workOders=cont.findByChekWOAll(avion);
        }
        else{
            workOders=cont.findByChekWORegistry(avion, fstrart, ffinal);  
        }
        
        
    }
    public void agregarWOForTail(){
        extendtime();//extiende el tiempo de sesion
      try{
        duplicado=false;
       ContCheck ctc = new ContCheck();
        for (ContCheck lisWO : listFiltro) {
            if (lisWO.getChkWo().equals(woESR) && lisWO.getChkRegistry().equals(avion)){
                duplicado=true;
                break;
            } 
        }
        if (!duplicado) {
            ctc.setChkRegistry(avion);
            ctc.setChkWo(woESR);
            listFiltro.add(ctc);
            avion= null;
            woESR= null;
            workOrder = listFiltro.get(0).getChkRegistry()+"- "+ listFiltro.get(0).getChkWo();
        }
      }catch(Exception e){
          Logger.getLogger(MotorBusquedaBean.class.getName()).log(Level.SEVERE,null,e);
      }
    }
    public void eliminarESR(ContCheck elemSh){
        listFiltro.remove(elemSh);
        
    }
    
    public void limpiarTrackingDisposition(){
        extendtime();//extiende el tiempo de sesion
        status = null;
        workOrder = null;
        fstrart = null;
        ffinal = null;
        codeuser = null;
        avion = null;
        listFiltro = new ArrayList<>();
    }
    public void compararfecha(){
        extendtime();//extiende el tiempo de sesion
        if (fstrart != null && ffinal != null) {
            if (ffinal.after(fstrart) || (ffinal.equals(fstrart))) {
                validarDate = 0;
            } else if (!ffinal.after(fstrart)) {
                validarDate = 1;                
            }

        }
    }

    @Override//metodo generado por implements Serializable
    void actualizar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override//metodo generado por implements Serializable
    void agregar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override//metodo generado por implements Serializable
    void eliminar(EngRequest elemento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override//metodo generado por implements Serializable
    EngRequest nuevoElemento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public EngRequest getEngRequest() {//get y set de variable
        return engRequest;
    }

    public void setEngRequest(EngRequest engRequest) {//get y set de variable
        this.engRequest = engRequest;
    }

    public String getOwSelected() {//get y set de variable
        return owSelected;
    }

    public void setOwSelected(String owSelected) {//get y set de variable
        this.owSelected = owSelected;
    }

    public String getEsrSelected() {//get y set de variable
        return esrSelected;
    }

    public void setEsrSelected(String esrSelected) {//get y set de variable
        this.esrSelected = esrSelected;
    }   

    public String getEaSelected() {//get y set de variable
        return eaSelected;
    }

    public void setEaSelected(String eaSelected) {//get y set de variable
        this.eaSelected = eaSelected;
    }

    public String getAvionModel() {//get y set de variable
        return avionModel;
    }

    public void setAvionModel(String avionModel) {//get y set de variable
        this.avionModel = avionModel;
        this.engRequest.setReqModel(avionModel);
    }

    public Integer getAtaSelected() {//get y set de variable
        return ataSelected;
    }

    public void setAtaSelected(Integer ataSelected) {//get y set de variable
        this.ataSelected = ataSelected;
        this.engRequest.setAtaNumata(ataSelected.shortValue());
    }

    public Integer getId() {//get y set de variable
        return id;
    }

    public void setId(Integer id) {//get y set de variable
        this.id = id;
    }

    public List<ContCheck> getOworks() {//get y set de variable
        return oworks;
    }

    public void setOworks(List<ContCheck> oworks) {//get y set de variable
        this.oworks = oworks;
    }

    public ContCheckFacade getCont() {//get y set de variable
        return cont;
    }

    public void setCont(ContCheckFacade cont) {//get y set de variable
        this.cont = cont;
    }

    public List<Integer> getAtasG() {//get y set de variable
        return atasG;
    }

    public void setAtasG(List<Integer> atasG) {//get y set de variable
        this.atasG = atasG;
    }

    public List<EngRequest> getEsrs() {//get y set de variable
        return esrs;
    }

    public void setEsrs(List<EngRequest> esrs) {//get y set de variable
        this.esrs = esrs;
    }

    public List<String> getColaAviones() {//get y set de variable
        return colaAviones;
    }

    public void setColaAviones(List<String> colaAviones) {//get y set de variable
        this.colaAviones = colaAviones;
    }

    public List<String> getConvertida() {//get y set de variable
        return convertida;
    }

    public void setConvertida(List<String> convertida) {//get y set de variable
        this.convertida = convertida;
    }

    public List<String> getEasStr() {//get y set de variable
        return easStr;
    }

    public void setEasStr(List<String> easStr) {//get y set de variable
        this.easStr = easStr;
    }

    public List<String> getOwStr() {//get y set de variable
        return owStr;
    }

    public void setOwStr(List<String> owStr) {//get y set de variable
        this.owStr = owStr;
    }

    public List<String> getEsrStr() {//get y set de variable
        return esrStr;
    }

    public void setEsrStr(List<String> esrStr) {//get y set de variable
        this.esrStr = esrStr;
    }

    public List<String> getTitulos() {//get y set de variable
        return titulos;
    }

    public void setTitulos(List<String> titulos) {//get y set de variable
        this.titulos = titulos;
    }

    public List<String> getAtasStr() {//get y set de variable
        return atasStr;
    }

    public void setAtasStr(List<String> atasStr) {//get y set de variable
        this.atasStr = atasStr;
    }

    public List<String> getAvionModels() {//get y set de variable
        return avionModels;
    }

    public void setAvionModels(List<String> avionModels) {//get y set de variable
        this.avionModels = avionModels;
    }

    public String getPn() {//get y set de variable
        return pn;
    }

    public void setPn(String pn) {//get y set de variable
        this.pn = pn;
    }

    public String getSn() {//get y set de variable
        return sn;
    }

    public void setSn(String sn) {//get y set de variable
        this.sn = sn;
    }

    public String getTitulo() {//get y set de variable
        return titulo;
    }

    public void setTitulo(String titulo) {//get y set de variable
        this.titulo = titulo;
    }

    public Integer getAñoSelect() {//get y set de variable
        return añoSelect;
    }

    public void setAñoSelect(Integer añoSelect) {//get y set de variable
        this.añoSelect = añoSelect;
    }

    public Boolean getBuscado() {//get y set de variable
        return buscado;
    }

    public void setBuscado(Boolean buscado) {//get y set de variable
        this.buscado = buscado;
    }

    public List<SearchEsr> getEsrResultados() {//get y set de variable
        return esrResultados;
    }

    public void setEsrResultados(List<SearchEsr> esrResultados) {//get y set de variable
        this.esrResultados = esrResultados;
    }

    public String getWorkorderBusqueda() {//get y set de variable
        return workorderBusqueda;
    }

    public void setWorkorderBusqueda(String workorderBusqueda) {//get y set de variable
        this.workorderBusqueda = workorderBusqueda;
    }

    public List<EngListView> getIngenieros() {//get y set de variable
        return ingenieros;
    }

    public void setIngenieros(List<EngListView> ingenieros) {//get y set de variable
        this.ingenieros = ingenieros;
    }

    public String getIngenieroBusq() {//get y set de variable
        return ingenieroBusq;
    }

    public void setIngenieroBusq(String ingenieroBusq) {//get y set de variable
        this.ingenieroBusq = ingenieroBusq;
    }

    public List<String> getListaClientes() {//get y set de variable
        return listaClientes;
    }

    public void setListaClientes(List<String> listaClientes) {//get y set de variable
        this.listaClientes = listaClientes;
    }

    public String getAtaBusq() {//get y set de variable
        return ataBusq;
    }

    public void setAtaBusq(String ataBusq) {//get y set de variable
        this.ataBusq = ataBusq;
    }

    public String getClienteBusq() {//get y set de variable
        return clienteBusq;
    }

    public void setClienteBusq(String clienteBusq) {//get y set de variable
        this.clienteBusq = clienteBusq;
    }

    @Override//metodo generado por implements Serializable
    void limpiar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getEsrSelTabla() {//get y set de variable
        return esrSelTabla;
    }

    public void setEsrSelTabla(String esrSelTabla) {//get y set de variable
        this.esrSelTabla = esrSelTabla;
    }

    public List<String> getClientesAutoc() {//get y set de variable
        return clientesAutoc;
    }

    public void setClientesAutoc(List<String> clientesAutoc) {//get y set de variable
        this.clientesAutoc = clientesAutoc;
    }

    public boolean isCamposvacios() {//get y set de variable
        return camposvacios;
    }

    public void setCamposvacios(boolean camposvacios) {//get y set de variable
        this.camposvacios = camposvacios;
    }

    public boolean isNodatafound() {//get y set de variable
        return nodatafound;
    }

    public void setNodatafound(boolean nodatafound) {//get y set de variable
        this.nodatafound = nodatafound;
    }

    public String getStatus() {//get y set de variable
        return status;
    }

    public void setStatus(String status) {//get y set de variable
        this.status = status;
    }

    public String getWorkOrder() {//get y set de variable
        return workOrder;
    }

    public void setWorkOrder(String workOrder) {//get y set de variable
        this.workOrder = workOrder;
    }

    public String getWorkOrderTr() {//get y set de variable
        return workOrderTr;
    }

    public void setWorkOrderTr(String workOrderTr) {//get y set de variable
        this.workOrderTr = workOrderTr;
    }

    public Date getFstrart() {//get y set de variable
        return fstrart;
    }

    public void setFstrart(Date fstrart) {//get y set de variable
        this.fstrart = fstrart;
    }

    public Date getFfinal() {//get y set de variable
        return ffinal;
    }

    public void setFfinal(Date ffinal) {//get y set de variable
        this.ffinal = ffinal;
    }

    public String getCodeuser() {//get y set de variable
        return codeuser;
    }

    public void setCodeuser(String codeuser) {//get y set de variable
        this.codeuser = codeuser;
    }

    public String getAvion() {//get y set de variable
        return avion;
    }

    public void setAvion(String avion) {//get y set de variable
        this.avion = avion;
    }

    public List<String> getAviones() {//get y set de variable
        return aviones;
    }

    public void setAviones(List<String> aviones) {//get y set de variable
        this.aviones = aviones;
    }

    public List<ContAtas> getTodasAtas() {//get y set de variable
        return todasAtas;
    }

    public void setTodasAtas(List<ContAtas> todasAtas) {//get y set de variable
        this.todasAtas = todasAtas;
    }

    public String getWoESR() {//get y set de variable
        return woESR;
    }

    public void setWoESR(String woESR) {//get y set de variable
        this.woESR = woESR;
    }

    public List<ContCheck> getWorkOders() {//get y set de variable
        return workOders;
    }

    public void setWorkOders(List<ContCheck> workOders) {//get y set de variable
        this.workOders = workOders;
    }

    public boolean isDuplicado() {//get y set de variable
        return duplicado;
    }

    public void setDuplicado(boolean duplicado) {//get y set de variable
        this.duplicado = duplicado;
    }

    public List<ContCheck> getListFiltro() {//get y set de variable
        return listFiltro;
    }

    public void setListFiltro(List<ContCheck> listFiltro) {//get y set de variable
        this.listFiltro = listFiltro;
    }

    public int getValidarDate() {//get y set de variable
        return validarDate;
    }

    public void setValidarDate(int validarDate) {//get y set de variable
        this.validarDate = validarDate;
    }
    
     public String getNrESR() {//get y set de variable
        return nrESR;
    }

    public void setNrESR(String nrESR) {//get y set de variable
        this.nrESR = nrESR;
    }

    public String getPartNumberSearch() {
        return partNumberSearch;
    }

    public void setPartNumberSearch(String partNumberSearch) {
        this.partNumberSearch = partNumberSearch;
    }

    public String getReqSearchAffectedPartSearch() {
        return reqSearchAffectedPartSearch;
    }

    public void setReqSearchAffectedPartSearch(String reqSearchAffectedPartSearch) {
        this.reqSearchAffectedPartSearch = reqSearchAffectedPartSearch;
    }

    public String getColAvionSearch() {
        return colAvionSearch;
    }

    public void setColAvionSearch(String colAvionSearch) {
        this.colAvionSearch = colAvionSearch;
    }

    public String getNumESRSearch() {
        return numESRSearch;
    }

    public void setNumESRSearch(String numESRSearch) {
        this.numESRSearch = numESRSearch;
    }

    public String getAtaSearch() {
        return ataSearch;
    }

    public void setAtaSearch(String ataSearch) {
        this.ataSearch = ataSearch;
    }

    public String getModelAirpSearch() {
        return modelAirpSearch;
    }

    public void setModelAirpSearch(String modelAirpSearch) {
        this.modelAirpSearch = modelAirpSearch;
    }

    public String getWorkOrderSearch() {
        return workOrderSearch;
    }

    public void setWorkOrderSearch(String workOrderSearch) {
        this.workOrderSearch = workOrderSearch;
    }

    public String getCustomerSearch() {
        return customerSearch;
    }

    public void setCustomerSearch(String customerSearch) {
        this.customerSearch = customerSearch;
    }

    public String getSolicitedSearch() {
        return solicitedSearch;
    }

    public void setSolicitedSearch(String solicitedSearch) {
        this.solicitedSearch = solicitedSearch;
    }

    public Boolean getEsStringESR() {
        return esStringESR;
    }

    public void setEsStringESR(Boolean esStringESR) {
        this.esStringESR = esStringESR;
    }

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
    }

    public String getCompanyUser() {
        return companyUser;
    }

    public void setCompanyUser(String companyUser) {
        this.companyUser = companyUser;
    }

    public Boolean getEsWorkOrder() {
        return esWorkOrder;
    }

    public void setEsWorkOrder(Boolean esWorkOrder) {
        this.esWorkOrder = esWorkOrder;
    }
    
    
    
}
