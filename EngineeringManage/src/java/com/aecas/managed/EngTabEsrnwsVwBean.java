
// To change this license header, choose License Headers in Project Properties.
// To change this template file, choose Tools | Templates
// and open the template in the editor.

package com.aecas.managed;// paquete manage


import com.aeroman.aees.entities.EngTabEcrByCusVW;
import com.aeroman.aees.entities.EngTabEsrnwaAircraft;
import com.aeroman.aees.entities.EngTabEsrnwsVw;// importacion de clase
import com.aeroman.aees.entities.grant.ContCheck;// importacion de clase
import com.aeroman.aees.facades.EngTabEcrByCusVWFacade;
import com.aeroman.aees.facades.EngTabEsrnwaAircraftFacade;
import com.aeroman.aees.facades.EngTabEsrnwsVwFacade;// importacion de clase
import com.aeroman.aees.facades.grant.ContCheckFacade;// importacion de clase
import java.io.Serializable;// libreria Serializable
import java.math.BigDecimal;
import java.text.SimpleDateFormat;// libreria SimpleDateFormat
import java.util.ArrayList;// libreria ArrayList
import java.util.List;
import java.util.logging.Level;// libreria Level
import java.util.logging.Logger;// libreria Logger
import javax.annotation.PostConstruct;// libreria PostConstruct
import javax.ejb.EJB;// libreria EJB
import javax.faces.bean.ManagedBean;// libreria ManagedBean
import javax.faces.bean.ManagedProperty;// libreria ManagedProperty
import javax.faces.bean.SessionScoped;// libreria SessionScoped

/**
 *
 * @author vjuarez
 */


//nombre de clase en mageBean
@ManagedBean(name = "engtabEsrnwsVwBean")
@SessionScoped//tipo de clase
//clase EngTabEsrnwsVwBean con extends al crud
public class EngTabEsrnwsVwBean extends CrudBean<EngTabEsrnwsVw> implements Serializable {
    
   
    
    @EJB
    private EngTabEsrnwsVwFacade engTabEsrnwsVwFacade;//declaracion de clases Facade
    
    @EJB
    private ContCheckFacade contFacade;//declaracion de clases Facade
    
    @EJB
    private EngTabEcrByCusVWFacade engTabEcrByCusVWFacade;//declaracion de clases Facade
    
    @EJB
    private EngTabEsrnwaAircraftFacade esrVwAircraftFacade;//declaracion de clases Facade
    @ManagedProperty(value = "#{tabEsrEaEoBean}")
    private TabEsrEaEo tabEsrEaEoID;//declarion variable tipo clase
    @ManagedProperty(value = "#{companyBean}")
    private CompanyBean companyBean;//declarion variable tipo clase
    @ManagedProperty(value = "#{engMergeCustomerBean}")
    private EngMergeCustomerBean engMergeCustomerBean;
    
    private ContCheck contCheckID;//declaracion de variable
    private String airCraft;//declaracion de variable
    private String company;//declaracion de variable
    private String idESRTab;//declaracion de variable
    private String userEsr= "username";//declaracion de variable
    private String valAirCraft;//declaracion de variable
    private String checkID;//declaracion de variable
    private String wo;//declaracion de variable
    private String airCraft2;//declaracion de variable
    private String fInicio;//declaracion de variable
    private String fFin;//declaracion de variable

    private String avion;
    private List<EngTabEsrnwaAircraft> listadoNw;
    List<EngTabEsrnwsVw> listadoETR = new ArrayList<>();
    
    //variable para saber el customer seleccionado en ECR
    String customerSelected;
    
    List<EngTabEcrByCusVW> listadoEcr;
    
    @Override//metodo generado por implements Serializable
    @PostConstruct//metodo constructor
    public void init() {        
        elemento = new EngTabEsrnwsVw();
        listado = new ArrayList<>();        
        listadoNw= new ArrayList<>();
        listadoETR = new ArrayList<>();
    }

