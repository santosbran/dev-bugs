/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

import com.aeroman.aees.entities.MpplnForeCustomer;
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
 * @author vjuarez
 */
@Stateless
public class MpplnForeCustomerFacade extends AbstractFacade<MpplnForeCustomer> {

    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MpplnForeCustomerFacade() {
        super(MpplnForeCustomer.class);
    }
    
    public List<MpplnForeCustomer> findAllCommerCustomer() {
        List<MpplnForeCustomer> mpplnForeCustomer = new ArrayList();
        Query query;
        try {
            em = getEntityManager();
            query = em.createQuery("SELECT s FROM MpplnForeCustomer s ORDER BY s.cstName ASC");
            mpplnForeCustomer = query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(MpplnForeCustomerFacade.class.getName()).log(Level.SEVERE, null, e);
        }
        return mpplnForeCustomer;
    }
    
}
