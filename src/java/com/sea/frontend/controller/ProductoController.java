/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.frontend.controller;

import com.sea.backend.entities.Producto;
import com.sea.backend.model.ProductoFacadeLocal;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author homero
 */
@Named
@ViewScoped
public class ProductoController implements Serializable {

    @EJB
    private ProductoFacadeLocal productoEJB;
    private Producto producto;

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @PostConstruct
    public void init() {

        producto = new Producto();

    }

    public void registrar() {
        try {
            productoEJB.create(producto);

        } catch (Exception e) {

        }

    }
}
