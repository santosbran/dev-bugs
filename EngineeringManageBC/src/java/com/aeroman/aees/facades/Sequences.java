/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

import com.aeroman.aees.entities.CargarEsrWo;
import com.aeroman.aees.entities.EngEaGeneral;
import com.aeroman.aees.entities.EngHoursVw;
import com.aeroman.aees.entities.EngListView;
import com.aeroman.aees.entities.EngOrders;
import com.aeroman.aees.entities.Eng_QR8;
import com.aeroman.aees.entities.GraficaCustomer;
import com.aeroman.aees.entities.GraficaCustomer2;
import com.aeroman.aees.entities.GraficaCustomer3;
import com.aeroman.aees.entities.HoursExp;
import com.aeroman.aees.entities.HoursExport;
import com.aeroman.aees.entities.ReportWoAct;
import com.aeroman.aees.entities.ReporteDatos;
import com.aeroman.aees.entities.ReportesUrl;
import com.aeroman.aees.entities.grant.SgrRole;
import com.aeroman.aees.entities.grant.SgrRolePK;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
/**
 *
 * @author Usuario
 */
@Stateless
    public class Sequences implements Serializable{
    @PersistenceContext
    private EntityManager em;
    private String systemid;
    private String inicial;
    private String puerto;
    private EntityManagerFactory entityManagerFactory = null;
    
     public Sequences(EntityManagerFactory emf) {
        this.entityManagerFactory = emf;
    }
    
    public Sequences(){
        entityManagerFactory = Persistence.createEntityManagerFactory("EngineeringManageBCPU");
    }
   

    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
    
    public int max (){
        int number=0;
        int counter=1;
        try {
            em = getEntityManager();
            Query q = em.createNativeQuery("select nvl(max(a.EAG_ID),0)+1 as id from eng_ea_general a");
            q.setMaxResults(counter);
            String res=(String) q.getSingleResult().toString();         
            number=Integer.parseInt(res);
            
        }catch(Exception e){
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e); 
        }finally{
            em.close();
        }
        return  number ;
          
    }
    public Long maxCode() {
        Long num=0l;
        BigDecimal big;
        try {
            em = getEntityManager();
            Query query = em.createNativeQuery("select nvl(max(EO_IDORD),0)+1 as count from eng_orders");
            big= (BigDecimal)query.getSingleResult();
            num=big.longValue();
            
        } catch (Exception e) {
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            em.close();
        }
        return num;

    }
    public  int getCounterCustomer(){
        int counter = 1;
        
        int customerAll=0 ;        
        try {
            em = getEntityManager();
            
            
            Query queryx = em.createNativeQuery("select sum(total) from ENG_CUSTOMER_VW ");
            queryx.setMaxResults(counter);
            String res2=(String) queryx.getSingleResult().toString(); 
            customerAll =Integer.parseInt(res2);  
      
            
            
        } catch (Exception e) {
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);
        }
        
        
        return customerAll;
        
    }
   
    public BigInteger idEsr(){
        BigInteger num=null;
        int n=1;
        int n2;
        try {
            em = getEntityManager();
            Query query = em.createNativeQuery("select nvl(max(REQ_MESSAGEID)+1,1) messageid from eng_request");
            query.setMaxResults(n);
            String a2=(String) query.getSingleResult().toString();
            n2=Integer.parseInt(a2);  
            num=BigInteger.valueOf(n2);
             return num;
        }catch(NumberFormatException e){
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);
            
        }finally{
            if(em!=null){
            em.close();
            }
        }
        return  num;
          
    }
    
    public int maxCodeIngaction() {
        int numberTemp = 0;
        int n1 = 1;
        try {
            em = getEntityManager();
            Query q1 = em.createNativeQuery("select nvl(max(a.EIN_ACTION_ID),0)+1 as id from ENG_REQ_INGACTION a");
            q1.setMaxResults(n1);
            String a1 = (String) q1.getSingleResult().toString();
            numberTemp = Integer.parseInt(a1);
            
        } catch (Exception e) {
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            em.close();
        }
        return numberTemp;

    }
    public int pdf (){
        int num=0;
        int n=1;
        try {
            em = getEntityManager();
            Query query = em.createNativeQuery("select nvl(max(a.PDF_ID),0)+1 as id from eng_ea_pdf a");
            query.setMaxResults(n);
            String a=(String) query.getSingleResult().toString();         
            num=Integer.parseInt(a);
             
        }catch(Exception e){
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);
            
        }finally{
            em.close();
        }
        return num;
          
    }
    public  int getCountFle(){
        int i = 1;
        
        int num3=0 ;        
        try {
            em = getEntityManager();
            
            
            Query query = em.createNativeQuery("select sum(total) from CONT_FLEETS_VW ");
            query.setMaxResults(i);
            String a2=(String) query.getSingleResult().toString(); 
            num3 =Integer.parseInt(a2);  
        } catch (Exception e) {
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);
        }
        return num3;
        
    }
    
    
    
    public int getLastID(){
          int i=1;
        
        try {
            em = getEntityManager();
            Query query = em.createNativeQuery("select nvl(max(PUB_ID),0) from ENG_AFFECTED_PUBS2 ");
            query.setMaxResults(i);
            String a2=(String) query.getSingleResult().toString(); 
            i =Integer.parseInt(a2);  
        } catch (Exception e) {
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);
        }
        i+=1;
        
        return i;
    }
    
    public int maxcodinstructions(){
        
    int i = 1;
        
        int customerAll=0 ;        
        try {
            em = getEntityManager();
            Query query = em.createNativeQuery("select nvl(max(ins_id),0)+1 from ENG_INSTRUCTIONS");
            query.setMaxResults(i);
            String a2=(String) query.getSingleResult().toString(); 
            customerAll =Integer.parseInt(a2);  
        } catch (Exception e) {
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);
        }
        return customerAll;
    }
    
    public int maxSupDoc() {
        int number1 = 0;
        int initial = 1;
        try {

            em = getEntityManager();
            Query query = em.createNativeQuery("SELECT nvl(MAX(SDO_ID),0)+1 FROM ENG_SUP_DOC2");
            query.setMaxResults(initial);
            String result1 = (String) query.getSingleResult().toString();
            number1 = Integer.parseInt(result1);
            return number1;

        } catch (Exception e) {
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            em.close();
        }

        return 0;

    }
    
    public List<Integer> ioOrder(){
        List<Integer> a = new ArrayList();
        try {
            em = getEntityManager();
            Query query = em.createNativeQuery("select EO_IDORD from ENG_ORDERS");            
            a=(List<Integer>) query.getResultList();
            
            return a; 
        }catch(Exception e){
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);            
        }
        return a;
    }
    public int getCountDistributions(){
        int i=1;
        
        try {
            em = getEntityManager();
            Query query = em.createNativeQuery("select nvl(max(DLC_ID),0)+1 from ENG_DISTRIBUTION_LISTS2 ");
            query.setMaxResults(i);
            String a2=(String) query.getSingleResult().toString(); 
            i =Integer.parseInt(a2);  
        } catch (Exception e) {
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);
        }
        return i;
    }
    public int maxCodID() {
        int numeroI = 0;
        int start = 1;
        try {
            em = getEntityManager();
            Query queryMaxCodId = em.createNativeQuery("select nvl(max(a.COD_ID),0)+1 as id from ENG_EO_REF a");
            queryMaxCodId.setMaxResults(start);
            String aMaxCodId = (String) queryMaxCodId.getSingleResult().toString();
            numeroI = Integer.parseInt(aMaxCodId);
            return numeroI;
        } catch (Exception e) {
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            em.close();
        }
        return 0;

    }

    public int maxSecNum() {
        int numberTemp = 0;
        int nMaxSecNum = 1;
        try {
            em = getEntityManager();
            Query qMaxSecNum = em.createNativeQuery("select nvl(max(a.SEC_NUM),0)+1 as id from ENG_EO_REF a");
            qMaxSecNum.setMaxResults(nMaxSecNum);
            String rMaxSec = (String) qMaxSecNum.getSingleResult().toString();
            numberTemp = Integer.parseInt(rMaxSec);
            return numberTemp;
        } catch (Exception e) {
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            em.close();
        }
        return 0;

    }
    public String getEstados(String id){
    
   String a="";
        int n=1;
        try{
        
        em=getEntityManager();
        Query query=em.createNativeQuery("Select R.REQ_STATUS FROM ENG_REQUEST R WHERE R.CHK_CHECKID="+id+"");
        query.setMaxResults(n);
        a=(String) query.getSingleResult().toString();

            return a; 
        
        } catch(Exception e){
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            em.close();
        }
        
            return a;
    }
    public int getMaxIdEffectivities() {
        int i = 0;
        String a2 = "";
        try {
            em = getEntityManager();
            Query query = em.createNativeQuery("select nvl(max(EFF_ID),0)+1 from ENG_EFFECTIVITIES");
            if (query.getSingleResult() == null) {
                a2 = "1";
            } else {
                a2 = query.getSingleResult().toString();
            }
            i = Integer.parseInt(a2);
            em.close();
        } catch (Exception e) {
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);
        }
        return i;
    }
    public List<Integer> iodor(){
          List<Integer> result = new ArrayList();
        try {
            em = getEntityManager();
            Query query = em.createNativeQuery("select EO_IDORD from ENG_ORDERS");
            result=query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;
     }
    public List<Object[]> esr(){
          List<Object[]> result = new ArrayList();
        try {
            em = getEntityManager();
            Query query = em.createNativeQuery("SELECT e.REQ_MESSAGEID ESR,nvl(c.CHK_WO_YEAR,0)||'/'||nvl(c.CHK_WO_CORR,0)||'-'||nvl(c.CHK_WO_ITEM,0)  WoOrder,e.COMPANY,e.REQ_FECHA_INS,e.REQ_PROBDESC\n" +
                                                "FROM ENG_REQUEST e , CONT.CONT_CHECK c where e.CHK_CHECKID=c.CONT_CHECK_ID order by e.REQ_MESSAGEID asc");
            result=(List<Object[]>)query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;
     }
    public List<EngEaGeneral> esrEA(BigInteger reqm){
          List<EngEaGeneral> result = new ArrayList();
        try {
            em = getEntityManager();
            Query query = em.createQuery("select r from EngEaGeneral r where r.reqMessageid=:reqm").setParameter("reqm", reqm);
            result=(List<EngEaGeneral>)query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;
     }
    public List<Object[]> esrporusuandestatus(String user){
          List<Object[]> result = new ArrayList();
        try {
            em = getEntityManager();
            Query query = em.createNativeQuery("SELECT e.REQ_MESSAGEID ESR, NVL(c.CHK_WO_YEAR,0)\n" +
"                     ||'-'\n" +
"                      ||NVL(c.CHK_WO_CORR,0)\n" +
"                      ||'/'\n" +
"                      ||NVL(c.CHK_WO_ITEM,0)  \n" +
"                      || '- ESR ' || ata_numata||'-'||req_corr||'/'||TO_CHAR(TO_DATE(c.CHK_WO_YEAR,'YYYY'),'YY')  WoOrder,"+
                        "e.COMPANY,e.REQ_FECHA_INS,e.REQ_PROBDESC,e.REQ_CUSTOMER,e.REQ_TAIL,e.USR_CODUSER\n" +
            " FROM ENG_REQUEST e , CONT.CONT_CHECK c where e.CHK_CHECKID=c.CONT_CHECK_ID and (e.USR_CODUSER = '"+user+"' or e.USR_CODUSER is null) and e.REQ_STATUS = 'O' order by e.REQ_MESSAGEID asc");
            result=(List<Object[]>)query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;
     }
    public List<Object[]> esrporestopenorclosed(String user){
          List<Object[]> result = new ArrayList();
        try {
            em = getEntityManager();
            Query query = em.createNativeQuery("SELECT e.REQ_MESSAGEID ESR,nvl(c.CHK_WO_YEAR,0)||'/'||nvl(c.CHK_WO_CORR,0)||'-'||nvl(c.CHK_WO_ITEM,0)  WoOrder,e.COMPANY,e.REQ_FECHA_INS,e.REQ_PROBDESC\n" +
            " FROM ENG_REQUEST e , CONT.CONT_CHECK c where e.CHK_CHECKID=c.CONT_CHECK_ID and (e.USR_CODUSER = '"+user+"' or e.USR_CODUSER is null) order by e.REQ_MESSAGEID asc");
            result=(List<Object[]>)query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;
     }
    public List<Object[]> esralluseropen(){
          List<Object[]> result = new ArrayList();
        try {
            em = getEntityManager();
            Query query = em.createNativeQuery("SELECT e.REQ_MESSAGEID ESR, NVL(c.CHK_WO_YEAR,0)\n" +
"                     ||'-'\n" +
"                      ||NVL(c.CHK_WO_CORR,0)\n" +
"                      ||'/'\n" +
"                      ||NVL(c.CHK_WO_ITEM,0)  \n" +
"                      || '- ESR ' || ata_numata||'-'||req_corr||'/'||TO_CHAR(TO_DATE(c.CHK_WO_YEAR,'YYYY'),'YY')  WoOrder,e.COMPANY,e.REQ_FECHA_INS,e.REQ_PROBDESC,e.REQ_CUSTOMER,"
                    + "e.req_Registry,e.USR_CODUSER\n" +
            " FROM ENG_REQUEST e , CONT.CONT_CHECK c where e.CHK_CHECKID=c.CONT_CHECK_ID and e.REQ_STATUS = 'O' order by e.REQ_MESSAGEID desc");
            result=(List<Object[]>)query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;
     }
     public List<EngOrders> esrEO(BigInteger reqm){
          List<EngOrders> result = new ArrayList();
        try {
            em = getEntityManager();
            Query query = em.createQuery("select r from EngOrders r where r.reqMessageid="+reqm, EngOrders.class);
            result=(List<EngOrders>)query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;
     }
      public List<EngListView> alluser() {
        List<EngListView> allu = new ArrayList();
        try {
            em = getEntityManager();
            Query query = em.createNativeQuery("select * from Eng_List_View", EngListView.class);
            allu=query.getResultList();
            
        } catch (Exception e) {
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);

        } 
        return allu;

    }
     public int email (){
        int numEmail=0;
        int nEmail=1;
        String rEmail="";
        try {
            em = getEntityManager();
            Query qEmail = em.createNativeQuery("SELECT NVL(max(r.RES_ID),0)+1 as id FROM ENG_REQ_RESPONSES  r");
            qEmail.setMaxResults(nEmail);
            if(qEmail.getSingleResult()!=null){
                rEmail=(String) qEmail.getSingleResult().toString();
            }else{
               rEmail="1"; 
            }
            numEmail=Integer.parseInt(rEmail);
            return numEmail; 
        }catch(Exception e){
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);
            
        }finally{
            em.close();
        }
        return  0 ;
          
    }
    
    public int addAdjuntos (){
        int numAdd=0;
        int nAdd=1;
        String addStr="";
        try {
            em = getEntityManager();
            Query qAdd = em.createNativeQuery("SELECT NVL(max(m.MSG_CODIGO),0)+1 as id FROM MSJ_ADJUNTOS  m");
            qAdd.setMaxResults(nAdd);
            if(qAdd.getSingleResult()!=null){
                addStr=(String) qAdd.getSingleResult().toString();
            }else{
               addStr="1"; 
            }
            numAdd=Integer.parseInt(addStr);
            return numAdd; 
        }catch(Exception e){
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);
            
        }finally{
            em.close();
        }
        return  0 ;
          
    }
    
    
        public List<CargarEsrWo> report(String usercode)throws SQLException{
            CargarEsrWo cwo=new CargarEsrWo();
            List<CargarEsrWo> cargaw=new ArrayList();
            List<Object[]> wo=new ArrayList();
        try{
            em = getEntityManager(); 
        Query sql =em.createNativeQuery("SELECT CARGA_REGISTRY, "   + 
        "                        CARGA_WO,"        + 
        "                        TO_CHAR(CARGA_CIERREWO)CARGA_CIERREWO, "  + 
        "                        CARGA_NUM_ESR, "   + 
        "                        CARGA_STD_ESR, "   + 
        "                        TO_CHAR(CARGA_CSTM_ESR)CARGA_CSTM_ESR, "  + 
        "                        TO_CHAR(CARGA_CREAL_ESR)CARGA_CREAL_ESR, " + 
        "                        CARGA_ING, "       + 
        "                        CARGA_ONTIME, "    + 
        "                        CARGA_USR, "       + 
        "                        CARGA_USR_DATE,"   +
        "                        CARGA_WO_STD,"     +
        "                        SUBSTR(CARGA_USR_DATE,0,10) FECHA," + 
        "                        SUBSTR(CARGA_USR_DATE,12,16) HORA,"   + 
        "                        CARGA_STD_CODE                                 " +
        "                        FROM ENG_CARGA_ESR_WO " +
        "                        WHERE CARGA_USR = '"+usercode+"'"); 
    
        
        wo = sql.getResultList();
            for(int i=0; i< wo.size(); i++){
                cwo.setCargaRegistry(wo.get(i)[0].toString());
                cwo.setCargaWo(wo.get(i)[1].toString());
                cwo.setCargaCierrewo(wo.get(i)[2].toString());
                cwo.setCargaNumEsr(wo.get(i)[3].toString());
                cwo.setCargaStdEsr(wo.get(i)[4].toString());
                cwo.setCargaCstmEsr(wo.get(i)[5].toString());
                cwo.setCargaCrealEsr(wo.get(i)[6].toString());
                cwo.setCargaIng(wo.get(i)[7].toString());
                cwo.setCargaOntime(wo.get(i)[8].toString());
                cwo.setCargaUsr(wo.get(i)[9].toString());
                cwo.setCargaUsrDate(wo.get(i)[10].toString());
                cwo.setCargaWoStd(wo.get(i)[11].toString());
                cwo.setFecha(wo.get(i)[12].toString());
                cwo.setHora(wo.get(i)[13].toString());
                cwo.setCargaStdCode(wo.get(i)[14].toString());
                cargaw.add(cwo);
            }         
                if(!wo.isEmpty()) {
                return cargaw;
            }
           
        }catch(Exception e){
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);
        }
        return cargaw;
    }
        
        
 public List<ReportWoAct> reportWoAct(String wos)throws SQLException{
            ReportWoAct cwo=new ReportWoAct();
            List<ReportWoAct> cargaw=new ArrayList();
            List<Object[]> wo=new ArrayList();
        try{
            em = getEntityManager(); 
        String sql ="SELECT req.REQ_REGISTRY,\n" +
                                            "  NVL(CH.CHK_WO,'null') CHK_WO,\n" +
                                            "  'ESR-'\n" +
                                            "  ||req.ATA_NUMATA\n" +
                                            "  ||'-'\n" +
                                            "  ||req.REQ_CORR\n" +
                                            "  ||'/'\n" +
                                            "  ||SUBSTR(req.REQ_YEAR,3,2) NUMERO_ESR,\n" +
                                            "  NVL(req.ATA_NUMATA,0)ATA_NUMATA,\n" +
                                            "  NVL(req.REQ_MODEL,'null') model,\n" +
                                            "  NVL(TO_CHAR(req.REQ_ISSUEDATE,'MM/DD/YYYY HH24:MI:SS'),' ') FECHA_REQUISICION,\n" +
                                            "  NVL(TO_CHAR(req.REQ_DUE_DATE,'MM/DD/YYYY HH24:MI:SS'),' ') FECHA_VENCIMIENTO,\n" +
                                            "  NVL(TO_CHAR(req.REQ_RESPONSEDT,'MM/DD/YYYY HH24:MI:SS'),' ') FECHA_RESPUESTA,\n" +
                                            "  NVL(req.REQ_COMPONENT,' ')COMPONENTE,\n" +
                                            "  NVL(req.REQ_PN,' ')NUMERO_PARTE,\n" +
                                            "  NVL(req.REQ_SN,' ') NUMERO_SERIE,\n" +
                                            "  NVL(req.REQ_NDTREPORT,' ') REPORTE_ADJUNTO_NDT,\n" +
                                            "  NVL(req.REQ_REPAIRAREA,' ') repairarea,\n" +
                                            "  NVL(req.REQ_REFFOUND,' ') reffound,\n" +
                                            "  NVL(req.REQ_STATAIRCRAFT,' ') stataircraft,\n" +
                                            "  NVL(req.REQ_PROBDESC,' ') DESCRIPCION_PROBLEMA,\n" +
                                            "  NVL(req.REQ_EXT_SOL,' ') TELEFONO,\n" +
                                            "  NVL(req.REQ_ACTION_ING,' ') DESCRIPCION_ESR,\n" +
                                            "  NVL(req.REQ_CHK_REF,' ') REFERENCIAS_CONSULTADAS,\n" +
                                            "  NVL(req.REQ_CHK_OTHEREF,' ') OTRAS_REFERNCIAS,\n" +
                                            "  NVL(req.REQ_OTHERREF,' ') OTRAS_REFERENCIAS,\n" +
                                            "  NVL(req.REQ_CLAS_REPAIR,' ') cLASIFICACION_REP,\n" +
                                            "  NVL(req.REQ_CRITICAL_ESR,' ') CRITICAL_ESR,\n" +
                                            "  NVL(req.REQ_REQ_ENV,' ') req_env,\n" +
                                            "  NVL(req.LOGPAGE,' ') taskcard,\n" +
                                            "  NVL(req.LOGPAGE,' ')\n" +
                                            "  ||'-'\n" +
                                            "  ||NVL(req.NUMEROLOGPAGE,' ') TASKCARDS,\n" +
                                            "  NVL(req.NUMEROLOGPAGE,' ') milestoneName,\n" +
                                            "  (DECODE(req.REQ_COD_ING_ENC, NULL, 1, 0) ) existeArchivo,\n" +
                                            "  NVL(TO_CHAR(req.REQ_FECHA_INS, 'mm/dd/yyyy HH24:MI:SS'),' ') fechaIngreso,\n" +
                                            "  NVL((SELECT NVL(CORE.CORE_USERS.USR_NAME,' ')\n" +
                                            "  FROM CORE.CORE_USERS\n" +
                                            "  WHERE CORE.CORE_USERS.USR_CODUSR = req.REQ_COD_ING_ENC\n" +
                                            "  ),' ') ingEncargadoDescription,\n" +
                                            "  NVL(eei.EIN_STATUS,0) CODIGO_ESTADOS,\n" +
                                            "  NVL(sts.EST_DESC,' ') NOMBRE_ESTADOS,\n" +
                                            "  NVL((SELECT REQ_USR_INS\n" +
                                            "    ||' - '\n" +
                                            "    ||USR_NAME\n" +
                                            "  FROM CORE.CORE_USERS usuario\n" +
                                            "  WHERE usuario.USR_CODUSR = REQ_USR_INS\n" +
                                            "  ),' ') USUARIO_INGRESO_TRACKING,\n" +
                                            "  NVL(EEI.EIN_DESCRIPTION,' ') DESCRIPCION_TRACKING,\n" +
                                            "  NVL(TO_CHAR(EEI.EIN_DATE,'MM/DD/YYYY HH24:MI:SS'),' ') FECHA_INGRESO_TRACKING,\n" +
                                            "  NVL(TO_CHAR(cdr.wo_closed_date, 'DD/MM/YYYY HH24:MI:SS'),' ') cierre,\n" +
                                            "  NVL(EIN_ACTION_ID,0) idaccionEng" +
                                            "FROM ENG.ENG_REQUEST req,\n" +
                                            "  ENG.ENG_REQ_INGACTION eei,\n" +
                                            "  CONT.CONT_CHECK CH ,\n" +
                                            "  ENG.ENG_REQ_STATUS STS,\n" +
                                            "  sita.cdr_check cdr\n" +
                                            "WHERE ";
                                           if(!("").equals(wos)){
                                                sql += " TRIM(CH.CHK_WO) IN ('"+wos+"') ";
                                            }
                                            sql +="AND req.REQ_MESSAGEID  = eei.REQ_MESSAGEID\n" +
                                                  "AND REQ.CHK_CHECKID    = CH.CONT_CHECK_ID\n" +
                                                  "AND (eei.EIN_STATUS    = sts.EST_CODE)\n" +
                                                  "AND ch.CHK_WO_YEAR     = cdr.wo_year\n" +
                                                  "AND ch.CHK_WO_CORR     = cdr.wo_corr\n" +
                                                  "AND ch.CHK_WO_ITEM     = cdr.wo_item\n" +
                                            "UNION ALL\n" +
                                            "SELECT req.REQ_REGISTRY,\n" +
                                            "  NVL(CH.CHK_WO,'null') CHK_WO,\n" +
                                            "  'ESR-'\n" +
                                            "  ||req.ATA_NUMATA\n" +
                                            "  ||'-'\n" +
                                            "  ||req.REQ_CORR\n" +
                                            "  ||'/'\n" +
                                            "  ||SUBSTR(req.REQ_YEAR,3,2) NUMERO_ESR,\n" +
                                            "  NVL(req.ATA_NUMATA,0)ATA_NUMATA,\n" +
                                            "  NVL(req.REQ_MODEL,'null') model,\n" +
                                            "  NVL(TO_CHAR(req.REQ_ISSUEDATE,'MM/DD/YYYY HH24:MI:SS'),' ') FECHA_REQUISICION,\n" +
                                            "  NVL(TO_CHAR(req.REQ_DUE_DATE,'MM/DD/YYYY HH24:MI:SS'),' ') FECHA_VENCIMIENTO,\n" +
                                            "  NVL(TO_CHAR(req.REQ_RESPONSEDT,'MM/DD/YYYY HH24:MI:SS'),' ') FECHA_RESPUESTA,\n" +
                                            "  NVL(req.REQ_COMPONENT,' ')COMPONENTE,\n" +
                                            "  NVL(req.REQ_PN,' ')NUMERO_PARTE,\n" +
                                            "  NVL(req.REQ_SN,' ') NUMERO_SERIE,\n" +
                                            "  NVL(req.REQ_NDTREPORT,' ') REPORTE_ADJUNTO_NDT,\n" +
                                            "  NVL(req.REQ_REPAIRAREA,' ') repairarea,\n" +
                                            "  NVL(req.REQ_REFFOUND,' ') reffound,\n" +
                                            "  NVL(req.REQ_STATAIRCRAFT,' ') stataircraft,\n" +
                                            "  NVL(req.REQ_PROBDESC,' ') DESCRIPCION_PROBLEMA,\n" +
                                            "  NVL(req.REQ_EXT_SOL,' ') TELEFONO,\n" +
                                            "  NVL(req.REQ_ACTION_ING,' ') DESCRIPCION_ESR,\n" +
                                            "  NVL(req.REQ_CHK_REF,' ') REFERENCIAS_CONSULTADAS,\n" +
                                            "  NVL(req.REQ_CHK_OTHEREF,' ') OTRAS_REFERNCIAS,\n" +
                                            "  NVL(req.REQ_OTHERREF,' ') OTRAS_REFERENCIAS,\n" +
                                            "  NVL(req.REQ_CLAS_REPAIR,' ') cLASIFICACION_REP,\n" +
                                            "  NVL(req.REQ_CRITICAL_ESR,' ') CRITICAL_ESR,\n" +
                                            "  NVL(req.REQ_REQ_ENV,' ') req_env,\n" +
                                            "  NVL(req.LOGPAGE,' ') taskcard,\n" +
                                            "  NVL(req.LOGPAGE,' ')\n" +
                                            "  ||'-'\n" +
                                            "  ||NVL(req.NUMEROLOGPAGE,' ') TASKCARDS,\n" +
                                            "  NVL(req.NUMEROLOGPAGE,' ') milestoneName,\n" +
                                            "  (DECODE(req.REQ_COD_ING_ENC, NULL, 1, 0) ) existeArchivo,\n" +
                                            "  NVL(TO_CHAR(req.REQ_FECHA_INS, 'mm/dd/yyyy HH24:MI:SS'),' ') fechaIngreso,\n" +
                                            "  NVL((SELECT NVL(CORE.CORE_USERS.USR_NAME,' ')\n" +
                                            "  FROM CORE.CORE_USERS\n" +
                                            "  WHERE CORE.CORE_USERS.USR_CODUSR = req.REQ_COD_ING_ENC\n" +
                                            "  ),' ') ingEncargadoDescription,\n" +
                                            "  NVL(eei.EIN_STATUS,0) CODIGO_ESTADOS,\n" +
                                            "  NVL(sts.EST_DESC,' ') NOMBRE_ESTADOS,\n" +
                                            "  NVL((SELECT REQ_USR_INS\n" +
                                            "    ||' - '\n" +
                                            "    ||USR_NAME\n" +
                                            "  FROM CORE.CORE_USERS usuario\n" +
                                            "  WHERE usuario.USR_CODUSR = REQ_USR_INS\n" +
                                            "  ),' ') USUARIO_INGRESO_TRACKING,\n" +
                                            "  NVL(EEI.EIN_DESCRIPTION,' ') DESCRIPCION_TRACKING,\n" +
                                            "  NVL(TO_CHAR(EEI.EIN_DATE,'MM/DD/YYYY HH24:MI:SS'),' ') FECHA_INGRESO_TRACKING,\n" +
                                            "  NVL(TO_CHAR(cdr.wo_closed_date, 'DD/MM/YYYY HH24:MI:SS'),' ') cierre,\n" +
                                            "  NVL(EIN_ACTION_ID,0) idaccionEng" +
                                            "FROM ENG.ENG_REQUEST req,\n" +
                                            "  ENG.ENG_REQ_INGACTION eei,\n" +
                                            "  CONT.CONT_CHECK CH ,\n" +
                                            "  ENG.ENG_REQ_STATUS STS,\n" +
                                            "  sita.cdr_check cdr\n" +
                                            "WHERE ";
                                            if(!("").equals(wos)){
                                                sql += " TRIM(CH.CHK_WO) IN ('"+wos+"') ";
                                            }
                                            sql +="AND req.REQ_MESSAGEID  = eei.REQ_MESSAGEID\n" +
                                                  "AND REQ.CHK_CHECKID    = CH.CONT_CHECK_ID\n" +
                                                  "AND (eei.EIN_STATUS    = sts.EST_CODE)\n" +
                                                  "AND ch.CHK_WO_YEAR     = cdr.wo_year\n" +
                                                  "AND ch.CHK_WO_CORR     = cdr.wo_corr\n" +
                                                  "AND ch.CHK_WO_ITEM     = cdr.wo_item\n" +
                                            "ORDER BY CHK_WO,\n" +
                                            "  REQ_REGISTRY,\n" +
                                            "  NUMERO_ESR,\n" +
                                            "  idaccionEng DESC";
                                Query query=em.createNativeQuery(sql);
    
        
            wo = query.getResultList();
            for (int i = 0; i < wo.size(); i++) {
                cwo.setAta_numata(wo.get(i)[3].toString());
                cwo.setChk_wo(wo.get(i)[1].toString());
                cwo.setCierre(wo.get(i)[35].toString());
                cwo.setClasificaciones_rep(wo.get(i)[21].toString());
                cwo.setCodigo_estados(wo.get(i)[30].toString());
                cwo.setComponente(wo.get(i)[8].toString());
                cwo.setCritical_esr(wo.get(i)[22].toString());
                cwo.setDescripcion_esr(wo.get(i)[17].toString());
                cwo.setDescripcion_problema(wo.get(i)[15].toString());
                cwo.setDescripcion_tracking(wo.get(i)[33].toString());
                cwo.setExistearchivo(wo.get(i)[27].toString());
                cwo.setFecha_ingreso_tracking(wo.get(i)[34].toString());
                cwo.setFecha_requisicion(wo.get(i)[5].toString());
                cwo.setFecha_respuesta(wo.get(i)[7].toString());
                cwo.setFecha_vencimiento(wo.get(i)[6].toString());
                cwo.setFechaingreso(wo.get(i)[28].toString());
                cwo.setIdaccioneng(wo.get(i)[36].toString());
                cwo.setIngencargadodescription(wo.get(i)[29].toString());
                cwo.setMilestonename(wo.get(i)[26].toString());
                cwo.setModel(wo.get(i)[4].toString());
                cwo.setNombre_estados(wo.get(i)[31].toString());
                cwo.setNumero_esr(wo.get(i)[2].toString());
                cwo.setNumero_parte(wo.get(i)[9].toString());
                cwo.setNumero_serie(wo.get(i)[10].toString());
                cwo.setOtras_referencias(wo.get(i)[20].toString());
                cwo.setOtras_referncias(wo.get(i)[19].toString());
                cwo.setReferencias_consultadas(wo.get(i)[18].toString());
                cwo.setReffound(wo.get(i)[13].toString());
                cwo.setRepairarea(wo.get(i)[12].toString());
                cwo.setReporte_adjunto_ndt(wo.get(i)[11].toString());
                cwo.setReq_env(wo.get(i)[23].toString());
                cwo.setReq_registry(wo.get(i)[0].toString());
                cwo.setStataircraft(wo.get(i)[14].toString());
                cwo.setTaskcard(wo.get(i)[24].toString());
                cwo.setTaskcards(wo.get(i)[25].toString());
                cwo.setTelefono(wo.get(i)[16].toString());
                cwo.setUsuario_ingreso_tracking(wo.get(i)[32].toString());
                cargaw.add(cwo);
            }         
                if(!wo.isEmpty()) {
                return cargaw;
            }
           
        }catch(Exception e){
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);
        }
        return cargaw;
    }
 
   public List<ReportWoAct> reportWoAct2(String wos,String woa,String fecha,String fechafin)throws SQLException{
            ReportWoAct cwo=new ReportWoAct();
            List<ReportWoAct> cargaw=new ArrayList();
            List<Object[]> wo=new ArrayList();
        try{
            em = getEntityManager(); 
                        String sql ="SELECT req.REQ_REGISTRY,\n" +
                                    "  NVL(CH.CHK_WO,'null') CHK_WO,\n" +
                                    "  'ESR-'\n" +
                                    "  ||req.ATA_NUMATA\n" +
                                    "  ||'-'\n" +
                                    "  ||req.REQ_CORR\n" +
                                    "  ||'/'\n" +
                                    "  ||SUBSTR(req.REQ_YEAR,3,2) NUMERO_ESR,\n" +
                                    "  NVL(req.ATA_NUMATA,0)ATA_NUMATA,\n" +
                                    "  NVL(req.REQ_MODEL,'null') model,\n" +
                                    "  NVL(TO_CHAR(req.REQ_ISSUEDATE,'MM/DD/YYYY HH24:MI:SS'),' ') FECHA_REQUISICION,\n" +
                                    "  NVL(TO_CHAR(req.REQ_DUE_DATE,'MM/DD/YYYY HH24:MI:SS'),' ') FECHA_VENCIMIENTO,\n" +
                                    "  NVL(TO_CHAR(req.REQ_RESPONSEDT,'MM/DD/YYYY HH24:MI:SS'),' ') FECHA_RESPUESTA,\n" +
                                    "  NVL(req.REQ_COMPONENT,' ')COMPONENTE,\n" +
                                    "  NVL(req.REQ_PN,' ')NUMERO_PARTE,\n" +
                                    "  NVL(req.REQ_SN,' ') NUMERO_SERIE,\n" +
                                    "  NVL(req.REQ_NDTREPORT,' ') REPORTE_ADJUNTO_NDT,\n" +
                                    "  NVL(req.REQ_REPAIRAREA,' ') repairarea,\n" +
                                    "  NVL(req.REQ_REFFOUND,' ') reffound,\n" +
                                    "  NVL(req.REQ_STATAIRCRAFT,' ') stataircraft,\n" +
                                    "  NVL(req.REQ_PROBDESC,' ') DESCRIPCION_PROBLEMA,\n" +
                                    "  NVL(req.REQ_EXT_SOL,' ') TELEFONO,\n" +
                                    "  NVL(req.REQ_ACTION_ING,' ') DESCRIPCION_ESR,\n" +
                                    "  NVL(req.REQ_CHK_REF,' ') REFERENCIAS_CONSULTADAS,\n" +
                                    "  NVL(req.REQ_CHK_OTHEREF,' ') OTRAS_REFERNCIAS,\n" +
                                    "  NVL(req.REQ_OTHERREF,' ') OTRAS_REFERENCIAS,\n" +
                                    "  NVL(req.REQ_CLAS_REPAIR,' ') cLASIFICACION_REP,\n" +
                                    "  NVL(req.REQ_CRITICAL_ESR,' ') CRITICAL_ESR,\n" +
                                    "  NVL(req.REQ_REQ_ENV,' ') req_env,\n" +
                                    "  NVL(req.LOGPAGE,' ') taskcard,\n" +
                                    "  NVL(req.LOGPAGE,' ')\n" +
                                    "  ||'-'\n" +
                                    "  ||NVL(req.NUMEROLOGPAGE,' ') TASKCARDS,\n" +
                                    "  NVL(req.NUMEROLOGPAGE,' ') milestoneName,\n" +
                                    "  (DECODE(req.REQ_COD_ING_ENC, NULL, 1, 0) ) existeArchivo,\n" +
                                    "  NVL(TO_CHAR(req.REQ_FECHA_INS, 'mm/dd/yyyy HH24:MI:SS'),' ') fechaIngreso,\n" +
                                    "  NVL((SELECT NVL(CORE.CORE_USERS.USR_NAME,' ')\n" +
                                    "  FROM CORE.CORE_USERS\n" +
                                    "  WHERE CORE.CORE_USERS.USR_CODUSR = req.REQ_COD_ING_ENC\n" +
                                    "  ),' ') ingEncargadoDescription,\n" +
                                    "  NVL(eei.EIN_STATUS,0) CODIGO_ESTADOS,\n" +
                                    "  NVL(sts.EST_DESC,' ') NOMBRE_ESTADOS,\n" +
                                    "  NVL((SELECT REQ_USR_INS\n" +
                                    "    ||' - '\n" +
                                    "    ||USR_NAME\n" +
                                    "  FROM CORE.CORE_USERS usuario\n" +
                                    "  WHERE usuario.USR_CODUSR = REQ_USR_INS\n" +
                                    "  ),' ') USUARIO_INGRESO_TRACKING,\n" +
                                    "  NVL(EEI.EIN_DESCRIPTION,' ') DESCRIPCION_TRACKING,\n" +
                                    "  NVL(TO_CHAR(EEI.EIN_DATE,'MM/DD/YYYY HH24:MI:SS'),' ') FECHA_INGRESO_TRACKING,\n" +
                                    "  NVL(TO_CHAR(cdr.wo_closed_date, 'DD/MM/YYYY HH24:MI:SS'),' ') cierre,\n" +
                                    "  NVL(EIN_ACTION_ID,0) idaccionEng" +
                                    "    FROM ENG.ENG_REQUEST req,\n" +
                                    "      ENG.ENG_REQ_INGACTION eei,\n" +
                                    "      CONT.CONT_CHECK CH ,\n" +
                                    "      ENG.ENG_REQ_STATUS STS,\n" +
                                    "      sita.cdr_check cdr\n" +
                                    "    WHERE ";
                                            if(!("").equals(wos)){
                                                sql += " TRIM(CH.CHK_WO) IN ('"+wos+"') ";
                                            }else{
                                                if(("A").equals(woa)){
                                                    sql += " trim(replace(replace(CH.CHK_WO,'-','_'),'/','_')) IN (select trim(wo_yecorit) from sita.cdr_check a where case when nvl(revised_etr,final_date) > sysdate then 'A' else 'I' end = 'A') ";
                                                }else{
                                                    sql += " trim(replace(replace(CH.CHK_WO,'-','_'),'/','_')) IN (select trim(wo_yecorit) from sita.cdr_check a where case when nvl(revised_etr,final_date) > sysdate then 'A' else 'I' end = 'I') ";   
                                                }                
                                                if((fecha != null)&&(!("").equals(fecha))){
                                                    sql += " and cdr.wo_closed_date between to_date('"+fecha+"','DD/MM/YYYY') and to_date('"+fechafin+"','DD/MM/YYYY')";
                                                }                
                                            }
                             sql += "    AND req.REQ_MESSAGEID  = eei.REQ_MESSAGEID\n" +
                                    "    AND REQ.CHK_CHECKID    = CH.CONT_CHECK_ID\n" +
                                    "    AND (eei.EIN_STATUS    = sts.EST_CODE)\n" +
                                    "    AND ch.CHK_WO_YEAR     = cdr.wo_year\n" +
                                    "    AND ch.CHK_WO_CORR     = cdr.wo_corr\n" +
                                    "    AND ch.CHK_WO_ITEM     = cdr.wo_item \n" +
                                    "" +
                                    "    UNION ALL\n" +
                                    "    SELECT req.REQ_REGISTRY,\n" +
                                    "  NVL(CH.CHK_WO,'null') CHK_WO,\n" +
                                    "  'ESR-'\n" +
                                    "  ||req.ATA_NUMATA\n" +
                                    "  ||'-'\n" +
                                    "  ||req.REQ_CORR\n" +
                                    "  ||'/'\n" +
                                    "  ||SUBSTR(req.REQ_YEAR,3,2) NUMERO_ESR,\n" +
                                    "  NVL(req.ATA_NUMATA,0)ATA_NUMATA,\n" +
                                    "  NVL(req.REQ_MODEL,'null') model,\n" +
                                    "  NVL(TO_CHAR(req.REQ_ISSUEDATE,'MM/DD/YYYY HH24:MI:SS'),' ') FECHA_REQUISICION,\n" +
                                    "  NVL(TO_CHAR(req.REQ_DUE_DATE,'MM/DD/YYYY HH24:MI:SS'),' ') FECHA_VENCIMIENTO,\n" +
                                    "  NVL(TO_CHAR(req.REQ_RESPONSEDT,'MM/DD/YYYY HH24:MI:SS'),' ') FECHA_RESPUESTA,\n" +
                                    "  NVL(req.REQ_COMPONENT,' ')COMPONENTE,\n" +
                                    "  NVL(req.REQ_PN,' ')NUMERO_PARTE,\n" +
                                    "  NVL(req.REQ_SN,' ') NUMERO_SERIE,\n" +
                                    "  NVL(req.REQ_NDTREPORT,' ') REPORTE_ADJUNTO_NDT,\n" +
                                    "  NVL(req.REQ_REPAIRAREA,' ') repairarea,\n" +
                                    "  NVL(req.REQ_REFFOUND,' ') reffound,\n" +
                                    "  NVL(req.REQ_STATAIRCRAFT,' ') stataircraft,\n" +
                                    "  NVL(req.REQ_PROBDESC,' ') DESCRIPCION_PROBLEMA,\n" +
                                    "  NVL(req.REQ_EXT_SOL,' ') TELEFONO,\n" +
                                    "  NVL(req.REQ_ACTION_ING,' ') DESCRIPCION_ESR,\n" +
                                    "  NVL(req.REQ_CHK_REF,' ') REFERENCIAS_CONSULTADAS,\n" +
                                    "  NVL(req.REQ_CHK_OTHEREF,' ') OTRAS_REFERNCIAS,\n" +
                                    "  NVL(req.REQ_OTHERREF,' ') OTRAS_REFERENCIAS,\n" +
                                    "  NVL(req.REQ_CLAS_REPAIR,' ') cLASIFICACION_REP,\n" +
                                    "  NVL(req.REQ_CRITICAL_ESR,' ') CRITICAL_ESR,\n" +
                                    "  NVL(req.REQ_REQ_ENV,' ') req_env,\n" +
                                    "  NVL(req.LOGPAGE,' ') taskcard,\n" +
                                    "  NVL(req.LOGPAGE,' ')\n" +
                                    "  ||'-'\n" +
                                    "  ||NVL(req.NUMEROLOGPAGE,' ') TASKCARDS,\n" +
                                    "  NVL(req.NUMEROLOGPAGE,' ') milestoneName,\n" +
                                    "  (DECODE(req.REQ_COD_ING_ENC, NULL, 1, 0) ) existeArchivo,\n" +
                                    "  NVL(TO_CHAR(req.REQ_FECHA_INS, 'mm/dd/yyyy HH24:MI:SS'),' ') fechaIngreso,\n" +
                                    "  NVL((SELECT NVL(CORE.CORE_USERS.USR_NAME,' ')\n" +
                                    "  FROM CORE.CORE_USERS\n" +
                                    "  WHERE CORE.CORE_USERS.USR_CODUSR = req.REQ_COD_ING_ENC\n" +
                                    "  ),' ') ingEncargadoDescription,\n" +
                                    "  NVL(eei.EIN_STATUS,0) CODIGO_ESTADOS,\n" +
                                    "  NVL(sts.EST_DESC,' ') NOMBRE_ESTADOS,\n" +
                                    "  NVL((SELECT REQ_USR_INS\n" +
                                    "    ||' - '\n" +
                                    "    ||USR_NAME\n" +
                                    "  FROM CORE.CORE_USERS usuario\n" +
                                    "  WHERE usuario.USR_CODUSR = REQ_USR_INS\n" +
                                    "  ),' ') USUARIO_INGRESO_TRACKING,\n" +
                                    "  NVL(EEI.EIN_DESCRIPTION,' ') DESCRIPCION_TRACKING,\n" +
                                    "  NVL(TO_CHAR(EEI.EIN_DATE,'MM/DD/YYYY HH24:MI:SS'),' ') FECHA_INGRESO_TRACKING,\n" +
                                    "  NVL(TO_CHAR(cdr.wo_closed_date, 'DD/MM/YYYY HH24:MI:SS'),' ') cierre,\n" +
                                    "  NVL(EIN_ACTION_ID,0) idaccionEng" +
                                    "    FROM ENG.ENG_REQUEST req,\n" +
                                    "      ENG.ENG_REQ_INGACTION eei,\n" +
                                    "      CONT.CONT_CHECK CH ,\n" +
                                    "      ENG.ENG_REQ_STATUS STS,\n" +
                                    "      sita.cdr_check cdr\n" +
                                    "    WHERE ";
                                            if(!("").equals(wos)){
                                                sql += " TRIM(CH.CHK_WO) IN ('"+wos+"') ";
                                            }else{
                                                if(("A").equals(woa)){
                                                    sql += " trim(replace(replace(CH.CHK_WO,'-','_'),'/','_')) IN (select trim(wo_yecorit) from sita.cdr_check a where case when nvl(revised_etr,final_date) > sysdate then 'A' else 'I' end = 'A') ";
                                                }else{
                                                    sql += " trim(replace(replace(CH.CHK_WO,'-','_'),'/','_')) IN (select trim(wo_yecorit) from sita.cdr_check a where case when nvl(revised_etr,final_date) > sysdate then 'A' else 'I' end = 'I') ";   
                                                }                
                                                if((fecha != null)&&(!("").equals(fecha))){
                                                    sql += " and cdr.wo_closed_date between to_date('"+fecha+"','DD/MM/YYYY') and to_date('"+fechafin+"','DD/MM/YYYY')";
                                                }                
                                            }
                             sql += "            AND req.REQ_MESSAGEID  = eei.REQ_MESSAGEID\n" +
                                    "            AND REQ.CHK_CHECKID    = CH.CONT_CHECK_ID\n" +
                                    "            AND (eei.EIN_STATUS    = sts.EST_CODE)\n" +
                                    "            AND ch.CHK_WO_YEAR     = cdr.wo_year\n" +
                                    "            AND ch.CHK_WO_CORR     = cdr.wo_corr\n" +
                                    "            AND ch.CHK_WO_ITEM     = cdr.wo_item\n" +
                                    "            order by \n" +
                                    "            CHK_WO, \n" +
                                    "            REQ_REGISTRY,  \n" +
                                    "            NUMERO_ESR, idaccionEng  desc"; 
                        Query query=em.createNativeQuery(sql);
    
        
        wo = query.getResultList();
            for(int i=0; i< wo.size(); i++){
                cwo.setReq_registry(wo.get(i)[0].toString());
                cwo.setChk_wo(wo.get(i)[1].toString());
                cwo.setNumero_esr(wo.get(i)[2].toString());
                cwo.setAta_numata(wo.get(i)[3].toString());
                cwo.setModel(wo.get(i)[4].toString());
                cwo.setFecha_requisicion(wo.get(i)[5].toString());
                cwo.setFecha_vencimiento(wo.get(i)[6].toString());
                cwo.setFecha_respuesta(wo.get(i)[7].toString());
                cwo.setComponente(wo.get(i)[8].toString());
                cwo.setNumero_parte(wo.get(i)[9].toString());
                cwo.setNumero_serie(wo.get(i)[10].toString());
                cwo.setReporte_adjunto_ndt(wo.get(i)[11].toString());
                cwo.setRepairarea(wo.get(i)[12].toString());
                cwo.setReffound(wo.get(i)[13].toString());
                cwo.setStataircraft(wo.get(i)[14].toString());
                cwo.setDescripcion_problema(wo.get(i)[15].toString());
                cwo.setTelefono(wo.get(i)[16].toString());
                cwo.setDescripcion_esr(wo.get(i)[17].toString());
                cwo.setReferencias_consultadas(wo.get(i)[18].toString());
                cwo.setOtras_referncias(wo.get(i)[19].toString());
                cwo.setOtras_referencias(wo.get(i)[20].toString());
                cwo.setClasificaciones_rep(wo.get(i)[21].toString());
                cwo.setCritical_esr(wo.get(i)[22].toString());
                cwo.setReq_env(wo.get(i)[23].toString());
                cwo.setTaskcard(wo.get(i)[24].toString());
                cwo.setTaskcards(wo.get(i)[25].toString());
                cwo.setMilestonename(wo.get(i)[26].toString());
                cwo.setExistearchivo(wo.get(i)[27].toString());
                cwo.setFechaingreso(wo.get(i)[28].toString());
                cwo.setIngencargadodescription(wo.get(i)[29].toString());
                cwo.setCodigo_estados(wo.get(i)[30].toString());
                cwo.setNombre_estados(wo.get(i)[31].toString());
                cwo.setUsuario_ingreso_tracking(wo.get(i)[32].toString());
                cwo.setDescripcion_tracking(wo.get(i)[33].toString());
                cwo.setFecha_ingreso_tracking(wo.get(i)[34].toString());
                cwo.setCierre(wo.get(i)[35].toString());
                cwo.setIdaccioneng(wo.get(i)[36].toString());                
                cargaw.add(cwo);
            }         
                if(!wo.isEmpty()) {
                return cargaw;
            }
           
        }catch(Exception e){
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);
        }
        return cargaw;
    }     
    
       public List<ReporteDatos> datos3(String wos,String woa,String fecha,String fechafin) throws SQLException{
            
            
            ReporteDatos cwo=new ReporteDatos();
            List<ReporteDatos> cargaw=new ArrayList();
            List<Object[]> wo=new ArrayList();
            
            try{
                
                em = getEntityManager(); 
                String sql =    "SELECT NVL(req.REQ_REGISTRY,' ') COLA,\n" +
                                "  NVL(CH.CHK_WO,' ') WO,\n" +
                                "  'ESR-'\n" +
                                "  || NVL(req.ATA_NUMATA,0)\n" +
                                "  ||'-'\n" +
                                "  || NVL(req.REQ_CORR,0)\n" +
                                "  ||'/'\n" +
                                "  ||SUBSTR( NVL(req.REQ_YEAR,0),3,2) NUMERO_ESR,\n" +
                                "  NVL(req.LOGPAGE,' ') TASKCARD,\n" +
                                "  NVL(reT.ERT_TK_YEAR,' ')\n" +
                                "  ||'-'\n" +
                                "  ||NVL(reT.ERT_TK_CORR,' ') TASKCARDS,\n" +
                                "  NVL(res.RES_ID,0) CODIGO_MENSAJE,\n" +
                                "  NVL(TO_CHAR(res.RES_DATE_INS, 'mm/dd/yyyy HH24:MI:SS'),' ') FECHA_ENVIO,\n" +
                                "  NVL(res.RES_COD_USR_MSG, ' ') COD_USRENVIA,\n" +
                                "  NVL(rh.dge_nombre_isss, ' ') NOMBRE_USRENVIA,\n" +
                                "  NVL(rh.dge_nombre_cco,' ') CCO_USRENVIA,\n" +
                                "  NVL(res.RES_BODY,' ') MENSAJE,\n" +
                                "  NVL(REQ.REQ_MESSAGEID,0) MESSAGE_ID" +
                                "   from CONT.CONT_CHECK CH\n" +
                                "   join ENG.ENG_REQUEST req on CH.CONT_CHECK_ID = REQ.REQ_YEAR\n" +
                                "   left join ENG_ENGREQ_TK ret on REQ.REQ_MESSAGEID = RET.REQ_MESSAGEID\n" +
                                "   left join ENG_REQ_RESPONSES res on req.REQ_MESSAGEID = RES.REQ_MESSAGEID\n" +
                                "   left join rrhh.pla_dge_general_empleado rh on res.res_cod_usr_msg = rh.dge_codigo_anterior , sita.cdr_check cdr \n" +
                                "   where " ;
                                
                if(wos!=null && !("").equals(wos)){
                    sql += " TRIM(CH.CHK_WO) in ('"+wos+"')  ";
                }else{
                    if(woa!=null && !("").equals(woa) && ("A").equals(woa)){
                        sql += " and trim(replace(replace(CH.CHK_WO,'-','_'),'/','_')) IN (select trim(wo_yecorit) from sita.cdr_check a where case when nvl(revised_etr,final_date) > sysdate then 'A' else 'I' end = 'A') ";
                    }else{
                        sql += " and trim(replace(replace(CH.CHK_WO,'-','_'),'/','_')) IN (select trim(wo_yecorit) from sita.cdr_check a where case when nvl(revised_etr,final_date) > sysdate then 'A' else 'I' end = 'I') ";   
                    }                
                    if((fecha != null)&&(!("").equals(fecha))){
                        sql += " and cdr.wo_closed_date between to_date('"+fecha+"','DD/MM/YYYY hh24:mi:ss') and to_date('"+fechafin+"','DD/MM/YYYY hh24:mi:ss') ";
                    }                
                }
                         sql += "   AND ch.CHK_WO_YEAR     = cdr.wo_year " +
                                "   AND ch.CHK_WO_CORR     = cdr.wo_corr " +
                                "   AND ch.CHK_WO_ITEM     = cdr.wo_item ";
                        Query query=em.createNativeQuery(sql); 
                
               wo = query.getResultList();
            for(int i=0; i< wo.size(); i++){
                cwo.setCola(wo.get(i)[0].toString());
                cwo.setWo(wo.get(i)[1].toString());
                cwo.setNumero_esr(wo.get(i)[2].toString());
                cwo.setTaskard(wo.get(i)[3].toString());
                cwo.setTaskards(wo.get(i)[4].toString());
                cwo.setCodigo_mensaje(wo.get(i)[5].toString());
                cwo.setFecha_envio(wo.get(i)[6].toString());
                cwo.setCod_userenvia(wo.get(i)[7].toString());
                cwo.setNombre_userenvia(wo.get(i)[8].toString());
                cwo.setCco_userenvia(wo.get(i)[9].toString());
                cwo.setMensaje(wo.get(i)[10].toString());
                cwo.setMensaje_id(wo.get(i)[11].toString());
                cargaw.add(cwo);
            }         
                if(!wo.isEmpty()) {
                return cargaw;
            }
            }catch(Exception e){
                Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);
            }
            return cargaw;
        }
       public String ontenerConDatos(String fechaini,String fechafin) throws SQLException{
        String colas = "";
        try{
            em = getEntityManager();
            String sql = "select to_char(substr(nvl(replace((wm_concat(trim(trim( ac_codigo)))),',',', '),' '),0,4000)) colas from(\n" +
                        " select distinct cdr.ac_codigo \n" +
                        " from ENG.ENG_REQUEST req,\n" +
                        " ENG.ENG_REQ_INGACTION eei,\n" +
                        " CONT.CONT_CHECK CH ,\n" +
                        " ENG.ENG_REQ_STATUS STS,\n" +
                        " sita.cdr_check cdr where  \n" +
                        " req.REQ_MESSAGEID = eei.REQ_MESSAGEID\n" +
                        " AND REQ.CHK_CHECKID   = CH.CONT_CHECK_ID\n" +
                        " AND (req.REQ_STATUS   = sts.EST_CODE\n" +
                        " OR eei.EIN_STATUS     = sts.EST_CODE) \n" +
                        " AND ch.CHK_WO_YEAR    = cdr.wo_year \n" +
                        " AND ch.CHK_WO_CORR    = cdr.wo_corr \n" +
                        " AND ch.CHK_WO_ITEM    = cdr.wo_item" + 
                         " and cdr.wo_closed_date between to_date('"+fechaini+"','DD/MM/YYYY hh24:mi:ss') and to_date('"+fechafin+"','DD/MM/YYYY hh24:mi:ss')"+
                         ")";
            
            Query query=em.createNativeQuery(sql); 
            colas =(String)query.toString();                     
        }catch(Exception e){
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);
        }
        return colas;
    }
       
       
           public String obtenerTodas() throws SQLException{
        String colas = "";
        try{
            em = getEntityManager();
            String sql = "select replace(to_char(wm_concat(trim(trim(ac_codigo)))),',',', ') colas from sita.cdr_check a where case when nvl(revised_etr,final_date) > sysdate then 'A' else 'I' end = 'A'";
            
             Query query=em.createNativeQuery(sql); 
            colas =(String)query.toString(); 
                                 
        }catch(Exception e){
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);
        }
        return colas;
    }
    public String woEsr(int id) {

        String a = "";
        int n = 1;
        try {

            em = getEntityManager();
            Query query = em.createNativeQuery("SELECT ENG_TIPO_SOLICITUD ||'-'||ata_numata||'-'||req_corr||'/'||TO_CHAR(TO_DATE(e.REQ_YEAR,'YYYY'),'YY')\n" +
"                    FROM ENG_REQUEST e ,\n" +
"                      CONT.CONT_CHECK c\n" +
"                    WHERE e.REQ_MESSAGEID="+id+"\n" +
"                    AND e.CHK_CHECKID    =c.CONT_CHECK_ID");
                   
            query.setMaxResults(n);
            a = (String) query.getSingleResult().toString();

            return a;

        } catch (Exception e) {
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            em.close();
        }

        return a;
    }
    
    public int maxesrdocument (){
        int numDoc=0;
        int initialMaxEsr=1;
        try {
            em = getEntityManager();
            Query qMaxEsr = em.createNativeQuery("SELECT NVL(max(a.ID_DOCU)+1,1) as id from eng_esr_document a");
            qMaxEsr.setMaxResults(initialMaxEsr);
            String aMaxEsr=(String) qMaxEsr.getSingleResult().toString();         
            numDoc=Integer.parseInt(aMaxEsr);
            
        }catch(Exception e){
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);
            
        }finally{
            em.close();
        }
        return  numDoc ;
          
    }
    
     public int maxUpdateFile (){
        int numDoc=0;
        int initialMaxEsr=1;
        try {
            em = getEntityManager();
            Query qMaxEsr = em.createNativeQuery("SELECT NVL(max(a.ID_DOCUMENT)+1,1) as id from ENG_UPLOAD_PLANTILLA_SEQ a");
            qMaxEsr.setMaxResults(initialMaxEsr);
            String aMaxEsr=(String) qMaxEsr.getSingleResult().toString();         
            numDoc=Integer.parseInt(aMaxEsr);
            
        }catch(Exception e){
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);
            
        }finally{
            em.close();
        }
        return  numDoc ;
          
    }
    
    public String maxesrcor (BigDecimal idATA, String year){
        String numCor="";
        try {
            em = getEntityManager();
            Query qCor = em.createNativeQuery("select LPAD( nvl(max(to_number(e.REQ_CORR)),0)+1,4,'0')  as ID from ENG_REQUEST e WHERE e.ATA_NUMATA = "+idATA.intValue()+" AND e.REQ_YEAR = '"+year+"'");            
            String aCor= qCor.getSingleResult().toString();         
            numCor=aCor;
            
        }catch(Exception e){
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);
            
        }finally{
            em.close();
        }
        return  numCor;
          
    }
    
    public String MaxEACorr (BigDecimal idATA, String year){
        String numCor="0";
        int nCor=1;
        try {
            em = getEntityManager();
            Query qCor = em.createNativeQuery("select LPAD(nvl(max(to_number(e.EAG_CORRELATIVE)),0)+1, 4, '0')  as ID from ENG_EA_GENERAL e WHERE  e.EAG_YEAR = '"+year+"'");            
            String aCor= qCor.getSingleResult().toString();         
            numCor=aCor;
            
        }catch(Exception e){
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);
            
        }finally{
            em.close();
        }
        return  numCor ;
          
    }
    
    public int idTaskcard(){
        int numCorTask=0;
        int nCorTask=1;
        try {
            em = getEntityManager();
            Query qCorTask = em.createNativeQuery("select nvl(max(ERT_ID_REG),0)+1 from eng.ENG_REQ_TASK_CARD");
            qCorTask.setMaxResults(nCorTask);
            String aCorTask=(String) qCorTask.getSingleResult().toString();         
            numCorTask=Integer.parseInt(aCorTask);
            
        }catch(Exception e){
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);
            
        }finally{
            em.close();
        }
        return  numCorTask ;
          
    }
    public List<Object[]> esrpormecanico(String user){
          List<Object[]> result = new ArrayList();
        try {
            em = getEntityManager();
            Query query = em.createNativeQuery("SELECT e.REQ_MESSAGEID ESR, NVL(c.CHK_WO_YEAR,0)\n" +
"                     ||'-'\n" +
"                      ||NVL(c.CHK_WO_CORR,0)\n" +
"                      ||'/'\n" +
"                      ||NVL(c.CHK_WO_ITEM,0)  \n" +
"                      || '- ESR ' || ata_numata||'-'||req_corr||'/'||TO_CHAR(TO_DATE(c.CHK_WO_YEAR,'YYYY'),'YY')  WoOrder,e.COMPANY,e.REQ_FECHA_INS,e.REQ_PROBDESC,"
                    + "e.REQ_CUSTOMER,e.req_Registry,e.REQ_USR_INS,e.usr_coduser\n" +
            " FROM ENG_REQUEST e , CONT.CONT_CHECK c where e.CHK_CHECKID=c.CONT_CHECK_ID and e.REQ_USR_INS = '"+user+"' order by e.REQ_MESSAGEID desc");
            result=(List<Object[]>)query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;
     }
    /*  agrega para horas de ing  */
    public List<HoursExport> findHrsExport(String checkid){
     HoursExport hrs=new HoursExport();
     List<HoursExport> cargaw=new ArrayList();
     List<Object[]> wos=new ArrayList();
     try{
     em = getEntityManager();        
     String sql=" SELECT NVL('ESR-'||REQ.ATA_NUMATA||'-'||REQ.REQ_CORR||'/'||SUBSTR(REQ.REQ_YEAR,3,2),'') NESR,\n" +
                "  NVL(CHK.CHK_WO_YEAR,0) YEAR,\n" +
                "  NVL(CHK.CHK_WO_CORR,0) CORR,\n" +
                "  NVL(CHK.CHK_WO_ITEM,0) ITEM,\n" +
                "  REQ.REQ_MESSAGEID MESSAGEID,\n" +
                "  NVL(REQ.REQ_PROBDESC,' ') SUBJECT,\n" +
                "  NVL(TO_CHAR(HIN.HIN_HRS_BILL),0) FACTURAR,\n" +
                "  NVL(HIN.HIN_SELECTION,'N') SELECCION,\n" +
                "  NVL(HIN.HIN_EXPORTED, 0) EXPORTADO,\n" +
                "  NVL(HIN.EHI_ID, 0) COMBOINDEX,\n" +
                "  NVL(\n" +
                "  (SELECT NVL(SUM(ING.EIN_HOURS),0)\n" +
                "  FROM ENG.ENG_REQ_INGACTION ING\n" +
                "  WHERE ING.REQ_MESSAGEID = REQ.REQ_MESSAGEID\n" +
                "  ),0) SUMHOURS, "+ 
                "  trim(AER.pfin010_cucod) CUCOD, "+ 
                "  trim(AER.pwos012_acreg) ACREG" +
                "  FROM ENG.ENG_REQUEST REQ,\n" +
                "  CONT.CONT_CHECK CHK,\n" +
                "  ENG.ENG_HORAS_ING HIN,"+
                "  aer.pwos012 AER " +
                " WHERE CHK.CONT_CHECK_ID  = "+checkid+" " +
                " AND REQ.CHK_CHECKID      = CHK.CONT_CHECK_ID "+
                " AND AER.PWOS012_ORDYR= CHK.CHK_WO_YEAR " +
                " AND AER.PWOS012_ORDER= CHK.CHK_WO_CORR " +
                " AND AER.PWOS012_TASK = HIN.HIN_WO_TASK " +
                " AND HIN.REQ_MESSAGEID (+)= REQ.REQ_MESSAGEID " +
                " ORDER BY REQ.REQ_MESSAGEID DESC";
     Query query=em.createNativeQuery(sql);
     wos=query.getResultList();
     for(int i=0; i< wos.size(); i++){
         hrs.setNESR(wos.get(i)[0].toString());
         hrs.setYEAR(wos.get(i)[1].toString());
         hrs.setCORR(wos.get(i)[2].toString());
         hrs.setITEM(wos.get(i)[3].toString());
         hrs.setMESSAGEID(wos.get(i)[4].toString());
         hrs.setSUBJECT(wos.get(i)[5].toString());
         hrs.setFACTURAR(wos.get(i)[6].toString());
         hrs.setSELECCION(wos.get(i)[7].toString());
         hrs.setEXPORTADO(wos.get(i)[8].toString());
         hrs.setCOMBOINDEX(wos.get(i)[9].toString());
         hrs.setSUMHOURS(wos.get(i)[10].toString());
         hrs.setCUCOD(wos.get(i)[11].toString());
         hrs.setACREG(wos.get(i)[12].toString());
         cargaw.add(hrs);
     }
    return cargaw;
     }catch(Exception e){
         Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);
     }finally{
         em.close();
     }
     return cargaw;
}


