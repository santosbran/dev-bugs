// To change this license header, choose License Headers in Project Properties.
// To change this template file, choose Tools | Templates
// and open the template in the editor.
 
package com.aecas.managed;// paquete manage

import com.aees.session.SessionBean;// importacion de clase
import com.aeroman.aees.entities.EngQuestion;// importacion de clase
import com.aeroman.aees.facades.EngQuestionFacade;// importacion de clase
import java.io.Serializable;// libreria Serializable
import java.math.BigDecimal;// libreria BigDecimal
import java.util.ArrayList;// libreria ArrayList
import java.util.Date;// libreria Date
import java.util.List;// libreria List
import java.util.Map;// libreria Map
import java.util.logging.Level;// libreria Level
import java.util.logging.Logger;// libreria Logger
import javax.annotation.PostConstruct;// libreria PostConstruct
import javax.ejb.EJB;// libreria EJB
import javax.faces.bean.ManagedBean;// libreria ManagedBean
import javax.faces.bean.SessionScoped;// libreria SessionScoped
import javax.faces.context.ExternalContext;// libreria ExternalContext
import javax.faces.context.FacesContext;// libreria FacesContext
import javax.servlet.http.HttpSession;// libreria HttpSession

/**
 *
 * @author vjuarez
 */
//nombre de clase en mageBean
@ManagedBean(name = "engQuestionBean")
@SessionScoped//tipo de clase
//clase EngQuestionBean con extends al crud
public class EngQuestionBean extends CrudBean<EngQuestion> implements Serializable {
    
    @EJB
    private EngQuestionFacade engQuestionFacade;//declaracion de clases Facade
    
    private String idQuestion;//declaracion de variable
    private boolean encontrarRepetido;//declaracion de variable
    private int pCount;//declaracion de variable
    private String users;//declaracion de variable
    private String descripcion;//declaracion de variable

    @Override//metodo generado por implements Serializable
    @PostConstruct//metodo constructor
    public void init() {
        listado = new ArrayList<>();
        elemento = new  EngQuestion();
        listado = engQuestionFacade.findAll();   
        descripcion = null;
    }

    @Override//metodo generado por implements Serializable
    public void limpiar() {
        extendtime();
        elemento = new  EngQuestion();
        edit=false;
        setEncontrarRepetido(false);
        descripcion = null;
    }

    @Override//metodo generado por implements Serializable
    public void actualizar() {
        extendtime();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        Map params = externalContext.getRequestParameterMap();            
        users = (String) params.get("user");
        HttpSession session = SessionBean.getSession();
        users=(String) session.getAttribute("username");        
        Date fechaD = new Date();
        
        if(descripcion.contains("?")){
            elemento.setQueDescription(descripcion);
        }
        else {
            elemento.setQueDescription(descripcion + "?");
        }
        
        elemento.setQueUserUpd(users);
        elemento.setQueDateUpd(fechaD);
        engQuestionFacade.edit(elemento);
        listado = engQuestionFacade.findAll();
        elemento = new  EngQuestion();
        edit=false;
    }

    @Override//metodo generado por implements Serializable
    public void agregar() {
        extendtime();//extiende el tiempo
        
        setEncontrarRepetido(false);
        
         List<EngQuestion> otroEliminar2 = listado;
        for (EngQuestion lis2 : otroEliminar2) {
            if (lis2.getQueName().equals(elemento.getQueName()) || lis2.getQueDescription().equals(elemento.getQueDescription())) {
                setEncontrarRepetido(true);
                break;
            }
        }
        
        if (!isEncontrarRepetido()) {
            FacesContext facesContext2 = FacesContext.getCurrentInstance();
            ExternalContext externalContext = facesContext2.getExternalContext();
            Map params2 = externalContext.getRequestParameterMap();            
            users = (String) params2.get("user");
            HttpSession sessionE = SessionBean.getSession();
            users=(String) sessionE.getAttribute("username");
            Date fechaDD = new Date();
            elemento.setQueDescription(descripcion + "?");
            elemento.setQueUserIns(users);
            elemento.setQueDateIns(fechaDD);
            engQuestionFacade.create(elemento);
            listado = engQuestionFacade.findAll();
            elemento = new EngQuestion();
         }
         else {
             FacesContext.getCurrentInstance().validationFailed();
         }
    }
    
    public void eliminarElm(String id){
        extendtime();
        try {
            BigDecimal idBig = new BigDecimal(id);
            elemento=engQuestionFacade.find(idBig);
                
            setpCount(engQuestionFacade.existeEnDamageQue(elemento.getQueId()));
                        
            if (getpCount() == 0) {                 
                eliminar(elemento);
                listado = engQuestionFacade.findAll();
                elemento = new EngQuestion();
            } else {
                FacesContext.getCurrentInstance().validationFailed();
            }           
        } catch (Exception e) {
            Logger.getLogger(EngQuestionBean.class.getName()).log(Level.SEVERE, null, e);
            FacesContext.getCurrentInstance().validationFailed();
        }
    } 
            

    @Override//metodo generado por implements Serializable
    public void eliminar(EngQuestion elem) {
        engQuestionFacade.remove(elem);
        
    }

    @Override//metodo generado por implements Serializable
    EngQuestion nuevoElemento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getIdQuestion() {//get y set de variable
        return idQuestion;
    }

    public void setIdQuestion(String idQuestion) {//get y set de variable
        this.idQuestion = idQuestion;
    }
    
    public boolean isEncontrarRepetido() {//get y set de variable
        return encontrarRepetido;
    }

    public void setEncontrarRepetido(boolean encontrarRepetido) {//get y set de variable
        this.encontrarRepetido = encontrarRepetido;
    }
    
    public int getpCount() {//get y set de variable
        return pCount;
    }

    public void setpCount(int pCount) {//get y set de variable
        this.pCount = pCount;
    }
    
    public String getDescripcion() {//get y set de variable
        return descripcion;
    }

    public void setDescripcion(String descripcion) {//get y set de variable
        this.descripcion = descripcion;
    }
}
