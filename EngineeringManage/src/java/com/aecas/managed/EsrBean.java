
// To change this license header, choose License Headers in Project Properties.
// To change this template file, choose Tools | Templates
// and open the template in the editor.

package com.aecas.managed;// paquete manage

import com.aees.pojos.AircraftDashPojo;// importacion de clase
import com.aees.pojos.CustomerByOpco;
import com.aees.pojos.DashbordEngPojo;// importacion de clase
import com.aees.pojos.IncialDasbordPojo;// importacion de clase
import com.aees.pojos.JsonDashENG;// importacion de clase
import com.aees.pojos.RampaPojo;// importacion de clase
import com.aees.pojos.RequestDashWS;// importacion de clase
import com.aees.session.SessionBean;// importacion de clase
import com.aeroman.aees.entities.CoreAircraftType;// importacion de clase
import com.aeroman.aees.entities.EngAffectedPart;// importacion de clase
import com.aeroman.aees.entities.EngDamageType;// importacion de clase
import com.aeroman.aees.entities.EngDent;// importacion de clase
import com.aeroman.aees.entities.EngDentIni;// importacion de clase
import com.aeroman.aees.entities.EngReqStatus;// importacion de clase
import com.aeroman.aees.entities.EngReqTaskCard;// importacion de clase
import com.aeroman.aees.entities.EngReqTaskCardIni;// importacion de clase
import com.aeroman.aees.entities.EngReqTaskJobcard;// importacion de clase
import com.aeroman.aees.entities.EngReqTaskJobcardIni;// importacion de clase
import com.aeroman.aees.entities.EngRequest;// importacion de clase
import com.aeroman.aees.entities.EngRequestDimen;// importacion de clase
import com.aeroman.aees.entities.EngRequestDimenIni;// importacion de clase
import com.aeroman.aees.entities.EngRequestDimenManuf;
import com.aeroman.aees.entities.EngRequestInicial;// importacion de clase
import com.aeroman.aees.entities.EngRequestQuestion;// importacion de clase
import com.aeroman.aees.entities.EngRequestQuestionIni;// importacion de clase
import com.aeroman.aees.entities.grant.PrcDetparam;
import com.aeroman.aees.entities.grant.SgrUser;
import com.aeroman.aees.facades.EngAffectedPartFacade;// importacion de clase
import com.aeroman.aees.facades.EngDamageTypeFacade;// importacion de clase
import com.aeroman.aees.facades.EngDentFacade;// importacion de clase
import com.aeroman.aees.facades.EngDentIniFacade;// importacion de clase
import com.aeroman.aees.facades.EngReqStatusFacade;// importacion de clase
import com.aeroman.aees.facades.EngReqTaskCardFacade;// importacion de clase
import com.aeroman.aees.facades.EngReqTaskCardIniFacade;// importacion de clase
import com.aeroman.aees.facades.EngReqTaskJobcardFacade;// importacion de clase
import com.aeroman.aees.facades.EngReqTaskJobcardIniFacade;// importacion de clase
import com.aeroman.aees.facades.EngRequestDimenFacade;// importacion de clase
import com.aeroman.aees.facades.EngRequestDimenIniFacade;// importacion de clase
import com.aeroman.aees.facades.EngRequestFacade;// importacion de clase
import com.aeroman.aees.facades.EngRequestDimenManufFacade;
import com.aeroman.aees.facades.EngRequestInicialFacade;// importacion de clase
import com.aeroman.aees.facades.EngRequestQuestionFacade;// importacion de clase
import com.aeroman.aees.facades.EngRequestQuestionIniFacade;// importacion de clase
import com.aeroman.aees.facades.Sequences;// importacion de clase
import com.aeroman.aees.facades.grant.ContCheckEmailsFacade;
import com.aeroman.aees.facades.grant.PrcDetparamFacade;
import com.aeroman.aees.facades.grant.SgrUserFacades;
import com.google.gson.Gson;// libreria Gson
import java.io.BufferedReader;// libreria BufferedReader
import java.io.IOException;// libreria IOException
import java.io.InputStreamReader;// libreria InputStreamReader
import java.io.Serializable;// libreria Serializable
import java.math.BigDecimal;// libreria BigDecimal
import java.math.BigInteger;// libreria BigInteger
import java.text.SimpleDateFormat;// libreria SimpleDateFormat
import java.util.Calendar;// libreria Calendar
import java.util.Date;// libreria Date
import java.util.GregorianCalendar;// libreria GregorianCalendar
import javax.annotation.PostConstruct;// libreria PostConstruct
import javax.ejb.EJB;// libreria EJB
import javax.faces.bean.ManagedBean;// libreria ManagedBean
import javax.faces.bean.ManagedProperty;// libreria ManagedProperty
import javax.faces.bean.SessionScoped;// libreria SessionScoped
import javax.servlet.http.HttpSession;// libreria HttpSession
import java.util.ArrayList;// libreria ArrayList
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;// libreria List
import java.util.ListIterator;
import java.util.Map;
import java.util.logging.Level;// libreria Level
import java.util.logging.Logger;// libreria Logger
import javax.el.ELContext;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;// libreria FacesMessage
import javax.faces.component.UIInput;// libreria UIInput
import javax.faces.component.UIViewRoot;// libreria UIViewRoot
import javax.faces.context.FacesContext;// libreria FacesContext
import org.apache.http.HttpResponse;// libreria HttpResponse
import org.apache.http.client.HttpClient;// libreria HttpClient
import org.apache.http.client.methods.HttpPost;// libreria HttpPost
import org.apache.http.entity.StringEntity;// libreria StringEntity
import org.apache.http.impl.client.DefaultHttpClient;// libreria DefaultHttpClient
import org.json.simple.JSONObject;// libreria JSONObject
import org.json.simple.parser.JSONParser;// libreria JSONParser
							   

/**
 *
 * @author Usuario
 */
 //nombre de clase en mageBean
@ManagedBean(name = "esrBean")
@SessionScoped//tipo de clase
//clase EsrBean con extends al crud
public class EsrBean extends CrudBean<EngRequest> implements Serializable {

																				
    private Boolean actualizado = false;//declaracion de variable
    // ip de desa http://esbt.aeroman.com.sv:7080/brk/dev/viewDashboardMobile
    // ip de test http://web1salwlt.aeroman.com.sv:8002/brk/test/viewDashboardMobile
    // ip de prod http://web1salwlp.aeroman.com.sv:8002/brk/prod/viewDashboardMobile
    private static final String CONTTYPE = "Content-type";//declaracion de variable
    private static final String JSONTYPE = "application/json";//declaracion de variable
    private static final String UTF="UTF-8";//declaracion de variable
    private String POSTURL = "http://esbt.aeroman.com.sv:7080/brk/dev/viewDashboardMobile";//declaracion de variable
    private RequestDashWS requestDashWS;//declarion variable tipo clase
    private JsonDashENG jsonDashENG;//declarion variable tipo clase
    private IncialDasbordPojo incialDashbordPojo;//declarion variable tipo clase
    private DashbordEngPojo dashbordEngPojo;//declarion variable tipo clase
    private AircraftDashPojo aircraftDashPojo;//declarion variable tipo clase
    
    private RampaPojo rampaPojo;//declarion variable tipo clase
   
    
    
    private String PKAffectedPart;//declaracion de variable

    private boolean existeAffectedPart;//declaracion de variable
    private boolean existeDamageType;//declaracion de variable
    private String affmalo;//declaracion de variable
    private String dammalo;//declaracion de variable
    private String  damageName;//declaracion de variable
    private String validarFlota;//declaracion de variable

    @EJB
    private EngRequestFacade engRequestFacade;//declaracion de clases Facade
    @EJB
    private Sequences seq;//declaracion de clases Facade
    @EJB
    private EngReqTaskCardFacade engReqTaskCardFacade;//declaracion de clases Facade
    @EJB
    private EngReqStatusFacade engReqStatusFacade;//declaracion de clases Facade
    @EJB
    private EngRequestInicialFacade engRequestInicialFacade;//declaracion de clases Facade
    @EJB
    private EngReqTaskJobcardFacade engReqTaskJobcardFacade;//declaracion de clases Facade
    
    @EJB
    private EngAffectedPartFacade AffectedPartFacade;//declaracion de clases Facade
    @EJB
    private SgrUserFacades sgrUser;
    @EJB
    private EngDamageTypeFacade DamageTypeFacade;//declaracion de clases Facade
    
