/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.frontend.controller;

import com.sea.backend.entities.Email;
import com.sea.backend.entities.Telefono;
import com.sea.backend.entities.Usuario;
import com.sea.backend.entities.UsuarioPerfil;
import com.sea.backend.model.EmailFacadeLocal;
import com.sea.backend.model.TelefonoFacadeLocal;
import com.sea.backend.model.UsuarioFacadeLocal;
import com.sea.backend.model.UsuarioPerfilFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author homero
 */
@Named
@ViewScoped
public class UsuarioController implements Serializable {

	@EJB
	private UsuarioFacadeLocal usuarioEJB;

	private Usuario usuario;
	private List<Usuario> listaUsuarios;
	private List<Usuario> lista;
	private String accion;
	private String limpieza = "";

	@EJB
	private TelefonoFacadeLocal telefonoEJB;

	private Telefono telefono;
	
	@EJB
	private EmailFacadeLocal correoEJB;
	private Email correo;
	
	@EJB
	private UsuarioPerfilFacadeLocal usuarioPerfilEJB;
	private UsuarioPerfil perfil;

	public Email getCorreo() {
		return correo;
	}

	public void setCorreo(Email correo) {
		this.correo = correo;
	}

	public UsuarioPerfil getPerfil() {
		return perfil;
	}

	public void setPerfil(UsuarioPerfil perfil) {
		this.perfil = perfil;
	}

	public String getLimpieza() {
		return limpieza;
	}

	public void setLimpieza(String limpieza) {
		this.limpieza = limpieza;
	}
	
	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public Telefono getTelefono() {
		return telefono;
	}

	public List<Usuario> getLista() {
		return lista;
	}

	public void setLista(List<Usuario> lista) {
		this.lista = lista;
	}

	public void setTelefono(Telefono telefono) {
		this.telefono = telefono;
	}

	public List<Usuario> getListaUsuarios() {
		listaUsuarios = usuarioEJB.findAll();
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@PostConstruct
	public void init() {
		usuario = new Usuario();
		telefono = new Telefono();
		correo = new Email();
		perfil = new UsuarioPerfil();
		lista = usuarioEJB.listaUsuario();
	}

	public void registrar() {
		try {
			getAccion();
			usuarioEJB.create(usuario);
			telefonoEJB.create(telefono);
			correoEJB.create(correo);
			usuarioPerfilEJB.create(perfil);
		} catch (Exception e) {

		}

	}
	public void modificar() {
		try {
			getAccion();
			usuarioEJB.edit(usuario);
		} catch (Exception e) {

		}

	}
	public void eliminar(Usuario usuario) {
		try {
			getAccion();
			usuarioEJB.remove(usuario);
		} catch (Exception e) {

		}

	}

	public void lista() {
			lista = usuarioEJB.listaUsuario();
	}

	public void leerID(Usuario usuario) {
		this.usuario = usuario;
		setAccion("Modificar");
	}
	
	public void limpiar() {
			usuario.setNumeroDocumento(limpieza);
			usuario.setNombre(limpieza);
			usuario.setApellido(limpieza);
			telefono.setNumeroTelefono(limpieza);
			
	}

}
