/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

import com.aeroman.aees.entities.EngDamageType;
import com.aeroman.aees.entities.EngEsrDocument;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Usuario
 */
@Stateless
public class EngEsrDocumentFacade extends AbstractFacade<EngEsrDocument> {
    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    public EngEsrDocumentFacade() {
        super(EngEsrDocument.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    
    public List<EngEsrDocument> findByItemId(String itemId){
        Short id = new Short(itemId);        
        return em.createQuery("Select e from EngEsrDocument e Where e.reqMessageid=:i").setParameter("i", id).getResultList();
    }
    
}
