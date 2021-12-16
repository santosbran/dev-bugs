/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades.grant;

import com.aeroman.aees.entities.grant.ContCheck;
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
 * @author Usuario
 */
@Stateless
public class ContCheckFacade extends AbstractFacade<ContCheck> {
    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    public ContCheckFacade() {
        super(ContCheck.class);
    }
    
    @Override
    protected EntityManager getEntityManagerf() {
        return em;
    }

    
    public List<ContCheck> findByidchekforwo(String wo){
        
        return (List<ContCheck>) em.createQuery("SELECT e FROM ContCheck e WHERE e.chkWo=:y ").setParameter("y", wo).getResultList();        
    }
    public ContCheck findByid(Short wo){
        
        return (ContCheck)em.createQuery("SELECT e FROM ContCheck e WHERE e.contCheckId=:y ").setParameter("y", wo).getSingleResult();        
    }
    
    public List<ContCheck> findAllAsc(){
        return (List<ContCheck>) em.createQuery("SELECT e FROM ContCheck e ORDER BY e.contCheckId DESC").getResultList() ;
    }
    public BigDecimal findByUltimoID(){
        return (BigDecimal) em.createNativeQuery("SELECT e.CONT_CHECK_ID from CONT.CONT_CHECK e where rownum = 1   ORDER BY e.CONT_CHECK_ID DESC").getSingleResult() ;
    }
    public List<ContCheck> findByChekActivos(){
        Date fecha = new Date();
        return (List<ContCheck>) em.createQuery("SELECT e FROM ContCheck e WHERE :fec BETWEEN e.chkStartdate AND e.chkFinishdate ORDER BY e.contCheckId DESC").setParameter("fec", fecha).getResultList() ;
    }
	
	
	
