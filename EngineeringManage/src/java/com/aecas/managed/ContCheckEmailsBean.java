
 //To change this license header, choose License Headers in Project Properties.
 // To change this template file, choose Tools | Templates
 // and open the template in the editor.

package com.aecas.managed;// paquete manage

import com.aeroman.aees.entities.grant.ContCheckEmails;// importacion de clase
import com.aeroman.aees.facades.grant.ContCheckEmailsFacade;// importacion de clase
import java.io.Serializable;// libreria Serializable
import java.util.ArrayList;
import java.util.List;
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
@ManagedBean (name="contCheckEmails")
@ViewScoped//tipo de clase
//clase ContAtasBean con extends al crud
public class ContCheckEmailsBean extends CrudBean<ContCheckEmails> implements Serializable {

    @EJB
    private ContCheckEmailsFacade contCheckEmailsFacade;//declaracion de clases Facade
    //metodo generado por implements Serializable    
    @Override
    //metodo constructor
    @PostConstruct
    public void init() {
        elemento = new ContCheckEmails();
        //listado = contCheckEmailsFacade.findAll();
        listado = new ArrayList<>();
    }
//metodo generado por implements Serializable limpia metodos y variables
    @Override
    public void limpiar() {
        extendtime();
        this.elemento = new ContCheckEmails();
        edit = false;
    }
//metodo generado por implements Serializable actualiza el elemento en la BD
    @Override
    public void actualizar() {
        extendtime();
        if (contCheckEmailsFacade.find(elemento.getContCheckEmailsId()) != null){
            contCheckEmailsFacade.edit(elemento);
            elemento = new ContCheckEmails();
            this.edit = false;
        } else {
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El elemento que esta tratando de editar no existe en la base de datos"));
        }
    }
//metodo generado por implements Serializable agrega el elemento BD
    @Override
    public void agregar() {
        extendtime();
         if (contCheckEmailsFacade.find(elemento.getContCheckEmailsId()) != null){
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El identificador unico se encuentra repetido"));
        } else {
            contCheckEmailsFacade.create(elemento);
            listado.add(elemento);
            elemento = new ContCheckEmails();
        }
    }
//metodo generado por implements Serializable elimina el elemento
   @Override
    void eliminar(ContCheckEmails elemento) {
        extendtime();
         if (contCheckEmailsFacade.find(elemento.getContCheckEmailsId()) != null){
            contCheckEmailsFacade.remove(elemento);
            listado.remove(elemento);
        }
    }
//metodo generado por implements Serializable     
   @Override
    public ContCheckEmails nuevoElemento() {
       return new ContCheckEmails ();
    }
     
    }

    
    

