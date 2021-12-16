/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades.grant;

import com.aeroman.aees.entities.grant.RptEsquemas;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ealvarado
 */
@Stateless
public class RptEsquemasFacade extends AbstractFacade<RptEsquemas> {

    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;
    
    public RptEsquemasFacade() {
        super(RptEsquemas.class);
    }

    @Override
    protected EntityManager getEntityManagerf() {
        return em;
    }

    public RptEsquemas findbyname(String name) {

        RptEsquemas ele = new RptEsquemas();
        try {
            Query query = em.createQuery("SELECT m FROM RptEsquemas m WHERE m.esquema = :esq").setParameter("esq", name);
            ele = (RptEsquemas) query.getSingleResult();
        } catch (Exception e) {
            Logger.getLogger(RptEsquemasFacade.class.getName()).log(Level.SEVERE, null, e);
        }
        return ele;
    }
    
}
