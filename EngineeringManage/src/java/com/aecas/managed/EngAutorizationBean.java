
// To change this license header, choose License Headers in Project Properties.
 // To change this template file, choose Tools | Templates
 // and open the template in the editor.

package com.aecas.managed;// paquete manage

import com.aees.session.SessionBean;// libreria SessionBean
import com.aees.util.DocxGenerator;// libreria DocxGenerator
import com.aeroman.aees.entities.EngEaGeneral;// importacion de clase
import com.aeroman.aees.entities.EngListView;// importacion de clase
import com.aeroman.aees.entities.EngPlantillasEaCoverPart;// importacion de clase
import com.aeroman.aees.entities.EngRequest;// importacion de clase
import com.aeroman.aees.entities.grant.ContFleets;// importacion de clase
import com.aeroman.aees.facades.EngCustomerFacade;// importacion de clase
import com.aeroman.aees.facades.EngEaEstatusFacade;// importacion de clase
import com.aeroman.aees.facades.EngEaGeneralFacade;// importacion de clase
import com.aeroman.aees.facades.EngListViewFacade;// importacion de clase
import com.aeroman.aees.facades.EngPlantillasEaCoverPartFacade;// importacion de clase
import com.aeroman.aees.facades.Sequences;// importacion de clase
import com.aeroman.aees.facades.grant.ContFleetsFacade;// importacion de clase
import com.aeroman.aees.facades.grant.SgrCiaFacade;// importacion de clase
import java.io.IOException;// libreria IOException
import java.io.Serializable;// libreria Serializable
import java.math.BigDecimal;// libreria BigDecimal
import java.math.BigInteger;// libreria Serializable
import java.text.SimpleDateFormat;// libreria SimpleDateFormat
import java.util.ArrayList;// libreria ArrayList
import java.util.Calendar;// libreria Calendar
import java.util.Date;// libreria Date
import java.util.HashMap;// libreria HashMap
import java.util.List;// libreria List
import javax.annotation.PostConstruct;// libreria PostConstruct
import javax.ejb.EJB;// libreria EJB
import javax.faces.application.FacesMessage;// libreria FacesMessage
import javax.faces.bean.ManagedBean;// libreria ManagedBean
import javax.faces.context.FacesContext;// libreria FacesContext
import javax.servlet.http.HttpServletResponse;// libreria HttpServletResponse
import javax.servlet.http.HttpSession;// libreria HttpSession
import java.util.logging.Level;// libreria Level
import java.util.logging.Logger;// libreria Logger
import javax.faces.bean.SessionScoped;// libreria SessionScoped

/**
 *
 * @author Usuario
 */
//nombre de clase en mageBean
@ManagedBean(name = "engAutorizationBean")
@SessionScoped//tipo de clase
//clase ContAtasBean con extends al crud
public class EngAutorizationBean extends CrudBean<EngEaGeneral> implements Serializable {

    private String fecha1;//declaracion de variable
    private BigInteger idErs;//declaracion de variable
    private String usrCoduser;//declaracion de variable
    private boolean p = false;//declaracion de variable
    private String nameUser;//declaracion de variable
    private String status;//declaracion de variable
    private String year;//declaracion de variable
    private EngRequest reservarElementos;//declaracion de variable
    private EngEaGeneral eeg; //declarion variable tipo clase
    private Sequences sec;//declarion variable tipo clase
    transient List<ContFleets> flotas = new ArrayList();//declaracion de variable
    String cont38 = "&#38;";//declaracion de variable
    String cont60 = "&#60;";//declaracion de variable
    String tipoSolicitud="";

    @EJB
    private ContFleetsFacade conFleets;//declaracion de clases Facade
    @EJB
    private EngCustomerFacade engCustomerFacade;//declaracion de clases Facade
    @EJB
    private EngEaGeneralFacade engEaGeneralFacade;//declaracion de clases Facade
    @EJB
    private SgrCiaFacade sgrCiaFacade;//declaracion de clases Facade
    @EJB
    private EngEaEstatusFacade engEaEstatusFacade;//declaracion de clases Facade
    @EJB
    private EngListViewFacade engListViewFacade;//declaracion de clases Facade
    
