/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.frontend.controller;

import com.sea.backend.entities.Cliente;
import com.sea.backend.model.ClienteFacadeLocal;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author homero
 */
@Named
@ViewScoped
public class ClienteController implements Serializable {

    @EJB
    private ClienteFacadeLocal clienteEJB;

    private Object[] cliente;
    private int idCliente;

    //Obteniendo todos los datos del cliente
    public void obtenerDatosCliente() throws Exception {
        try {
            cliente = clienteEJB.datosCliente(idCliente);
        } catch (Exception e) {
            throw e;
        }

    }

    @PostConstruct
    public void init() {

      

    }

    public Object[] getCliente() {
        return cliente;
    }

    public void setCliente(Object[] cliente) {
        this.cliente = cliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

}
