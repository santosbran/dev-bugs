 // To change this license header, choose License Headers in Project Properties.
 // To change this template file, choose Tools | Templates
 // and open the template in the editor.
package com.aecas.managed;// paquete manage


import com.aees.session.SessionBean;// libreria Serializable
import com.aeroman.aees.entities.EngEaPdf;// importacion de clase
import javax.faces.bean.ViewScoped;// libreria Serializable
import java.io.Serializable;// libreria Serializable
import com.aeroman.aees.entities.EngInstructions;// importacion de clase
import com.aeroman.aees.entities.EngOrders;// importacion de clase
import com.aeroman.aees.facades.EngInstructionsFacade;// importacion de clase
import com.aeroman.aees.facades.Sequences;// importacion de clase
import java.io.ByteArrayInputStream;// libreria Serializable
import java.io.File;// libreria Serializable
import java.io.IOException;// libreria Serializable
import java.io.InputStream;// libreria Serializable
import java.math.BigInteger;// libreria Serializable
import java.nio.file.Files;// libreria Serializable
import java.nio.file.Path;// libreria Serializable
import java.nio.file.Paths;// libreria Serializable
import java.util.ArrayList;// libreria Serializable
import java.util.Date;// libreria Serializable
import java.util.List;// libreria Serializable
import java.util.logging.Level;// libreria Serializable
import java.util.logging.Logger;// libreria Serializable
import javax.annotation.PostConstruct;// libreria Serializable
import javax.ejb.EJB;// libreria Serializable
import javax.faces.application.FacesMessage;// libreria Serializable
import javax.faces.bean.ManagedBean;// libreria Serializable
import javax.faces.context.FacesContext;// libreria Serializable
import javax.servlet.ServletOutputStream;// libreria Serializable
import javax.servlet.http.HttpServletRequest;// libreria Serializable
import javax.servlet.http.HttpServletResponse;// libreria Serializable
import javax.servlet.http.HttpSession;// libreria Serializable
import javax.servlet.http.Part;// libreria Serializable
import org.apache.commons.io.FilenameUtils;// libreria Serializable
/**
 *
 * @author mac
 */
//nombre de clase en mageBean
@ManagedBean (name = "instructionsBean")
@ViewScoped //tipo de clase
//clase ContAtasBean con extends al crud
public class InstructionsBean extends CrudBean<EngInstructions> implements Serializable{
    @EJB
    private EngInstructionsFacade engInstructionsFacade2; //declaracion de clases Facade
    private EngEaPdf elements;//declaracion de variable
    private int ida;//declaracion de variable
    private String title;//declaracion de variable
    private String coments;//declaracion de variable
    private Part file;//declaracion de variable
    protected transient List<EngInstructions> listado2;//declaracion de variable

    public EngEaPdf getElements() {
        return elements;
    }

    public void setElements(EngEaPdf elements) {
        this.elements = elements;
    }

    
    @Override//metodo generado por implements Serializable    
    @PostConstruct//metodo constructor
    public void init() {//metodo generado por implements Serializable
        elemento = new EngInstructions();
        listado=engInstructionsFacade2.findAll();
        elemento.setEosIdord(new EngOrders());
        this.edit=false;  
        Sequences sequences=new Sequences();
        int iid=sequences.maxcodinstructions();
        ida=iid;
    }

    public Object findSelect(String id){
        extendtime();
        elemento=new EngInstructions();
        listado=engInstructionsFacade2.findAll();
                    
        
        List<EngInstructions> listmex=new ArrayList<>();
        int x = 0;
        while (x < listado.size()) {
            EngInstructions company = (EngInstructions) listado.get(x);
            BigInteger num = new BigInteger(id);
            if (company.getInsId().equals(num)) {
                listmex.add(company);

            } 
            x++;
        }
        listado2=listmex;
                    
                    return elemento;
    }
    
    @Override
    public void limpiar() {//metodo generado por implements Serializable
        extendtime();
       this.elemento = new EngInstructions();
        edit = false;
    }
    
    public void buscarlista(long ideo){
        extendtime();
        listado=engInstructionsFacade2.findByeoid(ideo);   
    }
    
    
    @Override
    public void actualizar() {//metodo generado por implements Serializable
        extendtime();
        if (engInstructionsFacade2.find(elemento.getInsId()) != null) {
            HttpSession pauser = SessionBean.getSession();
            String user = (String) pauser.getAttribute("username");

            elemento.setInsUserUpd(user);
            elemento.setInsDateUpd(new Date());
            engInstructionsFacade2.edit(elemento);
            this.edit = false;
            elemento = new EngInstructions();
        } else {
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El elemento que esta tratando de editar no existe en la base de datos"));
        }      
    }

