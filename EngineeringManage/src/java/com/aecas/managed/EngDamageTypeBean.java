
//  To change this license header, choose License Headers in Project Properties.
//  To change this template file, choose Tools | Templates
//  and open the template in the editor.
 
package com.aecas.managed;// paquete manage

import com.aees.session.SessionBean;// libreria SessionBean
import com.aeroman.aees.entities.EngDamageType;// importacion de clase
import com.aeroman.aees.facades.EngDamageTypeFacade;// importacion de clase
import java.io.Serializable;// libreria Serializable
import java.math.BigDecimal;// libreria Serializable
import java.util.ArrayList;// libreria Serializable
import java.util.Date;// libreria Serializable
import java.util.List;// libreria Serializable
import java.util.logging.Level;// libreria Serializable
import java.util.logging.Logger;// libreria Serializable
import javax.annotation.PostConstruct;// libreria Serializable
import javax.ejb.EJB;// libreria Serializable
import javax.faces.application.FacesMessage;// libreria Serializable
import javax.faces.bean.ManagedBean;// libreria Serializable
import javax.faces.bean.SessionScoped;// libreria Serializable
import javax.faces.component.UIInput;// libreria Serializable
import javax.faces.component.UIViewRoot;// libreria Serializable
import javax.faces.context.FacesContext;// libreria Serializable
import javax.servlet.http.HttpSession;// libreria Serializable

/**
 *
 * @author mpolanco
 */
//nombre de clase en mageBean
@ManagedBean(name = "damagtyBean")
@SessionScoped //tipo de clase
//clase ContAtasBean con extends al crud
public class EngDamageTypeBean extends CrudBean<EngDamageType> implements Serializable{

    @EJB
    private EngDamageTypeFacade DamageTypeFacade;//declaracion de clases Facade
    
    private BigDecimal idDamageType2;//declaracion de variable
    private String userlg2;//declaracion de variable
    private String nombre2;//declaracion de variable
    private String descripcion2;//declaracion de variable
    private boolean encontrarRepetido2;//declaracion de variable
    private int pCount2;
    
    //metodo generado por implements Serializable
    @Override
    //metodo constructor
    @PostConstruct
    public void init() {
       HttpSession session2 = SessionBean.getSession();
        setUserlg2((String) session2.getAttribute("username")); 
       elemento = nuevoElemento();
       listado = findAllNotDeletedDamageTy();
       edit = false;
        setNombre2(null);
        setDescripcion2(null);
    }

    @Override
    public void limpiar() {
        extendtime();
        elemento = nuevoElemento();
        listado = findAllNotDeletedDamageTy();
        edit = false;
        setNombre2(null);
        setDescripcion2(null);
        setEncontrarRepetido2(false);
            
        
       /*se vuelve a setear en este metodo el tiempo maximo de inactividad para que se cierre la session*/
        extendtime();
    }

    @Override
    public void actualizar() {
        extendtime();
        try {
            elemento.setDatUserUpd(getUserlg2());
            elemento.setDatDateUpd(new Date());
            elemento.setDatName(getNombre2());
            elemento.setDatDescription(getDescripcion2());
            elemento.setDatState("A");
            
            if (elemento.getDatId() != null) {
                DamageTypeFacade.edit(elemento);
                limpiar();
            } else {
                FacesContext.getCurrentInstance().validationFailed();
            }

        } catch (Exception e) {
            Logger.getLogger(EngDamageTypeBean.class.getName()).log(Level.SEVERE, null, e);
            FacesContext.getCurrentInstance().validationFailed();
        }
    }