    private Boolean actualizado;//declaracion de variable

    @EJB
    EngPlantillasEaCoverPartFacade engPlantillasEaCoverPartFacade;//declaracion de clases Facade

    //metodo generado por implements Serializable
    @Override
    //metodo constructor
    @PostConstruct
    void init() {
        elemento = new EngEaGeneral();//inicializa elemento
        actualizado = false;//asigna falso  a actualizado
        flotas = new ArrayList<>();
        flotas = conFleets.findAll();//llena la lista de flota
    }
//busca autorizacion por id
    public void EsrElementToEA(EngRequest esr) {
        extendtime();//extiende el tiempo de sesion 
        elemento.setFltCod(esr.getFltCod());//asigna la flota 
        elemento.setCompany(sgrCiaFacade.find(esr.getCompany()).getCiaName());//asigna la emepresa
        elemento.setEagTail(esr.getReqRegistry());//asigna el avion
        elemento.setEagCustomer(esr.getReqCustomer());//asigna el cliente
        elemento.setEstEstatus(engEaEstatusFacade.find("P"));//asigna el estatus p
        tipoSolicitud=esr.getEngTipoSolcitud();
    }
//metodo que actualiza la informcion en la base de datos
    public void actualiza(BigDecimal idactividad, String idingeniero) {
        extendtime();//extiende el tiempo de sesion 
        elemento = engEaGeneralFacade.find(idactividad);//asigna al elemento lo filtrado
        elemento.setAegIngComm(String.valueOf(idingeniero));//asigna a AegIngComm el id del ingeniero
        engEaGeneralFacade.edit(elemento);//edita el elemento en la BD
    }
//metodo que busca por ID
    public EngEaGeneral findSelect(String id) {
        extendtime();//extiende el tiempo de sesion 
        int ids = Integer.parseInt(id);//declara y asigna una vaeiable int
        BigDecimal idd = new BigDecimal(ids);//declara y asigna una variable bigdecimal
        elemento = engEaGeneralFacade.find(idd);//asigna al elemento lo filtrado
        return elemento;//retorna el elemento
    }
//agrega esr Autorization
    public void agregarESR(EngRequest req) {
        extendtime();//extiende el tiempo de sesion 
        reservarElementos = req;
        if (req.getUsrCoduser() == null || "0".equals(req.getUsrCoduser())) {//evalua el usario
            usrCoduser = "";//asigna vacio a coduser
        } else {
            usrCoduser = req.getUsrCoduser();//asigna el codigo del usuario
        }
    }
    //metodo que cancela la ea
    public void cancelarEA(){
        extendtime();//extiende el tiempo de sesion 
        try {//bloque contolado
            
            elemento.setEstEstatus(engEaEstatusFacade.find("C"));//asigna c al estatus de EA
            engEaGeneralFacade.edit(elemento);//edita el elemento en la base de datos
            
        } catch (Exception e) {//captura posibles errores
            Logger.getLogger(EngAutorizationBean.class.getName()).log(Level.SEVERE, null, e);//captura el err
        }
    }
//metodo generado por implements Serializable
    @Override
    public void limpiar() {
        extendtime();//extiende el tiempo de sesion 
        elemento = new EngEaGeneral();//inicializa elemento
        elemento.setReqMessageid(reservarElementos.getReqMessageid());//asigna el id
        tipoSolicitud=reservarElementos.getEngTipoSolcitud();
        elemento.setCompany(reservarElementos.getCompany());//asigna la empresa
        elemento.setEagCustomer(reservarElementos.getReqCustomer());//asigna el cliente
        elemento.setEagTail(reservarElementos.getReqRegistry());//asigna el avion
        elemento.setEstEstatus(engEaEstatusFacade.find("P"));//asigna p al estatus
        elemento.setFltCod(reservarElementos.getFltCod());//asigna la flota
        elemento.setEagYear(new BigInteger(String.valueOf(Calendar.getInstance().get(Calendar.YEAR))));//asigna el year
        elemento.setAegRevNum(BigInteger.valueOf(0));//asigna 0a rev num
        year = null;//asigna a la variable year null
        this.edit = false;//asigna falso a la variable edit
    }
//metodo generado por implements Serializable actualiza en BD
    @Override
    public void actualizar() {
        extendtime();//extiende el tiempo de sesion 
        eeg = new EngEaGeneral();//inicializa el elemento 
        eeg = engEaGeneralFacade.find(elemento.getEagId());//asigana a la varible ya filtrada
        if ( eeg != null) {//evalua
            HttpSession session = SessionBean.getSession();
            String user = (String) session.getAttribute("username");
            elemento.setAegUsrMod(user);
            elemento.setAegDateMod(new Date());
            engEaGeneralFacade.edit(elemento);
            limpiar();
        } else {

            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El elemento que esta tratnado de editar no existe en la base de datos"));
        } 
        actualizado = true;//asigna verdadero a actualizado
    }
//metodo que valida la fecha 
    public Boolean validateVal(Object value) {
        extendtime();//extiende el tiempo de sesion 
        Boolean notNull = true;//asigna verdadero a notnull
        Integer sp = 0;//declara y asigna el bolor de 0
        String evaluate;//declara variable
        if (value == null) {//evalua value si es null
            notNull = false;//asigna falso a notnull
            return notNull;//retorna variable
        }
        evaluate = value.toString();//asigna la variable value
        if (evaluate.isEmpty()) {//valua el vacio evalua el vacio 
            notNull = false;// asigna falso a la variable
            return notNull;//retorna variable
        }
        for (int i = 0; i < evaluate.length(); i++) {
            if (evaluate.charAt(i) == ' ') {
                sp++;//incrementa en uno
            }
        }
        if (evaluate.length() == sp) {//valua el tamaño evalua el vacio 
            notNull = false;// asigna falso a la variable
            return notNull;//retorna variable
        }
        return notNull;
    }
    public void finalizarEA(BigInteger eaID){
        eeg = new EngEaGeneral();//inicializa el elemento 
        eeg = engEaGeneralFacade.find(new BigDecimal(eaID));//asigana a la varible ya filtrada
        eeg.setEstEstatus(engEaEstatusFacade.find("F"));
        engEaGeneralFacade.edit(eeg);
    }
//metodo generado por implements Serializable agregar en BD
    @Override
    public void agregar() {
        extendtime();//extiende el tiempo de sesion 
        try {//bloque contolado
            sec = new Sequences();//inicializa la variable de variable
            
            BigDecimal numAta = new BigDecimal(elemento.getEagAta());//asigna id con la variable eagAta
            String pYear  = elemento.getEagYear().toString();//asigna pYear con la variable num getEagYear()
            
            elemento.setEagCorrelative(sec.MaxEACorr(numAta, pYear));//asigna al correlativo mexEACorr
            if (elemento.getEagId() != null) {//evalua si existe en la base de datos
                FacesContext.getCurrentInstance().validationFailed();//captura error
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El elemento que esta tratnado de agregar ya existe en la base de datos"));//devuelve el error
            } else {
                HttpSession session = SessionBean.getSession();
                String user = (String) session.getAttribute("username");//captura usuario logueado
                elemento.setAegUsrCrea(user);//asigno usuario
                elemento.setAegDateCrea(new Date());//asigno fecha 
                if(elemento.getAegDateRev()!= null){//evalua fecha
                    elemento.setAegRevNum(new BigInteger("1"));//asigna a aegNum 1
                }else{
                    elemento.setAegRevNum(new BigInteger("0"));//asigna a aegNum 0
                }
                engEaGeneralFacade.create(elemento);//crea el elemento en la base de datos
                limpiar();//ejecuta el motodo de limpiar
            }
        } catch (Exception e) {//captura posibles errores
            Logger.getLogger(EngAutorizationBean.class.getName()).log(Level.SEVERE, null, e);//captura error
        }

    }
//metodo generado por implements Serializable
    @Override
    void eliminar(EngEaGeneral elemento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//metodo generado por implements Serializable
    @Override
    public EngEaGeneral nuevoElemento() {
        return new EngEaGeneral();
    }
//get y set de variable
    public Boolean getActualizado() {
        return actualizado;
    }
//get y set de variable
    public void setActualizado(Boolean actualizado) {
        this.actualizado = actualizado;
    }
//metodo que genera reporte de cover
    public void reportecover() {
        extendtime();//extiende el tiempo de sesion 
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();

        try {
            extendtime();
            SimpleDateFormat sdfd = new SimpleDateFormat("dd MMM yyyy");

            //generacion de reporte EA_COVER
            String eand = elemento.getEagAta() + "-" + elemento.getEagCorrelative() + "-" + elemento.getEagYear().intValue() % 100;//setea la variable para el repote
            String nrevd = elemento.getAegRevNum() != null ? elemento.getAegRevNum().toString() : "NA";//setea la variable para el repote
            String issuedated = elemento.getEagDateEmi() != null ? sdfd.format(elemento.getEagDateEmi()) : sdfd.format(new Date());//setea la variable para el repote
            String airregf = elemento.getEagTail()!= null ? elemento.getEagTail(): "NA";//setea la variable para el repote
            String airmodd = elemento.getEagModel() != null ? elemento.getEagModel() : "NA";//setea la variable para el repote
            String comppnd = elemento.getEagCmpPn() != null ? elemento.getEagCmpPn() : "NA";//setea la variable para el repote
            String compsnd = elemento.getEagCmpSn() != null ? elemento.getEagCmpSn() : "NA";//setea la variable para el repote
            String titled = elemento.getEagTitle() != null ? elemento.getEagTitle() : "NA";//setea la variable para el repote
            String sernumb = elemento.getEagSn()!= null ? elemento.getEagSn() : "NA";//setea la variable para el repote
                    
            EngListView NameCod86d = engListViewFacade.findByCodigo86(elemento.getAegIngComm()).get(0);
            
            
            String    issuedbyd = NameCod86d.getPrimerNombre()+' '+NameCod86d.getPrimerApellido();
            
            
            DocxGenerator doc = new DocxGenerator();
            HashMap<String, String> variables = new HashMap<>();
            
            String const60 = cont60;//asignacion de variable 
            variables.put("ean", eand);//asigna variable a reporte
            variables.put("nrev", nrevd);//asigna variable a reporte
            variables.put("issuedate", issuedated);//asigna variable a reporte
            variables.put("airreg", airregf);//asigna variable a reporte
            variables.put("airmod", airmodd.replace("&", cont38).replace("<", const60));//asigna variable a reporte
            variables.put("comppn", comppnd.replace("&", cont38).replace("<", const60));//asigna variable a reporte
            variables.put("compsn", compsnd.replace("&", cont38).replace("<", const60));//asigna variable a reporte
            variables.put("title", titled.replace("&", cont38).replace("<", const60));//asigna variable a reporte
            variables.put("issuedby", issuedbyd);//asigna variable a reporte
            variables.put("dateissue", "DD MON YYYY");//asigna variable a reporte
            variables.put("datereviewed"," ");//asigna variable a reporte
            List<EngPlantillasEaCoverPart> plantCoverLstd = new ArrayList<>();//inicializa y asigna la lista palntCoverLstd
            
             if(tipoSolicitud.equals("ETR"))
            {  
              variables.put("sernumb", sernumb.replace("&", cont38).replace("<", const60));//asigna variable a reporte
              plantCoverLstd = engPlantillasEaCoverPartFacade.findByTipoDocuActivo("COV_TOOL");//inicializa y asigna la lista palntCoverLstd
                for (EngPlantillasEaCoverPart plantCoverd : plantCoverLstd) {//itera la lista 
                    byte[] datasd = plantCoverd.getBodyDocu();//asigna el body del documentacion
                    doc.generarDocRep(response, variables, "EA_COVER_TOOL_" + elemento.getEagId() + ".docx", datasd);//genera reporte
                }
            
            }else{
                   plantCoverLstd = engPlantillasEaCoverPartFacade.findByTipoDocuActivo("COV");//inicializa y asigna la lista palntCoverLstd
                    for (EngPlantillasEaCoverPart plantCoverd : plantCoverLstd) {//itera la lista 
                        byte[] datasd = plantCoverd.getBodyDocu();//asigna el body del documentacion
                        doc.generarDocRep(response, variables, "EA_COVER_" + elemento.getEagId() + ".docx", datasd);//genera reporte
                    }            
            
            }
            
            FacesContext.getCurrentInstance().responseComplete();//fin generacion de reporte EA_COVER

        } catch (Exception e) {//captura de poibles errores
            Logger.getLogger(EngAutorizationBean.class.getName()).log(Level.SEVERE, null, e);//captura de error
        }

    }

    public void reporteParts() {
        extendtime();//extiende el tiempo de sesion 
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        if (elemento.getAegNumPart()==null){
            elemento.setAegNumPart(BigInteger.valueOf(1));
        }else{
                int var1 = elemento.getAegNumPart().intValue()+1;
                elemento.setAegNumPart( BigInteger.valueOf(var1) );
        }        
        engEaGeneralFacade.edit(elemento);

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
            //generacion de reporte EA_PART

            String ean = elemento.getEagAta() + "-" + elemento.getEagCorrelative() + "-" + elemento.getEagYear().intValue() % 100;//setea la variable para el repote
            String nrev = elemento.getAegNumPart() != null ? elemento.getAegNumPart().toString() : "NA";//setea la variable para el repote
            String issuedate = elemento.getEagDateEmi() != null ? sdf.format(elemento.getEagDateEmi()) : sdf.format(new Date());//setea la variable para el repote
            String airreg = elemento.getEagTail()!= null ? elemento.getEagTail(): "NA";//setea la variable para el repote
            String airmod = elemento.getEagModel() != null ? elemento.getEagModel() : "NA";//setea la variable para el repote
            String comppn = elemento.getEagCmpPn() != null ? elemento.getEagCmpPn() : "NA";//setea la variable para el repote
            String compsn = elemento.getEagCmpSn() != null ? elemento.getEagCmpSn() : "NA";//setea la variable para el repote
            String title = elemento.getEagTitle() != null ? elemento.getEagTitle() : "NA";//setea la variable para el repote
            String issuedby = "NA";
            
            String sernumb = elemento.getEagSn()!= null ? elemento.getEagSn() : "NA";//setea la variable para el repote
            List<String> NameCod86 = engListViewFacade.findNameByEngCodigo86(elemento.getAegIngComm());
            
            for (String name : NameCod86) {
                issuedby = name;
            }

            DocxGenerator doc = new DocxGenerator();
            HashMap<String, String> variables = new HashMap<>();
            
            String const60 = cont60;//asignacion de variable 
            variables.put("ean", ean);//asigna variable a reporte
            variables.put("nrev", nrev);//asigna variable a reporte
            variables.put("issuedate", issuedate);//asigna variable a reporte
            variables.put("airreg", airreg);//asigna variable a reporte
            variables.put("airmod", airmod.replace("&", cont38).replace("<", const60));//asigna variable a reporte
            variables.put("comppn", comppn.replace("&", cont38).replace("<", const60));//asigna variable a reporte
            variables.put("compsn", compsn.replace("&", cont38).replace("<", const60));//asigna variable a reporte
            variables.put("title", title.replace("&", cont38).replace("<", const60));//asigna variable a reporte
            variables.put("issuedby", issuedby);//asigna variable a reporte
            List<EngPlantillasEaCoverPart> plantCoverLst= new ArrayList<>();// = engPlantillasEaCoverPartFacade.findByTipoDocuActivo("PAR");//inicializa y asigna la lista
            if(tipoSolicitud.equals("ETR"))
            {  
              variables.put("sernumb", sernumb.replace("&", cont38).replace("<", const60));//asigna variable a reporte
              plantCoverLst = engPlantillasEaCoverPartFacade.findByTipoDocuActivo("PAR_TOOL");//inicializa y asigna la lista
                for (EngPlantillasEaCoverPart plantCover : plantCoverLst) {//itera la lista
                    byte[] datas = plantCover.getBodyDocu();//asigna el body del documentacion
                    doc.generarDocRep2_tool(response, variables, "EA_PART_TOOL_" + elemento.getEagId() + ".docx", datas);//genera reporte
                }
            
            }else{
              plantCoverLst = engPlantillasEaCoverPartFacade.findByTipoDocuActivo("PAR");//inicializa y asigna la lista
                   for (EngPlantillasEaCoverPart plantCover : plantCoverLst) {//itera la lista
                byte[] datas = plantCover.getBodyDocu();//asigna el body del documentacion
                doc.generarDocRep2(response, variables, "EA_PART_" + elemento.getEagId() + ".docx", datas);//genera reporte
                     }
            
            
            }
            
            
           
            FacesContext.getCurrentInstance().responseComplete(); //fin generacion de reporte EA_PART

        } catch (IOException e) {
            Logger.getLogger(EngAutorizationBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }
//get y set de variable
    public String getFecha1() {
        return fecha1;
    }
//get y set de variable
    public void setFecha1(String fecha1) {
        this.fecha1 = fecha1;
    }
//get y set de variable
    public List<ContFleets> getFlotas() {
        return flotas;
    }
//get y set de variable
    public void setFlotas(List<ContFleets> flotas) {
        this.flotas = flotas;
    }
//get y set de variable
    public BigInteger getIdErs() {
        return idErs;
    }
//get y set de variable
    public void setIdErs(BigInteger idErs) {
        this.idErs = idErs;
    }
//get y set de variable
    public String getUsrCoduser() {
        return usrCoduser;
    }
//get y set de variable
    public void setUsrCoduser(String usrCoduser) {
        this.usrCoduser = usrCoduser;
    }
//get y set de variable
    public String getStatus() {
        if (elemento.getEstEstatus() != null) {
            status = engEaEstatusFacade.findNameId(elemento.getEstEstatus().getEaeId()).getEaeEstName();
        } else {
            status = "";
        }
        return status;
    }
//get y set de variable
    public void setStatus(String sts) {
        this.status = sts;
    }
//get y set de variable
    public String getNameUser() {
        sec = new Sequences();
        nameUser = sec.traernombredeusuario(elemento.getAegIngComm());
        return nameUser;
    }
//get y set de variable
    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }
//get y set de variable
    public String getYear() {
        return year;
    }
//get y set de variable
    public void setYear(String year) {
        this.year = year;
    }
//get y set de variable
    public EngRequest getReservarElementos() {
        return reservarElementos;
    }
//get y set de variable
    public void setReservarElementos(EngRequest reservarElementos) {
        this.reservarElementos = reservarElementos;
    }
//get y set de variable
    public boolean isP() {
        return p;
    }
//get y set de variable
    public void setP(boolean p) {
        this.p = p;
    }
//get y set de variable
    public String getCont38() {
        return cont38;
    }
//get y set de variable
    public void setCont38(String cont38) {
        this.cont38 = cont38;
    }
//get y set de variable
    public String getTipoSolicitud() {
        return tipoSolicitud;
    }

    public void setTipoSolicitud(String tipoSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
    }
}
