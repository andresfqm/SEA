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
import com.sea.backend.entities.DescuentoVolumen;
import com.sea.backend.entities.Fabricante;
import com.sea.backend.entities.LugaresEntrega;
import com.sea.backend.entities.Material;
import com.sea.backend.entities.ModalidadDePago;
import com.sea.backend.entities.OrdenProduccion;
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
import com.sea.backend.model.FabricanteFacadeLocal;
import com.sea.backend.model.LugaresEntregaFacadeLocal;
import com.sea.backend.model.MaterialFacadeLocal;
import com.sea.backend.model.ModalidadDePagoFacadeLocal;
import com.sea.backend.model.OrdenProduccionFacadeLocal;
import com.sea.backend.model.ProductoEspecificacionFacadeLocal;
import com.sea.backend.model.ProductoEspecificacionTallaFacadeLocal;
import com.sea.backend.model.ProductoFacadeLocal;
import com.sea.backend.model.PropuestaNoIncluyeFacadeLocal;
import com.sea.backend.model.TallaFacadeLocal;
import com.sea.backend.model.TiempoEntregaFacadeLocal;
import com.sea.backend.model.UsuarioFacadeLocal;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author homero
 */
@Named
@ViewScoped
public class OrdenProduccionController implements Serializable {

	//EJB cotización
	@EJB
	private CotizacionFacadeLocal cotizacionEJB;
	private Cotizacion cotizacion;
	private Double descuentoCotizacion;
	private List<Cotizacion> listaSeguimientoCotizacions;
	private String numeroCotizacion;
	private List<Cotizacion> listaCotizacionesOrdenProduccion;
	private Object datosCotizacion;

//EJB Producto Especificación
	@EJB
	private ProductoEspecificacionFacadeLocal productoEsEJB;
	private ProductoEspecificacion productoEspecificacion;
	private int idProductoEspecificacion;
	private List<ProductoEspecificacion> listaProductoEspecificacion;

	//EJB CotizaciónProducto
	@EJB
	private CotizacionProductoFacadeLocal cotizacionProductoEJB;
	private CotizacionProducto cotizacionProducto;
	private List<CotizacionProducto> listaCotizacionP;
	private Object datosCotizacionProducto;
	private List<CotizacionProductoAuxiliar> listaDatosCotizacionProducto;

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
	private ProductoEspecificacionTallaFacadeLocal productoETEJB;
	private ProductoEspecificacionTalla productoEspecificacionTalla;
	private List<ProductoEspecificacionTalla> listaProductoEspecificacionTallas;

	//Variable para almacenar el campo diseño de generar orden producción
	private String diseño;

	//Ejb de la foranea TiempoEntrega
	@EJB
	private TiempoEntregaFacadeLocal tiempoEJB;
	private int idTiempoEntrega;
	private TiempoEntrega tiempoEntrega;
	private List<TiempoEntrega> listaTiempoEntrega;

	//EJB Lugares de entrega
	@EJB
	private LugaresEntregaFacadeLocal lugaresEEJB;
	private int idLugaresEntrega;
	private LugaresEntrega lugaresEntrega;
	private List<LugaresEntrega> listaLugaresEntrega;

	//Entidad producto
	@EJB
	private ProductoFacadeLocal productoEJB;
	private Producto producto;
	private int idProducto;
	private List<Material> listaMateriales;
	private List<Fabricante> listaFabricante;
	private List<Producto> listaProductoPrecio;
	private List<Producto> listaProducto;
	private List<ProductoAuxiliar> listaDatosEspecificacionProducto;
	private String referencia;

	@EJB
	private DescuentoFacadeLocal descuentoEJB;
	private int idDescuento;

	private int formatoCotizacion;

	private String mensaje;

	//Cargue de archivos- Logo tipo - diagrama de diseño
	private Part diagrama_diseño;
	private Part logotipo;
	private String diagramaDiseño;
	private String logotipoP;
	private String pathReal;

	//EJB de generar orden de producción
	@EJB
	private OrdenProduccionFacadeLocal ordenPEJB;
	private OrdenProduccion ordenProduccion;
	private List<Cotizacion> listaLugarEmision;

