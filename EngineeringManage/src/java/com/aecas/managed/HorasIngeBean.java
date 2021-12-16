/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aecas.managed;


import com.aeroman.aees.entities.EngHorasIng;
import com.aeroman.aees.entities.EngHorasIngPK;
import com.aeroman.aees.facades.EngHorasIngFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Usuario
 */
@ManagedBean(name = "horasIngeBean")
@ViewScoped
public class HorasIngeBean extends CrudBean<EngHorasIng> implements Serializable{
    
    @EJB
    private EngHorasIngFacade horasIngFacade;
    private EngHorasIngPK ingPk;

    @Override
    @PostConstruct
    public void init() {
        elemento = new EngHorasIng();
        listado = horasIngFacade.findAll();
    }

    @Override
    public void limpiar() {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar() {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregar() {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(EngHorasIng elemento) {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EngHorasIng nuevoElemento() {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }

    public EngHorasIngPK getIngPk() {
        return ingPk;
    }

    public void setIngPk(EngHorasIngPK ingPk) {
        this.ingPk = ingPk;
    }


    
}
