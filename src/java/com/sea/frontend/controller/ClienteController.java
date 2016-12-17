
package com.sea.frontend.controller;

import com.sea.backend.entities.Cliente;
import com.sea.backend.model.ClienteFacadeLocal;

import java.io.Serializable;
import java.util.List;
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

    private Object datosCliente;
    private int idCliente;
    private List<Cliente> clientes;

    //Obteniendo todos los datos del cliente
    public void obtenerDatosCliente() throws Exception {
        try {
            datosCliente = clienteEJB.datosCliente(idCliente);
        } catch (Exception e) {
            throw e;
        }

    }

    @PostConstruct
    public void init() {
        clientes = clienteEJB.findAll();
    }

    public Object getCliente() {
        return datosCliente;
    }

    public void setCliente(Object cliente) {
        this.datosCliente = cliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
}