public List vexportarhoras (int yearchequeos,int workorderchequeos, int registrychequeos){
    List<Object[]> wos=new ArrayList();
        try {
            em = getEntityManager();
            Query query = em.createNativeQuery("select count(*) WO FROM AECAS.AECAS_ESR_MH WHERE ESR_WO_YEAR= "+yearchequeos+" AND ESR_WO_ORDER= "+workorderchequeos+" AND ESR_WO_TASK= "+registrychequeos+"");
            wos= query.getResultList();
            return  wos;
        }catch(Exception e){
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);
            
        }finally{
            em.close();
        }
        return  wos ;
        }

@Transactional
public int exportarhorasup (List<EngHoursVw> form,String user){
        List<EngHoursVw> forms;
        forms=form;
        int cont= 0;
        int n=1;
        try {
            em = getEntityManager();
            for(int i=0;i<forms.size();i++){
            String sql =" select count(*) from AECAS.AECAS_ESR_MH " +
                        " WHERE ESR_WO_YEAR ="+forms.get(i).getChkYear()+"    "+
                        " AND ESR_WO_ORDER ="+forms.get(i).getCorr()+"     "+
                        " AND ESR_WO_TASK ="+forms.get(i).getItem()+"      "+
                        " AND trim(ESR_ESR_ID)='"+forms.get(i).getNesr()+"'"+
                        " AND trim(ESR_ACREG)='"+forms.get(i).getReqTail()+"'"+
                        " AND trim(ESR_CUCOD)='"+forms.get(i).getCustomer()+"'";
            Query query=em.createNativeQuery(sql);
            query.setMaxResults(n);
            String a=(String) query.getSingleResult().toString();         
            cont=Integer.parseInt(a);
            
            }
            return cont; 
        }catch(Exception e){
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);
            
        }finally{
            em.close();
        }
        return  0 ;
        }






