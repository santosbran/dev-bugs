/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

import com.aeroman.aees.entities.AecasEsrMh;
import com.aeroman.aees.entities.AecasEsrMhPK;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Moy
 */
@Stateless
public class AecasEsrMhFacade extends AbstractFacade<AecasEsrMh> {
    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    public AecasEsrMhFacade() {
        super(AecasEsrMh.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    
    public boolean findByIdPK(AecasEsrMhPK a){
        Long conteo=(Long)em.createQuery("SELECT COUNT(c) FROM AecasEsrMh c WHERE c.aecasEsrMhPK.esrAcreg=:acreg"
                + " AND c.aecasEsrMhPK.esrEsrId=:esrid "
                + " AND c.aecasEsrMhPK.esrCucod=:cucod"
                + " AND c.aecasEsrMhPK.esrWoOrder=:woorder"
                + " AND c.aecasEsrMhPK.esrWoTask=:wotask"
                + " AND c.aecasEsrMhPK.esrWoYear=:year")
                .setParameter("acreg", a.getEsrAcreg())
                .setParameter("esrid", a.getEsrEsrId())
                .setParameter("cucod", a.getEsrCucod())
                .setParameter("woorder", a.getEsrWoOrder())
                .setParameter("wotask", a.getEsrWoTask())
                .setParameter("year", a.getEsrWoYear()).getSingleResult();        
        if(conteo!=0)
            return true;
        else
            return false;
    }
    
}
