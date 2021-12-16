
 // To change this license header, choose License Headers in Project Properties.
 // To change this template file, choose Tools | Templates
 // and open the template in the editor.
 
package com.aecas.managed;// paquete manage

import com.aees.languageSwitcher.LanguageSwitcher;// importacion de clase
import com.aees.session.SessionBean;// importacion de clase
import com.aeroman.aees.entities.grant.ContCheck;// importacion de clase
import com.aeroman.aees.entities.grant.SgrCia;
import com.aeroman.aees.entities.grant.SgrUser;
import com.aeroman.aees.facades.EngDamageTypeDimManufactFacade;
import com.aeroman.aees.facades.grant.ContCheckFacade;// importacion de clase
import com.aeroman.aees.facades.grant.SgrCiaFacade;
import com.aeroman.aees.facades.grant.SgrUserFacades;
import java.io.Serializable;// libreria seralizable
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;// libreria ArrayList
import java.util.Calendar;// libreria Calendar
import java.util.List;// libreria List
import java.util.Map;// libreria Map
import java.util.logging.Level;// libreria Level
import java.util.logging.Logger;// libreria Logger
import javax.annotation.PostConstruct;// libreria PostConstruct
import javax.ejb.EJB;// libreria EJB
import javax.el.ELContext;
import javax.faces.application.Application;
import javax.faces.bean.ManagedBean;// inportacion de clase
import javax.faces.bean.ManagedProperty;// libreria ManagedProperty
import javax.faces.bean.SessionScoped;// libreria SessionScoped
import javax.faces.component.UIInput;// libreria UIInput
import javax.faces.component.UIViewRoot;// libreria UIViewRoot
import javax.faces.context.ExternalContext;// libreria ExternalContext
import javax.faces.context.FacesContext;// libreria FacesContext
import javax.servlet.http.HttpSession;// libreria HttpSession

/**
 *
 * @author Saplic16
 */
//nombre de clase en mageBean
@ManagedBean(name = "contCheckBean")
@SessionScoped//tipo de clase
//clase ContAtasBean con extends al crud
public class ContCheckBean extends CrudBean<ContCheck> implements Serializable{
    
    private String users; //declaracion de variable
    private String usuario;//declaracion de variable
    private String language;//declaracion de variable
    private int    chekID;//declaracion de variable
    private int    validarDate;//declaracion de variable
    private boolean caracteres;//declaracion de variable
    private ContCheck airWoer;//declaracion tipo clase
    private String  companyUser;//declaracion de variable
    private SgrCia sgrCia;
    
    /**
     * Creates a new instance of ContCheckBean
     */
    @EJB
    private SgrUserFacades sgrUser;//declaracion de clases Facade
    @EJB
    private SgrCiaFacade companyFacade;//declaracion de clases Facade
    @EJB
    private ContCheckFacade contCheckFacade;//declaracion de clases Facade
    
    @EJB
    private EngDamageTypeDimManufactFacade engDamageTypeDimManufactFacades;//declaracion de clases Facade
    																		 
    @ManagedProperty(value="#{Login}")
    private LoginBean loginBean;//declarion variable tipo clase
    @ManagedProperty(value="#{swtLanguage}")
    private LanguageSwitcher languageSwitcher;//declarion variable tipo clase
    
    private String itemId;//declaracion de variable
    
    private String parBusqueda;//declaracion de variable
    String fabricante;
    private List<String> listaManuf=new ArrayList<>();    
    transient List<Object[]> listChekbox = new ArrayList();//variable de lista
    
    private String requestType;
        
