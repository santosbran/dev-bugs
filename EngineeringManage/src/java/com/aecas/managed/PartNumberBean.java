/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aecas.managed;

import com.aeroman.aees.entities.grant.MatPartNumber;
import com.aeroman.aees.facades.grant.MatPartNumberFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author scruz
 */
@ManagedBean(name = "partNumberBean")
@ApplicationScoped
public class PartNumberBean extends CrudBean<MatPartNumber> implements Serializable{
    
    @EJB
    private MatPartNumberFacade parNumberFacade;

    @Override
    @PostConstruct
    public void init() {
       elemento = new MatPartNumber();
       listado = parNumberFacade.findAll();
    }

   

    @Override
    public void agregar() {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(MatPartNumber elemento) {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
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
    public MatPartNumber nuevoElemento() {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