	@PostConstruct
	public void init() {

		cotizacion = new Cotizacion();
		cotizacionP = new CotizacionProducto();
		producto = new Producto();
		listaDatosEspecificacionProducto = new ArrayList<>();
		listaCotizacionP = new ArrayList<>();
		listaProducto = productoEJB.findAll();
		lugaresEntrega = new LugaresEntrega();
		tiempoEntrega = new TiempoEntrega();
		ListapropuestaNoIncluye = propuestaEJB.findAll();
		listaTiempoEntrega = tiempoEJB.findAll();
		listaLugaresEntrega = lugaresEEJB.findAll();
		listaSeguimientoCotizacions = cotizacionEJB.listaSeguimiento(idUsuario());
		propuestaNoIncluye = new PropuestaNoIncluye();
		listaDatosCotizacionProducto = new ArrayList<>();
		listaCotizacionesOrdenProduccion = cotizacionEJB.findAll();
		listaProductoEspecificacion = new ArrayList<>();
		cotizacionProducto = new CotizacionProducto();

		listaProductoEspecificacionTallas = new ArrayList<>();
		productoEspecificacion = new ProductoEspecificacion();
		talla = new Talla();
		listaTallas = tallaEJB.findAll();
		productoEspecificacionTalla = new ProductoEspecificacionTalla();
		ordenProduccion = new OrdenProduccion();
		ordenProduccion.setFechaExpedicion(new Date());
		ordenProduccion.setFechaEntregaFinal(new Date());

	}

	public void agregarCotizacionProducto() {
		CotizacionProducto cot = new CotizacionProducto();

		cot.setTblProductoIdProducto(producto);
		cot.setCantidad(cotizacionP.getCantidad());
		cot.setPrecioParaCliente(cotizacionP.getPrecioParaCliente());

		//  ven.setTblProductoIdProducto(productoEJB.find(producto.getIdProducto()));
		listaCotizacionP.add(cot);

	}

	//Metodo para calcular el precio del producto seleccionado
	public Double calcularPrecioProductoDescuento() {
		return this.listaProductoPrecio.get(0).getPrecio() - (this.listaProductoPrecio.get(0).getPrecio() * this.descuentoCotizacion);

	}

	// Metodo para traer los productos registrados en una cotización
	public void obtenerProductosRegistrados() throws Exception {
		try {

			datosCotizacionProducto = cotizacionProductoEJB.datosCotizacionProducto(getNumeroCotizacion());

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
			datosCotizacion = cotizacionEJB.datosCotizacion(numeroCotizacion);
		} catch (Exception e) {
		}
	}

	public int idUsuario() {
		HttpSession sesion = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		Usuario u = (Usuario) sesion.getAttribute("usuario");
		return u.getIdUsuario();
	}

	public void modificarCotización() {
		try {
			cotizacionEJB.edit(cotizacion);
		} catch (Exception e) {
		}

	}