    public  ContCheckBean() {//construcor super
        super();
    }
 //metodo generado por implements Serializable
    @Override
     //metodo constructor
    @PostConstruct
    public void init() {
        elemento= new ContCheck();
        listado=new ArrayList<>();
        edit=false;
        caracteres=false;
        sgrCia = new SgrCia();
        FacesContext facesContext = FacesContext. getCurrentInstance();
            ExternalContext externalContext = facesContext.getExternalContext();
            Map params = externalContext.getRequestParameterMap(); 
            HttpSession session = SessionBean.getSession();
        if (users==null) {  
            users = (String) session.getAttribute("username");
        }
        companyUser = sgrUser.findSelectUser(users).getCiaDefault(); 
        sgrCia = companyFacade.find(companyUser);
        try {
            extendtime();
            if(sgrCia.getCiaAcceso().intValue()==1){
               //listado= contCheckFacade.findByChekActivosN();
               listado= contCheckFacade.findByChekActivos();                
            }else{
                
                listado= contCheckFacade.findByChekCompany(companyUser);
                //listado= contCheckFacade.findByChekCompanyN(companyUser);
            }
            
            fabricante="";
               listaManuf = new ArrayList<>();
        listaManuf = engDamageTypeDimManufactFacades.traerManufacurerAER();
        } catch (Exception e) {
            Logger.getLogger(ContCheckBean.class.getName()).log(Level.SEVERE, null, e);
        }
        
        
        
        
        if(users!=null){
        session.setAttribute("username", users);
        setUsuario(users);
        }
        loginBean.setUsuario(usuario);
        language =(String) params.get("language" );
        if(language!=null){
        languageSwitcher.setLanguage(language);
        }
        
        parBusqueda = "";
        validarDate=0;
    }
    
    //Cargar ECR:
    public void cargarECR(String valor)
    {
        System.err.println("Valor cargado de Click de nuevo boton: " + valor);
    }
    
//metodo que bucas por ID
    public void cargarCheckId(String id){
        extendtime();
        
        Short n= new Short(id);
        elemento= contCheckFacade.findByid(n);
		
	FacesContext context = FacesContext.getCurrentInstance();
        Application application = context.getApplication();
        ELContext elContext = context.getELContext();
        CompanyBean companyBean = (CompanyBean) application.getExpressionFactory()
            .createValueExpression(elContext, "#{companyBean}", CompanyBean.class).getValue(elContext);
        EngTabEsrnwsVwBean engtabEsrnwsVwBean = (EngTabEsrnwsVwBean) application.getExpressionFactory()
            .createValueExpression(elContext, "#{engtabEsrnwsVwBean}", EngTabEsrnwsVwBean.class).getValue(elContext);
        TabEsrEaEo tabEsrEaEo = (TabEsrEaEo) application.getExpressionFactory()
            .createValueExpression(elContext, "#{tabEsrEaEoBean}", TabEsrEaEo.class).getValue(elContext);
        EngHorasIngBean engHorasIngBean = (EngHorasIngBean) application.getExpressionFactory()
            .createValueExpression(elContext, "#{engHorasIngBean}", EngHorasIngBean.class).getValue(elContext);
        EmailEnBean emailEnBean = (EmailEnBean) application.getExpressionFactory()
            .createValueExpression(elContext, "#{emailEnBean}", EmailEnBean.class).getValue(elContext);
        
        engtabEsrnwsVwBean.setAirCraft(id);
        engtabEsrnwsVwBean.setCheckID(id);
        engtabEsrnwsVwBean.setCompany(elemento.getCheckCompany());  
        
        fabricante=engDamageTypeDimManufactFacades.traerManufacurerAERCont(elemento.getChkCucod(), elemento.getChkRegistry(), elemento.getChkModel());
        if(!fabricante.isEmpty()){
            elemento.setManufacturer(fabricante);
        }
        tabEsrEaEo.setWorkOrderJob(id);
        tabEsrEaEo.setAvion(elemento.getChkRegistry());
        tabEsrEaEo.setCompany(elemento.getCheckCompany());
        tabEsrEaEo.buscarWorkOrderJobIng();
        tabEsrEaEo.setAirWork(elemento.getChkRegistry().toString()+' '+elemento.getChkWo().toString());
        
        
        if (elemento.getCheckCompany()== null){
                elemento.setCheckCompany("AESV");
        }
        engHorasIngBean.setIdChk(n);
        engHorasIngBean.llenarHoursByCheck(n);          
        engHorasIngBean.setCola(elemento.getChkRegistry());
        engHorasIngBean.setWorkOrder(elemento.getChkWo());
        emailEnBean.somere(elemento.getContCheckId().toString());
        edit=true;
        validarDate=0;
        listChekbox = contCheckFacade.filtrarCheckbox(n);
        tabEsrEaEo.hangarDesf(elemento.getCheckCompany());
    }
    
