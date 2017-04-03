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
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author homero
 */
@Embeddable
public class CotizacionProductoPK implements Serializable {

	@Basic(optional = false)
    @NotNull
    @Column(name = "TBL_PRODUCTO_ID_PRODUCTO")
	private int tblProductoIdProducto;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "TBL_COTIZACION_NUMERO_COTIZACION")
	private String tblCotizacionNumeroCotizacion;

	public CotizacionProductoPK() {
	}

	public CotizacionProductoPK(int tblProductoIdProducto, String tblCotizacionNumeroCotizacion) {
		this.tblProductoIdProducto = tblProductoIdProducto;
		this.tblCotizacionNumeroCotizacion = tblCotizacionNumeroCotizacion;
	}

	public int getTblProductoIdProducto() {
		return tblProductoIdProducto;
	}

	public void setTblProductoIdProducto(int tblProductoIdProducto) {
		this.tblProductoIdProducto = tblProductoIdProducto;
	}

	public String getTblCotizacionNumeroCotizacion() {
		return tblCotizacionNumeroCotizacion;
	}

	public void setTblCotizacionNumeroCotizacion(String tblCotizacionNumeroCotizacion) {
		this.tblCotizacionNumeroCotizacion = tblCotizacionNumeroCotizacion;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (int) tblProductoIdProducto;
		hash += (tblCotizacionNumeroCotizacion != null ? tblCotizacionNumeroCotizacion.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof CotizacionProductoPK)) {
			return false;
		}
		CotizacionProductoPK other = (CotizacionProductoPK) object;
		if (this.tblProductoIdProducto != other.tblProductoIdProducto) {
			return false;
		}
		if ((this.tblCotizacionNumeroCotizacion == null && other.tblCotizacionNumeroCotizacion != null) || (this.tblCotizacionNumeroCotizacion != null && !this.tblCotizacionNumeroCotizacion.equals(other.tblCotizacionNumeroCotizacion))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.sea.backend.entities.CotizacionProductoPK[ tblProductoIdProducto=" + tblProductoIdProducto + ", tblCotizacionNumeroCotizacion=" + tblCotizacionNumeroCotizacion + " ]";
	}
	
}
