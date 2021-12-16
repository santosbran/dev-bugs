
 // To change this license header, choose License Headers in Project Properties.
 // To change this template file, choose Tools | Templates
 // and open the template in the editor.
package com.aecas.managed;// paquete manage

import com.aees.pojos.SearchEAPojo;
import com.aees.session.SessionBean;// importacion de clase
import com.aeroman.aees.entities.grant.ContCheck;// importacion de clase
import com.aeroman.aees.entities.EngEaGeneral;// importacion de clase
import com.aeroman.aees.entities.EngRequest;// importacion de clase
import com.aeroman.aees.entities.grant.ContAtas;// importacion de clase
import com.aeroman.aees.entities.grant.SgrCia;
import com.aeroman.aees.facades.grant.ContCheckFacade;// importacion de clase
import com.aeroman.aees.facades.EngEaGeneralFacade;// importacion de clase
import com.aeroman.aees.facades.EngRequestFacade;// importacion de clase
import com.aeroman.aees.facades.grant.ContAtasFacade;// importacion de clase
import com.aeroman.aees.facades.grant.SgrCiaFacade;
import com.aeroman.aees.facades.grant.SgrUserFacades;
import java.io.Serializable;// libreria Serializable
import java.math.BigDecimal;// libreria BigDecimal
import java.math.BigInteger;// libreria BigInteger
import java.text.ParseException;// libreria ParseException
import java.text.SimpleDateFormat;// libreria SimpleDateFormat
import java.util.ArrayList;// libreria ArrayList
import java.util.Calendar;// libreria Calendar
import java.util.GregorianCalendar;// libreria GregorianCalendar
import java.util.HashMap;// libreria HashMap
import java.util.List;// libreria List
import java.util.Map;// libreria Map
import java.util.logging.Level;// libreria Level
import java.util.logging.Logger;// libreria Logger
import javax.annotation.PostConstruct;// libreria PostConstruct
import javax.ejb.EJB;// libreria EJB
import javax.faces.bean.ManagedBean;// libreria ManagedBean
import javax.faces.bean.ManagedProperty;// libreria ManagedProperty
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;// libreria FacesContext
import javax.persistence.EntityManager;// libreria EntityManager
import javax.persistence.EntityManagerFactory;// libreria EntityManagerFactory
import javax.servlet.http.HttpSession;// libreria HttpSession

/**
 *
 * @author Usuario motorBusquedaBean.limpiar()
 */
@ManagedBean(name = "motorBusquedaBean") //nombre de clase en mageBean
@SessionScoped//tipo de clase
//clase EsrBean con extends al crud
public class MotorBusquedaBean extends CrudBean<EngEaGeneral> implements Serializable {

    private List<EngEaGeneral> listEas = new ArrayList<>();//declaracion de variable
    private List<String> colaAviones = new ArrayList<>();//declaracion de variable
    private List<String> convertida = new ArrayList<>();//declaracion de variable
    private List<String> easStr = new ArrayList<>();//declaracion de variable
    private List<String> owStr = new ArrayList<>();//declaracion de variable
    private List<String> esrStr = new ArrayList<>();//declaracion de variable
    private List<String> titulos = new ArrayList<>();//declaracion de variable
    private List<String> atasStr = new ArrayList<>();//declaracion de variable
    private List<String> avionModels = new ArrayList<>();//declaracion de variable

    private List<ContCheck> oworks = new ArrayList<>();//declaracion de variable
    private List<EngRequest> esrs = new ArrayList<>();//declaracion de variable
    private List<EngEaGeneral> easGeneral = new ArrayList<>();//declaracion de variable
    private List<EngEaGeneral> easGeneral2 = new ArrayList<>();//declaracion de variable
    private List<Integer> atasG = new ArrayList<>();//declaracion de variable
    private List<ContAtas> todasAtas = new ArrayList<>();//declaracion de variable

