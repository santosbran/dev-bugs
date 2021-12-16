 // To change this license header, choose License Headers in Project Properties.
 // To change this template file, choose Tools | Templates
 // and open the template in the editor.
package com.aecas.managed;// paquete manage

import com.aeroman.aees.entities.EngEoStatus;// importacion de clase
import com.aeroman.aees.facades.EngEoStatusFacade;// importacion de clase
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
@ManagedBean(name = "engEoStatus")
@ViewScoped //tipo de clase
//clase ContAtasBean con extends al crud
public class EngEoStatusBean extends CrudBean<EngEoStatus> implements Serializable {
    
    @EJB
    private EngEoStatusFacade engEoStatusFacade;//declaracion de clases Facade
    private String idalert1;//declaracion de variable
    
    //metodo generado por implements Serializable
    @Override
    //metodo constructor
    @PostConstruct
    public void init() {     
        elemento = new EngEoStatus ();
        listado = engEoStatusFacade.findAll();   
    }

    @Override
    public void limpiar() {   
        extendtime();
        this.elemento = new EngEoStatus();
        edit = false;
    }

    @Override
    public void actualizar() {
        extendtime();
        if (engEoStatusFacade.find(elemento.getStsEoCod()) != null){
            engEoStatusFacade.edit(elemento);
            elemento = new EngEoStatus();
            this.edit = false;
        } else {
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El elemento que esta tratando de editar no existe en la base de datos"));
        }
    }

    @Override
    public void agregar() {
        extendtime();
        if (engEoStatusFacade.find(elemento.getStsEoCod()) != null){
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El identificador unico se encuentra repetido"));
        } else {
            engEoStatusFacade.create(elemento);
            listado.add(elemento);
            elemento = new EngEoStatus();
        }
    }

    @Override
    public void eliminar(EngEoStatus elemento) {
        extendtime();
        if (engEoStatusFacade.find(elemento.getStsEoCod()) != null){
            engEoStatusFacade.remove(elemento);
            listado.remove(elemento);
        }
    }
    public void delete(String id) {
        extendtime();
        elemento = engEoStatusFacade.find(id);
        eliminar(elemento);
        limpiar();
    }

    @Override
    public EngEoStatus nuevoElemento() {
        return new EngEoStatus ();
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
