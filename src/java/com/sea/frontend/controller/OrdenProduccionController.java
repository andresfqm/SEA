/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.frontend.controller;

import com.sea.backend.entities.OrdenProduccion;
import com.sea.backend.model.OrdenProduccionFacadeLocal;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author homero
 */
@Named
@ViewScoped
public class OrdenProduccionController implements Serializable {

    @Named
    private OrdenProduccionFacadeLocal ordenPruduccionEJB;

    private OrdenProduccion ordenP;

    public OrdenProduccion getOrdenP() {
        return ordenP;
    }

    public void setOrdenP(OrdenProduccion ordenP) {
        this.ordenP = ordenP;
    }

    @PostConstruct
    public void init() {
        ordenP = new OrdenProduccion();

    }

    public void registrar() {
        try {
            ordenPruduccionEJB.create(ordenP);
        } catch (Exception e) {

        }

    }

}
