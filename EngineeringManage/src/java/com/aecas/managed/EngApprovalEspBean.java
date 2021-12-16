
 // To change this license header, choose License Headers in Project Properties.
 // To change this template file, choose Tools | Templates
 // and open the template in the editor.

package com.aecas.managed;// paquete manage

import com.aeroman.aees.entities.EngApprovalEsp;// importacion de clase
import com.aeroman.aees.facades.EngApprovalEspFacade;// importacion de clase
import java.io.Serializable;// libreria Serializable
import javax.annotation.PostConstruct;// libreria Serializable
import javax.ejb.EJB;// libreria Serializable
import javax.faces.application.FacesMessage;// libreria PostConstruct
import javax.faces.bean.ManagedBean;// libreria ManagedBean
import javax.faces.bean.ViewScoped;// libreria ViewScoped
import javax.faces.context.FacesContext;// libreria FacesContext

/**
 *
 * @author SAPLIC05
 */
//nombre de clase en mageBean
@ManagedBean (name= "engApprovalEsp")
@ViewScoped //tipo de clase
//clase ContAtasBean con extends al crud
public class EngApprovalEspBean extends CrudBean<EngApprovalEsp> implements Serializable{

    @EJB
    private EngApprovalEspFacade engApprovalEspFacade;//declaracion de clases Facade
    
    //metodo generado por implements Serializable
    @Override
    //metodo constructor
    @PostConstruct
    public void init() {
        elemento = new EngApprovalEsp();//inicializa el elemento
        listado=engApprovalEspFacade.findAll();//llena el listado
    }
//metodo generado por implements Serializable limpia el elemento y otras variables 
    @Override
    public void limpiar() {
        extendtime();//extiende el tiempo de sesion 
        this.elemento = new EngApprovalEsp();//inicia elemento 
        edit = false;//asigna falso a edit
    }
//metodo generado por implements Serializablelimpia actualiza en la BD
    @Override
    public void actualizar() {
        extendtime();//inicializa el elemento
        // ************************************Duda con getAspSpecialApp() o getAspApprovalOrder() *******
        if (engApprovalEspFacade.find(elemento.getAspSpecialApp()) != null){//verifica si existe
            engApprovalEspFacade.edit(elemento);//actualiza en la base de datos 
            elemento = new EngApprovalEsp();//enaliza el elemento
            this.edit = false;//asigna falso a edit
        } else {
            FacesContext.getCurrentInstance().validationFailed();//captura error 
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El elemento que esta tratando de editar no existe en la base de datos"));//manda el error
        }
    }
//metodo generado por implements Serializable agrega de la BD
    @Override
    public void agregar() {
        extendtime();//inicializa el elemento
        if (engApprovalEspFacade.find(elemento.getAspSpecialApp()) != null){//verifica si existe
            FacesContext.getCurrentInstance().validationFailed();//captura error 
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El identificador unico se encuentra repetido"));//manda el error
        } else {
            engApprovalEspFacade.create(elemento);//agrega a elemento de la BD
            listado.add(elemento);//agrega el elemento a la lista 
            elemento = new EngApprovalEsp();//inicializa el elemento
        }
    }
//metodo generado por implements Serializable elimina de la BD
    @Override
    public void eliminar(EngApprovalEsp elemento) {
        extendtime();//inicializa el elemento
        if (engApprovalEspFacade.find(elemento.getAspSpecialApp()) != null){//verifica si existe
            engApprovalEspFacade.remove(elemento);//elimina el elemento de la BD 
            listado.remove(elemento);//
        }
    }
//metodo generado por implements Serializable
    @Override
    public EngApprovalEsp nuevoElemento() {
     return new EngApprovalEsp();
    }
    
}