    public void cargarOpcos(String compa){
        
        extendtime();
        
	FacesContext context = FacesContext.getCurrentInstance();
        Application application = context.getApplication();
        ELContext elContext = context.getELContext();
        TabEsrEaEo tabEsrEaEo = (TabEsrEaEo) application.getExpressionFactory()
            .createValueExpression(elContext, "#{tabEsrEaEoBean}", TabEsrEaEo.class).getValue(elContext);
        WorkOrderBean workOrderbean = (WorkOrderBean) application.getExpressionFactory()
            .createValueExpression(elContext, "#{workOrderBean}", WorkOrderBean.class).getValue(elContext);
        
        
        tabEsrEaEo.buscarWorkOrderJobIng();
        
    
        edit=true;
        validarDate=0;
    
        tabEsrEaEo.hangarDesf(compa);
        workOrderbean.searchWoByCompany(compa);
    }
    
    //metodo generado por implements Serializable limpia los elementos y otras variables
    @Override
    public void limpiar() {
        extendtime();
        elemento= new ContCheck();
        edit=false;
        listChekbox = new ArrayList<>();
        extendtime();
        validarDate=0;
    }
    //limpiar formuliario de la vista de check
    public void limpiarForm() {
        extendtime();
        FacesContext contextEsr = FacesContext.getCurrentInstance();
        UIViewRoot rootEsr = contextEsr.getViewRoot();
        UIInput reqcomdg = (UIInput) rootEsr.findComponent("formChecks:reqcomdg");
        UIInput chkCucod = (UIInput) rootEsr.findComponent("formChecks:chkCucod");
        UIInput chkRegistry = (UIInput) rootEsr.findComponent("formChecks:chkRegistry");
        UIInput chkWo = (UIInput) rootEsr.findComponent("formChecks:chkWo");
        UIInput chkStartdate = (UIInput) rootEsr.findComponent("formChecks:chkStartdate");
        UIInput chkFinishdate = (UIInput) rootEsr.findComponent("formChecks:chkFinishdate");
        UIInput chkChecktype = (UIInput) rootEsr.findComponent("formChecks:chkChecktype");
        UIInput chkModel = (UIInput) rootEsr.findComponent("formChecks:chkModel");
        UIInput chkTtsn = (UIInput) rootEsr.findComponent("formChecks:chkTtsn");
        UIInput chkTcsn = (UIInput) rootEsr.findComponent("formChecks:chkTcsn");
        UIInput chkVn = (UIInput) rootEsr.findComponent("formChecks:chkVn");
        UIInput chkLn = (UIInput) rootEsr.findComponent("formChecks:chkLn");
        UIInput chkSn = (UIInput) rootEsr.findComponent("formChecks:chkSn");
        UIInput chkBn = (UIInput) rootEsr.findComponent("formChecks:chkBn");
        UIInput chkClosed = (UIInput) rootEsr.findComponent("formChecks:chkClosed");
        UIInput chkArrivaldate = (UIInput) rootEsr.findComponent("formChecks:chkArrivaldate");
        UIInput chkGroundtime = (UIInput) rootEsr.findComponent("formChecks:chkGroundtime");
        UIInput chkHangmanrespon = (UIInput) rootEsr.findComponent("formChecks:chkHangmanrespon");
        UIInput chkHangrespon = (UIInput) rootEsr.findComponent("formChecks:chkHangrespon");
        UIInput chkCommrespon = (UIInput) rootEsr.findComponent("formChecks:chkCommrespon");
        UIInput chkProdcontrespon = (UIInput) rootEsr.findComponent("formChecks:chkProdcontrespon");
        UIInput chkWarehrespon = (UIInput) rootEsr.findComponent("formChecks:chkWarehrespon");
        UIInput chkShopsrespon = (UIInput) rootEsr.findComponent("formChecks:chkShopsrespon");
        UIInput chkPurchrespon = (UIInput) rootEsr.findComponent("formChecks:chkPurchrespon");
        UIInput chkPlannrespon = (UIInput) rootEsr.findComponent("formChecks:chkPlannrespon");
        UIInput chkEnginrespon = (UIInput) rootEsr.findComponent("formChecks:chkEnginrespon");
        UIInput chkPowplantres = (UIInput) rootEsr.findComponent("formChecks:chkPowplantres");
        UIInput chkQarespon = (UIInput) rootEsr.findComponent("formChecks:chkQarespon");
        UIInput chkQcrespon = (UIInput) rootEsr.findComponent("formChecks:chkQcrespon");
        UIInput chkMsn = (UIInput) rootEsr.findComponent("formChecks:chkMsn");
        UIInput chkEngManHrs = (UIInput) rootEsr.findComponent("formChecks:chkEngManHrs");
        UIInput chkClosedEng = (UIInput) rootEsr.findComponent("formChecks:chkClosedEng");
        UIInput chkDescription = (UIInput) rootEsr.findComponent("formChecks:chkDescription");
        reqcomdg.resetValue();
        chkCucod.resetValue();
        chkRegistry.resetValue();
        chkWo.resetValue();
        chkStartdate.resetValue();
        chkFinishdate.resetValue();
        chkChecktype.resetValue();
        chkModel.resetValue();
        chkTtsn.resetValue();
        chkTcsn.resetValue();
        chkVn.resetValue();
        chkLn.resetValue();
        chkSn.resetValue();
        chkBn.resetValue();
        chkClosed.resetValue();
        chkArrivaldate.resetValue();
        chkGroundtime.resetValue();
        chkHangmanrespon.resetValue();
        chkHangrespon.resetValue();
        chkCommrespon.resetValue();
        chkProdcontrespon.resetValue();
        chkWarehrespon.resetValue();
        chkShopsrespon.resetValue();
        chkPurchrespon.resetValue();
        chkPlannrespon.resetValue();
        chkEnginrespon.resetValue();
        chkPowplantres.resetValue();
        chkQarespon.resetValue();
        chkQcrespon.resetValue();
        chkMsn.resetValue();
        chkEngManHrs.resetValue();
        chkClosedEng.resetValue();
        chkDescription.resetValue();
        validarDate=0;
        
    }
    //limpia la informacion filtrado por avion
     public void limpiarPorAvion(){
        extendtime();
		
	FacesContext context = FacesContext.getCurrentInstance();
        Application application = context.getApplication();
        ELContext elContext = context.getELContext();
																				  
																									   
        EngTabEsrnwsVwBean engtabEsrnwsVwBean = (EngTabEsrnwsVwBean) application.getExpressionFactory()
            .createValueExpression(elContext, "#{engtabEsrnwsVwBean}", EngTabEsrnwsVwBean.class).getValue(elContext);
        TabEsrEaEo tabEsrEaEo = (TabEsrEaEo) application.getExpressionFactory()
            .createValueExpression(elContext, "#{tabEsrEaEoBean}", TabEsrEaEo.class).getValue(elContext);
        
        //companyBean.menuDash();
        if(tabEsrEaEo.getWorkOrderJob()!=null && !tabEsrEaEo.getWorkOrderJob().isEmpty()){
        //ContCheck sdf = contCheckFacade.find(Short.parseShort(tabEsrEaEo.getWorkOrderJob()));
        ContCheck sdf = contCheckFacade.find(new BigDecimal(tabEsrEaEo.getWorkOrderJob()));
        engtabEsrnwsVwBean.setWo(null);
        engtabEsrnwsVwBean.setAirCraft2(null);
        engtabEsrnwsVwBean.setAirCraft(null);
        engtabEsrnwsVwBean.setCompany(null);
        engtabEsrnwsVwBean.setValAirCraft(null);
        engtabEsrnwsVwBean.setCheckID(null);
        engtabEsrnwsVwBean.setfInicio(null);
        engtabEsrnwsVwBean.setfFin(null);
        engtabEsrnwsVwBean.listado = new ArrayList<>();        
        tabEsrEaEo.setAirWork(null);
        tabEsrEaEo.setWorkOrderJob(null);
        tabEsrEaEo.limpiar2(2);
        tabEsrEaEo.getEsr().infoDash(sdf.getCheckCompany());
        tabEsrEaEo.llenarlistas();
        discardBusqueda();
         }
    }
    //metodo generado por implements Serializable actualiza el elemento de BD
    @Override
    public void actualizar() {        
        extendtime();
         /*AGREGAR MABNUFACTURADOR*/
        if(fabricante.isEmpty() && !elemento.getManufacturer().isEmpty()){
            engDamageTypeDimManufactFacades.crearManufacurerAERCont(elemento.getChkCucod(), elemento.getChkRegistry(), elemento.getChkModel(), elemento.getManufacturer());
        }
        contCheckFacade.edit(elemento);
        limpiar();
        listado= contCheckFacade.findByChekActivos();
		
	FacesContext context = FacesContext.getCurrentInstance();
        Application application = context.getApplication();
        ELContext elContext = context.getELContext();
        WorkOrderBean workOrderbean = (WorkOrderBean) application.getExpressionFactory()
            .createValueExpression(elContext, "#{workOrderBean}", WorkOrderBean.class).getValue(elContext);
        
        workOrderbean.init();
        validarDate=0;
    }
    //ingresa parametros de WO
    public void setParamer(){
        extendtime();
		
	FacesContext context = FacesContext.getCurrentInstance();
        Application application = context.getApplication();
        ELContext elContext = context.getELContext();
        TabEsrEaEo tabEsrEaEo = (TabEsrEaEo) application.getExpressionFactory()
            .createValueExpression(elContext, "#{tabEsrEaEoBean}", TabEsrEaEo.class).getValue(elContext);
        EngTabEsrnwsVwBean engtabEsrnwsVwBean = (EngTabEsrnwsVwBean) application.getExpressionFactory()
            .createValueExpression(elContext, "#{engtabEsrnwsVwBean}", EngTabEsrnwsVwBean.class).getValue(elContext);
        
        String workOrder = tabEsrEaEo.getWorkOrderJob();
        if(workOrder.isEmpty() || workOrder==null){
            workOrder = engtabEsrnwsVwBean.getContCheckID().getContCheckId().toString();
        }
        tabEsrEaEo.setWorkOrderJob(workOrder);
        airWoer = new ContCheck();
        //airWoer=contCheckFacade.find(Short.parseShort(workOrder));
        airWoer=contCheckFacade.find(new BigDecimal(workOrder));
        setParBusqueda(airWoer.getChkRegistry());
        buscarChequeo();
    }
    //selecciona las WO por empresa
    public void selectChek(String company){
        extendtime();
		
	FacesContext context = FacesContext.getCurrentInstance();
        Application application = context.getApplication();
        ELContext elContext = context.getELContext();
        EngTabEsrnwsVwBean engtabEsrnwsVwBean = (EngTabEsrnwsVwBean) application.getExpressionFactory()
            .createValueExpression(elContext, "#{engtabEsrnwsVwBean}", EngTabEsrnwsVwBean.class).getValue(elContext);
        EngMergeCustomerBean engMergeCustomerBean = (EngMergeCustomerBean) application.getExpressionFactory()
                .createValueExpression(elContext, "#{engMergeCustomerBean}", EngMergeCustomerBean.class).getValue(elContext);  
        
        engtabEsrnwsVwBean.setCompany(company);
        listado= contCheckFacade.findByChekActivosCompany(company);
        //listado= contCheckFacade.findByChekActivosCompanyN(company);
        validarDate=0;
        elemento.setCheckCompany(company);
        engMergeCustomerBean.listOpco(company);
    }
    //descarta cambios de horas
    public void descartarCambiosHours(){
        try {
            extendtime();
			
			FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();
            ELContext elContext = context.getELContext();
            EngHorasIngBean engHorasIngBean = (EngHorasIngBean) application.getExpressionFactory()
                .createValueExpression(elContext, "#{engHorasIngBean}", EngHorasIngBean.class).getValue(elContext);
            
            engHorasIngBean.llenarHoursByCheck(elemento.getContCheckId().shortValueExact()); 
        } catch (Exception e) {
            Logger.getLogger(ContCheckBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }
//metodo generado por implements Serializable agrega el elemento en la bd
    @Override
    public void agregar() {
            
        try {// capturar posibles errores
            Calendar fecha = Calendar.getInstance();
            int year = fecha.get(Calendar.YEAR);
            extendtime();           
            chekID = Integer.parseInt(contCheckFacade.findByUltimoID().toString()) + 1;            
            elemento.setContCheckId(new BigDecimal(chekID));            
            elemento.setChkCorrtype(new BigDecimal(chekID));             
            elemento.setChkYear(String.valueOf(year));
            
            /*AGREGAR MABNUFACTURADOR*/
            if(fabricante.isEmpty() && !elemento.getManufacturer().isEmpty()){
                engDamageTypeDimManufactFacades.crearManufacurerAERCont(elemento.getChkCucod(), elemento.getChkRegistry(), elemento.getChkModel(), elemento.getManufacturer());
            }
            
            contCheckFacade.create(elemento);
            validarDate=0;
			
			FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();
            ELContext elContext = context.getELContext();
            WorkOrderBean workOrderbean = (WorkOrderBean) application.getExpressionFactory()
                .createValueExpression(elContext, "#{workOrderBean}", WorkOrderBean.class).getValue(elContext);
            
            workOrderbean.init();
            edit=true;
            listado= contCheckFacade.findByChekActivos();
            elemento= new ContCheck();
            limpiarForm();       
        } catch (Exception e) {//captuara el posible error
            Logger.getLogger(ContCheckBean.class.getName()).log(Level.SEVERE, null, e);
        }   
        
        
    }
//metodo generado por implements Serializable
    @Override
    public void eliminar(ContCheck elemento) {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }
//busca chequeos  por filtro
    public void buscarChequeo(){
        extendtime();
        caracteres=false;
        if(parBusqueda.length()>=3){ 
            
            sgrCia = companyFacade.find(companyUser);
            if(sgrCia.getCiaAcceso().intValue()==1){
                listado = contCheckFacade.findByAvionOrWo(parBusqueda);
            }else{
                listado = contCheckFacade.findByAvionOrWoCia(parBusqueda,companyUser);
            }
        }else{
            caracteres=true;
        }
    }
    //descarta el metodo
    public void discardBusqueda(){
        extendtime();
        parBusqueda = "";
        listado = contCheckFacade.findByChekActivos();
        limpiar();
    }
    //compra fechas de WO
    public void compararfecha(){
        extendtime();
        if (elemento.getChkStartdate() != null && elemento.getChkFinishdate() != null) {
            if (elemento.getChkFinishdate().after(elemento.getChkStartdate()) || (elemento.getChkFinishdate().equals(elemento.getChkStartdate()))) {
                validarDate = 0;
            } else if (!elemento.getChkFinishdate().after(elemento.getChkStartdate())) {
                validarDate = 1;                
            }

        }
    }
    //metodo generado por implements Serializable
    @Override
    public ContCheck nuevoElemento() {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }
    // get y set de variable
    public ContCheckFacade getContCheckFacade() {
        return contCheckFacade;
    }

    public void setContCheckFacade(ContCheckFacade contCheckFacade) {
        this.contCheckFacade = contCheckFacade;
    }
// get y set de variable
    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

// get y set de variable
    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
    }
// get y set de variable
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
// get y set de variable
    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }
// get y set de variable
    public LanguageSwitcher getLanguageSwitcher() {
        return languageSwitcher;
    }

