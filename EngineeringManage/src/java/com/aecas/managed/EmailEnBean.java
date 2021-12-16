/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aecas.managed;// paquete manage

import com.aees.session.SessionBean;// importacion de clase
import com.aeroman.aees.entities.grant.ContCheck;// importacion de clase
import com.aeroman.aees.entities.grant.ContCheckEmails;// importacion de clase
import com.aeroman.aees.facades.grant.ContCheckEmailsFacade;// importacion de clase
import com.aeroman.aees.facades.grant.ContCheckFacade;// importacion de clase
import com.aeroman.aees.facades.Sequences;// importacion de clase
import java.io.Serializable;// libreria Serializable
import java.math.BigDecimal;// libreria BigDecimal
import java.util.ArrayList;// libreria ArrayList
import java.util.Date;// libreria Date
import java.util.List;// libreria List
import java.util.logging.Level;// libreria Level
import java.util.logging.Logger;// libreria Logger
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.PostConstruct;// libreria PostConstruct
import javax.ejb.EJB;// libreria EJB
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;// libreria ManagedBean
import javax.faces.bean.ManagedProperty;// libreria ManagedProperty
import javax.faces.bean.SessionScoped;// libreria SessionScoped
import javax.faces.context.FacesContext;// libreria FacesContext
import javax.servlet.http.HttpSession;// libreria HttpSession

/**
 *
 * @author pc
 */
//nombre de clase en mageBean
@ManagedBean(name = "emailEnBean")
@SessionScoped//tipo de clase
//clase ContAtasBean con extends al crud
public class EmailEnBean extends CrudBean<ContCheckEmails> implements Serializable {

    @EJB
    private ContCheckEmailsFacade contcheckEmail;//declaracion de clases Facade
    @EJB
    private ContCheckFacade contCheFacade;//declaracion de clases Facade

    @ManagedProperty(value = "#{reportesSeguiCheqBean}")
    private ReportesSeguiCheqBean reportesBean;//declarion variable tipo clase
    
    private Sequences seq;//declarion variable tipo clase

    private String idc;//declaracion de variable
    private String idborrarEmail;//declaracion de variable
    private int menscons;//declaracion de variable
    private String valor;//declaracion de variable
    private String id;//declaracion de variable
    private String contid;//declaracion de variable
    private boolean mval;

    transient List<ContCheckEmails> aux = new ArrayList<>();//variable de lista

