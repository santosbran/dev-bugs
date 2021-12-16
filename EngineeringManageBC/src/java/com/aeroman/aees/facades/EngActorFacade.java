/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

import com.aeroman.aees.entities.EngActor;
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
 * @author vjuarez
 */
@Stateless
public class EngActorFacade extends AbstractFacade<EngActor> {
    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EngActorFacade() {
        super(EngActor.class);
    }
    public EngActor findbyActorID(BigDecimal id){
        return (EngActor)em.createQuery("SELECT e FROM EngActor e WHERE e.actId =:id ").setParameter("id", id).getSingleResult();   
    }
    
    @Override
    public List<EngActor> findAll() {
        List<EngActor> actor = new ArrayList();
        Query query;
        try {
            em = getEntityManager();
            query = em.createQuery("SELECT e FROM EngActor e Order by e.actName");
            actor = query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(EngActor.class.getName()).log(Level.SEVERE, null, e);
        }
        return actor;
    }
    
    public int existeEnDisposition(BigDecimal pIdActor){
        int i = 1;
        
        int pCount = 0;        
        try {
            em = getEntityManager();
            Query query = em.createNativeQuery("SELECT COUNT(*) N FROM ENG.ENG_REQ_STATUS WHERE EST_IDACTOR = " + pIdActor);
            query.setMaxResults(i);
            String a2=(String) query.getSingleResult().toString(); 
            pCount =Integer.parseInt(a2);  
        } catch (Exception e) {
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);
        }
        return pCount;
    }
}
