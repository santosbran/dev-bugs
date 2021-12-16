/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aecas.managed;

import com.aees.session.SessionBean;
import com.aeroman.aees.facades.EngRequestFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import javax.faces.context.FacesContext;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.io.FileInputStream;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import com.aeroman.aees.entities.Usuario;
import com.aeroman.aees.entities.grant.RptEsquemas;
import com.aeroman.aees.facades.grant.RptEsquemasFacade;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.aeroman.reportingserviceae.util.Utils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import javax.faces.context.ExternalContext;
import org.apache.commons.codec.binary.Base64;

@ManagedBean(name = "reportesSeguiCheqBean")
@SessionScoped
public class ReportesSeguiCheqBean implements Serializable {

    private EntityManager em;
    private EntityManagerFactory emf = null;
    private static final long serialVersionUID = 1L;

    @EJB
    EngRequestFacade engrequest;
    
    @EJB
    private RptEsquemasFacade esquemafacade;
    private String urlrep;
    
    @EJB
    private engBIReport wsBIReport;

    private String valor;
    private String id;
    private String anyo;
    private String nesr;
    private String descripcion;
    private String fecha;
    private String revisado;
    private String esrid;
    private String idx;
    private List<Usuario> aux = new ArrayList();
    private List<Esrepor> list = new ArrayList();
    private String eoRevDate = "";
    private String eoSubject = "";
    private String priCod = "";
    private String status = "";
    private String eoEngAssmnt = "";
    private String eoExeDate = "";
    private String eoReptInt = "";
    private String eoLbs = "";
    private String eoLbsIn = "";
    private String eoRevRecord = "";
    private String refCompliance = "";
    private String bulletref = "";
    private String idord = "";
    private String eoWarranty = "";
    private String warrantyNo = "";
    private String eoEffectWb = "";
    private String effectWbNo = "";
    private String eoMaterials = "";
    private String eoSpecialTool = "";
    private String eoNdtEquipment = "";
    private String eoFeedback = "";
    private String eoOther = "";
    private String eoMajorForm = "";
    private String eoMinor = "";
    private String eoStc = "";
    private String eoRas = "";
    private String eoNotRequired = "";
    private String eoSummary = "";
    private String eoComments = "";
    private String val = "X";
    private String eoRev = "";
    private String actCod = "";
    private String creationDate = "";
    private String repor64;
    private String contedis = "Content-Disposition";
    private String utf="application/pdf;charset=utf-8";
    private String spTrackigswoDm64;
    private String spDispositionWo64;

    @PostConstruct
    public void init() {
        emf = Persistence.createEntityManagerFactory("EngineeringManageBCPU");
        setIdx("1");

    }

    public void limpiar() {
        this.id = "";
    }

    public void limpiar2(int ord) {
        if (ord == 1) {
            setIdx("1");
        } else if (ord == 2) {
            setIdx("2");
        } else if (ord == 3) {
            setIdx("3");
        } else if (ord == 4) {
            setIdx("4");
        }
    }

    public void extendtimeSegChek() {
        FacesContext faces = FacesContext.getCurrentInstance();
        if (faces != null) {
            faces.getExternalContext().setSessionMaxInactiveInterval(900);
        }
    }

    public String redireccionar() {
        extendtimeSegChek();
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();

        valor = params.get("nombre");
        String[] separado = valor.split("%"); //separado, vector que contiene los parametros recibidos de MatrizESR; 0=id, 1=workorder, 2=registry, 3=year
        id = separado[0];//contiene unicamente el id
        try {
            FacesContext fce = FacesContext.getCurrentInstance();
            fce.getExternalContext().redirect("/EngineeringManage/pages/reportes/reporteSeguiCheq.xhtml");
        } //redireccion
        catch (Exception e) {
            Logger.getLogger(ReportesSeguiCheqBean.class.getName()).log(Level.SEVERE, null, e);
        }
        return "result2";
    }

    public String matEa(String id) {
        extendtimeSegChek();
        esrid = id;
        try {
            FacesContext fce = FacesContext.getCurrentInstance();
            fce.getExternalContext().redirect("/EngineeringManage/pages/eas/matEa.xhtml");
        } //redireccion
        catch (Exception e) {
            Logger.getLogger(ReportesSeguiCheqBean.class.getName()).log(Level.SEVERE, null, e);
        }
        return "result3";
    }

    public String matEo(String id) {
        esrid = id;
        try {
            FacesContext fce = FacesContext.getCurrentInstance();
            fce.getExternalContext().redirect("/EngineeringManage/pages/eos/matEo.xhtml");
        } //redireccion
        catch (Exception e) {
            Logger.getLogger(ReportesSeguiCheqBean.class.getName()).log(Level.SEVERE, null, e);
        }
        return "result1";
    }