	public List<ContCheck> findByChekActivosN() {
        ContCheck contCheck = new ContCheck();

        List<ContCheck> listadoContCheck = new ArrayList<ContCheck>();
        List<Object[]> listaObjeto = new ArrayList<Object[]>();
        try {
            String consulta = "SELECT CONT_CHECK_ID, CHK_MODEL, CHK_REGISTRY, CHK_STARTDATE, CHK_FINISHDATE, CHK_TTSN, CHK_TCSN, CHK_VN, CHK_LN, CHK_SN, CHK_BN, \n"
                    + " CHK_CHECKTYPE, CHK_USERC, CHK_CLOSED, CHK_CORRTYPE, CHK_CHECKTYPE_1, CHK_DHISTORICA, CHK_WO, CHK_ARRIVALDATE, CHK_GROUNDTIME, \n"
                    + " CHK_HANGMANRESPON, CHK_HANGRESPON, CHK_COMMRESPON, CHK_PRODCONTRESPON, CHK_WAREHRESPON, CHK_SHOPSRESPON, CHK_PURCHRESPON, \n"
                    + " CHK_PLANNRESPON, CHK_ENGINRESPON, CHK_POWPLANTRES, CHK_QARESPON, CHK_QCRESPON, CHK_MSN, CHK_YEAR, CHK_ENG_MAN_HRS, CHK_IDENGACT, \n"
                    + " CHK_CLOSED_ENG, CHK_DESCRIPTION, CHK_USR_INS, CHK_DATE_INS, CHK_USR_UPD, CHK_DATE_UPD, CHK_WO_YEAR, CHK_WO_CORR, CHK_WO_ITEM, \n"
                    + " CHK_AC, CHK_CUCOD, CHECK_COMPANY, CHK_HANGAR_DEF  FROM CONT.CONT_CHECK \n"
                    + " WHERE (SYSDATE BETWEEN CHK_STARTDATE AND CHK_FINISHDATE) ORDER BY CONT_CHECK_ID DESC";
            Query query = em.createNativeQuery(consulta);
            listaObjeto = query.getResultList();
            for (int x = 0; x < listaObjeto.size(); x++) {
                contCheck = new ContCheck();
                contCheck.setContCheckId(new BigDecimal(listaObjeto.get(x)[0].toString()));
                if (listaObjeto.get(x)[1] != null) {
                    contCheck.setChkModel(listaObjeto.get(x)[1].toString());
                }
                if (listaObjeto.get(x)[2] != null) {
                    contCheck.setChkRegistry(listaObjeto.get(x)[2].toString());
                }

                DateFormat formatof = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                if (listaObjeto.get(x)[3] != null) {
                    Date chkStartdate = formatof.parse(listaObjeto.get(x)[3].toString());
                    contCheck.setChkStartdate(chkStartdate);
                }
                if (listaObjeto.get(x)[4] != null) {
                    Date chkfinishdate = formatof.parse(listaObjeto.get(x)[4].toString());
                    contCheck.setChkFinishdate(chkfinishdate);
                }
                  if (listaObjeto.get(x)[5] != null) {
                     contCheck.setChkTtsn(new BigDecimal(listaObjeto.get(x)[5].toString()));
                }
                    if (listaObjeto.get(x)[6] != null) {
                contCheck.setChkTcsn(new Integer(listaObjeto.get(x)[6].toString()));
                }
               
                
                if (listaObjeto.get(x)[7] != null) {
                    contCheck.setChkVn(listaObjeto.get(x)[7].toString());
                }
                if (listaObjeto.get(x)[8] != null) {
                    contCheck.setChkLn(listaObjeto.get(x)[8].toString());
                }
                if (listaObjeto.get(x)[9] != null) {
                    contCheck.setChkSn(listaObjeto.get(x)[9].toString());
                }
                if (listaObjeto.get(x)[10] != null) {
                    contCheck.setChkBn(listaObjeto.get(x)[10].toString());
                }
                if (listaObjeto.get(x)[11] != null) {
                    contCheck.setChkChecktype(listaObjeto.get(x)[11].toString());
                }
                if (listaObjeto.get(x)[12] != null) {
                    contCheck.setChkUserc(listaObjeto.get(x)[12].toString());
                }
                if (listaObjeto.get(x)[13] != null) {
                    contCheck.setChkClosed(listaObjeto.get(x)[13].toString());
                }
                if (listaObjeto.get(x)[14] != null) {
                    //contCheck.setChkCorrtype(new Short(listaObjeto.get(x)[14].toString()));
                }
                if (listaObjeto.get(x)[15] != null) {
                    contCheck.setChkChecktype1(listaObjeto.get(x)[15].toString());
                }
                if (listaObjeto.get(x)[16] != null) {
                    contCheck.setChkDhistorica(listaObjeto.get(x)[16].toString());
                }
                if (listaObjeto.get(x)[17] != null) {
                    contCheck.setChkWo(listaObjeto.get(x)[17].toString());
                }
                if (listaObjeto.get(x)[18] != null) {
                    Date arrivalDate = formatof.parse(listaObjeto.get(x)[18].toString());
                    contCheck.setChkArrivaldate(arrivalDate);
                }
                if (listaObjeto.get(x)[19] != null) {
                    contCheck.setChkGroundtime(listaObjeto.get(x)[19].toString());
                }
                if (listaObjeto.get(x)[20] != null) {
                    contCheck.setChkHangmanrespon(listaObjeto.get(x)[20].toString());
                }
                if (listaObjeto.get(x)[21] != null) {
                    contCheck.setChkHangrespon(listaObjeto.get(x)[21].toString());
                }
                if (listaObjeto.get(x)[22] != null) {
                    contCheck.setChkCommrespon(listaObjeto.get(x)[22].toString());
                }
                if (listaObjeto.get(x)[23] != null) {
                    contCheck.setChkProdcontrespon(listaObjeto.get(x)[23].toString());
                }
                if (listaObjeto.get(x)[24] != null) {
                    contCheck.setChkWarehrespon(listaObjeto.get(x)[24].toString());
                }
                if (listaObjeto.get(x)[25] != null) {
                    contCheck.setChkShopsrespon(listaObjeto.get(x)[25].toString());
                }
                if (listaObjeto.get(x)[26] != null) {
                    contCheck.setChkPurchrespon(listaObjeto.get(x)[26].toString());
                }
                if (listaObjeto.get(x)[27] != null) {
                    contCheck.setChkPlannrespon(listaObjeto.get(x)[27].toString());
                }
                if (listaObjeto.get(x)[28] != null) {
                    contCheck.setChkEnginrespon(listaObjeto.get(x)[28].toString());
                }
                if (listaObjeto.get(x)[29] != null) {
                    contCheck.setChkPowplantres(listaObjeto.get(x)[29].toString());
                }
                if (listaObjeto.get(x)[30] != null) {
                    contCheck.setChkQarespon(listaObjeto.get(x)[30].toString());
                }
                if (listaObjeto.get(x)[31] != null) {
                    contCheck.setChkQcrespon(listaObjeto.get(x)[31].toString());
                }
                if (listaObjeto.get(x)[32] != null) {
                    contCheck.setChkMsn(listaObjeto.get(x)[32].toString());
                }
                if (listaObjeto.get(x)[33] != null) {
                    contCheck.setChkYear(listaObjeto.get(x)[33].toString());
                }
                if (listaObjeto.get(x)[34] != null) {
                    contCheck.setChkEngManHrs(Double.parseDouble(listaObjeto.get(x)[34].toString()));
                }
                if (listaObjeto.get(x)[35] != null) {
                    //contCheck.setChkIdengact(new Short(listaObjeto.get(x)[35].toString()));
                }
                if (listaObjeto.get(x)[36] != null) {
                    contCheck.setChkClosedEng(listaObjeto.get(x)[36].toString());
                }
                if (listaObjeto.get(x)[37] != null) {
                    contCheck.setChkDescription(listaObjeto.get(x)[37].toString());
                }
                if (listaObjeto.get(x)[38] != null) {
                    contCheck.setChkUsrIns(listaObjeto.get(x)[38].toString());
                }
                if (listaObjeto.get(x)[39] != null) {
                    Date dateins = formatof.parse(listaObjeto.get(x)[39].toString());
                    contCheck.setChkDateIns(dateins);
                }
                if (listaObjeto.get(x)[40] != null) {
                    contCheck.setChkUsrUpd(listaObjeto.get(x)[40].toString());
                }
                if (listaObjeto.get(x)[41] != null) {
                    Date dateUpd = formatof.parse(listaObjeto.get(x)[41].toString());
                    contCheck.setChkDateUpd(dateUpd);
                }
                if (listaObjeto.get(x)[42] != null) {
                    //contCheck.setChkWoYear(new Short(listaObjeto.get(x)[42].toString()));
                }

                if (listaObjeto.get(x)[43] != null) {
                    contCheck.setChkWoCorr(Integer.parseInt(listaObjeto.get(x)[43].toString()));
                }

                if (listaObjeto.get(x)[44] != null) {
                    //contCheck.setChkWoItem(new Short(listaObjeto.get(x)[44].toString()));
                }

                if (listaObjeto.get(x)[45] != null) {
                    contCheck.setChkAc(listaObjeto.get(x)[45].toString());
                }
                if (listaObjeto.get(x)[46] != null) {
                    contCheck.setChkCucod(listaObjeto.get(x)[46].toString());
                }
                if (listaObjeto.get(x)[47] != null) {
                    contCheck.setCheckCompany(listaObjeto.get(x)[47].toString());
                }
                if (listaObjeto.get(x)[48] != null) {
                    contCheck.setChkHangarDef(listaObjeto.get(x)[48].toString());
                }
                     listadoContCheck.add(contCheck);
            }
           
        } catch (Exception e) {
            Logger.getLogger(ContCheckFacade.class.getName()).log(Level.SEVERE, null, e);
        }

        return listadoContCheck;
    }

	
    public List<ContCheck> findByChekActivosCompany(String company){
        Date fecha = new Date();
        return (List<ContCheck>) em.createQuery("SELECT e FROM ContCheck e WHERE :fec BETWEEN e.chkStartdate AND e.chkFinishdate AND e.CheckCompany= :com ORDER BY e.contCheckId DESC").setParameter("fec", fecha).setParameter("com", company).getResultList();
    }
    
