
//  To change this license header, choose License Headers in Project Properties.
//  To change this template file, choose Tools | Templates
//  and open the template in the editor.

package com.aecas.managed;// paquete manage

import com.aeroman.aees.entities.EngReqTaskJobcard;// importacion de clase
import com.aeroman.aees.entities.EngRequest;// importacion de clase
import com.aeroman.aees.facades.EngReqTaskJobcardFacade;// importacion de clase
import java.io.Serializable;// libreria Serializable
import java.util.ArrayList;// libreria ArrayList
import java.util.List;// libreria List
import java.util.logging.Level;// libreria Level
import java.util.logging.Logger;// libreria Logger
import javax.annotation.PostConstruct;// libreria PostConstruct
import javax.ejb.EJB;// libreria EJB
import javax.faces.bean.ManagedBean;// libreria ManagedBean
import javax.faces.bean.SessionScoped;// libreria SessionScoped

/**
 *
 * @author vjuarez
 */
//nombre de clase en mageBean
@ManagedBean(name = "engReqTaskJobcardBean")
@SessionScoped //tipo de clase
//clase EngReqTaskJobcardBean con extends al crud
public class EngReqTaskJobcardBean extends CrudBean<EngReqTaskJobcard> implements Serializable {
    
     /**
     * Creates a new instance of PlantillasBean
     */
    @EJB
    private EngReqTaskJobcardFacade engReqTaskJobcardFacade;//declaracion de clases Facade

    private boolean encontrarRepetido;//declaracion de variable
    private String  descripcion;//declaracion de variable
    
    private EngRequest engEr;//declaracion de variable
 
    @Override//metodo generado por implements Serializable
    @PostConstruct//metodo constructor
    public void init() {
        elemento= new EngReqTaskJobcard();
        listado = new ArrayList<>();
        setDescripcion(null);
        edit = false;
        engEr = new EngRequest();
    }

    @Override//metodo generado por implements Serializable
    public void limpiar() {
        extendtime();//extiende el tiempo de sesion
        elemento = new EngReqTaskJobcard();
        setDescripcion(null);
        setEncontrarRepetido(false);
    }

    @Override//metodo generado por implements Serializable
    void actualizar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override//metodo generado por implements Serializable
    public void agregar() {
        extendtime();//extiende el tiempo de sesion
        
        try {
            
            
            encontrarRepetido = false;             
            elemento.setReqMessageid(engEr); //id de ESR                   
            List<EngReqTaskJobcard> otroEliminar = listado;
            for (EngReqTaskJobcard lis : otroEliminar) {
                if (lis.getErtjDescrip().equals(elemento.getErtjDescrip())) {
                    encontrarRepetido = true;
                    break;
                }
            }
            if (!encontrarRepetido) {
                if (elemento.getReqMessageid() != null && elemento.getReqMessageid().getReqMessageid() != null) {             
                        engReqTaskJobcardFacade.create(elemento);
                    
                }
                listado.add(elemento);                
                elemento = new EngReqTaskJobcard();
            }
            
            descripcion = listado.get(0).getErtjDescrip();
        } catch (Exception e) {
            Logger.getLogger(TaskReqCardBean.class.getName()).log(Level.SEVERE, null, e);
        } 
    }
    public void eliminarJob(EngReqTaskJobcard elementoEl) {
        listado2 = new ArrayList<>();
        for (EngReqTaskJobcard lisTed : listado) {
            if(!lisTed.getErtjDescrip().equals(elementoEl.getErtjDescrip())){
               listado2.add(lisTed);
            }
            
        }
        listado = listado2;
        listado2 = new ArrayList<>();
        
        if (elementoEl.getErtjIdReg() != null) {
                eliminar(elementoEl);                
            }     
        if (listado.size() != 0){
            setDescripcion(listado.get(0).getErtjDescrip());
        }
        else{
            setDescripcion("");
        }
    }

    @Override//metodo generado por implements Serializable
    public void eliminar(EngReqTaskJobcard elemen) {
       engReqTaskJobcardFacade.remove(elemen);
    }

    @Override//metodo generado por implements Serializable
    EngReqTaskJobcard nuevoElemento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void selectJobCard(EngRequest req)   {
        extendtime();//extiende el tiempo de sesion
        listado = engReqTaskJobcardFacade.findByEngRequest(req);
        if (listado.size()!= 0){
            setDescripcion(listado.get(0).getErtjDescrip());
        }
    }

    public String getDescripcion() {//get y set de variable
        return descripcion;
    }

    public void setDescripcion(String descripcion) {//get y set de variable
        this.descripcion = descripcion;
    }

    public boolean isEncontrarRepetido() {//get y set de variable
        return encontrarRepetido;
    }

    public void setEncontrarRepetido(boolean encontrarRepetido) {//get y set de variable
        this.encontrarRepetido = encontrarRepetido;
    }

    public EngReqTaskJobcardFacade getEngReqTaskJobcardFacade() {//get y set de variable
        return engReqTaskJobcardFacade;
    }

    public void setEngReqTaskJobcardFacade(EngReqTaskJobcardFacade engReqTaskJobcardFacade) {//get y set de variable
        this.engReqTaskJobcardFacade = engReqTaskJobcardFacade;
    }

    public EngRequest getEngEr() {//get y set de variable
        return engEr;
    }

    public void setEngEr(EngRequest engEr) {//get y set de variable
        this.engEr = engEr;
    }
    
}