    public void llenadoDeTabla() {

        extendtimeSegChek();
        String year = "";
        String numEsr = "";
        String description = "";
        String fechaData = "";
        String revision = "";
        String estado = "";
        String correlativo = "";
        String idesr = " ";

        List<Object[]> lista = new ArrayList<>();
        aux.clear();
        try {
            em = getEntityManager();
            Query query = em.createNativeQuery("SELECT decode(to_char(nvl(INSTR(REQ_FLAG_TRACKING,'\"+\"-\"+ rol +\"-\"+\"'),'0')),'0','SI','NO') banderin,STS_DESCRIPTION estado,'ESR-'||req.ATA_NUMATA||'-'||req.REQ_CORR ||'/'||SUBSTR(req.REQ_YEAR,3,2) nesr, "
                    + " req.REQ_MESSAGEID req_messageid,\n"
                    + "         req.REQ_MODEL req_model,\n"
                    + "         to_char(req.REQ_ISSUEDATE,'dd/mm/yyyy hh:mi:ss') req_issuedate,\n"
                    + "         req.ATA_NUMATA num_numata,\n"
                    + "         req.REQ_DUEDATE req_duedate,\n"
                    + "         req.REQ_RESPONSEDT req_responsedt,\n"
                    + "         req.REQ_REGISTRY req_registry,\n"
                    + "         req.USR_CODUSER usr_coduser,\n"
                    + "         req.REQ_CORR req_corr,\n"
                    + "         req.REQ_REVNR req_revnr,\n"
                    + "         req.REQ_COMPONENT req_component,\n"
                    + "         req.REQ_PN req_pn, \n"
                    + "         req.REQ_SN req_sn, \n"
                    + "         req.REQ_PRIORITY req_priority,\n"
                    + "         req.REQ_CAUSEDAMAGE req_causedamage, \n"
                    + "         req.REQ_EXTDAMAGE req_extdamage,\n"
                    + "         req.REQ_REQDESDMG req_reqdesdmg, \n"
                    + "         req.REQ_SKETCH req_sketch,\n"
                    + "         req.REQ_NDTREPORT req_ndtreport,\n"
                    + "         req.REQ_NDTRESPONSE req_ndtresponse,\n"
                    + "         req.REQ_REPAIRAREA req_repairarea, \n"
                    + "         req.REQ_REFFOUND req_reffound,\n"
                    + "         req.REQ_DAMFOUND req_damfound, \n"
                    + "         req.REQ_STATAIRCRAFT req_stataircraft,\n"
                    + "         req.REQ_PROBDESC req_probdesc, \n"
                    + "         req.REQ_USERSOL req_usersol, \n"
                    + "         req.REQ_USERAPPR req_userappr, \n"
                    + "         req.REQ_RECIVEDATE req_recivedate,\n"
                    + "         req.REQ_EXT_SOL ewq_ext_sol, \n"
                    + "         req.REQ_ACTION_ING req_action_ing, \n"
                    + "         req.REQ_STATUS req_status,\n"
                    + "         req.CHK_CHECKID chk_checkid,\n"
                    + "         req.REQ_YEAR req_year, \n"
                    + "         req.REQ_OTHERREF req_otherref, \n"
                    + "         req.REQ_CHK_REF req_chk_ref,\n"
                    + "         req.REQ_CHK_OTHEREF req_chk_otheref, \n"
                    + "         req.REQ_ACTIVE req_active, \n"
                    + "         req.REQ_CLAS_REPAIR req_clas_repair,\n"
                    + "         req.REQ_CRITICAL_ESR req_critical_esr, \n"
                    + "         req.REQ_ADJ_CODIGO req_adj_codigo, \n"
                    + "         req.REQ_REQ_ENV req_req_env, \n"
                    + "         (SELECT DISTINCT CONCATENARW(req_messageid) FROM DUAL) numerologpage, \n"
                    + "   TO_CHAR(req.REQ_FECHA_INS, 'dd/mm/yyyy hh24:mi') fechaIngreso,\n"
                    + "   (SELECT p.FULL_USER_NAME FROM procesos.sgr_user p WHERE p.codigo86 = req.REQ_COD_ING_ENC) ingEncargadoDescription \n"
                    + "   FROM ENG.ENG_REQUEST req left outer join ENG.ENG_EO_STATUS ees on (req.REQ_STATUS = ees.STS_EO_COD) \n"
                    + "   where req.CHK_CHECKID = " + id + "  \n"
                    + "   order by req.REQ_MESSAGEID desc");

            lista = query.getResultList();

            for (int i = 0; i < lista.size(); i++) {
                if ((String) lista.get(i)[35] == null) {
                    year = " ";
                } else //luego va el correlativo
                {
                    year = lista.get(i)[35].toString();
                }
                if ((String) lista.get(i)[2] == null) {
                    numEsr = " ";
                } else {
                    numEsr = lista.get(i)[2].toString();
                }
                if ((String) lista.get(i)[27] == null) {
                    description = " ";
                } else {
                    description = lista.get(i)[27].toString();
                }
                if ((String) lista.get(i)[5] == null) {
                    fechaData = " ";
                } else {
                    fechaData = lista.get(i)[5].toString();
                }
                if ((String) lista.get(i)[46] == null) {
                    revision = " ";
                } else {
                    revision = lista.get(i)[46].toString();
                }
                if ((String) lista.get(i)[1] == null) {
                    estado = " ";
                } else {
                    estado = lista.get(i)[1].toString();
                }
                if ((String) lista.get(i)[44] == null) {
                    correlativo = " ";
                } else {
                    correlativo = lista.get(i)[44].toString();
                }

                if (lista.get(i)[3] == null) {
                    idesr = " ";
                } else {
                    idesr = lista.get(i)[3].toString();
                }
                Usuario user2 = new Usuario(year, correlativo, numEsr, description, fechaData, revision, estado, idesr);
                aux.add(user2);
            }// end for
        } catch (Exception e) {
            Logger.getLogger(ReportesSeguiCheqBean.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            em.close();
        }
    }// end function

    public void esrelacionada(String idx) {
        extendtimeSegChek();
        id = idx;
        String anyotk;
        String corretk;
        String descripcionESR;
        String numESR;
        String esrFecha;
        String disposicion;
        String ingrevision;
        List<Object[]> lista;
        list.clear();
        try {
            em = getEntityManager();
            Query query = em.createNativeQuery("SELECT DECODE(TO_CHAR(NVL(INSTR(REQ_FLAG_TRACKING,'-1-'),'0')),'0',0,1) banderin_old,\n"
                    + "  REQ_FLAG_TRACKING banderin,\n"
                    + "  'ESR-'\n"
                    + "  ||req.ATA_NUMATA\n"
                    + "  ||'-'\n"
                    + "  ||req.REQ_CORR\n"
                    + "  ||'/'\n"
                    + "  ||req.REQ_YEAR nesr,\n"
                    + "  EST_DESC estado,\n"
                    + "  req.REQ_MESSAGEID messageid,\n"
                    + "  req.REQ_MODEL model,\n"
                    + "  TO_CHAR(req.REQ_FECHA_INS,'DD/MM/YYYY hh:mi:ss') issuedate,\n"
                    + "  TO_CHAR(req.REQ_DUEDATE,'DD/MM/YYYY hh:mi:ss') duedate,\n"
                    + "  TO_CHAR(req.REQ_RESPONSEDT,'DD/MM/YYYY') responsedate,\n"
                    + "  req.REQ_REGISTRY registry,\n"
                    + "  req.USR_CODUSER coduser,\n"
                    + "  req.REQ_REVNR revnr,\n"
                    + "  req.REQ_COMPONENT component,\n"
                    + "  req.REQ_PN pn,\n"
                    + "  req.REQ_SN sn,\n"
                    + "  req.REQ_PRIORITY priority,\n"
                    + "  req.REQ_CAUSEDAMAGE causedamage,\n"
                    + "  req.REQ_EXTDAMAGE extdamage,\n"
                    + "  req.REQ_REQDESDMG desdamage,\n"
                    + "  req.REQ_SKETCH sketch,\n"
                    + "  req.REQ_NDTREPORT ndtreport,\n"
                    + "  TO_CHAR(req.REQ_NDTRESPONSE,'DD/MM/YYYY hh:mi:ss') ndtresponse,\n"
                    + "  req.REQ_REPAIRAREA repairarea,\n"
                    + "  req.REQ_REFFOUND reffound,\n"
                    + "  req.REQ_DAMFOUND damfound,\n"
                    + "  req.REQ_STATAIRCRAFT stataircraft,\n"
                    + "  req.REQ_PROBDESC probdesc,\n"
                    + "  req.REQ_USERSOL usersolicita,\n"
                    + "  req.REQ_USERAPPR userapproved,\n"
                    + "  TO_CHAR(req.REQ_RECIVEDATE,'DD/MM/YYYY') recivedate,\n"
                    + "  req.REQ_EXT_SOL ext_solicita,\n"
                    + "  req.REQ_ACTION_ING action_ing,\n"
                    + "  req.REQ_STATUS status,\n"
                    + "  req.CHK_CHECKID checkid,\n"
                    + "  req.REQ_OTHERREF otherref,\n"
                    + "  req.REQ_CHK_REF chk_references,\n"
                    + "  req.REQ_CHK_OTHEREF chk_otheref,\n"
                    + "  req.REQ_ACTIVE activo,\n"
                    + "  req.REQ_CLAS_REPAIR clas_repair,\n"
                    + "  req.REQ_CRITICAL_ESR critical_esr,\n"
                    + "  req.REQ_ADJ_CODIGO adj_codigo,\n"
                    + "  req.REQ_REQ_ENV req_env,\n"
                    + "  req.LOGPAGE logpage,\n"
                    + "  req.YEARLOGPAGE yearlogpage,\n"
                    + "  req.NUMEROLOGPAGE numerologpage,\n"
                    + "  req.LOGPAGE milestoneId,\n"
                    + "  req.YEARLOGPAGE milestoneName,\n"
                    + "  ( DECODE(req.REQ_COD_ING_ENC, NULL, 1, 0) ) existeArchivo,\n"
                    + "  TO_CHAR(req.REQ_FECHA_INS, 'dd/mm/yyyy hh24:mi') fechaIngreso,\n"
                    + "  (SELECT p.FULL_USER_NAME\n"
                    + "  FROM procesos.sgr_user p\n"
                    + "  WHERE p.codigo86 = req.USR_CODUSER\n"
                    + "  )ingEncargadoDescription,\n"
                    + "  NVL(\n"
                    + "  (SELECT EIN_DESCRIPTION\n"
                    + "  FROM ENG.ENG_REQ_INGACTION\n"
                    + "  WHERE REQ_MESSAGEID     = req.REQ_MESSAGEID\n"
                    + "  AND ROWNUM              =1\n"
                    + "  AND NVL(EIN_REGSORT,1) IN NVL(\n"
                    + "    (SELECT MAX(ING.EIN_REGSORT)\n"
                    + "    FROM ENG.ENG_REQ_INGACTION ING\n"
                    + "    WHERE ING.REQ_MESSAGEID = req.REQ_MESSAGEID),1) ),'') description\n"
                    + "FROM ENG_REQUEST req\n"
                    + "LEFT OUTER JOIN ENG_REQ_STATUS ees\n"
                    + "ON (req.REQ_STATUS    = ees.EST_CODE)"
                    + " where req.CHK_CHECKID = " + id + " "
                    + " order by req.REQ_MESSAGEID desc");

            lista = query.getResultList();
            for (int i = 0; i < lista.size(); i++) {
                if ((String) lista.get(i)[43] == null) {
                    anyotk = "---";
                } else {
                    anyotk = lista.get(i)[43].toString();
                }
                if ((String) lista.get(i)[44] == null) {
                    corretk = "---";
                } else {
                    corretk =  lista.get(i)[44].toString();
                }
                if ((String) lista.get(i)[26] == null) {
                    descripcionESR = "---";
                } else {
                    descripcionESR = lista.get(i)[26].toString();
                }
                if ((String) lista.get(i)[2] == null) {
                    numESR = "---";
                } else {
                    numESR = lista.get(i)[2].toString();
                }
                if ((String) lista.get(i)[8] == null) {
                    esrFecha = "---";
                } else {
                    esrFecha = lista.get(i)[8].toString();
                }
                if ((String) lista.get(i)[50] == null) {
                    disposicion = "---";
                } else {
                    disposicion = lista.get(i)[50].toString();
                }
                if ((String) lista.get(i)[49] == null) {
                    ingrevision = "---";
                } else {
                    ingrevision =  lista.get(i)[49].toString();
                }

                Esrepor reporte = new Esrepor(anyotk, corretk, numESR, descripcionESR, esrFecha, disposicion, ingrevision);
                list.add(reporte);
                setIdx("2");
            }// end for

        } //redireccion
        catch (Exception e) {
            Logger.getLogger(ReportesSeguiCheqBean.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    public void excelReportEsrelacionado() {
        extendtimeSegChek();
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        /**
         * *************************************
         *
         *
         * GENERACION DEL REPORTE EN EXCEL *
         *
         **************************************
         */
        try {

            SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
            Calendar fechaac = new GregorianCalendar();
            String actual = formatoDeFecha.format(fechaac.getTime());
            ServletContext sc = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String path0 = sc.getRealPath("/pages/Plantillas/ReporteEsrRelacionados.xlt");
            String ruta = path0.replace("\\", "/");
            if (ruta == null) {
                // resources en un .war (JBoss, WebLogic)
                java.net.URL url;
                    //archivo de ejemplo
                    url = sc.getResource("/pages/Plantillas/ReporteEsrRelacionados.xlt");
                    ruta = url.getPath();
            }
            HttpSession sessions = SessionBean.getSession();
            String iduser = sessions.getAttribute("username").toString();
            FileInputStream inputStream = new FileInputStream(ruta);//cargarmos una platilla
            POIFSFileSystem fs = new POIFSFileSystem(inputStream);
            HSSFWorkbook reporte = new HSSFWorkbook(fs, true);
            HSSFCellStyle style = reporte.createCellStyle();

            HSSFSheet sheet = reporte.getSheet("Sheet1");
            HSSFRow row;
            HSSFCell cell;
            int rowIndex = 7;

            row = sheet.getRow(3);
            cell = row.createCell((short) 8);
            cell.setCellValue(iduser);

            row = sheet.getRow(4);
            cell = row.createCell((short) 8);
            cell.setCellValue(actual);

            for (int i = 0; i < list.size(); i++) {
                row = sheet.createRow(rowIndex++);

                cell = row.createCell((short) 0);
                cell.setCellValue((String) list.get(i).getAnyotk());
                style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                cell.setCellStyle(style);

                cell = row.createCell((short) 1);
                cell.setCellValue((String) list.get(i).getCorretk());
                style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                cell.setCellStyle(style);

                cell = row.createCell((short) 2);
                cell.setCellValue((String) list.get(i).getNumESR());
                style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                cell.setCellStyle(style);

                cell = row.createCell((short) 3);
                cell.setCellValue((String) list.get(i).getDescripcionESR());
                style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                cell.setCellStyle(style);

                cell = row.createCell((short) 4);
                cell.setCellValue((String) list.get(i).getFecha());
                style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                cell.setCellStyle(style);

                cell = row.createCell((short) 5);
                cell.setCellValue((String) list.get(i).getDisposicion());
                style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                cell.setCellStyle(style);

                cell = row.createCell((short) 6);
                cell.setCellValue((String) list.get(i).getIngrevision());
                style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                cell.setCellStyle(style);
            }
            response.setContentType("application/xls");
            response.setHeader(contedis, "attachment; filename=ReporteEsrRelacionados.xls");
            try (ServletOutputStream outs = response.getOutputStream()) {
                reporte.write(outs);
                outs.flush();
            }
            FacesContext.getCurrentInstance().responseComplete();
        } catch (Exception e) {
            Logger.getLogger(ReportesSeguiCheqBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void llenarESR(String idx) {
        extendtimeSegChek();
        try {
            HttpServletResponse response =(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse(); 
            
            response.setContentType(utf);
            response.setHeader(contedis, "inline; filename=REP_HCHECK_ESR.pdf");  
            RptEsquemas report = esquemafacade.findbyname("AEIS");
            String xmls=idx;
            String wsdl=report.getRuta();
            String absolutePath=report.getRutaJasper()+"/AEIS/REP_HCHECK_ESR/REP_HCHECK_ESR.xdo";
            String user=report.getUsuario();
            String pass=report.getClave();
           
            repor64=String.valueOf(Utils.downloadPDF2(xmls,wsdl,absolutePath,user,pass));
            
        } catch (Exception e) {
            Logger.getLogger(ReportesSeguiCheqBean.class.getName()).log(Level.SEVERE, null, e);
        }

    }
   
    public void llenarESRExcel(String idx, String idcheq) {
        extendtimeSegChek();
        try {
            HttpServletResponse response =(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse(); 
            
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment; filename= test.xlsx");  
            RptEsquemas report = esquemafacade.findbyname("AEIS");
            String absolutePath=report.getRutaJasper()+"/AEIS/REP_HCHECK_ESR/REP_HCHECK_ESR.xdo";
            
            byte [] reportResponse = wsBIReport.runReportExcelBI(idcheq,"", absolutePath);
            ByteArrayOutputStream baos = new ByteArrayOutputStream(reportResponse.length);
            baos.write(reportResponse, 0, reportResponse.length);
            ServletOutputStream outs = response.getOutputStream();
            baos.writeTo(outs);
            outs.flush();
            outs.close();
            FacesContext.getCurrentInstance().responseComplete();
            
        } catch (Exception e) {
            Logger.getLogger(ReportesSeguiCheqBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void llenarHistoricoExcel(String idc, String idcheck) {
        extendtimeSegChek();
        try {
            HttpServletResponse response =(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse(); 
            
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment; filename= HistoricalReport.xlsx");  
            RptEsquemas report = esquemafacade.findbyname("AEIS");
            String absolutePath=report.getRutaJasper()+"/AEIS/REP_HCHECK_ESR_DETAIL/REP_HCHECK_ESR_DETAIL.xdo";
            
            byte [] reportResponse = wsBIReport.runReportExcelBI(idcheck,"", absolutePath);
            ByteArrayOutputStream baos = new ByteArrayOutputStream(reportResponse.length);
            baos.write(reportResponse, 0, reportResponse.length);
            ServletOutputStream outs = response.getOutputStream();
            baos.writeTo(outs);
            outs.flush();
            outs.close();
            FacesContext.getCurrentInstance().responseComplete();
            
        } catch (Exception e) {
            Logger.getLogger(ReportesSeguiCheqBean.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    
       
    public void spDispositionWo(String idx){
        extendtimeSegChek();
        try {
            
            RptEsquemas report = esquemafacade.findbyname("AEIS");            
            String wsdl=report.getRuta();
            String xmls=idx;
            String user=report.getUsuario();
            String absolutePath=report.getRutaJasper()+"/AEIS/SP_DISPOSITION_WO/SP_DISPOSITION_WO.xdo";
            String pass=report.getClave();
             
             ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            externalContext.responseReset(); 
            externalContext.setResponseContentType("application/vnd.ms-excel");
            externalContext.setResponseHeader(contedis, "attachment; filename=SP_DISPOSITION_WO.xls"); 
            OutputStream out = externalContext.getResponseOutputStream();
            spDispositionWo64=String.valueOf(Utils.downloadPDF2(xmls,wsdl,absolutePath,user,pass));
            out.write(Base64.decodeBase64(spDispositionWo64));
            out.close();
            FacesContext faces = FacesContext.getCurrentInstance();
            faces.responseComplete();
            
            
        } catch (Exception e) {
            Logger.getLogger(ReportesSeguiCheqBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public void spTrackigswoDm(String idx2){        
        try {
            extendtimeSegChek();
            RptEsquemas report2 = esquemafacade.findbyname("AEIS");            
            String wsdl2=report2.getRuta();
            String xmls2=idx2;
            String user2=report2.getUsuario();
            String absolutePath2=report2.getRutaJasper()+"/AEIS/SP_TRACKIGSWO/SP_TRACKIGSWO_DM.xdo";
            String pass2=report2.getClave();
             
             ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            externalContext.responseReset(); 
            externalContext.setResponseContentType("application/vnd.ms-excel");
            externalContext.setResponseHeader(contedis, "attachment; filename=SP_TRACKIGSWO_DM.xls"); 
            OutputStream out = externalContext.getResponseOutputStream();
            spTrackigswoDm64=String.valueOf(Utils.downloadPDF2(xmls2,wsdl2,absolutePath2,user2,pass2));
            out.write(Base64.decodeBase64(spTrackigswoDm64));
            out.close();
            FacesContext faces = FacesContext.getCurrentInstance();
            faces.responseComplete(); 
            
            
        } catch (Exception e) {
            Logger.getLogger(ReportesSeguiCheqBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void llenarCI(String idv) {
        extendtimeSegChek();
        try {
             HttpServletResponse response =(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse(); 
            
            response.setContentType(utf);
            response.setHeader(contedis, "inline; filename=rep_control_internoESR.pdf");  
            RptEsquemas report = esquemafacade.findbyname("AEIS");
            
            String xmls=idv;
            String wsdl=report.getRuta();
            String absolutePath=report.getRutaJasper()+"/AEIS/rep_control_internoERS/rep_control_internoESR.xdo";
            String user=report.getUsuario();
            String pass=report.getClave();
           
            repor64=String.valueOf(Utils.downloadPDF2(xmls,wsdl,absolutePath,user,pass));
            
        } catch (Exception e) {
            Logger.getLogger(ReportesSeguiCheqBean.class.getName()).log(Level.SEVERE, null, e);
        }
        //Termina el metodo de llenarCI

    }

    public void llenarHistorico(String idc) {
        extendtimeSegChek();
        try {
            HttpServletResponse response =(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse(); 
            
            response.setContentType(utf);
            response.setHeader(contedis, "inline; filename=REP_HCHECK_ESR_DETAIL.pdf");  
           
            RptEsquemas report = esquemafacade.findbyname("AEIS");
            
            String xmls=idc;
            String wsdl=report.getRuta();
            String absolutePath=report.getRutaJasper()+"/AEIS/REP_HCHECK_ESR_DETAIL/REP_HCHECK_ESR_DETAIL.xdo";
            String user=report.getUsuario();
            String pass=report.getClave();
           
            repor64=String.valueOf(Utils.downloadPDF2(xmls,wsdl,absolutePath,user,pass));
            
        } catch (Exception e) {
            Logger.getLogger(ReportesSeguiCheqBean.class.getName()).log(Level.SEVERE, null, e);
        }

        //Termina el metodo de llenarCI
    }

    public void reportESR(String idc3, String company) {
        extendtimeSegChek();
        try {
             HttpServletResponse response3 =(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse(); 
            
            response3.setContentType(utf);
            response3.setHeader(contedis, "inline; filename=REP_ESR.pdf");  
            RptEsquemas report3 = esquemafacade.findbyname("AEIS");
    
            if (company.equals("FAS")){
            String xmls3=idc3;
            String wsdl3=report3.getRuta();
            String absolutePath3=report3.getRutaJasper()+"/AEIS/REP_HCHECK_ESR_FAS/REP_HCHECK_ESR_FAS.xdo";
            String user3=report3.getUsuario();
            String pass3=report3.getClave();
            repor64=String.valueOf(Utils.downloadPDF2(xmls3,wsdl3,absolutePath3,user3,pass3));
            }else{
            String xmls3=idc3;
            String wsdl3=report3.getRuta();
            String absolutePath3=report3.getRutaJasper()+"/AEIS/REP_ESR/REP_ESR.xdo";
            String user3=report3.getUsuario();
            String pass3=report3.getClave();
            repor64=String.valueOf(Utils.downloadPDF2(xmls3,wsdl3,absolutePath3,user3,pass3));
            }
            
        } catch (Exception e) {
            Logger.getLogger(ReportesSeguiCheqBean.class.getName()).log(Level.SEVERE, null, e);
        }
    
    }
    
    //copia del metodo anterior con diferentes parametros
    public void reportESR(String idc3) {
        extendtimeSegChek();
        try {
             HttpServletResponse response3 =(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse(); 
            
            response3.setContentType(utf);
            response3.setHeader(contedis, "inline; filename=REP_ESR.pdf");  
            RptEsquemas report3 = esquemafacade.findbyname("AEIS");
            
            String xmls3=idc3;
            String wsdl3=report3.getRuta();
            String absolutePath3=report3.getRutaJasper()+"/AEIS/REP_ESR/REP_ESR.xdo";
            String user3=report3.getUsuario();
            String pass3=report3.getClave();
            repor64=String.valueOf(Utils.downloadPDF2(xmls3,wsdl3,absolutePath3,user3,pass3));
            
        } catch (Exception e) {
            Logger.getLogger(ReportesSeguiCheqBean.class.getName()).log(Level.SEVERE, null, e);
        }
    
    }
    
    public void reportETR(String idc3) {
        extendtimeSegChek();
        try {
             HttpServletResponse response3 =(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse(); 
            
            response3.setContentType(utf);
            response3.setHeader(contedis, "inline; filename=REP_ESR.pdf");  
            RptEsquemas report3 = esquemafacade.findbyname("AEIS");
            
            String xmls3=idc3;
            String wsdl3=report3.getRuta();
            String absolutePath3=report3.getRutaJasper()+"/AEIS/REP_ETR/REP_ETR.xdo";
            String user3=report3.getUsuario();
            String pass3=report3.getClave();
            repor64=String.valueOf(Utils.downloadPDF2(xmls3,wsdl3,absolutePath3,user3,pass3));
            
        } catch (Exception e) {
            Logger.getLogger(ReportesSeguiCheqBean.class.getName()).log(Level.SEVERE, null, e);
        }
    
    }
    //Reporte ECR, desarrollado por BI: /xmlpserver/DESA/MROH/AEIS/REP_ECR/REP_ECR.xdo
    public void reportECR(String idR) {
        extendtimeSegChek();
        try {
            HttpServletResponse responseCr =(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse(); 
            responseCr.setContentType(utf);
            responseCr.setHeader(contedis, "inline; filename=REP_ECR.pdf");  
            RptEsquemas reportBi = esquemafacade.findbyname("AEIS");
            String xmlsCr=idR;
            String wsdlCr=reportBi.getRuta();
            String absolutePath=reportBi.getRutaJasper()+"/AEIS/REP_ETR/REP_ECR.xdo";
            String user=reportBi.getUsuario();
            String pass=reportBi.getClave();
            repor64=String.valueOf(Utils.downloadPDF2(xmlsCr,wsdlCr,absolutePath,user,pass));
        } catch (Exception e) {
            Logger.getLogger(ReportesSeguiCheqBean.class.getName()).log(Level.SEVERE, null, e);
        }
    
    }
    
    
    public void downloadReportESR(){
        try {
            HttpServletResponse response =(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse(); 
            response.setContentType(utf);
            response.setHeader(contedis, "attachment; filename=REP_ESR.pdf");  
            try (InputStream in = new ByteArrayInputStream(Base64.decodeBase64(repor64)); 
                    ServletOutputStream outs = response.getOutputStream()) {
                int bit = 512;
                while ((bit) >= 0) {
                    bit = in.read();
                    outs.write(bit);
                }
                outs.flush();
            }
               FacesContext.getCurrentInstance().getResponseComplete();
        } catch (Exception e) {
            Logger.getLogger(ReportesSeguiCheqBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void llenarEngOrder() {
        try {

            extendtimeSegChek();
            List<Object[]> listadoQr8 = new ArrayList();

            for (int i = 0; i < listadoQr8.size(); i++) {
                eoRev = listadoQr8.get(i)[1].toString();
                eoRevDate = listadoQr8.get(i)[7].toString();
                eoSubject = listadoQr8.get(i)[10].toString();
                priCod = listadoQr8.get(i)[41].toString();
                status = listadoQr8.get(i)[9].toString();
                eoEngAssmnt = listadoQr8.get(i)[13].toString();
                eoSummary = listadoQr8.get(i)[11].toString();
                eoExeDate = listadoQr8.get(i)[16].toString();
                eoReptInt = listadoQr8.get(i)[3].toString();
                eoLbs = listadoQr8.get(i)[21].toString();
                eoLbsIn = listadoQr8.get(i)[22].toString();
                eoRevRecord = listadoQr8.get(i)[4].toString();
                eoWarranty = listadoQr8.get(i)[14].toString();
                warrantyNo = listadoQr8.get(i)[15].toString();
                eoEffectWb = listadoQr8.get(i)[19].toString();
                effectWbNo = listadoQr8.get(i)[20].toString();
                eoMaterials = listadoQr8.get(i)[25].toString();
                eoSpecialTool = listadoQr8.get(i)[32].toString();
                eoNdtEquipment = listadoQr8.get(i)[33].toString();
                eoFeedback = listadoQr8.get(i)[34].toString();
                eoOther = listadoQr8.get(i)[36].toString();
                eoMajorForm = listadoQr8.get(i)[23].toString();
                eoMinor = listadoQr8.get(i)[24].toString();
                eoStc = listadoQr8.get(i)[8].toString();
                eoRas = listadoQr8.get(i)[6].toString();
                eoNotRequired = listadoQr8.get(i)[26].toString();
                eoComments = listadoQr8.get(i)[31].toString();
                actCod = listadoQr8.get(i)[29].toString();
                creationDate = listadoQr8.get(i)[39].toString();
            }

        } catch (Exception e) {
            Logger.getLogger(ReportesSeguiCheqBean.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public String getAnyo() {
        return anyo;
    }

    public void setAnyo(String anyo) {
        this.anyo = anyo;
    }

    public String getNesr() {
        return nesr;
    }

    public void setNesr(String nesr) {
        this.nesr = nesr;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getRevisado() {
        return revisado;
    }

    public void setRevisado(String revisado) {
        this.revisado = revisado;
    }

    public List<Usuario> getAux() {
        return aux;
    }

    public void setAux(List<Usuario> aux) {
        this.aux = aux;
    }

    public List<Esrepor> getList() {
        return list;
    }

    public void setList(List<Esrepor> list) {
        this.list = list;
    }

    public String getIdx() {
        return idx;
    }

    public void setIdx(String idx) {
        this.idx = idx;
    }

    public String getUrlrep() {
        return urlrep;
    }

    public void setUrlrep(String urlrep) {
        this.urlrep = urlrep;
    }

    public String getEoRevDate() {
        return eoRevDate;
    }

    public void setEoRevDate(String eoRevDate) {
        this.eoRevDate = eoRevDate;
    }

    public String getEoSubject() {
        return eoSubject;
    }

    public void setEoSubject(String eoSubject) {
        this.eoSubject = eoSubject;
    }

    public String getPriCod() {
        return priCod;
    }

    public void setPriCod(String priCod) {
        this.priCod = priCod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEoEngAssmnt() {
        return eoEngAssmnt;
    }

    public void setEoEngAssmnt(String eoEngAssmnt) {
        this.eoEngAssmnt = eoEngAssmnt;
    }

    public String getEoExeDate() {
        return eoExeDate;
    }

    public void setEoExeDate(String eoExeDate) {
        this.eoExeDate = eoExeDate;
    }

    public String getEoReptInt() {
        return eoReptInt;
    }

    public void setEoReptInt(String eoReptInt) {
        this.eoReptInt = eoReptInt;
    }

    public String getEoLbs() {
        return eoLbs;
    }

    public void setEoLbs(String eoLbs) {
        this.eoLbs = eoLbs;
    }

    public String getEoLbsIn() {
        return eoLbsIn;
    }

    public void setEoLbsIn(String eoLbsIn) {
        this.eoLbsIn = eoLbsIn;
    }

    public String getEoRevRecord() {
        return eoRevRecord;
    }

    public void setEoRevRecord(String eoRevRecord) {
        this.eoRevRecord = eoRevRecord;
    }

    public String getRefCompliance() {
        return refCompliance;
    }

    public void setRefCompliance(String refCompliance) {
        this.refCompliance = refCompliance;
    }

    public String getBulletref() {
        return bulletref;
    }

    public void setBulletref(String bulletref) {
        this.bulletref = bulletref;
    }

    public String getIdord() {
        return idord;
    }

    public void setIdord(String idord) {
        this.idord = idord;
    }

    public String getEoWarranty() {
        return eoWarranty;
    }

    public void setEoWarranty(String eoWarranty) {
        this.eoWarranty = eoWarranty;
    }

    public String getWarrantyNo() {
        return warrantyNo;
    }

    public void setWarrantyNo(String warrantyNo) {
        this.warrantyNo = warrantyNo;
    }

    public String getEoEffectWb() {
        return eoEffectWb;
    }

    public void setEoEffectWb(String eoEffectWb) {
        this.eoEffectWb = eoEffectWb;
    }

    public String getEffectWbNo() {
        return effectWbNo;
    }

    public void setEffectWbNo(String effectWbNo) {
        this.effectWbNo = effectWbNo;
    }

    public String getEoMaterials() {
        return eoMaterials;
    }

    public void setEoMaterials(String eoMaterials) {
        this.eoMaterials = eoMaterials;
    }

    public String getEoSpecialTool() {
        return eoSpecialTool;
    }

    public void setEoSpecialTool(String eoSpecialTool) {
        this.eoSpecialTool = eoSpecialTool;
    }

    public String getEoNdtEquipment() {
        return eoNdtEquipment;
    }

    public void setEoNdtEquipment(String eoNdtEquipment) {
        this.eoNdtEquipment = eoNdtEquipment;
    }

    public String getEoFeedback() {
        return eoFeedback;
    }

    public void setEoFeedback(String eoFeedback) {
        this.eoFeedback = eoFeedback;
    }

    public String getEoOther() {
        return eoOther;
    }

    public void setEoOther(String eoOther) {
        this.eoOther = eoOther;
    }

    public String getEoMajorForm() {
        return eoMajorForm;
    }

    public void setEoMajorForm(String eoMajorForm) {
        this.eoMajorForm = eoMajorForm;
    }

    public String getEoMinor() {
        return eoMinor;
    }

    public void setEoMinor(String eoMinor) {
        this.eoMinor = eoMinor;
    }

    public String getEoStc() {
        return eoStc;
    }

    public void setEoStc(String eoStc) {
        this.eoStc = eoStc;
    }

    public String getEoRas() {
        return eoRas;
    }

    public void setEoRas(String eoRas) {
        this.eoRas = eoRas;
    }

    public String getEoNotRequired() {
        return eoNotRequired;
    }

    public void setEoNotRequired(String eoNotRequired) {
        this.eoNotRequired = eoNotRequired;
    }

    public String getEoSummary() {
        return eoSummary;
    }

    public void setEoSummary(String eoSummary) {
        this.eoSummary = eoSummary;
    }

    public String getEoComments() {
        return eoComments;
    }

    public void setEoComments(String eoComments) {
        this.eoComments = eoComments;
    }

    public String getEoRev() {
        return eoRev;
    }

    public void setEoRev(String eoRev) {
        this.eoRev = eoRev;
    }

    public String getActCod() {
        return actCod;
    }

    public void setActCod(String actCod) {
        this.actCod = actCod;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public String getEsrid() {
        return esrid;
    }

    public void setEsrid(String esrid) {
        this.esrid = esrid;
    }

    public String getRepor64() {
        return repor64;
    }

    public void setRepor64(String repor64) {
        this.repor64 = repor64;
    }

    public String getContedis() {
        return contedis;
    }

    public void setContedis(String contedis) {
        this.contedis = contedis;
    }

    public String getUtf() {
        return utf;
    }

    public void setUtf(String utf) {
        this.utf = utf;
    }

    public String getSpTrackigswoDm64() {
        return spTrackigswoDm64;
    }

    public void setSpTrackigswoDm64(String spTrackigswoDm64) {
        this.spTrackigswoDm64 = spTrackigswoDm64;
    }

    public String getSpDispositionWo64() {
        return spDispositionWo64;
    }

    public void setSpDispositionWo64(String spDispositionWo64) {
        this.spDispositionWo64 = spDispositionWo64;
    }
}
