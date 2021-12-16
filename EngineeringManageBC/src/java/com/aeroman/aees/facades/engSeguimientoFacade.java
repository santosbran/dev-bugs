/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

import com.aeroman.aees.entities.engSeguimiento;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sbran
 */
@Stateless
public class engSeguimientoFacade implements Serializable {
    private static final String PERSISTENCE_UNIT_NAME = "EngineeringManageBCPU";
    private static EntityManagerFactory factory;
    
    
        public List<engSeguimiento> lsSeguimiento(BigInteger msgId,BigDecimal resId) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        engSeguimiento sg = new engSeguimiento();
        List<engSeguimiento> lsSg = new ArrayList<engSeguimiento>();
        List<Object[]> sgT = new ArrayList<Object[]>();
        //HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        //HttpSession session = request.getSession();
        try {
                Query query = em.createNativeQuery("SELECT  RES_CORR_ESR,RES_COD_MSJ FROM ENG_REQ_RESPONSES "
                        + " WHERE RES_CORR_ESR IS NOT NULL AND RES_COD_MSJ IS NOT NULL AND REQ_MESSAGEID=" + msgId + " AND RES_ID<>" + resId);
                sgT = query.getResultList();
                
                for (int i = 0; i < sgT.size(); i++) {
                    sg = new engSeguimiento();
                    sg.setIdMSJ(sgT.get(i)[0].toString() + sgT.get(i)[1].toString());
                    //sg.setIdMSJ(sgT.get(i)[0].toString());
                    lsSg.add(sg);
                }
            
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);

        } 
        return lsSg;
    }
}
