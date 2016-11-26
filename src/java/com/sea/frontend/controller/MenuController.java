/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.frontend.controller;

import com.sea.backend.entities.Menu;
import com.sea.backend.model.MenuFacadeLocal;
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
public class MenuController implements Serializable {

    @EJB
    private MenuFacadeLocal menuEJB;

    private Menu menu;

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    @PostConstruct
    public void init() {
        menu = new Menu();

    }

    public void registrar() {
        try {

            menuEJB.create(menu);

        } catch (Exception e) {

        }

    }

}