public String woOrder (Short chechid){
        int n=1;
        try {
            em = getEntityManager();
            String sql ="SELECT nvl(c.CHK_WO_YEAR,0)||'/'||nvl(c.CHK_WO_CORR,0)||'-'||nvl(c.CHK_WO_ITEM,0)  WoOrder " +
                                               "FROM ENG_REQUEST e , CONT.CONT_CHECK c where c.CONT_CHECK_ID="+chechid+" and e.CHK_CHECKID=c.CONT_CHECK_ID and rownum =1";
              
            Query query=em.createNativeQuery(sql);
            query.setMaxResults(n);
            String a=(String) query.getSingleResult().toString();         
            
            return  a;
        }catch(Exception e){
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);
            
        }finally{
            em.close();
        }
        return  null ;
        }
public List<HoursExp> HrsExport(String checkid){
    HoursExp hrs;
     List<HoursExp> cargaw=new ArrayList();
     List<Object[]> wos;
     try{
     em = getEntityManager();        
     String sql=" SELECT NVL('ESR-'||REQ.ATA_NUMATA||'-'||REQ.REQ_CORR||'/'||SUBSTR(REQ.REQ_YEAR,3,2),'') NESR,\n"+
                "  NVL(HIN.HIN_ID,0)HIN_ID," +
                "  NVL(REQ.REQ_PROBDESC,' ') SUBJECT,\n" +
                "  NVL((SELECT ING.EIN_DESCRIPTION\n" +
                "  FROM ENG.ENG_REQ_INGACTION ING\n" +
                "  WHERE ING.REQ_MESSAGEID = REQ.REQ_MESSAGEID\n" +
                "  ), ' ') EACOMPLETADO,\n" +
                "  NVL(EOSEA.EHI_NAME, ' ') EA,\n" +
                "  (SELECT NVL(SUM(ING.EIN_HOURS),0)\n" +
                "  FROM ENG.ENG_REQ_INGACTION ING\n" +
                "  WHERE ING.REQ_MESSAGEID = REQ.REQ_MESSAGEID\n" +
                "  ) SUMHOURS,\n" +
                "  NVL(CHK.WO_CORR, 0) CORR,\n" +
                "  NVL(CHK.WO_ITEM,0) ITEM,\n" +
                "  NVL(REQ.REQ_MESSAGEID,0) REQ_MESSAGEID,\n" +
                "  NVL(CHK.WO_YEAR,0) YEAR,\n" +
                "  NVL(TO_CHAR(HIN.HIN_HRS_BILL),0) FACTURAR,\n" +
                "  NVL(HIN.HIN_SELECTION,'N') SELECCION,\n" +
                "  NVL(HIN.HIN_EXPORTED,' ') EXPORTADO,\n" +
                "  NVL(HIN.EHI_ID,0) COMBOINDEX " +
                "  FROM ENG.ENG_REQUEST REQ,\n" +
                "  ENG.ENG_HCHECK CHK,\n" +
                "  ENG.ENG_HORAS_ING HIN,\n" +
                "  ENG.ENG_HRS_INS EOSEA\n" +
                "WHERE CHK.CHECKID        ="+checkid+"\n" +
                "AND REQ.CHK_CHECKID      = CHK.CHECKID\n" +
                "AND HIN.REQ_MESSAGEID (+)= REQ.REQ_MESSAGEID\n" +
                "AND HIN_SELECTION(+)     = 'S'\n" +
                "AND EOSEA.EHI_ID(+)      = HIN.EHI_ID\n" +
                "ORDER BY REQ.REQ_MESSAGEID DESC";
     Query query=em.createNativeQuery(sql);
     wos=query.getResultList();
     for(int i=0; i< wos.size(); i++){
         hrs = new HoursExp();
         hrs.setNESR(wos.get(i)[0].toString());
         hrs.setHIN_ID(wos.get(i)[1].toString());
         hrs.setSUBJECT(wos.get(i)[2].toString());
         hrs.setCOMPLETADO(wos.get(i)[3].toString());
         hrs.setEA(wos.get(i)[4].toString());
         hrs.setSUMHOURS(new BigDecimal(wos.get(i)[5].toString()) );
         hrs.setCORR(wos.get(i)[6].toString());
         hrs.setITEM(wos.get(i)[7].toString());
         hrs.setMESSAGEID(wos.get(i)[8].toString());
         hrs.setYEAR(wos.get(i)[9].toString());
         hrs.setFACTURAR(new BigDecimal(wos.get(i)[10].toString()));
         hrs.setSELECCION(wos.get(i)[11].toString());
         hrs.setEXPORTADO(wos.get(i)[12].toString());
         hrs.setCOMBOINDEX(wos.get(i)[13].toString());
         cargaw.add(hrs);
     }
    return cargaw;
     }catch(Exception e){
         Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);
     }finally{
         em.close();
     }
     return cargaw;
}


