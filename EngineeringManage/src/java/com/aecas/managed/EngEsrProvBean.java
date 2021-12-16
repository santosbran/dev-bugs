 // To change this license header, choose License Headers in Project Properties.
 // To change this template file, choose Tools | Templates
 // and open the template in the editor.
package com.aecas.managed;// paquete manage

import com.aees.session.SessionBean;// libreria Serializable
import com.aeroman.aees.entities.EngEsrProv;// importacion de clase
import com.aeroman.aees.facades.EngEsrProvFacade;// importacion de clase
import java.io.Serializable;// libreria Serializable
import java.math.BigInteger;// libreria BigInteger
import java.util.ArrayList;// libreria ArrayList
import java.util.Date;// libreria Date
import java.util.logging.Level;// libreria Level
import java.util.logging.Logger;// libreria Logger
import javax.annotation.PostConstruct;// libreria PostConstruct
import javax.ejb.EJB;// libreria EJB
import javax.faces.bean.ManagedBean;// libreria ManagedBean
import javax.faces.bean.SessionScoped;// libreria SessionScoped
import javax.faces.context.FacesContext;// libreria FacesContext
import javax.servlet.http.HttpSession;// libreria HttpSession

/**
 *
 * @author vjuarez
 */
//nombre de clase en mageBean
@ManagedBean(name = "engEsrProvBean")
@SessionScoped //tipo de clase
//clase ContAtasBean con extends al crud
public class EngEsrProvBean extends CrudBean<EngEsrProv> implements Serializable {

    @EJB
    private EngEsrProvFacade engEsrProvFacade;//declaracion de clases Facade

    private boolean repetido;//declaracion de variable
    private String userING = "username";//declaracion de variable
    private int idEsrProv;//declaracion de variable
    private String nomeo;//declaracion de variable

    private int engEsrID;//declaracion de variable

    //metodo generado por implements Serializable
    @Override
    //metodo constructor
    @PostConstruct
    public void init() {
        elemento = new EngEsrProv();
        listado = new ArrayList<>();
    }

    @Override
    public void limpiar() {
        extendtime();
        elemento = new EngEsrProv();
    }

    @Override
    void actualizar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregar() {
        extendtime();
        HttpSession session = SessionBean.getSession();
        String user = (String) session.getAttribute(userING);
        java.util.Date fecha = new Date();
        try {
            listado.add(elemento);
            for (EngEsrProv task : listado) {
                if (task.getIdpord() == null) {
                    task.setMessageid(getEngEsrID());
                    task.setUserAct(user);
                    task.setUserIns(user);
                    task.setFechaAct(fecha);
                    task.setFechaIns(fecha);
                    task.setApproved("Y");
                    engEsrProvFacade.create(task);

                }
            }
            elemento = new EngEsrProv();
        } catch (Exception e) {
            Logger.getLogger(TaskReqCardBean.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    @Override
    public void eliminar(EngEsrProv elemento) {
        extendtime();
        engEsrProvFacade.remove(elemento);
        listado = engEsrProvFacade.findByEngEsrProv(getEngEsrID());
    }

    @Override
    EngEsrProv nuevoElemento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    public void actualizarEsrProv(int id) {
        extendtime();
        try {           
            java.util.Date fecha = new Date();
            elemento.setFechaAct(fecha);
            engEsrProvFacade.edit(elemento);
            listado = engEsrProvFacade.findByEngEsrProv(getEngEsrID());
            nomeo=null;
            elemento = new EngEsrProv();
        } catch (Exception e) {
            Logger.getLogger(TaskReqCardBean.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    public void delete(int id) {
        extendtime();
        try {

            EngEsrProv borrar = engEsrProvFacade.find(id);
            eliminar(borrar);
        } catch (Exception e) {
            FacesContext.getCurrentInstance().validationFailed();
            Logger.getLogger(EngReqIngactionStatusBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void selectEngEsrProv(BigInteger req) {
        extendtime();
        setEngEsrID(req.intValue());
        listado = engEsrProvFacade.findByEngEsrProv(req.intValue());
    }
//get y set de variable
    public EngEsrProvFacade getEngEsrProvFacade() {
        return engEsrProvFacade;
    }
//get y set de variable
    public void setEngEsrProvFacade(EngEsrProvFacade engEsrProvFacade) {
        this.engEsrProvFacade = engEsrProvFacade;
    }
//get y set de variable
    public boolean isRepetido() {
        return repetido;
    }
//get y set de variable
    public void setRepetido(boolean repetido) {
        this.repetido = repetido;
    }
//get y set de variable
    public String getUserING() {
        return userING;
    }
//get y set de variable
    public void setUserING(String userING) {
        this.userING = userING;
    }
//get y set de variable
    public int getEngEsrID() {
        return engEsrID;
    }
//get y set de variable
    public void setEngEsrID(int engEsrID) {
        this.engEsrID = engEsrID;
    }
//get y set de variable
    public int getIdEsrProv() {
        return idEsrProv;
    }
//get y set de variable
    public void setIdEsrProv(int idEsrProv) {
        this.idEsrProv = idEsrProv;
    }
//get y set de variable
    public String getNomeo() {
        return nomeo;
    }
//get y set de variable
    public void setNomeo(String nomeo) {
        this.nomeo = nomeo;
    }

}
