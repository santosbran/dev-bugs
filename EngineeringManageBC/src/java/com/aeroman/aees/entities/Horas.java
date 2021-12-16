/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities;

import java.math.BigDecimal;

/**
 *
 * @author APLICATIVA_01
 */
public class Horas {
    private String esr;
    private String descripcion;
    private String eacompletado;
    private BigDecimal eafacturar;
    private BigDecimal horasing;
    private String idtemp;
    private String idesr;
    private String comboindex;
    private boolean chequeado;
    private String hintId;
    private String corr;
    private String wo;
    private String year;
    private String jobcard;
    
    public Horas() {
        super();
    }
    
    public Horas(String esr, String descripcion, String eacompletado, BigDecimal eafacturar, BigDecimal horasing, String idtemp,String idesr, String comboindex, boolean chequeado, String hint, String correlativo, String workOrder, String year,String jobcard) {
        super();
        this.esr=esr;
        this.descripcion=descripcion;
        this.eacompletado = eacompletado;
        this.eafacturar = eafacturar;
        this.horasing=horasing;
        this.idtemp=idtemp;
        this.idesr=idesr;
        this.comboindex=comboindex;
        this.chequeado=chequeado;
        this.hintId=hint;
        this.corr=correlativo;
        this.wo=workOrder;
        this.year=year;
        this.jobcard=jobcard;
    }
    
    public boolean getChequeado() {
        return chequeado;
    }

    public void setChequeado(boolean chequeado) {
        this.chequeado = chequeado;
    }
    
    public String getComboindex() {
        return comboindex;
    }

    public void setComboindex(String comboindex) {
        this.comboindex = comboindex;
    }
    
    public String getIdesr() {
        return idesr;
    }

    public void setIdesr(String idesr) {
        this.idesr = idesr;
    }
    
    public String getIdtemp() {
        return idtemp;
    }

    public void setIdtemp(String idtemp) {
        this.idtemp = idtemp;
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

    public String getEacompletado() {
        return eacompletado;
    }

    public void setEacompletado(String eacompletado) {
        this.eacompletado = eacompletado;
    }

    public BigDecimal getEafacturar() {
        return eafacturar;
    }

    public void setEafacturar(BigDecimal eafacturar) {
        this.eafacturar = eafacturar;
    }

    public BigDecimal getHorasing() {
        return horasing;
    }

    public void setHorasing(BigDecimal horasing) {
        this.horasing = horasing;
    }

    public String getHintId() {
        return hintId;
    }

    public void setHintId(String hintId) {
        this.hintId = hintId;
    }

    public String getCorr() {
        return corr;
    }

    public void setCorr(String corr) {
        this.corr = corr;
    }

    public String getWo() {
        return wo;
    }

    public void setWo(String wo) {
        this.wo = wo;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getJobcard() {
        return jobcard;
    }

    public void setJobcard(String jobcard) {
        this.jobcard = jobcard;
    }

    
    
}
