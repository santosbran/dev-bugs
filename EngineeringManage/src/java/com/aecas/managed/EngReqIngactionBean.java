
// To change this license header, choose License Headers in Project Properties.
// To change this template file, choose Tools | Templates
// and open the template in the editor.

package com.aecas.managed;// paquete manage

import com.aees.session.SessionBean;// importacion de clase
import com.aeroman.aees.entities.EngListView;// importacion de clase
import com.aeroman.aees.entities.EngReqIngaction;// importacion de clase
import com.aeroman.aees.entities.EngReqStatus;// importacion de clase
import com.aeroman.aees.entities.EngRequest;// importacion de clase
import com.aeroman.aees.facades.EngListViewFacade;// importacion de clase
import com.aeroman.aees.facades.EngReqIngactionFacade;// importacion de clase
import com.aeroman.aees.facades.EngReqStatusFacade;// importacion de clase
import com.aeroman.aees.facades.EngRequestFacade;// importacion de clase
import com.aeroman.aees.facades.Sequences;// importacion de clase
import java.io.Serializable;// libreria Serializable
import java.math.BigInteger;// libreria BigInteger
import java.util.ArrayList;// libreria ArrayList
import java.util.Calendar;// libreria Calendar
import java.util.GregorianCalendar;// libreria GregorianCalendar
import java.util.List;// libreria List
import java.util.logging.Level;// libreria Level
import java.util.logging.Logger;// libreria Logger
import javax.annotation.PostConstruct;// libreria PostConstruct
import javax.ejb.EJB;// libreria EJB
import javax.faces.application.FacesMessage;// libreria FacesMessage
import javax.faces.bean.ManagedBean;// libreria ManagedBean
import javax.faces.bean.SessionScoped;// libreria SessionScoped
import javax.faces.component.UIInput;// libreria UIInput
import javax.faces.component.UIViewRoot;// libreria UIViewRoot
import javax.faces.context.FacesContext;// libreria FacesContext
import javax.servlet.http.HttpSession;// libreria HttpSession

/**
 *
 * @author joao
 */
//nombre de clase en mageBean
@ManagedBean(name = "engReqIngaction")
@SessionScoped//tipo de clase
//clase EngReqIngactionBean con extends al crud
public class EngReqIngactionBean extends CrudBean<EngReqIngaction> implements Serializable {

    private static final long serialVersionUID = 1L;//declaracion de variable

    @EJB
    private EngReqIngactionFacade engReqIngactionFacade;//declaracion de clases Facade
    @EJB
    private EngReqStatusFacade engReqStatusFacade;//declaracion de clases Facade
    @EJB
    private EngRequestFacade engRequestFacade;//declaracion de clases Facade
    @EJB
    private EngListViewFacade usersFacade;//declaracion de clases Facade
    @EJB
    private Sequences sequences;

    private String reqmessageid;//declaracion de variable
    private String idalert1;//declaracion de variable
    private List<EngReqStatus> listastatus = new ArrayList<>();//declaracion de variable

    private String tipoSolicitud;
    
    //private int maximo;//declaracion de variable
    private BigInteger deleteDispo;//declaracion de variable
    private String idDispTab; //declaracion de variable

    @Override//metodo generado por implements Serializable
    @PostConstruct//metodo constructor
    public void init() {
        elemento = new EngReqIngaction();
        //listastatus = engReqStatusFacade.findByStatus();
        tipoSolicitud="";
    }

