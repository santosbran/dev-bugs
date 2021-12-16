/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

;
import com.aeroman.aees.entities.EngRequestDimenManuf;
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
 * @author mchacon
 */
@Stateless
public class EngRequestDimenManufFacade extends AbstractFacade<EngRequestDimenManuf>{
    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    public EngRequestDimenManufFacade() {
        super(EngRequestDimenManuf.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }  
    
    public List<EngRequestDimenManuf> findAllActive(BigDecimal idesr) {
        List<EngRequestDimenManuf> req = new ArrayList();
        Query query;
        try {
            em = getEntityManager();
            query = em.createQuery("SELECT e FROM EngRequestDimenManuf e WHERE e.redState = 'A' and e.redIdRequest.reqMessageid = :idesr")
                    .setParameter("idesr", idesr);
            req = query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(EngRequestDimenManuf.class.getName()).log(Level.SEVERE, null, e);
        }
        return req;
    }
    public List<EngRequestDimenManuf> selectActives() {
        List<EngRequestDimenManuf> req = new ArrayList();
        Query query;
        try {
            em = getEntityManager();
            query = em.createQuery("SELECT e FROM EngRequestDimenManuf e WHERE e.redState = 'A'");
            req = query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(EngRequestDimenManuf.class.getName()).log(Level.SEVERE, null, e);
        }
        return req;
    } 
}
