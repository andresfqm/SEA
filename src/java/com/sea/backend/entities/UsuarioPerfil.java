/*
 * The MIT License
 *
 * Copyright 2017 EdisonArturo.
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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author EdisonArturo
 */
@Entity
@Table(name = "tbl_usuario_perfil")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "UsuarioPerfil.findAll", query = "SELECT u FROM UsuarioPerfil u"),
	@NamedQuery(name = "UsuarioPerfil.findByIdUsuarioPerfil", query = "SELECT u FROM UsuarioPerfil u WHERE u.idUsuarioPerfil = :idUsuarioPerfil")})
public class UsuarioPerfil implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_USUARIO_PERFIL")
	private Integer idUsuarioPerfil;
	@JoinColumn(name = "TBL_PERFIL_ID_PERFIL", referencedColumnName = "ID_PERFIL")
    @ManyToOne(optional = false)
	private Perfil tblPerfilIdPerfil;
	@JoinColumn(name = "TBL_USUARIO_ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false)
	private Usuario tblUsuarioIdUsuario;

	public UsuarioPerfil() {
	}

	public UsuarioPerfil(Integer idUsuarioPerfil) {
		this.idUsuarioPerfil = idUsuarioPerfil;
	}

	public Integer getIdUsuarioPerfil() {
		return idUsuarioPerfil;
	}

	public void setIdUsuarioPerfil(Integer idUsuarioPerfil) {
		this.idUsuarioPerfil = idUsuarioPerfil;
	}

	public Perfil getTblPerfilIdPerfil() {
		return tblPerfilIdPerfil;
	}

	public void setTblPerfilIdPerfil(Perfil tblPerfilIdPerfil) {
		this.tblPerfilIdPerfil = tblPerfilIdPerfil;
	}

	public Usuario getTblUsuarioIdUsuario() {
		return tblUsuarioIdUsuario;
	}

	public void setTblUsuarioIdUsuario(Usuario tblUsuarioIdUsuario) {
		this.tblUsuarioIdUsuario = tblUsuarioIdUsuario;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idUsuarioPerfil != null ? idUsuarioPerfil.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof UsuarioPerfil)) {
			return false;
		}
		UsuarioPerfil other = (UsuarioPerfil) object;
		if ((this.idUsuarioPerfil == null && other.idUsuarioPerfil != null) || (this.idUsuarioPerfil != null && !this.idUsuarioPerfil.equals(other.idUsuarioPerfil))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.sea.backend.entities.UsuarioPerfil[ idUsuarioPerfil=" + idUsuarioPerfil + " ]";
	}
	
}
