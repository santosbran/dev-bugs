/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aecas.managed;// paquete manage

import com.aees.session.SessionBean;// importacion de clase
import com.aeroman.aees.entities.EngEaGeneral;// importacion de clase
import com.aeroman.aees.entities.EngEaPdf;// importacion de clase
import com.aeroman.aees.facades.EngEaGeneralFacade;// importacion de clase
import com.aeroman.aees.facades.EngEaPdfFacade;// importacion de clase
import com.aeroman.aees.facades.Sequences;// importacion de clase
import java.io.ByteArrayInputStream;// libreria ByteArrayInputStream
import java.io.File;// libreria File
import java.io.IOException;// libreria IOException
import java.io.InputStream;// libreria InputStream
import java.io.Serializable;// libreria Serializable
import java.math.BigDecimal;// libreria BigDecimal
import java.math.BigInteger;// libreria BigInteger
import java.nio.file.Files;// libreria Files
import java.nio.file.Path;// libreria Path
import java.nio.file.Paths;// libreria Paths
import java.util.ArrayList;// libreria ArrayList
import java.util.Calendar;// libreria Calendar
import java.util.Date;// libreria Date
import java.util.GregorianCalendar;// libreria GregorianCalendar
import java.util.List;// libreria List
import java.util.logging.Level;// libreria Level
import java.util.logging.Logger;// libreria Logger
import javax.annotation.PostConstruct;// libreria PostConstruct
import javax.ejb.EJB;// libreria EJB
import javax.faces.bean.ManagedBean;// libreria ManagedBean
import javax.faces.bean.ManagedProperty;// libreria ManagedProperty
import javax.faces.bean.SessionScoped;// libreria SessionScoped
import javax.faces.context.FacesContext;// libreria FacesContext
import javax.servlet.ServletOutputStream;// libreria ServletOutputStream
import javax.servlet.http.Part;// libreria Part
import org.apache.commons.io.FilenameUtils;// libreria FilenameUtils
import javax.servlet.http.HttpServletRequest;// libreria HttpServletRequest
import javax.servlet.http.HttpServletResponse;// libreria HttpServletResponse
import javax.servlet.http.HttpSession;// libreria HttpSession


/**
 *
 * @author saplic
 */
//nombre de clase en mageBean
@ManagedBean(name = "eaPdfBean")
@SessionScoped //tipo de clase
//clase ContAtasBean con extends al crud
public class EaPdfBean extends CrudBean<EngEaPdf> implements Serializable{
    
    @EJB
    private EngEaPdfFacade engEaPdfFacade;//declaracion de clases Facade
    @EJB
    private EngEaGeneralFacade eaFacade;//declaracion de clases Facade
    private EngEaPdf elements;//declarion variable tipo clase
    private EngEaPdf elements2;//declarion variable tipo clase
    
    
   // private BigDecimal ida;//declaracion de variable
    private String title;//declaracion de variable
    private String coments;//declaracion de variable
    private Part file;//declaracion de variable
    private int idor;//declaracion de variable
    private String esrid;//declaracion de variable
    private String docname;//declaracion de variable
   
    
    private Part fileEa;//declarion variable tipo clase
    private boolean archivomalo;//declaracion de variable
    private boolean existecover;//declaracion de variable
    
    @ManagedProperty(value = "#{AdjuntosBean}")
    private AdjuntosBean adjuntosBean;//declarion variable tipo clase
    
    //metodo generado por implements Serializable
    @Override
    //metodo constructor
    @PostConstruct
   void init() {
        elemento=new EngEaPdf();
    }
   
