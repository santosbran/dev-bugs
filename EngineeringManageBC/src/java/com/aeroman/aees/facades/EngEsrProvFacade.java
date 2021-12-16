/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

import com.aeroman.aees.entities.EngEsrProv;
import com.aeroman.aees.entities.EngRequest;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author vjuarez
 */
@Stateless
public class EngEsrProvFacade extends AbstractFacade<EngEsrProv> {
    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EngEsrProvFacade() {
        super(EngEsrProv.class);
    }
    public List<EngEsrProv> findByEngEsrProv(int ers){
        return em.createQuery("SELECT e FROM EngEsrProv e WHERE e.messageid=:obj").setParameter("obj", ers).getResultList();        
    }
    
}
