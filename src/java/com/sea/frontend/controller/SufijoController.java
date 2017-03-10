/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.frontend.controller;

import com.sea.backend.entities.Sufijo;
import com.sea.backend.model.SufijoFacadeLocal;
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
public class SufijoController implements Serializable {

	@EJB
	private SufijoFacadeLocal sufijoEJB;
	private Sufijo sufijo;
	private List<Sufijo> listaSufijos;
	private String accion;
	private String subcat="";

	public SufijoFacadeLocal getSufijoEJB() {
		return sufijoEJB;
	}

	public void setSufijoEJB(SufijoFacadeLocal sufijoEJB) {
		this.sufijoEJB = sufijoEJB;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public List<Sufijo> getListaSufijos() {
		listaSufijos = sufijoEJB.findAll();
		return listaSufijos;
	}

	public void setListaSufijos(List<Sufijo> listaSufijos) {
		this.listaSufijos = listaSufijos;
	}

	public Sufijo getSufijo() {
		return sufijo;
	}

	public void setSufijo(Sufijo sufijo) {
		this.sufijo = sufijo;
	}

	@PostConstruct
	public void init() {
		sufijo = new Sufijo();

	}

	public void registrar() {
		try {
			getAccion();
			sufijoEJB.create(sufijo);
		} catch (Exception e) {
		}
	}

	public void eliminar(Sufijo sufijo) {
		try {
			sufijoEJB.remove(sufijo);
		} catch (Exception e) {

		}
	}

	public void modificar() {
		try {
			getAccion();
			sufijoEJB.edit(sufijo);
		} catch (Exception e) {

		}
		sufijo.setCodigo(subcat);
		sufijo.setDescripcionFabricante(subcat);
	}
	
	public void limpiar() {

		sufijo.setCodigo(subcat);
		sufijo.setDescripcionFabricante(subcat);
	}

	public void leerId(Sufijo sufijo) {
		this.sufijo = sufijo;
		setAccion("Modificar");
	}

}
