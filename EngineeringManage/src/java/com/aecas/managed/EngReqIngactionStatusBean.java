
// To change this license header, choose License Headers in Project Properties.
// To change this template file, choose Tools | Templates
// and open the template in the editor.

package com.aecas.managed;// paquete manage

import com.aees.session.SessionBean;// importacion de clase
import com.aeroman.aees.entities.EngActor;// importacion de clase
import com.aeroman.aees.entities.EngReqStatus;// importacion de clase
import com.aeroman.aees.facades.EngActorFacade;// importacion de clase
import com.aeroman.aees.facades.EngReqStatusFacade;// importacion de clase
import com.aeroman.aees.facades.Sequences;// importacion de clase
import java.io.Serializable;// libreria Serializable
import java.math.BigDecimal;// libreria BigDecimal
import java.math.BigInteger;// libreria BigInteger
import java.util.Calendar;// libreria Calendar
import java.util.GregorianCalendar;// libreria GregorianCalendar
import java.util.logging.Level;// libreria Level
import java.util.logging.Logger;// libreria Serializable
import javax.annotation.PostConstruct;// libreria PostConstruct
import javax.ejb.EJB;// libreria EJB
import javax.faces.application.FacesMessage;// libreria FacesMessage
import javax.faces.bean.ManagedBean;// libreria ManagedBean
import javax.faces.bean.ViewScoped;// libreria ViewScoped
import javax.faces.component.UIInput;// libreria UIInput
import javax.faces.component.UIViewRoot;// libreria UIViewRoot
import javax.faces.context.FacesContext;// libreria FacesContext
import javax.servlet.http.HttpSession;// libreria HttpSession

/**
 *
 * @author saplic11
 */
//nombre de clase en mageBean
@ManagedBean(name = "engReqIngactionStatus")
@ViewScoped//tipo de clase
//clase EngReqIngactionBean con extends al crud
public class EngReqIngactionStatusBean extends CrudBean<EngReqStatus> implements Serializable {

    @EJB
    private EngReqStatusFacade engReqStatusFacade;//declaracion de clases Facade
    @EJB
    private EngActorFacade engActorFacade;//declaracion de clases Facade
    
    private int maximo;//declaracion de variable
    private String idStaDispo;//declaracion de variable
    private int menscons;//declaracion de variable
    private String idActor;//declaracion de variable
    private int pCount;//declaracion de variable

    @Override//metodo generado por implements Serializable
    @PostConstruct//metodo constructor
    void init() {
        elemento = new EngReqStatus();
        listado = engReqStatusFacade.findAllEngReqStatus();
        Sequences numax = new Sequences();
        maximo = numax.maxEngStatus();
        BigInteger id = new BigInteger(String.valueOf(maximo));
        elemento.setEstId(id);
        idActor=null;
    }

    @Override//metodo generado por implements Serializable
    public void limpiar() {
        extendtime();//extiende el tiempo de sesion
        this.elemento = new EngReqStatus();
        edit = false;
        idStaDispo = null;
        menscons = 0;
        idActor=null;
    }
    
    public void limpiarformDispoESt() {
        extendtime();//extiende el tiempo de sesion
        FacesContext contexteve = FacesContext.getCurrentInstance();
        UIViewRoot root = contexteve.getViewRoot();
        UIInput code = (UIInput) root.findComponent("inputFormdis98:code");
        UIInput inputdelatarea = (UIInput) root.findComponent("inputFormdis98:inputdelatarea");
        UIInput engDispo = (UIInput) root.findComponent("inputFormdis98:engDispo");
        UIInput reqcomName = (UIInput) root.findComponent("inputFormdis98:reqcomName");
        code.resetValue();
        inputdelatarea.resetValue();
        engDispo.resetValue();
        reqcomName.resetValue();
    }