	public List<ContCheck> findByChekActivosCompanyN(String company) {
        ContCheck contCheck = new ContCheck();

        List<ContCheck> listadoContCheck = new ArrayList<ContCheck>();
        List<Object[]> listaObjeto = new ArrayList<Object[]>();
        try {
            String consulta = "SELECT CONT_CHECK_ID, CHK_MODEL, CHK_REGISTRY, CHK_STARTDATE, CHK_FINISHDATE, CHK_TTSN, CHK_TCSN, CHK_VN, CHK_LN, CHK_SN, CHK_BN, \n"
                    + "CHK_CHECKTYPE, CHK_USERC, CHK_CLOSED, CHK_CORRTYPE, CHK_CHECKTYPE_1, CHK_DHISTORICA, CHK_WO, CHK_ARRIVALDATE, CHK_GROUNDTIME, \n"
                    + "CHK_HANGMANRESPON, CHK_HANGRESPON, CHK_COMMRESPON, CHK_PRODCONTRESPON, CHK_WAREHRESPON, CHK_SHOPSRESPON, CHK_PURCHRESPON, \n"
                    + "CHK_PLANNRESPON, CHK_ENGINRESPON, CHK_POWPLANTRES, CHK_QARESPON, CHK_QCRESPON, CHK_MSN, CHK_YEAR, CHK_ENG_MAN_HRS, CHK_IDENGACT, \n"
                    + "CHK_CLOSED_ENG, CHK_DESCRIPTION, CHK_USR_INS, CHK_DATE_INS, CHK_USR_UPD, CHK_DATE_UPD, CHK_WO_YEAR, CHK_WO_CORR, CHK_WO_ITEM, \n"
                    + "CHK_AC, CHK_CUCOD, CHECK_COMPANY, CHK_HANGAR_DEF  FROM CONT.CONT_CHECK \n"
                    + "WHERE ((CHECK_COMPANY = '" + company + "') AND (SYSDATE BETWEEN CHK_STARTDATE AND CHK_FINISHDATE)) ORDER BY CONT_CHECK_ID DESC";
            Query query = em.createNativeQuery(consulta);
            listaObjeto = query.getResultList();
            for (int x = 0; x < listaObjeto.size(); x++) {
                contCheck = new ContCheck();
                //contCheck.setContCheckId(new Short(listaObjeto.get(x)[0].toString()));
                contCheck.setContCheckId(new BigDecimal(listaObjeto.get(x)[0].toString()));
                if (listaObjeto.get(x)[1] != null) {
                    contCheck.setChkModel(listaObjeto.get(x)[1].toString());
                }
                if (listaObjeto.get(x)[2] != null) {
                    contCheck.setChkRegistry(listaObjeto.get(x)[2].toString());
                }

                DateFormat formatof = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                if (listaObjeto.get(x)[3] != null) {
                    Date chkStartdate = formatof.parse(listaObjeto.get(x)[3].toString());
                    contCheck.setChkStartdate(chkStartdate);
                }
                if (listaObjeto.get(x)[4] != null) {
                    Date chkfinishdate = formatof.parse(listaObjeto.get(x)[4].toString());
                    contCheck.setChkFinishdate(chkfinishdate);
                }
                if (listaObjeto.get(x)[5] != null) {
                    contCheck.setChkTtsn(new BigDecimal(listaObjeto.get(x)[5].toString()));
                }
                if (listaObjeto.get(x)[6] != null) {
                contCheck.setChkTcsn(new Integer(listaObjeto.get(x)[6].toString()));
                }
                if (listaObjeto.get(x)[7] != null) {
                    contCheck.setChkVn(listaObjeto.get(x)[7].toString());
                }
                if (listaObjeto.get(x)[8] != null) {
                    contCheck.setChkLn(listaObjeto.get(x)[8].toString());
                }
                if (listaObjeto.get(x)[9] != null) {
                    contCheck.setChkSn(listaObjeto.get(x)[9].toString());
                }
                if (listaObjeto.get(x)[10] != null) {
                    contCheck.setChkBn(listaObjeto.get(x)[10].toString());
                }
                if (listaObjeto.get(x)[11] != null) {
                    contCheck.setChkChecktype(listaObjeto.get(x)[11].toString());
                }
                if (listaObjeto.get(x)[12] != null) {
                    contCheck.setChkUserc(listaObjeto.get(x)[12].toString());
                }
                if (listaObjeto.get(x)[13] != null) {
                    contCheck.setChkClosed(listaObjeto.get(x)[13].toString());
                }
                if (listaObjeto.get(x)[14] != null) {
                    //contCheck.setChkCorrtype(new Short(listaObjeto.get(x)[14].toString()));
                }
                if (listaObjeto.get(x)[15] != null) {
                    contCheck.setChkChecktype1(listaObjeto.get(x)[15].toString());
                }
                if (listaObjeto.get(x)[16] != null) {
                    contCheck.setChkDhistorica(listaObjeto.get(x)[16].toString());
                }
                if (listaObjeto.get(x)[17] != null) {
                    contCheck.setChkWo(listaObjeto.get(x)[17].toString());
                }
                if (listaObjeto.get(x)[18] != null) {
                    Date arrivalDate = formatof.parse(listaObjeto.get(x)[18].toString());
                    contCheck.setChkArrivaldate(arrivalDate);
                }
                if (listaObjeto.get(x)[19] != null) {
                    contCheck.setChkGroundtime(listaObjeto.get(x)[19].toString());
                }
                if (listaObjeto.get(x)[20] != null) {
                    contCheck.setChkHangmanrespon(listaObjeto.get(x)[20].toString());
                }
                if (listaObjeto.get(x)[21] != null) {
                    contCheck.setChkHangrespon(listaObjeto.get(x)[21].toString());
                }
                if (listaObjeto.get(x)[22] != null) {
                    contCheck.setChkCommrespon(listaObjeto.get(x)[22].toString());
                }
                if (listaObjeto.get(x)[23] != null) {
                    contCheck.setChkProdcontrespon(listaObjeto.get(x)[23].toString());
                }
                if (listaObjeto.get(x)[24] != null) {
                    contCheck.setChkWarehrespon(listaObjeto.get(x)[24].toString());
                }
                if (listaObjeto.get(x)[25] != null) {
                    contCheck.setChkShopsrespon(listaObjeto.get(x)[25].toString());
                }
                if (listaObjeto.get(x)[26] != null) {
                    contCheck.setChkPurchrespon(listaObjeto.get(x)[26].toString());
                }
                if (listaObjeto.get(x)[27] != null) {
                    contCheck.setChkPlannrespon(listaObjeto.get(x)[27].toString());
                }
                if (listaObjeto.get(x)[28] != null) {
                    contCheck.setChkEnginrespon(listaObjeto.get(x)[28].toString());
                }
                if (listaObjeto.get(x)[29] != null) {
                    contCheck.setChkPowplantres(listaObjeto.get(x)[29].toString());
                }
                if (listaObjeto.get(x)[30] != null) {
                    contCheck.setChkQarespon(listaObjeto.get(x)[30].toString());
                }
                if (listaObjeto.get(x)[31] != null) {
                    contCheck.setChkQcrespon(listaObjeto.get(x)[31].toString());
                }
                if (listaObjeto.get(x)[32] != null) {
                    contCheck.setChkMsn(listaObjeto.get(x)[32].toString());
                }
                if (listaObjeto.get(x)[33] != null) {
                    contCheck.setChkYear(listaObjeto.get(x)[33].toString());
                }
                if (listaObjeto.get(x)[34] != null) {
                    contCheck.setChkEngManHrs(Double.parseDouble(listaObjeto.get(x)[34].toString()));
                }
                if (listaObjeto.get(x)[35] != null) {
                    //contCheck.setChkIdengact(new Short(listaObjeto.get(x)[35].toString()));
                }
                if (listaObjeto.get(x)[36] != null) {
                    contCheck.setChkClosedEng(listaObjeto.get(x)[36].toString());
                }
                if (listaObjeto.get(x)[37] != null) {
                    contCheck.setChkDescription(listaObjeto.get(x)[37].toString());
                }
                if (listaObjeto.get(x)[38] != null) {
                    contCheck.setChkUsrIns(listaObjeto.get(x)[38].toString());
                }
                if (listaObjeto.get(x)[39] != null) {
                    Date dateins = formatof.parse(listaObjeto.get(x)[39].toString());
                    contCheck.setChkDateIns(dateins);
                }
                if (listaObjeto.get(x)[40] != null) {
                    contCheck.setChkUsrUpd(listaObjeto.get(x)[40].toString());
                }
                if (listaObjeto.get(x)[41] != null) {
                    Date dateUpd = formatof.parse(listaObjeto.get(x)[41].toString());
                    contCheck.setChkDateUpd(dateUpd);
                }
                if (listaObjeto.get(x)[42] != null) {
                    //contCheck.setChkWoYear(new Short(listaObjeto.get(x)[42].toString()));
                }

                if (listaObjeto.get(x)[43] != null) {
                    contCheck.setChkWoCorr(Integer.parseInt(listaObjeto.get(x)[43].toString()));
                }

                if (listaObjeto.get(x)[44] != null) {
                    //contCheck.setChkWoItem(new Short(listaObjeto.get(x)[44].toString()));
                }

                if (listaObjeto.get(x)[45] != null) {
                    contCheck.setChkAc(listaObjeto.get(x)[45].toString());
                }
                if (listaObjeto.get(x)[46] != null) {
                    contCheck.setChkCucod(listaObjeto.get(x)[46].toString());
                }
                if (listaObjeto.get(x)[47] != null) {
                    contCheck.setCheckCompany(listaObjeto.get(x)[47].toString());
                }
                if (listaObjeto.get(x)[48] != null) {
                    contCheck.setChkHangarDef(listaObjeto.get(x)[48].toString());
                }
                listadoContCheck.add(contCheck);
            }
            
        } catch (Exception e) {
            Logger.getLogger(ContCheckFacade.class.getName()).log(Level.SEVERE, null, e);
        }

        return listadoContCheck;
    }
	
