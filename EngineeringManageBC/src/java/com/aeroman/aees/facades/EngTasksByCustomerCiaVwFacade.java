/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

import com.aeroman.aees.entities.EngTasksByCustomerCiaVw;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

/**
 *
 * @author ssibrian
 */
@Stateless
public class EngTasksByCustomerCiaVwFacade extends AbstractFacade<EngTasksByCustomerCiaVw> {

    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    public EngTasksByCustomerCiaVwFacade() {
        super(EngTasksByCustomerCiaVw.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    
    
    public List<EngTasksByCustomerCiaVw> findByUserCia(String cia){
        return em.createQuery("SELECT e FROM EngTasksByCustomerCiaVw e WHERE e.company = :cia ORDER BY e.engName ASC").setParameter("cia", cia).getResultList();
    }
    
    public void spTrackingWO(String status,String workOrder,Date  fstrart,Date  ffinal,String  codeuser){
      
        try {    

             em = getEntityManager();
             StoredProcedureQuery  query = em.createStoredProcedureQuery("SP_TRACKIGSWO");
                                            query.registerStoredProcedureParameter("STATUS",String.class, ParameterMode.INOUT);
                                            query.registerStoredProcedureParameter("WORKORDER",String.class,ParameterMode.INOUT);
                                            query.registerStoredProcedureParameter("FSTART",Date.class, ParameterMode.INOUT);
                                            query.registerStoredProcedureParameter("FFINAL",Date.class, ParameterMode.INOUT);
                                            query.registerStoredProcedureParameter("CODUSER",String.class, ParameterMode.INOUT);
                                            
                                            query.setParameter("STATUS", status );
                                            query.setParameter("WORKORDER", workOrder);
                                            query.setParameter("FSTART",fstrart);
                                            query.setParameter("FFINAL",ffinal);
                                            query.setParameter("CODUSER",codeuser);
            query.execute();
        } catch (Exception e) {
           Logger.getLogger(EngTasksByCustomerCiaVwFacade.class.getName()).log(Level.SEVERE,null,e);  
        }

    }
    public void spDisposotionWO(String status1,String workOrder1,Date  fstrart1,Date  ffinal1,String  codeuser1){
      
        try {
             
             em = getEntityManager();
             StoredProcedureQuery  query = em.createStoredProcedureQuery("SP_DISPOSITION_WO");
                                            query.registerStoredProcedureParameter("STATUS",String.class, ParameterMode.INOUT);
                                            query.registerStoredProcedureParameter("WORKORDER",String.class,ParameterMode.INOUT);
                                            query.registerStoredProcedureParameter("FSTART",Date.class, ParameterMode.INOUT);
                                            query.registerStoredProcedureParameter("FFINAL",Date.class, ParameterMode.INOUT);
                                            query.registerStoredProcedureParameter("CODUSER",String.class, ParameterMode.INOUT);
                                            
                                            query.setParameter("STATUS", status1);
                                            query.setParameter("WORKORDER", workOrder1);
                                            query.setParameter("FSTART",fstrart1);
                                            query.setParameter("FFINAL",ffinal1);                                            
                                            query.setParameter("CODUSER",codeuser1);
            query.execute();
        } catch (Exception e) {
           Logger.getLogger(EngTasksByCustomerCiaVwFacade.class.getName()).log(Level.SEVERE,null,e);  
        }

    }
    
}
