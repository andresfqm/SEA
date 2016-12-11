/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.backend.model;

import com.sea.backend.entities.Cliente;
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
public class ClienteFacade extends AbstractFacade<Cliente> implements ClienteFacadeLocal {

    @PersistenceContext(unitName = "SEAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteFacade() {
        super(Cliente.class);
    }

    @Override
    public List datosCliente(int idCliente) {
        /*
        Nomenclatura de la consulta
        c: cliente
        o: origen
        ca: cambio asesor
        td: Tipo documento
        t: telefono
        e: e-mail
        tt: tipo teléfono
        te: tipo e-mail
        d: direccion
        tdi: tipo direccion
        ci: ciudad
        de: departamento
        */
        List datosCliente;
        String consulta="SELECT ci.NOMBRE FROM " +
                        "TBL_CLIENTE c " +
                        "INNER JOIN " +
                        "TBL_ORIGEN o ON c.TBL_ORIGEN_ID_ORIGEN = o.ID_ORIGEN AND c.ID_CLIENTE=?1 " +
                        "LEFT JOIN " +
                        "TBL_COMENTARIO_CAMBIO_ASESOR ca ON c.TBL_COMENTARIO_CAMBIO_ASESOR_ID_COMENTARIO_CAMBIO_ASESOR = ca.ID_COMENTARIO_CAMBIO_ASESOR " +
                        "INNER JOIN " +
                        "TBL_TIPO_DOCUMENTO td ON c.TBL_TIPO_DOCUMENTO_ID_TIPO_DOCUMENTO = td.ID_TIPO_DOCUMENTO " +
                        "INNER JOIN " +
                        "TBL_TELEFONO t ON c.ID_CLIENTE = t.TBL_CLIENTE_ID_CLIENTE " +
                        "INNER JOIN " +
                        "TBL_EMAIL e ON c.ID_CLIENTE = e.TBL_CLIENTE_ID_CLIENTE " +
                        "INNER JOIN " +
                        "TBL_TIPO_TELEFONO tt ON t.TBL_TIPO_TELEFONO_ID_TIPO_TELEFONO = tt.ID_TIPO_TELEFONO " +
                        "INNER JOIN " +
                        "TBL_TIPO_EMAIL te ON e.TBL_TIPO_EMAIL_ID_TIPO_EMAIL = te.ID_TIPO_EMAIL " +
                        "INNER JOIN " +
                        "TBL_DIRECCION d ON d.TBL_CLIENTE_ID_CLIENTE = c.ID_CLIENTE " +
                        "INNER JOIN " +
                        "TBL_TIPO_DIRECCION tdi ON d.TBL_TIPO_DIRECCION_ID_TIPO_DIRECCION = tdi.ID_TIPO_DIRECCION " +
                        "INNER JOIN " +
                        "TBL_CIUDAD ci ON d.TBL_CIUDAD_ID_CIUDAD = ci.ID_CIUDAD " +
                        "INNER JOIN " +
                        "TBL_DEPARTAMENTO de ON ci.TBL_DEPARTAMENTO_ID_DEPARTAMENTO = de.ID_DEPARTAMENTO";
        Query query = em.createNativeQuery(consulta);
        query.setParameter(1, idCliente);
        datosCliente = query.getResultList();
        return datosCliente;
    }

}
