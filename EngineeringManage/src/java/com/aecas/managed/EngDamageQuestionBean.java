
//  To change this license header, choose License Headers in Project Properties.
//  To change this template file, choose Tools | Templates
//  and open the template in the editor.

package com.aecas.managed;// paquete manage

import com.aees.session.SessionBean;// libreria SessionBean
import com.aeroman.aees.entities.CoreAircraftType;// importacion de clase
import com.aeroman.aees.entities.EngDamageQuestion;// importacion de clase
import com.aeroman.aees.entities.EngDamageType;// importacion de clase
import com.aeroman.aees.entities.EngQuestion;// importacion de clase
import com.aeroman.aees.facades.CoreAircraftTypeFacade;// importacion de clase
import com.aeroman.aees.facades.EngDamageQuestionFacade;// importacion de clase
import com.aeroman.aees.facades.EngDamageTypeFacade;// importacion de clase
import com.aeroman.aees.facades.EngQuestionFacade;// importacion de clase
import java.io.Serializable;// libreria Serializable
import java.math.BigDecimal;// libreria BigDecimal
import java.util.ArrayList;// libreria ArrayList
import java.util.Date;// libreria Date
import java.util.Map;// libreria Map
import javax.annotation.PostConstruct;// libreria PostConstruct
import javax.ejb.EJB;// libreria EJB
import javax.faces.bean.ManagedBean;// libreria ManagedBean
import javax.faces.bean.SessionScoped;// libreria SessionScoped
import javax.faces.context.ExternalContext;// libreria ExternalContext
import javax.faces.context.FacesContext;// libreria FacesContext
import javax.servlet.http.HttpSession;// libreria HttpSession

/**
 *
 * @author vjuarez
 */
//nombre de clase en mageBean
@ManagedBean(name = "engDamageQuestionBean")
@SessionScoped //tipo de clase
//clase ContAtasBean con extends al crud
public class EngDamageQuestionBean extends CrudBean<EngDamageQuestion> implements Serializable {

    @EJB
    private EngDamageQuestionFacade engDamageQuestionFacade;//declaracion de clases Facade
    @EJB
    private EngDamageTypeFacade engDamageTypeFacade;//declaracion de clases Facade
    @EJB
    private EngQuestionFacade engQuestionFacade;//declaracion de clases Facade
    @EJB
    private CoreAircraftTypeFacade CoreAircraftTypeFacade;//declaracion de clases Facade
    
    private String idDamageQuestion;//declaracion de variable
    private String idDamageType;//declaracion de variable
    private String idQuestion;//declaracion de variable
    private String users;//declaracion de variable
    private EngDamageType edt;//declaracion de variable
    private EngQuestion eqon;//declaracion de variable
    private CoreAircraftType ct;//declaracion de variable
    private String arctypId;//declaracion de variable
    private boolean encontrarRepetido;//declaracion de variable
    private int pCount;//declaracion de variable
    
    //metodo generado por implements Serializable
    @Override
    //metodo constructor
    @PostConstruct
    public void init() {
        listado = new ArrayList<>();
        elemento = new EngDamageQuestion();
        listado = engDamageQuestionFacade.findAllEngDamageQuestion();
        edt= new EngDamageType();
        eqon= new EngQuestion();
        ct = new CoreAircraftType();
    }

    @Override
    public void limpiar() { 
        extendtime();
        elemento = new EngDamageQuestion();
        idDamageQuestion=null;
        idDamageType=null;
        idQuestion=null;
        arctypId = null;
        edt= new EngDamageType();
        eqon= new EngQuestion();
        ct = new CoreAircraftType();
        edit = false;
        setEncontrarRepetido(false);
    }

    @Override
    public void actualizar() {
        extendtime();
        BigDecimal idDT = new BigDecimal(idDamageType);
        BigDecimal idQ = new BigDecimal(idQuestion);
        edt = engDamageTypeFacade.find(idDT);
        eqon = engQuestionFacade.find(idQ);
        ct = CoreAircraftTypeFacade.find(new BigDecimal(getArctypId()));
        elemento.setArctypId(ct);
        elemento.setDatId(edt);
        elemento.setQueId(eqon);
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        Map params = externalContext.getRequestParameterMap();            
        users = (String) params.get("user");
        HttpSession session = SessionBean.getSession();
        users=(String) session.getAttribute("username");
        Date fechaD = new Date();
        elemento.setDxqUserUpd(users);
        elemento.setDxqDateUpd(fechaD);
        engDamageQuestionFacade.edit(elemento);
        listado = engDamageQuestionFacade.findAll();
        elemento = new EngDamageQuestion();
        edit = false;
        idDamageType=null;
        idQuestion = null;
        arctypId = null;
    }

