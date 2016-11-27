/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.frontend.controller;

import com.sea.backend.entities.Pagina;
import com.sea.backend.model.PaginaFacadeLocal;
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
public class PaginaController implements Serializable {

    @EJB
    private PaginaFacadeLocal paginaEJB;

    private Pagina pagina;

    public Pagina getPagina() {
        return pagina;
    }

    public void setPagina(Pagina pagina) {
        this.pagina = pagina;
    }

    @PostConstruct
    public void init() {

        pagina = new Pagina();

    }
    
    public void registrar(){
        try{
            
            paginaEJB.create(pagina);
        }catch(Exception e){
        
        }
    
    }

}
