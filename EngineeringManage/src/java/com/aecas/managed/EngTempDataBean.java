
// To change this license header, choose License Headers in Project Properties.
// To change this template file, choose Tools | Templates
// and open the template in the editor.

package com.aecas.managed;// paquete manage

import com.aees.session.SessionBean;// importacion de clase
import com.aeroman.aees.entities.EngTempData;// importacion de clase
import com.aeroman.aees.facades.EngTempDataFacade;// importacion de clase
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
@ManagedBean(name = "tempdatBean")
@ViewScoped//tipo de clase
//clase EngTempDataBean con extends al crud
public class EngTempDataBean extends CrudBean<EngTempData> implements Serializable{
    
    @EJB
    private EngTempDataFacade TempDataFacade;//declaracion de clases Facade
        
    private BigDecimal idTempData3;//declaracion de variable
    private String userlg3;//declaracion de variable
    private String descripcion3;//declaracion de variable
    private boolean encontrarRepetido3;//declaracion de variable
    private int pCount3;//declaracion de variable
    
    @Override//metodo generado por implements Serializable
    @PostConstruct//metodo constructor
    public void init() {
       HttpSession session3 = SessionBean.getSession();
       setUserlg3((String) session3.getAttribute("username")); 
       elemento = nuevoElemento();
       listado = findAllNotDeletedTempData();
       edit = false;
       setDescripcion3(null);
    }

    @Override//metodo generado por implements Serializable
    public void limpiar() {
        elemento = nuevoElemento();
        listado = findAllNotDeletedTempData();
        edit = false;
        setDescripcion3(null);
        setEncontrarRepetido3(false);
        
        extendtime();//extiende el tiempo de sesion
    }

    @Override//metodo generado por implements Serializable
    public void actualizar() {
        extendtime();//extiende el tiempo de sesion
        try {
            elemento.setTedUserUpd(getUserlg3());
            elemento.setTedDateUpd(new Date());
            elemento.setTedDescription(getDescripcion3());
            elemento.setTedState("A");            
            
            if (elemento.getTedId() != null) {
                TempDataFacade.edit(elemento);
                limpiar();
            } else {
                FacesContext.getCurrentInstance().validationFailed();
            }
        } catch (Exception et) {
            Logger.getLogger(EngTempDataBean.class.getName()).log(Level.SEVERE, null, et);
            FacesContext.getCurrentInstance().validationFailed();
        }
    }

    @Override//metodo generado por implements Serializable
    public void agregar() {       
        try {
            extendtime();//extiende el tiempo de sesion
            setEncontrarRepetido3(false);
            
            elemento.setTedUserAdd(getUserlg3());
            elemento.setTedDateAdd(new Date());
            elemento.setTedDescription(getDescripcion3());
            elemento.setTedState("A");
            
            List<EngTempData> otroEliminar = listado;
            for (EngTempData lis : otroEliminar) {
                if (lis.getTedDescription().equals(elemento.getTedDescription())) {
                    setEncontrarRepetido3(true);
                    break;
                }
            }
            
            if (!isEncontrarRepetido3()) {
                
                if (elemento.getTedId() == null){
                    TempDataFacade.create(elemento);
                    limpiar();
                }else
                    FacesContext.getCurrentInstance().validationFailed();
            }
            else {
                FacesContext.getCurrentInstance().validationFailed();
            }
        } catch (Exception et) {
            Logger.getLogger(EngTempDataBean.class.getName()).log(Level.SEVERE, null, et);
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error al insert"));
        }
    }

    @Override//metodo generado por implements Serializable
    public void eliminar(EngTempData elemento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void delete(String id) {  
        extendtime();//extiende el tiempo de sesion
        try {
            BigDecimal idTempData = new BigDecimal(id);
            elemento = TempDataFacade.find(idTempData);            
            elemento.setTedUserDlt(getUserlg3());
            elemento.setTedDateDlt(new Date());
            elemento.setTedState("D");
            
            setpCount3(TempDataFacade.existeEnESR(elemento.getTedDescription()));
            
            if (getpCount3() == 0) {
                TempDataFacade.edit(elemento);
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
    public EngTempData nuevoElemento() {
        return new EngTempData();
    }
    
    public List<EngTempData> findAllNotDeletedTempData(){
        extendtime();//extiende el tiempo de sesion
        listado = new ArrayList<>();
        listado2 = TempDataFacade.findAllActive();
        for (EngTempData temp : listado2) {
            if(temp.getTedState().equals("A")){
                listado.add(temp);
            }            
        } 
        
        return listado;
    }
    
    public void limpiarTempDataModal() {
        extendtime();//extiende el tiempo de sesion
        FacesContext context = FacesContext.getCurrentInstance();
        UIViewRoot root = context.getViewRoot();
        UIInput txtTedDescription = (UIInput) root.findComponent("inputFormTempData:txtTedDescription");
        txtTedDescription.resetValue();
    }

    public BigDecimal getIdTempData3() {//get y set de variable
        return idTempData3;
    }

    public void setIdTempData3(BigDecimal idTempData3) {//get y set de variable
        this.idTempData3 = idTempData3;
    }

    public String getUserlg3() {//get y set de variable
        return userlg3;
    }

    public void setUserlg3(String userlg3) {//get y set de variable
        this.userlg3 = userlg3;
    }

    public String getDescripcion3() {//get y set de variable
        return descripcion3;
    }

    public void setDescripcion3(String descripcion3) {//get y set de variable
        this.descripcion3 = descripcion3;
    }

    public boolean isEncontrarRepetido3() {//get y set de variable
        return encontrarRepetido3;
    }

    public void setEncontrarRepetido3(boolean encontrarRepetido3) {//get y set de variable
        this.encontrarRepetido3 = encontrarRepetido3;
    }

    public int getpCount3() {//get y set de variable
        return pCount3;
    }

    public void setpCount3(int pCount3) {//get y set de variable
        this.pCount3 = pCount3;
    }

}
