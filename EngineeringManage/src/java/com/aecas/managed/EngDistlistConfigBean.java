 // To change this license header, choose License Headers in Project Properties.
 // To change this template file, choose Tools | Templates
 // and open the template in the editor.
package com.aecas.managed;// paquete manage

import com.aeroman.aees.entities.EngDistlistConfig;// importacion de clase
import com.aeroman.aees.facades.EngDistlistConfigFacade;// importacion de clase
import java.io.Serializable;// libreria Serializable
import javax.annotation.PostConstruct;// libreria PostConstruct
import javax.ejb.EJB;// libreria EJB
import javax.faces.application.FacesMessage;// libreria FacesMessage
import javax.faces.bean.ManagedBean;// libreria ManagedBean
import javax.faces.bean.ViewScoped;// libreria ViewScoped
import javax.faces.context.FacesContext;// libreria FacesContext

/**
 *
 * @author Usuario
 */
//nombre de clase en mageBean
@ManagedBean(name= "engDistlistConfig")
@ViewScoped //tipo de clase
//clase ContAtasBean con extends al crud
public class EngDistlistConfigBean extends CrudBean<EngDistlistConfig> implements Serializable{    
    
    @EJB
    private EngDistlistConfigFacade engDistlistConfigFacade;//declaracion de clases Facade
           
    //metodo generado por implements Serializable
    @Override
    //metodo constructor
    @PostConstruct
    public void init(){     
        elemento = new EngDistlistConfig ();
        listado = engDistlistConfigFacade.findAll();        
    }

    @Override
    public void limpiar() {
        extendtime();
        this.elemento = new EngDistlistConfig();
        edit = false;
    }

    @Override
    public void actualizar() {
        extendtime();
        if (engDistlistConfigFacade.find(elemento.getDlcId()) != null){
            engDistlistConfigFacade.edit(elemento);
            elemento = new EngDistlistConfig();
            this.edit = false;
        } else {
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El elemento que esta tratando de editar no existe en la base de datos"));
        }
    }

    @Override
    public void agregar() {
        extendtime();
        if (engDistlistConfigFacade.find(elemento.getDlcId()) != null){
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El identificador unico se encuentra repetido"));
        } else {
            engDistlistConfigFacade.create(elemento);
            listado.add(elemento);
            elemento = new EngDistlistConfig();
        }
    }

    @Override
    public void eliminar(EngDistlistConfig elemento) {
        extendtime();
        if (engDistlistConfigFacade.find(elemento.getDlcId()) != null){
            engDistlistConfigFacade.remove(elemento);
            listado.remove(elemento);
        }
    }
//metodo generado por implements Serializable
    @Override
    public EngDistlistConfig nuevoElemento() {
        return new EngDistlistConfig();
    }
    
}
