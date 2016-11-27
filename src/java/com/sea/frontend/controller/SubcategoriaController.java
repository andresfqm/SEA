/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.frontend.controller;

import com.sea.backend.entities.Subcategoria;
import com.sea.backend.model.SubcategoriaFacadeLocal;
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
public class SubcategoriaController implements Serializable {
    
    @EJB
    private SubcategoriaFacadeLocal SubcategoriaEJB;
    
    private Subcategoria subcategoria;
    
    public Subcategoria getSubcategoria() {
        return subcategoria;
    }
    
    public void setSubcategoria(Subcategoria subcategoria) {
        this.subcategoria = subcategoria;
    }
    
    @PostConstruct
    public void init() {
        subcategoria = new Subcategoria();
        
    }
    
    public void registrar() {
        
        try {
            SubcategoriaEJB.create(subcategoria);
        } catch (Exception e) {
            
        }
        
    }
    
}
