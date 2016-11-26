/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.backend.model;

import com.sea.backend.entities.Subcategoria;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author homero
 */
@Local
public interface SubcategoriaFacadeLocal {

    void create(Subcategoria subcategoria);

    void edit(Subcategoria subcategoria);

    void remove(Subcategoria subcategoria);

    Subcategoria find(Object id);

    List<Subcategoria> findAll();

    List<Subcategoria> findRange(int[] range);

    int count();
    
}
