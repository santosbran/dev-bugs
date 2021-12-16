/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

import com.aeroman.aees.entities.EngReqIngaction;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author pc
 */
@Stateless
public class EngReqIngactionFacade extends AbstractFacade<EngReqIngaction> {
    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    public EngReqIngactionFacade() {
        super(EngReqIngaction.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public List<EngReqIngaction> findByMessageId(BigInteger reqMessageid){
        return (List<EngReqIngaction>) em.createQuery("SELECT e FROM EngReqIngaction e WHERE e.reqMessageid = :reqMessageid ORDER BY e.einActionId DESC").setParameter("reqMessageid", reqMessageid).getResultList() ;
    }
}
