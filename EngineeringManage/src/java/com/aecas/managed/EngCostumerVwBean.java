
 //* To change this license header, choose License Headers in Project Properties.
 //* To change this template file, choose Tools | Templates
 //* and open the template in the editor.

package com.aecas.managed;// paquete manage

import com.aeroman.aees.entities.EngCustomerVw;// importacion de clase
import com.aeroman.aees.facades.EngCustomerVwFacade;// importacion de clase
import java.io.Serializable;// libreria Serializable
import javax.annotation.PostConstruct;// libreria PostConstruct
import javax.ejb.EJB;// libreria EJB
import javax.faces.bean.ManagedBean;// libreria ManagedBean
import javax.faces.view.ViewScoped;// libreria ViewScoped

/**
 *
 * @author ACTIVA_03
 */
//nombre de clase en mageBean
@ManagedBean(name = "engCostumerVwBean")
@ViewScoped//tipo de clase
//clase ContAtasBean con extends al crud
public class EngCostumerVwBean extends CrudBean<EngCustomerVw> implements Serializable {
    @EJB 
    private EngCustomerVwFacade costumerFacade;//declaracion de clases Facade
    /**
     * Creates a new instance of EngCostumerVwBean
     */
    //metodo costructor Super
    public EngCostumerVwBean() {
        super();
    }

    //metodo generado por implements Serializable
    @Override
    //metodo constructor
    @PostConstruct
    public void init() {
        elemento = new EngCustomerVw();//inicializa el elemento
        listado = costumerFacade.findAll();// llena el listado
        
    }
    //metodo generado por implements Serializable
    @Override
    EngCustomerVw nuevoElemento() {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }
    //metodo generado por implements Serializable
    @Override
    void actualizar() {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }
//metodo generado por implements Serializable
    @Override
    void agregar() {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }
    //metodo generado por implements Serializable
    @Override
    void limpiar() {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }
//metodo generado por implements Serializable
    @Override
    void eliminar(EngCustomerVw elemento) {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }
    

    
    
}

