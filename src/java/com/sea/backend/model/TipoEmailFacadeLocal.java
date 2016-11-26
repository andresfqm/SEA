/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.backend.model;

import com.sea.backend.entities.TipoEmail;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author homero
 */
@Local
public interface TipoEmailFacadeLocal {

    void create(TipoEmail tipoEmail);

    void edit(TipoEmail tipoEmail);

    void remove(TipoEmail tipoEmail);

    TipoEmail find(Object id);

    List<TipoEmail> findAll();

    List<TipoEmail> findRange(int[] range);

    int count();
    
}