    public void setLanguageSwitcher(LanguageSwitcher languageSwitcher) {
        this.languageSwitcher = languageSwitcher;
    }
// get y set de variable
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
// get y set de variable
    public String getParBusqueda() {
        return parBusqueda;
    }

    public void setParBusqueda(String parBusqueda) {
        this.parBusqueda = parBusqueda;
    }

// get y set de variable			
    public List<Object[]> getListChekbox() {
        return listChekbox;
    }

    public void setListChekbox(List<Object[]> listChekbox) {
        this.listChekbox = listChekbox;
    }

// get y set de variable						
    public int getChekID() {
        return chekID;
    }

    public void setChekID(int chekID) {
        this.chekID = chekID;
    }
// get y set de variable
    public int getValidarDate() {
        return validarDate;
    }

    public void setValidarDate(int validarDate) {
        this.validarDate = validarDate;
    }

    public ContCheck getAirWoer() {// get y set de variable
        return airWoer;
    }

    public void setAirWoer(ContCheck airWoer) {// get y set de variable
        this.airWoer = airWoer;
    }

// get y set de variable
    public boolean getCaracteres() {
        return caracteres;
    }

    public void setCaracteres(boolean caracteres) {
        this.caracteres = caracteres;
    }  

    public String getCompanyUser() {
        return companyUser;
    }

    public void setCompanyUser(String companyUser) {
        this.companyUser = companyUser;
    }
    
    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public List<String> getListaManuf() {
        return listaManuf;
    }

    public void setListaManuf(List<String> listaManuf) {
        this.listaManuf = listaManuf;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }
}
