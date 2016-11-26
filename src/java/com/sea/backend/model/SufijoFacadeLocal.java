/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.backend.model;

import com.sea.backend.entities.Sufijo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author homero
 */
@Local
public interface SufijoFacadeLocal {

    void create(Sufijo sufijo);

    void edit(Sufijo sufijo);

    void remove(Sufijo sufijo);

    Sufijo find(Object id);

    List<Sufijo> findAll();

    List<Sufijo> findRange(int[] range);

    int count();
    
}
