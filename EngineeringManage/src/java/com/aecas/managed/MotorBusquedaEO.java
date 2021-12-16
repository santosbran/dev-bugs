
// To change this license header, choose License Headers in Project Properties.
// To change this template file, choose Tools | Templates
// and open the template in the editor.

package com.aecas.managed;// paquete manage

import com.aeroman.aees.entities.EngOrders;// importacion de clase
import com.aeroman.aees.entities.grant.ContAtas;// importacion de clase
import com.aeroman.aees.facades.EngEoStatusFacade;// importacion de clase
import com.aeroman.aees.facades.EngOrdersFacade;// importacion de clase
import com.aeroman.aees.facades.grant.ContAtasFacade;// importacion de clase
import java.io.Serializable;// libreria Serializable
import java.util.ArrayList;// libreria Serializable
import java.util.Collections;// libreria Serializable
import java.util.List;// libreria Serializable
import javax.annotation.PostConstruct;// libreria Serializable
import javax.ejb.EJB;// libreria Serializable
import javax.faces.bean.ManagedBean;// libreria Serializable
import javax.faces.bean.ManagedProperty;// libreria Serializable
import javax.faces.bean.ViewScoped;// libreria Serializable
import javax.faces.context.FacesContext;// libreria Serializable

/**
 *
 * @author Usuario
 */
 //nombre de clase en mageBean
@ManagedBean(name = "motorBusquedaEO")
@ViewScoped //tipo de clase
//clase MotorBusquedaEO con extends al crud
public class MotorBusquedaEO extends CrudBean<EngOrders> implements Serializable {

    EngOrders search = new EngOrders();//declaracion de variable
    transient List<String> atasAuto = new ArrayList();//declaracion de variable
    transient List<String> atasModal = new ArrayList();//declaracion de variable
    transient List<String> fltAuto = new ArrayList();//declaracion de variable
    transient List<String> fltModal = new ArrayList();//declaracion de variable
    transient List<String> titlesAuto = new ArrayList();//declaracion de variable
    transient List<String> documentAuto = new ArrayList();//declaracion de variable
    transient List<String> documentsModal = new ArrayList();//declaracion de variable
    transient List<String> correlativsAuto = new ArrayList();//declaracion de variable
    transient List<String> correlativsModal = new ArrayList();//declaracion de variable
    transient List<ContAtas> todasAtas = new ArrayList();//declaracion de variable
    transient List<String> atasStr = new ArrayList();//declaracion de variable
    String dateRev;//declaracion de variable
    String nRev;//declaracion de variable
    String ata;//declaracion de variable
    String dateExp;//declaracion de variable
    String doc;//declaracion de variable
    String dateCreate;//declaracion de variable
    String correlative;//declaracion de variable
    String estatus;//declaracion de variable
    String flt;//declaracion de variable
    String year;//declaracion de variable
    String actions;//declaracion de variable
    String priorities;//declaracion de variable
    String title;//declaracion de variable
    String idElemnt;//declaracion de variable
    Boolean buscado = false;//declaracion de variable
    @EJB
    private EngOrdersFacade engOrders;//declaracion de clases Facade

    @EJB
    private EngEoStatusFacade beanStatus;//declaracion de clases Facade

    @EJB
    private ContAtasFacade contAtasFacade;//declaracion de clases Facade

    @ManagedProperty(value = "#{tabEsrEaEoBean}")
    private TabEsrEaEo tab;//declarion variable tipo clase
    @ManagedProperty(value = "#{engOrdersBean}")
    private EngOrdersBean order;//declarion variable tipo clase

    @Override//metodo generado por implements Serializable
    @PostConstruct//metodo constructor
    public void init() {
        elemento = new EngOrders();
        
    }

    @Override//metodo generado por implements Serializable
    public void limpiar() {
        extendtime();//extiende el tiempo de sesion
        this.dateRev = "";
        this.nRev = "";
        this.ata = "";
        this.dateRev = "";
        this.doc = "";
        this.dateCreate = "";
        this.correlative = "";
        this.estatus = "";
        this.flt = "";
        this.year = "";
        this.actions = "";
        this.priorities = "";
        this.title = "";
        this.buscado = false;
        listado = new ArrayList();
    }

    @Override//metodo generado por implements Serializable
    public void actualizar() {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.

    }

    @Override//metodo generado por implements Serializable
    public void agregar() {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.

    }

    @Override//metodo generado por implements Serializable
    public void eliminar(EngOrders elemento) {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.

    }

    @Override//metodo generado por implements Serializable
    public EngOrders nuevoElemento() {
        elemento = new EngOrders();
        return elemento;
    }
    /*Others Methods*/

  
    /*Getters And Setters*/
    public EngOrdersFacade getEngOrders() {//get y set de variable
        return engOrders;
    }

    public void setEngOrders(EngOrdersFacade engOrders) {//get y set de variable
        this.engOrders = engOrders;
    }

    public List<String> getAtasAuto() {//get y set de variable
        Collections.sort(atasAuto);
        return atasAuto;
    }

    public void setAtasAuto(List<String> atasAuto) {//get y set de variable
        this.atasAuto = atasAuto;
    }

    public List<String> getAtasModal() {//get y set de variable
        for (String val : atasAuto) {
            if (!atasModal.contains(val.replace("\"", ""))) {
                atasModal.add(val.replace("\"", ""));
            }
        }
        Collections.sort(atasModal);
        return atasModal;
    }

    public void setAtasModal(List<String> atasModal) {//get y set de variable
        this.atasModal = atasModal;
    }

    public List<String> getFltAuto() {//get y set de variable
        Collections.sort(fltAuto);
        return fltAuto;
    }

    public void setFltAuto(List<String> fltAuto) {//get y set de variable
        this.fltAuto = fltAuto;
    }

