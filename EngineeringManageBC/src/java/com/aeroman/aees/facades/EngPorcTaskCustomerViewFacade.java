/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

import com.aeroman.aees.entities.EngPorcTaskCustomerView;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ssibrian
 */
@Stateless
public class EngPorcTaskCustomerViewFacade extends AbstractFacade<EngPorcTaskCustomerView> {

    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    
    public EngPorcTaskCustomerViewFacade() {
        super(EngPorcTaskCustomerView.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    
    
}
