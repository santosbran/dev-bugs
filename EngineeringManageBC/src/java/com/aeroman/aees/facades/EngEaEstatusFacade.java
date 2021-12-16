/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

import com.aeroman.aees.entities.EngEaEstatus;
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
 * @author pc
 */
@Stateless
public class EngEaEstatusFacade extends AbstractFacade<EngEaEstatus> {
    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    public EngEaEstatusFacade() {
        super(EngEaEstatus.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<EngEaEstatus> findAllEngEaEstatus() {
        EngEaEstatus engEaEstatus = new EngEaEstatus();
        List<EngEaEstatus> listadoEngEaEstatus = new ArrayList<EngEaEstatus>();
        List<Object[]> listaObjeto = new ArrayList<Object[]>();
       
        try {
            String consulta = "SELECT EAE_ID, EAE_TYPE, EAE_EST_NAME FROM ENG_EA_ESTATUS";            
            Query query = em.createNativeQuery(consulta);
            listaObjeto = query.getResultList();
            for (int x = 0; x < listaObjeto.size(); x++) {
                engEaEstatus = new EngEaEstatus();
                if (listaObjeto.get(x)[0] != null) {
                    engEaEstatus.setEaeId(listaObjeto.get(x)[0].toString());
                }
                if (listaObjeto.get(x)[1] != null) {
                    engEaEstatus.setEaeType(listaObjeto.get(x)[1].toString());
                }
                if (listaObjeto.get(x)[2] != null) {
                    engEaEstatus.setEaeEstName(listaObjeto.get(x)[2].toString());
                }
                listadoEngEaEstatus.add(engEaEstatus);
            }
        } catch (Exception e) {
            Logger.getLogger(EngEaEstatusFacade.class.getName()).log(Level.SEVERE, null, e);
        }
        return listadoEngEaEstatus;
    }
    
    public EngEaEstatus findNameId(String c){
        return (EngEaEstatus)getEntityManager().createQuery("SELECT e FROM EngEaEstatus e WHERE e.eaeId=:id").setParameter("id", c).getSingleResult();
    }
    
}
