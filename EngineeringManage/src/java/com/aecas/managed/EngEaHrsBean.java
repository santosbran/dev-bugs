 // To change this license header, choose License Headers in Project Properties.
 // To change this template file, choose Tools | Templates
 // and open the template in the editor.
package com.aecas.managed;// paquete manage

import com.aeroman.aees.entities.EngHrsIns;// importacion de clase
import com.aeroman.aees.facades.EngEaHrsInsFacade;// importacion de clase
import java.io.Serializable;// libreria Serializable
import javax.annotation.PostConstruct;// libreria PostConstruct
import javax.ejb.EJB;// libreria EJB
import javax.faces.bean.ViewScoped;// libreria ViewScoped
import javax.faces.bean.ManagedBean;// libreria ManagedBean

/**
 *
 * @author APLICATIVA_01
 */
//nombre de clase en mageBean
@ManagedBean(name = "engEaHrsBean")
@ViewScoped //tipo de clase
//clase ContAtasBean con extends al crud
public class EngEaHrsBean extends CrudBean<EngHrsIns>implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @EJB
    private EngEaHrsInsFacade engEaHrsInsFacade;//declaracion de clases Facade
    
    //metodo generado por implements Serializable
    @Override
    //metodo constructor
    @PostConstruct
    public void init() {
        extendtime();
        elemento = new EngHrsIns();
        listado = engEaHrsInsFacade.findAll();
    
    }
    

//metodo generado por implements Serializable
    @Override
    public void actualizar() {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
        
    }
    //metodo generado por implements Serializable
    @Override
    public void limpiar() {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
      
    }

    
//metodo generado por implements Serializable
    @Override
    public void eliminar(EngHrsIns elemento) {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
       
    }
    //metodo generado por implements Serializable
    @Override
    public void agregar() {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
      
    }
//metodo generado por implements Serializable
    @Override
    public EngHrsIns nuevoElemento() {
        return new EngHrsIns();
    }
}
