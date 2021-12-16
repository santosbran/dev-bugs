/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

import com.aeroman.aees.entities.ContDefaultMail;
import com.aeroman.aees.entities.EngMergeCustomer;
import com.aeroman.aees.entities.MpplnForeCustomer;
import com.aeroman.aees.entities.grant.SgrCia;
import java.math.BigDecimal;
import java.math.BigInteger;
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
public class ContDefaultMailFacade extends AbstractFacade<ContDefaultMail> {
    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContDefaultMailFacade() {
        super(ContDefaultMail.class);
    }
   
    public List<ContDefaultMail> findAllContDefaultMail() {
        ContDefaultMail contDefaultMail = new ContDefaultMail();
        List<ContDefaultMail> listadoContDefaultMail = new ArrayList<ContDefaultMail>();
        List<Object[]> listaObjeto = new ArrayList<Object[]>();
        try {
            String consulta = "SELECT DEF_ID, DEF_MAIL, DEF_CIA_CODE, DEF_CUSTOMER, DEF_USER_ADD, DEF_DATE_ADD, DEF_USER_UPD, DEF_DATE_UPD FROM CONT.CONT_DEFAULT_MAIL";
            Query query = em.createNativeQuery(consulta);
            listaObjeto = query.getResultList();
            for (int x = 0; x < listaObjeto.size(); x++) {
                contDefaultMail = new ContDefaultMail();
               
                   if (listaObjeto.get(x)[0] != null) {
                    contDefaultMail.setDefId(new BigDecimal(listaObjeto.get(x)[0].toString()));
                }
                if (listaObjeto.get(x)[1] != null) {
                    contDefaultMail.setDefMail(listaObjeto.get(x)[1].toString());
                } 
                   if (listaObjeto.get(x)[2] != null) {
                    try {
                        Query querySgcia = em.createQuery("SELECT s FROM SgrCia s WHERE s.ciaCode = :ciaCode").setParameter("ciaCode", listaObjeto.get(x)[2].toString());
                        SgrCia sgrCia = (SgrCia) querySgcia.getSingleResult();
                        contDefaultMail.setDefCiaCode(sgrCia);
                    } catch (Exception e) {
                        Logger.getLogger(EngMeasureFacade.class.getName()).log(Level.SEVERE, null, e);
                    }
                } 
                if (listaObjeto.get(x)[3] != null) {
                        try {
                        Query queryDT = em.createQuery("SELECT e FROM EngMergeCustomer e WHERE e.emcId = :emcId").setParameter("emcId", new BigDecimal(listaObjeto.get(x)[3].toString()));
                        EngMergeCustomer engMergeCustomer = (EngMergeCustomer) queryDT.getSingleResult();
                        contDefaultMail.setDefCustomer(engMergeCustomer);
                    } catch (Exception e) {
                        Logger.getLogger(EngMeasureFacade.class.getName()).log(Level.SEVERE, null, e);
                    }
                }
                if (listaObjeto.get(x)[4] != null) {
                    contDefaultMail.setDefUserAdd(listaObjeto.get(x)[4].toString());
                }
                if (listaObjeto.get(x)[5] != null) {
                   DateFormat formatof = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date defdateadd = formatof.parse(listaObjeto.get(x)[5].toString());
                      contDefaultMail.setDefDateAdd(defdateadd);
                } 
               
                     if (listaObjeto.get(x)[6] != null) {
                    contDefaultMail.setDefUserUpd(listaObjeto.get(x)[6].toString());
                }
                if (listaObjeto.get(x)[7] != null) {
                   DateFormat formatof = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date defdateupdt = formatof.parse(listaObjeto.get(x)[7].toString());
                      contDefaultMail.setDefDateUpd(defdateupdt);
                } 
              
                listadoContDefaultMail.add(contDefaultMail);
            }
        } catch (Exception e) {
            Logger.getLogger(ContDefaultMailFacade.class.getName()).log(Level.SEVERE, null, e);
        }
        return listadoContDefaultMail;
    }
    
    
}
