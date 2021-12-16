/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

import com.aeroman.aees.entities.EngReqTaskCardIni;
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
public class EngReqTaskCardIniFacade extends AbstractFacade<EngReqTaskCardIni> {
    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EngReqTaskCardIniFacade() {
        super(EngReqTaskCardIni.class);
    }
    public List<EngReqTaskCardIni> findBySelectTaskCard(BigInteger ers){
        return em.createQuery("SELECT e FROM EngReqTaskCardIni e WHERE e.reqMessageid.reqMessageid =:obj").setParameter("obj", ers).getResultList();        
    }
    
}
