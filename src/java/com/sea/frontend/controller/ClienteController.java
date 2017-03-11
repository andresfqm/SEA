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
	private Cliente cliente;

	@PostConstruct
	public void init() {
		cliente = new Cliente();

	}
	
	
}
