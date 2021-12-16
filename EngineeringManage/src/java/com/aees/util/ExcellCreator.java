/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aees.util;

import com.aeroman.aees.entities.EngHrsIns;
import com.aeroman.aees.entities.EngTabEsrnwsVw;
import com.aeroman.aees.entities.Horas;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;



/**
 *
 * @author saplic16
 */
public class ExcellCreator {
    
    private String arial = "Arial";

    public ExcellCreator() {
        super();
        
    }

    public HSSFWorkbook excelCreator() {
        return  new HSSFWorkbook();
    }

    public HSSFWorkbook generateByHoras(HSSFWorkbook excel,List<EngHrsIns> list, List<Horas> hourList, String cola, String workOrder,List<EngTabEsrnwsVw> esr, String company) throws IOException{
       
        HSSFSheet sheet = excel.createSheet("Hours Report");
        if(company.equals("FAS")){
        int[] widthColumn = {1000,4500, 4500, 4500, 24000, 6000, 2000, 6000};

        //ajuste del ancho de las celdas
        for (int i = 0; i < widthColumn.length; i++) {
            sheet.setColumnWidth(i, widthColumn[i]);
        }
        }else{
        int[] widthColumn = {1000, 4500, 4500, 24000, 6000, 2000, 6000};

        //ajuste del ancho de las celdas
        for (int i = 0; i < widthColumn.length; i++) {
            sheet.setColumnWidth(i, widthColumn[i]);
        }
        }
        HSSFPalette palette = excel.getCustomPalette();
        HSSFColor myColor = palette.findSimilarColor((byte)15,(byte) 25,(byte) 87);
        
        //Estilo de fuente
        HSSFFont font = excel.createFont();        
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setColor(HSSFColor.WHITE.index);
        font.setFontName(arial);
        font.setFontHeight((short) (11 * 20));
        
        HSSFFont font2 = excel.createFont();                
        font2.setFontName(arial);
        font2.setFontHeight((short) (11 * 20));
        
        HSSFFont font3 = excel.createFont();                
        font3.setFontName(arial);
        font3.setColor(HSSFColor.WHITE.index);
        font3.setFontHeight((short) (22 * 20));
                      
        //stilo de la celda        
        HSSFCellStyle marco = excel.createCellStyle();
        marco.setFillForegroundColor(myColor.getIndex());
        marco.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);      
        marco.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        marco.setBorderTop(HSSFCellStyle.BORDER_THIN);
        marco.setBorderRight(HSSFCellStyle.BORDER_THIN);
        marco.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        marco.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        marco.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        marco.setWrapText(true);
        marco.setFont(font);
        
