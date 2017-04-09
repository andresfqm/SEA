/*
 * The MIT License
 *
 * Copyright 2017 homero.
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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author homero
 */
@Entity
@Table(name = "tbl_producto_especificacion_talla")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "ProductoEspecificacionTalla.findAll", query = "SELECT p FROM ProductoEspecificacionTalla p"),
	@NamedQuery(name = "ProductoEspecificacionTalla.findByIdProductoEspecificacionTalla", query = "SELECT p FROM ProductoEspecificacionTalla p WHERE p.idProductoEspecificacionTalla = :idProductoEspecificacionTalla"),
	@NamedQuery(name = "ProductoEspecificacionTalla.findByCantidad", query = "SELECT p FROM ProductoEspecificacionTalla p WHERE p.cantidad = :cantidad")})
public class ProductoEspecificacionTalla implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PRODUCTO_ESPECIFICACION_TALLA")
	private Integer idProductoEspecificacionTalla;
	@Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD")
	private int cantidad;
	@JoinColumn(name = "TBL_TALLA_ID_TALLA", referencedColumnName = "ID_TALLA")
    @ManyToOne(optional = false)
	private Talla tblTallaIdTalla;
	@JoinColumn(name = "TBL_PRODUCTO_ESPECIFICACION_ID_PRODUCTO_ESPECIFICACION", referencedColumnName = "ID_PRODUCTO_ESPECIFICACION")
    @ManyToOne(optional = false)
	private ProductoEspecificacion tblProductoEspecificacionIdProductoEspecificacion;

	public ProductoEspecificacionTalla() {
	}

	public ProductoEspecificacionTalla(Integer idProductoEspecificacionTalla) {
		this.idProductoEspecificacionTalla = idProductoEspecificacionTalla;
	}

	public ProductoEspecificacionTalla(Integer idProductoEspecificacionTalla, int cantidad) {
		this.idProductoEspecificacionTalla = idProductoEspecificacionTalla;
		this.cantidad = cantidad;
	}

	public Integer getIdProductoEspecificacionTalla() {
		return idProductoEspecificacionTalla;
	}

	public void setIdProductoEspecificacionTalla(Integer idProductoEspecificacionTalla) {
		this.idProductoEspecificacionTalla = idProductoEspecificacionTalla;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Talla getTblTallaIdTalla() {
		return tblTallaIdTalla;
	}

	public void setTblTallaIdTalla(Talla tblTallaIdTalla) {
		this.tblTallaIdTalla = tblTallaIdTalla;
	}

	public ProductoEspecificacion getTblProductoEspecificacionIdProductoEspecificacion() {
		return tblProductoEspecificacionIdProductoEspecificacion;
	}

	public void setTblProductoEspecificacionIdProductoEspecificacion(ProductoEspecificacion tblProductoEspecificacionIdProductoEspecificacion) {
		this.tblProductoEspecificacionIdProductoEspecificacion = tblProductoEspecificacionIdProductoEspecificacion;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idProductoEspecificacionTalla != null ? idProductoEspecificacionTalla.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof ProductoEspecificacionTalla)) {
			return false;
		}
		ProductoEspecificacionTalla other = (ProductoEspecificacionTalla) object;
		if ((this.idProductoEspecificacionTalla == null && other.idProductoEspecificacionTalla != null) || (this.idProductoEspecificacionTalla != null && !this.idProductoEspecificacionTalla.equals(other.idProductoEspecificacionTalla))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.sea.backend.entities.ProductoEspecificacionTalla[ idProductoEspecificacionTalla=" + idProductoEspecificacionTalla + " ]";
	}
	
}