    @Override
    public void agregar() {
        extendtime();
        try {
            
            setEncontrarRepetido2(false);
            
            elemento.setDatUserAdd(getUserlg2());
            elemento.setDatDateAdd(new Date());
            elemento.setDatName(getNombre2());
            elemento.setDatDescription(getDescripcion2());
            elemento.setDatState("A");
            
            List<EngDamageType> otroEliminar3 = listado;
            for (EngDamageType lis3 : otroEliminar3) {
                if (lis3.getDatName().equals(elemento.getDatName())) {
                    setEncontrarRepetido2(true);
                    break;
                }
            }
            
            if (!isEncontrarRepetido2()) {
                
                if (elemento.getDatId() == null){
                    DamageTypeFacade.create(elemento);
                    limpiar();
                }else
                    FacesContext.getCurrentInstance().validationFailed();
            }
            else {
                FacesContext.getCurrentInstance().validationFailed();
            }
        } catch (Exception ex) {
            Logger.getLogger(EngDamageTypeBean.class.getName()).log(Level.SEVERE, null, ex);
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error al insertar"));
        }
    }

    @Override
    public EngDamageType nuevoElemento() {
        return new EngDamageType();
    }
    
    public void delete(String id) {  
        extendtime();
        try {
            BigDecimal idDamage = new BigDecimal(id);
            elemento = DamageTypeFacade.find(idDamage);            
            elemento.setDatUserDlt(getUserlg2());
            elemento.setDatDateDlt(new Date());
            elemento.setDatState("D");
            
            setpCount(DamageTypeFacade.existeEnDamageDim(elemento.getDatId()));
            
            if (elemento.getDatId() != null && pCount2 == 0) {
                DamageTypeFacade.edit(elemento);
                limpiar();
            } else {
                FacesContext.getCurrentInstance().validationFailed();
            }

        } catch (Exception e) {
            Logger.getLogger(EngDamageTypeBean.class.getName()).log(Level.SEVERE, null, e);
            FacesContext.getCurrentInstance().validationFailed();
        }
    }
    @Override
    public void eliminar(EngDamageType elemento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    public List<EngDamageType> findAllNotDeletedDamageTy(){
        extendtime();
        listado = new ArrayList<>();
        listado = DamageTypeFacade.findAllActive();        
        return listado;
    }
    
    public void limpiarDamageTypeModal() {
        extendtime();
        FacesContext context = FacesContext.getCurrentInstance();
        UIViewRoot root = context.getViewRoot();
        UIInput txtDatName = (UIInput) root.findComponent("inputFormDamageType:txtDatName");
        txtDatName.resetValue();
        UIInput txtDatDescription = (UIInput) root.findComponent("inputFormDamageType:txtDatDescription");
        txtDatDescription.resetValue();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    /**
     * @return the idDamageType2
     */
    //get y set de variable
    public BigDecimal getIdDamageType2() {
        return idDamageType2;
    }

    /**
     * @param idDamageType2 the idDamageType2 to set
     */
    //get y set de variable
    public void setIdDamageType2(BigDecimal idDamageType2) {
        this.idDamageType2 = idDamageType2;
    }
    
    /**
     * @return the userlg2
     */
    //get y set de variable
    public String getUserlg2() {
        return userlg2;
    }

    /**
     * @param userlg2 the userlg2 to set
     */
    //get y set de variable
    public void setUserlg2(String userlg2) {
        this.userlg2 = userlg2;
    }

    /**
     * @return the nombre2
     */
    //get y set de variable
    public String getNombre2() {
        return nombre2;
    }

    /**
     * @param nombre2 the nombre2 to set
     */
    //get y set de variable
    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    /**
     * @return the descripcion2
     */
    //get y set de variable
    public String getDescripcion2() {
        return descripcion2;
    }

    /**
     * @param descripcion2 the descripcion2 to set
     */
    //get y set de variable
    public void setDescripcion2(String descripcion2) {
        this.descripcion2 = descripcion2;
    }

    /**
     * @return the encontrarRepetido2
     */
    //get y set de variable
    public boolean isEncontrarRepetido2() {
        return encontrarRepetido2;
    }

    /**
     * @param encontrarRepetido2 the encontrarRepetido2 to set
     */
    //get y set de variable
    public void setEncontrarRepetido2(boolean encontrarRepetido2) {
        this.encontrarRepetido2 = encontrarRepetido2;
    }
//get y set de variable
    public int getpCount() {
        return pCount2;
    }
//get y set de variable
    public void setpCount(int pCount) {
        this.pCount2 = pCount;
    }
    
    
}
