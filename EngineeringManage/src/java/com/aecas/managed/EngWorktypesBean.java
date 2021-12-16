
// To change this license header, choose License Headers in Project Properties.
// To change this template file, choose Tools | Templates
// and open the template in the editor.

package com.aecas.managed;// paquete manage

import com.aeroman.aees.entities.EngWorkTypes;// importacion de clase
import com.aeroman.aees.facades.EngWorkTypesFacade;// importacion de clase
import java.io.Serializable;// libreria Serializable
import javax.annotation.PostConstruct;// libreria PostConstruct
import javax.ejb.EJB;// libreria EJB
import javax.faces.application.FacesMessage;// libreria FacesMessage
import javax.faces.bean.ManagedBean;// libreria ManagedBean
import javax.faces.bean.ViewScoped;// libreria ViewScoped
import javax.faces.context.FacesContext;// libreria FacesContext
import java.util.ArrayList;// libreria ArrayList
import java.util.List;// libreria List
/**
 *
 * @author Usuario
 */
 //nombre de clase en mageBean
@ManagedBean(name = "engWorktypes")
@ViewScoped //tipo de clase
//clase EngWorktypesBean con extends al crud
public class EngWorktypesBean extends CrudBean<EngWorkTypes> implements Serializable{
    
    private static final long serialVersionUID = 1L;  //declaracion de variable

    @EJB
    private EngWorkTypesFacade engWorktypesFacade;//declaracion de clases Facade
    private String idalert1;//declaracion de variable
    private List<String> workTipes = new ArrayList();//declaracion de variable
	
    @Override//metodo generado por implements Serializable
    @PostConstruct//metodo constructor
    public void init(){
        elemento = new EngWorkTypes();
        listado=engWorktypesFacade.findAll();
    }
    
    @Override //metodo generado por implements Serializable
    public void actualizar(){
        extendtime();//extiende el tiempo de sesion
        if (engWorktypesFacade.find(elemento.getWtyCod()) != null){
            engWorktypesFacade.edit(elemento);
            elemento = new EngWorkTypes();
            this.edit = false;
        } else {
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El elemento que esta tratando de editar no existe en la base de datos"));
        }
    }
    
    @Override //metodo generado por implements Serializable
    public void agregar(){
        extendtime();//extiende el tiempo de sesion
        if (engWorktypesFacade.find(elemento.getWtyCod()) != null){
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El identificador unico se encuentra repetido"));
        } else {
            engWorktypesFacade.create(elemento);
            listado.add(elemento);
            elemento = new EngWorkTypes();
        }
    }

    @Override //metodo generado por implements Serializable
    public void eliminar(EngWorkTypes elemento) {
        extendtime();//extiende el tiempo de sesion
        if (engWorktypesFacade.find(elemento.getWtyCod()) != null){
            engWorktypesFacade.remove(elemento);
            listado.remove(elemento);
        }
    }
    public void delete(String id) {
        extendtime();//extiende el tiempo de sesion
        elemento = engWorktypesFacade.find(id);
        eliminar(elemento);
        limpiar();
    }

    @Override //metodo generado por implements Serializable
    public EngWorkTypes nuevoElemento() {
        return new EngWorkTypes();
    }

    @Override //metodo generado por implements Serializable
    public void limpiar() {
        extendtime();//extiende el tiempo de sesion
        this.elemento = new EngWorkTypes();
        edit = false;
    }
    

    public List<String> getWorkTipes() {//get y set de variable
        extendtime();//extiende el tiempo de sesion
        workTipes.clear();
        for (EngWorkTypes listado1 : listado) {
            if (!workTipes.contains("\"" + listado1.getWtyCod() + "\"")) {
                workTipes.add("\"" + listado1.getWtyCod() + "\"");
            }
        }
        return workTipes;
    }

    public void setWorkTipes(List<String> workTipes) {//get y set de variable
        this.workTipes = workTipes;
    }

    public String getIdalert1() {//get y set de variable
        return idalert1;
    }

    public void setIdalert1(String idalert1) {//get y set de variable
        this.idalert1 = idalert1;
    }
    
}
