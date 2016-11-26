/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.backend.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author homero
 */
@Entity
@Table(name = "tbl_registro_seguimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegistroSeguimiento.findAll", query = "SELECT r FROM RegistroSeguimiento r"),
    @NamedQuery(name = "RegistroSeguimiento.findByIdRegistroSeguimiento", query = "SELECT r FROM RegistroSeguimiento r WHERE r.idRegistroSeguimiento = :idRegistroSeguimiento"),
    @NamedQuery(name = "RegistroSeguimiento.findByFechaRegistro", query = "SELECT r FROM RegistroSeguimiento r WHERE r.fechaRegistro = :fechaRegistro")})
public class RegistroSeguimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_REGISTRO_SEGUIMIENTO")
    private Integer idRegistroSeguimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_REGISTRO")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    @JoinColumn(name = "TBL_COTIZACION_NUMERO_COTIZACION", referencedColumnName = "NUMERO_COTIZACION")
    @ManyToOne(optional = false)
    private Cotizacion tblCotizacionNumeroCotizacion;

    public RegistroSeguimiento() {
    }

    public RegistroSeguimiento(Integer idRegistroSeguimiento) {
        this.idRegistroSeguimiento = idRegistroSeguimiento;
    }

    public RegistroSeguimiento(Integer idRegistroSeguimiento, Date fechaRegistro, String observaciones) {
        this.idRegistroSeguimiento = idRegistroSeguimiento;
        this.fechaRegistro = fechaRegistro;
        this.observaciones = observaciones;
    }

    public Integer getIdRegistroSeguimiento() {
        return idRegistroSeguimiento;
    }

    public void setIdRegistroSeguimiento(Integer idRegistroSeguimiento) {
        this.idRegistroSeguimiento = idRegistroSeguimiento;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Cotizacion getTblCotizacionNumeroCotizacion() {
        return tblCotizacionNumeroCotizacion;
    }

    public void setTblCotizacionNumeroCotizacion(Cotizacion tblCotizacionNumeroCotizacion) {
        this.tblCotizacionNumeroCotizacion = tblCotizacionNumeroCotizacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRegistroSeguimiento != null ? idRegistroSeguimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegistroSeguimiento)) {
            return false;
        }
        RegistroSeguimiento other = (RegistroSeguimiento) object;
        if ((this.idRegistroSeguimiento == null && other.idRegistroSeguimiento != null) || (this.idRegistroSeguimiento != null && !this.idRegistroSeguimiento.equals(other.idRegistroSeguimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sea.backend.entities.RegistroSeguimiento[ idRegistroSeguimiento=" + idRegistroSeguimiento + " ]";
    }
    
}
