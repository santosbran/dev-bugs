/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aecas.managed;

import com.aeroman.aees.entities.EngAcRegistration;// importacion de clase
import java.io.Serializable;// libreria seralizable
import java.util.ArrayList;// libreria ArrayList
import javax.annotation.PostConstruct;// libreria PostConstruct
import javax.faces.bean.ManagedBean;// libreria ManagedBean
import javax.faces.bean.ViewScoped;// libreria ViewScoped

/**
 *
 * @author Usuario
 */
//nombre de clase en mageBean
@ManagedBean(name = "aircraftBean")
@ViewScoped //tipo de clase
//clase AircraftBean con extends al crud
public class AircraftBean extends CrudBean<EngAcRegistration> implements Serializable{
    
    private String notsupAir="Not supported yet.";//declaracion de variable
    //metodo generado por implements Serializable
    @Override
    //constructor de la clase
    @PostConstruct
    public void init() {
        elemento = new EngAcRegistration();
        listado=new ArrayList<>();
        listado2 = new ArrayList<>();
    }
    //metodo generado por implements Serializable
    @Override
    void agregar() {
        throw new UnsupportedOperationException(notsupAir); //To change body of generated methods, choose Tools | Templates.
    }
//metodo generado por implements Serializable
    @Override
    void limpiar() {
        throw new UnsupportedOperationException(notsupAir); //To change body of generated methods, choose Tools | Templates.
    }
//metodo generado por implements Serializable
    @Override
    void actualizar() {
        throw new UnsupportedOperationException(notsupAir); //To change body of generated methods, choose Tools | Templates.
    }
    //metodo generado por implements Serializable
    @Override
    EngAcRegistration nuevoElemento() {
        throw new UnsupportedOperationException(notsupAir); //To change body of generated methods, choose Tools | Templates.
    }

    
//metodo generado por implements Serializable
    @Override
    void eliminar(EngAcRegistration elemento) {
        throw new UnsupportedOperationException(notsupAir); //To change body of generated methods, choose Tools | Templates.
    }
//get y set de variable
    public String getNotsupAir() {
        return notsupAir;
    }
//get y set de variable
    public void setNotsupAir(String notsupAir) {
        this.notsupAir = notsupAir;
    }

    

    
    
}
