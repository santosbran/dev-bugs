 // To change this license header, choose License Headers in Project Properties.
 // To change this template file, choose Tools | Templates
 // and open the template in the editor.
package com.aecas.managed;// paquete manage

import com.aees.session.SessionBean;// libreria Serializable
import com.aeroman.aees.entities.EngDimension;// importacion de clase
import com.aeroman.aees.facades.EngDimensionFacade;// importacion de clase
import java.io.Serializable;// libreria Serializable
import java.math.BigDecimal;// libreria BigDecimal
import java.util.ArrayList;// libreria ArrayList
import java.util.Date;// libreria Date
import java.util.List;// libreria List
import java.util.logging.Level;// libreria Level
import java.util.logging.Logger;// libreria Logger
import javax.annotation.PostConstruct;// libreria PostConstruct
import javax.ejb.EJB;// libreria EJB
import javax.faces.application.FacesMessage;// libreria FacesMessage
import javax.faces.bean.ManagedBean;// libreria ManagedBean
import javax.faces.bean.ViewScoped;// libreria ViewScoped
import javax.faces.component.UIInput;// libreria UIInput
import javax.faces.component.UIViewRoot;// libreria UIViewRoot
import javax.faces.context.FacesContext;// libreria FacesContext
import javax.servlet.http.HttpSession;// libreria HttpSession

/**
 *
 * @author mpolanco
 */
//nombre de clase en mageBean
@ManagedBean(name = "dimenbean")
@ViewScoped //tipo de clase
//clase ContAtasBean con extends al crud
public class EngDimensionBean extends CrudBean<EngDimension> implements Serializable{

    @EJB
    private EngDimensionFacade DimensionFacade;//declaracion de clases Facade
    
    private BigDecimal idDimension1;//declaracion de variable
    private String userlg1;//declaracion de variable
    private String nombre1;//declaracion de variable
    private String descripcion1;//declaracion de variable
    private boolean encontrarRepetido1;//declaracion de variable
    private int pCount1;//declaracion de variable

    
    //metodo generado por implements Serializable
    @Override
    //metodo constructor
    @PostConstruct
    public void init() {
       HttpSession session1 = SessionBean.getSession();
       setUserlg1((String) session1.getAttribute("username")); 
       elemento = nuevoElemento();
       listado = findAllNotDeletedDimension();
       edit = false;
       setNombre1(null);
       setDescripcion1(null);
    }
    
    @Override
    public void limpiar() {
        extendtime();
        elemento = nuevoElemento();
        listado = findAllNotDeletedDimension();
        edit = false;
        setNombre1(null);
        setDescripcion1(null);
        setEncontrarRepetido1(false);
        
       /*se vuelve a setear en este metodo el tiempo maximo de inactividad para que se cierre la session*/
        extendtime();
    }

    @Override
    public void actualizar() {
        extendtime();
        try {
            elemento.setDimUserUpd(getUserlg1());
            elemento.setDimDateUpd(new Date());
            elemento.setDimName(getNombre1());
            elemento.setDimDescription(getDescripcion1());
            elemento.setDimState("A");
            
            if (elemento.getDimId() != null) {
                DimensionFacade.edit(elemento);
                limpiar();
            } else {
                FacesContext.getCurrentInstance().validationFailed();
            }

        } catch (Exception e) {
            Logger.getLogger(EngDimensionBean.class.getName()).log(Level.SEVERE, null, e);
            FacesContext.getCurrentInstance().validationFailed();
        }
    }

