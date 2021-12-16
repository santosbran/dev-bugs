
// To change this license header, choose License Headers in Project Properties.
 // To change this template file, choose Tools | Templates
// and open the template in the editor.

package com.aecas.managed;// paquete manage

import com.aees.session.SessionBean;// importacion de clase
import com.aeroman.aees.entities.EngRequestType;// importacion de clase
import com.aeroman.aees.facades.EngRequestTypeFacade;// importacion de clase
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
@ManagedBean(name = "reqtypeBean")
@ViewScoped//tipo de clase
//clase EngRequestTypeBean con extends al crud
public class EngRequestTypeBean extends CrudBean<EngRequestType> implements Serializable{

     @EJB
    private EngRequestTypeFacade RequestTypeFacade;//declaracion de clases Facade
           
    private BigDecimal idReqType4;//declaracion de variable
    private String userlg4;//declaracion de variable
    private boolean encontrarRepetido4;//declaracion de variable
    private int pCount4;//declaracion de variable
    
    @Override//metodo generado por implements Serializable
    @PostConstruct//metodo constructor
    public void init() {
       HttpSession session4 = SessionBean.getSession();
       setUserlg4((String) session4.getAttribute("username")); 
       elemento = nuevoElemento();
       listado = findAllNotDeleted();
       edit = false;
    }

    @Override//metodo generado por implements Serializable
    public void limpiar() {
        extendtime();//extiende el tiempo de sesion
        elemento = nuevoElemento();
        listado = findAllNotDeleted();
        edit = false;
        setEncontrarRepetido4(false);
        
        extendtime();
    }

    @Override//metodo generado por implements Serializable
    public void actualizar() {
        extendtime();//extiende el tiempo de sesion
        try {
            elemento.setRetUserUpd(getUserlg4());
            elemento.setRetDateUpd(new Date());
            elemento.setRetState("A");            
            
            if (elemento.getRetId() != null) {
                RequestTypeFacade.edit(elemento);
                limpiar();
            } else {
                FacesContext.getCurrentInstance().validationFailed();
            }
        } catch (Exception e) {
            Logger.getLogger(EngTempDataBean.class.getName()).log(Level.SEVERE, null, e);
            FacesContext.getCurrentInstance().validationFailed();
        }
    }

    @Override//metodo generado por implements Serializable
    public void agregar() {
        extendtime();//extiende el tiempo de sesion
        try {
            setEncontrarRepetido4(false);
            
            elemento.setRetUserAdd(getUserlg4());
            elemento.setRetDateAdd(new Date());
            elemento.setRetState("A");
            
            List<EngRequestType> otroEliminar = listado;
            for (EngRequestType lis : otroEliminar) {
                if (lis.getRetDescription().equals(elemento.getRetDescription())) {
                    setEncontrarRepetido4(true);
                    break;
                }
            }
            
            if (!isEncontrarRepetido4()) {
                
                if (elemento.getRetId() == null){
                    RequestTypeFacade.create(elemento);
                    limpiar();
                }else
                    FacesContext.getCurrentInstance().validationFailed();
            }
            else {
                FacesContext.getCurrentInstance().validationFailed();
            }
        } catch (Exception e) {
            Logger.getLogger(EngTempDataBean.class.getName()).log(Level.SEVERE, null, e);
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error al insertar"));
        }
    }

    @Override//metodo generado por implements Serializable
    public void eliminar(EngRequestType elemento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void delete(String id) {     
        extendtime();//extiende el tiempo de sesion
        try {
            
            
            BigDecimal idReqType = new BigDecimal(id);
            elemento = RequestTypeFacade.find(idReqType);            
            elemento.setRetUserDlt(getUserlg4());
            elemento.setRetDateDlt(new Date());
            elemento.setRetState("D");
            
            setpCount4(RequestTypeFacade.existeEnESR(elemento.getRetDescription()));
            
            if (getpCount4() == 0) {
                RequestTypeFacade.edit(elemento);
            limpiar();
            } else {
                FacesContext.getCurrentInstance().validationFailed();
            }            

        } catch (Exception e) {
            Logger.getLogger(EngTempDataBean.class.getName()).log(Level.SEVERE, null, e);
            FacesContext.getCurrentInstance().validationFailed();
        }
    }

    @Override//metodo generado por implements Serializable
    public EngRequestType nuevoElemento() {
        return new EngRequestType();
    }
    
    public List<EngRequestType> findAllNotDeleted(){
        extendtime();//extiende el tiempo de sesion
        listado = new ArrayList<>();
        listado2 = RequestTypeFacade.findAllActive();
        for (EngRequestType temp : listado2) {
            if(temp.getRetState().equals("A")){
                listado.add(temp);
            }            
        } 
        
        return listado;
    }
    
    public void limpiarRequestTypeModal() {
        extendtime();//extiende el tiempo de sesion
        FacesContext context = FacesContext.getCurrentInstance();
        UIViewRoot root = context.getViewRoot();
        UIInput txtRetDescription = (UIInput) root.findComponent("inputFormReqType:txtRetDescription");
        txtRetDescription.resetValue();
    }
    
    public BigDecimal getIdReqType4() {//get y set de variable
        return idReqType4;
    }

    public void setIdReqType4(BigDecimal idReqType4) {//get y set de variable
        this.idReqType4 = idReqType4;
    }
    
    public String getUserlg4() {//get y set de variable
        return userlg4;
    }

    public void setUserlg4(String userlg4) {//get y set de variable
        this.userlg4 = userlg4;
    }

    public boolean isEncontrarRepetido4() {//get y set de variable
        return encontrarRepetido4;
    }

    public void setEncontrarRepetido4(boolean encontrarRepetido4) {//get y set de variable
        this.encontrarRepetido4 = encontrarRepetido4;
    }

    public int getpCount4() {//get y set de variable
        return pCount4;
    }

    public void setpCount4(int pCount4) {//get y set de variable
        this.pCount4 = pCount4;
    }
}
