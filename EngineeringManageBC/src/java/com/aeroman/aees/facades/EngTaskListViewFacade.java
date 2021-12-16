/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

import com.aeroman.aees.entities.EngTaskListView;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
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
public class EngTaskListViewFacade extends AbstractFacade<EngTaskListView> {
    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    public EngTaskListViewFacade() {
        super(EngTaskListView.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    public List<EngTaskListView> findByWorkOrder(BigDecimal chekID){
        return em.createQuery("SELECT e FROM EngTaskListView e WHERE e.checkid=:obj").setParameter("obj", chekID).getResultList();       
    }
    public List<EngTaskListView> findByActive(){
        return em.createQuery("SELECT e FROM EngTaskListView e WHERE e.reqStatus not in ('FPP','FDP','NFA','C')").getResultList();        
    }
    public List<EngTaskListView> findByUserCia(String ciaUser){
        return em.createQuery("SELECT e FROM EngTaskListView e WHERE e.reqStatus not in ('FPP','FDP','NFA','C') and e.company=:cia").setParameter("cia", ciaUser) .getResultList();        
    }

     public List<EngTaskListView> findByUsuarioNoa(String UsuarioID){
        return em.createQuery("SELECT e FROM EngTaskListView e WHERE e.usrCoduser=:obj OR e.usrCoduser=0").setParameter("obj", UsuarioID).getResultList();        
    }
    public List<EngTaskListView> findByBuscarWorkOrder(String workOrder){
         BigDecimal chekID = new BigDecimal(workOrder);        
        return em.createQuery("SELECT e FROM EngTaskListView e WHERE e.checkid = :obj ").setParameter("obj", chekID).getResultList();        
    }
    public List<EngTaskListView> findUserCompa(String userCO,String company){                 
        return em.createQuery("SELECT e FROM EngTaskListView e WHERE e.usrCoduser=:userC AND e.company=:companyE").setParameter("userC", userCO).setParameter("companyE", company).getResultList();       
    }
    public List<EngTaskListView> findCompa(String company){                 
        return em.createQuery("SELECT e FROM EngTaskListView e WHERE e.company=:companyE").setParameter("companyE", company).getResultList();       
    }
    
    
    public List<EngTaskListView> findAllTaskListView() {
        EngTaskListView engTaskListView = new EngTaskListView();
        List<EngTaskListView> listadoengTaskListView = new ArrayList<EngTaskListView>();
        List<Object[]> listaObjeto = new ArrayList<Object[]>();
        try {
            String consulta = "SELECT ESR, CHECKID, WOORDER, COMPANY, REQ_FECHA_INS, REQ_PROBDESC, REQ_CUSTOMER, REQ_REGISTRY, USR_CODUSER, REQ_STATUS, FULL_USER_NAME, FLOTA, REQ_USR_INS, TIENE_HIJOS, WORKORDER, REQ_JOBCARD FROM ENG_TASK_LIST_VIEW";
            Query query = em.createNativeQuery(consulta);
            listaObjeto = query.getResultList();
            for (int x = 0; x < listaObjeto.size(); x++) {
                engTaskListView = new EngTaskListView();
                engTaskListView.setEsr(new BigInteger(listaObjeto.get(x)[0].toString()));
                engTaskListView.setCheckid(new BigDecimal(listaObjeto.get(x)[1].toString()));
                engTaskListView.setWoorder(listaObjeto.get(x)[2].toString());
                engTaskListView.setCompany(listaObjeto.get(x)[3].toString());
                DateFormat formatof = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date  fechareqIns= formatof.parse(listaObjeto.get(x)[4].toString());
                engTaskListView.setReqFechaIns(fechareqIns);
                   if (listaObjeto.get(x)[5] != null) {
                    engTaskListView.setReqProbdesc(listaObjeto.get(x)[5].toString());
                } else {
                    engTaskListView.setReqProbdesc("");
                }
                if (listaObjeto.get(x)[6] != null) {
                    engTaskListView.setReqCustomer(listaObjeto.get(x)[6].toString());
                } else {
                    engTaskListView.setReqCustomer("");
                }
                if (listaObjeto.get(x)[7] != null) {
                    engTaskListView.setReqRegistry(listaObjeto.get(x)[7].toString());
                } else {
                    engTaskListView.setReqRegistry("");
                }
                if (listaObjeto.get(x)[8] != null) {
                    engTaskListView.setUsrCoduser(listaObjeto.get(x)[8].toString());
                } else {
                    engTaskListView.setUsrCoduser("");
                }
                if (listaObjeto.get(x)[9] != null) {
                    engTaskListView.setReqStatus(listaObjeto.get(x)[9].toString());
                } else {
                    engTaskListView.setReqStatus("");
                }
                if (listaObjeto.get(x)[9] != null) {
                    engTaskListView.setReqStatus(listaObjeto.get(x)[9].toString());
                } else {
                    engTaskListView.setReqStatus("");
                }
                if (listaObjeto.get(x)[10] != null) {
                    engTaskListView.setFullUserName(listaObjeto.get(x)[10].toString());
                } else {
                    engTaskListView.setFullUserName("");
                }
                if (listaObjeto.get(x)[11] != null) {
                    engTaskListView.setFlota(listaObjeto.get(x)[11].toString());
                } else {
                    engTaskListView.setFlota("");
                } 
                if (listaObjeto.get(x)[12] != null) {
                    engTaskListView.setReqUsrIns(listaObjeto.get(x)[12].toString());
                } else {
                    engTaskListView.setReqUsrIns("");
                } 
                
                engTaskListView.setTieneHijos(new BigInteger(listaObjeto.get(x)[13].toString()));//**** java.lang.NumberFormatException: For input string: "sfuentes"
                
                if (listaObjeto.get(x)[14] != null) {
                    engTaskListView.setWoorder(listaObjeto.get(x)[14].toString());
                } else {
                    engTaskListView.setWoorder("");
                }
                 if (listaObjeto.get(x)[15] != null) {
                    engTaskListView.setReqJobcard(listaObjeto.get(x)[15].toString());
                } else {
                    engTaskListView.setReqJobcard("");
                }
                
                listadoengTaskListView.add(engTaskListView);
            }
        } catch (Exception e) {
            Logger.getLogger(EngTaskListViewFacade.class.getName()).log(Level.SEVERE, null, e);
        }
        return listadoengTaskListView;
    }
    
   
}
