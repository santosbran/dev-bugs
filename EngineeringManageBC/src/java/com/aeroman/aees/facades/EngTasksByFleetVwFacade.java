/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

import com.aeroman.aees.entities.EngTasksByFleetVw;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Usuario
 */
@Stateless
public class EngTasksByFleetVwFacade extends AbstractFacade<EngTasksByFleetVw> {
    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    public EngTasksByFleetVwFacade() {
        super(EngTasksByFleetVw.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    
    
}
