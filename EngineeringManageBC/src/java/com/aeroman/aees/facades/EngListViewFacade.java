/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

import com.aeroman.aees.entities.EngListView;
import com.aeroman.aees.entities.EngMergeCustomer;
import java.math.BigInteger;
import java.util.ArrayList;
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
public class EngListViewFacade extends AbstractFacade<EngListView> {
    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    
    public EngListViewFacade() {
        super(EngListView.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    
    
    public List<EngListView> findByCodigo86(String codigo86){
        List<EngListView> user = new ArrayList<EngListView>();
        
        if(codigo86 != null && !("").equals(codigo86)){
            user = (List<EngListView>) em.createNamedQuery("EngListView.findByCodigo86")
                    .setParameter("codigo86", codigo86).getResultList();
        }
        
        
        return user;
    }
    public List<String> findByEngCodigo86(){
        return em.createQuery("SELECT DISTINCT e.codigo86,e.fullUserName FROM EngListView e order by e.fullUserName asc").getResultList();        
    }
    public List<String> findByEngCodigoCiaCode(String pCodCia){
        return em.createQuery("SELECT DISTINCT e.codigo86,e.fullUserName FROM EngListView e where e.ciaCode ='"+pCodCia+"' order by e.fullUserName asc").getResultList();        
    }
     public List<String> findNameByEngCodigo86(String pCod86){
        return em.createQuery("SELECT DISTINCT e.fullUserName FROM EngListView e WHERE e.codigo86 = '" + pCod86 + "'").getResultList();        
    }
     
     public List<EngListView> findAllEngListView() {
        EngListView engListView = new EngListView();
        List<EngListView> listadoEngMergeCustomer = new ArrayList<EngListView>();
        List<Object[]> listaObjeto = new ArrayList<Object[]>();
        try {
            String consulta = "SELECT SEGUNDO_NOMBRE, PRIMER_NOMBRE, SEGUNDO_APELLIDO, PRIMER_APELLIDO, SKILL, DGE_CODCGR, PUESTO, USER_TYPE, CODIGO86, FULL_USER_NAME, CIA_CODE, ROLE_CODE, ROW_ID FROM ENG_LIST_VIEW";
        
            Query query = em.createNativeQuery(consulta);
            listaObjeto = query.getResultList();
            
            for (int x = 0; x < listaObjeto.size(); x++) {
                engListView = new EngListView();
                if (listaObjeto.get(x)[0] != null) {
                    engListView.setSegundoNombre(listaObjeto.get(x)[0].toString());
                }
                if (listaObjeto.get(x)[1] != null) {
                    engListView.setPrimerNombre(listaObjeto.get(x)[1].toString());
                }
                if (listaObjeto.get(x)[2] != null) {
                      engListView.setSegundoApellido(listaObjeto.get(x)[2].toString());
                }
                if (listaObjeto.get(x)[3] != null) {
                    engListView.setPrimerApellido(listaObjeto.get(x)[3].toString());
                }
                if (listaObjeto.get(x)[4] != null) {
                        engListView.setSkill(listaObjeto.get(x)[4].toString());
                }
                if (listaObjeto.get(x)[5] != null) {
                    engListView.setDgeCodcgr(listaObjeto.get(x)[5].toString());
                }                
                if (listaObjeto.get(x)[6] != null) {
                    engListView.setPuesto(listaObjeto.get(x)[6].toString());
                }
                if (listaObjeto.get(x)[7] != null) {
                    engListView.setUserType(listaObjeto.get(x)[7].toString());
                }
                if (listaObjeto.get(x)[8] != null) {
                    engListView.setCodigo86(listaObjeto.get(x)[8].toString());
                }
                if (listaObjeto.get(x)[9] != null) {
                    engListView.setFullUserName(listaObjeto.get(x)[9].toString());
                }
                if (listaObjeto.get(x)[10] != null) {
                    engListView.setCiaCode(listaObjeto.get(x)[10].toString());
                }
                if (listaObjeto.get(x)[11] != null) {
                    engListView.setRoleCode(listaObjeto.get(x)[11].toString());
                }
                if (listaObjeto.get(x)[12] != null) {
                    engListView.setRowId(new BigInteger(listaObjeto.get(x)[12].toString()));
                }
                listadoEngMergeCustomer.add(engListView);
            }
        } catch (Exception e) {
            Logger.getLogger(EngListViewFacade.class.getName()).log(Level.SEVERE, null, e);
        }
        return listadoEngMergeCustomer;
    }

    
}
