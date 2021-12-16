/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aees.pojos;

/**
 *
 * @author vjuarez
 */
public class RampaPojo {
    private String QtyESRA;
    private String WOYear;
    private String WOCorr;
    private String WOTask;
    private String airCraft;   
    private String Customer;
    private String Fleet;   
    private String Color;
    private String Hangar;
    private String Line;
    private String SpandDays;
    private String Planneddays;
    private String checkType;
    private String QtyESRT;
    private String checkID;
    

    public RampaPojo() {
        super();
    }
    
    public String getColor() {
        return Color;
    }
    
    public String getAirCraft() {
        return airCraft;
    }

    public void setAirCraft(String airCraft) {
        this.airCraft = airCraft;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }   
    public void setCustomer(String Customer) {
        this.Customer = Customer;
    }

    public String getFleet() {
        return Fleet;
    }
    public void setLine(String Line) {
        this.Line = Line;
    }

    public String getCustomer() {
        return Customer;
    }
    public String getHangar() {
        return Hangar;
    }

    public void setHangar(String Hangar) {
        this.Hangar = Hangar;
    }

    public String getLine() {
        return Line;
    }

    

    public void setFleet(String Fleet) {
        this.Fleet = Fleet;
    }

    public String getSpandDays() {
        return SpandDays;
    }

    public void setSpandDays(String SpandDays) {
        this.SpandDays = SpandDays;
    }
    

    

    public void setQtyESRT(String QtyESRT) {
        this.QtyESRT = QtyESRT;
    }

    public String getQtyESRA() {
        return QtyESRA;
    }
    public String getCheckType() {
        return checkType;
    }
    public void setQtyESRA(String QtyESRA) {
        this.QtyESRA = QtyESRA;
    }
    public String getPlanneddays() {
        return Planneddays;
    }

    public void setCheckType(String checkType) {
        this.checkType = checkType;
    }

    public String getQtyESRT() {
        return QtyESRT;
    }

    public void setWOCorr(String WOCorr) {
        this.WOCorr = WOCorr;
    }

    public String getWOTask() {
        return WOTask;
    }

    public void setWOTask(String WOTask) {
        this.WOTask = WOTask;
    }
    public String getWOYear() {
        return WOYear;
    }

    public void setWOYear(String WOYear) {
        this.WOYear = WOYear;
    }

    public String getWOCorr() {
        return WOCorr;
    }
    public void setPlanneddays(String Planneddays) {
        this.Planneddays = Planneddays;
    }

    public String getCheckID() {
        return checkID;
    }

    public void setCheckID(String checkID) {
        this.checkID = checkID;
    }
}
