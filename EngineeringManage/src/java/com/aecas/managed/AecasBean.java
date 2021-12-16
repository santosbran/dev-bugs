/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aecas.managed;

import com.aeroman.aees.entities.AecasEsrMh;// importacion de clase
import com.aeroman.aees.entities.AecasEsrMhPK;// importacion de clase
import com.aeroman.aees.facades.AecasEsrMhFacade;// importacion de clase
import java.io.Serializable;// libreria seralizable
import javax.annotation.PostConstruct;// libreria PostConstruct
import javax.ejb.EJB;// libreria EJB
import javax.faces.bean.ManagedBean;// libreria ManagedBean
import javax.faces.bean.SessionScoped;// libreria SessionScoped

/**
 *
 * @author saplic
 */
//nombre de clase en mageBean
@ManagedBean(name = "aecasBean")
@SessionScoped//tipo de clase
//clase AECASBeas con extends al crud
public class AecasBean extends CrudBean<AecasEsrMh> implements Serializable{
    @EJB
    private AecasEsrMhFacade aecasEsrMhFacade; //declaracion de clases Facade
    
    private AecasEsrMhPK aecasEsrMhPK;//declarion variable tipo clase
    private String notsupAEC="Not supported yet."; //declaracion de variable
//metodo generado por implements Serializable
    @Override
    //constructor de la clase
    @PostConstruct
    public void init() {
        extendtime();
        elemento=new AecasEsrMh();
        aecasEsrMhPK =new AecasEsrMhPK();
    }
    //limpa la variable tipo clase
    public void nuevoAecasPK(){
        extendtime();
        aecasEsrMhPK =new AecasEsrMhPK();
    }
    //metodo generado por implements Serializable
    @Override
    void limpiar() {
        throw new UnsupportedOperationException(notsupAEC); //To change body of generated methods, choose Tools | Templates.
    }
//metodo generado por implements Serializable el cual actualiza
    @Override
    public void actualizar() {
        extendtime();
        elemento.setAecasEsrMhPK(aecasEsrMhPK);
        aecasEsrMhFacade.edit(elemento);
        elemento = new AecasEsrMh();
    }
//metodo generado por implements Serializable el cual agrega AECAS
    @Override
    public void agregar() {
        extendtime();
        elemento.setAecasEsrMhPK(aecasEsrMhPK);
        aecasEsrMhFacade.create(elemento);
        elemento = new AecasEsrMh();

    }
//metodo generado por implements Serializable
    @Override
    void eliminar(AecasEsrMh elemento) {
        throw new UnsupportedOperationException(notsupAEC); //To change body of generated methods, choose Tools | Templates.
    }
//metodo generado por implements Serializable
    @Override
    AecasEsrMh nuevoElemento() {
        throw new UnsupportedOperationException(notsupAEC); //To change body of generated methods, choose Tools | Templates.
    }
//get y set de variable
    public AecasEsrMhPK getAecasEsrMhPK() {
        return aecasEsrMhPK;
    }

    public void setAecasEsrMhPK(AecasEsrMhPK aecasEsrMhPK) {
        this.aecasEsrMhPK = aecasEsrMhPK;
    }
//get y set de variable
    public String getNotsupAEC() {
        return notsupAEC;
    }

    public void setNotsupAEC(String notsupAEC) {
        this.notsupAEC = notsupAEC;
    }
    
}
