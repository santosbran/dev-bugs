
// To change this license header, choose License Headers in Project Properties.
// To change this template file, choose Tools | Templates
// and open the template in the editor.

package com.aecas.managed;// paquete manage

import static com.aecas.managed.EaPdfBean.getSubmittedFileName;// importacion de clase
import com.aeroman.aees.entities.EngEsrDocument;// importacion de clase
import com.aeroman.aees.entities.MsjAdjuntos;// importacion de clase
import com.aeroman.aees.entities.TypeDoc;// importacion de clase
import com.aeroman.aees.facades.EngEsrDocumentFacade;// importacion de clase
import com.aeroman.aees.facades.Sequences;// importacion de clase
import com.aeroman.aees.facades.TypeDocFacade;// importacion de clase
import java.io.ByteArrayInputStream;// libreria ByteArrayInputStream
import java.io.IOException;// libreria IOException
import java.io.InputStream;// libreria InputStream
import java.io.OutputStream;// libreria OutputStream
import java.io.Serializable;// libreria Serializable
import java.math.BigDecimal;// libreria BigDecimal
import java.math.BigInteger;// libreria BigInteger
import java.util.ArrayList;// libreria ArrayList
import java.util.Collection;// libreria Collection
import java.util.List;// libreria List
import java.util.logging.Level;// libreria Level
import java.util.logging.Logger;// libreria Logger
import javax.annotation.PostConstruct;// libreria PostConstruct
import javax.ejb.EJB;// libreria EJB
import javax.faces.bean.ManagedBean;// libreria ManagedBean
import javax.faces.bean.SessionScoped;// libreria SessionScoped
import javax.faces.context.FacesContext;// libreria FacesContext
import javax.servlet.ServletException;// libreria ServletException
import javax.servlet.ServletOutputStream;// libreria ServletOutputStream
import javax.servlet.http.HttpServletRequest;// libreria HttpServletRequest
import javax.servlet.http.HttpServletResponse;// libreria HttpServletResponse
import javax.servlet.http.Part;// libreria Part
import org.apache.commons.io.FilenameUtils;// libreria FilenameUtils
import org.apache.poi.openxml4j.opc.OPCPackage;// libreria OPCPackage
import org.apache.poi.util.IOUtils;// libreria IOUtils
import org.apache.poi.xssf.usermodel.XSSFWorkbook;// libreria XSSFWorkbook
import org.apache.soap.encoding.soapenc.Base64;// libreria Base64
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;// libreria WordprocessingMLPackage

/**
 *
 * @author Usuario
 */
 //nombre de clase en mageBean
@ManagedBean(name = "esrDocumentBean")
@SessionScoped//tipo de clase
//clase EsrDocumentBean con extends al crud
public class EsrDocumentBean extends CrudBean<EngEsrDocument> implements Serializable {

    @EJB
    private EngEsrDocumentFacade documentFacade;//declaracion de clases Facade
    @EJB
    private Sequences seq;//declaracion de clases Facade
    
    @EJB
    private TypeDocFacade typeDocFacade;//declaracion de clases Facade
    
    private TypeDoc typeDoc;//declaracion de variable

    private Part file;//declaracion de variable
    private String pathdoc;//declaracion de variable
    private String image;//declaracion de variable
    private List<String[]> listimage = new ArrayList();//declaracion de variable
    private String idImg;//declaracion de variable
    private String idesr;//declaracion de variable
    private int existeFile;//declaracion de variable
    private String idDocument;//declaracion de variable
    private boolean seleccionarArchivo;//declaracion de variable

    @Override//metodo generado por implements Serializable
    @PostConstruct//metodo constructor
    public void init() {
        elemento = new EngEsrDocument();
        listado = new ArrayList<>();
        pathdoc = "";
        existeFile = 0;
    }

