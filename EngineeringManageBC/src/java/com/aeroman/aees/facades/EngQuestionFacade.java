/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

import com.aeroman.aees.entities.EngQuestion;
import java.math.BigDecimal;
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
 * @author vjuarez
 */
@Stateless
public class EngQuestionFacade extends AbstractFacade<EngQuestion> {
    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EngQuestionFacade() {
        super(EngQuestion.class);
    }
    
    public int existeEnDamageQue(BigDecimal pIdQuestion){
        int i = 1;
        
        int pCount = 0;        
        try {
            em = getEntityManager();
            Query query = em.createNativeQuery("SELECT COUNT(*) N FROM ENG.ENG_DAMAGE_QUESTION WHERE QUE_ID = " + pIdQuestion);
            query.setMaxResults(i);
            String a2=(String) query.getSingleResult().toString(); 
            pCount =Integer.parseInt(a2);  
        } catch (Exception e) {
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);
        }
        return pCount;
    }
    
    @Override
    public List<EngQuestion> findAll() {
        List<EngQuestion> question = new ArrayList();
        Query query;
        try {
            em = getEntityManager();
            query = em.createQuery("SELECT e FROM EngQuestion e Order by e.queName");
            question = query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(EngQuestion.class.getName()).log(Level.SEVERE, null, e);
        }
        return question;
    }
}
