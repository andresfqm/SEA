/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.backend.model;

import com.sea.backend.entities.PropuestaNoIncluye;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author homero
 */
@Local
public interface PropuestaNoIncluyeFacadeLocal {

    void create(PropuestaNoIncluye propuestaNoIncluye);

    void edit(PropuestaNoIncluye propuestaNoIncluye);

    void remove(PropuestaNoIncluye propuestaNoIncluye);

    PropuestaNoIncluye find(Object id);

    List<PropuestaNoIncluye> findAll();

    List<PropuestaNoIncluye> findRange(int[] range);

    int count();
    
}
