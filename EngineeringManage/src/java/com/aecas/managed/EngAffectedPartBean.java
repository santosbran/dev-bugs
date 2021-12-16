
 // To change this license header, choose License Headers in Project Properties.
 // To change this template file, choose Tools | Templates
 // and open the template in the editor.
 
package com.aecas.managed;// paquete manage

import com.aees.session.SessionBean;// importacion de clase
import com.aeroman.aees.entities.EngAffectedPart;// importacion de clase
import com.aeroman.aees.facades.EngAffectedPartFacade;// importacion de clase
import java.io.Serializable;// libreria Serializable
import java.math.BigDecimal;// libreria BigDecimal
import java.util.ArrayList;// libreria ArrayList
import java.util.Date;// libreria Date
import java.util.List;// libreria List
import java.util.logging.Level;// libreria Level
import java.util.logging.Logger;// libreria Logger
import javax.annotation.PostConstruct;// libreria PostConstruct
import javax.ejb.EJB;// libreria EJB
import javax.faces.application.FacesMessage;// libreria FacesMessage
import javax.faces.bean.ManagedBean;// libreria ManagedBean
import javax.faces.bean.ViewScoped;// libreria ViewScoped
import javax.faces.component.UIInput;// libreria Serializable
import javax.faces.component.UIViewRoot;// libreria UIInput
import javax.faces.context.FacesContext;// libreria FacesContext
import javax.servlet.http.HttpSession;// libreria HttpSession

/**
 *
 * @author mpolanco
 */
//nombre de clase en mageBean
@ManagedBean(name = "affpBean")
@ViewScoped //tipo de clase
//clase ContAtasBean con extends al crud
public class EngAffectedPartBean extends CrudBean<EngAffectedPart> implements Serializable{
    
    @EJB
    private EngAffectedPartFacade AffectedPartFacade; //declaracion de clases Facade
    
    private BigDecimal idAffectPart;//declaracion de variable
    private String userlg;//declaracion de variable
    private String nombre;//declaracion de variable
    private String descripcion;//declaracion de variable
    private boolean encontrarRepetido;//declaracion de variable
    private int pCount;//declaracion de variable
    
