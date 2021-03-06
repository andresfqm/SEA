package com.sea.frontend.controller;

import com.sea.backend.entities.Ciudad;
import com.sea.backend.entities.Cliente;
import com.sea.backend.entities.Departamento;
import com.sea.backend.entities.Direccion;
import com.sea.backend.entities.Email;
import com.sea.backend.entities.Origen;
import com.sea.backend.entities.Telefono;
import com.sea.backend.entities.TipoDireccion;
import com.sea.backend.entities.TipoDocumento;
import com.sea.backend.entities.TipoEmail;
import com.sea.backend.entities.TipoTelefono;
import com.sea.backend.entities.Usuario;
import com.sea.backend.model.CiudadFacadeLocal;
import com.sea.backend.model.ClienteFacadeLocal;
import com.sea.backend.model.DepartamentoFacadeLocal;
import com.sea.backend.model.DireccionFacadeLocal;
import com.sea.backend.model.EmailFacadeLocal;
import com.sea.backend.model.OrigenFacadeLocal;
import com.sea.backend.model.TelefonoFacadeLocal;
import com.sea.backend.model.TipoDireccionFacadeLocal;
import com.sea.backend.model.TipoDocumentoFacadeLocal;
import com.sea.backend.model.TipoEmailFacadeLocal;
import com.sea.backend.model.TipoTelefonoFacadeLocal;
import com.sea.backend.model.UsuarioFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.json.JSONObject;
import org.primefaces.context.RequestContext;

/**
 *
 * @author homero
 */
@Named
@ViewScoped
public class ClienteController implements Serializable {
	
	String dialogTittle = null;
	String dialogContent = null;
	JSONObject snackbarData = new JSONObject();

	@EJB
	private ClienteFacadeLocal clienteEJB;
	private Cliente cliente;
	private List<Cliente> listaClientes;

	@EJB
	private UsuarioFacadeLocal usuarioEJB;
	private Usuario usuario;
	private List<Usuario> listaUsuario;

	@EJB
	private TipoTelefonoFacadeLocal tipoTelefonoEJB;
	private TipoTelefono tipoTelefono;
	private List<TipoTelefono> listaTipoTelefono;

	@EJB
	private TelefonoFacadeLocal telefonoEJB;
	private Telefono telefono;
	private List<Telefono> listaTelefono;

	@EJB
	private TipoDocumentoFacadeLocal tipoDocumentoEJB;
	private TipoDocumento tipoDocumento;
	private List<TipoDocumento> listaTipoDocumento;

	@EJB
	private TipoEmailFacadeLocal tipoEmailEJB;
	private TipoEmail tipoEmail;
	private List<TipoEmail> listaTipoEmail;

	@EJB
	private TipoDireccionFacadeLocal tipoDireccionEJB;
	private TipoDireccion tipoDireccion;
	private List<TipoDireccion> listaTipoDireccion;

	@EJB
	private EmailFacadeLocal emailEJB;
	private Email email;
	private List<Email> listaEmail;

	@EJB
	private DireccionFacadeLocal direccionEJB;
	private Direccion direccion;
	private List<Direccion> listaDireccion;

	@EJB
	private CiudadFacadeLocal ciudadEJB;
	private Ciudad ciudad;
	private List<Ciudad> listaCiudad;

	@EJB
	private DepartamentoFacadeLocal departamentoEJB;
	private Departamento departamento;
	private List<Departamento> listaDepartamento;

	@EJB
	private OrigenFacadeLocal origenEJB;
	private Origen origen;
	private List<Origen> listaOrigen;

	@PostConstruct
	public void init() {
		cliente = new Cliente();
		listaClientes = clienteEJB.listaClientes();
		usuario = new Usuario();
		listaUsuario = usuarioEJB.findAll();
		tipoTelefono = new TipoTelefono();
		listaTipoTelefono = tipoTelefonoEJB.findAll();
		tipoDocumento = new TipoDocumento();
		listaTipoDocumento = tipoDocumentoEJB.findAll();
		tipoEmail = new TipoEmail();
		listaTipoEmail = tipoEmailEJB.findAll();
		direccion = new Direccion();
		listaDireccion = direccionEJB.findAll();
		ciudad = new Ciudad();
		listaCiudad = ciudadEJB.findAll();
		email = new Email();
		listaEmail = emailEJB.findAll();
		telefono = new Telefono();
		listaTelefono = telefonoEJB.findAll();
		origen = new Origen();
		listaOrigen = origenEJB.findAll();
		departamento = new Departamento();
		listaDepartamento = departamentoEJB.findAll();
		tipoDireccion = new TipoDireccion();
		listaTipoDireccion = tipoDireccionEJB.findAll();
	}