    @Override//metodo generado por implements Serializable
    void limpiar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override//metodo generado por implements Serializable
    void actualizar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override//metodo generado por implements Serializable
    public void agregar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override//metodo generado por implements Serializable
    void eliminar(EngTabEsrnwsVw elemento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override//metodo generado por implements Serializable
    EngTabEsrnwsVw nuevoElemento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void llenarListaESRFromCheckSeleted(){
        setAvion(contCheckID.getChkRegistry());
        setCompany(contCheckID.getCheckCompany());
        setCheckID(contCheckID.getContCheckId().toString());        
        llenarListaESR();
    }
    
    public void llenarListaESR(){
        extendtime();//extiende el tiempo de sesion
        companyBean.menuESR();
        valAirCraft="Exists";
        String pattern = "MM/dd/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        if (getCompany() != null) {
             listadoETR = engTabEsrnwsVwFacade.findByAirCraftETR(getCompany(), "ETR"); 
        }
        if (getAirCraft() != null && getCompany() != null) {
            if(!getAirCraft().isEmpty() && !getCompany().isEmpty()){
                //listadoNw = esrVwAircraftFacade.findByAircraftAndCompany(getAvion(),getCompany());
                listado = engTabEsrnwsVwFacade.findByAircraftAndCompany(getAvion(),getCompany());
                    ContCheck contRep = new ContCheck(); 
                    //contRep=contFacade.find(Short.parseShort(checkID));
                    contRep=contFacade.find(new BigDecimal(checkID));
                    wo=contRep.getChkWo();
                    airCraft2=contRep.getChkRegistry();
                    fInicio= simpleDateFormat.format(contRep.getChkStartdate()); 
                    fFin=simpleDateFormat.format(contRep.getChkFinishdate());
            }
        }       
        if (listado.size()<=0){
            valAirCraft="Not Exists";
        }
        
    }
    
