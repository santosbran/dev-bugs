/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

import com.aeroman.aees.entities.EngMeasure;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author vjuarez
 */
@Stateless
public class EngMeasureFacade extends AbstractFacade<EngMeasure> {
    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EngMeasureFacade() {
        super(EngMeasure.class);
    }
    
    public int existeEnESR(String pDescripcion){
        int i = 1;
        
        int pCount = 0;        
        try {
            em = getEntityManager();
            Query query = em.createNativeQuery("SELECT COUNT(*) N FROM ENG.ENG_REQUEST_DIMEN  WHERE TRIM(RED_MEASURE) = '" + pDescripcion.trim() + "'");
            query.setMaxResults(i);
            String a2=(String) query.getSingleResult().toString(); 
            pCount =Integer.parseInt(a2);  
        } catch (Exception e) {
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);
        }
        return pCount;
    }
    
        public List<EngMeasure> findAllTaskListView() {
        EngMeasure engMeasure = new EngMeasure();
        List<EngMeasure> listadoEngMeasure = new ArrayList<EngMeasure>();
        List<Object[]> listaObjeto = new ArrayList<Object[]>();
        try {
            String consulta = "SELECT  ENG_ID, ENG_MEASURE  FROM ENG_MEASURE";
            Query query = em.createNativeQuery(consulta);
            listaObjeto = query.getResultList();
            for (int x = 0; x < listaObjeto.size(); x++) {
                engMeasure = new EngMeasure();
                if (listaObjeto.get(x)[0] != null) {
                    engMeasure.setEngId(new BigDecimal(listaObjeto.get(x)[0].toString()));
                }
                if (listaObjeto.get(x)[1] != null) {
                    engMeasure.setEngMeasure(listaObjeto.get(x)[1].toString());
                } else {
                    engMeasure.setEngMeasure("");
                }
                listadoEngMeasure.add(engMeasure);
            }
        } catch (Exception e) {
            Logger.getLogger(EngMeasureFacade.class.getName()).log(Level.SEVERE, null, e);
        }
        return listadoEngMeasure;
    }

    
    
    
}
