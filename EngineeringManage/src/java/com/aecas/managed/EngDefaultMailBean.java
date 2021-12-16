
 // To change this license header, choose License Headers in Project Properties.
 // To change this template file, choose Tools | Templates
 // and open the template in the editor.
package com.aecas.managed;// paquete manage

import com.aees.session.SessionBean;
import com.aeroman.aees.entities.ContDefaultMail;// importacion de clase
import com.aeroman.aees.facades.ContDefaultMailFacade;// importacion de clase
import com.aeroman.aees.facades.EngCustomerFacade;
import com.aeroman.aees.facades.EngMergeCustomerFacade;
import com.aeroman.aees.facades.grant.SgrCiaFacade;
import java.io.Serializable;// libreria Serializable
import java.math.BigDecimal;// libreria BigDecimal
import java.util.ArrayList;// libreria ArrayList
import java.util.Date;
import java.util.logging.Level;// libreria Level
import java.util.logging.Logger;// libreria Logger
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.PostConstruct;// libreria PostConstruct
import javax.ejb.EJB;// libreria EJB
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;// libreria ManagedBean
import javax.faces.bean.SessionScoped;// libreria SessionScoped
import javax.faces.context.FacesContext;// libreria FacesContext
import javax.servlet.http.HttpSession;

/**
 *
 * @author vjuarez
 */
//nombre de clase en mageBean
@ManagedBean(name = "engDefaultMailBean")
@SessionScoped //tipo de clase
//clase ContAtasBean con extends al crud
public class EngDefaultMailBean extends CrudBean<ContDefaultMail> implements Serializable {
    
    @EJB
    private ContDefaultMailFacade contDefaultMailFacade;//declaracion de clases Facade
    @EJB
    private SgrCiaFacade companyFacade;//declaracion de clases Facade
    @EJB
    private EngCustomerFacade engcustomerFacade;//declaracion de clases Facade
    @EJB
    private EngMergeCustomerFacade engMergeCustomerFacade;
    
    private boolean encontrarRepetido;//declaracion de variable
    private String idMail;//declaracion de variable
    private String idCodeCia;//declaracion de variable
    private String idCustomer;//declaracion de variable
    private boolean emailVa;

    //metodo generado por implements Serializable
    @Override
    //metodo constructor
    @PostConstruct
    public void init() {
        listado = new ArrayList<>();
        elemento = new ContDefaultMail();
        //listado = contDefaultMailFacade.findAllContDefaultMail();
        listado = contDefaultMailFacade.findAll();
        edit = false;
        encontrarRepetido = false;
        
    }

    @Override
    public void limpiar() {
        elemento = new ContDefaultMail();
        edit = false;
        encontrarRepetido = false;
        idCodeCia=null;
        idCustomer=null;
    }
    public void findMail() {
        extendtime();
        try {
            listado = contDefaultMailFacade.findAll();
        } catch (Exception e) {
            Logger.getLogger(EngDefaultMailBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void findByMail() {
        extendtime();
        try {
            BigDecimal id = new BigDecimal(idMail);
            elemento = contDefaultMailFacade.find(id);
        } catch (Exception e) {
            Logger.getLogger(EngActorBean.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    @Override
    public void actualizar() {
        extendtime();
        HttpSession sesUP = SessionBean.getSession();
        String userLUP = (String) sesUP.getAttribute("username"); 
        try {
            encontrarRepetido = false;
            elemento.setDefCiaCode(companyFacade.find(getIdCodeCia()));
            elemento.setDefCustomer(engMergeCustomerFacade.find(new BigDecimal(getIdCustomer())));
            elemento.setDefUserAdd(userLUP);
            elemento.setDefDateAdd(new Date());
            for (ContDefaultMail mail : listado) {
                if (mail.getDefMail().equals(elemento.getDefMail()) && mail.getDefId() != elemento.getDefId() && mail.getDefCiaCode().getCiaCode().equals(elemento.getDefCiaCode().getCiaCode()) && mail.getDefCustomer().getEmcId()== elemento.getDefCustomer().getEmcId()) {
                    encontrarRepetido = true;
                    FacesContext.getCurrentInstance().validationFailed();
                    break;
                }

            }
            if (!encontrarRepetido) {
                contDefaultMailFacade.edit(elemento);
                findMail();
                limpiar();
            }

        } catch (Exception e) {
            Logger.getLogger(ContDefaultMail.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void agregar() {
        extendtime();
        HttpSession sesADD = SessionBean.getSession();
        String userADD = (String) sesADD.getAttribute("username");  
        try {
            encontrarRepetido = false;
            elemento.setDefCiaCode(companyFacade.find(getIdCodeCia()));
            elemento.setDefCustomer(engMergeCustomerFacade.find(new BigDecimal(getIdCustomer())));
            elemento.setDefUserUpd(userADD);
            elemento.setDefDateUpd(new Date());
            for (ContDefaultMail mail : listado) {
                if (mail.getDefMail().equals(elemento.getDefMail())&& mail.getDefCiaCode().getCiaCode().equals(elemento.getDefCiaCode().getCiaCode()) && mail.getDefCustomer().getEmcId()==elemento.getDefCustomer().getEmcId()) {
                    encontrarRepetido = true;
                    break;
                }

            }
            if (!encontrarRepetido) {
                emailVa=validarMail(elemento.getDefMail());
                if (emailVa) {
                    contDefaultMailFacade.create(elemento);
                findMail();
                limpiar();
                }
                else{
                    FacesContext.getCurrentInstance().validationFailed();
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Mail Invalid"));
                }
                
            }

        } catch (Exception e) {
            Logger.getLogger(EngActorBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public boolean validarMail(String mail) {
        boolean valMail2=false;
 
        // Patrón para validar el email
        Pattern pattern2 = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather2 = pattern2.matcher(mail);
 
        if (mather2.find() == true) {
            valMail2=true;
        } else {
            valMail2=false;
        }
        return valMail2;
        
    }
    public void deleteMail() {
        extendtime();
        eliminar(elemento);
        findMail();
        limpiar();
        
    }

    @Override
    public void eliminar(ContDefaultMail elemento) {
        extendtime();
        try {
            contDefaultMailFacade.remove(elemento);
        } catch (Exception e) {
            Logger.getLogger(EngActorBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public ContDefaultMail nuevoElemento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public String getIdMail() {
        return idMail;
    }
 //get y set de variable
    public void setIdMail(String idMail) {
        this.idMail = idMail;
    }

    public String getIdCodeCia() { //get y set de variable
        return idCodeCia;
    }

    public void setIdCodeCia(String idCodeCia) { //get y set de variable
        this.idCodeCia = idCodeCia;
    }

    public String getIdCustomer() { //get y set de variable
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) { //get y set de variable
        this.idCustomer = idCustomer;
    }

    public boolean getEmailVa() {
        return emailVa;
    }

    public void setEmailVa(boolean emailVa) {
        this.emailVa = emailVa;
    }
    
}
