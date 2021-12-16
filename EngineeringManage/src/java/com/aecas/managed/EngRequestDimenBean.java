
//  To change this license header, choose License Headers in Project Properties.
//  To change this template file, choose Tools | Templates
//  and open the template in the editor.
 
package com.aecas.managed;// paquete manage

import com.aees.session.SessionBean;// importacion de clase
import com.aeroman.aees.entities.EngDamageDim;// importacion de clase
import com.aeroman.aees.entities.EngDent;// importacion de clase
import com.aeroman.aees.entities.EngDimension;// importacion de clase
import com.aeroman.aees.entities.EngDtDimByManuf;
import com.aeroman.aees.entities.EngRequest;// importacion de clase
import com.aeroman.aees.entities.EngRequestDimen;// importacion de clase
import com.aeroman.aees.entities.EngRequestQuestion;// importacion de clase
import com.aeroman.aees.facades.EngDentFacade;// importacion de clase
import com.aeroman.aees.facades.EngRequestDimenFacade;// importacion de clase
import com.aeroman.aees.facades.EngRequestQuestionFacade;// importacion de clase
import java.io.Serializable;// libreria Serializable
import java.math.BigDecimal;// libreria BigDecimal
import java.util.ArrayList;// libreria ArrayList
import java.util.Date;// libreria Date
import java.util.List;// libreria List
import java.util.logging.Level;// libreria Level
import java.util.logging.Logger;// libreria Logger
import javax.annotation.PostConstruct;// libreria PostConstruct
import javax.ejb.EJB;// libreria EJB
import javax.faces.bean.ManagedBean;// libreria ManagedBean
import javax.faces.bean.ManagedProperty;// libreria ManagedProperty
import javax.faces.bean.SessionScoped;// libreria SessionScoped
import javax.faces.component.UIInput;// libreria UIInput
import javax.faces.component.UIViewRoot;// libreria UIViewRoot
import javax.faces.context.FacesContext;// libreria FacesContext
import javax.servlet.http.HttpSession;// libreria HttpSession

/**
 *
 * @author mpolanco
 */
//nombre de clase en mageBean
@ManagedBean(name = "reqdimBean")
@SessionScoped
//tipo de clase
//clase EngRequestDimenBean con extends al crud
public class EngRequestDimenBean extends CrudBean<EngRequestDimen> implements Serializable {

    @EJB
    private EngRequestDimenFacade RequestDimenFacade;//declaracion de clases Facade

    @EJB
    private EngRequestQuestionFacade engRequestQuestionFacade;//declaracion de clases Facade
    
    @EJB
    private EngDentFacade engDentFacade;//declaracion de clases Facade
    
    @ManagedProperty(value = "#{damdimbean}")
    private EngDamageDimBean engDamageDimBean;//declarion variable tipo clase
    
    @ManagedProperty(value = "#{engDamageTypeManufactBean}")
    private EngDamageTypeManufactBean engDamageTypeManufactBean;//declarion variable tipo clase
    
    @ManagedProperty(value = "#{engRequestQuestionBean}")
    private EngRequestQuestionBean engRequestQuestionBean;//declarion variable tipo clase
    
    @ManagedProperty(value = "#{engDentBean}")
    private EngDentBean engDentBean;//declarion variable tipo clase
    
    
    private BigDecimal idAffectPart;//declaracion de variable
    private String userlg;//declaracion de variable
    private String dimFK;//declaracion de variable
    private String idDamage;//declaracion de variable
    private boolean encontrarRepetido;//declaracion de variable
    private String dimenciones;//declaracion de variable
    private String otherDescription;//declaracion de variable
    private ArrayList<EngDimension> dimencionesDamage;//declaracion de variable
    transient List<EngRequestDimen> listaRequestDimen = new ArrayList();//declaracion de variable
    transient List<EngDent> listaEngDent = new ArrayList();//declaracion de variable
    transient List<EngRequestQuestion> listaEngRequestQuestion = new ArrayList();//declaracion de variable
    private ArrayList<String> damageDimen;//declaracion de variable
    private String idListDamage;//declaracion de variable
    private String denAircraftGroundESR;//declaracion de variable
    private String denCriticalESR;//declaracion de variable
    List<EngRequestDimen> listadoEngRequestDim_Location = new ArrayList();//declaracion de variable
     List<EngRequestDimen> listadoEngRequestDim_Dimension = new ArrayList();//declaracion de variable
     List<EngRequestDimen> listadoEngRequestDim_DimensionCheck = new ArrayList();//declaracion de variable
  List<EngRequestDimen> listadoEngRequestDim_DimensionNearBy = new ArrayList();//declaracion de variable
    List<EngRequestDimen> listadoEngRequestDim_Nearby = new ArrayList();//declaracion de variable
    
