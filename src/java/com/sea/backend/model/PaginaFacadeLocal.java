/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.backend.model;

import com.sea.backend.entities.Pagina;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author homero
 */
@Local
public interface PaginaFacadeLocal {

    void create(Pagina pagina);

    void edit(Pagina pagina);

    void remove(Pagina pagina);

    Pagina find(Object id);

    List<Pagina> findAll();

    List<Pagina> findRange(int[] range);

    int count();
    
}
