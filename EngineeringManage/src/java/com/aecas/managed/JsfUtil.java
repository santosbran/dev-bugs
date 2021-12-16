/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aecas.managed;

import org.primefaces.PrimeFaces;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.model.SelectItem;
import org.primefaces.PrimeFaces;

/**
 *
 * @author sbran
 */
public class JsfUtil {
    static final String INFO = "Info";
    static final String ERROR = "Error";
    static PrimeFaces current = PrimeFaces.current();
    static final String BUNDLE_INGLES = "LaborManage";
    static final String BUNDLE_ESPANOL = "LaborManage_es";
    private static final String IDIOMA_ESPANOL = "ES";
    static final String IDIOMA_INGLES = "EN";
    static final String DATE_FORMAT_STR = "MM/dd/yyyy";
    static final String DATE_FORMAT_QA = "dd/MM/yyyy";
    static final String TIMESTAMP_FORMAT_STR = "MM/dd/yyyy HH:mm";
    static final String TIMESTAMP_FORMAT_QA = "dd/MM/yyyy HH:mm";
    static final String DATE_HOUR_STR = "HH:mm";
    public static final String GET_TASK_CARD_WS = "GET_TASK_CARD_WS";
    public static final String REPORT_NON_RUTINE_WS = "REPORT_NON_RUTINE_WS";
    public static final String QA_AUDIT = "QA-AUDIT";
    public static final String ME_0470 = "ME-0470";
    public static final String ME_0308 = "ME-0308";
    public static final String FORM_10151_3 = "FORM-10151-3";
    public static final String JB_REJECTION = "JB-REJECTION";
    
    static final String ME_0026_2 = "ME-0026-2"; //Discrepancy
    //static final String WS_REPORT_BI = "http://aesv-vsvroas09.aeroman.local:9502/xmlpserver/services/v2/ReportService?wsdl"; //PROD
    static final String WS_REPORT_BI = "http://172.23.123.39:9502/xmlpserver/services/v2/ReportService?wsdl"; //TEST

    static final String WS_REFERENCES = "http://aedocst.aeroman.com.sv/ppc/td/_vti_bin/lists.asmx?WSDL"; //TEST

    static final String HOST_REFERENCES = "http://aedocst.aeroman.com.sv/"; //TEST

    /**
     * Creates a new instance of JsfUtil
     */
    public JsfUtil() {
        //code here
    }

    public static SelectItem[] getSelectItems(List<?> entities, boolean selectOne) {
        int size = selectOne ? entities.size() + 1 : entities.size();
        SelectItem[] items = new SelectItem[size];
        int i = 0;
        if (selectOne) {
            items[0] = new SelectItem("", "---");
            i++;
        }
        for (Object x : entities) {
            items[i++] = new SelectItem(x, x.toString());
        }
        return items;
    }

    public static boolean isValidationFailed() {
        return FacesContext.getCurrentInstance().isValidationFailed();
    }

    public static void addErrorMessage(Exception ex, String defaultMsg) {
        addErrorMessage(defaultMsg);
    }

    public static void addErrorMessageDialog(Exception ex, String defaultMsg) {
        String msg = ex.getLocalizedMessage();
        if (msg != null && msg.length() > 0) {
            addErrorMessageDialog(msg);
        } else {
            addErrorMessageDialog(defaultMsg);
        }
    }

    public static void addErrorMessages(List<String> messages) {
        for (String message : messages) {
            addErrorMessage(message);
        }
    }

