/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

import com.aeroman.aees.entities.EngActor;
import com.aeroman.aees.entities.EngReqStatus;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;
/**
 *
 * @author pc
 */
@Stateless
public class EngReqStatusFacade extends AbstractFacade<EngReqStatus> {
    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    public EngReqStatusFacade() {
        super(EngReqStatus.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }        
    
    
    
    public List<EngReqStatus> findByStatus(){
        return em.createQuery("SELECT e FROM  EngReqStatus e WHERE e.estStatus='A'").getResultList();
    }
    
    public EngReqStatus findById(String a){
        BigInteger ax= new BigInteger(a);
        return (EngReqStatus)em.createQuery("SELECT e FROM  EngReqStatus e WHERE e.estId=:id").setParameter("id", ax).getSingleResult();
    }
    
    public EngReqStatus findByCode(String a){        
        return (EngReqStatus)em.createQuery("SELECT e FROM  EngReqStatus e WHERE e.estCode=:code").setParameter("code", a).getSingleResult();
    }
    
    public int existeEnESR(String pDisposition){
        int i = 1;
        
        int pCount = 0;        
        try {
            em = getEntityManager();
            Query query = em.createNativeQuery("SELECT COUNT(*) N FROM ENG.ENG_REQUEST WHERE TRIM(REQ_STATUS) = '" + pDisposition.trim() + "'");
            query.setMaxResults(i);
            String a2=(String) query.getSingleResult().toString(); 
            pCount =Integer.parseInt(a2);  
        } catch (Exception e) {
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);
        }
        return pCount;
    }
    
    
    public List<EngReqStatus> findAllEngReqStatus() {
        EngReqStatus engReqStatus = new EngReqStatus();
        List<EngReqStatus> listadoEngReqStatus = new ArrayList<EngReqStatus>();
        List<Object[]> listaObjeto = new ArrayList<Object[]>();
        try {
            String consulta = "SELECT EST_ID, EST_CODE, EST_DESC, EST_STATUS, EST_FECHA_INS, EST_USER_INS, EST_FECHA_ACT, EST_USER_ACT, EST_IDACTOR FROM ENG_REQ_STATUS";
            Query query = em.createNativeQuery(consulta);
            listaObjeto = query.getResultList();
            for (int x = 0; x < listaObjeto.size(); x++) {
                engReqStatus = new EngReqStatus();
                if (listaObjeto.get(x)[0] != null) {
                    engReqStatus.setEstId(new BigInteger(listaObjeto.get(x)[0].toString()));
                }
                 if (listaObjeto.get(x)[1] != null) {
                    engReqStatus.setEstCode(listaObjeto.get(x)[1].toString());
                }
                 if (listaObjeto.get(x)[2] != null) {
                    engReqStatus.setEstDesc(listaObjeto.get(x)[2].toString());
                }
                 if (listaObjeto.get(x)[3] != null) {
                    engReqStatus.setEstStatus(listaObjeto.get(x)[3].toString());
                }
                 if (listaObjeto.get(x)[4] != null) {
                   DateFormat formatof = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date fechains = formatof.parse(listaObjeto.get(x)[4].toString());
                   engReqStatus.setEstFechaIns(fechains);
                }
           if (listaObjeto.get(x)[5] != null) {
                    engReqStatus.setEstUserIns(listaObjeto.get(x)[5].toString());
                }
           if (listaObjeto.get(x)[6] != null) {
                   DateFormat formatof = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date fechaactDate = formatof.parse(listaObjeto.get(x)[6].toString());
                   engReqStatus.setEstFechaAct(fechaactDate);
                }
           if (listaObjeto.get(x)[7] != null) {
                    engReqStatus.setEstUserAct(listaObjeto.get(x)[7].toString());
                }
                if (listaObjeto.get(x)[8] != null) {
                    try {
                            Query queryEC = em.createQuery("SELECT e FROM EngActor e WHERE e.actId = :actId").setParameter("actId", new BigDecimal(listaObjeto.get(x)[8].toString()));
                        EngActor engActor = (EngActor) queryEC.getSingleResult();
                         engReqStatus.setEstIdactor(engActor);
                    } catch (Exception e) {
                        Logger.getLogger(EngMeasureFacade.class.getName()).log(Level.SEVERE, null, e);
                    }
                }
           
   
                listadoEngReqStatus.add(engReqStatus);
            }
        } catch (Exception e) {
            Logger.getLogger(EngMeasureFacade.class.getName()).log(Level.SEVERE, null, e);
        }
        return listadoEngReqStatus;
    }
    
    
    
}
