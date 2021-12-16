/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

import com.aeroman.aees.entities.EngTaskCard;
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
 * @author ssibrian
 */
@Stateless
public class EngTaskCardFacade extends AbstractFacade<EngTaskCard> {

    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    public EngTaskCardFacade() {
        super(EngTaskCard.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    
    public List<EngTaskCard> findByChkId(Short chkId){
        return em.createQuery("SELECT e FROM EngTaskCard e WHERE e.chkCheckid=:obj").setParameter("obj", chkId).getResultList();        
    }
    
    public EngTaskCard findByYearCorr(String year, String corr){
        Short a= new Short(year);
        int b = Integer.parseInt(corr);
        return (EngTaskCard)em.createQuery("SELECT e FROM EngTaskCard e WHERE e.tcYear=:y and e.tcCorr=:c").setParameter("y", a).setParameter("c", b).getSingleResult();        
    }
    
    public boolean findTaskByYearCorr(String year, String corr){
        
        boolean existeEnLaTabla = false;
        Short a= new Short(year);
        int b = Integer.parseInt(corr);
        List<EngTaskCard> tarjeta=new ArrayList<EngTaskCard>();
        Query query=em.createQuery("SELECT e FROM EngTaskCard e WHERE e.tcYear=:y and e.tcCorr=:c").setParameter("y", a).setParameter("c", b);
        tarjeta=query.getResultList();
        if(!tarjeta.isEmpty()){
            existeEnLaTabla = true;
        }
        
        
        return existeEnLaTabla; 
        
        
    }
    
    public int idTaskcard(){
        int num=0;
        int n=1;
        try {
            em = getEntityManager();
            Query query = em.createNativeQuery("select nvl(max(a.ID_CARD),0)+1 as id from cont.ENG_TASK_CARD a");
            query.setMaxResults(n);
            String a=(String) query.getSingleResult().toString();         
            num=Integer.parseInt(a);
             
        }catch(Exception e){
            Logger.getLogger(EngTaskCardFacade.class.getName()).log(Level.SEVERE, null, e);
            
        }
        return num;
          
    }
    
}