    @Override
    public void agregar() {
        extendtime();
        try {
            setEncontrarRepetido1(false);
            
            elemento.setDimUserAdd(getUserlg1());
            elemento.setDimDateAdd(new Date());
            elemento.setDimName(getNombre1());
            elemento.setDimDescription(getDescripcion1());
            elemento.setDimState("A");
            
            List<EngDimension> otroEliminar = listado;
            for (EngDimension lis : otroEliminar) {
                if (lis.getDimName().equals(elemento.getDimName())) {
                    setEncontrarRepetido1(true);
                    break;
                }
            }
            
            if (!isEncontrarRepetido1()) {
                
                if (elemento.getDimId() == null){
                    DimensionFacade.create(elemento);
                    limpiar();
                }else
                    FacesContext.getCurrentInstance().validationFailed();
            }
            else {
                FacesContext.getCurrentInstance().validationFailed();
            }
        } catch (Exception e) {
            Logger.getLogger(EngDamageTypeBean.class.getName()).log(Level.SEVERE, null, e);
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error al insertar"));
        }
    }

    @Override
    public void eliminar(EngDimension elemento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void delete(String id) {  
        extendtime();
        try {
            BigDecimal idDamage = new BigDecimal(id);
            elemento = DimensionFacade.find(idDamage);            
            elemento.setDimUserDlt(getUserlg1());
            elemento.setDimDateDlt(new Date());
            elemento.setDimState("D");
            
            setpCount1(DimensionFacade.existeEnDamageDim(elemento.getDimId()));
            
            if (elemento.getDimId() != null && pCount1 == 0) {
                DimensionFacade.edit(elemento);
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
    public EngDimension nuevoElemento() {
        return new EngDimension();
    }
    
    public List<EngDimension> findAllNotDeletedDimension(){
        extendtime();
        listado = new ArrayList<>();
        listado2 = DimensionFacade.findAllActive();
        for (EngDimension dimen : listado2) {
            if(dimen.getDimState().equals("A")){
                listado.add(dimen);
            }
            
        } 
        return listado;
    }
    
    public void limpiarDimensionModal() {
        extendtime();
        FacesContext context = FacesContext.getCurrentInstance();
        UIViewRoot root = context.getViewRoot();
        UIInput txtDatName = (UIInput) root.findComponent("inputFormDimension:txtDimName");
        txtDatName.resetValue();
        UIInput txtDatDescription = (UIInput) root.findComponent("inputFormDimension:txtDimDescription");
        txtDatDescription.resetValue();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    /**
     * @return the idDimension1
     */
     //get y set de variable
    public BigDecimal getIdDimension1() {
        return idDimension1;
    }

    /**
     * @param idDimension1 the idDimension1 to set
     */
     //get y set de variable
    public void setIdDimension1(BigDecimal idDimension1) {
        this.idDimension1 = idDimension1;
    }
    
    /**
     * @return the userlg1
     */
     //get y set de variable
    public String getUserlg1() {
        return userlg1;
    }

    /**
     * @param userlg1 the userlg1 to set
     */
     //get y set de variable
    public void setUserlg1(String userlg1) {
        this.userlg1 = userlg1;
    }

    /**
     * @return the nombre1
     */
     //get y set de variable
    public String getNombre1() {
        return nombre1;
    }

    /**
     * @param nombre1 the nombre1 to set
     */
     //get y set de variable
    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    /**
     * @return the descripcion1
     */
     //get y set de variable
    public String getDescripcion1() {
        return descripcion1;
    }

    /**
     * @param descripcion1 the descripcion1 to set
     */
     //get y set de variable
    public void setDescripcion1(String descripcion1) {
        this.descripcion1 = descripcion1;
    }

    /**
     * @return the encontrarRepetido1
     */
     //get y set de variable
    public boolean isEncontrarRepetido1() {
        return encontrarRepetido1;
    }

    /**
     * @param encontrarRepetido1 the encontrarRepetido1 to set
     */
     //get y set de variable
    public void setEncontrarRepetido1(boolean encontrarRepetido1) {
        this.encontrarRepetido1 = encontrarRepetido1;
    }
 //get y set de variable
    public int getpCount1() {
        return pCount1;
    }
 //get y set de variable
    public void setpCount1(int pCount1) {
        this.pCount1 = pCount1;
    }  

}
