/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aecas.managed;

import com.aees.session.SessionBean;
import com.aeroman.aees.entities.CoreAircraftType;
import com.aeroman.aees.entities.EngDamageQuestion;
import com.aeroman.aees.entities.EngDamageType;
import com.aeroman.aees.entities.EngDent;
import com.aeroman.aees.entities.EngDimension;
import com.aeroman.aees.entities.EngDtDimByManuf;
import com.aeroman.aees.facades.CoreAircraftTypeFacade;

import com.aeroman.aees.facades.EngDamageQuestionFacade;
import com.aeroman.aees.facades.EngDamageTypeFacade;
import com.aeroman.aees.facades.EngDimensionFacade;
import com.aeroman.aees.facades.EngDamageTypeDimManufactFacade;
import com.aeroman.aees.facades.engExceptionDamageTypeFacade;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIInput;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mchacon
 */

@ManagedBean(name = "engDamageTypeManufactBean")
@SessionScoped //tipo de clase
public class EngDamageTypeManufactBean  extends CrudBean<EngDtDimByManuf> implements Serializable{
//EngRequestDimen
    /**
     * Creates a new instance of EngDamageTypeManufactBean
     */
    
    @EJB
    private EngDamageTypeFacade DamageTypeFacade;//declaracion de clases Facade
    
    @EJB
    private EngDimensionFacade DimensionFacade;//declaracion de clases Facade

       @EJB
    private engExceptionDamageTypeFacade exceptionDamageTypeFacade;//declaracion de clases Facade

       
    @EJB
    private CoreAircraftTypeFacade coreAircraftTypeFacade;//declaracion de clases Facade
    
 @ManagedProperty(value = "#{engDentBean}")
    private EngDentBean engDentBean;//declarion variable tipo clase
    
    @ManagedProperty(value = "#{damagtyBean}")
    private EngDamageTypeBean engDamageTypeBean;//declarion variable tipo clase
    
    
    
    
     
    @EJB
    private EngDamageTypeDimManufactFacade engDamageTypeDimManufactFacades;//declaracion de clases Facade
    
    @EJB
    private EngDamageQuestionFacade engDamageQuestionFacade;//declaracion de clases Facade
    
    @EJB
    private EngDamageTypeDimManufactFacade engDamageTypeDimManufactFacade;//declaracion de clases Facade

    
    
     private String userlg2;//declaracion de variable
     private int existeDmiManuf;
     private BigDecimal idDamageDimManuf;//declaracion de variable
     private String damageName; //declaracion de variable
     transient List<EngDamageQuestion> listaDamageQuestion= new ArrayList<>();//variable de lista
     private String PKDamageType;//declaracion de variable
     private String noExistListDimen;//declaracion de variable
     private String noExistListQuestion;//declaracion de variable
     transient List<EngDamageType> valorDamageType;   //declaracion de variable        
     private String  repetido;//declaracion de variable        
     private String sacarid;//declaracion de variable
 private String iddamage;//declaracion de variable     
private String nameDameEvent;//declaracion de variable
private String flota;//declaracion de variable
 private List<EngDtDimByManuf> listadoNLocal = new ArrayList<>();  
  private List<EngDtDimByManuf> listadoNDim = new ArrayList<>();  
  private List<EngDtDimByManuf> listadoNDimCheck = new ArrayList<>(); 
  private List<EngDtDimByManuf> listadoNearby = new ArrayList<>();  
  private List<EngDtDimByManuf> listadoNDimforBlend_Dent = new ArrayList<>();  
  
private String colaAvion;
private boolean isDefault;
    private BigDecimal idDamageDim;//declaracion de variable
    private String userlg;//declaracion de variable
    private String damageFK;//declaracion de variable
    private String dimensionFK;//declaracion de variable
    
    private boolean existDamage;//declaracion de variable
    private boolean existDimension;//declaracion de variable
    private boolean encontrarRepetido;//declaracion de variable
    
    private String nota;//declaracion de variable
    private String arctypId;//declaracion de variable
    
    private int pCount;//declaracion de variable
    
    private CoreAircraftType ct;//declaracion de variable
    
    private String users;//declaracion de variable
    
    private String clienteESR;
    
   boolean existeTipoException=false;
       private String manufacturador;//declaracion de variable

