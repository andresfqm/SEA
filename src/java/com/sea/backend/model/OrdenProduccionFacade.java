/*
 * The MIT License
 *
 * Copyright 2017 homero.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.sea.backend.model;

import com.sea.backend.entities.OrdenProduccion;
import com.sea.frontend.controller.OrdenProduccionAuxiliar;
import java.util.ArrayList;
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
public class OrdenProduccionFacade extends AbstractFacade<OrdenProduccion> implements OrdenProduccionFacadeLocal {

	@PersistenceContext(unitName = "SEAPU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public OrdenProduccionFacade() {
		super(OrdenProduccion.class);
	}

	@Override
	public List<OrdenProduccionAuxiliar> lugarEmisionCotizacion(String numeroCotizacion) throws Exception {
		
		List<Object[]> listaDatos;
		 List<OrdenProduccionAuxiliar> listalugarEmisionCotizacion;
		 listalugarEmisionCotizacion = new ArrayList<>();
			String consulta1 = "SELECT LUGAR_EMISION FROM tbl_cotizacion WHERE NUMERO_COTIZACION = ?1";

		Query query = em.createNativeQuery(consulta1);
		query.setParameter(1, numeroCotizacion);

		listaDatos = query.getResultList();
		
		for (Object[] ordenProduccionAuxiliar : listaDatos) {
			OrdenProduccionAuxiliar ordPA = new OrdenProduccionAuxiliar();
			ordPA.setLugarEmision(ordenProduccionAuxiliar[0].toString());
	
	
		listalugarEmisionCotizacion.add(ordPA);
		}
		return listalugarEmisionCotizacion;
		//List<Object[]> miLista = query.getResultList();
	}
	
}
