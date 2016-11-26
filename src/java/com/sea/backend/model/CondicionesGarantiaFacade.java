/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.backend.model;

import com.sea.backend.entities.CondicionesGarantia;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author homero
 */
@Stateless
public class CondicionesGarantiaFacade extends AbstractFacade<CondicionesGarantia> implements CondicionesGarantiaFacadeLocal {

    @PersistenceContext(unitName = "SEAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CondicionesGarantiaFacade() {
        super(CondicionesGarantia.class);
    }
    
}
