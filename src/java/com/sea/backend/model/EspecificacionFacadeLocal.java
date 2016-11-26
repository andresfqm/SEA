/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.backend.model;

import com.sea.backend.entities.Especificacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author homero
 */
@Local
public interface EspecificacionFacadeLocal {

    void create(Especificacion especificacion);

    void edit(Especificacion especificacion);

    void remove(Especificacion especificacion);

    Especificacion find(Object id);

    List<Especificacion> findAll();

    List<Especificacion> findRange(int[] range);

    int count();
    
}
