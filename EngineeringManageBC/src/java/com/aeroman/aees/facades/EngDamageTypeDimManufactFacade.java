/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;


import com.aeroman.aees.entities.CoreAircraftType;
import com.aeroman.aees.entities.EngDamageDim;
import com.aeroman.aees.entities.EngDtDimByManuf;
import java.math.BigDecimal;
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
 * @author mchacon
 */
@Stateless
public class EngDamageTypeDimManufactFacade extends AbstractFacade<EngDtDimByManuf>{
   @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    public EngDamageTypeDimManufactFacade() {
        super(EngDtDimByManuf.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public List<EngDtDimByManuf> traerLocationByManuf(String ubicacion, String fabricante, BigDecimal datId) {
        List<EngDtDimByManuf> listaubicacion = new ArrayList();
        Query query;
         int damagetype=datId.intValue();
        try {
            em = getEntityManager();
                  query = em.createQuery("SELECT e FROM EngDtDimByManuf e WHERE e.ubicationDim = :ubicacion and e.datId.datId= :datId and trim(e.dtDimByManufName) = :fabricante and e.dimId.typeControl='textBox' Order by e.orden asc").setParameter("ubicacion", ubicacion).setParameter("fabricante", fabricante).setParameter("datId", datId);
                  listaubicacion = query.getResultList();
              
        } catch (Exception e) {
            Logger.getLogger(EngDtDimByManuf.class.getName()).log(Level.SEVERE, null, e);
        }
        return listaubicacion;
    }
    
    public List<EngDtDimByManuf> traerDTDimByManufCheck(String ubicacion, String fabricante, BigDecimal datId) {
        List<EngDtDimByManuf> listaubicacion = new ArrayList();
        Query query;
        int damagetype=datId.intValue();
        try {
            em = getEntityManager();
              if(damagetype!=6 && damagetype!=2){
                    query = em.createQuery("SELECT e FROM EngDtDimByManuf e WHERE e.ubicationDim = :ubicacion and e.datId.datId= :datId and trim(e.dtDimByManufName) = :fabricante and e.dimId.typeControl='checkBox' Order by e.orden asc").setParameter("ubicacion", ubicacion).setParameter("fabricante", fabricante).setParameter("datId", datId);
                    listaubicacion = query.getResultList();
              }else{
                          query = em.createQuery("SELECT e FROM EngDtDimByManuf e WHERE e.ubicationDim = :ubicacion and e.datId.datId= :datId and trim(e.dtDimByManufName) = :fabricante and e.dimId.typeControl='checkBox' and e.dimId.dimName in('Milimeter', 'Inches')  Order by e.orden asc").setParameter("ubicacion", ubicacion).setParameter("fabricante", fabricante).setParameter("datId", datId);
                    listaubicacion = query.getResultList();
                 }
              
        } catch (Exception e) {
            Logger.getLogger(EngDtDimByManuf.class.getName()).log(Level.SEVERE, null, e);
        }
        return listaubicacion;
    }
    
    public List<EngDtDimByManuf> traerDTDimByManuf(String ubicacion, String fabricante, BigDecimal datId) {
        List<EngDtDimByManuf> listaubicacion = new ArrayList();
        Query query;
         int damagetype=datId.intValue();
        try {
            em = getEntityManager();
              if(damagetype!=6 && damagetype!=2){
                  query = em.createQuery("SELECT e FROM EngDtDimByManuf e WHERE e.ubicationDim = :ubicacion and e.datId.datId= :datId and trim(e.dtDimByManufName) = :fabricante and e.dimId.typeControl='textBox' Order by e.orden asc").setParameter("ubicacion", ubicacion).setParameter("fabricante", fabricante).setParameter("datId", datId);
                  listaubicacion = query.getResultList();
               }
        } catch (Exception e) {
            Logger.getLogger(EngDtDimByManuf.class.getName()).log(Level.SEVERE, null, e);
        }
        return listaubicacion;
    }
    
    public List<EngDtDimByManuf> traerDTDimByManuf_forBD(String ubicacion, String fabricante, BigDecimal datId) {
        List<EngDtDimByManuf> listaubicacion = new ArrayList();
        Query query;
        int damagetype=datId.intValue();
        try {
            em = getEntityManager();
            if(damagetype==6 || damagetype==2){
            query = em.createQuery("SELECT e FROM EngDtDimByManuf e WHERE e.ubicationDim = :ubicacion and e.datId.datId= :datId and trim(e.dtDimByManufName) = :fabricante and e.dimId.dimName != 'Milimeter'  and e.dimId.dimName != 'Inches'  Order by e.orden asc").setParameter("ubicacion", ubicacion).setParameter("fabricante", fabricante).setParameter("datId", datId);          
            listaubicacion = query.getResultList();
            }
        } catch (Exception e) {
            Logger.getLogger(EngDtDimByManuf.class.getName()).log(Level.SEVERE, null, e);
        }
        return listaubicacion;
    }
    
    
    public List<EngDtDimByManuf> traerNearbyDimByManuf(String ubicacion, String fabricante, BigDecimal datId) {
        List<EngDtDimByManuf> listaubicacion = new ArrayList();
        Query query;
        try {
            em = getEntityManager();
            query = em.createQuery("SELECT e FROM EngDtDimByManuf e WHERE e.ubicationDim = :ubicacion and e.datId.datId= :datId and trim(e.dtDimByManufName) = :fabricante Order by e.orden asc").setParameter("ubicacion", ubicacion).setParameter("fabricante", fabricante).setParameter("datId", datId);
            listaubicacion = query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(EngDtDimByManuf.class.getName()).log(Level.SEVERE, null, e);
        }
        return listaubicacion;
    }
    
    
    public List<EngDtDimByManuf> traerDTDimByManufOther(String ubicacion, String fabricante, String datName) {
        List<EngDtDimByManuf> listaubicacion = new ArrayList();
        Query query;
        try {
            em = getEntityManager();
            query = em.createQuery("SELECT e FROM EngDtDimByManuf e WHERE e.ubicationDim = :ubicacion and e.datId = null and e.dimId.typeControl='textBox' and trim(e.dtDimByManufName) = :fabricante Order by e.orden asc").setParameter("ubicacion", ubicacion).setParameter("fabricante", fabricante);
            listaubicacion = query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(EngDtDimByManuf.class.getName()).log(Level.SEVERE, null, e);
        }
        return listaubicacion;
    }
    
    public List<EngDtDimByManuf> traerDTDimByManufOtherCheck(String ubicacion, String fabricante, String datName) {
        List<EngDtDimByManuf> listaubicacion = new ArrayList();
        Query query;
        try {
            em = getEntityManager();
            query = em.createQuery("SELECT e FROM EngDtDimByManuf e WHERE e.ubicationDim = :ubicacion and e.datId = null and trim(e.dtDimByManufName) = :fabricante and e.dimId.typeControl='checkBox' Order by e.orden asc").setParameter("ubicacion", ubicacion).setParameter("fabricante", fabricante);
            listaubicacion = query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(EngDtDimByManuf.class.getName()).log(Level.SEVERE, null, e);
        }
        return listaubicacion;
    }
      public List<String> traerManufacurerAER() {
        List<String> listaFabricante = new ArrayList();
  
      
        try {
            em = getEntityManager();
            String consulta = "SELECT DISTINCT TRIM(HACMAN) FROM AER.AER_GEN010A WHERE LENGTH(TRIM(HACMAN))>0";
                Query query = em.createNativeQuery(consulta);
                listaFabricante = query.getResultList();
               
            
            
        } catch (Exception e) {
            Logger.getLogger(EngDtDimByManuf.class.getName()).log(Level.SEVERE, null, e);
        }
        return listaFabricante;
    }
  
    public String traerManufacurerAERCont(String cliente, String ac, String acType) {
        String manufacturador="";
  
      
        try {
            em = getEntityManager();
            
            String consultaExiste = "SELECT COUNT (HACMAN) HACMAN FROM AER.AER_GEN010A WHERE TRIM(HCUST)='"+cliente+"' AND TRIM(HACREG) ='"+ac+"' AND TRIM(HACTYP)='"+acType+"'";
             Query query1 = em.createNativeQuery(consultaExiste);
            int cantidad = Integer.parseInt(query1.getSingleResult().toString().trim());
            if(cantidad > 0){
            String consulta = "SELECT HACMAN FROM AER.AER_GEN010A WHERE TRIM(HCUST)='"+cliente+"' AND TRIM(HACREG) ='"+ac+"' AND TRIM(HACTYP)='"+acType+"'";
                Query query = em.createNativeQuery(consulta);
                manufacturador = query.getSingleResult().toString().trim();
               }
            
            
        } catch (Exception e) {
            
                System.out.println("causa: "+e.getCause());
            Logger.getLogger(EngDtDimByManuf.class.getName()).log(Level.SEVERE, null, e);
        }
        return manufacturador;
    }
    
    public void crearManufacurerAERCont(String cliente, String ac, String acType, String manufact) {
        
        try {
            em = getEntityManager();
            String consulta = "INSERT INTO AER.AER_GEN010A(HACTYP, HACREG, HACMAN, HCUST) VALUES('"+acType+"','"+ac+"','"+manufact+"','"+cliente+"')";
                Query query = em.createNativeQuery(consulta);
                query.executeUpdate();
               
            
            
        } catch (Exception e) {
            
                System.out.println("causa: "+e.getCause());
            Logger.getLogger(EngDtDimByManuf.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
    
    
    
    
    public boolean existeTypeDamageManuf(BigDecimal idDamageType, BigDecimal idDim, String name) {
        boolean existe = false;
        int countDamageTypeManuf = 0;
        try {
            em = getEntityManager();
            String consulta = "SELECT COUNT(*) countDT FROM ENG_DT_DIM_BY_MANUF WHERE DAT_ID=" + idDamageType + " AND DIM_ID=" + idDim + " AND DT_DIM_BY_MANUF_NAME=TRIM('" + name + "')";
            Query query = em.createNativeQuery(consulta);
            countDamageTypeManuf = Integer.parseInt(query.getSingleResult().toString());
            if (countDamageTypeManuf > 0) {
                existe = true;
            }

        } catch (Exception e) {
            Logger.getLogger(EngDtDimByManuf.class.getName()).log(Level.SEVERE, null, e);
        }
        return existe;
    }
    
 public boolean existeTypeDamageManufUpdate(BigDecimal idDamageType, BigDecimal idDim, String name, BigDecimal idDimenDTManuf) {
        boolean existe = false;
        int countDamageTypeManuf = 0;
        try {
            em = getEntityManager();
            String consulta = "SELECT COUNT(*) countDT FROM ENG_DT_DIM_BY_MANUF WHERE DAT_ID=" + idDamageType + " AND DIM_ID=" + idDim + " AND DT_DIM_BY_MANUF_NAME=TRIM('" + name + "') AND DT_DIM_BY_MANUF_ID!="+idDimenDTManuf;
            Query query = em.createNativeQuery(consulta);
            countDamageTypeManuf = Integer.parseInt(query.getSingleResult().toString());
            if (countDamageTypeManuf > 0) {
                existe = true;
            }

        } catch (Exception e) {
            Logger.getLogger(EngDtDimByManuf.class.getName()).log(Level.SEVERE, null, e);
        }
        return existe;
    
 }  
          public List<EngDtDimByManuf> findAllByFlota(String pDamage,CoreAircraftType idAircraftType) {
        List<EngDtDimByManuf> location = new ArrayList();
        int dataID = Integer.parseInt(pDamage);
        Query query;
        try {
            em = getEntityManager();
            query = em.createQuery("SELECT e FROM EngDamageDim e WHERE e.dxdState = 'A' and e.datId.datId = :datName and e.arctypId=:arctypIds Order by e.datId.datName")
                    .setParameter("datName", dataID).setParameter("arctypIds", idAircraftType);
            location = query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(EngDamageDim.class.getName()).log(Level.SEVERE, null, e);
        }
        return location;
    }
    
}
