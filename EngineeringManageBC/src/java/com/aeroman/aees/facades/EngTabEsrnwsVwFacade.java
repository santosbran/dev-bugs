/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

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
public class EngTabEsrnwsVwFacade extends AbstractFacade<EngTabEsrnwsVw> {
    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EngTabEsrnwsVwFacade() {
        super(EngTabEsrnwsVw.class);
    }
    public List<EngTabEsrnwsVw> findByAirCraft(String chkId, String company, String tipo){
        return em.createQuery("SELECT e FROM EngTabEsrnwsVw e WHERE e.checkid=:obj AND e.company=:com AND e.tipoSolicitud = 'ESR'").setParameter("obj", new BigDecimal(chkId)).setParameter("com", company).getResultList();        
    }  
     public List<EngTabEsrnwsVw> findByAirCraftETR(String company, String tipo){
        return em.createQuery("SELECT e FROM EngTabEsrnwsVw e WHERE e.company=:com AND e.tipoSolicitud = 'ETR'").setParameter("com", company).getResultList();        
    } 
    public List<EngTabEsrnwsVw> findByAirCraftECR(String company, String tipo){
        return em.createQuery("SELECT e FROM EngTabEsrnwsVw e WHERE e.company=:com AND e.tipoSolicitud = 'ECR'").setParameter("com", company).getResultList();        
    } 
    public List<EngTabEsrnwsVw> findByUsuarioNoa(String userID){
        return em.createQuery("SELECT e FROM EngTabEsrnwsVw e WHERE e.codigo86=:obj OR e.reqCodIngEnc=0").setParameter("obj", userID).getResultList();        
    }
    public List<EngTabEsrnwsVw> findByWo(String chkId){
        return em.createQuery("SELECT e FROM EngTabEsrnwsVw e WHERE e.checkid=:obj").setParameter("obj", new BigDecimal(chkId)).getResultList();        
    }
    public List<EngTabEsrnwsVw> findByAircraftAndCompany(String airCraft, String company){
        return em.createQuery("SELECT e FROM EngTabEsrnwsVw e WHERE e.airCraft=:obj AND e.company=:com").setParameter("obj", airCraft).setParameter("com", company).getResultList();        
    }
    public List<EngTabEsrnwsVw> findByAplication(String airCraft, String company,String modulo){
        //return em.createQuery("SELECT e FROM EngTabEsrnwsVw e WHERE e.airCraft=:obj AND e.company=:com").setParameter("obj", airCraft).setParameter("com", company).getResultList();        
        return em.createQuery("SELECT e FROM EngTabEsrnwsVw e WHERE e.airCraft=:obj AND e.company=:com AND e.tipoSolicitud=:mdu").setParameter("obj", airCraft).setParameter("com", company).setParameter("mdu", modulo).getResultList();        
    }
}
