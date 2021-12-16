/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

import com.aeroman.aees.entities.EngDentIni;
import com.aeroman.aees.entities.EngRequest;
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
public class EngDentIniFacade extends AbstractFacade<EngDentIni> {
    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EngDentIniFacade() {
        super(EngDentIni.class);
    }
    
    public List<EngDentIni> findRequestDentIni(EngRequest id) {
        List<EngDentIni> locationes = new ArrayList();
       
        Query query;
        try {
            em = getEntityManager();
            query = em.createQuery("SELECT e FROM EngDentIni e WHERE e.reqMessageid = :reqMessageids").setParameter("reqMessageids", id);
            locationes = query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(EngDentIniFacade.class.getName()).log(Level.SEVERE, null, e);
        }
        return locationes;
    }
    
}