    private String coAvion;//declaracion de variable
    private String owSelected;//declaracion de variable
    private String esrSelected;//declaracion de variable
    private String eaSelected;//declaracion de variable
    private String avionModel;//declaracion de variable
    private String pn;//declaracion de variable
    private String sn;//declaracion de variable
    private String titulo;//declaracion de variable
    private String ataBusq;//declaracion de variable
    private Integer anioSelect;//declaracion de variable
    private Integer ataSelected;//declaracion de variable
    private Integer id;//declaracion de variable
    private Boolean buscado = false;//declaracion de variable
    private EntityManager em;//declaracion de variable
    private EntityManagerFactory emf = null;//declaracion de variable
    private Map<String, BigInteger> mapEsr = new HashMap<>();//declaracion de variable
    private Map<String, BigDecimal> mapEa = new HashMap<>();//declaracion de variable
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy");//declaracion de variable
    SimpleDateFormat sdf2 = new SimpleDateFormat("yy");//declaracion de variable
    EngEaGeneral eaSelTabla;//declaracion de variable
    private boolean llenarcampos;//declaracion de variable
    private boolean nohaydata;//declaracion de variable    
    private String numEASearch;//declaracion de variable
    private String numESRSearch;//declaracion de variable 
    private String planeTailEASearch;//declaracion de variable 
    private String yearSearch;//declaracion de variable 
    private String varATAsEASearch;//declaracion de variable 
    private String airplaneModelEASearch;//declaracion de variable 
    private String varpnComponentSearch;//declaracion de variable 
    private String varsnComponentSearch;//declaracion de variable 
    private String titleSearch;//declaracion de variable 
    private SearchEAPojo elementSearchEAPojo;//declaracion de variable
    private List<SearchEAPojo> listSearchEAPojo;//declaracion de variable
    private Boolean esString;//declaracion de variable
    private String users;//declaracion de variable
    private String companyUser;//declarion de variable
    private SgrCia sgrCia;//declaracion de variable

    @ManagedProperty(value = "#{esrBean}")
    private EsrBean esr;//declarion variable tipo clase

    @EJB
    private EngEaGeneralFacade easF;//declaracion de clases Facade
    @EJB
    private SgrUserFacades sgrUserFacades;//declaracion de clases Facade
    @EJB
    private SgrCiaFacade companyFacade;//declaracion de clases Facade
    @EJB
    private ContCheckFacade cont;//declaracion de clases Facade
    @EJB
    private EngRequestFacade engRequestFacade;//declaracion de clases Facade
    @EJB
    private ContAtasFacade contAtasFacade;//declaracion de clases Facade

    @Override//metodo generado por implements Serializable
    @PostConstruct//metodo constructor
    public void init() {
        esString=true;
        HttpSession session = SessionBean.getSession();
        users =(String) session.getAttribute("username");
        companyUser = sgrUserFacades.findSelectUser(users).getCiaDefault();
    }
    
    public List<String> searchNumEA(String varSearchEA) {
        extendtime();//extiende el tiempo de sesion
        List<String> listNumEA = new ArrayList<>();
        if (varSearchEA != null) {

            if (varSearchEA.length() > 3) {
                listNumEA = engRequestFacade.findByNumEA(varSearchEA);
            }
        }
        return listNumEA;
    }

    public List<Object[]> searchNumESR(String varSearchEA) {
        esString=true;
        extendtime();//extiende el tiempo de sesion
        List<Object[]> listNumESREA = new ArrayList<>();
        listSearchEAPojo = new ArrayList<>();
        //elementSearchEAPojo = new SearchEAPojo();
        if (varSearchEA != null) {

            if (varSearchEA.length() > 3) {
                listNumESREA = engRequestFacade.findByNumESREA(varSearchEA);
                
            }
        }
        return listNumESREA;
    }

    public List<String> searchPlaneTailEA(String varSearchEA) {
        extendtime();//extiende el tiempo de sesion
        List<String> listPlaneTailEA = new ArrayList<>();
        if (varSearchEA != null) {

            if (varSearchEA.length() > 3) {
                listPlaneTailEA = engRequestFacade.findByPlaneTailEA(varSearchEA);
            }
        }
        return listPlaneTailEA;
    }