    @Override
    public void agregar() {//metodo generado por implements Serializable
        extendtime();
        
       
        
        if(edit){
        actualizar();
        
        }else{
            
        try {
            
       addfile();
       
        } catch (IOException ex) {
            Logger.getLogger(InstructionsBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        }
        
        
    }
    
    public void addfile() throws IOException {
        extendtime();
        HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
       
       String path0 = request.getServletContext().getRealPath("/pages/pdf/");
       String path=path0.replace("\\", "/");
        Integer idd=ida;
            elemento.setInsId(idd);
  
      try (InputStream input = file.getInputStream()) {
          Part uploadedFile=getFile();
          FilenameUtils.getName(getSubmittedFileName(uploadedFile));
          String fileName=FilenameUtils.getName(getSubmittedFileName(file));
          String namef = fileName.substring(0, fileName.lastIndexOf('.'));
          String mime = fileName.substring(fileName.lastIndexOf('.'), fileName.length());
          String[] formatos = new String[]{".PDF", ".PNG", ".JPG",".JPEG",".GIF", ".DOC", ".DOCX", ".TXT",".PNG",".XLS",".pdf", ".png", ".jpg",".jpeg",".gif", ".doc", ".docx", ".txt",".PNG",".xls"};
          
            for (int i = 0; i < formatos.length; i++) {
                if (formatos[i].equals(mime) && engInstructionsFacade2.find(elemento.getInsId()) != null) {
                    FacesContext.getCurrentInstance().validationFailed();
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El elemento que esta tratnado de editar no existe en la base de datos"));
                } else {
                    Files.copy(input, new File(path + "/" + namef + "" + mime + "").toPath());
                    Path ruta = Paths.get(path + "/" + namef + "" + mime + "");

                    byte[] contenido;
                    contenido = Files.readAllBytes(ruta);

                    elemento.setDocBody(contenido);
                    HttpSession pauser = SessionBean.getSession();
                    String user = (String) pauser.getAttribute("username");

                    elemento.setInsUserUpd(user);
                    elemento.setInsDateUpd(new Date());
                    elemento.setInsUserIns(user);
                    elemento.setInsDateIns(new Date());
                    engInstructionsFacade2.create(elemento);
                    listado.add(elemento);

                    this.edit = false;

                    elemento = new EngInstructions();
                    Files.delete(ruta);
                    ida++;
                    break;
                }

                

            }

        }

    }
public void recuperarBlob(String id){
    extendtime();
      
       
           HttpServletResponse response =(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();           
           response.setContentType("application/pdf");
           response.setHeader("Content-Disposition", "attachment; filename=container.pdf");
           int bit = 512;
          try {
              int ids=Integer.parseInt(id);                    
              elemento = engInstructionsFacade2.find(ids);
               InputStream in = new ByteArrayInputStream(elemento.getDocBody());
               ServletOutputStream outs = response.getOutputStream();           
               while ((bit) >= 0) {
                   bit = in.read();
                   outs.write(bit);
               }
               outs.flush();
               outs.close();
               in.close();
           } catch (IOException | NumberFormatException e) {
               Logger.getLogger(InstructionsBean.class.getName()).log(Level.SEVERE, null, e);
           } 
      
   }

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
    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }
    @Override
    public void eliminar(EngInstructions elemento) {//metodo generado por implements Serializable
        extendtime();
        if(engInstructionsFacade2.find(elemento.getInsId())!=null){
        engInstructionsFacade2.remove(elemento);
        listado.remove(elemento);
        }
    }

    @Override
    public EngInstructions nuevoElemento() {//metodo generado por implements Serializable
        return new EngInstructions();
    }

    
    public List<EngInstructions> getListado2() {//get y set de variable
        return listado2;
    }

    public void setListado2(List<EngInstructions> listado2) {//get y set de variable
        this.listado2 = listado2;
    }
    public int getIda() {//get y set de variable
        return ida;
    }

    public void setIda(int ida) {//get y set de variable
        this.ida = ida;
    }

    public String getTitle() {//get y set de variable
        return title;
    }

    public void setTitle(String title) {//get y set de variable
        this.title = title;
    }

    public String getComents() {//get y set de variable
        return coments;
    }

    public void setComents(String coments) {//get y set de variable
        this.coments = coments;
    }
    
}
