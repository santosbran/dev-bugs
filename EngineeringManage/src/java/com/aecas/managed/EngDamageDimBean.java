
  // To change this license header, choose License Headers in Project Properties.
 // To change this template file, choose Tools | Templates
 // and open the template in the editor.

package com.aecas.managed;// paquete manage

import com.aees.session.SessionBean;// libreria SessionBean
import com.aeroman.aees.entities.CoreAircraftType;// importacion de clase
import com.aeroman.aees.entities.EngDamageDim;// importacion de clase
import com.aeroman.aees.entities.EngDamageQuestion;// importacion de clase
import com.aeroman.aees.entities.EngDamageType;// importacion de clase
import com.aeroman.aees.entities.EngDent;// importacion de clase
import com.aeroman.aees.entities.EngDimension;// importacion de clase
import com.aeroman.aees.entities.EngDtDimByManuf;
import com.aeroman.aees.facades.CoreAircraftTypeFacade;// importacion de clase
import com.aeroman.aees.facades.EngDamageDimFacade;// importacion de clase
import com.aeroman.aees.facades.EngDamageQuestionFacade;// importacion de clase
import com.aeroman.aees.facades.EngDamageTypeDimManufactFacade;
import com.aeroman.aees.facades.EngDamageTypeFacade;// importacion de clase
import com.aeroman.aees.facades.EngDimensionFacade;// importacion de clase
import com.aeroman.aees.facades.engExceptionDamageTypeFacade;
import java.io.Serializable;// libreria Serializable
import java.math.BigDecimal;// libreria Serializable
import java.util.ArrayList;// libreria Serializable
import java.util.Date;// libreria Serializable
import java.util.List;// libreria Serializable
import java.util.Map;// libreria Serializable
import java.util.logging.Level;// libreria Serializable
import java.util.logging.Logger;// libreria Serializable
import javax.annotation.PostConstruct;// libreria Serializable
import javax.ejb.EJB;// libreria Serializable
import javax.faces.application.FacesMessage;// libreria Serializable
import javax.faces.bean.ManagedBean;// libreria Serializable
import javax.faces.bean.ManagedProperty;// libreria Serializable
import javax.faces.bean.SessionScoped;// libreria Serializable
import javax.faces.component.UIInput;// libreria Serializable
import javax.faces.component.UIViewRoot;// libreria Serializable
import javax.faces.context.ExternalContext;// libreria Serializable
import javax.faces.context.FacesContext;// libreria Serializable
import javax.servlet.http.HttpSession;// libreria Serializable
import org.primefaces.component.contextmenu.ContextMenu;

/**
 *
 * @author mpolanco
 */
//nombre de clase en mageBean
@ManagedBean(name = "damdimbean")
@SessionScoped //tipo de clase
//clase ContAtasBean con extends al crud
public class EngDamageDimBean extends CrudBean<EngDamageDim> implements Serializable{

    
    @EJB
    private EngDamageDimFacade DamageDimFacade;//declaracion de clases Facade
    
    @EJB
    private EngDamageTypeFacade DamageTypeFacade;//declaracion de clases Facade
    
    @EJB
    private EngDimensionFacade DimensionFacade;//declaracion de clases Facade
    
    @EJB
    private CoreAircraftTypeFacade coreAircraftTypeFacade;//declaracion de clases Facade
    
    @EJB
    private EngDamageQuestionFacade engDamageQuestionFacade;//declaracion de clases Facade
    
    @EJB
    private EngDamageTypeDimManufactFacade engDamageTypeDimManufactFacade;//declaracion de clases Facade

   @EJB
    private engExceptionDamageTypeFacade exceptionDamageTypeFacade;//declaracion de clases Facade

   private String clienteESR;
    
    @ManagedProperty(value = "#{engDentBean}")
    private EngDentBean engDentBean;//declarion variable tipo clase
    
    @ManagedProperty(value = "#{damagtyBean}")
    private EngDamageTypeBean engDamageTypeBean;//declarion variable tipo clase
    
