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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "tbl_subcategoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subcategoria.findAll", query = "SELECT s FROM Subcategoria s"),
    @NamedQuery(name = "Subcategoria.findByIdSubcategoria", query = "SELECT s FROM Subcategoria s WHERE s.idSubcategoria = :idSubcategoria"),
    @NamedQuery(name = "Subcategoria.findByNombre", query = "SELECT s FROM Subcategoria s WHERE s.nombre = :nombre"),
    @NamedQuery(name = "Subcategoria.findByCodigo", query = "SELECT s FROM Subcategoria s WHERE s.codigo = :codigo")})
public class Subcategoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_SUBCATEGORIA")
    private Integer idSubcategoria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "CODIGO")
    private String codigo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblSubcategoriaIdSubcategoria")
    private List<Producto> productoList;
    @JoinColumn(name = "TBL_CATEGORIA_ID_CATEGORIA", referencedColumnName = "ID_CATEGORIA")
    @ManyToOne(optional = false)
    private Categoria tblCategoriaIdCategoria;

    public Subcategoria() {
    }

    public Subcategoria(Integer idSubcategoria) {
        this.idSubcategoria = idSubcategoria;
    }

    public Subcategoria(Integer idSubcategoria, String nombre, String codigo) {
        this.idSubcategoria = idSubcategoria;
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public Integer getIdSubcategoria() {
        return idSubcategoria;
    }

    public void setIdSubcategoria(Integer idSubcategoria) {
        this.idSubcategoria = idSubcategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @XmlTransient
    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    public Categoria getTblCategoriaIdCategoria() {
        return tblCategoriaIdCategoria;
    }

    public void setTblCategoriaIdCategoria(Categoria tblCategoriaIdCategoria) {
        this.tblCategoriaIdCategoria = tblCategoriaIdCategoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSubcategoria != null ? idSubcategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subcategoria)) {
            return false;
        }
        Subcategoria other = (Subcategoria) object;
        if ((this.idSubcategoria == null && other.idSubcategoria != null) || (this.idSubcategoria != null && !this.idSubcategoria.equals(other.idSubcategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sea.backend.entities.Subcategoria[ idSubcategoria=" + idSubcategoria + " ]";
    }
    
}
