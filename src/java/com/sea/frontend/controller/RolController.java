/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.frontend.controller;

import com.sea.backend.entities.Rol;
import com.sea.backend.model.RolFacadeLocal;
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
public class RolController implements Serializable {
    
    @EJB
    private RolFacadeLocal rolEJB;
    private Rol rol;
    
    public Rol getRol() {
        return rol;
    }
    
    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    @PostConstruct
    public void init() {
        rol = new Rol();
        
    }
    
    public void registrar() {
        try {
            rolEJB.create(rol);
            
        } catch (Exception e) {
            
        }
        
    }
    
}
