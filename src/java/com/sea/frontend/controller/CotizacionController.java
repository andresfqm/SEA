/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.frontend.controller;

import com.sea.backend.entities.Cotizacion;
import com.sea.backend.model.CotizacionFacadeLocal;
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
public class CotizacionController implements Serializable {

    @EJB
    private CotizacionFacadeLocal cotizacionEJB;

    private Cotizacion cotizacion;

    public Cotizacion getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(Cotizacion cotizacion) {
        this.cotizacion = cotizacion;
    }

    @PostConstruct
    public void init() {

        cotizacion = new Cotizacion();

    }

    public void registrar() {
        try {
            cotizacionEJB.create(cotizacion);

        } catch (Exception e) {

        }

    }
}
