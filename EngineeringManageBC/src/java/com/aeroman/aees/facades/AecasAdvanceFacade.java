/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

import com.aeroman.aees.entities.AecasAdvance;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Moy
 */
@Stateless
public class AecasAdvanceFacade extends AbstractFacade<AecasAdvance> {
    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    
    public AecasAdvanceFacade() {
        super(AecasAdvance.class);
    }
    
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    
    
}
