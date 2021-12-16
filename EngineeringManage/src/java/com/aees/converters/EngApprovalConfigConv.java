/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aees.converters;


import com.aecas.managed.EngApprovalConfigBean;
import com.aeroman.aees.entities.EngApprovalConfig;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Usuario
 */
@FacesConverter(value="engApprovalConfigConv")
public class EngApprovalConfigConv implements Converter {

    @ManagedProperty("engApprovalConfig")
    private EngApprovalConfigBean bean;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {                      
       for (EngApprovalConfig ewt: bean.getListado()){
           if (ewt.getFltCod().equals(value))
               return ewt;
       }
       return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return ((EngApprovalConfig)value).getAcfId();
    }
    
    
    
}
