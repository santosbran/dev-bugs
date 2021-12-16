 // To change this license header, choose License Headers in Project Properties.
 // To change this template file, choose Tools | Templates
 // and open the template in the editor.
package com.aecas.managed;// paquete manage

import com.aeroman.aees.entities.grant.ContCheck;// importacion de clase
import com.aeroman.aees.facades.grant.ContCheckFacade;// importacion de clase
import java.io.Serializable;// libreria Serializable
import javax.annotation.PostConstruct;// libreria PostConstruct
import javax.ejb.EJB;// libreria EJB
import javax.faces.application.FacesMessage;// libreria FacesMessage
import javax.faces.bean.ManagedBean;// libreria ManagedBean
import javax.faces.bean.ViewScoped;// libreria ViewScoped
import javax.faces.context.FacesContext;// libreria FacesContext

/**
 *
 * @author APLICATIVA_01
 */
//nombre de clase en mageBean
@ManagedBean(name = "engMatrizESRBean")
@ViewScoped //tipo de clase
//clase ContAtasBean con extends al crud
public class EngMatrizESRBean extends CrudBean<ContCheck> implements Serializable {

    private static final long serialVersionUID = 1L;//declaracion de variable

    @EJB
    private ContCheckFacade engMatrizESRFacade;//declaracion de clases Facade

    //metodo generado por implements Serializable
    @Override
    //metodo constructor
    @PostConstruct
    public void init() {
        elemento = new ContCheck();
        listado = engMatrizESRFacade.findAll();
    }
//metodo generado por implements Serializable
    @Override
    public void actualizar() {
        extendtime();
        if (engMatrizESRFacade.find(elemento.getContCheckId()) != null) {
            engMatrizESRFacade.edit(elemento);
            elemento = new ContCheck();
            this.edit = false;

        } else {
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El elemento que esta tratando de editar no existe en la base de datos"));
        }
    }
//metodo generado por implements Serializable
    @Override
    public void agregar() {
        extendtime();
        if (engMatrizESRFacade.find(elemento.getContCheckId()) != null) {
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El identificador unico se encuentra repetido"));
        } else {
            engMatrizESRFacade.create(elemento);
            listado.add(elemento);
            elemento = new ContCheck();
        }
    }
//metodo generado por implements Serializable
    @Override
    public void eliminar(ContCheck elemento) {
        extendtime();
        if (engMatrizESRFacade.find(elemento.getContCheckId()) != null) {
            engMatrizESRFacade.remove(elemento);
            listado.remove(elemento);
        }
    }
//metodo generado por implements Serializable
    @Override
    public ContCheck nuevoElemento() {
        return new ContCheck();
    }
//metodo generado por implements Serializable
    @Override
    public void limpiar() {
        extendtime();
        this.elemento = new ContCheck();
        edit = false;
    }

}
