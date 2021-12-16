package com.aecas.managed;// paquete manage

import com.aees.languageSwitcher.LanguageSwitcher;// importacion de clase
import com.aees.session.SessionBean;// importacion de clase
import com.aeroman.aees.entities.EngEaGeneral;// importacion de clase
import com.aeroman.aees.entities.EngOrders;// importacion de clase
import com.aeroman.aees.entities.EngTaskCustUserVw;// importacion de clase
import com.aeroman.aees.entities.EngTaskListView;// importacion de clase
import com.aeroman.aees.entities.EngTasksByCustomerCiaVw;// importacion de clase
import com.aeroman.aees.entities.EngTasksByCustomerFltVw;// importacion de clase
import com.aeroman.aees.entities.EngTasksByCustomernfVw;// importacion de clase
import com.aeroman.aees.entities.EngTasksByFleetCustVw;// importacion de clase
import com.aeroman.aees.entities.EngTasksByFleetMngVw;// importacion de clase
import com.aeroman.aees.entities.EngTasksByFltCusUserVw;// importacion de clase
import com.aeroman.aees.entities.EngTasksByFltUserVw;// importacion de clase
import com.aeroman.aees.entities.EngTasksByUserCustMngVw;// importacion de clase
import com.aeroman.aees.entities.EngTasksByUserFltCustVw;// importacion de clase
import com.aeroman.aees.entities.EngTasksByUserFltMngVw;// importacion de clase
import com.aeroman.aees.entities.EngTasksByUserMngVw;// importacion de clase
import com.aeroman.aees.entities.EngTasksCustUserNfVw;// importacion de clase
import com.aeroman.aees.entities.grant.SgrCia;
import com.aeroman.aees.facades.EngTaskCustUserVwFacade;// importacion de clase
import com.aeroman.aees.facades.EngTaskListViewFacade;// importacion de clase
import com.aeroman.aees.facades.EngTasksByCustomerCiaVwFacade;// importacion de clase
import com.aeroman.aees.facades.EngTasksByCustomerFltVwFacade;// importacion de clase
import com.aeroman.aees.facades.EngTasksByFleetCustVwFacade;// importacion de clase
import com.aeroman.aees.facades.EngTasksByFleetMngVwFacade;// importacion de clase
import com.aeroman.aees.facades.EngTasksByFltCusUserVwFacade;// importacion de clase
import com.aeroman.aees.facades.EngTasksByFltUserVwFacade;// importacion de clase
import com.aeroman.aees.facades.EngTasksByUserCustMngVwFacade;// importacion de clase
import com.aeroman.aees.facades.EngTasksByUserFltCustVwFacade;// importacion de clase
import com.aeroman.aees.facades.EngTasksByUserFltMngVwFacade;// importacion de clase
import com.aeroman.aees.facades.EngTasksByUserMngVwFacade;// importacion de clase
import com.aeroman.aees.facades.EngTasksCustUserNfVwFacade;// importacion de clase
import com.aeroman.aees.facades.Sequences;// importacion de clase
import com.aeroman.aees.facades.grant.SgrCiaFacade;
import com.aeroman.aees.facades.grant.SgrUserFacades;
import java.io.Serializable;// libreria Serializable
import java.math.BigInteger;// libreria BigInteger
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;// libreria *
import java.util.logging.Level;// libreria Level
import java.util.logging.Logger;// libreria Logger
import javax.annotation.PostConstruct;// libreria PostConstruct
import javax.ejb.EJB;// libreria EJB
import javax.faces.bean.ManagedBean;// libreria ManagedBean
import javax.faces.bean.ManagedProperty;// libreria ManagedProperty
import javax.faces.bean.SessionScoped;// libreria SessionScoped
import javax.faces.context.ExternalContext;// libreria ExternalContext
import javax.faces.context.FacesContext;// libreria FacesContext
import javax.servlet.http.HttpSession;// libreria HttpSession

/**
 *
 * @author Usuario
 */
//nombre de clase en mageBean
@ManagedBean(name = "customerManagerBean")
@SessionScoped //tipo de clase
//clase ContAtasBean con extends al crud
public class CustomerManagerBean extends CrudBean<EngTasksByCustomerCiaVw> implements Serializable {

    @EJB
    private EngTasksCustUserNfVwFacade customeruserFacade;//declaracion de clases Facade
    @EJB
    private EngTasksByCustomerCiaVwFacade customerciaFacade;//declaracion de clases Facade
    @EJB
    private EngTasksByCustomerFltVwFacade cusciafltFacade;//declaracion de clases Facade
    @EJB
    private EngTaskCustUserVwFacade cusciafltuserFacade;//declaracion de clases Facade
    @EJB
    private EngTasksByUserMngVwFacade userFacade;//declaracion de clases Facade
    @EJB
    private EngTaskListViewFacade taskListFacade;//declaracion de clases Facade
    @EJB
    private EngTasksByFleetMngVwFacade fleetciaFacade;//declaracion de clases Facade
    @EJB
    private EngTasksByUserCustMngVwFacade userbycustFacade;//declaracion de clases Facade
    @EJB
    private EngTasksByUserFltCustVwFacade filtrouserflotafacede;//declaracion de clases Facade   
    @EJB
    private EngTasksByFltCusUserVwFacade fltcususerFacade;//declaracion de clases Facade
    @EJB
    private EngTasksByFltUserVwFacade fltbyonlyuser;//declaracion de clases Facade
    @EJB
    private EngTasksByFleetCustVwFacade flotasdoblefiltro;//declaracion de clases Facade    
    @EJB
    private EngTasksByUserFltMngVwFacade userbyflota;//declaracion de clases Facade    
    @EJB
    private Sequences numax;//declaracion de clases Facade
    
    @ManagedProperty(value="#{reportesSeguiCheqBean}")
    private ReportesSeguiCheqBean reportesSeguiCheqBean;//declarion variable tipo clase
        
    transient List<EngTasksByFleetMngVw> fleet = new ArrayList();//variable de lista
    transient List<EngTasksByFleetMngVw> fleetcompany = new ArrayList();//variable de lista
    transient List<EngTaskListView> taskList = new ArrayList();//variable de lista
    transient List<EngTasksByUserMngVw> user = new ArrayList();//variable de lista

    transient List<EngTasksByCustomernfVw> customer = new ArrayList();//variable de lista
    transient List<EngTasksByCustomernfVw> customer2 = new ArrayList();//variable de lista

