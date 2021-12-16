package com.aeroman.aees.facades;

import com.aeroman.aees.entities.TypeDoc;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;








@Stateless
public class TypeDocFacade extends AbstractFacade<TypeDoc>
{
  @PersistenceContext(unitName="EngineeringManageBCPU")
  private EntityManager em;
  
  protected EntityManager getEntityManager()
  {
    return em;
  }
  
  public TypeDocFacade() {
    super(TypeDoc.class);
  }
}