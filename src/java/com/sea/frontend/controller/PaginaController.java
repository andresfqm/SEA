/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.frontend.controller;

import com.sea.backend.entities.Pagina;
import com.sea.backend.model.PaginaFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author homero
 */
@Named
@ViewScoped
public class PaginaController implements Serializable {

	@EJB
	private PaginaFacadeLocal PaginaEJB;
	private List<Pagina> listaSubMenus;
	private String seccion;

	@PostConstruct
	public void init() {
	}

	//Obteniendo todos los menús del usuario
	public void obtenerSubMenus(String seccion) throws Exception {
		try {
			listaSubMenus = PaginaEJB.obtenerSubMenus(obtenerIdUsuario(), seccion);
		} catch (Exception e) {

		}
	}

	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}
}
