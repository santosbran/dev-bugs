/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

import com.aeroman.aees.entities.EngRepairClassif;
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
 * @author mchacon
 */
@Stateless
public class EngRepairClassifFacade  extends AbstractFacade<EngRepairClassif>{
    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    public EngRepairClassifFacade() {
        super(EngRepairClassif.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public List<EngRepairClassif> findAllActive() {
        List<EngRepairClassif> listRepClass = new ArrayList();
        Query query;
        try {
            em = getEntityManager();
            query = em.createQuery("SELECT e FROM EngRepairClassif e");
            listRepClass = query.getResultList();
        } catch (Exception er) {
            Logger.getLogger(EngRepairClassif.class.getName()).log(Level.SEVERE, null, er);
        }
        return listRepClass;
    }
     
//     public int existeEnESR(String pDescripcion){
//        int i3 = 1;
//        pCount3
//        int pCount3 = 0;        
//        try {
//            em = getEntityManager();
//            Query query = em.createNativeQuery("SELECT COUNT(*) N FROM ENG.ENG_REPAIR_CLASSIF WHERE TRIM() = '" + pDescripcion.trim() + "'");
//            query.setMaxResults(i3);
//            String a2=(String) query.getSingleResult().toString(); 
//            pCount3 =Integer.parseInt(a2);  
//        } catch (Exception er) {
//               Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, er);
//        }
//        return pCount3;
//    }
}
