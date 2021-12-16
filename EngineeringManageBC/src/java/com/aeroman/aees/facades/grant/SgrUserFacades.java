/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades.grant;

import com.aeroman.aees.entities.grant.SgrUser;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Usuario
 */
@Stateless
public class SgrUserFacades extends AbstractFacade<SgrUser> {
    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    public SgrUserFacades() {
        super(SgrUser.class);
    }
    
    @Override
    protected EntityManager getEntityManagerf() {
        return em;
    }

    
    
    public SgrUser findSelectUser(String codigo86){
        SgrUser users= new  SgrUser(); 
        if (codigo86==null){
            users= new  SgrUser(); 
        }else{
            users = (SgrUser) em.createQuery("SELECT e FROM SgrUser e WHERE e.codigo86 = :codigo86 ").setParameter("codigo86", codigo86).getSingleResult();
        }
        return users;
       
    }
}
