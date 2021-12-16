package com.aeroman.aees.facades;

import com.aeroman.aees.entities.ResponsesNameVw;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;







@Stateless
public class ResponsesNameVwFacade extends AbstractFacade<ResponsesNameVw>
{
  @PersistenceContext(unitName="EngineeringManageBCPU")
  private EntityManager em;
  
  protected EntityManager getEntityManager()
  {
    return em;
  }
  
  public ResponsesNameVwFacade() {
    super(ResponsesNameVw.class);
  }
  
  public List<ResponsesNameVw> findTrackingsByEsr(BigInteger reqMessageID) { 
      return em.createQuery("SELECT e FROM ResponsesNameVw e WHERE e.reqMessageid = :reqMessageid ORDER BY e.resDateMsg DESC").setParameter("reqMessageid", reqMessageID).getResultList(); 
  }
}