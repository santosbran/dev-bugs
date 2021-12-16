/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

import com.aeroman.aees.entities.EngReqResponses;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

/**
 *
 * @author pc
 */
@Stateless                                               
public class EngReqResponsesFacade extends AbstractFacade<EngReqResponses> {
    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    public EngReqResponsesFacade() {
        super(EngReqResponses.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public String validarCorreoPla(String idUser){
        String email="NA";       
        try {
            em = getEntityManager();
            Query query = em.createNativeQuery("SELECT cia.DGE_EMAIL AS EMAIL FROM RRHH.PLA_DGE_EMPLEADO_CIA cia WHERE cia.dge_codigo_anterior ='"+idUser+"' AND cia.DGE_ESTADO='A'" );
            query.setMaxResults(1);
            email=(String) query.getSingleResult().toString();  
        } catch (Exception e) {
            email="NA";
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);
        }
        return email;
    }
    public String validarCorreoProc(String idUser){
        String email2="NA";       
        try {
            em = getEntityManager();
            Query query2 = em.createNativeQuery("SELECT users.email AS EMAIL INTO mailSender from PROCESOS.SGR_USER users WHERE users.CODIGO86 ='"+idUser+"'");
            query2.setMaxResults(1);
            email2=(String) query2.getSingleResult().toString();  
        } catch (Exception e) {
            email2="NA";
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);
        }
        return email2;
    }
            

    
    
    public void executeEnvioCorreoTracking(EngReqResponses esr, String usuario){
      
        try {
             em = getEntityManager();
             StoredProcedureQuery  query = em.createStoredProcedureQuery("MAIL_ENG_TRACKING");
                                            query.registerStoredProcedureParameter("p_idmessageid",Integer.class, ParameterMode.INOUT);
                                            query.registerStoredProcedureParameter("p_idusuario",String.class,ParameterMode.INOUT);
                                            query.registerStoredProcedureParameter("p_coderesponse",Integer.class, ParameterMode.INOUT);
                                            
                                            query.setParameter("p_idmessageid", esr.getReqMessageid() );
                                            query.setParameter("p_idusuario", usuario);
                                            query.setParameter("p_coderesponse", esr.getResId().toBigInteger());
            query.execute();
        } catch (Exception e) {
            Logger.getLogger(EngReqResponsesFacade.class.getName()).log(Level.SEVERE,null,e);
        }

    }
    
    public void executeEnvioCorreoTrackingEA(int esr,int pdf, String usuario){
      
        try {
             em = getEntityManager();
             StoredProcedureQuery  query = em.createStoredProcedureQuery("MAIL_ENG_TRACKING_EA");
                                            query.registerStoredProcedureParameter("p_idmessageid",Integer.class, ParameterMode.IN);
                                            query.registerStoredProcedureParameter("p_idusuario",String.class,ParameterMode.IN);
                                            query.registerStoredProcedureParameter("p_idpdf",Integer.class, ParameterMode.IN);
                                            
                                            query.setParameter("p_idmessageid", esr );
                                            query.setParameter("p_idusuario", usuario);
                                            query.setParameter("p_idpdf", pdf);
            query.execute();
        } catch (Exception e) {
            Logger.getLogger(EngReqResponsesFacade.class.getName()).log(Level.SEVERE,null,e);
        }

    }
    
    public List<EngReqResponses> findTrackingsByEsr(BigInteger reqMessageid){
        return (List<EngReqResponses>)  em.createQuery("SELECT e FROM EngReqResponses e WHERE e.reqMessageid = :reqMessageid").setParameter("reqMessageid", reqMessageid).getResultList() ;
    }
    
    
    public List<EngReqResponses> findAdj(BigDecimal id) {
        List<EngReqResponses> locationes = new ArrayList();
       
        Query query;
        try {
            query = em.createQuery("SELECT e FROM EngReqResponses e WHERE e.resId = :resId").setParameter("resId", id);
            locationes = query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(MsjAdjuntosFacade.class.getName()).log(Level.SEVERE, null, e);
        }
        return locationes;
    }
    
    //Validar mayores:
    //RES_COD_MSJ
    //RES_CORR_ESR
    //RES_RESP_PRI
    //RES_SEG_ENG
     /*
    public int Mayor() {
         return (int)em.createQuery("select max(t.id)+1 from taShit t").getSingleResult();
    }*/
    //max = engReqResponsesFacade.maxCorrESR(numESR,reCorr,reqYear);
    
    public String validaESR(int ESR, String reCorr, String reqYear) {
        int valor = 0;
        String pointer = "";
        try {
            BigDecimal max = new BigDecimal("0");
            if ((ESR == 0) || (reCorr.trim().isEmpty()) || (reCorr == null) || (reqYear.trim().isEmpty()) || (reqYear == null)) {
                max = new BigDecimal(0);
            } else {
                Query q = getEntityManager().createNativeQuery("SELECT Count(*) As Cant FROM ENG_REQUEST "
                        + " WHERE  REQ_STATUS IN('FPP','NFA')  AND ata_numata =" + ESR + " AND req_corr = '" + reCorr.trim() + "' AND substr(req_year, 3,2) =" + reqYear.trim());
                max = (BigDecimal) q.getSingleResult();
            }
            valor = max.intValue();
            if (valor > 0) {
                pointer = "pointer-events:none; opacity:0.4;";
            } else {
                pointer = "pointer-events:auto;";
            }
            return pointer;
        } catch (Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
            return pointer;
        }
    }
    
        //Update ENG_REQ_RESPONSES campos adicionados:
        public int updateReq(String resCodMsj,int reqMessageid,String resCorrEsr,String resRespPri,String resSegEng,String resFirstResp)throws SQLException {
            try{
            Query sql =em.createNativeQuery("UPDATE ENG_REQ_RESPONSES SET RES_COD_MSJ =?, RES_CORR_ESR=?, RES_RESP_PRI=?, RES_SEG_ENG = ?, RES_FIRST_RESP = ? WHERE req_messageid = ?"); 
            sql.setParameter(1, resCodMsj);
            sql.setParameter(2, resCorrEsr);
            sql.setParameter(3, resRespPri);
            sql.setParameter(4, resSegEng);
            sql.setParameter(5, resFirstResp);
            sql.setParameter(6, reqMessageid);
	    sql.executeUpdate();
            
            int results = 0;
	   return  results;
           
            }catch(Exception e){
                Logger.getLogger(SgrUserFacade.class.getName()).log(Level.SEVERE, null, e);
            }
       
       
        return 0;
	} 
        
        //codMayor:
         public int valMayor(BigInteger idMsj)
        {
        int i = 1;
        int Count = 0;        
        try {
            em = getEntityManager();
            Query query = em.createNativeQuery("SELECT MAX(NVL(RES_CORR_ESR,0)) +1  AS ID FROM ENG_REQ_RESPONSES WHERE REQ_MESSAGEID=" + idMsj);
            query.setMaxResults(i);
            String rs=(String) query.getSingleResult().toString(); 
            Count =Integer.parseInt(rs);  
            
        } catch (Exception e) {
            Count =1;
            Logger.getLogger(EngReqResponsesFacade.class.getName()).log(Level.SEVERE, null, e);
        }
        return Count;
    }
    
}