    public EngDamageTypeManufactBean() {
    }

    private List<String> listaManuf=new ArrayList<>();

        
    @Override
    //metodo constructor
    @PostConstruct
    void init() {
        elemento = nuevoElemento();
        HttpSession session2 = SessionBean.getSession();
        setUserlg2((String) session2.getAttribute("username"));
        edit = false;
        listaManuf = new ArrayList<>();
        listaManuf = engDamageTypeDimManufactFacades.traerManufacurerAER();
        listado = engDamageTypeDimManufactFacades.findAll();
        clienteESR="";
        
       valorDamageType = new ArrayList<>();      
       listaDamageQuestion = new ArrayList();
       ct = new CoreAircraftType();
       edit = false;
       setDamageFK(null);
       setDimensionFK(null);
       
       setFlota(null);
       setNoExistListDimen(null);
       setNoExistListQuestion(null);
       isDefault=false;
        
    }

        public void checkDefault() {   
            if(isDefault){
            isDefault=false;
            }else{
            isDefault=true;
            }
            System.out.println("Es Default: "+isDefault);
         
        }
    
    @Override
    public void limpiar() {     
        extendtime();
        elemento = nuevoElemento();
        listado = new ArrayList<>();
        listaDamageQuestion = new ArrayList<>();
        ct = new CoreAircraftType();
        edit = false;
        setDamageFK(null);
        setDimensionFK(null);
        existDamage = false;
        existDimension = false;
            listaManuf = engDamageTypeDimManufactFacades.traerManufacurerAER();
        listado = engDamageTypeDimManufactFacades.findAll();
       // setFlota(null);
        setNoExistListDimen(null);
        setNoExistListQuestion(null);
          isDefault=false;
       /*se vuelve a setear en este metodo el tiempo maximo de inactividad para que se cierre la session*/
         existeDmiManuf=0;
         limpiarDamageDimManuModal();
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
            if (getNameDameEvent().equals("Other") || getNameDameEvent().equals("DTA")) {
               EngDamageType engDT = DamageTypeFacade.findByDamageByNameTR(getNameDameEvent());
               engDamageTypeBean.listado2.add(engDT); 
             engDamageTypeBean.listado2 = new ArrayList<>();
             listadoNLocal= new ArrayList<>();
             listadoNDim= new ArrayList<>();
             listadoNDimCheck= new ArrayList<>();
            listadoNearby = new ArrayList<>();  
            listadoNDimforBlend_Dent = new ArrayList<>();  
            }
            else{
                engDamageTypeBean.listado2 = DamageTypeFacade.findAllActive();            
                if(iddamage!=null){
                EngDamageType engDT = DamageTypeFacade.findByDamageType(new BigDecimal(iddamage));
                  setDamageName(engDT.getDatName());
                
                }
                  
            }
        }
    