public int maxHrsIng (){
        int numHrsIng=0;
        int nHrsIng=1;
        try {
            em = getEntityManager();
            Query qHrsIng = em.createNativeQuery("select nvl(max(a.HIN_ID),0)+1 as id from ENG_HORAS_ING a");
            qHrsIng.setMaxResults(nHrsIng);
            String aHrsIng=(String) qHrsIng.getSingleResult().toString();         
            numHrsIng=Integer.parseInt(aHrsIng);
            return numHrsIng; 
        }catch(Exception e){
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);
            
        }finally{
            em.close();
        }
        return  0 ;
          
    }

public BigInteger maxHorasIng (){
        BigInteger num=new BigInteger("0");
        int n=1;
        try {
            em = getEntityManager();
            Query query = em.createNativeQuery("select nvl(max(a.HIN_ID),0)+1 as id from ENG_HORAS_ING a");
            query.setMaxResults(n);
            String a=(String) query.getSingleResult().toString();         
            num=new BigInteger(a);
            return num; 
        }catch(Exception e){
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);
            
        }finally{
            em.close();
        }
        return num ;
          
    }
public List<Object[]> Q8(int pIdOrd) throws SQLException{
            
            
            Eng_QR8 cwo=new Eng_QR8();    
            List<Object[]> wo=new ArrayList();
            
            try{
                    em = getEntityManager(); 
                    String sql ="SELECT NVL(ord.eo_idord,0)eo_idord,\n" +
"                      NVL(ord.eo_rev,0)eo_rev,\n" +
"                      NVL(ord.eo_rept_type,0)eo_rept_type,\n" +
"                      NVL(ord.eo_rept_int,'-')eo_rept_int,\n" +
"                      NVL(ord.eo_rev_record,'-')eo_rev_record ,\n" +
"                      NVL(DECODE(ord.eo_ras,'I', 'X','P','X'),'-') ras,\n" +
"                      NVL(ord.eo_ras,'-') rasvalue,\n" +
"                      NVL(ord.eo_rev_date, TO_DATE('01/01/2050', 'MM-DD-YYYY'))eo_rev_date,\n" +
"                      NVL(DECODE(ord.eo_stc,'S','X'), '-') eo_stc,\n" +
"                      NVL(DECODE(ord.eo_codstseo,'SUP','INC',ord.eo_codstseo),'-') status ,\n" +
"                      NVL(ord.eo_subject,'-')eo_subject,\n" +
"                      NVL(ord.eo_summary, '-')eo_summary ,\n" +
"                      NVL(ord.eo_distlist_cmt,'-')eo_distlist_cmt,\n" +
"                      NVL(ord.eo_eng_assmnt,'-'),\n" +
"                      NVL(DECODE(ord.eo_warranty,'S','X'),'-') eo_warranty  ,\n" +
"                      NVL(DECODE(ord.eo_warranty,'N','X'),'-') warrantyNo,\n" +
"                      NVL(ord.eo_exe_date,'-')eo_exe_date ,\n" +
"                      NVL(ord.eo_exe_interval,'-')eo_exe_interval,\n" +
"                      NVL(ord.eo_int_unit,'-')eo_int_unit,\n" +
"                      NVL(DECODE(ord.eo_effect_wb,'S','X'),'-') eo_effect_wb ,\n" +
"                      NVL(DECODE(ord.eo_effect_wb,'N','X'),'-') effect_wbNo,\n" +
"                      NVL(ord.eo_lbs,'-')eo_lbs,\n" +
"                      NVL(ord.eo_lbs_in,'-')eo_lbs_in ,\n" +
"                      NVL(DECODE(ord.eo_major_form,'S','X'),'-') eo_major_form,\n" +
"                      NVL(DECODE(ord.eo_minor,'S','X'),'-') eo_minor,\n" +
"                      NVL(DECODE(ord.eo_materials,'S','X'),'-') eo_materials  ,\n" +
"                      NVL(DECODE(ord.eo_not_required,'S','X'),'-') eo_not_required,\n" +
"                      NVL(DECODE(ord.eo_upd_tecrec,'S','X'),'-') eo_upd_tecrec ,\n" +
"                      NVL(DECODE(ord.eo_inc_aff_pub,'S','X'),'-') eo_inc_aff_pub,\n" +
"                      NVL(ord.act_cod,'-')act_cod,\n" +
"                      NVL(DECODE(ord.eo_req_to_inspec,'S','X'),'-') eo_req_to_inspec,\n" +
"                      NVL(ord.eo_comments,'-')eo_comments,\n" +
"                      NVL(DECODE(ord.eo_special_tool,'S','X'),'-') eo_special_tool ,\n" +
"                      NVL(DECODE(ord.eo_ndtequipment,'S','X'),'-') eo_ndtequipment,\n" +
"                      NVL(DECODE(ord.eo_feedback,'S','X'),'-') eo_feedback ,\n" +
"                      NVL(DECODE(ord.eo_new_insp_int,'S','X'),'-') eo_new_insp_int,\n" +
"                      NVL(DECODE(ord.eo_other,'S','X'),'-') eo_other,\n" +
"                      NVL(ord.eo_correlative,0)eo_correlative,\n" +
"                      NVL(eo_man_hour_cost,0)eo_man_hour_cost ,\n" +
"                      NVL(ord.eo_creation_date, TO_DATE('01/01/2050', 'MM-DD-YYYY')), \n" +
"                      NVL(ord.eo_year,0)eo_year,\n" +
"                      NVL(ord.eo_codpre,'-')eo_codpre,\n" +
"                      NVL(ord.ATA_NUMATA,0)ATA_NUMATA,\n" +
"                      NVL(ord.flt_cod,'-')flt_cod,\n" +
"                      NVL(ord.pri_cod,0)pri_cod ,\n" +
"                      NVL(ord.wty_cod,'-')wty_cod,\n" +
"                      NVL(eng_pack.codord(ord.eo_idord),'-') numeo\n" +
"                    FROM eng_orders ord\n" +
"                    WHERE eo_idord="+pIdOrd;
                    Query query=em.createNativeQuery(sql); 
                    wo = query.getResultList();
                      for(int i=0; i< wo.size(); i++){
                      cwo.setEo_idord(wo.get(i)[0].toString());
                        cwo.setEo_rev(wo.get(i)[1].toString());
                        cwo.setEo_rept_type(wo.get(i)[2].toString());
                        cwo.setEo_rept_int(wo.get(i)[3].toString());
                        cwo.setEo_rev_record(wo.get(i)[4].toString());
                        cwo.setRas(wo.get(i)[5].toString());
                        cwo.setRasvalue(wo.get(i)[6].toString());
                        cwo.setEo_rev_date(wo.get(i)[7].toString());
                        cwo.setEo_stc(wo.get(i)[8].toString());
                        cwo.setStatus(wo.get(i)[9].toString());
                        cwo.setEo_subject(wo.get(i)[10].toString());
                        cwo.setEo_summary(wo.get(i)[11].toString());
                        cwo.setEo_distlist_cmt(wo.get(i)[12].toString());
                        cwo.setEo_eng_assmnt(wo.get(i)[13].toString());
                        cwo.setEo_warranty(wo.get(i)[14].toString());
                        cwo.setWarrantyNo(wo.get(i)[15].toString());
                        cwo.setEo_exe_date(wo.get(i)[16].toString());
                        cwo.setEo_exe_interval(wo.get(i)[17].toString());
                        cwo.setEo_int_unit(wo.get(i)[18].toString());
                        cwo.setEo_effect_wb(wo.get(i)[19].toString());
                        cwo.setEffect_wbNo(wo.get(i)[20].toString());
                        cwo.setEo_Lbs(wo.get(i)[21].toString());
                        cwo.setEo_lbs_in(wo.get(i)[22].toString());
                        cwo.setEo_major_form(wo.get(i)[23].toString());
                        cwo.setEo_minor(wo.get(i)[24].toString());
                        cwo.setEo_materials(wo.get(i)[25].toString());
                        cwo.setEo_not_required(wo.get(i)[26].toString());
                        cwo.setEo_upd_tecrec(wo.get(i)[27].toString());
                        cwo.setEo_inc_aff_pub(wo.get(i)[28].toString());
                        cwo.setAct_cod(wo.get(i)[29].toString());
                        cwo.setEo_req_to_inspec(wo.get(i)[30].toString());
                        cwo.setEo_comments(wo.get(i)[31].toString());
                        cwo.setEo_special_tool(wo.get(i)[32].toString());
                        cwo.setEo_ndtequipment(wo.get(i)[33].toString());
                        cwo.setEo_feedback(wo.get(i)[34].toString());
                        cwo.setEo_new_insp_int(wo.get(i)[35].toString());
                        cwo.setEo_other(wo.get(i)[36].toString());
                        cwo.setEo_correlative(wo.get(i)[37].toString());
                        cwo.setEo_man_hour_cost(wo.get(i)[38].toString());                       
                        cwo.setEo_creation_date(wo.get(i)[39].toString());
                        cwo.setEo_year(wo.get(i)[40].toString());
                        cwo.setEo_codpre(wo.get(i)[41].toString());
                        cwo.setATA_NUMATA(wo.get(i)[42].toString());
                        cwo.setFlt_cod(wo.get(i)[43].toString());
                        cwo.setPri_cod(wo.get(i)[44].toString());
                        cwo.setWty_cod(wo.get(i)[45].toString());
                        cwo.setNumeo(wo.get(i)[46].toString());
             
 
                
            }
                    return wo;
            }
            catch(Exception e){
                Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);
            }
            return wo;
        }
