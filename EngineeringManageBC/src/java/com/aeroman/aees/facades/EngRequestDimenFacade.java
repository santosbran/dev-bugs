/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

import com.aeroman.aees.entities.EngRequestDimen;
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
public class EngRequestDimenFacade extends AbstractFacade<EngRequestDimen>{
 @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    public EngRequestDimenFacade() {
        super(EngRequestDimen.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }  
    
    public List<EngRequestDimen> findAllActive(BigDecimal idesr) {
        List<EngRequestDimen> req = new ArrayList();
        Query query;
        try {
            em = getEntityManager();
            query = em.createQuery("SELECT e FROM EngRequestDimen e WHERE e.redState = 'A' and e.redIdRequest.reqMessageid = :idesr")
                    .setParameter("idesr", idesr);
            req = query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(EngRequestDimen.class.getName()).log(Level.SEVERE, null, e);
        }
        return req;
    }
    
    public List<EngRequestDimen> findAllActiveLocation(BigDecimal idesr) {
        List<EngRequestDimen> req = new ArrayList();
        Query query;
        try {
            em = getEntityManager();
            query = em.createQuery("SELECT e FROM EngRequestDimen e WHERE e.redState = 'A' and e.redIdDimensionManf.ubicationDim='Location' and e.redIdRequest.reqMessageid = :idesr order by e.redIdDimensionManf.orden asc")
                    .setParameter("idesr", idesr);
            req = query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(EngRequestDimen.class.getName()).log(Level.SEVERE, null, e);
        }
        return req;
    }
    // and e.redIdDimensionManf.dimId.dimName in('Milimeter', 'Inches') 
    public List<EngRequestDimen> findAllActiveDimension(BigDecimal idesr) {
        List<EngRequestDimen> req = new ArrayList();
        Query query;
        try {
            em = getEntityManager();
            query = em.createQuery("SELECT e FROM EngRequestDimen e WHERE e.redState = 'A' and e.redIdDimensionManf.ubicationDim='Dimension' and e.redIdDimensionManf.dimId.typeControl='textBox' and e.redIdRequest.reqMessageid = :idesr order by e.redIdDimensionManf.orden asc")
                    .setParameter("idesr", idesr);
            req = query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(EngRequestDimen.class.getName()).log(Level.SEVERE, null, e);
        }
        return req;
    }
    
    public List<EngRequestDimen> findAllActiveDimensionBlend_Dent(BigDecimal idesr) {
        List<EngRequestDimen> req = new ArrayList();
        Query query;
        try {
            em = getEntityManager();
                query = em.createQuery("SELECT e FROM EngRequestDimen e WHERE e.redState = 'A' and e.redIdDimensionManf.ubicationDim='Dimension' and e.redIdDimensionManf.datId.datId in(6,2) and e.redIdDimensionManf.dimId.dimName != 'Milimeter'  and e.redIdDimensionManf.dimId.dimName != 'Inches'  and e.redIdRequest.reqMessageid = :idesr order by e.redIdDimensionManf.orden asc")
                    .setParameter("idesr", idesr);
                req = query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(EngRequestDimen.class.getName()).log(Level.SEVERE, null, e);
        }
        return req;
    }
    
    public List<EngRequestDimen> findAllActiveNearBy(BigDecimal idesr) {
        List<EngRequestDimen> req = new ArrayList();
        Query query;
        try {
            em = getEntityManager();
            query = em.createQuery("SELECT e FROM EngRequestDimen e WHERE e.redState = 'A' and e.redIdDimensionManf.ubicationDim='Nearby_Dimension' and e.redIdRequest.reqMessageid = :idesr order by e.redIdDimensionManf.orden asc")
                    .setParameter("idesr", idesr);
            req = query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(EngRequestDimen.class.getName()).log(Level.SEVERE, null, e);
        }
        return req;
    }
    
    
    public List<EngRequestDimen> findAllActiveDimensionNearbyRepair(BigDecimal idesr) {
        List<EngRequestDimen> req = new ArrayList();
        Query query;
        try {
            em = getEntityManager();
            query = em.createQuery("SELECT e FROM EngRequestDimen e WHERE e.redState = 'A' and e.redIdDimensionManf.ubicationDim='Nearby_Dimension' and e.redIdRequest.reqMessageid = :idesr order by e.redIdDimensionManf.orden asc")
                    .setParameter("idesr", idesr);
            req = query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(EngRequestDimen.class.getName()).log(Level.SEVERE, null, e);
        }
        return req;
    }// and e.redIdDimensionManf.datId.datId = :idesr
    
    public List<EngRequestDimen> findAllActiveDimensionCheckbox(BigDecimal idesr) {
        List<EngRequestDimen> req = new ArrayList();
        Query query;
        try {
            em = getEntityManager();
            query = em.createQuery("SELECT e FROM EngRequestDimen e WHERE e.redState = 'A' and e.redIdDimensionManf.ubicationDim='Dimension' and e.redIdDimensionManf.dimId.typeControl='checkBox' and e.redIdDimensionManf.dimId.dimName in('Milimeter', 'Inches') and e.redIdRequest.reqMessageid = :idesr order by e.redIdDimensionManf.orden asc")
                    .setParameter("idesr", idesr);
            req = query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(EngRequestDimen.class.getName()).log(Level.SEVERE, null, e);
        }
        return req;
    }
    public List<EngRequestDimen> selectActives() {
        List<EngRequestDimen> req = new ArrayList();
        Query query;
        try {
            em = getEntityManager();
            query = em.createQuery("SELECT e FROM EngRequestDimen e WHERE e.redState = 'A'");
            req = query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(EngRequestDimen.class.getName()).log(Level.SEVERE, null, e);
        }
        return req;
    }
}
