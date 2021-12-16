
 // To change this license header, choose License Headers in Project Properties.
 // To change this template file, choose Tools | Templates
 // and open the template in the editor.
 
package com.aecas.managed;// paquete manage

import com.aeroman.aees.entities.ContFleetsVw;// importacion de clase
import com.aeroman.aees.facades.ContFleetsVwFacade;// importacion de clase
import java.io.Serializable;// libreria Serializable
import java.util.ArrayList;// libreria ArrayList
import javax.annotation.PostConstruct;// libreria PostConstruct
import javax.ejb.EJB;// libreria EJB
import javax.faces.bean.ManagedBean;// libreria ManagedBean
import javax.faces.bean.ViewScoped;// libreria ViewScoped

/**
 *
 * @author ACTIVA_03
 */
//nombre de clase en mageBean
@ManagedBean(name = "countFleetVwBean")
@ViewScoped //tipo de clase
//clase ContAtasBean con extends al crud
public class CountFleetVwBean extends CrudBean<ContFleetsVw> implements Serializable {
    
    @EJB 
    private ContFleetsVwFacade contFacaVW; //declaracion de clases Facade
    //metodo generado por implements Serializable
    @Override
    //metodo constructor
    @PostConstruct
    public void init() {
        elemento = new ContFleetsVw();
        listado= contFacaVW.findAll();
        
    }
    //metodo generado por implements Serializable
    @Override
    void limpiar() {
    listado = new ArrayList<>();
    }
//metodo generado por implements Serializable
    @Override
    void actualizar() {
        listado2 = new ArrayList<>();
    }
//metodo generado por implements Serializable
    @Override
    void agregar() {
        listado3 = new ArrayList<>();
    }
//metodo generado por implements Serializable
    @Override
    void eliminar(ContFleetsVw elemento) {
         listadoEng.add(elemento);
    
    }
//metodo generado por implements Serializable
    @Override
    ContFleetsVw nuevoElemento() {
        listadoEng = new ArrayList<>();
        return elemento;
    }
    
    
}


