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
public class responseDashPojo {
    private String errorCode;
    private String errorMessage;
    private List<DashbordEngPojo> dashboardENG;

    public responseDashPojo() {
        super();
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public List<DashbordEngPojo> getDashboardENG() {
        return dashboardENG;
    }

    public void setDashboardENG(List<DashbordEngPojo> dashboardENG) {
        this.dashboardENG = dashboardENG;
    }
    
      
}
