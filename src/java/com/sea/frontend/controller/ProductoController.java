/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.frontend.controller;

import com.sea.backend.entities.Direccion;
import com.sea.backend.entities.Fabricante;
import com.sea.backend.entities.Material;
import com.sea.backend.entities.Producto;
import com.sea.backend.model.DireccionFacadeLocal;
import com.sea.backend.model.FabricanteFacadeLocal;
import com.sea.backend.model.MaterialFacadeLocal;
import com.sea.backend.model.ProductoFacadeLocal;
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
public class ProductoController implements Serializable {

	@EJB
	private ProductoFacadeLocal productoEJB;
	@EJB
	private MaterialFacadeLocal materialEJB;
	@EJB
	private FabricanteFacadeLocal fabricanteEJB;
	private List<Producto> producto;
	private List<Material> listaMateriales;
	private List<Fabricante> listaFabricante;
	private List<Producto> listaProductoPrecio;
	private int idProducto;
	private int idFabricante;
	private int idMaterial;
	private Producto productoDescripcion;
	private int idCliente;
	String listString;
	private Fabricante descripcionFabricante;

	public List<Producto> getListaProductoPrecio() {
		return listaProductoPrecio;
	}

	}

	public void setListaProductoPrecio(List<Producto> listaProductoPrecio) {
		this.listaProductoPrecio = listaProductoPrecio;
	}

	
	
	public List<Fabricante> getListaFabricante() {
		return listaFabricante;
	}

	}

	public void setListaFabricante(List<Fabricante> listaFabricante) {
		this.listaFabricante = listaFabricante;
	}

	public Fabricante getDescripcionFabricante() {
		return descripcionFabricante;
	}

	}

	public void setDescripcionFabricante(Fabricante descripcionFabricante) {
		this.descripcionFabricante = descripcionFabricante;
	}

	public int getIdFabricante() {
		return idFabricante;
	}

	}

	public void setIdFabricante(int idFabricante) {
		this.idFabricante = idFabricante;
	}

	public int getIdMaterial() {
		return idMaterial;

	}

	public void setIdMaterial(int idMaterial) {
		this.idMaterial = idMaterial;
	}

	}

	public List<Producto> getProducto() {
		return producto;


	public void setProducto(List<Producto> producto) {
		this.producto = producto;

	}

	public int getIdProducto() {
		return idProducto;
	}
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;


	public List<Material> getListaMateriales() {
		return listaMateriales;

	}

	public void setListaMateriales(List<Material> listaMateriales) {
		this.listaMateriales = listaMateriales;



	private Material datosMaterial;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}


}
	public Material getDatosMaterial() {
		return datosMaterial;
