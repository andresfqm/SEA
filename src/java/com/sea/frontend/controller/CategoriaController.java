/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.frontend.controller;

import com.sea.backend.entities.Categoria;
import com.sea.backend.model.CategoriaFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author homero
 */
@Named
@ViewScoped
public class CategoriaController implements Serializable {

	@EJB
	private CategoriaFacadeLocal categoriaEJB;

	private Categoria categoria;

	private List<Categoria> ListaCategoria;

	private String accion;
	private String categori="";

	public List<Categoria> getListaCategoria() {
		ListaCategoria = categoriaEJB.findAll();
		return ListaCategoria;
	}

	public String getCategori() {
		return categori;
	}

	public void setCategori(String categori) {
		this.categori = categori;
	}
	
	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public void setListaCategoria(List<Categoria> ListaCategoria) {
		this.ListaCategoria = ListaCategoria;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@PostConstruct
	public void init() {
		categoria = new Categoria();
		ListaCategoria = categoriaEJB.findAll();
		categori = "";
	}

	public void registrar() {
		try {
			getAccion();
			categoriaEJB.create(categoria);
		} catch (Exception e) {
		}
	}

	public void eliminar(Categoria c) {
		try {
			categoriaEJB.remove(c);
		} catch (Exception e) {

		}
	}

	public void modificar() {
		try {
			getAccion();
			categoriaEJB.edit(categoria);
		} catch (Exception e) {

		}
		categoria.setNombre(categori);
	}
	
	public void limpiar() {

		categoria.setNombre(categori);
	}

	public void leerId(Categoria categoria) {
		this.categoria = categoria;
		setAccion("Modificar");
	}

}
