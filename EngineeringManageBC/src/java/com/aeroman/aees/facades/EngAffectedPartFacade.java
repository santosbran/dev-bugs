/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

import com.aeroman.aees.entities.EngAffectedPart;
import java.math.BigDecimal;
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
public class EngAffectedPartFacade extends AbstractFacade<EngAffectedPart> {
    
    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    public EngAffectedPartFacade() {
        super(EngAffectedPart.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public List<EngAffectedPart> findAllActive() {
        List<EngAffectedPart> location = new ArrayList();
        Query query;
        try {
            em = getEntityManager();
            query = em.createQuery("SELECT e FROM EngAffectedPart e WHERE e.afpState = 'A'");
            location = query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(EngAffectedPart.class.getName()).log(Level.SEVERE, null, e);
        }
        return location;
    }
    
    public EngAffectedPart findBySelectA(String affectedType){
        EngAffectedPart elm = new EngAffectedPart();
        String sacarid = affectedType.substring(0, affectedType.indexOf("-"));
        BigDecimal idDim = new BigDecimal(sacarid);
         Query query;
         query = em.createQuery("SELECT e FROM EngAffectedPart e WHERE e.afpState = 'A' and e.afpId = :obj").setParameter("obj", idDim);        
         elm = (EngAffectedPart) query.getSingleResult();
         return elm;
    }
    
    public int existeEnESR(BigDecimal pIdAFP){
        int i = 1;
        
        int pCount = 0;        
        try {
            em = getEntityManager();
            Query query = em.createNativeQuery("SELECT COUNT(*) N FROM ENG.ENG_REQUEST WHERE REQ_AFP_ID = " + pIdAFP);
            query.setMaxResults(i);
            String a2=(String) query.getSingleResult().toString(); 
            pCount =Integer.parseInt(a2);  
        } catch (Exception e) {
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);
        }
        return pCount;
    }
}
