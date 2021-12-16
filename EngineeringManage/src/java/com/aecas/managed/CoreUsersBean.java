
 // To change this license header, choose License Headers in Project Properties.
 // To change this template file, choose Tools | Templates
 // and open the template in the editor.

package com.aecas.managed;// paquete manage

import com.aeroman.aees.entities.EngListView;// importacion de clase
import com.aeroman.aees.entities.grant.SgrCia;
import com.aeroman.aees.facades.EngListViewFacade;// importacion de clase
import com.aeroman.aees.facades.grant.SgrCiaFacade;
import com.aeroman.aees.facades.grant.SgrUserFacades;
import java.io.Serializable;// libreria Serializable
import java.util.ArrayList;// libreria ArrayList
import java.util.List;// libreria List
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;// libreria PostConstruct
import javax.ejb.EJB;// libreria EJB
import javax.faces.application.FacesMessage;// libreria FacesMessage
import javax.faces.bean.ManagedBean;// libreria ManagedBean
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;// libreria ViewScoped
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;// libreria FacesContext

/**
 *
 * @author pc
 */
//nombre de clase en mageBean
@ManagedBean(name = "coreUsers")
@SessionScoped//tipo de clase
//clase ContAtasBean con extends al crud
public class CoreUsersBean extends CrudBean<EngListView> implements Serializable{
    @EJB
    private EngListViewFacade usersFacade;//declaracion de clases Facade
    @EJB
    private SgrUserFacades sgrUser;
    @EJB
    private SgrCiaFacade companyFacade;
    
    transient List<String> inge86 = new ArrayList();//variable de lista
    transient List<String> listaIng = new ArrayList();//variable de lista
    
    private String users;
    private String companyUser;
    private SgrCia sgrCia = new SgrCia();
    /**
     * Creates a new instance of CoreUsers
     */
    //costructor super
    public CoreUsersBean() {
        super();
    }
     //metodo generado por implements Serializable
    @Override
    //metodo constructor
    @PostConstruct
    public void init() {
        elemento = new EngListView();
        listado = new ArrayList<>();
        listado=usersFacade.findAllEngListView();
        listadoIngenieros();
        FacesContext facesContext = FacesContext.getCurrentInstance();
            ExternalContext externalContext = facesContext.getExternalContext();
            Map params = externalContext.getRequestParameterMap();
            users = (String) params.get("user");
            companyUser = sgrUser.findSelectUser(users).getCiaDefault();
            if(companyUser!=null){
                sgrCia = companyFacade.find(companyUser);
                engListSelect(sgrCia);
            }
    }
    public void engListSelect(SgrCia ciaSgr){
        extendtime();
        if(sgrCia.getCiaAcceso().intValue()==1){
               listaIng = usersFacade.findByEngCodigo86();
            }else{
                listaIng = usersFacade.findByEngCodigoCiaCode(ciaSgr.getCiaCode());
            } 
        
        
}
      
//metodo generado por implements Serializable limpia el elemento y otras variables
    @Override
    public void limpiar() {
        extendtime();//extiende el tiempo de sesion
        this.elemento = new EngListView();
        edit = false;
    }
//metodo generado por implements Serializable atualiza el elemento en la BD
    @Override
    public void actualizar() {
        extendtime();
        if (usersFacade.find(elemento.getCodigo86()) != null){
            usersFacade.edit(elemento);
            elemento = new EngListView();
            this.edit = false;
        } else {
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El elemento que esta tratando de editar no existe en la base de datos"));
        }
    }
//metodo generado por implements Serializable agrega el elemento en la BD
    @Override
    public void agregar() {
        extendtime();
       if (usersFacade.find(elemento.getCodigo86()) != null){
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El identificador unico se encuentra repetido"));
        } else {
            usersFacade.create(elemento);
            listado.add(elemento);
            elemento = new EngListView();
        }
    }
//metodo generado por implements Serializable  elimina el elemento en la bd
    @Override
    public void eliminar(EngListView elemento) {
        extendtime();
        if (usersFacade.find(elemento.getCodigo86()) != null){
            usersFacade.remove(elemento);
            listado.remove(elemento);
        }
    }
//metodo generado por implements Serializable
    @Override
    EngListView nuevoElemento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //llena la lista de ingeniero
    public void listadoIngenieros(){
        extendtime();
        for(EngListView ings : listado){
            inge86.add("\""+ings.getCodigo86() +"-"+ings.getFullUserName()+"\"");
        }
    }
    
// get y set de variable
    public List<String> getInge86() {
        return inge86;
    }
    
// get y set de variable
    public void setInge86(List<String> inge86) {
        this.inge86 = inge86;
    }
    
// get y set de variable
    public List<String> getListaIng() {
        return listaIng;
    }
    
// get y set de variable
    public void setListaIng(List<String> listaIng) {
        this.listaIng = listaIng;
    }
    
}