    transient List<EngDamageQuestion> listaDamageQuestion= new ArrayList<>();//variable de lista
      
    private BigDecimal idDamageDim;//declaracion de variable
    private String userlg;//declaracion de variable
    private String damageFK;//declaracion de variable
    private String dimensionFK;//declaracion de variable
    private String PKDamageType;//declaracion de variable
    private String noExistListDimen;//declaracion de variable
    private String noExistListQuestion;//declaracion de variable
    private boolean existDamage;//declaracion de variable
    private boolean existDimension;//declaracion de variable
    private boolean encontrarRepetido;//declaracion de variable
    private String  repetido;//declaracion de variable
    transient List<EngDamageType> valorDamageType;   //declaracion de variable
    private String damageName; //declaracion de variable
    private String sacarid;//declaracion de variable
    private String nota;//declaracion de variable
    private String arctypId;//declaracion de variable
    private String iddamage;//declaracion de variable
    private int pCount;//declaracion de variable
    private String flota;//declaracion de variable
    private CoreAircraftType ct;//declaracion de variable
    private String nameDameEvent;//declaracion de variable
    private String users;//declaracion de variable
    private List<EngDtDimByManuf> listadoNLocal = new ArrayList<>();  
  private List<EngDtDimByManuf> listadoNDim = new ArrayList<>();  
   boolean existeTipoException=false;
       private String manufacturador;//declaracion de variable
       private String colaAvion;
    
    //metodo generado por implements Serializable
    @Override
    //metodo constructor
    @PostConstruct
    public void init() {
       HttpSession session = SessionBean.getSession();
       setUserlg((String) session.getAttribute("username")); //captura usuario logueado
       elemento = nuevoElemento();//inivializa el elemento
       listado = findAllNotDeleted();    //llena el listado
       valorDamageType = new ArrayList<>();      
       listaDamageQuestion = new ArrayList();
       ct = new CoreAircraftType();
       edit = false;
       setDamageFK(null);
       setDimensionFK(null);
       setNota(null);
       setArctypId(null);
       setFlota(null);
       setNoExistListDimen(null);
       setNoExistListQuestion(null);
    }
    
    @Override
    public void limpiar() {     
        extendtime();
        elemento = nuevoElemento();
        listado = findAllNotDeleted();
        listaDamageQuestion = new ArrayList<>();
        ct = new CoreAircraftType();
        edit = false;
        setDamageFK(null);
        setDimensionFK(null);
        existDamage = false;
        existDimension = false;
        setEncontrarRepetido(false);
        setNota(null);
        setArctypId(null);
        setFlota(null);
        setNoExistListDimen(null);
        setNoExistListQuestion(null);
        
       /*se vuelve a setear en este metodo el tiempo maximo de inactividad para que se cierre la session*/
        extendtime();
    }

    @Override
    public void actualizar() {
        extendtime();
        try {
            existDamage = false;
            existDimension = false;
            existDamage = verificarExistenciaDamageType();
            existDimension = verificarExistenciaDimension();
            elemento.setDxdUserUpd(userlg);
            elemento.setDxdDateUpd(new Date());
            elemento.setDxdNota(nota);
            ct = coreAircraftTypeFacade.find(new BigDecimal(getArctypId()));
            elemento.setArctypId(ct);
            if (existDamage && existDimension) {
               FacesContext facesContext = FacesContext.getCurrentInstance();
               ExternalContext externalContext = facesContext.getExternalContext();
               Map params = externalContext.getRequestParameterMap();            
               users = (String) params.get("user");
               HttpSession session = SessionBean.getSession();
               users=(String) session.getAttribute("username");
               Date fechaD = new Date();
               elemento.setDxdUserUpd(users); 
               elemento.setDxdDateUpd(fechaD); 
                DamageDimFacade.edit(elemento);
                limpiar();
            } else {
                FacesContext.getCurrentInstance().validationFailed();
            }
            
        } catch (Exception e) {
            Logger.getLogger(EngDamageDimBean.class.getName()).log(Level.SEVERE, null, e);
            FacesContext.getCurrentInstance().validationFailed();
        }
    }

