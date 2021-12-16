 // To change this license header, choose License Headers in Project Properties.
 // To change this template file, choose Tools | Templates
 // and open the template in the editor.
package com.aecas.managed;// paquete manage


import com.aees.session.SessionBean;// libreria Serializable
import com.aeroman.aees.entities.grant.ContFleets;// importacion de clase
import com.aeroman.aees.entities.EngEoActionTypes;// importacion de clase
import com.aeroman.aees.entities.EngEoPrefixes;// importacion de clase
import com.aeroman.aees.entities.EngOrders;// importacion de clase
import com.aeroman.aees.entities.EngPriorities;// importacion de clase
import com.aeroman.aees.entities.EngRequest;// importacion de clase
import com.aeroman.aees.entities.EngWorkTypes;// importacion de clase
import com.aeroman.aees.facades.grant.ContFleetsFacade;// importacion de clase
import com.aeroman.aees.facades.EngEoActionTypesFacade;// importacion de clase
import com.aeroman.aees.facades.EngEoPrefixesFacade;// importacion de clase
import com.aeroman.aees.facades.EngOrdersFacade;// importacion de clase
import com.aeroman.aees.facades.EngPrioritiesFacade;// importacion de clase
import com.aeroman.aees.facades.EngWorkTypesFacade;// importacion de clase
import com.aeroman.aees.facades.Sequences;// importacion de clase
import java.io.Serializable;// libreria Serializable
import java.math.BigInteger;// libreria BigInteger
import javax.annotation.PostConstruct;// libreria PostConstruct
import javax.ejb.EJB;// libreria EJB
import javax.faces.application.FacesMessage;// libreria FacesMessage
import javax.faces.bean.ManagedBean;// libreria ManagedBean
import javax.faces.bean.ViewScoped;// libreria ViewScoped
import javax.faces.context.FacesContext;// libreria FacesContext
import java.util.List;// libreria List
import java.util.ArrayList;// libreria ArrayList
import java.util.Date;// libreria Date
import java.util.logging.Level;// libreria Level
import java.util.logging.Logger;// libreria Logger
import javax.servlet.http.HttpSession;// libreria HttpSession
/**
 *
 * @author Usuario
 */
//nombre de clase en mageBean
@ManagedBean(name = "engOrdersBean")
@ViewScoped //tipo de clase
//clase ContAtasBean con extends al crud
public class EngOrdersBean extends CrudBean<EngOrders> implements Serializable{
    private Boolean actualizado=false;//declaracion de variable
    private List<Integer> ididord = new ArrayList<>();//declaracion de variable
    private EngOrders orders;//declaracion de variable
    private String usrCoduser;//declaracion de variable
    
    @EJB
    private EngOrdersFacade engOrders;//declaracion de clases Facade
    @EJB
    private EngPrioritiesFacade prifacade;//declaracion de clases Facade
    @EJB
    private Sequences numax;//declaracion de clases Facade
    @EJB
    private EngEoPrefixesFacade prefixesFacade;//declaracion de clases Facade
    @EJB
    private EngWorkTypesFacade workFacade;//declaracion de clases Facade
    @EJB
    private EngEoActionTypesFacade actFacade;//declaracion de clases Facade
    @EJB
    private ContFleetsFacade contFacade;//declaracion de clases Facade
   
   
    
    private Long idmaxea;//declaracion de variable
    private String flotas="";//declaracion de variable
    private BigInteger idErs;//declaracion de variable
    private String codpre="";//declaracion de variable
    private String wtycod="";//declaracion de variable
    private String actcod="";//declaracion de variable
    private String priCod="";//declaracion de variable
    private String ata="";//declaracion de variable
    private String cont="";//declaracion de variable
    
