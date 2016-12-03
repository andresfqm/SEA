/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.frontend.controller;

import com.mysql.jdbc.Statement;
import com.sea.backend.entities.Categoria;
import com.sea.backend.model.CategoriaFacadeLocal;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
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
    
    private List<Categoria> listaCategoria;
    

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Categoria> getListaCategoria() {
        listaCategoria =  categoriaEJB.findAll();
        return listaCategoria;
    }

    public void setListaCategoria(List<Categoria> listaCategoria) {
        this.listaCategoria = listaCategoria;
    }
    
    public List<Categoria> getListAllName() throws Exception{
        if(listaCategoria == null){
            listaCategoria = categoriaEJB.findAllName("");
        }
        return listaCategoria;
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
    
}
