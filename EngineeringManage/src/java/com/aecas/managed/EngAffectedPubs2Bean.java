package com.aecas.managed; // paquete manage

//
 // To change this license header, choose License Headers in Project Properties.
 // To change this template file, choose Tools | Templates
 // and open the template in the editor.
 //

import com.aees.session.SessionBean;// importacion de clase
import com.aeroman.aees.entities.EngAffectedPubs;// importacion de clase
import com.aeroman.aees.facades.EngAffectedPubsFacade;// importacion de clase
import com.aeroman.aees.facades.Sequences;// importacion de clase
import java.io.Serializable;// libreria Serializable
import java.util.Calendar;// libreria Calendar
import java.util.GregorianCalendar;// libreria GregorianCalendar
import javax.annotation.PostConstruct;// libreria PostConstruct
import javax.ejb.EJB;// libreria EJB
import javax.faces.application.FacesMessage;// libreria FacesMessage
import javax.faces.bean.ManagedBean;// libreria ManagedBean
import javax.faces.bean.ViewScoped;// libreria ViewScoped
import javax.faces.context.FacesContext;// libreria FacesContext
import javax.servlet.http.HttpSession;// libreria HttpSession

/**
 *
 * @author ACTIVA_03
 */
//nombre de clase en mageBean
@ManagedBean(name = "engAffectedPubs2")
@ViewScoped //tipo de clase
//clase ContAtasBean con extends al crud
public class EngAffectedPubs2Bean extends CrudBean<EngAffectedPubs> implements Serializable {
   
    // Creates a new instance of EngAffectedPubs2
   
    @EJB 
    private EngAffectedPubsFacade engAffectedPubs2facade;//declaracion de clases Facade
    @EJB
    private Sequences seq;//declaracion de clases Facade
    
    //constructor super
    public EngAffectedPubs2Bean() {
        super();
    }

    //metodo generado por implements Serializable
    @Override
    //metodo constructor
    @PostConstruct
    void init() {
        elemento = new EngAffectedPubs();//inicializa elemento
        listado = engAffectedPubs2facade.findAll();//asigna a listado        
        }
//metodo generado por implements Serializable limpia elemento y otras variables
    @Override
    public void limpiar() {
        extendtime();//extiende tiempo de sesion
        elemento = new EngAffectedPubs(); //inicializa elemento
        edit=false;//asigna falso a variable
    }
//metodo que busca por id
    public void buscarlista(long ideo){
        extendtime();//extiende tiempo de sesion
        listado=engAffectedPubs2facade.findByeoid(ideo);  //asigna la busqueda a listado  
    }
//metodo generado por implements Serializable    
    @Override
    public  void actualizar() {
        extendtime();//extiende tiempo de sesion
       if(engAffectedPubs2facade.find(elemento.getPubId()) != null){//verifica si existe 
           HttpSession session = SessionBean.getSession();
           elemento.setPubUserUpd((String) session.getAttribute("username"));//asigna usuario 
           Calendar fechaUp = new GregorianCalendar();//asigna fecha
           elemento.setPubDateUpd(fechaUp.getTime());//asigna fecha
           engAffectedPubs2facade.edit(elemento);//actualiza en bd
           elemento= new EngAffectedPubs();//inicializa el elemento
           this.edit= false;//asigna falso a edit
       }else{
            FacesContext.getCurrentInstance().validationFailed();//captura error
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El elemento que esta tratnado de editar no existe en la base de datos"));//manda error si existe
       
       }
        
        
    }
//metodo generado por implements Serializable  agrega a la BD
    @Override
    public void agregar() {
        extendtime();//extiende tiempo de sesion            
        elemento.setPubId(seq.getLastID());//agrega el id
        if (engAffectedPubs2facade.find(elemento.getPubId())!= null) {//evalua si existe
            FacesContext.getCurrentInstance().validationFailed();//captura el error
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El elemento que esta tratnado de editar no existe en la base de datos"));//manda error en la vista
            
        }else{//si no 
            
            HttpSession session = SessionBean.getSession();
            elemento.setPubUserIns((String) session.getAttribute("username"));//captura usuario logueado
            
            Calendar fechaUp = new GregorianCalendar();//asigna fecha a variable
            elemento.setPubDateIns(fechaUp.getTime());//asigna la variable a fecha
            engAffectedPubs2facade.create(elemento);//crea elemento en la BD
            listado.add(elemento);//agrega elemento a la lista
            elemento= new EngAffectedPubs();    //inicializa elemento
        }
    }
//metodo generado por implements Serializable  limpia el elemento y otras variables
    @Override
    public void eliminar(EngAffectedPubs elemento) {
        extendtime();//extiende tiempo de sesion 
        EngAffectedPubs element = elemento;// asigna element al elemento
       if (engAffectedPubs2facade.find(element.getPubId()) != null){//evalua si existe
            engAffectedPubs2facade.remove(element);//elimina el elemento de la base de datos
            listado.remove(element);//remueve el elemento de la lista
            element= new EngAffectedPubs();//inicializa la variable element
            element.setPubId(seq.getLastID());//asigna id a pubId
       }
    }
//metodo generado por implements Serializable
    @Override
    EngAffectedPubs nuevoElemento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
