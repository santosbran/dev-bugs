/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

import com.aeroman.aees.entities.EngToolRequest;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author scruz
 */
@Stateless
public class EngToolRequestFacade extends AbstractFacade<EngToolRequest> {

    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    public EngToolRequestFacade() {
        super(EngToolRequest.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