    public List<ContCheck> findByChekCompany(String company){
       Date fecha = new Date();
       return (List<ContCheck>) em.createQuery( "SELECT e FROM ContCheck e WHERE e.CheckCompany = :vCompany AND :fec BETWEEN e.chkStartdate AND e.chkFinishdate ORDER BY e.chkWo ASC").setParameter("vCompany", company).setParameter("fec", fecha).getResultList();
        
    }
    
    public ContCheck findByChekCompanyETR(String company) {
        ContCheck chequeoETR = new ContCheck();
        try {
            String consulta = "SELECT e FROM ContCheck e WHERE e.CheckCompany = :vCompany AND e.chkModel = 'ETR' ";
            Query query = em.createQuery(consulta).setParameter("vCompany", company);
            chequeoETR = (ContCheck) query.getSingleResult();
        } catch (Exception e) {
            Logger.getLogger(ContCheckFacade.class.getName()).log(Level.SEVERE, null, e);
        }
        return chequeoETR;

    }
    
    public ContCheck findByChekCompanyECR(String company) {
        ContCheck chequeoECR = new ContCheck();
        try {
            String consulta = "SELECT e FROM ContCheck e WHERE e.CheckCompany = :vCompany AND e.chkModel = 'ECR' ";
            Query query = em.createQuery(consulta).setParameter("vCompany", company);
            chequeoECR = (ContCheck) query.getSingleResult();
        } catch (Exception e) {
            Logger.getLogger(ContCheckFacade.class.getName()).log(Level.SEVERE, null, e);
        }
        return chequeoECR;

    }
	
