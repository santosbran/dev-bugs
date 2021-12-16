/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

import com.aeroman.aees.entities.EngHoursVw;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ssibrian
 */
@Stateless
public class EngHoursVwFacade extends AbstractFacade<EngHoursVw> {

    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    public EngHoursVwFacade() {
        super(EngHoursVw.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    
    
    public List<EngHoursVw> findByCheck(Short id){
        return em.createQuery("SELECT a From EngHoursVw a WHERE a.checkid=:chk ORDER BY a.reqMessageid ASC").setParameter("chk", id).getResultList();
    }
    
}
