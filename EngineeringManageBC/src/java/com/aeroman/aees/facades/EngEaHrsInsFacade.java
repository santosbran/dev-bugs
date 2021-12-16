/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

import com.aeroman.aees.entities.EngHrsIns;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author pc
 */
@Stateless
public class EngEaHrsInsFacade extends AbstractFacade<EngHrsIns> {
    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    public EngEaHrsInsFacade() {
        super(EngHrsIns.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    
    
}
