/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

import com.aeroman.aees.entities.EngReqTaskCard;
import com.aeroman.aees.entities.EngRequest;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ssibrian
 */
@Stateless
public class EngReqTaskCardFacade extends AbstractFacade<EngReqTaskCard> {

    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    public EngReqTaskCardFacade() {
        super(EngReqTaskCard.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    
    public List<EngReqTaskCard> findByEngRequest(EngRequest ers){
        return em.createQuery("SELECT e FROM EngReqTaskCard e WHERE e.reqMessageid=:obj").setParameter("obj", ers).getResultList();        
    }
    
}
