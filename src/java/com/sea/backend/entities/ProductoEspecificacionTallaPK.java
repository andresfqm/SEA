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
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Depurador
 */
@Embeddable
public class ProductoEspecificacionTallaPK implements Serializable {

	@Basic(optional = false)
	@NotNull
	@Column(name = "TBL_TALLA_ID_TALLA")
	private int tblTallaIdTalla;
	@Basic(optional = false)
	@NotNull
	@Column(name = "TBL_PRODUCTO_ESPECIFICACION_ID_PRODUCTO_ESPECIFICACION")
	private int tblProductoEspecificacionIdProductoEspecificacion;

	public ProductoEspecificacionTallaPK() {
	}

	public ProductoEspecificacionTallaPK(int tblTallaIdTalla, int tblProductoEspecificacionIdProductoEspecificacion) {
		this.tblTallaIdTalla = tblTallaIdTalla;
		this.tblProductoEspecificacionIdProductoEspecificacion = tblProductoEspecificacionIdProductoEspecificacion;
	}

	public int getTblTallaIdTalla() {
		return tblTallaIdTalla;
	}

	public void setTblTallaIdTalla(int tblTallaIdTalla) {
		this.tblTallaIdTalla = tblTallaIdTalla;
	}

	public int getTblProductoEspecificacionIdProductoEspecificacion() {
		return tblProductoEspecificacionIdProductoEspecificacion;
	}

	public void setTblProductoEspecificacionIdProductoEspecificacion(int tblProductoEspecificacionIdProductoEspecificacion) {
		this.tblProductoEspecificacionIdProductoEspecificacion = tblProductoEspecificacionIdProductoEspecificacion;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (int) tblTallaIdTalla;
		hash += (int) tblProductoEspecificacionIdProductoEspecificacion;
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof ProductoEspecificacionTallaPK)) {
			return false;
		}
		ProductoEspecificacionTallaPK other = (ProductoEspecificacionTallaPK) object;
		if (this.tblTallaIdTalla != other.tblTallaIdTalla) {
			return false;
		}
		if (this.tblProductoEspecificacionIdProductoEspecificacion != other.tblProductoEspecificacionIdProductoEspecificacion) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.sea.backend.entities.ProductoEspecificacionTallaPK[ tblTallaIdTalla=" + tblTallaIdTalla + ", tblProductoEspecificacionIdProductoEspecificacion=" + tblProductoEspecificacionIdProductoEspecificacion + " ]";
	}

}
