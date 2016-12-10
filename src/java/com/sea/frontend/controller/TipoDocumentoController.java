/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.frontend.controller;

import com.sea.backend.entities.TipoDocumento;
import com.sea.backend.model.TipoDocumentoFacadeLocal;
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
public class TipoDocumentoController implements Serializable {

    @EJB
    private TipoDocumentoFacadeLocal tipoDocumentoEJB;
    private TipoDocumento tipoD;

    public TipoDocumento getTipoD() {
        return tipoD;
    }

    public void setTipoD(TipoDocumento tipoD) {
        this.tipoD = tipoD;
    }

    @PostConstruct
    public void init() {
        tipoD = new TipoDocumento();

    }

    public void registrar() {
        try {
            tipoDocumentoEJB.create(tipoD);
        } catch (Exception e) {

        }

    }
    
    public SelectItem[] getItemsAvailableSelectOne() {
        return Conversor.getSelectItems(tipoDocumentoEJB.findAll(), true);
    }
    
    public TipoDocumento getUsuario(java.lang.Integer id) {
        return tipoDocumentoEJB.find(id);
    }

}
