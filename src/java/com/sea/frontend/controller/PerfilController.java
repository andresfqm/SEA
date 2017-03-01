/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.frontend.controller;

import com.sea.backend.entities.Perfil;
import com.sea.backend.model.PerfilFacadeLocal;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author homero
 */
@Named
@ViewScoped
public class PerfilController implements Serializable {

	@EJB
	private PerfilFacadeLocal perfilEJB;
	private Perfil perfil;

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public void init() {
		perfil = new Perfil();

	}

	public void registrar() {
		try {
			perfilEJB.create(perfil);

		} catch (Exception e) {

		}

	}

}
