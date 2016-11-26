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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author homero
 */
@Entity
@Table(name = "tbl_sufijo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sufijo.findAll", query = "SELECT s FROM Sufijo s"),
    @NamedQuery(name = "Sufijo.findByIdSufijo", query = "SELECT s FROM Sufijo s WHERE s.idSufijo = :idSufijo"),
    @NamedQuery(name = "Sufijo.findByCodigo", query = "SELECT s FROM Sufijo s WHERE s.codigo = :codigo")})
public class Sufijo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_SUFIJO")
    private Integer idSufijo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CODIGO")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "DESCRIPCION_FABRICANTE")
    private String descripcionFabricante;
    @ManyToMany(mappedBy = "sufijoList")
    private List<Producto> productoList;

    public Sufijo() {
    }

    public Sufijo(Integer idSufijo) {
        this.idSufijo = idSufijo;
    }

    public Sufijo(Integer idSufijo, String codigo, String descripcionFabricante) {
        this.idSufijo = idSufijo;
        this.codigo = codigo;
        this.descripcionFabricante = descripcionFabricante;
    }

    public Integer getIdSufijo() {
        return idSufijo;
    }

    public void setIdSufijo(Integer idSufijo) {
        this.idSufijo = idSufijo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcionFabricante() {
        return descripcionFabricante;
    }

    public void setDescripcionFabricante(String descripcionFabricante) {
        this.descripcionFabricante = descripcionFabricante;
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
        hash += (idSufijo != null ? idSufijo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sufijo)) {
            return false;
        }
        Sufijo other = (Sufijo) object;
        if ((this.idSufijo == null && other.idSufijo != null) || (this.idSufijo != null && !this.idSufijo.equals(other.idSufijo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sea.backend.entities.Sufijo[ idSufijo=" + idSufijo + " ]";
    }
    
}
