
 // To change this license header, choose License Headers in Project Properties.
 // To change this template file, choose Tools | Templates
 // and open the template in the editor.
 
package com.aecas.managed; // paquete manage
import java.io.Serializable;// libreria Serializable
import com.aeroman.aees.entities.EngEoActionTypes;// importacion de clase
import com.aeroman.aees.facades.EngEoActionTypesFacade;// importacion de clase
import javax.annotation.PostConstruct;// libreria Serializable
import javax.ejb.EJB;// libreria EJB
import javax.faces.application.FacesMessage;// libreria FacesMessage
import javax.faces.bean.ManagedBean;// libreria ManagedBean
import javax.faces.context.FacesContext;// libreria FacesContext
import javax.faces.bean.ViewScoped;// libreria ViewScoped
import java.util.ArrayList;// libreria ArrayList
import java.util.List;// libreria List
/**
 *
 * @author SAPLIC05
 */
//nombre de clase en mageBean
@ManagedBean (name= "engActionTypes")
@ViewScoped //tipo de clase
//clase ContAtasBean con extends al crud
public class EngActionTypesBean extends CrudBean<EngEoActionTypes> implements Serializable{

    @EJB
    private EngEoActionTypesFacade engActionTypesFacade;//declaracion de clases Facade
    private String idalert1; //declaracion de variable
    transient List<String> actionTypes = new ArrayList();//variable de lista
    
    //metodo generado por implements Serializable
    @Override
    //metodo constructor
    @PostConstruct
    public void init() {
         elemento = new EngEoActionTypes();//inicialaiza elemento
         listado=engActionTypesFacade.findAll();//llena el listado de las action
    }
//metodo generado por implements Serializable limpia el elemento y otras variables
    @Override
    public void limpiar() {
        extendtime();//extiende el tiempo de sesion
        this.elemento = new EngEoActionTypes();//inicializa el elemento
        edit = false;//asigna a falso edit
    }
//metodo generado por implements Serializable actualiza en la BD
    @Override
    public void actualizar() {
        extendtime();//extiende el tiempo de sesion
        if (engActionTypesFacade.find(elemento.getActCod()) != null){//evalua si existe en la base de datos
            engActionTypesFacade.edit(elemento);//edita el elemento en la base de datos
            elemento = new EngEoActionTypes();//inicializa el elemento
            this.edit = false;//asigna falso a edit
        } else {//captura posibles errores
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El elemento que esta tratando de editar no existe en la base de datos"));
        }
    }
//metodo generado por implements Serializable agrega a la BD
    @Override
    public void agregar() {
        extendtime();//estiende el tiempo de sesion
        if (engActionTypesFacade.find(elemento.getActCod()) != null){//evalua si existe en la bd
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El identificador unico se encuentra repetido"));//manda error si existe
        } else {// si no
            engActionTypesFacade.create(elemento);//crea el elemento
            listado.add(elemento);//agrega el elemento creado a la lista
            elemento = new EngEoActionTypes();//inicializa el elemento
        }
    }
//metodo generado por implements Serializable elimina el elmento de la bd
    @Override
    public void eliminar(EngEoActionTypes elemento) {
        extendtime();//extiende el teiempo de sesion
        if (engActionTypesFacade.find(elemento.getActCod()) != null){//evalua si existe en la base de datos
            engActionTypesFacade.remove(elemento);//elimina el elemento de la bd
            listado.remove(elemento);//elimina el elemento de la lista
        }
    }
    //metodo de eliminar segun id
    public void delete(String id) {
        extendtime();//extiende el tiempo de sesion
        elemento = engActionTypesFacade.find(id);// busca el id y lo asigna al elemento
        eliminar(elemento);//metodo de eliminar
        limpiar();//metodo de limpiar
    }
//metodo generado por implements Serializable
    @Override
    public EngEoActionTypes nuevoElemento() {
        return new EngEoActionTypes();
    }
    
    
    //get y set de variable
    public List<String> getActionTypes() {
        extendtime();
        actionTypes.clear();
        for (EngEoActionTypes listado1 : listado) {
            if (!actionTypes.contains("\"" + listado1.getActCod() + "\"")) {
                actionTypes.add("\"" + listado1.getActCod() + "\"");
            }
        }
        return actionTypes;
    }
//get y set de variable
    public void setActionTypes(List<String> actionTypes) {
        this.actionTypes = actionTypes;
    }
 //get y set de variable   
    public String getIdalert1() {
        return idalert1;
    }
//get y set de variable
    public void setIdalert1(String idalert1) {
        this.idalert1 = idalert1;
    }

    
}
