/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aecas.managed;

import static com.aecas.managed.EaPdfBean.getSubmittedFileName;
import com.aeroman.aees.entities.EngUploadPlantilla;
import com.aeroman.aees.facades.EngUploadPlantillaFacade;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.util.IOUtils;

/**
 *
 * @author firaheta
 */
@ManagedBean(name = "plantillasBeen")
@SessionScoped
public class PlantillasBean extends CrudBean<EngUploadPlantilla> {

    /**
     * Creates a new instance of PlantillasBean
     */
    @EJB
    private EngUploadPlantillaFacade plantillaUploadFacade;
    
    private Part file;
    private boolean seleccionarArchivo;
    private int existeFile,contolador,menscons;
    private long ID_DOCUMENT;
    private long borrar;
    private String NAME_DOCUMENT,EXTEN_DOCUMENT;
    private String idDocumentUpload;
    
    @PostConstruct
    @Override    
    public void init() {
        elemento= new EngUploadPlantilla();
        listado = plantillaUploadFacade.findAllEngUploadPlantilla();
    }

    @Override
    public void limpiar() {
        extendtime();
        this.elemento = new EngUploadPlantilla();
        edit = false;
        idDocumentUpload = null;
        menscons = 0;
    }

    @Override
    public void actualizar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

     public void delete(String id){
         extendtime();
        try {
            long  ax= Long.parseLong(id);
            EngUploadPlantilla borrar = plantillaUploadFacade.find(ax);
            eliminar(borrar);
        } catch (Exception e) {
            String errores = e.getCause().getMessage();
            if (errores.contains("Error committing transaction") || errores.contains("Error al realizar la transacción")) {
                limpiar();
                menscons = 1;
            }
            FacesContext.getCurrentInstance().validationFailed();
            Logger.getLogger(EngReqIngactionStatusBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    @Override
    public void eliminar(EngUploadPlantilla elemento) {
        extendtime();      
        plantillaUploadFacade.remove(elemento);
        listado = plantillaUploadFacade.findAll();        
    }

    @Override
    public EngUploadPlantilla nuevoElemento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @SuppressWarnings("empty-statement")
    public void savedocu() throws IOException, ServletException {
        extendtime();
        if (listado2 == null) {
            listado2 = new ArrayList<>();
        }
        seleccionarArchivo = false;
        ArrayList<String> namex = new ArrayList();
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

        try {
            int size=listado.size();
            byte[] content;
            Collection<Part> part = request.getParts();
            for (Part current : part) {
                if (current.getSubmittedFileName() != null) {
                    
                    InputStream inputStream = current.getInputStream();
                    Part uploadedFile = current;
                    FilenameUtils.getName(getSubmittedFileName(uploadedFile));
                    String fileName = FilenameUtils.getName(getSubmittedFileName(current));
                    if (val(fileName)) {

                        String nameDoc = fileName.substring(0, fileName.lastIndexOf('.'));
                        String mimeDoc = fileName.substring(fileName.lastIndexOf('.'), fileName.length());
                        String[] formats = new String[]{".PDF", ".PNG", ".JPG",".JPEG",".GIF", ".DOC", ".DOCX", ".TXT",".PNG",".XLS",".pdf", ".png", ".jpg",".jpeg",".gif", ".doc", ".docx", ".txt",".PNG",".xls"};

                        for (int i = 0; i < formats.length; i++) {
                            if (formats[i].equals(mimeDoc)) {
                                String id;
                                existeFile = 0;
                                contolador=0;
                                elemento = new EngUploadPlantilla();
                                content = IOUtils.toByteArray(inputStream);

                                namex.add(nameDoc + "" + mimeDoc + "");
                                
                                
                                for (EngUploadPlantilla fd : listado) {
                                    ID_DOCUMENT=fd.getIdDocument();
                                    NAME_DOCUMENT=fd.getNameDocument();
                                    EXTEN_DOCUMENT=fd.getExtenDocument();
                                    if (NAME_DOCUMENT.equals(nameDoc) && EXTEN_DOCUMENT.equals(mimeDoc)){
                                        contolador=1;
                                        break;
                                    }
                                    
                                }
                                if(contolador != 1){
                                elemento.setBodyDocument(content);
                                elemento.setNameDocument(nameDoc);
                                elemento.setExtenDocument(mimeDoc);                                          
                                plantillaUploadFacade.create(elemento);
                                listado = plantillaUploadFacade.findAll();
                                elemento = new EngUploadPlantilla();
                                existeFile=0;
                                break;
                                }
                                else{
                                    FacesContext.getCurrentInstance().validationFailed();
                                    break;
                                }                                    
                            }else{
                                existeFile=1;
                                
                            }
                        }
                        if (existeFile==1){
                            FacesContext.getCurrentInstance().validationFailed();
                        }
                    }else{
                        seleccionarArchivo = true;
                        FacesContext.getCurrentInstance().validationFailed();
                    }
                }
            }

        } catch (Exception e) {
            Logger.getLogger(EsrDocumentBean.class.getName()).log(Level.SEVERE, null, e);
           
        }

    }
    
    public Boolean val(Object val) {
        extendtime();
        Boolean verifyIsNotNull2 = true;
        Integer esp2 = 0;
        String evaluar2;
        if (val == null) {
            verifyIsNotNull2 = false;
            return verifyIsNotNull2;
        }
        evaluar2 = val.toString();
        if (evaluar2.isEmpty()) {
            verifyIsNotNull2 = false;
            return verifyIsNotNull2;
        }
        for (int i = 0; i < evaluar2.length(); i++) {
            if (evaluar2.charAt(i) == ' ') {
                esp2++;
            }
        }
        if (evaluar2.length() == esp2) {
            verifyIsNotNull2 = false;
            return verifyIsNotNull2;
        }
        return verifyIsNotNull2;
    }
    
    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public boolean isSeleccionarArchivo() {
        return seleccionarArchivo;
    }

    public void setSeleccionarArchivo(boolean seleccionarArchivo) {
        this.seleccionarArchivo = seleccionarArchivo;
    }

    public int getExisteFile() {
        return existeFile;
    }

    public void setExisteFile(int existeFile) {
        this.existeFile = existeFile;
    }

    public int getContolador() {
        return contolador;
    }

    public void setContolador(int contolador) {
        this.contolador = contolador;
    }

    public String getIdDocumentUpload() {
        return idDocumentUpload;
    }

    public void setIdDocumentUpload(String idDocumentUpload) {
        this.idDocumentUpload = idDocumentUpload;
    }

    public int getMenscons() {
        return menscons;
    }

    public void setMenscons(int menscons) {
        this.menscons = menscons;
    }

    public long getID_DOCUMENT() {
        return ID_DOCUMENT;
    }

    public void setID_DOCUMENT(long ID_DOCUMENT) {
        this.ID_DOCUMENT = ID_DOCUMENT;
    }

    public long getBorrar() {
        return borrar;
    }

    public void setBorrar(long borrar) {
        this.borrar = borrar;
    }

    public String getNAME_DOCUMENT() {
        return NAME_DOCUMENT;
    }

    public void setNAME_DOCUMENT(String NAME_DOCUMENT) {
        this.NAME_DOCUMENT = NAME_DOCUMENT;
    }

    public String getEXTEN_DOCUMENT() {
        return EXTEN_DOCUMENT;
    }

    public void setEXTEN_DOCUMENT(String EXTEN_DOCUMENT) {
        this.EXTEN_DOCUMENT = EXTEN_DOCUMENT;
    }
    
    
    
    
}
