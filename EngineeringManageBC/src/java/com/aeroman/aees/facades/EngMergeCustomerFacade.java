/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;


import com.aeroman.aees.entities.EngCustomer;
import com.aeroman.aees.entities.EngMergeCustomer;
import com.aeroman.aees.entities.EngQuestion;
import com.aeroman.aees.entities.MpplnForeCustomer;
import com.aeroman.aees.entities.grant.SgrCia;
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
public class EngMergeCustomerFacade extends AbstractFacade<EngMergeCustomer> {

    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EngMergeCustomerFacade() {
        super(EngMergeCustomer.class);
    } 
    public List<EngMergeCustomer> findOpco(SgrCia opco){
        List<EngMergeCustomer> engCustomeOpco = new ArrayList();
        Query query;
        try {
            em = getEntityManager();
            query = em.createQuery("SELECT s FROM EngMergeCustomer s  WHERE s.ciaCode=:opcos").setParameter("opcos", opco);;
            engCustomeOpco = query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(EngMergeCustomerFacade.class.getName()).log(Level.SEVERE, null, e);
        }
        return engCustomeOpco;
    }
    /*
    EMC_ID
    CST_ID
    ENG_ID
    CIA_CODE
    EMC_USER_ADD
    EMC_DATE_ADD
    EMC_USER_UPD
    EMC_DATE_UPD
    EMC_MERGE
    */
    
    public List<EngMergeCustomer> findAllEngMergeCustomer() {
        EngMergeCustomer engMergeCustomer = new EngMergeCustomer();
        List<EngMergeCustomer> listadoEngMergeCustomer = new ArrayList<EngMergeCustomer>();
        List<Object[]> listaObjeto = new ArrayList<Object[]>();
        try {
            String consulta = "SELECT EMC_ID, CST_ID, ENG_ID, CIA_CODE, EMC_USER_ADD, EMC_DATE_ADD, EMC_USER_UPD, EMC_DATE_UPD, EMC_MERGE FROM ENG_MERGE_CUSTOMER";
        
            Query query = em.createNativeQuery(consulta);
            listaObjeto = query.getResultList();
            for (int x = 0; x < listaObjeto.size(); x++) {
                engMergeCustomer = new EngMergeCustomer();
                if (listaObjeto.get(x)[0] != null) {
                    engMergeCustomer.setEmcId(new BigDecimal(listaObjeto.get(x)[0].toString()));
                }
                if (listaObjeto.get(x)[1] != null) {
                    try {
                        Query queryDT = em.createQuery("SELECT m FROM MpplnForeCustomer m WHERE m.cstId = :cstId").setParameter("cstId", new BigDecimal(listaObjeto.get(x)[1].toString()));
                        MpplnForeCustomer customer = (MpplnForeCustomer) queryDT.getSingleResult();
                        engMergeCustomer.setCstId(customer);
                    } catch (Exception e) {
                        Logger.getLogger(EngMeasureFacade.class.getName()).log(Level.SEVERE, null, e);
                    }
                }
                if (listaObjeto.get(x)[2] != null) {
                    try {
                        Query queryEC = em.createQuery("SELECT e FROM EngCustomer e WHERE e.engId = :engId").setParameter("engId", listaObjeto.get(x)[2].toString());
                        EngCustomer engCustomer = (EngCustomer) queryEC.getSingleResult();
                        engMergeCustomer.setEngId(engCustomer);
                    } catch (Exception e) {
                        Logger.getLogger(EngMeasureFacade.class.getName()).log(Level.SEVERE, null, e);
                    }
                }
                if (listaObjeto.get(x)[3] != null) {
                    try {
                        Query querySgcia = em.createQuery("SELECT s FROM SgrCia s WHERE s.ciaCode = :ciaCode").setParameter("ciaCode", listaObjeto.get(x)[3].toString());
                        SgrCia sgrCia = (SgrCia) querySgcia.getSingleResult();
                        engMergeCustomer.setCiaCode(sgrCia);
                    } catch (Exception e) {
                        Logger.getLogger(EngMeasureFacade.class.getName()).log(Level.SEVERE, null, e);
                    }
                }
   
                if (listaObjeto.get(x)[4] != null) {
                    engMergeCustomer.setEmcUserAdd(listaObjeto.get(x)[4].toString());
                }
                if (listaObjeto.get(x)[5] != null) {
                    DateFormat formatof = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date fechaEmcDateAdd = formatof.parse(listaObjeto.get(x)[5].toString());
                    engMergeCustomer.setEmcDateAdd(fechaEmcDateAdd);
                }
                if (listaObjeto.get(x)[6] != null) {
                    engMergeCustomer.setEmcUserUpd(listaObjeto.get(x)[6].toString());
                }

                if (listaObjeto.get(x)[7] != null) {
                    DateFormat formatof = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date fechaEmcDateUpd = formatof.parse(listaObjeto.get(x)[7].toString());
                    engMergeCustomer.setEmcDateUpd(fechaEmcDateUpd);
                }
             
                if (listaObjeto.get(x)[8] != null) {
                       engMergeCustomer.setEmcMerge(listaObjeto.get(x)[8].toString());
                }

                listadoEngMergeCustomer.add(engMergeCustomer);
            }
        } catch (Exception e) {
            Logger.getLogger(EngMeasureFacade.class.getName()).log(Level.SEVERE, null, e);
        }
        return listadoEngMergeCustomer;
    }

    
}