    //Llenas lista de ECR: 
     public void llenarListaECR(){
         extendtime();//extiende el tiempo de sesion
        valAirCraft="Exists";
        String pattern = "MM/dd/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        if (getCompany() != null) {
             //listadoETR = engTabEsrnwsVwFacade.findByAirCraftETR(getCompany(), "ECR"); 
             listadoEcr = engTabEcrByCusVWFacade.findECRByCustomer(company, customerSelected);
             tabEsrEaEoID.setCompanyECRSelected(company);
             tabEsrEaEoID.setCustomerSelected(customerSelected);
             System.out.println("");
        }
        if (getAirCraft() != null && getCompany() != null) {
            if(!getAirCraft().isEmpty() && !getCompany().isEmpty()){
                listado = engTabEsrnwsVwFacade.findByAircraftAndCompany(getAvion(),getCompany());
                    ContCheck contRep = new ContCheck(); 
                    contRep=contFacade.find(new BigDecimal(checkID));
                    wo=contRep.getChkWo();
                    airCraft2=contRep.getChkRegistry();
                    fInicio= simpleDateFormat.format(contRep.getChkStartdate()); 
                    fFin=simpleDateFormat.format(contRep.getChkFinishdate());
            }
        }       
        if (listadoEcr.size()<=0){
            valAirCraft="Not Exists";
        }
    }
    
    public void seleccionarTabla(String id) {    
        extendtime();//extiende el tiempo de sesion
       try {
       tabEsrEaEoID.actESR(id);
       companyBean.menuBotoneraESR();
       } catch(Exception e){
           Logger.getLogger(EngTabEsrnwsVw.class.getName()).log(Level.SEVERE, null, e);
       }
    }
    public void autoComplete(){
        extendtime();//extiende el tiempo de sesion
        try{
            if (checkID != null && getAirCraft() != null && getCompany() != null){
                if(!checkID.isEmpty() && !getAirCraft().isEmpty() &&  !getCompany().isEmpty()){
                    //contCheckID = contFacade.find(Short.parseShort(checkID));
                    contCheckID = contFacade.find(new BigDecimal(checkID));
                    tabEsrEaEoID.autoComplete(getAirCraft(),getCompany() ,contCheckID.getContCheckId().toString());
                    engMergeCustomerBean.listOpco(getCompany());
                }
            }
        }catch(Exception e){
            Logger.getLogger(EngTabEsrnwsVw.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
    
    public void autoCompleteETR(){
        extendtime();//extiende el tiempo de sesion
        try{
            
                if(getCompany() != null &&  !getCompany().isEmpty()){
                    contCheckID = contFacade.findByChekCompanyETR(getCompany());
                   
                    tabEsrEaEoID.autoCompleteETR(getAirCraft(),getCompany() ,contCheckID.getContCheckId().toString());
                    engMergeCustomerBean.listOpco(getCompany());
                
            }
        }catch(Exception e){
            Logger.getLogger(EngTabEsrnwsVw.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
    
    //ECR:
    public void autoCompleteECR() {
        extendtime();
        try {
            if (getCompany() != null && !getCompany().isEmpty()) {
                contCheckID = contFacade.findByChekCompanyECR(getCompany());
                tabEsrEaEoID.autoCompleteECR(getAirCraft(), getCompany(), contCheckID.getContCheckId().toString());
                engMergeCustomerBean.listOpco(getCompany());
            }
        } catch (Exception e) {
            Logger.getLogger(EngTabEsrnwsVw.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public EngTabEsrnwsVwFacade getEngTabEsrnwsVwFacade() {//get y set de variable
        return engTabEsrnwsVwFacade;
    }

    public void setEngTabEsrnwsVwFacade(EngTabEsrnwsVwFacade engTabEsrnwsVwFacade) {//get y set de variable
        this.engTabEsrnwsVwFacade = engTabEsrnwsVwFacade;
    }

    public String getIdESRTab() {//get y set de variable
        return idESRTab;
    }

    public void setIdESRTab(String idESRTab) {//get y set de variable
        this.idESRTab = idESRTab;
    }

    public TabEsrEaEo getTabEsrEaEoID() {//get y set de variable
        return tabEsrEaEoID;
    }

    public void setTabEsrEaEoID(TabEsrEaEo tabEsrEaEoID) {//get y set de variable
        this.tabEsrEaEoID = tabEsrEaEoID;
    }

    public String getAirCraft() {//get y set de variable
        return airCraft;
    }

    public void setAirCraft(String airCraft) {//get y set de variable
        this.airCraft = airCraft;
    }

    public String getValAirCraft() {//get y set de variable
        return valAirCraft;
    }

    public void setValAirCraft(String valaAirCraft) {//get y set de variable
        this.valAirCraft = valaAirCraft;
    }

    public String getCompany() {//get y set de variable
        return company;
    }

    public void setCompany(String company) {//get y set de variable
        this.company = company;
    }

    public String getUserEsr() {//get y set de variable
        return userEsr;
    }

    public void setUserEsr(String userEsr) {//get y set de variable
        this.userEsr = userEsr;
    }  

    public String getCheckID() {//get y set de variable
        return checkID;
    }

    public void setCheckID(String checkID) {//get y set de variable
        this.checkID = checkID;
    } 

    public ContCheckFacade getContFacade() {//get y set de variable
        return contFacade;
    }

    public void setContFacade(ContCheckFacade contFacade) {//get y set de variable
        this.contFacade = contFacade;
    }

    public ContCheck getContCheckID() {//get y set de variable
        return contCheckID;
    }

    public void setContCheckID(ContCheck contCheckID) {//get y set de variable
        this.contCheckID = contCheckID;
    } 

    public String getWO() {//get y set de variable
        return wo;
    }

    public void setWo(String wo) {//get y set de variable
        this.wo = wo;
    }

    public String getAirCraft2() {//get y set de variable
        return airCraft2;
    }

    public void setAirCraft2(String airCraft2) {//get y set de variable
        this.airCraft2 = airCraft2;
    }

    public String getfInicio() {//get y set de variable
        return fInicio;
    }

    public void setfInicio(String fInicio) {//get y set de variable
        this.fInicio = fInicio;
    }

    public String getfFin() {//get y set de variable
        return fFin;
    }

    public void setfFin(String fFin) {//get y set de variable
        this.fFin = fFin;
    }
    public String getAvion() {
        return avion;
    }

    public void setAvion(String avion) {
        this.avion = avion;
    }

    public List<EngTabEsrnwaAircraft> getListadoNw() {
        return listadoNw;
    }

    public void setListadoNw(List<EngTabEsrnwaAircraft> listadoNw) {
        this.listadoNw = listadoNw;
    }
    public List<EngTabEsrnwsVw> getListadoETR() {
        return listadoETR;
    }

    public void setListadoETR(List<EngTabEsrnwsVw> listadoETR) {
        this.listadoETR = listadoETR;
    }
    public CompanyBean getCompanyBean() {
        return companyBean;
    }

    public void setCompanyBean(CompanyBean companyBean) {
        this.companyBean = companyBean;
    }

    public EngMergeCustomerBean getEngMergeCustomerBean() {
        return engMergeCustomerBean;
    }

    public void setEngMergeCustomerBean(EngMergeCustomerBean engMergeCustomerBean) {
        this.engMergeCustomerBean = engMergeCustomerBean;
    }

    public String getCustomerSelected() {
        return customerSelected;
    }

    public void setCustomerSelected(String customerSelected) {
        this.customerSelected = customerSelected;
    }

    public EngTabEcrByCusVWFacade getEngTabEcrByCusVWFacade() {
        return engTabEcrByCusVWFacade;
    }

    public void setEngTabEcrByCusVWFacade(EngTabEcrByCusVWFacade engTabEcrByCusVWFacade) {
        this.engTabEcrByCusVWFacade = engTabEcrByCusVWFacade;
    }

    public List<EngTabEcrByCusVW> getListadoEcr() {
        return listadoEcr;
    }

    public void setListadoEcr(List<EngTabEcrByCusVW> listadoEcr) {
        this.listadoEcr = listadoEcr;
    }
    
    
}
