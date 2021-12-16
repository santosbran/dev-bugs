/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

import com.aeroman.aees.entities.EngHorasIng;
import com.aeroman.aees.entities.EngHorasIngPK;
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
 * @author pc
 */
@Stateless
public class EngHorasIngFacade extends AbstractFacade<EngHorasIng> {
    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    public EngHorasIngFacade() {
        super(EngHorasIng.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    
    
    public BigInteger maxIdHin(){
        BigInteger n;
        if ((n=(BigInteger)em.createQuery("SELECT MAX(a.engHorasIngPK.hinId)+1 FROM EngHorasIng a").getSingleResult())!=null)
            return n;
        else{
            n = new BigInteger("1");
            return n;
        }
    }
    
     public List<EngHorasIng> findAllEngHorasIng() {
        EngHorasIng engHorasIng = new EngHorasIng();
        EngHorasIngPK engHorasIngemb = new EngHorasIngPK();
        List<EngHorasIng> listadoEngHorasIng = new ArrayList<EngHorasIng>();
        List<Object[]> listaObjeto = new ArrayList<Object[]>();
        try {
            String consulta = "SELECT HIN_ID, HIN_WO_YEAR, HIN_WO_CORR, HIN_WO_TASK, REQ_MESSAGEID, HIN_HRS_REALS, HIN_HRS_BILL, HIN_SELECTION, HIN_EXPORTED, EHI_ID, HIN_COD_USR_INS, HIN_DATE_INS, HIN_COD_USR_UPD, HIN_DATE_UPD  FROM ENG_HORAS_ING";
            Query query = em.createNativeQuery(consulta);
            listaObjeto = query.getResultList();
            
            for (int x = 0; x < listaObjeto.size(); x++) {
                engHorasIng = new EngHorasIng();
                engHorasIngemb = new EngHorasIngPK();
                engHorasIngemb.setHinId(new BigInteger(listaObjeto.get(x)[0].toString()));
                engHorasIng.setHinWoYear(new BigInteger(listaObjeto.get(x)[1].toString()));
                engHorasIng.setHinWoYear(new BigInteger(listaObjeto.get(x)[1].toString()));
                engHorasIng.setHinWoCorr(new BigInteger(listaObjeto.get(x)[2].toString()));
                engHorasIng.setHinWoTask(new BigInteger(listaObjeto.get(x)[3].toString()));
                engHorasIngemb.setReqMessageid(new BigInteger(listaObjeto.get(x)[4].toString()));
                engHorasIng.setHinHrsReals(new BigDecimal(listaObjeto.get(x)[5].toString()));
                engHorasIng.setHinHrsBill(new BigDecimal(listaObjeto.get(x)[6].toString()));
                engHorasIng.setEngHorasIngPK(engHorasIngemb);
                if (listaObjeto.get(x)[7] != null) {
                    engHorasIng.setHinSelection(listaObjeto.get(x)[7].toString());
                } else {
                    engHorasIng.setHinSelection("");
                }
                if (listaObjeto.get(x)[8] != null) {
                    engHorasIng.setHinExported(listaObjeto.get(x)[8].toString());
                } else {
                    engHorasIng.setHinExported("");
                }
                engHorasIng.setEhiId(new BigInteger(listaObjeto.get(x)[9].toString()));
                  if (listaObjeto.get(x)[10] != null) {
                   engHorasIng.setHinCodUsrIns(listaObjeto.get(x)[10].toString());
                } else {
                    engHorasIng.setHinCodUsrIns("");
                  }               
                DateFormat formatof = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                if (listaObjeto.get(x)[11] != null) {
                    Date hindateins = formatof.parse(listaObjeto.get(x)[11].toString());
                    engHorasIng.setHinDateIns(hindateins);
                }                      
               
                if (listaObjeto.get(x)[12] != null) {
                    engHorasIng.setHinCodUsrUpd(listaObjeto.get(x)[12].toString());
                } else {
                    engHorasIng.setHinCodUsrUpd("");
                }
                 if (listaObjeto.get(x)[13] != null) {
                    Date hindateUpd = formatof.parse(listaObjeto.get(x)[13].toString());
                    engHorasIng.setHinDateUpd(hindateUpd);
                }
                 
                listadoEngHorasIng.add(engHorasIng);
            }
        } catch (Exception e) {
            Logger.getLogger(EngTaskListViewFacade.class.getName()).log(Level.SEVERE, null, e);
        }
        return listadoEngHorasIng;
    }

    
    
    
}
