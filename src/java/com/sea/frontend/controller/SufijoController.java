/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.frontend.controller;

import com.sea.backend.entities.Sufijo;
import com.sea.backend.model.SufijoFacadeLocal;
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
public class SufijoController implements Serializable {

    @EJB
    private SufijoFacadeLocal sufijoEJB;
    private Sufijo sufijo;

    public Sufijo getSufijo() {
        return sufijo;
    }

    public void setSufijo(Sufijo sufijo) {
        this.sufijo = sufijo;
    }

    @PostConstruct
    public void init() {
        sufijo = new Sufijo();

    }

    public void registrar() {
        try {
            sufijoEJB.create(sufijo);
        } catch (Exception e) {

        }

    }

}
