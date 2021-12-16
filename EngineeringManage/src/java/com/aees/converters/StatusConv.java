/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aees.converters;

import com.aecas.managed.EngEoStatusBean;
import com.aeroman.aees.entities.EngEoStatus;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author saplic
 */
@ManagedBean(name="StatusConv")
@RequestScoped
public class StatusConv implements Converter {
    
    @ManagedProperty(value = "#{engEoStatus}")
    private EngEoStatusBean bean;

    public EngEoStatusBean getBean() {
        return bean;
    }

    public void setBean(EngEoStatusBean bean) {
        this.bean = bean;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        for (EngEoStatus ewt: getBean().getListado()){
           if (ewt.getStsEoCod().equals(value))
           {
               return ewt;
           }
           
       }
       return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
    return (String)value;
    }
    
}
