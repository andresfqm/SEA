/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.backend.model;

import com.sea.backend.entities.CondicionesGarantia;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author homero
 */
@Local
public interface CondicionesGarantiaFacadeLocal {

    void create(CondicionesGarantia condicionesGarantia);

    void edit(CondicionesGarantia condicionesGarantia);

    void remove(CondicionesGarantia condicionesGarantia);

    CondicionesGarantia find(Object id);

    List<CondicionesGarantia> findAll();

    List<CondicionesGarantia> findRange(int[] range);

    int count();
    
}