    @Override
    public void agregar() {
        extendtime();
        try {
            setEncontrarRepetido(false);
            
            existDamage = false;
            existDimension = false;
            existDamage = verificarExistenciaDamageType();
            existDimension = verificarExistenciaDimension();
            elemento.setDxdUserAdd(userlg);
            elemento.setDxdDateAdd(new Date());
            elemento.setDxdState("A");
            elemento.setDxdNota(nota);
            ct = coreAircraftTypeFacade.find(new BigDecimal(getArctypId()));
            elemento.setArctypId(ct);
            for (EngDamageDim lis : listado) {
                if (lis.getDatId().getDatId().equals(elemento.getDatId().getDatId())
                        && lis.getDimId().getDimId().equals(elemento.getDimId().getDimId())
                        && lis.getArctypId().getArctypId().toString().equals(elemento.getArctypId().getArctypId().toString())) {
                    setEncontrarRepetido(true);
                    break;
                }
            }
            
            if (!isEncontrarRepetido()) {
                
                if (existDamage && existDimension) {
                    FacesContext facesContext = FacesContext.getCurrentInstance();
                    ExternalContext externalContext = facesContext.getExternalContext();
                    Map params = externalContext.getRequestParameterMap();            
                    users = (String) params.get("user");
                    HttpSession session = SessionBean.getSession();
                    users=(String) session.getAttribute("username");
                    Date fechaD = new Date();
                    elemento.setDxdUserAdd(users); 
                    elemento.setDxdDateAdd(fechaD); 
                    DamageDimFacade.create(elemento);
                    limpiar();
                } else {
                    FacesContext.getCurrentInstance().validationFailed();
                }
            }
            else {
                FacesContext.getCurrentInstance().validationFailed();
            }
        } catch (Exception e) {
            Logger.getLogger(EngDamageDimBean.class.getName()).log(Level.SEVERE, null, e);
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error al insertar"));
        }
    }

