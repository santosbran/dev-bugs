/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aees.pojos;

import java.util.List;

/**
 *
 * @author vjuarez
 */
public class DashbordEngPojo {

    private String hangarCode;
    private String hangarName;
    private String RampaCode;
    private String ciaCode;
    private String hrgColumn;
    private String hgrRow;
    private String hrgMaxH;
    private String hrgmaxR;
    private List<AircraftDashPojo> Aircraft;
    private List<RampaPojo> Rampa;

    public DashbordEngPojo() {
        super();
    }

    public String getHangarCode() {
        return hangarCode;
    }

    public void setHangarCode(String hangarCode) {
        this.hangarCode = hangarCode;
    }

    public String getHangarName() {
        return hangarName;
    }

    public void setHangarName(String hangarName) {
        this.hangarName = hangarName;
    }

    public String getRampaCode() {
        return RampaCode;
    }

    public void setRampaCode(String rampaCode) {
        this.RampaCode = rampaCode;
    }

    public String getCiaCode() {
        return ciaCode;
    }

    public void setCiaCode(String ciaCode) {
        this.ciaCode = ciaCode;
    }

    public String getHrgColumn() {
        return hrgColumn;
    }

    public void setHrgColumn(String hrgColumn) {
        this.hrgColumn = hrgColumn;
    }

    public String getHgrRow() {
        return hgrRow;
    }

    public void setHgrRow(String hgrRow) {
        this.hgrRow = hgrRow;
    }

    public String getHrgMaxH() {
        return hrgMaxH;
    }

    public void setHrgMaxH(String hrgMaxH) {
        this.hrgMaxH = hrgMaxH;
    }

    public String getHrgmaxR() {
        return hrgmaxR;
    }

    public void setHrgmaxR(String hrgmaxR) {
        this.hrgmaxR = hrgmaxR;
    }

    public List<AircraftDashPojo> getAircraft() {
        return Aircraft;
    }

    public void setAircraft(List<AircraftDashPojo> Aircraft) {
        this.Aircraft = Aircraft;
    }

    public List<RampaPojo> getRampa() {
        return Rampa;
    }

    public void setRampa(List<RampaPojo> Rampa) {
        this.Rampa = Rampa;
    }
     
}
