/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

import com.aeroman.aees.entities.EngRequest;
import com.aeroman.aees.entities.EngRequestQuestion;
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
public class EngRequestQuestionFacade extends AbstractFacade<EngRequestQuestion> {
    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EngRequestQuestionFacade() {
        super(EngRequestQuestion.class);
    }
    
    public List<EngRequestQuestion> findDamageQuestion(EngRequest id) {
        List<EngRequestQuestion> locationes = new ArrayList();
       
        Query query;
        try {
            em = getEntityManager();
            query = em.createQuery("SELECT e FROM EngRequestQuestion e WHERE e.reqMessageid = :reqMessageid").setParameter("reqMessageid", id);
            locationes = query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(EngRequestQuestionFacade.class.getName()).log(Level.SEVERE, null, e);
        }
        return locationes;
    }
    
}
