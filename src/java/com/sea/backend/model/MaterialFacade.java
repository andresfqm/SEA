/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.backend.model;

import com.sea.backend.entities.Material;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author homero
 */
@Stateless
public class MaterialFacade extends AbstractFacade<Material> implements MaterialFacadeLocal {

    @PersistenceContext(unitName = "SEAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MaterialFacade() {
        super(Material.class);
    }

    @Override
    public List<Material> datosMaterial(int idProducto) throws Exception {
        List<Material> lista;
        String consulta1 = "SELECT m.nombre FROM tbl_producto AS p\n"
                + "INNER JOIN tbl_producto_material AS pm ON p.id_producto = pm.tbl_producto_id_producto\n"
                + "INNER JOIN tbl_material AS m ON pm.tbl_material_id_material = m.id_material\n"
                + "WHERE p.id_producto = ?1";

        Query query = em.createNativeQuery(consulta1);
        query.setParameter(1, idProducto);

        lista = query.getResultList();
        return lista;
    }

}
