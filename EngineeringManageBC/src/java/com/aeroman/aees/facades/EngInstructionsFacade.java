/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

import com.aeroman.aees.entities.EngInstructions;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * @author pc
 */
@Stateless
public class EngInstructionsFacade extends AbstractFacade<EngInstructions> {
    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    public EngInstructionsFacade() {
        super(EngInstructions.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    
    
    public List<EngInstructions> findByeoid(long eoid){
        return em.createQuery("SELECT e FROM EngInstructions e WHERE e.eosIdord.eoIdord = :obj").setParameter("obj", eoid).getResultList();        
    }
    
}
