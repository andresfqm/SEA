/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.frontend.controller;

import com.sea.backend.entities.Subcategoria;
import com.sea.backend.model.CategoriaFacade;
import com.sea.backend.model.SubcategoriaFacade;
import com.sea.backend.model.SubcategoriaFacadeLocal;
import com.sea.frontend.converters.Conversor;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;

/**
 *
 * @author homero
 */
@Named
@ViewScoped
public class SubcategoriaController implements Serializable {

	@EJB
	private SubcategoriaFacadeLocal SubcategoriaEJB;
	private Subcategoria subcategoria;
	private List<Subcategoria> listaSubcategoria;

	public List<Subcategoria> getListaSubcategoria() {
		listaSubcategoria = SubcategoriaEJB.findAll();
		return listaSubcategoria;
	}

	public void setListaSubcategoria(List<Subcategoria> listaSubcategoria) {
		this.listaSubcategoria = listaSubcategoria;
	}

	public Subcategoria getSubcategoria() {
		return subcategoria;
	}

	public void setSubcategoria(Subcategoria subcategoria) {
		this.subcategoria = subcategoria;
	}

	@PostConstruct
	public void init() {
		subcategoria = new Subcategoria();

	}

	public String registrar() {
		try {
			SubcategoriaEJB.create(subcategoria);
			return ("Categoria creada");
		} catch (Exception e) {
			return ("PersistenceErrorOccured");
		}
	}

	public SelectItem[] getItemsAvailableSelectOne() {
		return Conversor.getSelectItems(SubcategoriaEJB.findAll(), true);
	}

	public Subcategoria getSubcategoria(java.lang.Integer id) {
		return SubcategoriaEJB.find(id);
	}

}
