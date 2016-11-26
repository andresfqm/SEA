/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.frontend.controller;


import com.sea.backend.entities.Ciudad;
import com.sea.backend.model.CiudadFacadeLocal;
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
public class CiudadController implements Serializable {
    
    @EJB
    private CiudadFacadeLocal ciudadEJB;
    
    private Ciudad ciudad;

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
    

    
    @PostConstruct
    public void init() {
        ciudad = new Ciudad();
        
    }
    
    public void registrar() {
        ciudadEJB.create(ciudad);
        
    }
    
}
