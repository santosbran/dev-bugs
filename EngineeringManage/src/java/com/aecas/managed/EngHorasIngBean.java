 // To change this license header, choose License Headers in Project Properties.
 // To change this template file, choose Tools | Templates
 // and open the template in the editor.
package com.aecas.managed;// paquete manage

import com.aees.session.EnviarEmail;// importacion de clase
import com.aees.util.ExcellCreator;// importacion de clase
import com.aees.session.SessionBean;// importacion de clase
import com.aeroman.aees.entities.EngHorasIng;// importacion de clase
import com.aeroman.aees.entities.EngHorasIngPK;// importacion de clase
import com.aeroman.aees.entities.EngHoursVw;// importacion de clase
import com.aeroman.aees.entities.EngHrsIns;// importacion de clase
import com.aeroman.aees.entities.EngReqIngaction;// importacion de clase
import com.aeroman.aees.entities.EngRequest;// importacion de clase
import com.aeroman.aees.entities.EngTabEsrnwsVw;
import com.aeroman.aees.entities.HoursExp;// importacion de clase
import com.aeroman.aees.entities.HoursExport;// importacion de clase
import com.aeroman.aees.facades.EngHorasIngFacade;// importacion de clase
import com.aeroman.aees.facades.Sequences;// importacion de clase
import com.aeroman.aees.entities.Horas;// importacion de clase
import com.aeroman.aees.entities.grant.PrcDetparam;// importacion de clase
import com.aeroman.aees.facades.AecasEsrMhFacade;// importacion de clase
import com.aeroman.aees.facades.EngEaHrsInsFacade;// importacion de clase
import com.aeroman.aees.facades.EngHoursVwFacade;// importacion de clase
import com.aeroman.aees.facades.EngReqIngactionFacade;// importacion de clase
import com.aeroman.aees.facades.EngRequestFacade;// importacion de clase
import com.aeroman.aees.facades.EngTabEsrnwsVwFacade;
import com.aeroman.aees.facades.grant.PrcDetparamFacade;// importacion de clase
import java.io.IOException;// libreria IOException
import java.io.Serializable;// libreria Serializable
import java.math.BigDecimal;
import java.math.BigInteger;// libreria BigInteger
import java.text.ParseException;// libreria ParseException
import java.util.ArrayList;// libreria ArrayList
import java.util.Date;// libreria Date
import java.util.List;// libreria List
import java.util.logging.Level;// libreria Level
import java.util.logging.Logger;// libreria Logger
import javax.annotation.PostConstruct;// libreria PostConstruct
import javax.ejb.EJB;// libreria EJB
import javax.faces.application.FacesMessage;// libreria FacesMessage
import javax.faces.bean.ManagedBean;// libreria ManagedBean
import javax.faces.bean.ManagedProperty;// libreria ManagedProperty
import javax.faces.bean.SessionScoped;// libreria SessionScoped
import javax.faces.context.FacesContext;// libreria FacesContext
import javax.persistence.EntityManager;// libreria EntityManager
import javax.persistence.EntityManagerFactory;// libreria EntityManagerFactory
import javax.persistence.Persistence;// libreria Persistence
import javax.servlet.ServletOutputStream;// libreria ServletOutputStream
import javax.servlet.http.HttpServletResponse;// libreria HttpServletResponse
import javax.servlet.http.HttpSession;// libreria HttpSession
import org.apache.poi.hssf.usermodel.HSSFWorkbook;// libreria HSSFWorkbook

/**
 *
 * @author APLICATIVA_01
 */
//nombre de clase en mageBean
@ManagedBean(name = "engHorasIngBean")
@SessionScoped //tipo de clase
//clase ContAtasBean con extends al crud
public class EngHorasIngBean extends CrudBean<EngHorasIng> implements Serializable {

    private EntityManagerFactory emf = null;//declaracion de variable
    private static final long serialVersionUID = 1L;//declaracion de variable

    @EJB
    private AecasEsrMhFacade aecasEsrMhFacade;//declaracion de clases Facade
    @EJB
    private EngHorasIngFacade engHorasIngFacade;//declaracion de clases Facade
    @EJB
    private EngHoursVwFacade engHoursVwFacade;//declaracion de clases Facade
    @EJB
    private EngEaHrsInsFacade engEaHrsInsFacade;//declaracion de clases Facade
    @EJB
    private Sequences sec;//declaracion de clases Facade
    @EJB
    private EngRequestFacade engRequestFacade;//declaracion de clases Facade
    @EJB
    private PrcDetparamFacade prcDetparamFacade;//declaracion de clases Facade
    @EJB
    private EngReqIngactionFacade engReqIngactionFacade;//declaracion de clases Facade
    @EJB
    private EngTabEsrnwsVwFacade engTabEsrnwsVwFacade;//declaracion de clases Facade

