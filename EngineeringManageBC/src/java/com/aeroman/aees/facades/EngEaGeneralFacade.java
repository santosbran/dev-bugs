/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

import com.aeroman.aees.entities.EngEaGeneral;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc
 */
@Stateless
public class EngEaGeneralFacade extends AbstractFacade<EngEaGeneral> {
    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    public EngEaGeneralFacade() {
        super(EngEaGeneral.class);
    } 
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    
    public List<EngEaGeneral> bLike(String like, String campo){
        List<EngEaGeneral> bus = new ArrayList();
        try {
            em = getEntityManager();
            Query query = em.createNativeQuery("SELECT * FROM ENG_EA_GENERAL  WHERE "+campo+" LIKE %'"+like+"'% ");
            bus = (List<EngEaGeneral>)query.getResultList();
        }catch(Exception e){
            Logger.getLogger(EngEaGeneralFacade.class.getName()).log(Level.SEVERE, null, e);
        }
        return bus;
    }
    
    
    
    public List<EngEaGeneral> bWhere(String where, String campo){
        List<EngEaGeneral> result = new ArrayList();
        try {
            em = getEntityManager();
            Query query = em.createNativeQuery("SELECT * FROM ENG_EA_GENERAL  WHERE "+campo+" = "+where+" ");
            result = (List<EngEaGeneral>)query.getResultList();
        }catch(Exception e){
            Logger.getLogger(EngEaGeneralFacade.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;
    }
    
    
    public List<EngEaGeneral> search(Object[] vals) {
        List<EngEaGeneral> busc = new ArrayList();
        try {
            em = getEntityManager();
            String sql = "SELECT * FROM ENG_EA_GENERAL WHERE 1=1 ";
            if (vals[0] != null) {
                String query0 = " AND EAG_CORRELATIVE = '";
                sql += query0 + vals[0] + "' ";
            }
            if (vals[1] != null) {
                String query1 = " AND REQ_MESSAGEID = '";
                sql += query1 + vals[1] + "' ";
            }
            if (vals[2] != null) {
                String query2 = " AND EAG_TAIL = '";
                sql += query2 + vals[2] + "' ";
            }
            if (vals[3] != null) {
                String query3 = " AND EAG_YEAR = '";
                sql += query3 + vals[3] + "'";
            }
            if (vals[4] != null) {
                String query4 = " AND EAG_ATA LIKE '%";
                sql += query4 + vals[4] + "%' ";
            }
            if (vals[5] != null) {
                String query5 = " AND EAG_MODEL LIKE '%";
                sql += query5 + vals[5] + "%' ";
            }
            if (vals[6] != null) {
                String query6 = " AND EAG_CMP_PN LIKE '%";
                sql += query6 + vals[6] + "%' ";
            }
            if (vals[7] != null) {
                String query7 = " AND EAG_CMP_SN = ";
                sql += query7 + vals[7] + " ";
            }
            if (vals[8] != null) {
                String query8 = " AND EAG_TITLE = '";
                sql += query8 + vals[8] + "' ";
            }
            Query query = em.createNativeQuery(sql, EngEaGeneral.class);
            busc = query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(EngEaGeneralFacade.class.getName()).log(Level.SEVERE, null, e);
        }
        return busc;
    }
    public List<EngEaGeneral> searchOpco(Object[] vals, String Opco) {
        List<EngEaGeneral> busc = new ArrayList();
        try {
            em = getEntityManager();
            String sql = "SELECT * FROM ENG_EA_GENERAL WHERE COMPANY='"+Opco+"'";
            if (vals[0] != null) {
                String query0 = " AND EAG_CORRELATIVE = '";
                sql += query0 + vals[0] + "' ";
            }
            if (vals[1] != null) {
                String query1 = " AND REQ_MESSAGEID = '";
                sql += query1 + vals[1] + "' ";
            }
            if (vals[2] != null) {
                String query2 = " AND EAG_TAIL = '";
                sql += query2 + vals[2] + "' ";
            }
            if (vals[3] != null) {
                String query3 = " AND EAG_YEAR = '";
                sql += query3 + vals[3] + "'";
            }
            if (vals[4] != null) {
                String query4 = " AND EAG_ATA LIKE '%";
                sql += query4 + vals[4] + "%' ";
            }
            if (vals[5] != null) {
                String query5 = " AND EAG_MODEL LIKE '%";
                sql += query5 + vals[5] + "%' ";
            }
            if (vals[6] != null) {
                String query6 = " AND EAG_CMP_PN LIKE '%";
                sql += query6 + vals[6] + "%' ";
            }
            if (vals[7] != null) {
                String query7 = " AND EAG_CMP_SN = ";
                sql += query7 + vals[7] + " ";
            }
            if (vals[8] != null) {
                String query8 = " AND EAG_TITLE = '";
                sql += query8 + vals[8] + "' ";
            }
            Query query = em.createNativeQuery(sql, EngEaGeneral.class);
            busc = query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(EngEaGeneralFacade.class.getName()).log(Level.SEVERE, null, e);
        }
        return busc;
    }
}
