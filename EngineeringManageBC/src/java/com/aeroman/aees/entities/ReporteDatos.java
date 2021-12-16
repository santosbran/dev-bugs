/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities;

/**
 *
 * @author saplic
 */
public class ReporteDatos {
    private String cola;
    private String wo;
    private String numero_esr;
    private String taskard;
    private String taskards;
    private String codigo_mensaje;
    private String fecha_envio;
    private String cod_userenvia;
    private String nombre_userenvia;
    private String cco_userenvia;
    private String mensaje;
    private String mensaje_id;

    public ReporteDatos() {
    }

    
    
    public ReporteDatos(String cola, String wo, String numero_esr, String taskard, String taskards, String codigo_mensaje, String fecha_envio, String cod_userenvia, String nombre_userenvia, String cco_userenvia, String mensaje, String mensaje_id) {
        this.cola = cola;
        this.wo = wo;
        this.numero_esr = numero_esr;
        this.taskard = taskard;
        this.taskards = taskards;
        this.codigo_mensaje = codigo_mensaje;
        this.fecha_envio = fecha_envio;
        this.cod_userenvia = cod_userenvia;
        this.nombre_userenvia = nombre_userenvia;
        this.cco_userenvia = cco_userenvia;
        this.mensaje = mensaje;
        this.mensaje_id = mensaje_id;
    }

    
    
    public String getCola() {
        return cola;
    }

    public void setCola(String cola) {
        this.cola = cola;
    }

    public String getWo() {
        return wo;
    }

    public void setWo(String wo) {
        this.wo = wo;
    }

    public String getNumero_esr() {
        return numero_esr;
    }

    public void setNumero_esr(String numero_esr) {
        this.numero_esr = numero_esr;
    }

    public String getTaskard() {
        return taskard;
    }

    public void setTaskard(String taskard) {
        this.taskard = taskard;
    }

    public String getTaskards() {
        return taskards;
    }

    public void setTaskards(String taskards) {
        this.taskards = taskards;
    }

    public String getCodigo_mensaje() {
        return codigo_mensaje;
    }

    public void setCodigo_mensaje(String codigo_mensaje) {
        this.codigo_mensaje = codigo_mensaje;
    }

    public String getFecha_envio() {
        return fecha_envio;
    }

    public void setFecha_envio(String fecha_envio) {
        this.fecha_envio = fecha_envio;
    }

    public String getCod_userenvia() {
        return cod_userenvia;
    }

    public void setCod_userenvia(String cod_userenvia) {
        this.cod_userenvia = cod_userenvia;
    }

    public String getNombre_userenvia() {
        return nombre_userenvia;
    }

    public void setNombre_userenvia(String nombre_userenvia) {
        this.nombre_userenvia = nombre_userenvia;
    }

    public String getCco_userenvia() {
        return cco_userenvia;
    }

    public void setCco_userenvia(String cco_userenvia) {
        this.cco_userenvia = cco_userenvia;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje_id() {
        return mensaje_id;
    }

    public void setMensaje_id(String mensaje_id) {
        this.mensaje_id = mensaje_id;
    }
    
    
    
}
