 // To change this license header, choose License Headers in Project Properties.
 // To change this template file, choose Tools | Templates
 // and open the template in the editor.
package com.aecas.managed;// paquete manage

import com.aeroman.aees.entities.EngHoursVw;// importacion de clase
import com.aeroman.aees.facades.EngHoursVwFacade;// importacion de clase
import java.io.IOException;// libreria IOException
import java.io.Serializable;// libreria IOException
import java.util.ArrayList;// libreria IOException
import java.util.logging.Level;// libreria IOException
import java.util.logging.Logger;// libreria IOException
import javax.annotation.PostConstruct;// libreria IOException
import javax.ejb.EJB;// libreria IOException
import javax.faces.bean.ManagedBean;// libreria IOException
import javax.faces.bean.ViewScoped;// libreria IOException
import javax.faces.context.FacesContext;// libreria IOException
import javax.servlet.ServletOutputStream;// libreria IOException
import javax.servlet.http.HttpServletResponse;// libreria IOException
import org.apache.poi.hssf.usermodel.HSSFWorkbook;// libreria IOException

/**
 *
 * @author Saplic16
 */
//nombre de clase en mageBean
@ManagedBean(name = "engHorasIngViewBean")
@ViewScoped //tipo de clase
//clase ContAtasBean con extends al crud
public class EngHorasIngViewBean extends CrudBean<EngHoursVw> implements Serializable{

    /**
     * Creates a new instance of EngHorasIngViewBean
     */
    @EJB
    private EngHoursVwFacade engHoursVwFacade;//declaracion de clases Facade
    //metodo constructur super
    public EngHorasIngViewBean() {
        super();
    }

    //metodo generado por implements Serializable
    @Override
    //metodo constructor
    @PostConstruct
    void init() {
        elemento=new EngHoursVw();
        listado=new ArrayList<>();
    }
    
    public void cargarHorasCheck(Short idCheck){
        extendtime();
        listado=engHoursVwFacade.findByCheck(idCheck);
    }
    
    public void generarExcell(){
        try {
            extendtime();
                String nameExcel = "Eng_Hours" ;
                HSSFWorkbook excel = new HSSFWorkbook();
                HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
                response.setContentType("application/vnd.ms-excel");
                response.setHeader("Content-Disposition", "attachment; filename="+nameExcel+".xls");
                ServletOutputStream outs = response.getOutputStream();
                excel.write(outs);
                outs.flush();
                outs.close();
                FacesContext.getCurrentInstance().responseComplete();
            } catch (IOException ex) {
                Logger.getLogger(EngHorasIngViewBean.class.getName()).log(Level.SEVERE, null, ex);
                
            }
    
    
    }
    
//get y set de variable    
    public EngHoursVwFacade getEngHoursVwFacade() {
        return engHoursVwFacade;
    }
//get y set de variable
    public void setEngHoursVwFacade(EngHoursVwFacade engHoursVwFacade) {
        this.engHoursVwFacade = engHoursVwFacade;
    }
    //metodo generado por implements Serializable
    @Override
    void limpiar() {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }
//metodo generado por implements Serializable
    @Override
    void actualizar() {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }
//metodo generado por implements Serializable
    @Override
    void agregar() {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }
//metodo generado por implements Serializable
    @Override
    void eliminar(EngHoursVw elemento) {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }
//metodo generado por implements Serializable
    @Override
    EngHoursVw nuevoElemento() {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }

    
}
