
// To change this license header, choose License Headers in Project Properties.
// To change this template file, choose Tools | Templates
// and open the template in the editor.
 
package com.aecas.managed;// paquete manage

import com.aees.session.SessionBean;// importacion de clase
import com.aeroman.aees.entities.EngDistributionLists;// importacion de clase
import com.aeroman.aees.entities.EngDistributionListsPK;// importacion de clase
import com.aeroman.aees.entities.EngOrders;// importacion de clase
import com.aeroman.aees.facades.EngDistributionListsFacade;// importacion de clase
import com.aeroman.aees.facades.Sequences;// importacion de clase
import java.io.Serializable;// libreria Serializable
import java.util.ArrayList;// libreria ArrayList
import java.util.Calendar;// libreria Calendar
import java.util.GregorianCalendar;// libreria GregorianCalendar
import java.util.List;// libreria List
import javax.annotation.PostConstruct;// libreria PostConstruct
import javax.ejb.EJB;// libreria EJB
import javax.faces.bean.ManagedBean;// libreria ManagedBean
import javax.faces.bean.ManagedProperty;// libreria ManagedProperty
import javax.faces.bean.ViewScoped;// libreria ViewScoped
import javax.servlet.http.HttpSession;// libreria HttpSession

/**
 *
 * @author Usuario
 */
//nombre de clase en mageBean
@ManagedBean(name = "distributionBean")
@ViewScoped
//tipo de clase
//clase ContAtasBean con extends al crud
public class DistributionBean extends CrudBean<EngDistributionLists> implements Serializable {

    @EJB
    private EngDistributionListsFacade engDistFacade;//declaracion de clases Facade

    @ManagedProperty(value = "#{engOrdersBean}")
    private EngOrdersBean order;//declarion variable tipo clase

    transient List<EngOrders> listado22 = new ArrayList();//variable de lista
    transient List<EngOrders> listado33 = new ArrayList();//variable de lista
    transient List<EngOrders> listado44 = new ArrayList();//variable de lista
    private Boolean dlValue; //declaracion de variable
    EngDistributionListsPK pk;//declaracion de variable
// get y set de variable
    public EngDistributionListsPK getPk() {
        return pk;
    }
// get y set de variable
    public void setPk(EngDistributionListsPK pk) {
        this.pk = pk;
    }
// get y set de variable
    public List<EngOrders> getListado33() {
        return listado33;
    }
// get y set de variable
    public void setListado33(List<EngOrders> listado33) {
        this.listado33 = listado33;
    }
// get y set de variable
    public List<EngOrders> getListado44() {
        return listado44;
    }
// get y set de variable
    public void setListado44(List<EngOrders> listado44) {
        this.listado44 = listado44;
    }
// get y set de variable
    public List<EngOrders> getListado22() {
        extendtime();
        listado22.clear();
        listado33.clear();
        listado44.clear();
        List<EngOrders> list = order.listado;

        for (EngOrders list1 : list) {

            listado22.add(list1);
            if (list1.getCompany() != null) {
                if (("MEX").equals(list1.getCompany())) {
                    listado33.add(list1);
                }
                if (("AE").equals(list1.getCompany())) {
                    listado44.add(list1);
                }
            }
        }
        return listado22;
    }
// get y set de variable
    public void setListado22(List<EngOrders> listado22) {
        this.listado22 = listado22;
    }
// get y set de variable
    public Boolean getDlValue() {
        if (elemento.getDlValue() != null && ("Y").equals(elemento.getDlValue())) {
            dlValue = true;
        }
        return dlValue;
    }
// get y set de variable
    public void setDlValue(Boolean dlValue) {
        this.dlValue = dlValue;
    }
// get y set de variable
    public EngOrdersBean getOrder() {
        return order;
    }
// get y set de variable
    public void setOrder(EngOrdersBean order) {
        this.order = order;
    }
//metodo generado por implements Serializable
    @Override
    //metodo constructor
    @PostConstruct
    void init() {
        elemento = new EngDistributionLists();
        pk = new EngDistributionListsPK();
    }
//metodo generado por implements Serializable limpiar los elementos
    @Override
    public void limpiar() {
        extendtime();
        elemento = new EngDistributionLists();
        edit = false;
    }
//metodo generado por implements Serializable que actualiza a la base de datos
    @Override
    public void actualizar() {
        extendtime();
        HttpSession session = SessionBean.getSession();
        elemento.setDlUserUpd((String) session.getAttribute("username"));
        Calendar fechaUp = new GregorianCalendar();
        elemento.setDlDateUpd(fechaUp.getTime());
        if (dlValue) {
            elemento.setDlValue("Y");
        } else {
            elemento.setDlValue("N");
        }
        elemento.setEngDistributionListsPK(pk);
        engDistFacade.edit(elemento);
        elemento = new EngDistributionLists();
        this.edit = false;
    }
//metodo generado por implements Serializable agrega a la base de datos
    @Override
    public void agregar() {
        extendtime();
        Sequences sec = new Sequences();
        pk.setDlcId(sec.getCountDistributions());
        HttpSession session = SessionBean.getSession();
        elemento.setDlUserIns((String) session.getAttribute("username"));
        Calendar fechaIns = new GregorianCalendar();
        elemento.setDlDateIns(fechaIns.getTime());
        if (dlValue) {
            elemento.setDlValue("Y");
        } else {
            elemento.setDlValue("N");
        }
        elemento.setEngDistributionListsPK(pk);
        engDistFacade.create(elemento);
        listado.add(elemento);
        elemento = new EngDistributionLists();
    }
//metodo generado por implements Serializable elimina el elemento a la BD
    @Override
    public void eliminar(EngDistributionLists elemento) {
        extendtime();
        engDistFacade.remove(elemento);
        listado.remove(elemento);
    }
//metodo generado por implements Serializable
    @Override
    public EngDistributionLists nuevoElemento() {
        return new EngDistributionLists();
    }
//metodo generado por implements Serializable
    public void buscarlista(long ideo) {
        listado = engDistFacade.findByeoid(ideo);

    }

}
