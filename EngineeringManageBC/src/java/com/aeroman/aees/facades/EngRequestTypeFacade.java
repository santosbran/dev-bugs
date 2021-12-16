/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;


import com.aeroman.aees.entities.EngRequestType;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author mpolanco
 */
@Stateless
public class EngRequestTypeFacade extends AbstractFacade<EngRequestType>{
    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    public EngRequestTypeFacade() {
        super(EngRequestType.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
     public List<EngRequestType> findAllActive() {
        List<EngRequestType> reqtype3 = new ArrayList();
        Query query;
        try {
            em = getEntityManager();
            query = em.createQuery("SELECT e FROM EngRequestType e WHERE e.retState = 'A'");
            reqtype3 = query.getResultList();
        } catch (Exception er) {
            Logger.getLogger(EngRequestType.class.getName()).log(Level.SEVERE, null, er);
        }
        return reqtype3;
    }
     
     public int existeEnESR(String pDescripcion){
        int i3 = 1;
        
        int pCount3 = 0;        
        try {
            em = getEntityManager();
            Query query = em.createNativeQuery("SELECT COUNT(*) N FROM ENG.ENG_REQUEST WHERE TRIM(REQ_RET_DESCRIPTION) = '" + pDescripcion.trim() + "'");
            query.setMaxResults(i3);
            String a2=(String) query.getSingleResult().toString(); 
            pCount3 =Integer.parseInt(a2);  
        } catch (Exception er) {
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, er);
        }
        return pCount3;
    }
}
