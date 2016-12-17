/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.backend.model;

import com.sea.backend.entities.Producto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author homero
 */
@Stateless
public class ProductoFacade extends AbstractFacade<Producto> implements ProductoFacadeLocal {

    @PersistenceContext(unitName = "SEAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductoFacade() {
        super(Producto.class);
    }

    @Override
    public Producto productoDescripcion(int idProducto) throws Exception {
        Producto productoDescripcion = null;
        String consulta;

        try {
            consulta = "FROM Producto p WHERE p.idProducto = ?1";

            Query query = em.createQuery(consulta);
            query.setParameter(1, idProducto);
            productoDescripcion = (Producto) query.getSingleResult();
            System.out.println(productoDescripcion);
        } catch (Exception e) {
            throw e;
        }
        return productoDescripcion;
    }
}
