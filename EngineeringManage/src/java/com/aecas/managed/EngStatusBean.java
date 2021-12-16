
// To change this license header, choose License Headers in Project Properties.
// To change this template file, choose Tools | Templates
// and open the template in the editor.
 
package com.aecas.managed;// paquete manage

import com.aeroman.aees.entities.EngEaEstatus;// importacion de clase
import com.aeroman.aees.facades.EngEaEstatusFacade;// importacion de clase
import java.io.Serializable;// libreria Serializable
import javax.annotation.PostConstruct;// libreria PostConstruct
import javax.ejb.EJB;// libreria EJB
import javax.faces.application.FacesMessage;// libreria FacesMessage
import javax.faces.bean.ManagedBean;// libreria ManagedBean
import javax.faces.bean.ViewScoped;// libreria ViewScoped
import javax.faces.context.FacesContext;// libreria FacesContext

/**
 *
 * @author ACTIVA_03
 */
//nombre de clase en mageBean
@ManagedBean(name = "engEaStatusBean")
@ViewScoped//tipo de clase
//clase EngStatusBean con extends al crud
public class EngStatusBean extends CrudBean<EngEaEstatus>  implements Serializable{

    @EJB
    private EngEaEstatusFacade engEaEstatusFacade;//declaracion de clases Facade
    private String idalert1;//declaracion de variable
    
    @Override//metodo generado por implements Serializable
    @PostConstruct//metodo constructor
    public void init() {
       elemento = new EngEaEstatus();
       listado = engEaEstatusFacade.findAllEngEaEstatus();
    }
    
    public Object findSelect(String id){
        extendtime();//extiende el tiempo de sesion
        
        elemento = engEaEstatusFacade.find(id);
        
        return elemento;
    }
    
    @Override//metodo generado por implements Serializable
    public void limpiar() {
        extendtime();//extiende el tiempo de sesion
        this.elemento = new EngEaEstatus();
        edit = false;
    }

    @Override//metodo generado por implements Serializable
    public void actualizar() {
        extendtime();//extiende el tiempo de sesion
        if (engEaEstatusFacade.find(elemento.getEaeId()) != null){
            engEaEstatusFacade.edit(elemento);
            elemento = new EngEaEstatus();
            this.edit = false;
        } else {
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El elemento que esta tratando de editar no existe en la base de datos"));
        }
    }

    @Override//metodo generado por implements Serializable
    public void agregar() {
        extendtime();//extiende el tiempo de sesion
        if (engEaEstatusFacade.find(elemento.getEaeId()) != null){
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El identificador unico se encuentra repetido"));
        } else {
            engEaEstatusFacade.create(elemento);
            listado.add(elemento);
            elemento = new EngEaEstatus();
            limpiar();
        }
    }

    @Override//metodo generado por implements Serializable
    public void eliminar(EngEaEstatus elemento) {
        extendtime();//extiende el tiempo de sesion
        if (engEaEstatusFacade.find(elemento.getEaeId()) != null){
            engEaEstatusFacade.remove(elemento);
            listado.remove(elemento);
        }
    }
    public void delete(String id) {
        extendtime();//extiende el tiempo de sesion
        elemento = engEaEstatusFacade.find(id);
        eliminar(elemento);
        
    }

    @Override//metodo generado por implements Serializable
    public EngEaEstatus nuevoElemento() {
        return new EngEaEstatus();//To change body of generated methods, choose Tools | Templates.
    }

    public String getIdalert1() {//get y set de variable
        return idalert1;
    }

    public void setIdalert1(String idalert1) {//get y set de variable
        this.idalert1 = idalert1;
    }
    
    
    
}