    public static void addErrorMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, ERROR, msg);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

    public static void addDeleteMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, INFO, msg);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

    public static void addErrorMessageDialog(String msg) {
        PrimeFaces.current().dialog().showMessageDynamic(new FacesMessage(FacesMessage.SEVERITY_ERROR, ERROR, msg));
    }

    public static void addSuccessMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, INFO, msg);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

    public static void addSuccessMessageDialog(String msg) {
        PrimeFaces.current().dialog().showMessageDynamic(new FacesMessage(FacesMessage.SEVERITY_INFO, INFO, msg));
    }

    public static String getRequestParameter(String key) {
        return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(key);
    }

    public static Object getObjectFromRequestParameter(String requestParameterName, Converter converter, UIComponent component) {
        String theId = JsfUtil.getRequestParameter(requestParameterName);
        return converter.getAsObject(FacesContext.getCurrentInstance(), component, theId);
    }

    public static String getIdiomaTexto(String idioma, String texto) {

        //Modificar si quieres añadir mas idiomas
        //Cambia el nombre de los ficheros o añade los necesarios
        String txt;
        if (idioma == null) {
            idioma = "";
        }
        switch (idioma.toUpperCase()) {
            case IDIOMA_INGLES:
                txt = getProperties(BUNDLE_INGLES, texto);
                break;
            case IDIOMA_ESPANOL:
                txt = getProperties(BUNDLE_ESPANOL, texto);
                break;
            default:
                txt = getProperties(BUNDLE_ESPANOL, texto);
        }
        return txt;
    }

    public static String getProperties(String bundle, String txt) {
        try {
            return ResourceBundle.getBundle(bundle).getString(txt);
        } catch (Exception ex) {
            return txt;
        }
    }

    public static Date getDateTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static String getSqlDate(Date date) {
        try {
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            return sqlDate.toString();
        } catch (Exception ex) {
            return getDateStr(new Date(), "yyyy-MM-dd");
        }
    }

    public static String getDatePattern() {
        return DATE_FORMAT_STR;
    }

    public static String getDatePatternQa() {
        return DATE_FORMAT_QA;
    }

    public static String getHourPattern() {
        return DATE_HOUR_STR;
    }

    public static String getTimeStampPattern() {
        return TIMESTAMP_FORMAT_STR;
    }

    public static String getTimeStampPatternQa() {
        return TIMESTAMP_FORMAT_QA;
    }

    //******** Time zone *****************//
    public static TimeZone getTimeZone() {
        return TimeZone.getDefault();
    }

    //******** Time zone *****************//
    public static Locale getLocale() {
        return Locale.getDefault();
    }

    public static String getDateStr(Date date) {
        try {
            DateFormat format = new SimpleDateFormat(getDatePattern());
            if (date != null) {
                return format.format(date);
            }
            return format.format(new Date());
        } catch (Exception ex) {
            return "";
        }
    }

    public static String getDateStr(Date date, String formatDate) {
        try {
            DateFormat format = new SimpleDateFormat(formatDate);
            if (date != null) {
                return format.format(date);
            }
            return format.format(new Date());
        } catch (Exception ex) {
            return "";
        }
    }

    public static Date getFormatHour(Date date) {
        if (date != null) {
            DateFormat format = new SimpleDateFormat(getHourPattern());
            try {
                return format.parse(format.format(date));
            } catch (ParseException ex) {
                Logger.getLogger(JsfUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return new Date();
    }

    public static String encodeValue(String value) {
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException ex) {
            return value;
        }
    }

    //************* Alertify ********************//
    public static void alertifyModalError(String texto) {
        current.executeScript("alertify.alert()\n"
                + "  .setting({\n"
                + "    'label':'Agree',\n"
                + "    'message': 'This dialog is : ' + (closable ? ' ' : ' not ') + 'closable.' ,\n"
                + "    'onok': function(){ alertify.success('Great');}\n"
                + "  }).show();");
    }

    public static void alertifyError(String texto) {
        current.executeScript("alertify.error('" + texto + "');");
    }

    public static void alertifySuccess(String texto) {
        current.executeScript("alertify.success('" + texto + "');");
    }

    public static void alertifyNotify(String texto) {
        current.executeScript("alertify.success('" + texto + "');");
    }

    public static void alertifyWarning(String texto) {
        current.executeScript("alertify.log('" + texto + "');");
    }

    public static void executeScript(String texto) {
        current.executeScript(texto);
    }

    public static boolean verificarFechas(Date startDate, Date endDate) {
        if (startDate != null && endDate != null) {
            startDate = getDateTime(startDate);
            endDate = getDateTime(endDate);
            if (startDate.equals(endDate) || startDate.before(endDate)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static boolean verificarHoras(Date startHour, Date endHour) {
        if (startHour != null && endHour != null) {
            startHour = getFormatHour(startHour);
            endHour = getFormatHour(endHour);
            if (startHour.compareTo(endHour) < 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static boolean verificarFechaHoraCurrent(Date startDate, Date endDate, Date startHour, Date endHour) {
        if (startDate != null && endDate != null && startHour != null && endHour != null) {
            startDate = getDateTime(startDate);
            endDate = getDateTime(endDate);
            startHour = getFormatHour(startHour);
            endHour = getFormatHour(endHour);
            if ((startDate.equals(getDateTime(new Date())) || startDate.after(getDateTime(new Date()))) && (endDate.equals(getDateTime(new Date())) || endDate.after(getDateTime(new Date())))) {
                if (startDate.equals(getDateTime(new Date()))) {
                    if (startHour.compareTo(getFormatHour(new Date())) > 0 && endHour.compareTo(getFormatHour(new Date())) > 0) {
                        return true;
                    } else {
                        return false;
                    }
                }//if
                else {
                    return true;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static String completarCorrelativo(String corr) {

        String corrStr = "";
        if (corr == null) {
            corr = "";
        }
        switch (corr.length()) {
            case 0:
                corrStr = "0000000";
                break;
            case 1:
                corrStr = "000000" + corr;
                break;
            case 2:
                corrStr = "00000" + corr;
                break;
            case 3:
                corrStr = "0000" + corr;
                break;
            case 4:
                corrStr = "000" + corr;
                break;
            case 5:
                corrStr = "00" + corr;
                break;
            case 6:
                corrStr = "0" + corr;
                break;
            case 7:
                corrStr = corr;
                break;
            default:
        }

        return corrStr;
    }

    public enum PersistAction {
        CREATE,
        DELETE,
        UPDATE
    }

    /**
     * @return the current
     */
    public PrimeFaces getCurrent() {
        return current;
    }

    /**
     * @return the IDIOMA_ESPANOL
     */
    public static String getIdiomaEspanol() {
        return IDIOMA_ESPANOL;
    }

    /**
     * @return the WS_REPORT_BI
     */
    public static String getWsReportBi() {
        return WS_REPORT_BI;
    }

    /**
     * @return the WS_REFERENCES
     */
    public static String getWsReferences() {
        return WS_REFERENCES;
    }

    /**
     * @return the HOST_REFERENCES
     */
    public static String getHostReferences() {
        return HOST_REFERENCES;
    }

    public static String getUpperTrimStr(String text) {
        return text.toUpperCase().trim();
    }
}
