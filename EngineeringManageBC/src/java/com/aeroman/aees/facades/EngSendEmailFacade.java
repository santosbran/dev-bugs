/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Moy
 */
@Stateless
public class EngSendEmailFacade implements Serializable {
    @PersistenceContext
    private EntityManager em;
    private EntityManagerFactory emf = null;
    
     public EngSendEmailFacade(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public EngSendEmailFacade(){
        emf = Persistence.createEntityManagerFactory("EngineeringManageBCPU");
    }
    

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    
    
     
     public Object verificaRole(String usuario){
        try {       
            em = getEntityManager();            
            Query query=em.createNativeQuery("SELECT   u.CODUSR username, u.CODUSR codigoM4, u.USR_COD_ROL roleCode, u.USR_PASSWORD password, " +
                                "emp.dge_primer_nom|| ' '|| emp.dge_segundo_nom|| ' '|| emp.dge_primer_ape|| ' '|| emp.dge_segundo_ape name," +
                                "1 flgCode, USR_TIPO usertipo  FROM EOS.EOS_USERS u, rrhh.pla_dge_general_empleado emp WHERE u.CODUSR = '"+usuario+"' " +
                                "AND u.CODUSR = emp.dge_codigo_anterior AND USR_TIPO = 'I' " +
                                " union SELECT CODUSR username, CODUSR codigoM4, USR_COD_ROL roleCode, USR_PASSWORD password, NAME name, 1 flgCode, USR_TIPO usertipo " +
                                " FROM EOS.EOS_USERS u, EOS.ADM_ROLES r WHERE u.USR_COD_ROL = r.ROL_CODIGO and CODUSR = '"+usuario+"' " +
                                " AND USR_TIPO = 'E'");  
            
            List results= query.getResultList();
            if(!results.isEmpty()) {
                return results.get(0);
            }
         
        } catch (Exception e) {
            Logger.getLogger(EngSendEmailFacade.class.getName()).log(Level.SEVERE,null,e);
        }
        finally{
                em.close();
        }
        return null;   
    }
   
}
