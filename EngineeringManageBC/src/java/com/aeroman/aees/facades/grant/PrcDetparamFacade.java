/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades.grant;

import com.aeroman.aees.entities.grant.PrcDetparam;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Saplic16
 */
@Stateless
public class PrcDetparamFacade extends AbstractFacade<PrcDetparam> {

    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    public PrcDetparamFacade() {
        super(PrcDetparam.class);
    }
    
    @Override
    protected EntityManager getEntityManagerf() {
        return em;
    }

    
    
    public List<PrcDetparam> filterByCodeParam(){    
        return em.createQuery("SELECT c from PrcDetparam c WHERE c.codparam LIKE 'AEES_EXPORT_HOURS'").getResultList();
    }
    
    public PrcDetparam findByLiksWeb(String webService){    
        return (PrcDetparam) em.createQuery("SELECT c from PrcDetparam c WHERE c.codparam='LINK_WEB_SERVICES' and c.att1=:var1").setParameter("var1",webService).getSingleResult();
    }
    
    public PrcDetparam findByRpENGESR(String company){    
        return (PrcDetparam) em.createQuery("SELECT c from PrcDetparam c WHERE c.codparam='RP_ENG_ESR' and c.att1=:var1").setParameter("var1",company).getSingleResult();
    }
    
}