    @ManagedProperty(value = "#{aecasBean}")
    private AecasBean aecasBean;//declarion variable tipo clase
    @ManagedProperty(value = "#{Login}")
    private LoginBean loginBean;//declarion variable tipo clase
    @ManagedProperty(value = "#{reportesSeguiCheqBean}")
    private ReportesSeguiCheqBean reportesBean;//declarion variable tipo clase

    private List<Horas> aux = new ArrayList();//declaracion de variable
    private String id;//declaracion de variable
    private String idz;//declaracion de variable
    private String listadoId = "inicio";//declaracion de variable
    private int export;//declaracion de variable
    private EngRequest engRequest;//declaracion de variable
    private List<HoursExport> expor = new ArrayList();//declaracion de variable
    private List<Horas> listHours = new ArrayList();//declaracion de variable
    private List<EngRequest> esr = new ArrayList();//declaracion de variable
    private List<HoursExp> hoursExp = new ArrayList();//declaracion de variable
    private List<EngHoursVw> enghoursvw = new ArrayList();//declaracion de variable
    private List<EngHoursVw> enghoursvw2 = new ArrayList();//declaracion de variable
    private List<PrcDetparam> listParam = new ArrayList();//declaracion de variable
    private EngHorasIngPK llave;//declaracion de variable
    private Short idChk;//declaracion de variable
    private String cola;//declaracion de variable
    private String workOrder;//declaracion de variable

    //metodo generado por implements Serializable
    @Override
    //metodo constructor
    @PostConstruct
    public void init() {
        elemento = new EngHorasIng();
        llave = new EngHorasIngPK();
        //listado = engHorasIngFacade.findAllEngHorasIng();
        emf = Persistence.createEntityManagerFactory("EngineeringManageBCPU");

    }

