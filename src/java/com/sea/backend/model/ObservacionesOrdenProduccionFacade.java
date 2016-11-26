/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.backend.model;

import com.sea.backend.entities.ObservacionesOrdenProduccion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author homero
 */
@Stateless
public class ObservacionesOrdenProduccionFacade extends AbstractFacade<ObservacionesOrdenProduccion> implements ObservacionesOrdenProduccionFacadeLocal {

    @PersistenceContext(unitName = "SEAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ObservacionesOrdenProduccionFacade() {
        super(ObservacionesOrdenProduccion.class);
    }
    
}
