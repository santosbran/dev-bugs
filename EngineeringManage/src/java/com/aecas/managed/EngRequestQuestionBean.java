
//  To change this license header, choose License Headers in Project Properties.
//  To change this template file, choose Tools | Templates
//  and open the template in the editor.
 
package com.aecas.managed;// paquete manage

import com.aeroman.aees.entities.EngDamageQuestion;// importacion de clase
import com.aeroman.aees.entities.EngDamageType;// importacion de clase
import com.aeroman.aees.entities.EngRequest;// importacion de clase
import com.aeroman.aees.entities.EngRequestQuestion;// importacion de clase
import com.aeroman.aees.facades.EngRequestQuestionFacade;// importacion de clase
import java.io.Serializable;// libreria Serializable
import java.util.ArrayList;// libreria ArrayList
import java.util.Date;// libreria Date
import java.util.List;// libreria List
import java.util.logging.Level;// libreria Level
import java.util.logging.Logger;// libreria Logger
import javax.annotation.PostConstruct;// libreria Serializable
import javax.ejb.EJB;// libreria Serializable
import javax.faces.bean.ManagedBean;// libreria Serializable
import javax.faces.bean.ManagedProperty;// libreria Serializable
import javax.faces.bean.SessionScoped;// libreria Serializable

/**
 *
 * @author vjuarez
 */
//nombre de clase en mageBean
@ManagedBean(name = "engRequestQuestionBean")
@SessionScoped//tipo de clase
//clase EngRequestQuestionBean con extends al crud
public class EngRequestQuestionBean extends CrudBean<EngRequestQuestion> implements Serializable {    
    @EJB
    private EngRequestQuestionFacade engRequestQuestionFacade;//declaracion de clases Facade
    
    @ManagedProperty(value = "#{damdimbean}")
    private EngDamageDimBean engDamageDimBean;//declarion variable tipo clase
    
    transient List<EngDamageType> valorDamageType; //declaracion de variable
    private boolean encontrarRepetido;//declaracion de variable
    
    private EngRequest engEr;//declaracion de variable
    private String userlg;//declaracion de variable

    @Override//metodo generado por implements Serializable
    @PostConstruct//metodo constructor
    public void init() {
        elemento = new EngRequestQuestion();
        listado = new ArrayList<>();
        listado2 = new ArrayList<>();
    }

    @Override//metodo generado por implements Serializable
    public void limpiar() {
        extendtime();//extiende el tiempo de sesion
        listado = new  ArrayList<>();
    }

    @Override//metodo generado por implements Serializable
    public void actualizar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override//metodo generado por implements Serializable
    public void agregar() {
        extendtime();//extiende el tiempo de sesion
        try {
            
            setEncontrarRepetido(false);
            List<EngRequestQuestion> otroEliminar = listado;
            for (EngRequestQuestion lis : otroEliminar) {
                for(EngDamageQuestion listaDimeciones: engDamageDimBean.getListaDamageQuestion()){
                    if (lis.getDxqId().equals(listaDimeciones.getDxqId())) {
                        setEncontrarRepetido(true);                    
                        break;
                    }  
                }
               if (isEncontrarRepetido()) {
                    break;
                } 
            }
            if (!isEncontrarRepetido()) {
                for (EngDamageQuestion listaDimeciones: engDamageDimBean.getListaDamageQuestion()) {                    
                    elemento.setReqMessageid(getEngEr()); //id de ESR 
                    elemento.setDxqId(listaDimeciones);
                    elemento.setReqUserIns(getUserlg());
                    elemento.setReqDateIns(new Date());
                    elemento.setReqValue(listaDimeciones.getResponse());
                    
                    if (elemento.getReqMessageid() != null && elemento.getReqMessageid().getReqMessageid() != null) {
                        engRequestQuestionFacade.create(elemento);
                        listado.add(elemento); 
                    }
                    else{
                        listado.add(elemento);                
                    }
                    elemento = new EngRequestQuestion();
                }                
                
            }
        } catch (Exception e) {
            Logger.getLogger(EngRequestQuestionBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void findForESR(EngRequest idesr) {
        extendtime();//extiende el tiempo de sesion
        listado = new ArrayList<>();
        listado = engRequestQuestionFacade.findDamageQuestion(idesr); 
    }


    @Override//metodo generado por implements Serializable
    public void eliminar(EngRequestQuestion elemento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override//metodo generado por implements Serializable
    public EngRequestQuestion nuevoElemento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<EngDamageType> getValorDamageType() {//get y set de variable
        return valorDamageType;
    }

    public void setValorDamageType(List<EngDamageType> valorDamageType) {//get y set de variable
        this.valorDamageType = valorDamageType;
    }

    public boolean isEncontrarRepetido() {//get y set de variable
        return encontrarRepetido;
    }

    public void setEncontrarRepetido(boolean encontrarRepetido) {//get y set de variable
        this.encontrarRepetido = encontrarRepetido;
    }  

    public EngDamageDimBean getEngDamageDimBean() {//get y set de variable
        return engDamageDimBean;
    }

    public void setEngDamageDimBean(EngDamageDimBean engDamageDimBean) {//get y set de variable
        this.engDamageDimBean = engDamageDimBean;
    }

    public EngRequest getEngEr() {//get y set de variable
        return engEr;
    }

    public void setEngEr(EngRequest engEr) {//get y set de variable
        this.engEr = engEr;
    }

    public String getUserlg() {//get y set de variable
        return userlg;
    }

    public void setUserlg(String userlg) {//get y set de variable
        this.userlg = userlg;
    }
    
    
}