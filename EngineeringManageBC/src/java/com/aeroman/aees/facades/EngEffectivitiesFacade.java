/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

import com.aeroman.aees.entities.EngEffectivities;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * @author pc
 */
@Stateless
public class EngEffectivitiesFacade extends AbstractFacade<EngEffectivities> {
    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    public EngEffectivitiesFacade() {
        super(EngEffectivities.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    
    
    public List<EngEffectivities> findByeoid(long eoid){
        return em.createQuery("SELECT e FROM EngEffectivities e WHERE e.eoIdord = :obj").setParameter("obj", eoid).getResultList();        
    }
    
}
