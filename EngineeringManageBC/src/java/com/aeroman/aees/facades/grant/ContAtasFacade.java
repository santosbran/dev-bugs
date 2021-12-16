/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades.grant;

import com.aeroman.aees.entities.grant.ContAtas;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Usuario
 */
@Stateless
public class ContAtasFacade extends AbstractFacade<ContAtas> {
    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    public ContAtasFacade() {
        super(ContAtas.class);
    }
    
    @Override
    protected EntityManager getEntityManagerf() {
        return em;
    }
    
    public List<ContAtas> finAllOrder (){
        return em.createQuery("SELECT e FROM ContAtas e ORDER BY e.ataNumata ASC").getResultList();
    }

    
    
}