    public List<String> getFltModal() {//get y set de variable
        for (String tem : fltAuto) {
            if (!fltModal.contains(tem.replace("\"", ""))) {
                fltModal.add(tem.replace("\"", ""));
            }

        }
        Collections.sort(fltModal);
        return fltModal;
    }

    public void setFltModal(List<String> fltModal) {//get y set de variable
        this.fltModal = fltModal;
    }

    public List<String> getTitlesAuto() {//get y set de variable
        Collections.sort(titlesAuto);
        return titlesAuto;
    }

    public void setTitlesAuto(List<String> titlesAuto) {//get y set de variable
        this.titlesAuto = titlesAuto;
    }

    public List<String> getDocumentAuto() {//get y set de variable
        Collections.sort(documentAuto);
        return documentAuto;
    }

    public void setDocumentAuto(List<String> documentAuto) {//get y set de variable
        this.documentAuto = documentAuto;
    }

    public List<String> getDocumentsModal() {//get y set de variable
        for (String list : documentAuto) {
            if (!documentsModal.contains(list.replace("\"", ""))) {
                documentsModal.add(list.replace("\"", ""));
            }

        }
        Collections.sort(documentsModal);
        return documentsModal;
    }

    public void setDocumentsModal(List<String> documentsModal) {//get y set de variable
        this.documentsModal = documentsModal;
    }

    public List<String> getCorrelativsAuto() {//get y set de variable
        Collections.sort(correlativsAuto);
        return correlativsAuto;
    }

    public void setCorrelativsAuto(List<String> correlativsAuto) {//get y set de variable
        this.correlativsAuto = correlativsAuto;
    }

    public List<String> getCorrelativsModal() {//get y set de variable
        for (String lis : correlativsAuto) {
            if (!correlativsModal.contains(lis.replace("\"", ""))) {
                correlativsModal.add(lis.replace("\"", ""));
            }
        }
        Collections.sort(correlativsModal);
        return correlativsModal;
    }

    public void setCorrelativsModal(List<String> correlativsModal) {//get y set de variable
        this.correlativsModal = correlativsModal;
    }

    public String getDateRev() {//get y set de variable
        return dateRev;
    }

    public void setDateRev(String dateRev) {//get y set de variable
        this.dateRev = dateRev;
    }

    public String getAta() {//get y set de variable
        return ata;
    }

    public void setAta(String ata) {//get y set de variable
        this.ata = ata;
    }

    public String getDateExp() {//get y set de variable
        return dateExp;
    }

    public void setDateExp(String dateExp) {//get y set de variable
        this.dateExp = dateExp;
    }

    public String getDoc() {//get y set de variable
        return doc;
    }

    public void setDoc(String doc) {//get y set de variable
        this.doc = doc;
    }

    public String getDateCreate() {//get y set de variable
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {//get y set de variable
        this.dateCreate = dateCreate;
    }

    public String getCorrelative() {//get y set de variable
        return correlative;
    }

    public void setCorrelative(String correlative) {//get y set de variable
        this.correlative = correlative;
    }

    public String getEstatus() {//get y set de variable
        return estatus;
    }

    public void setEstatus(String estatus) {//get y set de variable
        this.estatus = estatus;
    }

    public String getFlt() {//get y set de variable
        return flt;
    }

    public void setFlt(String flt) {//get y set de variable
        this.flt = flt;
    }

    public String getYear() {//get y set de variable
        return year;
    }

    public void setYear(String year) {//get y set de variable
        this.year = year;
    }

    public String getActions() {//get y set de variable
        return actions;
    }

    public void setActions(String actions) {//get y set de variable
        this.actions = actions;
    }

    public String getPriorities() {//get y set de variable
        return priorities;
    }

    public void setPriorities(String priorities) {//get y set de variable
        this.priorities = priorities;
    }

    public String getTitle() {//get y set de variable
        return title;
    }

    public void setTitle(String title) {//get y set de variable
        this.title = title;
    }

    public EngOrders getSearch() {//get y set de variable
        return search;
    }

    public void setSearch(EngOrders search) {//get y set de variable
        this.search = search;
    }

    public EngEoStatusFacade getBeanStatus() {//get y set de variable
        return beanStatus;
    }

    public void setBeanStatus(EngEoStatusFacade beanStatus) {//get y set de variable
        this.beanStatus = beanStatus;
    }

    public String getnRev() {//get y set de variable
        return nRev;
    }

    public void setnRev(String nRev) {//get y set de variable
        this.nRev = nRev;
    }

    public String getIdElemnt() {//get y set de variable
        return idElemnt;
    }

    public void setIdElemnt(String idElemnt) {//get y set de variable
        this.idElemnt = idElemnt;
    }

    public TabEsrEaEo getTab() {//get y set de variable
        return tab;
    }

    public void setTab(TabEsrEaEo tab) {//get y set de variable
        this.tab = tab;
    }

    public EngOrdersBean getOrder() {//get y set de variable
        return order;
    }

    public void setOrder(EngOrdersBean order) {//get y set de variable
        this.order = order;
    }

    public List<ContAtas> getTodasAtas() {//get y set de variable
        return todasAtas;
    }

    public void setTodasAtas(List<ContAtas> todasAtas) {//get y set de variable
        this.todasAtas = todasAtas;
    }

    public List<String> getAtasStr() {//get y set de variable
        return atasStr;
    }

    public void setAtasStr(List<String> atasStr) {//get y set de variable
        this.atasStr = atasStr;
    }

    public Boolean isBuscado() {//get y set de variable
        return buscado;
    }

    public Boolean getBuscado() {//get y set de variable
        return buscado;
    }

    public void setBuscado(Boolean buscado) {//get y set de variablel
        this.buscado = buscado;
    }

}
