/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

import com.aeroman.aees.entities.EngDamageType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author mpolanco
 */
@Stateless
public class EngDamageTypeFacade extends AbstractFacade<EngDamageType>{

    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    public EngDamageTypeFacade() {
        super(EngDamageType.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public List<EngDamageType> findAllActive() {
        List<EngDamageType> location = new ArrayList();
        Query query;
        try {
            em = getEntityManager();
            query = em.createQuery("SELECT e FROM EngDamageType e WHERE e.datState = 'A' Order by e.datName");
            location = query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(EngDamageType.class.getName()).log(Level.SEVERE, null, e);
        }
        return location;
    }
    
    public EngDamageType findByDamageType(BigDecimal id){
        EngDamageType elemento = new EngDamageType();
        try {
            Query query = em.createQuery("SELECT e FROM EngDamageType e WHERE e.datId = :datId")
                    .setParameter("datId", id);
            elemento = (EngDamageType) query.getSingleResult();

        } catch (Exception e) {
            Logger.getLogger(EngDamageTypeFacade.class.getName()).log(Level.SEVERE, null, e);
            FacesContext.getCurrentInstance().validationFailed();
        }
        
        return elemento;
    }
    
    public EngDamageType findByDamageByName(String damagetype){
        EngDamageType elemento = new EngDamageType();
        if(damagetype != null){
            String sacarid = damagetype.substring(0, damagetype.indexOf("-"));
            BigDecimal idDim = new BigDecimal(sacarid);
            try {
                Query query = em.createQuery("SELECT e FROM EngDamageType e WHERE e.datState = 'A' and e.datId = :datName")
                        .setParameter("datName", idDim);
                elemento = (EngDamageType) query.getSingleResult();

            } catch (Exception e) {
                Logger.getLogger(EngDamageTypeFacade.class.getName()).log(Level.SEVERE, null, e);
                FacesContext.getCurrentInstance().validationFailed();
            }
        }
        
        
        return elemento;
    }
    public EngDamageType findByDamageByNameTR(String damagetype){
        EngDamageType elemento = new EngDamageType();        
        try {
            Query query = em.createQuery("SELECT e FROM EngDamageType e WHERE e.datState = 'A' and e.datName = :datName")
                    .setParameter("datName", damagetype);
            elemento = (EngDamageType) query.getSingleResult();

        } catch (Exception e) {
            Logger.getLogger(EngDamageTypeFacade.class.getName()).log(Level.SEVERE, null, e);
            FacesContext.getCurrentInstance().validationFailed();
        }
        
        return elemento;
    }
    
    public int existeEnDamageDim(BigDecimal pIdDAT){
        int i = 1;
        
        int pCount = 0;        
        try {
            em = getEntityManager();
            Query query = em.createNativeQuery("SELECT COUNT(*) N FROM ENG.ENG_DAMAGE_DIM WHERE DAT_ID = " + pIdDAT);
            query.setMaxResults(i);
            String a2=(String) query.getSingleResult().toString(); 
            pCount =Integer.parseInt(a2);  
        } catch (Exception e) {
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);
        }
        return pCount;
    }
}
