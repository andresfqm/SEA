/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.frontend.controller;

import com.sea.backend.entities.Ciudad;
import com.sea.backend.entities.Cliente;
import com.sea.backend.entities.Departamento;
import com.sea.backend.entities.Direccion;
import com.sea.backend.entities.Email;
import com.sea.backend.entities.Producto;
import com.sea.backend.entities.Telefono;
import com.sea.backend.model.CiudadFacadeLocal;
import com.sea.backend.model.ClienteFacadeLocal;
import com.sea.backend.model.DepartamentoFacadeLocal;
import com.sea.backend.model.DireccionFacadeLocal;
import com.sea.backend.model.EmailFacadeLocal;
import com.sea.backend.model.ProductoFacadeLocal;
import com.sea.backend.model.TelefonoFacadeLocal;

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
public class ConsultaController implements Serializable {

    @EJB
    private ProductoFacadeLocal productoEJB;
    private List<Producto> producto;
    private int idProducto;
    private Producto productoDescripcion;
    private int idCliente;

    public List<Producto> getProducto() {
        return producto;
    }

    public void setProducto(List<Producto> producto) {
        this.producto = producto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public void obtenerDescripcionReferencia() throws Exception {
        try {
            productoDescripcion = productoEJB.productoDescripcion(idProducto);
        } catch (Exception e) {
            throw e;
        }

    }

    public Producto getProductoDescripcion() {
        return productoDescripcion;
    }

    public void setProductoDescripcion(Producto productoDescripcion) {
        this.productoDescripcion = productoDescripcion;
    }

    @PostConstruct
    public void init() {
        ciudad = ciudadEJB.findAll();
        producto = productoEJB.findAll();
        //departamento = departamentoEJB.findAll();
        //email = emailEJB.findAll();
        //telefono = telefonoEJB.findAll();

    }

    @EJB
    private CiudadFacadeLocal ciudadEJB;
    private List<Ciudad> ciudad;

    public List<Ciudad> getCiudad() {
        return ciudad;
    }

    public void setCiudad(List<Ciudad> ciudad) {
        this.ciudad = ciudad;
    }

    @EJB
    private DireccionFacadeLocal direccionEJB;
    private Direccion direccionCliente;

    public void obtenerDireccionCliente() throws Exception {
        try {
            direccionCliente = direccionEJB.direccionCliente(idCliente);
        } catch (Exception e) {
            throw e;
        }

    }

    public Direccion getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(Direccion direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

}