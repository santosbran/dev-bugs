/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades.grant;

import com.aeroman.aees.entities.grant.CoreDpto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Usuario
 */
@Stateless
public class CoreDptoFacade extends AbstractFacade<CoreDpto> {
    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    public CoreDptoFacade() {
        super(CoreDpto.class);
    }
    
    @Override
    protected EntityManager getEntityManagerf() {
        return em;
    }

    
    
}