    //metodo generado por implements Serializable
    @Override
    //metodo constructor
    @PostConstruct
    public void init() {
        elemento = new ContCheckEmails();//inicializa el elemento
        mval=true;

    }
//metodo que llena los correos del chequeo
    public String somere(String idz) {
        extendtime();
        id = idz;
        contid=idz;
        try {
            elemento = new ContCheckEmails();
            //listado = contcheckEmail.findAll();//asigna los correos del cheque
            listado = contcheckEmail.findbywo(new Short(id));//carga solo los correos de la compañia, no sera necesario el filtro siguiente
            List<ContCheckEmails> listmex = new ArrayList<>(); //declara una lista y la inicializa
            int x = 0;//declara una variable y la inicializa
            listado2 = listado;//asiga a listado 2
            setIdc("3");// ingresa a idc el valor de 3
        } catch (Exception e) {//captura posbles errores
            Logger.getLogger(EmailEnBean.class.getName()).log(Level.SEVERE, null, e);
        }
        return "alot"; ///retorna alot
    }
 //metodo generado por implements Serializable limpia el elemento y otras variables
    @Override
    public void limpiar() {
        extendtime();//extiende el tiempo de sesion 
        this.elemento = new ContCheckEmails();//inicializa el elmento
        edit = false;//asigana falso a esdi
        menscons = 0;//asigna 0 a menscons
        idborrarEmail = null;//asigna null a idborrarEmail
    }
 //metodo generado por implements Serializable actualiza en la base de datos
    @Override
    public void actualizar() {
        extendtime();//extiende el tiempo de de sesion 
        HttpSession session = SessionBean.getSession();
        String user = (String) session.getAttribute("username");//captura el usuario en sesion
        try {//bloque controlado de posibles errores
            elemento.setCemCodUsrAct(user);//asigna el usuario
            elemento.setCemFechaAct(new Date());//asigana la fecha de ingreso 
            elemento.setCemEmail(elemento.getCemEmail().trim());//asigna el correo registrado el formulario
            contcheckEmail.edit(elemento);//edita el elemento en la bd
            elemento = new ContCheckEmails();//inicializa el elmento
        } catch (Exception c) {//captura posibles errores al actualizar
            Logger.getLogger(EmailEnBean.class.getName()).log(Level.SEVERE, null, c);
        } finally {//finally de catch
            this.edit = false;
        }

    }
 //metodo generado por implements Serializable agrega a la base dedatos
    @Override
    public void agregar() {
        mval=false;
        extendtime();//extiende el tiepo de sesion
        seq = new Sequences();// inicializa la clase se sequences
        //Short xd = new Short(contid);// convierte a short a variable contid
        ContCheck contch = contCheFacade.find(new BigDecimal(contid));//delcara una variable tipo clase y le asigna el valos de la busqueda del chuequeo
        HttpSession session = SessionBean.getSession();
        String user = (String) session.getAttribute("username");//se captura usuario logueado 
        elemento.setContCheckId(contch);//asigna a contcheckid la variable de contch
        elemento.setCemCodUsrIns(user);//asigna el usuario 
        elemento.setCemFechaIns(new Date());//asigna la fecha de registro
        elemento.setCemEmail(elemento.getCemEmail().trim());//asigna el correo
        mval=mailVal(elemento.getCemEmail());
        if (mval) {
            contcheckEmail.create(elemento);//agrega el elemento a la base de datos
            listado2.add(elemento);//agrega el elemento a la lista
            elemento = new ContCheckEmails(); //inicializa el elemento
            limpiar();//metodo para limpiar 
        }
        else{
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Mail Invalid"));
        }
        

    }
     public boolean mailVal(String email) {
        boolean valMail=false;
 
        // Patrón para validar el email
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(email);
 
        if (mather.find() == true) {
            valMail=true;
        } else {
            valMail=false;
        }
        return valMail;
        
    }
 //metodo generado por implements Serializable metodo para elimindar de la bd
    @Override
    public void eliminar(ContCheckEmails elemento) {
        extendtime();// extiende el tiempo de sesion
        contcheckEmail.remove(elemento);//remueve de la base de datos
        listado2.remove(elemento);// remueve de la lista el elemento
    }
    //metodo que elimina de la bd
    public void delete(String id) {
        extendtime();// extiende el tiempode la bd
        try {//bloque controlado de posibles errores
            ContCheckEmails borrar = contcheckEmail.find(new BigDecimal(id)); //declara y asigna una variable tipoo clase y asigna lo filtrado
            eliminar(borrar);//ejecuta el metodo de eliminacion
        } catch (Exception e) {//captura de posibles errores

            String errores = e.getCause().getMessage();//asigna error a variable errores
            if (errores.contains("Error committing transaction") || errores.contains("Error al realizar la transacción")) {//evalua errores
                menscons = 1; //asigna 1  a menscons
            }
            FacesContext.getCurrentInstance().validationFailed();
            Logger.getLogger(EmailEnBean.class.getName()).log(Level.SEVERE, null, e);
        }

    }
 //metodo generado por implements Serializable
    @Override
    ContCheckEmails nuevoElemento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//get y set de variable
    public String getId() {
        return id;
    }
//get y set de variable
    public void setId(String id) {
        this.id = id;
    }
//get y set de variable
    public String getIdc() {
        return idc;
    }
//get y set de variable
    public void setIdc(String idc) {
        this.idc = idc;
    }
//get y set de variable
    public ReportesSeguiCheqBean getReportesBean() {
        return reportesBean;
    }
//get y set de variable
    public void setReportesBean(ReportesSeguiCheqBean reportesBean) {
        this.reportesBean = reportesBean;
    }
//get y set de variable
    public String getIdborrarEmail() {
        return idborrarEmail;
    }
//get y set de variable
    public void setIdborrarEmail(String idborrarEmail) {
        this.idborrarEmail = idborrarEmail;
    }
//get y set de variable
    public String getValor() {
        return valor;
    }
//get y set de variable
    public void setValor(String valor) {
        this.valor = valor;
    }
//get y set de variable
    public int getMenscons() {
        return menscons;
    }
//get y set de variable
    public void setMenscons(int menscons) {
        this.menscons = menscons;
    }
//get y set de variable
    public List<ContCheckEmails> getAux() {
        return aux;
    }
//get y set de variable
    public void setAux(List<ContCheckEmails> aux) {
        this.aux = aux;
    }
//get y set de variable
    public String getContid() {
        return contid;
    }
//get y set de variable
    public void setContid(String contid) {
        this.contid = contid;
    }
//get y set de variable
    public Sequences getSeq() {
        return seq;
    }
//get y set de variable
    public void setSeq(Sequences seq) {
        this.seq = seq;
    }

    public boolean getMval() {
        return mval;
    }

    public void setMval(boolean mval) {
        this.mval = mval;
    }
    
    
}
