/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aecas.managed;// paquete manage
import com.aeroman.aees.entities.EngReqResponses;// importacion de clase
import com.aeroman.aees.entities.MsjAdjuntos;// importacion de clase
import com.aeroman.aees.entities.TypeDoc;// importacion de clase
import com.aeroman.aees.facades.MsjAdjuntosFacade;// importacion de clase
import com.aeroman.aees.facades.TypeDocFacade;// importacion de clase
import java.io.ByteArrayInputStream;// libreria ByteArrayInputStream
import java.io.InputStream;// libreria InputStream
import java.io.Serializable;// libreria Serializable
import java.math.BigDecimal;// libreria BigDecimal
import java.util.ArrayList;// libreria ArrayList
import java.util.List;// libreria List
import java.util.logging.Level;// libreria Level
import java.util.logging.Logger;// libreria Logger
import javax.annotation.PostConstruct;// libreria PostConstruct
import javax.ejb.EJB;// libreria EJB
import javax.faces.bean.ManagedBean;// libreria ManagedBean
import javax.faces.bean.SessionScoped;// libreria SessionScoped
import javax.faces.context.FacesContext;// libreria FacesContext
import javax.servlet.ServletOutputStream;// libreria ServletOutputStream
import javax.servlet.http.HttpServletResponse;// libreria HttpServletResponse
import org.apache.soap.encoding.soapenc.Base64;// libreria Base64
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;// libreria WordprocessingMLPackage
import org.apache.poi.openxml4j.opc.OPCPackage;// libreria OPCPackage
import org.apache.poi.xssf.usermodel.XSSFWorkbook;// libreria XSSFWorkbook
/**
 *
 * @author saplic
 */
//nombre de clase en mageBean
@ManagedBean(name="AdjuntosBean")
@SessionScoped//tipo de clase
//clase ContAtasBean con extends al crud
public class AdjuntosBean extends CrudBean<MsjAdjuntos> implements Serializable{

    @EJB
    private MsjAdjuntosFacade msjAdjuntosFacade;//declaracion de clases Facade
    @EJB
    private TypeDocFacade typeDocFacade;//declaracion de clases Facade
    
    private String notsup="Not supported yet.";//declaracion de variable
    private TypeDoc typeDoc;//declarion variable tipo clase
    
    
    private String idReqResponse;//declaracion de variable
    private List<String[]> listimage = new ArrayList();//variable de lista
    
