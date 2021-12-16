/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

import com.aeroman.aees.entities.EngCustomer;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Usuario
 */
@Stateless
public class EngCustomerFacade extends AbstractFacade<EngCustomer> {
    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;
    
    public EngCustomerFacade() {
        super(EngCustomer.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public List<EngCustomer> findAllCustomer() {
        List<EngCustomer> engCustome = new ArrayList();
        Query query;
        try {
            em = getEntityManager();
            query = em.createQuery("SELECT s FROM EngCustomer s ORDER BY s.engName ASC");
            engCustome = (List<EngCustomer>)query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(EngCustomerFacade.class.getName()).log(Level.SEVERE, null, e);
        }
        return engCustome;
    }
    
}
