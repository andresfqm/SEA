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

import com.sea.backend.entities.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Depurador
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

	@PersistenceContext(unitName = "SEAPU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public UsuarioFacade() {
		super(Usuario.class);
	}

	@Override
	public Usuario iniciarSesion(Usuario us) {

		Usuario usuario = null;
		String consulta;
		try {
			consulta = "FROM Usuario u WHERE u.nombreUsuario = ?1 and u.contrasena = ?2";

			Query query = em.createQuery(consulta);
			query.setParameter(1, us.getNombreUsuario());
			query.setParameter(2, us.getContrasena());

			List<Usuario> lista = query.getResultList();
			if (!lista.isEmpty()) {
				usuario = lista.get(0);
			}
		} catch (Exception e) {

			throw e;

		}
		return usuario;
	}

	@Override
	public List<Usuario> listaUsuario() {
		List<Usuario> lista;
			String jpql = "select u.nombre, u.numero_documento, u.id_interno, t.numero_telefono, c.email, u.nombre_usuario, p.nombre from tbl_usuario as u\n"
					+ "inner join tbl_telefono as t\n"
					+ "on u.id_usuario = t.tbl_usuario_id_usuario\n"
					+ "inner join tbl_email as c\n"
					+ "on u.id_usuario = c.tbl_usuario_id_usuario\n"
					+ "inner join tbl_usuario_perfil as pe\n"
					+ "on u.id_usuario = pe.tbl_usuario_id_usuario\n"
					+ "inner join tbl_perfil as p\n"
					+ "on pe.tbl_perfil_id_perfil = p.id_perfil";
			Query query = em.createNativeQuery(jpql);
			lista = query.getResultList();

		return lista;
	}

}
