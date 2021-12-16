package com.aeroman.aees.facades;

import com.aeroman.aees.entities.EngTabEcrByCusVW;
import com.aeroman.aees.entities.EngTabEsrnwsVw;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EngTabEcrByCusVWFacade extends AbstractFacade<EngTabEcrByCusVW>{
    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EngTabEcrByCusVWFacade() {
        super(EngTabEcrByCusVW.class);
    }
    
    public List<EngTabEcrByCusVW> findECRByCustomer(String company, String customer){
        return em.createQuery("SELECT e FROM EngTabEcrByCusVW e WHERE e.tipoSolicitud = 'ECR' AND e.company=:com AND e.reqCustomer=:customer ").setParameter("com", company).setParameter("customer", customer).getResultList();        
    }
}
