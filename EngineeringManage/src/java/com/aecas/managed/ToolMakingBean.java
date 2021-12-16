/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aecas.managed;

import static com.aecas.managed.EaPdfBean.getSubmittedFileName;
import com.aees.session.SessionBean;
import com.aeroman.aees.entities.EngPriorities;
import com.aeroman.aees.entities.EngToolRequest;
import com.aeroman.aees.entities.MsjAdjuntos;
import com.aeroman.aees.facades.EngPrioritiesFacade;
import com.aeroman.aees.facades.EngToolRequestFacade;
import com.aeroman.aees.facades.MsjAdjuntosFacade;
import com.aeroman.core.webservice.CoreAircraftFamPJ;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.xml.ws.WebServiceRef;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.util.IOUtils;

/**
 *
 * @author scruz
 */
@ManagedBean(name = "toolMakingBean")
@ViewScoped
public class ToolMakingBean extends CrudBean<EngToolRequest> implements Serializable{
    
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8054/CoreAircraftFamWS/CoreAircraftFamWS.wsdl")
    private com.aeroman.core.webservice.CoreAircraftFamWS_Service service;
    
    @EJB
    private EngToolRequestFacade toolFacade;
    @EJB
    private EngPrioritiesFacade engPrioritiesFacade;
    @EJB
    private MsjAdjuntosFacade msjAdjuntosFacade;
    private Part quote;
    private Part attach;
    private Short priority;
    private List<CoreAircraftFamPJ> listFleet = new ArrayList<>();
    @ManagedProperty(value = "#{AdjuntosBean}")
    private AdjuntosBean adjuntosBean;

    @Override
    public void init() {
        service = new com.aeroman.core.webservice.CoreAircraftFamWS_Service();
        elemento = new EngToolRequest();
        listado = toolFacade.findAll();
        listFleet = coreAll();
    }

    @Override
    public void limpiar() {
        extendtime();
        elemento = new EngToolRequest();
        edit=false;
    }

    @Override
    void actualizar() {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregar() {
        extendtime();
        try {
            BigDecimal contenidoAttach;
            BigDecimal contenidoquote;
            HttpSession sesion=SessionBean.getSession();
            String usuarioins=(String)sesion.getAttribute("username");
            EngPriorities pri = engPrioritiesFacade.find(priority);
            elemento.setToolRequestPrioriy(pri);
            elemento.setToolReqCreationDate(new Date());
            elemento.setToolReqCreatedBy(usuarioins);
            contenidoAttach=tranformarBlob(attach);
            contenidoquote=tranformarBlob(quote);
            elemento.setToolQuoteAtt(contenidoquote.toBigInteger());
            elemento.setToolAtt(contenidoAttach.toBigInteger());
            toolFacade.create(elemento);
            limpiar();
        } catch (Exception e) {
            Logger.getLogger(ToolMakingBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void descargarArchivo(BigInteger archivo) {
        extendtime();
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.setContentType("application/pdf");
        BigDecimal idArchivo = new BigDecimal(archivo);
        int bit = 512;
        MsjAdjuntos file = msjAdjuntosFacade.find(idArchivo);
        try (InputStream in = new ByteArrayInputStream(file.getMsgAdjunto())) {
            response.setHeader("Content-Disposition", "attachment; filename=" + file.getMsgNombreArchivo().replace(",", "_") + file.getMsgExtension());
            try (ServletOutputStream outs = response.getOutputStream()) {
                while ((bit) >= 0) {
                    bit = in.read();
                    outs.write(bit);
                }
                outs.flush();
            }
            in.close();
            response.getOutputStream().close();
            FacesContext.getCurrentInstance().getResponseComplete();
        } catch (IOException e) {
            Logger.getLogger(RequestTrackingBean.class.getName()).log(Level.SEVERE, null, e);
        } 

    }
    
    @SuppressWarnings("empty-statement")
    public BigDecimal tranformarBlob(Part archivo) {
        extendtime();
        BigDecimal idAdjunto = new BigDecimal(BigInteger.ONE);
        byte[] contenido;   
        try {
                if (archivo.getSubmittedFileName() != null) {

                    InputStream input = archivo.getInputStream();
                    FilenameUtils.getName(getSubmittedFileName(archivo));
                    String fileName = FilenameUtils.getName(getSubmittedFileName(archivo));
                    if (verifyValue(fileName)) {
                        String nameF = fileName.substring(0, fileName.lastIndexOf('.'));
                        String mime = fileName.substring(fileName.lastIndexOf('.'), fileName.length());
                        String[] formatos = new String[]{".PDF", ".PNG", ".JPG",".JPEG",".GIF", ".DOC", ".DOCX", ".TXT",".PNG",".XLS",".pdf", ".png", ".jpg",".jpeg",".gif", ".doc", ".docx", ".txt",".PNG",".xls"};

                        for (String formato : formatos) {
                            if (formato.equals(mime)) {
                                contenido = IOUtils.toByteArray(input);
                                adjuntosBean.elemento.setMsgExtension(mime);
                                adjuntosBean.elemento.setMsgNombreArchivo(nameF);
                                adjuntosBean.elemento.setMsgAdjunto(contenido);

                                if (adjuntosBean.elemento.getMsgAdjunto() != null) {
                                    adjuntosBean.agregar();
                                    idAdjunto = adjuntosBean.elemento.getMsgCodigo();
                                    adjuntosBean.elemento = new MsjAdjuntos();
                                }
                                break;
                            }
                        }
                    }
                }
            

        } catch (Exception e) {
            Logger.getLogger(ToolMakingBean.class.getName()).log(Level.SEVERE, null, e);
        }
        return idAdjunto;
    }

    public Boolean verifyValue(String val1) {
        extendtime();
        Boolean verifyNotNull1 = true;
        Integer esp1 = 0;
        String evaluar;
        if (val1 == null) {
            verifyNotNull1 = false;
            return verifyNotNull1;
        }
        evaluar = val1;
        if (evaluar.isEmpty()) {
            verifyNotNull1 = false;
            return verifyNotNull1;
        }
        for (int i = 0; i < evaluar.length(); i++) {
            if (evaluar.charAt(i) == ' ') {
                esp1++;
            }
        }
        if (evaluar.length() == esp1) {
            verifyNotNull1 = false;
            return verifyNotNull1;
        }
        return verifyNotNull1;
    }

    @Override
    public void eliminar(EngToolRequest elemento) {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    EngToolRequest nuevoElemento() {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    public Part getQuote() {
        return quote;
    }

    public void setQuote(Part quote) {
        this.quote = quote;
    }

    public Part getAttach() {
        return attach;
    }

    public void setAttach(Part attach) {
        this.attach = attach;
    }

    public Short getPriority() {
        return priority;
    }

    public void setPriority(Short priority) {
        this.priority = priority;
    }

    public List<CoreAircraftFamPJ> getListFleet() {
        return listFleet;
    }

    public void setListFleet(List<CoreAircraftFamPJ> listFleet) {
        this.listFleet = listFleet;
    }

    private java.util.List<com.aeroman.core.webservice.CoreAircraftFamPJ> coreAll() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.aeroman.core.webservice.CoreAircraftFamWS port = service.getCoreAircraftFamWSPort();
        return port.coreAll();
    }

    public AdjuntosBean getAdjuntosBean() {
        return adjuntosBean;
    }

    public void setAdjuntosBean(AdjuntosBean adjuntosBean) {
        this.adjuntosBean = adjuntosBean;
    }

    
    
}
