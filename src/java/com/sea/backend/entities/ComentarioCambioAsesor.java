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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author homero
 */
@Entity
@Table(name = "tbl_comentario_cambio_asesor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComentarioCambioAsesor.findAll", query = "SELECT c FROM ComentarioCambioAsesor c"),
    @NamedQuery(name = "ComentarioCambioAsesor.findByIdComentarioCambioAsesor", query = "SELECT c FROM ComentarioCambioAsesor c WHERE c.idComentarioCambioAsesor = :idComentarioCambioAsesor")})
public class ComentarioCambioAsesor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_COMENTARIO_CAMBIO_ASESOR")
    private Integer idComentarioCambioAsesor;
    @Lob
    @Size(max = 65535)
    @Column(name = "COMENTARIO")
    private String comentario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblComentarioCambioAsesorIdComentarioCambioAsesor")
    private List<Cliente> clienteList;

    public ComentarioCambioAsesor() {
    }

    public ComentarioCambioAsesor(Integer idComentarioCambioAsesor) {
        this.idComentarioCambioAsesor = idComentarioCambioAsesor;
    }

    public Integer getIdComentarioCambioAsesor() {
        return idComentarioCambioAsesor;
    }

    public void setIdComentarioCambioAsesor(Integer idComentarioCambioAsesor) {
        this.idComentarioCambioAsesor = idComentarioCambioAsesor;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @XmlTransient
    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComentarioCambioAsesor != null ? idComentarioCambioAsesor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComentarioCambioAsesor)) {
            return false;
        }
        ComentarioCambioAsesor other = (ComentarioCambioAsesor) object;
        if ((this.idComentarioCambioAsesor == null && other.idComentarioCambioAsesor != null) || (this.idComentarioCambioAsesor != null && !this.idComentarioCambioAsesor.equals(other.idComentarioCambioAsesor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sea.backend.entities.ComentarioCambioAsesor[ idComentarioCambioAsesor=" + idComentarioCambioAsesor + " ]";
    }
    
}
