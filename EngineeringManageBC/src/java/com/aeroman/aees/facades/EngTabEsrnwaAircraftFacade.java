/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

import com.aeroman.aees.entities.EngTabEsrnwaAircraft;
import com.aeroman.aees.entities.EngTabEsrnwsVw;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author vjuarez
 */
@Stateless
public class EngTabEsrnwaAircraftFacade extends AbstractFacade<EngTabEsrnwaAircraft> {
    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EngTabEsrnwaAircraftFacade() {
        super(EngTabEsrnwaAircraft.class);
    }
    public List<EngTabEsrnwaAircraft> findByAirCraft(String chkId, String company){
        return em.createQuery("SELECT e FROM EngTabEsrnwaAircraft e WHERE e.checkid=:obj AND e.company=:com").setParameter("obj", new BigDecimal(chkId)).setParameter("com", company).getResultList();        
    }
    public List<EngTabEsrnwaAircraft> findByUsuarioNoa(String userID){
        return em.createQuery("SELECT e FROM EngTabEsrnwaAircraft e WHERE e.codigo86=:obj OR e.reqCodIngEnc=0").setParameter("obj", userID).getResultList();        
    }
    public List<EngTabEsrnwaAircraft> findByWo(String chkId){
        return em.createQuery("SELECT e FROM EngTabEsrnwaAircraft e WHERE e.checkid=:obj").setParameter("obj", new BigDecimal(chkId)).getResultList();        
    }
    public List<EngTabEsrnwaAircraft> findByAircraftAndCompany(String airCraft, String company){
        return em.createQuery("SELECT e FROM EngTabEsrnwaAircraft e WHERE e.airCraft=:obj AND e.company=:com").setParameter("obj", airCraft).setParameter("com", company).getResultList();        
    }
}
