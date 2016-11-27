/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.frontend.controller;

import com.sea.backend.entities.TipoTelefono;
import com.sea.backend.model.TipoTelefonoFacadeLocal;
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
public class TipoTelefonoController implements Serializable {
    
    @EJB
    private TipoTelefonoFacadeLocal tipoTelefonoEJB;
    
    private TipoTelefono tipoT;
    
    public TipoTelefono getTipoT() {
        return tipoT;
    }
    
    public void setTipoT(TipoTelefono tipoT) {
        this.tipoT = tipoT;
    }
    
    @PostConstruct
    public void init() {
        tipoT = new TipoTelefono();
        
    }
    
    public void registrar() {
        try {
            tipoTelefonoEJB.create(tipoT);
            
        } catch (Exception e) {
            
        }
        
    }
    
}
