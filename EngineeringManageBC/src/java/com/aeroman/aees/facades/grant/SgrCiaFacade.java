/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades.grant;

import com.aeroman.aees.entities.grant.SgrCia;
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
public class SgrCiaFacade extends AbstractFacade<SgrCia> {
    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    public SgrCiaFacade() {
        super(SgrCia.class);
    }
    
    @Override
    protected EntityManager getEntityManagerf() {
        return em;
    }

    public List<SgrCia> findAllOperative() {
        List<SgrCia> companies = new ArrayList();
        Query query;
        try {
            em = getEntityManagerf();
            query = em.createQuery("SELECT s FROM SgrCia s WHERE s.ciaType = '1' ORDER BY s.ciaName ASC");
            companies = query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(SgrCia.class.getName()).log(Level.SEVERE, null, e);
        }
        return companies;
    }
    
}
