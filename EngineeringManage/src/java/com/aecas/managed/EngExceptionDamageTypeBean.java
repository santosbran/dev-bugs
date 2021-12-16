/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aecas.managed;

import com.aees.session.SessionBean;
import com.aeroman.aees.entities.EngDamageType;
import com.aeroman.aees.entities.EngExcepDamage;
import com.aeroman.aees.facades.EngDamageTypeFacade;
import com.aeroman.aees.facades.engExceptionDamageTypeFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.component.UIInput;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mchacon
 */
@Named(value = "engExceptionDamageTypeBean")
@SessionScoped
public class EngExceptionDamageTypeBean extends CrudBean<EngExcepDamage> implements Serializable{

    @EJB
    private EngDamageTypeFacade DamageTypeFacade;

    @EJB
    private engExceptionDamageTypeFacade EngExceptionDamageTypeFacade;
    private BigDecimal idDamageType2;//declaracion de variable
    private String userlg2;//declaracion de variable
    private String nombreExcepcion;//declaracion de variable
    int regAsoc=0;
    private List<EngDamageType> listadoDamage = new ArrayList<>();

    public EngExceptionDamageTypeBean() {
        super();
    }

    @Override
@PostConstruct            
    void init() {
         HttpSession session2 = SessionBean.getSession();
    setUserlg2((String) session2.getAttribute("username")); 
       elemento = nuevoElemento();
       listadoDamage = findAllNotDeletedDamageTy();
       edit = false;
       listado= EngExceptionDamageTypeFacade.findAll();
         regAsoc=0;
    }
   public List<EngDamageType> findAllNotDeletedDamageTy(){
        extendtime();
        listadoDamage = new ArrayList<>();
        listadoDamage = DamageTypeFacade.findAllActive();        
        return listadoDamage;
    }
   
   public void limpiarDamageTypeModal() {
        extendtime();
        FacesContext context = FacesContext.getCurrentInstance();
        UIViewRoot root = context.getViewRoot();
        UIInput txtDatName = (UIInput) root.findComponent("inputFormExcDamageType:txtExcDatName");
        txtDatName.resetValue();
        UIInput txtDatDescription = (UIInput) root.findComponent("inputFormExcDamageType:txtExcDatDescription");
        txtDatDescription.resetValue();   
   }
   
   
   public void limpiar() {
   extendtime();
        elemento = nuevoElemento();
  listadoDamage = findAllNotDeletedDamageTy();
        edit = false;
        listado=new ArrayList<EngExcepDamage>();
        listado= EngExceptionDamageTypeFacade.findAll();
   regAsoc=0;
        
       /*se vuelve a setear en este metodo el tiempo maximo de inactividad para que se cierre la session*/
        extendtime();
    }

    @Override
    void actualizar() {
           extendtime();
        try {
            if(elemento.getExcepDamId()!=null){
            elemento.setExcepDamUserUpd(getUserlg2());
            elemento.setExcepDamDateUpd(new Date());
            elemento.setExcepDamName(nombreExcepcion);
            
            EngExceptionDamageTypeFacade.edit(elemento);
                limpiar();
            }else{
                FacesContext.getCurrentInstance().validationFailed();
            }
            
            

        } catch (Exception e) {
            Logger.getLogger(EngDamageTypeBean.class.getName()).log(Level.SEVERE, null, e);
            FacesContext.getCurrentInstance().validationFailed();
        }
    }
    
    
    public void delete(String id) {
        extendtime();
        try {
            BigDecimal idDamage = new BigDecimal(id);
            elemento = EngExceptionDamageTypeFacade.find(idDamage);
            if (elemento != null) {
                boolean existeRegistroAsoc = EngExceptionDamageTypeFacade.tieneManufactAsociados(elemento.getExcepDamName());
                if (!existeRegistroAsoc) {
                    EngExceptionDamageTypeFacade.remove(elemento);
                      limpiar();
                } else {
                     regAsoc=1;
                    FacesContext.getCurrentInstance().validationFailed();
                }
              

            } else {
                limpiar();
                FacesContext.getCurrentInstance().validationFailed();
            }

        } catch (Exception e) {
            Logger.getLogger(EngDamageTypeBean.class.getName()).log(Level.SEVERE, null, e);
            FacesContext.getCurrentInstance().validationFailed();
        }
    }

    @Override
    void agregar() {
        
           int countExiste=EngExceptionDamageTypeFacade.findByDamageByNameExcep(nombreExcepcion);
            if(countExiste>0){
                FacesContext.getCurrentInstance().validationFailed();
                
            }else{
                elemento.setExcepDamUserAdd(getUserlg2());
                elemento.setExcepDamDateAdd(new Date());
                elemento.setExcepDamName(nombreExcepcion);
                elemento.setExcepDamUserUpd(getUserlg2());
                elemento.setExcepDamDateUpd(new Date());
                EngExceptionDamageTypeFacade.create(elemento);
                limpiar();
            }
            
            
            
    }

    public void eliminar(EngExcepDamage elemento) {

    }

    @Override
    EngExcepDamage nuevoElemento() {
return new EngExcepDamage();
    }

    public String getUserlg2() {
        return userlg2;
    }

    public void setUserlg2(String userlg2) {
        this.userlg2 = userlg2;
    }

    public String getNombreExcepcion() {
        return nombreExcepcion;
    }

    public void setNombreExcepcion(String nombreExcepcion) {
        this.nombreExcepcion = nombreExcepcion;
    }


    public List<EngDamageType> getListadoDamage() {
        return listadoDamage;
    }

    public void setListadoDamage(List<EngDamageType> listadoDamage) {
        this.listadoDamage = listadoDamage;
    }

    public BigDecimal getIdDamageType2() {
        return idDamageType2;
    }

    public void setIdDamageType2(BigDecimal idDamageType2) {
        this.idDamageType2 = idDamageType2;
    }

    public int getRegAsoc() {
        return regAsoc;
    }

    public void setRegAsoc(int regAsoc) {
        this.regAsoc = regAsoc;
    }
    
    
}