    private EngRequest engEr;//declarion variable tipo clase

    @Override//metodo generado por implements Serializable
    @PostConstruct//metodo constructor
    public void init() {
        dimencionesDamage= new ArrayList();
        HttpSession session = SessionBean.getSession();
        setUserlg((String) session.getAttribute("username"));
        elemento = nuevoElemento();
        listado = new ArrayList<>();
        listadoEngRequestDim_Location = new ArrayList<>();
        listadoEngRequestDim_Dimension = new ArrayList<>();
        listadoEngRequestDim_DimensionCheck = new ArrayList<>();
        listaRequestDimen = new ArrayList<>();
        
        listadoEngRequestDim_DimensionNearBy = new ArrayList();//declaracion de variable
        listadoEngRequestDim_Nearby = new ArrayList();//declaracion de variable
        listaEngRequestQuestion = new ArrayList<>();
        listaEngDent = new ArrayList<>();
        edit = false;
        setDimFK(null);
        dimenciones=null;
        damageDimen= new ArrayList<>();
    }

    @Override//metodo generado por implements Serializable
    public void limpiar() {
        extendtime();//extiende el tiempo de sesion
        //engDamageDimBean.limpiarListas();
        engDamageTypeManufactBean.limpiarListas();
        //engDamageDimBean.setValorDamageType(null);
        engDamageTypeManufactBean.setValorDamageType(null);
        elemento = nuevoElemento();
        edit = false;
        setDimFK(null);
        dimenciones=null;
        setEncontrarRepetido(false);
        listadoEngRequestDim_Dimension=new ArrayList<>();
        listadoEngRequestDim_DimensionCheck=new ArrayList<>();
        listadoEngRequestDim_Location=new ArrayList<>();
        listadoEngRequestDim_DimensionNearBy = new ArrayList();//declaracion de variable
        listadoEngRequestDim_Nearby = new ArrayList();//declaracion de variable
        /*se vuelve a setear en este metodo el tiempo maximo de inactividad para que se cierre la session*/
        extendtime();//extiende el tiempo de sesion
    }
    public void limpiarLista() {
        extendtime();
        //engDamageDimBean.limpiarListas(); 
        engDamageTypeManufactBean.limpiarListas(); 
        elemento = nuevoElemento();
        edit = false;
        setDimFK(null);
        dimenciones=null;
        setEncontrarRepetido(false);
        listadoEngRequestDim_Dimension=new ArrayList<>();
        listadoEngRequestDim_DimensionCheck=new ArrayList<>();
        listadoEngRequestDim_Location=new ArrayList<>();
        /*se vuelve a setear en este metodo el tiempo maximo de inactividad para que se cierre la session*/
        extendtime();//extiende el tiempo de sesion
    }

    @Override//metodo generado por implements Serializable
    public void actualizar() {
        extendtime();//extiende el tiempo de sesion
        try {
            elemento.setRedUserUpd(getUserlg());
            elemento.setRedDateUpd(new Date());
            elemento.setRedState("A");

            if (elemento.getRedId() != null) {
                RequestDimenFacade.edit(elemento);
                dimenciones= elemento.getRedIdDimensionManf().getDimId().getDimDescription()+" - "+elemento.getRedValor().toString();
                limpiar();
            } else {
                FacesContext.getCurrentInstance().validationFailed();
            }
            

        } catch (Exception e) {
            Logger.getLogger(EngRequestDimenBean.class.getName()).log(Level.SEVERE, null, e);
            FacesContext.getCurrentInstance().validationFailed();
        }
    }

