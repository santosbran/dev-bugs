
 // To change this license header, choose License Headers in Project Properties.
 // To change this template file, choose Tools | Templates
 // and open the template in the editor.

package com.aecas.managed;// paquete manage
import java.io.Serializable;// libreria Serializable
import com.aeroman.aees.entities.EngCatActividades;// importacion de clase
import com.aeroman.aees.facades.EngCatActividadesFacade;// importacion de clase
import javax.annotation.PostConstruct;// libreria PostConstruct
import javax.ejb.EJB;// libreria EJB
import javax.faces.application.FacesMessage;// libreria FacesMessage
import javax.faces.bean.ManagedBean;// libreria ManagedBean
import javax.faces.context.FacesContext;// libreria FacesContext
import javax.faces.bean.ViewScoped;// libreria ViewScoped
import java.math.BigDecimal;// libreria BigDecimal

/**
 *
 * @author Usuario
 */
//nombre de clase en mageBean
@ManagedBean (name= "engActivity")
@ViewScoped //tipo de clase
//clase ContAtasBean con extends al crud
public class EngActivityBean extends CrudBean<EngCatActividades> implements Serializable {

    @EJB
    private EngCatActividadesFacade engActivityFacade;//declaracion de clases Facade
    private String idalert1;//declaracion de variable
    
    //metodo generado por implements Serializable
    @Override
    //metodo constructor
    @PostConstruct
    public void init() {
      elemento = new EngCatActividades ();// iicializa el elemento
        listado = engActivityFacade.findAll();   //llena la lista de actividades
    }
//metodo generado por implements Serializable limpia el elemento y otras variable
    @Override
    public void limpiar() {
        extendtime();//rxtirnfr rl tiempo
         this.elemento = new EngCatActividades();// inicializa el elemento
        edit = false;//asigna falso a la variable
    }
//metodo generado por implements Serializable
    @Override
    public void actualizar() {
        extendtime();//etiende el tiempo de sesion actualiza en la bd
        if (engActivityFacade.find(elemento.getActId()) != null){//evalua si existe en la base de datos 
            engActivityFacade.edit(elemento);//actualiza el elemento en la base de datos
            elemento = new EngCatActividades();//inicializa el elemento
            this.edit = false; //asigna falso a la variable edit
        } else {
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El elemento que esta tratando de editar no existe en la base de datos"));//devuelve error que no existe
        }
    }
//metodo generado por implements Serializable actualiza en la bd
    @Override
    public void agregar() {
        extendtime();//etiende el tiempo de sesion 
          if (engActivityFacade.find(elemento.getActId()) != null){//evalua si existe en la base de datos 
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El identificador unico se encuentra repetido"));//devuelve error que si existe
        } else {
            engActivityFacade.create(elemento);//crea el elemento en la BD
            listado.add(elemento);//agrega el elemento a listado
            elemento = new EngCatActividades();//inicializa el elemento
        }
    }
//metodo generado por implements Serializable elimina de la BD
    @Override
    public void eliminar(EngCatActividades elemento) {
        extendtime();//etiende el tiempo de sesion 
         if (engActivityFacade.find(elemento.getActId()) != null){//evalua si existe en la base de datos 
            engActivityFacade.remove(elemento);//elimina el elemento de la base de datos
            listado.remove(elemento);//remueve de la lista el elemento
        }
    }
    //metodo que se ejecuta de la vista para eliminar
    public void delete(String id) {
        extendtime();//etiende el tiempo de sesion
        BigDecimal ele = new BigDecimal(id);//declara y asigana variable big decimal
        elemento = engActivityFacade.find(ele);//asigna al elemento
        eliminar(elemento);//llama al metodo de elimina
        limpiar();//llama al metodo de limpiar
    }
//metodo que se ejecuta de la vista para eliminar
    @Override
    public EngCatActividades nuevoElemento() {
        return new EngCatActividades ();
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
