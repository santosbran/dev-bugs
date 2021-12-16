/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aecas.managed;

import com.aeroman.aees.entities.grant.ContFleets;
import com.aeroman.aees.entities.EngCustomer;
import com.aeroman.aees.entities.EngRequest;
import com.aeroman.aees.entities.grant.SgrUser;
import com.aeroman.aees.facades.grant.ContFleetsFacade;
import com.aeroman.aees.facades.EngCustomerFacade;
import com.aeroman.aees.facades.EngRequestFacade;
import com.aeroman.aees.facades.grant.SgrUserFacades;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Usuario
 */
@ManagedBean(name = "managerBean")
@ViewScoped
public class ManagerBean extends CrudBean<ContFleets> implements Serializable{
    private List<SgrUser> listuser = new ArrayList<>();
    private List<EngRequest> listask = new ArrayList<>();
    private List<EngCustomer> listcus = new ArrayList<>();
    private List<SgrUser> filuser = new ArrayList<>();
    private List<EngRequest> filtask = new ArrayList<>();
    private List<EngCustomer> filcus = new ArrayList<>();
    
    @EJB
    private ContFleetsFacade contFacade;
    @EJB
    private EngCustomerFacade cusFacade;
    @EJB
    private EngRequestFacade engEaEoReqVwFacade;
    @EJB
    private SgrUserFacades userFacade;

    @Override
    @PostConstruct
    public void init() {
        elemento = new ContFleets();
        listado=contFacade.findAll();
        listuser = userFacade.findAll();
        listask = engEaEoReqVwFacade.findAll();
        listcus = cusFacade.findAll();
        List<ContFleets> listmex=new ArrayList<>();
        List<ContFleets> listea=new ArrayList<>();
        int x = 0;
        while (x < listado.size()) {
            ContFleets company = (ContFleets) listado.get(x);

            if (("MEX").equals(company.getCompany())) {
                listmex.add(company);

            } else {
                if (("AE").equals(company.getCompany()))
                {
                    listea.add(company);
                }
            }
            x++;
        }
        listado2=listmex;
        listado3=listea;  
    }

    @Override
    void limpiar() {
        listask =  new ArrayList<>(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void actualizar() {
        contFacade.edit(elemento); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void agregar() {
       contFacade.create(elemento); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void eliminar(ContFleets elemento) {
        contFacade.remove(elemento); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    ContFleets nuevoElemento() {
        return listado.get(0);//To change body of generated methods, choose Tools | Templates.
    }
    
    public List<SgrUser> getListuser() {
        return listuser;
    }

    public void setListuser(List<SgrUser> listuser) {
        this.listuser = listuser;
    }

    public List<EngRequest> getListask() {
        return listask;
    }

    public void setListask(List<EngRequest> listask) {
        this.listask = listask;
    }

    public List<EngCustomer> getListcus() {
        return listcus;
    }

    public void setListcus(List<EngCustomer> listcus) {
        this.listcus = listcus;
    }

    public List<SgrUser> getFiluser() {
        return filuser;
    }

    public void setFiluser(List<SgrUser> filuser) {
        this.filuser = filuser;
    }

    public List<EngRequest> getFiltask() {
        return filtask;
    }

    public void setFiltask(List<EngRequest> filtask) {
        this.filtask = filtask;
    }

    public List<EngCustomer> getFilcus() {
        return filcus;
    }

    public void setFilcus(List<EngCustomer> filcus) {
        this.filcus = filcus;
    }
    
    
}
