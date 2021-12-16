/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;
import com.aeroman.aees.entities.EngDistributionLists;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author pc
 */
@Stateless
public class EngDistributionListsFacade extends AbstractFacade<EngDistributionLists> {
    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    public EngDistributionListsFacade() {
        super(EngDistributionLists.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    
    public List<EngDistributionLists> findByeoid(long eoid){
        return em.createQuery("SELECT e FROM EngDistributionLists e WHERE e.engDistributionListsPK.eoIdord = :obj").setParameter("obj", eoid).getResultList();        
    }
}
