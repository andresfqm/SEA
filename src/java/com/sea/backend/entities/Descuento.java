/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.backend.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author homero
 */
@Entity
@Table(name = "tbl_descuento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Descuento.findAll", query = "SELECT d FROM Descuento d"),
    @NamedQuery(name = "Descuento.findByIdDescuento", query = "SELECT d FROM Descuento d WHERE d.idDescuento = :idDescuento"),
    @NamedQuery(name = "Descuento.findByDescuento", query = "SELECT d FROM Descuento d WHERE d.descuento = :descuento"),
    @NamedQuery(name = "Descuento.findByCantidadMinima", query = "SELECT d FROM Descuento d WHERE d.cantidadMinima = :cantidadMinima")})
public class Descuento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_DESCUENTO")
    private Integer idDescuento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DESCUENTO")
    private float descuento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD_MINIMA")
    private int cantidadMinima;
    @JoinTable(name = "producto_descuento", joinColumns = {
        @JoinColumn(name = "TBL_DESCUENTO_ID_DESCUENTO", referencedColumnName = "ID_DESCUENTO")}, inverseJoinColumns = {
        @JoinColumn(name = "TBL_PRODUCTO_ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO")})
    @ManyToMany
    private List<Producto> productoList;

    public Descuento() {
    }

    public Descuento(Integer idDescuento) {
        this.idDescuento = idDescuento;
    }

    public Descuento(Integer idDescuento, float descuento, int cantidadMinima) {
        this.idDescuento = idDescuento;
        this.descuento = descuento;
        this.cantidadMinima = cantidadMinima;
    }

    public Integer getIdDescuento() {
        return idDescuento;
    }

    public void setIdDescuento(Integer idDescuento) {
        this.idDescuento = idDescuento;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public int getCantidadMinima() {
        return cantidadMinima;
    }

    public void setCantidadMinima(int cantidadMinima) {
        this.cantidadMinima = cantidadMinima;
    }

    @XmlTransient
    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDescuento != null ? idDescuento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Descuento)) {
            return false;
        }
        Descuento other = (Descuento) object;
        if ((this.idDescuento == null && other.idDescuento != null) || (this.idDescuento != null && !this.idDescuento.equals(other.idDescuento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sea.backend.entities.Descuento[ idDescuento=" + idDescuento + " ]";
    }
    
}
