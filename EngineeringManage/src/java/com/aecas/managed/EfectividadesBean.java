
// * To change this license header, choose License Headers in Project Properties.
 //* To change this template file, choose Tools | Templates
// * and open the template in the editor.

package com.aecas.managed;// paquete manage

import com.aees.session.SessionBean;// importacion de clase
import com.aeroman.aees.entities.EngEffectivities;// importacion de clase
import com.aeroman.aees.facades.EngEffectivitiesFacade;// importacion de clase
import com.aeroman.aees.facades.Sequences;// importacion de clase
import java.io.Serializable;// libreria File
import java.util.ArrayList;// libreria File
import java.util.Calendar;// libreria File
import java.util.GregorianCalendar;// libreria File
import java.util.List;// libreria File
import javax.annotation.PostConstruct;// libreria File
import javax.ejb.EJB;// libreria File
import javax.faces.application.FacesMessage;// libreria File
import javax.faces.bean.ManagedBean;// libreria File
import javax.faces.bean.ViewScoped;// libreria File
import javax.faces.context.FacesContext;// libreria File
import javax.servlet.http.HttpSession;// libreria File

/**
 *
 * @author Usuario
 */
//nombre de clase en mageBean
@ManagedBean(name = "efectividadesBean")
@ViewScoped //tipo de clase
//clase ContAtasBean con extends al crud
public class EfectividadesBean extends CrudBean<EngEffectivities> implements Serializable{

    transient List<Integer> iodor = new ArrayList(); //variable de lista
    @EJB
    private EngEffectivitiesFacade engEffectivities;//declaracion de clases Facade

    //metodo generado por implements Serializable
    @Override
    //metodo constructor
    @PostConstruct
    public void init() {
        elemento = new EngEffectivities();//inicicializa el elemento
        listado = engEffectivities.findAll();  //llena listado
       Sequences sec = new Sequences();
       iodor=sec.iodor();
    }
//metodo generado por implements Serializable limpia el elemento y otras variables
    @Override
    public void limpiar() {// 
        extendtime();//extiente el tiempo
         this.elemento = new EngEffectivities();
        edit = false;
    }
    // busca por id
    public void buscarlista(long ideo){
        extendtime();
        listado=engEffectivities.findByeoid(ideo); //agrega a la lista
    }
//metodo generado por implements Serializable actualiza en la BD
    @Override
    public void actualizar() {
        extendtime();//extiende el tiempo de sesion
        if (engEffectivities.find(elemento.getEffId()) != null){
             HttpSession session = SessionBean.getSession();
            elemento.setEffUserUpd((String)session.getAttribute("username"));
            Calendar fechaUp = new GregorianCalendar();           
            elemento.setEffDateUpd(fechaUp.getTime());
            engEffectivities.edit(elemento); //actualiza el elemento en la base de datos
            elemento = new EngEffectivities();
            this.edit = false;
        } else {
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El elemento que esta tratando de editar no existe en la base de datos"));
        }
    }
//metodo generado por implements Serializable agrega a la base de datos
    @Override
    public void agregar() {
        extendtime();// esxtiende el tiempo en la sesion
        Sequences sec = new Sequences();
        elemento.setEffId(sec.getMaxIdEffectivities());
         if (engEffectivities.find(elemento.getEffId()) != null){
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El identificador unico se encuentra repetido"));
        } else {
            HttpSession session = SessionBean.getSession();
            elemento.setEffUserIns((String)session.getAttribute("username"));
            Calendar fechaIns = new GregorianCalendar();  
            elemento.setEffDateIns(fechaIns.getTime());
            engEffectivities.create(elemento);
            listado.add(elemento);//agrega a la lista
            elemento = new EngEffectivities();
        }
    }
//metodo generado por implements Serializable elimina el elemento de la BD
    @Override
    public void eliminar(EngEffectivities elemento) {
        extendtime();
            if (engEffectivities.find(elemento.getEffId()) != null){
                engEffectivities.remove(elemento);//eliminda de la bd
                listado.remove(elemento);//remover de la lista
            }
    }
//metodo generado por implements Serializable
    @Override
    public EngEffectivities nuevoElemento() {
        return new EngEffectivities();
    }

//get y set de variable
    public List<Integer> getIodor() {
        return iodor;
    }
//get y set de variable
    public void setIodor(List<Integer> iodor) {
        this.iodor = iodor;
    }
    
    
}
