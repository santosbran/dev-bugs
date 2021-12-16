/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

import com.aeroman.aees.entities.EngReqResponses;
import com.aeroman.aees.entities.MsjAdjuntos;
import java.math.BigInteger;
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
 * @author Usuario
 */
@Stateless
public class MsjAdjuntosFacade extends AbstractFacade<MsjAdjuntos> {
    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    
    public MsjAdjuntosFacade() {
        super(MsjAdjuntos.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    
    
    public List<MsjAdjuntos> findByMsgCodResponse(BigInteger msgCodResponse){
        return (List<MsjAdjuntos>)  em.createNamedQuery("MsjAdjuntos.findByMsgCodResponse").setParameter("msgCodResponse", msgCodResponse).getResultList() ;
    }
    
    public List<MsjAdjuntos> findAdj(EngReqResponses id) {
        List<MsjAdjuntos> locationes = new ArrayList();
       
        Query query;
        try {
            em = getEntityManager();
            query = em.createQuery("SELECT m FROM MsjAdjuntos m WHERE m.msgCodResponse = :msgCodRes").setParameter("msgCodRes", id);
            locationes = query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(MsjAdjuntosFacade.class.getName()).log(Level.SEVERE, null, e);
        }
        return locationes;
    }
    
}
