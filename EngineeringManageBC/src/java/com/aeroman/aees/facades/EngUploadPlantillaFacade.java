/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

import com.aeroman.aees.entities.EngUploadPlantilla;
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
 * @author firaheta
 */
@Stateless
public class EngUploadPlantillaFacade extends AbstractFacade<EngUploadPlantilla> {
    @PersistenceContext(unitName = "EngineeringManageBCPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EngUploadPlantillaFacade() {
        super(EngUploadPlantilla.class);
    }

    public List<EngUploadPlantilla> findAllEngUploadPlantilla() {
        EngUploadPlantilla engUploadPlantilla = new EngUploadPlantilla();
        List<EngUploadPlantilla> listadoEngMergeCustomer = new ArrayList<EngUploadPlantilla>();
        List<Object[]> listaObjeto = new ArrayList<Object[]>();
        try {
            String consulta = "SELECT ID_DOCUMENT, BODY_DOCUMENT, NAME_DOCUMENT, EXTEN_DOCUMENT FROM ENG_UPLOAD_PLANTILLA";
        
            Query query = em.createNativeQuery(consulta);
            listaObjeto = query.getResultList();
            for (int x = 0; x < listaObjeto.size(); x++) {
                engUploadPlantilla = new EngUploadPlantilla();
                if (listaObjeto.get(x)[0] != null) {
                    engUploadPlantilla.setIdDocument(new Long(listaObjeto.get(x)[0].toString()));
                }
                  if (listaObjeto.get(x)[1] != null) {
                      byte[] blobfile=(byte[])listaObjeto.get(x)[1];
                    engUploadPlantilla.setBodyDocument(blobfile);
                }
                    if (listaObjeto.get(x)[2] != null) {
                    engUploadPlantilla.setNameDocument(listaObjeto.get(x)[2].toString());
                }
                    if (listaObjeto.get(x)[3] != null) {
                    engUploadPlantilla.setExtenDocument(listaObjeto.get(x)[3].toString());
                }
                listadoEngMergeCustomer.add(engUploadPlantilla);
            }
        } catch (Exception e) {
            Logger.getLogger(EngMeasureFacade.class.getName()).log(Level.SEVERE, null, e);
        }
        return listadoEngMergeCustomer;
    }

    
}
