/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

import com.aeroman.aees.entities.CoreAircraftType;
import com.aeroman.aees.entities.EngDamageQuestion;
import com.aeroman.aees.entities.EngDamageType;
import com.aeroman.aees.entities.EngQuestion;
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
public class EngDamageQuestionFacade extends AbstractFacade<EngDamageQuestion> {
    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EngDamageQuestionFacade() {
        super(EngDamageQuestion.class);
    }
    public List<EngDamageQuestion> findDamageQuestion(EngDamageType id,CoreAircraftType idAircraftType) {
        List<EngDamageQuestion> location = new ArrayList();
       
        Query query;
        try {
            em = getEntityManager();
            query = em.createQuery("SELECT e FROM EngDamageQuestion e WHERE e.datId = :dxqId and e.arctypId=:arctypIds").setParameter("dxqId", id).setParameter("arctypIds", idAircraftType);
            location = query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(EngDamageQuestionFacade.class.getName()).log(Level.SEVERE, null, e);
        }
        return location;
    }
    
    public int existeEnESR(BigDecimal pIdDamQues){
        int i = 1;
        
        int pCount = 0;        
        try {
            em = getEntityManager();
            Query query = em.createNativeQuery("SELECT COUNT(*) N FROM ENG.ENG_REQUEST_QUESTION WHERE DXQ_ID = " + pIdDamQues);
            query.setMaxResults(i);
            String a2=(String) query.getSingleResult().toString(); 
            pCount =Integer.parseInt(a2);  
        } catch (Exception e) {
            Logger.getLogger(EngDamageQuestionFacade.class.getName()).log(Level.SEVERE, null, e);
        }
        return pCount;
    }
    
    public List<EngDamageQuestion> findAllEngDamageQuestion() {
        EngDamageQuestion engDamageQuestion = new EngDamageQuestion();
        List<EngDamageQuestion> listadoEngDamageQuestion = new ArrayList<EngDamageQuestion>();
        List<Object[]> listaObjeto = new ArrayList<Object[]>();
        List<Object[]> listaObjetoDT = new ArrayList<Object[]>();
        try {
            String consulta = "SELECT  DXQ_ID, DAT_ID, QUE_ID, DXQ_USER_INS, DXQ_DATE_INS, DXQ_USER_UPD, DXQ_DATE_UPD, ARCTYP_ID  FROM ENG_DAMAGE_QUESTION";
            //    String consultaDT = "SELECT DAT_ID, DAT_NAME, DAT_DESCRIPTION, DAT_STATE, DAT_USER_ADD, DAT_DATE_ADD, DAT_USER_UPD, DAT_DATE_UPD, DAT_USER_DLT, DAT_DATE_DLT FROM ENG_DAMAGE_TYPE WHERE DAT_ID=";
            Query query = em.createNativeQuery(consulta);
            listaObjeto = query.getResultList();
            for (int x = 0; x < listaObjeto.size(); x++) {
                engDamageQuestion = new EngDamageQuestion();
                if (listaObjeto.get(x)[0] != null) {
                    engDamageQuestion.setDxqId(new BigDecimal(listaObjeto.get(x)[0].toString()));
                }
                if (listaObjeto.get(x)[1] != null) {
                    try {
                        Query queryDT = em.createQuery("SELECT e FROM EngDamageType e WHERE e.datId = :datId").setParameter("datId", new BigDecimal(listaObjeto.get(x)[1].toString()));
                        EngDamageType engDamageType = (EngDamageType) queryDT.getSingleResult();
                        engDamageQuestion.setDatId(engDamageType);
                    } catch (Exception e) {
                        Logger.getLogger(EngMeasureFacade.class.getName()).log(Level.SEVERE, null, e);
                    }
                }
                if (listaObjeto.get(x)[2] != null) {
                    try {
                        Query queryEQ = em.createQuery("SELECT e FROM EngQuestion e WHERE e.queId = :queId").setParameter("queId", new BigDecimal(listaObjeto.get(x)[2].toString()));
                        EngQuestion engQuestion = (EngQuestion) queryEQ.getSingleResult();
                        engDamageQuestion.setQueId(engQuestion);
                    } catch (Exception e) {
                        Logger.getLogger(EngMeasureFacade.class.getName()).log(Level.SEVERE, null, e);
                    }
                }
       
                if (listaObjeto.get(x)[3] != null) {
                    engDamageQuestion.setDxqUserIns(listaObjeto.get(x)[3].toString());
                }
                if (listaObjeto.get(x)[4] != null) {
                    DateFormat formatof = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date fechaDxqDateIns = formatof.parse(listaObjeto.get(x)[4].toString());
                    engDamageQuestion.setDxqDateIns(fechaDxqDateIns);
                }
                if (listaObjeto.get(x)[5] != null) {
                    engDamageQuestion.setDxqUserUpd(listaObjeto.get(x)[5].toString());
                }

                if (listaObjeto.get(x)[6] != null) {
                    DateFormat formatof = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date fechaDxqDateUpd = formatof.parse(listaObjeto.get(x)[6].toString());
                    engDamageQuestion.setDxqDateUpd(fechaDxqDateUpd);
                }
                if (listaObjeto.get(x)[7] != null) {
                    try {
                        Query queryEQ = em.createQuery("SELECT c FROM CoreAircraftType c WHERE c.arctypId = :arctypId").setParameter("arctypId", new BigDecimal(listaObjeto.get(x)[7].toString()));
                        CoreAircraftType coreAircraftType = (CoreAircraftType) queryEQ.getSingleResult();
                        engDamageQuestion.setArctypId(coreAircraftType);
                    } catch (Exception e) {
                        Logger.getLogger(EngMeasureFacade.class.getName()).log(Level.SEVERE, null, e);
                    }
                }

                listadoEngDamageQuestion.add(engDamageQuestion);
            }
        } catch (Exception e) {
            Logger.getLogger(EngMeasureFacade.class.getName()).log(Level.SEVERE, null, e);
        }
        return listadoEngDamageQuestion;
    }

    
    
}
