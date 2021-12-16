/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades.grant;

import com.aeroman.aees.entities.grant.CoreEngineersListV;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Usuario
 */
@Stateless
public class CoreEngineersListVFacade extends AbstractFacade<CoreEngineersListV> {
    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    public CoreEngineersListVFacade() {
        super(CoreEngineersListV.class);
    }
    
    @Override
    protected EntityManager getEntityManagerf() {
        return em;
    }

    
    
    public List<CoreEngineersListV> findAllJpa(){
        
        CoreEngineersListV contC;
        List<CoreEngineersListV> contChList=new ArrayList();
        String sql="SELECT CODIGO86 FROM ENG.Core_Engineers_List_V e ";
        List<Object> checks;
        Query query=em.createNativeQuery(sql);
        checks=query.getResultList();
                
        for(Object listObj : checks){
            contC= new CoreEngineersListV();
            contC.setCodigo86((String) listObj);
            contChList.add(contC);
        }
        
        return contChList; 
    }
}
