/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

import com.aeroman.aees.entities.EngTasksByUserSupVw;
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
 * @author ssibrian
 */
@Stateless
public class EngTasksByUserSupVwFacade extends AbstractFacade<EngTasksByUserSupVw> {

    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    public EngTasksByUserSupVwFacade() {
        super(EngTasksByUserSupVw.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    public List<String> findByHangares(String company){
        List<String> a = new ArrayList();
        try {
            em = getEntityManager();
            Query query = em.createNativeQuery("SELECT e.HGR_CODE FROM CORE.CORE_HANGAR_REAL e where e.CIA_CODE='"+company+"'");            
            a=(List<String>) query.getResultList();
            
            return a; 
        }catch(Exception e){
            Logger.getLogger(EngTasksByUserSupVwFacade.class.getName()).log(Level.SEVERE, null, e);            
        }
        return a;
              
    }
    public List<String> findByRampa(String company){
        List<String> a = new ArrayList();
        try {
            em = getEntityManager();
            Query query = em.createNativeQuery("SELECT e.HGR_CODER FROM CORE.CORE_HANGAR_REAL e where e.CIA_CODE='"+company+"'");            
            a=(List<String>) query.getResultList();
            
            return a; 
        }catch(Exception e){
            Logger.getLogger(EngTasksByUserSupVwFacade.class.getName()).log(Level.SEVERE, null, e);            
        }
        return a;
   
    }
    public List<EngTasksByUserSupVw> findUserCompa(String userCO,String company){
        List<EngTasksByUserSupVw> a = new ArrayList<EngTasksByUserSupVw>();
        try {
            a= (List<EngTasksByUserSupVw>) em.createQuery("SELECT e FROM EngTasksByUserSupVw e WHERE e.usercode=:userC AND e.company=:companyE").setParameter("userC", userCO).setParameter("companyE", company).getResultList();
        }catch(Exception e){
            Logger.getLogger(EngTasksByUserSupVwFacade.class.getName()).log(Level.SEVERE, null, e);            
        }
        return a;
   
    }
    public List<EngTasksByUserSupVw> findCompa(String company){
        List<EngTasksByUserSupVw> a = new ArrayList<EngTasksByUserSupVw>();
        try {
            a= (List<EngTasksByUserSupVw>) em.createQuery("SELECT e FROM EngTasksByUserSupVw e WHERE e.company=:companyE").setParameter("companyE", company).getResultList();
        }catch(Exception e){
            Logger.getLogger(EngTasksByUserSupVwFacade.class.getName()).log(Level.SEVERE, null, e);            
        }
        return a;
   
    }
    
    public List<EngTasksByUserSupVw> listadoEngTasksByUserSupVw() {
        EngTasksByUserSupVw engTasksByUserSupVw = new EngTasksByUserSupVw();
        List<EngTasksByUserSupVw> listadoEngTasksByUserSupVw = new ArrayList<EngTasksByUserSupVw>();
        List<Object[]> listaObjeto = new ArrayList<Object[]>();
        try {
            String consulta = "SELECT ROW_ID, USERCODE, USER_NAME, COMPANY, TASK, COLOR FROM ENG_TASKS_BY_USER_SUP_VW";
            Query query = em.createNativeQuery(consulta);
            listaObjeto = query.getResultList();
            for (int x = 0; x < listaObjeto.size(); x++) {
                engTasksByUserSupVw = new EngTasksByUserSupVw();
                engTasksByUserSupVw.setRowId(new BigInteger(listaObjeto.get(x)[0].toString()));
              
                if (listaObjeto.get(x)[1] != null) {
                    engTasksByUserSupVw.setUsercode(listaObjeto.get(x)[1].toString());
                } else {
                    engTasksByUserSupVw.setUsercode("");
                }
                if (listaObjeto.get(x)[2] != null) {
                    engTasksByUserSupVw.setUserName(listaObjeto.get(x)[2].toString());
                } else {
                    engTasksByUserSupVw.setUserName("");
                }
                if (listaObjeto.get(x)[3] != null) {
                    engTasksByUserSupVw.setCompany(listaObjeto.get(x)[3].toString());
                } else {
                    engTasksByUserSupVw.setCompany("");
                }
                  engTasksByUserSupVw.setTask(new BigInteger(listaObjeto.get(x)[4].toString()));
                  
                if (listaObjeto.get(x)[5] != null) {
                    engTasksByUserSupVw.setColor(listaObjeto.get(x)[5].toString());
                } else {
                    engTasksByUserSupVw.setColor("");
                }
                listadoEngTasksByUserSupVw.add(engTasksByUserSupVw);
            }
        } catch (Exception e) {
            Logger.getLogger(EngTaskListViewFacade.class.getName()).log(Level.SEVERE, null, e);
        }
        return listadoEngTasksByUserSupVw;
    }


    
    

    
    
}
