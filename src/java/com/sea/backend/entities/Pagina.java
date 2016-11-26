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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "tbl_pagina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pagina.findAll", query = "SELECT p FROM Pagina p"),
    @NamedQuery(name = "Pagina.findByIdPagina", query = "SELECT p FROM Pagina p WHERE p.idPagina = :idPagina"),
    @NamedQuery(name = "Pagina.findByNombre", query = "SELECT p FROM Pagina p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Pagina.findByUrl", query = "SELECT p FROM Pagina p WHERE p.url = :url")})
public class Pagina implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PAGINA")
    private Integer idPagina;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "URL")
    private String url;
    @JoinColumn(name = "TBL_MENU_ID_MENU", referencedColumnName = "ID_MENU")
    @ManyToOne(optional = false)
    private Menu tblMenuIdMenu;

    public Pagina() {
    }

    public Pagina(Integer idPagina) {
        this.idPagina = idPagina;
    }

    public Pagina(Integer idPagina, String nombre, String descripcion, String url) {
        this.idPagina = idPagina;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.url = url;
    }

    public Integer getIdPagina() {
        return idPagina;
    }

    public void setIdPagina(Integer idPagina) {
        this.idPagina = idPagina;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Menu getTblMenuIdMenu() {
        return tblMenuIdMenu;
    }

    public void setTblMenuIdMenu(Menu tblMenuIdMenu) {
        this.tblMenuIdMenu = tblMenuIdMenu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPagina != null ? idPagina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pagina)) {
            return false;
        }
        Pagina other = (Pagina) object;
        if ((this.idPagina == null && other.idPagina != null) || (this.idPagina != null && !this.idPagina.equals(other.idPagina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sea.backend.entities.Pagina[ idPagina=" + idPagina + " ]";
    }
    
}
