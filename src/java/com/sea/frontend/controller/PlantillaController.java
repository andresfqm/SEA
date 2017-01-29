/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.frontend.controller;

import com.sea.backend.entities.Usuario;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author homero
 */
@Named
@ViewScoped
public class PlantillaController implements Serializable {

    public void verificarSesion() {

        try {
            FacesContext context = FacesContext.getCurrentInstance();
           
            Usuario us = (Usuario) context.getExternalContext().getSessionMap().get("usuario");

            if (us == null) {
                
               context.getExternalContext().redirect( "/SEA/auth");
                

            }   
        } catch (Exception e) {
            // log para guardar un registro de error
        }

    }
    
    public void verificarSesionLogin() {

        try {
            FacesContext context = FacesContext.getCurrentInstance();
           
            Usuario us = (Usuario) context.getExternalContext().getSessionMap().get("usuario");

            if (us != null) {
                
            context.getExternalContext().redirect( "/SEA/index.xhtml");
                

            }   
        } catch (Exception e) {
            // log para guardar un registro de error
        }

    }

}
