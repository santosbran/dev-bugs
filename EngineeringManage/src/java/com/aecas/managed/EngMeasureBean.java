 // To change this license header, choose License Headers in Project Properties.
 // To change this template file, choose Tools | Templates
 // and open the template in the editor.
package com.aecas.managed;// paquete manage

import com.aeroman.aees.entities.EngMeasure;// importacion de clase
import com.aeroman.aees.facades.EngMeasureFacade;// importacion de clase
import java.io.Serializable;// libreria Serializable
import java.util.ArrayList;// libreria ArrayList
import java.util.List;// libreria List
import java.util.logging.Level;// libreria Level
import java.util.logging.Logger;// libreria Logger
import javax.annotation.PostConstruct;// libreria PostConstruct
import javax.ejb.EJB;// libreria EJB
import javax.faces.application.FacesMessage;// libreria FacesMessage
import javax.faces.bean.ManagedBean;// libreria ManagedBean
import javax.faces.bean.SessionScoped;// libreria SessionScoped
import javax.faces.context.FacesContext;// libreria FacesContext

/**
 *
 * @author vjuarez
 */
//nombre de clase en mageBean
@ManagedBean(name = "engMeasureBean")//nombre de clase en mageBean
@SessionScoped //tipo de clase
public class EngMeasureBean extends CrudBean<EngMeasure> implements Serializable{//clase ContAtasBean con extends al crud
    
    @EJB
    private EngMeasureFacade engMeasureFacade;//declaracion de clases Facade
    private int pCount;//declaracion de variable

    private boolean encontrarRepetido;//declaracion de variable
    
    
    @Override//metodo generado por implements Serializable
    @PostConstruct    //metodo constructor
    void init() {
        listado = new ArrayList<>();
        elemento = new EngMeasure();        
        listado = engMeasureFacade.findAllTaskListView();
        encontrarRepetido=false;
        
    }

    @Override
    public void limpiar() {   
        extendtime();
         elemento = new EngMeasure();
         encontrarRepetido=false;
    }

    @Override//metodo generado por implements Serializable
    void actualizar() {
        extendtime();
          try {
        encontrarRepetido=false;
        List<EngMeasure> listaMeasure = listado;
            for (EngMeasure lis : listaMeasure) {
                if (lis.getEngMeasure().equals(elemento.getEngMeasure()) && lis.getEngId()!= elemento.getEngId()) {
                    setEncontrarRepetido(true);
                    break;
                }
                
            }
        if (!isEncontrarRepetido()) {
             engMeasureFacade.edit(elemento);
             listado = engMeasureFacade.findAll();
             elemento =new EngMeasure();
         }  
        } catch (Exception e) {
            Logger.getLogger(EngMeasureBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override//metodo generado por implements Serializable
    public void agregar() {
        extendtime();
        try {
            encontrarRepetido = false;
            List<EngMeasure> listaMeasure = listado;
            for (EngMeasure lis : listaMeasure) {
                if (lis.getEngMeasure().equals(elemento.getEngMeasure())) {
                    setEncontrarRepetido(true);
                     FacesContext.getCurrentInstance().validationFailed();
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Exists Date"));
                    break;
                }

            }
            if (!isEncontrarRepetido()) {
                engMeasureFacade.create(elemento);
                listado.add(elemento);
                elemento =new EngMeasure();
            }
        } catch (Exception e) {
            Logger.getLogger(EngMeasureBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void deleteMeasure(){//metodo generado por implements Serializable
        extendtime();
        eliminar(elemento);
    }
    
    @Override//metodo generado por implements Serializable
    public void eliminar(EngMeasure elemento) {
        extendtime();
        try {
            
            elemento = engMeasureFacade.find(elemento.getEngId());
            setpCount(engMeasureFacade.existeEnESR(elemento.getEngMeasure()));
            
            
            if (getpCount() == 0) {
                engMeasureFacade.remove(elemento);
                listado = engMeasureFacade.findAll();
                elemento =new EngMeasure();
            } else {
                FacesContext.getCurrentInstance().validationFailed();
            }
            
        } catch (Exception e) {
            Logger.getLogger(EngMeasureBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override//metodo generado por implements Serializable
    EngMeasure nuevoElemento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean isEncontrarRepetido() {//get y set de variable
        return encontrarRepetido;
    }

    public void setEncontrarRepetido(boolean encontrarRepetido) {//get y set de variable
        this.encontrarRepetido = encontrarRepetido;
    }
    
    public int getpCount() {
        return pCount;
    }

    public void setpCount(int pCount) {//get y set de variable
        this.pCount = pCount;
    }
    
}
