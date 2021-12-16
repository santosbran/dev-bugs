/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aecas.managed;
import java.io.Serializable;
import com.aeroman.aees.entities.EngPartMat;
import com.aeroman.aees.facades.EngPartMatFacade;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import javax.faces.bean.ViewScoped;
/**
 *
 * @author QC_01
 */
@ManagedBean(name = "partMatbean")
@ViewScoped 
public class PartMatbean extends CrudBean<EngPartMat> implements Serializable{
@EJB 
private EngPartMatFacade engPartMat2Facade;
    @Override
    @PostConstruct
    public void init() 
    {
        elemento =new EngPartMat();
        listado=engPartMat2Facade.findAll();
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
   public void limpiar() {
       extendtime();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.elemento=new EngPartMat();
        edit=false;
    }
   
    public void buscarlista(long ideo){
        extendtime();
        listado=engPartMat2Facade.findByeoid(ideo);   
    }

    @Override
   public void actualizar() {
       extendtime();
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    if(engPartMat2Facade.find(elemento.getPmtId())!=null)
    {
    engPartMat2Facade.edit(elemento);
    elemento=new EngPartMat();
    this.edit=false;
            
    }
    else{
    FacesContext.getCurrentInstance().validationFailed();
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El elemento que esta tratando de editar no existe en la base de datos"));
    }
        
        
    }

    @Override
  public void agregar() {
      extendtime();
                //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
              if(engPartMat2Facade.find(elemento.getPmtId())!=null){
              FacesContext.getCurrentInstance().validationFailed();
              FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El identificador unico se encuentra repetido"));   
    } else
              {
            engPartMat2Facade.create(elemento);
            listado.add(elemento);
            elemento=new EngPartMat();
     }
    }

    @Override
   public void eliminar(EngPartMat elemento) {
       extendtime();
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    if(engPartMat2Facade.find(elemento.getPmtId())!=null){
    engPartMat2Facade.remove(elemento);
    listado.remove(elemento);
    }
    }

    @Override
    EngPartMat nuevoElemento() 
    {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    return new EngPartMat();
    
    }

    
    
}
