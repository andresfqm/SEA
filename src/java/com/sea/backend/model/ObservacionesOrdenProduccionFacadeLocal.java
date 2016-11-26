/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.backend.model;

import com.sea.backend.entities.ObservacionesOrdenProduccion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author homero
 */
@Local
public interface ObservacionesOrdenProduccionFacadeLocal {

    void create(ObservacionesOrdenProduccion observacionesOrdenProduccion);

    void edit(ObservacionesOrdenProduccion observacionesOrdenProduccion);

    void remove(ObservacionesOrdenProduccion observacionesOrdenProduccion);

    ObservacionesOrdenProduccion find(Object id);

    List<ObservacionesOrdenProduccion> findAll();

    List<ObservacionesOrdenProduccion> findRange(int[] range);

    int count();
    
}