    @EJB
    private EngRequestDimenFacade RequestDimenFacade;//declaracion de clases Facade
    @EJB
    private EngRequestDimenManufFacade engRequestDimenManufFacade;//declaracion de clases Facade
    @EJB
    private EngReqTaskJobcardIniFacade engReqTaskJobcardIniFacade;//declaracion de clases Facade
    @EJB
    private EngReqTaskCardIniFacade engReqTaskCardIniFacade;//declaracion de clases Facade
    @EJB
    private EngRequestDimenIniFacade engRequestDimenIniFacade;//declaracion de clases Facade
    @EJB
    private EngRequestQuestionFacade engRequestQuestionFacade;//declaracion de clases Facade
    @EJB
    private EngDentFacade engDentFacade;//declaracion de clases Facade
    @EJB
    private EngRequestQuestionIniFacade engRequestQuestionIniFacade;//declaracion de clases Facade
    @EJB
    private EngDentIniFacade engDentIniFacade;//declaracion de clases Facade
    @EJB
    private ContCheckEmailsFacade contcheckEmail;//declaracion de clases Facade
    @EJB
    private PrcDetparamFacade prcDetparamFacade;//declaracion de clases Facade
    
    
    

    private String validarCoDash;//declaracion de variable
    private String userSol;//declaracion de variable
    private String workOrderJob;//declaracion de variable
    private String corr;//declaracion de variable
    BigInteger us = null;//declaracion de variable
    private String companyCia ;//declaracion de variable
    private String descStatus;//declaracion de variable
    private String userEsr= "username";//declaracion de variable
    private boolean fechaInsmala;//declaracion de variable
    private boolean fechaExpmala;//declaracion de variable
    private boolean fechaDamagepmala;//declaracion de variable
    private int esrIngresada;//declaracion de variable
    private String idHangar;//declaracion de variable
    private EngRequestInicial engRequestInicial;//declarion variable tipo clase
    transient List<AircraftDashPojo> listaAviones = new ArrayList<>();//declaracion de variable
    transient List<RampaPojo> listaAvionesEnRampa = new ArrayList<>();  //declaracion de variable
    transient List<DashbordEngPojo> listaHangares = new ArrayList<>();//declaracion de variable
    transient List<EngDentIni> listaEngDentIni = new ArrayList<>();//declaracion de variable
    transient List<EngDamageType> listaEngDamageType = new ArrayList<>();//declaracion de variable
    
    transient List<EngRequestQuestionIni> listaEngRequestQuestionIni = new ArrayList<>();//declaracion de variable
    transient List<EngRequestDimenIni> listaEngRequestDimenIniLocal = new ArrayList<>();//declaracion de variable
    transient List<EngRequestDimenIni> listaEngRequestDimenIniDimCheck = new ArrayList<>();//declaracion de variable
    transient List<EngRequestDimenIni> listaEngRequestDimenIni = new ArrayList<>();//declaracion de variable
    transient List<EngRequestDimenIni> listaEngRequestDimenIniDimBlend_Dent = new ArrayList<>();//declaracion de variable
    transient List<EngRequestDimenIni> listaEngRequestDimenIniDimNearby = new ArrayList<>();//declaracion de variable
    
																				 
    @ManagedProperty(value = "#{esrDocumentBean}")
    private EsrDocumentBean esrDocumentBean;//declarion variable tipo clase
       
																			 
    private boolean compCheck;
    
    private PojoAviones reqPojoAviones;//declarion variable tipo clase
    
    @ManagedProperty(value = "#{coreAircraftTypeBean}")
    private CoreAircraftTypeBean coreAircraftTypeBean;//declarion variable tipo clase
    
    Gson gson;//declaracion de variable
    HttpClient httpClient;//declaracion de variable
    HttpPost post;//declaracion de variable
    HttpResponse response;//declaracion de variable
    
    //lista para poder pintar los motores de ECR
    private List<CustomerByOpco> customersByOpco;
    
    
    @Override//metodo generado por implements Serializable
    @PostConstruct//metodo constructor
    public void init() {
													 
        extendtime();//extiende el tiempo de sesion
        esrDocumentBean.setExisteFile(0);
        elemento = new EngRequest();
        //POSTURL = prcDetparamFacade.findByLiksWeb("DASH").getValor();
        listaAviones = new ArrayList<>();

        dashbordEngPojo = new DashbordEngPojo();
        requestDashWS = new RequestDashWS();
        jsonDashENG = new JsonDashENG();
        incialDashbordPojo = new IncialDasbordPojo();
        aircraftDashPojo = new AircraftDashPojo();
        
        customersByOpco = new ArrayList<>();

        setPKAffectedPart(null);      
//        setDamageName(null);
        setExisteAffectedPart(false);
        setExisteDamageType(false);
														
    }
    public void nombreCortoING(){
        SgrUser varIngeniero= new SgrUser(); 
        if (!elemento.getReqCodIngEnc().equals("0")){
            varIngeniero = sgrUser.findSelectUser(elemento.getReqCodIngEnc());
            elemento.setReqClasRepair((varIngeniero.getPrimerNombre().substring(0,1)+". "+varIngeniero.getPrimerApellido()).toUpperCase());

        }else{
            elemento.setReqClasRepair("");
        }
    }
    