    public void findnameDameEvent() {
        extendtime();
        engDamageTypeBean.listado2 = new ArrayList<>();
        if (getNameDameEvent() == null) {
            setNameDameEvent("pasa");
        }
           if (getNameDameEvent().equals("Other") || getNameDameEvent().equals("DTA")) {
            EngDamageType engDT = DamageTypeFacade.findByDamageByNameTR(getNameDameEvent());
            engDamageTypeBean.listado2 = new ArrayList();
            listadoNLocal = new ArrayList<>();
            listadoNDim = new ArrayList<>();
            listadoNDimCheck = new ArrayList<>();
            listadoNearby = new ArrayList<>();  
            listadoNDimforBlend_Dent = new ArrayList<>();  
            if (engDT != null && engDT.getDatId() != null) {
                PKDamageType = engDT.getDatId().toString() + "-" + engDT.getDatName();
                iddamage = PKDamageType;
                FindAllByDamage();
            }
        } else {
            engDamageTypeBean.listado2 = DamageTypeFacade.findAllActive();
            PKDamageType = null;
            iddamage = null;
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
    
    public void setaerDT(String DT){
        setDamageFK(DT);
        
    }
    
    //Metodo que se activa cuando cambian de tipo de daño
public List<EngDtDimByManuf> FindAllByDamage(){
        extendtime();
        listadoNDim = new ArrayList<>();    
        listadoNLocal= new ArrayList<>();    
        listadoNDimCheck= new ArrayList<>();
        listadoNearby = new ArrayList<>();  
        listadoNDimforBlend_Dent = new ArrayList<>();  
        listaDamageQuestion = new ArrayList();
        noExistListDimen=null;
        noExistListQuestion=null;
         try {
             
                
             String cola=colaAvion;
            if(((iddamage != null) && (!iddamage.equals("")))&&((getFlota() != null) && (!getFlota().equals(""))))
            {
                setPKDamageType(iddamage);
                
                sacarid = iddamage.substring(0, iddamage.indexOf('-'));
                damageName = iddamage.substring(iddamage.indexOf('-')+1,iddamage.length());
                setDamageFK(damageName);
                
                manufacturador=exceptionDamageTypeFacade.traerManufAER(clienteESR, cola, getFlota());
                System.out.println("Valor iddamage: "+iddamage);
                System.out.println("Flota: "+getFlota());
                System.out.println("Cola: "+cola);
                System.out.println("Manufacturador: "+manufacturador);
                System.out.println("damageName: "+damageName);
                existeTipoException=exceptionDamageTypeFacade.existeExcep(damageName);
                if (!manufacturador.isEmpty()) {
                    if (existeTipoException) {
                        listadoNDim = engDamageTypeDimManufactFacade.traerDTDimByManuf("Dimension", manufacturador, new BigDecimal(sacarid));
                        listadoNDimCheck = engDamageTypeDimManufactFacade.traerDTDimByManufCheck("Dimension", manufacturador, new BigDecimal(sacarid));
                        listadoNLocal = engDamageTypeDimManufactFacade.traerLocationByManuf("Location", manufacturador, new BigDecimal(sacarid));
                        listadoNearby = engDamageTypeDimManufactFacade.traerNearbyDimByManuf("Nearby_Dimension", manufacturador, new BigDecimal(sacarid));
                        listadoNDimforBlend_Dent  = engDamageTypeDimManufactFacade.traerDTDimByManuf_forBD("Dimension", manufacturador, new BigDecimal(sacarid));
                    } else {// Others
                        listadoNDim = engDamageTypeDimManufactFacade.traerDTDimByManufOther("Dimension", "ALL", "");
                        listadoNDimCheck = engDamageTypeDimManufactFacade.traerDTDimByManufOtherCheck("Dimension", "ALL", "");
                        listadoNLocal = engDamageTypeDimManufactFacade.traerDTDimByManufOther("Location", "ALL", "");                        
                        listadoNearby = engDamageTypeDimManufactFacade.traerDTDimByManufOther("Nearby_Dimension", "ALL", "");
                        listadoNDimforBlend_Dent = new ArrayList<>();        
                        
                    }

                }
         
                
                
                              
                
                             engDentBean.setIdDamageType(sacarid);                
                ct = coreAircraftTypeFacade.findAllByFlota(getFlota());
                listado2 = engDamageTypeDimManufactFacade.findAllByFlota(sacarid,ct);
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
         if(!cola.isEmpty()){
         setColaAvion(cola);
         }
         
     }
    
     
    
    public boolean verificarExistenciaDamageType() {
        extendtime();
        boolean verifyDamageType = false;
        //listado = findAllNotDeleted();
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
        //listado = findAllNotDeleted();
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
          listadoNDim = new ArrayList();
          listadoNDimCheck = new ArrayList();
          listadoNLocal = new ArrayList();
          listadoNearby = new ArrayList();
          listadoNDimforBlend_Dent  = new ArrayList();
       
        
    }
      
   
       public void validadAll(String fabricante){
       if(fabricante.equals("ALL"))
           isDefault=true;
       else
           isDefault=false;
       }
   

    @Override
    void actualizar() {
        try {
            String manunfacturadorupd = "";
            EngDamageType damaType = new EngDamageType();
            EngDimension dimension = new EngDimension();
            if (!isDefault) {
                if (!damageFK.isEmpty()) {
                    BigDecimal damPK = new BigDecimal(damageFK.trim());
                    damaType = DamageTypeFacade.findByDamageType(damPK);
                }
                elemento.setDatId(damaType);

                manunfacturadorupd = elemento.getDtDimByManufName().trim();
            } else {
                elemento.setDatId(null);
                manunfacturadorupd = "ALL";
            }
         
            if (!dimensionFK.isEmpty()) {
                BigDecimal dimPK = new BigDecimal(dimensionFK.trim());
                dimension = DimensionFacade.findByDimension(dimPK);
            }
            
            boolean existe = engDamageTypeDimManufactFacades.existeTypeDamageManufUpdate(damaType.getDatId(), dimension.getDimId(), elemento.getDtDimByManufName(), elemento.getDtDimByManufId());
         if (dimension != null) {
            if (!existe) {
                // No se puede repetir un tipo de daño 
       
                    elemento.setDimId(dimension);

                    elemento.setDtDimByManufUserAdd(getUserlg2());
                    elemento.setDtDimByManufDateAdd(new Date());
                    elemento.setDtDimByManufUserUpd(getUserlg2());
                    elemento.setDtDimByManufDateUpd(new Date());                    
                    elemento.setDtDimByManufName(manunfacturadorupd);
                
                engDamageTypeDimManufactFacades.edit(elemento);
                limpiar();
            } else {
                existeDmiManuf = 1;
                FacesContext.getCurrentInstance().validationFailed();
            }
         }
            
        } catch (Exception e) {
            Logger.getLogger(EngDtDimByManuf.class.getName()).log(Level.SEVERE, null, e);
            FacesContext.getCurrentInstance().validationFailed();
        }
    
    }

    @Override
    void agregar() {
        try {
            String manunfacturadorA="";
            EngDamageType damaType = new EngDamageType();
            EngDimension dimension = new EngDimension();
            if(!isDefault){
                if (!damageFK.isEmpty()) {
                    BigDecimal damPK = new BigDecimal(damageFK.trim());
                    damaType = DamageTypeFacade.findByDamageType(damPK);
                }
                
                elemento.setDatId(damaType);
              
                
              manunfacturadorA =elemento.getDtDimByManufName().trim();  
            }else{
              elemento.setDatId(null);
               manunfacturadorA ="ALL";
            }
        if (!dimensionFK.isEmpty()) {
                    BigDecimal dimPK = new BigDecimal(dimensionFK.trim());
                    dimension = DimensionFacade.findByDimension(dimPK);
                }
                
          

            if (dimension != null) {

                boolean existe = engDamageTypeDimManufactFacades.existeTypeDamageManuf(damaType.getDatId(), dimension.getDimId(), manunfacturadorA);

                if (!existe) {

                    elemento.setDimId(dimension);
                    
                    elemento.setDtDimByManufUserAdd(getUserlg2());
                    elemento.setDtDimByManufDateAdd(new Date());
                    elemento.setDtDimByManufUserUpd(getUserlg2());
                    elemento.setDtDimByManufDateUpd(new Date());
                    elemento.setDtDimByManufState("Y");               
                    elemento.setDtDimByManufName(manunfacturadorA);    
                    engDamageTypeDimManufactFacades.create(elemento);
                    limpiar();
                } else {
                    existeDmiManuf = 1;
                    FacesContext.getCurrentInstance().validationFailed();
                }

            }
        } catch (Exception e) {
            Logger.getLogger(EngDtDimByManuf.class.getName()).log(Level.SEVERE, null, e);
            FacesContext.getCurrentInstance().validationFailed();
        }
            
    }

    @Override
    void eliminar(EngDtDimByManuf elemento) {
        try {
            engDamageTypeDimManufactFacades.remove(elemento);
            limpiar();
        } catch (Exception e) {
             Logger.getLogger(EngDamageTypeManufactBean.class.getName()).log(Level.SEVERE, null, e);
            FacesContext.getCurrentInstance().validationFailed();
        }
    
    }
    public void delete(String id) {  
        extendtime();
        try {
            BigDecimal idDamage = new BigDecimal(id);
            elemento = engDamageTypeDimManufactFacades.find(idDamage);            
            eliminar(elemento);

        } catch (Exception e) {
            Logger.getLogger(EngDamageTypeManufactBean.class.getName()).log(Level.SEVERE, null, e);
            FacesContext.getCurrentInstance().validationFailed();
        }
    }

        public void limpiarDamageDimManuModal() {
        extendtime();
        FacesContext context = FacesContext.getCurrentInstance();
        UIViewRoot root = context.getViewRoot();
        UIInput cbDamage = (UIInput) root.findComponent("inputFormDamageDimManuf:cbDamage1");
        cbDamage.resetValue();
        UIInput cbDimension = (UIInput) root.findComponent("inputFormDamageDimManuf:cbDimension1");
        cbDimension.resetValue();
        UIInput manuf = (UIInput) root.findComponent("inputFormDamageDimManuf:cbFlota1");
        manuf.resetValue();
         UIInput order = (UIInput) root.findComponent("inputFormDamageDimManuf:orderDamageManuf");
        order.resetValue();
        
    }

    @Override
    EngDtDimByManuf nuevoElemento() {
     return new EngDtDimByManuf();
    }

    public List<String> getListaManuf() {
        return listaManuf;
    }

    public void setListaManuf(List<String> listaManuf) {
        this.listaManuf = listaManuf;
    }

    public String getUserlg2() {
        return userlg2;
    }

    public void setUserlg2(String userlg2) {
        this.userlg2 = userlg2;
    }

    public String getDamageFK() {
        return damageFK;
    }

    public void setDamageFK(String damageFK) {
        this.damageFK = damageFK;
    }

    public String getDimensionFK() {
        return dimensionFK;
    }

    public void setDimensionFK(String dimensionFK) {
        this.dimensionFK = dimensionFK;
    }

    public int getExisteDmiManuf() {
        return existeDmiManuf;
    }

    public void setExisteDmiManuf(int existeDmiManuf) {
        this.existeDmiManuf = existeDmiManuf;
    }

    public BigDecimal getIdDamageDimManuf() {
        return idDamageDimManuf;
    }

    public void setIdDamageDimManuf(BigDecimal idDamageDimManuf) {
        this.idDamageDimManuf = idDamageDimManuf;
    }

    public String getPKDamageType() {
        return PKDamageType;
    }

    public void setPKDamageType(String PKDamageType) {
        this.PKDamageType = PKDamageType;
    }

    public String getNoExistListDimen() {
        return noExistListDimen;
    }

    public void setNoExistListDimen(String noExistListDimen) {
        this.noExistListDimen = noExistListDimen;
    }

    public String getNoExistListQuestion() {
        return noExistListQuestion;
    }

    public void setNoExistListQuestion(String noExistListQuestion) {
        this.noExistListQuestion = noExistListQuestion;
    }

    public List<EngDamageType> getValorDamageType() {
        return valorDamageType;
    }

    public void setValorDamageType(List<EngDamageType> valorDamageType) {
        this.valorDamageType = valorDamageType;
    }

    public String getRepetido() {
        return repetido;
    }

    public void setRepetido(String repetido) {
        this.repetido = repetido;
    }

    public String getSacarid() {
        return sacarid;
    }

    public void setSacarid(String sacarid) {
        this.sacarid = sacarid;
    }

    public String getIddamage() {
        return iddamage;
    }

    public void setIddamage(String iddamage) {
        this.iddamage = iddamage;
    }

    public EngDentBean getEngDentBean() {
        return engDentBean;
    }

    public void setEngDentBean(EngDentBean engDentBean) {
        this.engDentBean = engDentBean;
    }

    public String getDamageName() {
        return damageName;
    }

    public void setDamageName(String damageName) {
        this.damageName = damageName;
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

    public List<EngDtDimByManuf> getListadoNDimCheck() {
        return listadoNDimCheck;
    }

    public void setListadoNDimCheck(List<EngDtDimByManuf> listadoNDimCheck) {
        this.listadoNDimCheck = listadoNDimCheck;
    }
    
    
    
    public EngDamageTypeFacade getDamageTypeFacade() {
        return DamageTypeFacade;
    }

    public void setDamageTypeFacade(EngDamageTypeFacade DamageTypeFacade) {
        this.DamageTypeFacade = DamageTypeFacade;
    }

    public EngDimensionFacade getDimensionFacade() {
        return DimensionFacade;
    }

    public void setDimensionFacade(EngDimensionFacade DimensionFacade) {
        this.DimensionFacade = DimensionFacade;
    }

    public List<EngDamageQuestion> getListaDamageQuestion() {
        return listaDamageQuestion;
    }

    public void setListaDamageQuestion(List<EngDamageQuestion> listaDamageQuestion) {
        this.listaDamageQuestion = listaDamageQuestion;
    }

    public String getNameDameEvent() {
        return nameDameEvent;
    }

    public void setNameDameEvent(String nameDameEvent) {
        this.nameDameEvent = nameDameEvent;
    }

    public EngDamageTypeBean getEngDamageTypeBean() {
        return engDamageTypeBean;
    }

    public void setEngDamageTypeBean(EngDamageTypeBean engDamageTypeBean) {
        this.engDamageTypeBean = engDamageTypeBean;
    }

    public String getFlota() {
        return flota;
    }

    public void setFlota(String flota) {
        this.flota = flota;
    }

    public engExceptionDamageTypeFacade getExceptionDamageTypeFacade() {
        return exceptionDamageTypeFacade;
    }

    public void setExceptionDamageTypeFacade(engExceptionDamageTypeFacade exceptionDamageTypeFacade) {
        this.exceptionDamageTypeFacade = exceptionDamageTypeFacade;
    }

    public CoreAircraftTypeFacade getCoreAircraftTypeFacade() {
        return coreAircraftTypeFacade;
    }

    public void setCoreAircraftTypeFacade(CoreAircraftTypeFacade coreAircraftTypeFacade) {
        this.coreAircraftTypeFacade = coreAircraftTypeFacade;
    }

    public EngDamageTypeDimManufactFacade getEngDamageTypeDimManufactFacade() {
        return engDamageTypeDimManufactFacade;
    }

    public void setEngDamageTypeDimManufactFacade(EngDamageTypeDimManufactFacade engDamageTypeDimManufactFacade) {
        this.engDamageTypeDimManufactFacade = engDamageTypeDimManufactFacade;
    }

    public String getColaAvion() {
        return colaAvion;
    }

    public void setColaAvion(String colaAvion) {
        this.colaAvion = colaAvion;
    }

    public boolean isExistDamage() {
        return existDamage;
    }

    public void setExistDamage(boolean existDamage) {
        this.existDamage = existDamage;
    }

    public boolean isExistDimension() {
        return existDimension;
    }

    public void setExistDimension(boolean existDimension) {
        this.existDimension = existDimension;
    }

    public String getArctypId() {
        return arctypId;
    }

    public void setArctypId(String arctypId) {
        this.arctypId = arctypId;
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

    public EngDamageTypeDimManufactFacade getEngDamageTypeDimManufactFacades() {
        return engDamageTypeDimManufactFacades;
    }

    public void setEngDamageTypeDimManufactFacades(EngDamageTypeDimManufactFacade engDamageTypeDimManufactFacades) {
        this.engDamageTypeDimManufactFacades = engDamageTypeDimManufactFacades;
    }

    public BigDecimal getIdDamageDim() {
        return idDamageDim;
    }

    public void setIdDamageDim(BigDecimal idDamageDim) {
        this.idDamageDim = idDamageDim;
    }

    public String getUserlg() {
        return userlg;
    }

    public void setUserlg(String userlg) {
        this.userlg = userlg;
    }

    public boolean isEncontrarRepetido() {
        return encontrarRepetido;
    }

    public void setEncontrarRepetido(boolean encontrarRepetido) {
        this.encontrarRepetido = encontrarRepetido;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public int getpCount() {
        return pCount;
    }

    public void setpCount(int pCount) {
        this.pCount = pCount;
    }

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
    }

    public boolean isIsDefault() {
        return isDefault;
    }

    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    public String getClienteESR() {
        return clienteESR;
    }

    public void setClienteESR(String clienteESR) {
        this.clienteESR = clienteESR;
    }

    public List<EngDtDimByManuf> getListadoNearby() {
        return listadoNearby;
    }

    public void setListadoNearby(List<EngDtDimByManuf> listadoNearby) {
        this.listadoNearby = listadoNearby;
    }

    public List<EngDtDimByManuf> getListadoNDimforBlend_Dent() {
        return listadoNDimforBlend_Dent;
    }

    public void setListadoNDimforBlend_Dent(List<EngDtDimByManuf> listadoNDimforBlend_Dent) {
        this.listadoNDimforBlend_Dent = listadoNDimforBlend_Dent;
    }

    
    
    
    
}