        HSSFCellStyle header = excel.createCellStyle();
        header.setFillForegroundColor(myColor.getIndex());
        header.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);             
        header.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        header.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        header.setWrapText(true);
        header.setFont(font);
        
        HSSFCellStyle title = excel.createCellStyle();
        title.setFillForegroundColor(myColor.getIndex());
        title.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);             
        title.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        title.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        
        title.setWrapText(true);
        title.setFont(font);
        
        HSSFCellStyle marc = excel.createCellStyle();
        marc.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        marc.setBorderTop(HSSFCellStyle.BORDER_THIN);
        marc.setBorderRight(HSSFCellStyle.BORDER_THIN);
        marc.setBorderLeft(HSSFCellStyle.BORDER_THIN);          
        marc.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        marc.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        marc.setWrapText(true);
        marc.setFont(font);

        HSSFCellStyle normal = excel.createCellStyle();
        normal.setBorderBottom(HSSFCellStyle.BORDER_THIN);        
        normal.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        normal.setWrapText(true);
        normal.setFont(font2);
        
        HSSFCellStyle normal2 = excel.createCellStyle();
        normal2.setBorderRight(HSSFCellStyle.BORDER_THIN); 
        normal2.setBorderBottom(HSSFCellStyle.BORDER_THIN);        
        normal2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        normal2.setWrapText(true);
        normal2.setFont(font2);
        
        HSSFCellStyle normal3 = excel.createCellStyle();
        normal3.setBorderBottom(HSSFCellStyle.BORDER_THIN);        
        normal3.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        normal3.setWrapText(true);
        normal3.setFont(font2);
        normal3.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        
        HSSFCellStyle normal4 = excel.createCellStyle();
        normal4.setBorderBottom(HSSFCellStyle.BORDER_THIN);        
        normal4.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        normal4.setWrapText(true);
        normal4.setFont(font);
        normal4.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        
        HSSFCellStyle cal = excel.createCellStyle();
        cal.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
        cal.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND); 
        cal.setBorderBottom(HSSFCellStyle.BORDER_THIN);        
        cal.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        cal.setWrapText(true);
        cal.setFont(font);
        cal.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        
        
        
        HSSFRow row;//fila vacia
        HSSFCell cell;
        
        row = sheet.createRow(1);
        row.setHeight((short) (22 * 20));
        cell = row.createCell(1);
        cell.setCellStyle(title);
        cell.setCellValue("ENGINEERING HOURS");   
        //validacion para que el titulo se ajuste a la tabla de datos
        if(company.equals("FAS")){ 
        sheet.addMergedRegion(new CellRangeAddress(
                
                1, //first row (0-based)
                1, //last row  (0-based)
                1, //first column (0-based)
                7  //last column  (0-based)
        ));
        }else{
        sheet.addMergedRegion(new CellRangeAddress(
                
                1, //first row (0-based)
                1, //last row  (0-based)
                1, //first column (0-based)
                6  //last column  (0-based)
        ));
        }

        row = sheet.createRow(3);
        cell= row.createCell(1);
        cell.setCellStyle(header);
        cell.setCellValue("WO: " + workOrder);
        
        cell= row.createCell(2);
        cell.setCellStyle(header);
        cell.setCellValue("Tail: " + cola);
        
        //if para la tabla central y la fecha
        if(company.equals("FAS")){ 
        cell= row.createCell(5);
        cell.setCellStyle(header);
        DateFormat df= new SimpleDateFormat("dd/MM/yyyy h:mm a");
        String actualDate= df.format(new Date());
        cell.setCellValue("Date: "+actualDate);        
        sheet.addMergedRegion(new CellRangeAddress(
                3, //first row (0-based)
                3, //last row  (0-based)
                5, //first column (0-based)
                7  //last column  (0-based)
        ));
        
        row = sheet.createRow(5);//fila vacia
        createCell(row, 1, marco, "Item");
        createCell(row, 2, marco, "No. ESR");
        createCell(row, 3, marco, "Jobcard");
        createCell(row, 4, marco, "Description");
        createCell(row, 5, marco, "Eng. Action");
        createCell(row, 6, marco, "Hours");
        createCell(row, 7, marco, "Document Issued");
                
        int position=6;
        int item=1;
        double sumHours=0;
        for(Horas h: hourList){

            row = sheet.createRow(position);//fila vacia
            cell= row.createCell(1);
            cell.setCellValue(item);
            cell.setCellStyle(normal3);

            cell= row.createCell(2);
            cell.setCellValue(h.getEsr());
            cell.setCellStyle(normal);
            
            cell= row.createCell(3);
            cell.setCellStyle(normal);
            cell.setCellValue(h.getJobcard());
            

            cell= row.createCell(4);
            cell.setCellValue(h.getDescripcion());
            cell.setCellStyle(normal);
            
            cell= row.createCell(5); 
            cell.setCellStyle(normal);            
            String actionName="";
            BigDecimal c=new BigDecimal(h.getComboindex()==null?"1":h.getComboindex()==""?"1":h.getComboindex());
            
            for(EngHrsIns ehi:list){                    
                if(ehi.getEhiId().equals(c)){
                    actionName= ehi.getEhiName();                                                    
                }
            }            
            cell.setCellValue(actionName);             
            
            cell= row.createCell(6);
            cell.setCellStyle(normal3);
            cell.setCellValue(h.getEafacturar().toString());

            cell= row.createCell(7);
            cell.setCellStyle(normal2);
            if (!esr.isEmpty()) {
                for(EngTabEsrnwsVw lsTabEsr : esr){
                    if(lsTabEsr.getReqMessageid().toString().equals(h.getIdesr())){
                        cell.setCellValue(lsTabEsr.getNumata());
                    }
                }                
            }
        
            position++;
            item++;
            sumHours+=Double.parseDouble(h.getEafacturar().toString());
        }
                        
        row = sheet.createRow(position+1);//fila vacia
        cell= row.createCell(1);
        cell.setCellStyle(header);
        cell= row.createCell(2);
        cell.setCellStyle(header);
        cell= row.createCell(3);
        cell.setCellStyle(header);
        cell= row.createCell(4);
        cell.setCellStyle(header);
        cell= row.createCell(5);
        cell.setCellStyle(marco);
        cell.setCellValue("TOTAL ENG. HOURS:");                
        cell= row.createCell(6);
        cell.setCellStyle(marco);
        cell.setCellValue(sumHours);        
        cell= row.createCell(7);
        cell.setCellStyle(header);
        }
        else{
        cell= row.createCell(4);
        cell.setCellStyle(header);
        DateFormat df= new SimpleDateFormat("dd/MM/yyyy h:mm a");
        String actualDate= df.format(new Date());
        cell.setCellValue("Date: "+actualDate);        
        sheet.addMergedRegion(new CellRangeAddress(
                3, //first row (0-based)
                3, //last row  (0-based)
                4, //first column (0-based)
                6  //last column  (0-based)
        ));
        row = sheet.createRow(5);//fila vacia
        createCell(row, 1, marco, "Item");
        createCell(row, 2, marco, "No. ESR");
        createCell(row, 3, marco, "Description");
        createCell(row, 4, marco, "Eng. Action");
        createCell(row, 5, marco, "Hours");
        createCell(row, 6, marco, "Document Issued");
              
        int position=6;
        int item=1;
        double sumHours=0;
        for(Horas h: hourList){

            row = sheet.createRow(position);//fila vacia
            cell= row.createCell(1);
            cell.setCellValue(item);
            cell.setCellStyle(normal3);

            cell= row.createCell(2);
            cell.setCellValue(h.getEsr());
            cell.setCellStyle(normal);

            cell= row.createCell(3);
            cell.setCellValue(h.getDescripcion());
            cell.setCellStyle(normal);
            
            cell= row.createCell(4); 
            cell.setCellStyle(normal);            
            String actionName="";
            BigDecimal c=new BigDecimal(h.getComboindex()==null?"1":h.getComboindex()==""?"1":h.getComboindex());
            
            for(EngHrsIns ehi:list){                    
                if(ehi.getEhiId().equals(c)){
                    actionName= ehi.getEhiName();                                                    
                }
            }            
            cell.setCellValue(actionName);             
            
            cell= row.createCell(5);
            cell.setCellStyle(normal3);
            cell.setCellValue(h.getEafacturar().toString());

            cell= row.createCell(6);
            cell.setCellStyle(normal2);
            if (!esr.isEmpty()) {
                for(EngTabEsrnwsVw lsTabEsr : esr){
                    if(lsTabEsr.getReqMessageid().toString().equals(h.getIdesr())){
                        cell.setCellValue(lsTabEsr.getNumata());
                    }
                }                
            }
        
            position++;
            item++;
            sumHours+=Double.parseDouble(h.getEafacturar().toString());
        }
                        
        row = sheet.createRow(position+1);//fila vacia
        cell= row.createCell(1);
        cell.setCellStyle(header);
        cell= row.createCell(2);
        cell.setCellStyle(header);
        cell= row.createCell(3);
        cell.setCellStyle(header);
        cell= row.createCell(4);
        cell.setCellStyle(marco);
        cell.setCellValue("TOTAL ENG. HOURS:");                
        cell= row.createCell(5);
        cell.setCellStyle(marco);
        cell.setCellValue(sumHours);        
        cell= row.createCell(6);
        cell.setCellStyle(header);
        }
        System.out.println(" v.v.v.v.v.v.v.v " + company);
        return excel;
    }
    
    public void createCell(HSSFRow row,int rowNumber, HSSFCellStyle style, String value){
        HSSFCell cell;
        cell= row.createCell(rowNumber);
        cell.setCellStyle(style);
        cell.setCellValue(value);
    }
}