    public void validarAffectedPart() {
        extendtime();//extiende el tiempo de sesion
        existeAffectedPart = "s".equals(affmalo);
        try {
            if (!existeAffectedPart) {
                String sacarid = PKAffectedPart.substring(0, PKAffectedPart.indexOf("-"));
                BigDecimal idaff = new BigDecimal(sacarid);
                EngAffectedPart aff = AffectedPartFacade.find(idaff);
                elemento.setReqAfpId(aff);
                PKAffectedPart = aff.getAfpId()+ "-" + aff.getAfpName();
            }
        } catch (Exception e) {
            Logger.getLogger(TabEsrEaEo.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
  
    public void actualiza(BigDecimal idactividad, String idingeniero) {
        extendtime(); //extiende el tiempo de sesion
        elemento = engRequestFacade.find(idactividad);
        elemento.setUsrCoduser(String.valueOf(idingeniero));
        engRequestFacade.edit(elemento);
    }

    public Object findSelect(String id) throws IOException {
        extendtime(); //extiende el tiempo de sesion
        BigInteger bd = new BigInteger(id);
        elemento = engRequestFacade.find(bd);
        esrDocumentBean.findSelectedItem(id);
        return elemento;
    }

    public void cambiarWCCCard() {
        try {
            extendtime(); //extiende el tiempo de sesion
			FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();
            ELContext elContext = context.getELContext();
            TaskReqCardBean taskReqCardBean = (TaskReqCardBean) application.getExpressionFactory()
                .createValueExpression(elContext, "#{taskReqCardBean}", TaskReqCardBean.class).getValue(elContext);
            taskReqCardBean.concatenar();
            if (taskReqCardBean.listado.size() < 1) {
                elemento.setLogpage(String.valueOf(taskReqCardBean.getTaskcard().getTcYear()) + "-" + String.valueOf(taskReqCardBean.getTaskcard().getTcCorr()));
                elemento.setYearlogpage(String.valueOf(taskReqCardBean.getTaskcard().getTcYear()));
                elemento.setNumerologpage(String.valueOf(taskReqCardBean.getTaskcard().getTcCorr()));
            }
            taskReqCardBean.agregar();
        } catch (Exception e) {
            Logger.getLogger(EsrBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public void responseDateMala(){
        extendtime(); //extiende el tiempo de sesion
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
        fechaInsmala = false;
        if(elemento.getReqResponsedt() != null){ 
            if(elemento.getReqResponsedt().after(elemento.getReqFechaIns()) || sdf.format(elemento.getReqFechaIns()).equals(sdf.format(elemento.getReqResponsedt()))){
                fechaInsmala = false;
            }else{
                fechaInsmala = true;
            }
        }
    }
    public void expirationDateMala(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
        fechaExpmala = false;
        if(elemento.getReqDuedate() != null){   
            if(elemento.getReqDuedate().after(elemento.getReqFechaIns()) || sdf.format(elemento.getReqFechaIns()).equals(sdf.format(elemento.getReqDuedate()))){
                fechaExpmala = false;
            }else{
                fechaExpmala = true;
            }        
        }
    }
    public void fechaDamageMala(){
        extendtime(); //extiende el tiempo de sesion
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
        fechaDamagepmala = false;
		
		FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();
            ELContext elContext = context.getELContext();
            EngDentBean engDentBean = (EngDentBean) application.getExpressionFactory()
                .createValueExpression(elContext, "#{engDentBean}", EngDentBean.class).getValue(elContext);
        
        if(engDentBean.elemento.getDenDateTime() != null){        
        
            if(engDentBean.elemento.getDenDateTime().after(elemento.getReqFechaIns()) || sdf.format(elemento.getReqFechaIns()).equals(sdf.format(engDentBean.elemento.getDenDateTime()))){
                fechaDamagepmala = false;
            }else{
                fechaDamagepmala = true;
            }
        }
    }
    
    public void guardarDisposition(BigInteger id){
        extendtime(); //extiende el tiempo de sesion
		FacesContext context = FacesContext.getCurrentInstance();
        Application application = context.getApplication();
        ELContext elContext = context.getELContext();
        EngReqIngactionBean reqIngactionBean = (EngReqIngactionBean) application.getExpressionFactory()
            .createValueExpression(elContext, "#{engReqIngaction}", EngReqIngactionBean.class).getValue(elContext);
        
        reqIngactionBean.setReqmessageid(id.toString());
        if(reqIngactionBean.edit){
            reqIngactionBean.actualizar();
            getDescStatus();
        }else{
            reqIngactionBean.agregar();
            getDescStatus();
        }
        elemento = engRequestFacade.find(id);        
      
    }

    @Override//metodo generado por implements Serializable
    public void limpiar() {
        extendtime(); //extiende el tiempo de sesion
        this.elemento = new EngRequest();
        elemento.setReqFechaIns(new Date());
        elemento.setUsrCoduser("0");
        edit = false;
		
		FacesContext context = FacesContext.getCurrentInstance();
        Application application = context.getApplication();
        ELContext elContext = context.getELContext();
        EngRequestDimenBean reqdimBean = (EngRequestDimenBean) application.getExpressionFactory()
            .createValueExpression(elContext, "#{reqdimBean}", EngRequestDimenBean.class).getValue(elContext);  
        EngDamageTypeManufactBean engDamageTypeManufactBean = (EngDamageTypeManufactBean) application.getExpressionFactory()
            .createValueExpression(elContext, "#{engDamageTypeManufactBean}", EngDamageTypeManufactBean.class).getValue(elContext);
        EngRequestQuestionBean engRequestQuestionBean = (EngRequestQuestionBean) application.getExpressionFactory()
            .createValueExpression(elContext, "#{engRequestQuestionBean}", EngRequestQuestionBean.class).getValue(elContext);
        EngDentBean engDentBean = (EngDentBean) application.getExpressionFactory()
            .createValueExpression(elContext, "#{engDentBean}", EngDentBean.class).getValue(elContext);
        EngReqTaskJobcardBean engReqTaskJobcardBean = (EngReqTaskJobcardBean) application.getExpressionFactory()
            .createValueExpression(elContext, "#{engReqTaskJobcardBean}", EngReqTaskJobcardBean.class).getValue(elContext);
        
        engReqTaskJobcardBean.listado = new ArrayList<>();
        engReqTaskJobcardBean.elemento = new EngReqTaskJobcard();
        engReqTaskJobcardBean.setDescripcion(null);
        
        reqdimBean.listado = new ArrayList<>();
        reqdimBean.elemento = new EngRequestDimen();
        reqdimBean.setEngEr(new EngRequest());
        engRequestQuestionBean.setEngEr(new EngRequest());
        engDentBean.setEngEr(new EngRequest());
        setPKAffectedPart(null);
//        engDamageDimBean.setPKDamageType(null);
//        engDamageDimBean.setDamageName(null);
        engDamageTypeManufactBean.setPKDamageType(null);
        engDamageTypeManufactBean.setDamageName(null);
        setDamageName(null);
        setExisteAffectedPart(false);
        setExisteDamageType(false);
        elemento.setReqMessageid(null);
        elemento.setAtaNumata(Short.decode("250"));
    }

    @Override//metodo generado por implements Serializable
    public void actualizar() {
        extendtime(); //extiende el tiempo de sesion
        HttpSession session = SessionBean.getSession();
        String user = (String) session.getAttribute(userEsr);
        EngRequest buscarusersol = engRequestFacade.find(elemento.getReqMessageid());
        
        
        elemento.setReqUsrAct(user);
        elemento.setReqDateAct(new Date());
        elemento.setReqTail(elemento.getReqRegistry());
        
        EngAffectedPart aff = AffectedPartFacade.findBySelectA(PKAffectedPart);
        elemento.setReqAfpId(aff);
        
        String usersolicita = buscarusersol.getReqUsersol();
        if (usersolicita != null) {
                    elemento.setReqUsersol(usersolicita);
        }
        if(elemento.getReqMessageid() != null){
        engRequestFacade.edit(elemento);
        }
        esrIngresada = elemento.getReqMessageid().intValue();
        
        
        this.edit = false;
        actualizado = true;

        //se limpia la lista de los documentos que ya han sido agregados
        esrDocumentBean.agregarDocumentos(elemento.getReqMessageid());
         String usuario = (String) session.getAttribute(userEsr);
         if (elemento.getReqCodIngEnc()== null){
             elemento.setReqCodIngEnc("0");
         }
        if(!buscarusersol.getReqCodIngEnc().equals(elemento.getReqCodIngEnc()) && !elemento.getReqCodIngEnc().equals("0") ){
            engRequestFacade.envioCorreoIngenieroAsignado(elemento, usuario);
        }
    }
    
    @Override//metodo generado por implements Serializable
    public void agregar() {
        extendtime(); //extiende el tiempo de sesion
        validarFlota="";
        boolean validarMail=false;
        HttpSession session = SessionBean.getSession();
        String user = (String) session.getAttribute(userEsr);                  
        SimpleDateFormat formatoDeFecha = new SimpleDateFormat("yyyy");
        Calendar fechaac = new GregorianCalendar();
        String actual = formatoDeFecha.format(fechaac.getTime());
        elemento.setReqYear(actual);
        BigDecimal idATA = new BigDecimal(elemento.getAtaNumata());
        corr = seq.maxesrcor(idATA ,actual);
        elemento.setUsrCoduser(user);
        elemento.setReqActive("A");
        elemento.setReqCorr(String.valueOf(corr));
        elemento.setReqUsrIns(user);
        elemento.setReqStatus("O");
        elemento.setReqTail(elemento.getReqRegistry());
        elemento.setReqFechaIns(new Date());
        elemento.setEngCompChk(isCompCheck()==true?"Y":"N");
        
        EngAffectedPart aff = AffectedPartFacade.findBySelectA(PKAffectedPart);
        elemento.setReqAfpId(aff);
        
		FacesContext context = FacesContext.getCurrentInstance();
        Application application = context.getApplication();
        ELContext elContext = context.getELContext();
        EngRequestDimenBean reqdimBean = (EngRequestDimenBean) application.getExpressionFactory()
            .createValueExpression(elContext, "#{reqdimBean}", EngRequestDimenBean.class).getValue(elContext);
        EngRequestQuestionBean engRequestQuestionBean = (EngRequestQuestionBean) application.getExpressionFactory()
            .createValueExpression(elContext, "#{engRequestQuestionBean}", EngRequestQuestionBean.class).getValue(elContext);
        EngDentBean engDentBean = (EngDentBean) application.getExpressionFactory()
            .createValueExpression(elContext, "#{engDentBean}", EngDentBean.class).getValue(elContext);
        EngReqTaskJobcardBean engReqTaskJobcardBean = (EngReqTaskJobcardBean) application.getExpressionFactory()
            .createValueExpression(elContext, "#{engReqTaskJobcardBean}", EngReqTaskJobcardBean.class).getValue(elContext);
        TaskReqCardBean taskReqCardBean = (TaskReqCardBean) application.getExpressionFactory()
                .createValueExpression(elContext, "#{taskReqCardBean}", TaskReqCardBean.class).getValue(elContext);
        RequestTrackingBean trackingesrbean = (RequestTrackingBean) application.getExpressionFactory()
                .createValueExpression(elContext, "#{RequestTracking}", RequestTrackingBean.class).getValue(elContext);
        
         if (engReqTaskJobcardBean.listado.size()>=1)
         {
            this.elemento.setReqJobcard(engReqTaskJobcardBean.listado.get(0).getErtjDescrip());
            engReqTaskJobcardBean.setDescripcion(null);
         }      
         //aca la validacion de 
         for (CoreAircraftType coreAircraftType : coreAircraftTypeBean.listado) {
            if (coreAircraftType.getArctypCode().equals(elemento.getFltCod())){
                validarFlota="existe";
                break;
            }
            validarFlota="no existe";
        }
        // Esta validacion solo aplica para cuando se esta creando una ETR porque no deberia estar asociado
         // a un avion, entonces se a dejado por defecto asociado a un registro aunque no guarda una flota como
         // tal solo se utiliza para seguir la logica del codigo y las tablas anteriormente definidas 

                if(elemento.getFltCod().equals("ETR") || elemento.getFltCod().equals("ECR")){
                     validarFlota="existe";
                }
         
         // *****************************************************
        if (validarFlota.equals("existe")){
            if (elemento.getReqCodIngEnc()== null){
             elemento.setReqCodIngEnc("0");
         }
        engRequestFacade.create(elemento);
        esrIngresada = elemento.getReqMessageid().intValue();
  
        if (elemento.getCompany().equals("AESV"))
        {        
            for (EngReqTaskCard task : taskReqCardBean.listado) {
                if (task.getReqMessageid() == null || task.getReqMessageid().getReqMessageid() == null) {
                    int taskId = seq.idTaskcard();
                    task.setErtIdReg(new BigDecimal(String.valueOf(taskId)));
                    task.setReqMessageid(this.elemento);
                    engReqTaskCardFacade.create(task);         
                   
                    EngReqTaskCardIni oli = new EngReqTaskCardIni();
                    oli.setReqMessageid(task.getReqMessageid());
                    oli.setErtIdReg(task.getErtIdReg());
                    oli.setErtLogpage(task.getErtLogpage());
                    oli.setErtPrincipal(task.getErtPrincipal());
                    oli.setErtTkCorr(task.getErtTkCorr());
                    oli.setErtTkYear(task.getErtTkYear());
                    oli.setIdCard(new BigInteger(task.getIdCard().getIdCard().toString()));
                    engReqTaskCardIniFacade.create(oli);
                 
                    

                }
            }
        }
        else
        {
             for (EngReqTaskJobcard task : engReqTaskJobcardBean.listado) {
                if (task.getReqMessageid() == null || task.getReqMessageid().getReqMessageid() == null) {
                    task.setReqMessageid(this.elemento);
                    engReqTaskJobcardFacade.create(task);  
                   
                     EngReqTaskJobcardIni ertjc = new EngReqTaskJobcardIni();
                     ertjc.setReqMessageid(task.getReqMessageid());
                     ertjc.setErtjIdReg(task.getErtjIdReg());
                     ertjc.setErtjDescrip(task.getErtjDescrip());
                     engReqTaskJobcardIniFacade.create(ertjc);

                 }
            }  
             
        }
        
        //insert damage type by dimension
        for (EngRequestDimen reqdim : reqdimBean.listado) {
            if (reqdim.getRedIdRequest()== null || reqdim.getRedIdRequest().getReqMessageid()== null) {
                reqdim.setRedIdRequest(this.elemento);
                RequestDimenFacade.create(reqdim);                
                        
                        EngRequestDimenIni erdi = new EngRequestDimenIni();
                        erdi.setRedDateAdd(reqdim.getRedDateAdd());
                        erdi.setRedDateDlt(reqdim.getRedDateDlt());
                        erdi.setRedDateUpd(reqdim.getRedDateUpd());
                        erdi.setRedId(reqdim.getRedId());
                        erdi.setRedIdDimension(reqdim.getRedIdDimensionManf().getDtDimByManufId());
                        erdi.setRedIdDimensionManfIni(reqdim.getRedIdDimensionManf());
                        erdi.setRedIdRequest(reqdim.getRedIdRequest());
                        erdi.setRedState(reqdim.getRedState());
                        erdi.setRedUserAdd(reqdim.getRedUserAdd());
                        erdi.setRedUserDlt(reqdim.getRedUserDlt());
                        erdi.setRedUserUpd(reqdim.getRedUserAdd());
                        erdi.setRedValor(reqdim.getRedValor());
                        erdi.setRedValorCheck(reqdim.getRedValorCheck());
                        erdi.setRedMeasure(reqdim.getRedMeasure());
                        erdi.setRedOther(reqdim.getRedOther());
                        engRequestDimenIniFacade.create(erdi);
//                    

            }
        }  
        /*inicio: insert of question*/
    for (EngRequestQuestion reqRequeQuest: engRequestQuestionBean.listado) {
            if (reqRequeQuest.getReqMessageid()== null || reqRequeQuest.getReqMessageid().getReqMessageid()== null) {
                reqRequeQuest.setReqMessageid(this.elemento);
                engRequestQuestionFacade.create(reqRequeQuest); 
                   /*inicio de: inicial question*/
                    EngRequestQuestionIni erqi = new EngRequestQuestionIni();
                    erqi.setReqValue(reqRequeQuest.getReqValue());
                    erqi.setReqUserIns(reqRequeQuest.getReqUserIns());
                    erqi.setReqDateIns(reqRequeQuest.getReqDateIns());
                    erqi.setReqUserUpd(reqRequeQuest.getReqUserUpd());
                    erqi.setReqDateUpd(reqRequeQuest.getReqDateUpd());
                    erqi.setDxqId(reqRequeQuest.getDxqId());
                    erqi.setReqMessageid(reqRequeQuest.getReqMessageid());
                
                    engRequestQuestionIniFacade.create(erqi);
                   /*fin de: inicial question*/
                
            }
        }
        /*fin: insert of question*/
    /*inicio: insert of dent*/   
    for (EngDent reqDent: engDentBean.listado) {
            if (reqDent.getReqMessageid()== null || reqDent.getReqMessageid().getReqMessageid()== null) {
                reqDent.setReqMessageid(this.elemento);
                engDentFacade.create(reqDent);  
                    /*inicio de: inicial question*/
                EngDentIni edi = new EngDentIni();
                edi.setDenDiscrepancy(reqDent.getDenDiscrepancy());
                edi.setDenRefEvaluated(reqDent.getDenRefEvaluated());
                edi.setDenAttachments(reqDent.getDenAttachments());
                edi.setDenReqAct(reqDent.getDenReqAct());
                edi.setDenDateTime(reqDent.getDenDateTime());
                edi.setDenTemplateData(reqDent.getDenTemplateData());
                edi.setDenAircraftGround(reqDent.getDenAircraftGround());
                edi.setDenCritical(reqDent.getDenCritical());
                edi.setDatId(reqDent.getDatId());
                edi.setReqMessageid(reqDent.getReqMessageid());
                engDentIniFacade.create(edi);
                    /*fin de: inicial question*/
            }
        }
        /*fin: insert of dent*/

        trackingesrbean.elemento.setReqMessageid(elemento.getReqMessageid());

        esrDocumentBean.agregarDocumentos(elemento.getReqMessageid());
        
        //agregar a otra tabla lo insertado
         try {
           engRequestInicial = new EngRequestInicial();
           engRequestInicial.setReqMessageid(new BigDecimal(elemento.getReqMessageid()));
           engRequestInicial.setReqModel(elemento.getReqModel());
           engRequestInicial.setReqIssuedate(elemento.getReqIssuedate());
           engRequestInicial.setAtaNumata(elemento.getAtaNumata());
           engRequestInicial.setReqDuedate(elemento.getReqDuedate());
           engRequestInicial.setReqResponsedt(elemento.getReqResponsedt());
           engRequestInicial.setReqRegistry(elemento.getReqRegistry());
           engRequestInicial.setUsrCoduser(elemento.getUsrCoduser());
           engRequestInicial.setReqCorr(elemento.getReqCorr());
           engRequestInicial.setReqRevnr(elemento.getReqRevnr());
           engRequestInicial.setReqComponent(elemento.getReqComponent());
           engRequestInicial.setReqPn(elemento.getReqPn());
           engRequestInicial.setReqSn(elemento.getReqSn());
           engRequestInicial.setReqPriority(elemento.getReqPriority());
           engRequestInicial.setReqCausedamage(elemento.getReqCausedamage());
           engRequestInicial.setReqExtdamage(elemento.getReqExtdamage());
           engRequestInicial.setReqReqdesdmg(elemento.getReqReqdesdmg());
           engRequestInicial.setReqSketch(elemento.getReqSketch());
           engRequestInicial.setReqNdtreport(elemento.getReqNdtreport());
           engRequestInicial.setReqNdtresponse(elemento.getReqNdtresponse());
           engRequestInicial.setReqRepairarea(elemento.getReqRepairarea());
           engRequestInicial.setReqDamfound(elemento.getReqDamfound());
           engRequestInicial.setReqStataircraft(elemento.getReqStataircraft());
           engRequestInicial.setReqUsersol(elemento.getReqUsersol());
           engRequestInicial.setReqUserappr(elemento.getReqUserappr());
           engRequestInicial.setReqRecivedate(elemento.getReqRecivedate());
           engRequestInicial.setReqExtSol(elemento.getReqExtSol());
           engRequestInicial.setReqStatus(elemento.getReqStatus());
           engRequestInicial.setChkCheckid(elemento.getChkCheckid());
           engRequestInicial.setReqYear(elemento.getReqYear());
           engRequestInicial.setReqOtherref(elemento.getReqOtherref());
           engRequestInicial.setReqChkRef(elemento.getReqChkRef());
           engRequestInicial.setReqChkOtheref(elemento.getReqChkOtheref());
           engRequestInicial.setReqActive(elemento.getReqActive());
           engRequestInicial.setReqClasRepair(elemento.getReqClasRepair());
           engRequestInicial.setReqCriticalEsr(elemento.getReqCriticalEsr());
           engRequestInicial.setReqEngManHrs(elemento.getReqEngManHrs());
           engRequestInicial.setReqOtherCost(elemento.getReqOtherCost());
           engRequestInicial.setReqDescCost(elemento.getReqDescCost());
           engRequestInicial.setReqStatusEng(elemento.getReqStatusEng());
           engRequestInicial.setReqAdjCodigo(elemento.getReqAdjCodigo());
           engRequestInicial.setReqCodIngEnc(elemento.getReqCodIngEnc());
           engRequestInicial.setReqUsrIns(elemento.getReqUsrIns());
           engRequestInicial.setReqFechaIns(elemento.getReqFechaIns());
           engRequestInicial.setReqUsrAct(elemento.getReqUsrAct());
           engRequestInicial.setReqDateAct(elemento.getReqDateAct());
           engRequestInicial.setReqReqEnv(elemento.getReqReqEnv());
           engRequestInicial.setReqDuedate(elemento.getReqDuedate());
           engRequestInicial.setReqFlagTracking(elemento.getReqFlagTracking());
           engRequestInicial.setReqTail(elemento.getReqTail());
           engRequestInicial.setReqCustomer(elemento.getReqCustomer());
           engRequestInicial.setFltCod(elemento.getFltCod());
           engRequestInicial.setLogpage(elemento.getLogpage());
           engRequestInicial.setYearlogpage(elemento.getYearlogpage());
           engRequestInicial.setCompany(elemento.getCompany());
           engRequestInicial.setNumerologpage(elemento.getNumerologpage());           
           engRequestInicial.setReqJobcard(elemento.getReqJobcard());
           engRequestInicial.setReqAfpId(elemento.getReqAfpId());
           engRequestInicial.setReqDiscreporidoc(elemento.getReqDiscreporidoc());
           engRequestInicial.setReqDimDesc(elemento.getReqDimDesc());
           engRequestInicial.setReqRetDescription(elemento.getReqRetDescription());
           engRequestInicial.setReqProbdesc(elemento.getReqProbdesc());
           engRequestInicial.setReqClasRepair2(elemento.getReqClasRepair2());
           engRequestInicial.setReqComplete(elemento.getReqComplete());
           engRequestInicial.setReqReason(elemento.getReqReason());
           engRequestInicial.setReqCritical(elemento.getReqCritical());
           engRequestInicial.setReqAog(elemento.getReqAog());
           engRequestInicial.setEngCompChk(elemento.getEngCompChk());  
           engRequestInicial.setEngCompPn(elemento.getEngCompPn());  
           engRequestInicial.setEngDiscreReq(elemento.getEngDiscreReq());  
           engRequestInicial.setEngReferVal(elemento.getEngReferVal());  
           engRequestInicial.setEngDamageType(elemento.getEngDamageType());
           engRequestInicial.setEngRequestOther(elemento.getEngRequestOther());
           engRequestInicialFacade.create(engRequestInicial);
         }
          catch (Exception e) {
            Logger.getLogger(EsrBean.class.getName()).log(Level.SEVERE, null, e);
        }
         if (contcheckEmail.findbywo(elemento.getChkCheckid()).size()>0){
             validarMail=true;
         }
        //ENVIAR CORREO A INGENIERO ASIGNADO
         String usuario = (String) session.getAttribute(userEsr);
         if(elemento.getReqCodIngEnc()==null){
             elemento.setReqCodIngEnc("0");
         }
            if (!elemento.getReqCodIngEnc().equals("0") && validarMail){
                engRequestFacade.envioCorreoIngenieroAsignado(elemento, usuario);
            }
         
        //ENVIO CORREO
        if(validarMail){
            engRequestFacade.executeEnvioCorreoEsr(elemento, usuario);
        }
        
        
        edit = false;
        }else{
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Flota erronea"));
        }
    }
    
    public void esrInicial(EngRequest idMessage){
        extendtime(); //extiende el tiempo de sesion       
        engRequestInicial=engRequestInicialFacade.find(new BigDecimal(idMessage.getReqMessageid()));
        listaEngDamageType = new ArrayList<>();
        listaEngDentIni = new ArrayList<>();        
        listaEngRequestDimenIniLocal = new ArrayList<>();
        listaEngRequestDimenIniDimCheck = new ArrayList<>();
        listaEngRequestDimenIni = new ArrayList<>();
        listaEngRequestDimenIniDimBlend_Dent = new ArrayList<>();
        listaEngRequestDimenIniDimNearby = new ArrayList<>();
        listaEngRequestQuestionIni = new ArrayList<>();
        listaEngDentIni = engDentIniFacade.findRequestDentIni(idMessage);
        for (EngDentIni lisDat : listaEngDentIni) {
            listaEngDamageType.add(lisDat.getDatId());             
        }
        
        listaEngRequestDimenIniLocal = engRequestDimenIniFacade.findBySelectDimenLocal(idMessage.getReqMessageid());
        listaEngRequestDimenIniDimCheck =engRequestDimenIniFacade.findBySelectDimenCheck(idMessage.getReqMessageid());
        listaEngRequestDimenIni =engRequestDimenIniFacade.findBySelectDimen(idMessage.getReqMessageid());
        listaEngRequestDimenIniDimBlend_Dent =engRequestDimenIniFacade.findBySelectDimenBlend_Dent(idMessage.getReqMessageid());
        listaEngRequestDimenIniDimNearby  =engRequestDimenIniFacade.findBySelectDimenNearby(idMessage.getReqMessageid());
        
        listaEngRequestQuestionIni=engRequestQuestionIniFacade.findDamageQuestionIni(idMessage);
    }
    
    public void limpiarformEsr() {
        extendtime(); //extiende el tiempo de sesion
        validarFlota="LM";
        FacesContext contexteve = FacesContext.getCurrentInstance();
        UIViewRoot root = contexteve.getViewRoot();
        UIInput reqcom = (UIInput) root.findComponent("inputForm70:reqcom");
        UIInput workOrderM = (UIInput) root.findComponent("inputForm70:workOrderM");
        UIInput reqmodel = (UIInput) root.findComponent("inputForm70:reqmodel");
        UIInput logPage = (UIInput) root.findComponent("inputForm70:log_Page");
        UIInput ata = (UIInput) root.findComponent("inputForm70:ATA");
        UIInput responsedate = (UIInput) root.findComponent("inputForm70:responsedate");
        UIInput partNumberM = (UIInput) root.findComponent("inputForm70:partNumberM");
        UIInput serialNumberM = (UIInput) root.findComponent("inputForm70:serialNumberM");
        UIInput slcReqM = (UIInput) root.findComponent("inputForm70:slcReqM");
        UIInput telM = (UIInput) root.findComponent("inputForm70:telM");
        UIInput componentmireM = (UIInput) root.findComponent("inputForm70:componentmireM");
        UIInput problemDescriptionM = (UIInput) root.findComponent("inputForm70:problemDescriptionM");
        UIInput eoOwner = (UIInput) root.findComponent("inputForm70:eoOwner");
        UIInput fechaVencM = (UIInput) root.findComponent("inputForm70:fechaVencM");
        UIInput clasificacionRepM = (UIInput) root.findComponent("inputForm70:clasificacionRepM");
        UIInput clasificacionRepM2 = (UIInput) root.findComponent("inputForm70:clasificacionRepM2");
        UIInput jobCardCorr = (UIInput) root.findComponent("inputForm70:jobCard");
        UIInput reqDamageType = (UIInput) root.findComponent("inputForm70:reqDamageType");
        UIInput reqMSN = (UIInput) root.findComponent("inputForm70:MSN");
        UIInput reqcyclese = (UIInput) root.findComponent("inputForm70:cycles");       
        UIInput reqcustomer = (UIInput) root.findComponent("inputForm70:reqcustomer");
        UIInput tailPlaneM = (UIInput) root.findComponent("inputForm70:tailPlaneM");
        reqcom.resetValue();
        workOrderM.resetValue();
        reqmodel.resetValue();
        logPage.resetValue();
        ata.resetValue();
        responsedate.resetValue();
        partNumberM.resetValue();
        serialNumberM.resetValue();
        slcReqM.resetValue();
        telM.resetValue();
        componentmireM.resetValue();
        problemDescriptionM.resetValue();
        eoOwner.resetValue();
        fechaVencM.resetValue();
        clasificacionRepM.resetValue();
        clasificacionRepM2.resetValue();
        jobCardCorr.resetValue();
        reqDamageType.resetValue();
        reqMSN.resetValue();
        reqcyclese.resetValue();
        reqcustomer.resetValue();
        tailPlaneM.resetValue();
    }

    public void deleteDisposition(String idDispo){
        extendtime(); //extiende el tiempo de sesion
		
		FacesContext context = FacesContext.getCurrentInstance();
        Application application = context.getApplication();
        ELContext elContext = context.getELContext();
        EngReqIngactionBean reqIngactionBean = (EngReqIngactionBean) application.getExpressionFactory()
            .createValueExpression(elContext, "#{engReqIngaction}", EngReqIngactionBean.class).getValue(elContext);
        
        reqIngactionBean.delete(idDispo);
        EngRequest ele = engRequestFacade.find(reqIngactionBean.getDeleteDispo());
        if(!reqIngactionBean.listado2.isEmpty()){
            EngReqStatus estatus = engReqStatusFacade.findById(reqIngactionBean.listado2.get(0).getEinStatus());
            ele.setReqStatus(estatus.getEstCode());
        }else{
            ele.setReqStatus("O");
        }
        engRequestFacade.edit(ele);
    }
    
    public boolean existCustomer (List<CustomerByOpco> list, String customer){
        for(CustomerByOpco cust : list){
            if(cust.getCustomer().equals(customer)){
                return true;
            }
        }
        return false;
    } 
    
    public String infoDash(String companyDash) {
        extendtime(); //extiende el tiempo de sesion
												 
        //companyBean.menuDash();
						   
        HttpSession session = SessionBean.getSession();
        session.setAttribute("companySelected", companyDash);
        String mensaje = "";
        validarCoDash="VALIDAR";
        String  respuesta;
        dashbordEngPojo = new DashbordEngPojo();
        requestDashWS = new RequestDashWS();
        jsonDashENG = new JsonDashENG();
        companyCia=companyDash;
        incialDashbordPojo = new IncialDasbordPojo();
        aircraftDashPojo = new AircraftDashPojo();
        listaAviones = new ArrayList<>();
        listaAvionesEnRampa = new ArrayList<>();
        customersByOpco = new ArrayList<>();
       
        try {
            
            jsonDashENG.setApp("EN");
            jsonDashENG.setCompany(companyDash);
            requestDashWS.setRequest(jsonDashENG);
            
            gson = new Gson();
            httpClient = new DefaultHttpClient();
            POSTURL = prcDetparamFacade.findByLiksWeb("DASH").getValor();
            post = new HttpPost(POSTURL);       
            StringEntity postingString = new StringEntity(gson.toJson(requestDashWS));//gson.tojson() converts your pojo to json
            post.setEntity(postingString);
            post.setHeader(CONTTYPE, JSONTYPE);
            response = httpClient.execute(post);
            try (BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), UTF))) {
                respuesta = br.readLine();
                JSONObject json = (JSONObject) new JSONParser().parse(respuesta);
                incialDashbordPojo = gson.fromJson(json.toJSONString(), IncialDasbordPojo.class);
                listaHangares = incialDashbordPojo.getResponse().getDashboardENG();
                if (listaHangares!=null){
                    for (DashbordEngPojo lis : listaHangares) {
                        if (lis.getAircraft().size()>=1){
                            validarCoDash="EXISTE";
                        }
                    }
                }
                if (validarCoDash.equals("EXISTE")){
                 for (DashbordEngPojo lis : listaHangares) {
                   if (lis.getAircraft().size()>=1){
                       for (int factor = 1; factor <= lis.getAircraft().size(); factor ++){
                            listaAviones.add(lis.getAircraft().get(factor-1));
                       }                  
                        
                    }
                   if(lis.getAircraft().size() != Integer.parseInt(lis.getHrgMaxH())){
                        for (int factor = (lis.getAircraft().size()+1); factor <= Integer.parseInt(lis.getHrgMaxH()); factor ++){
                            AircraftDashPojo oli = new  AircraftDashPojo();
                            oli.setAirCraft("N / A");
                            oli.setHangar(lis.getHangarCode());
                            oli.setQtyESRA("0");
                            oli.setQtyESRT("0");
                            oli.setColor("sincolor");
                            listaAviones.add(oli);
                       }
                   }
                }
                for (DashbordEngPojo lis : listaHangares) {
                    
                   if (lis.getRampa().size()>=1){
                       for (int factor = 1; factor <= lis.getRampa().size(); factor ++){
                            listaAvionesEnRampa.add(lis.getRampa().get(factor-1));
                            CustomerByOpco customerByOpco = new CustomerByOpco();
                            customerByOpco.setCompany(companyCia);
                            customerByOpco.setColor(lis.getRampa().get(factor-1).getColor());
                            customerByOpco.setCustomer(lis.getRampa().get(factor-1).getCustomer());
                            if(!existCustomer(customersByOpco, customerByOpco.getCustomer())){
                                customersByOpco.add(customerByOpco);
                            }                            
                       }                  
                        
                    }
                   if((lis.getRampa().size()) != Integer.parseInt(lis.getHrgmaxR())){
                        for (int factor = (lis.getRampa().size()); factor < Integer.parseInt(lis.getHrgmaxR()); factor ++){
                            RampaPojo otherOli = new  RampaPojo();
                            otherOli.setAirCraft("N / A");
                            otherOli.setHangar(lis.getRampaCode());
                            otherOli.setQtyESRA("0");
                            otherOli.setQtyESRT("0");
                            otherOli.setColor("sincolor");
                            listaAvionesEnRampa.add(otherOli);
                       }
                   }
                }
            } else{
                validarCoDash="ESR";
            }    
            } catch (Exception e) {
                Logger.getLogger(EsrBean.class.getName()).log(Level.SEVERE, null, e);
            }

        } catch (Exception e) {
            Logger.getLogger(EsrBean.class.getName()).log(Level.SEVERE, null, e);
        }
        
        //eliminamos repetidos de la lista de aviones
        //en el checkId puede venir null, esos no los tomaremos en cuenta
        //vamos a recorrer la lista original, y por cada elemento lo comparamos
        //con cada elemento de una nueva lista..
        //condiciones:
        
        List<RampaPojo> listaRampaLimpia = new ArrayList<>();
        for(RampaPojo rampa:listaAvionesEnRampa){
            //si es null, se agrega sin comprobar nada
            if(rampa.getAirCraft()==null){
                listaRampaLimpia.add(rampa);
            }else{
                //recorrer para saber si existe
                boolean existeR = false;
                ListIterator<RampaPojo> rampaIterator = listaRampaLimpia.listIterator();
                while(rampaIterator.hasNext()){
                    RampaPojo rampaD = rampaIterator.next();
                    if(rampa.getAirCraft().equals(rampaD.getAirCraft())){
                        existeR=true;
                        //validacion del checkId
                        int rampaCheckId = Integer.parseInt(rampa.getCheckID()==null?"0":rampa.getCheckID());
                        int rampaDCheckId = Integer.parseInt(rampaD.getCheckID()==null?"0":rampaD.getCheckID());
                        if(rampaCheckId<rampaDCheckId){
                            rampaIterator.remove();
                            rampaIterator.add(rampa);
                        }
                    }
                }
                if(existeR){
                    //si ya existe, pues se agrega como un null
                    RampaPojo otherOli = new  RampaPojo();
                    otherOli.setAirCraft("N / A");
                    otherOli.setHangar(rampa.getHangar());
                    otherOli.setQtyESRA("0");
                    otherOli.setQtyESRT("0");
                    otherOli.setColor("sincolor");
                    listaRampaLimpia.add(otherOli);
                }else{
                    listaRampaLimpia.add(rampa);
                }
            }
        }
        
        listaAvionesEnRampa = new ArrayList<>();
        listaAvionesEnRampa = listaRampaLimpia;
        
        List<AircraftDashPojo> listaLimpia = new ArrayList<>();
        for(AircraftDashPojo avion:listaAviones){
            // si es null, se agrega sin comprobar nada
            if(avion.getAirCraft()==null){
                listaLimpia.add(avion);
            }else{
                //recorrer para saber si existe
                boolean existe = false;
                ListIterator<AircraftDashPojo> avionesIterator = listaLimpia.listIterator();
                while(avionesIterator.hasNext()){
                    AircraftDashPojo avionD = avionesIterator.next();
                    if(avion.getAirCraft().equals(avionD.getAirCraft())){
                        existe=true;
                        //validacion del checkId
                        int avionCheckId= Integer.parseInt(avion.getCheckID()==null?"0":avion.getCheckID());
                        int avionDCheckId = Integer.parseInt(avionD.getCheckID()==null?"0":avionD.getCheckID());
                        if(avionCheckId<avionDCheckId){
                            avionesIterator.remove();
                            avionesIterator.add(avion);
                        }                        
                    }
                }                                
                if(existe){
                    // si ya existe, pues se agrega como un null.
                    AircraftDashPojo oli = new  AircraftDashPojo();
                    oli.setAirCraft("N / A");
                    oli.setHangar(avion.getHangar());
                    oli.setQtyESRA("0");
                    oli.setQtyESRT("0");
                    oli.setColor("sincolor");
                    listaLimpia.add(oli);
                }else{
                    // si no existe, se agrega despues de comparar todos los elementos
                    listaLimpia.add(avion);
                }
            }            
        }
        
        listaAviones = new ArrayList<>();
        listaAviones= listaLimpia;
        return mensaje;
    }

    
    @Override//metodo generado por implements Serializable
    void eliminar(EngRequest elemento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override//metodo generado por implements Serializable
    EngRequest nuevoElemento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Boolean getActualizado() {//get y set de variable
        return actualizado;
    }

    public void setActualizado(Boolean actualizado) {//get y set de variable
        this.actualizado = actualizado;
    }

    public EngRequestFacade getEngRequestFacade() {//get y set de variable
        return engRequestFacade;
    }

    public void setEngRequestFacade(EngRequestFacade engRequestFacade) {//get y set de variable
        this.engRequestFacade = engRequestFacade;
    }

    public Sequences getSeq() {//get y set de variable
        return seq;
    }

    public void setSeq(Sequences seq) {//get y set de variable
        this.seq = seq;
    }

    public EsrDocumentBean getEsrDocumentBean() {//get y set de variable
        return esrDocumentBean;
    }

    public void setEsrDocumentBean(EsrDocumentBean esrDocumentBean) {//get y set de variable
        this.esrDocumentBean = esrDocumentBean;
    }

    public String getUserSol() {//get y set de variable
        return userSol;
    }

    public void setUserSol(String userSol) {//get y set de variable
        this.userSol = userSol;
    }

    public String getCorr() {//get y set de variable
        return corr;
    }

    public void setCorr(String corr) {//get y set de variable
        this.corr = corr;
    }
    
    public BigInteger getUs() {//get y set de variable
        return us;
    }

    public void setUs(BigInteger us) {//get y set de variable
        this.us = us;
    }   

    public EngReqStatusFacade getEngReqStatusFacade() {//get y set de variable
        return engReqStatusFacade;
    }

    public void setEngReqStatusFacade(EngReqStatusFacade engReqStatusFacade) {//get y set de variable
        this.engReqStatusFacade = engReqStatusFacade;
    }

    public String getDescStatus() {//get y set de variable
        extendtime(); //extiende el tiempo de sesion
        try {
            if (elemento.getReqMessageid() != null) {
                elemento = engRequestFacade.find(elemento.getReqMessageid());
                EngReqStatus w = engReqStatusFacade.findByCode(elemento.getReqStatus());
                this.descStatus = w.getEstDesc();
            } else {
                this.descStatus = "-";
            }

        } catch (Exception e) {
            Logger.getLogger(EsrBean.class.getName()).log(Level.SEVERE, null, e);

            this.descStatus = "-";
        }
        return descStatus;
    }    
    
    public void setDescStatus(String descStatus) {//get y set de variable
        this.descStatus = descStatus;
    }

    public String getUserEsr() {//get y set de variable
        return userEsr;
    }

    public void setUserEsr(String userEsr) {//get y set de variable
        this.userEsr = userEsr;
    }

    public boolean isFechaInsmala() {//get y set de variable
        return fechaInsmala;
    }

    public void setFechaInsmala(boolean fechaInsmala) {//get y set de variable
        this.fechaInsmala = fechaInsmala;
    }

    public boolean isFechaExpmala() {//get y set de variable
        return fechaExpmala;
    }

    public void setFechaExpmala(boolean fechaExpmala) {//get y set de variable
        this.fechaExpmala = fechaExpmala;
    }

    public int getEsrIngresada() {//get y set de variable
        return esrIngresada;
    }

    public void setEsrIngresada(int esrIngresada) {//get y set de variable
        this.esrIngresada = esrIngresada;
    }

    public EngRequestInicial getEngRequestInicial() {//get y set de variable
        return engRequestInicial;
    }

    public void setEngRequestInicial(EngRequestInicial engRequestInicial) {//get y set de variable
        this.engRequestInicial = engRequestInicial;
    }

    public String getCompanyCia() {//get y set de variable
        return companyCia;
    }

    public void setCompanyCia(String companyCia) {//get y set de variable
        this.companyCia = companyCia;
    }

    public EngReqTaskCardFacade getEngReqTaskCardFacade() {//get y set de variable
        return engReqTaskCardFacade;
    }

    public void setEngReqTaskCardFacade(EngReqTaskCardFacade engReqTaskCardFacade) {//get y set de variable
        this.engReqTaskCardFacade = engReqTaskCardFacade;
    }

    public EngRequestInicialFacade getEngRequestInicialFacade() {//get y set de variable
        return engRequestInicialFacade;
    }

    public void setEngRequestInicialFacade(EngRequestInicialFacade engRequestInicialFacade) {//get y set de variable
        this.engRequestInicialFacade = engRequestInicialFacade;
    }

    public EngReqTaskJobcardFacade getEngReqTaskJobcardFacade() {//get y set de variable
        return engReqTaskJobcardFacade;
    }

    public void setEngReqTaskJobcardFacade(EngReqTaskJobcardFacade engReqTaskJobcardFacade) {//get y set de variable
        this.engReqTaskJobcardFacade = engReqTaskJobcardFacade;
    }

    public List<DashbordEngPojo> getListaHangares() {//get y set de variable
        return listaHangares;
    }

    public void setListaHangares(List<DashbordEngPojo> listaHangares) {//get y set de variable
        this.listaHangares = listaHangares;
    }
    
    public String getIdHangar() {//get y set de variable
        return idHangar;
    }

    public void setIdHangar(String idHangar) {//get y set de variable
        this.idHangar = idHangar;
    }

    public PojoAviones getReqPojoAviones() {//get y set de variable
        return reqPojoAviones;
    }

    public void setReqPojoAviones(PojoAviones reqPojoAviones) {//get y set de variable
        this.reqPojoAviones = reqPojoAviones;
    }

    public IncialDasbordPojo getIncialDashbordPojo() {//get y set de variable
        return incialDashbordPojo;
    }

    public void setIncialDashbordPojo(IncialDasbordPojo incialDashbordPojo) {//get y set de variable
        this.incialDashbordPojo = incialDashbordPojo;
    }

    public DashbordEngPojo getDashbordEngPojo() {//get y set de variable
        return dashbordEngPojo;
    }

    public void setDashbordEngPojo(DashbordEngPojo dashbordEngPojo) {//get y set de variable
        this.dashbordEngPojo = dashbordEngPojo;
    }

    public AircraftDashPojo getAircraftDashPojo() {//get y set de variable
        return aircraftDashPojo;
    }

    public void setAircraftDashPojo(AircraftDashPojo aircraftDashPojo) {//get y set de variable
        this.aircraftDashPojo = aircraftDashPojo;
    }

    public List<AircraftDashPojo> getListaAviones() {//get y set de variable
        return listaAviones;
    }

    /**
     * @return the PKAffectedPart
     */
    public String getPKAffectedPart() {//get y set de variable
        return PKAffectedPart;
    }

    /**
     * @param PKAffectedPart the PKAffectedPart to set
     */
    public void setPKAffectedPart(String PKAffectedPart) {//get y set de variable
        this.PKAffectedPart = PKAffectedPart;
    }
    

        /**
     * @return the existeAffectedPart
     */
    public boolean isExisteAffectedPart() {//get y set de variable
        return existeAffectedPart;
    }

    /**
     * @param existeAffectedPart the existeAffectedPart to set
     */
    public void setExisteAffectedPart(boolean existeAffectedPart) {//get y set de variable
        this.existeAffectedPart = existeAffectedPart;
    }

    /**
     * @return the existeDamageType
     */
    public boolean isExisteDamageType() {//get y set de variable
        return existeDamageType;
    }

    /**
     * @param existeDamageType the existeDamageType to set
     */
    public void setExisteDamageType(boolean existeDamageType) {//get y set de variable
        this.existeDamageType = existeDamageType;
    }
    
    public void setListaAviones(List<AircraftDashPojo> listaAviones) {//get y set de variable
        this.listaAviones = listaAviones;
    }
    /**
     * @return the affmalo
     */
    public String getAffmalo() {//get y set de variable
        return affmalo;
    }

    public RampaPojo getRampaPojo() {//get y set de variable
        return rampaPojo;
    }
    /**
     * @param affmalo the affmalo to set
     */
    public void setAffmalo(String affmalo) {//get y set de variable
        this.affmalo = affmalo;
    }

    public void setRampaPojo(RampaPojo rampaPojo) {//get y set de variable
        this.rampaPojo = rampaPojo;
    }

    public List<RampaPojo> getListaAvionesEnRampa() {//get y set de variable
        return listaAvionesEnRampa;
    }

    public void setListaAvionesEnRampa(List<RampaPojo> listaAvionesEnRampa) {//get y set de variable
        this.listaAvionesEnRampa = listaAvionesEnRampa;
    }

    public String getWorkOrderJob() {//get y set de variable
        return workOrderJob;
    }

    public void setWorkOrderJob(String workOrderJob) {//get y set de variable
        this.workOrderJob = workOrderJob;
    }
    
    /**
     * @return the dammalo
     */
    public String getDammalo() {//get y set de variable
        return dammalo;
    }

    /**
     * @param dammalo the dammalo to set
     */
    public void setDammalo(String dammalo) {//get y set de variable
        this.dammalo = dammalo;
    }

    public String getDamageName() {//get y set de variable
        return damageName;
    }

    public void setDamageName(String damageName) {//get y set de variable
        this.damageName = damageName;
    }   

    public String getValidarCoDash() {//get y set de variable
        return validarCoDash;
    }

    public void setValidarCoDash(String validarCoDash) {//get y set de variable
        this.validarCoDash = validarCoDash;
    }

    public CoreAircraftTypeBean getCoreAircraftTypeBean() {//get y set de variable
        return coreAircraftTypeBean;
    }

    public void setCoreAircraftTypeBean(CoreAircraftTypeBean coreAircraftTypeBean) {//get y set de variable
        this.coreAircraftTypeBean = coreAircraftTypeBean;
    }

    public String getValidarFlota() {//get y set de variable
        return validarFlota;
    }

    public void setValidarFlota(String validarFlota) {//get y set de variable
        this.validarFlota = validarFlota;
    }

   public EngRequestDimenManufFacade getEngRequestDimenManufFacade() {
        return engRequestDimenManufFacade;
    }

    public void setEngRequestDimenManufFacade(EngRequestDimenManufFacade engRequestDimenManufFacade) {
        this.engRequestDimenManufFacade = engRequestDimenManufFacade;
    }

    public List<EngDentIni> getListaEngDentIni() {//get y set de variable
        return listaEngDentIni;
    }

    public void setListaEngDentIni(List<EngDentIni> listaEngDentIni) {//get y set de variable
        this.listaEngDentIni = listaEngDentIni;
    }

    public List<EngDamageType> getListaEngDamageType() {//get y set de variable
        return listaEngDamageType;
    }

    public void setListaEngDamageType(List<EngDamageType> listaEngDamageType) {//get y set de variable
        this.listaEngDamageType = listaEngDamageType;
    }

    public List<EngRequestDimenIni> getListaEngRequestDimenIni() {//get y set de variable
        return listaEngRequestDimenIni;
    }

    public void setListaEngRequestDimenIni(List<EngRequestDimenIni> listaEngRequestDimenIni) {//get y set de variable
        this.listaEngRequestDimenIni = listaEngRequestDimenIni;
    }

    public List<EngRequestQuestionIni> getListaEngRequestQuestionIni() {//get y set de variable
        return listaEngRequestQuestionIni;
    }

    public void setListaEngRequestQuestionIni(List<EngRequestQuestionIni> listaEngRequestQuestionIni) {//get y set de variable
        this.listaEngRequestQuestionIni = listaEngRequestQuestionIni;
    }

    public boolean isFechaDamagepmala() {//get y set de variable
        return fechaDamagepmala;
    }

    public void setFechaDamagepmala(boolean fechaDamagepmala) {//get y set de variable
        this.fechaDamagepmala = fechaDamagepmala;
    }
    public boolean isCompCheck() {
        return compCheck;
    }

    public void setCompCheck(boolean compCheck) {
        this.compCheck = compCheck;
    }

    public List<EngRequestDimenIni> getListaEngRequestDimenIniLocal() {
        return listaEngRequestDimenIniLocal;
    }

    public void setListaEngRequestDimenIniLocal(List<EngRequestDimenIni> listaEngRequestDimenIniLocal) {
        this.listaEngRequestDimenIniLocal = listaEngRequestDimenIniLocal;
    }

    public List<EngRequestDimenIni> getListaEngRequestDimenIniDimCheck() {
        return listaEngRequestDimenIniDimCheck;
    }

    public void setListaEngRequestDimenIniDimCheck(List<EngRequestDimenIni> listaEngRequestDimenIniDimCheck) {
        this.listaEngRequestDimenIniDimCheck = listaEngRequestDimenIniDimCheck;
    }

    public List<EngRequestDimenIni> getListaEngRequestDimenIniDimBlend_Dent() {
        return listaEngRequestDimenIniDimBlend_Dent;
    }

    public void setListaEngRequestDimenIniDimBlend_Dent(List<EngRequestDimenIni> listaEngRequestDimenIniDimBlend_Dent) {
        this.listaEngRequestDimenIniDimBlend_Dent = listaEngRequestDimenIniDimBlend_Dent;
    }

    public List<EngRequestDimenIni> getListaEngRequestDimenIniDimNearby() {
        return listaEngRequestDimenIniDimNearby;
    }

    public void setListaEngRequestDimenIniDimNearby(List<EngRequestDimenIni> listaEngRequestDimenIniDimNearby) {
        this.listaEngRequestDimenIniDimNearby = listaEngRequestDimenIniDimNearby;
    }

    public List<CustomerByOpco> getCustomersByOpco() {
        return customersByOpco;
    }

    public void setCustomersByOpco(List<CustomerByOpco> customersByOpco) {
        this.customersByOpco = customersByOpco;
    }

}
