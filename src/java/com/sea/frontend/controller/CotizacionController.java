/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.frontend.controller;

import com.sea.backend.entities.Ciudad;
import com.sea.backend.entities.Cliente;
import com.sea.backend.entities.Cotizacion;
import com.sea.backend.entities.Direccion;
import com.sea.backend.entities.Producto;
import com.sea.backend.model.CiudadFacadeLocal;
import com.sea.backend.model.ClienteFacadeLocal;
import com.sea.backend.model.CotizacionFacadeLocal;
import com.sea.backend.model.DescuentoVolumenFacadeLocal;
import com.sea.backend.model.DireccionFacadeLocal;
import com.sea.backend.model.LugaresEntregaFacadeLocal;
import com.sea.backend.model.ModalidadDePagoFacadeLocal;
import com.sea.backend.model.ProductoFacadeLocal;
import com.sea.backend.model.PropuestaNoIncluyeFacadeLocal;
import com.sea.backend.model.TiempoEntregaFacadeLocal;
import java.io.Serializable;
import java.util.Date;
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
public class CotizacionController implements Serializable {

	@EJB
	private CotizacionFacadeLocal cotizacionEJB;

	private Cotizacion cotizacion;

	public Cotizacion getCotizacion() {
		return cotizacion;
	}

	public void setCotizacion(Cotizacion cotizacion) {
		this.cotizacion = cotizacion;
	}

	@PostConstruct
	public void init() {

		cotizacion = new Cotizacion();
		cotizacion.setFechaEmision(new Date());
		clientes = clienteEJB.findAll();

	}

	//Ejb de las foraneas, ejb de Cliente
	@EJB
	private ClienteFacadeLocal clienteEJB;
	private List<Cliente> clientes;
	private int idCliente;

	//Ejb de las foraneas, ejb de ciudadEmision
	@EJB
	private CiudadFacadeLocal ciudadEJB;
	private int idCiudadEmision;

	//Ejb de la foranea PropuestaNoIncluye
	@EJB
	private PropuestaNoIncluyeFacadeLocal propuestaEJB;
	private int idPropuestaNoIncluye;

	//Ejb de la foranea TiempoEntrega
	@EJB
	private TiempoEntregaFacadeLocal tiempoEJB;
	private int idTiempoEntrega;

	//Ejb de la foranea DescuentoVolen
	@EJB
	private DescuentoVolumenFacadeLocal descuentoVEJB;
	private int idDescuentoVulumen;

	@EJB
	private ModalidadDePagoFacadeLocal modalidadPEJB;
	private int idModalidadPago;

	@EJB
	private LugaresEntregaFacadeLocal lugaresEEJB;
	private int idLugaresEntrega;

	public void setIdLugaresEntrega(int idLugaresEntrega) {
		this.idLugaresEntrega = idLugaresEntrega;
	}

	public int getIdModalidadPago() {
		return idModalidadPago;
	}

	public void setIdModalidadPago(int idModalidadPago) {
		this.idModalidadPago = idModalidadPago;
	}

	public int getIdDescuentoVulumen() {
		return idDescuentoVulumen;
	}

	public void setIdDescuentoVulumen(int idDescuentoVulumen) {
		this.idDescuentoVulumen = idDescuentoVulumen;
	}

	public int getIdTiempoEntrega() {
		return idTiempoEntrega;
	}

	public void setIdTiempoEntrega(int idTiempoEntrega) {
		this.idTiempoEntrega = idTiempoEntrega;
	}

	public int getIdPropuestaNoIncluye() {
		return idPropuestaNoIncluye;
	}

	public void setIdPropuestaNoIncluye(int idPropuestaNoIncluye) {
		this.idPropuestaNoIncluye = idPropuestaNoIncluye;
	}

	public int getIdCiudadEmision() {
		return idCiudadEmision;
	}

	public void setIdCiudadEmision(int idCiudadEmision) {
		this.idCiudadEmision = idCiudadEmision;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public void registrarCotización() {
		//Se carga los objetos de las clases correspondientes a las llaves foraneas
		cotizacion.setTblClienteIdCliente(clienteEJB.find(idCliente));
		cotizacion.setTblPropuestaNoIncluyeIdPropuestaNoIncluye(propuestaEJB.find(idPropuestaNoIncluye));
		cotizacion.setTblTiempoEntregaIdTiempoEntrega(tiempoEJB.find(idTiempoEntrega));
		cotizacion.setTblDescuentoVolumenIdDescuentoVolumen(descuentoVEJB.find(idDescuentoVulumen));
		cotizacion.setTblModalidadDePagoIdModalidadDePago(modalidadPEJB.find(idModalidadPago));
		cotizacion.setTblLugaresEntregaIdLugaresEntrega(lugaresEEJB.find(idLugaresEntrega));
		cotizacionEJB.create(cotizacion);

	}

}
