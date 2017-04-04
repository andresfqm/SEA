/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.frontend.controller;

import com.sea.backend.entities.Pagina;
import com.sea.backend.entities.Usuario;
import com.sea.backend.model.PaginaFacadeLocal;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.faces.view.facelets.FaceletContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

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

	@PostConstruct
	public void init() {
		FaceletContext faceletContext = (FaceletContext) FacesContext.getCurrentInstance().getAttributes().get(FaceletContext.FACELET_CONTEXT_KEY);
		String seccionSubMenu = (String) faceletContext.getAttribute("seccion");
		try {
			listaSubMenus = PaginaEJB.obtenerSubMenus(obtenerIdUsuario());
		} catch (Exception ex) {
			Logger.getLogger(PaginaController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	//Obteniendo todos los menús del usuario
	public void obtenerMenusGenerales() throws Exception {
		FaceletContext faceletContext = (FaceletContext) FacesContext.getCurrentInstance().getAttributes().get(FaceletContext.FACELET_CONTEXT_KEY);
		String seccionSubMenu = (String) faceletContext.getAttribute("seccion");
		try {
			listaSubMenus = PaginaEJB.obtenerSubMenus(obtenerIdUsuario());
		} catch (Exception e) {
			throw e;
		}
	}

	public int obtenerIdUsuario() {
		HttpSession sesion = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		Usuario u = (Usuario) sesion.getAttribute("usuario");
		return u.getIdUsuario();
	}

	public List<Pagina> getListaSubMenus() {
		return listaSubMenus;
	}

	public void setListaSubMenus(List<Pagina> listaMenuGeneral) {
		this.listaSubMenus = listaMenuGeneral;
	}

}
