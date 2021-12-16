/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aees.util;

/**
 *
 * @author mac
 */

import java.io.ByteArrayInputStream;
import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;

import org.docx4j.TraversalUtil.CallbackImpl;
import javax.xml.bind.JAXBElement;
import org.docx4j.TraversalUtil;
import org.docx4j.XmlUtils;
import org.docx4j.jaxb.Context;
import org.docx4j.model.datastorage.migration.VariablePrepare;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.Part;
import org.docx4j.openpackaging.parts.PartName;
import org.docx4j.openpackaging.parts.WordprocessingML.HeaderPart;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.openpackaging.parts.relationships.Namespaces;
import org.docx4j.openpackaging.parts.relationships.RelationshipsPart;
import org.docx4j.relationships.Relationship;
import org.docx4j.wml.BooleanDefaultTrue;
import org.docx4j.wml.CTFFCheckBox;
import org.docx4j.wml.CTFFData;
import org.docx4j.wml.CTFFName;
import org.docx4j.wml.ContentAccessor;
import org.docx4j.wml.ObjectFactory;
import org.docx4j.wml.Tbl;
import org.docx4j.wml.Tr;
import org.docx4j.wml.TcPrInner.VMerge;
import org.docx4j.wml.Tc;
import org.docx4j.wml.TcPr;
import org.docx4j.openpackaging.contenttype.ContentType;
import org.docx4j.openpackaging.exceptions.Docx4JException;

import org.docx4j.openpackaging.parts.WordprocessingML.AlternativeFormatInputPart;
import org.docx4j.wml.CTAltChunk;

public class DocxGenerator
{
    private ObjectFactory factory;
    
