/*
 * The MIT License
 *
 * Copyright 2017 Depurador.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Depurador
 */
@Entity
@Table(name = "tbl_cotizacion_producto")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "CotizacionProducto.findAll", query = "SELECT c FROM CotizacionProducto c")
	, @NamedQuery(name = "CotizacionProducto.findByTblProductoIdProducto", query = "SELECT c FROM CotizacionProducto c WHERE c.cotizacionProductoPK.tblProductoIdProducto = :tblProductoIdProducto")
	, @NamedQuery(name = "CotizacionProducto.findByTblCotizacionNumeroCotizacion", query = "SELECT c FROM CotizacionProducto c WHERE c.cotizacionProductoPK.tblCotizacionNumeroCotizacion = :tblCotizacionNumeroCotizacion")
	, @NamedQuery(name = "CotizacionProducto.findByPrecioParaCliente", query = "SELECT c FROM CotizacionProducto c WHERE c.precioParaCliente = :precioParaCliente")
	, @NamedQuery(name = "CotizacionProducto.findByCantidad", query = "SELECT c FROM CotizacionProducto c WHERE c.cantidad = :cantidad")})
public class CotizacionProducto implements Serializable {

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	protected CotizacionProductoPK cotizacionProductoPK;
	// @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
	@Column(name = "PRECIO_PARA_CLIENTE")
	private Double precioParaCliente;
	@Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD")
	private int cantidad;
	@JoinColumn(name = "TBL_COTIZACION_NUMERO_COTIZACION", referencedColumnName = "NUMERO_COTIZACION", insertable = false, updatable = false)
    @ManyToOne(optional = false)
	private Cotizacion cotizacion;
	@JoinColumn(name = "TBL_PRODUCTO_ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
	private Producto producto;

	public CotizacionProducto() {
	}

	public CotizacionProducto(CotizacionProductoPK cotizacionProductoPK) {
		this.cotizacionProductoPK = cotizacionProductoPK;
	}

	public CotizacionProducto(CotizacionProductoPK cotizacionProductoPK, int cantidad) {
		this.cotizacionProductoPK = cotizacionProductoPK;
		this.cantidad = cantidad;
	}

	public CotizacionProducto(int tblProductoIdProducto, String tblCotizacionNumeroCotizacion) {
		this.cotizacionProductoPK = new CotizacionProductoPK(tblProductoIdProducto, tblCotizacionNumeroCotizacion);
	}

	public CotizacionProductoPK getCotizacionProductoPK() {
		return cotizacionProductoPK;
	}

	public void setCotizacionProductoPK(CotizacionProductoPK cotizacionProductoPK) {
		this.cotizacionProductoPK = cotizacionProductoPK;
	}

	public Double getPrecioParaCliente() {
		return precioParaCliente;
	}

	public void setPrecioParaCliente(Double precioParaCliente) {
		this.precioParaCliente = precioParaCliente;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Cotizacion getCotizacion() {
		return cotizacion;
	}

	public void setCotizacion(Cotizacion cotizacion) {
		this.cotizacion = cotizacion;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (cotizacionProductoPK != null ? cotizacionProductoPK.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof CotizacionProducto)) {
			return false;
		}
		CotizacionProducto other = (CotizacionProducto) object;
		if ((this.cotizacionProductoPK == null && other.cotizacionProductoPK != null) || (this.cotizacionProductoPK != null && !this.cotizacionProductoPK.equals(other.cotizacionProductoPK))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.sea.backend.entities.CotizacionProducto[ cotizacionProductoPK=" + cotizacionProductoPK + " ]";
	}
	
}
