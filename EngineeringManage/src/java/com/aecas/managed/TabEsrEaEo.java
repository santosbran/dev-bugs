 // To change this license header, choose License Headers in Project Properties.
 // To change this template file, choose Tools | Templates
 // and open the template in the editor.
package com.aecas.managed;// paquete manage

import static com.aecas.managed.EaPdfBean.getSubmittedFileName;// importacion de clase
import com.aees.languageSwitcher.LanguageSwitcher;// libreria Serializable
import com.aees.session.SessionBean;// libreria Serializable
import com.aeroman.aees.entities.EngEaGeneral;// importacion de clase
import com.aeroman.aees.entities.EngEaPdf;// importacion de clase
import com.aeroman.aees.entities.EngEoRef;// importacion de clase
import com.aeroman.aees.entities.EngEsrDocument;// importacion de clase
import com.aeroman.aees.entities.EngEsrListView;// importacion de clase
import com.aeroman.aees.entities.EngOrders;// importacion de clase
import com.aeroman.aees.entities.EngReqTaskCardIni;// importacion de clase
import com.aeroman.aees.entities.EngReqTaskJobcardIni;// importacion de clase
import com.aeroman.aees.entities.EngRequest;// importacion de clase
import com.aeroman.aees.entities.EngRequestDimenIni;// importacion de clase
import com.aeroman.aees.entities.EngTaskCard;// importacion de clase
import com.aeroman.aees.entities.EngTaskListView;// importacion de clase
import com.aeroman.aees.entities.TypeDoc;// importacion de clase
import com.aeroman.aees.entities.grant.ContAtas;// importacion de clase
import com.aeroman.aees.entities.grant.ContCheck;// importacion de clase
import com.aeroman.aees.entities.grant.SgrCia;// importacion de clase
import com.aeroman.aees.entities.grant.SgrRole;// importacion de clase
import com.aeroman.aees.entities.grant.SgrRolePK;
import com.aeroman.aees.entities.grant.SgrUser;// importacion de clase
import com.aeroman.aees.facades.EngEaEoReqVwFacade;// importacion de clase
import com.aeroman.aees.facades.EngEsrDocumentFacade;// importacion de clase
import com.aeroman.aees.facades.EngReqResponsesFacade;
import com.aeroman.aees.facades.EngReqTaskCardIniFacade;// importacion de clase
import com.aeroman.aees.facades.EngReqTaskJobcardIniFacade;// importacion de clase
import com.aeroman.aees.facades.EngRequestDimenIniFacade;// importacion de clase
import com.aeroman.aees.facades.EngRequestFacade;// importacion de clase
import com.aeroman.aees.facades.EngTaskListViewFacade;// importacion de clase
import com.aeroman.aees.facades.EngTasksByUserSupVwFacade;// importacion de clase
import com.aeroman.aees.facades.Sequences;// importacion de clase
import com.aeroman.aees.facades.TypeDocFacade;// importacion de clase
import com.aeroman.aees.facades.engSeguimientoFacade;
import com.aeroman.aees.facades.grant.ContAtasFacade;// importacion de clase
import com.aeroman.aees.facades.grant.ContCheckFacade;// importacion de clase
import com.aeroman.aees.facades.grant.EngEsrListViewFacade;// importacion de clase
import com.aeroman.aees.facades.grant.SgrCiaFacade;// importacion de clase
import com.aeroman.aees.facades.grant.SgrUserFacades;// importacion de clase
import java.io.ByteArrayInputStream;// libreria Serializable
import java.io.IOException;// libreria Serializable
import java.io.InputStream;// libreria Serializable
import java.io.Serializable;// libreria Serializable
import java.math.BigDecimal;// libreria Serializable
import java.math.BigInteger;// libreria Serializable
import java.text.DateFormat;
import java.text.ParseException;// libreria Serializable
import java.text.SimpleDateFormat;// libreria Serializable
import java.util.ArrayList;// libreria Serializable
import java.util.Calendar;// libreria Serializable
import java.util.Collection;// libreria Serializable
import java.util.Date;// libreria Serializable
import java.util.List;// libreria Serializable
import java.util.Map;// libreria Serializable
import java.util.logging.Level;// libreria Serializable
import java.util.logging.Logger;// libreria Serializable
import javax.annotation.PostConstruct;// libreria Serializable
import javax.ejb.EJB;// libreria Serializable
import javax.el.ELContext;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;// libreria Serializable
import javax.faces.bean.ManagedBean;// libreria Serializable
import javax.faces.bean.ManagedProperty;// libreria Serializable
import javax.faces.bean.SessionScoped;// libreria Serializable
import javax.faces.context.ExternalContext;// libreria Serializable
import javax.faces.context.FacesContext;// libreria Serializable
import javax.servlet.ServletException;// libreria Serializable
import javax.servlet.ServletOutputStream;// libreria Serializable
import javax.servlet.http.HttpServletRequest;// libreria Serializable
import javax.servlet.http.HttpServletResponse;// libreria Serializable
import javax.servlet.http.HttpSession;// libreria Serializable
import javax.servlet.http.Part;// libreria Serializable
import org.apache.commons.io.FilenameUtils;// libreria Serializable
import org.apache.poi.openxml4j.opc.OPCPackage;// libreria Serializable
import org.apache.poi.util.IOUtils;// libreria Serializable
import org.apache.poi.xssf.usermodel.XSSFWorkbook;// libreria Serializable
import org.apache.soap.encoding.soapenc.Base64;// libreria Serializable
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;// libreria Serializable
import org.primefaces.event.FileUploadEvent;// libreria Serializable
import org.primefaces.model.UploadedFile;// libreria Serializable
							   

/**
 *
 * @author Usuario
 */
@ManagedBean(name = "tabEsrEaEoBean")
@SessionScoped
public class TabEsrEaEo extends CrudBean<EngRequest> implements Serializable {

																				   
	
    @EJB
    private EngEaEoReqVwFacade engEaEoReqVwFacade;

    @EJB
    private EngRequestFacade requestFacade;

    @EJB
    private EngTaskListViewFacade taskviewfacade;

    @EJB
    private Sequences numax;

    @EJB
    private ContCheckFacade contFacade;

    @EJB
    private SgrUserFacades sgrUser;

    @EJB
    private EngTasksByUserSupVwFacade coreUsersVwFacade;
    
    @EJB
    private ContAtasFacade contAtasFacade;
    @EJB
    private EngEsrDocumentFacade documentFacade;
    @EJB
    private EngReqTaskJobcardIniFacade engReqTaskJobcardIniFacade;
    @EJB
    private EngReqTaskCardIniFacade engReqTaskCardIniFacade;
    @EJB
    private EngRequestDimenIniFacade engRequestDimenIniFacade;
    @EJB
    private SgrCiaFacade companyFacade;
    @EJB
    private EngEsrListViewFacade engEsrListViewFacade;
    
    @EJB
    private TypeDocFacade typeDocFacade;
    @EJB
    private EngReqResponsesFacade engReqResponsesFacade; //VALIDAR DATOS DE ESR: 21/06/2021
     @EJB
    private engSeguimientoFacade engSegFacade;
     
    private TypeDoc typeDoc;
    private String idIng;
    private boolean existeArchivo;
    private String idAct;
    private String tempId;
    private String esrId;
    private String idTab;
    private int idor;
    private int idmaxea;
    private String worder;
    private EngEaPdf elemntt2;
    private transient Object[] idtodas;
    private String idEsrWo;
    private EngEsrListView listfiltro2;
    private SgrUser elementoUser;
    transient List<String> listaHangares = new ArrayList();
    transient List<String> listaRampas = new ArrayList();
    transient List<EngRequest> listadoTabEsr = new ArrayList<>();
    transient List<SgrUser> listadoUser = new ArrayList<>();
    transient List<EngEaGeneral> listadoTabEa = new ArrayList<>();
    transient List<EngOrders> listadoTabEo = new ArrayList<>();
    transient List<Object[]> listAll = new ArrayList<>();
    transient List<EngEsrListView> listfiltro = new ArrayList<>();
    transient List<Object[]> listEsr = new ArrayList<>();
    transient List<EngTaskListView> listadoMex = new ArrayList<>();
    transient List<EngTaskListView> listadoAe = new ArrayList<>();
    transient List<EngTaskListView> listInge = new ArrayList<>();
    transient List<Object[]> listadoTabEaing = new ArrayList<>();
    transient List<Object[]> listadoTabEoing = new ArrayList<>();
    transient List<Object[]> listAlling = new ArrayList<>();
    transient List<EngTaskListView> listadouserins = new ArrayList<>();
    transient List<EngTaskListView> listesrcompany = new ArrayList<>();
    transient List<EngEsrListView> listesrcompanymec = new ArrayList<>();
    transient List<EngTaskListView> listesrcompanysup = new ArrayList<>();
    transient List<SgrRole> rol = new ArrayList<>();
    transient List<EngReqTaskJobcardIni> listaJobIni = new ArrayList<>();
    transient List<EngReqTaskCardIni> listaTaskCard = new ArrayList<>();
    transient List<EngRequestDimenIni> listaDime = new ArrayList<>();
    transient List<EngEaGeneral> listTavea = new ArrayList<>();
    transient List<Object[]> listTavall = new ArrayList<>();
    
    private List<UploadedFile> uploadedFiles;
    private boolean disable;
    private UploadedFile filex;
    private String tipoActividad;    
    private EngOrders elemnt;
    private EngRequest elemnts;
    private EngEaGeneral elemntt;
    private EngEoRef elemnt2;
    private Date fechaAct = new Date();
    private String str2;
    private String itemId;
    private boolean filtro;
    private boolean filtrouser;
    private boolean algotienequetraer;
    private String usr86;
    private String contid;
    private String avion;
    private String custom;
    private String idreq;
    private String nuwitem;
    private String roles;
    private String usuario;
    private String flota;
    private String nombreUsr;
    private String workOrderJob;
    private String airWork;
    private String draguser;
    private String dragesr;
    private String language;
    private String users;
    private String usercompany;
    private String userfulname;
    private String comsup = "";
    private String worderid;
    private Short idcontcke;
    private int ingbutom;
    private String usertem;
    private String idAta;
    private String desAta;
    private String atamala;
    private boolean existeata;
    private String companySV;
    private boolean existeLista;
    private String errorTarjeta;
    private String msnWork;
    private String hoursWork;
    private String cyclesWork;
    private String companyUser;
    private String idEAForm;
    
    private String completEsr;
    private String reasonEsr;
    private String criticalEsr="0";
    private String aogEsr="0";
    
    private boolean criticalEsrb=false;
    private boolean aogEsrb=false;
    private boolean completEsrb=false;
   
    private boolean compCheck;

    private String tipoSolicitud; 
    
    private String componentName;
    
    private String companyECRSelected;
    private String customerSelected;
    
								
    @ManagedProperty(value = "#{esrBean}")
    private EsrBean esr;
    @ManagedProperty(value = "#{engAutorizationBean}")
    private EngAutorizationBean engAutorization;
											  
								   
    @ManagedProperty(value = "#{swtLanguage}")
    private LanguageSwitcher languageSwitcher;
																					  
    @ManagedProperty(value = "#{Login}")
    private LoginBean loginBean;
													
    @ManagedProperty(value = "#{RequestTracking}")
    private RequestTrackingBean trackingesrbean;
												  
												   
    
    private SgrCia sgrCia;
    
    private String userTabEsr = "username";
    private String nombresolicitante;
    private boolean valNav;
    private String navegador;
    
    private String companySelected;
    private String airCraft;
    private String company;
    
    private boolean disables;
    private String define;

    @Override
    @PostConstruct
    public void init() {
														
        extendtime();
        //esr.init();
        completEsr="true";
        uploadedFiles = new ArrayList<>();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        Map params = externalContext.getRequestParameterMap();
        users = (String) params.get("user");
        HttpSession session = SessionBean.getSession();
        existeArchivo=true;
        sgrCia= new SgrCia();
																	   
        companyUser = sgrUser.findSelectUser(users).getCiaDefault();
																		   
        if(companyUser!=null){
            if (users != null) {
                session.setAttribute(userTabEsr, users);
                setUsuario(users);
            }
            loginBean.setUsuario(usuario);
            language = (String) params.get("language");
            if (language != null) {
                languageSwitcher.setLanguage(language);
            }

            String user = (String) session.getAttribute(userTabEsr);
            if (user != null) {
                setUsertem(user);
            }

            if (user == null) {
                user = usertem;
            }
																				
            userfulname = numax.traernombredeusuario(user);
																				   
            numax.content();
																   
            rol = numax.SgrRole(user);
																   
            if (!rol.isEmpty()){
                roles = rol.get(0).getSgrRolePK().getRoleCode();
                trackingesrbean.setRolUser(roles);
            }        
            esr.elemento.setCompany(usercompany);
																  
            llenarlistas();
																	

            engAutorization.edit = true;
            esr.elemento = new EngRequest();
            esr.elemento.setReqFechaIns(new Date());
            esr.edit = false;
            setWorder("");
            setWorderid("");
																					
            nombresolicitante = numax.traernombredeusuario(users);
																					   
            esr.elemento.setReqUsersol(nombresolicitante); 
																	 
            disables = validaRol(rol);
																		
        }
																 
        
    }
    
    public boolean validaRol(List<SgrRole> lsRol)
    {
        boolean val = false;
        int valRol = 0;
        //Recorrer listado de roles:
        //Then  you can use "foreache" loop to iterate. 01/06/2021
        for(SgrRole item:lsRol){
            valRol = Integer.parseInt(item.getSgrRolePK().getRoleCode());
            if(valRol == 7)
            {
                val = true;
                break;
            }
        }
        return val;        
    }
    
    public void companyFilter(){ 
        extendtime();
		
	FacesContext context = FacesContext.getCurrentInstance();
        Application application = context.getApplication();
        ELContext elContext = context.getELContext();
        CompanyBean companyBean = (CompanyBean) application.getExpressionFactory()
            .createValueExpression(elContext, "#{companyBean}", CompanyBean.class).getValue(elContext);
        
																				  
        if(companyBean==null){
            companyBean=new CompanyBean();
        }
		
        companyBean.initMenus();
        sgrCia= new SgrCia();
        esr.elemento = new EngRequest();      
        companyBean.listado2 = new ArrayList<>();
        companyBean.listado3 = new ArrayList<>();
        if(elementoUser==null){
            llenarElementoUser();
        }
        sgrCia = companyFacade.find(elementoUser.getCiaDefault());
        if("7".equals(roles)){            
            companyBean.listado2.add(sgrCia);
        }else{
            if(sgrCia.getCiaAcceso().intValue()==1){
                companyBean.listado2 = companyFacade.findAllOperative();
            }
            else{
                companyBean.listado2.add(sgrCia);
            }
            
        }
        for (SgrCia sgrCia1Lis : companyBean.listado2) {
            if(sgrCia1Lis.getCiaLogoExt()!= null){
                sgrCia1Lis.setLogoBase64(Base64.encode(sgrCia1Lis.getCiaLogoBlob()));
            }
            companyBean.listado3.add(sgrCia1Lis);
            
        }
        companyBean.listado2 = new ArrayList<>();
        companyBean.listado2 = companyBean.listado3;
        companyBean.listado3 = new ArrayList<>();
    
    }
    
    public void guardarDispositionEaEO(BigInteger id){
        extendtime();
        esr.guardarDisposition(id);
        engDispositioPanelDerecho(new BigDecimal(id));
        //llenarlistas();          
      
    }
    
    public void llenarAta(){
        extendtime();
        Short idta = new Short(idAta);
        ContAtas ata = contAtasFacade.find(idta);
        esr.elemento.setAtaNumata(ata.getAtaNumata());
        desAta = ata.getAtaNumata() +"-"+ ata.getAtaDescription();
        existeata = false;
    }
    