	public String leerId(Cotizacion cotizacion) {
		this.cotizacion = cotizacionEJB.find(cotizacion.getNumeroCotizacion());
		return "actualizarCotizacion.xhtml";

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

	public LugaresEntrega getLugaresEntrega() {
		return lugaresEntrega;
	}

	public void setLugaresEntrega(LugaresEntrega lugaresEntrega) {
		this.lugaresEntrega = lugaresEntrega;
	}

	public Cotizacion getCotizacion() {
		return cotizacion;
	}

	public void setCotizacion(Cotizacion cotizacion) {
		this.cotizacion = cotizacion;
	}

	public List<TiempoEntrega> getListaTiempoEntrega() {
		return listaTiempoEntrega;
	}

	public void setListaTiempoEntrega(List<TiempoEntrega> listaTiempoEntrega) {
		this.listaTiempoEntrega = listaTiempoEntrega;
	}

	public List<LugaresEntrega> getListaLugaresEntrega() {
		return listaLugaresEntrega;
	}

	public void setListaLugaresEntrega(List<LugaresEntrega> listaLugaresEntrega) {
		this.listaLugaresEntrega = listaLugaresEntrega;
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

	public int getIdLugaresEntrega() {
		return idLugaresEntrega;
	}

	public void setIdLugaresEntrega(int idLugaresEntrega) {
		this.idLugaresEntrega = idLugaresEntrega;
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

	public int getIdDescuento() {
		return idDescuento;
	}

	public void setIdDescuento(int idDescuento) {
		this.idDescuento = idDescuento;
	}

	//Metodo para registrar las tallas
	public void obtenertallaDescripcion() throws Exception {
		talla = tallaEJB.tallaDescripcion(talla.getIdTalla());
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

	public int consecutivoCotizacion() {
		HttpSession sesion = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		Usuario u = (Usuario) sesion.getAttribute("usuario");
		return u.getConsecutivoCotizacion();
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

	public int getFormatoCotizacion() {
		return formatoCotizacion;
	}

	public void setFormatoCotizacion(int formatoCotizacion) {
		this.formatoCotizacion = formatoCotizacion;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Object getDatosCotizacionProducto() {
		return datosCotizacionProducto;
	}

	public void setDatosCotizacionProducto(Object datosCotizacionProducto) {
		this.datosCotizacionProducto = datosCotizacionProducto;
	}

	public List<PropuestaNoIncluye> getListapropuestaNoIncluye() {
		return ListapropuestaNoIncluye;
	}

	public void setListapropuestaNoIncluye(List<PropuestaNoIncluye> ListapropuestaNoIncluye) {
		this.ListapropuestaNoIncluye = ListapropuestaNoIncluye;
	}

	public String getNumeroCotizacion() {
		return numeroCotizacion;
	}

	public void setNumeroCotizacion(String numeroCotizacion) {
		this.numeroCotizacion = numeroCotizacion;
	}

	public List<Cotizacion> getListaCotizacionesOrdenProduccion() {
		return listaCotizacionesOrdenProduccion;
	}

	public void setListaCotizacionesOrdenProduccion(List<Cotizacion> listaCotizacionesOrdenProduccion) {
		this.listaCotizacionesOrdenProduccion = listaCotizacionesOrdenProduccion;
	}

	public Object getDatosCotizacion() {
		return datosCotizacion;
	}

	public void setDatosCotizacion(Object datosCotizacion) {
		this.datosCotizacion = datosCotizacion;
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

	public String getDiseño() {
		return diseño;
	}

	public void setDiseño(String diseño) {
		this.diseño = diseño;
	}

	public ProductoEspecificacion getProductoEspecificacion() {
		return productoEspecificacion;
	}

	public void setProductoEspecificacion(ProductoEspecificacion productoEspecificacion) {
		this.productoEspecificacion = productoEspecificacion;
	}

	public ProductoEspecificacionTalla getProductoEspecificacionTalla() {
		return productoEspecificacionTalla;
	}

	public void setProductoEspecificacionTalla(ProductoEspecificacionTalla productoEspecificacionTalla) {
		this.productoEspecificacionTalla = productoEspecificacionTalla;
	}

	public Part getDiagrama_diseño() {
		return diagrama_diseño;
	}

	public void setDiagrama_diseño(Part diagrama_diseño) {
		this.diagrama_diseño = diagrama_diseño;
	}

	public Part getLogotipo() {
		return logotipo;
	}

	public void setLogotipo(Part logotipo) {
		this.logotipo = logotipo;
	}

	public String getDiagramaDiseño() {
		return diagramaDiseño;
	}

	public void setDiagramaDiseño(String diagramaDiseño) {
		this.diagramaDiseño = diagramaDiseño;
	}

	public String getLogotipoP() {
		return logotipoP;
	}

	public void setLogotipoP(String logotipoP) {
		this.logotipoP = logotipoP;
	}

	public String getPathReal() {
		return pathReal;
	}

	public void setPathReal(String pathReal) {
		this.pathReal = pathReal;
	}

	public List<ProductoEspecificacion> getListaProductoEspecificacion() {
		return listaProductoEspecificacion;
	}

	public void setListaProductoEspecificacion(List<ProductoEspecificacion> listaProductoEspecificacion) {
		this.listaProductoEspecificacion = listaProductoEspecificacion;
	}

	public OrdenProduccion getOrdenProduccion() {
		return ordenProduccion;
	}

	public void setOrdenProduccion(OrdenProduccion ordenProduccion) {
		this.ordenProduccion = ordenProduccion;
	}

	public int getIdProductoEspecificacion() {
		return idProductoEspecificacion;
	}

	public void setIdProductoEspecificacion(int idProductoEspecificacion) {
		this.idProductoEspecificacion = idProductoEspecificacion;
	}

	public List<ProductoEspecificacionTalla> getListaProductoEspecificacionTallas() {
		return listaProductoEspecificacionTallas;
	}

	public void setListaProductoEspecificacionTallas(List<ProductoEspecificacionTalla> listaProductoEspecificacionTallas) {
		this.listaProductoEspecificacionTallas = listaProductoEspecificacionTallas;
	}

	//Metodo para agragar producto_especificación
	public void productoEspecificacon() {
		ProductoEspecificacion proE = new ProductoEspecificacion();

		proE.setDescripcion(productoEspecificacion.getDescripcion());
		proE.setLogotipo(productoEspecificacion.getLogotipo());
		proE.setCantidadArticulos(productoEspecificacion.getCantidadArticulos());
		proE.setDiagramaDiseño(productoEspecificacion.getDiagramaDiseño());
		proE.setNecesitaBordado(productoEspecificacion.getNecesitaBordado());
		proE.setTblProductoIdProducto(producto);
		listaProductoEspecificacion.add(proE);

		ProductoEspecificacionTalla proET = new ProductoEspecificacionTalla();
		proET.setCantidad(productoEspecificacionTalla.getCantidad());
		proET.setTblTallaIdTalla(talla);
		listaProductoEspecificacionTallas.add(proET);

	}

	public List<Cotizacion> getListaLugarEmision() {
		return listaLugarEmision;
	}

	public void setListaLugarEmision(List<Cotizacion> listaLugarEmision) {
		this.listaLugarEmision = listaLugarEmision;
	}

	public void objetosCotizacionProducto() throws Exception {
		System.out.println("(((((((((((((((((" + numeroCotizacion);
		listaDatosCotizacionProducto = cotizacionProductoEJB.datosCotizacionProducto(getNumeroCotizacion());

	}
	//Metodo para traer las especififaciones de los prodectos registrados EJP: Botones, Colores, Botas etc.

	public void obtenerEspecicacionesProductosRegistrados() throws Exception {
		try {
			System.out.println("(prueba referncia = " + referencia);
			listaDatosEspecificacionProducto = productoEJB.datosEspecificacionProducto(referencia);

		} catch (Exception e) {
		}
	}

	public void registrarOrdenProduccion() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		try {

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
				productoEspecificacion.setDiagramaDiseño(pathReal);

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
				productoEspecificacion.setLogotipo(pathReal);

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
			ordenProduccion.setFechaExpedicion(ordenProduccion.getFechaExpedicion());
			ordenProduccion.setFechaEntregaFinal(ordenProduccion.getFechaEntregaFinal());
			//Ciudad quemada
			ordenProduccion.setCiudadExpedicion("Abriaquí");
			ordenProduccion.setObservaciones(ordenProduccion.getObservaciones());
			ordenProduccion.setTotalPrendas(ordenProduccion.getTotalPrendas());
			ordenProduccion.setEstado("Pendiente");
			ordenProduccion.setTblCotizacionNumeroCotizacion(cotizacionEJB.find(numeroCotizacion));

			ordenPEJB.create(ordenProduccion);

			for (ProductoEspecificacion itemVenta1 : listaProductoEspecificacion) {
				itemVenta1.setTblOrdenProduccionIdOrdenProduccion(ordenProduccion);
				itemVenta1.setTblProductoIdProducto(producto);
				itemVenta1.setDescripcion(this.productoEspecificacion.getDescripcion());
				itemVenta1.setLogotipo(this.productoEspecificacion.getLogotipo());
				itemVenta1.setCantidadArticulos(this.productoEspecificacion.getCantidadArticulos());
				itemVenta1.setDiagramaDiseño(this.productoEspecificacion.getDiagramaDiseño());
				itemVenta1.setNecesitaBordado(this.productoEspecificacion.getNecesitaBordado());
				productoEsEJB.create(itemVenta1);
			}

			for (ProductoEspecificacionTalla itemventa2 : listaProductoEspecificacionTallas) {
				itemventa2.setTblProductoEspecificacionIdProductoEspecificacion(productoEspecificacion);
				itemventa2.setTblTallaIdTalla(talla);
				itemventa2.setCantidad(this.productoEspecificacionTalla.getCantidad());
				productoETEJB.create(itemventa2);
			}
		} catch (Exception e) {
		}
	}

	public List<CotizacionProductoAuxiliar> getListaDatosCotizacionProducto() throws Exception {

		objetosCotizacionProducto();

		for (CotizacionProductoAuxiliar ca : listaDatosCotizacionProducto) {
			System.out.println("Descripción" + ca.getDescripcion());
			System.out.println("Referencia" + ca.getReferencia());
			System.out.println("Material" + ca.getNombreMaterial());
			System.out.println("Fabricante" + ca.getNombreFabricante());

		}

		return listaDatosCotizacionProducto;

	}

	public void setListaDatosCotizacionProducto(List<CotizacionProductoAuxiliar> listaDatosCotizacionProducto) {
		this.listaDatosCotizacionProducto = listaDatosCotizacionProducto;
	}

	public List<ProductoAuxiliar> getListaDatosEspecificacionProducto() throws Exception {
		obtenerEspecicacionesProductosRegistrados();
		for (ProductoAuxiliar prA : listaDatosEspecificacionProducto) {
			System.out.println("Descripción de los productos" + prA.getDescripcion());

		}
		return listaDatosEspecificacionProducto;
	}

	public void setListaDatosEspecificacionProducto(List<ProductoAuxiliar> listaDatosEspecificacionProducto) {
		this.listaDatosEspecificacionProducto = listaDatosEspecificacionProducto;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

}
