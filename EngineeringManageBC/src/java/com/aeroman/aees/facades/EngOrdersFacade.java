/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

import com.aeroman.aees.entities.EngOrders;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;
/**
 *
 * @author pc
 */
@Stateless
public class EngOrdersFacade extends AbstractFacade<EngOrders> {
    
    List<String> titles = new ArrayList();
    List<String> atas = new ArrayList();
    List<String> flts = new ArrayList();
    List<String> documents = new ArrayList();
    List<String> correlativs = new ArrayList();
    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;
     
    public EngOrdersFacade() {
        super(EngOrders.class);
    }
    

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    /*Obtiene los datos para las modales y los autocompletados de la bd*/
    public void getAtasOnly(){        
        List<Object[]> temp = new ArrayList();
        try {
            em = getEntityManager();
            Query query = em.createNativeQuery("select ATA_NUMATA, EO_EXE_DATE, FLT_COD, EO_DOC_TYPE, EO_CORRELATIVE from ENG_ORDERS ");
            temp = (List<Object[]>) query.getResultList();
            if (temp != null) {
                for (Object[] temp1: temp) {
                    if (!atas.contains("\"" + temp1[0].toString() + "\""))
                        atas.add("\"" + temp1[0].toString() + "\"");
                    String title=temp1[1].toString().replace("\"", "");
                    if (!titles.contains("\"" + title + "\""))
                        titles.add("\"" +  title+ "\"");
                    if (!flts.contains("\"" + temp1[2].toString() + "\""))
                        flts.add("\"" + temp1[2].toString() + "\"");
                    if (!documents.contains("\"" + temp1[3].toString() + "\""))
                        documents.add("\"" + temp1[3].toString() + "\"");
                    if (!correlativs.contains("\"" + temp1[4].toString() + "\""))
                        correlativs.add("\"" + temp1[4].toString() + "\"");
                }
            }
        } catch (Exception e) {
            Logger.getLogger(EngOrdersFacade.class.getName()).log(Level.SEVERE,null,e);
        }finally{
            em.clear();
    }
    }
    
    /*Metodo que busca*/
    public List<EngOrders> search(Object[] valores){
        List<EngOrders> results = new ArrayList();
        String sql0 = " AND EO_REV_DATE = '";
        String sql1 = " AND ATA_NUMATA = '" ;
        String sql2 = " AND EO_EXE_DATE = '";
        String sql3=" AND EO_DOC_TYPE = '";
        String sql4=" AND EO_CREATION_DATE = '";
        String sql5 = " AND EO_CORRELATIVE = ";
        String sql6= " AND STS_EO_COD = '";
        String sql7=" AND FLT_COD = '";
        String sql8= " AND EO_YEAR = ";
        String sql9=" AND EO_DOC_TYPE = '";
        String sql10=" AND PRI_COD = '";
        String sql11=" AND EO_SUBJECT LIKE  '%";
        String sql12=" AND EO_REV = " ;
        
      
        
        try {
            em = getEntityManager();
            String sql = "SELECT * FROM ENG_ORDERS WHERE 1=1 ";
            if (valores[12] != null) {
                
                sql += sql12+ valores[12].toString() + " ";
            }
            if (valores[11] != null) {
                
                sql += sql11 + valores[11].toString() + "%' ";
            }
            if (valores[10] != null) {
                
                sql += sql10 + valores[10].toString() + "' ";
            }
            if (valores[9] != null) {
                
                sql += sql9+ valores[9].toString() + "' ";
            }
            if (valores[8] != null) {
                
                sql += sql8 + valores[8].toString() + " ";
            }
            if (valores[7] != null) {
                
                sql += sql7 + valores[7].toString() + "' ";
            }
            if (valores[6] != null) {
                
                sql += sql6 + valores[6].toString() + "' ";
            }
            if (valores[5] != null) {
                
                sql += sql5 + valores[5].toString() + " ";
            }
            if (valores[4] != null) {
                
                sql += sql4+ valores[4].toString() + "' ";
            }
            if (valores[3] != null) {
                
                sql += sql3 + valores[3].toString() + "' ";
            }
            if (valores[2] != null) {
                
                sql += sql2 + valores[2].toString() + "' ";
            }
            if (valores[1] != null) {
                sql += sql1 + valores[1].toString() + "' ";
            }
            if (valores[0] != null) {
                sql += sql0 + valores[0].toString() + "' ";
            }

            Query query = em.createNativeQuery(sql, EngOrders.class);  
            results = (List<EngOrders>) query.getResultList();
        }
        catch (Exception e) {
           Logger.getLogger(EngOrdersFacade.class.getName()).log(Level.SEVERE,null,e);
        }
        return results;
    }
    public List<String> getTitles() {
        return titles;
    }

    public void setTitles(List<String> titles) {
        this.titles = titles;
    }

    public List<String> getAtas() {
        return atas;
    }

    public void setAtas(List<String> atas) {
        this.atas = atas;
    }

    public List<String> getFlts() {
        return flts;
    }

    public void setFlts(List<String> flts) {
        this.flts = flts;
    }

    public List<String> getDocuments() {
        return documents;
    }

    public void setDocuments(List<String> documents) {
        this.documents = documents;
    }

    public List<String> getCorrelativs() {
        return correlativs;
    }

    public void setCorrelativs(List<String> correlativs) {
        this.correlativs = correlativs;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
}