    public List<String> searchYear(String varSearchEA) {
        extendtime();//extiende el tiempo de sesion
        List<String> listYear = new ArrayList<>();
        if (varSearchEA != null) {

            if (varSearchEA.length() > 3) {
                listYear = engRequestFacade.findByYear(varSearchEA);
            }
        }
        return listYear;
    }

    public List<Object[]> searchATAsEA(String varSearchEA) {
        extendtime();//extiende el tiempo de sesion
        List<Object[]> listATAsEA = new ArrayList<>();
        if (varSearchEA != null) {

            if (varSearchEA.length() > 3) {
                listATAsEA = engRequestFacade.findByATAsEA(varSearchEA);
            }
        }
        return listATAsEA;
    }

    public List<String> searchAirplaneModelEA(String varSearchEA) {
        extendtime();//extiende el tiempo de sesion
        List<String> listAirplaneModelEA = new ArrayList<>();
        if (varSearchEA != null) {

            if (varSearchEA.length() > 3) {
                listAirplaneModelEA = engRequestFacade.findByAirplaneModelEA(varSearchEA);
            }
        }
        return listAirplaneModelEA;
    }

    public List<String> searchPNComponent(String varSearchEA) {
        extendtime();//extiende el tiempo de sesion
        List<String> listPNComponent = new ArrayList<>();
        if (varSearchEA != null) {

            if (varSearchEA.length() > 3) {
                listPNComponent = engRequestFacade.findByPNComponent(varSearchEA);
            }
        }
        return listPNComponent;
    }

    public List<String> searchSNComponent(String varSearchEA) {
        extendtime();//extiende el tiempo de sesion
        List<String> listSNComponent = new ArrayList<>();
        if (varSearchEA != null) {

            if (varSearchEA.length() > 3) {
                listSNComponent = engRequestFacade.findBySNComponent(varSearchEA);
            }
        }
        return listSNComponent;
    }

    public List<String> searchTitle(String varSearchEA) {
        extendtime();//extiende el tiempo de sesion
        List<String> listTitle = new ArrayList<>();
        if (varSearchEA != null) {

            if (varSearchEA.length() > 3) {
                listTitle = engRequestFacade.findByTitle(varSearchEA);
            }
        }
        return listTitle;
    }
     

    public void ordenWork() {
        extendtime();//extiende el tiempo de sesion
        List<ContCheck> contCheckTemp = new ArrayList<>();
        if (!"".equals(coAvion) && coAvion != null) {
            for (ContCheck check : oworks) {
                if (check.getChkRegistry().equals(coAvion)) {
                    contCheckTemp.add(check);
                }
            }
            oworks = contCheckTemp;
        } else {
            try {
                contCheckTemp = cont.findAll();
                oworks = contCheckTemp;
            } catch (Exception e) {
                Logger.getLogger(MotorBusquedaBean.class.getName());
            }
        }
    }

    public void cAvion() {
        extendtime();//extiende el tiempo de sesion
        List<String> aviones1 = new ArrayList<>();
        try {
            for (ContCheck avione1 : oworks) {
                if (!aviones1.contains(avione1.getChkRegistry())) {
                    aviones1.add(avione1.getChkRegistry());
                }
            }
            colaAviones = aviones1;
        } catch (Exception e1) {
            Logger.getLogger(MotorBusquedaEsrBean.class.getName()).log(Level.SEVERE, null, e1);
        }
    }

