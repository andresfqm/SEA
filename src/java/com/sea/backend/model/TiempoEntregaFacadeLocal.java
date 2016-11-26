/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.backend.model;

import com.sea.backend.entities.TiempoEntrega;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author homero
 */
@Local
public interface TiempoEntregaFacadeLocal {

    void create(TiempoEntrega tiempoEntrega);

    void edit(TiempoEntrega tiempoEntrega);

    void remove(TiempoEntrega tiempoEntrega);

    TiempoEntrega find(Object id);

    List<TiempoEntrega> findAll();

    List<TiempoEntrega> findRange(int[] range);

    int count();
    
}
