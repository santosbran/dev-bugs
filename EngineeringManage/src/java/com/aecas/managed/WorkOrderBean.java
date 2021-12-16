/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aecas.managed;


import com.aeroman.aees.entities.grant.ContCheck;
import com.aeroman.aees.facades.grant.ContCheckFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;
import java.util.ArrayList;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Usuario
 */
@ManagedBean(name ="workOrderBean")
@SessionScoped
public class WorkOrderBean extends CrudBean<ContCheck> implements Serializable{
    
    @EJB
    private ContCheckFacade contFacade;
    
    transient List<ContCheck> autowo = new ArrayList<>();
    
    @PostConstruct
    @Override
    public void init() {
        elemento = new ContCheck();
        
    }
    
    public void searchWoByCompany(String com){
        extendtime();
        autowo = new ArrayList<>();
        autowo=contFacade.findByChekCompany(com);
       
    }

    @Override
    void limpiar() {
        listadoCus = new ArrayList<>(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void actualizar() {
        listadoEng = new ArrayList<>();
        }

    @Override
    void agregar() {
        listado2 = new ArrayList<>(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void eliminar(ContCheck elemento) {
        contFacade.remove(elemento); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    ContCheck nuevoElemento() {
        return elemento;//To change body of generated methods, choose Tools | Templates.
    }

    public List<ContCheck> getAutowo() {
        return autowo;
    }

    public void setAutowo(List<ContCheck> autowo) {
        this.autowo = autowo;
    }

    
}
