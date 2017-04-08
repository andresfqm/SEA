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
import com.sea.backend.entities.CotizacionProductoPK;
import com.sea.backend.entities.DescuentoVolumen;
import com.sea.backend.entities.Fabricante;
import com.sea.backend.entities.LugaresEntrega;
import com.sea.backend.entities.Material;
import com.sea.backend.entities.ModalidadDePago;
import com.sea.backend.entities.Producto;
import com.sea.backend.entities.ProductoEspecificacion;
import com.sea.backend.entities.ProductoEspecificacionTalla;
import com.sea.backend.entities.PropuestaNoIncluye;
import com.sea.backend.entities.Talla;
import com.sea.backend.entities.TiempoEntrega;
import com.sea.backend.entities.Usuario;
import com.sea.backend.model.CiudadFacadeLocal;
import com.sea.backend.model.ClienteFacadeLocal;
import com.sea.backend.model.CotizacionFacadeLocal;
import com.sea.backend.model.CotizacionProductoFacadeLocal;
import com.sea.backend.model.DescuentoFacadeLocal;
import com.sea.backend.model.DescuentoVolumenFacadeLocal;
import com.sea.backend.model.DireccionFacadeLocal;
import com.sea.backend.model.FabricanteFacadeLocal;
import com.sea.backend.model.LugaresEntregaFacadeLocal;
import com.sea.backend.model.MaterialFacadeLocal;
import com.sea.backend.model.ModalidadDePagoFacadeLocal;
import com.sea.backend.model.ProductoEspecificacionFacade;
import com.sea.backend.model.ProductoEspecificacionFacadeLocal;
import com.sea.backend.model.ProductoEspecificacionTallaFacade;
import com.sea.backend.model.ProductoFacadeLocal;
import com.sea.backend.model.PropuestaNoIncluyeFacadeLocal;
import com.sea.backend.model.TallaFacadeLocal;
import com.sea.backend.model.TiempoEntregaFacadeLocal;
import com.sea.backend.model.UsuarioFacadeLocal;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

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
	private String numeroCotizacion;
	private Double descuentoCotizacion;
	private List<Cotizacion> listaSeguimientoCotizacions;
	private List<Cotizacion> listaCotizacionesOrdenProduccion;
	private Object datosCotizacion;

	@EJB
	private UsuarioFacadeLocal EJBUsuario;
	private Usuario usuario;

	//EJB cliente
	@EJB
	private ClienteFacadeLocal clienteEJB;
	private Cliente cliente;
	private List<Cliente> listaClientes;
	private Object datosCliente;
	private int idCliente;
	private int idModalidad;
	private List<Cliente> clientes;

	//EJB Producto Especificación
	@EJB
	private ProductoEspecificacionFacadeLocal productoEsEJB;
	private ProductoEspecificacion productoEspecificacion;

	//EJB CotizaciónProducto
	@EJB
	private CotizacionProductoFacadeLocal cotizacionProductoEJB;
	private CotizacionProducto cotizacionProducto;
	private List<CotizacionProducto> listaCotizacionP;
	private Object datosCotizacionProducto;
	private List<CotizacionProducto> listaProductosCotizados;

	private int cantidad;
	private Float precioParaCliente;
	private double precioDescuento;

	// EJB de tallas
	@EJB
	private TallaFacadeLocal tallaEJB;
	private Talla talla;
	private List<Talla> listaTallas;
	private int idTalla;

	@EJB
	private CotizacionProductoFacadeLocal cotizacionpEJB;
	private CotizacionProducto cotizacionP;

	@EJB
	private MaterialFacadeLocal materialEJB;
	@EJB
	private FabricanteFacadeLocal fabricanteEJB;

	//Ejb de las foraneas, ejb de ciudadEmision
	@EJB
	private CiudadFacadeLocal ciudadEJB;
	private Ciudad ciudad;
	private List<Ciudad> ciudades;

	//EJB Propuesta no incluye
	@EJB
	private PropuestaNoIncluyeFacadeLocal propuestaEJB;
	private List<PropuestaNoIncluye> ListapropuestaNoIncluye;
	private int idPropuestaNoIncluye;
	private PropuestaNoIncluye propuestaNoIncluye;

	//EJB Producto Especificación talla
	private ProductoEspecificacionTallaFacade productoETEJB;
	private ProductoEspecificacionTalla productoEspecificacionTalla;

	//Variable para almacenar el campo diseño de generar orden producción
	private String diseño;

	//Ejb de la foranea TiempoEntrega
	@EJB
	private TiempoEntregaFacadeLocal tiempoEJB;
	private int idTiempoEntrega;
	private TiempoEntrega tiempoEntrega;
	private List<TiempoEntrega> listaTiempoEntrega;

	//Ejb de la foranea DescuentoVolen
	@EJB
	private DescuentoVolumenFacadeLocal descuentoVEJB;
	private int idDescuentoVolumen;
	private DescuentoVolumen descuentoVolumen;
	private List<DescuentoVolumen> listaDescuentoVolumen;

	//EJB Modalidades de pago
	@EJB
	private ModalidadDePagoFacadeLocal modalidadPEJB;
	private int idModalidadDePago;
	private List<ModalidadDePago> listaModalidadDePago;
	private ModalidadDePago modalidadDePago;

	//EJB Lugares de entrega
	@EJB
	private LugaresEntregaFacadeLocal lugaresEEJB;
	private int idLugaresEntrega;
	private LugaresEntrega lugaresEntrega;
	private List<LugaresEntrega> listaLugaresEntrega;

	//EJB producto
	@EJB
	private ProductoFacadeLocal productoEJB;
	private Producto producto;
	private int idProducto;
	private List<Material> listaMateriales;
	private List<Fabricante> listaFabricante;
	private List<Producto> listaProductoPrecio;
	private List<Producto> listaProducto;

	//EJB descuento
	@EJB
	private DescuentoFacadeLocal descuentoEJB;
	private int idDescuento;

	//Cargue de archivos- Logo tipo - diagrama de diseño
	private Part diagrama_diseño;
	private Part logotipo;
	private String diagramaDiseño;
	private String logotipoP;
	private String pathReal;

	@PostConstruct
	public void init() {

		cotizacion = new Cotizacion();
		cotizacion.setFechaEmision(new Date());
		cotizacion.setValidezOferta(60);
		cotizacion.setDescuento(15);
		cotizacion.setIva(19);
		listaCotizacionesOrdenProduccion = cotizacionEJB.findAll();
		cotizacionP = new CotizacionProducto();
		cotizacionProducto = new CotizacionProducto();
		clientes = clienteEJB.findAll();
		cliente = new Cliente();
		productoEspecificacion = new ProductoEspecificacion();
		producto = new Producto();
		talla = new Talla();
		listaTallas = tallaEJB.findAll();
		listaCotizacionP = new ArrayList<>();
		listaProducto = productoEJB.findAll();
		usuario = new Usuario();
		lugaresEntrega = new LugaresEntrega();
		tiempoEntrega = new TiempoEntrega();
		descuentoVolumen = new DescuentoVolumen();
		ListapropuestaNoIncluye = propuestaEJB.findAll();
		listaTiempoEntrega = tiempoEJB.findAll();
		listaLugaresEntrega = lugaresEEJB.findAll();
		listaDescuentoVolumen = descuentoVEJB.findAll();
		listaModalidadDePago = modalidadPEJB.findAll();
		listaSeguimientoCotizacions = cotizacionEJB.listaSeguimiento(idUsuario());
		propuestaNoIncluye = new PropuestaNoIncluye();
		productoEspecificacionTalla = new ProductoEspecificacionTalla();

	}

	//Obteniendo todos los datos del cliente
	public void obtenerDatosCliente() throws Exception {
		try {

			datosCliente = clienteEJB.datosCliente(idCliente);
		} catch (Exception e) {
			throw e;
		}
	}

	public void agregarCotizacionProducto() {
		CotizacionProducto cot = new CotizacionProducto();

		cot.setProducto(producto);
		cot.setCantidad(cotizacionP.getCantidad());
		cot.setPrecioParaCliente(cotizacionP.getPrecioParaCliente());

		//  ven.setTblProductoIdProducto(productoEJB.find(producto.getIdProducto()));
		listaCotizacionP.add(cot);

	}

	//Metodo para calcular el precio del producto seleccionado
	public Double calcularPrecioProductoDescuento() {
		return this.listaProductoPrecio.get(0).getPrecio() - (this.listaProductoPrecio.get(0).getPrecio() * this.descuentoCotizacion);

	}

	public void obtenerDescripcionReferencia() throws Exception {
		try {

			producto = productoEJB.productoDescripcion(producto.getIdProducto());
			listaMateriales = materialEJB.datosMaterial(producto.getIdProducto());
			listaFabricante = fabricanteEJB.descripcionFabricante(producto.getIdProducto());
			listaProductoPrecio = productoEJB.productoPrecio(producto.getIdProducto());
		} catch (Exception e) {
			throw e;
		}

	}

	// Metodo para traer los productos registrados en una cotización
	public void obtenerProductosRegistrados() throws Exception {
		try {
			listaProductosCotizados = cotizacionProductoEJB.datosCotizacionProducto(numeroCotizacion);

		} catch (Exception e) {
		}
	}

	// Metodo para obtener las cotizaciones registradas por un asesor
	public void obtenerCotizacionesRegistradas() throws Exception {
		try {
			listaSeguimientoCotizacions = cotizacionEJB.listaSeguimiento(idUsuario());

		} catch (Exception e) {
		}
	}

	// Metodo para obtener las cotizaciones registradas para generar ordenes de producción
	public void obtenerDatosRegistroOrdenProduccion() throws Exception {
		try {
			datosCotizacion = cotizacionEJB.datosCotizacion(cotizacion.getNumeroCotizacion());
		} catch (Exception e) {
		}
	}

	public int idUsuario() {
		HttpSession sesion = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		Usuario u = (Usuario) sesion.getAttribute("usuario");
		return u.getIdUsuario();
	}

	//Forma de generar el id de la cotización
	public String generarIdCotizacion() {
		HttpSession sesion = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		Usuario u = (Usuario) sesion.getAttribute("usuario");
		this.usuario = u;
		return u.getIdInterno() + u.getConsecutivoCotizacion();
	}

	//Metodo para cargar diagrama-logotipo
	public void upload() {

		String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("Archivos");
		path = path.substring(0, path.indexOf("\\build"));
		path = path + "\\web\\Archivos\\";
		try {
			this.diagramaDiseño = diagrama_diseño.getSubmittedFileName();
			pathReal = "/UploadFile/Archivos/" + diagramaDiseño;
			path = path + this.diagramaDiseño;
			InputStream in = diagrama_diseño.getInputStream();

			byte[] data = new byte[in.available()];
			in.read(data);
			FileOutputStream out = new FileOutputStream(new File(path));
			out.write(data);
			in.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		try {
			this.logotipoP = logotipo.getSubmittedFileName();
			pathReal = "/UploadFile/Archivos/" + logotipoP;
			path = path + this.logotipoP;
			InputStream in2 = logotipo.getInputStream();

			byte[] data2 = new byte[in2.available()];
			in2.read(data2);
			FileOutputStream out2 = new FileOutputStream(new File(path));
			out2.write(data2);
			in2.close();
			out2.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

	public void registrarCotización() {

		try {
			cotizacion.setNumeroCotizacion(generarIdCotizacion());
			cotizacion.setFechaEmision(cotizacion.getFechaEmision());
			cotizacion.setLugarEmision(cotizacion.getLugarEmision());
			cotizacion.setValidezOferta(cotizacion.getValidezOferta());
			cotizacion.setDescuento(cotizacion.getDescuento());
			cotizacion.setVisita(cotizacion.getVisita());
			cotizacion.setPrestamoMuestra(cotizacion.getPrestamoMuestra());
			cotizacion.setRelacionMuestra(cotizacion.getRelacionMuestra());
			cotizacion.setEstado("En seguimiento");
			//Se carga los objetos de las clases correspondientes a las llaves foraneas
			cotizacion.setTblClienteIdCliente(clienteEJB.find(idCliente));
			cotizacion.setTblModalidadDePagoIdModalidadDePago(modalidadPEJB.find(idModalidadDePago));
			cotizacion.setTblPropuestaNoIncluyeIdPropuestaNoIncluye(propuestaEJB.find(idPropuestaNoIncluye));
			cotizacion.setTblTiempoEntregaIdTiempoEntrega(tiempoEJB.find(idTiempoEntrega));
			cotizacion.setTblDescuentoVolumenIdDescuentoVolumen(descuentoVEJB.find(idDescuentoVolumen));
			cotizacion.setTblLugaresEntregaIdLugaresEntrega(lugaresEEJB.find(idLugaresEntrega));
			cotizacionEJB.create(cotizacion);
			for (CotizacionProducto itemVenta : listaCotizacionP) {
				CotizacionProductoPK cotizacionP = new CotizacionProductoPK();
				cotizacionP.setTblCotizacionNumeroCotizacion(cotizacion.getNumeroCotizacion());
				cotizacionP.setTblProductoIdProducto(producto.getIdProducto());
				itemVenta.setCotizacionProductoPK(cotizacionP);
				itemVenta.setPrecioParaCliente(this.cotizacionP.getPrecioParaCliente());
				itemVenta.setPrecioBase(producto.getPrecio());
				itemVenta.setCantidad(this.cotizacionP.getCantidad());
				cotizacionProductoEJB.create(itemVenta);
			}
		} catch (Exception e) {
		}

	}

	public void modificarCotización() {
		try {
			cotizacionEJB.edit(cotizacion);
		} catch (Exception e) {
		}

	}

	public String leerId(Cotizacion cotizacion) {
		this.cotizacion = cotizacionEJB.find(cotizacion.getNumeroCotizacion());
		return "actualizarCotizacion";

	}

	public PropuestaNoIncluye getPropuestaNoIncluye() {
		return propuestaNoIncluye;
	}

	public void setPropuestaNoIncluye(PropuestaNoIncluye propuestaNoIncluye) {
		this.propuestaNoIncluye = propuestaNoIncluye;
	}

	public TiempoEntrega getTiempoEntrega() {
		return tiempoEntrega;
	}

	public void setTiempoEntrega(TiempoEntrega tiempoEntrega) {
		this.tiempoEntrega = tiempoEntrega;
	}

	public DescuentoVolumen getDescuentoVolumen() {
		return descuentoVolumen;
	}

	public void setDescuentoVolumen(DescuentoVolumen descuentoVolumen) {
		this.descuentoVolumen = descuentoVolumen;
	}

	public LugaresEntrega getLugaresEntrega() {
		return lugaresEntrega;
	}

	public void setLugaresEntrega(LugaresEntrega lugaresEntrega) {
		this.lugaresEntrega = lugaresEntrega;
	}

	public int getIdModalidad() {
		return idModalidad;
	}

	public void setIdModalidad(int idModalidad) {
		this.idModalidad = idModalidad;
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

	public List<TiempoEntrega> getListaTiempoEntrega() {
		return listaTiempoEntrega;
	}

	public void setListaTiempoEntrega(List<TiempoEntrega> listaTiempoEntrega) {
		this.listaTiempoEntrega = listaTiempoEntrega;
	}

	public List<DescuentoVolumen> getListaDescuentoVolumen() {
		return listaDescuentoVolumen;
	}

	public void setListaDescuentoVolumen(List<DescuentoVolumen> listaDescuentoVolumen) {
		this.listaDescuentoVolumen = listaDescuentoVolumen;
	}

	public List<ModalidadDePago> getListaModalidadDePago() {
		return listaModalidadDePago;
	}

	public void setListaModalidadDePago(List<ModalidadDePago> listaModalidadDePago) {
		this.listaModalidadDePago = listaModalidadDePago;
	}

	public List<LugaresEntrega> getListaLugaresEntrega() {
		return listaLugaresEntrega;
	}

	public void setListaLugaresEntrega(List<LugaresEntrega> listaLugaresEntrega) {
		this.listaLugaresEntrega = listaLugaresEntrega;
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

	public int getIdDescuentoVolumen() {
		return idDescuentoVolumen;
	}

	public void setIdDescuentoVolumen(int idDescuentoVolumen) {
		this.idDescuentoVolumen = idDescuentoVolumen;
	}

	public int getIdModalidadDePago() {
		return idModalidadDePago;
	}

	public void setIdModalidadDePago(int idModalidadDePago) {
		this.idModalidadDePago = idModalidadDePago;
	}

	public ModalidadDePago getModalidadDePago() {
		return modalidadDePago;
	}

	public void setModalidadDePago(ModalidadDePago modalidadDePago) {
		this.modalidadDePago = modalidadDePago;
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

	public int getIdDescuento() {
		return idDescuento;
	}

	public void setIdDescuento(int idDescuento) {
		this.idDescuento = idDescuento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Float getPrecioParaCliente() {
		return precioParaCliente;
	}

	public void setPrecioParaCliente(Float precioParaCliente) {
		this.precioParaCliente = precioParaCliente;
	}

	public Object getDatosCotizacion() {
		return datosCotizacion;
	}

	public void setDatosCotizacion(Object datosCotizacion) {
		this.datosCotizacion = datosCotizacion;
	}

	public List<Material> getListaMateriales() {
		return listaMateriales;
	}

	public void setListaMateriales(List<Material> listaMateriales) {
		this.listaMateriales = listaMateriales;
	}

	public List<Fabricante> getListaFabricante() {
		return listaFabricante;
	}

	public void setListaFabricante(List<Fabricante> listaFabricante) {
		this.listaFabricante = listaFabricante;
	}

	public List<Producto> getListaProductoPrecio() {
		return listaProductoPrecio;
	}

	public void setListaProductoPrecio(List<Producto> listaProductoPrecio) {
		this.listaProductoPrecio = listaProductoPrecio;
	}

	public CotizacionProducto getCotizacionP() {
		return cotizacionP;
	}

	public void setCotizacionP(CotizacionProducto cotizacionP) {
		this.cotizacionP = cotizacionP;
	}

	public List<Producto> getListaProducto() {
		return listaProducto;
	}

	public void setListaProducto(List<Producto> listaProducto) {
		this.listaProducto = listaProducto;
	}

	public double getPrecioDescuento() {
		return precioDescuento;
	}

	public void setPrecioDescuento(double precioDescuento) {
		this.precioDescuento = calcularPrecioProductoDescuento();
	}

	public Double getDescuentoCotizacion() {
		return descuentoCotizacion;
	}

	public void setDescuentoCotizacion(Double descuentoCotizacion) {
		this.descuentoCotizacion = descuentoCotizacion;
	}

	public List<Cotizacion> getListaSeguimientoCotizacions() {
		return listaSeguimientoCotizacions;
	}

	public void setListaSeguimientoCotizacions(List<Cotizacion> listaSeguimientoCotizacions) {
		this.listaSeguimientoCotizacions = listaSeguimientoCotizacions;
	}

	public List<Cotizacion> getListaCotizacionesOrdenProduccion() {
		return listaCotizacionesOrdenProduccion;
	}

	public void setListaCotizacionesOrdenProduccion(List<Cotizacion> listaCotizacionesOrdenProduccion) {
		this.listaCotizacionesOrdenProduccion = listaCotizacionesOrdenProduccion;
	}

	public String getNumeroCotizacion() {
		return numeroCotizacion;
	}

	public void setNumeroCotizacion(String numeroCotizacion) {
		this.numeroCotizacion = numeroCotizacion;
	}

	public Part getDiagrama_diseño() {
		return diagrama_diseño;
	}

	public void setDiagrama_diseño(Part diagrama_diseño) {
		this.diagrama_diseño = diagrama_diseño;
	}

	public String getDiagramaDiseño() {
		return diagramaDiseño;
	}

	public void setDiagramaDiseño(String diagramaDiseño) {
		this.diagramaDiseño = diagramaDiseño;
	}

	public String getPathReal() {
		return pathReal;
	}

	public void setPathReal(String pathReal) {
		this.pathReal = pathReal;
	}

	public Part getLogotipo() {
		return logotipo;
	}

	public void setLogotipo(Part logotipo) {
		this.logotipo = logotipo;
	}

	public String getLogotipoP() {
		return logotipoP;
	}

	public void setLogotipoP(String logotipoP) {
		this.logotipoP = logotipoP;
	}

	public ProductoEspecificacion getProductoEspecificacion() {
		return productoEspecificacion;
	}

	public void setProductoEspecificacion(ProductoEspecificacion productoEspecificacion) {
		this.productoEspecificacion = productoEspecificacion;
	}

	public String getDiseño() {
		return diseño;
	}

	public void setDiseño(String diseño) {
		this.diseño = diseño;
	}

	public Talla getTalla() {
		return talla;
	}

	public void setTalla(Talla talla) {
		this.talla = talla;
	}

	public List<Talla> getListaTallas() {
		return listaTallas;
	}

	public void setListaTallas(List<Talla> listaTallas) {
		this.listaTallas = listaTallas;
	}

	public int getIdTalla() {
		return idTalla;
	}

	public void setIdTalla(int idTalla) {
		this.idTalla = idTalla;
	}

	public ProductoEspecificacionTalla getProductoEspecificacionTalla() {
		return productoEspecificacionTalla;
	}

	public void setProductoEspecificacionTalla(ProductoEspecificacionTalla productoEspecificacionTalla) {
		this.productoEspecificacionTalla = productoEspecificacionTalla;
	}

	public List<PropuestaNoIncluye> getListapropuestaNoIncluye() {
		return ListapropuestaNoIncluye;
	}

	public void setListapropuestaNoIncluye(List<PropuestaNoIncluye> ListapropuestaNoIncluye) {
		this.ListapropuestaNoIncluye = ListapropuestaNoIncluye;
	}

	public Object getDatosCotizacionProducto() {
		return datosCotizacionProducto;
	}

	public void setDatosCotizacionProducto(Object datosCotizacionProducto) {
		this.datosCotizacionProducto = datosCotizacionProducto;
	}

	public List<CotizacionProducto> getListaProductosCotizados() {
		try {
			listaProductosCotizados = cotizacionProductoEJB.datosCotizacionProducto(cotizacion.getNumeroCotizacion());
		} catch (Exception ex) {
			Logger.getLogger(CotizacionController.class.getName()).log(Level.SEVERE, null, ex);
		}
		return listaProductosCotizados;
	}

	public void setListaProductosCotizados(List<CotizacionProducto> listaProductosCotizados) {
		this.listaProductosCotizados = listaProductosCotizados;
	}

}
