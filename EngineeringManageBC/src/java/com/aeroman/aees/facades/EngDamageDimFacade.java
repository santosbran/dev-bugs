/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

import com.aeroman.aees.entities.CoreAircraftType;
import com.aeroman.aees.entities.EngDamageDim;
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
public class EngDamageDimFacade extends AbstractFacade<EngDamageDim>{
    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    public EngDamageDimFacade() {
        super(EngDamageDim.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public List<EngDamageDim> findAllActive() {
        List<EngDamageDim> location = new ArrayList();
        Query query;
        try {
            em = getEntityManager();
            query = em.createQuery("SELECT e FROM EngDamageDim e WHERE e.dxdState = 'A' Order by e.datId.datName");
            location = query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(EngDamageDim.class.getName()).log(Level.SEVERE, null, e);
        }
        return location;
    }
    
    public List<EngDamageDim> findAllByDamage(String pDamage) {
        List<EngDamageDim> location = new ArrayList();
        int dataID = Integer.parseInt(pDamage);
        Query query;
        try {
            em = getEntityManager();
            query = em.createQuery("SELECT e FROM EngDamageDim e WHERE e.dxdState = 'A' and e.datId.datId = :datName Order by e.datId.datName")
                    .setParameter("datName", dataID);
            location = query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(EngDamageDim.class.getName()).log(Level.SEVERE, null, e);
        }
        return location;
    }
    public List<EngDamageDim> findAllByFlota(String pDamage,CoreAircraftType idAircraftType) {
        List<EngDamageDim> location = new ArrayList();
        int dataID = Integer.parseInt(pDamage);
        Query query;
        try {
            em = getEntityManager();
            query = em.createQuery("SELECT e FROM EngDamageDim e WHERE e.dxdState = 'A' and e.datId.datId = :datName and e.arctypId=:arctypIds Order by e.datId.datName")
                    .setParameter("datName", dataID).setParameter("arctypIds", idAircraftType);
            location = query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(EngDamageDim.class.getName()).log(Level.SEVERE, null, e);
        }
        return location;
    }
    
    public EngDamageDim findAllByDimension(String idDamag, BigDecimal idDimen){
        EngDamageDim elemento = new EngDamageDim();
        BigDecimal id = new BigDecimal(idDamag);
        Query query;
        try {
            query = em.createQuery("SELECT e FROM EngDamageDim e WHERE e.dxdState = 'A' and e.datId.datId = :datId"+ " and e.dxdId = :dimId Order by e.dimId.dimName")
                    .setParameter("datId",  id)
                    .setParameter("dimId", idDimen);
            elemento = (EngDamageDim) query.getSingleResult();

        } catch (Exception e) {
            Logger.getLogger(EngDamageDimFacade.class.getName()).log(Level.SEVERE, null, e);
            FacesContext.getCurrentInstance().validationFailed();
        }
        
        return elemento;
    }
    
    public int existeEnESR(BigDecimal pIdDim){
        int i = 1;
        
        int pCount = 0;        
        try {
            em = getEntityManager();
            Query query = em.createNativeQuery("SELECT COUNT(*) N FROM ENG.ENG_REQUEST_DIMEN WHERE RED_ID_DIMENSION = " + pIdDim);
            query.setMaxResults(i);
            String a2=(String) query.getSingleResult().toString(); 
            pCount =Integer.parseInt(a2);  
        } catch (Exception e) {
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);
        }
        return pCount;
    }
}
