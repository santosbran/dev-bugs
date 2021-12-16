/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aecas.managed;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.ws.WebServiceRef;
import com.oracle.xmlns.oxp.service.v2.ArrayOfParamNameValue;
import com.oracle.xmlns.oxp.service.v2.ArrayOfString;
import com.oracle.xmlns.oxp.service.v2.ParamNameValue;
import com.oracle.xmlns.oxp.service.v2.ParamNameValues;
import com.oracle.xmlns.oxp.service.v2.ReportResponse;
import com.oracle.xmlns.oxp.service.v2.ReportService_Service;
import com.oracle.xmlns.oxp.service.v2.ReportRequest;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;
import static org.apache.poi.util.IOUtils.toByteArray;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author sbran
 */
@Singleton
public class engBIReport implements Serializable {
    @Inject
    private engParametrosController parameters;
    @WebServiceRef(wsdlLocation = "http://aesv-vsvrapp23:9502/xmlpserver/services/v2/ReportService?wsdl")  
    private ReportService_Service service;
    static final String USER_WS = "reportsWS";
    static final String PASS_REPORT_WS = "reports#ws";
    static final float SIZE_FONT = 24;
    private HttpSession session;
    private ReportResponse pdfResponse;
    private StreamedContent pdfRender;
    private boolean printable;
    private boolean fileNotFound; //fallo=true
    private String base64PdfWs;

    public engBIReport() {
        //Code here
    }

    @PostConstruct
    public void init() {
        FacesContext fCtx = FacesContext.getCurrentInstance();
        session = (HttpSession) fCtx.getExternalContext().getSession(false);
    }

    //*******WEB SERVICE REPORT BI************//
    public StreamedContent runReport(String yearTk, String correlativeTk,String nReport) {

        try {
            setFileNotFound(false);
            com.oracle.xmlns.oxp.service.v2.ReportRequest reportRequest = parametrosReporte(yearTk, correlativeTk,nReport);
            com.oracle.xmlns.oxp.service.v2.ReportService port = service.getReportService();
            pdfResponse = port.runReport(reportRequest, USER_WS, PASS_REPORT_WS);
            if (pdfResponse == null) {
                pdfRender = fileNotFound();
                setFileNotFound(true);
            } else {
                pdfRender = new DefaultStreamedContent(new ByteArrayInputStream(pdfResponse.getReportBytes()), pdfResponse.getReportContentType());
                byte[] byteStreamed = toByteArray(new ByteArrayInputStream(pdfResponse.getReportBytes()));
                base64PdfWs = DatatypeConverter.printBase64Binary(byteStreamed);
            }
            return pdfRender;
        } catch (Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
            pdfRender = fileNotFound();
            setFileNotFound(true);
            return pdfRender;
        }
    }