    private int refresh;//declaracion de variable
    private Boolean filtrocliente;//declaracion de variable
    private Boolean filtroflota;//declaracion de variable
    private Boolean filtrouser;//declaracion de variable
    private String idcli ="";//declaracion de variable
    private String idflota ="";//declaracion de variable
    private String iduser="";//declaracion de variable
    private String idcompanhy="";//declaracion de variable
    private Integer conteoclientesgeneral;//declaracion de variable
    private Integer conteoflotabycom;//declaracion de variable
    private Integer conteouser;//declaracion de variable
    private Integer conteotask;//declaracion de variable
    private String indicesdelosfiltros = "";//declaracion de variable
    private String aaaa="";//declaracion de variable
    private List<String> filtros = new ArrayList();//variable de lista
    private String nombreinge;//declaracion de variable
    private List<String> clientesAutoc = new ArrayList();//variable de lista
    private String userfulname;//declaracion de variable
    private String usuario;//declaracion de variable
    private Date fechaActual= new Date();//declaracion de variable
    transient List<Object[]> listAll = new ArrayList<>();//variable de lista
    private String itemId;//declaracion de variable
    EngEaGeneral it1 = new EngEaGeneral();//declarion variable tipo clase
    EngOrders it2 = new EngOrders();//declaracion de variable
    @ManagedProperty(value = "#{swtLanguage}")
    private LanguageSwitcher languageSwitcher;//declarion variable tipo clase
    private SgrCia sgrCia = new SgrCia();//declarion variable tipo clase
    private String language;//declaracion de variable
    private String seleccionCompany;//declaracion de variable
    private String usersComp;
    private String companyUser;
    private String username="username";
    @EJB
    private SgrUserFacades sgrUser;//declaracion de clases Facade
    @EJB
    private SgrCiaFacade companyFacade;//declaracion de clases Facade
     //metodo generado por implements Serializable
    @Override
     //metodo constructor
    @PostConstruct
    public void init() {
        extendtime();
        elemento = new EngTasksByCustomerCiaVw();
        if (usersComp==null){
            FacesContext facesContext1 = FacesContext.getCurrentInstance();
            ExternalContext externalContext1 = facesContext1.getExternalContext();
            Map params1 = externalContext1.getRequestParameterMap();
            usersComp = (String) params1.get("user");
        }
        HttpSession session1 = SessionBean.getSession();
        if (usersComp==null) {  
            usersComp = (String) session1.getAttribute(username);
        }
        companyUser = sgrUser.findSelectUser(usersComp).getCiaDefault();
        if(companyUser!=null){
            sgrCia = companyFacade.find(companyUser);
            if(sgrCia.getCiaAcceso().intValue()==1){
                listado = customerciaFacade.findAll();
            }else{
                listado = customerciaFacade.findByUserCia(companyUser);
            }         
        
            conteoclientesgeneral = 0;
            conteoflotabycom = 0;
            Integer newconteocli = 0;
            Integer newconteoflota = 0;

            for (EngTasksByCustomerCiaVw count : listado) {

                newconteocli = newconteocli + Integer.parseInt(count.getTasks().toString());
            }
            conteoclientesgeneral = newconteocli;

            if(sgrCia.getCiaAcceso().intValue()==1){
                    fleet = fleetciaFacade.findAll();
            }else{
                    fleet = fleetciaFacade.findByUserCia(companyUser);
            }

            for (EngTasksByFleetMngVw count : fleet) {

                newconteoflota = newconteoflota + Integer.parseInt(count.getNumflota().toString());
            }
            conteoflotabycom = newconteoflota;

            if(sgrCia.getCiaAcceso().intValue()==1){
                taskList = taskListFacade.findByActive();
            }else{
                taskList = taskListFacade.findByUserCia(companyUser);
            }
            conteotask = taskList.size();
            if(sgrCia.getCiaAcceso().intValue()==1){
                user = userFacade.findAll();
            }else{
                user = userFacade.findByUserCia(companyUser);
            }

            Integer newcontusr = 0;
            for (EngTasksByUserMngVw li : user) {
                newcontusr = newcontusr + Integer.parseInt(li.getTask().toString());
            }
            conteouser = newcontusr;
            setRefresh(0);
            setIdcli("");
            setIdcompanhy("");
            setIdflota("");
            setIduser("");
            setIndicesdelosfiltros("");
            setNombreinge("");
            filtros = new ArrayList();

            FacesContext facesContext = FacesContext.getCurrentInstance();
            ExternalContext externalContext = facesContext.getExternalContext();
            Map params = externalContext.getRequestParameterMap();
            String userName = (String) params.get("user");
            HttpSession session = SessionBean.getSession();
            language = (String) params.get("language");
            if (language != null) {
                languageSwitcher.setLanguage(language);
            }
            if (userName != null) {
                session.setAttribute(username, userName);
                setUsuario(userName);
            }

            userName=(String) session.getAttribute(username);
            userfulname= numax.traernombredeusuario(userName);
            seleccionCompany = "butall";
        }
            
    }
    //llena lsita de customer
    public void countgeneral() {
        extendtime();
        listado.clear();
        listado = customerciaFacade.findAll();
        conteoclientesgeneral = 0;
        Integer newconteocli = 0;
        for (EngTasksByCustomerCiaVw count : listado) {
            newconteocli = newconteocli + Integer.parseInt(count.getTasks().toString());
        }
        conteoclientesgeneral = newconteocli;
    }
// metodo llena lista de floa 
    public void countgeneralflota() {
        extendtime();
        fleet.clear();
        fleet = fleetciaFacade.findAll();
        Integer newconteoflota = 0;
        for (EngTasksByFleetMngVw count : fleet) {

            newconteoflota = newconteoflota + Integer.parseInt(count.getNumflota().toString());
        }
        conteoflotabycom = newconteoflota;
    }
    //metodo qie filta por empresa
    public void filtroCompanyCustomer(String id) {
        seleccionCompany = "but"+id;
        extendtime();
        if (!"".equals(idcompanhy)) {
            filtros.remove(idcompanhy);
            filtros.add(id);
        } else {
            filtros.add(id);
        }
        aaaa = "\"" + id + "\"";
        setIdcompanhy(id);
        setRefresh(1);
        //compara la las flotas
        if (("").equals(idcli) && ("").equals(idflota) && ("").equals(iduser)) {
            //listado de clientes por compañia
            List<EngTasksByCustomerCiaVw> cus1 = customerciaFacade.findAll();
            List<EngTasksByCustomerCiaVw> cus2 = new ArrayList();
            int x1 = 0;
            while (x1 < cus1.size()) {

                EngTasksByCustomerCiaVw com = (EngTasksByCustomerCiaVw) cus1.get(x1);
                if (com.getCompany() != null && com.getCompany().equals(idcompanhy)) {
                    cus2.add(com);//agrega a lista

                }
                x1++;

            }
            Integer newconteocli = 0;
            for (EngTasksByCustomerCiaVw cu : cus2) {
                newconteocli = newconteocli + Integer.parseInt(cu.getTasks().toString());//llena nueva lista
            }
            conteoclientesgeneral = newconteocli;
            listado = cus2;

//        listado de flotas por compañia
            List<EngTasksByFleetMngVw> fleetcomp = fleetciaFacade.findAll();
            //lista de flota 2
            List<EngTasksByFleetMngVw> fleetcomp2 = new ArrayList();

            int xflt = 0;
            while (xflt < fleetcomp.size()) {//filta la lista

                EngTasksByFleetMngVw com = (EngTasksByFleetMngVw) fleetcomp.get(xflt);
                if (com.getCompany() != null && com.getCompany().equals(idcompanhy)) {
                    fleetcomp2.add(com); //agrega a lista ya filtrada
                }
                xflt++;

            }
            Integer newconteoflota = 0;
            for (EngTasksByFleetMngVw count : fleetcomp2) {
                newconteoflota = newconteoflota + Integer.parseInt(count.getNumflota().toString());
            }
            conteoflotabycom = newconteoflota;

            fleet = fleetcomp2;
            //listado de ingenieros por compañia
            List<EngTasksByUserMngVw> newuser = userFacade.findAll();
            //listado de ingenieros por compañia
            List<EngTasksByUserMngVw> newuser2 = new ArrayList();

            Integer newcontusr = 0;//declara variable
            int x = 0;//declara variable
            while (x < newuser.size()) {//recorre wile de la lista user

                EngTasksByUserMngVw com = (EngTasksByUserMngVw) newuser.get(x);
                if (com.getCompany() != null && com.getCompany().equals(idcompanhy)) {
                    newuser2.add(com);//agrega a la lista ya filtrada
                }

                x++;//incrementa la variable en 1

            }
            user = newuser2;//asiga la lista filtrada a user

            for (EngTasksByUserMngVw li : user) {//iitera la lista user
                newcontusr = newcontusr + Integer.parseInt(li.getTask().toString()); //sele concatena nuevo valor
            }
            conteouser = newcontusr; // se asigna valor a conteouser

            //listado de tareas mediante el filtro
            List<EngTaskListView> newtaskList = new ArrayList();
            //listado de tareas mediante el filtro
            List<EngTaskListView> newtaskList2 = taskListFacade.findAll();

            int y = 0;//declara variable
            while (y < newtaskList2.size()) {//itera la lista
                EngTaskListView lis = (EngTaskListView) newtaskList2.get(y);
                //filtro de lista
                if (lis.getCompany() != null && lis.getCompany().equals(idcompanhy)) {
                    newtaskList.add(lis);//agrega a la lista filtrada

                }
                y++;//incrementa en 1
            }
            taskList = newtaskList; //asiga en tasklist
            setConteotask(taskList.size()); //ingresa en total de lineas a contotask
        } else {
            validation();// funcion validador

        }

//</editor-fold>
    }
    //metodo que remueve compañias 
    public void quitarcompany()
    {
        extendtime();// etiende tiempo
        if(filtros.contains(idcompanhy)){//valida si existe
            filtros.remove(idcompanhy);//remueve elemento
        }
        setIdcompanhy("");//setea vacia la variable
        aaaa="";//listado de ingenieros por compañia
        setRefresh(1);//seta 1 a refresh
        validation();//metodo que valida
    }
    //metodo de validacion utilizado en metodos anteriores
    public void validation(){
        extendtime();
        if(!"".equals(idcli) && ("").equals(idflota) && ("").equals(iduser)){//filtra cliente
                this.filtromasivocliente();
            }
            if(("").equals(idcli) && !"".equals(idflota) && ("").equals(iduser)){//filtra flota
                this.filtromasivoflotas();
            }
            if(("").equals(idcli) && ("").equals(idflota) && !"".equals(iduser)){//filta ingenieros creo
                this.filtromasivoInge();
            }
            
            
            
            if(!"".equals(idcli) && ("").equals(idflota) && !"".equals(iduser)){// filta cliente y ingeniero creo
                this.filtromasivocliente();
                this.filtromasivoInge();
            }
             if(!"".equals(idcli) && !"".equals(idflota) && ("").equals(iduser)){// filta cliente y flota
                 this.filtromasivocliente();
                this.filtromasivoflotas();
            }
             if(("").equals(idcli) && !"".equals(idflota) && !"".equals(iduser)){//filtra flota y ingeniero
                this.filtromasivoflotas();
                this.filtromasivoInge();
            }
             
             if(!"".equals(idcli) && !"".equals(idflota) && !"".equals(iduser)){// filtra las cliente flota he ingeniero creo
                this.filtromasivocliente();
                this.filtromasivoflotas();
                this.filtromasivoInge();
            }
             if("".equals(idcli) && "".equals(idflota) && "".equals(iduser)){//filtra flota
                 this.init();
             }
    }
    //selecciona el cliente 
    public void filtrocliente(String id){
        extendtime();
        if(!filtros.contains(id)){
            filtros.add(id);
        }
        setRefresh(1);
        setIdcli(id);
        this.filtromasivocliente();
    }
    //filta por flota
    public void filtroflota(String id){
        extendtime();
        if(!filtros.contains(id)){
            filtros.add(id);
        }
        setRefresh(1);
        setIdflota(id);
        this.filtromasivoflotas();
    }
    //filtra ingeniero
    public void filtroinge(String id,String name){
        extendtime();
        if(!filtros.contains(name)){
            filtros.add(name);
        }
        setRefresh(1);
        setIduser(id);
        setNombreinge(name);
        this.filtromasivoInge();
    }
    //genera un reporte de ESR
    public void reportemngESR(String id, String Checkid, String company) {
        extendtime();
        try {//bloque controlado
            //xml para generar reporte
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
        } catch (Exception e) {
            Logger.getLogger(CustomerManagerBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    //genera un reporte de ESR (copia del metodo anterior con diferentes parametros)
    public void reportemngESR(String id){
        extendtime();
      try {//bloque controlado
        //xml para generar reporte
          String parametros="<pub:item>" 
                        + "<pub:dataType>xsd:string</pub:dataType>" 
                        + "<pub:name>idmessage</pub:name>" 
                        +   "<pub:values>" 
                        +     "<pub:item>"+id+"</pub:item>" 
                        +   "</pub:values>" 
                     +  "</pub:item>";
            reportesSeguiCheqBean.reportESR(parametros);
        } catch (Exception e) {//captura posbles errores
           Logger.getLogger(CustomerManagerBean.class.getName()).log(Level.SEVERE, null, e);
        }  
    }
    
    //genera un reporte de ESR
    public void reportemngETR(String id){
        extendtime();
      try {//bloque controlado
        //xml para generar reporte
          String parametros="<pub:item>" 
                        + "<pub:dataType>xsd:string</pub:dataType>" 
                        + "<pub:name>idmessage</pub:name>" 
                        +   "<pub:values>" 
                        +     "<pub:item>"+id+"</pub:item>" 
                        +   "</pub:values>" 
                     +  "</pub:item>";
            reportesSeguiCheqBean.reportETR(parametros);
        } catch (Exception e) {//captura posbles errores
           Logger.getLogger(CustomerManagerBean.class.getName()).log(Level.SEVERE, null, e);
        }  
    }
    
    //Reporte ECR:
    public void reportemngECR(String id){
      extendtime();
      try {
          String parametros="<pub:item>" 
                        + "<pub:dataType>xsd:string</pub:dataType>" 
                        + "<pub:name>idmessage</pub:name>" 
                        +   "<pub:values>" 
                        +     "<pub:item>"+id+"</pub:item>" 
                        +   "</pub:values>" 
                     +  "</pub:item>";
            reportesSeguiCheqBean.reportECR(parametros);
        } catch (Exception e) {
           Logger.getLogger(CustomerManagerBean.class.getName()).log(Level.SEVERE, null, e);
        }  
    }

    //quita los indices 
    public void quitarindices(String ivnhjht)
    {
        extendtime();//extiende tiempo
        int posicion = filtros.indexOf(ivnhjht);//declara y agrega a la variable el idex de filtro
        for (int i = filtros.size()-1; i > posicion; i--) {//itera la lista filtro con ingeniero
            if (filtros.get(i).equals(nombreinge)) {
                setIduser("");
                setNombreinge("");
            }
            if (filtros.get(i).equals(idcompanhy)) {//itera la lista filtro con la compañia
                setIdcompanhy("");
                aaaa="";
            }
            if (filtros.get(i).equals(idflota)) {//itera la lista filtro con la flota
                setIdflota("");
            }
            if (filtros.get(i).equals(idcli)) {//itera la lista filtro con el cliente
                setIdcli("");
            }
            filtros.remove(i); //remueve el indice
            
        }
        validation();
    }
    //metodo filtro masivo de cliente
    public void filtromasivocliente() {
        extendtime();
//<editor-fold defaultstate="collapsed" desc="filtro de cliente cuando solo se le ha dado click a cliente">
        //filtro de cliente cuando solo se le ha dado click a cliente
        if (("").equals(idcompanhy) && ("").equals(idflota) && ("").equals(iduser)) {
            //aqui el listado de todos los clientes ya con los filtros
            List<EngTasksByCustomerCiaVw> cus1 = customerciaFacade.findAll();
            List<EngTasksByCustomerCiaVw> cus2 = new ArrayList<>();
            int x1 = 0;
            while (x1 < cus1.size()) {

                EngTasksByCustomerCiaVw com = (EngTasksByCustomerCiaVw) cus1.get(x1);
                if (com.getCompany() != null && com.getEngId().equals(idcli)) {
                        cus2.add(com);
                    
                }
                x1++;

            }
            Integer newconteocli = 0;
            for (EngTasksByCustomerCiaVw cu : cus2) {
                newconteocli = newconteocli + Integer.parseInt(cu.getTasks().toString());
            }
            conteoclientesgeneral = newconteocli;
            listado = cus2;

            //aqui el listado de todas las workorder ya con los filtros
            List<EngTasksByFleetCustVw> fleetcomp = new ArrayList<>();
            List<EngTasksByFleetCustVw> fleetcomp2 = flotasdoblefiltro.findAll();
            List<EngTasksByFleetMngVw> fleetcomp3 = new ArrayList<>();

            
            int xflt = 0;
            while (xflt < fleetcomp2.size()) {

                EngTasksByFleetCustVw com = (EngTasksByFleetCustVw) fleetcomp2.get(xflt);
                if (com.getEagCustomer() != null && com.getEagCustomer().equals(idcli)) {
                        fleetcomp.add(com);
                }
                xflt++;

            }

            for (EngTasksByFleetCustVw engTaskByFleetCusVw : fleetcomp) {
                EngTasksByFleetMngVw etbf = new EngTasksByFleetMngVw();
                fleetcomp3.add(etbf);
                etbf.setRowId(engTaskByFleetCusVw.getRowId());
                etbf.setNumflota(engTaskByFleetCusVw.getNumflota());
                etbf.setColor(engTaskByFleetCusVw.getColor());
                etbf.setCompany(engTaskByFleetCusVw.getCompany());
                etbf.setWorkorder(engTaskByFleetCusVw.getWorkorder());
                etbf.setCola(engTaskByFleetCusVw.getCola());
            }
            Integer newconteoflota = 0;
            for (EngTasksByFleetMngVw count : fleetcomp3) {
                newconteoflota = newconteoflota + Integer.parseInt(count.getNumflota().toString());

            }
            conteoflotabycom = newconteoflota;
            fleet = fleetcomp3;

            //filtro de todos los ingenieros
            List<EngTasksByUserCustMngVw> user2 = userbycustFacade.findAll();
            List<EngTasksByUserCustMngVw> newUser1 = new ArrayList<>();
            List<EngTasksByUserMngVw> newUser = new ArrayList<>();
            

            int z = 0;
            while (z < user2.size()) {
                EngTasksByUserCustMngVw inge = (EngTasksByUserCustMngVw) user2.get(z);
                if (inge.getEagCustomer() != null && inge.getEagCustomer().equals(idcli)) {
                        newUser1.add(inge);
                    
                }
                z++;
            }
            for (EngTasksByUserCustMngVw element : newUser1) {
                EngTasksByUserMngVw engTaskByUser = new EngTasksByUserMngVw();
                engTaskByUser.setRowId(element.getRowId());
                engTaskByUser.setTask(element.getTask());
                engTaskByUser.setUsercode(element.getUsercode());
                engTaskByUser.setColor(element.getColor());
                engTaskByUser.setUserName(element.getUserName());
                engTaskByUser.setCompany(element.getCompany());
               
                newUser.add(engTaskByUser);
            }

            Integer newContUser = 0;
            for (EngTasksByUserMngVw element : newUser) {
                newContUser = newContUser + Integer.parseInt(element.getTask().toString());
            }
            conteouser = newContUser;
            this.user = newUser;

            //listado de tareas mediante el filtro
            List<EngTaskListView> newtaskList = new ArrayList<>();
            List<EngTaskListView> newtaskList2 = taskListFacade.findAll();
            
            int y = 0;
            while (y < newtaskList2.size()) {
                EngTaskListView lis = (EngTaskListView) newtaskList2.get(y);
                if (lis.getReqCustomer() != null && lis.getReqCustomer().equals(idcli)) {
                        newtaskList.add(lis);
                    
                }
                y++;
            }
            taskList = newtaskList;
            setConteotask(taskList.size());
        }
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="filtro de cliente cuando tambien se le dio al filtro de compañia">
        //filtro de cliente cuando tambien se le dio al filtro de compañia
        if(!("").equals(idcompanhy) && ("").equals(idflota) && ("").equals(iduser))
        {
             //aqui el listado de todos los clientes ya con los filtros
            List<EngTasksByCustomerCiaVw> cus1 = customerciaFacade.findAll();
        List<EngTasksByCustomerCiaVw> cus2 = new ArrayList();
        
        int x1 = 0;
        while (x1 < cus1.size()) {

            EngTasksByCustomerCiaVw com = (EngTasksByCustomerCiaVw) cus1.get(x1);
            if (com.getCompany() != null && com.getEngId().equals(idcli) && com.getCompany().equals(idcompanhy)) {
                    cus2.add(com);
                
            }
            x1++;

        }
        Integer newconteocli = 0;
            for (EngTasksByCustomerCiaVw cu : cus2) {
                newconteocli = newconteocli + Integer.parseInt(cu.getTasks().toString());
            }
            conteoclientesgeneral = newconteocli;
        listado=cus2;
        
        //aqui el listado de todas las workorder ya con los filtros
        
        List<EngTasksByFleetCustVw> fleetcomp = new ArrayList();
        List<EngTasksByFleetCustVw> fleetcomp2 = flotasdoblefiltro.findAll();
        List<EngTasksByFleetMngVw> fleetcomp3 = new ArrayList();
        
        
        int xflt = 0;
        while (xflt < fleetcomp2.size()) {

            EngTasksByFleetCustVw com = (EngTasksByFleetCustVw) fleetcomp2.get(xflt);
            if (com.getEagCustomer()!= null && com.getEagCustomer().equals(idcli) && com.getCompany().equals(idcompanhy)) {
                    fleetcomp.add(com);
            }
            xflt++;

        }
        
        for (EngTasksByFleetCustVw jf : fleetcomp) {
            EngTasksByFleetMngVw oli = new EngTasksByFleetMngVw();
            oli.setRowId(jf.getRowId());
            oli.setNumflota(jf.getNumflota());
            oli.setColor(jf.getColor());
            oli.setCompany(jf.getCompany());
            oli.setWorkorder(jf.getWorkorder());
            oli.setCola(jf.getCola());
            fleetcomp3.add(oli);

        }
        Integer newconteoflota = 0;
        for (EngTasksByFleetMngVw count : fleetcomp3) {
            newconteoflota = newconteoflota + Integer.parseInt(count.getNumflota().toString());

        }
        conteoflotabycom = newconteoflota;
        fleet = fleetcomp3;
        
        //filtro de todos los ingenieros
        List<EngTasksByUserCustMngVw> user2=userbycustFacade.findAll();
        List<EngTasksByUserCustMngVw> newUserEng = new ArrayList();
        List<EngTasksByUserMngVw> newUserEngMng = new ArrayList();
        
        
        int z = 0;
            while (z < user2.size()) {
                EngTasksByUserCustMngVw custMng = (EngTasksByUserCustMngVw) user2.get(z);
                if (custMng.getEagCustomer()!= null && custMng.getEagCustomer().equals(idcli) && custMng.getCompany().equals(idcompanhy)) {
                        newUserEng.add(custMng);
                    
                }
                z++;
            }
            for (EngTasksByUserCustMngVw element : newUserEng) {
                EngTasksByUserMngVw engElement = new EngTasksByUserMngVw();
                engElement.setRowId(element.getRowId());
                engElement.setCompany(element.getCompany());
                engElement.setUsercode(element.getUsercode());
                engElement.setColor(element.getColor());
                engElement.setUserName(element.getUserName());
                engElement.setTask(element.getTask());
                newUserEngMng.add(engElement);
            }
            this.user = newUserEngMng;
            Integer newCountUserMng = 0;
            for (EngTasksByUserMngVw engTasksByUserMng : this.user) {
                newCountUserMng = newCountUserMng + Integer.parseInt(engTasksByUserMng.getTask().toString());
            }
            conteouser = newCountUserMng;
            
            
            //listado de tareas mediante el filtro
            
            List<EngTaskListView> newtaskList = new ArrayList();
            List<EngTaskListView> newtaskList2=taskListFacade.findAll();
            
             int y = 0;
            while (y < newtaskList2.size()) {
                EngTaskListView lis = (EngTaskListView) newtaskList2.get(y);
                if (lis.getReqCustomer() != null && lis.getReqCustomer().equals(idcli) && lis.getCompany().equals(idcompanhy)) {
                        newtaskList.add(lis);
                }
                y++;
            }
            taskList = newtaskList;
            setConteotask(taskList.size());
        
        }
        
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="filtro de cliente cuando ya se le dio al cliente, compañia y flota"> ahora es por workorder
        //filtro de cliente cuando ya se le dio al cliente, compañia y flota
        if(!("").equals(idcompanhy) && !("").equals(idflota) && ("").equals(iduser))
        {
            
            //aqui el listado de todos los clientes ya con los filtros
            List<EngTasksByCustomerFltVw> cus1 = cusciafltFacade.findAll();
        List<EngTasksByCustomerFltVw> customerFlt = new ArrayList();
         List<EngTasksByCustomerCiaVw> cus = new ArrayList();
        
        int custCounter = 0;
        while (custCounter < cus1.size()) {

            EngTasksByCustomerFltVw com = (EngTasksByCustomerFltVw) cus1.get(custCounter);
            if (com.getEngId() != null && com.getEngId().equals(idcli) && com.getCompany().equals(idcompanhy) && com.getWorkorder().equals(idflota)) {
                    customerFlt.add(com);
            }
            custCounter++;

        }
        for (EngTasksByCustomerFltVw custFlt : customerFlt) {
                    EngTasksByCustomerCiaVw custCustCia = new EngTasksByCustomerCiaVw();
                    custCustCia.setCompany(custFlt.getCompany());
                    custCustCia.setEngId(custFlt.getEngId());
                    custCustCia.setTasks(custFlt.getTasks());
                    custCustCia.setEngName(custFlt.getEngName());
                    custCustCia.setColor(custFlt.getColor());
                    
                    cus.add(custCustCia);
                    
                }
        Integer newCustFltCount = 0;
            for (EngTasksByCustomerCiaVw custCiaElement : cus) {
                newCustFltCount = newCustFltCount + Integer.parseInt(custCiaElement.getTasks().toString());
            }
            conteoclientesgeneral = newCustFltCount;
        listado=cus;
        
        //filtro de todos los ingenieros
        List<EngTasksByUserFltCustVw> userList=filtrouserflotafacede.findAll();
        List<EngTasksByUserFltCustVw> userFltCust = new ArrayList();
        List<EngTasksByUserMngVw> newUserFltCust = new ArrayList();
        
        int z = 0;
            while (z < userList.size()) {
                EngTasksByUserFltCustVw engUserFlt = (EngTasksByUserFltCustVw) userList.get(z);
                if (engUserFlt.getEagCustomer()!= null && engUserFlt.getEagCustomer().equals(idcli) && engUserFlt.getCompany().equals(idcompanhy) && engUserFlt.getWorkorder().equals(idflota)) {
                        userFltCust.add(engUserFlt);
                }
                z++;
            }
            for (EngTasksByUserFltCustVw userFltCustElement : userFltCust) {
                EngTasksByUserMngVw userMngVw = new EngTasksByUserMngVw();
                userMngVw.setTask(userFltCustElement.getTask());
                userMngVw.setColor(userFltCustElement.getColor());
                userMngVw.setRowId(userFltCustElement.getRowId());
                userMngVw.setUsercode(userFltCustElement.getUsercode());
                userMngVw.setUserName(userFltCustElement.getUserName());
                userMngVw.setCompany(userFltCustElement.getCompany());
                
                newUserFltCust.add(userMngVw);
            }
            
            Integer newUserc = 0;
            for (EngTasksByUserMngVw UserMngCust : newUserFltCust) {
                newUserc = newUserc + Integer.parseInt(UserMngCust.getTask().toString());
            }
            conteouser = newUserc;
            this.user = newUserFltCust;
            
            //listado de tareas mediante el filtro
            
            List<EngTaskListView> newEngTaskList = new ArrayList();
            List<EngTaskListView> engTaskList=taskListFacade.findAll();
            
             int y = 0;
            while (y < engTaskList.size()) {
                EngTaskListView listTask = (EngTaskListView) engTaskList.get(y);
                if (listTask.getReqCustomer() != null && listTask.getReqCustomer().equals(idcli) && listTask.getCompany().equals(idcompanhy) && listTask.getWorkorder().equals(idflota)) {
                        newEngTaskList.add(listTask);
                }
                y++;
            }
            taskList = newEngTaskList;
            setConteotask(taskList.size());
        
        }
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="filtro de cliente cuando ya se le dio al cliente, compañia, flota e ingeniero"> ya no es flota es workorder
        //filtro de cliente cuando ya se le dio al cliente, compañia, flota e ingeniero
        if(!("").equals(idcompanhy) && !("").equals(idflota) && !("").equals(iduser))
        {
             //aqui el listado de todos los clientes ya con los filtros
            List<EngTaskCustUserVw> cus1 = cusciafltuserFacade.findAll();
        List<EngTaskCustUserVw> engTaskCustUserList = new ArrayList();
         List<EngTasksByCustomerCiaVw> customerCiaList = new ArrayList();
        
        int x1 = 0;
        while (x1 < cus1.size()) {

            EngTaskCustUserVw com = (EngTaskCustUserVw) cus1.get(x1);
            
                if (com.getEngId().equals(idcli) && com.getCompany().equals(idcompanhy) && com.getWorkorder().equals(idflota) && com.getUsercode().equals(iduser)) {
                    engTaskCustUserList.add(com);
                }
            
            x1++;

        }
        for (EngTaskCustUserVw custUserVwList : engTaskCustUserList) {
                    EngTasksByCustomerCiaVw customerCia = new EngTasksByCustomerCiaVw();
                    customerCia.setEngName(custUserVwList.getEngName());
                    customerCia.setColor(custUserVwList.getColor());
                    customerCia.setTasks(custUserVwList.getTasks());
                    customerCia.setCompany(custUserVwList.getCompany());
                    customerCia.setEngId(custUserVwList.getEngId());                    
                    customerCiaList.add(customerCia);
                    
                }
        Integer newCustCia = 0;
            for (EngTasksByCustomerCiaVw taskByCustCiaList : customerCiaList) {
                newCustCia = newCustCia + Integer.parseInt(taskByCustCiaList.getTasks().toString());
            }
            conteoclientesgeneral = newCustCia;
        listado=customerCiaList;
        
        //listado de tareas mediante el filtro
            
            List<EngTaskListView> taskList1 = new ArrayList();
            List<EngTaskListView> taskLis2=taskListFacade.findAll();
            
             int y = 0;
            while (y < taskLis2.size()) {
                EngTaskListView engTaskListView = (EngTaskListView) taskLis2.get(y);
                if (engTaskListView.getReqCustomer().equals(idcli) && engTaskListView.getCompany().equals(idcompanhy) && 
                        engTaskListView.getWorkorder().equals(idflota) && engTaskListView.getUsrCoduser().equals(iduser))
                    {
                        taskList1.add(engTaskListView);
                    
                }
                y++;
            }
            taskList = taskList1;
            setConteotask(taskList.size());
        }
        
         
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="filtro de clientes por cliente compañia e inge">
        //filtro de clientes por cliente compañia e inge
        if(!("").equals(idcompanhy) && ("").equals(idflota) && !("").equals(iduser))
        {
            
            //aqui el listado de todos los clientes ya con los filtros
            List<EngTasksCustUserNfVw> cus1 = customeruserFacade.findAll();
        List<EngTasksCustUserNfVw> custUserNf = new ArrayList();
         List<EngTasksByCustomerCiaVw> customerCiaVwList = new ArrayList();
        
        int custNf = 0;
        while (custNf < cus1.size()) {

            EngTasksCustUserNfVw com = (EngTasksCustUserNfVw) cus1.get(custNf);
            if (com.getCompany() != null && com.getEngId().equals(idcli) && com.getCompany().equals(idcompanhy) && com.getUsercode().equals(iduser)) {
                    custUserNf.add(com);
            }
            custNf++;

        }
        for (EngTasksCustUserNfVw userNf : custUserNf) {
                    EngTasksByCustomerCiaVw custCiaVw = new EngTasksByCustomerCiaVw();
                    custCiaVw.setEngId(userNf.getEngId());
                    custCiaVw.setEngName(userNf.getEngName());
                    custCiaVw.setTasks(userNf.getTasks());
                    custCiaVw.setColor(userNf.getColor());
                    custCiaVw.setCompany(userNf.getCompany());
                    customerCiaVwList.add(custCiaVw);
                    
                }
        Integer custCiaNf = 0;
            for (EngTasksByCustomerCiaVw ciaList : customerCiaVwList) {
                custCiaNf = custCiaNf + Integer.parseInt(ciaList.getTasks().toString());
            }
            conteoclientesgeneral = custCiaNf;
        listado=customerCiaVwList;
        
         //listado de workorder por inge compañia y cliente
            List<EngTasksByFltCusUserVw> fltCusUser = fltcususerFacade.findAll();
            List<EngTasksByFltCusUserVw> fltCusUserTemp = new ArrayList();
            List<EngTasksByFleetMngVw> fltCusUserTem2 = new ArrayList();
            
                int nFlt = 0;
                while (nFlt < fltCusUser.size()) {

                    EngTasksByFltCusUserVw fltCustUserVw = (EngTasksByFltCusUserVw) fltCusUser.get(nFlt);
                        if (fltCustUserVw.getUsercode().equals(iduser) && fltCustUserVw.getCompany().equals(idcompanhy) && fltCustUserVw.getEagCustomer().equals(idcli)) {
                            fltCusUserTemp.add(fltCustUserVw);
                        
                    }
                    nFlt++;

                }
                for (EngTasksByFltCusUserVw fleetCust : fltCusUserTemp) {
                    EngTasksByFleetMngVw flet = new EngTasksByFleetMngVw();
                    flet.setNumflota(fleetCust.getNumflota());
                    flet.setCompany(fleetCust.getCompany());
                    flet.setRowId(fleetCust.getRowId());
                    flet.setColor(fleetCust.getColor());
                    flet.setCola(fleetCust.getCola());
                    flet.setWorkorder(fleetCust.getWorkorder());
                    fltCusUserTem2.add(flet);
                }
                Integer cFleet = 0;
                for (EngTasksByFleetMngVw count : fltCusUserTem2) {
                    cFleet = cFleet + Integer.parseInt(count.getNumflota().toString());
                }
                conteoflotabycom = cFleet;

                fleet = fltCusUserTem2;
            
            //listado de tareas mediante el filtro
            
            List<EngTaskListView> engTaskListView1 = new ArrayList();
            List<EngTaskListView> engTaskListView2=taskListFacade.findAll();
            
             int counterList = 0;
            while (counterList < engTaskListView2.size()) {
                EngTaskListView taskListTemp = (EngTaskListView) engTaskListView2.get(counterList);
                    if (taskListTemp.getReqCustomer().equals(idcli) && taskListTemp.getCompany().equals(idcompanhy) && taskListTemp.getUsrCoduser().equals(iduser)) {
                        engTaskListView1.add(taskListTemp);
                }
                counterList++;
            }
            taskList = engTaskListView1;
            setConteotask(taskList.size());
        
        }
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="filtro de cliente por id e inge sin compañia">
        //filtro de cliente por id e inge sin compañia
        if(("").equals(idcompanhy) && ("").equals(idflota) && !"".equals(iduser))
        {
            
            //aqui el listado de todos los clientes ya con los filtros
            List<EngTasksCustUserNfVw> cus1 = customeruserFacade.findAll();
        List<EngTasksCustUserNfVw> cus2 = new ArrayList();
         List<EngTasksByCustomerCiaVw> cus = new ArrayList();
        
        int x1 = 0;
        while (x1 < cus1.size()) {

            EngTasksCustUserNfVw com = (EngTasksCustUserNfVw) cus1.get(x1);
            if (com.getCompany() != null && com.getEngId().equals(idcli) && com.getUsercode().equals(iduser)) {
                    cus2.add(com);
                
            }
            x1++;

        }
        for (EngTasksCustUserNfVw ja : cus2) {
                    EngTasksByCustomerCiaVw ciaCust = new EngTasksByCustomerCiaVw();
                    ciaCust.setTasks(ja.getTasks());
                    ciaCust.setEngId(ja.getEngId());
                    ciaCust.setColor(ja.getColor());
                    ciaCust.setCompany(ja.getCompany());
                    ciaCust.setEngName(ja.getEngName());

                    cus.add(ciaCust);
                    
                }
        Integer newconteocli = 0;
            for (EngTasksByCustomerCiaVw cu : cus) {
                newconteocli = newconteocli + Integer.parseInt(cu.getTasks().toString());
            }
            conteoclientesgeneral = newconteocli;
        listado=cus;
        
         //listado de workorder por inge y cliente
            List<EngTasksByFltCusUserVw> fltCustUserVw = fltcususerFacade.findAll();
            List<EngTasksByFltCusUserVw> fltCustUserVw1 = new ArrayList();
            List<EngTasksByFleetMngVw> fltCustUserVw2 = new ArrayList();
            
                int countFleet = 0;
                while (countFleet < fltCustUserVw.size()) {

                    EngTasksByFltCusUserVw elementFltCusUser = (EngTasksByFltCusUserVw) fltCustUserVw.get(countFleet);
                    if (elementFltCusUser.getEagCustomer()!= null  && elementFltCusUser.getUsercode().equals(iduser) && elementFltCusUser.getEagCustomer().equals(idcli)) {
                            fltCustUserVw1.add(elementFltCusUser);
                        
                    }
                    countFleet++;

                }
                for (EngTasksByFltCusUserVw fltCusT : fltCustUserVw1) {
                    EngTasksByFleetMngVw fletTemp = new EngTasksByFleetMngVw();
                    fletTemp.setNumflota(fltCusT.getNumflota());
                    fletTemp.setRowId(fltCusT.getRowId());
                    fletTemp.setCompany(fltCusT.getCompany());
                    fletTemp.setColor(fltCusT.getColor());
                    fletTemp.setWorkorder(fltCusT.getWorkorder());
                    fletTemp.setCola(fltCusT.getCola());
                    fltCustUserVw2.add(fletTemp);
                }
                Integer contFleet = 0;
                for (EngTasksByFleetMngVw count : fltCustUserVw2) {
                    contFleet = contFleet + Integer.parseInt(count.getNumflota().toString());
                }
                conteoflotabycom = contFleet;

                fleet = fltCustUserVw2;
            
            //listado de tareas mediante el filtro
            
            List<EngTaskListView> listTemp1 = new ArrayList();
            List<EngTaskListView> listTemp2=taskListFacade.findAll();
            
             int contList = 0;
            while (contList < listTemp2.size()) {
                EngTaskListView listTasksT = (EngTaskListView) listTemp2.get(contList);
                if (listTasksT.getReqCustomer() != null && listTasksT.getReqCustomer().equals(idcli) && listTasksT.getUsrCoduser().equals(iduser)) {
                        listTemp1.add(listTasksT);
                }
                contList++;
            }
            taskList = listTemp1;
            setConteotask(taskList.size());
        
        }
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="filtro de clientes por id y flota sin compañia"> workorder
        //filtro de clientes por id y flota sin compañia
        if(("").equals(idcompanhy) && !"".equals(idflota) && ("").equals(iduser))
        {
            
            //aqui el listado de todos los clientes ya con los filtros
            List<EngTasksByCustomerFltVw> cus1 = cusciafltFacade.findAll();
        List<EngTasksByCustomerFltVw> customerFleet = new ArrayList();
         List<EngTasksByCustomerCiaVw> customerFleet2 = new ArrayList();
        
        int x1 = 0;
        while (x1 < cus1.size()) {

            EngTasksByCustomerFltVw com = (EngTasksByCustomerFltVw) cus1.get(x1);
            if (com.getEngId() != null && com.getEngId().equals(idcli) && com.getWorkorder().equals(idflota)) {
                    customerFleet.add(com);
                }
            x1++;

        }
        for (EngTasksByCustomerFltVw customerFlt : customerFleet) {
                    EngTasksByCustomerCiaVw cusflt = new EngTasksByCustomerCiaVw();
                    cusflt.setEngId(customerFlt.getEngId());
                    cusflt.setEngName(customerFlt.getEngName());
                    cusflt.setTasks(customerFlt.getTasks());
                    cusflt.setColor(customerFlt.getColor());
                    cusflt.setCompany(customerFlt.getCompany());
                    customerFleet2.add(cusflt);
                    
                }
        Integer newconteocli = 0;
            for (EngTasksByCustomerCiaVw cu : customerFleet2) {
                newconteocli = newconteocli + Integer.parseInt(cu.getTasks().toString());
            }
            conteoclientesgeneral = newconteocli;
        listado=customerFleet2;
        
        //filtro de todos los ingenieros
        List<EngTasksByUserFltCustVw> user2=filtrouserflotafacede.findAll();
        List<EngTasksByUserFltCustVw> newUserFlt = new ArrayList();
        List<EngTasksByUserMngVw> newuser = new ArrayList();
        
        
        int z = 0;
            while (z < user2.size()) {
                EngTasksByUserFltCustVw userEngFlt = (EngTasksByUserFltCustVw) user2.get(z);
                if (userEngFlt.getEagCustomer()!= null && userEngFlt.getEagCustomer().equals(idcli) && userEngFlt.getWorkorder().equals(idflota)) {
                        newUserFlt.add(userEngFlt);
                }
                z++;
            }
            for (EngTasksByUserFltCustVw userFltElem : newUserFlt) {
                EngTasksByUserMngVw userMngTemp = new EngTasksByUserMngVw();
                userMngTemp.setRowId(userFltElem.getRowId());
                userMngTemp.setUsercode(userFltElem.getUsercode());
                userMngTemp.setUserName(userFltElem.getUserName());
                userMngTemp.setCompany(userFltElem.getCompany());
                userMngTemp.setTask(userFltElem.getTask());
                userMngTemp.setColor(userFltElem.getColor());
                newuser.add(userMngTemp);
            }
            
            Integer newcontusr = 0;
            for (EngTasksByUserMngVw li : newuser) {
                newcontusr = newcontusr + Integer.parseInt(li.getTask().toString());
            }
            conteouser = newcontusr;
            this.user = newuser;
            
            //listado de tareas mediante el filtro
            
            List<EngTaskListView> newtaskList = new ArrayList();
            List<EngTaskListView> newtaskList2=taskListFacade.findAll();
            
             int y = 0;
            while (y < newtaskList2.size()) {
                EngTaskListView lis = (EngTaskListView) newtaskList2.get(y);
                if (lis.getReqCustomer() != null && lis.getReqCustomer().equals(idcli) && lis.getWorkorder().equals(idflota)) {
                        newtaskList.add(lis);
                }
                y++;
            }
            taskList = newtaskList;
            setConteotask(taskList.size());
        
        }
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="filtro de clientes por id flota e ingeniero sin compañia"> workorder en lugar de flota
        if(("").equals(idcompanhy) && !"".equals(idflota) && !"".equals(iduser))
        {
            
            //aqui el listado de todos los clientes ya con los filtros
            List<EngTaskCustUserVw> cus1 = cusciafltuserFacade.findAll();
        List<EngTaskCustUserVw> cus2 = new ArrayList();
         List<EngTasksByCustomerCiaVw> cus = new ArrayList();
        
        int x1 = 0;
        while (x1 < cus1.size()) {

            EngTaskCustUserVw com = (EngTaskCustUserVw) cus1.get(x1);
            if (com.getEngId() != null && com.getEngId().equals(idcli) && com.getWorkorder().equals(idflota) && com.getUsercode().equals(iduser)) {
                    cus2.add(com);
            }
            x1++;

        }
        for (EngTaskCustUserVw etcu : cus2) {
                    EngTasksByCustomerCiaVw custCiaTemp1 = new EngTasksByCustomerCiaVw();
                    custCiaTemp1.setEngId(etcu.getEngId());
                    custCiaTemp1.setEngName(etcu.getEngName());
                    custCiaTemp1.setTasks(etcu.getTasks());
                    custCiaTemp1.setColor(etcu.getColor());
                    custCiaTemp1.setCompany(etcu.getCompany());
                    cus.add(custCiaTemp1);
                    
                }
        Integer newconteocli = 0;
            for (EngTasksByCustomerCiaVw cu : cus) {
                newconteocli = newconteocli + Integer.parseInt(cu.getTasks().toString());
            }
            conteoclientesgeneral = newconteocli;
        listado=cus;
        
        
            
            //listado de tareas mediante el filtro
            
            List<EngTaskListView> newtaskList = new ArrayList();
            List<EngTaskListView> newtaskList2=taskListFacade.findAll();
            
             int y = 0;
            while (y < newtaskList2.size()) {
                EngTaskListView lis = (EngTaskListView) newtaskList2.get(y);
                if (lis.getReqCustomer().equals(idcli) && lis.getWorkorder().equals(idflota) && lis.getUsrCoduser().equals(iduser)) {
                        newtaskList.add(lis);
                }
                y++;
            }
            taskList = newtaskList;
            setConteotask(taskList.size());
        
        }        
//</editor-fold>
    }
//filtro masivo de flota
    public void filtromasivoflotas()
    {
        extendtime();
//<editor-fold defaultstate="collapsed" desc="filtro de las flotas por la flota misma"> AHORA ES POR WORKORDER
        //filtro de las flotas por la flota misma"> AHORA ES POR WORKORDER
        if(("").equals(idcompanhy) && ("").equals(idcli) && ("").equals(iduser))
        {
        List<EngTasksByFleetMngVw> fleetcomp = fleetciaFacade.findAll();
        List<EngTasksByFleetMngVw> fltCompTemp = new ArrayList();
        
            int xFleet = 0;
            while (xFleet < fleetcomp.size()) {

                EngTasksByFleetMngVw com = (EngTasksByFleetMngVw) fleetcomp.get(xFleet);
                if (com.getWorkorder() != null && com.getWorkorder().equals(idflota)) {
                        fltCompTemp.add(com);
                }
                xFleet++;

            }
            Integer nFleet = 0;
            for (EngTasksByFleetMngVw fltMngTemp : fltCompTemp) {
                nFleet = nFleet + Integer.parseInt(fltMngTemp.getNumflota().toString());
            }
            conteoflotabycom = nFleet;

            fleet = fltCompTemp;
            
            
            //listado de clientes por flota
            List<EngTasksByCustomerFltVw> newCus1=cusciafltFacade.findAll();
            List<EngTasksByCustomerFltVw> newCus2 = new ArrayList();
            List<EngTasksByCustomerCiaVw> newCus3 = new ArrayList();
            
            int contCust = 0;
            while (contCust < newCus1.size()) {
                EngTasksByCustomerFltVw cliente = (EngTasksByCustomerFltVw) newCus1.get(contCust);

                if (cliente.getWorkorder() != null && cliente.getWorkorder().equals(idflota)) {
                        newCus2.add(cliente);
                }
                contCust++;
            }
            for (EngTasksByCustomerFltVw custFlte : newCus2) {
                EngTasksByCustomerCiaVw ciaT = new EngTasksByCustomerCiaVw();
                ciaT.setEngId(custFlte.getEngId());
                ciaT.setEngName(custFlte.getEngName());
                ciaT.setTasks(custFlte.getTasks());
                ciaT.setColor(custFlte.getColor());
                ciaT.setCompany(custFlte.getCompany());
                newCus3.add(ciaT);
            }
            
            Integer contNewCust = 0;
            for (EngTasksByCustomerCiaVw ciaCustT : newCus3) {
                contNewCust = contNewCust + Integer.parseInt(ciaCustT.getTasks().toString());
            }
            conteoclientesgeneral = contNewCust;
            listado = newCus3;
            
            //listado de ingenieros por flota
            List<EngTasksByUserFltMngVw> newuser;
            List<EngTasksByUserFltMngVw> newUserMng2 = new ArrayList<>();
            List<EngTasksByUserMngVw> user2 = new ArrayList<>();
            newuser=userbyflota.findAll();
            int contNew = 0;
            while (contNew < newuser.size()) {
                EngTasksByUserFltMngVw inge = (EngTasksByUserFltMngVw) newuser.get(contNew);
                if (inge.getWorkorder() != null && inge.getWorkorder().equals(idflota)) {
                        newUserMng2.add(inge);
                }
                contNew++;
            }
            for (EngTasksByUserFltMngVw userMngVw : newUserMng2) {
                EngTasksByUserMngVw userMngTemporal = new EngTasksByUserMngVw();
                userMngTemporal.setRowId(userMngVw.getRowId());
                userMngTemporal.setUsercode(userMngVw.getUsercode());
                userMngTemporal.setUserName(userMngVw.getUserName());
                userMngTemporal.setCompany(userMngVw.getCompany());
                userMngTemporal.setTask(userMngVw.getTask());
                userMngTemporal.setColor(userMngVw.getColor());
                user2.add(userMngTemporal);
            }
            this.user = user2;
            Integer contMng = 0;
            for (EngTasksByUserMngVw li : this.user) {
                contMng = contMng + Integer.parseInt(li.getTask().toString());
            }
            conteouser = contMng;
            
            //lista de esr por flota
            List<EngTaskListView> taskListFleetMng = new ArrayList();
            List<EngTaskListView> taskListFleetMng2=taskListFacade.findAll();
            
             int y = 0;
            while (y < taskListFleetMng2.size()) {
                EngTaskListView listFleetMng2 = (EngTaskListView) taskListFleetMng2.get(y);
                if (listFleetMng2.getWorkorder()!= null && listFleetMng2.getWorkorder().equals(idflota))
                    {
                        taskListFleetMng.add(listFleetMng2);
                }
                y++;
            }
            taskList = taskListFleetMng;
            setConteotask(taskList.size());
        }
        //</editor-fold>
//<editor-fold defaultstate="collapsed" desc="filtro de flotas por id y compañia"> ahora es workorder en lugar de flota
     //filtro de flotas por id y compañia
        if(!"".equals(idcompanhy) && ("").equals(idcli) && ("").equals(iduser))
        {
            //listado de workorder por id y compañia 
            List<EngTasksByFleetMngVw> fleetcomp = fleetciaFacade.findAll();
        List<EngTasksByFleetMngVw> fleetcomp2 = new ArrayList();
        
            int xflt = 0;
            while (xflt < fleetcomp.size()) {

                EngTasksByFleetMngVw com = (EngTasksByFleetMngVw) fleetcomp.get(xflt);
                if (com.getWorkorder() != null && com.getWorkorder().equals(idflota) && com.getCompany().equals(idcompanhy)) {
                        fleetcomp2.add(com);
                    
                }
                xflt++;

            }
            Integer newconteoflota = 0;
            for (EngTasksByFleetMngVw count : fleetcomp2) {
                newconteoflota = newconteoflota + Integer.parseInt(count.getNumflota().toString());
            }
            conteoflotabycom = newconteoflota;

            fleet = fleetcomp2;
            
            //listado de clientes por flota y compañia
             List<EngTasksByCustomerFltVw> newcustomer1=cusciafltFacade.findAll();
            List<EngTasksByCustomerFltVw> newcustomer2 = new ArrayList();
            List<EngTasksByCustomerCiaVw> newcustomer3 = new ArrayList();
            
            int x = 0;
            while (x < newcustomer1.size()) {
                EngTasksByCustomerFltVw cliente = (EngTasksByCustomerFltVw) newcustomer1.get(x);

                if (cliente.getWorkorder() != null && cliente.getWorkorder().equals(idflota) && cliente.getCompany().equals(idcompanhy)) {
                        newcustomer2.add(cliente);
                    
                }
                x++;
            }
            for (EngTasksByCustomerFltVw eTaskBtCus : newcustomer2) {
                EngTasksByCustomerCiaVw eCusCia = new EngTasksByCustomerCiaVw();
                eCusCia.setEngId(eTaskBtCus.getEngId());
                eCusCia.setEngName(eTaskBtCus.getEngName());
                eCusCia.setTasks(eTaskBtCus.getTasks());
                eCusCia.setColor(eTaskBtCus.getColor());
                eCusCia.setCompany(eTaskBtCus.getCompany());
                newcustomer3.add(eCusCia);
            }
            
            Integer newconteocli = 0;
            for (EngTasksByCustomerCiaVw cu : newcustomer3) {
                newconteocli = newconteocli + Integer.parseInt(cu.getTasks().toString());
            }
            conteoclientesgeneral = newconteocli;
            listado = newcustomer3;
            
            //listado de ingenieros por flota y compañia
            List<EngTasksByUserFltMngVw> newuser=userbyflota.findAll();
            List<EngTasksByUserFltMngVw> newuser2 = new ArrayList();
            List<EngTasksByUserMngVw> userMng = new ArrayList();
            
            int z = 0;
            while (z < newuser.size()) {
                EngTasksByUserFltMngVw inge = (EngTasksByUserFltMngVw) newuser.get(z);
                if (inge.getWorkorder() != null && inge.getWorkorder().equals(idflota) && inge.getCompany().equals(idcompanhy)) {
                        newuser2.add(inge);
                }
                z++;
            }
            for (EngTasksByUserFltMngVw eTaskUserFltMng : newuser2) {
                EngTasksByUserMngVw eTaskByUserMng = new EngTasksByUserMngVw();
                eTaskByUserMng.setRowId(eTaskUserFltMng.getRowId());
                eTaskByUserMng.setUsercode(eTaskUserFltMng.getUsercode());
                eTaskByUserMng.setUserName(eTaskUserFltMng.getUserName());
                eTaskByUserMng.setCompany(eTaskUserFltMng.getCompany());
                eTaskByUserMng.setTask(eTaskUserFltMng.getTask());
                eTaskByUserMng.setColor(eTaskUserFltMng.getColor());
                userMng.add(eTaskByUserMng);
            }
            this.user = userMng;
            Integer contUserMng = 0;
            for (EngTasksByUserMngVw eList : this.user) {
                contUserMng = contUserMng + Integer.parseInt(eList.getTask().toString());
            }
            conteouser = contUserMng;
            
            //lista de esr por workorder
            List<EngTaskListView> eList = new ArrayList();
            List<EngTaskListView> eList2=taskListFacade.findAll();
            
             int y = 0;
            while (y < eList2.size()) {
                EngTaskListView lis = (EngTaskListView) eList2.get(y);
                if (lis.getReqCustomer() != null && lis.getCompany().equals(idcompanhy) && lis.getWorkorder().equals(idflota)){
                        eList.add(lis);
                    
                }
                y++;
            }
            taskList = eList;
            setConteotask(taskList.size());
        }   
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="filtro de flotas por id cliente y compañia"> por workorder, no por flota
     //filtro de flotas por id cliente y compañia   
     if(!"".equals(idcompanhy) && !"".equals(idcli) && ("").equals(iduser))
        {
             //listado de workorder por id compañia y cliente
            List<EngTasksByFleetCustVw> fleetcomp = flotasdoblefiltro.findAll();
        List<EngTasksByFleetCustVw> fleetcomp2 = new ArrayList();
        List<EngTasksByFleetMngVw> fleetcomp3 = new ArrayList();
        
            int xflt = 0;
            while (xflt < fleetcomp.size()) {

                EngTasksByFleetCustVw com = (EngTasksByFleetCustVw) fleetcomp.get(xflt);
                if (com.getWorkorder() != null && com.getWorkorder().equals(idflota) && com.getCompany().equals(idcompanhy) && com.getEagCustomer().equals(idcli)) {
                        fleetcomp2.add(com);
                }
                xflt++;

            }
            for (EngTasksByFleetCustVw flt : fleetcomp2) {
                EngTasksByFleetMngVw flet = new EngTasksByFleetMngVw();
                flet.setNumflota(flt.getNumflota());
                flet.setRowId(flt.getRowId());
                flet.setCompany(flt.getCompany());
                flet.setColor(flt.getColor());
                flet.setWorkorder(flt.getWorkorder());
                flet.setCola(flt.getCola());
                fleetcomp3.add(flet);
            }
            Integer newconteoflota = 0;
            for (EngTasksByFleetMngVw count : fleetcomp3) {
                newconteoflota = newconteoflota + Integer.parseInt(count.getNumflota().toString());
            }
            conteoflotabycom = newconteoflota;

            fleet = fleetcomp3;
            
            //listado de ingenieros por flota ,compañia y cliente
            List<EngTasksByUserFltCustVw> eNewUserFlt=filtrouserflotafacede.findAll();
            List<EngTasksByUserFltCustVw> eNewUserFlt2 = new ArrayList();
            List<EngTasksByUserMngVw> eUser = new ArrayList();
            
            int contador = 0;
            while (contador < eNewUserFlt.size()) {
                EngTasksByUserFltCustVw eUserFltCus = (EngTasksByUserFltCustVw) eNewUserFlt.get(contador);
                if (eUserFltCus.getWorkorder() != null && eUserFltCus.getWorkorder().equals(idflota) && eUserFltCus.getCompany().equals(idcompanhy) && eUserFltCus.getEagCustomer().equals(idcli)) {
                        eNewUserFlt2.add(eUserFltCus);
                }
                contador++;
            }
            for (EngTasksByUserFltCustVw eUserFltCus : eNewUserFlt2) {
                EngTasksByUserMngVw temp = new EngTasksByUserMngVw();
                temp.setRowId(eUserFltCus.getRowId());
                temp.setUsercode(eUserFltCus.getUsercode());
                temp.setUserName(eUserFltCus.getUserName());
                temp.setCompany(eUserFltCus.getCompany());
                temp.setTask(eUserFltCus.getTask());
                temp.setColor(eUserFltCus.getColor());
                eUser.add(temp);
            }
            this.user = eUser;
            Integer newUserCounter = 0;
            for (EngTasksByUserMngVw li : this.user) {
                newUserCounter = newUserCounter + Integer.parseInt(li.getTask().toString());
            }
            conteouser = newUserCounter;
            
            //lista de esr por flota, compañia y cliente
            List<EngTaskListView> eListCompCus = new ArrayList();
            List<EngTaskListView> eListCompCus2=taskListFacade.findAll();
            
             int y = 0;
            while (y < eListCompCus2.size()) {
                EngTaskListView eListCompCusTem = (EngTaskListView) eListCompCus2.get(y);
                if (eListCompCusTem.getWorkorder()!= null && eListCompCusTem.getCompany().equals(idcompanhy) && eListCompCusTem.getWorkorder().equals(idflota) && eListCompCusTem.getReqCustomer().equals(idcli))
                    {
                        eListCompCus.add(eListCompCusTem);
                }
                y++;
            }
            taskList = eListCompCus;
            setConteotask(taskList.size());
        }
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="filtro de flotas por id compañia  cliente y usuario"> workorder, no flota
     //filtro de flotas por id compañia  cliente y usuario   
     if(!"".equals(idcli) && !"".equals(idcompanhy) && !"".equals(iduser))
        {
            //
            List<EngTasksByFltCusUserVw> eFleet1 = fltcususerFacade.findAll();
        List<EngTasksByFltCusUserVw> eFleet2 = new ArrayList();
        List<EngTasksByFleetMngVw> eFleet3 = new ArrayList();
        
            int ef = 0;
            while (ef < eFleet1.size()) {

                EngTasksByFltCusUserVw eFltCus = (EngTasksByFltCusUserVw) eFleet1.get(ef);
                if (eFltCus.getWorkorder() != null && eFltCus.getWorkorder().equals(idflota) && eFltCus.getCompany().equals(idcompanhy) && 
                        eFltCus.getEagCustomer().equals(idcli) && eFltCus.getUsercode().equals(iduser)) {
                        eFleet2.add(eFltCus);
                }
                ef++;

            }
            for (EngTasksByFltCusUserVw fleetCusUsr : eFleet2) {
                EngTasksByFleetMngVw eFleetMng = new EngTasksByFleetMngVw();
                eFleetMng.setNumflota(fleetCusUsr.getNumflota());
                eFleetMng.setRowId(fleetCusUsr.getRowId());
                eFleetMng.setCompany(fleetCusUsr.getCompany());
                eFleetMng.setColor(fleetCusUsr.getColor());
                eFleetMng.setWorkorder(fleetCusUsr.getWorkorder());
                eFleetMng.setCola(fleetCusUsr.getCola());
                eFleet3.add(eFleetMng);
            }
            Integer counterFleet = 0;
            for (EngTasksByFleetMngVw cFleet : eFleet3) {
                counterFleet = counterFleet + Integer.parseInt(cFleet.getNumflota().toString());
            }
            conteoflotabycom = counterFleet;

            fleet = eFleet3;
            
            List<EngTaskListView> eTaskList1 = new ArrayList();
            List<EngTaskListView> eTaskList2=taskListFacade.findAll();
            
             int nCounter = 0;
            while (nCounter < eTaskList2.size()) {
                EngTaskListView eTaskListView = (EngTaskListView) eTaskList2.get(nCounter);
                if (eTaskListView.getWorkorder()!= null && eTaskListView.getCompany().equals(idcompanhy) && eTaskListView.getWorkorder().equals(idflota) && 
                         eTaskListView.getReqCustomer().equals(idcli) && eTaskListView.getUsrCoduser().equals(iduser))
                    {
                        eTaskList1.add(eTaskListView);
                }
                nCounter++;
            }
            taskList = eTaskList1;
            setConteotask(taskList.size());
        }
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="filtro de flotas id ingeniero y compañia"> workorder, no flota
     //filtro de flotas id ingeniero y compañia   
     if(("").equals(idcli) && !"".equals(idcompanhy) && !"".equals(iduser))
        {
            //listado de workorder por id compañia e inge
        List<EngTasksByFltUserVw> fltComp = fltbyonlyuser.findAll();
        List<EngTasksByFltUserVw> fltComp2 = new ArrayList();
        List<EngTasksByFleetMngVw> fltComp3 = new ArrayList();
        
            int cFlt = 0;
            while (cFlt < fltComp.size()) {

                EngTasksByFltUserVw fltUserTask = (EngTasksByFltUserVw) fltComp.get(cFlt);
                if (fltUserTask.getWorkorder() != null && fltUserTask.getWorkorder().equals(idflota) && fltUserTask.getCompany().equals(idcompanhy) && fltUserTask.getUsercode().equals(iduser)) {
                        fltComp2.add(fltUserTask);
                }
                cFlt++;

            }
            for (EngTasksByFltUserVw fltTemp : fltComp2) {
                EngTasksByFleetMngVw fltMngVw = new EngTasksByFleetMngVw();
                fltMngVw.setNumflota(fltTemp.getNumflota());
                fltMngVw.setCompany(fltTemp.getCompany());
                fltMngVw.setColor(fltTemp.getColor());
                fltMngVw.setRowId(fltTemp.getRowId());
                fltMngVw.setWorkorder(fltTemp.getWorkorder());
                fltMngVw.setCola(fltTemp.getCola());
                fltComp3.add(fltMngVw);
            }
            Integer eContFlt = 0;
            for (EngTasksByFleetMngVw eContFltMng : fltComp3) {
                eContFlt = eContFlt + Integer.parseInt(eContFltMng.getNumflota().toString());
            }
            conteoflotabycom = eContFlt;

            fleet = fltComp3;
            
            //listado de clientes por workorder compañia e inge
             List<EngTaskCustUserVw> eNewCus=cusciafltuserFacade.findAll();
            List<EngTaskCustUserVw> eNewCus2 = new ArrayList();
            List<EngTasksByCustomerCiaVw> eNewCus3 = new ArrayList();
            
            int e = 0;
            while (e < eNewCus.size()) {
                EngTaskCustUserVw eCustomerVw = (EngTaskCustUserVw) eNewCus.get(e);

                if (eCustomerVw.getWorkorder() != null && eCustomerVw.getWorkorder().equals(idflota) && eCustomerVw.getCompany().equals(idcompanhy) && eCustomerVw.getUsercode().equals(iduser)) {
                        eNewCus2.add(eCustomerVw);
                }
                e++;
            }
            for (EngTaskCustUserVw elementCust : eNewCus2) {
                EngTasksByCustomerCiaVw eTemp = new EngTasksByCustomerCiaVw();
                eTemp.setEngId(elementCust.getEngId());
                eTemp.setEngName(elementCust.getEngName());
                eTemp.setTasks(elementCust.getTasks());
                eTemp.setColor(elementCust.getColor());
                eTemp.setCompany(elementCust.getCompany());
                eNewCus3.add(eTemp);
            }
            
            Integer newContCli = 0;
            for (EngTasksByCustomerCiaVw cu : eNewCus3) {
                newContCli = newContCli + Integer.parseInt(cu.getTasks().toString());
            }
            conteoclientesgeneral = newContCli;
            listado = eNewCus3;
            
            //lista de esr por workorder, compañia y cliente
            List<EngTaskListView> engTaskListViews = new ArrayList();
            List<EngTaskListView> engTaskListViews2=taskListFacade.findAll();
            
             int a = 0;
            while (a < engTaskListViews2.size()) {
                EngTaskListView eListView = (EngTaskListView) engTaskListViews2.get(a);
                if (eListView.getWorkorder()!= null && eListView.getCompany().equals(idcompanhy) && eListView.getWorkorder().equals(idflota) && eListView.getUsrCoduser().equals(iduser))
                    {
                        engTaskListViews.add(eListView);
                }
                a++;
            }
            taskList = engTaskListViews;
            setConteotask(taskList.size());
        }
        
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="filtro de flotas por id y cliente sin compañia"> por workorder , no flota
    //filtro de flotas por id y cliente sin compañia
     if( !"".equals(idcli) && ("").equals(idcompanhy) && ("").equals(iduser))
    {
         //listado de workorder por id y cliente sin compañia
        List<EngTasksByFleetCustVw> engTasksByFleetCustVws = flotasdoblefiltro.findAll();
        List<EngTasksByFleetCustVw> engTasksByFleetCustVws2 = new ArrayList();
        List<EngTasksByFleetMngVw> engTasksByFleetCustVws3 = new ArrayList();
        
            int a1 = 0;
            while (a1 < engTasksByFleetCustVws.size()) {

                EngTasksByFleetCustVw byFleetCustVw = (EngTasksByFleetCustVw) engTasksByFleetCustVws.get(a1);
                if (byFleetCustVw.getWorkorder() != null && byFleetCustVw.getWorkorder().equals(idflota) && byFleetCustVw.getEagCustomer().equals(idcli)) {
                        engTasksByFleetCustVws2.add(byFleetCustVw);
                    
                }
                a1++;

            }
            for (EngTasksByFleetCustVw eFleetCustVw : engTasksByFleetCustVws2) {
                EngTasksByFleetMngVw eFleetTemp = new EngTasksByFleetMngVw();
                eFleetTemp.setNumflota(eFleetCustVw.getNumflota());
                eFleetTemp.setRowId(eFleetCustVw.getRowId());
                eFleetTemp.setCompany(eFleetCustVw.getCompany());
                eFleetTemp.setColor(eFleetCustVw.getColor());
                eFleetTemp.setWorkorder(eFleetCustVw.getWorkorder());
                eFleetTemp.setCola(eFleetCustVw.getCola());
                engTasksByFleetCustVws3.add(eFleetTemp);
            }
            Integer newCounterFlt = 0;
            for (EngTasksByFleetMngVw contFlt : engTasksByFleetCustVws3) {
                newCounterFlt = newCounterFlt + Integer.parseInt(contFlt.getNumflota().toString());
            }
            conteoflotabycom = newCounterFlt;

            fleet = engTasksByFleetCustVws3;
            
            //listado de ingenieros por workorder  y cliente sin complia
            List<EngTasksByUserFltCustVw> newByUserFltCustVws=filtrouserflotafacede.findAll();
            List<EngTasksByUserFltCustVw> newByUserFltCustVws1 = new ArrayList();
            List<EngTasksByUserMngVw> byUserMngVws = new ArrayList();
            
            int a3 = 0;
            while (a3 < newByUserFltCustVws.size()) {
                EngTasksByUserFltCustVw engTasksByUserVw = (EngTasksByUserFltCustVw) newByUserFltCustVws.get(a3);
                if (engTasksByUserVw.getWorkorder() != null && engTasksByUserVw.getWorkorder().equals(idflota) &&  engTasksByUserVw.getEagCustomer().equals(idcli)) {
                        newByUserFltCustVws1.add(engTasksByUserVw);
                }
                a3++;
            }
            for (EngTasksByUserFltCustVw eUserF : newByUserFltCustVws1) {
                EngTasksByUserMngVw byUserMngVwtemp = new EngTasksByUserMngVw();
                byUserMngVwtemp.setRowId(eUserF.getRowId());
                byUserMngVwtemp.setUsercode(eUserF.getUsercode());
                byUserMngVwtemp.setUserName(eUserF.getUserName());
                byUserMngVwtemp.setCompany(eUserF.getCompany());
                byUserMngVwtemp.setTask(eUserF.getTask());
                byUserMngVwtemp.setColor(eUserF.getColor());
                byUserMngVws.add(byUserMngVwtemp);
            }
            this.user = byUserMngVws;
            Integer newUsercounte = 0;
            for (EngTasksByUserMngVw li : this.user) {
                newUsercounte = newUsercounte + Integer.parseInt(li.getTask().toString());
            }
            conteouser = newUsercounte;
            
            //lista de esr por workorder y cliente sin compañia
            List<EngTaskListView> taskListCustomer = new ArrayList();
            List<EngTaskListView> taskListCustomer2=taskListFacade.findAll();
            
             int y = 0;
            while (y < taskListCustomer2.size()) {
                EngTaskListView engTListVw = (EngTaskListView) taskListCustomer2.get(y);
                if (engTListVw.getWorkorder()!= null && engTListVw.getWorkorder().equals(idflota) && engTListVw.getReqCustomer().equals(idcli))
                    {
                        taskListCustomer.add(engTListVw);
                    
                }
                y++;
            }
            taskList = taskListCustomer;
            setConteotask(taskList.size());
    }
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="filtro de flotas por id e inge sin compañia"> por workorder, no flota
    //filtro de flotas por id e inge sin compañia
     if(("").equals(idcli) && ("").equals(idcompanhy) && !"".equals(iduser))
    {
         //listado de workorder por id y cliente sin compañia
        List<EngTasksByFltUserVw> eTaskByFlt = fltbyonlyuser.findAll();
        List<EngTasksByFltUserVw> eTaskByFlt2 = new ArrayList();
        List<EngTasksByFleetMngVw> eTaskByFlt3 = new ArrayList();
        
            int counterFlt = 0;
            while (counterFlt < eTaskByFlt.size()) {

                EngTasksByFltUserVw byFltUserVw = (EngTasksByFltUserVw) eTaskByFlt.get(counterFlt);
                if (byFltUserVw.getWorkorder() != null && byFltUserVw.getWorkorder().equals(idflota) && byFltUserVw.getUsercode().equals(iduser)) {
                        eTaskByFlt2.add(byFltUserVw);
                    }
                counterFlt++;

            }
            for (EngTasksByFltUserVw fleetByFltUserVw : eTaskByFlt2) {
                EngTasksByFleetMngVw byFleetMngVwTemp = new EngTasksByFleetMngVw();
                byFleetMngVwTemp.setNumflota(fleetByFltUserVw.getNumflota());
                byFleetMngVwTemp.setRowId(fleetByFltUserVw.getRowId());
                byFleetMngVwTemp.setCompany(fleetByFltUserVw.getCompany());
                byFleetMngVwTemp.setColor(fleetByFltUserVw.getColor());
                byFleetMngVwTemp.setWorkorder(fleetByFltUserVw.getWorkorder());
                byFleetMngVwTemp.setCola(fleetByFltUserVw.getCola());
                eTaskByFlt3.add(byFleetMngVwTemp);
            }
            Integer newFltCounter = 0;
            for (EngTasksByFleetMngVw count : eTaskByFlt3) {
                newFltCounter = newFltCounter + Integer.parseInt(count.getNumflota().toString());
            }
            conteoflotabycom = newFltCounter;

            fleet = eTaskByFlt3;
            
            //listado de clientes por flota compañia e inge
             List<EngTaskCustUserVw> custUserVws=cusciafltuserFacade.findAll();
            List<EngTaskCustUserVw> custUserVws1 = new ArrayList();
            List<EngTasksByCustomerCiaVw> byCustomerCiaVwT = new ArrayList();
            
            int counter1 = 0;
            while (counter1 < custUserVws.size()) {
                EngTaskCustUserVw  eTcustUser = (EngTaskCustUserVw) custUserVws.get(counter1);

                if ( eTcustUser.getWorkorder() != null && eTcustUser.getWorkorder().equals(idflota) &&  eTcustUser.getUsercode().equals(iduser)) {
                        custUserVws1.add( eTcustUser);
                    
                }
                counter1++;
            }
            for (EngTaskCustUserVw eTcustUserElem : custUserVws1) {
                EngTasksByCustomerCiaVw eTbyCustomerCia = new EngTasksByCustomerCiaVw();
                eTbyCustomerCia.setEngId(eTcustUserElem.getEngId());
                eTbyCustomerCia.setEngName(eTcustUserElem.getEngName());
                eTbyCustomerCia.setTasks(eTcustUserElem.getTasks());
                eTbyCustomerCia.setColor(eTcustUserElem.getColor());
                eTbyCustomerCia.setCompany(eTcustUserElem.getCompany());
                byCustomerCiaVwT.add(eTbyCustomerCia);
            }
            
            Integer newCounter1 = 0;
            for (EngTasksByCustomerCiaVw cu : byCustomerCiaVwT) {
                newCounter1 = newCounter1 + Integer.parseInt(cu.getTasks().toString());
            }
            conteoclientesgeneral = newCounter1;
            listado = byCustomerCiaVwT;
            
            //lista de esr por workorder y cliente sin compañia
            List<EngTaskListView> eTListVw = new ArrayList();
            List<EngTaskListView> eTListVw2=taskListFacade.findAll();
            
             int cont1 = 0;
            while (cont1 < eTListVw2.size()) {
                EngTaskListView eTList = (EngTaskListView) eTListVw2.get(cont1);
                if (eTList.getWorkorder()!= null && eTList.getWorkorder().equals(idflota) && eTList.getUsrCoduser().equals(iduser))
                    {
                        eTListVw.add(eTList);
                }
                cont1++;
            }
            taskList = eTListVw;
            setConteotask(taskList.size());
    }
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="filtro de flotas por id inge y cliente"> por workorder, no flota
    //filtro de flotas por id inge y cliente
     if( !"".equals(idcli) && ("").equals(idcompanhy) && !"".equals(iduser))
    {
         //listado de workorder por id y cliente sin compañia
        List<EngTasksByFltCusUserVw> byFltCusUserVws = fltcususerFacade.findAll();
        List<EngTasksByFltCusUserVw> byFltCusUserVws1 = new ArrayList();
        List<EngTasksByFleetMngVw> byFleetMngVws = new ArrayList();
        
            int counterFlt = 0;
            while (counterFlt < byFltCusUserVws.size()) {

                EngTasksByFltCusUserVw byFltCusUserVw = (EngTasksByFltCusUserVw) byFltCusUserVws.get(counterFlt);
                if (byFltCusUserVw.getWorkorder() != null && byFltCusUserVw.getWorkorder().equals(idflota) && byFltCusUserVw.getUsercode().equals(iduser) && byFltCusUserVw.getEagCustomer().equals(idcli)) {
                        byFltCusUserVws1.add(byFltCusUserVw);
                }
                counterFlt++;

            }
            for (EngTasksByFltCusUserVw fltCus : byFltCusUserVws1) {
                EngTasksByFleetMngVw fleetMng = new EngTasksByFleetMngVw();
                fleetMng.setNumflota(fltCus.getNumflota());
                fleetMng.setRowId(fltCus.getRowId());
                fleetMng.setCompany(fltCus.getCompany());
                fleetMng.setColor(fltCus.getColor());
                fleetMng.setWorkorder(fltCus.getWorkorder());
                fleetMng.setCola(fltCus.getCola());
                byFleetMngVws.add(fleetMng);
            }
            Integer counterFlt2 = 0;
            for (EngTasksByFleetMngVw countByFleetMngVw : byFleetMngVws) {
                counterFlt2 = counterFlt2 + Integer.parseInt(countByFleetMngVw.getNumflota().toString());
            }
            conteoflotabycom = counterFlt2;

            fleet = byFleetMngVws;
            
            //lista de esr por workorder y cliente sin compañia
            List<EngTaskListView> listadoCliente = new ArrayList();
            List<EngTaskListView> listadoCliente2=taskListFacade.findAll();
            
             int y = 0;
            while (y < listadoCliente2.size()) {
                EngTaskListView engTlist = (EngTaskListView) listadoCliente2.get(y);
                if (engTlist.getWorkorder()!= null && engTlist.getWorkorder().equals(idflota) && engTlist.getUsrCoduser().equals(iduser) && engTlist.getReqCustomer().equals(idcli))
                    {
                        listadoCliente.add(engTlist);
                }
                y++;
            }
            taskList = listadoCliente;
            setConteotask(taskList.size());
    }
//</editor-fold>
    }
   //filtro masivo de ingeniero 
    public void filtromasivoInge()
    {
        extendtime();//extiende tiempo de sesion
//<editor-fold defaultstate="collapsed" desc="filtro de ingenieros solo por usuario">
        //filtro de ingenieros solo por usuario
        if(("").equals(idcli) && ("").equals(idcompanhy) && ("").equals(idflota))
        {
            List<EngTasksByUserMngVw> newuser = userFacade.findAll();
            List<EngTasksByUserMngVw> newuser2 = new ArrayList();
            
            Integer newcontusr = 0;
            int x = 0;
            while (x < newuser.size()) {

                EngTasksByUserMngVw com = (EngTasksByUserMngVw) newuser.get(x);
                if (com.getUsercode()!= null && com.getUsercode().equals(iduser)) {
                        newuser2.add(com);
                }
                x++;

            }
            user=newuser2;
            
            for (EngTasksByUserMngVw li : user) {
                newcontusr = newcontusr + Integer.parseInt(li.getTask().toString());
            }
            conteouser = newcontusr;
             
            
            //listado de cliente por inge
             List<EngTasksCustUserNfVw> newCustUserNfVw1=customeruserFacade.findAll();
            List<EngTasksCustUserNfVw> newCustUserNf = new ArrayList();
            List<EngTasksByCustomerCiaVw> newCustUserNf2 = new ArrayList();
            
            int xCont = 0;
            while (xCont < newCustUserNfVw1.size()) {
                EngTasksCustUserNfVw cliente = (EngTasksCustUserNfVw) newCustUserNfVw1.get(xCont);

                if (cliente.getUsercode()!= null && cliente.getUsercode().equals(iduser)) {
                        newCustUserNf.add(cliente);
                    
                }
                xCont++;
            }
            for (EngTasksCustUserNfVw custUserNfVw : newCustUserNf) {
                EngTasksByCustomerCiaVw eTaskbyCusCia = new EngTasksByCustomerCiaVw();
                eTaskbyCusCia.setEngId(custUserNfVw.getEngId());
                eTaskbyCusCia.setEngName(custUserNfVw.getEngName());
                eTaskbyCusCia.setTasks(custUserNfVw.getTasks());
                eTaskbyCusCia.setColor(custUserNfVw.getColor());
                eTaskbyCusCia.setCompany(custUserNfVw.getCompany());
                newCustUserNf2.add(eTaskbyCusCia);
            }
            
            Integer contNf = 0;
            for (EngTasksByCustomerCiaVw custNf : newCustUserNf2) {
                contNf = contNf + Integer.parseInt(custNf.getTasks().toString());
            }
            conteoclientesgeneral = contNf;
            listado = newCustUserNf2;
            
            //listado de workorder por inge
            List<EngTasksByFltUserVw> eTaskFlt1 = fltbyonlyuser.findAll();
            List<EngTasksByFltUserVw> eTaskFlt2 = new ArrayList();
            List<EngTasksByFleetMngVw> eTaskFlt3 = new ArrayList();
            
                int cFlt = 0;
                while (cFlt < eTaskFlt1.size()) {

                    EngTasksByFltUserVw eTbyFltUserVw = (EngTasksByFltUserVw) eTaskFlt1.get(cFlt);
                    if (eTbyFltUserVw.getUsercode()!= null && eTbyFltUserVw.getUsercode().equals(iduser)) {
                            eTaskFlt2.add(eTbyFltUserVw);
                    }
                    cFlt++;

                }
                for (EngTasksByFltUserVw eTFleetU : eTaskFlt2) {
                    EngTasksByFleetMngVw eTFltMng = new EngTasksByFleetMngVw();
                    eTFltMng.setNumflota(eTFleetU.getNumflota());
                    eTFltMng.setRowId(eTFleetU.getRowId());
                    eTFltMng.setCompany(eTFleetU.getCompany());
                    eTFltMng.setColor(eTFleetU.getColor());
                    eTFltMng.setWorkorder(eTFleetU.getWorkorder());
                    eTFltMng.setCola(eTFleetU.getCola());
                    eTaskFlt3.add(eTFltMng);
                }
                Integer countNewFlt = 0;
                for (EngTasksByFleetMngVw countFltMng : eTaskFlt3) {
                    countNewFlt = countNewFlt + Integer.parseInt(countFltMng.getNumflota().toString());
                }
                conteoflotabycom = countNewFlt;

                fleet = eTaskFlt3;
                
                //listado de esr por inge
                List<EngTaskListView> eTListView1 = new ArrayList();
                List<EngTaskListView> eTListView2=taskListFacade.findAll();
                
                 int y = 0;
                while (y < eTListView2.size()) {
                    EngTaskListView listView = (EngTaskListView) eTListView2.get(y);
                    if (listView.getUsrCoduser()!= null && listView.getUsrCoduser().equals(iduser))
                        {
                            eTListView1.add(listView);
                    }
                    y++;
                }
                taskList = eTListView1;
                setConteotask(taskList.size());
        }
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="filtro por ingeniero y compañia">
        //filtro por ingeniero y compañia
        if(("").equals(idcli) && !"".equals(idcompanhy) && ("").equals(idflota))
        {
            List<EngTasksByUserMngVw> newuser = userFacade.findAll();
            List<EngTasksByUserMngVw> newuser2 = new ArrayList();
            
            Integer newcontusr = 0;
            int x = 0;
            while (x < newuser.size()) {

                EngTasksByUserMngVw com = (EngTasksByUserMngVw) newuser.get(x);
                if (com.getUsercode()!= null && com.getUsercode().equals(iduser) && com.getCompany().equals(idcompanhy)) {
                        newuser2.add(com);
                    
                }
                x++;

            }
            this.user=newuser2;
            
            for (EngTasksByUserMngVw li : this.user) {
                newcontusr = newcontusr + Integer.parseInt(li.getTask().toString());
            }
            conteouser = newcontusr;
            
            
            //listado de clientes por inge y compañia
            List<EngTasksCustUserNfVw> newCus1=customeruserFacade.findAll();
            List<EngTasksCustUserNfVw> newCus2 = new ArrayList();
            List<EngTasksByCustomerCiaVw> newCus3 = new ArrayList();
            
            int xu = 0;
            while (xu < newCus1.size()) {
                EngTasksCustUserNfVw cliente = (EngTasksCustUserNfVw) newCus1.get(xu);

                if (cliente.getUsercode()!= null && cliente.getUsercode().equals(iduser) && cliente.getCompany().equals(idcompanhy)) {
                        newCus2.add(cliente);
                }
                xu++;
            }
            for (EngTasksCustUserNfVw custElement : newCus2) {
                EngTasksByCustomerCiaVw cusCiaTemp = new EngTasksByCustomerCiaVw();
                cusCiaTemp.setEngId(custElement.getEngId());
                cusCiaTemp.setEngName(custElement.getEngName());
                cusCiaTemp.setCompany(custElement.getCompany());
                cusCiaTemp.setTasks(custElement.getTasks());
                cusCiaTemp.setColor(custElement.getColor());
                newCus3.add(cusCiaTemp);
            }
            
            Integer countNewCus = 0;
            for (EngTasksByCustomerCiaVw engTcusCia : newCus3) {
                countNewCus = countNewCus + Integer.parseInt(engTcusCia.getTasks().toString());
            }
            conteoclientesgeneral = countNewCus;
            listado = newCus3;
            
            //listado de workorder por inge y compañia
            List<EngTasksByFltUserVw> fltCompany1 = fltbyonlyuser.findAll();
            List<EngTasksByFltUserVw> fltCompany2 = new ArrayList();
            List<EngTasksByFleetMngVw> fltCompany3 = new ArrayList();
            
                int xflt = 0;
                while (xflt < fltCompany1.size()) {

                    EngTasksByFltUserVw com = (EngTasksByFltUserVw) fltCompany1.get(xflt);
                    if (com.getUsercode()!= null && com.getUsercode().equals(iduser) && com.getCompany().equals(idcompanhy)) {
                            fltCompany2.add(com);
                    }
                    xflt++;

                }
                for (EngTasksByFltUserVw fltUser1 : fltCompany2) {
                    EngTasksByFleetMngVw fltMng1 = new EngTasksByFleetMngVw();
                    fltMng1.setNumflota(fltUser1.getNumflota());
                    fltMng1.setRowId(fltUser1.getRowId());
                    fltMng1.setCompany(fltUser1.getCompany());
                    fltMng1.setColor(fltUser1.getColor());
                    fltMng1.setWorkorder(fltUser1.getWorkorder());
                    fltMng1.setCola(fltUser1.getCola());
                    fltCompany3.add(fltMng1);
                }
                Integer newFltCont = 0;
                for (EngTasksByFleetMngVw count : fltCompany3) {
                    newFltCont = newFltCont + Integer.parseInt(count.getNumflota().toString());
                }
                conteoflotabycom = newFltCont;

                fleet = fltCompany3;
                
                //listado de esr por inge y compañia
                List<EngTaskListView> eTaskList1 = new ArrayList();
                List<EngTaskListView> eTaskList2=taskListFacade.findAll();
                
                 int eTcounter = 0;
                while (eTcounter < eTaskList2.size()) {
                    EngTaskListView tasLview = (EngTaskListView) eTaskList2.get(eTcounter);
                    if (tasLview.getUsrCoduser()!= null && tasLview.getUsrCoduser().equals(iduser) && tasLview.getCompany().equals(idcompanhy))
                        {
                            eTaskList1.add(tasLview);
                    }
                    eTcounter++;
                }
                taskList = eTaskList1;
                setConteotask(taskList.size());
        }
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="filtro por inge compañia y cliente">
        //filtro por inge compañia y cliente
        if(!"".equals(idcli) && !"".equals(idcompanhy) && ("").equals(idflota))
        {
            List<EngTasksByUserCustMngVw> userCusMng1=userbycustFacade.findAll();
        List<EngTasksByUserCustMngVw> userCusMng2 = new ArrayList();
        List<EngTasksByUserMngVw> userCusMng3 = new ArrayList();
        
        
        int z = 0;
            while (z < userCusMng1.size()) {
                EngTasksByUserCustMngVw inge = (EngTasksByUserCustMngVw) userCusMng1.get(z);
                if (inge.getUsercode()!= null && inge.getUsercode().equals(iduser) && inge.getEagCustomer().equals(idcli) && inge.getCompany().equals(idcompanhy)) {
                        userCusMng2.add(inge);
                }
                z++;
            }
            for (EngTasksByUserCustMngVw userCusMngElem : userCusMng2) {
                EngTasksByUserMngVw taskByUsr = new EngTasksByUserMngVw();
                taskByUsr.setRowId(userCusMngElem.getRowId());
                taskByUsr.setUsercode(userCusMngElem.getUsercode());
                taskByUsr.setUserName(userCusMngElem.getUserName());
                taskByUsr.setCompany(userCusMngElem.getCompany());
                taskByUsr.setTask(userCusMngElem.getTask());
                taskByUsr.setColor(userCusMngElem.getColor());
                userCusMng3.add(taskByUsr);
            }
            this.user = userCusMng3;
            Integer newMngCounter = 0;
            for (EngTasksByUserMngVw li : this.user) {
                newMngCounter = newMngCounter + Integer.parseInt(li.getTask().toString());
            }
            conteouser = newMngCounter;
            
            
            //listado de workorder por inge compañia y cliente
            List<EngTasksByFltCusUserVw> fltCusUsr1 = fltcususerFacade.findAll();
            List<EngTasksByFltCusUserVw> fltCusUsr2 = new ArrayList();
            List<EngTasksByFleetMngVw> fltCusUsr3 = new ArrayList();
            
                int contFlt = 0;
                while (contFlt < fltCusUsr1.size()) {

                    EngTasksByFltCusUserVw fltCustUsr = (EngTasksByFltCusUserVw) fltCusUsr1.get(contFlt);
                    if (fltCustUsr.getUsercode()!= null && fltCustUsr.getUsercode().equals(iduser) && fltCustUsr.getCompany().equals(idcompanhy) && fltCustUsr.getEagCustomer().equals(idcli)) {
                            fltCusUsr2.add(fltCustUsr);
                    }
                    contFlt++;

                }
                for (EngTasksByFltCusUserVw fltCusUsrElmt : fltCusUsr2) {
                    EngTasksByFleetMngVw fltCusUsrTemp = new EngTasksByFleetMngVw();
                    fltCusUsrTemp.setNumflota(fltCusUsrElmt.getNumflota());
                    fltCusUsrTemp.setRowId(fltCusUsrElmt.getRowId());
                    fltCusUsrTemp.setCompany(fltCusUsrElmt.getCompany());
                    fltCusUsrTemp.setColor(fltCusUsrElmt.getColor());
                    fltCusUsrTemp.setWorkorder(fltCusUsrElmt.getWorkorder());
                    fltCusUsrTemp.setCola(fltCusUsrElmt.getCola());
                    fltCusUsr3.add(fltCusUsrTemp);
                }
                Integer contNewFlt = 0;
                for (EngTasksByFleetMngVw count : fltCusUsr3) {
                    contNewFlt = contNewFlt + Integer.parseInt(count.getNumflota().toString());
                }
                conteoflotabycom = contNewFlt;

                fleet = fltCusUsr3;
                
                //listado de esr por inge compañia y cliente
                List<EngTaskListView> eTlistCusCia1 = new ArrayList();
                List<EngTaskListView> eTlistCusCia2=taskListFacade.findAll();
                
                 int y = 0;
                while (y < eTlistCusCia2.size()) {
                    EngTaskListView engTList = (EngTaskListView) eTlistCusCia2.get(y);
                    if (engTList.getUsrCoduser()!= null && engTList.getUsrCoduser().equals(iduser) && engTList.getCompany().equals(idcompanhy) && engTList.getReqCustomer().equals(idcli))
                        {
                            eTlistCusCia1.add(engTList);
                    }
                    y++;
                }
                taskList = eTlistCusCia1;
                setConteotask(taskList.size());
            
        }
        
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="filtro por inge compañia cliente y flota"> por workorder, no flota
        //filtro por inge compañia cliente y flota
        if(!"".equals(idcli) && !"".equals(idcompanhy) && !"".equals(idflota))
        {
        List<EngTasksByUserFltCustVw> byUsrFltCusVw= filtrouserflotafacede.findAll();
        List<EngTasksByUserFltCustVw> byUsrFltCusVw1 = new ArrayList();
        List<EngTasksByUserMngVw> byUsrMngVw = new ArrayList();
        
        
        int z = 0;
            while (z < byUsrFltCusVw.size()) {
                EngTasksByUserFltCustVw eng = (EngTasksByUserFltCustVw) byUsrFltCusVw.get(z);
                if (eng.getUsercode()!= null && eng.getUsercode().equals(iduser) && eng.getEagCustomer().equals(idcli) && 
                        eng.getCompany().equals(idcompanhy) && eng.getWorkorder().equals(idflota)) {
                        byUsrFltCusVw1.add(eng);
                }
                z++;
            }
            for (EngTasksByUserFltCustVw engTaskElement : byUsrFltCusVw1) {
                EngTasksByUserMngVw tempEngTask = new EngTasksByUserMngVw();
                tempEngTask.setRowId(engTaskElement.getRowId());
                tempEngTask.setUsercode(engTaskElement.getUsercode());
                tempEngTask.setUserName(engTaskElement.getUserName());
                tempEngTask.setCompany(engTaskElement.getCompany());
                tempEngTask.setTask(engTaskElement.getTask());
                tempEngTask.setColor(engTaskElement.getColor());
                byUsrMngVw.add(tempEngTask);
            }
            this.user = byUsrMngVw;
            
            Integer newUserCounter = 0;
            for (EngTasksByUserMngVw listaEngTask : this.user) {
                newUserCounter = newUserCounter + Integer.parseInt(listaEngTask.getTask().toString());
            }
            conteouser = newUserCounter;
            
            //listado de esr por inge compañia y workorder
                List<EngTaskListView> tListCiaWork1 = new ArrayList();
                List<EngTaskListView> tListCiaWork2=taskListFacade.findAll();
                
                 int cnt = 0;
                while (cnt < tListCiaWork2.size()) {
                    EngTaskListView listEngTask = (EngTaskListView) tListCiaWork2.get(cnt);
                    if (listEngTask.getUsrCoduser()!= null && listEngTask.getUsrCoduser().equals(iduser) && listEngTask.getCompany().equals(idcompanhy) && 
                            listEngTask.getReqCustomer().equals(idcli)  && listEngTask.getWorkorder().equals(idflota))
                        {
                            tListCiaWork1.add(listEngTask);
                    }
                    cnt++;
                }
                taskList = tListCiaWork1;
                setConteotask(taskList.size());
            
        }
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="filtro por inge y cliente sin compañia">
        //filtro por inge y cliente sin compañia
        if(!"".equals(idcli) && ("").equals(idcompanhy) && ("").equals(idflota))
        {
            List<EngTasksByUserCustMngVw> usrCusMng1= userbycustFacade.findAll();
        List<EngTasksByUserCustMngVw> usrCusMng2 = new ArrayList();
        List<EngTasksByUserMngVw> usrCusMng3 = new ArrayList();
        
        
        int z = 0;
            while (z < usrCusMng1.size()) {
                EngTasksByUserCustMngVw engUsrCusMng = (EngTasksByUserCustMngVw) usrCusMng1.get(z);
                if (engUsrCusMng.getUsercode()!= null && engUsrCusMng.getUsercode().equals(iduser) && engUsrCusMng.getEagCustomer().equals(idcli)) {
                        usrCusMng2.add(engUsrCusMng);
                }
                z++;
            }
            for (EngTasksByUserCustMngVw userMngElemnt : usrCusMng2) {
                EngTasksByUserMngVw usrMngTemp = new EngTasksByUserMngVw();
                usrMngTemp.setRowId(userMngElemnt.getRowId());
                usrMngTemp.setUsercode(userMngElemnt.getUsercode());
                usrMngTemp.setUserName(userMngElemnt.getUserName());
                usrMngTemp.setCompany(userMngElemnt.getCompany());
                usrMngTemp.setTask(userMngElemnt.getTask());
                usrMngTemp.setColor(userMngElemnt.getColor());
                usrCusMng3.add(usrMngTemp);
            }
            this.user = usrCusMng3;
            
            Integer userCont = 0;
            for (EngTasksByUserMngVw listTemp : this.user) {
                userCont = userCont + Integer.parseInt(listTemp.getTask().toString());
            }
            conteouser = userCont;
            
            //listado de workorder por inge y cliente sin compañia
            List<EngTasksByFltCusUserVw> fltCus1 = fltcususerFacade.findAll();
            List<EngTasksByFltCusUserVw> fltCus2 = new ArrayList();
            List<EngTasksByFleetMngVw> fltCus3 = new ArrayList();
            
                int contFlt = 0;
                while (contFlt < fltCus1.size()) {

                    EngTasksByFltCusUserVw fltCustUsrVwCom = (EngTasksByFltCusUserVw) fltCus1.get(contFlt);
                    if (fltCustUsrVwCom.getUsercode()!= null && fltCustUsrVwCom.getUsercode().equals(iduser) && fltCustUsrVwCom.getEagCustomer().equals(idcli)) {
                            fltCus2.add(fltCustUsrVwCom);
                    }
                    contFlt++;

                }
                for (EngTasksByFltCusUserVw flt1 : fltCus2) {
                    EngTasksByFleetMngVw flt2 = new EngTasksByFleetMngVw();
                    flt2.setNumflota(flt1.getNumflota());
                    flt2.setRowId(flt1.getRowId());
                    flt2.setCompany(flt1.getCompany());
                    flt2.setColor(flt1.getColor());
                    flt2.setWorkorder(flt1.getWorkorder());
                    flt2.setCola(flt1.getCola());
                    fltCus3.add(flt2);
                }
                Integer contadorFlota = 0;
                for (EngTasksByFleetMngVw count : fltCus3) {
                    contadorFlota = contadorFlota + Integer.parseInt(count.getNumflota().toString());
                }
                conteoflotabycom = contadorFlota;

                fleet = fltCus3;
                
                //listado de esr por inge y cliente sin compañia
                List<EngTaskListView> listEngT1 = new ArrayList();
                List<EngTaskListView> listEngT2=taskListFacade.findAll();
                
                 int cntr = 0;
                while (cntr < listEngT2.size()) {
                    EngTaskListView lis = (EngTaskListView) listEngT2.get(cntr);
                    if (lis.getUsrCoduser()!= null && lis.getUsrCoduser().equals(iduser) && lis.getReqCustomer().equals(idcli))
                        {
                            listEngT1.add(lis);
                    }
                    cntr++;
                }
                taskList = listEngT1;
                setConteotask(taskList.size());
        }
        
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="filtro por inge y flota sin compañia"> por workorder, no flota
       //filtro por inge y flota sin compañia
        if(("").equals(idcli) && ("").equals(idcompanhy) && !"".equals(idflota))
        {
        List<EngTasksByUserFltMngVw> newUsrMng1= userbyflota.findAll();
        List<EngTasksByUserFltMngVw> newUsrMng2 = new ArrayList();
        List<EngTasksByUserMngVw> newUsrMng3 = new ArrayList();
        
        
        int z = 0;
            while (z < newUsrMng1.size()) {
                EngTasksByUserFltMngVw engUsrFltMng = (EngTasksByUserFltMngVw) newUsrMng1.get(z);
                if (engUsrFltMng.getUsercode()!= null && engUsrFltMng.getUsercode().equals(iduser) && engUsrFltMng.getWorkorder().equals(idflota)) {
                        newUsrMng2.add(engUsrFltMng);
                }
                z++;
            }
            for (EngTasksByUserFltMngVw elemntUsrFltMng : newUsrMng2) {
                EngTasksByUserMngVw tempUsrMng = new EngTasksByUserMngVw();
                tempUsrMng.setRowId(elemntUsrFltMng.getRowId());
                tempUsrMng.setUsercode(elemntUsrFltMng.getUsercode());
                tempUsrMng.setUserName(elemntUsrFltMng.getUserName());
                tempUsrMng.setCompany(elemntUsrFltMng.getCompany());
                tempUsrMng.setTask(elemntUsrFltMng.getTask());
                tempUsrMng.setColor(elemntUsrFltMng.getColor());
                newUsrMng3.add(tempUsrMng);
            }
            this.user = newUsrMng3;
            
            Integer usrCounter = 0;
            for (EngTasksByUserMngVw listUsr : this.user) {
                usrCounter = usrCounter + Integer.parseInt(listUsr.getTask().toString());
            }
            conteouser = usrCounter;
            
            //listado de cliente por inge y workorder sin compañia
             List<EngTaskCustUserVw> cusUsrVw1=cusciafltuserFacade.findAll();
            List<EngTaskCustUserVw> cusUsrVw2 = new ArrayList();
            List<EngTasksByCustomerCiaVw> cusUsrCiaVw3 = new ArrayList();
            
            int contCus = 0;
            while (contCus < cusUsrVw1.size()) {
                EngTaskCustUserVw engCusUsr = (EngTaskCustUserVw) cusUsrVw1.get(contCus);

                if (engCusUsr.getUsercode()!= null && engCusUsr.getUsercode().equals(iduser) && engCusUsr.getWorkorder().equals(idflota)) {
                        cusUsrVw2.add(engCusUsr);
                }
                contCus++;
            }
            for (EngTaskCustUserVw e : cusUsrVw2) {
                EngTasksByCustomerCiaVw engCiaTemp = new EngTasksByCustomerCiaVw();
                engCiaTemp.setEngId(e.getEngId());
                engCiaTemp.setEngName(e.getEngName());
                engCiaTemp.setTasks(e.getTasks());
                engCiaTemp.setColor(e.getColor());
                engCiaTemp.setCompany(e.getCompany());
                cusUsrCiaVw3.add(engCiaTemp);
            }
            
            Integer contCus2 = 0;
            for (EngTasksByCustomerCiaVw custCia : cusUsrCiaVw3) {
                contCus2 = contCus2 + Integer.parseInt(custCia.getTasks().toString());
            }
            conteoclientesgeneral = contCus2;
            listado = cusUsrCiaVw3;
                
            //listado de esr por inge y workorder sin compañia
            List<EngTaskListView> list1 = new ArrayList();
            List<EngTaskListView> list2=taskListFacade.findAll();
            
             int y = 0;
            while (y < list2.size()) {
                EngTaskListView eList = (EngTaskListView) list2.get(y);
                if (eList.getUsrCoduser()!= null && eList.getUsrCoduser().equals(iduser) && eList.getWorkorder().equals(idflota))
                    {
                        list1.add(eList);
                }
                y++;
            }
            taskList = list1;
            setConteotask(taskList.size());
        } 
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="filtro por inge flota y compañia"> por workorder, no flota
       //filtro por inge flota y compañia
        if(("").equals(idcli) && !"".equals(idcompanhy) && !"".equals(idflota))
       {
        List<EngTasksByUserFltMngVw> newUsrFtl1= userbyflota.findAll();
        List<EngTasksByUserFltMngVw> newUsrFtl2 = new ArrayList();
        List<EngTasksByUserMngVw> newUsrMngVw=  new ArrayList();
        
        
        int contUsrFtl = 0;
            while (contUsrFtl < newUsrFtl1.size()) {
                EngTasksByUserFltMngVw userMng = (EngTasksByUserFltMngVw) newUsrFtl1.get(contUsrFtl);
                if (userMng.getUsercode()!= null && userMng.getUsercode().equals(iduser) && userMng.getWorkorder().equals(idflota) && userMng.getCompany().equals(idcompanhy)) {
                        newUsrFtl2.add(userMng);
                }
                contUsrFtl++;
            }
            for (EngTasksByUserFltMngVw elemtMng : newUsrFtl2) {
                EngTasksByUserMngVw temMng = new EngTasksByUserMngVw();
                temMng.setRowId(elemtMng.getRowId());
                temMng.setUsercode(elemtMng.getUsercode());
                temMng.setUserName(elemtMng.getUserName());
                temMng.setCompany(elemtMng.getCompany());
                temMng.setTask(elemtMng.getTask());
                temMng.setColor(elemtMng.getColor());
                newUsrMngVw.add(temMng);
            }
            this.user = newUsrMngVw;
            
            Integer contUsr = 0;
            for (EngTasksByUserMngVw li : this.user) {
                contUsr = contUsr + Integer.parseInt(li.getTask().toString());
            }
            conteouser = contUsr;
            
            //listado de cliente por inge workorder y compañia
             List<EngTaskCustUserVw> newCustUsr1=cusciafltuserFacade.findAll();
            List<EngTaskCustUserVw> newCustUsr2 = new ArrayList();
            List<EngTasksByCustomerCiaVw> newCustUsr3 = new ArrayList();
            
            int xu = 0;
            while (xu < newCustUsr1.size()) {
                EngTaskCustUserVw engTcustUsrVw = (EngTaskCustUserVw) newCustUsr1.get(xu);

                if (engTcustUsrVw.getUsercode()!= null && engTcustUsrVw.getUsercode().equals(iduser) && engTcustUsrVw.getWorkorder().equals(idflota) && engTcustUsrVw.getCompany().equals(idcompanhy)) {
                        newCustUsr2.add(engTcustUsrVw);
                    
                }
                xu++;
            }
            for (EngTaskCustUserVw custElemet : newCustUsr2) {
                EngTasksByCustomerCiaVw tempCusCia = new EngTasksByCustomerCiaVw();
                tempCusCia.setTasks(custElemet.getTasks());
                tempCusCia.setColor(custElemet.getColor());
                tempCusCia.setEngId(custElemet.getEngId());
                tempCusCia.setEngName(custElemet.getEngName());
                tempCusCia.setCompany(custElemet.getCompany());
                newCustUsr3.add(tempCusCia);
            }
            
            Integer numCust = 0;
            for (EngTasksByCustomerCiaVw eTaskcustCia : newCustUsr3) {
                numCust = numCust + Integer.parseInt(eTaskcustCia.getTasks().toString());
            }
            conteoclientesgeneral = numCust;
            listado = newCustUsr3;
                
            //listado de esr por inge  workorder y compañia
            List<EngTaskListView> listadoTask1 = new ArrayList();
            List<EngTaskListView> listadoTask2=taskListFacade.findAll();
            
             int y = 0;
            while (y < listadoTask2.size()) {
                EngTaskListView tempEngTaskView = (EngTaskListView) listadoTask2.get(y);
                if (tempEngTaskView.getUsrCoduser()!= null && tempEngTaskView.getUsrCoduser().equals(iduser) && tempEngTaskView.getWorkorder().equals(idflota) && tempEngTaskView.getCompany().equals(idcompanhy))
                    {
                        listadoTask1.add(tempEngTaskView);
                    
                }
                y++;
            }
            taskList = listadoTask1;
            setConteotask(taskList.size());
       }
       
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="filtro por inge flota y cliente sin compañia"> por workorder, no flota
       //filtro por inge flota y cliente sin compañia
        if(!"".equals(idcli) && ("").equals(idcompanhy) && !"".equals(idflota))
        {
        List<EngTasksByUserFltCustVw> usrFltCustomer1= filtrouserflotafacede.findAll();
        List<EngTasksByUserFltCustVw> usrFltCustomer2 = new ArrayList();
        List<EngTasksByUserMngVw> usrFltCustomer3 = new ArrayList();
        
        
        int numUsrFlt = 0;
            while (numUsrFlt < usrFltCustomer1.size()) {
                EngTasksByUserFltCustVw inge = (EngTasksByUserFltCustVw) usrFltCustomer1.get(numUsrFlt);
                if (inge.getUsercode()!= null && inge.getUsercode().equals(iduser) && inge.getEagCustomer().equals(idcli)  && inge.getWorkorder().equals(idflota)) {
                        usrFltCustomer2.add(inge);
                }
            numUsrFlt++;
            }
                
            for (EngTasksByUserFltCustVw elementUsrFlt : usrFltCustomer2) {
                EngTasksByUserMngVw tempUserMng = new EngTasksByUserMngVw();
                tempUserMng.setRowId(elementUsrFlt.getRowId());
                tempUserMng.setUsercode(elementUsrFlt.getUsercode());
                tempUserMng.setUserName(elementUsrFlt.getUserName());
                tempUserMng.setCompany(elementUsrFlt.getCompany());
                tempUserMng.setTask(elementUsrFlt.getTask());
                tempUserMng.setColor(elementUsrFlt.getColor());
                usrFltCustomer3.add(tempUserMng);
            }
            this.user = usrFltCustomer3;
            
            Integer contUsrMng = 0;
            for (EngTasksByUserMngVw listMng : this.user) {
                contUsrMng = contUsrMng + Integer.parseInt(listMng.getTask().toString());
            }
            conteouser = contUsrMng;
            
            //listado de esr por inge workorder y cliente
                List<EngTaskListView> eTlist1 = new ArrayList();
                List<EngTaskListView> eTlist2=taskListFacade.findAll();
                
                 int m = 0;
                while (m < eTlist2.size()) {
                    EngTaskListView listView = (EngTaskListView) eTlist2.get(m);
                    if (listView.getUsrCoduser()!= null && listView.getUsrCoduser().equals(iduser) && listView.getReqCustomer().equals(idcli)  && listView.getWorkorder().equals(idflota))
                        {
                            eTlist1.add(listView);
                        
                    }
                    m++;
                }
                taskList = eTlist1;
                setConteotask(taskList.size());
            
        }
//</editor-fold>
    }
    
    //auto completado de cliente
    public void clientesAutocompletado(){
        
        extendtime();//extiende tiempo
        for(EngTasksByCustomerCiaVw cust :  listado){
            clientesAutoc.add("\""+cust.getEngId()+"-"+cust.getEngName()+"\"");
        }
    }
    //metodo que extiende la sesion
    public boolean homeManager() {
        extendtime();
        return true;   
    }
    //metodo que verifica la fecha
    public int verFecha(Date fecha){
        extendtime();
        int ret=0;
        Long dias;
        Long diferencia;
        
        if(fecha!=null){
            dias=fechaActual.getTime()-fecha.getTime();
            diferencia=dias / (1000 * 60 * 60 * 24);
            if(diferencia.intValue()<=1)
                ret=1;
            if(diferencia.intValue()==2)
                ret=2;
            if(diferencia.intValue()>=3)
                ret=3;
            return ret;
        }
        return 3;
    }
    //metodo que llena la informacion de la ESR
    public void actESR(String id) {
        try {
            extendtime();
            BigInteger reqid = new BigInteger(id);
            List<EngEaGeneral> tavea = numax.esrEA(reqid);
            List<EngOrders> taveo = numax.esrEO(reqid);
            List<Object[]> tavall = new ArrayList<>();
            
            DateFormat dateFormat = new SimpleDateFormat("yy");  
             for (EngEaGeneral listadoEng1 : tavea) {
                    Object[] listado1 = new Object[2];
                    listadoEng1.setYearEA(dateFormat.format(listadoEng1.getAegDateCrea()));
                    if (listadoEng1.getAegIngComm() != null) {
                    listadoEng1.setUserEA(sgrUser.findSelectUser(listadoEng1.getAegIngComm()).getFullUserName());
                    }else{
                        listadoEng1.setUserEA("NA");
                    }
                    listadoEng1.setEsrEA("ESR");
                    listado1[1]=listadoEng1;
                    listado1[0]="EA";
                    tavall.add(listado1);
                }
             for (EngOrders listadoEng2 : taveo) {
                    Object[] listado2 = new Object[2];
                    listado2[1]=listadoEng2;
                    listado2[0]="EO";
                    tavall.add(listado2);
                }
             
             //si no tiene EA o EO se pondra NA
             if(tavall.isEmpty()){
                EngEaGeneral enEaNa = new EngEaGeneral();
                Object[] listadoNA = new Object[2];
                listadoNA[1] = enEaNa;
                listadoNA[0] = "NA";
                tavall.add(listadoNA);
             }
             
             listAll=tavall;
            
        } catch (Exception e) {
           Logger.getLogger(CustomerManagerBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    //llena en un arrglo y extiende el 
    public void actTodas(Object[] id){
        extendtime();
         if(("EA").equals(id[0])){
             it1 =(EngEaGeneral) id[1];
         }else{
             it2 =(EngOrders) id[1];
         }
     }
    //metodo generado por implements Serializable
    @Override
    void limpiar() {
        listado3 = new ArrayList<>(); //To change body of generated methods, choose Tools | Templates.
    }
//metodo generado por implements Serializable
    @Override
    void actualizar() {
        listado2 = new ArrayList<>(); //To change body of generated methods, choose Tools | Templates.
    }
//metodo generado por implements Serializable
    @Override
    void agregar() {
        listado = new ArrayList<>(); //To change body of generated methods, choose Tools | Templates.
    }
//metodo generado por implements Serializable
    @Override
    void eliminar(EngTasksByCustomerCiaVw elemento) {
        listadoTask  = new ArrayList<>(); //To change body of generated methods, choose Tools | Templates.
    }
//metodo generado por implements Serializable
    @Override
    EngTasksByCustomerCiaVw nuevoElemento() {
        return elemento;//To change body of generated methods, choose Tools | Templates.
    }
    //<editor-fold defaultstate="collapsed" desc="GETTER Y SETTER">
    // get y set de variable
    public Boolean getFiltrouser() {
        return filtrouser;
    }
// get y set de variable
    public void setFiltrouser(Boolean filtrouser) {
        this.filtrouser = filtrouser;
    }
// get y set de variable
    public List<EngTasksByFleetMngVw> getFleet() {
        return fleet;
    }
// get y set de variable
    public void setFleet(List<EngTasksByFleetMngVw> fleet) {
        this.fleet = fleet;
    }
// get y set de variable
    public List<EngTaskListView> getTaskList() {
        return taskList;
    }
// get y set de variable
    public void setTaskList(List<EngTaskListView> taskList) {
        this.taskList = taskList;
    }
// get y set de variable
    public List<EngTasksByUserMngVw> getUser() {
        return user;
    }
// get y set de variable
    public void setUser(List<EngTasksByUserMngVw> user) {
        this.user = user;
    }
// get y set de variable
    public int getRefresh() {
        return refresh;
    }
// get y set de variable
    public void setRefresh(int refresh) {
        this.refresh = refresh;
    }
// get y set de variable
    public String getIdcli() {
        return idcli;
    }
// get y set de variable
    public void setIdcli(String idcli) {
        this.idcli = idcli;
    }
// get y set de variable
    public String getIdflota() {
        return idflota;
    }
// get y set de variable
    public void setIdflota(String idflota) {
        this.idflota = idflota;
    }
// get y set de variable
    public List<EngTasksByFleetMngVw> getFleetcompany() {
        return fleetcompany;
    }
// get y set de variable
    public void setFleetcompany(List<EngTasksByFleetMngVw> fleetcompany) {
        this.fleetcompany = fleetcompany;
    }
// get y set de variable
    public List<EngTasksByCustomernfVw> getCustomer() {
        return customer;
    }
// get y set de variable
    public void setCustomer(List<EngTasksByCustomernfVw> customer) {
        this.customer = customer;
    }
// get y set de variable
    public List<EngTasksByCustomernfVw> getCustomer2() {
        return customer2;
    }
// get y set de variable
    public void setCustomer2(List<EngTasksByCustomernfVw> customer2) {
        this.customer2 = customer2;
    }
// get y set de variable
    public Integer getConteoclientesgeneral() {
        return conteoclientesgeneral;
    }
// get y set de variable
    public void setConteoclientesgeneral(Integer conteoclientesgeneral) {
        this.conteoclientesgeneral = conteoclientesgeneral;
    }
// get y set de variable
    public Integer getConteoflotabycom() {
        return conteoflotabycom;
    }
// get y set de variable
    public void setConteoflotabycom(Integer conteoflotabycom) {
        this.conteoflotabycom = conteoflotabycom;
    }
// get y set de variable
    public String getIduser() {
        return iduser;
    }
// get y set de variable
    public void setIduser(String iduser) {
        this.iduser = iduser;
    }
    // get y set de variable
    public Integer getConteouser() {
        return conteouser;
    }
// get y set de variable
    public void setConteouser(Integer conteouser) {
        this.conteouser = conteouser;
    }
// get y set de variable
    public Integer getConteotask() {
        return conteotask;
    }
// get y set de variable
    public void setConteotask(Integer conteotask) {
        this.conteotask = conteotask;
    }
// get y set de variable
    public Boolean getFiltrocliente() {
        return filtrocliente;
    }
// get y set de variable
    public void setFiltrocliente(Boolean filtrocliente) {
        this.filtrocliente = filtrocliente;
    }
// get y set de variable
    public Boolean getFiltroflota() {
        return filtroflota;
    }
// get y set de variable
    public void setFiltroflota(Boolean filtroflota) {
        this.filtroflota = filtroflota;
    }
    // get y set de variable
    public String getIdcompanhy() {
        return idcompanhy;
    }
// get y set de variable
    public void setIdcompanhy(String idcompanhy) {
        this.idcompanhy = idcompanhy;
    }
    // get y set de variable
    public String getIndicesdelosfiltros() {
        return indicesdelosfiltros;
    }
// get y set de variable
    public void setIndicesdelosfiltros(String indicesdelosfiltros) {
        this.indicesdelosfiltros = indicesdelosfiltros;
    }
    // get y set de variable
//</editor-fold>

    public List<String> getFiltros() {
        return filtros;
    }
// get y set de variable
    public void setFiltros(List<String> filtros) {
        this.filtros = filtros;
    }
    // get y set de variable
    public ReportesSeguiCheqBean getReportesSeguiCheqBean() {
        return reportesSeguiCheqBean;
    }
// get y set de variable
    public void setReportesSeguiCheqBean(ReportesSeguiCheqBean reportesSeguiCheqBean) {
        this.reportesSeguiCheqBean = reportesSeguiCheqBean;
    }
// get y set de variable
    public String getAaaa() {
        return aaaa;
    }
// get y set de variable
    public void setAaaa(String aaaa) {
        this.aaaa = aaaa;
    }
// get y set de variable
    public String getNombreinge() {
        return nombreinge;
    }
// get y set de variable
    public void setNombreinge(String nombreinge) {
        this.nombreinge = nombreinge;
    }
// get y set de variable
    public List<String> getClientesAutoc() {
        return clientesAutoc;
    }
// get y set de variable
    public void setClientesAutoc(List<String> clientesAutoc) {
        this.clientesAutoc = clientesAutoc;
    }   
// get y set de variable
    public String getUserfulname() {
        return userfulname;
    }
// get y set de variable
    public void setUserfulname(String userfulname) {
        this.userfulname = userfulname;
    }
// get y set de variable
    public String getUsuario() {
        return usuario;
    }
// get y set de variable
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
// get y set de variable
    public Date getFechaActual() {
        return fechaActual;
    }
// get y set de variable
    public void setFechaActual(Date fechaActual) {
        this.fechaActual = fechaActual;
    }
// get y set de variable
    public String getItemId() {
        return itemId;
    }
// get y set de variable
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
// get y set de variable
    public List<Object[]> getListAll() {
        return listAll;
    }
// get y set de variable
    public void setListAll(List<Object[]> listAll) {
        this.listAll = listAll;
    }
// get y set de variable
    public String getLanguage() {
        return language;
    }
// get y set de variable
    public void setLanguage(String language) {
        this.language = language;
    }
// get y set de variable
    public EngEaGeneral getIt1() {
        return it1;
    }
// get y set de variable
    public void setIt1(EngEaGeneral it1) {
        this.it1 = it1;
    }
// get y set de variable
    public EngOrders getIt2() {
        return it2;
    }
// get y set de variable
    public void setIt2(EngOrders it2) {
        this.it2 = it2;
    }
// get y set de variable
    public LanguageSwitcher getLanguageSwitcher() {
        return languageSwitcher;
    }
// get y set de variable
    public void setLanguageSwitcher(LanguageSwitcher languageSwitcher) {
        this.languageSwitcher = languageSwitcher;
    }
// get y set de variable
    public String getSeleccionCompany() {
        return seleccionCompany;
    }
// get y set de variable
    public void setSeleccionCompany(String seleccionCompany) {
        this.seleccionCompany = seleccionCompany;
    }
    
}
