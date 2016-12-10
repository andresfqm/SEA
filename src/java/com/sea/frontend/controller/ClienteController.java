/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.frontend.controller;

import com.sea.backend.entities.Cliente;
import com.sea.backend.model.ClienteFacadeLocal;
import java.io.Serializable;
import java.util.List;
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
    private List<Cliente> listaClientes;
    private Cliente cliente;

    public List<Cliente> getListaClientes() {
        listaClientes = clienteEJB.findAll();
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }
    
    

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @PostConstruct
    public void init() {

        cliente = new Cliente();

    }

    public void registrar() {
        clienteEJB.create(cliente);

    }

}
