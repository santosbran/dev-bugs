/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

import com.aeroman.aees.entities.EngReqTaskJobcardIni;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author vjuarez
 */
@Stateless
public class EngReqTaskJobcardIniFacade extends AbstractFacade<EngReqTaskJobcardIni> {
    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EngReqTaskJobcardIniFacade() {
        super(EngReqTaskJobcardIni.class);
    }
    
    public List<EngReqTaskJobcardIni> findBySelectJobCard(BigInteger ers){
        return em.createQuery("SELECT e FROM EngReqTaskJobcardIni e WHERE e.reqMessageid.reqMessageid=:obj").setParameter("obj", ers).getResultList();        
    }
    
}