    private String custobyesr="";//declaracion de variable
    private String tailbyesr="";//declaracion de variable
    private String companybyesr ="";//declaracion de variable
    private String username = "username";//declaracion de variable
//get y set de variable
    public String getCont() {
        return cont;
    }
//get y set de variable
    public void setCont(String cont) {
        this.cont = cont;
    }
     

    
    //metodo generado por implements Serializable
    @Override
    //metodo constructor
    @PostConstruct
    public void init() {        
        
        ididord=numax.ioOrder();
        elemento = new EngOrders ();
        
        elemento.setEoCodpre(new EngEoPrefixes());
        elemento.setPriCod(new EngPriorities());
        elemento.setWtyCod(new EngWorkTypes());
        elemento.setActCod(new EngEoActionTypes ());
        ata=String.valueOf(elemento.getAtaNumata());
        listado = engOrders.findAll();
        
        edit = false;
        
    }
//metodo generado por implements Serializable
    @Override
    public void limpiar() {
        extendtime();
        this.elemento = new EngOrders();              
        elemento.setEoIdord(getIdmaxea());
        elemento.setReqMessageid(idErs);
        //checkbox en false por defecto     
        elemento.setEoMaterials("N");
        elemento.setEoEffectWb("N");
        elemento.setEoNdtequipment("N");
        elemento.setEoSpecialTool("N");
        elemento.setEoOther("N");            
        elemento.setEoFeedback("N");
        elemento.setEoMinor("N");
        elemento.setEoMajorref("N");
        codpre="";
        wtycod="";
        actcod="";
        priCod="";
        ata="";
        edit= false;
    }
//get y set de variable   
    public String getAta() {
        return ata;
    }
//get y set de variable
    public void setAta(String ata) {
        this.ata = ata;
    }
//get y set de variable
    public EngOrders getOrders() {
        return orders;
    }
//get y set de variable
    public void setOrders(EngOrders orders) {
        this.orders = orders;
    }
//metodo generado por implements Serializable
    @Override
    public void actualizar() {
        extendtime();
        if(engOrders.find(elemento.getEoIdord())!= null){
            
            HttpSession sesion=SessionBean.getSession();
            String usuarioins=(String)sesion.getAttribute(username);
            
            Short prico = new Short(priCod);
            
            EngPriorities pri;
            EngEoPrefixes pre;
            EngWorkTypes work;
            EngEoActionTypes act;
            ContFleets countFleets;
            pri=prifacade.find(prico);
            pre=prefixesFacade.find(codpre);
            work=workFacade.find(wtycod);
            act=actFacade.find(actcod);
            countFleets = contFacade.find(elemento.getFltCod());
            elemento.setPriCod(pri);
            elemento.setEoCodpre(pre);
            elemento.setWtyCod(work);
            elemento.setActCod(act);
            elemento.setFltCod(countFleets.getCodflt());            
            elemento.setEoUsrUpd(usuarioins);
            engOrders.edit(elemento);
            elemento= new EngOrders();
            this.edit=false;
            actualizado=true;
        }else{
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El elemento que esta tratando de editar no existe en la base de datos"));
        }
        
    }
    
    public Object findSelect(String id){
        extendtime();
        if (edit) {
            int ids = Integer.parseInt(id);
            long idd = (long) (ids);
            elemento = engOrders.find(idd);

        }
        return elemento;
    }
    
    public void agregarESR(EngRequest req){
        extendtime();
        if(req.getUsrCoduser()==null || req.getUsrCoduser()=="0"){
            usrCoduser="";
        }else{
            usrCoduser=req.getUsrCoduser();
        }
    }
    
    public void actualiza(Long idactividad,String idingeniero){
        extendtime();
            elemento = engOrders.find(idactividad);
            elemento.setEoOwner(String.valueOf(idingeniero));
            elemento.setEoDateUpd(new Date());
            HttpSession sesion=SessionBean.getSession();
            String usuarioins=(String)sesion.getAttribute(username);
            elemento.setEoUsrUpd(usuarioins);
            engOrders.edit(elemento);
            
    }
    
 
//metodo generado por implements Serializable
    @Override
    public void agregar() {
        extendtime();

        try{
        if(engOrders.find(elemento.getEoIdord())!= null){
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El elemento que esta tratnado de editar no existe en la base de datos"));
        }else{
   
                        orders=new EngOrders();
    
            Short prico = new Short(priCod);
         
               
            EngPriorities pri;
            EngEoPrefixes pre;
            EngWorkTypes work;
            EngEoActionTypes act;
            ContFleets contFltvar;
            contFltvar = contFacade.find(elemento.getFltCod());
        
            
            pri=prifacade.find(prico);
            pre=prefixesFacade.find(codpre);
            work=workFacade.find(wtycod);
            act=actFacade.find(actcod);
            
            
            elemento.setPriCod(pri);
            elemento.setEoCodpre(pre);
            elemento.setWtyCod(work);
            elemento.setActCod(act);
            elemento.setFltCod(contFltvar.getCodflt());
            elemento.setEoStc("N");
            elemento.setEoMajorForm("1");
            elemento.setEoNotRequired("1");
            elemento.setEoIncAffPub("1");
            elemento.setEoReqToInspec("1");
            elemento.setEoNewInspInt("1");
            elemento.setEoDocType("EO");
            elemento.setEoAlertDate(new Date());
            short idn=1;
            elemento.setEoIdnot(idn);
            elemento.setEoCreationDate(new Date());
            elemento.setEoDistlistCmt("-");
            elemento.setEoExeInterval("N");
            elemento.setEoIntUnit("N");
           
            elemento.setEoLbs("N");
            elemento.setEoLbsIn("N");
            
            elemento.setEoSpecialInst("1");            
            elemento.setEoAd("N");
            elemento.setEoCn("N");
            elemento.setEoCompDate(new Date());
            elemento.setEoRecepDate(new Date());
            
            
            elemento.setEoDateIns(new Date());
            elemento.setEoCoc('N');
            elemento.setEoCodstseo("PEN");
            elemento.setEoDateUpd(new Date());
            elemento.setEoUpdTecrec("N");
            
            HttpSession sesion=SessionBean.getSession();
            String usuarioins=(String)sesion.getAttribute(username);
            elemento.setEoUsrIns(usuarioins);
            
            elemento.setCompany(companybyesr);
            elemento.setEoCustomer(custobyesr);
            elemento.setEoTail(tailbyesr);
            elemento.setEoReptInt("N");
      
            if (elemento.getActCod() == null) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Necesita un codigo de Accion: " + elemento.getActCod()));
            } else if (elemento.getFltCod() == null) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Necesita una flota: " + elemento.getFltCod()));
            } else if (elemento.getEoCodpre() == null) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Necesita un prefijo: " + elemento.getEoCodpre()));
            } else if (elemento.getPriCod() == null) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Necesita un codigo de Prioridad: " + elemento.getPriCod()));
            } else if (elemento.getWtyCod() == null) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Necesita un codigo de trabajo " + elemento.getWtyCod()));
            } else {
                engOrders.create(elemento);
                elemento = new EngOrders();
            }

        
        }
        }catch(Exception ex){
        Logger.getLogger(EngOrdersBean.class.getName()).log(Level.SEVERE, null, ex);
        
        }
    this.elemento=new EngOrders();
    edit=false;
    }
