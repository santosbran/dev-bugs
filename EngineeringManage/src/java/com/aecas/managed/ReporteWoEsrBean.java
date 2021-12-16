/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aecas.managed;

import com.aees.session.SessionBean;
import com.aeroman.aees.entities.CargarEsrWo;
import com.aeroman.aees.entities.EngCargaEsrWo;
import com.aeroman.aees.facades.Sequences;
import java.io.FileInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/**
 *
 * @author saplic
 */
@ManagedBean(name = "reporteWoEsrBean")
@ViewScoped
public class ReporteWoEsrBean extends CrudBean<EngCargaEsrWo> implements Serializable {

    private String fechaini;
    private String fechafin;

    @Override
    @PostConstruct
    void init() {
        elemento = new EngCargaEsrWo();
    }

    public void excelReport() {
        extendtime();
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        /* ****************************************
         *                                         *
         *                                         *
         *      GENERACION DEL REPORTE EN EXCEL    *
         *                                         *
         *                                         *
         * ****************************************/
        try {

            String fechaIni = fechaini;
            String fechaFin = fechafin;

            ServletContext sc = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String path0 = sc.getRealPath("/pages/plantillas/ReporteESRWO.xlt");
            String ruta = path0.replace("\\", "/");

            if (ruta == null) {
                // resources en un .war (JBoss, WebLogic)
                java.net.URL url;
                //archivo de ejemplo
                url = sc.getResource("/pages/plantillas/ReporteESRWO.xlt");
                ruta = url.getPath();
            }
            Sequences sec = new Sequences();
            HttpSession sessions = SessionBean.getSession();
            String iduser = sessions.getAttribute("username").toString();
            List<CargarEsrWo> datos = sec.report(iduser);
            String estado;

            FileInputStream inputStream = new FileInputStream(ruta);//cargarmos una platilla
            POIFSFileSystem fs = new POIFSFileSystem(inputStream);
            HSSFWorkbook reporte = new HSSFWorkbook(fs, true);

            HSSFSheet sheet = reporte.getSheet("Sheet1");
            HSSFRow row;
            HSSFCell cell;
            int rowIndex = 7;

            row = sheet.getRow(3);
            cell = row.createCell((short) 9);
            cell.setCellValue(iduser);

            row = sheet.getRow(4);
            cell = row.createCell((short) 4);
            cell.setCellValue(fechaIni);
            cell = row.createCell((short) 6);
            cell.setCellValue(fechaFin);

            for (int i = 0; i < datos.size(); i++) {

                row = sheet.getRow(4);
                cell = row.createCell((short) 9);
                cell.setCellValue((String) datos.get(i).getFecha());

                row = sheet.getRow(5);
                cell = row.createCell((short) 9);
                cell.setCellValue((String) datos.get(i).getHora());

                row = sheet.createRow(rowIndex++);

                cell = row.createCell((short) 0);
                cell.setCellValue((String) datos.get(i).getCargaRegistry());

                cell = row.createCell((short) 1);
                cell.setCellValue((String) datos.get(i).getCargaWo());

                cell = row.createCell((short) 2);
                cell.setCellValue((String) datos.get(i).getCargaWoStd());

                cell = row.createCell((short) 3);
                cell.setCellValue((String) datos.get(i).getCargaCierrewo());

                cell = row.createCell((short) 4);
                cell.setCellValue((String) datos.get(i).getCargaNumEsr());

                cell = row.createCell((short) 5);
                cell.setCellValue((String) datos.get(i).getCargaIng());

                cell = row.createCell((short) 6);
                cell.setCellValue((String) datos.get(i).getCargaCstmEsr());

                cell = row.createCell((short) 7);
                cell.setCellValue((String) datos.get(i).getCargaStdEsr());

                estado = (String) datos.get(i).getCargaStdCode();

                if (("C").equals(estado.trim()) || ("NFA").equals(estado.trim()) || ("FDP").equals(estado.trim())) {
                    cell = row.createCell((short) 8);
                    cell.setCellValue((String) datos.get(i).getCargaCrealEsr());
                }

                cell = row.createCell((short) 9);
                cell.setCellValue((String) datos.get(i).getCargaOntime());

            }
            response.setContentType("application/xls");
            response.setHeader("Content-Disposition", "attachment; filename=ReporteESRWO.xls");
            ServletOutputStream outs = response.getOutputStream();
            reporte.write(outs);
            outs.flush();
            outs.close();

        } catch (Exception e) {
            Logger.getLogger(ReporteWoEsrBean.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    @Override
    void limpiar() {
        listado2 = new ArrayList<>(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void actualizar() {
        fechaini = "duplicidad"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void agregar() {
        fechafin= "duplicidad2";
    }

    @Override
    void eliminar(EngCargaEsrWo elemento) {
        listado.add(elemento);
    }

    @Override
    EngCargaEsrWo nuevoElemento() {
        return listado.get(0);
    }

    public String getFechaini() {
        return fechaini;
    }

    public void setFechaini(String fechaini) {
        this.fechaini = fechaini;
    }

    public String getFechafin() {
        return fechafin;
    }

    public void setFechafin(String fechafin) {
        this.fechafin = fechafin;
    }
}
