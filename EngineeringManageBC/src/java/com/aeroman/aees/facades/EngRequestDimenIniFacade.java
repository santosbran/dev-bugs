/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

import com.aeroman.aees.entities.EngRequestDimenIni;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author vjuarez
 */
@Stateless
public class EngRequestDimenIniFacade extends AbstractFacade<EngRequestDimenIni> {
    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EngRequestDimenIniFacade() {
        super(EngRequestDimenIni.class);
    }
    public List<EngRequestDimenIni> findBySelectDimenLocal(BigInteger ers){
        return em.createQuery("SELECT e FROM EngRequestDimenIni e WHERE e.redIdRequest.reqMessageid =:obj and e.redIdDimensionManfIni.ubicationDim='Location' order by e.redIdDimensionManfIni.orden asc ").setParameter("obj", ers).getResultList();        
    }
    public List<EngRequestDimenIni> findBySelectDimenCheck(BigInteger ers){
        return em.createQuery("SELECT e FROM EngRequestDimenIni e WHERE e.redIdRequest.reqMessageid =:obj and e.redIdDimensionManfIni.ubicationDim='Dimension' and e.redIdDimensionManfIni.dimId.typeControl='checkBox' and e.redIdDimensionManfIni.dimId.dimName in('Milimeter', 'Inches') order by e.redIdDimensionManfIni.orden asc").setParameter("obj", ers).getResultList();        
    }
    public List<EngRequestDimenIni> findBySelectDimen(BigInteger ers){
        return em.createQuery("SELECT e FROM EngRequestDimenIni e WHERE e.redIdRequest.reqMessageid =:obj and e.redIdDimensionManfIni.ubicationDim='Dimension' and e.redIdDimensionManfIni.dimId.typeControl='textBox' order by e.redIdDimensionManfIni.orden asc").setParameter("obj", ers).getResultList();        
    }
    public List<EngRequestDimenIni> findBySelectDimenBlend_Dent(BigInteger ers){
        return em.createQuery("SELECT e FROM EngRequestDimenIni e WHERE e.redIdRequest.reqMessageid =:obj and e.redIdDimensionManfIni.ubicationDim='Dimension' and e.redIdDimensionManfIni.datId.datId in(6,2) and e.redIdDimensionManfIni.dimId.dimName != 'Milimeter'  and e.redIdDimensionManfIni.dimId.dimName != 'Inches' order by e.redIdDimensionManfIni.orden asc").setParameter("obj", ers).getResultList();        
    }
    public List<EngRequestDimenIni> findBySelectDimenNearby(BigInteger ers){
        return em.createQuery("SELECT e FROM EngRequestDimenIni e WHERE e.redIdRequest.reqMessageid =:obj and e.redIdDimensionManfIni.ubicationDim='Nearby_Dimension' order by e.redIdDimensionManfIni.orden asc").setParameter("obj", ers).getResultList();        
    }
    
}