    public Object findSelect(String id) {
        extendtime();//extiende el tiempo de sesion
        listado3= new ArrayList<>();
        BigInteger idD = new BigInteger(id);
        setReqmessageid(id);
        elemento = new EngReqIngaction();
        listado2 = engReqIngactionFacade.findByMessageId(idD);
        if (!listado2.isEmpty()) {
            for (EngReqIngaction engReqIngaList2 : listado2) {
                if(engReqIngaList2.getEinDescription().length()>=50){
                    engReqIngaList2.setEinDescription(engReqIngaList2.getEinDescription().substring(0, 50)+"...");
                }
                engReqIngaList2.setStatusIA(engReqStatusFacade.findById(engReqIngaList2.getEinStatus()).getEstDesc());
                engReqIngaList2.setEinUserIns(engReqIngaList2.getEinUserIns()+" - "+sequences.traernombredeusuario(engReqIngaList2.getEinUserIns()));
                if (engReqIngaList2.getEinUserUpd()!= null){
                    engReqIngaList2.setEinUserUpd(engReqIngaList2.getEinUserUpd()+" - "+sequences.traernombredeusuario(engReqIngaList2.getEinUserUpd()));
                }
                listado3.add(engReqIngaList2);
                                
            }
            
        }
        listado2 = listado3;
        
        return elemento;
    }
    public void findIDDis(String id){
        Integer idD = Integer.parseInt(id);
        elemento = new EngReqIngaction();
        elemento = engReqIngactionFacade.find(idD);
        edit=true;
    }

    @Override//metodo generado por implements Serializable
    public void actualizar() {
        extendtime();//extiende el tiempo de sesion
        if (engReqIngactionFacade.find(elemento.getEinActionId()) != null) {
            HttpSession session = SessionBean.getSession();
            elemento.setEinUserUpd((String) session.getAttribute("username"));//usuario que modifica
            Calendar fechaUp = new GregorianCalendar();
            elemento.setEinDateUpd(fechaUp.getTime()); //fecha en que se modifica
            engReqIngactionFacade.edit(elemento);
            BigInteger rid = new BigInteger(reqmessageid);
            EngRequest er = engRequestFacade.find(rid);
            EngReqStatus engRegStatus = engReqStatusFacade.findById(elemento.getEinStatus());
            er.setReqStatus(engRegStatus.getEstCode());
            engRequestFacade.edit(er);
            elemento = new EngReqIngaction();
            this.edit = false;
        } else {
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El elemento que esta tratando de editar no existe en la base de datos"));
        }
    }

    @Override//metodo generado por implements Serializable
    public void agregar() {
        extendtime();//extiende el tiempo de sesion

            HttpSession session = SessionBean.getSession();
            elemento.setEinUserIns((String) session.getAttribute("username"));//usuario que inserta
            Calendar fechaIns = new GregorianCalendar();
            elemento.setEinFechaIns(fechaIns.getTime()); //fecha en que se inserta
            BigInteger rid = new BigInteger(reqmessageid);
            elemento.setReqMessageid(rid);
            engReqIngactionFacade.create(elemento);
            if(elemento.getEinDescription().length()>=20){
                    elemento.setEinDescription(elemento.getEinDescription().substring(0, 20)+"...");
                    elemento.setEinUserIns(elemento.getEinUserIns()+" - "+sequences.traernombredeusuario(elemento.getEinUserIns()));
                }
            listado2.add(elemento);

            //actualizar la esr
            EngRequest er = engRequestFacade.find(rid);
            EngReqStatus engRegStatus = engReqStatusFacade.findById(elemento.getEinStatus());
            er.setReqStatus(engRegStatus.getEstCode());
            engRequestFacade.edit(er);

            elemento = new EngReqIngaction();
    }

    @Override//metodo generado por implements Serializable
    public void eliminar(EngReqIngaction elemento) {
        extendtime();//extiende el tiempo de sesion
        EngReqIngaction element = elemento;
        if (engReqIngactionFacade.find(element.getEinActionId()) != null) {
            engReqIngactionFacade.remove(element);
            listado2.remove(element);
            element = new EngReqIngaction();
        }
    }