    //reemplaza las variables que encuentra en el documento
    public void reemplazarVariables(WordprocessingMLPackage wordMLPackage, List<List<String>> variables)throws IOException{        
        try {
            VariablePrepare.prepare(wordMLPackage);
            MainDocumentPart docPart = wordMLPackage.getMainDocumentPart();
            RelationshipsPart relationPart = wordMLPackage.getMainDocumentPart().getRelationshipsPart();
            Relationship relationship = relationPart.getRelationshipByType(Namespaces.HEADER);
            Part part = relationPart.getPart(relationship);
            part.setPartName(new PartName("/word/header1.xml"));
            HeaderPart headePart = (HeaderPart) part;
            HashMap<String, String> maps = new HashMap<>();
            for(List valores : variables){
                maps.put(valores.get(0).toString(), valores.get(1).toString());
            }
            docPart.variableReplace(maps);
            headePart.variableReplace(maps);
        } catch (Exception ex) {
            Logger.getLogger(DocxGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 

    private static List<Object> getAllElementFromObject(Object obj, Class<?> toSearch) {
        Object objTemp = obj;
        List<Object> result = new ArrayList();
        if (objTemp instanceof JAXBElement)
            objTemp = ((JAXBElement<?>) objTemp).getValue();
        if (objTemp.getClass().equals(toSearch))
            result.add(objTemp);
        else if (objTemp instanceof ContentAccessor) {
            List<?> children = ((ContentAccessor) objTemp).getContent();
            for (Object child : children) {
                result.addAll(getAllElementFromObject(child, toSearch));
            }
        }
        return result;
    }        
    
    public void generarDocumento(String path, HttpServletResponse response, List checkboxes, List<List<String>> variables) throws IOException{        
        try {
            String inputfilepath = path;
            WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(new java.io.File(inputfilepath));
            MainDocumentPart documentPart = wordMLPackage.getMainDocumentPart();
            Finder finder = new Finder(CTFFData.class);
            tablaDinamica(documentPart, wordMLPackage);
            new TraversalUtil(documentPart.getContent(), finder);
            BooleanDefaultTrue ischk = new BooleanDefaultTrue();
            ischk.setVal(true);
            String chk = "";
            for (Object o : finder.results) {
                Object o2 = XmlUtils.unwrap(o);
                CTFFData names = (CTFFData)o2;
                List<JAXBElement<?>> calcOnExit = names.getNameOrEnabledOrCalcOnExit();
                for(Object o3 : calcOnExit){
                    Object o4 = XmlUtils.unwrap(o3);
                    if(o4 instanceof CTFFName){
                        CTFFName name = (CTFFName)o4;                    
                        chk = name.getVal();
                    }
                    if(o4 instanceof CTFFCheckBox && checkboxes.contains(chk)){
                            CTFFCheckBox ch = (CTFFCheckBox)o4;
                            ch.setChecked(ischk);
                    }
                }
            }
            if(!variables.isEmpty()){             
                reemplazarVariables(wordMLPackage, variables);
            }
            response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
            response.setHeader("Content-disposition", "attachment;filename=MyDocument.doc");
            wordMLPackage.save(response.getOutputStream());
        } catch (Docx4JException ex) {
            Logger.getLogger(DocxGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void tablaDinamica(MainDocumentPart documentPart, WordprocessingMLPackage wordMLPackage){
        Finder finder = new Finder(Tbl.class);
        new TraversalUtil(documentPart.getContent(), finder);        
        Tbl tbl;
        int validacion = 0;
        for (Object table : finder.results) {
                tbl = (Tbl)table;             
                factory = Context.getWmlObjectFactory(); 
            while(validacion<=0){
                List rows = getAllElementFromObject(tbl, Tr.class);                                 
                tbl.getContent().remove((Tr) rows.get(2)); 
                tbl.getContent().remove((Tr) rows.get(3));
                for(int i = 0; i < 3; i++){
                    Tr tableRow = factory.createTr(); 
                    addTableCell(tableRow, "Test0", wordMLPackage,0);
                    addTableCell(tableRow, "Test1", wordMLPackage,0);
                    addTableCell(tableRow, "Test2", wordMLPackage,0);
                    addTableCell(tableRow, "Test3", wordMLPackage,0);
                    tbl.getContent().add(tableRow);   
                }
                tbl.getContent().add((Tr) rows.get(3));
                validacion ++;
            }
        }        
    }

    private void addTableCell(Tr tableRow, String content, WordprocessingMLPackage wordMLPackage, int mergeVal) {  
        Tc tableCell = factory.createTc();  
        VMerge merge = new VMerge();
        TcPr tableCellProperties = new TcPr();  
        if(mergeVal > 1){
            merge.setVal(String.valueOf(mergeVal));
            tableCellProperties.setVMerge(merge);
            tableCell.setTcPr(tableCellProperties);
        }
        tableCell.getContent().add(wordMLPackage.getMainDocumentPart().createParagraphOfText(content));  
        tableRow.getContent().add(tableCell);  
    }
    
    public static class Finder extends CallbackImpl {
        protected Class<?> typeToFind;
        protected Finder(Class<?> typeToFind) {
            this.typeToFind = typeToFind;
        }
          private List<Object> results = new ArrayList(); 
          @Override
          public List<Object> apply(Object o) {
              if (o.getClass().equals(typeToFind)) {
                  results.add(o);
              }
              return results;
          }
    }  
    
    private List<Relationship> getRelationshipsOfType(WordprocessingMLPackage document, String type) {
        List<Relationship> allRelationhips = document
                .getMainDocumentPart()
                .getRelationshipsPart()
                .getRelationships()
                .getRelationship();
        List<Relationship> headerRelationships = new ArrayList<>();
        for (Relationship r : allRelationhips) {
            if (r.getType().equals(type)) {
                headerRelationships.add(r);
            }
        }
        return headerRelationships;
    }
    
    public void generarDocRep(HttpServletResponse response, HashMap<String,String> variables, String outname, byte[] datas) throws IOException{
      
        try {
            ByteArrayInputStream datoss = new ByteArrayInputStream(datas);
            WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(datoss);
            MainDocumentPart documentPart = wordMLPackage.getMainDocumentPart();
            
            RelationshipsPart rp = wordMLPackage.getMainDocumentPart().getRelationshipsPart();
            /* funciona para obtener el encabezado en especifico para EA_COVER.docx y EA_PARTS.docx */
            List<Relationship> headerRelationships = getRelationshipsOfType(wordMLPackage, Namespaces.HEADER);
            Relationship headerR = headerRelationships.get(0);
            //Relationship rel = rp.getRelationshipByID("rId9");
            //Part p = rp.getPart(rel);    
            HeaderPart header = (HeaderPart) rp.getPart(headerR.getId());
            //HeaderPart header = (HeaderPart) p;
         String body = "<html><body style=\"font-family:Arial;font-size:6.5;\" >";
         String style = "border-spacing:0;font-weight:bold;font-family:Arial;font-size:12px;border-collapse:collapse;border-top:1px solid black;border-bottom:1px solid black;border-right:1px solid black;border-left:1px solid black;";
         String html = "<table style=\"width:100%;"+style+"\"><tr>\n" + 
                       "<td style=\"background-color:#D8D8D8;width:61px;border-right:1px solid black;font-size:13px;\">Type:</td>\n" + 
                       "<td>Repair:</td><td><input type=\"checkbox\" id=\"ch\" /></td><td>,</td>\n" + 
                       "<td>Mod/Alt:</td><td><input type=\"checkbox\" id=\"ch\" /></td><td>,</td>\n" + 
                       "<td>Inspection:</td><td><input type=\"checkbox\" id=\"ch\" /></td><td>,</td>\n" + 
                       "<td>Other:</td><td colspan=\"2\">____________________________________________________</td>\n" + 
                       "</tr></table><br>";  
         
         String tabCat = "<table style=\"font-weight:bold;font-family:Arial;font-size:12px;border-collapse:collapse;\" ><tr><td><input type=\"checkbox\" id=\"ch\" /></td><td>Category A</td></tr>" +
                         "<tr><td><input type=\"checkbox\" style=\"\" id=\"ch\" /></td><td>Category B</td></tr>" +
                         "<tr><td><input type=\"checkbox\" id=\"ch\" /></td><td>Category C</td></tr></table>";
         
         String tabCls = "<table style=\"font-weight:bold;font-family:Arial;font-size:12px;border-collapse:collapse;\" ><tr><td><input type=\"checkbox\" id=\"ch\" /></td><td>Major</td><td><input type=\"checkbox\" id=\"ch\" /></td><td>Minor</td></tr>" +
                         "<tr><td colspan=\"4\">In accordance with: <p style=\"text-decoration:underline;\">Operator's classification procedure</p></td></tr>" +                         
                         "</table>"; 
         
         String dte = "<table style=\"font-weight:bold;font-family:Arial;font-size:12px;border-collapse:collapse;border-spacing:0;\"><tr><td><input type=\"checkbox\" id=\"ch\" /></td><td>Stage 1 DTE Due in_______.</td></tr>" +
                      "<tr><td><input type=\"checkbox\" id=\"ch\" /></td><td>Stage 2 (Follow-Up Action)</td></tr>" +
                      "<tr><td><input type=\"checkbox\" id=\"ch\" /></td><td>Stage 3 (Follow-Up Action)</td></tr>" +
                      "<tr><td colspan=\"2\">Other ______________________.</td></tr></table>";
            
             html += "<table border=\"1\" style=\"width:100%;"+style.replace("font-weight:bold;", "")+"\">\n" + 
                     "<tr style=\"background-color:#D8D8D8;font-size:13px;font-weight:bold;\" ><td colspan=\"2\">Current FC & FH</td><td>Category:</td><td>Classification:</td><td>DTE Approval Stage:</td><td>AD</td></tr>\n" + 
                     "<tr height=\"45\" ><td width=\"37\" style=\"text-align:center;font-weight:bold;\">FC:</td><td width=\"106\" style=\"text-align:center;\" ></td><td width=\"120\" rowspan=\"2\"> "+tabCat+" </td><td rowspan=\"2\" width=\"160\"> "+tabCls+" </td><td rowspan=\"2\"> "+dte+" </td><td width=\"80\" rowspan=\"2\" style=\"text-align:center;\"> <input type=\"checkbox\" id=\"ch\" /> </td></tr>\n" + 
                     "<tr><td style=\"text-align:center;font-weight:bold;\">FH:</td><td style=\"text-align:center;\"></td></tr>\n" + 
                     "</table><br>";
             
         html += "<table style=\"font-family:Arial;font-size:12px;border-collapse:collapse;width:100%;"+style.replace("font-weight:bold;", "")+"\">" +
                 "<tr><td style=\"border-bottom:1px solid black;background-color:#D8D8D8;width:35px;text-align:center;\"><input type=\"checkbox\" id=\"ch\" style=\"width:10;height:8.75\" /></td><td style=\"border-bottom:1px solid black;background-color:#D8D8D8;font-weight:bold;\"> Follow-Up Action (unless otherwise specified, threshold or life time limitation are from date or FC or FH or approval):</td></tr>" +
                 "<tr height=\"43\"><td colspan=\"2\"></td></tr></table>";    
             
         body += html;
         body += "</body></html>";
         AlternativeFormatInputPart afiPart = new AlternativeFormatInputPart(new PartName("/hw.html"));
         afiPart.setBinaryData(body.getBytes());
         afiPart.setContentType(new ContentType("text/html"));
         Relationship altChunkRel = wordMLPackage.getMainDocumentPart().addTargetPart(afiPart);            
         CTAltChunk ac = Context.getWmlObjectFactory().createCTAltChunk();
         ac.setId(altChunkRel.getId());         
         documentPart.getContent().add(8,ac);    
         documentPart.getContent().remove(9);
            
            if (variables.size() > 0) {
                VariablePrepare.prepare(wordMLPackage);
                documentPart.variableReplace(variables);                
                header.variableReplace(variables);
            }
            response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
            response.setHeader("Content-disposition", "attachment;filename="
                    + outname);
            wordMLPackage.save(response.getOutputStream());
            response.getOutputStream().close();
        } catch (Exception ex) {
            Logger.getLogger(DocxGenerator.class.getName()).log(Level.SEVERE, null, ex);
        } 
     }
    
    /* Advertencia si se cambia el encabezado del documento puede que tenga que cambiarse la id del encabezado
     * en la linea Relationship rel tiene que se rId8 */
    public void generarDocRep2(HttpServletResponse response, HashMap<String,String> variables2, String outname2, byte[] datas) throws IOException {
         
        try {
            ByteArrayInputStream datoss = new ByteArrayInputStream(datas);
            WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(datoss);
            MainDocumentPart documentPart = wordMLPackage.getMainDocumentPart();
            
            RelationshipsPart rp = wordMLPackage.getMainDocumentPart().getRelationshipsPart();
            /* funciona para obtener el encabezado en especifico para EA_COVER.docx y EA_PARTS.docx */
            List<Relationship> headerRelationships = getRelationshipsOfType(wordMLPackage, Namespaces.HEADER);
            Relationship headerR = headerRelationships.get(0);
            //Relationship rel = rp.getRelationshipByID("rId9");
            //Part p = rp.getPart(rel);
            HeaderPart header = (HeaderPart) rp.getPart(headerR.getId());
            //HeaderPart header = (HeaderPart) p;
            
            if (variables2.size() > 0) {
                VariablePrepare.prepare(wordMLPackage);
                documentPart.variableReplace(variables2);                
                header.variableReplace(variables2);
            }
            response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
            response.setHeader("Content-disposition", "attachment;filename="
                    + outname2);
            wordMLPackage.save(response.getOutputStream());
            response.getOutputStream().close();
        } catch (Exception exr) {
            Logger.getLogger(DocxGenerator.class.getName()).log(Level.SEVERE, null, exr);
        } 
     }
    
     /* Advertencia si se cambia el encabezado del documento puede que tenga que cambiarse la id del encabezado
     * en la linea Relationship rel tiene que se rId8 */
    public void generarDocRep2_tool(HttpServletResponse response, HashMap<String,String> variables2, String outname2, byte[] datas) throws IOException {
         
        try {
            ByteArrayInputStream datoss = new ByteArrayInputStream(datas);
            WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(datoss);
            MainDocumentPart documentPart = wordMLPackage.getMainDocumentPart();
            
            RelationshipsPart rp = wordMLPackage.getMainDocumentPart().getRelationshipsPart();
            /* funciona para obtener el encabezado en especifico para EA_COVER.docx y EA_PARTS.docx */
            List<Relationship> headerRelationships = getRelationshipsOfType(wordMLPackage, Namespaces.HEADER);
            Relationship headerR = headerRelationships.get(0);
            //Relationship rel = rp.getRelationshipByID("rId9");
            //Part p = rp.getPart(rel);
            HeaderPart header = (HeaderPart) rp.getPart(headerR.getId());
            //HeaderPart header = (HeaderPart) p;
            
            if (variables2.size() > 0) {
                VariablePrepare.prepare(wordMLPackage);
                documentPart.variableReplace(variables2);                
                header.variableReplace(variables2);
            }
            response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
            response.setHeader("Content-disposition", "attachment;filename="
                    + outname2);
            wordMLPackage.save(response.getOutputStream());
            response.getOutputStream().close();
        } catch (Exception exr) {
            Logger.getLogger(DocxGenerator.class.getName()).log(Level.SEVERE, null, exr);
        } 
     }
    public void reempvar(WordprocessingMLPackage wordMLPackage, List<List<String>> variables)throws IOException{        
        try {
            VariablePrepare.prepare(wordMLPackage);
            MainDocumentPart documentPart = wordMLPackage.getMainDocumentPart();
            RelationshipsPart rp = wordMLPackage.getMainDocumentPart().getRelationshipsPart();
            Relationship rel = rp.getRelationshipByType(Namespaces.HEADER);
            Part p = rp.getPart(rel);
            p.setPartName(new PartName("/word/header1.xml"));
            HeaderPart header = (HeaderPart) p;
            HashMap<String, String> mappings = new HashMap<>();
            for(List valores : variables){
                mappings.put(valores.get(0).toString(), valores.get(1).toString());
            }
            documentPart.variableReplace(mappings);
            header.variableReplace(mappings);
        } catch (Exception ex) {
            Logger.getLogger(DocxGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
    
}
