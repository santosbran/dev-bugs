/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

import com.aeroman.aees.entities.grant.SgrOptionRole;
import com.aeroman.aees.entities.grant.SgrRole;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sbran
 */
@Stateless
public class SgrUrsRoleFacade implements Serializable {
    
    private static final String PERSISTENCE_UNIT_NAME = "EngineeringManageBCPU";
    private static EntityManagerFactory factory;
    
    /*
    public SgrUrsRoleFacade(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public SgrUrsRoleFacade() {
        emf = Persistence.createEntityManagerFactory("EngineeringManageBCPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    */
    
    public List<SgrOptionRole> validarRol(String Cod) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        SgrOptionRole sg = new SgrOptionRole();
        List<SgrOptionRole> roles = new ArrayList<SgrOptionRole>();
        List<Object[]> rol = new ArrayList<Object[]>();
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession();
        try {
            //em = getEntityManager();
                Query query = em.createNativeQuery("SELECT ROLE_CODE,'opt' As option_code,SYSTEMID,CIA_CODE "
                        + " FROM SGR_USER_ROLE WHERE USER_ID=(SELECT USER_ID FROM SGR_USER WHERE CODIGO86='" + Cod.trim() + "') AND SYSTEMID=8300");
                rol = query.getResultList();
                for (int i = 0; i < rol.size(); i++) {
                    sg = new SgrOptionRole();
                    sg.setRolecode(rol.get(i)[0].toString());
                    sg.setOptioncode(rol.get(i)[1].toString());
                    sg.setSystemid(rol.get(i)[2].toString());
                    sg.setCiacode(rol.get(i)[3].toString());
                    roles.add(sg);
                    System.out.println("Valor encontrado: " + sg);
                }
            
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            em.close();
        }
        return roles;
    }
}
