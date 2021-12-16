
// To change this license header, choose License Headers in Project Properties.
// To change this template file, choose Tools | Templates
// and open the template in the editor.

package com.aecas.managed;// paquete manage

import com.aeroman.aees.entities.EngOrderNotes;// importacion de clase
import com.aeroman.aees.facades.EngOrderNotesFacade;// importacion de clase
import java.io.Serializable;// libreria Serializable
import javax.annotation.PostConstruct;// libreria PostConstruct
import javax.ejb.EJB;// libreria EJB
import javax.faces.application.FacesMessage;// libreria FacesMessage
import javax.faces.bean.ManagedBean;// libreria ManagedBean
import javax.faces.context.FacesContext;// libreria FacesContext
import javax.faces.bean.ViewScoped;// libreria ViewScoped

/**
 *
 * @author Usuario
 */
  //nombre de clase en mageBean
@ManagedBean(name = "eosOrderNotesBean")
@ViewScoped //tipo de clase
//clase EosOrderNotesBean con extends al crud
public class EosOrderNotesBean extends CrudBean<EngOrderNotes> implements Serializable {
    
    @EJB
    private EngOrderNotesFacade eosOrderNotesFacade;//declaracion de clases Facade
    private String idalert1; //declaracion de variable
	
    @Override//metodo generado por implements Serializable
    @PostConstruct//metodo constructor
    public void init() {
         elemento = new EngOrderNotes ();
        listado = eosOrderNotesFacade.findAll(); 
    }

    @Override//metodo generado por implements Serializable
    public void limpiar() {
        extendtime();//extiende el tiempo de sesion
        this.elemento = new EngOrderNotes();
        edit = false;
    }

    @Override//metodo generado por implements Serializable
    public void actualizar() {
        extendtime();//extiende el tiempo de sesion
          if (eosOrderNotesFacade.find(elemento.getIdnot()) != null){
            eosOrderNotesFacade.edit(elemento);
            elemento = new EngOrderNotes();
            this.edit = false;
        } else {
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El elemento que esta tratando de editar no existe en la base de datos"));
        }
    }

    @Override//metodo generado por implements Serializable
    public void agregar() {
        extendtime();//extiende el tiempo de sesion
          if (eosOrderNotesFacade.find(elemento.getIdnot()) != null){
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El identificador unico se encuentra repetido"));
        } else {
            eosOrderNotesFacade.create(elemento);
            listado.add(elemento);
            elemento = new EngOrderNotes();
        } 
    }

    @Override//metodo generado por implements Serializable
    public void eliminar(EngOrderNotes elemento) {
        extendtime();//extiende el tiempo de sesion
        if (eosOrderNotesFacade.find(elemento.getIdnot()) != null){
            eosOrderNotesFacade.remove(elemento);
            listado.remove(elemento);
        }
    }
    public void delete(String id) {
        extendtime();//extiende el tiempo de sesion
        Short ele= new Short(id);
        elemento = eosOrderNotesFacade.find(ele);
        eliminar(elemento);
        
    }

    @Override//metodo generado por implements Serializable
    public EngOrderNotes nuevoElemento() {
        return new EngOrderNotes ();
    }

    public String getIdalert1() {//get y set de variable
        return idalert1;
    }

    public void setIdalert1(String idalert1) {//get y set de variable
        this.idalert1 = idalert1;
    }

   

   
    
}
