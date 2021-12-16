
 // To change this license header, choose License Headers in Project Properties.
// To change this template file, choose Tools | Templates
// and open the template in the editor.

package com.aecas.managed; // paquete manage

import com.aeroman.aees.entities.EngEoPrefixes;// importacion de clase
import com.aeroman.aees.facades.EngEoPrefixesFacade;// importacion de clase
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
 * @author SAPLIC05
 */
//nombre de clase en mageBean
@ManagedBean (name="engPrefixes")
@ViewScoped//tipo de clase
//clase EngPrefixesBean con extends al crud
public class EngPrefixesBean extends CrudBean<EngEoPrefixes> implements Serializable{

    @EJB
    private EngEoPrefixesFacade engPrefixesFacade;//declaracion de clases Facade
    private String idalert1;//declaracion de variable
    transient List<String> preefixes = new ArrayList();//declaracion de variable
    @Override//metodo generado por implements Serializable
    @PostConstruct//metodo constructor
    public void init() {
        elemento = new EngEoPrefixes();
        listado = engPrefixesFacade.findAll();
    }

    @Override//metodo generado por implements Serializable
    public void limpiar() {
        extendtime();
        this.elemento = new EngEoPrefixes();
        edit = false;
    }

    @Override//metodo generado por implements Serializable
    public void actualizar() {
        extendtime();
        if (engPrefixesFacade.find(elemento.getPreCod()) != null){
            engPrefixesFacade.edit(elemento);
            elemento = new EngEoPrefixes();
            this.edit = false;
        } else {
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El elemento que esta tratando de editar no existe en la base de datos"));
        }
    }

    @Override//metodo generado por implements Serializable
    public void agregar() {
        extendtime();
        if (engPrefixesFacade.find(elemento.getPreCod()) != null){
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El identificador unico se encuentra repetido"));
        } else {
            engPrefixesFacade.create(elemento);
            listado.add(elemento);
            elemento = new EngEoPrefixes();
        }
    }

    @Override//metodo generado por implements Serializable
    public void eliminar(EngEoPrefixes elemento) {
        extendtime();
        if (engPrefixesFacade.find(elemento.getPreCod()) != null){
            engPrefixesFacade.remove(elemento);
            listado.remove(elemento);
        }
    }
    public void delete(String id) {
        extendtime();
        elemento = engPrefixesFacade.find(id);
        eliminar(elemento);
        limpiar();
    }

    @Override
    public EngEoPrefixes nuevoElemento() {//metodo generado por implements Serializable
        return new EngEoPrefixes();
    }
    

    public List<String> getPreefixes() {//get y set de variable
        extendtime();
        preefixes.clear();
        for (EngEoPrefixes listado1 : listado) {
            if (!preefixes.contains("\"" + listado1.getPreCod() + "\"")) {
                preefixes.add("\"" + listado1.getPreCod() + "\"");
            }
        }
        return preefixes;
    }

    public void setPreefixes(List<String> preefixes) {//get y set de variable
        this.preefixes = preefixes;
    }

    public String getIdalert1() {//get y set de variable
        return idalert1;
    }

    public void setIdalert1(String idalert1) {//get y set de variable
        this.idalert1 = idalert1;
    }
    
}