/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aeroman.aees.facades;

import com.aeroman.aees.entities.EngPlantillasEaCoverPart;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EngPlantillasEaCoverPartFacade extends AbstractFacade<EngPlantillasEaCoverPart> {
    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    public EngPlantillasEaCoverPartFacade() {
        super(EngPlantillasEaCoverPart.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public List<EngPlantillasEaCoverPart> findByTipoDocuActivo(String tipoDocumento){
        return (List<EngPlantillasEaCoverPart>)  em.createQuery("SELECT e FROM EngPlantillasEaCoverPart e WHERE e.tipoDocu = :tipoDocu and e.estadoDocu = 'ACT'").setParameter("tipoDocu", tipoDocumento).getResultList() ;
    }
}
