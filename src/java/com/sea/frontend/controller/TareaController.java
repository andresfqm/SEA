/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.frontend.controller;

import com.sea.backend.entities.Tarea;
import com.sea.backend.model.TareaFacadeLocal;
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
public class TareaController implements Serializable {
    
    @EJB
    private TareaFacadeLocal tareaEJB;
    private Tarea tarea;
    
    public Tarea getTarea() {
        return tarea;
    }
    
    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }
    
    @PostConstruct
    public void init() {
        tarea = new Tarea();
        
    }
    
    public void registrar() {
        try {
            tareaEJB.create(tarea);
        } catch (Exception e) {
            
        }
        
    }
    
}
