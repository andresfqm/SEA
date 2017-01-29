/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.backend.model;

import com.sea.backend.entities.Origen;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author homero
 */
@Local
public interface OrigenFacadeLocal {

    void create(Origen origen);

    void edit(Origen origen);

    void remove(Origen origen);

    Origen find(Object id);

    List<Origen> findAll();
    
    List<Origen> findRange(int[] range);

    int count();
    
}