    @Override
    public void eliminar(EngDamageDim elemento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void delete(String id) {  
        extendtime();
        try {
            BigDecimal idDamage = new BigDecimal(id);
            elemento = DamageDimFacade.find(idDamage);            
            elemento.setDxdUserDlt(getUserlg());
            elemento.setDxdDateDlt(new Date());
            elemento.setDxdState("D");
            
            setpCount(DamageDimFacade.existeEnESR(elemento.getDxdId()));
                        
            if (elemento.getDxdId() != null && pCount == 0) {
                DamageDimFacade.edit(elemento);
                limpiar();
            } else {
                FacesContext.getCurrentInstance().validationFailed();
            }

        } catch (Exception e) {
            Logger.getLogger(EngDamageDimBean.class.getName()).log(Level.SEVERE, null, e);
            FacesContext.getCurrentInstance().validationFailed();
        }
    }

    @Override
    public EngDamageDim nuevoElemento() {
        return new EngDamageDim();
    }
    
    public List<EngDamageDim> findAllNotDeleted(){
        extendtime();
        listado = new ArrayList<>();
        listado = DamageDimFacade.findAllActive();
        return listado;
    }
    public void agregarLista(){
        extendtime();
        repetido = "NO EXISTE";
        sacarid=null;
        if(valorDamageType==null){
            valorDamageType = new ArrayList<>();
        }
       
         try {
            if((iddamage != null) && (!iddamage.equals("")))
            {
                 sacarid = iddamage.substring(0, iddamage.indexOf('-'));              
               
                    for (EngDamageType damagetype : valorDamageType) {
                        if (damagetype.getDatId().toString().equals(sacarid)) {
                            repetido = "EXISTE";
                            break;
                        }
                    }
            }
                if (repetido.equals("NO EXISTE") && sacarid != null) {
                    EngDamageType engDT = DamageTypeFacade.find(new BigDecimal(sacarid));
                    valorDamageType.add(engDT);
                }
            
         }catch(Exception e){
             Logger.getLogger(EngDamageDimBean.class.getName()).log(Level.SEVERE, null, e);
                FacesContext.getCurrentInstance().validationFailed();
         }
    }
    public void findlistado2(){
        extendtime();
        engDamageTypeBean.listado2 = new ArrayList<>();
        if(getNameDameEvent()==null){
            setNameDameEvent("pasa");
        }
        if (getNameDameEvent().equals("Other")){
         EngDamageType engDT = DamageTypeFacade.findByDamageByNameTR(getNameDameEvent());
         engDamageTypeBean.listado2.add(engDT); 
         engDamageTypeBean.listado2 = new ArrayList<>();
         listadoNLocal= new ArrayList<>();
         listadoNDim= new ArrayList<>();
        }
        else{
            engDamageTypeBean.listado2 = DamageTypeFacade.findAllActive();            
        }
    }
    public void findnameDameEvent(){
        extendtime();
        engDamageTypeBean.listado2 = new ArrayList<>();
        if(getNameDameEvent()==null){
            setNameDameEvent("pasa");
        }        
        if (getNameDameEvent().equals("Other")){
         EngDamageType engDT = DamageTypeFacade.findByDamageByNameTR(getNameDameEvent());
         engDamageTypeBean.listado2  = new ArrayList();
         listadoNLocal= new ArrayList<>();
         listadoNDim= new ArrayList<>();
//         if(engDT != null && engDT.getDatId()!=null){
//             PKDamageType= engDT.getDatId().toString()+"-"+engDT.getDatName();
//             iddamage = PKDamageType;
//             FindAllByDamage();
//         }
         
        }
        else{
            engDamageTypeBean.listado2 = DamageTypeFacade.findAllActive();
            PKDamageType= null;
            iddamage=null;
            listado2 = new ArrayList<>();       
            listaDamageQuestion = new ArrayList();
            engDentBean.setIdDamageType(null);
            engDentBean.elemento = new EngDent();
        }
         
    }
    public void eliminarValorDamage(String id){
        extendtime();
        EngDamageType engDT = DamageTypeFacade.find(new BigDecimal(id));
        valorDamageType.remove(engDT);
    }
    public void llenarValorDamageType(){
        extendtime();
        valorDamageType = new ArrayList<>();
        for (EngDent lisDat : engDentBean.listado) {
            valorDamageType.add( lisDat.getDatId());             
        }
        
    }
    
    public List<EngDtDimByManuf> FindAllByDamageManuf(){
        extendtime();
        listadoNDim = new ArrayList<>();    
        listadoNLocal= new ArrayList<>();    
        listaDamageQuestion = new ArrayList();
        noExistListDimen=null;
        noExistListQuestion=null;
         try {
             
         
             String cola=colaAvion;
            if(((iddamage != null) && (!iddamage.equals("")))&&((getFlota() != null) && (!getFlota().equals(""))))
            {
              
                manufacturador=exceptionDamageTypeFacade.traerManufAER(clienteESR, cola, getFlota());
                
                sacarid = iddamage.substring(0, iddamage.indexOf('-'));
                damageName = iddamage.substring(iddamage.indexOf('-')+1,iddamage.length());
                  System.out.println("Cola: "+cola);
                System.out.println("Manufacturador: "+manufacturador);
                System.out.println("damageName: "+damageName);
                existeTipoException=exceptionDamageTypeFacade.existeExcep(damageName);
                
             if(existeTipoException){
                listadoNDim=engDamageTypeDimManufactFacade.traerDTDimByManuf("Dimension", manufacturador, new BigDecimal(sacarid));
              
              listadoNLocal=engDamageTypeDimManufactFacade.traerDTDimByManuf("Location", manufacturador, new BigDecimal(sacarid));
                 
             }else{// Others
             listadoNDim=engDamageTypeDimManufactFacade.traerDTDimByManufOther("Dimension", manufacturador, "Default");
              
              listadoNLocal=engDamageTypeDimManufactFacade.traerDTDimByManufOther("Location", manufacturador, "Default");
             }
                
                
                
              
                
                
                engDentBean.setIdDamageType(sacarid);                
                ct = coreAircraftTypeFacade.findAllByFlota(getFlota());
                listado2 = DamageDimFacade.findAllByFlota(sacarid,ct);
                if(listado2.size()<=0){
                    noExistListDimen="notExist";
                }
                BigDecimal idBD = new BigDecimal(sacarid);
                EngDamageType engDT = DamageTypeFacade.find(idBD);
                listaDamageQuestion = engDamageQuestionFacade.findDamageQuestion(engDT,ct);  
                if(listaDamageQuestion.size()<=0){
                    noExistListQuestion ="notExist";                    
                }

            }
        
         }catch(Exception e){
             Logger.getLogger(EngDamageDimBean.class.getName()).log(Level.SEVERE, null, e);
                FacesContext.getCurrentInstance().validationFailed();
         }
         return listadoNDim;
    }
    
     public void setaerCola(String cola){         
         setColaAvion(cola);
     }
    
    public List<EngDamageDim> FindAllByDamage(){
        extendtime();
        listado2 = new ArrayList<>();       
        listaDamageQuestion = new ArrayList();
        noExistListDimen=null;
        noExistListQuestion=null;
         try {
            if(((iddamage != null) && (!iddamage.equals("")))&&((getFlota() != null) && (!getFlota().equals(""))))
            {
                FindAllByDamageManuf();
                sacarid = iddamage.substring(0, iddamage.indexOf('-'));
                damageName = iddamage.substring(iddamage.indexOf('-')+1,iddamage.length());
                engDentBean.setIdDamageType(sacarid);                
                ct = coreAircraftTypeFacade.findAllByFlota(getFlota());
                listado2 = DamageDimFacade.findAllByFlota(sacarid,ct);
                if(listado2.size()<=0){
                    noExistListDimen="notExist";
                }
                BigDecimal idBD = new BigDecimal(sacarid);
                EngDamageType engDT = DamageTypeFacade.find(idBD);
                listaDamageQuestion = engDamageQuestionFacade.findDamageQuestion(engDT,ct);  
                if(listaDamageQuestion.size()<=0){
                    noExistListQuestion ="notExist";                    
                }

            }
        
         }catch(Exception e){
             Logger.getLogger(EngDamageDimBean.class.getName()).log(Level.SEVERE, null, e);
                FacesContext.getCurrentInstance().validationFailed();
         }
         return listado2;
    }
    
    public void limpiarDamageDimModal() {
        extendtime();
        FacesContext context = FacesContext.getCurrentInstance();
        UIViewRoot root = context.getViewRoot();
        UIInput cbDamage = (UIInput) root.findComponent("inputFormDamageDim:cbDamage");
        cbDamage.resetValue();
        UIInput cbDimension = (UIInput) root.findComponent("inputFormDamageDim:cbDimension");
        cbDimension.resetValue();
        UIInput txtNota = (UIInput) root.findComponent("inputFormDamageDim:txtDamDimNota");
        txtNota.resetValue();
    }
    
    public boolean verificarExistenciaDamageType() {
        extendtime();
        boolean verifyDamageType = false;
        listado = findAllNotDeleted();
        List<EngDamageType> listAllDamage = DamageTypeFacade.findAll();
        for (EngDamageType dam : listAllDamage) {
            if(dam.getDatId().intValue() == Integer.parseInt(damageFK)){
                BigDecimal damPK = new BigDecimal(damageFK);
                EngDamageType clss = DamageTypeFacade.findByDamageType(damPK);
                elemento.setDatId(clss);
                verifyDamageType = true;
                break;
            }else
                verifyDamageType = false;
                
        }
        return verifyDamageType;
    }
    
    public boolean verificarExistenciaDimension() {
        extendtime();
        boolean verifyDimension = false;
        listado = findAllNotDeleted();
        List<EngDimension> listAllDimension = DimensionFacade.findAll();
        for (EngDimension dim : listAllDimension) {
            if(dim.getDimId().intValue() == Integer.parseInt(dimensionFK)){
                BigDecimal dimPK = new BigDecimal(dimensionFK);
                EngDimension clss = DimensionFacade.findByDimension(dimPK);
                elemento.setDimId(clss);
                verifyDimension = true;
                break;
            }else
                verifyDimension = false;
                
        }
        return verifyDimension;
    }
    public void limpiarListas(){
        extendtime();
       damageName=null;
       listaDamageQuestion = new ArrayList<>();
       listado2= new ArrayList();
       setPKDamageType(null);      
       setNoExistListDimen(null);
       setNoExistListQuestion(null);
       engDentBean.elemento = new EngDent();
       
        
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    /**
     * @return the idDamageDim
     */
    //get y set de variable
    public BigDecimal getIdDamageDim() {
        return idDamageDim;
    }

    /**
     * @param idDamageDim the idDamageDim to set
     */
    //get y set de variable
    public void setIdDamageDim(BigDecimal idDamageDim) {
        this.idDamageDim = idDamageDim;
    }
    
    /**
     * @return the userlg
     */
    //get y set de variable
    public String getUserlg() {
        return userlg;
    }

    /**
     * @param userlg the userlg to set
     */
    //get y set de variable
    public void setUserlg(String userlg) {
        this.userlg = userlg;
    }

    /**
     * @return the nombre
     */
    //get y set de variable
    public String getDamageFK() {
        return damageFK;
    }

    /**
     * @param damageFK the nombre to set
     */
    //get y set de variable
    public void setDamageFK(String damageFK) {
        this.damageFK = damageFK;
    }

    /**
     * @return the descripcion
     */
    //get y set de variable
    public String getDimensionFK() {
        return dimensionFK;
    }

    /**
     * @param dimensionFK the descripcion to set
     */
    //get y set de variable
    public void setDimensionFK(String dimensionFK) {
        this.dimensionFK = dimensionFK;
    }
    
    /**
     * @return the iddamage
     */
    //get y set de variable
    public String getIddamage() {
        return iddamage;
    }

    /**
     * @param iddamage the iddamage to set
     */
    //get y set de variable
    public void setIddamage(String iddamage) {
        this.iddamage = iddamage;
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    /**
     * @return the encontrarRepetido
     */
    //get y set de variable
    public boolean isEncontrarRepetido() {
        return encontrarRepetido;
    }

    /**
     * @param encontrarRepetido the encontrarRepetido to set
     */
    //get y set de variable
    public void setEncontrarRepetido(boolean encontrarRepetido) {
        this.encontrarRepetido = encontrarRepetido;
    }
//get y set de variable
    public int getpCount() {
        return pCount;
    }
//get y set de variable
    public void setpCount(int pCount) {
        this.pCount = pCount;
    }
//get y set de variable
    public List<EngDamageType> getValorDamageType() {
        return valorDamageType;
    }
//get y set de variable
    public void setValorDamageType(List<EngDamageType> valorDamageType) {
        this.valorDamageType = valorDamageType;
    }
//get y set de variable
    public boolean isExistDamage() {
        return existDamage;
    }
//get y set de variable
    public void setExistDamage(boolean existDamage) {
        this.existDamage = existDamage;
    }
//get y set de variable
    public boolean isExistDimension() {
        return existDimension;
    }
//get y set de variable
    public void setExistDimension(boolean existDimension) {
        this.existDimension = existDimension;
    }
//get y set de variable
    public String getPKDamageType() {
        return PKDamageType;
    }
//get y set de variable
    public void setPKDamageType(String PKDamageType) {
        this.PKDamageType = PKDamageType;
    }
//get y set de variable
    public String getRepetido() {
        return repetido;
    }
//get y set de variable
    public void setRepetido(String repetido) {
        this.repetido = repetido;
    }
//get y set de variable
    public String getDamageName() {
        return damageName;
    }
//get y set de variable
    public void setDamageName(String damageName) {
        this.damageName = damageName;
    }
//get y set de variable
    public String getSacarid() {
        return sacarid;
    }
//get y set de variable
    public void setSacarid(String sacarid) {
        this.sacarid = sacarid;
    }
   //get y set de variable
    public String getNota() {
        return nota;
    }
//get y set de variable
    public void setNota(String nota) {
        this.nota = nota;
    }
//get y set de variable
    public List<EngDamageQuestion> getListaDamageQuestion() {
        return listaDamageQuestion;
    }
//get y set de variable
    public void setListaDamageQuestion(List<EngDamageQuestion> listaDamageQuestion) {
        this.listaDamageQuestion = listaDamageQuestion;
    }
//get y set de variable
    public EngDentBean getEngDentBean() {
        return engDentBean;
    }
//get y set de variable
    public void setEngDentBean(EngDentBean engDentBean) {
        this.engDentBean = engDentBean;
    }
//get y set de variable
    public String getArctypId() {
        return arctypId;
    }
//get y set de variable
    public void setArctypId(String arctypId) {
        this.arctypId = arctypId;
    }
//get y set de variable
    public CoreAircraftType getCt() {
        return ct;
    }
//get y set de variable
    public void setCt(CoreAircraftType ct) {
        this.ct = ct;
    }
//get y set de variable
    public String getFlota() {
        return flota;
    }
//get y set de variable
    public void setFlota(String flota) {
        this.flota = flota;
    }
//get y set de variable
    public String getNoExistListDimen() {
        return noExistListDimen;
    }
//get y set de variable
    public void setNoExistListDimen(String noExistListDimen) {
        this.noExistListDimen = noExistListDimen;
    }
//get y set de variable
    public String getNoExistListQuestion() {
        return noExistListQuestion;
    }
//get y set de variable
    public void setNoExistListQuestion(String noExistListQuestion) {
        this.noExistListQuestion = noExistListQuestion;
    }
//get y set de variable
    public String getNameDameEvent() {
        return nameDameEvent;
    }
//get y set de variable
    public void setNameDameEvent(String nameDameEvent) {
        this.nameDameEvent = nameDameEvent;
    }
//get y set de variable
    public EngDamageTypeBean getEngDamageTypeBean() {
        return engDamageTypeBean;
    }
//get y set de variable
    public void setEngDamageTypeBean(EngDamageTypeBean engDamageTypeBean) {
        this.engDamageTypeBean = engDamageTypeBean;
    }
    public List<EngDtDimByManuf> getListadoNLocal() {
        return listadoNLocal;
    }

    public void setListadoNLocal(List<EngDtDimByManuf> listadoNLocal) {
        this.listadoNLocal = listadoNLocal;
    }

    public List<EngDtDimByManuf> getListadoNDim() {
        return listadoNDim;
    }

    public void setListadoNDim(List<EngDtDimByManuf> listadoNDim) {
        this.listadoNDim = listadoNDim;
    }

 

    public boolean isExisteTipoException() {
        return existeTipoException;
    }

    public void setExisteTipoException(boolean existeTipoException) {
        this.existeTipoException = existeTipoException;
    }

    public String getManufacturador() {
        return manufacturador;
    }

    public void setManufacturador(String manufacturador) {
        this.manufacturador = manufacturador;
    }

    public String getColaAvion() {
        return colaAvion;
    }

    public void setColaAvion(String colaAvion) {
        this.colaAvion = colaAvion;
    }

    public String getClienteESR() {
        return clienteESR;
    }

    public void setClienteESR(String clienteESR) {
        this.clienteESR = clienteESR;
    }
}
