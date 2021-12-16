
 // To change this license header, choose License Headers in Project Properties.
 // To change this template file, choose Tools | Templates
 // and open the template in the editor.

package com.aecas.managed;// paquete manage

import com.aeroman.aees.entities.grant.ContFleets;// importacion de clase
import com.aeroman.aees.facades.grant.ContFleetsFacade;// importacion de clase
import java.io.Serializable;// libreria Serializable
import javax.annotation.PostConstruct;// libreria Serializable
import javax.ejb.EJB;// libreria Serializable
import javax.faces.application.FacesMessage;// libreria Serializable
import javax.faces.bean.ManagedBean;// libreria Serializable
import javax.faces.bean.ViewScoped;// libreria Serializable
import javax.faces.context.FacesContext;// libreria Serializable
import java.util.ArrayList;// libreria Serializable
import java.util.List;// libreria Serializable
/**
 *
 * @author Usuario
 */
//nombre de clase en mageBean
@ManagedBean(name="contFleets")
@ViewScoped//tipo de clase
//clase ContAtasBean con extends al crud
public class ContFleetsBean extends CrudBean<ContFleets> implements Serializable{    

    @EJB
    private ContFleetsFacade contFleetsFacade;//declaracion de clases Facade
    private List<String> flota = new ArrayList();//variable de lista
    //metodo generado por implements Serializable   
    @Override
     //metodo constructor
    @PostConstruct
    public void init() {
        elemento = new ContFleets();
        listado=contFleetsFacade.findAll();
        
    }
//metodo generado por implements Serializable  limpia el elmento
    @Override
    public void limpiar() {
        extendtime();
        this.elemento = new ContFleets();
        edit = false;
    }
//metodo generado por implements Serializable  actualiza elemento en la BD
    @Override
    public void actualizar() {
        extendtime();
        if (contFleetsFacade.find(elemento.getCodflt()) != null){
            contFleetsFacade.edit(elemento);
            elemento = new ContFleets();
            this.edit = false;
        } else {
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El elemento que esta tratando de editar no existe en la base de datos"));
        }
    }
//metodo generado por implements Serializable  agrega en BD
    @Override
    public void agregar() {
        extendtime();
       if (contFleetsFacade.find(elemento.getCodflt()) != null){
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El identificador unico se encuentra repetido"));
        } else {
            contFleetsFacade.create(elemento);
            listado.add(elemento);
            elemento = new ContFleets();
        }
    }
//metodo generado por implements Serializable  elimina el elemento de en la BD
    @Override
    public void eliminar(ContFleets elemento) {
        extendtime();
        if (contFleetsFacade.find(elemento.getCodflt()) != null){
            contFleetsFacade.remove(elemento);
            listado.remove(elemento);
        }
    }
//metodo generado por implements Serializable  
    @Override
    public ContFleets nuevoElemento() {
        return new ContFleets();  
    }
    
// get y set de variable
    public List<String> getFlota() {
        extendtime();
        flota = new ArrayList<>();
        for (ContFleets listado1 : listado) {
            if (!flota.contains("\"" + listado1.getCodflt() + "\"")) {
                flota.add("\"" + listado1.getCodflt() + "\"");
            }
        }
        return flota;
    }
// get y set de variable
    public void setFlota(List<String> flota) {
        this.flota = flota;
    }

}
