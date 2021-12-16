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
public class HoursExport {
    private String NESR;
    private String YEAR;
    private String CORR;
    private String ITEM;
    private String MESSAGEID;
    private String SUBJECT;
    private String FACTURAR;
    private String SELECCION;
    private String EXPORTADO;
    private String COMBOINDEX;
    private String SUMHOURS;
    private String CUCOD;
    private String ACREG;
    

    public HoursExport() {
        super();
    }

    public HoursExport(String NESR, String YEAR, String CORR, String ITEM, String MESSAGEID, String SUBJECT, String FACTURAR, String SELECCION, String EXPORTADO, String COMBOINDEX, String SUMHOURS, String CUCOD, String ACREG) {
        this.NESR = NESR;
        this.YEAR = YEAR;
        this.CORR = CORR;
        this.ITEM = ITEM;
        this.MESSAGEID = MESSAGEID;
        this.SUBJECT = SUBJECT;
        this.FACTURAR = FACTURAR;
        this.SELECCION = SELECCION;
        this.EXPORTADO = EXPORTADO;
        this.COMBOINDEX = COMBOINDEX;
        this.SUMHOURS = SUMHOURS;
        this.CUCOD = CUCOD;
        this.ACREG = ACREG;
    }

    
    
   

    public String getNESR() {
        return NESR;
    }

    public void setNESR(String NESR) {
        this.NESR = NESR;
    }

    public String getYEAR() {
        return YEAR;
    }

    public void setYEAR(String YEAR) {
        this.YEAR = YEAR;
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

    public String getSUBJECT() {
        return SUBJECT;
    }

    public void setSUBJECT(String SUBJECT) {
        this.SUBJECT = SUBJECT;
    }

    public String getFACTURAR() {
        return FACTURAR;
    }

    public void setFACTURAR(String FACTURAR) {
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

    public String getSUMHOURS() {
        return SUMHOURS;
    }

    public void setSUMHOURS(String SUMHOURS) {
        this.SUMHOURS = SUMHOURS;
    }

    public String getCUCOD() {
        return CUCOD;
    }

    public void setCUCOD(String CUCOD) {
        this.CUCOD = CUCOD;
    }

    public String getACREG() {
        return ACREG;
    }

    public void setACREG(String ACREG) {
        this.ACREG = ACREG;
    }
    
    
}
