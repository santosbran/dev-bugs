/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aecas.managed;

import com.aees.session.SessionBean;
import com.aeroman.aees.entities.EngCustomer;
import com.aeroman.aees.entities.EngMergeCustomer;
import com.aeroman.aees.entities.MpplnForeCustomer;
import com.aeroman.aees.entities.grant.SgrCia;
import com.aeroman.aees.facades.EngCustomerFacade;
import com.aeroman.aees.facades.EngMergeCustomerFacade;
import com.aeroman.aees.facades.MpplnForeCustomerFacade;
import com.aeroman.aees.facades.grant.SgrCiaFacade;
import com.aeroman.aees.facades.grant.SgrUserFacades;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author vjuarez
 */
//nombre de clase en mageBean
@ManagedBean(name = "engMergeCustomerBean")//nombre de clase en mageBean
@SessionScoped //tipo de clase
public class EngMergeCustomerBean extends CrudBean<EngMergeCustomer> implements Serializable{
    
    @EJB
    private EngMergeCustomerFacade engMergeCustomerFacade;
    @EJB
    private SgrCiaFacade sgrCiaFacade;
    @EJB
    private EngCustomerFacade engCustomerFacade;
    @EJB
    private MpplnForeCustomerFacade mpplnForeCustomerFacade;
    @EJB
    private SgrUserFacades sgrUser;//declaracion de clases Facade
    
    transient List<EngCustomer> listEngId;
    transient List<MpplnForeCustomer> listCstId;
    transient List<SgrCia> listCiaCode;
    
    private boolean checkMarge;
    private String engId;
    private String cstId;
    private String ciaCode;
    private boolean repetido;
    private boolean opcoUp;
    private ArrayList<String> stringCustomer;
    private String userEsr= "username";
    private String  companyUser;//declaracion de variable
    private SgrCia sgrCia;//declaracion de variable
    private String userEA;//declaracion de variable
    
    @Override//metodo generado por implements Serializable
    @PostConstruct    //metodo constructor
    public void init() {        
        edit=false;        
        elemento = new EngMergeCustomer();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        Map params = externalContext.getRequestParameterMap();
        userEA = (String) params.get("user");
        llenandoLista();
    }
    public void listOpco(String opco){
        SgrCia opcos = new SgrCia();
        opcos = sgrCiaFacade.find(opco);
        listado2 = engMergeCustomerFacade.findOpco(opcos);
    }
    public void listOpcoMail(String opco){
        listado3 = new ArrayList<>();
        SgrCia opcos2 = new SgrCia();
        opcos2 = sgrCiaFacade.find(opco);
        listado3 = engMergeCustomerFacade.findOpco(opcos2);
    }
    public void deleteCustomer(){
        eliminar(elemento);
        listado.remove(elemento);
        limpiar();
    }
     public void llenandoLista(){
        listado = new ArrayList<>();
        listEngId = new ArrayList<>();
        listCstId = new ArrayList<>();
        listCiaCode = new ArrayList<>();
        stringCustomer = new ArrayList<String>();
        stringCustomer.add("YES");
        stringCustomer.add("NO");
        if (userEA == null){
            HttpSession ses = SessionBean.getSession();
            userEA = (String) ses.getAttribute(userEsr);
        }
        
        companyUser = sgrUser.findSelectUser(userEA).getCiaDefault(); 
        if(companyUser!=null){
        sgrCia = sgrCiaFacade.find(companyUser);
        listEngId = engCustomerFacade.findAllCustomer();
        listCstId = mpplnForeCustomerFacade.findAllCommerCustomer();
        try {
            extendtime();
            if(sgrCia.getCiaAcceso().intValue()==1){
                listCiaCode = sgrCiaFacade.findAllOperative();  
                //listado = engMergeCustomerFacade.findAllEngMergeCustomer();
                listado = engMergeCustomerFacade.findAll();
            }else{
                listCiaCode.add(sgrCia);
                listado = engMergeCustomerFacade.findOpco(sgrCia);
            }
            
            
        } catch (Exception e) {
            Logger.getLogger(EngMergeCustomerBean.class.getName()).log(Level.SEVERE, null, e);
        }
        }
    }

    @Override
    public void limpiar() {
        elemento = new EngMergeCustomer();
        checkMarge=false;
        engId=null;
        cstId=null;
        ciaCode=null;
        repetido=false;
        edit=false;
    }

