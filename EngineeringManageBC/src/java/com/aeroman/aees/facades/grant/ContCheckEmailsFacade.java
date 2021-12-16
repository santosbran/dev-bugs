/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades.grant;

import com.aeroman.aees.entities.grant.ContCheckEmails;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * @author Usuario
 */
@Stateless
public class ContCheckEmailsFacade extends AbstractFacade<ContCheckEmails> {
    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    public ContCheckEmailsFacade() {
        super(ContCheckEmails.class);
    }
    
    @Override
    protected EntityManager getEntityManagerf() {
        return em;
    }

    
    
    public List<ContCheckEmails> findbywo(Short wo){
        return em.createQuery("SELECT c FROM ContCheckEmails c WHERE c.contCheckId.contCheckId = :oli").setParameter("oli",wo).getResultList();
    }
    
}
