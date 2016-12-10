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
import com.sea.backend.entities.Telefono;
import com.sea.backend.model.CiudadFacadeLocal;
import com.sea.backend.model.ClienteFacadeLocal;
import com.sea.backend.model.DepartamentoFacadeLocal;
import com.sea.backend.model.DireccionFacadeLocal;
import com.sea.backend.model.EmailFacadeLocal;
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
    private ClienteFacadeLocal clienteEJB;
    private List<Cliente> clientes;
    private int idCliente;

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

    @PostConstruct
    public void init() {
        //clientes = clienteEJB.findAll();
       ciudad = ciudadEJB.findAll();
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
    public void obtenerDireccionCliente() throws Exception{
        try {
            direccionCliente=direccionEJB.direccionCliente(idCliente);
        } catch (Exception e) {
            throw e;
        }
        
        
    }
    
    /*
    @EJB
    private DepartamentoFacadeLocal departamentoEJB;
    private List<Departamento> departamento;

    public List<Departamento> getDepartamento() {
        return departamento;
    }

    public void setDepartamento(List<Departamento> departamento) {
        this.departamento = departamento;
    }

    @EJB
    private EmailFacadeLocal emailEJB;

    private List<Email> email;

    public List<Email> getEmail() {
        return email;
    }

    public void setEmail(List<Email> email) {
        this.email = email;
    }

    @EJB
    private TelefonoFacadeLocal telefonoEJB;

    private List<Telefono> telefono;

    public List<Telefono> getTelefono() {
        return telefono;
    }

    public void setTelefono(List<Telefono> telefono) {
        this.telefono = telefono;
    }
*/

    public Direccion getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(Direccion direccionCliente) {
        this.direccionCliente = direccionCliente;
    }
}
