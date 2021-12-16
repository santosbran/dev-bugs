/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

import com.aeroman.aees.entities.SearchEsr;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author vjuarez
 */
@Stateless
public class SearchEsrFacade extends AbstractFacade<SearchEsr> {

    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SearchEsrFacade() {
        super(SearchEsr.class);
    }
    public List<SearchEsr> findFromMotorBusqueda(Object[] vals){
         List<SearchEsr> busc = new ArrayList();
        try {
            em = getEntityManager();
            String sql = "SELECT * FROM SEARCH_ESR WHERE 1=1 ";
            if (vals[0] != null) {
                String query0 = " AND UPPER(REQ_MESSAGEID) = '";
                sql += query0 + vals[0] + "' ";
            }
            if (vals[1] != null) {
                String query1 = " AND UPPER(REQ_REGISTRY) = '";
                sql += query1 + vals[1] + "' ";
            }
            if (vals[2] != null) {
                String query2 = " AND ATA_NUMATA = '";
                sql += query2 + vals[2] + "' ";
            }
            if (vals[3] != null) {
                String query3 = " AND CHK_MODEL = '";
                sql += query3 + vals[3] + "'";
            }
            if (vals[4] != null) {
                String query4 = " AND CHK_CHECKID = '";
                sql += query4 + vals[4] + "' ";
            }
            if (vals[5] != null) {
                String query5 = " AND REQ_CUSTOMER LIKE '%";
                sql += query5 + vals[5] + "%' ";
            }
            if (vals[6] != null) {
                String query6 = " AND REQ_COD_ING_ENC LIKE '%";
                sql += query6 + vals[6] + "%' ";
            }
            if (vals[7] != null) {
                String query7 = " AND REQ_PN = '";
                sql += query7 + vals[7] + "' ";
            }
            if (vals[8] != null) {
                String query8 = " AND REQ_AFP_ID = '";
                sql += query8 + vals[8] + "' ";
            }
            Query query = em.createNativeQuery(sql, SearchEsr.class);
            busc = query.getResultList();
            } catch (Exception e) {
                Logger.getLogger(SearchEsrFacade.class.getName()).log(Level.SEVERE, null, e);//captura de error
                FacesContext.getCurrentInstance().validationFailed();
            } 
        return busc;
    }
    public List<SearchEsr> findFromMotorBusquedaCia(Object[] vals, String opco){
         List<SearchEsr> busc = new ArrayList();
        try {
            em = getEntityManager();
            String sql = "SELECT * FROM SEARCH_ESR WHERE COMPANY='"+opco+"'";
            if (vals[0] != null) {
                String query0 = " AND UPPER(REQ_MESSAGEID) = '";
                sql += query0 + vals[0] + "' ";
            }
            if (vals[1] != null) {
                String query1 = " AND UPPER(REQ_REGISTRY) = '";
                sql += query1 + vals[1] + "' ";
            }
            if (vals[2] != null) {
                String query2 = " AND ATA_NUMATA = '";
                sql += query2 + vals[2] + "' ";
            }
            if (vals[3] != null) {
                String query3 = " AND CHK_MODEL = '";
                sql += query3 + vals[3] + "'";
            }
            if (vals[4] != null) {
                String query4 = " AND CHK_CHECKID = '";
                sql += query4 + vals[4] + "' ";
            }
            if (vals[5] != null) {
                String query5 = " AND REQ_CUSTOMER LIKE '%";
                sql += query5 + vals[5] + "%' ";
            }
            if (vals[6] != null) {
                String query6 = " AND REQ_COD_ING_ENC LIKE '%";
                sql += query6 + vals[6] + "%' ";
            }
            if (vals[7] != null) {
                String query7 = " AND REQ_PN = '";
                sql += query7 + vals[7] + "' ";
            }
            if (vals[8] != null) {
                String query8 = " AND REQ_AFP_ID = '";
                sql += query8 + vals[8] + "' ";
            }
            Query query = em.createNativeQuery(sql, SearchEsr.class);
            busc = query.getResultList();
            } catch (Exception e) {
                Logger.getLogger(SearchEsrFacade.class.getName()).log(Level.SEVERE, null, e);//captura de error
                FacesContext.getCurrentInstance().validationFailed();
            } 
        return busc;
    }
    
}
