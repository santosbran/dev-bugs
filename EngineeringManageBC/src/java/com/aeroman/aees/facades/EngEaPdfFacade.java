/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

import com.aeroman.aees.entities.EngEaPdf;
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
public class EngEaPdfFacade extends AbstractFacade<EngEaPdf> {
    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    public EngEaPdfFacade() {
        super(EngEaPdf.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<EngEaPdf> findByIDEA(BigInteger eagId){
        return (List<EngEaPdf>) em.createQuery("SELECT e FROM EngEaPdf e WHERE e.eagId = :eagId")
                .setParameter("eagId", eagId).getResultList() ;
    }
    
    public List<EngEaPdf> findByCoverR0(BigInteger eagId, String filename){
        return (List<EngEaPdf>) em.createQuery("SELECT e FROM EngEaPdf e WHERE e.eagId = :eagId AND e.pdfFilename like :pdfFilename")
                .setParameter("eagId", eagId)
                .setParameter("pdfFilename", filename).getResultList() ;
    }
    
    public List<EngEaPdf> findByCoverR0pdf(BigInteger eagId, String filename){
        return (List<EngEaPdf>) em.createQuery("SELECT e FROM EngEaPdf e WHERE e.eagId = :eagId AND e.pdfFilename = :pdfFilename")
                .setParameter("eagId", eagId)
                .setParameter("pdfFilename", filename).getResultList() ;
    }
}
