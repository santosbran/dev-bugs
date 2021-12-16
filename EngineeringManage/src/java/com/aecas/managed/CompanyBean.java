/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aecas.managed;

import com.aeroman.aees.entities.grant.SgrCia;// importacion de clase
import com.aeroman.aees.facades.Sequences;// importacion de clase
import com.aeroman.aees.facades.grant.SgrCiaFacade;// importacion de clase
import com.aeroman.aees.facades.grant.SgrUserFacades;
import java.io.IOException;
import java.io.Serializable;// libreria seralizable
import java.util.ArrayList;// libreria ArrayList
import java.util.List;// libreria List
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;// libreria PostConstruct
import javax.ejb.EJB;// libreria EJB
import javax.faces.bean.ManagedBean;// libreria ManagedBean
import javax.faces.bean.SessionScoped;// libreria SessionScoped
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Saplic17
 */
//nombre de clase en mageBean
@ManagedBean(name = "companyBean")
@SessionScoped//tipo de clase
//clase CompanyBean con extends al crud
public class CompanyBean extends CrudBean<SgrCia> implements Serializable {

    transient List<Object[]> listadoforcompany=new ArrayList();// inportacion de clase
    transient List<Object[]> listadoTabEoing=new ArrayList();// inportacion de clase
    transient List<Object[]> listAlesr = new ArrayList();// inportacion de clase
    private String company;//declaracion de variable
    private SgrCia sgrCia = new SgrCia();
    private String users;
    private String companyUser;
    private String showMenuDash;    
    private String showMenuAirplane; 
    private String showMenuESR;
    private String showMenuAEIS;
    private String showBotoneraESR;
    private int contInitial;
    
//<editor-fold defaultstate="collapsed" desc="EJB">
    @EJB
    private SgrCiaFacade companyFacade;//declaracion de clases Facade
    @EJB
    private Sequences seq;//declaracion de clases Facade
    @EJB
    private SgrUserFacades sgrUser;//declaracion de clases Facade
    
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="INIT">
     //metodo generado por implements Serializable
    @Override
    //metodo constructor
    @PostConstruct
    public void init() {
            this.elemento = new SgrCia();
            listado = new ArrayList<>();
            FacesContext facesContext = FacesContext.getCurrentInstance();
            ExternalContext externalContext = facesContext.getExternalContext();
            Map params = externalContext.getRequestParameterMap();
            users = (String) params.get("user");
            companyUser = sgrUser.findSelectUser(users).getCiaDefault();
            contInitial=0;
            if(companyUser==null){
                try {
                    externalContext.redirect("/EngineeringManage/pages/error/error.xhtml");
                } catch (IOException ex) {
                    Logger.getLogger(CompanyBean.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                sgrCia = companyFacade.find(companyUser);
                if(sgrCia.getCiaAcceso().intValue()==1){
                    listado = companyFacade.findAllOperative();
                }else{
                    listado.add(sgrCia);
                } 
                initMenus();
            }
    }
//</editor-fold>
    public void initMenus(){
        try{
            setShowMenuDash("0");
            setShowMenuAirplane("1");
            setShowMenuESR("0");
            setShowMenuAEIS("1");
            setShowBotoneraESR("0");
            if(contInitial>0){
              //  PrimeFaces.current().ajax().update("menuAditional");
             //   PrimeFaces.current().ajax().update("botoneraESR");
            }
            contInitial++;
        }catch(Exception e){
            e.printStackTrace();
        }        
    }
    
    public void menuESR(){
        setShowMenuAEIS("0");
        setShowMenuDash("0");
        setShowMenuAirplane("0");
        setShowMenuESR("1");
        setShowBotoneraESR("0");
     //   PrimeFaces.current().ajax().update("menuAditional");
     //   PrimeFaces.current().ajax().update("botoneraESR");
    }
    
    public void menuBotoneraESR(){
        setShowMenuAEIS("0");
        setShowMenuDash("0");
        setShowMenuAirplane("0");
        setShowMenuESR("0");
        setShowBotoneraESR("1");
     //   PrimeFaces.current().ajax().update("menuAditional");
     //   PrimeFaces.current().ajax().update("botoneraESR");
    }
    
    public void menuDash(){
        setShowMenuDash("1");
        setShowMenuAirplane("0");
        setShowMenuESR("0");
        setShowMenuAEIS("1");
        setShowBotoneraESR("0");
    //    PrimeFaces.current().ajax().update("menuAditional");
      //  PrimeFaces.current().ajax().update("botoneraESR");
    }

//<editor-fold defaultstate="collapsed" desc="Limpiar">
     //metodo generado por implements Serializable el cual limpia el elemento y edit
    @Override
    public void limpiar() {
        extendtime();
        this.elemento = new SgrCia();
        this.edit = false;
    }
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="Eliminar">
     //metodo generado por implements Serializable
    @Override
    public void eliminar(SgrCia elemento) {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
        
    }
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="Actualizar">
     //metodo generado por implements Serializable
    @Override
    public void actualizar() {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.        
    }
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="Agregar">
     //metodo generado por implements Serializable
    @Override
    public void agregar() {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
        
    }
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="nuevoElemento">
     //metodo generado por implements Serializable
    @Override
    SgrCia nuevoElemento() {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }
//</editor-fold>
//get y set de variable
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
    public String getShowMenuDash() {
        return showMenuDash;
    }

    public void setShowMenuDash(String showMenuDash) {
        this.showMenuDash = showMenuDash;
    }    

    public String getShowMenuAirplane() {
        return showMenuAirplane;
    }

    public void setShowMenuAirplane(String showMenuAirplane) {
        this.showMenuAirplane = showMenuAirplane;
    }

    public String getShowMenuESR() {
        return showMenuESR;
    }

    public void setShowMenuESR(String showMenuESR) {
        this.showMenuESR = showMenuESR;
    }

    public String getShowMenuAEIS() {
        return showMenuAEIS;
    }

    public void setShowMenuAEIS(String showMenuAEIS) {
        this.showMenuAEIS = showMenuAEIS;
    }

    public String getShowBotoneraESR() {
        return showBotoneraESR;
    }

    public void setShowBotoneraESR(String showBotoneraESR) {
        this.showBotoneraESR = showBotoneraESR;
    }    

    public int getContInitial() {
        return contInitial;
    }

    public void setContInitial(int contInitial) {
        this.contInitial = contInitial;
    }
    
}//cierre de clase
