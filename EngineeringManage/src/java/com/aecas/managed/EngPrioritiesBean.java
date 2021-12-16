
 // To change this license header, choose License Headers in Project Properties.
 // To change this template file, choose Tools | Templates
// and open the template in the editor.

package com.aecas.managed;// paquete manage

import com.aeroman.aees.entities.EngPriorities;// importacion de clase
import com.aeroman.aees.facades.EngPrioritiesFacade;// importacion de clase
import java.io.Serializable;// libreria Serializable
import javax.annotation.PostConstruct;// libreria PostConstruct
import javax.ejb.EJB;// libreria EJB
import javax.faces.bean.ManagedBean;// libreria ManagedBean
import javax.faces.context.FacesContext;// libreria FacesContext
import javax.faces.bean.ViewScoped;// libreria ViewScoped
import java.util.ArrayList;// libreria ArrayList
import java.util.List;// libreria List
/**
 *
 * @author Usuario
 */
//nombre de clase en mageBean
@ManagedBean(name = "engPriorities")
@ViewScoped//tipo de clase
//clase EngPrioritiesBean con extends al crud
public class EngPrioritiesBean extends CrudBean<EngPriorities> implements Serializable{
    
    @EJB
    private EngPrioritiesFacade engPrioritiesFacade;//declaracion de clases Facade
    private String idalert1;//declaracion de variable
    transient List<String> priorities = new ArrayList();//declaracion de variable
    
    @Override //metodo generado por implements Serializable
    @PostConstruct //metodo constructor
    public void init() {        
        elemento = new EngPriorities ();
        listado = engPrioritiesFacade.findAll();        
    }

    @Override//metodo generado por implements Serializable
    public void limpiar() {
        extendtime();
        this.elemento = new EngPriorities();
        edit = false;
    }

    @Override//metodo generado por implements Serializable
    public void actualizar() {
        extendtime();
        if (engPrioritiesFacade.find(elemento.getPriCod()) != null){
            engPrioritiesFacade.edit(elemento);
            elemento = new EngPriorities();
            this.edit = false;
        } else {
            FacesContext.getCurrentInstance().validationFailed();
        }
    }

    @Override//metodo generado por implements Serializable
    public void agregar() {
        extendtime();
        if (engPrioritiesFacade.find(elemento.getPriCod()) != null){
            FacesContext.getCurrentInstance().validationFailed();
        } else {
            engPrioritiesFacade.create(elemento);
            listado.add(elemento);
            elemento = new EngPriorities();
        }
    }

    @Override//metodo generado por implements Serializable
    public void eliminar(EngPriorities elemento) {
        extendtime();
        if (engPrioritiesFacade.find(elemento.getPriCod()) != null){
            engPrioritiesFacade.remove(elemento);
            listado.remove(elemento);
        }
    }
    public void delete(String id) {
        extendtime();
        Short ele = new Short(id);
        elemento = engPrioritiesFacade.find(ele);
        eliminar(elemento);
        limpiar();
    }

    @Override//metodo generado por implements Serializable
    public EngPriorities nuevoElemento() {
        return new EngPriorities();
    }
    
    
	public List<String> getPriorities() {//get y set de variable
            extendtime();
        priorities = new ArrayList<>();
        for (EngPriorities listado1 : listado) {
            if(!priorities.contains("\""+listado1.getPriCod()+"\"")){
                priorities.add("\""+listado1.getPriCod()+"\"");
            }
        }
        return priorities;
    }

    public void setPriorities(List<String> priorities) {//get y set de variable
        this.priorities = priorities;
    }

    public String getIdalert1() {//get y set de variable
        return idalert1;
    }

    public void setIdalert1(String idalert1) {//get y set de variable
        this.idalert1 = idalert1;
    }
    
 }