    public void esr() {
        extendtime();//extiende el tiempo de sesion
        if (esrStr != null) {
            esrStr.clear();

            for (EngRequest er : esrs) {
                try {
                    if (!esrStr.contains("ESR-" + er.getAtaNumata() + "-" + (er.getReqCorr() != null ? er.getReqCorr() : "NA") + "/" + er.getReqYear() != null ? sdf2.format(sdf.parse(er.getReqYear())) : "NA" + "")) {

                        String reqCorr = er.getReqCorr() != null ? er.getReqCorr() : "NA";
                        String reqYear = er.getReqYear() != null ? sdf2.format(sdf.parse(er.getReqYear())) : "NA";

                        mapEsr.put("ESR-" + er.getAtaNumata() + "-" + reqCorr + "/" + reqYear, er.getReqMessageid());
                        esrStr.add("ESR-" + er.getAtaNumata() + "-" + reqCorr + "/" + reqYear + "");
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(MotorBusquedaEsrBean.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

  
    public void buscar() {
        esString=false;
        extendtime();//extiende el tiempo de sesion
        listado = new ArrayList<>();
        easGeneral2.clear();
        try {
            Object[] valABusc = new Object[9];
        if (val(numEASearch)) {
            valABusc[0] = numEASearch;
        }
        if (val(numESRSearch)) {
                valABusc[1] = numESRSearch; 
                esString=false;
                EngRequest reqTem2 = engRequestFacade.find(new BigInteger(numESRSearch));
                numESRSearch = "ESR-" + reqTem2.getAtaNumata() + "-" + reqTem2.getReqCorr() + "/" + sdf2.format(sdf.parse(reqTem2.getReqYear()));
        }
        if (val(planeTailEASearch)) {
            valABusc[2] = planeTailEASearch;
        }
        if (val(yearSearch)) {
            valABusc[3] = yearSearch;
        }
        if (val(varATAsEASearch)) {
            boolean resultado = varATAsEASearch.contains("-");
            if (resultado){
                valABusc[4] = varATAsEASearch.substring(0, varATAsEASearch.indexOf('-')); 
            }
            
        }
        if (val(airplaneModelEASearch)) {
            valABusc[5] = airplaneModelEASearch;
        }
        if (val(varpnComponentSearch)) {
            valABusc[6] = varpnComponentSearch;
        }
        if (val(varsnComponentSearch)) {
            valABusc[7] = varsnComponentSearch;
        }
        if (val(titleSearch)) {
            valABusc[8] = titleSearch;
        }
        sgrCia = companyFacade.find(companyUser);
        if(sgrCia.getCiaAcceso().intValue()==1){
            easGeneral2 = easF.search(valABusc);
        }else{
            easGeneral2 = easF.searchOpco(valABusc,companyUser);
        }
        
        
            for (EngEaGeneral eaTemp : easGeneral2) {
                EngRequest reqTem = engRequestFacade.find(eaTemp.getReqMessageid());
                        if (reqTem != null) {
                            eaTemp.setNumeroEsr("ESR-" + reqTem.getAtaNumata() + "-" + reqTem.getReqCorr() + "/" + sdf2.format(sdf.parse(reqTem.getReqYear())));
                            eaTemp.setNumeroEa(eaTemp.getEagAta() + "-" + eaTemp.getEagCorrelative() + "-" + sdf2.format(sdf.parse(eaTemp.getEagYear().toString())));
                        }
                listado.add(eaTemp);
                easGeneral2= new ArrayList<>();
            }
            
        } catch (Exception e) {
            Logger.getLogger(MotorBusquedaBean.class.getName()).log(Level.SEVERE, null, e);//captura de error
            FacesContext.getCurrentInstance().validationFailed();
        }        
       
    }

    public Boolean val(Object val) {
        extendtime();//extiende el tiempo de sesion
        Boolean isNotNull = true;
        Integer esp = 0;
        String evaluar;
        if (val == null) {
            return isNotNull = false;
        }
        evaluar = val.toString();
        if (evaluar.isEmpty()) {
            return isNotNull = false;
        }
        for (int i = 0; i < evaluar.length(); i++) {
            if (evaluar.charAt(i) == ' ') {
                esp++;
            }
        }
        if (evaluar.length() == esp) {
            return isNotNull = false;
        }
        return isNotNull;
    }

    public Boolean valObject(Object[] valores) {
        extendtime();//extiende el tiempo de sesion
        Boolean nNolo = true;
        Integer nuls = 0;
        if (valores == null) {
            return nNolo = false;
        }
        for (int i = 0; i < valores.length; i++) {
            if (valores[i] == null) {
                nuls++;
            }
        }
        if (nuls == valores.length) {
            return false;
        }
        return nNolo;
    }
    
    public boolean verificarcamposllenos(){
        extendtime();//extiende el tiempo de sesion
        boolean siestanllenos = false;
        
        if(!"".equals(coAvion) || !"".equals(esrSelected) || !"".equals(eaSelected) || !"".equals(ataBusq)){
            siestanllenos = true;
        }else if(!"".equals(avionModel) || !"".equals(pn) || !"".equals(sn) || !"".equals(titulo)){
            siestanllenos = true;
        }else if(!"".equals(owSelected) || anioSelect != null){
            siestanllenos = true;
        }else {
            siestanllenos = false;
        }
        
        return siestanllenos; 
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void atasNombre() {
        extendtime();//extiende el tiempo de sesion
        for (ContAtas atasTemp : todasAtas) {
            atasStr.add("" + atasTemp.getAtaNumata() + "." + atasTemp.getAtaDescription().replaceAll("\\x1C", "").trim() + "");
        }

    }
    @Override//metodo generado por implements Serializable
    void limpiar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void limpiarCamps() {
        extendtime();//extiende el tiempo de sesion      
        coAvion= "";
        numEASearch="";
        numESRSearch= ""; 
        esString=false;
        planeTailEASearch= "";
        yearSearch= "";
        varATAsEASearch= "";
        airplaneModelEASearch= "";
        varpnComponentSearch= "";
        varsnComponentSearch= "";
        titleSearch= "";    
        listado = new ArrayList<>();
    }

    @Override//metodo generado por implements Serializable
    void actualizar() {
        extendtime();//extiende el tiempo de sesion
        HttpSession session = SessionBean.getSession();
        elemento.setAegUsrMod((String) session.getAttribute("username"));
        Calendar fechaUp = new GregorianCalendar();
        elemento.setAegDateMod(fechaUp.getTime());
        easF.edit(elemento);
        elemento = new EngEaGeneral();
        this.edit = false;
    }

    @Override//metodo generado por implements Serializable
    void agregar() {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override//metodo generado por implements Serializable
    void eliminar(EngEaGeneral elemento) {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override//metodo generado por implements Serializable
    EngEaGeneral nuevoElemento() {
        return new EngEaGeneral();
    }

    public void limpiar2() {
        this.elemento = new EngEaGeneral();
        this.edit = false;
    }

    public void cModal() {
        this.edit = true;
        if (this.id != null) {
            BigDecimal idc = new BigDecimal(this.id);
            this.elemento = easF.find(idc);
        }
    }

    public List<String> getColaAviones() {//get y set de variable
        return colaAviones;
    }

    public void setColaAviones(List<String> colaAviones) {//get y set de variable
        this.colaAviones = colaAviones;
    }

    public String getCoAvion() {//get y set de variable
        return coAvion;
    }

    public void setCoAvion(String coAvion) {//get y set de variable
        this.coAvion = coAvion.trim();
        ordenWork();
    }

    public List<ContCheck> getOworks() {//get y set de variable
        return (List<ContCheck>) oworks;
    }

    public void setOworks(List<ContCheck> oworks) {//get y set de variable
        this.oworks = oworks;
    }

    public String getOwSelected() {//get y set de variable
        return owSelected;
    }

    public void setOwSelected(String owSelected) {//get y set de variable
        this.owSelected = owSelected.trim();
    }

    public List<EngRequest> getEsrs() {//get y set de variable
        return esrs;
    }

    public void setEsrs(List<EngRequest> esrs) {//get y set de variable
        this.esrs = esrs;
    }

    public String getEsrSelected() {//get y set de variable
        return esrSelected;
    }

    public void setEsrSelected(String esrSelected) {//get y set de variable
        this.esrSelected = esrSelected.trim();
    }

    public String getEaSelected() {//get y set de variable
        return eaSelected;
    }

    public void setEaSelected(String eaSelected) {//get y set de variable
        this.eaSelected = eaSelected.trim();

    }

    public String getAvionModel() {//get y set de variable
        return avionModel;
    }

    public void setAvionModel(String avionModel) {//get y set de variable
        this.avionModel = avionModel.trim();
    }

    public String getPn() {//get y set de variable
        return pn;
    }

    public void setPn(String pn) {//get y set de variable
        this.pn = pn.trim();
    }

    public String getTitulo() {//get y set de variable
        return titulo;
    }

    public void setTitulo(String titulo) {//get y set de variable
        this.titulo = titulo;
    }    

    public String getSn() {//get y set de variable
        return sn;
    }

    public void setSn(String sn) {//get y set de variable
        this.sn = sn.trim();
    }

    public List<EngEaGeneral> getListEas() {//get y set de variable
        return listEas;
    }

    public void setListEas(List<EngEaGeneral> listEas) {//get y set de variable
        this.listEas = listEas;
    }

    public List<Integer> getAtasG() {//get y set de variable
        return atasG;
    }

    public void setAtasG(List<Integer> atasG) {//get y set de variable
        this.atasG = atasG;
    }

    public Integer getAtaSelected() {//get y set de variable
        return ataSelected;
    }

    public void setAtaSelected(Integer ataSelected) {//get y set de variable
        this.ataSelected = ataSelected;
    }

    public Boolean getBuscado() {//get y set de variable
        return buscado;
    }

    public void setBuscado(Boolean buscado) {//get y set de variable
        this.buscado = buscado;
    }

    /*getters y setters para el javascript*/
    public List<String> getConvertida() {//get y set de variable
        convertida.clear();
        for (String uno : colaAviones) {
            if (!convertida.contains("" + uno + "")) {
                convertida.add("" + uno + "");
            }
        }
        return convertida;
    }

    public void setConvertida(List<String> convertida) {//get y set de variable
        this.convertida = convertida;
    }

    public List<String> getEasStr() {//get y set de variable
        return easStr;
    }

    public void setEasStr(List<String> easStr) {//get y set de variable
        this.easStr = easStr;
    }

    public List<String> getOwStr() {//get y set de variable
        owStr = new ArrayList<>();
        for (ContCheck ob : oworks) {
            if (!owStr.contains("" + ob.getChkWo() + "")) {
                owStr.add("" + ob.getChkWo() + "");
            }
        }
        return owStr;
    }

    public void setOwStr(List<String> owStr) {//get y set de variable
        this.owStr = owStr;
    }

    public List<String> getEsrStr() {//get y set de variable
        return esrStr;
    }

    public void setEsrStr(List<String> esrStr) {//get y set de variable
        this.esrStr = esrStr;
    }

    public List<String> getTitulos() {//get y set de variable
        extendtime();
        titulos = new ArrayList<>();
        for (EngEaGeneral list : easGeneral) {
            if (list.getEagId().intValue() != 361 && !titulos.contains("" + list.getEagTitle() + "")) {
                titulos.add("" + list.getEagTitle() + "");
            }
        }
        return titulos;
    }

    public void setTitulos(List<String> titulos) {//get y set de variable
        this.titulos = titulos;
    }

    public List<String> getAtasStr() {//get y set de variable
        return atasStr;
    }

    public void setAtasStr(List<String> atasStr) {//get y set de variable
        this.atasStr = atasStr;
    }

    public List<String> getAvionModels() {//get y set de variable
        extendtime();
        avionModels.clear();
        for (EngEaGeneral list : easGeneral) {
            if (!avionModels.contains("" + list.getEagModel() + "")) {
                avionModels.add("" + list.getEagModel() + "");
            }
        }
        return avionModels;
    }

    public void setAvionModels(List<String> avionModels) {//get y set de variable
        this.avionModels = avionModels;
    }

    public List<EngEaGeneral> getEasGeneral() {//get y set de variable
        return easGeneral;
    }

    public void setEasGeneral(List<EngEaGeneral> easGeneral) {//get y set de variable
        this.easGeneral = easGeneral;
    }

    public EsrBean getEsr() {//get y set de variable
        return esr;
    }

    public void setEsr(EsrBean esr) {//get y set de variable
        this.esr = esr;
    }

    public List<EngEaGeneral> getEasGeneral2() {//get y set de variable
        return easGeneral2;
    }

    public void setEasGeneral2(List<EngEaGeneral> easGeneral2) {//get y set de variable
        this.easGeneral2 = easGeneral2;
    }

    public Integer getId() {//get y set de variable
        return id;
    }

    public void setId(Integer id) {//get y set de variable
        this.id = id;
    }

    public Map<String, BigInteger> getMapEsr() {//get y set de variable
        return mapEsr;
    }

    public void setMapEsr(Map<String, BigInteger> mapEsr) {//get y set de variable
        this.mapEsr = mapEsr;
    }

    public Map<String, BigDecimal> getMapEa() {//get y set de variable
        return mapEa;
    }

    public void setMapEa(Map<String, BigDecimal> mapEa) {//get y set de variable
        this.mapEa = mapEa;
    }

    public EngEaGeneral getEaSelTabla() {//get y set de variable
        return eaSelTabla;
    }

    public void setEaSelTabla(EngEaGeneral eaSelTabla) {//get y set de variable
        this.eaSelTabla = eaSelTabla;
    }

    public String getAtaBusq() {//get y set de variable
        return ataBusq;
    }

    public void setAtaBusq(String ataBusq) {//get y set de variable
        this.ataBusq = ataBusq;
    }

    public boolean isLlenarcampos() {//get y set de variable
        return llenarcampos;
    }

    public void setLlenarcampos(boolean llenarcampos) {//get y set de variable
        this.llenarcampos = llenarcampos;
    }

    public boolean isNohaydata() {//get y set de variable
        return nohaydata;
    }

    public void setNohaydata(boolean nohaydata) {//get y set de variable
        this.nohaydata = nohaydata;
    }

    public Integer getAnioSelect() {//get y set de variable
        return anioSelect;
    }

    public void setAnioSelect(Integer anioSelect) {//get y set de variable
        this.anioSelect = anioSelect;
    } 

    public String getNumEASearch() {
        return numEASearch;
    }

    public void setNumEASearch(String numEASearch) {
        this.numEASearch = numEASearch;
    }

    public String getNumESRSearch() {
        return numESRSearch;
    }

    public void setNumESRSearch(String numESRSearch) {
        this.numESRSearch = numESRSearch;
    }

    public String getPlaneTailEASearch() {
        return planeTailEASearch;
    }

    public void setPlaneTailEASearch(String planeTailEASearch) {
        this.planeTailEASearch = planeTailEASearch;
    }

    public String getYearSearch() {
        return yearSearch;
    }

    public void setYearSearch(String yearSearch) {
        this.yearSearch = yearSearch;
    }

    public String getVarATAsEASearch() {
        return varATAsEASearch;
    }

    public void setVarATAsEASearch(String varATAsEASearch) {
        this.varATAsEASearch = varATAsEASearch;
    }

    public String getAirplaneModelEASearch() {
        return airplaneModelEASearch;
    }

    public void setAirplaneModelEASearch(String airplaneModelEASearch) {
        this.airplaneModelEASearch = airplaneModelEASearch;
    }

    public String getVarpnComponentSearch() {
        return varpnComponentSearch;
    }

    public void setVarpnComponentSearch(String varpnComponentSearch) {
        this.varpnComponentSearch = varpnComponentSearch;
    }

    public String getVarsnComponentSearch() {
        return varsnComponentSearch;
    }

    public void setVarsnComponentSearch(String varsnComponentSearch) {
        this.varsnComponentSearch = varsnComponentSearch;
    }

    public String getTitleSearch() {
        return titleSearch;
    }

    public void setTitleSearch(String titleSearch) {
        this.titleSearch = titleSearch;
    }

    public SearchEAPojo getElementSearchEAPojo() {
        return elementSearchEAPojo;
    }

    public void setElementSearchEAPojo(SearchEAPojo elementSearchEAPojo) {
        this.elementSearchEAPojo = elementSearchEAPojo;
    }

    public List<SearchEAPojo> getListSearchEAPojo() {
        return listSearchEAPojo;
    }

    public void setListSearchEAPojo(List<SearchEAPojo> listSearchEAPojo) {
        this.listSearchEAPojo = listSearchEAPojo;
    }

    public Boolean getEsString() {
        return esString;
    }

    public void setEsString(Boolean esString) {
        this.esString = esString;
    }

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
    }

    public String getCompanyUser() {
        return companyUser;
    }

    public void setCompanyUser(String companyUser) {
        this.companyUser = companyUser;
    }
    
    
    
}
