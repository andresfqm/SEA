/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.frontend.controller;

import com.sea.backend.entities.Categoria;
import com.sea.backend.model.CategoriaFacadeLocal;
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
public class CategoriaController implements Serializable {

    @EJB
    private CategoriaFacadeLocal categoriaEJB;

    private Categoria categoria;

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @PostConstruct
    public void init() {
        categoria = new Categoria();

    }

    public void registrar() {

        try {

            categoriaEJB.create(categoria);
        } catch (Exception e) {

        }

    }
    
    public void verCategorias() {

        try {

            categoriaEJB.findAll();
        } catch (Exception e) {

        }

    }

}