public List<GraficaCustomer> graficaCustomer(){
    GraficaCustomer gf;
    List<GraficaCustomer> cargrafica=new ArrayList();
    List<Object[]> wos;
        try {
            em = getEntityManager();
            String sql="select eng_id, sum(tasks) from ENG_TASKS_BY_CUSTOMER_VW group by eng_id";
            Query query=em.createNativeQuery(sql);
            wos=query.getResultList();
            for(int i=0; i< wos.size(); i++){
              gf=new GraficaCustomer();
              gf.setEngId(wos.get(i)[0].toString());
              gf.setCounT(wos.get(i)[1].toString());
              cargrafica.add(gf);
            }
            return cargrafica; 
        }catch(Exception e){
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);
            
        }
       
        return cargrafica;
          
    }

public List<GraficaCustomer2> graficaCustomer2(){
    GraficaCustomer2 gf=new GraficaCustomer2();
    List<GraficaCustomer2> cargrafica2=new ArrayList();
    List<Object[]> wos=new ArrayList();
        try {
            em = getEntityManager();
            String sql=" select COLOR, COUNT(*) from eng_taskS_BY_CUSTOMER_vw  group by color";
            Query query=em.createNativeQuery(sql);
            wos=query.getResultList();
            for(int i=0; i< wos.size(); i++){
              gf=new GraficaCustomer2();
              gf.setColor(wos.get(i)[0].toString());
              gf.setCounT(wos.get(i)[1].toString());
              cargrafica2.add(gf);
            }
            return cargrafica2; 
        }catch(Exception e){
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);
            
        }finally{
            em.close();
        }
        return  cargrafica2;
          
    }
