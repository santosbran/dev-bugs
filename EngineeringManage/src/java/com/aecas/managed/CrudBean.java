/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aecas.managed;

import java.util.List;
import javax.faces.context.FacesContext;

/**
 *
 * @author marcel
 */
public abstract class CrudBean<T> {
    
    protected T elemento;
    protected List<T> listado;
    protected List<T> listadoEng;
    protected List<T> listadoCus;
    protected List<T> listadoTask;
    protected List<T> listado2;
    protected List<T> listado3;
    protected boolean edit;
    
    public CrudBean() { 
        super();
    }

    public List<T> getListadoCus() {
        return listadoCus;
    }

    public void setListadoCus(List<T> listadoCus) {
        this.listadoCus = listadoCus;
    }

    public List<T> getListadoTask() {
        return listadoTask;
    }

    public void setListadoTask(List<T> listadoTask) {
        this.listadoTask = listadoTask;
    }

    public List<T> getListado2() {
        return listado2;
    }

    public void setListado2(List<T> listado2) {
        this.listado2 = listado2;
    }

    public List<T> getListado3() {
        return listado3;
    }

    public void setListado3(List<T> listado3) {
        this.listado3 = listado3;
    }
    

    public List<T> getListadoEng() {
        return listadoEng;
    }

    public void setListadoEng(List<T> listadoEng) {
        this.listadoEng = listadoEng;
    }
    
    
    
    
    public T getElemento(){
        return elemento;
    }
    
    public void setElemento(T elemento){
        this.elemento = elemento;
    }
    
    public List<T> getListado(){
        return listado;
    }
    
    public void setListado(List<T> listado){
        this.listado = listado;
    }
    
    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }
    
    public void guardar(){
        
        if (edit){
            
            actualizar();
        } else {
            agregar();
        }
        
    }
    /*este metodo sirve para volver a extender el tiempo de inactividad a 15 minutos
    despued de realizar alguna accion dentro de un bean*/
    public void extendtime(){
        FacesContext faces = FacesContext.getCurrentInstance();
        if(faces != null)
            faces.getExternalContext().setSessionMaxInactiveInterval(10800);
    }
    
    /* Métodos abstractos a implementar por las clases
     * debe incluirse la anotación @Override en la implementación
     */
    abstract void init(); //metodo para la inicialización, debe llevar anotación @PostConstruct
    
    abstract void limpiar(); //limpia el contenido del elemento
    
    abstract void actualizar(); //guarda los cambios efectuados al elemento editado
    
    abstract void agregar(); //guarda un nuevo elemento
    
    abstract void eliminar(T elemento); //elimina un elemento
    
    abstract T nuevoElemento(); //genera una nueva instancia para poder asignarla
}