	  public List<ContCheck> findByChekCompanyN(String company) {
        ContCheck contCheck = new ContCheck();

        List<ContCheck> listadoContCheck = new ArrayList<ContCheck>();
        List<Object[]> listaObjeto = new ArrayList<Object[]>();
        try {
            String consulta = "SELECT CONT_CHECK_ID, CHK_MODEL, CHK_REGISTRY, CHK_STARTDATE, CHK_FINISHDATE, CHK_TTSN, CHK_TCSN, CHK_VN, CHK_LN, CHK_SN, CHK_BN, \n"
                    + "CHK_CHECKTYPE, CHK_USERC, CHK_CLOSED, CHK_CORRTYPE, CHK_CHECKTYPE_1, CHK_DHISTORICA, CHK_WO, CHK_ARRIVALDATE, CHK_GROUNDTIME, \n"
                    + "CHK_HANGMANRESPON, CHK_HANGRESPON, CHK_COMMRESPON, CHK_PRODCONTRESPON, CHK_WAREHRESPON, CHK_SHOPSRESPON, CHK_PURCHRESPON, \n"
                    + "CHK_PLANNRESPON, CHK_ENGINRESPON, CHK_POWPLANTRES, CHK_QARESPON, CHK_QCRESPON, CHK_MSN, CHK_YEAR, CHK_ENG_MAN_HRS, CHK_IDENGACT, \n"
                    + "CHK_CLOSED_ENG, CHK_DESCRIPTION, CHK_USR_INS, CHK_DATE_INS, CHK_USR_UPD, CHK_DATE_UPD, CHK_WO_YEAR, CHK_WO_CORR, CHK_WO_ITEM, \n"
                    + "CHK_AC, CHK_CUCOD, CHECK_COMPANY, CHK_HANGAR_DEF  FROM CONT.CONT_CHECK \n"
                    + "WHERE ((CHECK_COMPANY = " + company + ") AND (SYSDATE BETWEEN CHK_STARTDATE AND CHK_FINISHDATE)) ORDER BY CHK_WO ASC";
            Query query = em.createNativeQuery(consulta);
            listaObjeto = query.getResultList();
            for (int x = 0; x < listaObjeto.size(); x++) {
                contCheck = new ContCheck();
                //contCheck.setContCheckId(new Short(listaObjeto.get(x)[0].toString()));
                contCheck.setContCheckId(new BigDecimal(listaObjeto.get(x)[0].toString()));
                if (listaObjeto.get(x)[1] != null) {
                    contCheck.setChkModel(listaObjeto.get(x)[1].toString());
                }
                if (listaObjeto.get(x)[2] != null) {
                    contCheck.setChkRegistry(listaObjeto.get(x)[2].toString());
                }

                DateFormat formatof = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                if (listaObjeto.get(x)[3] != null) {
                    Date chkStartdate = formatof.parse(listaObjeto.get(x)[3].toString());
                    contCheck.setChkStartdate(chkStartdate);
                }
                if (listaObjeto.get(x)[4] != null) {
                    Date chkfinishdate = formatof.parse(listaObjeto.get(x)[4].toString());
                    contCheck.setChkFinishdate(chkfinishdate);
                }
                if (listaObjeto.get(x)[5] != null) {
                    contCheck.setChkTtsn(new BigDecimal(listaObjeto.get(x)[5].toString()));
                }
                if (listaObjeto.get(x)[6] != null) {
                contCheck.setChkTcsn(new Integer(listaObjeto.get(x)[6].toString()));
                }
                if (listaObjeto.get(x)[7] != null) {
                    contCheck.setChkVn(listaObjeto.get(x)[7].toString());
                }
                if (listaObjeto.get(x)[8] != null) {
                    contCheck.setChkLn(listaObjeto.get(x)[8].toString());
                }
                if (listaObjeto.get(x)[9] != null) {
                    contCheck.setChkSn(listaObjeto.get(x)[9].toString());
                }
                if (listaObjeto.get(x)[10] != null) {
                    contCheck.setChkBn(listaObjeto.get(x)[10].toString());
                }
                if (listaObjeto.get(x)[11] != null) {
                    contCheck.setChkChecktype(listaObjeto.get(x)[11].toString());
                }
                if (listaObjeto.get(x)[12] != null) {
                    contCheck.setChkUserc(listaObjeto.get(x)[12].toString());
                }
                if (listaObjeto.get(x)[13] != null) {
                    contCheck.setChkClosed(listaObjeto.get(x)[13].toString());
                }
                if (listaObjeto.get(x)[14] != null) {
                    //contCheck.setChkCorrtype(new Short(listaObjeto.get(x)[14].toString()));
                }
                if (listaObjeto.get(x)[15] != null) {
                    contCheck.setChkChecktype1(listaObjeto.get(x)[15].toString());
                }
                if (listaObjeto.get(x)[16] != null) {
                    contCheck.setChkDhistorica(listaObjeto.get(x)[16].toString());
                }
                if (listaObjeto.get(x)[17] != null) {
                    contCheck.setChkWo(listaObjeto.get(x)[17].toString());
                }
                if (listaObjeto.get(x)[18] != null) {
                    Date arrivalDate = formatof.parse(listaObjeto.get(x)[18].toString());
                    contCheck.setChkArrivaldate(arrivalDate);
                }
                if (listaObjeto.get(x)[19] != null) {
                    contCheck.setChkGroundtime(listaObjeto.get(x)[19].toString());
                }
                if (listaObjeto.get(x)[20] != null) {
                    contCheck.setChkHangmanrespon(listaObjeto.get(x)[20].toString());
                }
                if (listaObjeto.get(x)[21] != null) {
                    contCheck.setChkHangrespon(listaObjeto.get(x)[21].toString());
                }
                if (listaObjeto.get(x)[22] != null) {
                    contCheck.setChkCommrespon(listaObjeto.get(x)[22].toString());
                }
                if (listaObjeto.get(x)[23] != null) {
                    contCheck.setChkProdcontrespon(listaObjeto.get(x)[23].toString());
                }
                if (listaObjeto.get(x)[24] != null) {
                    contCheck.setChkWarehrespon(listaObjeto.get(x)[24].toString());
                }
                if (listaObjeto.get(x)[25] != null) {
                    contCheck.setChkShopsrespon(listaObjeto.get(x)[25].toString());
                }
                if (listaObjeto.get(x)[26] != null) {
                    contCheck.setChkPurchrespon(listaObjeto.get(x)[26].toString());
                }
                if (listaObjeto.get(x)[27] != null) {
                    contCheck.setChkPlannrespon(listaObjeto.get(x)[27].toString());
                }
                if (listaObjeto.get(x)[28] != null) {
                    contCheck.setChkEnginrespon(listaObjeto.get(x)[28].toString());
                }
                if (listaObjeto.get(x)[29] != null) {
                    contCheck.setChkPowplantres(listaObjeto.get(x)[29].toString());
                }
                if (listaObjeto.get(x)[30] != null) {
                    contCheck.setChkQarespon(listaObjeto.get(x)[30].toString());
                }
                if (listaObjeto.get(x)[31] != null) {
                    contCheck.setChkQcrespon(listaObjeto.get(x)[31].toString());
                }
                if (listaObjeto.get(x)[32] != null) {
                    contCheck.setChkMsn(listaObjeto.get(x)[32].toString());
                }
                if (listaObjeto.get(x)[33] != null) {
                    contCheck.setChkYear(listaObjeto.get(x)[33].toString());
                }
                if (listaObjeto.get(x)[34] != null) {
                    contCheck.setChkEngManHrs(Double.parseDouble(listaObjeto.get(x)[34].toString()));
                }
                if (listaObjeto.get(x)[35] != null) {
                    //contCheck.setChkIdengact(new Short(listaObjeto.get(x)[35].toString()));
                }
                if (listaObjeto.get(x)[36] != null) {
                    contCheck.setChkClosedEng(listaObjeto.get(x)[36].toString());
                }
                if (listaObjeto.get(x)[37] != null) {
                    contCheck.setChkDescription(listaObjeto.get(x)[37].toString());
                }
                if (listaObjeto.get(x)[38] != null) {
                    contCheck.setChkUsrIns(listaObjeto.get(x)[38].toString());
                }
                if (listaObjeto.get(x)[39] != null) {
                    Date dateins = formatof.parse(listaObjeto.get(x)[39].toString());
                    contCheck.setChkDateIns(dateins);
                }
                if (listaObjeto.get(x)[40] != null) {
                    contCheck.setChkUsrUpd(listaObjeto.get(x)[40].toString());
                }
                if (listaObjeto.get(x)[41] != null) {
                    Date dateUpd = formatof.parse(listaObjeto.get(x)[41].toString());
                    contCheck.setChkDateUpd(dateUpd);
                }
                if (listaObjeto.get(x)[42] != null) {
                    //contCheck.setChkWoYear(new Short(listaObjeto.get(x)[42].toString()));
                }

                if (listaObjeto.get(x)[43] != null) {
                    contCheck.setChkWoCorr(Integer.parseInt(listaObjeto.get(x)[43].toString()));
                }

                if (listaObjeto.get(x)[44] != null) {
                    //contCheck.setChkWoItem(new Short(listaObjeto.get(x)[44].toString()));
                }

                if (listaObjeto.get(x)[45] != null) {
                    contCheck.setChkAc(listaObjeto.get(x)[45].toString());
                }
                if (listaObjeto.get(x)[46] != null) {
                    contCheck.setChkCucod(listaObjeto.get(x)[46].toString());
                }
                if (listaObjeto.get(x)[47] != null) {
                    contCheck.setCheckCompany(listaObjeto.get(x)[47].toString());
                }
                if (listaObjeto.get(x)[48] != null) {
                    contCheck.setChkHangarDef(listaObjeto.get(x)[48].toString());
                }
                listadoContCheck.add(contCheck);
            }
            
        } catch (Exception e) {
            Logger.getLogger(ContCheckFacade.class.getName()).log(Level.SEVERE, null, e);
        }

        return listadoContCheck;
    }
    
	
    public List<ContCheck> findByCompAndID(String company, Short contID){
       Date fecha = new Date();
       return (List<ContCheck>) em.createQuery( "SELECT e FROM ContCheck e WHERE e.CheckCompany = :vCompany AND :fec BETWEEN e.chkStartdate AND e.chkFinishdate OR e.contCheckId=:contIDs ORDER BY e.chkWo ASC").setParameter("vCompany", company).setParameter("fec", fecha).setParameter("contIDs", contID).getResultList();
        
    }
    public List<ContCheck> findByAvionOrWo(String filtro){
        
         filtro = "%"+filtro+"%";
        return em.createQuery("SELECT e FROM ContCheck e WHERE e.chkWo like :obj OR e.chkRegistry like :obj ").setParameter("obj", filtro).getResultList();        
    
    }
    public List<ContCheck> findByAvionOrWoCia(String filtro,String cia){
        
         filtro = "%"+filtro+"%";
        return em.createQuery("SELECT e FROM ContCheck e WHERE e.chkWo like :obj OR e.chkRegistry like :obj and e.CheckCompany=:opco ").setParameter("obj", filtro).setParameter("opco", cia).getResultList();        
    
    }
    