public List<GraficaCustomer3> graficaCustomer3(){
    GraficaCustomer3 graficaCustomer3=new GraficaCustomer3();
    List<GraficaCustomer3> cargarGrafica3=new ArrayList();
    List<Object[]> listWos=new ArrayList();
        try {
            em = getEntityManager();
            String sqlGrafica="select company, count(*) from eng_taskS_BY_CUSTOMER_cia_vw group by COMPANY";
            
            Query qSql=em.createNativeQuery(sqlGrafica);
            listWos=qSql.getResultList();
            for(int i=0; i< listWos.size(); i++){
              graficaCustomer3=new GraficaCustomer3();
              graficaCustomer3.setCompany("\""+listWos.get(i)[0].toString()+"\"");
              graficaCustomer3.setCounT(Integer.parseInt(listWos.get(i)[1].toString()));
              cargarGrafica3.add(graficaCustomer3);
            }
            return cargarGrafica3; 
        }catch(Exception e){
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);
            
        }finally{
            em.close();
        }
        return  cargarGrafica3;
          
    }
public int maxEngStatus() {
        int numEngStatus = 0;
        int nEngStatus = 1;
        try {
            em = getEntityManager();
            Query qEngStatus = em.createNativeQuery("select nvl(max(a.EST_ID),0)+1 as id from eng_req_status a");
            qEngStatus.setMaxResults(nEngStatus);
            String aStatus = (String) qEngStatus.getSingleResult().toString();
            numEngStatus = Integer.parseInt(aStatus);
            
        } catch (Exception e) {
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            em.close();
        }
        return numEngStatus;

    }
