/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades.grant;

import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Usuario
 */
public abstract class AbstractFacade<T> {
    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManagerf();

    public void create(T entity) {
        getEntityManagerf().persist(entity);
    }

    public void edit(T entity) {
        getEntityManagerf().merge(entity);
    }

    public void remove(T entity) {
        getEntityManagerf().remove(getEntityManagerf().merge(entity));
    }

    public T find(Object id) {
        return getEntityManagerf().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManagerf().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManagerf().createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cqfindRage = getEntityManagerf().getCriteriaBuilder().createQuery();
        cqfindRage.select(cqfindRage.from(entityClass));
        javax.persistence.Query qrange = getEntityManagerf().createQuery(cqfindRage);
        qrange.setMaxResults(range[1] - range[0] + 1);
        qrange.setFirstResult(range[0]);
        return qrange.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cqcount = getEntityManagerf().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cqcount.from(entityClass);
        cqcount.select(getEntityManagerf().getCriteriaBuilder().count(rt));
        javax.persistence.Query qcount = getEntityManagerf().createQuery(cqcount);
        return ((Long) qcount.getSingleResult()).intValue();
    }
    
}
