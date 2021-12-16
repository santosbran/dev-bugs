
// To change this license header, choose License Headers in Project Properties.
// To change this template file, choose Tools | Templates
// and open the template in the editor.

package com.aecas.managed;// paquete manage


import com.aeroman.aees.entities.EngTasksByFleetVw;// importacion de clase
import com.aeroman.aees.facades.EngTasksByFleetVwFacade;// importacion de clase
import java.io.Serializable;// libreria Serializable
import java.util.ArrayList;// libreria ArrayList
import javax.annotation.PostConstruct;// libreria PostConstruct
import javax.ejb.EJB;// libreria EJB
import javax.faces.bean.ManagedBean;// libreria ManagedBean
import javax.faces.bean.ViewScoped;// libreria ViewScoped

/**
 *
 * @author Usuario
 */
  //nombre de clase en mageBean
@ManagedBean(name = "flotasManagerBean")
@ViewScoped//tipo de clase
//clase FlotasManagerBean con extends al crud
public class FlotasManagerBean extends CrudBean<EngTasksByFleetVw> implements Serializable{
    
    @EJB
    private EngTasksByFleetVwFacade managerflotasfacade;//declaracion de clases Facade
    
    @Override//metodo generado por implements Serializable
    @PostConstruct//metodo constructor
    public void init() {
       elemento = new EngTasksByFleetVw();
       listado=managerflotasfacade.findAll();
        
    }

    @Override//metodo generado por implements Serializable
    void limpiar() {
        listado3 = new ArrayList<>();
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override//metodo generado por implements Serializable
    void actualizar() {
        listado2 = new ArrayList<>(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override//metodo generado por implements Serializable
    void agregar() {
        listado = new ArrayList<>();
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override//metodo generado por implements Serializable
    void eliminar(EngTasksByFleetVw elemento) {
        managerflotasfacade.remove(elemento); //To change body of generated methods, choose Tools | Templates.
    }

    @Override//metodo generado por implements Serializable
    EngTasksByFleetVw nuevoElemento() {
        managerflotasfacade.create(elemento); //To change body of generated methods, choose Tools | Templates.
        return elemento;
    }

    
    
}
