/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aees.converters;

import com.aecas.managed.ContFleetsBean;
import com.aeroman.aees.entities.grant.ContFleets;
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

@ManagedBean(name="FleetsConv")
@RequestScoped
public class ContFleetsConv implements Converter{
    
    @ManagedProperty(value = "#{contFleets}")
    private ContFleetsBean bean;
    
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) { 
       for (ContFleets ewt: getBean().getListado()){
           if (ewt.getCodflt().equals(value))
               return ewt;
       }
       return null;
    }
   
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return ((ContFleets)value).getCodflt();
    }

    /**
     * @return the bean
     */
    public ContFleetsBean getBean() {
        return bean;
    }

    /**
     * @param bean the bean to set
     */
    public void setBean(ContFleetsBean bean) {
        this.bean = bean;
    }
    

}