    @Override//metodo generado por implements Serializable
    public void agregar() {
        extendtime();//extiende el tiempo de sesion
        try {
            
            setEncontrarRepetido(false);
            //   engDamageDimBean.agregarLista();
            engDamageTypeManufactBean.agregarLista();
            List<EngRequestDimen> otroEliminar = listado;
            for (EngRequestDimen lis : otroEliminar) {
                for(EngDtDimByManuf listaDimeciones: engDamageTypeManufactBean.listado2){
                    if (lis.getRedIdDimensionManf().getDatId().equals(listaDimeciones.getDatId())) {
                    setEncontrarRepetido(true);                    
                    break;
                    }  
                }
               if (isEncontrarRepetido()) {
                    break;
                } 
            }
            if (!isEncontrarRepetido()) {
              engRequestQuestionBean.agregar();
               engDentBean.agregar();
    // Agremos la parte de los locations 
                for (EngDtDimByManuf listaDimeciones: engDamageTypeManufactBean.getListadoNLocal()) {                    
                    elemento.setRedIdRequest(getEngEr()); //id de ESR 
                    elemento.setRedIdDimensionManf(listaDimeciones);
                    elemento.setRedUserAdd(getUserlg());
                    elemento.setRedDateAdd(new Date());
                    elemento.setRedState("A");
                    elemento.setRedMeasure(listaDimeciones.getDimId().getMesure());
                    
                    if(listaDimeciones.getDimId().getOli()!= null && !listaDimeciones.getDimId().getOli().isEmpty() ){
                         if(listaDimeciones.getDatId() != null){// Entrara aqui cuando sea una exception(Blend out. Crack. Dent)
                              if(listaDimeciones.getDimId().getTypeControl().equals("textBox")){
                                 elemento.setRedValor(listaDimeciones.getDimId().getOli());
                             }else if(listaDimeciones.getDimId().getTypeControl().equals("checkBox")){
                                 elemento.setRedValorCheck(listaDimeciones.getDimId().getOli());
                             }  
                         
                         }else{// Aqui entrara cuando aplique para todas las flotas y todos los manufacturers
                                
                                    if(listaDimeciones.getDimId().getTypeControl().equals("textBox")){
                                        elemento.setRedValor(listaDimeciones.getDimId().getOli());
                                    }else if(listaDimeciones.getDimId().getTypeControl().equals("checkBox")){
                                        elemento.setRedValorCheck(listaDimeciones.getDimId().getOli());
                                    }
                               
                         }                       
                    }
                    
                    
                    
                    if (elemento.getRedIdRequest() != null && elemento.getRedIdRequest().getReqMessageid() != null) {
                        RequestDimenFacade.create(elemento);
                        listado.add(elemento);
                    }
                    else{
                        listado.add(elemento);                
                    }
                    elemento = new EngRequestDimen();
                    setDimFK(null);
                }
                /// agreguemos la parte de las dimensiones 
                  for (EngDtDimByManuf listaDimeciones: engDamageTypeManufactBean.getListadoNDim()) {                    
                    elemento.setRedIdRequest(getEngEr()); //id de ESR 
                    elemento.setRedIdDimensionManf(listaDimeciones);
                    elemento.setRedUserAdd(getUserlg());
                    elemento.setRedDateAdd(new Date());
                    elemento.setRedState("A");
                    elemento.setRedMeasure(listaDimeciones.getDimId().getMesure());
                    
                    if(listaDimeciones.getDimId().getOli()!= null && !listaDimeciones.getDimId().getOli().isEmpty() ){
                         if(listaDimeciones.getDatId() != null){// Entrara aqui cuando sea una exception(Blend out. Crack. Dent)
                             
                                 elemento.setRedValor(listaDimeciones.getDimId().getOli());
                             
                         
                         }else{// Aqui entrara cuando aplique para todas las flotas y todos los manufacturers
                                
                             
                                        elemento.setRedValor(listaDimeciones.getDimId().getOli());
                             
                               
                         }                       
                    }
                    
                    
                    
                    if (elemento.getRedIdRequest() != null && elemento.getRedIdRequest().getReqMessageid() != null) {
                        RequestDimenFacade.create(elemento);
                        listado.add(elemento);
                    }
                    else{
                        listado.add(elemento);                
                    }
                    elemento = new EngRequestDimen();
                    setDimFK(null);
                }
                
               //**
                /// agreguemos la parte de los Checkbox dimensiones 
                  for (EngDtDimByManuf listaDimeciones: engDamageTypeManufactBean.getListadoNDimCheck()) {                    
                    elemento.setRedIdRequest(getEngEr()); //id de ESR 
                    elemento.setRedIdDimensionManf(listaDimeciones);
                    elemento.setRedUserAdd(getUserlg());
                    elemento.setRedDateAdd(new Date());
                    elemento.setRedState("A");
                    elemento.setRedMeasure(listaDimeciones.getDimId().getMesure());
                    
                    if(listaDimeciones.getDimId().getOli()!= null && !listaDimeciones.getDimId().getOli().isEmpty() ){
                         if(listaDimeciones.getDatId() != null){// Entrara aqui cuando sea una exception(Blend out. Crack. Dent)                             
                                 elemento.setRedValorCheck(listaDimeciones.getDimId().getOli());                              
                         }else{// Aqui entrara cuando aplique para todas las flotas y todos los manufacturers                                
                                elemento.setRedValorCheck(listaDimeciones.getDimId().getOli());                                   
                               
                         }                       
                    }
                    if (elemento.getRedIdRequest() != null && elemento.getRedIdRequest().getReqMessageid() != null) {
                        RequestDimenFacade.create(elemento);
                        listado.add(elemento);
                    }
                    else{
                        listado.add(elemento);                
                    }
                    elemento = new EngRequestDimen();
                    setDimFK(null);
                }
                
                //********************* AQUI SE GUARDA LA DIMENSION DE BLEND OUT Y DENT ***********************************************
                for (EngDtDimByManuf listaDimeciones: engDamageTypeManufactBean.getListadoNDimforBlend_Dent()) {                    
                    elemento.setRedIdRequest(getEngEr()); //id de ESR 
                    elemento.setRedIdDimensionManf(listaDimeciones);
                    elemento.setRedUserAdd(getUserlg());
                    elemento.setRedDateAdd(new Date());
                    elemento.setRedState("A");
                    elemento.setRedMeasure(listaDimeciones.getDimId().getMesure());
                    
                    if(listaDimeciones.getDimId().getOli()!= null && !listaDimeciones.getDimId().getOli().isEmpty() ){
                         if(listaDimeciones.getDatId() != null){// Entrara aqui cuando sea una exception(Blend out. Crack. Dent)
                              if(listaDimeciones.getDimId().getTypeControl().equals("textBox")){
                                 elemento.setRedValor(listaDimeciones.getDimId().getOli());
                             }else if(listaDimeciones.getDimId().getTypeControl().equals("checkBox")){
                                 elemento.setRedValorCheck(listaDimeciones.getDimId().getOli());
                             }  
                         
                         }else{// Aqui entrara cuando aplique para todas las flotas y todos los manufacturers
                                
                                    if(listaDimeciones.getDimId().getTypeControl().equals("textBox")){
                                        elemento.setRedValor(listaDimeciones.getDimId().getOli());
                                    }else if(listaDimeciones.getDimId().getTypeControl().equals("checkBox")){
                                        elemento.setRedValorCheck(listaDimeciones.getDimId().getOli());
                                    }
                               
                         }                       
                    }
                    
                    
                    
                    if (elemento.getRedIdRequest() != null && elemento.getRedIdRequest().getReqMessageid() != null) {
                        RequestDimenFacade.create(elemento);
                        listado.add(elemento);
                    }
                    else{
                        listado.add(elemento);                
                    }
                    elemento = new EngRequestDimen();
                    setDimFK(null);
                }
                
                
                //************************** AQUI SE GUARDA LA SECCION DE NEARBY ********************************************
                for (EngDtDimByManuf listaDimeciones: engDamageTypeManufactBean.getListadoNearby()) {                    
                    elemento.setRedIdRequest(getEngEr()); //id de ESR 
                    elemento.setRedIdDimensionManf(listaDimeciones);
                    elemento.setRedUserAdd(getUserlg());
                    elemento.setRedDateAdd(new Date());
                    elemento.setRedState("A");
                    elemento.setRedMeasure(listaDimeciones.getDimId().getMesure());
                    
                    if(listaDimeciones.getDimId().getOli()!= null && !listaDimeciones.getDimId().getOli().isEmpty() ){
                         if(listaDimeciones.getDatId() != null){// Entrara aqui cuando sea una exception(Blend out. Crack. Dent)
                              if(listaDimeciones.getDimId().getTypeControl().equals("textBox")){
                                 elemento.setRedValor(listaDimeciones.getDimId().getOli());
                             }else if(listaDimeciones.getDimId().getTypeControl().equals("checkBox")){
                                 elemento.setRedValorCheck(listaDimeciones.getDimId().getOli());
                             }  
                         
                         }else{// Aqui entrara cuando aplique para todas las flotas y todos los manufacturers
                                
                                    if(listaDimeciones.getDimId().getTypeControl().equals("textBox")){
                                        elemento.setRedValor(listaDimeciones.getDimId().getOli());
                                    }else if(listaDimeciones.getDimId().getTypeControl().equals("checkBox")){
                                        elemento.setRedValorCheck(listaDimeciones.getDimId().getOli());
                                    }
                               
                         }                       
                    }
                    
                    
                    
                    if (elemento.getRedIdRequest() != null && elemento.getRedIdRequest().getReqMessageid() != null) {
                        RequestDimenFacade.create(elemento);
                        listado.add(elemento);
                    }
                    else{
                        listado.add(elemento);                
                    }
                    elemento = new EngRequestDimen();
                    setDimFK(null);
                }
                
                
                //***********************************************************************************************************
                engDamageTypeManufactBean.limpiarListas();
                
            }
        } catch (Exception e) {
            Logger.getLogger(TaskReqCardBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public void preUpdateLista(){
        extendtime();//extiende el tiempo de sesion
        updateLista(engDamageTypeManufactBean.getIddamage());
        setIdListDamage(null); 
        setDenAircraftGroundESR("0");
        setDenCriticalESR("0");
    }
    public void updateLista(String id){
        extendtime();//extiende el tiempo de sesion
        String damageType=null;       
        
        for (EngRequestDimen listDime : listadoEngRequestDim_Location) {
           // damageType=listDime.getRedIdDimensionManf().getDatId().getDatId().toString();
            if(listDime.getRedId()!=null){
                RequestDimenFacade.edit(listDime);  
               // break;
            }    
        }
        for (EngRequestDimen listDime : listadoEngRequestDim_DimensionCheck) {
        ///    damageType=listDime.getRedIdDimensionManf().getDatId().getDatId().toString();
            if(listDime.getRedId()!=null){
                RequestDimenFacade.edit(listDime);  
                //break;
            }    
        }
            for (EngRequestDimen listDime : listadoEngRequestDim_Dimension) {
       //     damageType=listDime.getRedIdDimensionManf().getDatId().getDatId().toString();
            if(listDime.getRedId()!=null){
                RequestDimenFacade.edit(listDime);  
               // break;
            }    
        }
        
           for (EngRequestDimen listDime : listadoEngRequestDim_DimensionNearBy) {
            if(listDime.getRedId()!=null){
                RequestDimenFacade.edit(listDime);  
       
            }    
        } 
           for (EngRequestDimen listDime : listadoEngRequestDim_Nearby) {
              if(listDime.getRedId()!=null){
                RequestDimenFacade.edit(listDime);  
      
            }    
        }
            
            
        for (EngDent listDime : engDentBean.listado) {
            damageType=listDime.getDatId().getDatId().toString();
            if(damageType.equals(id) && listDime.getDenId()!= null){
                listDime.setDenCritical(getDenCriticalESR());
                listDime.setDenAircraftGround(getDenAircraftGroundESR());
                engDentFacade.edit(listDime);
                break;
            }
            
            
        }
        for (EngRequestQuestion listDime : engRequestQuestionBean.listado) {
            damageType=listDime.getDxqId().getDatId().getDatId().toString();
            if(damageType.equals(id) && listDime.getReqId() != null){
                engRequestQuestionFacade.edit(listDime);
                break;
            }
            
            
        }
    }
    public void preEliminarDeLista(){
        extendtime();//extiende el tiempo de sesion
        eliminarDeLista(getIdListDamage());
        setIdListDamage(null);
    }
    public void eliminarDeLista(String id) {
        extendtime();//extiende el tiempo de sesion
        String pb = null;
        listaRequestDimen = new ArrayList<>();
        listaEngRequestQuestion = new ArrayList<>();
        listaEngDent = new ArrayList<>();
      
        for (EngRequestDimen listDime : listado) {
            pb=listDime.getRedIdDimensionManf().getDatId().getDatId().toString();
            if(!pb.equals(id)){
                listaRequestDimen.add(listDime);                
            }
            else{
                if (listDime.getRedId()!= null){
                    RequestDimenFacade.remove(listDime);
                }
            }
            
            
        }
        for (EngDent listDime : engDentBean.listado) {
            pb=listDime.getDatId().getDatId().toString();
            if(!pb.equals(id)){
                listaEngDent.add(listDime);                
            }
            else{
                if (listDime.getDenId()!= null){
                    engDentFacade.remove(listDime);
                }
            }
            
            
        }
        for (EngRequestQuestion listDime : engRequestQuestionBean.listado) {
            pb=listDime.getDxqId().getDatId().getDatId().toString();
            if(!pb.equals(id)){
                listaEngRequestQuestion.add(listDime);                
            }
            else{
                if (listDime.getReqId() != null){
                    engRequestQuestionFacade.remove(listDime);
                }
            }
            
            
        }
        
        listado=listaRequestDimen;
        engDentBean.listado=listaEngDent;
        engRequestQuestionBean.listado=listaEngRequestQuestion;
        engDamageTypeManufactBean.eliminarValorDamage(id);
    }

    @Override//metodo generado por implements Serializable
    public void eliminar(EngRequestDimen elemento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void delete(String id) {
        extendtime();//extiende el tiempo de sesion
        try {
            BigDecimal idAffected = new BigDecimal(id);
            elemento = RequestDimenFacade.find(idAffected);
            elemento.setRedUserDlt(getUserlg());
            elemento.setRedDateDlt(new Date());
            elemento.setRedState("D");

            if (elemento.getRedId() != null) {
                RequestDimenFacade.edit(elemento);
                limpiar();
            } else {
                FacesContext.getCurrentInstance().validationFailed();
            }

        } catch (Exception e) {
            Logger.getLogger(EngRequestDimenBean.class.getName()).log(Level.SEVERE, null, e);
            FacesContext.getCurrentInstance().validationFailed();
        }
    }

    @Override//metodo generado por implements Serializable
    public EngRequestDimen nuevoElemento() {
        return new EngRequestDimen();
    }

    public List<EngRequestDimen> findAllNotDeleted(BigDecimal idesr) {
        extendtime();//extiende el tiempo de sesion
        listado = new ArrayList<>();
        listadoEngRequestDim_Location = new ArrayList<>();
        listadoEngRequestDim_Dimension = new ArrayList<>();
        listadoEngRequestDim_DimensionCheck = new ArrayList<>();
        System.out.println("ID ESR: " + idesr);
        listado = RequestDimenFacade.findAllActive(idesr);
        listadoEngRequestDim_Location = RequestDimenFacade.findAllActiveLocation(idesr);
        listadoEngRequestDim_Dimension = RequestDimenFacade.findAllActiveDimension(idesr);
        listadoEngRequestDim_DimensionCheck = RequestDimenFacade.findAllActiveDimensionCheckbox(idesr);        
        listadoEngRequestDim_DimensionNearBy = RequestDimenFacade.findAllActiveDimensionBlend_Dent(idesr);
        listadoEngRequestDim_Nearby = RequestDimenFacade.findAllActiveNearBy(idesr);
        return listado;
    }

    public void limpiarDamageDimModal() {
        extendtime();//extiende el tiempo de sesion
        FacesContext context = FacesContext.getCurrentInstance();
        UIViewRoot root = context.getViewRoot();
        UIInput cbDimension = (UIInput) root.findComponent("fDimension:cbDimension");
        cbDimension.resetValue();
        UIInput redValor = (UIInput) root.findComponent("fDimension:redValor");
        redValor.resetValue();
    }

    //@return the idAffectPart
     
    public BigDecimal getIdAffectPart() {//get y set de variable
        return idAffectPart;
    }

   
     // @param idAffectPart the idAffectPart to set
    
    public void setIdAffectPart(BigDecimal idAffectPart) {//get y set de variable
        this.idAffectPart = idAffectPart;
    }

    // @return the userlg
    
    public String getUserlg() {//get y set de variable
        return userlg;
    }

    // @param userlg the userlg to set
    
    public void setUserlg(String userlg) {//get y set de variable
        this.userlg = userlg;
    }

    // @return the dimFK
     
    public String getDimFK() {//get y set de variable
        return dimFK;
    }

    // @param dimFK the dimFK to set
     
    public void setDimFK(String dimFK) {//get y set de variable
        this.dimFK = dimFK;
    }

    // @return the encontrarRepetido
    
    public boolean isEncontrarRepetido() {//get y set de variable
        return encontrarRepetido;
    }

    // @param encontrarRepetido the encontrarRepetido to set
     
    public void setEncontrarRepetido(boolean encontrarRepetido) {//get y set de variable
        this.encontrarRepetido = encontrarRepetido;
    }

    // @return the engEr
     
    public EngRequest getEngEr() {//get y set de variable
        return engEr;
    }

    // @param engEr the engEr to set
     
    public void setEngEr(EngRequest engEr) {//get y set de variable
        this.engEr = engEr;
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    // @return the idDamage
     
    public String getIdDamage() {//get y set de variable
        return idDamage;
    }

    // @param idDamage the idDamage to set
     
    public void setIdDamage(String idDamage) {//get y set de variable
        this.idDamage = idDamage;
    }

    public String getDimenciones() {//get y set de variable
        return dimenciones;
    }

    public void setDimenciones(String dimenciones) {//get y set de variable
        this.dimenciones = dimenciones;
    }

    public EngDamageDimBean getEngDamageDimBean() {//get y set de variable
        return engDamageDimBean;
    }

    public void setEngDamageDimBean(EngDamageDimBean engDamageDimBean) {//get y set de variable
        this.engDamageDimBean = engDamageDimBean;
    }

    public ArrayList<EngDimension> getDimencionesDamage() {//get y set de variable
        return dimencionesDamage;
    }

    public void setDimencionesDamage(ArrayList<EngDimension> dimencionesDamage) {//get y set de variable
        this.dimencionesDamage = dimencionesDamage;
    }

    public String getOtherDescription() {//get y set de variable
        return otherDescription;
    }

    public void setOtherDescription(String otherDescription) {//get y set de variable
        this.otherDescription = otherDescription;
    }

    public EngRequestQuestionBean getEngRequestQuestionBean() {//get y set de variable
        return engRequestQuestionBean;
    }

    public void setEngRequestQuestionBean(EngRequestQuestionBean engRequestQuestionBean) {//get y set de variable
        this.engRequestQuestionBean = engRequestQuestionBean;
    }

    public List<EngRequestDimen> getListaRequestDimen() {//get y set de variable
        return listaRequestDimen;
    }

    public void setListaRequestDimen(List<EngRequestDimen> listaRequestDimen) {//get y set de variable
        this.listaRequestDimen = listaRequestDimen;
    }

    public ArrayList<String> getDamageDimen() {//get y set de variable
        return damageDimen;
    }

    public void setDamageDimen(ArrayList<String> damageDimen) {//get y set de variable
        this.damageDimen = damageDimen;
    }

    public EngDentBean getEngDentBean() {//get y set de variable
        return engDentBean;
    }

    public void setEngDentBean(EngDentBean engDentBean) {//get y set de variable
        this.engDentBean = engDentBean;
    }

    public String getIdListDamage() {//get y set de variable
        return idListDamage;
    }

    public void setIdListDamage(String idListDamage) {//get y set de variable
        this.idListDamage = idListDamage;
    }

    public String getDenAircraftGroundESR() {//get y set de variable
        return denAircraftGroundESR;
    }

    public void setDenAircraftGroundESR(String denAircraftGroundESR) {//get y set de variable
        this.denAircraftGroundESR = denAircraftGroundESR;
    }

    public String getDenCriticalESR() {//get y set de variable
        return denCriticalESR;
    }

    public void setDenCriticalESR(String denCriticalESR) {//get y set de variable
        this.denCriticalESR = denCriticalESR;
    }
    public EngDamageTypeManufactBean getEngDamageTypeManufactBean() {
        return engDamageTypeManufactBean;
    }

    public void setEngDamageTypeManufactBean(EngDamageTypeManufactBean engDamageTypeManufactBean) {
        this.engDamageTypeManufactBean = engDamageTypeManufactBean;
    }

    public List<EngRequestDimen> getListadoEngRequestDim_Location() {
        return listadoEngRequestDim_Location;
    }

    public void setListadoEngRequestDim_Location(List<EngRequestDimen> listadoEngRequestDim_Location) {
        this.listadoEngRequestDim_Location = listadoEngRequestDim_Location;
    }

    public List<EngRequestDimen> getListadoEngRequestDim_Dimension() {
        return listadoEngRequestDim_Dimension;
    }

    public void setListadoEngRequestDim_Dimension(List<EngRequestDimen> listadoEngRequestDim_Dimension) {
        this.listadoEngRequestDim_Dimension = listadoEngRequestDim_Dimension;
    }

    public List<EngRequestDimen> getListadoEngRequestDim_DimensionCheck() {
        return listadoEngRequestDim_DimensionCheck;
    }

    public void setListadoEngRequestDim_DimensionCheck(List<EngRequestDimen> listadoEngRequestDim_DimensionCheck) {
        this.listadoEngRequestDim_DimensionCheck = listadoEngRequestDim_DimensionCheck;
    }

    public List<EngRequestDimen> getListadoEngRequestDim_DimensionNearBy() {
        return listadoEngRequestDim_DimensionNearBy;
    }

    public void setListadoEngRequestDim_DimensionNearBy(List<EngRequestDimen> listadoEngRequestDim_DimensionNearBy) {
        this.listadoEngRequestDim_DimensionNearBy = listadoEngRequestDim_DimensionNearBy;
    }

    public List<EngRequestDimen> getListadoEngRequestDim_Nearby() {
        return listadoEngRequestDim_Nearby;
    }

    public void setListadoEngRequestDim_Nearby(List<EngRequestDimen> listadoEngRequestDim_Nearby) {
        this.listadoEngRequestDim_Nearby = listadoEngRequestDim_Nearby;
    }
    
    
    
    
    
}
