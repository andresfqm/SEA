/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.backend.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "tbl_direccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Direccion.findAll", query = "SELECT d FROM Direccion d"),
    @NamedQuery(name = "Direccion.findByIdDireccion", query = "SELECT d FROM Direccion d WHERE d.idDireccion = :idDireccion"),
    @NamedQuery(name = "Direccion.findByDireccion", query = "SELECT d FROM Direccion d WHERE d.direccion = :direccion")})
public class Direccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_DIRECCION")
    private Integer idDireccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "DIRECCION")
    private String direccion;
    @JoinColumn(name = "TBL_CIUDAD_ID_CIUDAD", referencedColumnName = "ID_CIUDAD")
    @ManyToOne(optional = false)
    private Ciudad tblCiudadIdCiudad;
    @JoinColumn(name = "TBL_CLIENTE_ID_CLIENTE", referencedColumnName = "ID_CLIENTE")
    @ManyToOne
    private Cliente tblClienteIdCliente;
    @JoinColumn(name = "TBL_TIPO_DIRECCION_ID_TIPO_DIRECCION", referencedColumnName = "ID_TIPO_DIRECCION")
    @ManyToOne(optional = false)
    private TipoDireccion tblTipoDireccionIdTipoDireccion;
    @JoinColumn(name = "TBL_USUARIO_ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuario tblUsuarioIdUsuario;

    public Direccion() {
    }

    public Direccion(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

    public Direccion(Integer idDireccion, String direccion) {
        this.idDireccion = idDireccion;
        this.direccion = direccion;
    }

    public Integer getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Ciudad getTblCiudadIdCiudad() {
        return tblCiudadIdCiudad;
    }

    public void setTblCiudadIdCiudad(Ciudad tblCiudadIdCiudad) {
        this.tblCiudadIdCiudad = tblCiudadIdCiudad;
    }

    public Cliente getTblClienteIdCliente() {
        return tblClienteIdCliente;
    }

    public void setTblClienteIdCliente(Cliente tblClienteIdCliente) {
        this.tblClienteIdCliente = tblClienteIdCliente;
    }

    public TipoDireccion getTblTipoDireccionIdTipoDireccion() {
        return tblTipoDireccionIdTipoDireccion;
    }

    public void setTblTipoDireccionIdTipoDireccion(TipoDireccion tblTipoDireccionIdTipoDireccion) {
        this.tblTipoDireccionIdTipoDireccion = tblTipoDireccionIdTipoDireccion;
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
        hash += (idDireccion != null ? idDireccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Direccion)) {
            return false;
        }
        Direccion other = (Direccion) object;
        if ((this.idDireccion == null && other.idDireccion != null) || (this.idDireccion != null && !this.idDireccion.equals(other.idDireccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sea.backend.entities.Direccion[ idDireccion=" + idDireccion + " ]";
    }
    
}
