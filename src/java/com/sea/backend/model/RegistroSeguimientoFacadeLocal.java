/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.backend.model;

import com.sea.backend.entities.RegistroSeguimiento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author homero
 */
@Local
public interface RegistroSeguimientoFacadeLocal {

    void create(RegistroSeguimiento registroSeguimiento);

    void edit(RegistroSeguimiento registroSeguimiento);

    void remove(RegistroSeguimiento registroSeguimiento);

    RegistroSeguimiento find(Object id);

    List<RegistroSeguimiento> findAll();

    List<RegistroSeguimiento> findRange(int[] range);

    int count();
    
}
