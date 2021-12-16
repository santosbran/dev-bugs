 // To change this license header, choose License Headers in Project Properties.
 // To change this template file, choose Tools | Templates
 // and open the template in the editor.
package com.aecas.managed;// paquete manage

import com.aees.session.SessionBean;// libreria SessionBean
import com.aeroman.aees.entities.EngEoRef;// importacion de clase
import com.aeroman.aees.entities.EngEoRefPK;// importacion de clase
import com.aeroman.aees.facades.EngEoRefFacade;// importacion de clase
import com.aeroman.aees.facades.Sequences;// importacion de clase
import java.io.Serializable;// libreria Serializable
import java.util.ArrayList;// libreria ArrayList
import java.util.Calendar;// libreria Calendar
import java.util.GregorianCalendar;// libreria GregorianCalendar
import java.util.List;// libreria List
import javax.annotation.PostConstruct;// libreria PostConstruct
import javax.ejb.EJB;// libreria EJB
import javax.faces.application.FacesMessage;// libreria FacesMessage
import javax.faces.bean.ManagedBean;// libreria ManagedBean
import javax.faces.bean.ViewScoped;// libreria ViewScoped
import javax.faces.context.FacesContext;// libreria FacesContext
import javax.servlet.http.HttpSession;// libreria HttpSession

/**
 *
 * @author APLICATIVA_01
 */
//nombre de clase en mageBean
@ManagedBean(name = "engEoRefBean")
@ViewScoped //tipo de clase
//clase ContAtasBean con extends al crud



public class EngEoRefBean extends CrudBean<EngEoRef> implements Serializable{
 transient List<EngEoRef> engEoRefList=new ArrayList();//declaracion de variable
 EngEoRefPK llave;//declaracion de variable
 transient List<EngEoRef> listmex=new ArrayList();//declaracion de variable
    

    @EJB
    private EngEoRefFacade engEoRefFacade;//declaracion de clases Facade
    private String valor; //declaracion de variable
    private int maximo;//declaracion de variable
    private int maximo2;//declaracion de variable
    
    @Override
    @PostConstruct
    public void init() {     
        elemento = new EngEoRef ();
        llave=new EngEoRefPK();
        
    
    }  
    
    @Override
    
    public void limpiar() { 
        extendtime();
        this.elemento = new EngEoRef();
        edit = false;
    }

    @Override
    public void actualizar() {
        extendtime();
        if (engEoRefFacade.find(elemento.getEngEoRefPK()) != null){
            
            HttpSession session = SessionBean.getSession(); 
            elemento.setRefUserUpd((String)session.getAttribute("username"));//usuario que modifica
            Calendar fechaUp = new GregorianCalendar();           
            elemento.setRefDateUpd(fechaUp.getTime()); //fecha en que se modifica
            llave=elemento.getEngEoRefPK();
            elemento.setEngEoRefPK(llave);
            engEoRefFacade.edit(elemento);
            elemento = new EngEoRef();
            this.edit = false;
        } else {
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El elemento que esta tratando de editar no existe en la base de datos"));
        }
    }

   @Override
    public void agregar() {
        extendtime();
            HttpSession session = SessionBean.getSession(); 
            elemento.setRefUserIns((String)session.getAttribute("username"));//usuario que inserta
            Calendar fechaIns = new GregorianCalendar();
            elemento.setRefFechaIns(fechaIns.getTime()); //fecha en que se inserta
        
            Sequences seq = new Sequences();   /////  
            maximo=seq.maxCodID();             // la secuencia para el codigo del documento
            maximo2=seq.maxSecNum();           // la secuencia del id
            
            llave.setCodId(Integer.toString(maximo));
            llave.setSecNum((short)maximo2);
            elemento.setEngEoRefPK(llave);
            
            engEoRefFacade.create(elemento);
            engEoRefList.add(elemento);
            elemento = new EngEoRef();
        
    }

    @Override
    public void eliminar(EngEoRef elemento) {
        extendtime();
        if (engEoRefFacade.find(elemento.getEngEoRefPK()) != null){
            engEoRefFacade.remove(elemento);
            engEoRefList.remove(elemento);
        }
    }

    @Override
    public EngEoRef nuevoElemento() {
        return new EngEoRef ();
    }
     
      public Object findSelect(String id){
          extendtime();
 
          elemento=new EngEoRef();
          listado= engEoRefFacade.findAll();
          
          valor=id;
          int x = 0;
          while (x < listado.size()) {
          EngEoRef company = (EngEoRef) listado.get(x);
          
          long orden=company.getEngEoRefPK().getEoIdord();
          String ids=Long.toString(orden);
          if(ids.equals(id)) {
                listmex.add(company);
                } 
            x++;
            }//fin while
        engEoRefList.clear();
        engEoRefList.addAll(listmex);
        listmex.clear();
        return elemento;
    }
      //get y set de variable
    public EngEoRefPK getLlave() {
        return llave;
    }
//get y set de variable
    public void setLlave(EngEoRefPK llave) {
        this.llave = llave;
    }

//get y set de variable
    public List<EngEoRef> getListado2() {
        return engEoRefList;
    }
//get y set de variable
    public void setListado2(List<EngEoRef> listado2) {
        this.engEoRefList = listado2;
    }
//get y set de variable
    public List<EngEoRef> getListmex() {
        return listmex;
    }
//get y set de variable
    public void setListmex(List<EngEoRef> listmex) {
        this.listmex = listmex;
    }
//get y set de variable
    public int getMaximo() {
        return maximo;
    }
//get y set de variable
    public void setMaximo(int maximo) {
        this.maximo = maximo;
    }
//get y set de variable
    public int getMaximo2() {
        return maximo2;
    }
//get y set de variable
    public void setMaximo2(int maximo2) {
        this.maximo2 = maximo2;
    }
    
    //get y set de variable
    public String getValor() {
        return valor;
    }
//get y set de variable
    public void setValor(String valor) {
        this.valor = valor;
    }
}