    public void delete(String id) {
        extendtime();//extiende el tiempo de sesion
        try {
            
            EngReqIngaction newEle = engReqIngactionFacade.find(Integer.parseInt(id));
            eliminar(newEle);
            listado3 = new ArrayList<>();
            deleteDispo = newEle.getReqMessageid();
            listado2 = engReqIngactionFacade.findByMessageId(deleteDispo);
            if (!listado2.isEmpty()) {
                for (EngReqIngaction engReqIngaList : listado2) {
                    if(engReqIngaList.getEinDescription().length()>=50){
                        engReqIngaList.setEinDescription(engReqIngaList.getEinDescription().substring(0, 50)+"...");
                    }
                    engReqIngaList.setStatusIA(engReqStatusFacade.findById(engReqIngaList.getEinStatus()).getEstDesc());
                    engReqIngaList.setEinUserIns(engReqIngaList.getEinUserIns()+" - "+sequences.traernombredeusuario(engReqIngaList.getEinUserIns()));
                    if (engReqIngaList.getEinUserUpd()!= null){
                    engReqIngaList.setEinUserUpd(engReqIngaList.getEinUserUpd()+" - "+sequences.traernombredeusuario(engReqIngaList.getEinUserUpd()));
                }
                    listado3.add(engReqIngaList);

                }
            }
            listado2 =listado3;
            limpiar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().validationFailed();
            Logger.getLogger(EngReqIngactionBean.class.getName()).log(Level.SEVERE, null, e);
        }

    }
    
    @Override//metodo generado por implements Serializable
    public EngReqIngaction nuevoElemento() {
        return new EngReqIngaction();
    }
    
    public void limpiarformDispo() {
        extendtime();//extiende el tiempo de sesion
        FacesContext contexteve = FacesContext.getCurrentInstance();
        UIViewRoot root = contexteve.getViewRoot();
        UIInput inputdelatarea = (UIInput) root.findComponent("inputForm11590:inputdelatarea");
        UIInput horas = (UIInput) root.findComponent("inputForm11590:horas");
        UIInput engDispo0 = (UIInput) root.findComponent("inputForm11590:engDispo0");        
        inputdelatarea.resetValue();
        horas.resetValue();
        engDispo0.resetValue();
    }

    @Override//metodo generado por implements Serializable
    public void limpiar() {
        extendtime();//extiende el tiempo de sesion
        this.elemento = new EngReqIngaction();
        edit = false;
        limpiarformDispo();
    }
    public void limpiarTab() {//limpiar tab
        extendtime();//extiende el tiempo de sesion
        this.elemento = new EngReqIngaction();
        edit = false;
        listado2 = new ArrayList<>();
    }

    public String obtenerNombrePorCod86(String cod86) {
        extendtime();//extiende el tiempo de sesion
        List<EngListView> userlist = usersFacade.findByCodigo86(cod86);
        EngListView usuario = userlist.get(0);
        return usuario.getCodigo86() + " - " + usuario.getFullUserName();
    }

    public List<EngReqStatus> getListastatus() {//get y set de variable
        return listastatus = engReqStatusFacade.findByStatus();
    }

    public void setListastatus(List<EngReqStatus> listastatus) {//get y set de variable
        this.listastatus = listastatus;
    }

    public String getReqmessageid() {//get y set de variable
        return reqmessageid;
    }

    public void setReqmessageid(String reqmessageid) {//get y set de variable
        this.reqmessageid = reqmessageid;
    }

    public EngRequestFacade getEngRequestFacade() {//get y set de variable
        return engRequestFacade;
    }

    public void setEngRequestFacade(EngRequestFacade engRequestFacade) {//get y set de variable
        this.engRequestFacade = engRequestFacade;
    }

    public String getIdalert1() {//get y set de variable
        return idalert1;
    }

    public void setIdalert1(String idalert1) {//get y set de variable
        this.idalert1 = idalert1;
    }

    public BigInteger getDeleteDispo() {//get y set de variable
        return deleteDispo;
    }

    public void setDeleteDispo(BigInteger deleteDispo) {//get y set de variable
        this.deleteDispo = deleteDispo;
    }

    public String getIdDispTab() {//get y set de variable
        return idDispTab;
    }

    public void setIdDispTab(String idDispTab) {//get y set de variable
        this.idDispTab = idDispTab;
    }    
    public String getTipoSolicitud() {
        return tipoSolicitud;
    }

    public void setTipoSolicitud(String tipoSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
    }

}
