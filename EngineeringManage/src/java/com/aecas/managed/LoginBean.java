/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aecas.managed;

import com.aees.session.SessionBean;
import com.aeroman.aees.facades.SgrUserFacade;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.logging.Logger;
import javax.faces.bean.SessionScoped;
import javax.security.auth.login.LoginException;

/**
 *
 * @author Usuario
 */
@ManagedBean(name = "Login")
@SessionScoped
public class LoginBean implements Serializable{

    private String usuario;
    private String password;
    private String bandera;
    
    public LoginBean() {
        super();
    }
    
    @PostConstruct
    public void init(){
        Logger.getLogger(LoginBean.class.getName());
           
    }
    
    public String usersValidator() throws LoginException{
       SgrUserFacade valid=new SgrUserFacade();
       Object us;
        if(bandera != null && !("").equals(bandera)){
        us=valid.VerificaLoginBandera(usuario);
        }else
        if(getUsuario()!= null && !"".equals(getUsuario()) && getPassword() != null && !"".equals(getPassword())){
           
             us=valid.VerificaLogin(usuario, password);
             
            
        }else{
                    us=null;
        }
        if(us!=null){
            HttpSession session = SessionBean.getSession();
            session.setAttribute("username", usuario);
            return "/pages/welcome.xhtml?faces-redirect=true";
        }
        
        return null;  
    }
    
    public String logout() {
        HttpSession session = SessionBean.getSession();
        session.invalidate();        
        return "/login.xhtml?faces-redirect=true";
    }
    
    //getters and setters
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the bandera
     */
    public String getBandera() {
        return bandera;
    }

    /**
     * @param bandera the bandera to set
     */
    public void setBandera(String bandera) {
        this.bandera = bandera;
    }
    
}
