/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.backend.model;

import com.sea.backend.entities.LugaresEntrega;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author homero
 */
@Local
public interface LugaresEntregaFacadeLocal {

    void create(LugaresEntrega lugaresEntrega);

    void edit(LugaresEntrega lugaresEntrega);

    void remove(LugaresEntrega lugaresEntrega);

    LugaresEntrega find(Object id);

    List<LugaresEntrega> findAll();

    List<LugaresEntrega> findRange(int[] range);

    int count();
    
}