    public void validarAta() {
        extendtime();
        existeata = "s".equals(atamala);
        try {
            if (!existeata) {
                String sacarid = desAta.substring(0, desAta.indexOf("-"));
                Short idta = new Short(sacarid);
                ContAtas ata = contAtasFacade.find(idta);
                esr.elemento.setAtaNumata(ata.getAtaNumata());
                desAta = ata.getAtaNumata() + "-" + ata.getAtaDescription();
            }
        } catch (Exception e) {
            Logger.getLogger(TabEsrEaEo.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void trust(String res){
														 
        extendtime();
        valNav = "yes".equals(res);
															
    }

    public void findSelectUser(String id) {
        extendtime();
        elementoUser = new SgrUser();
        elementoUser = sgrUser.findSelectUser(id);
    }
    public void buscarWorkOrderJobIng(){
        extendtime();
        String workOrder = getWorkOrderJob();
        listfiltro.clear();       
        extendtime();
        try{
//        listfiltro = engEsrListViewFacade.findByBuscarWorkOrder(workOrder);  
        listfiltro = engEsrListViewFacade.findByAircraftAndCompany(getAvion(), getCompany());
        ContCheck airWoer =new ContCheck();
        //airWoer=contFacade.find(Short.parseShort(workOrder) );
        airWoer=contFacade.find(new BigDecimal(workOrder) );
        airWork = airWoer.getChkRegistry().toString()+' '+airWoer.getChkWo().toString();     
		
	FacesContext context = FacesContext.getCurrentInstance();
        Application application = context.getApplication();
        ELContext elContext = context.getELContext();
        WorkOrderBean workOrderbean = (WorkOrderBean) application.getExpressionFactory()
            .createValueExpression(elContext, "#{workOrderBean}", WorkOrderBean.class).getValue(elContext);
        
																							
        if(workOrderbean==null){
            workOrderbean=new WorkOrderBean();
        }
		
        workOrderbean.autowo = new ArrayList<>();
        workOrderbean.autowo = contFacade.findByCompAndID(esr.elemento.getCompany(),esr.elemento.getChkCheckid());
        } catch (Exception e) {
            Logger.getLogger(TabEsrEaEo.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public void buscarWorkOrderJobMec(){
        extendtime();
        String workOrder = getWorkOrderJob();        
        listesrcompanymec.clear();
        extendtime();
        try{
        listesrcompanymec = engEsrListViewFacade.findByBuscarWorkOrder(workOrder);  
        ContCheck airWoer =new ContCheck();
        airWoer=contFacade.find(new BigDecimal(workOrder));
        airWork = airWoer.getChkRegistry().toString()+' '+airWoer.getChkWo().toString();
        
        } catch (Exception e) {
            Logger.getLogger(TabEsrEaEo.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    /**
     * Metodo nuevo para cargar el usuario 29-3-2021
     */
    public void llenarElementoUser(){
        HttpSession session = SessionBean.getSession();
        String user = (String) session.getAttribute(userTabEsr);
        elementoUser = new SgrUser();
        elementoUser = sgrUser.findSelectUser(user);
    }
    
    public void llenarlistas() {
																
        extendtime();
																 
        HttpSession session = SessionBean.getSession();
        String user = (String) session.getAttribute(userTabEsr);
        
        listfiltro = new ArrayList<>();
        elementoUser = new SgrUser();
        elementoUser = sgrUser.findSelectUser(user);
        usercompany = elementoUser.getCiaDefault();
        companySV = esr.elemento.getCompany();
		
	FacesContext context = FacesContext.getCurrentInstance();
        Application application = context.getApplication();
        ELContext elContext = context.getELContext();
        WorkOrderBean workOrderbean = (WorkOrderBean) application.getExpressionFactory()
            .createValueExpression(elContext, "#{workOrderBean}", WorkOrderBean.class).getValue(elContext);
        
																					
        if(workOrderbean==null){
										 
            workOrderbean=new WorkOrderBean();
        }
																				 
        workOrderbean.searchWoByCompany(elementoUser.getCiaDefault());
																					
        esr.setCompanyCia(companySV);
        setUsr86(user);
																	   
        if (("7").equals(rol.get(0).getSgrRolePK().getRoleCode())) {
            setUsercompany(elementoUser.getCiaDefault());
            esrcompanymec(elementoUser.getCiaDefault());
            esr.elemento.setCompany(usercompany);
        }
																					 

        if (workOrderJob!= null){
            listfiltro = engEsrListViewFacade.findByWorkOrder(new BigDecimal(workOrderJob));
        }
        
       
         
        if (("7").equals(rol.get(0).getSgrRolePK().getRoleCode())) {
            setRoles(rol.get(0).getSgrRolePK().getRoleCode());
            setNombreUsr(elementoUser.getFullUserName());
            setIdor(2);
            
        } else if (("2").equals(rol.get(0).getSgrRolePK().getRoleCode())) {
            setRoles(rol.get(0).getSgrRolePK().getRoleCode());
            setNombreUsr(elementoUser.getFullUserName());
			
																		   
            IngenierBean inge = (IngenierBean) application.getExpressionFactory()
                .createValueExpression(elContext, "#{ingenierBean}", IngenierBean.class).getValue(elContext);
            
																			  
            if(inge==null){
											  
                inge=new IngenierBean();
            }
			
            inge.cargarTodas();
            

        } else if (("4").equals(rol.get(0).getSgrRolePK().getRoleCode())) {
            setRoles(rol.get(0).getSgrRolePK().getRoleCode());
            setNombreUsr(elementoUser.getFullUserName());
        } else {
            setRoles(rol.get(0).getSgrRolePK().getRoleCode());
            setNombreUsr(elementoUser.getFullUserName());
            
        }
        setIdor(2);
																   
    }
    public boolean homeManager() {
															   
        return true;
    }
    
    public String logout() {
														  
        extendtime();
        try {
            HttpSession session = SessionBean.getSession();
            session.invalidate();
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

        } catch (Exception e) {
            Logger.getLogger(TabEsrEaEo.class.getName()).log(Level.SEVERE, null, e);
        }
															 
        return "/EngineeringManage/pages/error/error.xhtml";
    }

    public void refrescarlistas(boolean editando) {
        
        /*parte para guardar el archivo*/
            extendtime();
            existeArchivo=false;
            boolean taskCard;
			
            FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();
            ELContext elContext = context.getELContext();
            EngDamageDimBean engDamageDimBean = (EngDamageDimBean) application.getExpressionFactory()
                    .createValueExpression(elContext, "#{engDamageDimBean}", EngDamageDimBean.class).getValue(elContext);
            EngDamageTypeManufactBean engDamageTypeManufactBean = (EngDamageTypeManufactBean) application.getExpressionFactory()
                    .createValueExpression(elContext, "#{engDamageTypeManufactBean}", EngDamageTypeManufactBean.class).getValue(elContext);
            EngRequestDimenBean reqdimBean = (EngRequestDimenBean) application.getExpressionFactory()
                    .createValueExpression(elContext, "#{reqdimBean}", EngRequestDimenBean.class).getValue(elContext);
            IngenierBean inge = (IngenierBean) application.getExpressionFactory()
                    .createValueExpression(elContext, "#{ingenierBean}", IngenierBean.class).getValue(elContext);
            TaskReqCardBean taskReqCard = (TaskReqCardBean) application.getExpressionFactory()
                    .createValueExpression(elContext, "#{taskReqCardBean}", TaskReqCardBean.class).getValue(elContext);
            EngReqTaskJobcardBean engReqTaskJobcardBean = (EngReqTaskJobcardBean) application.getExpressionFactory()
                    .createValueExpression(elContext, "#{engReqTaskJobcardBean}", EngReqTaskJobcardBean.class).getValue(elContext);

        if (engDamageDimBean == null) {
            engDamageDimBean = new EngDamageDimBean();
        }
        if (engDamageTypeManufactBean == null) {
            engDamageTypeManufactBean = new EngDamageTypeManufactBean();
        }
        if (reqdimBean == null) {
            reqdimBean = new EngRequestDimenBean();
        }
        if (inge == null) {
            inge = new IngenierBean();
        }
        if (taskReqCard == null) {
            taskReqCard = new TaskReqCardBean();
        }
        if (engReqTaskJobcardBean == null) {
            engReqTaskJobcardBean = new EngReqTaskJobcardBean();
        }


        if(engDamageDimBean.getPKDamageType() != null){
            engDamageTypeManufactBean.setPKDamageType(engDamageDimBean.getPKDamageType());
        }    
         
           System.out.println("Nombre del daÃ±o creado: "+engDamageTypeManufactBean.getDamageName()); 
        if(engDamageTypeManufactBean.getDamageName() != null){
          //   reqdimBean.agregar();
           if(editando){
           reqdimBean.preUpdateLista();
           }else{
              reqdimBean.agregar();
              esr.elemento.setEngDamageType(engDamageTypeManufactBean.getSacarid());
           }
           
        }       
        if (listado2 == null) {
            listado2 = new ArrayList<>();
        }        
        
        
        if(esr.getEsrDocumentBean().listado.size()>0){
            existeArchivo=true;
        }
        
        
        //validamos que OPCO este en N
        if(contFacade.validparam(esr.elemento.getCompany())){
            existeArchivo=true;
        }
                
        if(existeArchivo==true){
        HttpSession session = SessionBean.getSession();
        String user = (String) session.getAttribute(userTabEsr);
        if (esr.elemento.getLogpage() == null && "AESV".equals(esr.elemento.getCompany())){
            taskCard=false;
        }else{
            taskCard=true;
        }
        
        if (taskCard) {
             esr.elemento.setReqComplete(completEsr);
            if(completEsr.equalsIgnoreCase("true")){
                setReasonEsr("");
            }
            esr.elemento.setReqReason(reasonEsr);
            esr.elemento.setReqCritical(criticalEsrb==true ? "1" : "0");
            esr.elemento.setReqAog(aogEsrb==true ? "1" : "0");
            
            if(compCheck){
            esr.elemento.setEngCompChk("Y");
            }else{
            esr.elemento.setEngCompChk("N");
            }
            esr.elemento.setEngTipoSolcitud("ESR");
            esr.guardar();
            setWorder("");
            setWorderid("");
            taskReqCard.listado = new ArrayList<>();
            taskReqCard.setTaskCards(new ArrayList<EngTaskCard>());
            setIngbutom(0);
            if("7".equals(roles)){
                esrcompanymec(usercompany);
                actESRMecanic(esr.elemento.getReqMessageid().toString());
            }
            if("2".equals(roles)){
                inge.cargarTodas();
            }
            llenarlistas();
            esr.elemento = new EngRequest();
            esr.limpiar();
            esr.elemento.setReqFechaIns(new Date());
            if("7".equals(roles)){
                esr.elemento.setReqUsersol(users);
                esr.elemento.setCompany(usercompany);
            }
            esr.elemento.setReqUsersol(nombresolicitante);
            setWorder("");
            setWorderid("");
            worderid = "";
            contid = null;            
            avion = null;
            custom = null;
            flota = null;
            desAta = null;
            reqdimBean.setDimenciones(null);
            engReqTaskJobcardBean.setDescripcion(null);
            limpiar2(2);
            completeAddOrUp();
              
        } else {
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puede agregar sin TaskCard"));
        }
        }
    }
    //Lista ECR:
         public void refrescarlistasECR(boolean editando) {
            System.out.println("INGRESANDO A REGISTRAR");
             extendtime();
            existeArchivo=false;
            boolean taskCard;
            
            FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();
            ELContext elContext = context.getELContext();
            EngDamageDimBean engDamageDimBean = (EngDamageDimBean) application.getExpressionFactory()
                    .createValueExpression(elContext, "#{engDamageDimBean}", EngDamageDimBean.class).getValue(elContext);
            EngDamageTypeManufactBean engDamageTypeManufactBean = (EngDamageTypeManufactBean) application.getExpressionFactory()
                    .createValueExpression(elContext, "#{engDamageTypeManufactBean}", EngDamageTypeManufactBean.class).getValue(elContext);
            EngRequestDimenBean reqdimBean = (EngRequestDimenBean) application.getExpressionFactory()
                    .createValueExpression(elContext, "#{reqdimBean}", EngRequestDimenBean.class).getValue(elContext);

            
            if (engDamageDimBean == null) {
                engDamageDimBean = new EngDamageDimBean();
            }
            if (engDamageTypeManufactBean == null) {
                engDamageTypeManufactBean = new EngDamageTypeManufactBean();
            }
            if (reqdimBean == null) {
                reqdimBean = new EngRequestDimenBean();
            }
            
            System.out.println("INGRESANDO A REGISTRAR");
            if(engDamageDimBean.getPKDamageType() != null){
                engDamageTypeManufactBean.setPKDamageType(engDamageDimBean.getPKDamageType());
            }    
            if(engDamageTypeManufactBean.getDamageName() != null){
               if(editando){
               reqdimBean.preUpdateLista();
               }else{
                  reqdimBean.agregar();
                  esr.elemento.setEngDamageType(engDamageTypeManufactBean.getSacarid());
               }

            }    
            System.out.println("PASANDO VALIDACION.");
        if (listado2 == null) {
            listado2 = new ArrayList<>();
        }        
        if(esr.getEsrDocumentBean().listado.size()>0){
            existeArchivo=true;
        }
        //OPCO='N'
        if(contFacade.validparam(esr.elemento.getCompany())){
            existeArchivo=true;
        }
        if(existeArchivo==true){
        HttpSession session = SessionBean.getSession();
        String user = (String) session.getAttribute(userTabEsr);
        if (esr.elemento.getLogpage() == null && "AESV".equals(esr.elemento.getCompany())){
            taskCard=false;
        }else{
            taskCard=true;
        }
        
        if (taskCard) {
            esr.elemento.setReqComplete(completEsr);
            esr.elemento.setReqReason(reasonEsr);
            esr.elemento.setReqCritical(criticalEsr);
            esr.elemento.setReqAog(aogEsr);
            
            if(compCheck){
            esr.elemento.setEngCompChk("Y");
            }else{
            esr.elemento.setEngCompChk("N");
            }
            esr.elemento.setEngTipoSolcitud("ECR");// INSERTANDOD UNA SOLICITUD DE HERRMIENTAS DE INGENIERIA
            esr.guardar();
            System.out.println("REGISTRO ECR");
            setWorder("");
            setWorderid("");
            TaskReqCardBean taskReqCard = (TaskReqCardBean) application.getExpressionFactory()
                    .createValueExpression(elContext, "#{taskReqCardBean}", TaskReqCardBean.class).getValue(elContext);
            if (taskReqCard == null) {
                taskReqCard = new TaskReqCardBean();
            }
            taskReqCard.listado = new ArrayList<>();
            taskReqCard.setTaskCards(new ArrayList<EngTaskCard>());
            setIngbutom(0);
            if("7".equals(roles)){
                esrcompanymec(usercompany);
                actESRMecanic(esr.elemento.getReqMessageid().toString());
            }
            if("2".equals(roles)){
                IngenierBean inge = (IngenierBean) application.getExpressionFactory()
                    .createValueExpression(elContext, "#{ingenierBean}", IngenierBean.class).getValue(elContext);
                if (inge == null) {
                    inge = new IngenierBean();
                }
                inge.cargarTodas();
            }
            llenarlistas();
            esr.elemento = new EngRequest();
            esr.limpiar();
            esr.elemento.setReqFechaIns(new Date());
            if("7".equals(roles)){
                esr.elemento.setReqUsersol(users);
                esr.elemento.setCompany(usercompany);
            }
            esr.elemento.setReqUsersol(nombresolicitante);
            setWorder("");
            setWorderid("");
            worderid = "";
            contid = null;            
            avion = null;
            custom = null;
            flota = null;
            desAta = null;
            reqdimBean.setDimenciones(null);
            EngReqTaskJobcardBean engReqTaskJobcardBean = (EngReqTaskJobcardBean) application.getExpressionFactory()
                    .createValueExpression(elContext, "#{engReqTaskJobcardBean}", EngReqTaskJobcardBean.class).getValue(elContext);
            if (engReqTaskJobcardBean == null) {
                engReqTaskJobcardBean = new EngReqTaskJobcardBean();
            }

            engReqTaskJobcardBean.setDescripcion(null);
            limpiar2(2);
            completeAddOrUp();
              
        } else {
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puede agregar sin TaskCard"));
        }
        }
        System.out.println("FINALIZO EL PROCESO DE INSERTAR.");
    }
    
     public void refrescarlistasETR(boolean editando) {
        
        /*parte para guardar el archivo*/
            extendtime();
            existeArchivo=false;
            boolean taskCard;
            
            FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();
            ELContext elContext = context.getELContext();
            EngDamageDimBean engDamageDimBean = (EngDamageDimBean) application.getExpressionFactory()
                .createValueExpression(elContext, "#{engDamageDimBean}", EngDamageDimBean.class).getValue(elContext);
            EngRequestDimenBean reqdimBean = (EngRequestDimenBean) application.getExpressionFactory()
                .createValueExpression(elContext, "#{reqdimBean}", EngRequestDimenBean.class).getValue(elContext);  
            EngDamageTypeManufactBean engDamageTypeManufactBean = (EngDamageTypeManufactBean) application.getExpressionFactory()
                .createValueExpression(elContext, "#{engDamageTypeManufactBean}", EngDamageTypeManufactBean.class).getValue(elContext);  
            IngenierBean inge = (IngenierBean) application.getExpressionFactory()
                .createValueExpression(elContext, "#{ingenierBean}", IngenierBean.class).getValue(elContext);
            TaskReqCardBean taskReqCard = (TaskReqCardBean) application.getExpressionFactory()
                .createValueExpression(elContext, "#{taskReqCardBean}", TaskReqCardBean.class).getValue(elContext);
			EngReqTaskJobcardBean engReqTaskJobcardBean = (EngReqTaskJobcardBean) application.getExpressionFactory()
                .createValueExpression(elContext, "#{engReqTaskJobcardBean}", EngReqTaskJobcardBean.class).getValue(elContext);
            																						
																									  
            if(engDamageDimBean==null){
                engDamageDimBean=new EngDamageDimBean();
            }
            if(reqdimBean==null){
                reqdimBean=new EngRequestDimenBean();
            }
            if(engDamageTypeManufactBean==null){
                engDamageTypeManufactBean=new EngDamageTypeManufactBean();
            }
            if(inge==null){
                inge=new IngenierBean();
            }
            if(taskReqCard==null){
                taskReqCard=new TaskReqCardBean();
            }
            if(engReqTaskJobcardBean==null){
                engReqTaskJobcardBean=new EngReqTaskJobcardBean();
            }
			
            System.out.println("Valor del PKDamageType en engDamageDimBean: "+engDamageDimBean.getPKDamageType());
            System.out.println("Valor del PKDamageType en engDamageTypeManufactBean: "+engDamageTypeManufactBean.getPKDamageType());
            if(engDamageDimBean.getPKDamageType() != null){
                engDamageTypeManufactBean.setPKDamageType(engDamageDimBean.getPKDamageType());
            }    
         
           System.out.println("Nombre del daÃ±o creado: "+engDamageTypeManufactBean.getDamageName()); 
            if(engDamageTypeManufactBean.getDamageName() != null){
              //   reqdimBean.agregar();
               if(editando){
               reqdimBean.preUpdateLista();
               }else{
                  reqdimBean.agregar();
                  esr.elemento.setEngDamageType(engDamageTypeManufactBean.getSacarid());
               }

            }    
        
        System.out.println("ingresando el ID del daÃ±o: "+esr.elemento.getEngDamageType());
        if (listado2 == null) {
            listado2 = new ArrayList<>();
        }        
        
        
        if(esr.getEsrDocumentBean().listado.size()>0){
            existeArchivo=true;
        }
        
        
        //validamos que OPCO este en N
        if(contFacade.validparam(esr.elemento.getCompany())){
            existeArchivo=true;
        }
        
                
        if(existeArchivo==true){
        HttpSession session = SessionBean.getSession();
        String user = (String) session.getAttribute(userTabEsr);
        if (esr.elemento.getLogpage() == null && "AESV".equals(esr.elemento.getCompany())){
            taskCard=false;
        }else{
            taskCard=true;
        }
        
        if (taskCard) {
            esr.elemento.setReqComplete(completEsr);
            esr.elemento.setReqReason(reasonEsr);
            esr.elemento.setReqCritical(criticalEsr);
            esr.elemento.setReqAog(aogEsr);
            
            if(compCheck){
            esr.elemento.setEngCompChk("Y");
            }else{
            esr.elemento.setEngCompChk("N");
            }
            esr.elemento.setEngTipoSolcitud("ETR");// INSERTANDOD UNA SOLICITUD DE HERRMIENTAS DE INGENIERIA
            esr.guardar();
            setWorder("");
            setWorderid("");
            taskReqCard.listado = new ArrayList<>();
            taskReqCard.setTaskCards(new ArrayList<EngTaskCard>());
            setIngbutom(0);
            if("7".equals(roles)){
                esrcompanymec(usercompany);
                actESRMecanic(esr.elemento.getReqMessageid().toString());
            }
            if("2".equals(roles)){
                inge.cargarTodas();
            }
            llenarlistas();
            esr.elemento = new EngRequest();
            esr.limpiar();
            esr.elemento.setReqFechaIns(new Date());
            if("7".equals(roles)){
                esr.elemento.setReqUsersol(users);
                esr.elemento.setCompany(usercompany);
            }
            esr.elemento.setReqUsersol(nombresolicitante);
            setWorder("");
            setWorderid("");
            worderid = "";
            contid = null;            
            avion = null;
            custom = null;
            flota = null;
            desAta = null;
            reqdimBean.setDimenciones(null);
            engReqTaskJobcardBean.setDescripcion(null);
            limpiar2(2);
            completeAddOrUp();
              
        } else {
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puede agregar sin TaskCard"));
        }
        }
    }
    
     public void completeAddOrUp(){
        extendtime();

        ContCheck contCHK = new ContCheck();
        try {
            if (getWorkOrderJob()!= null) {
                if(!getWorkOrderJob().isEmpty()){
                    contCHK = contFacade.find(new BigDecimal(getWorkOrderJob()));
                    autoComplete(contCHK.getChkRegistry(),contCHK.getCheckCompany(),contCHK.getContCheckId().toString());                
                }                
            } 
        } catch (Exception x) {
            Logger.getLogger(TabEsrEaEo.class.getName()).log(Level.SEVERE, null, x);
        }
        
    }
    
  
    public void actESRMecanic(String id) {
        extendtime();
        try {
			
            FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();
            ELContext elContext = context.getELContext();
            EngHorasIngBean engHorasIngBean = (EngHorasIngBean) application.getExpressionFactory()
                .createValueExpression(elContext, "#{engHorasIngBean}", EngHorasIngBean.class).getValue(elContext);
            EngDamageTypeManufactBean engDamageTypeManufactBean = (EngDamageTypeManufactBean) application.getExpressionFactory()
                .createValueExpression(elContext, "#{engDamageTypeManufactBean}", EngDamageTypeManufactBean.class).getValue(elContext);
        																			  
																		   
            if(engHorasIngBean==null){
                engHorasIngBean=new EngHorasIngBean();
            }
            if(engDamageTypeManufactBean==null){
                engDamageTypeManufactBean=new EngDamageTypeManufactBean();
            }
			
            if (!id.isEmpty()) {
                BigInteger woid = new BigInteger(id);
                listfiltro2 = engEsrListViewFacade.find(woid);
                setIdEsrWo(listfiltro2.getWoorder().substring(0, listfiltro2.getWoorder().indexOf("- ")));
                engHorasIngBean.redireccionar2(id);
                setIdor(2);
                esr.elemento.setCompany(usercompany);
                setWorder("");
                setWorderid("");
                esr.edit = false;
                esr.elemento.setReqFechaIns(new Date());
                //engDamageDimBean.limpiarListas();
                engDamageTypeManufactBean.limpiarListas();
            } else {
                esr.limpiar();
                setIdor(2);
                //engDamageDimBean.limpiarListas();
                engDamageTypeManufactBean.limpiarListas();
            }
        } catch (Exception x) {
            Logger.getLogger(TabEsrEaEo.class.getName()).log(Level.SEVERE, null, x);
        }
    }

    public void actESRMecanic2(String id) {
        extendtime();
        try {
			
            FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();
            ELContext elContext = context.getELContext();            
            EngRequestDimenBean reqdimBean = (EngRequestDimenBean) application.getExpressionFactory()
            .createValueExpression(elContext, "#{reqdimBean}", EngRequestDimenBean.class).getValue(elContext);  
            EngDamageTypeManufactBean engDamageTypeManufactBean = (EngDamageTypeManufactBean) application.getExpressionFactory()
                .createValueExpression(elContext, "#{engDamageTypeManufactBean}", EngDamageTypeManufactBean.class).getValue(elContext);  
            TaskReqCardBean taskReqCard = (TaskReqCardBean) application.getExpressionFactory()
                .createValueExpression(elContext, "#{taskReqCardBean}", TaskReqCardBean.class).getValue(elContext);            
            EngHorasIngBean engHorasIngBean = (EngHorasIngBean) application.getExpressionFactory()
                .createValueExpression(elContext, "#{engHorasIngBean}", EngHorasIngBean.class).getValue(elContext);
            
																							
            if(reqdimBean==null){
                reqdimBean=new EngRequestDimenBean();
            }
            if(engDamageTypeManufactBean==null){
                engDamageTypeManufactBean=new EngDamageTypeManufactBean();
            }
            if(taskReqCard==null){
                taskReqCard=new TaskReqCardBean();
            }
            if(engHorasIngBean==null){
                engHorasIngBean=new EngHorasIngBean();
            }
			
            if (!id.isEmpty()) {
                esr.setEdit(true);
                int idRequest = Integer.parseInt(id);
                BigInteger woid = new BigInteger(id);
                listfiltro2 = engEsrListViewFacade.find(woid);
                setIdEsrWo(listfiltro2.getWoorder().substring(0, listfiltro2.getWoorder().indexOf("- ")));
                elemnts = (EngRequest) esr.findSelect(id);
                esr.setElemento(elemnts);
                
                esr.setPKAffectedPart(elemnts.getReqAfpId().getAfpId().toString() + "-" + elemnts.getReqAfpId().getAfpName());
                BigDecimal idesr = new BigDecimal(elemnts.getReqMessageid());
                reqdimBean.findAllNotDeleted(idesr);

                esr.esrInicial(elemnts);
                engHorasIngBean.redireccionar2(id);
                setWorder(numax.woEsr(idRequest));
                ContCheck idwo = contFacade.find(elemnts.getChkCheckid());
                setWorderid(idwo.getChkWo());
                customeravion(String.valueOf(idwo.getContCheckId()));
                setIdor(2);
                taskReqCard.limpiar();
                taskReqCard.agregarESR(elemnts);
                worder = numax.woEsr(idRequest);
                ContAtas ata = contAtasFacade.find(elemnts.getAtaNumata());
                desAta = ata.getAtaNumata()+"-"+ata.getAtaDescription();
                existeata = false;
                //engDamageDimBean.limpiarListas();
                engDamageTypeManufactBean.limpiarListas();
            } else {
                esr.limpiar();
                setIdor(2);
                //engDamageDimBean.limpiarListas();
                engDamageTypeManufactBean.limpiarListas();
            }
        } catch (NumberFormatException | IOException x) {
            Logger.getLogger(TabEsrEaEo.class.getName()).log(Level.SEVERE, null, x);
        }
    }

    public void eo() {
        try {
            setIdor(3);
        } catch (Exception x) {
            Logger.getLogger(TabEsrEaEo.class.getName()).log(Level.SEVERE, null, x);
        }
    }

    public void reportEo() {
        try {
			
            FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();
            ELContext elContext = context.getELContext();            
            ReportesSeguiCheqBean reportesSeguiCheqBean = (ReportesSeguiCheqBean) application.getExpressionFactory()
            .createValueExpression(elContext, "#{reportesSeguiCheqBean}", ReportesSeguiCheqBean.class).getValue(elContext);  
            
																						  
            if(reportesSeguiCheqBean==null){
                reportesSeguiCheqBean=new ReportesSeguiCheqBean();
            }
			
            reportesSeguiCheqBean.llenarEngOrder();
            setIdor(13);

        } catch (Exception x) {
            Logger.getLogger(TabEsrEaEo.class.getName()).log(Level.SEVERE, null, x);
        }
    }

    public void customeravion(String wo) {
        extendtime();
        //Short idWo = Short.parseShort(wo);
        BigDecimal idWo = new BigDecimal(wo);
        try {
            ContCheck tail = new ContCheck();
            //tail = contFacade.findByid(idWo);
            tail = contFacade.find(idWo);
            if (tail != null ){
				
		FacesContext context = FacesContext.getCurrentInstance();
                Application application = context.getApplication();
                ELContext elContext = context.getELContext();
                WorkOrderBean workOrderbean = (WorkOrderBean) application.getExpressionFactory()
                    .createValueExpression(elContext, "#{workOrderBean}", WorkOrderBean.class).getValue(elContext);
                EngDamageTypeManufactBean engDamageTypeManufactBean = (EngDamageTypeManufactBean) application.getExpressionFactory()
                    .createValueExpression(elContext, "#{engDamageTypeManufactBean}", EngDamageTypeManufactBean.class).getValue(elContext);  
                TaskReqCardBean taskReqCard = (TaskReqCardBean) application.getExpressionFactory()
                    .createValueExpression(elContext, "#{taskReqCardBean}", TaskReqCardBean.class).getValue(elContext);
        																					  
                if(workOrderbean==null){
                    workOrderbean=new WorkOrderBean();
                }
                if(engDamageTypeManufactBean==null){
                    engDamageTypeManufactBean=new EngDamageTypeManufactBean();
                }
                if(taskReqCard==null){
                    taskReqCard=new TaskReqCardBean();
                }
				
                setIdcontcke(tail.getContCheckId().shortValueExact());
                setAvion(tail.getChkRegistry().trim());
                setCustom(tail.getChkCucod().trim());
                setFlota(tail.getChkModel().trim());
                engDamageTypeManufactBean.setFlota(tail.getChkModel().trim());
                esr.elemento.setChkCheckid(tail.getContCheckId().shortValueExact());
                esr.elemento.setReqRegistry(tail.getChkRegistry().trim());
                esr.elemento.setReqCustomer(tail.getChkCucod().trim());
                esr.elemento.setFltCod(tail.getChkModel().trim());
                taskReqCard.filtroTaskCard(tail.getContCheckId().toString());
                msnWork=tail.getChkMsn();
                if(tail.getChkTtsn() != null){
                    hoursWork=tail.getChkTtsn().toString();
                }
                
                if(tail.getChkTcsn()!= null){
                    cyclesWork=tail.getChkTcsn().toString();
                }
               
                setErrorTarjeta(null);
                workOrderbean.autowo = new ArrayList<>();
                //workOrderbean.elemento = contFacade.find(esr.elemento.getChkCheckid());
                //workOrderbean.autowo = contFacade.findByCompAndID(esr.elemento.getCompany(),esr.elemento.getChkCheckid());
                workOrderbean.elemento = contFacade.find(new BigDecimal(esr.elemento.getChkCheckid()));
                workOrderbean.autowo = contFacade.findByCompAndID(esr.elemento.getCompany(),esr.elemento.getChkCheckid());
            }
            else{
                setAvion(null);
                setCustom(null);
                setFlota(null);
            }
            
        } catch (Exception e) {
            Logger.getLogger(TabEsrEaEo.class.getName()).log(Level.SEVERE, null, e);
        }

    }
    
    // ETR
       
    public void customeravionETR(String wo) {
        extendtime();
		
        BigDecimal idWo = new BigDecimal(wo);
        try {
            ContCheck tail = new ContCheck();
            tail = contFacade.find(idWo);
            if (tail != null ){
				
		FacesContext context = FacesContext.getCurrentInstance();
                Application application = context.getApplication();
                ELContext elContext = context.getELContext();
                WorkOrderBean workOrderbean = (WorkOrderBean) application.getExpressionFactory()
                    .createValueExpression(elContext, "#{workOrderBean}", WorkOrderBean.class).getValue(elContext);
                EngDamageTypeManufactBean engDamageTypeManufactBean = (EngDamageTypeManufactBean) application.getExpressionFactory()
                    .createValueExpression(elContext, "#{engDamageTypeManufactBean}", EngDamageTypeManufactBean.class).getValue(elContext);  
                TaskReqCardBean taskReqCard = (TaskReqCardBean) application.getExpressionFactory()
                    .createValueExpression(elContext, "#{taskReqCardBean}", TaskReqCardBean.class).getValue(elContext);
            																									
																							  
                if(workOrderbean==null){
                    workOrderbean=new WorkOrderBean();
                }
                if(engDamageTypeManufactBean==null){
                    engDamageTypeManufactBean=new EngDamageTypeManufactBean();
                }
                if(taskReqCard==null){
                    taskReqCard=new TaskReqCardBean();
                }
				
                setIdcontcke(tail.getContCheckId().shortValueExact());
                setAvion(tail.getChkRegistry().trim());
                setCustom(tail.getChkCucod().trim());
                setFlota(tail.getChkModel().trim());
                engDamageTypeManufactBean.setFlota(tail.getChkModel().trim());
                esr.elemento.setChkCheckid(tail.getContCheckId().shortValueExact());
                esr.elemento.setReqRegistry(tail.getChkRegistry().trim());
                esr.elemento.setReqCustomer(tail.getChkCucod().trim());
                esr.elemento.setFltCod(tail.getChkModel().trim());
                taskReqCard.filtroTaskCard(tail.getContCheckId().toString());
                msnWork=tail.getChkMsn();
                if(tail.getChkTtsn() != null){
                    hoursWork=tail.getChkTtsn().toString();
                }
                
                if(tail.getChkTcsn()!= null){
                    cyclesWork=tail.getChkTcsn().toString();
                }
               
                setErrorTarjeta(null);
                workOrderbean.autowo = new ArrayList<>();

                workOrderbean.elemento = contFacade.find(new BigDecimal(esr.elemento.getChkCheckid()));
                workOrderbean.autowo = contFacade.findByCompAndID(esr.elemento.getCompany(),esr.elemento.getChkCheckid());
            }
            else{
                setAvion(null);
                setCustom(null);
                setFlota(null);
            }
            
        } catch (Exception e) {
            Logger.getLogger(TabEsrEaEo.class.getName()).log(Level.SEVERE, null, e);
        }

    }
    
    
    public void agregarTaskCard() {
        extendtime();
        try {
			
            FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();
            ELContext elContext = context.getELContext();
            TaskReqCardBean taskReqCardBean = (TaskReqCardBean) application.getExpressionFactory()
                .createValueExpression(elContext, "#{taskReqCardBean}", TaskReqCardBean.class).getValue(elContext);
            
            if(taskReqCardBean==null){
                taskReqCardBean=new TaskReqCardBean();
            }
			
            String respuesta = taskReqCardBean.infoTaskCard(worderid);
            if ("continue".equals(respuesta)) {
                esr.cambiarWCCCard();
                errorTarjeta = null;
                Date dateactual = new Date();
                SimpleDateFormat getanio = new SimpleDateFormat("yyyy");
                String anio = getanio.format(dateactual.getTime());
                taskReqCardBean.setTkyear(anio);
            } else if ("tajeta no pertenece".equals(respuesta)) {
                errorTarjeta = "tailnopertenece";
            } else {
                errorTarjeta = "tcnotfound";
            }

        } catch (Exception e) {
            Logger.getLogger(TabEsrEaEo.class.getName()).log(Level.SEVERE, null, e);
        }

    }
    
    public void limpiarTaskcard(){
         extendtime();
		 
	FacesContext context = FacesContext.getCurrentInstance();
        Application application = context.getApplication();
        ELContext elContext = context.getELContext();
        TaskReqCardBean taskReqCardBean = (TaskReqCardBean) application.getExpressionFactory()
                .createValueExpression(elContext, "#{taskReqCardBean}", TaskReqCardBean.class).getValue(elContext);
        
        if(taskReqCardBean==null){
           taskReqCardBean=new TaskReqCardBean();
        }
        
        taskReqCardBean.limpiar();
         errorTarjeta = null;
    }

    public void engHours(Short id) {
        extendtime();
        try {
            String idh = String.valueOf(id);
			
            FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();
            ELContext elContext = context.getELContext();        
            EngHorasIngBean engHorasIngBean = (EngHorasIngBean) application.getExpressionFactory()
                .createValueExpression(elContext, "#{engHorasIngBean}", EngHorasIngBean.class).getValue(elContext);
            
            if(engHorasIngBean==null){
                engHorasIngBean=new EngHorasIngBean();
            }
			
            engHorasIngBean.redireccionar2(idh);
            setIdor(7);
        } catch (Exception x) {
            Logger.getLogger(TabEsrEaEo.class.getName()).log(Level.SEVERE, null, x);
        }
    }

    public void updateesrbyuser(String user86, String esrid) {
        try {
            extendtime();
            if (!("0").equals(user86)) {
                listInge = new ArrayList<>();
                BigInteger busidesr = new BigInteger(esrid);
                EngRequest buscar = requestFacade.find(busidesr);
                buscar.setReqCodIngEnc(user86);
                esrcompanysup(buscar.getCompany());
                requestFacade.edit(buscar);
                listInge = taskviewfacade.findAll();
				
		FacesContext context = FacesContext.getCurrentInstance();
                Application application = context.getApplication();
                ELContext elContext = context.getELContext();
                IngenierBean inge = (IngenierBean) application.getExpressionFactory()
                    .createValueExpression(elContext, "#{ingenierBean}", IngenierBean.class).getValue(elContext);

                if(inge==null){
                    inge=new IngenierBean();
                }
				
                inge.listado.clear();
                inge.listado = coreUsersVwFacade.findAll();
                inge.cargarTodas();
                this.acteng(esrid);
            }
        } catch (Exception x) {
            Logger.getLogger(TabEsrEaEo.class.getName()).log(Level.SEVERE, null, x);
        }
    }

    public void insertea() {
        try {
            extendtime();
            HttpSession session = SessionBean.getSession();
            String user = (String) session.getAttribute(userTabEsr);

            engAutorization.edit = algotienequetraer;
            engAutorization.guardar();
            algotienequetraer = false;
            this.limpiar2(1);

        } catch (Exception x) {
            Logger.getLogger(TabEsrEaEo.class.getName()).log(Level.SEVERE, null, x);
        }
    }

    //ECR:
    public void customeravionECR(String wo) {
        extendtime();
        BigDecimal idWo = new BigDecimal(wo);
        try {
            ContCheck tail = new ContCheck();
            tail = contFacade.find(idWo);
            if (tail != null ){
                
                FacesContext context = FacesContext.getCurrentInstance();
                Application application = context.getApplication();
                ELContext elContext = context.getELContext();
                WorkOrderBean workOrderbean = (WorkOrderBean) application.getExpressionFactory()
                    .createValueExpression(elContext, "#{workOrderBean}", WorkOrderBean.class).getValue(elContext);
                EngDamageTypeManufactBean engDamageTypeManufactBean = (EngDamageTypeManufactBean) application.getExpressionFactory()
                    .createValueExpression(elContext, "#{engDamageTypeManufactBean}", EngDamageTypeManufactBean.class).getValue(elContext);  
                TaskReqCardBean taskReqCard = (TaskReqCardBean) application.getExpressionFactory()
                    .createValueExpression(elContext, "#{taskReqCardBean}", TaskReqCardBean.class).getValue(elContext);
                
                if(workOrderbean==null){
                    workOrderbean=new WorkOrderBean();
                }
                if(engDamageTypeManufactBean==null){
                    engDamageTypeManufactBean=new EngDamageTypeManufactBean();
                }
                if(taskReqCard==null){
                    taskReqCard=new TaskReqCardBean();
                }
                
                setIdcontcke(tail.getContCheckId().shortValueExact());
                setAvion(tail.getChkRegistry().trim());
                setCustom(customerSelected);//customer
                setFlota(tail.getChkModel().trim());
                engDamageTypeManufactBean.setFlota(tail.getChkModel().trim());
                esr.elemento.setChkCheckid(tail.getContCheckId().shortValueExact());
                esr.elemento.setReqRegistry(tail.getChkRegistry().trim());
                esr.elemento.setReqCustomer(customerSelected);//customer
                esr.elemento.setFltCod(tail.getChkModel().trim());
                taskReqCard.filtroTaskCard(tail.getContCheckId().toString());
                msnWork=tail.getChkMsn();
                if(tail.getChkTtsn() != null){
                    hoursWork=tail.getChkTtsn().toString();
                }
                
                if(tail.getChkTcsn()!= null){
                    cyclesWork=tail.getChkTcsn().toString();
                }
               
                setErrorTarjeta(null);
                workOrderbean.autowo = new ArrayList<>();

                workOrderbean.elemento = contFacade.find(new BigDecimal(esr.elemento.getChkCheckid()));
                workOrderbean.autowo = contFacade.findByCompAndID(esr.elemento.getCompany(),esr.elemento.getChkCheckid());
            }
            else{
                setAvion(null);
                setCustom(null);
                setFlota(null);
            }
            
        } catch (Exception e) {
            Logger.getLogger(TabEsrEaEo.class.getName()).log(Level.SEVERE, null, e);
        }

    }
    
    

    public void intance(String iding, Long idact, String tipoAct) {
        try {
            extendtime();
            if ("EA".equals(tipoAct.trim()) && idact != 0 && iding != null) {
                BigDecimal idactB = BigDecimal.valueOf(idact);
                engAutorization.actualiza(idactB, iding);

            }
            if ("ESR".equals(tipoAct.trim()) && idact != 0 && iding != null) {
                BigDecimal idactB = BigDecimal.valueOf(idact);
                esr.actualiza(idactB, iding);

            }
			
            FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();
            ELContext elContext = context.getELContext();
            IngenierBean inge = (IngenierBean) application.getExpressionFactory()
                .createValueExpression(elContext, "#{ingenierBean}", IngenierBean.class).getValue(elContext);
            
            if(inge==null){
                inge=new IngenierBean();
            }

            inge.init();
        } catch (Exception x) {
            Logger.getLogger(TabEsrEaEo.class.getName()).log(Level.SEVERE, null, x);
        }

    }
    
    public void guardarEA(){
        extendtime();
        if(engAutorization.edit){
            engAutorization.actualizar();
             refreshEA();
        }else{
            engAutorization.agregar();
            //llenarlistas();
             refreshEA();
            
        }
    }
    public void cancelarEA(){
        extendtime();
        engAutorization.cancelarEA();
         refreshEA();
    }
    
    public void refreshEA(){
        actESR(elemnts.getReqMessageid().toString());
        limpiar2(1);
    }

    public void actEA(String id) {
        try {
															 
            DateFormat dateFormat = new SimpleDateFormat("yy"); 
            extendtime();
            if (id == null){
            id="";
            }
            if(!id.isEmpty()){            
                elemntt = engAutorization.findSelect(id);
                setIdor(1);
				
		FacesContext context = FacesContext.getCurrentInstance();
                Application application = context.getApplication();
                ELContext elContext = context.getELContext();
                EaPdfBean eaPdfBeans = (EaPdfBean) application.getExpressionFactory()
                    .createValueExpression(elContext, "#{eaPdfBean}", EaPdfBean.class).getValue(elContext);
                
                if(eaPdfBeans==null){
                    eaPdfBeans=new EaPdfBean();
                }
				
                eaPdfBeans.elemento.setEagId(elemntt.getEagId().toBigInteger());
                engAutorization.setElemento(elemntt);
                engAutorization.setYear(engAutorization.elemento.getEagYear().toString());
                engAutorization.elemento.setYearEA(dateFormat.format(elemntt.getAegDateCrea()));
                engAutorization.edit = true;
                setAlgotienequetraer(true);
            }
        } catch (Exception x) {
            Logger.getLogger(TabEsrEaEo.class.getName()).log(Level.SEVERE, null, x);
        }
															
    }

    public void actESR(String id) {
        try {
															  
            extendtime();   
															   
            FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();
            ELContext elContext = context.getELContext();
            WorkOrderBean workOrderbean = (WorkOrderBean) application.getExpressionFactory()
                .createValueExpression(elContext, "#{workOrderBean}", WorkOrderBean.class).getValue(elContext);
            EngRequestDimenBean reqdimBean = (EngRequestDimenBean) application.getExpressionFactory()
                .createValueExpression(elContext, "#{reqdimBean}", EngRequestDimenBean.class).getValue(elContext);  
            EngDamageTypeManufactBean engDamageTypeManufactBean = (EngDamageTypeManufactBean) application.getExpressionFactory()
                .createValueExpression(elContext, "#{engDamageTypeManufactBean}", EngDamageTypeManufactBean.class).getValue(elContext);  
            TaskReqCardBean taskReqCard = (TaskReqCardBean) application.getExpressionFactory()
                .createValueExpression(elContext, "#{taskReqCardBean}", TaskReqCardBean.class).getValue(elContext);
            EaPdfBean eaPdfBeans = (EaPdfBean) application.getExpressionFactory()
                .createValueExpression(elContext, "#{eaPdfBean}", EaPdfBean.class).getValue(elContext);
            EngRequestQuestionBean engRequestQuestionBean = (EngRequestQuestionBean) application.getExpressionFactory()
                .createValueExpression(elContext, "#{engRequestQuestionBean}", EngRequestQuestionBean.class).getValue(elContext);
            EngDentBean engDentBean = (EngDentBean) application.getExpressionFactory()
                .createValueExpression(elContext, "#{engDentBean}", EngDentBean.class).getValue(elContext);
            EngReqTaskJobcardBean engReqTaskJobcardBean = (EngReqTaskJobcardBean) application.getExpressionFactory()
                .createValueExpression(elContext, "#{engReqTaskJobcardBean}", EngReqTaskJobcardBean.class).getValue(elContext);
            																			
																						  
            if(workOrderbean==null){
                workOrderbean=new WorkOrderBean();
            }
            if(reqdimBean==null){
                reqdimBean=new EngRequestDimenBean();
            }
            if(engDamageTypeManufactBean==null){
                engDamageTypeManufactBean=new EngDamageTypeManufactBean();
            }
            if(taskReqCard==null){
                taskReqCard=new TaskReqCardBean();
            }
            if(eaPdfBeans==null){
                eaPdfBeans=new EaPdfBean();
            }
            if(engRequestQuestionBean==null){
                engRequestQuestionBean=new EngRequestQuestionBean();
            }
            if(engDentBean==null){
                engDentBean=new EngDentBean();
            }
            if(engReqTaskJobcardBean==null){
                engReqTaskJobcardBean=new EngReqTaskJobcardBean();
            }
			
																		   
            existeArchivo=true;
            tipoSolicitud="";
            esr.setExisteAffectedPart(false);
            esr.setExisteDamageType(false);
            //engDamageDimBean.limpiarListas(); // se entra a este metodo cuando se selecciona una esr desde la tabla 
																		   
            engDamageTypeManufactBean.limpiarListas();
																			  
            listfiltro2 = new EngEsrListView();
            tempId = id;
            eaPdfBeans.setIdor(2);//para que se desaparezca la pantalla de tracking de EA ya que lo setean javascript
            int idrequest = Integer.parseInt(id);
            BigInteger reqid = new BigInteger(String.valueOf(idrequest));
            BigInteger woid = new BigInteger(id);
																		 
            listfiltro2 = engEsrListViewFacade.find(woid);
																			
            setIdEsrWo(listfiltro2.getWoorder().substring(0, listfiltro2.getWoorder().indexOf("- ")));
																		
            elemnts = (EngRequest) esr.findSelect(id);
              
            esr.setPKAffectedPart(elemnts.getReqAfpId().getAfpId().toString() + "-" + elemnts.getReqAfpId().getAfpName());
            
            
            
																   
            BigDecimal idesr = new BigDecimal(elemnts.getReqMessageid());
			
            engRequestQuestionBean.findForESR(elemnts);
            engDentBean.findForESR(elemnts);
            engDamageTypeManufactBean.llenarValorDamageType();
         //engDamageDimBean.llenarValorDamageType();
            reqdimBean.findAllNotDeleted(idesr);
            
            engReqTaskJobcardBean.setEngEr(elemnts);
            reqdimBean.setEngEr(elemnts);
            engRequestQuestionBean.setEngEr(elemnts);
            engDentBean.setEngEr(elemnts);
            engRequestQuestionBean.setUserlg(users);
            
            setCompletEsr(elemnts.getReqComplete());
            setReasonEsr(elemnts.getReqReason());
            setCriticalEsr(elemnts.getReqCritical());
            setAogEsr(elemnts.getReqAog());
            
            if("1".equals(elemnts.getReqCritical())){
                setCriticalEsrb(true);
            }else{
                setCriticalEsrb(false);
            }
            if("1".equals(elemnts.getReqAog())){
                setAogEsrb(true);
            }else{
                setAogEsrb(false);
            }
            if("false".equals(elemnts.getReqComplete())){
                setCompletEsrb(true);
            }else{
                setCompletEsrb(false);
            }
            
            trackingesrbean.elemento.setReqMessageid(elemnts.getReqMessageid());
            esr.setElemento(elemnts);
            boolean check = elemnts.getEngCompChk()==null ? false : elemnts.getEngCompChk().equals("Y");
            esr.setCompCheck(check);
            esr.esrInicial(elemnts);
//            engDamageDimBean.setNameDameEvent(elemnts.getReqRetDescription());
//            engDamageDimBean.findlistado2();
//            engDamageDimBean.setNameDameEvent("");

            engDamageTypeManufactBean.setNameDameEvent(elemnts.getReqRetDescription());
            System.out.println("NameDameEvent: "+elemnts.getReqRetDescription());
            engDamageTypeManufactBean.setIddamage(elemnts.getEngDamageType());
            engDamageTypeManufactBean.findlistado2();
            engDamageTypeManufactBean.setNameDameEvent("");

            //ContCheck idWo = contFacade.find(elemnts.getChkCheckid());
																	   
            ContCheck idWo = contFacade.find(new BigDecimal(elemnts.getChkCheckid()));
            setWorderid(idWo.getChkWo());
																		  
            if(elemnts.getEngTipoSolcitud().equals("ETR")){
                 customeravionETR(String.valueOf(idWo.getContCheckId()));
            }else{
                 customeravion(String.valueOf(idWo.getContCheckId()));
            }
            
            tipoSolicitud=elemnts.getEngTipoSolcitud();
            trackingesrbean.setTipoSocilictudTracking(tipoSolicitud);
            setIdor(2);
            listTavea = new ArrayList<>();
            listTavea = numax.esrEA(reqid);
            listTavall = new ArrayList<>();
            setWorder(numax.woEsr(idrequest));
            esr.edit = true;
            taskReqCard.limpiar();
            taskReqCard.agregarESR(elemnts);
            engAutorization.agregarESR(elemnts);
            
            int numESR= 0;
            String reCorr = "";
            String reqYear = "";
            
            try {
                HttpSession sessionr = SessionBean.getSession();
                numESR = elemnts.getAtaNumata();
                reCorr = elemnts.getReqCorr();
                reqYear = elemnts.getReqYear().substring(2,4);
                
                sessionr.setAttribute("Re_numESR", numESR);
                sessionr.setAttribute("Re_reCorr", reCorr);
                sessionr.setAttribute("Re_reqYear", reqYear);

            } catch (Exception e) {
                 Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            }
            
            DateFormat dateFormat = new SimpleDateFormat("yy");  
																			 
            for (EngEaGeneral listadoEng1 : listTavea) {
                Object[] li = new Object[2];  
                listadoEng1.setYearEA(dateFormat.format(listadoEng1.getAegDateCrea()));
                
                if (listadoEng1.getAegIngComm() != null) {
                    listadoEng1.setUserEA(sgrUser.findSelectUser(listadoEng1.getAegIngComm()).getFullUserName());
                }else{
                    listadoEng1.setUserEA("NA");
                }
                listadoEng1.setEsrEA(getWorder());
                li[1] = listadoEng1;
                li[0] = "EA";
                listTavall.add(li);
            }
																				
            if (listTavall.isEmpty()) {
                EngEaGeneral enEaNa = new EngEaGeneral();
                Object[] liNa = new Object[2];
                liNa[1] = enEaNa;
                liNa[0] = "NA";
                listTavall.add(liNa);
            }
																	 
            listAll = listTavall;
            listadoTabEa = listTavea;
            ContAtas ata = contAtasFacade.find(elemnts.getAtaNumata());
            desAta = ata.getAtaNumata()+"-"+ata.getAtaDescription();
            existeata = false;
            workOrderbean.autowo = new ArrayList<>();
																				  
            workOrderbean.autowo = contFacade.findByCompAndID(esr.elemento.getCompany(),esr.elemento.getChkCheckid());
            findAdjuntos(elemnts.getReqMessageid().toString());

        } catch (NumberFormatException | IOException x) {
            Logger.getLogger(TabEsrEaEo.class.getName()).log(Level.SEVERE, null, x);
        }
															 
    }
    public void allEsr(){
        try {
            extendtime();
            HttpSession session = SessionBean.getSession();
            String user = (String) session.getAttribute(userTabEsr);
            listesrcompany.clear();
            List<EngEsrListView> listuserAll = new ArrayList<>();
            int x = 0;
            while (x < listfiltro.size()) {

                EngEsrListView com = (EngEsrListView) listfiltro.get(x);
                if (com.getUsrCoduser() == null || com.getUsrCoduser().equals(user) || ("0").equals(com.getUsrCoduser())) {
                    listuserAll.add(com);
                }
                x++;
            }
            listfiltro = listuserAll;
        } catch (Exception e) {
            Logger.getLogger(TabEsrEaEo.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    
    public void allEsrCompany(){
        extendtime();
        llenarlistas();
    }
    public void esrcompanymec(String company) {
        try {
            extendtime();
            listesrcompanymec = new ArrayList<>();
            listadouserins = taskviewfacade.findAll(); // work Order Job
          
            if (workOrderJob!= null){
                listesrcompanymec= engEsrListViewFacade.findByWorkOrder(new BigDecimal(workOrderJob));
            }

        } catch (Exception x) {
            Logger.getLogger(TabEsrEaEo.class.getName()).log(Level.SEVERE, null, x);
        }
    }

    public void esrcompanysup(String company) {
        try {
            extendtime();
            List<EngTaskListView> listadocom2 = taskviewfacade.findAll();
            if (listesrcompanysup != null) {
                listesrcompanysup.clear();
            }

            List<EngTaskListView> listadocom = new ArrayList<>();

            for (EngTaskListView com : listadocom2) {

                if (com.getCompany() != null && com.getCompany().equals(company)) {
                    listadocom.add(com);
                }

            }
            listesrcompanysup = listadocom;

        } catch (Exception x) {
            Logger.getLogger(TabEsrEaEo.class.getName()).log(Level.SEVERE, null, x);
        }
    }

    

    public void actTodas(Object[] id) {
        if (("EA").equals(id[0])) {
            EngEaGeneral it = (EngEaGeneral) id[1];
            actEA(it.getEagId().toString());
        }
    }

    public void ea(String id) {
        try {
            extendtime();
            elemntt = (EngEaGeneral) engAutorization.findSelect(id);
			
            FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();
            ELContext elContext = context.getELContext();
            EaPdfBean eaPdfBeans = (EaPdfBean) application.getExpressionFactory()
                .createValueExpression(elContext, "#{eaPdfBean}", EaPdfBean.class).getValue(elContext);
            
            if(eaPdfBeans==null){
                eaPdfBeans=new EaPdfBean();
            }
			
            elemntt2 =  eaPdfBeans.findSelect(id);
            eaPdfBeans.setIdor(4);//para que se desaparezca la pantalla de tracking de EA ya que lo setean javascript
            setIdor(4);
            trackingesrbean.elemento.setReqMessageid(esr.elemento.getReqMessageid());
            trackingesrbean.setearTo(esr.elemento.getChkCheckid());
            eaPdfBeans.setArchivomalo(false);
            eaPdfBeans.setExistecover(false);

        } catch (Exception x) {
            Logger.getLogger(TabEsrEaEo.class.getName()).log(Level.SEVERE, null, x);
        }
    }


    public void cover() {
        try {

            setIdor(11);

        } catch (Exception x) {
            Logger.getLogger(TabEsrEaEo.class.getName()).log(Level.SEVERE, null, x);
        }
    }

    public void eas() {
        try {
            extendtime();
			
            FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();
            ELContext elContext = context.getELContext();
            EaPdfBean eaPdfBeans = (EaPdfBean) application.getExpressionFactory()
                .createValueExpression(elContext, "#{eaPdfBean}", EaPdfBean.class).getValue(elContext);
            
            if(eaPdfBeans==null){
                eaPdfBeans=new EaPdfBean();
            }
			
            eaPdfBeans.setIdor(1);//para que se desaparezca la pantalla de tracking de EA ya que lo setean javascript
            setIdor(1);

        } catch (Exception x) {
            Logger.getLogger(TabEsrEaEo.class.getName()).log(Level.SEVERE, null, x);
        }
    }

    public void esrs() {
        extendtime();
        try {
            actESR(tempId);
            setIdor(2);
        } catch (Exception x) {
            Logger.getLogger(TabEsrEaEo.class.getName()).log(Level.SEVERE, null, x);
        }
    }

    public void volverEsrs() {
        extendtime();
        try {
            actESR(esrId);
        } catch (Exception e) {
            Logger.getLogger(TabEsrEaEo.class.getName()).log(Level.SEVERE, null, e);
        }

        esrs();
    }

    public void trackingesr() {
        try {
            extendtime();
            setIdor(14);
            trackingesrbean.elemento.setReqMessageid(esr.elemento.getReqMessageid());
            trackingesrbean.setearTo(esr.elemento.getChkCheckid());
        } catch (Exception x) {
            Logger.getLogger(TabEsrEaEo.class.getName()).log(Level.SEVERE, null, x);
        }
    }

    public void parts() {
        extendtime();
        try {

            setIdor(12);

        } catch (Exception x) {
            Logger.getLogger(TabEsrEaEo.class.getName()).log(Level.SEVERE, null, x);
        }
    }
   

    public void acteng(String id) {
        try {
            extendtime();
			
            FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();
            ELContext elContext = context.getELContext();
            TaskReqCardBean taskReqCard = (TaskReqCardBean) application.getExpressionFactory()
                .createValueExpression(elContext, "#{taskReqCardBean}", TaskReqCardBean.class).getValue(elContext);            
            EngHorasIngBean engHorasIngBean = (EngHorasIngBean) application.getExpressionFactory()
                .createValueExpression(elContext, "#{engHorasIngBean}", EngHorasIngBean.class).getValue(elContext);
            
																				   
            if(taskReqCard==null){
                taskReqCard=new TaskReqCardBean();
            }
            if(engHorasIngBean==null){
                engHorasIngBean=new EngHorasIngBean();
            }
			
            engHorasIngBean.redireccionar2(id);
            int idRequest = Integer.parseInt(id);
            BigInteger reqid = new BigInteger(String.valueOf(idRequest));
            elemnts = (EngRequest) esr.findSelect(id);
            esr.setElemento(elemnts);
            ContCheck idwo = contFacade.find(elemnts.getChkCheckid());
            setWorderid(idwo.getChkWo());
            customeravion(String.valueOf(idwo.getContCheckId()));
            setIdor(2);
            List<EngEaGeneral> tavea = numax.esrEA(reqid);
            List<Object[]> tavall = new ArrayList<>();

            setWorder(numax.woEsr(idRequest));
            taskReqCard.limpiar();
            taskReqCard.agregarESR(elemnts);
            esr.edit = true;
            esr.elemento.setReqFechaIns(new Date());
            for (EngEaGeneral listadoEng1 : (List<EngEaGeneral>) tavea) {
                Object[] li = new Object[2];
                li[1] = listadoEng1;
                li[0] = "EA";
                tavall.add(li);
            }

            listAlling = tavall;
            setIngbutom(1);

        } catch (Exception x) {
            Logger.getLogger(TabEsrEaEo.class.getName()).log(Level.SEVERE, null, x);
        }

    }

    public int verFecha(Date fecha) throws ParseException {
        extendtime();
        Long dias;
        Long diferencia = new Long("0");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fechaEsrStr = sdf.format(fecha);
        String fechaactStr = sdf.format(fechaAct);
        Date fas = sdf.parse(fechaEsrStr);
        Date facs = sdf.parse(fechaactStr);
        int ret = 0;
        if (fecha != null) {
            dias = facs.getTime() - fas.getTime();
            diferencia = dias / (1000 * 60 * 60 * 24);
            if (diferencia.intValue() <= 2) {
                ret = 1;
            }
            if (diferencia.intValue() == 3 || diferencia.intValue()==4) {
                ret = 2;
            }
            if (diferencia.intValue() > 4) {
                ret = 3;
            }
           
            
        }
        return ret;
    }

    @Override
    public void limpiar() {
        extendtime();
        this.elemento = new EngRequest();
        setWorder("");
        setWorderid("");
        edit = false;
    }

    public void limpiar2(int ord) {
															
        extendtime();
        if (ord == 1) {
            setIdor(1);
            BigInteger esridor;
            engAutorization.elemento = new EngEaGeneral();
            esridor = esr.elemento.getReqMessageid();
            if (esridor != null) {
                engAutorization.setIdErs(esridor);
            }
            engAutorization.EsrElementToEA(elemnts);
            engAutorization.elemento.setAegIngComm(esr.elemento.getUsrCoduser());
            engAutorization.elemento.setEagYear(new BigInteger(String.valueOf(Calendar.getInstance().get(Calendar.YEAR))));
            engAutorization.elemento.setReqMessageid(esridor);
            engAutorization.elemento.setCompany(elemnts.getCompany());
            engAutorization.elemento.setEagCustomer(elemnts.getReqCustomer());
            engAutorization.elemento.setFltCod(elemnts.getFltCod());
            engAutorization.elemento.setEagAta(elemnts.getAtaNumata());
            engAutorization.elemento.setAegRevNum(BigInteger.valueOf(0));           
            engAutorization.edit = false;
            engAutorization.elemento.setEagDateEmi(new Date());
            
        } else if (ord == 2) {
            
            esr.limpiarformEsr();
            esr.getEsrDocumentBean().listado = new ArrayList<>();
            uploadedFiles = new ArrayList<>();
            existeLista=false;
            setCriticalEsrb(false);
            setAogEsrb(false);
			
            FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();
            ELContext elContext = context.getELContext();
            WorkOrderBean workOrderbean = (WorkOrderBean) application.getExpressionFactory()
                .createValueExpression(elContext, "#{workOrderBean}", WorkOrderBean.class).getValue(elContext);
            EngRequestDimenBean reqdimBean = (EngRequestDimenBean) application.getExpressionFactory()
                .createValueExpression(elContext, "#{reqdimBean}", EngRequestDimenBean.class).getValue(elContext);  
            EngDamageTypeManufactBean engDamageTypeManufactBean = (EngDamageTypeManufactBean) application.getExpressionFactory()
                .createValueExpression(elContext, "#{engDamageTypeManufactBean}", EngDamageTypeManufactBean.class).getValue(elContext);  
            TaskReqCardBean taskReqCard = (TaskReqCardBean) application.getExpressionFactory()
                .createValueExpression(elContext, "#{taskReqCardBean}", TaskReqCardBean.class).getValue(elContext);
            EngRequestQuestionBean engRequestQuestionBean = (EngRequestQuestionBean) application.getExpressionFactory()
                .createValueExpression(elContext, "#{engRequestQuestionBean}", EngRequestQuestionBean.class).getValue(elContext);
            EngDentBean engDentBean = (EngDentBean) application.getExpressionFactory()
                .createValueExpression(elContext, "#{engDentBean}", EngDentBean.class).getValue(elContext);
            EngReqTaskJobcardBean engReqTaskJobcardBean = (EngReqTaskJobcardBean) application.getExpressionFactory()
                .createValueExpression(elContext, "#{engReqTaskJobcardBean}", EngReqTaskJobcardBean.class).getValue(elContext);
            
            if(workOrderbean==null){
                workOrderbean=new WorkOrderBean();
            }
            if(reqdimBean==null){
                reqdimBean=new EngRequestDimenBean();
            }
            if(engDamageTypeManufactBean==null){
                engDamageTypeManufactBean=new EngDamageTypeManufactBean();
            }
            if(taskReqCard==null){
                taskReqCard=new TaskReqCardBean();
            }
            if(engRequestQuestionBean==null){
                engRequestQuestionBean=new EngRequestQuestionBean();
            }
            if(engDentBean==null){
                engDentBean=new EngDentBean();
            }
            if(engReqTaskJobcardBean==null){
                engReqTaskJobcardBean=new EngReqTaskJobcardBean();
            }
			
            reqdimBean.limpiar();
            engRequestQuestionBean.limpiar();
            engDentBean.limpiar();
//            engDamageDimBean.limpiarListas();
//            engDamageDimBean.getEngDamageTypeBean().listado2= new ArrayList<>();
//            engDamageDimBean.setFlota(null);
//            engDamageDimBean.setNameDameEvent(null);
//            engDamageDimBean.setPKDamageType(null);

            engDamageTypeManufactBean.limpiarListas();
            engDamageTypeManufactBean.getEngDamageTypeBean().listado2= new ArrayList<>();
            engDamageTypeManufactBean.setFlota(null);
            engDamageTypeManufactBean.setNameDameEvent(null);
            engDamageTypeManufactBean.setPKDamageType(null);
            
            engRequestQuestionBean.limpiar();
            msnWork="";
            cyclesWork="";
            hoursWork="";
            
            esr.limpiar();
            existeArchivo=true;
            setIngbutom(0);
            esr.setCompCheck(false);
            if (("7").equals(rol.get(0).getSgrRolePK().getRoleCode())) {
                esr.elemento.setCompany(usercompany);
            }
            setIdor(2);
            setWorder("");
            setWorderid("");
            esr.elemento.setUsrCoduser("0");
            taskReqCard.listado.clear();
            taskReqCard.limpiar();
            taskReqCard.getTaskCards().clear();
            taskReqCard.setEr(null);
            esr.getEsrDocumentBean().setListimage(new ArrayList<String[]>());
            esr.getEsrDocumentBean().setElemento(new EngEsrDocument());
            esr.getEsrDocumentBean().setListado2(new ArrayList<EngEsrDocument>());
            esr.setFechaInsmala(false);
            esr.setFechaExpmala(false);
            esr.getEsrDocumentBean().setExisteFile(0);
            esr.elemento.setReqFechaIns(new Date());
            esr.elemento.setReqUsersol(users);
            esr.elemento.setReqUsersol(nombresolicitante);
            existeata = false;
            desAta = null;
            setAvion(null);
            setCustom(null);
            setFlota(null);
            reqdimBean.setDimenciones(null);
			
            engReqTaskJobcardBean.setEngEr(new EngRequest());
            engRequestQuestionBean.setEngEr(new EngRequest());
            worderid = null;
            workOrderbean.searchWoByCompany(esr.elemento.getCompany());
        } else {

            setIdor(3);
            setWorder("");
            setWorderid("");
        }
															   
    }
    public void limpiarWorkOrder(){
        extendtime();
        worderid = null;
		
        FacesContext context = FacesContext.getCurrentInstance();
        Application application = context.getApplication();
        ELContext elContext = context.getELContext();
        WorkOrderBean workOrderbean = (WorkOrderBean) application.getExpressionFactory()
            .createValueExpression(elContext, "#{workOrderBean}", WorkOrderBean.class).getValue(elContext);
        
        if(workOrderbean==null){
            workOrderbean=new WorkOrderBean();
        }
			
        workOrderbean.searchWoByCompany(esr.elemento.getCompany());
    }
    

    public void engDispositio(BigDecimal id) {
        try {
            extendtime();
            esrId = id.toString();
            String idh = String.valueOf(id);
            setIdreq(idh);
			
            FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();
            ELContext elContext = context.getELContext();
            EngReqIngactionBean engReqIngactionBean = (EngReqIngactionBean) application.getExpressionFactory()
                .createValueExpression(elContext, "#{engReqIngaction}", EngReqIngactionBean.class).getValue(elContext);
            
            if(engReqIngactionBean==null){
                engReqIngactionBean=new EngReqIngactionBean();
            }
			
            engReqIngactionBean.findSelect(idh);
            setIdor(7);
        } catch (Exception x) {
            Logger.getLogger(TabEsrEaEo.class.getName()).log(Level.SEVERE, null, x);
        }
    }

    public void Engrep(short id) {
        try {
            extendtime();
            String idh = String.valueOf(id);
			
            FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();
            ELContext elContext = context.getELContext();            
            ReportesSeguiCheqBean reportesSeguiCheqBean = (ReportesSeguiCheqBean) application.getExpressionFactory()
                .createValueExpression(elContext, "#{reportesSeguiCheqBean}", ReportesSeguiCheqBean.class).getValue(elContext);  
            
            if(reportesSeguiCheqBean==null){
                reportesSeguiCheqBean=new ReportesSeguiCheqBean();
            }
			
            reportesSeguiCheqBean.esrelacionada(idh);
            reportesSeguiCheqBean.excelReportEsrelacionado();
        } catch (Exception x) {
            Logger.getLogger(TabEsrEaEo.class.getName()).log(Level.SEVERE, null, x);
        }
    }

    public void viewEmail(short id) {
        try {
            extendtime();
            String idh = String.valueOf(id);
			
            FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();
            ELContext elContext = context.getELContext();            
            EmailEnBean emailEnBean = (EmailEnBean) application.getExpressionFactory()
                .createValueExpression(elContext, "#{emailEnBean}", EmailEnBean.class).getValue(elContext);  
            if(emailEnBean==null){
                emailEnBean=new EmailEnBean();
            } 
			
            emailEnBean.somere(idh);
            setIdor(9);
        } catch (Exception x) {
            Logger.getLogger(TabEsrEaEo.class.getName()).log(Level.SEVERE, null, x);
        }
    }

    public void llenarESRs(short id) {
        try {
            extendtime();
            String parametros="<pub:item>\n" +
"                <pub:dataType>xsd:string</pub:dataType>\n" +
"                <pub:name>CHEQUEO</pub:name>\n" +
"                 <pub:values>\n" +
"                    <pub:item>"+id+"</pub:item>\n" +
"                  </pub:values>\n" +
"             </pub:item>\n" +
"             <pub:item>\n" +
"                <pub:dataType>xsd:string</pub:dataType>\n" +
"                <pub:name>VSTATUS</pub:name>\n" +
"                 <pub:values>\n" +
"                    <pub:item></pub:item>\n" +
"                  </pub:values>\n" +
"             </pub:item>";
			
            FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();
            ELContext elContext = context.getELContext();            
            ReportesSeguiCheqBean reportesSeguiCheqBean = (ReportesSeguiCheqBean) application.getExpressionFactory()
                .createValueExpression(elContext, "#{reportesSeguiCheqBean}", ReportesSeguiCheqBean.class).getValue(elContext);  
            
            if(reportesSeguiCheqBean==null){
                reportesSeguiCheqBean=new ReportesSeguiCheqBean();
            }
			
            reportesSeguiCheqBean.llenarESR(parametros);
        } catch (Exception x) {
            Logger.getLogger(TabEsrEaEo.class.getName()).log(Level.SEVERE, null, x);
        }
    }
    
    public void llenarESRExcel(String id) {
        try {
            extendtime();
            String idcheq = id;
            String parametros="<pub:item>\n" +
"                <pub:dataType>xsd:string</pub:dataType>\n" +
"                <pub:name>CHEQUEO</pub:name>\n" +
"                 <pub:values>\n" +
"                    <pub:item>"+id+"</pub:item>\n" +
"                  </pub:values>\n" +
"             </pub:item>\n" +
"             <pub:item>\n" +
"                <pub:dataType>xsd:string</pub:dataType>\n" +
"                <pub:name>VSTATUS</pub:name>\n" +
"                 <pub:values>\n" +
"                    <pub:item></pub:item>\n" +
"                  </pub:values>\n" +
"             </pub:item>";

            FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();
            ELContext elContext = context.getELContext();            
            ReportesSeguiCheqBean reportesSeguiCheqBean = (ReportesSeguiCheqBean) application.getExpressionFactory()
                .createValueExpression(elContext, "#{reportesSeguiCheqBean}", ReportesSeguiCheqBean.class).getValue(elContext);  
            
            if(reportesSeguiCheqBean==null){
                reportesSeguiCheqBean=new ReportesSeguiCheqBean();
            }            
			
            reportesSeguiCheqBean.llenarESRExcel(parametros, idcheq);
        } catch (Exception x) {
            Logger.getLogger(TabEsrEaEo.class.getName()).log(Level.SEVERE, null, x);
        }
    }

    public void llenarHistoricoExcel(String id) {
        try {
            extendtime();
            String idcheq = id;
            String parametros="<pub:item>\n" +
"                <pub:dataType>xsd:string</pub:dataType>\n" +
"                <pub:name>CHEQUEO</pub:name>\n" +
"                 <pub:values>\n" +
"                    <pub:item>"+id+"</pub:item>\n" +
"                  </pub:values>\n" +
"             </pub:item>\n" +
"             <pub:item>\n" +
"                <pub:dataType>xsd:string</pub:dataType>\n" +
"                <pub:name>VSTATUS</pub:name>\n" +
"                 <pub:values>\n" +
"                    <pub:item></pub:item>\n" +
"                  </pub:values>\n" +
"             </pub:item>";

            FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();
            ELContext elContext = context.getELContext();            
            ReportesSeguiCheqBean reportesSeguiCheqBean = (ReportesSeguiCheqBean) application.getExpressionFactory()
                .createValueExpression(elContext, "#{reportesSeguiCheqBean}", ReportesSeguiCheqBean.class).getValue(elContext);  
            
            if(reportesSeguiCheqBean==null){
                reportesSeguiCheqBean=new ReportesSeguiCheqBean();
            }
			
            reportesSeguiCheqBean.llenarHistoricoExcel(parametros, idcheq);
        } catch (Exception x) {         Logger.getLogger(TabEsrEaEo.class.getName()).log(Level.SEVERE, null, x);
        }
    }

    
    public void generarRepDispositionWo() {
        String codUserTra = getUsr86();
        try {
            extendtime();
            String parametros="<pub:item>\n" +
"                <pub:dataType>xsd:string</pub:dataType>\n" +
"                <pub:name>CODUSER</pub:name>\n" +
"                 <pub:values>\n" +
"                    <pub:item>"+codUserTra+"</pub:item>\n" +
"                  </pub:values>\n" +
"             </pub:item>\n";

            FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();
            ELContext elContext = context.getELContext();            
            ReportesSeguiCheqBean reportesSeguiCheqBean = (ReportesSeguiCheqBean) application.getExpressionFactory()
                .createValueExpression(elContext, "#{reportesSeguiCheqBean}", ReportesSeguiCheqBean.class).getValue(elContext);  
            
            if(reportesSeguiCheqBean==null){
                reportesSeguiCheqBean=new ReportesSeguiCheqBean();
            }
			
            reportesSeguiCheqBean.spDispositionWo(parametros);
        } catch (Exception x) {
            Logger.getLogger(TabEsrEaEo.class.getName()).log(Level.SEVERE, null, x);
        }
    }
    public void generarRepTrackigswoDm() {
        String codUserTra = getUsr86();
        try {
            extendtime();
            String parametros="<pub:item>\n" +
"                <pub:dataType>xsd:string</pub:dataType>\n" +
"                <pub:name>CODUSER</pub:name>\n" +
"                 <pub:values>\n" +
"                    <pub:item>"+codUserTra+"</pub:item>\n" +
"                  </pub:values>\n" +
"             </pub:item>\n";

            FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();
            ELContext elContext = context.getELContext();            
            ReportesSeguiCheqBean reportesSeguiCheqBean = (ReportesSeguiCheqBean) application.getExpressionFactory()
                .createValueExpression(elContext, "#{reportesSeguiCheqBean}", ReportesSeguiCheqBean.class).getValue(elContext);  
            
            if(reportesSeguiCheqBean==null){
                reportesSeguiCheqBean=new ReportesSeguiCheqBean();
            }
			
            reportesSeguiCheqBean.spTrackigswoDm(parametros);
        } catch (Exception x) {
            Logger.getLogger(TabEsrEaEo.class.getName()).log(Level.SEVERE, null, x);
        }
    }

    public void llenarHistorico(short id) {
        try {
            extendtime();
            String parametros="<pub:item>\n" +
"                <pub:dataType>xsd:string</pub:dataType>\n" +
"                <pub:name>CHEQUEO</pub:name>\n" +
"                 <pub:values>\n" +
"                    <pub:item>"+id+"</pub:item>\n" +
"                  </pub:values>\n" +
"             </pub:item>\n" +
"             <pub:item>\n" +
"                <pub:dataType>xsd:string</pub:dataType>\n" +
"                <pub:name>VSTATUS</pub:name>\n" +
"                 <pub:values>\n" +
"                    <pub:item></pub:item>\n" +
"                  </pub:values>\n" +
"             </pub:item>";

            FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();
            ELContext elContext = context.getELContext();            
            ReportesSeguiCheqBean reportesSeguiCheqBean = (ReportesSeguiCheqBean) application.getExpressionFactory()
                .createValueExpression(elContext, "#{reportesSeguiCheqBean}", ReportesSeguiCheqBean.class).getValue(elContext);  
            
            if(reportesSeguiCheqBean==null){
                reportesSeguiCheqBean=new ReportesSeguiCheqBean();
            }
			
            reportesSeguiCheqBean.llenarHistorico(parametros);
        } catch (Exception x) {
            Logger.getLogger(TabEsrEaEo.class.getName()).log(Level.SEVERE, null, x);
        }
    }

    public void llenarCI(short id) {
        try {
            extendtime();
            String parametros="<pub:item>\n" +
"                <pub:dataType>xsd:string</pub:dataType>\n" +
"                <pub:name>CHEQUEO</pub:name>\n" +
"                 <pub:values>\n" +
"                    <pub:item>"+id+"</pub:item>\n" +
"                  </pub:values>\n" +
"             </pub:item>\n" +
"             <pub:item>\n" +
"                <pub:dataType>xsd:string</pub:dataType>\n" +
"                <pub:name>VSTATUS</pub:name>\n" +
"                 <pub:values>\n" +
"                    <pub:item></pub:item>\n" +
"                  </pub:values>\n" +
"             </pub:item>";

            FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();
            ELContext elContext = context.getELContext();            
            ReportesSeguiCheqBean reportesSeguiCheqBean = (ReportesSeguiCheqBean) application.getExpressionFactory()
                .createValueExpression(elContext, "#{reportesSeguiCheqBean}", ReportesSeguiCheqBean.class).getValue(elContext);  
            
            if(reportesSeguiCheqBean==null){
                reportesSeguiCheqBean=new ReportesSeguiCheqBean();
            }  
			
            reportesSeguiCheqBean.llenarCI(parametros);
        } catch (Exception x) {
            Logger.getLogger(TabEsrEaEo.class.getName()).log(Level.SEVERE, null, x);
        }
    }

    public void reporteESR(String id, String Checkid, String company) {
        extendtime();
        try {
			
            FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();
            ELContext elContext = context.getELContext();            
            ReportesSeguiCheqBean reportesSeguiCheqBean = (ReportesSeguiCheqBean) application.getExpressionFactory()
                .createValueExpression(elContext, "#{reportesSeguiCheqBean}", ReportesSeguiCheqBean.class).getValue(elContext);  
            
            if(reportesSeguiCheqBean==null){
                reportesSeguiCheqBean=new ReportesSeguiCheqBean();
            }
			
            if (company.equals("FAS")) {
                String parametros = "<pub:item>\n"
                        + "                <pub:dataType>xsd:string</pub:dataType>\n"
                        + "                <pub:name>MESSAGEID</pub:name>\n"
                        + "                 <pub:values>\n"
                        + "                    <pub:item>" + id + "</pub:item>\n"
                        + "                  </pub:values>\n"
                        + "             </pub:item>\n"
                        + "             <pub:item>\n"
                        + "                <pub:dataType>xsd:string</pub:dataType>\n"
                        + "                <pub:name>CHEQUEO</pub:name>\n"
                        + "                 <pub:values>\n"
                        + "                    <pub:item>" + Checkid + "</pub:item>\n"
                        + "                  </pub:values>\n"
                        + "            </pub:item>";
                reportesSeguiCheqBean.reportESR(parametros, company);
            } else {
                String parametros = "<pub:item>"
                        + "<pub:dataType>xsd:string</pub:dataType>"
                        + "<pub:name>idmessage</pub:name>"
                        + "<pub:values>"
                        + "<pub:item>" + id + "</pub:item>"
                        + "</pub:values>"
                        + "</pub:item>";
                reportesSeguiCheqBean.reportESR(parametros, company);
            }
        } catch (Exception x) {
            Logger.getLogger(TabEsrEaEo.class.getName()).log(Level.SEVERE, null, x);
        }
    }



    public void trackingesrPanelDerecho() {
        try {
            extendtime();
            trackingesrbean.elemento.setReqMessageid(esr.elemento.getReqMessageid());
            HttpSession session = SessionBean.getSession();
            setCompanySelected((String) session.getAttribute("companySelected"));
            trackingesrbean.resetDisable();
            trackingesrbean.setEsESR("YES");
            
            int numESR= 0;
            String reCorr = "";
            String reqYear = "";
           
            numESR=esr.elemento.getAtaNumata();
            session.setAttribute("Re_numESR", numESR);
            
            reCorr = esr.elemento.getReqCorr();
            session.setAttribute("Re_reCorr", reCorr);
            
            reqYear = esr.elemento.getReqYear().substring(2, 4);
            session.setAttribute("Re_reqYear", reqYear);
            
            BigInteger rqMsid;
            rqMsid = esr.elemento.getReqMessageid();
            trackingesrbean.lstSeguimiento = engSegFacade.lsSeguimiento(esr.elemento.getReqMessageid(), BigDecimal.ZERO);
            
            //Ocultar btnActualiazar:
            //setOcultaBtn
            trackingesrbean.setOcultaBtn("visibility:hidden;");
            //Validacion agregada Bloqueo de botones:
            define = engReqResponsesFacade.validaESR(numESR,reCorr,reqYear);
            trackingesrbean.setPointer(define);
            
        } catch (Exception x) {
            Logger.getLogger(TabEsrEaEo.class.getName()).log(Level.SEVERE, null, x);
        }
    }

    public void engDispositioPanelDerecho(BigDecimal id) {
        try {
            extendtime();
            esrId = id.toString();
            String idh = String.valueOf(id);
            setIdreq(idh);
			
            FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();
            ELContext elContext = context.getELContext();
            EngReqIngactionBean engReqIngactionBean = (EngReqIngactionBean) application.getExpressionFactory()
                .createValueExpression(elContext, "#{engReqIngaction}", EngReqIngactionBean.class).getValue(elContext);
            
            if(engReqIngactionBean==null){
                engReqIngactionBean=new EngReqIngactionBean();
            }
			
            engReqIngactionBean.findSelect(idh);
            engReqIngactionBean.setTipoSolicitud(tipoSolicitud);
            trackingesrbean.setTipoSocilictudTracking(tipoSolicitud);
        } catch (Exception x) {
            Logger.getLogger(TabEsrEaEo.class.getName()).log(Level.SEVERE, null, x);
        }
    }

    public void reporteESRModal(BigDecimal id, String company) {
        extendtime();
        try {
            String parametros="<pub:item>" 
                        + "<pub:dataType>xsd:string</pub:dataType>" 
                        + "<pub:name>idmessage</pub:name>" 
                        +   "<pub:values>" 
                        +     "<pub:item>"+id+"</pub:item>" 
                        +   "</pub:values>" 
                     +  "</pub:item>";
					 
				FacesContext context = FacesContext.getCurrentInstance();
				Application application = context.getApplication();
				ELContext elContext = context.getELContext();            
				ReportesSeguiCheqBean reportesSeguiCheqBean = (ReportesSeguiCheqBean) application.getExpressionFactory()
					.createValueExpression(elContext, "#{reportesSeguiCheqBean}", ReportesSeguiCheqBean.class).getValue(elContext);  
				
				if(reportesSeguiCheqBean==null){
					reportesSeguiCheqBean=new ReportesSeguiCheqBean();
				}
			
            reportesSeguiCheqBean.reportESR(parametros, company);
        } catch (Exception x) {
            Logger.getLogger(TabEsrEaEo.class.getName()).log(Level.SEVERE, null, x);
        }
    }

    public String redirectToGraphics() {
        extendtime();
        try {
            FacesContext fce = FacesContext.getCurrentInstance();
            fce.getExternalContext().redirect("/EngineeringManage/pages/reportes/graficos.xhtml");
        } 
        catch (Exception e) {
            Logger.getLogger(ReportesSeguiCheqBean.class.getName()).log(Level.SEVERE, null, e);
        }
        return "result";
    }
    public void jobCardIni(String idor)
    {
        extendtime();
        BigInteger id = new BigInteger(idor);
        listaJobIni = engReqTaskJobcardIniFacade.findBySelectJobCard(id);
    }
     public void taskCardIni(String idor)
    {
        extendtime();
        BigInteger id = new BigInteger(idor);
        listaTaskCard = engReqTaskCardIniFacade.findBySelectTaskCard(id);
        jobCardIni(idor);
    }
     public void dimenIni(String idor)
    {
        extendtime();
        BigInteger id = new BigInteger(idor);
        listaDime = engRequestDimenIniFacade.findBySelectDimen(id);
    }
    public void hangarDesf(String company){
         try{
             extendtime();
             listaHangares = coreUsersVwFacade.findByHangares(company);             
             listaRampas = coreUsersVwFacade.findByRampa(company);
			 
            FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();
            ELContext elContext = context.getELContext();            
            EngMergeCustomerBean engMergeCustomerBean = (EngMergeCustomerBean) application.getExpressionFactory()
                .createValueExpression(elContext, "#{engMergeCustomerBean}", EngMergeCustomerBean.class).getValue(elContext);  
             
            if(engMergeCustomerBean==null){
                engMergeCustomerBean=new EngMergeCustomerBean();
            }
			 
             engMergeCustomerBean.listOpco(company);
             for (String  listaR : listaRampas) {
                 listaHangares.add(listaR);                 
             }
         }
         catch(Exception x) {
             Logger.getLogger(TabEsrEaEo.class.getName()).log(Level.SEVERE, null, x);
         }
    }   
    
    public void autoComplete(String airCraft,String ciaCode,String workOrder){
        extendtime();
        setWorderid(workOrder);
        setAvion(airCraft);
        esr.elemento.setReqRegistry(airCraft.trim());
        esr.elemento.setCompany(ciaCode);
        esr.elemento.setReqUsersol(nombresolicitante);
        esr.elemento.setReqFechaIns(new Date());  
        esr.elemento.setUsrCoduser(getUsr86());
        esr.elemento.setAtaNumata(Short.decode("250"));
        esr.setCompCheck(false);
        customeravion(workOrder);
        
    }
    
    public void autoCompleteETR(String airCraft,String ciaCode,String workOrder){
        extendtime();
        
        
        
        esr.elemento.setCompany(ciaCode);
        esr.elemento.setReqUsersol(nombresolicitante);
        esr.elemento.setReqFechaIns(new Date());  
        esr.elemento.setUsrCoduser(getUsr86());
        esr.elemento.setAtaNumata(Short.decode("250"));
          customeravionETR(workOrder);
        
    }
    
    public void handleFileUpload(FileUploadEvent event) {
        extendtime();
        setExisteLista(false);
        EngEsrDocument lisAdjsj = new EngEsrDocument();
        try{
          uploadedFiles.add(event.getFile());
          disable=false;
          if(uploadedFiles.isEmpty()){
            FacesMessage message = new FacesMessage("Choose Documents");
            FacesContext.getCurrentInstance().addMessage(null, message);  
          }else{
              
              for (UploadedFile lisUpload : uploadedFiles) {
                  lisAdjsj.setNombreAcotado(lisUpload.getFileName());
                  lisAdjsj.setNameDocu(lisUpload.getFileName().substring(0,lisUpload.getFileName().lastIndexOf(".")));
                  lisAdjsj.setExtenDocu(lisUpload.getFileName().substring(lisUpload.getFileName().lastIndexOf("."), lisUpload.getFileName().length()));
                  lisAdjsj.setBodyDocu(lisUpload.getContents());
                  lisAdjsj.setExtension("error");
                  if (lisAdjsj.getNombreAcotado().length()>22) {
                      lisAdjsj.setNombreAcotado(lisAdjsj.getNombreAcotado().substring(0,19)+"...");
                  }
                  switch (lisAdjsj.getExtenDocu().toUpperCase()) {
                      case ".PDF":
                          lisAdjsj.setExtension("pdf");
                          break;
                      case ".PNG":
                          lisAdjsj.setExtension("png");
                          break;
                      case ".JPG":                      
                      case ".JPEG":
                          lisAdjsj.setExtension("jpg");
                          break;
                      case ".GIF":
                          lisAdjsj.setExtension("gif");
                          break;
                      case ".DOC":
                      case ".DOCX":
                          lisAdjsj.setExtension("doc");
                          break;
                      case ".XLS":
                      case ".XLSX":
                          lisAdjsj.setExtension("xls");
                          break;
                      default:    
                      case ".TXT":
                          lisAdjsj.setExtension("txt");
                          break;
                  }
                  esr.getEsrDocumentBean().listado.add(lisAdjsj);
                  if (esr.getEsrDocumentBean().listado.size() >0){
                    setExisteLista(true);
                  }
                    lisAdjsj = new EngEsrDocument();    
              }
              uploadedFiles = new ArrayList<>();
          }
          
        }catch(Exception e){
            Logger.getLogger(TabEsrEaEo.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
    public void deleteBlod() {        
        extendtime();
        int ids = Integer.parseInt(esr.getEsrDocumentBean().getIdDocument());
        esr.getEsrDocumentBean().listado.remove(ids);
        if (esr.getEsrDocumentBean().listado.isEmpty()) {
            existeLista=false;            
        }
    }
    public void newDownloadfile() {

        extendtime();
        HttpServletResponse response1 = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();

        int bit1 = 512;

        int ids1 = Integer.parseInt(esr.getEsrDocumentBean().getIdDocument());
        EngEsrDocument esrdoc1 = esr.getEsrDocumentBean().listado.get(ids1);
        typeDoc = new TypeDoc();
        typeDoc = typeDocFacade.find(esrdoc1.getExtenDocu());
        response1.setContentType("application/octet-stream");
        if (typeDoc != null) {
            response1.setContentType(typeDoc.getTcMime());
        }
        if (!esrdoc1.getExtenDocu().equals(".docx") && !esrdoc1.getExtenDocu().equals(".xlsx")) {
            
            response1.setHeader("Content-Disposition", "attachment; filename=" + esrdoc1.getNameDocu().replace(",", "_") + esrdoc1.getExtenDocu());
            try (InputStream in1 = new ByteArrayInputStream(esrdoc1.getBodyDocu())) {

                ServletOutputStream outs1 = response1.getOutputStream();
                while ((bit1) >= 0) {
                    bit1 = in1.read();
                    outs1.write(bit1);
                }
                outs1.flush();
                outs1.close();
                in1.close();
                FacesContext.getCurrentInstance().getResponseComplete();
            } catch (Exception e1) {
                Logger.getLogger(TabEsrEaEo.class.getName()).log(Level.SEVERE, null, e1);
            } finally {
                FacesContext.getCurrentInstance().getResponseComplete();
            }
        } else if (esrdoc1.getExtenDocu().equals(".docx")) {
            newDownloadfileDocx(response1,esrdoc1);
        }
        else{
            newDownloadfileXlsx(response1,esrdoc1);
        }
    }
    public void newDownloadfile2() {

        extendtime();
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        int bit = 512;

        int ids = Integer.parseInt(esr.getEsrDocumentBean().getIdDocument());
        EngEsrDocument esrdoc = esr.getEsrDocumentBean().listado.get(ids);
        typeDoc = new TypeDoc();
        typeDoc = typeDocFacade.find(esrdoc.getExtenDocu());
        response.setContentType("application/octet-stream");
        if (typeDoc != null) {
            response.setContentType(typeDoc.getTcMime());
        }
        if (!esrdoc.getExtenDocu().equals(".docx")) {            
            response.setHeader("Content-Disposition", "attachment; filename=" + esrdoc.getNameDocu().replace(",", "_") + esrdoc.getExtenDocu());
        try (InputStream in = new ByteArrayInputStream(esrdoc.getBodyDocu())) {

            ServletOutputStream outs = response.getOutputStream();
            while ((bit) >= 0) {
                bit = in.read();
                outs.write(bit);
            }
            outs.flush();
            outs.close();
            in.close();
            FacesContext.getCurrentInstance().getResponseComplete();

        } catch (Exception e) {
            Logger.getLogger(TabEsrEaEo.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            FacesContext.getCurrentInstance().getResponseComplete();
        }
        }else {
            newDownloadfileDocx(response,esrdoc);
        }
    }
    public void newDownloadfileDocx(HttpServletResponse response, EngEsrDocument esrdoc) {
         
        try {       
            ByteArrayInputStream datoss = new ByteArrayInputStream(esrdoc.getBodyDocu());
            WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(datoss);   
             
            response.setHeader("Content-disposition", "attachment; filename="+esrdoc.getNameDocu().replace(",", "_") + esrdoc.getExtenDocu());
            wordMLPackage.save(response.getOutputStream());
            response.getOutputStream().close();
        } catch (Exception ex) {
            Logger.getLogger(TabEsrEaEo.class.getName()).log(Level.SEVERE, null, ex);
        } 
     }
    public void newDownloadfileXlsx(HttpServletResponse response, EngEsrDocument esrdoc) {
         
        try {       
             String fileName = "SomeExcel.xlsx";

            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            ByteArrayInputStream datoss = new ByteArrayInputStream(esrdoc.getBodyDocu());

            OPCPackage pkg = OPCPackage.open(datoss);

            XSSFWorkbook workbook = new XSSFWorkbook(pkg);

            ServletOutputStream respOut = response.getOutputStream();

            pkg.close();
            workbook.write(respOut);
            respOut.flush();

            workbook = null;                    

            response.setHeader("Content-disposition", "attachment;filename=\"" +fileName+ "\"");

        } catch (Exception ex) {
            Logger.getLogger(AdjuntosBean.class.getName()).log(Level.SEVERE, null, ex);
        } 
     }
    
    public void autoCompleteECR(String airCraft,String ciaCode,String workOrder){
        extendtime();
        esr.elemento.setCompany(ciaCode);
        esr.elemento.setReqUsersol(nombresolicitante);
        esr.elemento.setReqFechaIns(new Date());  
        esr.elemento.setUsrCoduser(getUsr86());
        esr.elemento.setAtaNumata(Short.decode("250"));
        customeravionECR(workOrder);//esta es la parte donde selecciona el cliente
    }
    
    public void findAdjuntos(String idESR){
        extendtime();
        esr.getEsrDocumentBean().listado = new ArrayList<>();
        esr.getEsrDocumentBean().listado2 = documentFacade.findByItemId(idESR);
        for (EngEsrDocument lisMsj3 : esr.getEsrDocumentBean().listado2) {
            lisMsj3.setNombreAcotado(lisMsj3.getNameDocu()+lisMsj3.getExtenDocu());
            if (lisMsj3.getNombreAcotado().length()>22) {
                      lisMsj3.setNombreAcotado(lisMsj3.getNameDocu().substring(0,19)+"...");
                  }
            lisMsj3.setExtension("error");
            switch(lisMsj3.getExtenDocu().toUpperCase()) {
                case ".PDF":
                  lisMsj3.setExtension("pdf");
                  break;
                case ".PNG":
                  lisMsj3.setExtension("png");
                  break;
                case ".JPG":
                case ".JPEG":
                  lisMsj3.setExtension("jpg");
                  break;
                case ".GIF":
                  lisMsj3.setExtension("gif");
                  break;
                case ".DOC":
                case ".DOCX":
                  lisMsj3.setExtension("doc");
                  break;
                case ".XLS":
                case ".XLSX":
                  lisMsj3.setExtension("xls");
                  break;
                default:
                case ".TXT":
                  lisMsj3.setExtension("txt");
                  break;                    
              }
                esr.getEsrDocumentBean().listado.add(lisMsj3);
                  if (esr.getEsrDocumentBean().listado.size() >0){
                    setExisteLista(true);
                  }
                    lisMsj3 = new EngEsrDocument();
        }
    }

    @Override
    public void actualizar() {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public void agregar() {
        extendtime();
    }

    @Override
    public void eliminar(EngRequest elemento) {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EngRequest nuevoElemento() {
        return new EngRequest();
    }

    public String getIdIng() {
        return idIng;
    }

    public void setIdIng(String idIng) {
        this.idIng = idIng;
    }

    public String getIdAct() {
        return idAct;
    }

    public void setIdAct(String idAct) {
        this.idAct = idAct;
    }

    public String getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(String tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    public EsrBean getEsr() {
        return esr;
    }

    public void setEsr(EsrBean esr) {
        this.esr = esr;
    }

    

    public void setEngAutorization(EngAutorizationBean engAutorization) {
        this.engAutorization = engAutorization;
    }


    public EngEaEoReqVwFacade getEngEaEoReqVwFacade() {
        return engEaEoReqVwFacade;
    }

    public void setEngEaEoReqVwFacade(EngEaEoReqVwFacade engEaEoReqVwFacade) {
        this.engEaEoReqVwFacade = engEaEoReqVwFacade;
    }

    public EngOrders getElemnt() {
        return elemnt;
    }

    public void setElemnt(EngOrders elemnt) {
        this.elemnt = elemnt;
    }

    public EngRequest getElemnts() {
        return elemnts;
    }

    public void setElemnts(EngRequest elemnts) {
        this.elemnts = elemnts;
    }

    public EngEaGeneral getElemntt() {
        return elemntt;
    }

    public void setElemntt(EngEaGeneral elemntt) {
        this.elemntt = elemntt;
    }


    public void setListado(List<EngRequest> listado) {
        this.listadoTabEsr = listado;
    }

    public int getIdmaxea() {
        return idmaxea;
    }

    public void setIdmaxea(int idmaxea) {
        this.idmaxea = idmaxea;
    }

    public int getIdor() {
        return idor;
    }

    public void setIdor(int idor) {
        this.idor = idor;
    }

    public EngEaPdf getElemntt2() {
        return elemntt2;
    }

    public void setElemntt2(EngEaPdf elemntt2) {
        this.elemntt2 = elemntt2;
    }

    public Date getFechaAct() {
        return fechaAct;
    }

    public void setFechaAct(Date fechaAct) {
        this.fechaAct = fechaAct;
    }

    public EngEoRef getElemnt2() {
        return elemnt2;
    }

    public void setElemnt2(EngEoRef elemnt2) {
        this.elemnt2 = elemnt2;
    }

    public String getStr2() {
        return str2;
    }

    public void setStr2(String str2) {
        this.str2 = str2;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public List<EngEaGeneral> getListadoTabEa() {
        return listadoTabEa;
    }

    public void setListadoTabEa(List<EngEaGeneral> listadoTabEa) {
        this.listadoTabEa = listadoTabEa;
    }

    public List<EngOrders> getListadoTabEo() {
        return listadoTabEo;
    }

    public void setListadoTabEo(List<EngOrders> listadoTabEo) {
        this.listadoTabEo = listadoTabEo;
    }

    public List<Object[]> getListAll() {
        return listAll;
    }

    public void setListAll(List<Object[]> listAll) {
        this.listAll = listAll;
    }

    public List<Object[]> getListEsr() {
        return listEsr;
    }

    public void setListEsr(List<Object[]> listEsr) {
        this.listEsr = listEsr;
    }

    public List<EngTaskListView> getListadoMex() {
        return listadoMex;
    }

    public void setListadoMex(List<EngTaskListView> listadoMex) {
        this.listadoMex = listadoMex;
    }

    public List<EngTaskListView> getListadoAe() {
        return listadoAe;
    }

    public void setListadoAe(List<EngTaskListView> listadoAe) {
        this.listadoAe = listadoAe;
    }

    public String getWorder() {
        return worder;
    }

    public void setWorder(String worder) {
        this.worder = worder;
    }

    public List<EngEsrListView> getListfiltro() {
        return listfiltro;
    }

    public void setListfiltro(List<EngEsrListView> listfiltro) {
        this.listfiltro = listfiltro;
    }

    public boolean getFiltro() {
        return filtro;
    }

    public void setFiltro(boolean filtro) {
        this.filtro = filtro;
    }

    public boolean isFiltrouser() {
        return filtrouser;
    }

    public void setFiltrouser(boolean filtrouser) {
        this.filtrouser = filtrouser;
    }

    public List<EngTaskListView> getListInge() {
        return listInge;
    }

    public void setListInge(List<EngTaskListView> listInge) {
        this.listInge = listInge;
    }

    public List<Object[]> getListadoTabEaing() {
        return listadoTabEaing;
    }

    public void setListadoTabEaing(List<Object[]> listadoTabEaing) {
        this.listadoTabEaing = listadoTabEaing;
    }

    public List<Object[]> getListadoTabEoing() {
        return listadoTabEoing;
    }

    public void setListadoTabEoing(List<Object[]> listadoTabEoing) {
        this.listadoTabEoing = listadoTabEoing;
    }

    public List<Object[]> getListAlling() {
        return listAlling;
    }

    public void setListAlling(List<Object[]> listAlling) {
        this.listAlling = listAlling;
    }

    public List<EngTaskListView> getListesrcompany() {
        return listesrcompany;
    }

    public void setListAllcompany(List<EngTaskListView> listesrcompany) {
        this.listesrcompany = listesrcompany;
    }

    public List<EngTaskListView> getListadouserins() {
        return listadouserins;
    }

    public void setListadouserins(List<EngTaskListView> listadouserins) {
        this.listadouserins = listadouserins;
    }

    public LanguageSwitcher getLanguageSwitcher() {
        return languageSwitcher;
    }

    public void setLanguageSwitcher(LanguageSwitcher languageSwitcher) {
        this.languageSwitcher = languageSwitcher;
    }

    public Object[] getIdtodas() {
        return idtodas;
    }

    public void setIdtodas(Object[] idtodas) {
        this.idtodas = idtodas;
    }

    public String getUsr86() {
        return usr86;
    }

    public void setUsr86(String usr86) {
        this.usr86 = usr86;
    }

    public String getContid() {
        return contid;
    }

    public void setContid(String contid) {
        this.contid = contid;
    }

    public String getAvion() {
        return avion;
    }

    public void setAvion(String avion) {
        this.avion = avion;
    }

    public String getCustom() {
        return custom;
    }

    public void setCustom(String custom) {
        this.custom = custom;
    }

    public List<EngEsrListView> getListesrcompanymec() {
        return listesrcompanymec;
    }

    public void setListesrcompanymec(List<EngEsrListView> listesrcompanymec) {
        this.listesrcompanymec = listesrcompanymec;
    }

    public String getIdreq() {
        return idreq;
    }

    public void setIdreq(String idreq) {
        this.idreq = idreq;
    }

    public String getIdEsrWo() {
        return idEsrWo;
    }

    public void setIdEsrWo(String idEsrWo) {
        this.idEsrWo = idEsrWo;
    }

    public EngEsrListView getListfiltro2() {
        return listfiltro2;
    }

    public void setListfiltro2(EngEsrListView listfiltro2) {
        this.listfiltro2 = listfiltro2;
    }

    public String getNuwitem() {
        return nuwitem;
    }

    public void setNuwitem(String nuwitem) {
        this.nuwitem = nuwitem;
    }

    public List<EngTaskListView> getListesrcompanysup() {
        return listesrcompanysup;
    }

    public void setListesrcompanysup(List<EngTaskListView> listesrcompanysup) {
        this.listesrcompanysup = listesrcompanysup;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getFlota() {
        return flota;
    }

    public void setFlota(String flota) {
        this.flota = flota;
    }

    public String getNombreUsr() {
        return nombreUsr;
    }

    public void setNombreUsr(String nombreUsr) {
        this.nombreUsr = nombreUsr;
    }

    public SgrUserFacades getSgrUser() {
        return sgrUser;
    }

    public void setSgrUser(SgrUserFacades sgrUser) {
        this.sgrUser = sgrUser;
    }

    public SgrUser getElementoUser() {
        return elementoUser;
    }

    public void setElementoUser(SgrUser elementoUser) {
        this.elementoUser = elementoUser;
    }

    public List<SgrUser> getListadoUser() {
        return listadoUser;
    }

    public void setListadoUser(List<SgrUser> listadoUser) {
        this.listadoUser = listadoUser;
    }

    public String getDraguser() {
        return draguser;
    }

    public void setDraguser(String draguser) {
        this.draguser = draguser;
    }

    public String getDragesr() {
        return dragesr;
    }

    public void setDragesr(String dragesr) {
        this.dragesr = dragesr;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
    }

    public String getUsercompany() {
        return usercompany;
    }

    public void setUsercompany(String usercompany) {
        this.usercompany = usercompany;
    }


    public List<SgrRole> getRol() {
        return rol;
    }

    public void setRol(List<SgrRole> rol) {
        this.rol = rol;
    }

    public boolean isAlgotienequetraer() {
        return algotienequetraer;
    }

    public void setAlgotienequetraer(boolean algotienequetraer) {
        this.algotienequetraer = algotienequetraer;
    }

    public String getUserfulname() {
        return userfulname;
    }

    public void setUserfulname(String userfulname) {
        this.userfulname = userfulname;
    }

    public String getComsup() {
        return comsup;
    }

    public void setComsup(String comsup) {
        this.comsup = comsup;
    }

    public String getWorderid() {
        return worderid;
    }

    public void setWorderid(String worderid) {
        this.worderid = worderid;
    }

    public Short getIdcontcke() {
        return idcontcke;
    }

    public void setIdcontcke(Short idcontcke) {
        this.idcontcke = idcontcke;
    }

    public int getIngbutom() {
        return ingbutom;
    }

    public void setIngbutom(int ingbutom) {
        this.ingbutom = ingbutom;
    }

    public String getUsertem() {
        return usertem;
    }

    public void setUsertem(String usertem) {
        this.usertem = usertem;
    }

    public RequestTrackingBean getTrackingesrbean() {
        return trackingesrbean;
    }

    public void setTrackingesrbean(RequestTrackingBean trackingesrbean) {
        this.trackingesrbean = trackingesrbean;
    }

    public String getTempId() {
        return tempId;
    }

    public void setTempId(String tempId) {
        this.tempId = tempId;
    }

    public String getEsrId() {
        return esrId;
    }

    public void setEsrId(String esrId) {
        this.esrId = esrId;
    }

    public String getIdTab() {
        return idTab;
    }

    public void setIdTab(String idTab) {
        this.idTab = idTab;
    }

    public List<EngRequest> getListadoTabEsr() {
        return listadoTabEsr;
    }

    public void setListadoTabEsr(List<EngRequest> listadoTabEsr) {
        this.listadoTabEsr = listadoTabEsr;
    }

    public String getUserTabEsr() {
        return userTabEsr;
    }

    public void setUserTabEsr(String userTabEsr) {
        this.userTabEsr = userTabEsr;
    }

    public String getNombresolicitante() {
        return nombresolicitante;
    }

    public void setNombresolicitante(String nombresolicitante) {
        this.nombresolicitante = nombresolicitante;
    }

    public boolean isValNav() {
        return valNav;
    }

    public void setValNav(boolean valNav) {
        this.valNav = valNav;
    }

    public String getNavegador() {
        return navegador;
    }

    public void setNavegador(String navegador) {
        this.navegador = navegador;
    }

    public String getIdAta() {
        return idAta;
    }

    public void setIdAta(String idAta) {
        this.idAta = idAta;
    }

    public String getAtamala() {
        return atamala;
    }

    public void setAtamala(String atamala) {
        this.atamala = atamala;
    }

    public String getDesAta() {
        return desAta;
    }

    public void setDesAta(String desAta) {
        this.desAta = desAta;
    }

    public boolean isExisteata() {
        return existeata;
    }

    public void setExisteata(boolean existeata) {
        this.existeata = existeata;
    }

    public String getErrorTarjeta() {
        return errorTarjeta;
    }

    public void setErrorTarjeta(String errorTarjeta) {
        this.errorTarjeta = errorTarjeta;
    }

    public String getCompanySV() {
        return companySV;
    }

    public void setCompanySV(String companySV) {
        this.companySV = companySV;
    }

    public String getWorkOrderJob() {
        return workOrderJob;
    }

    public void setWorkOrderJob(String workOrderJob) {
        this.workOrderJob = workOrderJob;
    }

    public boolean getExisteArchivo() {
        return existeArchivo;
    }

    public void setExisteArchivo(boolean existeArchivo) {
        this.existeArchivo = existeArchivo;
    }

    public List<EngReqTaskJobcardIni> getListaJobIni() {
        return listaJobIni;
    }

    public void setListaJobIni(List<EngReqTaskJobcardIni> listaJobIni) {
        this.listaJobIni = listaJobIni;
    }

    public List<EngReqTaskCardIni> getListaTaskCard() {
        return listaTaskCard;
    }

    public void setListaTaskCard(List<EngReqTaskCardIni> listaTaskCard) {
        this.listaTaskCard = listaTaskCard;
    }

    public List<EngRequestDimenIni> getListaDime() {
        return listaDime;
    }

    public void setListaDime(List<EngRequestDimenIni> listaDime) {
        this.listaDime = listaDime;
    }

    public List<String> getListaHangares() {
        return listaHangares;
    }

    public void setListaHangares(List<String> listaHangares) {
        this.listaHangares = listaHangares;
    }

    public List<String> getListaRampas() {
        return listaRampas;
    }

    public void setListaRampas(List<String> listaRampas) {
        this.listaRampas = listaRampas;
    }

    public List<EngEaGeneral> getListTavea() {
        return listTavea;
    }

    public void setListTavea(List<EngEaGeneral> listTavea) {
        this.listTavea = listTavea;
    }
    
    public Sequences getNumax() {
        return numax;
    }

    public void setNumax(Sequences numax) {
        this.numax = numax;
    }

    public String getMsnWork() {
        return msnWork;
    }

    public void setMsnWork(String msnWork) {
        this.msnWork = msnWork;
    }

    public String getHoursWork() {
        return hoursWork;
    }

    public void setHoursWork(String hoursWork) {
        this.hoursWork = hoursWork;
    }

    public String getCyclesWork() {
        return cyclesWork;
    }	   

    public void setCyclesWork(String cyclesWork) {
        this.cyclesWork = cyclesWork;
    }

    public String getAirWork() {
        return airWork;
    }

    public void setAirWork(String airWork) {
        this.airWork = airWork;
    }

    public boolean isExisteLista() {
        return existeLista;
    }

    public void setExisteLista(boolean existeLista) {
        this.existeLista = existeLista;
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

    public UploadedFile getFilex() {
        return filex;
    }

    public void setFilex(UploadedFile filex) {
        this.filex = filex;
    }											      

    public String getCompanyUser() {
        return companyUser;
    }

    public void setCompanyUser(String companyUser) {
        this.companyUser = companyUser;
    }

    public String getIdEAForm() {
        return idEAForm;
    }

    public void setIdEAForm(String idEAForm) {
        this.idEAForm = idEAForm;
    }
    
    public String getCompanySelected() {
        return companySelected;
    }

    public void setCompanySelected(String companySelected) {
        this.companySelected = companySelected;
    }
    public boolean isDisables() {
        return disables;
    }

    public void setDisables(boolean disables) {
        this.disables = disables;
    }
    public String getCompletEsr() {
        return completEsr;
    }

    public void setCompletEsr(String completEsr) {
        this.completEsr = completEsr;
    }

    public String getReasonEsr() {
        return reasonEsr;
    }

    public void setReasonEsr(String reasonEsr) {
        this.reasonEsr = reasonEsr;
    }

    public String getCriticalEsr() {
        return criticalEsr;
    }

    public void setCriticalEsr(String criticalEsr) {
        this.criticalEsr = criticalEsr;
    }

    public String getAogEsr() {
        return aogEsr;
    }

    public void setAogEsr(String aogEsr) {
        this.aogEsr = aogEsr;
    }

    public boolean isCriticalEsrb() {
        return criticalEsrb;
    }

    public void setCriticalEsrb(boolean criticalEsrb) {
        this.criticalEsrb = criticalEsrb;
    }

    public boolean isAogEsrb() {
        return aogEsrb;
    }

    public void setAogEsrb(boolean aogEsrb) {
        this.aogEsrb = aogEsrb;
    }

    public boolean isCompletEsrb() {
        return completEsrb;
    }

    public void setCompletEsrb(boolean completEsrb) {
        this.completEsrb = completEsrb;
    }

    public boolean isCompCheck() {
        return compCheck;
    }

    public void setCompCheck(boolean compCheck) {
        this.compCheck = compCheck;
    }   

    public String getAirCraft() {
        return airCraft;
    }

    public void setAirCraft(String airCraft) {
        this.airCraft = airCraft;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
    public String getTipoSolicitud() {
        return tipoSolicitud;
    }

    public void setTipoSolicitud(String tipoSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public String getCompanyECRSelected() {
        return companyECRSelected;
    }

    public void setCompanyECRSelected(String companyECRSelected) {
        this.companyECRSelected = companyECRSelected;
    }

    public String getCustomerSelected() {
        return customerSelected;
    }

    public void setCustomerSelected(String customerSelected) {
        this.customerSelected = customerSelected;
    }
    
    
}
