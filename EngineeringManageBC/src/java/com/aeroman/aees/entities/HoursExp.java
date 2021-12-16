/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities;

import java.math.BigDecimal;

/**
 *
 * @author saplic
 */
public class HoursExp {
    private String NESR;
    private String HIN_ID;
    private String SUBJECT;
    private String COMPLETADO;
    private String EA;
    private BigDecimal SUMHOURS;
    private String CORR;
    private String ITEM;
    private String MESSAGEID;
    private String YEAR;
    private BigDecimal FACTURAR;
    private String SELECCION;
    private String EXPORTADO;
    private String COMBOINDEX;;

    public HoursExp() {
        super();
    }

    public HoursExp(String NESR, String HIN_ID, String SUBJECT, String COMPLETADO, String EA, BigDecimal SUMHOURS, String CORR, String ITEM, String MESSAGEID, String YEAR, BigDecimal FACTURAR, String SELECCION, String EXPORTADO, String COMBOINDEX) {
        this.NESR = NESR;
        this.HIN_ID = HIN_ID;
        this.SUBJECT = SUBJECT;
        this.COMPLETADO = COMPLETADO;
        this.EA = EA;
        this.SUMHOURS = SUMHOURS;
        this.CORR = CORR;
        this.ITEM = ITEM;
        this.MESSAGEID = MESSAGEID;
        this.YEAR = YEAR;
        this.FACTURAR = FACTURAR;
        this.SELECCION = SELECCION;
        this.EXPORTADO = EXPORTADO;
        this.COMBOINDEX = COMBOINDEX;
    }

    public String getNESR() {
        return NESR;
    }

    public void setNESR(String NESR) {
        this.NESR = NESR;
    }

    public String getHIN_ID() {
        return HIN_ID;
    }

    public void setHIN_ID(String HIN_ID) {
        this.HIN_ID = HIN_ID;
    }

    public String getSUBJECT() {
        return SUBJECT;
    }

    public void setSUBJECT(String SUBJECT) {
        this.SUBJECT = SUBJECT;
    }

    public String getCOMPLETADO() {
        return COMPLETADO;
    }

    public void setCOMPLETADO(String COMPLETADO) {
        this.COMPLETADO = COMPLETADO;
    }

    public String getEA() {
        return EA;
    }

    public void setEA(String EA) {
        this.EA = EA;
    }

    public BigDecimal getSUMHOURS() {
        return SUMHOURS;
    }

    public void setSUMHOURS(BigDecimal SUMHOURS) {
        this.SUMHOURS = SUMHOURS;
    }

    public String getCORR() {
        return CORR;
    }

    public void setCORR(String CORR) {
        this.CORR = CORR;
    }

    public String getITEM() {
        return ITEM;
    }

    public void setITEM(String ITEM) {
        this.ITEM = ITEM;
    }

    public String getMESSAGEID() {
        return MESSAGEID;
    }

    public void setMESSAGEID(String MESSAGEID) {
        this.MESSAGEID = MESSAGEID;
    }

    public String getYEAR() {
        return YEAR;
    }

    public void setYEAR(String YEAR) {
        this.YEAR = YEAR;
    }

    public BigDecimal getFACTURAR() {
        return FACTURAR;
    }

    public void setFACTURAR(BigDecimal FACTURAR) {
        this.FACTURAR = FACTURAR;
    }

    public String getSELECCION() {
        return SELECCION;
    }

    public void setSELECCION(String SELECCION) {
        this.SELECCION = SELECCION;
    }

    public String getEXPORTADO() {
        return EXPORTADO;
    }

    public void setEXPORTADO(String EXPORTADO) {
        this.EXPORTADO = EXPORTADO;
    }

    public String getCOMBOINDEX() {
        return COMBOINDEX;
    }

    public void setCOMBOINDEX(String COMBOINDEX) {
        this.COMBOINDEX = COMBOINDEX;
    }

    
    
    
    
    
    
}
