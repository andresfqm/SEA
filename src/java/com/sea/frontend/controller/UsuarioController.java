/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.frontend.controller;

import com.sea.backend.entities.Direccion;
import com.sea.backend.entities.Email;
import com.sea.backend.entities.Perfil;
import com.sea.backend.entities.Telefono;
import com.sea.backend.entities.TipoDireccion;
import com.sea.backend.entities.TipoDocumento;
import com.sea.backend.entities.TipoEmail;
import com.sea.backend.entities.TipoTelefono;
import com.sea.backend.entities.Usuario;
import com.sea.backend.entities.UsuarioPerfil;
import com.sea.backend.model.DireccionFacadeLocal;
import com.sea.backend.model.EmailFacadeLocal;
import com.sea.backend.model.PerfilFacadeLocal;
import com.sea.backend.model.TelefonoFacadeLocal;
import com.sea.backend.model.TipoDireccionFacadeLocal;
import com.sea.backend.model.TipoDocumentoFacadeLocal;
import com.sea.backend.model.TipoEmailFacadeLocal;
import com.sea.backend.model.TipoTelefonoFacadeLocal;
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
	private TipoTelefonoFacadeLocal tipoTelefonoEJB;
	private TipoTelefono tipoTelefono;

	@EJB
	private TipoEmailFacadeLocal tipoEmailEJB;
	private TipoEmail tipoEmail;

	@EJB
	private TipoDireccionFacadeLocal tipoDireccionEJB;
	private TipoDireccion tipoDireccion;

	@EJB
	private EmailFacadeLocal correoEJB;
	private Email correo;

	@EJB
	private UsuarioPerfilFacadeLocal usuarioPerfilEJB;
	private UsuarioPerfil perfil;

	@EJB
	private PerfilFacadeLocal perfilEJB;
	private Perfil perfilt;

	@EJB
	private DireccionFacadeLocal direccionEJB;
	private Direccion direccion;

	@EJB
	private TipoDocumentoFacadeLocal tipoDocumentoEJB;
	private TipoDocumento tipoDocumento;

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
		perfilt = new Perfil();
		lista = usuarioEJB.listaUsuario();
		direccion = new Direccion();
		tipoTelefono = new TipoTelefono();
		tipoDireccion = new TipoDireccion();
		tipoEmail = new TipoEmail();
		tipoDocumento = new TipoDocumento();
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public TipoTelefono getTipoTelefono() {
		return tipoTelefono;
	}

	public void setTipoTelefono(TipoTelefono tipoTelefono) {
		this.tipoTelefono = tipoTelefono;
	}

	public TipoEmail getTipoEmail() {
		return tipoEmail;
	}

	public void setTipoEmail(TipoEmail tipoEmail) {
		this.tipoEmail = tipoEmail;
	}

	public TipoDireccion getTipoDireccion() {
		return tipoDireccion;
	}

	public void setTipoDireccion(TipoDireccion tipoDireccion) {
		this.tipoDireccion = tipoDireccion;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Perfil getPerfilt() {
		return perfilt;
	}

	public void setPerfilt(Perfil perfilt) {
		this.perfilt = perfilt;
	}

	public void registrar() {
		try {
			usuario.setTblTipoDocumentoIdTipoDocumento(tipoDocumentoEJB.find(tipoDocumento.getIdTipoDocumento()));
			usuarioEJB.create(usuario);
			telefono.setTblTipoTelefonoIdTipoTelefono(tipoTelefonoEJB.find(tipoTelefono.getIdTipoTelefono()));
			telefono.setTblUsuarioIdUsuario(usuarioEJB.find(usuario.getIdUsuario()));
			telefonoEJB.create(telefono);
			correo.setTblTipoEmailIdTipoEmail(tipoEmailEJB.find(tipoEmail.getIdTipoEmail()));
			correo.setTblUsuarioIdUsuario(usuarioEJB.find(usuario.getIdUsuario()));
			correoEJB.create(correo);
			perfil.setTblPerfilIdPerfil(perfilEJB.find(perfilt.getIdPerfil()));
			perfil.setTblUsuarioIdUsuario(usuarioEJB.find(usuario.getIdUsuario()));
			usuarioPerfilEJB.create(perfil);
			direccion.setTblTipoDireccionIdTipoDireccion(tipoDireccionEJB.find(tipoDireccion.getIdTipoDireccion()));
			direccion.setTblUsuarioIdUsuario(usuarioEJB.find(usuario.getIdUsuario()));
			direccionEJB.create(direccion);
		} catch (Exception e) {

		}
		lista = usuarioEJB.listaUsuario();
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
