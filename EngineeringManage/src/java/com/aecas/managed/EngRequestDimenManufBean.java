/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aecas.managed;

import com.aeroman.aees.entities.EngRequestDimenManuf;
import java.io.Serializable;


import com.aees.session.SessionBean;// importacion de clase

import com.aeroman.aees.entities.EngDent;// importacion de clase
import com.aeroman.aees.entities.EngDimension;// importacion de clase
import com.aeroman.aees.entities.EngDtDimByManuf;
import com.aeroman.aees.entities.EngRequest;// importacion de clase

import com.aeroman.aees.entities.EngRequestQuestion;// importacion de clase
import com.aeroman.aees.facades.EngDentFacade;// importacion de clase

import com.aeroman.aees.facades.EngRequestDimenManufFacade;
import com.aeroman.aees.facades.EngRequestQuestionFacade;// importacion de clase
import java.io.Serializable;// libreria Serializable
import java.math.BigDecimal;// libreria BigDecimal
import java.util.ArrayList;// libreria ArrayList
import java.util.Date;// libreria Date
import java.util.List;// libreria List
import java.util.logging.Level;// libreria Level
import java.util.logging.Logger;// libreria Logger
import javax.annotation.PostConstruct;// libreria PostConstruct
import javax.ejb.EJB;// libreria EJB
import javax.faces.bean.ManagedBean;// libreria ManagedBean
import javax.faces.bean.ManagedProperty;// libreria ManagedProperty
import javax.faces.bean.SessionScoped;// libreria SessionScoped
import javax.faces.component.UIInput;// libreria UIInput
import javax.faces.component.UIViewRoot;// libreria UIViewRoot
import javax.faces.context.FacesContext;// libreria FacesContext
import javax.servlet.http.HttpSession;// libreria HttpSession

/**
 *
 * @author mpolanco
 */
//nombre de clase en mageBean
@ManagedBean(name = "reqdimManufBean")
@SessionScoped
//tipo de clase
//clase EngRequestDimenBean con extends al crud

public class EngRequestDimenManufBean extends CrudBean<EngRequestDimenManuf> implements Serializable {
    
    @EJB
    private EngRequestDimenManufFacade RequestDimenManufFacade;//declaracion de clases Facade

    @EJB
    private EngRequestQuestionFacade engRequestQuestionFacade;//declaracion de clases Facade
    
    @EJB
    private EngDentFacade engDentFacade;//declaracion de clases Facade
    
    
      @ManagedProperty(value = "#{engDamageTypeManufactBean}")
    private EngDamageTypeManufactBean engDamageTypeManufactBean;//declarion variable tipo clase
    
    
    @ManagedProperty(value = "#{engRequestQuestionBean}")
    private EngRequestQuestionBean engRequestQuestionBean;//declarion variable tipo clase
    
    @ManagedProperty(value = "#{engDentBean}")
    private EngDentBean engDentBean;//declarion variable tipo clase
    
    
    private BigDecimal idAffectPart;//declaracion de variable
    private String userlg;//declaracion de variable
    private String dimFK;//declaracion de variable
    private String idDamage;//declaracion de variable
    private boolean encontrarRepetido;//declaracion de variable
    private String dimenciones;//declaracion de variable
    private String otherDescription;//declaracion de variable
    private ArrayList<EngDimension> dimencionesDamage;//declaracion de variable
    transient List<EngRequestDimenManuf> listaRequestDimen = new ArrayList();//declaracion de variable
    transient List<EngDent> listaEngDent = new ArrayList();//declaracion de variable
    transient List<EngRequestQuestion> listaEngRequestQuestion = new ArrayList();//declaracion de variable
    private ArrayList<String> damageDimen;//declaracion de variable
    private String idListDamage;//declaracion de variable
    private String denAircraftGroundESR;//declaracion de variable
    private String denCriticalESR;//declaracion de variable
    

    
    private EngRequest engEr;//declarion variable tipo clase

