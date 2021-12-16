/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

import com.aeroman.aees.entities.EngRequest;
import com.aeroman.aees.entities.GraficaCustomer3;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
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
public class EngRequestFacade extends AbstractFacade<EngRequest> {
    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    public EngRequestFacade() {
        super(EngRequest.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public void envioCorreoIngenieroAsignado(EngRequest esr, String usuario){
      
        try {
             em = getEntityManager();
             StoredProcedureQuery  query = em.createStoredProcedureQuery("MAIL_ENG_ENGINEER_ASSIG");
                                            query.registerStoredProcedureParameter("p_idmessageid",Integer.class, ParameterMode.INOUT);
                                            query.registerStoredProcedureParameter("p_idusuario",String.class,ParameterMode.INOUT);
                                            query.registerStoredProcedureParameter("p_coderesponse",Integer.class, ParameterMode.INOUT);
                                            
                                            query.setParameter("p_idmessageid", esr.getReqMessageid() );
                                            query.setParameter("p_idusuario", usuario);
                                            query.setParameter("p_coderesponse",0);
            query.execute();
        } catch (Exception e) {
           Logger.getLogger(EngRequestFacade.class.getName()).log(Level.SEVERE,null,e);  
        }

    }

    
    
    public void executeEnvioCorreoEsr(EngRequest esr, String usuario){
      
        try {
             em = getEntityManager();
             StoredProcedureQuery  query = em.createStoredProcedureQuery("MAIL_ENG_ESR");
                                            query.registerStoredProcedureParameter("p_idmessageid",Integer.class, ParameterMode.INOUT);
                                            query.registerStoredProcedureParameter("p_idusuario",String.class,ParameterMode.INOUT);
                                            query.registerStoredProcedureParameter("p_codchequeo",String.class, ParameterMode.INOUT);
                                            
                                            query.setParameter("p_idmessageid", esr.getReqMessageid() );
                                            query.setParameter("p_idusuario", usuario);
                                            query.setParameter("p_codchequeo",String.valueOf(esr.getChkCheckid()));
            query.execute();
        } catch (Exception e) {
           Logger.getLogger(EngRequestFacade.class.getName()).log(Level.SEVERE,null,e);  
        }

    }
    
    public List<EngRequest> findFromMotorBusqueda(Object[] vals){
         List<EngRequest> busc = new ArrayList();
        try {
            em = getEntityManager();
            String sql = "SELECT * FROM ENG_REQUEST WHERE 1=1 ";
            if (vals[0] != null) {
                String query0 = " AND UPPER(REQ_MESSAGEID) = '";
                sql += query0 + vals[0] + "' ";
            }
            if (vals[1] != null) {
                String query1 = " OR UPPER(REQ_REGISTRY) = '";
                sql += query1 + vals[1] + "' ";
            }
            if (vals[2] != null) {
                String query2 = " OR ATA_NUMATA = '";
                sql += query2 + vals[2] + "' ";
            }
            if (vals[3] != null) {
                String query3 = " OR REQ_MODEL = '";
                sql += query3 + vals[3] + "'";
            }
            if (vals[4] != null) {
                String query4 = " OR CHK_CHECKID = '%";
                sql += query4 + vals[4] + "%' ";
            }
            if (vals[5] != null) {
                String query5 = " OR REQ_CUSTOMER LIKE '%";
                sql += query5 + vals[5] + "%' ";
            }
            if (vals[6] != null) {
                String query6 = " OR REQ_COD_ING_ENC LIKE '%";
                sql += query6 + vals[6] + "%' ";
            }
            if (vals[7] != null) {
                String query7 = " OR REQ_PN = '";
                sql += query7 + vals[7] + "' ";
            }
            if (vals[8] != null) {
                String query8 = " OR REQ_AFP_ID = '";
                sql += query8 + vals[8] + "' ";
            }
            Query query = em.createNativeQuery(sql, EngRequest.class);
            busc = query.getResultList();
            } catch (Exception e) {
                Logger.getLogger(EngRequestFacade.class.getName()).log(Level.SEVERE, null, e);//captura de error
                FacesContext.getCurrentInstance().validationFailed();
            } 
        return busc;
    }
    
    public List<EngRequest> findWithEa(){
        
        return em.createQuery("SELECT e FROM EngRequest e JOIN EngEaGeneral a ON e.reqMessageid = a.reqMessageid ").getResultList();
    }
    
    public List<GraficaCustomer3> findByAvionesChecksActivos(String aviones){
        GraficaCustomer3 gf;
        List<GraficaCustomer3> cargrafica3=new ArrayList();
        String sql="SELECT TRIM(e.req_Registry), count(*) FROM Eng.Eng_Request e where TRIM(e.req_Registry) IN ("+aviones+") GROUP BY TRIM(e.req_Registry) ";
        List<Object[]> esrs;
        Query query=em.createNativeQuery(sql);
        esrs=query.getResultList();
        
        for(int i=0; i< esrs.size(); i++){
            gf=new GraficaCustomer3();
            gf.setCompany("\""+esrs.get(i)[0].toString()+"\"");
            gf.setCounT(Integer.parseInt(esrs.get(i)[1].toString()));
            cargrafica3.add(gf);
        }
        
        return cargrafica3; 
        
        
    }
    
    public List<GraficaCustomer3> findByIngenierosEncargados(String ingenierosCod86){
        GraficaCustomer3 gf;
        List<GraficaCustomer3> cargrafica3=new ArrayList();
        String sql="SELECT  SUBSTR(v.PRIMER_NOMBRE,1,1) || '. '|| PRIMER_APELLIDO, count(*)  FROM Eng.Eng_Request e JOIN ENG.ENG_LIST_VIEW v ON e.USR_CODUSER = v.CODIGO86  where  TRIM(e.USR_CODUSER) IN ("+ingenierosCod86+") AND e.req_status not in ('FPP','FDP','NFA','C') GROUP BY SUBSTR(v.PRIMER_NOMBRE,1,1) || '. '|| PRIMER_APELLIDO";
        List<Object[]> esrsIng;
        Query query=em.createNativeQuery(sql);
        esrsIng=query.getResultList();
        
        for(int i=0; i< esrsIng.size(); i++){
            gf=new GraficaCustomer3();
            String company = esrsIng.get(i)[0]==null?"":esrsIng.get(i)[0].toString();
            gf.setCompany("\""+company+"\"");
            gf.setCounT(Integer.parseInt(esrsIng.get(i)[1].toString()));
            cargrafica3.add(gf);
        }
        
        return cargrafica3; 
    }
    /*****************************/
    /* Metodos de busqueda de ESR */
    /*****************************/
    public List<String> findByPlaneTail(String search){
        List<String> listPlaneTail = new ArrayList<String>();
        try {
            em = getEntityManager();
            Query query = em.createNativeQuery("SELECT DISTINCT CHK_REGISTRY FROM CONT.CONT_CHECK WHERE UPPER(CHK_REGISTRY) LIKE '%"+search.toUpperCase()+"%'");
            listPlaneTail = query.getResultList(); 
        } catch (Exception e) {
            Logger.getLogger(EngRequestFacade.class.getName()).log(Level.SEVERE, null, e);
            listPlaneTail = new ArrayList<String>();
        }
        return listPlaneTail;
    }
    
    public List<Object[]> findByESRNumber(String search){
        List<Object[]> listNrESR = new ArrayList<Object[]>();
        try {
            em = getEntityManager();
            Query query = em.createNativeQuery("SELECT DISTINCT e.REQ_MESSAGEID,'ESR'||'-'||ata_numata||'-'||req_corr||'/'||TO_CHAR(TO_DATE(e.REQ_YEAR,'YYYY'),'YY')\n" +
"                    FROM ENG_REQUEST e ,\n" +
"                      CONT.CONT_CHECK c\n" +
"                    WHERE e.CHK_CHECKID    =c.CONT_CHECK_ID\n"+
                    "AND UPPER(ata_numata||'-'||req_corr||'/'||TO_CHAR(TO_DATE(e.REQ_YEAR,'YYYY'),'YY')) like '%"+search.toUpperCase()+"%'");
            listNrESR = query.getResultList();

        

        } catch (Exception e) {
            Logger.getLogger(EngRequestFacade.class.getName()).log(Level.SEVERE, null, e);
            listNrESR = new ArrayList<Object[]>();

        }

        return listNrESR;
    }
    
    public List<String> findByATAs(String search){
        List<String> listATAs = new ArrayList<String>();
        try {

            em = getEntityManager();
            Query query = em.createNativeQuery("SELECT DISTINCT ATA_NUMATA||'-'||ATA_DESCRIPTION AS ATAS FROM CONT.CONT_ATAS WHERE UPPER(ATA_DESCRIPTION) LIKE '%"+search.toUpperCase()+"%'");
            listATAs = query.getResultList();

        

        } catch (Exception e) {
            Logger.getLogger(EngRequestFacade.class.getName()).log(Level.SEVERE, null, e);
            listATAs = new ArrayList<String>();

        }
        return listATAs;
    }
    public List<String> findByAirplaneModel(String search){
        List<String> listAirplaneModel = new ArrayList<String>();
        try {
            em = getEntityManager();
            Query query = em.createNativeQuery("SELECT DISTINCT ARCTYP_CODE FROM CORE.CORE_AIRCRAFT_TYPE WHERE UPPER(ARCTYP_CODE) LIKE '%"+search.toUpperCase()+"%'");
            listAirplaneModel = query.getResultList();  
        } catch (Exception e) {
            Logger.getLogger(EngRequestFacade.class.getName()).log(Level.SEVERE, null, e);
            listAirplaneModel = new ArrayList<String>();
        }
        return listAirplaneModel;
    }
    public List<Object[]> findByWorkOrder(String search){
        List<Object[]> listWorkOrder = new ArrayList<Object[]>();
        try {
            em = getEntityManager();
            Query query = em.createNativeQuery("SELECT DISTINCT CONT_CHECK_ID,CHK_WO FROM CONT.CONT_CHECK WHERE UPPER(CHK_WO) LIKE '%"+search.toUpperCase()+"%'");
            listWorkOrder = query.getResultList();  
        } catch (Exception e) {
            Logger.getLogger(EngRequestFacade.class.getName()).log(Level.SEVERE, null, e);
            listWorkOrder = new ArrayList<Object[]>();
        }
        return listWorkOrder;
    }
    public List<String> findByCustomer(String search){
        List<String> listCustomer = new ArrayList<String>();
        try {
            em = getEntityManager();
            Query query = em.createNativeQuery("SELECT DISTINCT ENG_ID||'-'|| ENG_NAME FROM ENG_CUSTOMER WHERE UPPER(ENG_NAME) LIKE '%"+search.toUpperCase()+"%'");
            listCustomer = query.getResultList();  
        } catch (Exception e) {
            Logger.getLogger(EngRequestFacade.class.getName()).log(Level.SEVERE, null, e);
            listCustomer = new ArrayList<String>();
        }
        return listCustomer;
    }
    
    public List<String> findByEngineerAttendant(String search){
        List<String> listEngineerAttendant = new ArrayList<String>();
        try {
            em = getEntityManager();
            Query query = em.createNativeQuery("SELECT DISTINCT ER.REQ_COD_ING_ENC||'-'|| SUR.FULL_USER_NAME\n"
                    + " FROM ENG_REQUEST ER INNER JOIN PROCESOS.SGR_USER SUR ON ER.REQ_COD_ING_ENC=SUR.CODIGO86  WHERE UPPER(SUR.FULL_USER_NAME) LIKE '%"+search.toUpperCase()+"%'");
            listEngineerAttendant = query.getResultList();  
        } catch (Exception e) {
            Logger.getLogger(EngRequestFacade.class.getName()).log(Level.SEVERE, null, e);
            listEngineerAttendant = new ArrayList<String>();
        }
        return listEngineerAttendant;
    }
    public List<String> findByPartNumber(String search){
        List<String> listPartNumber = new ArrayList<String>();
        try {
            em = getEntityManager();
            Query query = em.createNativeQuery("SELECT DISTINCT REQ_PN FROM ENG_REQUEST WHERE UPPER(REQ_PN) LIKE '%"+search.toUpperCase()+"%'");
            listPartNumber = query.getResultList();  
        } catch (Exception e) {
            Logger.getLogger(EngRequestFacade.class.getName()).log(Level.SEVERE, null, e);
            listPartNumber = new ArrayList<String>();
        }
        return listPartNumber;
    }
    public List<String> findByAffectedPart(String search){
        List<String> listAffectedPart = new ArrayList<String>();
        try {
            em = getEntityManager();
            Query query = em.createNativeQuery("SELECT DISTINCT ER.REQ_AFP_ID ||'-'||EAP.AFP_NAME AS AFFECTED_PART\n"
                    + " FROM ENG_REQUEST ER INNER JOIN ENG_AFFECTED_PART EAP ON ER.REQ_AFP_ID=EAP.AFP_ID WHERE UPPER(EAP.AFP_NAME) LIKE '%"+search.toUpperCase()+"%'");
            listAffectedPart = query.getResultList();  
        } catch (Exception e) {
            Logger.getLogger(EngRequestFacade.class.getName()).log(Level.SEVERE, null, e);
            listAffectedPart = new ArrayList<String>();
        }
        return listAffectedPart;
    }
    /*****************************/
    /* Metodos de busqueda de EA */
    /*****************************/
    
    public List<String> findByNumEA(String searchEA){
        List<String> listNumEA = new ArrayList<String>();
        try {
            em = getEntityManager();
            Query query = em.createNativeQuery("SELECT DISTINCT EAG_CORRELATIVE FROM ENG_EA_GENERAL WHERE UPPER(EAG_CORRELATIVE) LIKE '%"+searchEA.toUpperCase()+"%'");
            listNumEA = query.getResultList();  
        } catch (Exception e) {
            Logger.getLogger(EngRequestFacade.class.getName()).log(Level.SEVERE, null, e);
            listNumEA = new ArrayList<String>();
        }
        return listNumEA;
    }
    
    public List<Object[]> findByNumESREA(String searchEA){
        List<Object[]> listNumESREA = new ArrayList<Object[]>();
        try {
            em = getEntityManager();
            Query query = em.createNativeQuery("SELECT DISTINCT ER.REQ_MESSAGEID, 'ESR'||'-'||ER.ATA_NUMATA||'-'||ER.REQ_CORR||'/'||TO_CHAR(TO_DATE(ER.REQ_YEAR,'YYYY'),'YY') AS ESR\n "
                    + "FROM ENG_EA_GENERAL EEG INNER JOIN ENG_REQUEST ER ON EEG.REQ_MESSAGEID= ER.REQ_MESSAGEID\n "
                    + "WHERE UPPER(ER.ATA_NUMATA||'-'||ER.REQ_CORR||'/'||TO_CHAR(TO_DATE(ER.REQ_YEAR,'YYYY'),'YY')) LIKE '%"+searchEA.toUpperCase()+"%'");
            listNumESREA = query.getResultList(); 
        } catch (Exception e) {
            Logger.getLogger(EngRequestFacade.class.getName()).log(Level.SEVERE, null, e);
            listNumESREA = new ArrayList<Object[]>();
        }
        return listNumESREA;
    }
    
    public List<String> findByPlaneTailEA(String searchEA){
        List<String> listAffectedPart = new ArrayList<String>();
        try {
            em = getEntityManager();
            Query query = em.createNativeQuery("SELECT DISTINCT EAG_TAIL FROM ENG_EA_GENERAL WHERE UPPER(EAG_TAIL) LIKE '%"+searchEA.toUpperCase()+"%'");
            listAffectedPart = query.getResultList();  
        } catch (Exception e) {
            Logger.getLogger(EngRequestFacade.class.getName()).log(Level.SEVERE, null, e);
            listAffectedPart = new ArrayList<String>();
        }
        return listAffectedPart;
    }
    public List<String> findByYear(String searchEA){
        List<String> listYear = new ArrayList<String>();
        try {
            em = getEntityManager();
            Query query = em.createNativeQuery("SELECT DISTINCT EAG_YEAR FROM ENG_EA_GENERAL WHERE UPPER(EAG_YEAR) LIKE '%"+searchEA.toUpperCase()+"%'");
            listYear = query.getResultList();  
        } catch (Exception e) {
            Logger.getLogger(EngRequestFacade.class.getName()).log(Level.SEVERE, null, e);
            listYear = new ArrayList<String>();
        }
        return listYear;
    }
    public List<Object[]> findByATAsEA(String searchEA){
        List<Object[]> listAffectedPart = new ArrayList<Object[]>();
        try {
            em = getEntityManager();
            Query query = em.createNativeQuery("SELECT DISTINCT ATA_NUMATA||'-'||ATA_DESCRIPTION FROM ENG_EA_GENERAL EY INNER JOIN  CONT.CONT_ATAS CA ON EY.EAG_ATA=CA.ATA_NUMATA WHERE UPPER(CA.ATA_DESCRIPTION) LIKE '%"+searchEA.toUpperCase()+"%'");
            listAffectedPart = query.getResultList();  
        } catch (Exception e) {
            Logger.getLogger(EngRequestFacade.class.getName()).log(Level.SEVERE, null, e);
            listAffectedPart = new ArrayList<Object[]>();
        }
        return listAffectedPart;
    }
    public List<String> findByAirplaneModelEA(String searchEA){
        List<String> listAirplaneModelEA = new ArrayList<String>();
        try {
            em = getEntityManager();
            Query query = em.createNativeQuery("SELECT DISTINCT EEG.FLT_COD FROM ENG_EA_GENERAL EEG INNER JOIN CORE.CORE_AIRCRAFT_TYPE CAT  ON EEG.FLT_COD=CAT.ARCTYP_CODE WHERE  UPPER(EEG.FLT_COD) LIKE '%"+searchEA.toUpperCase()+"%'");
            listAirplaneModelEA = query.getResultList();  
        } catch (Exception e) {
            Logger.getLogger(EngRequestFacade.class.getName()).log(Level.SEVERE, null, e);
            listAirplaneModelEA = new ArrayList<String>();
        }
        return listAirplaneModelEA;
    }
    public List<String> findByPNComponent(String searchEA){
        List<String> listAffectedPart = new ArrayList<String>();
        try {
            em = getEntityManager();
            Query query = em.createNativeQuery("SELECT DISTINCT EAG_CMP_PN FROM ENG_EA_GENERAL WHERE UPPER(EAG_CMP_PN) LIKE '%"+searchEA.toUpperCase()+"%'");
            listAffectedPart = query.getResultList();  
        } catch (Exception e) {
            Logger.getLogger(EngRequestFacade.class.getName()).log(Level.SEVERE, null, e);
            listAffectedPart = new ArrayList<String>();
        }
        return listAffectedPart;
    }
    public List<String> findBySNComponent(String searchEA){
        List<String> listSNComponent = new ArrayList<String>();
        try {
            em = getEntityManager();
            Query query = em.createNativeQuery("SELECT DISTINCT EAG_CMP_SN FROM ENG_EA_GENERAL WHERE UPPER(EAG_CMP_SN) LIKE '%"+searchEA.toUpperCase()+"%'");
            listSNComponent = query.getResultList();  
        } catch (Exception e) {
            Logger.getLogger(EngRequestFacade.class.getName()).log(Level.SEVERE, null, e);
            listSNComponent = new ArrayList<String>();
        }
        return listSNComponent;
    }
    public List<String> findByTitle(String searchEA){
        List<String> listTitle = new ArrayList<String>();
        try {
            em = getEntityManager();
            Query query = em.createNativeQuery("SELECT DISTINCT EAG_TITLE FROM ENG_EA_GENERAL WHERE UPPER(EAG_TITLE) LIKE '%"+searchEA.toUpperCase()+"%'");
            listTitle = query.getResultList();  
        } catch (Exception e) {
            Logger.getLogger(EngRequestFacade.class.getName()).log(Level.SEVERE, null, e);
            listTitle = new ArrayList<String>();
        }
        return listTitle;
    }
    
    public String findTitleByReq(BigInteger reqMessageID){
        String title="";
        try{
            em = getEntityManager();
            String compa="";
            Query queryCom = em.createNativeQuery("SELECT company FROM ENG.ENG_REQUEST WHERE REQ_MESSAGEID = "+reqMessageID+"");
            compa = (String) queryCom.getSingleResult();
            
            if(compa.equalsIgnoreCase("FAS")){
                Query query = em.createNativeQuery("SELECT req_registry FROM ENG.ENG_REQUEST WHERE REQ_MESSAGEID = "+reqMessageID+"");
                title = (String) query.getSingleResult();
            }else{
                Query query = em.createNativeQuery("SELECT req_registry|| ' - ESR-' || ata_numata|| '-' || LPAD(NVL(REQ_CORR, NULL), 4, '0') || '/' || SUBSTR(req_year,0,2) || ' / ' || req_probdesc FROM ENG.ENG_REQUEST WHERE REQ_MESSAGEID = "+reqMessageID+"");
                title = (String) query.getSingleResult();
            }
            return title;
        }catch(Exception e){
            Logger.getLogger(EngRequestFacade.class.getName()).log(Level.SEVERE, null, e);
            return "";
        }
    }
    
    //Validar ESR Activas: Requerimiento Karla, By Santos Bran
        //public BigDecimal validaESR(int numData, String corr,int year) {
        public BigDecimal validaESR(int valESR) {    
        try {

            Query q = getEntityManager().createNativeQuery("SELECT COUNT(req_messageid) As Val FROM ENG_REQUEST WHERE  REQ_STATUS IN('FPP','NFA')  AND req_messageid =" + valESR);
            System.out.println("VERIFICANDO ESR ACTIVAS: "+ q);
            return (BigDecimal) q.getSingleResult();
        } catch (Exception e) {
            return BigDecimal.ZERO;
        }
    }
        
    // SBRAN: Validar mayor de codigo ESR:    
    public BigDecimal maxESR(int idMessage) {
        try {

            Query q = getEntityManager().createNativeQuery("SELECT (MAX(NVL(RES_CORR_ESR,0)) + 1) AS MAX FROM ENG_REQ_RESPONSES WHERE req_messageid = " + idMessage);
            System.out.println("Valor MAX Codgio ESR : "+ q.getSingleResult());
            return (BigDecimal) q.getSingleResult();
        } catch (Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
            return BigDecimal.ZERO;
        }
    }
    
}
