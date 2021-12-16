/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aecas.managed;

import com.aees.session.SessionBean;
import java.io.Serializable;
import javax.faces.bean.ViewScoped;
import com.aeroman.aees.entities.EngSupDoc;
import com.aeroman.aees.facades.Sequences;
import com.aeroman.aees.facades.EngSupDocFacade;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "supportDocsBean")
@ViewScoped
public class SupportDocsBean extends CrudBean<EngSupDoc> implements Serializable {

    @ManagedProperty(value = "#{engOrdersBean}")
    private EngOrdersBean bean;
    @EJB
    private EngSupDocFacade engSupDocFacade;
    private Integer id;
    private Integer idorden;

    @Override
    @PostConstruct
    public void init() {

        elemento = new EngSupDoc();
        listado = engSupDocFacade.findAll();

    }

    @Override
    public void limpiar() {
        extendtime();
        this.elemento = new EngSupDoc();
        edit = false;
    }

    public void buscarlista(long ideo) {
        extendtime();
        listado = engSupDocFacade.findByeoid(ideo);
    }

    @Override
    public void actualizar() {
        extendtime();
        if (engSupDocFacade.find(elemento.getSdoId()) != null) {
            HttpSession pauser = SessionBean.getSession();
            String user = (String) pauser.getAttribute("username");

            elemento.setSdoUserUpd(user);
            elemento.setSdoDateUpd(new Date());
            engSupDocFacade.edit(elemento);
            elemento = new EngSupDoc();
            this.edit = false;
        } else {
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El elemento que se esta tratando de editar no existe en la base de datos "));

        }
    }

    @Override
    public void agregar() {
        extendtime();
        Sequences secuencia = new Sequences();
        id = secuencia.maxSupDoc();
        HttpSession pauser = SessionBean.getSession();
        String user = (String) pauser.getAttribute("username");

        elemento.setSdoUserIns(user);
        elemento.setSdoDateIns(new Date());
        elemento.setSdoId(id);
        engSupDocFacade.create(elemento);
        listado.add(elemento);
        elemento = new EngSupDoc();

    }

    @Override
    public void eliminar(EngSupDoc elemento) {
        extendtime();
        if (engSupDocFacade.find(elemento.getSdoId()) != null) {
            engSupDocFacade.remove(elemento);
            listado.remove(elemento);
        }

    }

    @Override
    public EngSupDoc nuevoElemento() {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return new EngSupDoc();

    }

    public EngOrdersBean getBean() {
        return bean;
    }

    public void setBean(EngOrdersBean bean) {
        this.bean = bean;
    }

    public Integer getId() {
        return id;
    }

    public Integer getIdorden() {
        return idorden;
    }

    public void setIdorden(Integer idorden) {
        this.idorden = idorden;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EngSupDocFacade getEngSupDocFacade() {
        return engSupDocFacade;
    }

    public void setEngSupDocFacade(EngSupDocFacade engSupDocFacade) {
        this.engSupDocFacade = engSupDocFacade;
    }

}