//metodo generado por implements Serializable
    @Override
    void eliminar(EngOrders elemento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//metodo generado por implements Serializable
    @Override
    public EngOrders nuevoElemento() {
return new EngOrders();
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
//<editor-fold defaultstate="collapsed" desc="g y s">
    
    public Long getIdmaxea() {//get y set de variable
        idmaxea = numax.maxCode();
        return idmaxea;
    }

    public void setIdmaxea(Long idmaxea) {//get y set de variable
        this.idmaxea = idmaxea;
    }
//</editor-fold>
    
    public Boolean getActualizado() {//get y set de variable
        return actualizado;
    }
    
    public void setActualizado(Boolean actualizado) {//get y set de variable
        this.actualizado = actualizado;
    }
    
    public String getPriCod() {//get y set de variable
        if(elemento.getPriCod()== null){
           Logger.getLogger(EngOrdersBean.class.getName());
        }else{
            priCod=String.valueOf(elemento.getPriCod().getPriCod());
        }
        return priCod;
    }
    
    public void setPriCod(String priCod) {//get y set de variable
        this.priCod = priCod;
    }

    public String getCodpre() {//get y set de variable
        if(elemento.getEoCodpre()== null){
            Logger.getLogger(EngOrdersBean.class.getName());
           
        }else{
            codpre=elemento.getEoCodpre().getPreCod();
        }
        return codpre;
    }

    public void setCodpre(String codpre) {//get y set de variable
        this.codpre = codpre;
    }

    public String getWtycod() {//get y set de variable
        if(elemento.getWtyCod()== null){
            Logger.getLogger(EngOrdersBean.class.getName());
            
        }else{
            wtycod=elemento.getWtyCod().getWtyCod();
        }
        return wtycod;
    }

    public void setWtycod(String wtycod) {//get y set de variable
        this.wtycod = wtycod;
    }

    public String getActcod() {//get y set de variable
        if(elemento.getActCod()== null){
           Logger.getLogger(EngOrdersBean.class.getName());
        }else{
            actcod=elemento.getActCod().getActCod();
        }
        return actcod;
    }

    public void setActcod(String actcod) {//get y set de variable
        this.actcod = actcod;
    }

    public BigInteger getIdErs() {//get y set de variable
        return idErs;
    }

    public void setIdErs(BigInteger idErs) {//get y set de variable
        this.idErs = idErs;
    }

    public String getFlotas() {//get y set de variable
        return flotas;
        
    }
    public void setFlotas(String flotas) {//get y set de variable
        this.flotas = flotas;
    }
    
    public String getCustobyesr() {//get y set de variable
        return custobyesr;
    }
    
    public void setCustobyesr(String custobyesr) {//get y set de variable
        this.custobyesr = custobyesr;
    }
    
    public String getTailbyesr() {//get y set de variable
        return tailbyesr;
    }

    public void setTailbyesr(String tailbyesr) {//get y set de variable
        this.tailbyesr = tailbyesr;
    }

    public String getCompanybyesr() {//get y set de variable
        return companybyesr;
    }

    public void setCompanybyesr(String companybyesr) {//get y set de variable
        this.companybyesr = companybyesr;
    }

    public String getUsrCoduser() {//get y set de variable
        return usrCoduser;
    }

    public void setUsrCoduser(String usrCoduser) {//get y set de variable
        this.usrCoduser = usrCoduser;
    }

    public List<Integer> getIdidord() {//get y set de variable
        return ididord;
    }

    public void setIdidord(List<Integer> ididord) {//get y set de variable
        this.ididord = ididord;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {//get y set de variable
        this.username = username;
    }
    
}