    private String image;//declaracion de variable
    private String idDocument;//declaracion de variable
    private boolean esEA;//declaracion de variable
    private String docx=".docx";//declaracion de variable
    private String app="application/octet-stream";//declaracion de variable
    private String cont="Content-Disposition";//declaracion de variable
    private String att="attachment; filename=";//declaracion de variable
    //Constructor de adjuntos ESR
    @Override
    @PostConstruct        
    public void init() {
        elemento = new MsjAdjuntos();
        listado = new ArrayList<>();
        esEA = false;
    }
    //Metodo de extends de implementes
    @Override
    void limpiar() {
        throw new UnsupportedOperationException(notsup); //To change body of generated methods, choose Tools | Templates.
    }
    //Metodo de extends de implementes
    @Override
    void actualizar() {
        throw new UnsupportedOperationException(notsup); //To change body of generated methods, choose Tools | Templates.
    }
    //agregar da data en la DB
    @Override
    public void agregar() {
        extendtime();
        msjAdjuntosFacade.create(elemento);

    }
    //Metodo de extends de implementes
    @Override
    void eliminar(MsjAdjuntos elemento) {
        throw new UnsupportedOperationException(notsup); //To change body of generated methods, choose Tools | Templates.
    }
    //Metodo de extends de implementes
    @Override
    MsjAdjuntos nuevoElemento() {
        throw new UnsupportedOperationException(notsup); //To change body of generated methods, choose Tools | Templates.
    }
    //Metodo de busqueda de archivos
    public void findAdjunto(){
        extendtime();
        EngReqResponses idRR = new EngReqResponses();
        idRR.setResId(new BigDecimal(getIdReqResponse()));
        listado=msjAdjuntosFacade.findAdj(idRR);
        setEsEA(false);
        // lledado de lista de archivos adjuntos 
        for (MsjAdjuntos lisMsj : listado) {
            lisMsj.setNombreAcotado(lisMsj.getMsgNombreArchivo()+lisMsj.getMsgExtension());
            if (lisMsj.getNombreAcotado().length()>22) {
                      lisMsj.setNombreAcotado(lisMsj.getMsgNombreArchivo().substring(0,19)+"...");
                  }
            //seteo de una extencion de error para adjuntar un archivo X
            lisMsj.setExtension("error");
            // tanformacion de tipo de archivo
            switch(lisMsj.getMsgExtension().toUpperCase()) {
                case ".PDF":
                  lisMsj.setExtension("pdf");
                  break;
                case ".PNG":
                  lisMsj.setExtension("png");
                  break;
                case ".JPG":
                case ".JPEG":
                  lisMsj.setExtension("jpg");
                  break;
                case ".GIF":
                  lisMsj.setExtension("gif");
                  break;
                case ".DOC":
                case ".DOCX":
                  lisMsj.setExtension("doc");
                  break;
                case ".XLS":
                case ".XLSX":
                  lisMsj.setExtension("xls");
                  break;
                default:
                case ".TXT":
                  lisMsj.setExtension("txt");
                  break;                    
              }
            
        }
    }
    // metodo de busqueda anterior 
    public void findSelectedItem() {      
        extendtime();
        if (listimage != null) {
            //limpia lista de archivos
            listimage = new ArrayList<>();
            
// se llena el arreglo de los archivos
            for (MsjAdjuntos e : listado) {
                String[] img = new String[4];
                img[0] = e.getMsgNombreArchivo();
                img[1] = e.getMsgExtension();
                img[3] = e.getMsgCodigo().toString();
                image = Base64.encode(e.getMsgAdjunto());
                img[2] = image; // se agrega la imagen del documento
                listimage.add(img);

            }
        }
    }
    // metodo de descar de archivos 
    public void downloadfile() {
        extendtime();
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();

        int bit2 = 512;

        int ids = Integer.parseInt(getIdReqResponse());
        BigDecimal idd = new BigDecimal(ids);
        // se extrae el archivo selecionado
        MsjAdjuntos esrdoc = msjAdjuntosFacade.find(idd);
        // se inicializa la clase TypeDoc la cual contendra el mime de la extencion
        typeDoc = new TypeDoc();
        //extraccion del mime de la BD
        typeDoc = typeDocFacade.find(esrdoc.getMsgExtension());
        response.setContentType(app);
        //evaluacion del mime
        if (typeDoc != null) {
            response.setContentType(typeDoc.getTcMime());
        }
        //evaluciaon cuando el archivo es docx
        if (!esrdoc.getMsgExtension().equals(docx)) {
            //estructura para armar archivo a descargar
            response.setHeader(cont, att + esrdoc.getMsgNombreArchivo().replace(",", "_") + esrdoc.getMsgExtension());
        try (InputStream in2 = new ByteArrayInputStream(esrdoc.getMsgAdjunto())) {

            ServletOutputStream outs2 = response.getOutputStream();
            while ((bit2) >= 0) {
                bit2 = in2.read();
                outs2.write(bit2);
            }
            outs2.flush();
            outs2.close();
            in2.close();
            FacesContext.getCurrentInstance().getResponseComplete();

        } catch (Exception e) {
            //captura de posibles errores
            Logger.getLogger(AdjuntosBean.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            //captura de finally del metodo
            FacesContext.getCurrentInstance().getResponseComplete();
        }
        } else {
            //metodo de descarga para tipos de archivo .docx
            newDownloadfileDocx(response,esrdoc);
        }
    }
    // nuevo tipo de descar de archivos
    public void newDownloadfile() {

        extendtime();// extender tiempo de sesion
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();

        int bit3 = 512;
        //convertir el ID seleccionado al tipo de dato de la clase
        int ids = Integer.parseInt(getIdDocument());
        MsjAdjuntos esrdoc = listado.get(ids);
        // se inicializa la clase TypeDoc la cual contendra el mime de la extencion
        typeDoc = new TypeDoc();
        //extraccion del mime de la BD
        typeDoc = typeDocFacade.find(esrdoc.getMsgExtension());
        response.setContentType(app);
        if (typeDoc != null) {
            response.setContentType(typeDoc.getTcMime());
        }
        //evaluciaon cuando el archivo es docx o .xlsx
        if (!esrdoc.getMsgExtension().equals(docx) && !esrdoc.getMsgExtension().equals(".xlsx")) {
             //estructura para armar archivo a descargar
            response.setHeader(cont, att + esrdoc.getMsgNombreArchivo().replace(",", "_") + esrdoc.getMsgExtension());
            try (InputStream in3 = new ByteArrayInputStream(esrdoc.getMsgAdjunto())) {

                ServletOutputStream outs3 = response.getOutputStream();
                while ((bit3) >= 0) {
                    bit3 = in3.read();
                    outs3.write(bit3);
                }
                outs3.flush();
                outs3.close();
                in3.close();
                FacesContext.getCurrentInstance().getResponseComplete();
            } catch (Exception e) {
                //captura de posibles errores
                Logger.getLogger(AdjuntosBean.class.getName()).log(Level.SEVERE, null, e);
            } finally {
                // final de metdo
                FacesContext.getCurrentInstance().getResponseComplete();
            }
        } else if (esrdoc.getMsgExtension().equals(docx)) {
            //metodo  que descar archivos tipo docx
            newDownloadfileDocx(response,esrdoc);
        }
        else{
             //metodo  que descar archivos tipo xlsx
            newDownloadfileXlsx(response,esrdoc);
        }
    }
    
    //metodo para descargar archivos docx
    public void newDownloadfileDocx(HttpServletResponse response, MsjAdjuntos esrdoc) {
         
        try {     
            //convertir a base 64
            ByteArrayInputStream datoss = new ByteArrayInputStream(esrdoc.getMsgAdjunto());
            WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(datoss);   
             //descarga de archivos
            response.setHeader(cont, att+esrdoc.getMsgNombreArchivo().replace(",", "_") + esrdoc.getMsgExtension());
            wordMLPackage.save(response.getOutputStream());
            response.getOutputStream().close();
        } catch (Exception ex) {
            Logger.getLogger(AdjuntosBean.class.getName()).log(Level.SEVERE, null, ex);
        } 
     }
    //metodo para descargar xlsx no funciona aun
    public void newDownloadfileXlsx(HttpServletResponse response, MsjAdjuntos esrdoc) {
         
        try {       
             String fileName = "SomeExcel.xlsx";
             // mime por defecto
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            //convierte a base 64
            ByteArrayInputStream datoss = new ByteArrayInputStream(esrdoc.getMsgAdjunto());

            OPCPackage pkg = OPCPackage.open(datoss);

            XSSFWorkbook workbook = new XSSFWorkbook(pkg);

            ServletOutputStream respOut = response.getOutputStream();

            pkg.close();
            workbook.write(respOut);
            respOut.flush();               

            response.setHeader(cont, "attachment;filename=\"" +fileName+ "\"");

        } catch (Exception ex) {
            //captura de nuevos errores
            Logger.getLogger(AdjuntosBean.class.getName()).log(Level.SEVERE, null, ex);
        } 
     }
    
    
    //metodo de descarga de archivos que solo se ecuentran cargados en memoria
    public void newDownloadfile2() {

        extendtime();//extender el tiepo de sesion 
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        int bit = 512;
        //posicion seleccionada
        int ids = Integer.parseInt(getIdDocument());
        //llenando clase de la lista
        MsjAdjuntos esrdoc = listado2.get(ids);
        typeDoc = new TypeDoc();
        //tipo de mime de la BD
        typeDoc = typeDocFacade.find(esrdoc.getMsgExtension());
        response.setContentType(app);
        //evalucaion de mime
        if (typeDoc != null) {
            response.setContentType(typeDoc.getTcMime());
        }
        //estructura de descarga de archivos sin ID
        if (!esrdoc.getMsgExtension().equals(docx)) {            
            response.setHeader(cont, att + esrdoc.getMsgNombreArchivo().replace(",", "_") + esrdoc.getMsgExtension());
        try (InputStream in = new ByteArrayInputStream(esrdoc.getMsgAdjunto())) {

            ServletOutputStream outs = response.getOutputStream();
            while ((bit) >= 0) {
                bit = in.read();
                outs.write(bit);
            }
            outs.flush();
            outs.close();
            in.close();
            FacesContext.getCurrentInstance().getResponseComplete();

        } catch (Exception e) {
            //captura de error de descarga ADJ
            Logger.getLogger(AdjuntosBean.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            //finally de catch
            FacesContext.getCurrentInstance().getResponseComplete();
        }
        }else {
            //metodo de descarga tipo docx
            newDownloadfileDocx(response,esrdoc);
        }
    }
    
    //get y set de variable

    public String getNotsup() {
        return notsup;
    }

    public void setNotsup(String notsup) {
        this.notsup = notsup;
    }
//get y set de variable
    public String getIdReqResponse() {
        return idReqResponse;
    }

    public void setIdReqResponse(String idReqResponse) {
        this.idReqResponse = idReqResponse;
    }
//get y set de variable
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
//get y set de variable
    public List<String[]> getListimage() {
        return listimage;
    }

    public void setListimage(List<String[]> listimage) {
        this.listimage = listimage;
    }
//get y set de variable
    public String getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(String idDocument) {
        this.idDocument = idDocument;
    }
//get y set de variable
    public boolean isEsEA() {
        return esEA;
    }

    public void setEsEA(boolean esEA) {
        this.esEA = esEA;
    }  
}