    @Override
    public void actualizar() {
        HttpSession sesUP = SessionBean.getSession();
        String userLUP = (String) sesUP.getAttribute(userEsr);  
        opcoUp=false;
        try {
                setRepetido(false);
                for (EngMergeCustomer listEngMergeCustomer : listado) {
                    if (listEngMergeCustomer.getCstId().getCstId().equals(getCstId()) && listEngMergeCustomer.getCiaCode().getCiaCode().equals(getCiaCode()) && listEngMergeCustomer.getEmcMerge().equals(elemento.getEmcMerge()) && listEngMergeCustomer.getEngId().getEngId().equals(getEngId())) {
                        setRepetido(true);
                        break;
                    }
                }
                if(!getRepetido() && getCiaCode().equals("AESV") && getEngId()== null){
                    opcoUp=true;
                }
                if (!getRepetido() && !opcoUp) {
                    elemento.setCiaCode(sgrCiaFacade.find(getCiaCode()));
                    elemento.setCstId(mpplnForeCustomerFacade.find(new BigDecimal(getCstId())));
                    elemento.setEmcDateUpd(new Date());
                    elemento.setEmcUserUpd(userLUP);
                    if (getEngId()!=null) {
                        elemento.setEngId(engCustomerFacade.find(getEngId()));                            
                    }else{
                        elemento.setEngId(null);
                    }
                    
                    if( elemento.getEmcMerge()== null && elemento.getCiaCode().getCiaCode().equals("AESV")){
                       elemento.setEmcMerge("YES");
                    }else{
                       elemento.setEmcMerge("NO");
                    }
                    engMergeCustomerFacade.edit(elemento);
                    listado = engMergeCustomerFacade.findAll();
                    limpiar();
                }else{
                    FacesContext.getCurrentInstance().validationFailed();
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Customer alrady exists"));
                }

        } catch (Exception e) {
            Logger.getLogger(EngMergeCustomerBean.class.getName()).log(Level.SEVERE, null, e);
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("error"));
        }
       
    }

    @Override
    public void agregar() {
        HttpSession ses = SessionBean.getSession();
        String userL = (String) ses.getAttribute(userEsr);
        opcoUp=false;
        try {
                setRepetido(false);
                for (EngMergeCustomer listEngMergeCustomer : listado) {
                    if (listEngMergeCustomer.getCstId().getCstId().toString().equals(getCstId()) && listEngMergeCustomer.getCiaCode().getCiaCode().equals(getCiaCode())) {
                        setRepetido(true);
                        break;
                    }
                }
                if(!getRepetido() && getCiaCode().equals("AESV") && getEngId()== null){
                    opcoUp=true;
                }
                
                if (!getRepetido() && !opcoUp) {
                    elemento.setCiaCode(sgrCiaFacade.find(getCiaCode()));
                    elemento.setCstId(mpplnForeCustomerFacade.find(new BigDecimal(getCstId())));
                    elemento.setEmcDateAdd(new Date());
                    elemento.setEmcUserAdd(userL);
                    if (getEngId()!=null) {
                        elemento.setEngId(engCustomerFacade.find(getEngId()));                            
                    } else{
                        elemento.setEngId(null);
                    }
                    if( elemento.getEmcMerge()== null && elemento.getCiaCode().getCiaCode().equals("AESV")){
                       elemento.setEmcMerge("YES");
                    }else{
                       elemento.setEmcMerge("NO");
                    }
                    engMergeCustomerFacade.create(elemento);
                    listado.add(elemento);
                    limpiar();
                }else{
                    FacesContext.getCurrentInstance().validationFailed();
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Customer alrady exists"));
                }

        } catch (Exception e) {
            Logger.getLogger(EngMergeCustomerBean.class.getName()).log(Level.SEVERE, null, e);
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("error"));
        }
       
        
    }

    @Override
    public void eliminar(EngMergeCustomer elementMCB) {
        engMergeCustomerFacade.remove(elementMCB);
    }

    @Override
    public EngMergeCustomer nuevoElemento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<EngCustomer> getListEngId() {
        return listEngId;
    }

    public void setListEngId(List<EngCustomer> listEngId) {
        this.listEngId = listEngId;
    }

    public List<MpplnForeCustomer> getListCstId() {
        return listCstId;
    }

    public void setListCstId(List<MpplnForeCustomer> listCstId) {
        this.listCstId = listCstId;
    }

    public List<SgrCia> getListCiaCode() {
        return listCiaCode;
    }

    public void setListCiaCode(List<SgrCia> listCiaCode) {
        this.listCiaCode = listCiaCode;
    }

    public boolean isCheckMarge() {
        return checkMarge;
    }

    public void setCheckMarge(boolean checkMarge) {
        this.checkMarge = checkMarge;
    }

    public String getEngId() {
        return engId;
    }

    public void setEngId(String engId) {
        this.engId = engId;
    }

    public String getCstId() {
        return cstId;
    }

    public void setCstId(String cstId) {
        this.cstId = cstId;
    }

    public String getCiaCode() {
        return ciaCode;
    }

    public void setCiaCode(String ciaCode) {
        this.ciaCode = ciaCode;
    }

    public boolean getRepetido() {
        return repetido;
    }

    public void setRepetido(boolean repetido) {
        this.repetido = repetido;
    }

    public ArrayList<String> getStringCustomer() {
        return stringCustomer;
    }

    public void setStringCustomer(ArrayList<String> stringCustomer) {
        this.stringCustomer = stringCustomer;
    }

    public boolean getOpcoUp() {
        return opcoUp;
    }

    public void setOpcoUp(boolean opcoUp) {
        this.opcoUp = opcoUp;
    }
    
  
}
