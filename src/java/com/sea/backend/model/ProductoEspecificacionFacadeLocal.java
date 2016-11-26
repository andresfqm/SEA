/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.backend.model;

import com.sea.backend.entities.ProductoEspecificacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author homero
 */
@Local
public interface ProductoEspecificacionFacadeLocal {

    void create(ProductoEspecificacion productoEspecificacion);

    void edit(ProductoEspecificacion productoEspecificacion);

    void remove(ProductoEspecificacion productoEspecificacion);

    ProductoEspecificacion find(Object id);

    List<ProductoEspecificacion> findAll();

    List<ProductoEspecificacion> findRange(int[] range);

    int count();
    
}
