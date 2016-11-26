package com.sea.backend.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class EmailPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "ID_EMAIL")
    private int idEmail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TBL_CLIENTE_ID_CLIENTE")
    private int tblClienteIdCliente;

    public EmailPK() {
    }

    public  EmailPK(int idEmail, int tblClienteIdCliente) {
        this.idEmail = idEmail;
        this.tblClienteIdCliente = tblClienteIdCliente;
    }

    public int getIdEmail() {
        return idEmail;
    }

    public void setIdEmail(int idEmail) {
        this.idEmail = idEmail;
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
        hash += (int) idEmail;
        hash += (int) tblClienteIdCliente;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmailPK)) {
            return false;
        }
        EmailPK other = (EmailPK) object;
        if (this.idEmail != other.idEmail) {
            return false;
        }
        if (this.tblClienteIdCliente != other.tblClienteIdCliente) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sea.backend.entities.EmailPK[ idEmail=" + idEmail + ", tblClienteIdCliente=" + tblClienteIdCliente + " ]";
    }

}
