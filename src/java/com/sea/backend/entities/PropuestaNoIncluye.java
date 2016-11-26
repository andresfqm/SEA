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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author homero
 */
@Entity
@Table(name = "tbl_propuesta_no_incluye")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PropuestaNoIncluye.findAll", query = "SELECT p FROM PropuestaNoIncluye p"),
    @NamedQuery(name = "PropuestaNoIncluye.findByIdPropuestaNoIncluye", query = "SELECT p FROM PropuestaNoIncluye p WHERE p.idPropuestaNoIncluye = :idPropuestaNoIncluye"),
    @NamedQuery(name = "PropuestaNoIncluye.findByActivo", query = "SELECT p FROM PropuestaNoIncluye p WHERE p.activo = :activo")})
public class PropuestaNoIncluye implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PROPUESTA_NO_INCLUYE")
    private Integer idPropuestaNoIncluye;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACTIVO")
    private boolean activo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblPropuestaNoIncluyeIdPropuestaNoIncluye")
    private List<Cotizacion> cotizacionList;

    public PropuestaNoIncluye() {
    }

    public PropuestaNoIncluye(Integer idPropuestaNoIncluye) {
        this.idPropuestaNoIncluye = idPropuestaNoIncluye;
    }

    public PropuestaNoIncluye(Integer idPropuestaNoIncluye, String descripcion, boolean activo) {
        this.idPropuestaNoIncluye = idPropuestaNoIncluye;
        this.descripcion = descripcion;
        this.activo = activo;
    }

    public Integer getIdPropuestaNoIncluye() {
        return idPropuestaNoIncluye;
    }

    public void setIdPropuestaNoIncluye(Integer idPropuestaNoIncluye) {
        this.idPropuestaNoIncluye = idPropuestaNoIncluye;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
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
        hash += (idPropuestaNoIncluye != null ? idPropuestaNoIncluye.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PropuestaNoIncluye)) {
            return false;
        }
        PropuestaNoIncluye other = (PropuestaNoIncluye) object;
        if ((this.idPropuestaNoIncluye == null && other.idPropuestaNoIncluye != null) || (this.idPropuestaNoIncluye != null && !this.idPropuestaNoIncluye.equals(other.idPropuestaNoIncluye))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sea.backend.entities.PropuestaNoIncluye[ idPropuestaNoIncluye=" + idPropuestaNoIncluye + " ]";
    }
    
}
