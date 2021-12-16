/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

import com.aeroman.aees.entities.ContFleetsVw;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Usuario
 */
@Stateless
public class ContFleetsVwFacade extends AbstractFacade<ContFleetsVw> {
    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    public ContFleetsVwFacade() {
        super(ContFleetsVw.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