    @Override//metodo generado por implements Serializable
    @PostConstruct//metodo constructor
    public void init() {
        dimencionesDamage= new ArrayList();
        HttpSession session = SessionBean.getSession();
        setUserlg((String) session.getAttribute("username"));
        elemento = nuevoElemento();
        listado = new ArrayList<>();
        listaRequestDimen = new ArrayList<>();
        listaEngRequestQuestion = new ArrayList<>();
        listaEngDent = new ArrayList<>();
        edit = false;
        setDimFK(null);
        dimenciones=null;
        damageDimen= new ArrayList<>();
    }

    @Override//metodo generado por implements Serializable
    public void limpiar() {
        extendtime();//extiende el tiempo de sesion
        //engDamageDimBean.limpiarListas();
        engDamageTypeManufactBean.limpiarListas();
      //  engDamageDimBean.setValorDamageType(null);        
        engDamageTypeManufactBean.setValorDamageType(null);
        elemento = nuevoElemento();
        edit = false;
        setDimFK(null);
        dimenciones=null;
        setEncontrarRepetido(false);
        /*se vuelve a setear en este metodo el tiempo maximo de inactividad para que se cierre la session*/
        extendtime();//extiende el tiempo de sesion
    }
    public void limpiarLista() {
        extendtime();
   //     engDamageDimBean.limpiarListas();    
        engDamageTypeManufactBean.limpiarListas();    
        elemento = nuevoElemento();
        edit = false;
        setDimFK(null);
        dimenciones=null;
        setEncontrarRepetido(false);
        /*se vuelve a setear en este metodo el tiempo maximo de inactividad para que se cierre la session*/
        extendtime();//extiende el tiempo de sesion
    }

    @Override//metodo generado por implements Serializable
    public void actualizar() {
        extendtime();//extiende el tiempo de sesion
        try {
            elemento.setRedUserUpd(getUserlg());
            elemento.setRedDateUpd(new Date());
            elemento.setRedState("A");

            if (elemento.getRedId() != null) {
                RequestDimenManufFacade.edit(elemento);
                dimenciones= elemento.getRedIdDimension().getDimId().getDimDescription()+" - "+elemento.getRedValorText();
                limpiar();
                
            } else {
                FacesContext.getCurrentInstance().validationFailed();
            }
            

        } catch (Exception e) {
            Logger.getLogger(EngRequestDimenManuf.class.getName()).log(Level.SEVERE, null, e);
            FacesContext.getCurrentInstance().validationFailed();
        }
    }

