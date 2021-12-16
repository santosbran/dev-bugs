
// To change this license header, choose License Headers in Project Properties.
// To change this template file, choose Tools | Templates
// and open the template in the editor.

package com.aecas.managed;// paquete manage

/**
 *
 * @author Usuario
 */
 
public class Esrepor {//clase Esrepor con extends al crud
    
   
    private String anyotk;//declaracion de variable
    private String corretk;//declaracion de variable
    private String numESR;//declaracion de variable
    private String descripcionESR;//declaracion de variable
    private String fecha;//declaracion de variable
    private String disposicion;//declaracion de variable
    private String ingrevision;//declaracion de variable

    //metodo constructor
    public Esrepor(String anyotk, String corretk, String numESR, String descripcionESR, String fecha, String disposicion, String ingrevision) {
        super();
        this.fecha=fecha;
        this.anyotk=anyotk;
        this.corretk = corretk;
        this.numESR = numESR;
        this.descripcionESR=descripcionESR;
        this.disposicion=disposicion;
        this.ingrevision=ingrevision;
    }

    public String getAnyotk() {//get y set de variable
        return anyotk;
    }

    public void setAnyotk(String anyotk) {//get y set de variable
        this.anyotk = anyotk;
    }

    public String getCorretk() {//get y set de variable
        return corretk;
    }

    public void setCorretk(String corretk) {//get y set de variable
        this.corretk = corretk;
    }

    public String getNumESR() {//get y set de variable
        return numESR;
    }

    public void setNumESR(String numESR) {//get y set de variable
        this.numESR = numESR;
    }

    public String getDescripcionESR() {//get y set de variable
        return descripcionESR;
    }

    public void setDescripcionESR(String descripcionESR) {//get y set de variable
        this.descripcionESR = descripcionESR;
    }

    public String getFecha() {//get y set de variable
        return fecha;
    }

    public void setFecha(String fecha) {//get y set de variable
        this.fecha = fecha;
    }

    public String getDisposicion() {//get y set de variable
        return disposicion;
    }

    public void setDisposicion(String disposicion) {//get y set de variable
        this.disposicion = disposicion;
    }

    public String getIngrevision() {//get y set de variable
        return ingrevision;
    }

    public void setIngrevision(String ingrevision) {//get y set de variable
        this.ingrevision = ingrevision;
    }
        
}


    

