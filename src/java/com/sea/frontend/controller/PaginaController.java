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
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
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
		try {
			obtenerSubMenus();
			/*try {
			listaSubMenus = PaginaEJB.obtenerSubMenus(obtenerIdUsuario());
			} catch (Exception ex) {
			Logger.getLogger(PaginaController.class.getName()).log(Level.SEVERE, null, ex);
			}*/
		} catch (Exception ex) {
			Logger.getLogger(PaginaController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	//Obteniendo la sección enviada por parámetro
	/*public void obtenerSeccion(){
		FacesContext facesContext = FacesContext. getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		Map params = externalContext.getRequestParameterMap();
		seccion = (String) params.get("seccion" );
		//System.out.println((String) faceletContext.getAttribute("seccion"));
	}*/

	//Obteniendo todos los menús del usuario
	public void obtenerSubMenus() throws Exception {
		try {

			paginaEJB.create(pagina);
		} catch (Exception e) {

		}
		System.out.println(getSeccion());
	}

	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

}
