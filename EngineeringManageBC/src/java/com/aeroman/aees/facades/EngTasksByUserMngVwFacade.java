/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

import com.aeroman.aees.entities.EngTasksByUserMngVw;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Usuario
 */
@Stateless
public class EngTasksByUserMngVwFacade extends AbstractFacade<EngTasksByUserMngVw> {
    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    public EngTasksByUserMngVwFacade() {
        super(EngTasksByUserMngVw.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    public List<EngTasksByUserMngVw> findByUserCia(String cia){
        return em.createQuery("SELECT e FROM EngTasksByUserMngVw e WHERE e.company = :cia ORDER BY e.rowId ASC").setParameter("cia", cia).getResultList();
    }

    
    
}
