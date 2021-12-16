 // To change this license header, choose License Headers in Project Properties.
 // To change this template file, choose Tools | Templates
 // and open the template in the editor.
package com.aecas.managed;// paquete manage

import com.aeroman.aees.entities.EngDamageDim;// importacion de clase
import com.aeroman.aees.entities.EngDamageType;// importacion de clase
import com.aeroman.aees.entities.EngDent;// importacion de clase
import com.aeroman.aees.entities.EngRequest;// importacion de clase
import com.aeroman.aees.facades.EngDamageDimFacade;// importacion de clase
import com.aeroman.aees.facades.EngDamageTypeFacade;// importacion de clase
import com.aeroman.aees.facades.EngDentFacade;// importacion de clase
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

/**
 *
 * @author vjuarez
 */
//nombre de clase en mageBean
@ManagedBean(name = "engDentBean")
@SessionScoped //tipo de clase
//clase ContAtasBean con extends al crud
public class EngDentBean extends CrudBean<EngDent> implements Serializable {
    
    @EJB
    private EngDamageTypeFacade engDamageTypeFacade;//declaracion de clases Facade
    @EJB
    private EngDentFacade engDentFacade;//declaracion de clases Facade
    
    private EngRequest engEr;//declaracion de variable
    
    
    private boolean encontrarRepetido;//declaracion de variable
    
    private String idDamageType;//declaracion de variable

    //metodo generado por implements Serializable
    @Override
    //metodo constructor
    @PostConstruct
    public void init() {
        elemento = new EngDent();
        listado = new ArrayList<>();
        listado2 = new ArrayList<>();
    }

    @Override
    public void limpiar() {
        extendtime();
        elemento = new EngDent();
        listado = new ArrayList<>();
        listado2 = new ArrayList<>();
    }
    
    public void limpiarLista(){
        extendtime();
        listado2 = new ArrayList<>();
    }

    @Override
    void actualizar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void findForESR(EngRequest idesr) {
        extendtime();
        listado = new ArrayList<>();
        listado = engDentFacade.findRequestDent(idesr); 
    }

    @Override
    public void agregar() {
        extendtime();
        try {
            
            setEncontrarRepetido(false);
            BigDecimal idDamage = new BigDecimal(getIdDamageType());
            EngDamageType engDamageType = engDamageTypeFacade.find(idDamage);
            elemento.setDatId(engDamageType);
            elemento.setReqMessageid(getEngEr()); //id de ESR 
            for (EngDent lis : listado) {
           
                if (lis.getDatId().getDatId().toString().equals(elemento.getDatId().getDatId().toString())) {
                    setEncontrarRepetido(true);                    
                    break;
                }            
                
            }
            if (!isEncontrarRepetido()) {
                    
                    
                                        
                    
                    if (elemento.getReqMessageid() != null && elemento.getReqMessageid().getReqMessageid() != null) {
                        engDentFacade.create(elemento);
                        listado.add(elemento);
                    }
                    else{
                        listado.add(elemento);                
                    }
                    elemento = new EngDent();
                            
                
            }
        } catch (Exception e) {
            Logger.getLogger(EngDentBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    void eliminar(EngDent elemento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    EngDent nuevoElemento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 //get y set de variable
    public EngRequest getEngEr() {
        return engEr;
    }
 //get y set de variable
    public void setEngEr(EngRequest engEr) {
        this.engEr = engEr;
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
    public String getIdDamageType() {
        return idDamageType;
    }
 //get y set de variable
    public void setIdDamageType(String idDamageType) {
        this.idDamageType = idDamageType;
    }
    
    
}
