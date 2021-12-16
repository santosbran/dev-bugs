/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

import com.aeroman.aees.entities.EngDimension;
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
public class EngDimensionFacade extends AbstractFacade<EngDimension>{
    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    public EngDimensionFacade() {
        super(EngDimension.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public List<EngDimension> findAllActive() {
        List<EngDimension> location = new ArrayList();
        Query query;
        try {
            em = getEntityManager();
            query = em.createQuery("SELECT e FROM EngDimension e WHERE e.dimState = 'A' Order by e.dimName");
            location = query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(EngDimension.class.getName()).log(Level.SEVERE, null, e);
        }
        return location;
    }
    
    public EngDimension findByDimension(BigDecimal id){
        EngDimension elemento = new EngDimension();
        try {
            Query query = em.createQuery("SELECT e FROM EngDimension e WHERE e.dimId = :dimId")
                    .setParameter("dimId", id);
            elemento = (EngDimension) query.getSingleResult();

        } catch (Exception e) {
            Logger.getLogger(EngDamageTypeFacade.class.getName()).log(Level.SEVERE, null, e);
            FacesContext.getCurrentInstance().validationFailed();
        }
        
        return elemento;
    }
    
    public int existeEnDamageDim(BigDecimal pIdDim){
        int i = 1;
        
        int pCount1 = 0;        
        try {
            em = getEntityManager();
            Query query1 = em.createNativeQuery("SELECT COUNT(*) N FROM ENG.ENG_DAMAGE_DIM WHERE DIM_ID = " + pIdDim);
            query1.setMaxResults(i);
            String a21=(String) query1.getSingleResult().toString(); 
            pCount1 =Integer.parseInt(a21);  
        } catch (Exception e) {
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);
        }
        return pCount1;
    }
}
