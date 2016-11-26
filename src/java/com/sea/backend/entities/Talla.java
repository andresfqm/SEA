/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.backend.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author homero
 */
@Entity
@Table(name = "tbl_talla")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Talla.findAll", query = "SELECT t FROM Talla t"),
    @NamedQuery(name = "Talla.findByIdTalla", query = "SELECT t FROM Talla t WHERE t.idTalla = :idTalla"),
    @NamedQuery(name = "Talla.findByTalla", query = "SELECT t FROM Talla t WHERE t.talla = :talla")})
public class Talla implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TALLA")
    private Integer idTalla;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "TALLA")
    private String talla;

    public Talla() {
    }

    public Talla(Integer idTalla) {
        this.idTalla = idTalla;
    }

    public Talla(Integer idTalla, String talla) {
        this.idTalla = idTalla;
        this.talla = talla;
    }

    public Integer getIdTalla() {
        return idTalla;
    }

    public void setIdTalla(Integer idTalla) {
        this.idTalla = idTalla;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTalla != null ? idTalla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Talla)) {
            return false;
        }
        Talla other = (Talla) object;
        if ((this.idTalla == null && other.idTalla != null) || (this.idTalla != null && !this.idTalla.equals(other.idTalla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sea.backend.entities.Talla[ idTalla=" + idTalla + " ]";
    }
    
}
