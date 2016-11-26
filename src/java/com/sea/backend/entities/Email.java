/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.backend.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author homero
 */
@Entity
@Table(name = "tbl_email")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Email.findAll", query = "SELECT e FROM Email e"),
    @NamedQuery(name = "Email.findByIdEmail", query = "SELECT e FROM Email e WHERE e.emailPK.idEmail = :idEmail"),
    @NamedQuery(name = "Email.findByEmail", query = "SELECT e FROM Email e WHERE e.email = :email"),
    @NamedQuery(name = "Email.findByTblClienteIdCliente", query = "SELECT e FROM Email e WHERE e.emailPK.tblClienteIdCliente = :tblClienteIdCliente")})
public class Email implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EmailPK emailPK;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "EMAIL")
    private String email;
    @JoinColumn(name = "TBL_CLIENTE_ID_CLIENTE", referencedColumnName = "ID_CLIENTE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cliente cliente;
    @JoinColumn(name = "TBL_TIPO_EMAIL_ID_TIPO_EMAIL", referencedColumnName = "ID_TIPO_EMAIL")
    @ManyToOne
    private TipoEmail tblTipoEmailIdTipoEmail;
    @JoinColumn(name = "TBL_USUARIO_ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false)
    private Usuario tblUsuarioIdUsuario;

    public Email() {
    }

    public Email(EmailPK emailPK) {
        this.emailPK = emailPK;
    }

    public Email(EmailPK emailPK, String email) {
        this.emailPK = emailPK;
        this.email = email;
    }

    public Email(int idEmail, int tblClienteIdCliente) {
        this.emailPK = new EmailPK(idEmail, tblClienteIdCliente);
    }

    public EmailPK getEmailPK() {
        return emailPK;
    }

    public void setEmailPK(EmailPK emailPK) {
        this.emailPK = emailPK;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public TipoEmail getTblTipoEmailIdTipoEmail() {
        return tblTipoEmailIdTipoEmail;
    }

    public void setTblTipoEmailIdTipoEmail(TipoEmail tblTipoEmailIdTipoEmail) {
        this.tblTipoEmailIdTipoEmail = tblTipoEmailIdTipoEmail;
    }

    public Usuario getTblUsuarioIdUsuario() {
        return tblUsuarioIdUsuario;
    }

    public void setTblUsuarioIdUsuario(Usuario tblUsuarioIdUsuario) {
        this.tblUsuarioIdUsuario = tblUsuarioIdUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emailPK != null ? emailPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Email)) {
            return false;
        }
        Email other = (Email) object;
        if ((this.emailPK == null && other.emailPK != null) || (this.emailPK != null && !this.emailPK.equals(other.emailPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sea.backend.entities.Email[ emailPK=" + emailPK + " ]";
    }
    
}
