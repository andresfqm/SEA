/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.frontend.controller;

import com.sea.backend.entities.Ciudad;
import com.sea.backend.entities.Cliente;
import com.sea.backend.entities.Cotizacion;
import com.sea.backend.entities.Direccion;
import com.sea.backend.entities.Producto;
import com.sea.backend.model.CiudadFacadeLocal;
import com.sea.backend.model.ClienteFacadeLocal;
import com.sea.backend.model.CotizacionFacadeLocal;
import com.sea.backend.model.DireccionFacadeLocal;
import com.sea.backend.model.ProductoFacadeLocal;
import java.io.Serializable;
import java.util.Date;
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
        cotizacion.setFechaEmision(new Date());
        clientes = clienteEJB.findAll();
        

    }

    @EJB
    private ClienteFacadeLocal clienteEJB;
    private List<Cliente> clientes;
    private int idCliente;

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

}
