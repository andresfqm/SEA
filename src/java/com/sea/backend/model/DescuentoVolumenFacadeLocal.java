/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.backend.model;

import com.sea.backend.entities.DescuentoVolumen;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author homero
 */
@Local
public interface DescuentoVolumenFacadeLocal {

    void create(DescuentoVolumen descuentoVolumen);

    void edit(DescuentoVolumen descuentoVolumen);

    void remove(DescuentoVolumen descuentoVolumen);

    DescuentoVolumen find(Object id);

    List<DescuentoVolumen> findAll();

    List<DescuentoVolumen> findRange(int[] range);

    int count();
    
}