    public Object findSelect(String id) throws IOException {
        extendtime(); //extiende el tiempo de sesion
        elemento = new EngEsrDocument();
        listado = documentFacade.findAll();
        if (listimage != null) {
            listimage.clear();

            List<EngEsrDocument> listesrdoc = new ArrayList();
            int x = 0;
            short num = Short.parseShort(id);
            while (x < listado.size()) {
                EngEsrDocument esrdoc = (EngEsrDocument) listado.get(x);
                
                if (esrdoc.getReqMessageid() != null && esrdoc.getReqMessageid().equals(num)) {

                    String[] img = new String[4];
                    img[0] = esrdoc.getNameDocu();
                    img[1] = esrdoc.getExtenDocu();
                    img[3] = esrdoc.getIdDocu().toString();

                    image = Base64.encode(esrdoc.getBodyDocu());
                    img[2] = image;

                    listesrdoc.add(esrdoc);
                    listimage.add(img);

                }
                x++;
            }

            listado2 = listesrdoc;
        }
        return elemento;
    }

    public void findSelectedItem(String id) throws IOException {
        extendtime(); //extiende el tiempo de sesion
        listado = documentFacade.findByItemId(id);
        
    }

    //metodo para recuperar blob
    public void recuperarBlob(EngEsrDocument esrdoc) {
        extendtime(); //extiende el tiempo de sesion
        String est = esrdoc.getExtenDocu().replace(".", "");
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.setContentType("application/" + est);

        int bit = 512;
        OutputStream outs = null;
        try (InputStream in = new ByteArrayInputStream(esrdoc.getBodyDocu())) {
            outs = response.getOutputStream();

            while ((bit) >= 0) {
                bit = in.read();
                outs.write(bit);
            }
            outs.flush();
            outs.close();
            in.close();
        } catch (IOException e) {
            Logger.getLogger(EsrDocumentBean.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (outs != null) {
                    outs.flush();
                    outs.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(EsrDocumentBean.class.getName()).log(Level.SEVERE, null, ex);
            }
            FacesContext.getCurrentInstance().responseComplete();
        }

    }

    public void downloadfile() {
        extendtime(); //extiende el tiempo de sesion
        Short iddocu = new Short(idImg);
        EngEsrDocument esrdoc = documentFacade.find(iddocu);
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        
      
        typeDoc = new TypeDoc();
        typeDoc = typeDocFacade.find(esrdoc.getExtenDocu());
        response.setContentType("application/octet-stream");
        if (typeDoc != null) {
            response.setContentType(typeDoc.getTcMime());
        }
        if (!esrdoc.getExtenDocu().equals(".docx") && !esrdoc.getExtenDocu().equals(".xlsx")) { 
        
        response.setHeader("Content-Disposition", "attachment; filename=" + esrdoc.getNameDocu().replace(",", "_") + esrdoc.getExtenDocu());
        int bit = 512;
        try (InputStream in = new ByteArrayInputStream(esrdoc.getBodyDocu())) {

            ServletOutputStream outs = response.getOutputStream();
            while ((bit) >= 0) {
                bit = in.read();
                outs.write(bit);
            }
            outs.flush();
            outs.close();
            in.close();

        } catch (Exception e) {
            Logger.getLogger(EsrDocumentBean.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            FacesContext.getCurrentInstance().getResponseComplete();
        }
        } else if (esrdoc.getExtenDocu().equals(".docx")) {
            newDownloadfileDocx(response,esrdoc);
        }
        else{
            newDownloadfileXlsx(response,esrdoc);
        }
    }
        public void newDownloadfileDocx(HttpServletResponse response, EngEsrDocument esrdoc) {
         
        try {       
            ByteArrayInputStream datoss = new ByteArrayInputStream(esrdoc.getBodyDocu());
            WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(datoss);   
             
            response.setHeader("Content-disposition", "attachment; filename="+ esrdoc.getNameDocu().replace(",", "_") + esrdoc.getExtenDocu());
            wordMLPackage.save(response.getOutputStream());
            response.getOutputStream().close();
        } catch (Exception ex) {
            Logger.getLogger(EsrDocumentBean.class.getName()).log(Level.SEVERE, null, ex);
        } 
     }
    public void newDownloadfileXlsx(HttpServletResponse response, EngEsrDocument esrdoc) {
         
        try {       
             String fileName2 = "SomeExcel.xlsx";

            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            ByteArrayInputStream datoss2 = new ByteArrayInputStream(esrdoc.getBodyDocu());

            OPCPackage pkg2 = OPCPackage.open(datoss2);

            XSSFWorkbook workbook2 = new XSSFWorkbook(pkg2);

            ServletOutputStream respOut2 = response.getOutputStream();

            pkg2.close();
            workbook2.write(respOut2);
            respOut2.flush();

            workbook2 = null;                    

            response.setHeader("Content-disposition", "attachment;filename=\"" +fileName2+ "\"");

        } catch (Exception ex) {
            Logger.getLogger(AdjuntosBean.class.getName()).log(Level.SEVERE, null, ex);
        } 
     }

    public void deletefile() {
        try {
            extendtime(); //extiende el tiempo de sesion
            Short iddocu = new Short(idImg);
            elemento = documentFacade.find(iddocu);
            idesr = elemento.getReqMessageid().toString();
            documentFacade.remove(elemento);
            findSelect(idesr);
        } catch (Exception e) {
            Logger.getLogger(EsrDocumentBean.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    public void agregarDocumentos(BigInteger reqMessageid) {
        extendtime(); //extiende el tiempo de sesion
        if (listado != null) {
            for (EngEsrDocument docuguard : listado) {
                if(docuguard.getReqMessageid() == null){                    
                    docuguard.setReqMessageid(reqMessageid.shortValue());
                    documentFacade.create(docuguard);
                }
                
            }
        }
        elemento = new EngEsrDocument();
        listimage = new ArrayList();
        listado = new ArrayList();
    }

    @Override//metodo generado por implements Serializable
    void limpiar() {
       documentFacade.count();
    }

    @Override//metodo generado por implements Serializable
    void actualizar() {
        documentFacade.edit(elemento); //To change body of generated methods, choose Tools | Templates.
    }

    @Override//metodo generado por implements Serializable
    void agregar() {
        documentFacade.create(elemento); //To change body of generated methods, choose Tools | Templates.
    }

    @Override//metodo generado por implements Serializable
    void eliminar(EngEsrDocument elemento) {
        documentFacade.remove(elemento); //To change body of generated methods, choose Tools | Templates.
    }

    @Override//metodo generado por implements Serializable
    EngEsrDocument nuevoElemento() {
        return listado3.get(0); //To change body of generated methods, choose Tools | Templates.
    }



    public Boolean val(Object val) {
        extendtime(); //extiende el tiempo de sesion
        Boolean verifyIsNotNull = true;
        Integer esp = 0;
        String evaluar;
        if (val == null) {
            verifyIsNotNull = false;
            return verifyIsNotNull;
        }
        evaluar = val.toString();
        if (evaluar.isEmpty()) {
            verifyIsNotNull = false;
            return verifyIsNotNull;
        }
        for (int i = 0; i < evaluar.length(); i++) {
            if (evaluar.charAt(i) == ' ') {
                esp++;
            }
        }
        if (evaluar.length() == esp) {
            verifyIsNotNull = false;
            return verifyIsNotNull;
        }
        return verifyIsNotNull;
    }

    public Part getFile() {//get y set de variable
        return file;
    }

    public void setFile(Part file) {//get y set de variable
        this.file = file;
    }

    public String getPathdoc() {//get y set de variable
        return pathdoc;
    }

    public void setPathdoc(String pathdoc) {//get y set de variable
        this.pathdoc = pathdoc;
    }

    public String getImage() {//get y set de variable
        return image;
    }

    public void setImage(String image) {//get y set de variable
        this.image = image;
    }

    public List<String[]> getListimage() {//get y set de variable
        return listimage;
    }

    public void setListimage(List<String[]> listimage) {//get y set de variable
        this.listimage = listimage;
    }

    public String getIdImg() {//get y set de variable
        return idImg;
    }

    public void setIdImg(String idImg) {//get y set de variable
        this.idImg = idImg;
    }

    public String getIdesr() {//get y set de variable
        return idesr;
    }

    public void setIdesr(String idesr) {//get y set de variable
        this.idesr = idesr;
    }

    public int getExisteFile() {//get y set de variable
        return existeFile;
    }

    public void setExisteFile(int existeFile) {//get y set de variable
        this.existeFile = existeFile;
    }

    public boolean isSeleccionarArchivo() {//get y set de variable
        return seleccionarArchivo;
    }

    public void setSeleccionarArchivo(boolean seleccionarArchivo) {//get y set de variable
        this.seleccionarArchivo = seleccionarArchivo;
    }

    public String getIdDocument() {//get y set de variable
        return idDocument;
    }

    public void setIdDocument(String idDocument) {//get y set de variable
        this.idDocument = idDocument;
    }
}
