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
@Table(name = "tbl_producto_especificacion_talla")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "ProductoEspecificacionTalla.findAll", query = "SELECT p FROM ProductoEspecificacionTalla p")
	, @NamedQuery(name = "ProductoEspecificacionTalla.findByTblTallaIdTalla", query = "SELECT p FROM ProductoEspecificacionTalla p WHERE p.productoEspecificacionTallaPK.tblTallaIdTalla = :tblTallaIdTalla")
	, @NamedQuery(name = "ProductoEspecificacionTalla.findByTblProductoEspecificacionIdProductoEspecificacion", query = "SELECT p FROM ProductoEspecificacionTalla p WHERE p.productoEspecificacionTallaPK.tblProductoEspecificacionIdProductoEspecificacion = :tblProductoEspecificacionIdProductoEspecificacion")
	, @NamedQuery(name = "ProductoEspecificacionTalla.findByCantidad", query = "SELECT p FROM ProductoEspecificacionTalla p WHERE p.cantidad = :cantidad")})
public class ProductoEspecificacionTalla implements Serializable {

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	protected ProductoEspecificacionTallaPK productoEspecificacionTallaPK;
	@Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD")
	private int cantidad;
	@JoinColumn(name = "TBL_TALLA_ID_TALLA", referencedColumnName = "ID_TALLA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
	private Talla talla;
	@JoinColumn(name = "TBL_PRODUCTO_ESPECIFICACION_ID_PRODUCTO_ESPECIFICACION", referencedColumnName = "ID_PRODUCTO_ESPECIFICACION", insertable = false, updatable = false)
    @ManyToOne(optional = false)
	private ProductoEspecificacion productoEspecificacion;

	public ProductoEspecificacionTalla() {
	}

	public ProductoEspecificacionTalla(ProductoEspecificacionTallaPK productoEspecificacionTallaPK) {
		this.productoEspecificacionTallaPK = productoEspecificacionTallaPK;
	}

	public ProductoEspecificacionTalla(ProductoEspecificacionTallaPK productoEspecificacionTallaPK, int cantidad) {
		this.productoEspecificacionTallaPK = productoEspecificacionTallaPK;
		this.cantidad = cantidad;
	}

	public ProductoEspecificacionTalla(int tblTallaIdTalla, int tblProductoEspecificacionIdProductoEspecificacion) {
		this.productoEspecificacionTallaPK = new ProductoEspecificacionTallaPK(tblTallaIdTalla, tblProductoEspecificacionIdProductoEspecificacion);
	}

	public ProductoEspecificacionTallaPK getProductoEspecificacionTallaPK() {
		return productoEspecificacionTallaPK;
	}

	public void setProductoEspecificacionTallaPK(ProductoEspecificacionTallaPK productoEspecificacionTallaPK) {
		this.productoEspecificacionTallaPK = productoEspecificacionTallaPK;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Talla getTalla() {
		return talla;
	}

	public void setTalla(Talla talla) {
		this.talla = talla;
	}

	public ProductoEspecificacion getProductoEspecificacion() {
		return productoEspecificacion;
	}

	public void setProductoEspecificacion(ProductoEspecificacion productoEspecificacion) {
		this.productoEspecificacion = productoEspecificacion;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (productoEspecificacionTallaPK != null ? productoEspecificacionTallaPK.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof ProductoEspecificacionTalla)) {
			return false;
		}
		ProductoEspecificacionTalla other = (ProductoEspecificacionTalla) object;
		if ((this.productoEspecificacionTallaPK == null && other.productoEspecificacionTallaPK != null) || (this.productoEspecificacionTallaPK != null && !this.productoEspecificacionTallaPK.equals(other.productoEspecificacionTallaPK))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.sea.backend.entities.ProductoEspecificacionTalla[ productoEspecificacionTallaPK=" + productoEspecificacionTallaPK + " ]";
	}
	
}
