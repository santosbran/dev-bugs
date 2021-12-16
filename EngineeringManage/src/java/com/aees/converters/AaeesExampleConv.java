/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aees.converters;

import com.aecas.managed.EngWorktypesBean;
import com.aeroman.aees.entities.EngWorkTypes;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


/**
 *
 * @author SAPLIC05
 */
@FacesConverter (value = "exampleConv")
public class AaeesExampleConv implements Converter{
    
    @ManagedProperty("engWorktypes")
    private EngWorktypesBean bean;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {                      
       for (EngWorkTypes ewt: bean.getListado()){
           if (ewt.getWtyCod().equals(value))
               return ewt;
       }
       return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return ((EngWorkTypes)value).getWtyCod();
    }
    
}
