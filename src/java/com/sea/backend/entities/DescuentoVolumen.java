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
@Table(name = "tbl_descuento_volumen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DescuentoVolumen.findAll", query = "SELECT d FROM DescuentoVolumen d"),
    @NamedQuery(name = "DescuentoVolumen.findByIdDescuentoVolumen", query = "SELECT d FROM DescuentoVolumen d WHERE d.idDescuentoVolumen = :idDescuentoVolumen"),
    @NamedQuery(name = "DescuentoVolumen.findByActivo", query = "SELECT d FROM DescuentoVolumen d WHERE d.activo = :activo")})
public class DescuentoVolumen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_DESCUENTO_VOLUMEN")
    private Integer idDescuentoVolumen;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblDescuentoVolumenIdDescuentoVolumen")
    private List<Cotizacion> cotizacionList;

    public DescuentoVolumen() {
    }

    public DescuentoVolumen(Integer idDescuentoVolumen) {
        this.idDescuentoVolumen = idDescuentoVolumen;
    }

    public DescuentoVolumen(Integer idDescuentoVolumen, String descripcion, boolean activo) {
        this.idDescuentoVolumen = idDescuentoVolumen;
        this.descripcion = descripcion;
        this.activo = activo;
    }

    public Integer getIdDescuentoVolumen() {
        return idDescuentoVolumen;
    }

    public void setIdDescuentoVolumen(Integer idDescuentoVolumen) {
        this.idDescuentoVolumen = idDescuentoVolumen;
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
        hash += (idDescuentoVolumen != null ? idDescuentoVolumen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DescuentoVolumen)) {
            return false;
        }
        DescuentoVolumen other = (DescuentoVolumen) object;
        if ((this.idDescuentoVolumen == null && other.idDescuentoVolumen != null) || (this.idDescuentoVolumen != null && !this.idDescuentoVolumen.equals(other.idDescuentoVolumen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sea.backend.entities.DescuentoVolumen[ idDescuentoVolumen=" + idDescuentoVolumen + " ]";
    }
    
}
