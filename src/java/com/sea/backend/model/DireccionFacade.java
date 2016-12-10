/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.backend.model;

import com.sea.backend.entities.Direccion;
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
public class DireccionFacade extends AbstractFacade<Direccion> implements DireccionFacadeLocal {

    @PersistenceContext(unitName = "SEAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DireccionFacade() {
        super(Direccion.class);
    }

    @Override
    public Direccion direccionCliente(int idCliente) {
        Direccion direccionCliente = null;
        String consulta;
        try {
            consulta = "FROM Direccion d WHERE d.tblClienteIdCliente.idCliente = ?1";
            //consulta = "c.nombre FROM Direccion d INNER JOIN d.Cliente cl ON d.tblClienteIdCliente.idCliente=cl.idCliente AND d.tblClienteIdCliente= ?1 INNER JOIN Ciudad c ON d.tblCiudadIdCiudad.idCiudad=c.idCiudad";
            //SELECT c.nombre FROM TBL_DIRECCION d INNER JOIN TBL_CLIENTE cl ON d.TBL_CLIENTE_ID_CLIENTE=cl.ID_CLIENTE AND d.TBL_CLIENTE_ID_CLIENTE=211 INNER JOIN TBL_CIUDAD c ON d.TBL_CIUDAD_ID_CIUDAD=c.ID_CIUDAD;
            Query query = em.createQuery(consulta);
            query.setParameter(1, idCliente);
            direccionCliente = (Direccion) query.getSingleResult();
            System.out.println(direccionCliente);
        } catch (Exception e) {
            throw e;
        }
        return direccionCliente;
    }
}
