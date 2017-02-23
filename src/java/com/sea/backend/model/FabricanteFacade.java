/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.backend.model;

import com.sea.backend.entities.Fabricante;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author homero
 */
@Stateless
public class FabricanteFacade extends AbstractFacade<Fabricante> implements FabricanteFacadeLocal {

    @PersistenceContext(unitName = "SEAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FabricanteFacade() {
        super(Fabricante.class);
    }

    @Override
    public Fabricante descripcionFabricante(int idProducto) throws Exception {
        Fabricante descripcioFabricante = null;
        String consulta2;

        try {
            consulta2 = "SELECT fa.nombre FROM tbl_producto AS P\n"
                    + "INNER JOIN tbl_fabricante AS fa \n"
                    + "ON p.tbl_fabricante_id_fabricante = fa.id_fabricante\n"
                    + "where p.id_producto= ?1";

            Query query = em.createNativeQuery(consulta2);
            query.setParameter(1, idProducto);

            descripcioFabricante = (Fabricante) query.getSingleResult();
            //System.out.println(descripcioFabricante);

        } catch (Exception e) {

        }
        return descripcioFabricante;
    }

}
