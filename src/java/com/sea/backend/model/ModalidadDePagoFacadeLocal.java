/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.backend.model;

import com.sea.backend.entities.ModalidadDePago;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author homero
 */
@Local
public interface ModalidadDePagoFacadeLocal {

    void create(ModalidadDePago modalidadDePago);

    void edit(ModalidadDePago modalidadDePago);

    void remove(ModalidadDePago modalidadDePago);

    ModalidadDePago find(Object id);

    List<ModalidadDePago> findAll();

    List<ModalidadDePago> findRange(int[] range);

    int count();
    
}
