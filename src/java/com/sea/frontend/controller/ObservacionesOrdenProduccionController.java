/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.frontend.controller;

import com.sea.backend.entities.ObservacionesOrdenProduccion;
import com.sea.backend.model.ObservacionesOrdenProduccionFacadeLocal;
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
public class ObservacionesOrdenProduccionController implements Serializable {

	@EJB
	private ObservacionesOrdenProduccionFacadeLocal observacionesOPEJB;

	private ObservacionesOrdenProduccion observacionesOP;

	public ObservacionesOrdenProduccion getObservacionesOP() {
		return observacionesOP;
	}

	public void setObservacionesOP(ObservacionesOrdenProduccion observacionesOP) {
		this.observacionesOP = observacionesOP;
	}

	@PostConstruct
	public void init() {
		observacionesOP = new ObservacionesOrdenProduccion();

	}

	public void registrar() {
		try {
			observacionesOPEJB.create(observacionesOP);

		} catch (Exception e) {

		}

	}
}