    @Override
    public void agregar() {
        extendtime();
        BigDecimal idDT = new BigDecimal(idDamageType);
        BigDecimal idQ = new BigDecimal(idQuestion);
        setEncontrarRepetido(false);
        edt = engDamageTypeFacade.find(idDT);
        eqon = engQuestionFacade.find(idQ);
        ct = CoreAircraftTypeFacade.find(new BigDecimal(getArctypId()));
        elemento.setArctypId(ct);
        elemento.setDatId(edt);
        elemento.setQueId(eqon);
        for (EngDamageQuestion lis : listado) {
                if (lis.getDatId().getDatId().equals(elemento.getDatId().getDatId())
                        && lis.getQueId().getQueId().toString().equals(elemento.getQueId().getQueId().toString())
                        && lis.getArctypId().getArctypId().toString().equals(elemento.getArctypId().getArctypId().toString())) {
                    setEncontrarRepetido(true);
                    break;
                }
            }
            
            if (!isEncontrarRepetido()) {
                FacesContext facesContext = FacesContext.getCurrentInstance();
                ExternalContext externalContext = facesContext.getExternalContext();
                Map params = externalContext.getRequestParameterMap();            
                users = (String) params.get("user");
                HttpSession session = SessionBean.getSession();
                users=(String) session.getAttribute("username");
                Date fechaD = new Date();
                elemento.setDxqUserIns(users);
                elemento.setDxqDateIns(fechaD);
                engDamageQuestionFacade.create(elemento);
                
                listado = engDamageQuestionFacade.findAll();
                elemento = new EngDamageQuestion();
                idDamageType=null;
                idQuestion = null;
                arctypId = null;
            }
            else {
                FacesContext.getCurrentInstance().validationFailed();
            }
    }
    public void eliminarElm(String id){
        extendtime();
        BigDecimal idBig = new BigDecimal(id);
        
        setpCount(engDamageQuestionFacade.existeEnESR(idBig));

        if (getpCount() == 0) {
            elemento = engDamageQuestionFacade.find(idBig);
            eliminar(elemento);
            listado = engDamageQuestionFacade.findAll();
            elemento = new EngDamageQuestion();
        } else {
            FacesContext.getCurrentInstance().validationFailed();
        }
    }

    @Override
    public void eliminar(EngDamageQuestion elem) {
        extendtime();
        engDamageQuestionFacade.remove(elem);
    }

    @Override
    public EngDamageQuestion nuevoElemento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//get y set de variable
    public String getIdDamageQuestion() {
        return idDamageQuestion;
    }
//get y set de variable
    public void setIdDamageQuestion(String idDamageQuestion) {
        this.idDamageQuestion = idDamageQuestion;
    }
//get y set de variable
    public String getIdDamageType() {
        return idDamageType;
    }
//get y set de variable
    public void setIdDamageType(String idDamageType) {
        this.idDamageType = idDamageType;
    }
//get y set de variable
    public String getIdQuestion() {
        return idQuestion;
    }
//get y set de variable
    public void setIdQuestion(String idQuestion) {
        this.idQuestion = idQuestion;
    }
//get y set de variable
    public EngDamageType getEdt() {
        return edt;
    }
//get y set de variable
    public void setEdt(EngDamageType edt) {
        this.edt = edt;
    }
//get y set de variable
    public EngQuestion getEqon() {
        return eqon;
    }
//get y set de variable
    public void setEqon(EngQuestion eqon) {
        this.eqon = eqon;
    }
//get y set de variable
    public String getArctypId() {
        return arctypId;
    }
//get y set de variable
    public void setArctypId(String arctypId) {
        this.arctypId = arctypId;
    }
//get y set de variable
    public CoreAircraftType getCt() {
        return ct;
    }
//get y set de variable
    public void setCt(CoreAircraftType ct) {
        this.ct = ct;
    }
//get y set de variable
    public boolean isEncontrarRepetido() {
        return encontrarRepetido;
    }
//get y set de variable
    public void setEncontrarRepetido(boolean encontrarRepetido) {
        this.encontrarRepetido = encontrarRepetido;
    }
//get y set de variable
    public String getUsers() {
        return users;
    }
//get y set de variable
    public void setUsers(String users) {
        this.users = users;
    }
    //get y set de variable
    public int getpCount() {
        return pCount;
    }
//get y set de variable
    public void setpCount(int pCount) {
        this.pCount = pCount;
    }
}
