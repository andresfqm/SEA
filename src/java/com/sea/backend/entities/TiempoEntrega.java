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
@Table(name = "tbl_tiempo_entrega")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiempoEntrega.findAll", query = "SELECT t FROM TiempoEntrega t"),
    @NamedQuery(name = "TiempoEntrega.findByIdTiempoEntrega", query = "SELECT t FROM TiempoEntrega t WHERE t.idTiempoEntrega = :idTiempoEntrega"),
    @NamedQuery(name = "TiempoEntrega.findByActivo", query = "SELECT t FROM TiempoEntrega t WHERE t.activo = :activo")})
public class TiempoEntrega implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TIEMPO_ENTREGA")
    private Integer idTiempoEntrega;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblTiempoEntregaIdTiempoEntrega")
    private List<Cotizacion> cotizacionList;

    public TiempoEntrega() {
    }

    public TiempoEntrega(Integer idTiempoEntrega) {
        this.idTiempoEntrega = idTiempoEntrega;
    }

    public TiempoEntrega(Integer idTiempoEntrega, String descripcion, boolean activo) {
        this.idTiempoEntrega = idTiempoEntrega;
        this.descripcion = descripcion;
        this.activo = activo;
    }

    public Integer getIdTiempoEntrega() {
        return idTiempoEntrega;
    }

    public void setIdTiempoEntrega(Integer idTiempoEntrega) {
        this.idTiempoEntrega = idTiempoEntrega;
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
        hash += (idTiempoEntrega != null ? idTiempoEntrega.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiempoEntrega)) {
            return false;
        }
        TiempoEntrega other = (TiempoEntrega) object;
        if ((this.idTiempoEntrega == null && other.idTiempoEntrega != null) || (this.idTiempoEntrega != null && !this.idTiempoEntrega.equals(other.idTiempoEntrega))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sea.backend.entities.TiempoEntrega[ idTiempoEntrega=" + idTiempoEntrega + " ]";
    }
    
}
