/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.frontend.controller;

import com.sea.backend.entities.Usuario;
import com.sea.backend.model.UsuarioFacadeLocal;
import com.sea.frontend.converters.Conversor;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author homero
 */
@Named
@ViewScoped
public class UsuarioController implements Serializable {
    
    @EJB
    private UsuarioFacadeLocal usuarioEJB;
    
    private Usuario usuario;
    
    public Usuario getUsuario() {
        return usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    @PostConstruct
    public void init() {
        usuario = new Usuario();
        
    }
    
    public void registrar() {
        try {
            usuarioEJB.create(usuario);
            
        } catch (Exception e) {
            
        }
        
    }
    
    public SelectItem[] getItemsAvailableSelectOne() {
        return Conversor.getSelectItems(usuarioEJB.findAll(), true);
    }
    
    public Usuario getUsuario(java.lang.Integer id) {
        return usuarioEJB.find(id);
    }
    
}
