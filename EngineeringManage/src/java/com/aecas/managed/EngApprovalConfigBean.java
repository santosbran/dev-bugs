
 // To change this license header, choose License Headers in Project Properties.
 // To change this template file, choose Tools | Templates
 // and open the template in the editor.

package com.aecas.managed; // paquete manage



import com.aeroman.aees.entities.EngApprovalConfig;// importacion de clase
import com.aeroman.aees.entities.EngWorkTypes;// importacion de clase
import com.aeroman.aees.facades.EngApprovalConfigFacade;// importacion de clase
import java.io.Serializable;// libreria Serializable
import javax.annotation.PostConstruct;// libreria PostConstruct
import javax.ejb.EJB;// libreria EJB
import javax.faces.application.FacesMessage;// libreria FacesMessage
import javax.faces.bean.ManagedBean;// libreria ManagedBean
import javax.faces.bean.ViewScoped;// libreria ViewScoped
import javax.faces.context.FacesContext;// libreria FacesContext

/**
 *
 * @author SAPLIC05
 */
//nombre de clase en mageBean
@ManagedBean (name= "engApprovalConfig")
@ViewScoped //tipo de clase
//clase ContAtasBean con extends al crud
public class EngApprovalConfigBean extends CrudBean<EngApprovalConfig> implements Serializable{
    
    @EJB
    private EngApprovalConfigFacade engApprovalConfigFacade;//declaracion de clases Facade

    private EngWorkTypes engWT;//declarion variable tipo clase
//get de variable
    public EngWorkTypes getEngWT() {
        return engWT;
    }
//ser de variable
    public void setEngWT(EngWorkTypes engWT) {
        this.engWT = engWT;
    }

    //metodo generado por implements Serializable
    @Override
    //metodo constructor
    @PostConstruct
    public void init(){
        elemento= new EngApprovalConfig();
        listado= engApprovalConfigFacade.findAll();
    }
//metodo generado por implements Serializable limpia el elemento y otras variables
    @Override
    public void limpiar() {
        extendtime();//extiende el tiempo de sesion
        this.elemento = new EngApprovalConfig();//inicializa el tiempo
        edit = false;//asigana falso a edit
    }
//metodo generado por implements Serializable actualiza en la BD
    @Override
    public void actualizar() {
        extendtime();//extiende el tiempo de sesion
        if (engApprovalConfigFacade.find(elemento.getAcfId()) != null){//verifica si existe
            engApprovalConfigFacade.edit(elemento);//edita el elemento en la bd
            elemento = new EngApprovalConfig();//inicializa el elemento
            this.edit = false;//asigna falso a edit
        } else {
            FacesContext.getCurrentInstance().validationFailed();//captura error 
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El elemento que esta tratando de editar no existe en la base de datos"));//manda el error
        }
    }
//metodo generado por implements Serializable agregar en la BD
    @Override
    public void agregar() {
        extendtime();//extiende el tiempo de sesion
        if (engApprovalConfigFacade.find(elemento.getAcfId()) != null){//verifica si existe
            FacesContext.getCurrentInstance().validationFailed();//captura error 
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El identificador unico se encuentra repetido"));//manda el error
        } else {
            engApprovalConfigFacade.create(elemento);//agrega en la base de datos
            listado.add(elemento);// agrega a la lista 
            elemento = new EngApprovalConfig();//inicializa el elemento
        }
    }
//metodo generado por implements Serializable eliminar en la BD
    @Override
    public void eliminar(EngApprovalConfig elemento) {
        extendtime();//extiende el tiempo de sesion
        if (engApprovalConfigFacade.find(elemento.getAcfId()) != null){//verifica si existe
            engApprovalConfigFacade.remove(elemento);//remueve de la base de datos
            listado.remove(elemento);//elimina el elemento de la BD
        }
    }
//metodo generado por implements Serializable
    @Override
    public EngApprovalConfig nuevoElemento() {
        return new EngApprovalConfig();
    }
    
}
