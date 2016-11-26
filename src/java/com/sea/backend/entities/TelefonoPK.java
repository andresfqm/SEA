/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.backend.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author homero
 */
@Embeddable
public class TelefonoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "ID_TELEFONO")
    private int idTelefono;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TBL_CLIENTE_ID_CLIENTE")
    private int tblClienteIdCliente;

    public TelefonoPK() {
    }

    public TelefonoPK(int idTelefono, int tblClienteIdCliente) {
        this.idTelefono = idTelefono;
        this.tblClienteIdCliente = tblClienteIdCliente;
    }

    public int getIdTelefono() {
        return idTelefono;
    }

    public void setIdTelefono(int idTelefono) {
        this.idTelefono = idTelefono;
    }

    public int getTblClienteIdCliente() {
        return tblClienteIdCliente;
    }

    public void setTblClienteIdCliente(int tblClienteIdCliente) {
        this.tblClienteIdCliente = tblClienteIdCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idTelefono;
        hash += (int) tblClienteIdCliente;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TelefonoPK)) {
            return false;
        }
        TelefonoPK other = (TelefonoPK) object;
        if (this.idTelefono != other.idTelefono) {
            return false;
        }
        if (this.tblClienteIdCliente != other.tblClienteIdCliente) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sea.backend.entities.TelefonoPK[ idTelefono=" + idTelefono + ", tblClienteIdCliente=" + tblClienteIdCliente + " ]";
    }
    
}