    @Override//metodo generado por implements Serializable
    public void actualizar() {
        extendtime();//extiende el tiempo de sesion
        if (engReqStatusFacade.find(elemento.getEstId()) != null) {
            HttpSession session = SessionBean.getSession();
            elemento.setEstUserAct((String) session.getAttribute("username"));//usuario que modifica
            Calendar fechaUp = new GregorianCalendar();
            elemento.setEstFechaAct(fechaUp.getTime()); //fecha en que se modifica
            BigDecimal iddam = new BigDecimal(idActor);
            EngActor dam = engActorFacade.find(iddam);
            elemento.setEstIdactor(dam);
            engReqStatusFacade.edit(elemento);
        } else {
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El elemento que esta tratando de editar no existe en la base de datos"));
        }
    }

    @Override//metodo generado por implements Serializable
    public void agregar() {
        extendtime();//extiende el tiempo de sesion
        boolean repett=false;
       
            for (EngReqStatus esdG : listado) {
                if (esdG.getEstCode().equals(elemento.getEstCode())) {
                    repett=true;
                    FacesContext.getCurrentInstance().validationFailed();
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El identificador unico se encuentra repetido"));
                }
            }
            if (!repett) {
                HttpSession session = SessionBean.getSession();
                elemento.setEstUserIns((String) session.getAttribute("username"));//usuario que inserta
                Calendar fechaIns = new GregorianCalendar();
                elemento.setEstFechaIns(fechaIns.getTime()); //fecha en que se inserta
                Sequences numax = new Sequences();
                maximo = numax.maxEngStatus();
                BigInteger id = new BigInteger(String.valueOf(maximo));
                elemento.setEstId(id);           
                BigDecimal iddam = new BigDecimal(idActor);
                EngActor dam = engActorFacade.find(iddam);
                elemento.setEstIdactor(dam);
                engReqStatusFacade.create(elemento);
                listado.add(elemento);
                elemento = new EngReqStatus();
                idActor=null;
                
            }

    }
    
    public void delete(String id){
        extendtime();//extiende el tiempo de sesion
        try {
            EngReqStatus borrar = engReqStatusFacade.findById(id);
            
            setpCount(engReqStatusFacade.existeEnESR(borrar.getEstCode()));
                
            if (getpCount() == 0) {
                eliminar(borrar);
            } else {
                FacesContext.getCurrentInstance().validationFailed();
            }
        } catch (Exception e) {
            String errores = e.getCause().getMessage();
            if (errores.contains("Error committing transaction") || errores.contains("Error al realizar la transacción")) {
                limpiar();
                menscons = 1;
            }
            FacesContext.getCurrentInstance().validationFailed();
            Logger.getLogger(EngReqIngactionStatusBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override//metodo generado por implements Serializable
    public void eliminar(EngReqStatus elemento) {
        extendtime();//extiende el tiempo de sesion
        if (engReqStatusFacade.find(elemento.getEstCode()) != null) {
            engReqStatusFacade.remove(elemento);
            listado = engReqStatusFacade.findAll();
        }

    }

    @Override//metodo generado por implements Serializable
    public EngReqStatus nuevoElemento() {
        return new EngReqStatus();
    }

    public int getMaximo() {//get y set de variable
        return maximo;
    }

    public void setMaximo(int maximo) {//get y set de variable
        this.maximo = maximo;
    }

    public String getIdStaDispo() {//get y set de variable
        return idStaDispo;
    }

    public void setIdStaDispo(String idStaDispo) {//get y set de variable
        this.idStaDispo = idStaDispo;
    }

    public int getMenscons() {//get y set de variable
        return menscons;
    }

    public void setMenscons(int menscons) {//get y set de variable
        this.menscons = menscons;
    }

    public String getIdActor() {//get y set de variable
        return idActor;
    }

    public void setIdActor(String idActor) {//get y set de variable
        this.idActor = idActor;
    }
    
    public int getpCount() {//get y set de variable
        return pCount;
    }

    public void setpCount(int pCount) {//get y set de variable
        this.pCount = pCount;
    }

}
