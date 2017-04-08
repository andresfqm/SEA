/*
 * The MIT License
 *
 * Copyright 2017 Depurador.
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

import com.sea.backend.entities.Pagina;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Depurador
 */
@Stateless
public class PaginaFacade extends AbstractFacade<Pagina> implements PaginaFacadeLocal {

	@PersistenceContext(unitName = "SEAPU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public PaginaFacade() {
		super(Pagina.class);
	}
	@Override
	public List<Pagina> obtenerSubMenus(int idUsuario, String seccion) {
		/*
        Nomenclatura de la consulta
		u: Usuario
		up: Usuario perfil
		p: Perfil
		pp: Página
		m: Menú
		 */

		String consulta = "SELECT "
				+ "pa.TBL_MENU_ID_MENU, pa.NOMBRE, pa.DESCRIPCION, pa.NOMBRE_BOTON, pa.URL, pa.URL_IMAGEN FROM "
				+ "tbl_usuario AS u INNER JOIN "
				+ "tbl_usuario_perfil AS up ON u.id_usuario = up.tbl_usuario_id_usuario INNER JOIN "
				+ "tbl_perfil AS p ON up.tbl_perfil_id_perfil = p.id_perfil INNER JOIN "
				+ "tbl_perfil_pagina AS pp ON p.id_perfil = pp.tbl_perfil_id_perfil INNER JOIN "
				+ "tbl_pagina AS pa ON pp.tbl_pagina_id_pagina = pa.id_pagina INNER JOIN "
				+ "tbl_menu AS m ON pa.tbl_menu_id_menu = m.id_menu WHERE "
				+ "u.id_usuario = ?1 and m.nombre=?2 ORDER BY pa.POSICION";
		Query query = em.createNativeQuery(consulta);
		query.setParameter(1, idUsuario);
		query.setParameter(2, seccion);
		List<Pagina> subMenusUsuario;
		subMenusUsuario = query.getResultList();
		return subMenusUsuario;
	}
}