public String content(){
        String userid="0";
        List<Object[]> rol=new ArrayList();
        
        try{
            em = getEntityManager();
            Query query= em.createNativeQuery("SELECT SYSTEMID,INITIALACTION,PUERTO FROM SGR_SISTEMA where system_name = 'AEIS-CORE'");
            rol=query.getResultList();
            HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest() ;
            HttpSession session = request.getSession();
            for(int i=0; i< rol.size(); i++){
                systemid=rol.get(i)[0].toString();
                inicial=rol.get(i)[1].toString();
                puerto=rol.get(i)[2].toString();
                session.setAttribute("systemid", systemid);
            }
             
            
            return userid;
        }catch(Exception e){
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            em.close();
        }
        return null;
    }
    
    public List<SgrRole> SgrRole(String user) {
        SgrRole role=new SgrRole();
        SgrRolePK r =new SgrRolePK();
        List<SgrRole> roles=new ArrayList();
        List<Object[]> rol=new ArrayList();
        content();
        HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest() ;
        systemid=request.getSession().getAttribute("systemid").toString();
        try {
            em = getEntityManager();
            Query query = em.createNativeQuery("select a.role_code code, a.role_desc name from sgr_role a, " +
                                " sgr_user_role b, sgr_user c, sgr_role_cia d, sgr_cia e " +
                                " where a.systemid = '"+systemid+"' " +
                                " and codigo86 = '"+user+"' " +
                                " and e.cia_code = 'AESV' " +
                                " and a.role_code = b.role_code " +
                                " and a.systemid = b.systemid " +
                                " and b.user_id = c.user_id " +
                                " and b.role_code = d.role_code " +
                                " and b.cia_code = d.cia_code " +
                                " and b.systemid = d.systemid " +
                                " and d.cia_code = e.cia_code " +
                                " and trunc(nvl(b.expired_date,sysdate)) >= trunc(sysdate)  " +
                                " and b.STATUS = 'ACT' and a.role_code in (7,4,3,2)");
            
            rol=query.getResultList();
             for(int i=0; i< rol.size(); i++){
                 role=new SgrRole();
                 r =new SgrRolePK();
                 r.setRoleCode(rol.get(i)[0].toString());
                 role.setSgrRolePK(r);
                 role.setRoleDesc(rol.get(i)[1].toString());
                 roles.add(role);
             }
            
        } catch (Exception e) {
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            em.close();
        }
        return roles;

    }
    