    public StreamedContent fileNotFound() {
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            Font fuente = new Font();
            fuente.setSize(SIZE_FONT);
            Document document = new Document();
            PdfWriter.getInstance(document, out);
            document.open();
            for (int i = 0; i < 1; i++) {
                document.add(new Paragraph(JsfUtil.getIdiomaTexto(parameters.getLanguage(), "FileNotFound"), fuente));
            }
            document.close();
            return new DefaultStreamedContent(new ByteArrayInputStream(out.toByteArray()), "application/pdf");
        } catch (Exception ex) {
            Logger.getLogger(engBIReport.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    //********** ENVIO PARAMETROS A REPORTE **************************//
    public ReportRequest parametrosReporte(String yearTk, String corrTk,String nReport) {

        ParamNameValues paramReport = new ParamNameValues();
        ReportRequest reportParam = new ReportRequest();
        ArrayOfParamNameValue arrayParam = new ArrayOfParamNameValue();

        String parametro1 = "ID"; //correlativo
        String parametro2 = "year"; //year
        ParamNameValue yearParam = new ParamNameValue();
        ParamNameValue tkYearParam = new ParamNameValue();

        ArrayOfString corrVal = new ArrayOfString();
        ArrayOfString tkYearVal = new ArrayOfString();
        try {

            reportParam.setReportAbsolutePath(nReport);// Agregar los nombres de .xdo .
            corrVal.getItem().add(corrTk); // id
            yearParam.setName(parametro1); //year
            yearParam.setValues(corrVal);
            arrayParam.getItem().add(yearParam);

            tkYearVal.getItem().add(yearTk);
            tkYearParam.setName(parametro2); // tkYear
            tkYearParam.setValues(tkYearVal);
            arrayParam.getItem().add(tkYearParam);

            paramReport.setListOfParamNameValues(arrayParam);
            reportParam.setParameterNameValues(paramReport);
            reportParam.setSizeOfDataChunkDownload(-1);// Parametro necesario

        } catch (Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return reportParam;
    }
    
    //13 08 2021:
    public StreamedContent runReportExcel(String chequeo, String vstatus, String nReport) {
        try 
        {
            setFileNotFound(false);
            com.oracle.xmlns.oxp.service.v2.ReportRequest reportRequest = parametrosReporteExcel(chequeo, vstatus, nReport);
            com.oracle.xmlns.oxp.service.v2.ReportService port = service.getReportService();
            pdfResponse = port.runReport(reportRequest, USER_WS, PASS_REPORT_WS);
            if (pdfResponse == null) {
                pdfRender = fileNotFound();
                setFileNotFound(true);
            } else {
                pdfRender = new DefaultStreamedContent(new ByteArrayInputStream(pdfResponse.getReportBytes()), pdfResponse.getReportContentType());
                byte[] byteStreamed = toByteArray(new ByteArrayInputStream(pdfResponse.getReportBytes()));
                base64PdfWs = DatatypeConverter.printBase64Binary(byteStreamed);
            }

            reportRequest.setAttributeFormat("Excel");
            reportRequest.setByPassCache(true);
            return pdfRender;
        } catch (Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
            pdfRender = fileNotFound();
            setFileNotFound(true);
            return pdfRender;
        }
    }
    
    //jeremias
    public byte [] runReportExcelBI(String chequeo, String vstatus, String nReport) {
        try 
        {
            setFileNotFound(false);
            com.oracle.xmlns.oxp.service.v2.ReportRequest reportRequest = parametrosReporteExcel(chequeo, vstatus, nReport);
            com.oracle.xmlns.oxp.service.v2.ReportService port = service.getReportService();
            reportRequest.setAttributeFormat("xlsx");
            reportRequest.setByPassCache(true);
            ReportResponse repResponse = new ReportResponse();
            repResponse = port.runReport(reportRequest, USER_WS, PASS_REPORT_WS);
            String contentType = repResponse.getReportContentType();
            System.out.println(contentType);
            byte[] baReport = repResponse.getReportBytes();
           
            return baReport;
           
            
        } catch (Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
            pdfRender = fileNotFound();
            setFileNotFound(true);
            return null;
        }
        
    }
    
         public ReportRequest parametrosReporteExcel(String chequeo, String vstatus,String nReport) {

        ParamNameValues paramReport = new ParamNameValues();
        ReportRequest reportParam = new ReportRequest();
        ArrayOfParamNameValue arrayParam = new ArrayOfParamNameValue();

        String parametro1 = "CHEQUEO"; 
        String parametro2 = "VSTATUS";
        ParamNameValue yearParam = new ParamNameValue();
        ParamNameValue tkYearParam = new ParamNameValue();

        ArrayOfString corrVal = new ArrayOfString();
        ArrayOfString tkYearVal = new ArrayOfString();
        try {

            reportParam.setReportAbsolutePath(nReport);// Agregar los nombres de .xdo .
            corrVal.getItem().add(chequeo); // id
            yearParam.setName(parametro1); //year
            yearParam.setValues(corrVal);
            arrayParam.getItem().add(yearParam);

            tkYearVal.getItem().add(vstatus);
            tkYearParam.setName(parametro2); // tkYear
            tkYearParam.setValues(tkYearVal);
            arrayParam.getItem().add(tkYearParam);

            paramReport.setListOfParamNameValues(arrayParam);
            reportParam.setParameterNameValues(paramReport);
            reportParam.setSizeOfDataChunkDownload(-1);// Parametro necesario

        } catch (Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return reportParam;
    }
        

    /**
     * @return the printable
     */
    public boolean isPrintable() {
        return printable;
    }

    /**
     * @param printable the printable to set
     */
    public void setPrintable(boolean printable) {
        this.printable = printable;
    }

    /**
     * @return the fileNotFound
     */
    public boolean isFileNotFound() {
        return fileNotFound;
    }

    /**
     * @param fileNotFound the fileNotFound to set
     */
    public void setFileNotFound(boolean fileNotFound) {
        this.fileNotFound = fileNotFound;
    }

    /**
     * @return the base64PdfWs
     */
    public String getBase64PdfWs() {
        return base64PdfWs;
    }

    /**
     * @param base64PdfWs the base64PdfWs to set
     */
    public void setBase64PdfWs(String base64PdfWs) {
        this.base64PdfWs = base64PdfWs;
    }
    
}