    //metodo generado por implements Serializable
    @Override
    //metodo constructor
    @PostConstruct
    public void init() {
        HttpSession session = SessionBean.getSession();
        setUserlg((String) session.getAttribute("username")); //captura usuario logueado
        elemento = nuevoElemento();//imicializa elemento
        listado = findAllNotDeleted();//llena listado
        edit = false;//asigna falso a edit
        setNombre(null);//asigna null a nombre
        setDescripcion(null);// asigna null descripcion
    }
//metodo generado por implements Serializable limpia el elemento y otras variables
    @Override
    public void limpiar() {
        extendtime();//extiende el tiempo de sesion
        elemento = nuevoElemento();//inicializa elemento
        listado = findAllNotDeleted();//llena listado 
        edit = false;// asigna falso a edit
        setNombre(null);//asigna nulla nombre
        setDescripcion(null);// asigna null descripcion
        setEncontrarRepetido(false);// asigna falso a repetido/
    }
//metodo generado por implements Serializable actualiza en la bd
    @Override
    public void actualizar() {
        extendtime();//extiende el tiempo de sesion
        try {//bloque controlado
            elemento.setAfpUserUpd(getUserlg()); //asigna user
            elemento.setAfpDateUpd(new Date());// assigna fecha
            elemento.setAfpName(getNombre());// asigna nombre
            elemento.setAfpDescription(getDescripcion());// asigna descripcion
            elemento.setAfpState("A");// asgina A a state
            
            if (elemento.getAfpId() != null) {//evalua null
                AffectedPartFacade.edit(elemento);//actualiza en la base de datos
                limpiar();//ejacuta limpiar 
            } else {
                FacesContext.getCurrentInstance().validationFailed();//captura error
            }

        } catch (Exception e) {//captura posibles errores
            Logger.getLogger(EngAffectedPartBean.class.getName()).log(Level.SEVERE, null, e);
            FacesContext.getCurrentInstance().validationFailed();
        }
    }
//metodo generado por implements Serializable agrega a la bd
    @Override
    public void agregar() {
        extendtime();//extiende el tiempo de sesion
        try {//bloque controlado
            setEncontrarRepetido(false);//setea falso a repetido
            
            elemento.setAfpUserAdd(getUserlg());//asigna usuario 
            elemento.setAfpDateAdd(new Date());//asigna fecha
            elemento.setAfpName(getNombre());//asigna nombre
            elemento.setAfpDescription(getDescripcion());//asigna descripcion
            elemento.setAfpState("A");//asigna A

            List<EngAffectedPart> otroEliminar = listado;//declara y asigna a la lista
            for (EngAffectedPart lis : otroEliminar) {//itera la lista
                if (lis.getAfpName().equals(elemento.getAfpName())) {//filta lista y evalua si existe
                    setEncontrarRepetido(true);//asigna verdadero
                    break;//sale de ford
                }
            }
            
            if (!isEncontrarRepetido()) {//evalua repetido
                
                if (elemento.getAfpId() == null){//verifica si el id es null
                    AffectedPartFacade.create(elemento);//crea el elemento en la bd
                    limpiar();//ejecuta el metodo
                }else
                    FacesContext.getCurrentInstance().validationFailed();//captura error si existe
            }
            else {
                FacesContext.getCurrentInstance().validationFailed();//captura error si tiene repetido
            }
        } catch (Exception e) {//captura posibles errores
            Logger.getLogger(EngAffectedPartBean.class.getName()).log(Level.SEVERE, null, e);//captura error si existe
            FacesContext.getCurrentInstance().validationFailed();//captura error si existe
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error al insertar"));//captura error si existe
        }
    }
//metodo generado por implements Serializable
    @Override
    public void eliminar(EngAffectedPart elemento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//metodo que se ejecuta de la lista    
    public void delete(String id) {
        extendtime();//extiende el tiempo de sesion
        try {//bloque controlado
            BigDecimal idAffected = new BigDecimal(id);//declara y asigna la variable
            elemento = AffectedPartFacade.find(idAffected);// asigna al elemento              
            elemento.setAfpUserDlt(getUserlg());//asigna el suario
            elemento.setAfpDateDlt(new Date());//asigna la fecha de ingreso
            elemento.setAfpState("D"); //ingrsa al estado D
            
            setpCount(AffectedPartFacade.existeEnESR(elemento.getAfpId()));//setea a count la busqueda
            
            
            if (elemento.getAfpId() != null && getpCount() == 0) {//evalua la variable count y el id
                AffectedPartFacade.edit(elemento);//edita el registro en la base dedatos
                limpiar();//ejecuta el metodo limpiar
            } else {// si no
                FacesContext.getCurrentInstance().validationFailed();// campura error para la vista
            }

        } catch (Exception e) {//captura posibles errores
            Logger.getLogger(EngAffectedPartBean.class.getName()).log(Level.SEVERE, null, e);// campura error para la vista
            FacesContext.getCurrentInstance().validationFailed();// campura error para la vista
        }
    }
//metodo generado por implements Serializable
    @Override
    public EngAffectedPart nuevoElemento() {
        return new EngAffectedPart();
    }
    //llena la lista de affected part
    public List<EngAffectedPart> findAllNotDeleted(){
        extendtime();//extiende el tiempó de sesion
        listado = new ArrayList<EngAffectedPart>(); //inicializa la variable
        listado2 = AffectedPartFacade.findAllActive();// asigna a la listado2
        for (EngAffectedPart affectpart : listado2) {//itera la lista 
            if(affectpart.getAfpState().equals("A")){//evalua el estado
                listado.add(affectpart);//agrega a listado
            }
            
        } 
        return listado; //retorna la lista
    }
    //metodo que limpia el formulario
    public void limpiarAffectedPartModal() {
        extendtime();//extiende el tiempó de sesion
        FacesContext context = FacesContext.getCurrentInstance();
        UIViewRoot root = context.getViewRoot();
        UIInput txtAfpName = (UIInput) root.findComponent("inputFormAffectPart:txtAfpName");
        txtAfpName.resetValue();
        UIInput txtAfpDescription = (UIInput) root.findComponent("inputFormAffectPart:txtAfpDescription");
        txtAfpDescription.resetValue();
    }
    
    //
     // @return the idAffectPart
     //
    //get y set de variable
    public BigDecimal getIdAffectPart() {
        return idAffectPart;
    }

    //
     // @param idAffectPart the idAffectPart to set
     ///
    //get y set de variable
    public void setIdAffectPart(BigDecimal idAffectPart) {
        this.idAffectPart = idAffectPart;
    }

    //
     // @return the userlg
     //
    //get y set de variable
    public String getUserlg() {
        return userlg;
    }

    //
     // @param userlg the userlg to set
     //
    //get y set de variable
    public void setUserlg(String userlg) {
        this.userlg = userlg;
    }

    //
     // @return the nombre
     //
    //get y set de variable
    public String getNombre() {
        return nombre;
    }

    //
     // @param nombre the nombre to set
     //
    //get y set de variable
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //
     // @return the descripcion
     //
    //get y set de variable
    public String getDescripcion() {
        return descripcion;
    }
    

    //
     // @param descripcion the descripcion to set
     //
    //get y set de variable
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    //
     // @return the encontrarRepetido
     //
    //get y set de variable
    public boolean isEncontrarRepetido() {
        return encontrarRepetido;
    }

    //
     // @param encontrarRepetido the encontrarRepetido to set
     //
    //get y set de variable
    public void setEncontrarRepetido(boolean encontrarRepetido) {
        this.encontrarRepetido = encontrarRepetido;
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
