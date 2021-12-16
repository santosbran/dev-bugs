/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aecas.managed;



/**
 *
 * @author vjuarez
 */

public class PojoAviones {
    private int id;
    private String aviones;
    
    
    public PojoAviones(int id, String aviones) {
        this.id = id;
        this.aviones = aviones;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAviones() {
        return aviones;
    }

    public void setAviones(String aviones) {
        this.aviones = aviones;
    }
    
    
}
