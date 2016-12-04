/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.frontend.controller;

import com.sea.backend.entities.Material;
import com.sea.backend.model.MaterialFacadeLocal;
import java.io.Serializable;
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
public class MaterialController implements Serializable {

    @EJB
    private MaterialFacadeLocal materialEJB;

    private Material material;
    
    private List<Material> materiales;

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public List<Material> getMateriales() {
        materiales = materialEJB.findAll();
        return materiales;
    }

    public void setMateriales(List<Material> materiales) {
        this.materiales = materiales;
    }
    
    

    @PostConstruct
    public void init() {
        material = new Material();

    }

    public void registrar() {
        try {
            materialEJB.create(material);
        } catch (Exception e) {

        }

    }

}
