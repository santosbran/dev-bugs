/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

import com.aeroman.aees.entities.EngReqTaskCard;
import com.aeroman.aees.entities.EngReqTaskJobcard;
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
public class EngReqTaskJobcardFacade extends AbstractFacade<EngReqTaskJobcard> {
    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EngReqTaskJobcardFacade() {
        super(EngReqTaskJobcard.class);
    }
    public List<EngReqTaskJobcard> findByEngRequest(EngRequest ers){
        return em.createQuery("SELECT e FROM EngReqTaskJobcard e WHERE e.reqMessageid=:obj").setParameter("obj", ers).getResultList();        
    }
    
}
