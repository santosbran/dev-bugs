
 // To change this license header, choose License Headers in Project Properties.
 // To change this template file, choose Tools | Templates
// and open the template in the editor.

package com.aecas.managed;// paquete manage

import com.aeroman.aees.entities.EngActor;// importacion de clase
import com.aeroman.aees.facades.EngActorFacade;// importacion de clase
import java.io.Serializable;// libreria Serializable
import java.math.BigDecimal;// libreria BigDecimal
import java.util.ArrayList;// libreria ArrayList
import java.util.List;// libreria List
import java.util.logging.Level;// libreria Level
import java.util.logging.Logger;// libreria Logger
import javax.annotation.PostConstruct;// libreria PostConstruct
import javax.ejb.EJB;// libreria EJB
import javax.faces.bean.ManagedBean;// libreria ManagedBean
import javax.faces.bean.SessionScoped;// libreria SessionScoped
import javax.faces.context.FacesContext;// libreria FacesContext

/**
 *
 * @author vjuarez
 */
//nombre de clase en mageBean
@ManagedBean(name = "engActorBean")
@SessionScoped
//tipo de clase
//clase ContAtasBean con extends al crud
public class EngActorBean extends CrudBean<EngActor> implements Serializable {

    private String idActor;//declaracion de variable
    private boolean encontrarRepetido;//declaracion de variable
    private int pCount;//declaracion de variable

    @EJB
    private EngActorFacade engActorFacade;//declaracion de clases Facade

    //metodo generado por implements Serializable
    @Override
    //metodo constructor
    @PostConstruct
    public void init() {
        listado = new ArrayList<>();//inicializa listado
        elemento = new EngActor();//inicializa elemento
        idActor = null;//asigna null a la variable
        edit = false;//asigna falso a variable
        encontrarRepetido = false;//asigna falso a repetido
        findActor();//ejecuta metodo para buscar Actor
    }
//metodo generado por implements Serializable limpia el elemento y otras variable
    @Override
    public void limpiar() {
        extendtime();//extiende el tiempo de sesion
        elemento = new EngActor();//inicializa el elemento
        idActor = null;// asigna null al id del actor
        edit = false;// asigna dalso ala variable edit
        encontrarRepetido = false;//asigna falso a repetido
        findActor();//ejecuta metodo de busqueda de actores
    }
//metodo busqueda de actores
    public void findActor() {
        extendtime();//extiende el tiempo de sesion
        try {//bloque controlado
            listado = engActorFacade.findAll();//asigna a listado la busquede de actores
        } catch (Exception e) {//captura posibles errores
            Logger.getLogger(EngActorBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }
//busqueda por actor
    public void findByActor() {
        extendtime();//extiende el tiempo de sesion
        try {//bloque controlado
            BigDecimal id = new BigDecimal(idActor);//declara y asigna variable big decimal
            elemento = engActorFacade.findbyActorID(id);// asigna elemento la busqueda de actor
        } catch (Exception e) {//captura posibles errores
            Logger.getLogger(EngActorBean.class.getName()).log(Level.SEVERE, null, e);
        }

    }
//metodo generado por implements Serializable actualiza en la bd
    @Override
    public void actualizar() {
        extendtime();//extiende el tiempo de sesion
        try {//bloque controlado
            encontrarRepetido = false;//asigna falso a la variable
            for (EngActor listaActor1 : listado) {//itera la lista 
                if (listaActor1.getActCode().equals(elemento.getActCode()) && listaActor1.getActId() != elemento.getActId()) {//filtra la lista si existe
                    encontrarRepetido = true;//asigna verdadero a la variable
                    findActor();//busco actor 
                    FacesContext.getCurrentInstance().validationFailed();// ingresa error
                    break;//salir del for
                }

            }
            if (!encontrarRepetido) {//evalua repetido
                engActorFacade.edit(elemento);//actualiza elemento en la bd
                findActor();//ejecuta metodo de busqueda de actores
                limpiar();//ejecuta el metodo limpiar
            }

        } catch (Exception e) {//captura posibles errores
            Logger.getLogger(EngActorBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }
//metodo generado por implements Serializable 
    @Override
    public void agregar() {
        extendtime();//extiende el tiempo de sesion
        try {//bloque controlado
            encontrarRepetido = false;//asigna falso a la variable
            List<EngActor> listaActor = listado;//variable de lista
            for (EngActor listaActor1 : listaActor) {//itera la lista
                if (listaActor1.getActCode().equals(elemento.getActCode())) {//evalua lista de actor
                    encontrarRepetido = true;// asigna verdadero a repetido
                    break;//sale del ford
                }

            }
            if (!encontrarRepetido) {//evalua repetido
                engActorFacade.create(elemento);//crea elemento en la bd
                findActor();//ejecuta metodo de busqueda de actores
                limpiar();//ejecuta el metodo limpiar
            }

        } catch (Exception e) {//captura posibles errores
            Logger.getLogger(EngActorBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }
//mmetodo que ejecuta la vista
    public void deleteActor() {
        extendtime();//extiende el tiempo de sesion
        setpCount(engActorFacade.existeEnDisposition(elemento.getActId()));//asigna a valiable count si existe
                
        if (getpCount() == 0) {
            eliminar(elemento);//ejecuta metodo de elinar
            findActor();//ejecuta metodo de busqueda de actores
            limpiar();//ejecuta el metodo limpiar
        } else {
            FacesContext.getCurrentInstance().validationFailed();//captura error
        }
    }
//metodo generado por implements Serializable 
    @Override
    public void eliminar(EngActor elemento) {
        extendtime();//extiende el tiempo de sesion
        try {//bloque controlado
            engActorFacade.remove(elemento);//eleimina elemento de la BD
        } catch (Exception e) {//captura posibles errores
            Logger.getLogger(EngActorBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }
//metodo generado por implements Serializable 
    @Override
    EngActor nuevoElemento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//get y set de variable
    public String getIdActor() {
        return idActor;
    }
//get y set de variable
    public void setIdActor(String idActor) {
        this.idActor = idActor;
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
    public EngActorFacade getEngActorFacade() {
        return engActorFacade;
    }
//get y set de variable
    public void setEngActorFacade(EngActorFacade engActorFacade) {
        this.engActorFacade = engActorFacade;
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
