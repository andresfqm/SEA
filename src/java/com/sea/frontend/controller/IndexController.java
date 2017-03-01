/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.frontend.controller;

import com.sea.backend.entities.Usuario;
import com.sea.backend.model.UsuarioFacadeLocal;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 *
 * @author homero
 */
@Named
@ViewScoped
public class IndexController implements Serializable {

	@EJB
	private UsuarioFacadeLocal EJBUsuario;
	private Usuario usuario;

	@PostConstruct
	public void init() {
		usuario = new Usuario();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void iniciarSesion() {
		Usuario us;

		try {
			us = EJBUsuario.iniciarSesion(usuario);
			if (us != null) {
				//Almacenar la sesión de JSF
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", us);
				FacesContext contex = FacesContext.getCurrentInstance();
				contex.getExternalContext().redirect("/SEA/index.xhtml");

			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Usuario o contraseña incorrectos"));
			}

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!"));
		}

	}

	public String mostrarNombreUsuario() {
		HttpSession sesion = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		Usuario u = (Usuario) sesion.getAttribute("usuario");
		return u.getNombre() + " " + u.getApellido();
	}

	//Metodo para mostar el id Interno del usuario y el numero de cotizaci´´on correspondiente
	public String mostrarIdInterno() {
		HttpSession sesion = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		Usuario u = (Usuario) sesion.getAttribute("usuario");
		this.usuario = u;
		return u.getIdInterno();
	}

}