   //metodo que busca por lo seleccionado
    public EngEaPdf findSelect(String id) {
        extendtime();//extiende el tiempo
        elemento = new EngEaPdf(); //inicializa el elemento
        listado2 = new ArrayList<>();
        listado2 = engEaPdfFacade.findByIDEA(new BigInteger(id));

        return elemento; //retorna el elemento
    }

//busca por ID para las EA
    public Object findSelect2(String id) {
        extendtime();
        int ids = Integer.parseInt(id);
        BigDecimal idd = new BigDecimal(ids);
        elemento = engEaPdfFacade.find(idd);

        return elemento;//retorna el elemento
    }
    
//metodo generado por implements Serializable
    @Override
    public void limpiar() {
        extendtime();
        setIdor(0);
        docname=null;
        elemento.setPdfComent(null);
        file=null;
        edit=false;
    }
//metodo generado por implements Serializable y actualiza en la base de datos
    @Override
    public void actualizar() {//Este metodo lo ocuparemos para actualizar la fecha de revision del cover y el numero de rev en la Ea cuando se agregue un cover y alguna parte despues del cover
        extendtime();
        List<EngEaPdf> tieneCoverR0 ;
        tieneCoverR0 = engEaPdfFacade.findByCoverR0pdf(elemento.getEagId(), "Cover R0.pdf");
        
        if (!tieneCoverR0.isEmpty()) {
            EngEaGeneral ea = eaFacade.find(new BigDecimal(elemento.getEagId()));
            ea.setAegDateRev(new Date());
            if(ea.getAegRevNum() == null)
                ea.setAegRevNum(new BigInteger("0"));
            else{
                int suma = ea.getAegRevNum().intValue()+1;
                ea.setAegRevNum(new BigInteger(String.valueOf(suma)));
            }
            eaFacade.edit(ea);
        }
    }
//metodo generado por implements Serializable
    @Override
    public void agregar() {
        
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
        
    }
    //actualiza el esta a enviado
    public void actualizarEstado(BigDecimal id){
        extendtime();
        elemento = engEaPdfFacade.find(id);
        elemento.setPdfEstatusEnviado("ENVIADO");
        engEaPdfFacade.edit(elemento);
        elemento = engEaPdfFacade.find(id);
        
    }
    
