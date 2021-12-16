/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aecas.managed;// paquete manage


import com.aeroman.aees.entities.grant.ContAtas;// importacion de clase
import com.aeroman.aees.facades.grant.ContAtasFacade;// importacion de clase
import java.io.Serializable;// libreria seralizable
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
@ManagedBean( name = "contAtas")
@ViewScoped//tipo de clase
//clase ContAtasBean con extends al crud
public class ContAtasBean extends CrudBean<ContAtas> implements Serializable{    
    
    @EJB
    private ContAtasFacade contAtasFacade;//declaracion de clases Facade
    transient List<String> atascod = new ArrayList();//variable de lista
    transient List<String> atasdes = new ArrayList();//variable de lista
 //metodo generado por implements Serializable
    @Override
    //metodo constructor
    @PostConstruct
    public void init() {       
        elemento = new ContAtas ();
        listado = contAtasFacade.finAllOrder();
    }
 //metodo generado por implements Serializable el cual limpia el elemento y variables
    @Override
    public void limpiar() {
        extendtime();
        this.elemento=new ContAtas();
        edit= false;
    }
 //metodo generado por implements Serializable actualiza la ata
    @Override
    public void actualizar() {
        extendtime();
        if(contAtasFacade.find(elemento.getAtaCoduskill())!= null){
            contAtasFacade.edit(elemento);
            elemento= new ContAtas();
            this.edit=false;
        }else{
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El elemento que esta tratnado de editar no existe en la base de datos"));
        }
    }
 //metodo generado por implements Serializable agrega a la bd
    @Override
    public void agregar() {
        extendtime();
        if(contAtasFacade.find(elemento.getAtaCoduskill())!= null){
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El elemento que esta tratnado de editar no existe en la base de datos"));
        }else{
            contAtasFacade.create(elemento);
            listado.add(elemento);
            elemento= new ContAtas();            
        }
    }
 //metodo generado por implements Serializable elimina el elemento de la db
    @Override
    public void eliminar(ContAtas elemento) {
        extendtime();
        if (contAtasFacade.find(elemento.getAtaCoduskill()) != null){
        contAtasFacade.remove(elemento);
        listado.remove(elemento);
        }
    }
 //metodo generado por implements Serializable
    @Override   
    public ContAtas nuevoElemento() {
        extendtime();
        return new ContAtas(); 
    }
    
// get y set de variable
    public List<String> getAtascod() {
        extendtime();
        atascod.clear();
        for (ContAtas listado1 : listado) {
            if (!atascod.contains("\"" + listado1.getAtaNumata() + "\"")) {
                atascod.add("\"" + listado1.getAtaNumata() + "\"");
            }
        }
        return atascod;
    }
    
// get y set de variable
    public void setAtascod(List<String> atascod) {
        this.atascod = atascod;
    }
// get y set de variable
    public List<String> getAtasdes() {
        extendtime();
        atasdes.clear();
        for (ContAtas listado1 : listado) {
            if (!atasdes.contains("\"" + listado1.getAtaDescription()+ "\"")) {
                atasdes.add("\"" + listado1.getAtaDescription()+ "\"");
            }
        }
        return atasdes;
    }
    
// get y set de variable
    public void setAtasdes(List<String> atasdes) {
        this.atasdes = atasdes;
    }
    
   
    
}
