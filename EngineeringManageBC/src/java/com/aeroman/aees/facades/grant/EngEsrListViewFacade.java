/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades.grant;

import com.aeroman.aees.entities.EngEsrListView;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author vjuarez
 */
@Stateless
public class EngEsrListViewFacade extends AbstractFacade<EngEsrListView> {
    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public EngEsrListViewFacade() {
        super(EngEsrListView.class);
    }

    @Override
    protected EntityManager getEntityManagerf() {
        return em;
    }
    
    public List<EngEsrListView> findByWorkOrder(BigDecimal chekID){
        return em.createQuery("SELECT e FROM EngEsrListView e WHERE e.checkid=:obj").setParameter("obj", chekID).getResultList();       
    }
    public List<EngEsrListView> findByUsuarioNoa(String UsuarioID){
        return em.createQuery("SELECT e FROM EngEsrListView e WHERE e.usrCoduser=:obj OR e.usrCoduser=0").setParameter("obj", UsuarioID).getResultList();        
    }
    public List<EngEsrListView> findByBuscarWorkOrder(String workOrder){
         BigDecimal chekID = new BigDecimal(workOrder);        
        return em.createQuery("SELECT e FROM EngEsrListView e WHERE e.checkid = :obj ").setParameter("obj", chekID).getResultList();        
    }
    public List<EngEsrListView> findByAircraftAndCompany(String airCraft, String company){
        return em.createQuery("SELECT e FROM EngEsrListView e WHERE e.reqRegistry = :airCraft and e.company= :company ").setParameter("airCraft", airCraft).setParameter("company", company).getResultList();        
    }    
}
