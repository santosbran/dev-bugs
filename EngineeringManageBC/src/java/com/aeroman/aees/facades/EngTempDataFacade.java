/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

import com.aeroman.aees.entities.EngTempData;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author mpolanco
 */
@Stateless
public class EngTempDataFacade extends AbstractFacade<EngTempData>{
    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    public EngTempDataFacade() {
        super(EngTempData.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public List<EngTempData> findAllActive() {
        List<EngTempData> tempData2 = new ArrayList();
        Query query;
        try {
            em = getEntityManager();
            query = em.createQuery("SELECT e FROM EngTempData e WHERE e.tedState = 'A'");
            tempData2 = query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(EngTempData.class.getName()).log(Level.SEVERE, null, e);
        }
        return tempData2;
    }
    
    public int existeEnESR(String pDescripcion){
        int i2 = 1;
        
        int pCount2 = 0;        
        try {
            em = getEntityManager();
            Query query = em.createNativeQuery("SELECT COUNT(*) N FROM ENG.ENG_DENT WHERE TRIM(DEN_TEMPLATE_DATA) = '" + pDescripcion.trim() + "'");
            query.setMaxResults(i2);
            String a2=(String) query.getSingleResult().toString(); 
            pCount2 =Integer.parseInt(a2);  
        } catch (Exception et) {
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, et);
        }
        return pCount2;
    }
}
