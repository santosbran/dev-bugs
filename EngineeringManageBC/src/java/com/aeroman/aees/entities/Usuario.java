/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities;

/**
 *
 * @author APLICATIVA_01
 */
public class Usuario {
   
    private String anyo;
    private String esr;
    private String descripcion;
    private String fecha;
    private String revision;
    private String estados;
    private String correlativo;
    private String esrid;

    public Usuario() {
        super();
    }
    
     public Usuario(String anyo, String correlativo, String esr, String descripcion, String fecha, String revision, String estados,String esrid) {
        super();
        this.esrid=esrid;
        this.fecha=fecha;
        this.anyo=anyo;
        this.esr = esr;
        this.descripcion = descripcion;
        this.correlativo=correlativo;
        this.estados=estados;
        this.revision=revision;
     }
    
    public String getEsrid() {
        return esrid;
    }

    public void setEsrid(String esrid) {
        this.esrid = esrid;
    }

    public String getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(String correlativo) {
        this.correlativo = correlativo;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public String getEstados() {
        return estados;
    }

    public void setEstados(String estados) {
        this.estados = estados;
    }
   
    public String getAnyo() {
        return anyo;
    }

    public void setAnyo(String anyo) {
        this.anyo = anyo;
    }

    public String getEsr() {
        return esr;
    }

    public void setEsr(String esr) {
        this.esr = esr;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
  
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
}