
 // To change this license header, choose License Headers in Project Properties.
 // To change this template file, choose Tools | Templates
 // and open the template in the editor.

package com.aecas.managed;// paquete manage

import com.aeroman.aees.entities.CoreAircraftType;// importacion de clase
import com.aeroman.aees.facades.CoreAircraftTypeFacade;// importacion de clase
import java.io.Serializable;// libreria Serializable
import java.util.ArrayList;// libreria ArrayList
import javax.annotation.PostConstruct;// libreria PostConstruct
import javax.ejb.EJB;// libreria EJB
import javax.faces.bean.ManagedBean;// libreria ManagedBean
import javax.faces.bean.SessionScoped;// libreria SessionScoped

/**
 *
 * @author vjuarez
 */
//nombre de clase en mageBean
@ManagedBean(name = "coreAircraftTypeBean")
@SessionScoped//tipo de clase
//clase ContAtasBean con extends al crud
public class CoreAircraftTypeBean extends CrudBean<CoreAircraftType> implements Serializable{

    @EJB
    private CoreAircraftTypeFacade coreAircraftTypeFacade;//declaracion de clases Facade
    //metodo generado por implements Serializable   
    @Override
    //metodo constructor
    @PostConstruct
    public void init() {
        listado= new ArrayList<>();
        listado= coreAircraftTypeFacade.findAll();
    }
//metodo generado por implements Serializable 
    @Override
    public void limpiar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//metodo generado por implements Serializable 
    @Override
    public void actualizar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//metodo generado por implements Serializable 
    @Override
    public void agregar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//metodo generado por implements Serializable 
    @Override
    public void eliminar(CoreAircraftType elemento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//metodo generado por implements Serializable 
    @Override
    public CoreAircraftType nuevoElemento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
// get y set de variable
    public CoreAircraftTypeFacade getCoreAircraftTypeFacade() {
        return coreAircraftTypeFacade;
    }
// get y set de variable
    public void setCoreAircraftTypeFacade(CoreAircraftTypeFacade coreAircraftTypeFacade) {
        this.coreAircraftTypeFacade = coreAircraftTypeFacade;
    }
    
    
}