    @Override//metodo generado por implements Serializable
    public void agregar() {
        extendtime();//extiende el tiempo de sesion
        try {
            
            setEncontrarRepetido(false);
         //   engDamageDimBean.agregarLista();
            engDamageTypeManufactBean.agregarLista();
            List<EngRequestDimenManuf> otroEliminar = listado;
            for (EngRequestDimenManuf lis : otroEliminar) {
                for(EngDtDimByManuf listaDimeciones: engDamageTypeManufactBean.listado2){
                    if (lis.getRedIdDimension().getDatId().equals(listaDimeciones.getDatId())) {
                    setEncontrarRepetido(true);                    
                    break;
                    }  
                }
               if (isEncontrarRepetido()) {
                    break;
                } 
            }
            if (!isEncontrarRepetido()) {
                engRequestQuestionBean.agregar();
                engDentBean.agregar();
                
                for (EngDtDimByManuf listaDimeciones: engDamageTypeManufactBean.getListadoNLocal()) {                    
                    elemento.setRedIdRequest(getEngEr()); //id de ESR 
                    elemento.setRedIdDimension(listaDimeciones);
                    elemento.setRedUserAdd(getUserlg());
                    elemento.setRedDateAdd(new Date());
                    elemento.setRedState("A");
                    elemento.setRedMeasure(listaDimeciones.getDimId().getMesure());
                    
                    if(listaDimeciones.getValueDim()!= null && !listaDimeciones.getValueDim().isEmpty() ){
                        if(listaDimeciones.getDatId().getDatName().equals("Other")){
                            elemento.setRedOther(listaDimeciones.getValueDim());                           
                        }else{
                             if(listaDimeciones.getDimId().getTypeControl().equals("textBox")){
                                 elemento.setRedValorText(listaDimeciones.getValueDim());
                             }else if(listaDimeciones.getDimId().getTypeControl().equals("checkBox")){
                                 elemento.setRedValorCheck(listaDimeciones.getValueDim());
                             }
                            
                         //  elemento.setRedValorText(listaDimeciones.getDimId().getOli());
                        }
                        
                    }
                    
                    
                    
                    if (elemento.getRedIdRequest() != null && elemento.getRedIdRequest().getReqMessageid() != null) {
                        RequestDimenManufFacade.create(elemento);
                        listado.add(elemento);
                    }
                    else{
                        listado.add(elemento);                
                    }
                    elemento = new EngRequestDimenManuf();
                    setDimFK(null);
                }
                for (EngDtDimByManuf listaDimeciones: engDamageTypeManufactBean.getListadoNDim()) {                    
                    elemento.setRedIdRequest(getEngEr()); //id de ESR 
                    elemento.setRedIdDimension(listaDimeciones);
                    elemento.setRedUserAdd(getUserlg());
                    elemento.setRedDateAdd(new Date());
                    elemento.setRedState("A");
                    elemento.setRedMeasure(listaDimeciones.getDimId().getMesure());
                    
                    if(listaDimeciones.getDimId().getOli()!= null && !listaDimeciones.getDimId().getOli().isEmpty() ){
                        if(listaDimeciones.getDatId().getDatName().equals("Other")){
                            elemento.setRedOther(listaDimeciones.getDimId().getOli());                           
                        }
                        else{
                             if(listaDimeciones.getDimId().getTypeControl().equals("textBox")){
                                 elemento.setRedValorText(listaDimeciones.getDimId().getOli());
                             }else if(listaDimeciones.getDimId().getTypeControl().equals("checkBox")){
                                 elemento.setRedValorCheck(listaDimeciones.getDimId().getOli());
                             }
                            
                         //  elemento.setRedValorText(listaDimeciones.getDimId().getOli());
                        }
                        
                    }
                    
                    
                    
                    if (elemento.getRedIdRequest() != null && elemento.getRedIdRequest().getReqMessageid() != null) {
                        RequestDimenManufFacade.create(elemento);
                        listado.add(elemento);
                    }
                    else{
                        listado.add(elemento);                
                    }
                    elemento = new EngRequestDimenManuf();
                    setDimFK(null);
                }
                engDamageTypeManufactBean.limpiarListas();
                //engDamageDimBean.limpiarListas();
                
            }
        } catch (Exception e) {
            Logger.getLogger(TaskReqCardBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public void preUpdateLista(){
        extendtime();//extiende el tiempo de sesion
        updateLista(getIdListDamage());
        setIdListDamage(null); 
        setDenAircraftGroundESR("0");
        setDenCriticalESR("0");
    }
    public void updateLista(String id){
        extendtime();//extiende el tiempo de sesion
        String damageType=null;       
        
        for (EngRequestDimenManuf listDime : listado) {
            damageType=listDime.getRedIdDimension().getDatId().getDatId().toString();
            if(damageType.equals(id) && listDime.getRedId()!=null){
                RequestDimenManufFacade.edit(listDime);  
                break;
            }    
        }
        for (EngDent listDime : engDentBean.listado) {
            damageType=listDime.getDatId().getDatId().toString();
            if(damageType.equals(id) && listDime.getDenId()!= null){
                listDime.setDenCritical(getDenCriticalESR());
                listDime.setDenAircraftGround(getDenAircraftGroundESR());
                engDentFacade.edit(listDime);
                break;
            }
            
            
        }
        for (EngRequestQuestion listDime : engRequestQuestionBean.listado) {
            damageType=listDime.getDxqId().getDatId().getDatId().toString();
            if(damageType.equals(id) && listDime.getReqId() != null){
                engRequestQuestionFacade.edit(listDime);
                break;
            }
            
            
        }
    }
    public void preEliminarDeLista(){
        extendtime();//extiende el tiempo de sesion
        eliminarDeLista(getIdListDamage());
        setIdListDamage(null);
    }
    public void eliminarDeLista(String id) {
        extendtime();//extiende el tiempo de sesion
        String pb = null;
        listaRequestDimen = new ArrayList<>();
        listaEngRequestQuestion = new ArrayList<>();
        listaEngDent = new ArrayList<>();
      
        for (EngRequestDimenManuf listDime : listado) {
            pb=listDime.getRedIdDimension().getDatId().getDatId().toString();
            if(!pb.equals(id)){
                listaRequestDimen.add(listDime);                
            }
            else{
                if (listDime.getRedId()!= null){
                    RequestDimenManufFacade.remove(listDime);
                }
            }
            
            
        }
        for (EngDent listDime : engDentBean.listado) {
            pb=listDime.getDatId().getDatId().toString();
            if(!pb.equals(id)){
                listaEngDent.add(listDime);                
            }
            else{
                if (listDime.getDenId()!= null){
                    engDentFacade.remove(listDime);
                }
            }
            
            
        }
        for (EngRequestQuestion listDime : engRequestQuestionBean.listado) {
            pb=listDime.getDxqId().getDatId().getDatId().toString();
            if(!pb.equals(id)){
                listaEngRequestQuestion.add(listDime);                
            }
            else{
                if (listDime.getReqId() != null){
                    engRequestQuestionFacade.remove(listDime);
                }
            }
            
            
        }
        
        listado=listaRequestDimen;
        engDentBean.listado=listaEngDent;
        engRequestQuestionBean.listado=listaEngRequestQuestion;
      //  engDamageDimBean.eliminarValorDamage(id);
        engDamageTypeManufactBean.eliminarValorDamage(id);
    }

    @Override//metodo generado por implements Serializable
    public void eliminar(EngRequestDimenManuf elemento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void delete(String id) {
        extendtime();//extiende el tiempo de sesion
        try {
            BigDecimal idAffected = new BigDecimal(id);
            elemento = RequestDimenManufFacade.find(idAffected);
            elemento.setRedUserDlt(getUserlg());
            elemento.setRedDateDlt(new Date());
            elemento.setRedState("D");

            if (elemento.getRedId() != null) {
                RequestDimenManufFacade.edit(elemento);
                limpiar();
            } else {
                FacesContext.getCurrentInstance().validationFailed();
            }

        } catch (Exception e) {
            Logger.getLogger(EngRequestDimenManufBean.class.getName()).log(Level.SEVERE, null, e);
            FacesContext.getCurrentInstance().validationFailed();
        }
    }

    
    public EngRequestDimenManuf nuevoElemento() {
        return new EngRequestDimenManuf();
    }

    public List<EngRequestDimenManuf> findAllNotDeleted(BigDecimal idesr) {
        extendtime();//extiende el tiempo de sesion
        listado = new ArrayList<>();
        listado = RequestDimenManufFacade.findAllActive(idesr);
        
        return listado;
    }

    public void limpiarDamageDimModal() {
        extendtime();//extiende el tiempo de sesion
        FacesContext context = FacesContext.getCurrentInstance();
        UIViewRoot root = context.getViewRoot();
        UIInput cbDimension = (UIInput) root.findComponent("fDimension:cbDimension");
        cbDimension.resetValue();
        UIInput redValor = (UIInput) root.findComponent("fDimension:redValor");
        redValor.resetValue();
    }

    //@return the idAffectPart
     
    public BigDecimal getIdAffectPart() {//get y set de variable
        return idAffectPart;
    }

   
     // @param idAffectPart the idAffectPart to set
    
    public void setIdAffectPart(BigDecimal idAffectPart) {//get y set de variable
        this.idAffectPart = idAffectPart;
    }

    // @return the userlg
    
    public String getUserlg() {//get y set de variable
        return userlg;
    }

    // @param userlg the userlg to set
    
    public void setUserlg(String userlg) {//get y set de variable
        this.userlg = userlg;
    }

    // @return the dimFK
     
    public String getDimFK() {//get y set de variable
        return dimFK;
    }

    // @param dimFK the dimFK to set
     
    public void setDimFK(String dimFK) {//get y set de variable
        this.dimFK = dimFK;
    }

    // @return the encontrarRepetido
    
    public boolean isEncontrarRepetido() {//get y set de variable
        return encontrarRepetido;
    }

    // @param encontrarRepetido the encontrarRepetido to set
     
    public void setEncontrarRepetido(boolean encontrarRepetido) {//get y set de variable
        this.encontrarRepetido = encontrarRepetido;
    }

    // @return the engEr
     
    public EngRequest getEngEr() {//get y set de variable
        return engEr;
    }

    // @param engEr the engEr to set
     
    public void setEngEr(EngRequest engEr) {//get y set de variable
        this.engEr = engEr;
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    // @return the idDamage
     
    public String getIdDamage() {//get y set de variable
        return idDamage;
    }

    // @param idDamage the idDamage to set
     
    public void setIdDamage(String idDamage) {//get y set de variable
        this.idDamage = idDamage;
    }

    public String getDimenciones() {//get y set de variable
        return dimenciones;
    }

    public void setDimenciones(String dimenciones) {//get y set de variable
        this.dimenciones = dimenciones;
    }


    public ArrayList<EngDimension> getDimencionesDamage() {//get y set de variable
        return dimencionesDamage;
    }

    public void setDimencionesDamage(ArrayList<EngDimension> dimencionesDamage) {//get y set de variable
        this.dimencionesDamage = dimencionesDamage;
    }

    public String getOtherDescription() {//get y set de variable
        return otherDescription;
    }

    public void setOtherDescription(String otherDescription) {//get y set de variable
        this.otherDescription = otherDescription;
    }

    public EngRequestQuestionBean getEngRequestQuestionBean() {//get y set de variable
        return engRequestQuestionBean;
    }

    public void setEngRequestQuestionBean(EngRequestQuestionBean engRequestQuestionBean) {//get y set de variable
        this.engRequestQuestionBean = engRequestQuestionBean;
    }

    public List<EngRequestDimenManuf> getListaRequestDimen() {//get y set de variable
        return listaRequestDimen;
    }

    public void setListaRequestDimen(List<EngRequestDimenManuf> listaRequestDimen) {//get y set de variable
        this.listaRequestDimen = listaRequestDimen;
    }

    public ArrayList<String> getDamageDimen() {//get y set de variable
        return damageDimen;
    }

    public void setDamageDimen(ArrayList<String> damageDimen) {//get y set de variable
        this.damageDimen = damageDimen;
    }

    public EngDentBean getEngDentBean() {//get y set de variable
        return engDentBean;
    }

    public void setEngDentBean(EngDentBean engDentBean) {//get y set de variable
        this.engDentBean = engDentBean;
    }

    public String getIdListDamage() {//get y set de variable
        return idListDamage;
    }

    public void setIdListDamage(String idListDamage) {//get y set de variable
        this.idListDamage = idListDamage;
    }

    public String getDenAircraftGroundESR() {//get y set de variable
        return denAircraftGroundESR;
    }

    public void setDenAircraftGroundESR(String denAircraftGroundESR) {//get y set de variable
        this.denAircraftGroundESR = denAircraftGroundESR;
    }

    public String getDenCriticalESR() {//get y set de variable
        return denCriticalESR;
    }

    public void setDenCriticalESR(String denCriticalESR) {//get y set de variable
        this.denCriticalESR = denCriticalESR;
    }

    public EngRequestDimenManufFacade getRequestDimenManufFacade() {
        return RequestDimenManufFacade;
    }

    public void setRequestDimenManufFacade(EngRequestDimenManufFacade RequestDimenManufFacade) {
        this.RequestDimenManufFacade = RequestDimenManufFacade;
    }

    public EngRequestQuestionFacade getEngRequestQuestionFacade() {
        return engRequestQuestionFacade;
    }

    public void setEngRequestQuestionFacade(EngRequestQuestionFacade engRequestQuestionFacade) {
        this.engRequestQuestionFacade = engRequestQuestionFacade;
    }

    public EngDentFacade getEngDentFacade() {
        return engDentFacade;
    }

    public void setEngDentFacade(EngDentFacade engDentFacade) {
        this.engDentFacade = engDentFacade;
    }

    public EngDamageTypeManufactBean getEngDamageTypeManufactBean() {
        return engDamageTypeManufactBean;
    }

    public void setEngDamageTypeManufactBean(EngDamageTypeManufactBean engDamageTypeManufactBean) {
        this.engDamageTypeManufactBean = engDamageTypeManufactBean;
    }

    
    

}
