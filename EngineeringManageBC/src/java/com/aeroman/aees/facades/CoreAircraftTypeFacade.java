/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

import com.aeroman.aees.entities.CoreAircraftType;
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
 * @author vjuarez
 */
@Stateless
public class CoreAircraftTypeFacade extends AbstractFacade<CoreAircraftType> {
    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CoreAircraftTypeFacade() {
        super(CoreAircraftType.class);
    }
    
    public CoreAircraftType findAllByFlota(String idFlota){
        CoreAircraftType elems = new CoreAircraftType();
        
        Query query;
        try {
            query = em.createQuery("SELECT e FROM CoreAircraftType e WHERE e.arctypDesc=:flota")
                    .setParameter("flota",  idFlota);
            elems = (CoreAircraftType) query.getSingleResult();

        } catch (Exception e) {
            Logger.getLogger(CoreAircraftTypeFacade.class.getName()).log(Level.SEVERE, null, e);
            FacesContext.getCurrentInstance().validationFailed();
        }
        
        return elems;
    }
    public List<String> findModelAir(){
        return em.createQuery("SELECT DISTINCT e.arctypCode FROM CoreAircraftType e order by e.arctypCode asc").getResultList();    
        
    }
    
    @Override
    public List<CoreAircraftType> findAll() {
        List<CoreAircraftType> aircraft = new ArrayList();
        Query query;
        try {
            em = getEntityManager();
            query = em.createQuery("SELECT c FROM CoreAircraftType c Order by c.arctypDesc");
            aircraft = query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(CoreAircraftType.class.getName()).log(Level.SEVERE, null, e);
        }
        return aircraft;
    }
}
