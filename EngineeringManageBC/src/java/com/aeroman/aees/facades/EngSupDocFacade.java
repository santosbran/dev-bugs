/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

import com.aeroman.aees.entities.EngSupDoc;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * @author pc
 */
@Stateless
public class EngSupDocFacade extends AbstractFacade<EngSupDoc> {
    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    public EngSupDocFacade() {
        super(EngSupDoc.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    
    
    public List<EngSupDoc> findByeoid(long eoid){
        return em.createQuery("SELECT e FROM EngSupDoc e WHERE e.eoIdord.eoIdord = :obj").setParameter("obj", eoid).getResultList();        
    }
    
}