public List<ReportesUrl> UrlReporte(String esquema) {
        ReportesUrl role=new ReportesUrl();
        List<ReportesUrl> roles=new ArrayList();
        List<Object[]> rol=new ArrayList();
        content();
        HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest() ;
        systemid=request.getSession().getAttribute("systemid").toString();
        try {
            em = getEntityManager();
            Query query = em.createNativeQuery("SELECT esquema, server, usuario, clave, ruta FROM PROCESOS.rpt_esquemas  WHERE esquema='"+esquema+"'");
            
            rol=query.getResultList();
             for(int i=0; i< rol.size(); i++){
                 role=new ReportesUrl();
                 role.setEsquema(rol.get(i)[0].toString());
                 role.setServer(rol.get(i)[1].toString());
                 role.setUsuario(rol.get(i)[2].toString());
                 role.setClave(rol.get(i)[3].toString());
                 role.setRuta(rol.get(i)[4].toString());
                 roles.add(role);
             }
            
        } catch (Exception e) {
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            em.close();
        }
        return roles;

    }
 public List<Object[]> countByCustomer(String idCusto){
    
        List<Object[]> wos=new ArrayList();
        try {
            em = getEntityManager();
            String sql="select \n" +
                        "(select count(*)EO from eng_general_task_list_vw e where e.tipo='EO' and e.EAG_CUSTOMER='"+idCusto+"' )EO,\n" +
                        "(select count(*)EA from eng_general_task_list_vw e where e.tipo='EA' and e.EAG_CUSTOMER='"+idCusto+"')EA,\n" +
                        "(select count(*)ESR from eng_general_task_list_vw e where e.tipo='ESR' and e.EAG_CUSTOMER='"+idCusto+"')ESR\n" +
                        "from dual";
            
            Query query=em.createNativeQuery(sql);
            wos=query.getResultList();
                        
        }catch(Exception e){
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);
            
        }finally{
            em.close();
        }
        return  wos;          
    }
 public List<Object[]> countByCustomerall(){
    
        List<Object[]> wos=new ArrayList();
        try {
            em = getEntityManager();
            String sql="select \n" +
                        "(select count(*)EO from eng_general_task_list_vw e where e.tipo='EO')EO,\n" +
                        "(select count(*)EA from eng_general_task_list_vw e where e.tipo='EA')EA,\n" +
                        "(select count(*)ESR from eng_general_task_list_vw e where e.tipo='ESR')ESR\n" +
                        "from dual";
            
            Query query=em.createNativeQuery(sql);
            wos=query.getResultList();
                        
        }catch(Exception e){
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);
            
        }finally{
            em.close();
        }
        return  wos;          
    }
 public List<GraficaCustomer3> graficaCustomerManager(String idCusto){
    GraficaCustomer3 gfManager=new GraficaCustomer3();
    List<GraficaCustomer3> cargarGfManager=new ArrayList();
    List<Object[]> managerList=new ArrayList();
        try {
            em = getEntityManager();
            String sqlManager="select company, sum(tasks) from eng_taskS_BY_CUSTOMER_cia_vw where ENG_ID='"+idCusto+"' group by COMPANY";
            
            Query query=em.createNativeQuery(sqlManager);
            managerList=query.getResultList();
            for(int i=0; i< managerList.size(); i++){
              gfManager=new GraficaCustomer3();
              gfManager.setCompany("\""+managerList.get(i)[0].toString()+"\"");
              gfManager.setCounT(Integer.parseInt(managerList.get(i)[1].toString()));
              cargarGfManager.add(gfManager);
            }
            return cargarGfManager; 
        }catch(Exception e){
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);
            
        }finally{
            em.close();
        }
        return  cargarGfManager;
          
    }
 public List<GraficaCustomer3> graficaCustomerManagerall(){
    GraficaCustomer3 gfManagerAll=new GraficaCustomer3();
    List<GraficaCustomer3> cargarGfManagerAll=new ArrayList();
    List<Object[]> managerAllList=new ArrayList();
        try {
            em = getEntityManager();
            String managerAllSql="select company, sum(tasks) from ENG_TASKS_BY_CUSTOMER_CIA_VW group by COMPANY";
            
            Query qManagerAll=em.createNativeQuery(managerAllSql);
            managerAllList=qManagerAll.getResultList();
            for(int i=0; i< managerAllList.size(); i++){
              gfManagerAll=new GraficaCustomer3();
              gfManagerAll.setCompany("\""+managerAllList.get(i)[0].toString()+"\"");
              gfManagerAll.setCounT(Integer.parseInt(managerAllList.get(i)[1].toString()));
              cargarGfManagerAll.add(gfManagerAll);
            }
            return cargarGfManagerAll; 
        }catch(Exception e){
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);
            
        }finally{
            em.close();
        }
        return  cargarGfManagerAll;
          
    }
 
 public List<Object> userskill(){
        
        List<Object> wos=new ArrayList();
        try {
            em = getEntityManager();            
            Query query=em.createNativeQuery("select DISTINCT skill from eng_list_view");
            wos=query.getResultList();           
        }catch(Exception e){
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);
            
        }finally{
            em.close();
        }
        return  wos;          
    }
 
    public BigDecimal maxCodIdErt() {
        int n = 1;
        BigDecimal maxCode = null;
        em = getEntityManager();

        try {
            Query qMaxCode = em.createNativeQuery("select nvl(max(a.ERT_ID_REG)+1,1) as id from ENG_REQ_TASK_CARD a");
            qMaxCode.setMaxResults(n);
            String aMaxCode = (String) qMaxCode.getSingleResult().toString();
            Long bMaxCode = new Long(aMaxCode);
            maxCode = BigDecimal.valueOf(bMaxCode);

        } catch (Exception e) {
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            em.close();
        }
        return maxCode;
    }
 
public  String traernombredeusuario(String cod86){
        String nombre = "";
        int  i = 1;
        
        try {
            em = getEntityManager();
            
            
            Query query = em.createNativeQuery("select full_user_name from procesos.SGR_USER where rownum = 1 and CODIGO86='"+cod86+"'");
            query.setMaxResults(i);
            nombre=(String) query.getSingleResult(); 
        } catch (NoResultException e) {
            nombre="N/A";
        }  
        return nombre;
        
    }
public BigDecimal maxEmailIDConCheck(){
        em= getEntityManager();
        BigDecimal codeCheck=null;
        int n=1;
        try {
            Query qConCheck = em.createNativeQuery("select nvl(max(a.CONT_CHECK_EMAILS_ID)+1,1) as id from cont.CONT_CHECK_EMAILS a");
            qConCheck.setMaxResults(n);
            String aConCheck = (String) qConCheck.getSingleResult().toString();            
            Long bConCheck= new Long(aConCheck);
            codeCheck= BigDecimal.valueOf(bConCheck);

        } catch (Exception e) {
            Logger.getLogger(Sequences.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            em.close();
        }                
        return codeCheck; 
    }
    
    public String getSystemid() {
        return systemid;
    }

    public void setSystemid(String systemid) {
        this.systemid = systemid;
    }

    public String getInicial() {
        return inicial;
    }

    public void setInicial(String inicial) {
        this.inicial = inicial;
    }

    public String getPuerto() {
        return puerto;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }
    
}
