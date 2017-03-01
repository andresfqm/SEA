/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.frontend.controller;

import com.sea.backend.entities.Categoria;
import com.sea.backend.model.CategoriaFacadeLocal;
import com.sea.frontend.converters.Conversor;
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

	public List<Categoria> getListaCategoria() {
		ListaCategoria = categoriaEJB.findAll();
		return ListaCategoria;
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

	}

	public void registrar() {
		try {
			categoriaEJB.create(categoria);
		} catch (Exception e) {
		}
	}

	public void Eliminar(Categoria c) {
		try {
			categoriaEJB.remove(c);
		} catch (Exception e) {

		}
	}

	public void Modificar() {
		try {
			categoriaEJB.edit(categoria);
		} catch (Exception e) {

		}
	}

	public SelectItem[] getItemsAvailableSelectMany() {
		return Conversor.getSelectItems(categoriaEJB.findAll(), false);
	}

	public SelectItem[] getItemsAvailableSelectOne() {
		return Conversor.getSelectItems(categoriaEJB.findAll(), true);
	}

	public Categoria getCategoria(java.lang.Integer id) {
		return categoriaEJB.find(id);
	}

	@FacesConverter(forClass = Categoria.class)
	public static class CategoriaControllerConverter implements Converter {

		@Override
		public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
			if (value == null || value.length() == 0) {
				return null;
			}
			CategoriaController controller = (CategoriaController) facesContext.getApplication().getELResolver().
					getValue(facesContext.getELContext(), null, "categoriaController");
			return controller.getCategoria(getKey(value));
		}

		java.lang.Integer getKey(String value) {
			java.lang.Integer key;
			key = Integer.valueOf(value);
			return key;
		}

		String getStringKey(java.lang.Integer value) {
			StringBuilder sb = new StringBuilder();
			sb.append(value);
			return sb.toString();
		}

		@Override
		public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
			if (object == null) {
				return null;
			}
			if (object instanceof Categoria) {
				Categoria o = (Categoria) object;
				return getStringKey(o.getIdCategoria());
			} else {
				throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Categoria.class.getName());
			}
		}

	}

}
