/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aees.pojos;

import java.util.List;

/**
 *
 * @author scruz
 */
public class TaskCardInformation {
    
    private String errorMessage;
    private String errorCode;
    private MsgTaskCard msg;

    public TaskCardInformation() {
        super();
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public MsgTaskCard getMsg() {
        return msg;
    }

    public void setMsg(MsgTaskCard msg) {
        this.msg = msg;
    }
    
   
    
    
    
}
