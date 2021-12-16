/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

import com.aeroman.aees.entities.ApprovalConfigVw;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author pc
 */
@Stateless
public class ApprovalConfigVwFacade extends AbstractFacade<ApprovalConfigVw> {
    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    public ApprovalConfigVwFacade() {
        super(ApprovalConfigVw.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    
    
}
