/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.frontend.controller;

import com.sea.backend.entities.PropuestaNoIncluye;
import com.sea.backend.model.PropuestaNoIncluyeFacadeLocal;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author homero
 */
@Named
@ViewScoped
public class PropuestaNoIncluyeController implements Serializable {
    
    @EJB
    private PropuestaNoIncluyeFacadeLocal propuestoNoIncluyeEJB;
    
    private PropuestaNoIncluye propuestaNoI;
    
    public PropuestaNoIncluye getPropuestaNoI() {
        return propuestaNoI;
    }
    
    public void setPropuestaNoI(PropuestaNoIncluye propuestaNoI) {
        this.propuestaNoI = propuestaNoI;
    }
    
    public void init() {
        
        propuestaNoI = new PropuestaNoIncluye();
        
    }
    
    public void registrar() {
        try {
            propuestoNoIncluyeEJB.create(propuestaNoI);
            
        } catch (Exception e) {
            
        }
        
    }
    
}
