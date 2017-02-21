/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.backend.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.metamodel.SingularAttribute;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author homero
 */
@Entity
@Table(name = "tbl_cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByIdCliente", query = "SELECT c FROM Cliente c WHERE c.idCliente = :idCliente"),
    @NamedQuery(name = "Cliente.findByNumeroDocumento", query = "SELECT c FROM Cliente c WHERE c.numeroDocumento = :numeroDocumento"),
    @NamedQuery(name = "Cliente.findByDigitoVerificacion", query = "SELECT c FROM Cliente c WHERE c.digitoVerificacion = :digitoVerificacion"),
    @NamedQuery(name = "Cliente.findByNombreORazonSocial", query = "SELECT c FROM Cliente c WHERE c.nombreORazonSocial = :nombreORazonSocial"),
    @NamedQuery(name = "Cliente.findByApellido", query = "SELECT c FROM Cliente c WHERE c.apellido = :apellido"),
    @NamedQuery(name = "Cliente.findByNombreContacto", query = "SELECT c FROM Cliente c WHERE c.nombreContacto = :nombreContacto")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CLIENTE")
    private Integer idCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "NUMERO_DOCUMENTO")
    private String numeroDocumento;
    @Size(max = 1)
    @Column(name = "DIGITO_VERIFICACION")
    private String digitoVerificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "NOMBRE_O_RAZON_SOCIAL")
    private String nombreORazonSocial;
    @Size(max = 64)
    @Column(name = "APELLIDO")
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "NOMBRE_CONTACTO")
    private String nombreContacto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<Telefono> telefonoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<Email> emailList;
    @OneToMany(mappedBy = "tblClienteIdCliente")
    private List<Direccion> direccionList;
    @JoinColumn(name = "TBL_COMENTARIO_CAMBIO_ASESOR_ID_COMENTARIO_CAMBIO_ASESOR", referencedColumnName = "ID_COMENTARIO_CAMBIO_ASESOR")
    @ManyToOne(optional = false)
    private ComentarioCambioAsesor tblComentarioCambioAsesorIdComentarioCambioAsesor;
    @JoinColumn(name = "TBL_ORIGEN_ID_ORIGEN", referencedColumnName = "ID_ORIGEN")
    @ManyToOne(optional = false)
    private Origen tblOrigenIdOrigen;
    @JoinColumn(name = "TBL_TIPO_DOCUMENTO_ID_TIPO_DOCUMENTO", referencedColumnName = "ID_TIPO_DOCUMENTO")
    @ManyToOne(optional = false)
    private TipoDocumento tblTipoDocumentoIdTipoDocumento;
    @JoinColumn(name = "TBL_USUARIO_ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false)
    private Usuario tblUsuarioIdUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblClienteIdCliente")
    private List<Cotizacion> cotizacionList;

    public Cliente() {
    }

    public Cliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente(Integer idCliente, String numeroDocumento, String nombreORazonSocial, String nombreContacto) {
        this.idCliente = idCliente;
        this.numeroDocumento = numeroDocumento;
        this.nombreORazonSocial = nombreORazonSocial;
        this.nombreContacto = nombreContacto;
    }

    public Cliente(int idCliente, SingularAttribute<Cliente, String> numeroDocumento, SingularAttribute<Cliente, String> nombreORazonSocial, SingularAttribute<Cliente, String> nombreContacto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getDigitoVerificacion() {
        return digitoVerificacion;
    }

    public void setDigitoVerificacion(String digitoVerificacion) {
        this.digitoVerificacion = digitoVerificacion;
    }

    public String getNombreORazonSocial() {
        return nombreORazonSocial;
    }

    public void setNombreORazonSocial(String nombreORazonSocial) {
        this.nombreORazonSocial = nombreORazonSocial;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    @XmlTransient
    public List<Telefono> getTelefonoList() {
        return telefonoList;
    }

    public void setTelefonoList(List<Telefono> telefonoList) {
        this.telefonoList = telefonoList;
    }

    @XmlTransient
    public List<Email> getEmailList() {
        return emailList;
    }

    public void setEmailList(List<Email> emailList) {
        this.emailList = emailList;
    }

    @XmlTransient
    public List<Direccion> getDireccionList() {
        return direccionList;
    }

    public void setDireccionList(List<Direccion> direccionList) {
        this.direccionList = direccionList;
    }

    public ComentarioCambioAsesor getTblComentarioCambioAsesorIdComentarioCambioAsesor() {
        return tblComentarioCambioAsesorIdComentarioCambioAsesor;
    }

    public void setTblComentarioCambioAsesorIdComentarioCambioAsesor(ComentarioCambioAsesor tblComentarioCambioAsesorIdComentarioCambioAsesor) {
        this.tblComentarioCambioAsesorIdComentarioCambioAsesor = tblComentarioCambioAsesorIdComentarioCambioAsesor;
    }

    public Origen getTblOrigenIdOrigen() {
        return tblOrigenIdOrigen;
    }

    public void setTblOrigenIdOrigen(Origen tblOrigenIdOrigen) {
        this.tblOrigenIdOrigen = tblOrigenIdOrigen;
    }

    public TipoDocumento getTblTipoDocumentoIdTipoDocumento() {
        return tblTipoDocumentoIdTipoDocumento;
    }

    public void setTblTipoDocumentoIdTipoDocumento(TipoDocumento tblTipoDocumentoIdTipoDocumento) {
        this.tblTipoDocumentoIdTipoDocumento = tblTipoDocumentoIdTipoDocumento;
    }

    public Usuario getTblUsuarioIdUsuario() {
        return tblUsuarioIdUsuario;
    }

    public void setTblUsuarioIdUsuario(Usuario tblUsuarioIdUsuario) {
        this.tblUsuarioIdUsuario = tblUsuarioIdUsuario;
    }

    @XmlTransient
    public List<Cotizacion> getCotizacionList() {
        return cotizacionList;
    }

    public void setCotizacionList(List<Cotizacion> cotizacionList) {
        this.cotizacionList = cotizacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sea.backend.entities.Cliente[ idCliente=" + idCliente + " ]";
    }
    
}