    public void redireccionar2(String idx) {//recine el parametro y redirecciona a la pagina siguiente, este metodo es llamado desde la vista anterior
        try {
            extendtime();
            setIdz("1");
            id = idx; //parametro recibido de la vista anterior, reportesSeguiCheq.xhtml, este id sera ocupado en la consulta
            llenado(id);
            BigInteger idc = new BigInteger(id);
            engRequest = engRequestFacade.find(idc);

        } catch (Exception e) {
            Logger.getLogger(ReportesSeguiCheqBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void llenarHoursByCheck(Short idCheck) {
        extendtime();
        export = 1;
        String nesr;
        String descripcion;
        BigDecimal facturar;
        BigDecimal sumahoras;
        String correlativo;
        String idesr;
        String cmbindex;
        String hint;
        String wotask;
        String year;
        String jobcard;
        boolean chequeado;
        aux = new ArrayList<>();
        enghoursvw2 = engHoursVwFacade.findByCheck(idCheck);

        for (int i = 0; i < enghoursvw2.size(); i++) {

            nesr = enghoursvw2.get(i).getNesr();
            descripcion = enghoursvw2.get(i).getSubject();
            List<EngReqIngaction> erinList = engReqIngactionFacade.findByMessageId(enghoursvw2.get(i).getReqMessageid());
            StringBuilder sb = new StringBuilder();
            for (EngReqIngaction erin : erinList) {
                sb.append(erin.getEinDescription());
                sb.append(", ");
            }
            String eacompletado = sb.toString();

            facturar = enghoursvw2.get(i).getFacturar();
            sumahoras = enghoursvw2.get(i).getSumhours();
            idesr = enghoursvw2.get(i).getReqMessageid().toString();
            hint = enghoursvw2.get(i).getHinId() == null ? " " : enghoursvw2.get(i).getHinId().toString();
            correlativo = enghoursvw2.get(i).getCorr().toString();
            wotask = String.valueOf(enghoursvw2.get(i).getCheckid());
            year = enghoursvw2.get(i).getChkYear().toString();
            chequeado = "S".equals(enghoursvw2.get(i).getSelection());
            if (enghoursvw2.get(i).getComboindex() != null) {
                cmbindex = (String) enghoursvw2.get(i).getComboindex().toString();
            } else {
                cmbindex = "1";
            }
            //con una hora que no haya sido exportada debera aparecer aun 
            if (enghoursvw2.get(i).getExported() != null && export ==1) {
                if (("Y").equals(enghoursvw2.get(i).getExported())) {
                    export = 1;
                } else {
                    export = 2;
                }
            } else {
                export = 2;
            }
            
            jobcard=enghoursvw2.get(i).getJobcard();
            
            String idtemp = Integer.toString(i);
            Horas horas = new Horas(nesr, descripcion, eacompletado, facturar, sumahoras, idtemp, idesr, cmbindex, chequeado, hint, correlativo, wotask, year,jobcard);
            aux.add(horas);

        }
    }

    public void addElement(Horas h) {
        extendtime();
        if (listHours.contains(h)) {
            listHours.remove(h);
        }
        listHours.add(h);
    }

    public void llenado(String idx) {
        extendtime();
        String comboindex;
        String nesr;
        BigDecimal sumahoras;
        String correlativo;
        String wotask;
        String year;
        String idesr;
        String hint;
        Boolean chequeado;
        String descripcion;
        BigDecimal facturar;
        String eacompletado = null;
        String jobcard;

        List<Object[]> lista = new ArrayList<>();
        aux.clear();//limpia el contenido de la lista para evitar que se acumule cada vez que se abra una vista
        lista.clear();
        enghoursvw = engHoursVwFacade.findAll();

        List<EngHoursVw> listmex = new ArrayList<>();
        int x = 0;
        while (x < enghoursvw.size()) {
            EngHoursVw company = (EngHoursVw) enghoursvw.get(x);
            BigInteger nums = new BigInteger(idx);
            if (company.getReqMessageid().equals(nums)) {
                listmex.add(company);

            }
            x++;
        }
        enghoursvw2 = listmex;
        for (int i = 0; i < enghoursvw2.size(); i++) {
            nesr = (String) enghoursvw2.get(i).getNesr();
            descripcion = (String) enghoursvw2.get(i).getSubject();
            facturar = enghoursvw2.get(i).getFacturar();
            sumahoras = enghoursvw2.get(i).getSumhours();
            idesr = (String) enghoursvw2.get(i).getReqMessageid().toString();
            hint = enghoursvw2.get(i).getHinId() == null ? " " : enghoursvw2.get(i).getHinId().toString();
            correlativo = enghoursvw2.get(i).getCorr().toString();
            wotask = String.valueOf(enghoursvw2.get(i).getCheckid());
            year = enghoursvw2.get(i).getChkYear().toString();
            //Metodo de validacion 
            if (enghoursvw2.get(i).getComboindex() != null) {
                comboindex = (String) enghoursvw2.get(i).getComboindex().toString();
            } else {
                comboindex = "1";
            }
            //con una hora que no haya sido exportada debera aparecer aun 
            if (enghoursvw2.get(i).getExported() != null) {
                if (("Y").equals(enghoursvw2.get(i).getExported())) {
                    export = 1;
                } else {
                    export = 2;
                }
            } else {
                export = 2;
            }
            jobcard=enghoursvw2.get(i).getJobcard();

            chequeado = enghoursvw2.get(i).getSelection() == "S" ? true : false;
            String idtemp = Integer.toString(i);

            Horas horas = new Horas(nesr, descripcion, eacompletado, facturar, sumahoras, idtemp, idesr, comboindex, chequeado, hint, correlativo, wotask, year, jobcard);
            aux.add(horas);
        }//end for
    }//end function

    public void descartar() {
        extendtime();
    }

    public void exporHoras() {
        try {
            extendtime();
            String iduser = loginBean.getUsuario();

            for (int x = 0; x < enghoursvw2.size(); x++) {
                aecasBean.nuevoAecasPK();
                aecasBean.getAecasEsrMhPK().setEsrWoYear(enghoursvw2.get(x).getChkYear().toString());
                aecasBean.getAecasEsrMhPK().setEsrWoOrder(enghoursvw2.get(x).getCorr().toString());
                aecasBean.getAecasEsrMhPK().setEsrWoTask(enghoursvw2.get(x).getItem().toString());
                aecasBean.getAecasEsrMhPK().setEsrEsrId(enghoursvw2.get(x).getNesr());
                aecasBean.getAecasEsrMhPK().setEsrAcreg(enghoursvw2.get(x).getReqTail());
                aecasBean.getAecasEsrMhPK().setEsrCucod(enghoursvw2.get(x).getCustomer());
                BigDecimal ft = enghoursvw2.get(x).getFacturar();
                aecasBean.elemento.setEsrFinal(ft);
                aecasBean.elemento.setEsrUserFinalMod(iduser);
                aecasBean.elemento.setEsrFechaFinalMod(new Date());

                if (!aecasEsrMhFacade.findByIdPK(aecasBean.getAecasEsrMhPK())) {
                    aecasBean.agregar();
                } else {
                    aecasBean.actualizar();
                }
            }
            for (int x = 0; x < aux.size(); x++) {

                llave = new EngHorasIngPK();
                BigInteger bigreq = BigInteger.valueOf(Integer.parseInt(aux.get(x).getIdesr()));
                llave.setHinId(aux.get(x).getHintId() != " " ? new BigInteger(aux.get(x).getHintId()) : engHorasIngFacade.maxIdHin());
                llave.setReqMessageid(bigreq);
                elemento.setEngHorasIngPK(llave);

                if (engHorasIngFacade.find(elemento.getEngHorasIngPK()) != null) {
                    elemento.setEhiId(new BigInteger(aux.get(x).getComboindex()));//Código de EA haciendo referencia al nombre de la acción                       
                    elemento.setHinCodUsrUpd(loginBean.getUsuario());
                    elemento.setHinDateUpd(new Date());
                    elemento.setHinHrsBill(aux.get(x).getEafacturar());
                    elemento.setHinHrsReals(aux.get(x).getHorasing());
                    elemento.setHinSelection(aux.get(x).getChequeado() ? "S" : "N");
                    elemento.setHinWoCorr(new BigInteger(aux.get(x).getCorr()));
                    elemento.setHinWoTask(new BigInteger(aux.get(x).getWo()));
                    elemento.setHinWoYear(new BigInteger(aux.get(x).getYear()));
                    elemento.setHinExported("Y");

                    engHorasIngFacade.edit(elemento);
                } else {

                    elemento.setEhiId(new BigInteger(aux.get(x).getComboindex()));//Código de EA haciendo referencia al nombre de la acción
                    elemento.setHinCodUsrIns(loginBean.getUsuario());
                    elemento.setHinDateIns(new Date());
                    elemento.setHinHrsBill(aux.get(x).getEafacturar());
                    elemento.setHinHrsReals(aux.get(x).getHorasing());
                    elemento.setHinSelection(aux.get(x).getChequeado() ? "S" : "N");
                    elemento.setHinWoCorr(new BigInteger(aux.get(x).getCorr()));
                    elemento.setHinWoTask(new BigInteger(aux.get(x).getWo()));
                    elemento.setHinWoYear(new BigInteger(aux.get(x).getYear()));
                    elemento.setHinCodUsrUpd(iduser);
                    elemento.setHinDateUpd(new Date());
                    elemento.setHinExported("Y");

                    engHorasIngFacade.create(elemento);
                }

            }
            export = 1; //indica que las horas se han exportado
            listarCorreos();
        } catch (Exception e) {
            Logger.getLogger(ReportesSeguiCheqBean.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    public void listarCorreos() {
        try {
            extendtime();
            listParam = prcDetparamFacade.filterByCodeParam();
            EnviarEmail email = new EnviarEmail();
            email.sendEmailHours(listParam, workOrder, cola);
        } catch (Exception e) {
            Logger.getLogger(ReportesSeguiCheqBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void insertIni() {
        extendtime();
        HttpSession sessions = SessionBean.getSession();
        String iduser = sessions.getAttribute("username").toString();
        hoursExp = sec.HrsExport(id);
        for (int x = 0; x < hoursExp.size(); x++) {
            if (("0").equals(hoursExp.get(x).getHIN_ID())) {
                EngHorasIngPK pk = new EngHorasIngPK();
                int idMaxHrsIng = sec.maxHrsIng();
                String idh = String.valueOf(idMaxHrsIng);
                BigInteger idd = new BigInteger(idh);
                pk.setHinId(idd);
                BigInteger messageid = new BigInteger(hoursExp.get(x).getMESSAGEID());
                pk.setReqMessageid(messageid);
                elemento.setEngHorasIngPK(pk);
                BigDecimal hrs = new BigDecimal("0");
                elemento.setHinHrsReals(hrs);
                BigDecimal hrsbills = hoursExp.get(x).getSUMHOURS();
                elemento.setHinHrsBill(hrsbills);
                elemento.setHinSelection(hoursExp.get(x).getSELECCION());
                elemento.setHinCodUsrIns(iduser);
                elemento.setHinDateIns(new Date());
                elemento.setHinCodUsrUpd(iduser);
                elemento.setHinDateUpd(new Date());
                elemento.setHinExported("Y");
                BigInteger items = new BigInteger(hoursExp.get(x).getITEM());
                elemento.setHinWoTask(items);
                BigInteger cor = new BigInteger(hoursExp.get(x).getCORR());
                elemento.setHinWoCorr(cor);
                BigInteger yea = new BigInteger(hoursExp.get(x).getYEAR());
                elemento.setHinWoYear(yea);
                engHorasIngFacade.create(elemento);
            }
        }
    }

    public void llenarExcel() throws IOException, ParseException {
        String company = null;
        extendtime();
        String nameExcel = "Hours_Report";
        ExcellCreator excellCreator = new ExcellCreator();
        HSSFWorkbook excel = new HSSFWorkbook();
        List<EngHrsIns> lt = engEaHrsInsFacade.findAll();
        List<EngTabEsrnwsVw> engTabEsrnwsVwAS =new ArrayList<>();
        if(!aux.isEmpty()){
            engTabEsrnwsVwAS=engTabEsrnwsVwFacade.findByWo(aux.get(0).getWo());
            company=engTabEsrnwsVwAS.get(0).getCompany();
        }
        
        excel = excellCreator.generateByHoras(excel, lt, aux, cola, workOrder,engTabEsrnwsVwAS, company);
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=" + nameExcel + ".xls");
        ServletOutputStream outs = response.getOutputStream();
        excel.write(outs);
        outs.flush();
        outs.close();
        FacesContext.getCurrentInstance().responseComplete();
                 
    }


    @Override
    public void limpiar() {
        extendtime();
        this.elemento = new EngHorasIng();
        edit = false;
    }

    @Override
    public void actualizar() {
        extendtime();
        for (Horas horas : aux) {

            try {
                elemento = new EngHorasIng();
                llave = new EngHorasIngPK();
                BigInteger bigreq = BigInteger.valueOf(Integer.parseInt(horas.getIdesr()));
                llave.setHinId(horas.getHintId() != " " ? new BigInteger(horas.getHintId()) : engHorasIngFacade.maxIdHin());
                llave.setReqMessageid(bigreq);
                elemento.setEngHorasIngPK(llave);

                if (engHorasIngFacade.find(elemento.getEngHorasIngPK()) != null) {
                    elemento.setEhiId(new BigInteger(horas.getComboindex()));//Código de EA haciendo referencia al nombre de la acción
                    elemento.setHinCodUsrUpd(loginBean.getUsuario());
                    elemento.setHinDateUpd(new Date());
                    elemento.setHinHrsBill(horas.getEafacturar());
                    elemento.setHinHrsReals(horas.getHorasing());
                    elemento.setHinSelection(horas.getChequeado() ? "S" : "N");
                    elemento.setHinWoCorr(new BigInteger(horas.getCorr()));
                    elemento.setHinWoTask(new BigInteger(horas.getWo()));
                    elemento.setHinWoYear(new BigInteger(horas.getYear()));
                    engHorasIngFacade.edit(elemento);

                } else {
                    elemento.setEhiId(new BigInteger(horas.getComboindex()));//Código de EA haciendo referencia al nombre de la acción
                    elemento.setHinCodUsrIns(loginBean.getUsuario());
                    elemento.setHinDateIns(new Date());
                    elemento.setHinHrsBill(horas.getEafacturar());
                    elemento.setHinHrsReals(horas.getHorasing());
                    elemento.setHinSelection(horas.getChequeado() ? "S" : "N");
                    elemento.setHinWoCorr(new BigInteger(horas.getCorr()));
                    elemento.setHinWoTask(new BigInteger(horas.getWo()));
                    elemento.setHinWoYear(new BigInteger(horas.getYear()));
                    engHorasIngFacade.create(elemento);
                }
            } catch (Exception e) {
                Logger.getLogger(ReportesSeguiCheqBean.class.getName()).log(Level.SEVERE, null, e);
            }

        }
        llenarHoursByCheck(idChk);
    }

    @Override
    public void agregar() {
        extendtime();
        if (engHorasIngFacade.find(elemento.getEngHorasIngPK()) != null) {
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El identificador unico se encuentra repetido"));
        } else {
            engHorasIngFacade.create(elemento);
            listado.add(elemento);
            elemento = new EngHorasIng();
        }
    }

    @Override
    public void eliminar(EngHorasIng elemento) {
        extendtime();
        if (engHorasIngFacade.find(elemento.getEngHorasIngPK()) != null) {
            engHorasIngFacade.remove(elemento);
            listado.remove(elemento);
        }
    }

    @Override
    public EngHorasIng nuevoElemento() {
        return new EngHorasIng();
    }
//get y set de variable
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
//get y set de variable
    public List<Horas> getAux() {
        return aux;
    }
//get y set de variable
    public void setAux(List<Horas> aux) {
        this.aux = aux;
    }
//get y set de variable
    public String getListadoId() {
        return listadoId;
    }
//get y set de variable
    public void setListadoId(String listadoId) {
        this.listadoId = listadoId;
    }
//get y set de variable
    public AecasBean getAecasBean() {
        return aecasBean;
    }
//get y set de variable
    public void setAecasBean(AecasBean aecasBean) {
        this.aecasBean = aecasBean;
    }
//get y set de variable
    public EngHorasIngPK getLlave() {
        return llave;
    }
//get y set de variable
    public List<HoursExport> getExpor() {
        return expor;
    }
//get y set de variable
    public void setExpor(List<HoursExport> expor) {
        this.expor = expor;
    }
//get y set de variable
    public int getExport() {
        return export;
    }
//get y set de variable
    public void setExport(int export) {
        this.export = export;
    }
//get y set de variable
    public void setLlave(EngHorasIngPK llave) {
        this.llave = llave;
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
    public List<HoursExp> getHoursExp() {
        return hoursExp;
    }
//get y set de variable
    public void setHoursExp(List<HoursExp> hoursExp) {
        this.hoursExp = hoursExp;
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
    public String getIdz() {
        return idz;
    }
//get y set de variable
    public void setIdz(String idz) {
        this.idz = idz;
    }
//get y set de variable
    public List<EngHoursVw> getEnghoursvw() {
        return enghoursvw;
    }
//get y set de variable
    public void setEnghoursvw(List<EngHoursVw> enghoursvw) {
        this.enghoursvw = enghoursvw;
    }
//get y set de variable
    public List<EngHoursVw> getEnghoursvw2() {
        return enghoursvw2;
    }
//get y set de variable
    public void setEnghoursvw2(List<EngHoursVw> enghoursvw2) {
        this.enghoursvw2 = enghoursvw2;
    }
//get y set de variable
    public List<EngRequest> getEsr() {
        return esr;
    }
//get y set de variable
    public void setEsr(List<EngRequest> esr) {
        this.esr = esr;
    }
//get y set de variable
    public EngRequest getEngRequest() {
        return engRequest;
    }
//get y set de variable
    public void setEngRequest(EngRequest engRequest) {
        this.engRequest = engRequest;
    }
//get y set de variable
    public List<Horas> getListHours() {
        return listHours;
    }
//get y set de variable
    public void setListHours(List<Horas> listHours) {
        this.listHours = listHours;
    }
//get y set de variable
    public Sequences getSec() {
        return sec;
    }
//get y set de variable
    public void setSec(Sequences sec) {
        this.sec = sec;
    }
//get y set de variable
    public Short getIdChk() {
        return idChk;
    }
//get y set de variable
    public void setIdChk(Short idChk) {
        this.idChk = idChk;
    }
//get y set de variable
    public String getCola() {
        return cola;
    }
//get y set de variable
    public void setCola(String cola) {
        this.cola = cola;
    }
//get y set de variable
    public String getWorkOrder() {
        return workOrder;
    }
//get y set de variable
    public void setWorkOrder(String workOrder) {
        this.workOrder = workOrder;
    }
//get y set de variable
    public LoginBean getLoginBean() {
        return loginBean;
    }
//get y set de variable
    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }
//get y set de variable
    public AecasEsrMhFacade getAecasEsrMhFacade() {
        return aecasEsrMhFacade;
    }
//get y set de variable
    public void setAecasEsrMhFacade(AecasEsrMhFacade aecasEsrMhFacade) {
        this.aecasEsrMhFacade = aecasEsrMhFacade;
    }
//get y set de variable
    public List<PrcDetparam> getListParam() {
        return listParam;
    }
//get y set de variable
    public void setListParam(List<PrcDetparam> listParam) {
        this.listParam = listParam;
    }

}