    public List<ContCheck> findChecksActivos(){
        
        ContCheck contC;
        List<ContCheck> contChList=new ArrayList();
        String sql="SELECT e.chk_Registry FROM Cont.Cont_Check e WHERE  e.CHK_STARTDATE is not null and e.CHK_ARRIVALDATE is not null or e.CHK_FINISHDATE >= sysdate GROUP BY e.chk_Registry";
        List<Object> checks;
        Query query=em.createNativeQuery(sql);
        checks=query.getResultList();
                
        for(Object listObj : checks){
            contC= new ContCheck();
            contC.setChkRegistry((String) listObj);
            contChList.add(contC);
        }
        
        return contChList; 
    }
    
    public List<Object[]> filtrarCheckbox(Short chek) {
        
        List<Object[]> resultar1 = new ArrayList();
        
        try {
            String  sql = "Select DISTINCT(sta.EST_ID), sta.EST_CODE,sta.EST_DESC from ENG_REQ_STATUS sta\n" +
            "JOIN ENG_REQ_INGACTION act on sta.EST_ID = act.EIN_STATUS\n" +
            "JOIN Eng_Request esr  on esr.REQ_MESSAGEID = act.REQ_MESSAGEID\n" +
            "JOIN CONT.CONT_CHECK wo  on wo.CONT_CHECK_ID = esr.CHK_CHECKID\n" +
            "where wo.CONT_CHECK_ID = "+chek.intValue();
            Query query = em.createNativeQuery(sql);
            resultar1 = query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(ContCheckFacade.class.getName()).log(Level.SEVERE, null, e);
        }
        return resultar1;
    }
    
    public List<String> findAeroplanes(){
        return em.createQuery("SELECT DISTINCT e.chkRegistry FROM ContCheck e").getResultList(); 
    }
    public List<ContCheck> findByChekWORegistry(String registry,Date fStrart,Date fFinish){
        return  em.createQuery("SELECT e FROM ContCheck e WHERE e.chkRegistry = :reg AND e.chkStartdate BETWEEN :fs AND :ff ").setParameter("reg", registry).setParameter("fs", fStrart).setParameter("ff", fFinish).getResultList();
    }
    public List<ContCheck> findByChekWOAll(String registry){
        return  em.createQuery("SELECT e FROM ContCheck e WHERE e.chkRegistry = :reg").setParameter("reg", registry).getResultList();
    }
    
    public boolean validparam(String opco) {
        boolean status=false;
        try {
            String  sql = "select EAP_REQ FROM ENG_ESRADJPARAM where EAP_OPCO = '"+opco+"'";
            Query query = em.createNativeQuery(sql);
            String a2=(String) query.getSingleResult().toString();
            if("N".equals(a2)){
               status=true; 
            }
        } catch (Exception e) {
            Logger.getLogger(ContCheckFacade.class.getName()).log(Level.SEVERE, null, e);
        }
        return status;
    }
}