	public void registrarCliente() {
		try{
		cliente.setTblTipoDocumentoIdTipoDocumento(tipoDocumentoEJB.find(tipoDocumento.getIdTipoDocumento()));
		cliente.setTblUsuarioIdUsuario(usuarioEJB.find(usuario.getIdUsuario()));
		cliente.setTblOrigenIdOrigen(origenEJB.find(origen.getIdOrigen()));
		clienteEJB.create(cliente);
		direccion.setTblTipoDireccionIdTipoDireccion(tipoDireccion);
		direccion.setTblClienteIdCliente(cliente);
		direccion.setTblCiudadIdCiudad(ciudadEJB.listaCiudad(ciudad.getNombre()));
		direccionEJB.create(direccion);
		telefono.setTblClienteIdCliente(cliente);
		telefono.setTblTipoTelefonoIdTipoTelefono(tipoTelefono);
		telefonoEJB.create(telefono);
		email.setTblClienteIdCliente(cliente);
		email.setTblTipoEmailIdTipoEmail(tipoEmail);
		emailEJB.create(email);
	snackbarData.put("message", "Se creó al cliente'"+cliente.getNombreORazonSocial()+" "+cliente.getApellido()+"'.");
	RequestContext.getCurrentInstance().execute("mostrarSnackbar("+snackbarData+");");
		} catch(Exception e){
			dialogTittle = "Error no controlado";
			dialogContent = e.getMessage();
			RequestContext.getCurrentInstance().execute("mostrarDialogos(`" + dialogTittle + "`, `" + dialogContent + "`);");
		}
		listaClientes = clienteEJB.listaClientes();
	}

	public void obtenerCiudad() {
		listaCiudad = ciudadEJB.listaCiudades(departamento);
	}

	public void render() {
		tipoDocumento = tipoDocumentoEJB.find(tipoDocumento.getIdTipoDocumento());
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}

	public TipoTelefono getTipoTelefono() {
		return tipoTelefono;
	}

	public void setTipoTelefono(TipoTelefono tipoTelefono) {
		this.tipoTelefono = tipoTelefono;
	}

	public List<TipoTelefono> getListaTipoTelefono() {
		return listaTipoTelefono;
	}

	public void setListaTipoTelefono(List<TipoTelefono> listaTipoTelefono) {
		this.listaTipoTelefono = listaTipoTelefono;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public List<TipoDocumento> getListaTipoDocumento() {
		return listaTipoDocumento;
	}

	public void setListaTipoDocumento(List<TipoDocumento> listaTipoDocumento) {
		this.listaTipoDocumento = listaTipoDocumento;
	}

	public TipoEmail getTipoEmail() {
		return tipoEmail;
	}

	public void setTipoEmail(TipoEmail tipoEmail) {
		this.tipoEmail = tipoEmail;
	}

	public List<TipoEmail> getListaTipoEmail() {
		return listaTipoEmail;
	}

	public void setListaTipoEmail(List<TipoEmail> listaTipoEmail) {
		this.listaTipoEmail = listaTipoEmail;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public List<Direccion> getListaDireccion() {
		return listaDireccion;
	}

	public void setListaDireccion(List<Direccion> listaDireccion) {
		this.listaDireccion = listaDireccion;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public List<Ciudad> getListaCiudad() {
		return listaCiudad;
	}

	public void setListaCiudad(List<Ciudad> listaCiudad) {
		this.listaCiudad = listaCiudad;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<Departamento> getListaDepartamento() {
		return listaDepartamento;
	}

	public void setListaDepartamento(List<Departamento> listaDepartamento) {
		this.listaDepartamento = listaDepartamento;
	}

	public Telefono getTelefono() {
		return telefono;
	}

	public void setTelefono(Telefono telefono) {
		this.telefono = telefono;
	}

	public List<Telefono> getListaTelefono() {
		return listaTelefono;
	}

	public void setListaTelefono(List<Telefono> listaTelefono) {
		this.listaTelefono = listaTelefono;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public List<Email> getListaEmail() {
		return listaEmail;
	}

	public void setListaEmail(List<Email> listaEmail) {
		this.listaEmail = listaEmail;
	}

	public Origen getOrigen() {
		return origen;
	}

	public void setOrigen(Origen origen) {
		this.origen = origen;
	}

	public List<Origen> getListaOrigen() {
		return listaOrigen;
	}

	public void setListaOrigen(List<Origen> listaOrigen) {
		this.listaOrigen = listaOrigen;
	}

	public TipoDireccion getTipoDireccion() {
		return tipoDireccion;
	}

	public void setTipoDireccion(TipoDireccion tipoDireccion) {
		this.tipoDireccion = tipoDireccion;
	}

	public List<TipoDireccion> getListaTipoDireccion() {
		return listaTipoDireccion;
	}

	public void setListaTipoDireccion(List<TipoDireccion> listaTipoDireccion) {
		this.listaTipoDireccion = listaTipoDireccion;
	}

}