   //agrega archivo
    public void addfile() throws IOException {
        extendtime();
        List<EngEaPdf> tieneCoverR0 = new ArrayList<>();

        tieneCoverR0 = engEaPdfFacade.findByCoverR0pdf(elemento.getEagId(), "Cover R0.pdf");
//carga archivos ala base de datos
        if (tieneCoverR0.isEmpty() || docname.contains("Cover R0")) {
            try (InputStream input = file.getInputStream()) {
                Part uploadedFile = getFile();
                FilenameUtils.getName(getSubmittedFileName(uploadedFile));
                String fileName = FilenameUtils.getName(getSubmittedFileName(file));
                short var1;
                String nameFile = fileName.substring(0, fileName.lastIndexOf('.'));
                String mime = fileName.substring(fileName.lastIndexOf('.'), fileName.length());
                String[] formatos = new String[]{".pdf"};
                HttpServletRequest session = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
                String path = session.getServletContext().getRealPath("/pages/pdf/");
                String path2 = path.replace("\\", "/");
                for (int i = 0; i < formatos.length; i++) {
                    if (formatos[i].equals(mime) ) {
                        Files.copy(input, new File(path2 + "/" + nameFile + "" + mime + "").toPath());
                        Path ruta = Paths.get(path2 + "/" + nameFile + "" + mime + "");
                        String archivo = path2 + "/" + nameFile + "" + mime + "";
                        byte[] contenido = Files.readAllBytes(ruta);

                        HttpSession session2 = SessionBean.getSession();
                        elemento.setPdfUsrChr((String) session2.getAttribute("username"));
                        Calendar fechaIns = new GregorianCalendar();
                        elemento.setPdfDateChr(fechaIns.getTime());
                        elemento.setPdfFilename(fileName);
                        elemento.setPdfFile(contenido);
                        var1= (short) 0;
                        if(docname.equals("Cover R0")){
                          var1= (short) 1;  
                        }
                        elemento.setPdfType(var1);
                        elemento.setPdfEstatusEnviado("CARGADO");
                        engEaPdfFacade.create(elemento);
                        listado2.add(elemento);
                        archivomalo = false;
                        existecover = false;
                        actualizar();//metodo para actualizar la ea cuando se agregue un cover
                        elemento = new EngEaPdf();
                        deleteFile(archivo);
                        break;
                    }else{
                        FacesContext.getCurrentInstance().validationFailed();
                        archivomalo = true;
                    }

                }
            }

        } else {
            existecover = true;
            FacesContext.getCurrentInstance().validationFailed();

        }
    }
     //borra archivos en la base de datos 
    public static void deleteFile(String filename){       
        
              try{
                  File f = new File(filename);
                  while (f.exists()){
                   boolean bool = f.delete();
                   if(bool){
                       f.getName();
                   }
                  }
                  
              }
              catch(SecurityException e){
                Logger.getLogger(EaPdfBean.class.getName()).log(Level.SEVERE, null, e);
              }
              
     } 
    //busca el archivo en la bd y lo descarga
   public void recuperarBlob(String archivo,String id){
      
        extendtime();//extiende el tiempo de sesion 
           HttpServletResponse response =(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();           
           response.setContentType("application/pdf");//asigana el mime del archivo
           
           int bit = 512;//declara variable 
          
              int ids=Integer.parseInt(id);      // declara variable               
              BigDecimal idd = new BigDecimal(ids);//declare variable
              elements = engEaPdfFacade.find(idd);//asigna al elemento
              response.setHeader("Content-Disposition", "attachment; filename="+elements.getPdfFilename());
              try(InputStream in = new ByteArrayInputStream(elements.getPdfFile())) {
                  
               ServletOutputStream outs = response.getOutputStream();           
               while ((bit) >= 0) {
                   bit = in.read();
                   outs.write(bit);
               }
               outs.flush();
               outs.close();
               in.close();
               FacesContext.getCurrentInstance().getResponseComplete();
           }
       catch (IOException e) {//captura posibles errores
               Logger.getLogger(EaPdfBean.class.getName()).log(Level.SEVERE, null, e);
           } finally {//finally del catch
               FacesContext.getCurrentInstance().getResponseComplete();
           }     
      
   } 
     //metodo que obtiene en nombre del archivo
    public static String getSubmittedFileName(Part filePart) {
        String header = filePart.getHeader("content-disposition");
        if(header == null)
            return null;
        for(String headerPart : header.split(";"))
        {
            if(headerPart.trim().startsWith("filename"))
            {
                return headerPart.substring(headerPart.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
    
    //metodo generado por implements Serializable
    @Override
    public void eliminar(EngEaPdf elemento) {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }
//metodo generado por implements Serializable
    @Override
    public EngEaPdf nuevoElemento() {
        return new EngEaPdf();
    }

    public String getTitle() {
        return title;
    }
//get y set de variable
    public void setTitle(String title) {
        this.title = title;
    }
//get y set de variable
    public String getComents() {
        return coments;
    }
//get y set de variable
    public void setComents(String coments) {
        this.coments = coments;
    }
//get y set de variable
    public Part getFile() {
        return file;
    }
//get y set de variable
    public void setFile(Part file) {
        this.file = file;
    }
    
    
    
  //get y set de variable  
    public EngEaPdf getElements2() {
        return elements2;
    }
//get y set de variable
    public void setElements2(EngEaPdf elements2) {
        this.elements2 = elements2;
    }
//get y set de variable
    public EngEaPdf getElements() {
        return elements;
    }
//get y set de variable
    public void setElements(EngEaPdf elements) {
        this.elements = elements;
    }
//get y set de variable
    public String getDocname() {
        return docname;
    }
//get y set de variable
    public void setDocname(String docname) {
        this.docname = docname;
    }
   //get y set de variable 
    public Part getFileEa() {
        return fileEa;
    }
//get y set de variable
    public void setFileEa(Part fileEa) {
        this.fileEa = fileEa;
    }
    //get y set de variable
    public String getEsrid() {
        return esrid;
    }
//get y set de variable
    public void setEsrid(String esrid) {
        this.esrid = esrid;
    }
     //get y set de variable       
    public int getIdor() {
        return idor;
    }
//get y set de variable
    public void setIdor(int idor) {
        this.idor = idor;
    }
//get y set de variable
    public boolean isArchivomalo() {
        return archivomalo;
    }
//get y set de variable
    public void setArchivomalo(boolean archivomalo) {
        this.archivomalo = archivomalo;
    }
//get y set de variable
    public boolean isExistecover() {
        return existecover;
    }
//get y set de variable
    public void setExistecover(boolean existecover) {
        this.existecover = existecover;
    }
//get y set de variable
    public AdjuntosBean getAdjuntosBean() {
        return adjuntosBean;
    }
//get y set de variable
    public void setAdjuntosBean(AdjuntosBean adjuntosBean) {
        this.adjuntosBean = adjuntosBean;
    }
    
}
