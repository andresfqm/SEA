/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.backend.model;

import com.sea.backend.entities.OrdenProduccion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author homero
 */
@Local
public interface OrdenProduccionFacadeLocal {

    void create(OrdenProduccion ordenProduccion);

    void edit(OrdenProduccion ordenProduccion);

    void remove(OrdenProduccion ordenProduccion);

    OrdenProduccion find(Object id);

    List<OrdenProduccion> findAll();

    List<OrdenProduccion> findRange(int[] range);

    int count();
    
}
