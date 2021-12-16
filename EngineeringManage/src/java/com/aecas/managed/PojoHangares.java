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

public class PojoHangares {
    private int id;
    private String hangar;

    PojoHangares(int id,String hangar) {
        this.id = id;
        this.hangar = hangar;
    }    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHangar() {
        return hangar;
    }

    public void setHangar(String hangar) {
        this.hangar = hangar;
    }
    
    
    
    
}
