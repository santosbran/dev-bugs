/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities.grant;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Saplic16
 */
@Entity
@Cacheable(false)
@Table(name = "PRC_DETPARAM", catalog = "", schema = "PROCESOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrcDetparam.findAll", query = "SELECT p FROM PrcDetparam p"),
    @NamedQuery(name = "PrcDetparam.findByCodparam", query = "SELECT p FROM PrcDetparam p WHERE p.codparam = :codparam"),
    @NamedQuery(name = "PrcDetparam.findByValor", query = "SELECT p FROM PrcDetparam p WHERE p.valor = :valor"),
    @NamedQuery(name = "PrcDetparam.findByIdDetparam", query = "SELECT p FROM PrcDetparam p WHERE p.idDetparam = :idDetparam"),
    @NamedQuery(name = "PrcDetparam.findByAtt1", query = "SELECT p FROM PrcDetparam p WHERE p.att1 = :att1")})
public class PrcDetparam implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 25)
    @Column(name = "CODPARAM")
    private String codparam;
    @Size(max = 500)
    @Column(name = "VALOR")
    private String valor;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_DETPARAM")
    private BigDecimal idDetparam;
    @Size(max = 20)
    @Column(name = "ATT1")
    private String att1;

    public PrcDetparam() {
        super();
    }

    public PrcDetparam(BigDecimal idDetparam) {
        this.idDetparam = idDetparam;
    }

    public String getCodparam() {
        return codparam;
    }

    public void setCodparam(String codparam) {
        this.codparam = codparam;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public BigDecimal getIdDetparam() {
        return idDetparam;
    }

    public void setIdDetparam(BigDecimal idDetparam) {
        this.idDetparam = idDetparam;
    }

    public String getAtt1() {
        return att1;
    }

    public void setAtt1(String att1) {
        this.att1 = att1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetparam != null ? idDetparam.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof PrcDetparam)) {
            return false;
        }
        PrcDetparam other = (PrcDetparam) object;
        if ((this.idDetparam == null && other.idDetparam != null) || (this.idDetparam != null && !this.idDetparam.equals(other.idDetparam))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.grant.PrcDetparam[ idDetparam=" + idDetparam + " ]";
    }
    
}
