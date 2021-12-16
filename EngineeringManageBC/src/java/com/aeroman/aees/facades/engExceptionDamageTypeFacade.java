/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

import com.aeroman.aees.entities.CoreAircraftType;
import com.aeroman.aees.entities.EngDamageDim;
import com.aeroman.aees.entities.EngExcepDamage;
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
public class engExceptionDamageTypeFacade extends AbstractFacade<EngExcepDamage> {
   @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    public engExceptionDamageTypeFacade() {
        super(EngExcepDamage.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public int findByDamageByNameExcep(String excepcion){
        int count =0;
        try {
            em = getEntityManager();
            Query query = em.createNativeQuery("SELECT COUNT(*) N FROM ENG.ENG_EXCEP_DAMAGE WHERE EXCEP_DAM_NAME = '" + excepcion.trim() + "'");
            String a2=(String) query.getSingleResult().toString(); 
            count =Integer.parseInt(a2);  
        } catch (Exception er) {
               Logger.getLogger(EngExcepDamage.class.getName()).log(Level.SEVERE, null, er);
        }
         return count;
    }
    
    public boolean tieneManufactAsociados(String excepcion) {
        int count = 0;
        boolean existe = false;
        try {
            em = getEntityManager();
            Query query = em.createNativeQuery("SELECT COUNT(*) FROM ENG.ENG_DT_DIM_BY_MANUF WHERE DAT_ID = (SELECT DAT_ID FROM ENG_DAMAGE_TYPE WHERE DAT_NAME ='" + excepcion.trim() + "')");
            String cant = (String) query.getSingleResult().toString();
            count = Integer.parseInt(cant);
            if (count > 0) {
                existe = true;
            }
        } catch (Exception er) {
            Logger.getLogger(EngExcepDamage.class.getName()).log(Level.SEVERE, null, er);
        }
        return existe;
    }
    
    
    public boolean existeExcep(String excepcion){
        int count =0;
        boolean existe = false;
        try {
            em = getEntityManager();
            Query query = em.createNativeQuery("SELECT COUNT(*) N FROM ENG.ENG_EXCEP_DAMAGE WHERE EXCEP_DAM_NAME = '" + excepcion.trim() + "'");
            String a2=(String) query.getSingleResult().toString(); 
            count =Integer.parseInt(a2);  
            if(count >0){
            existe=true;
            }
                    
        } catch (Exception er) {
               Logger.getLogger(EngExcepDamage.class.getName()).log(Level.SEVERE, null, er);
        }
         return existe;
    }

        public String traerManufAER(String cliente, String ac, String acType) {/* TRAER MANUFACTURADOR CON LOS SIGUIENTRES */
        String Fabricante = "";       
      
        try {
            em = getEntityManager();
            
            String consultaExiste = "SELECT COUNT (HACMAN) HACMAN FROM AER.AER_GEN010A WHERE TRIM(HCUST)='"+cliente+"' AND TRIM(HACREG) ='"+ac+"' AND TRIM(HACTYP)='"+acType+"'";
             Query query1 = em.createNativeQuery(consultaExiste);
            int cantidad = Integer.parseInt(query1.getSingleResult().toString().trim());
            if(cantidad > 0){
             String consulta = "SELECT HACMAN FROM AER.AER_GEN010A WHERE TRIM(HCUST)='"+cliente+"' AND TRIM(HACREG) ='"+ac+"' AND TRIM(HACTYP)='"+acType+"'";
             Query query = em.createNativeQuery(consulta);
             Fabricante = query.getSingleResult().toString().trim();
         
        }
               
            
            
        } catch (Exception e) {
            Logger.getLogger(EngExcepDamage.class.getName()).log(Level.SEVERE, null, e);
        }
        return Fabricante;
    }
    
     
}
