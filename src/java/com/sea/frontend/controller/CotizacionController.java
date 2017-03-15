/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.frontend.controller;

import com.sea.backend.entities.Ciudad;
import com.sea.backend.entities.Cliente;
import com.sea.backend.entities.Cotizacion;
import com.sea.backend.entities.CotizacionProducto;
import com.sea.backend.entities.Direccion;
import com.sea.backend.entities.Producto;
import com.sea.backend.model.CiudadFacadeLocal;
import com.sea.backend.model.ClienteFacadeLocal;
import com.sea.backend.model.CotizacionFacadeLocal;
import com.sea.backend.model.CotizacionProductoFacadeLocal;
import com.sea.backend.model.DescuentoVolumenFacadeLocal;
import com.sea.backend.model.DireccionFacadeLocal;
import com.sea.backend.model.LugaresEntregaFacadeLocal;
import com.sea.backend.model.ModalidadDePagoFacadeLocal;
import com.sea.backend.model.ProductoFacadeLocal;
import com.sea.backend.model.PropuestaNoIncluyeFacadeLocal;
import com.sea.backend.model.TiempoEntregaFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
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

	//EJB cotización
	@EJB
	private CotizacionFacadeLocal cotizacionEJB;
	private Cotizacion cotizacion;
	
	//EJB cliente
	@EJB
	private ClienteFacadeLocal clienteEJB;
	private Cliente cliente;
	private List<Cliente> listaClientes;
	private Object datosCliente;
	private int idCliente;
	private List<Cliente> clientes;
  
	
	//EJB CotizaciónProducto
	@EJB
	private CotizacionProductoFacadeLocal cotizacionProductoEJB;
	private CotizacionProducto cotizacionProducto;
	private List<CotizacionProducto> listaCotizacionP;
	private int cantidad;
	private double precioParaCliente;
	
	//Ejb de las foraneas, ejb de ciudadEmision
	@EJB
	private CiudadFacadeLocal ciudadEJB;
	private Ciudad ciudad;
	private List<Ciudad> ciudades;
	
	//EJB Propuesta no incluye
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
	
	//EJB Modalidades de pago
	@EJB
	private ModalidadDePagoFacadeLocal modalidadPEJB;
	private int idModalidadPago;

	//EJB Lugares de entrega
	@EJB
	private LugaresEntregaFacadeLocal lugaresEEJB;
	private int idLugaresEntrega;
	
	@EJB
	private ProductoFacadeLocal productoEJB;
	//Entidad producto
	private Producto producto;
	private int idProducto;
	
	@PostConstruct
	public void init() {

		cotizacion = new Cotizacion();
		cotizacion.setFechaEmision(new Date());
		clientes = clienteEJB.findAll();
		cliente = new Cliente();
		producto = new Producto();
		listaCotizacionP = new ArrayList<>();
		

	}

	//Obteniendo todos los datos del cliente
	public void obtenerDatosCliente() throws Exception {
		try {

			datosCliente = clienteEJB.datosCliente(idCliente);
		} catch (Exception e) {
			throw e;
		}
	}


	public void AgregarCotizacionProducto() {
		CotizacionProducto cot = new CotizacionProducto();

		cot.setProducto(producto);
		cot.setCantidad(cantidad);
		cot.setPrecioParaCliente(precioParaCliente);
		//  ven.setTblProductoIdProducto(productoEJB.find(producto.getIdProducto()));
		cot.setProducto(productoEJB.find(getIdProducto()));
		listaCotizacionP.add(cot);
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

	public Cotizacion getCotizacion() {
		return cotizacion;
	}

	public void setCotizacion(Cotizacion cotizacion) {
		this.cotizacion = cotizacion;
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}



	public Object getDatosCliente() {
		return datosCliente;
	}

	public void setDatosCliente(Object datosCliente) {
		this.datosCliente = datosCliente;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public CotizacionProducto getCotizacionProducto() {
		return cotizacionProducto;
	}

	public void setCotizacionProducto(CotizacionProducto cotizacionProducto) {
		this.cotizacionProducto = cotizacionProducto;
	}

	public List<CotizacionProducto> getListaCotizacionP() {
		return listaCotizacionP;
	}

	public void setListaCotizacionP(List<CotizacionProducto> listaCotizacionP) {
		this.listaCotizacionP = listaCotizacionP;
	}

	public CiudadFacadeLocal getCiudadEJB() {
		return ciudadEJB;
	}

	public void setCiudadEJB(CiudadFacadeLocal ciudadEJB) {
		this.ciudadEJB = ciudadEJB;
	}

	public int getIdPropuestaNoIncluye() {
		return idPropuestaNoIncluye;
	}

	public void setIdPropuestaNoIncluye(int idPropuestaNoIncluye) {
		this.idPropuestaNoIncluye = idPropuestaNoIncluye;
	}

	public int getIdTiempoEntrega() {
		return idTiempoEntrega;
	}

	public void setIdTiempoEntrega(int idTiempoEntrega) {
		this.idTiempoEntrega = idTiempoEntrega;
	}

	public int getIdDescuentoVulumen() {
		return idDescuentoVulumen;
	}

	public void setIdDescuentoVulumen(int idDescuentoVulumen) {
		this.idDescuentoVulumen = idDescuentoVulumen;
	}

	public int getIdModalidadPago() {
		return idModalidadPago;
	}

	public void setIdModalidadPago(int idModalidadPago) {
		this.idModalidadPago = idModalidadPago;
	}

	public int getIdLugaresEntrega() {
		return idLugaresEntrega;
	}

	public void setIdLugaresEntrega(int idLugaresEntrega) {
		this.idLugaresEntrega = idLugaresEntrega;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecioParaCliente() {
		return precioParaCliente;
	}

	public void setPrecioParaCliente(double precioParaCliente) {
		this.precioParaCliente = precioParaCliente;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public List<Ciudad> getCiudades() {
		return ciudades;
	}

	public void setCiudades(List<Ciudad> ciudades) {
		this.ciudades = ciudades;
	}
	
	 public Object getCliente() {
        return datosCliente;
    }

    public void setCliente(Object cliente) {
        this.datosCliente = cliente;
    }
	

 

	
}
