/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.backend.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author homero
 */
@Entity
@Table(name = "tbl_telefono")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Telefono.findAll", query = "SELECT t FROM Telefono t"),
    @NamedQuery(name = "Telefono.findByIdTelefono", query = "SELECT t FROM Telefono t WHERE t.telefonoPK.idTelefono = :idTelefono"),
    @NamedQuery(name = "Telefono.findByNumeroTelefono", query = "SELECT t FROM Telefono t WHERE t.numeroTelefono = :numeroTelefono"),
    @NamedQuery(name = "Telefono.findByTblClienteIdCliente", query = "SELECT t FROM Telefono t WHERE t.telefonoPK.tblClienteIdCliente = :tblClienteIdCliente")})
public class Telefono implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TelefonoPK telefonoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "NUMERO_TELEFONO")
    private String numeroTelefono;
    @JoinColumn(name = "TBL_CLIENTE_ID_CLIENTE", referencedColumnName = "ID_CLIENTE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cliente cliente;
    @JoinColumn(name = "TBL_TIPO_TELEFONO_ID_TIPO_TELEFONO", referencedColumnName = "ID_TIPO_TELEFONO")
    @ManyToOne(optional = false)
    private TipoTelefono tblTipoTelefonoIdTipoTelefono;
    @JoinColumn(name = "TBL_USUARIO_ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuario tblUsuarioIdUsuario;

    public Telefono() {
    }

    public Telefono(TelefonoPK telefonoPK) {
        this.telefonoPK = telefonoPK;
    }

    public Telefono(TelefonoPK telefonoPK, String numeroTelefono) {
        this.telefonoPK = telefonoPK;
        this.numeroTelefono = numeroTelefono;
    }

    public Telefono(int idTelefono, int tblClienteIdCliente) {
        this.telefonoPK = new TelefonoPK(idTelefono, tblClienteIdCliente);
    }

    public TelefonoPK getTelefonoPK() {
        return telefonoPK;
    }

    public void setTelefonoPK(TelefonoPK telefonoPK) {
        this.telefonoPK = telefonoPK;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public TipoTelefono getTblTipoTelefonoIdTipoTelefono() {
        return tblTipoTelefonoIdTipoTelefono;
    }

    public void setTblTipoTelefonoIdTipoTelefono(TipoTelefono tblTipoTelefonoIdTipoTelefono) {
        this.tblTipoTelefonoIdTipoTelefono = tblTipoTelefonoIdTipoTelefono;
    }

    public Usuario getTblUsuarioIdUsuario() {
        return tblUsuarioIdUsuario;
    }

    public void setTblUsuarioIdUsuario(Usuario tblUsuarioIdUsuario) {
        this.tblUsuarioIdUsuario = tblUsuarioIdUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (telefonoPK != null ? telefonoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Telefono)) {
            return false;
        }
        Telefono other = (Telefono) object;
        if ((this.telefonoPK == null && other.telefonoPK != null) || (this.telefonoPK != null && !this.telefonoPK.equals(other.telefonoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sea.backend.entities.Telefono[ telefonoPK=" + telefonoPK + " ]";
    }
    
}
