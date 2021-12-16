/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

import com.aeroman.aees.entities.EngAffectedPubs;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * @author pc
 */
@Stateless
public class EngAffectedPubsFacade extends AbstractFacade<EngAffectedPubs> {
    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    public EngAffectedPubsFacade() {
        super(EngAffectedPubs.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    
    
    public List<EngAffectedPubs> findByeoid(long eoid){
        return em.createQuery("SELECT e FROM EngAffectedPubs e WHERE e.eoIdord = :obj").setParameter("obj", eoid).getResultList();        
    }
}
