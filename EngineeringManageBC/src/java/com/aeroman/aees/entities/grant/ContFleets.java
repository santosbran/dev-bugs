/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities.grant;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Cacheable(false)
@Table(name = "CONT_FLEETS", catalog = "", schema = "CONT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContFleets.findAll", query = "SELECT c FROM ContFleets c"),
    @NamedQuery(name = "ContFleets.findByCodflt", query = "SELECT c FROM ContFleets c WHERE c.codflt = :codflt"),
    @NamedQuery(name = "ContFleets.findByDescription", query = "SELECT c FROM ContFleets c WHERE c.description = :description"),
    @NamedQuery(name = "ContFleets.findByTipo", query = "SELECT c FROM ContFleets c WHERE c.tipo = :tipo"),
    @NamedQuery(name = "ContFleets.findByCustomerId", query = "SELECT c FROM ContFleets c WHERE c.customerId = :customerId"),
    @NamedQuery(name = "ContFleets.findByCompany", query = "SELECT c FROM ContFleets c WHERE c.company = :company"),
    @NamedQuery(name = "ContFleets.findByUsrIns", query = "SELECT c FROM ContFleets c WHERE c.usrIns = :usrIns"),
    @NamedQuery(name = "ContFleets.findByFechaIns", query = "SELECT c FROM ContFleets c WHERE c.fechaIns = :fechaIns"),
    @NamedQuery(name = "ContFleets.findByUsrAct", query = "SELECT c FROM ContFleets c WHERE c.usrAct = :usrAct"),
    @NamedQuery(name = "ContFleets.findByFechaAct", query = "SELECT c FROM ContFleets c WHERE c.fechaAct = :fechaAct"),
    @NamedQuery(name = "ContFleets.findByActivo", query = "SELECT c FROM ContFleets c WHERE c.activo = :activo")})
public class ContFleets implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CODFLT")
    private String codflt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 20)
    @Column(name = "TIPO")
    private String tipo;
    @Column(name = "CUSTOMER_ID")
    private BigInteger customerId;
    @Size(max = 5)
    @Column(name = "COMPANY")
    private String company;
    @Size(max = 30)
    @Column(name = "USR_INS")
    private String usrIns;
    @Column(name = "FECHA_INS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIns;
    @Size(max = 30)
    @Column(name = "USR_ACT")
    private String usrAct;
    @Column(name = "FECHA_ACT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAct;
    @Size(max = 1)
    @Column(name = "ACTIVO")
    private String activo;

    public ContFleets() {
        super();
    }

    public ContFleets(String codflt) {
        this.codflt = codflt;
    }

    public ContFleets(String codflt, String description) {
        this.codflt = codflt;
        this.description = description;
    }

    public String getCodflt() {
        return codflt;
    }

    public void setCodflt(String codflt) {
        this.codflt = codflt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BigInteger getCustomerId() {
        return customerId;
    }

    public void setCustomerId(BigInteger customerId) {
        this.customerId = customerId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getUsrIns() {
        return usrIns;
    }

    public void setUsrIns(String usrIns) {
        this.usrIns = usrIns;
    }

    public Date getFechaIns() {
        return fechaIns;
    }

    public void setFechaIns(Date fechaIns) {
        this.fechaIns = fechaIns;
    }

    public String getUsrAct() {
        return usrAct;
    }

    public void setUsrAct(String usrAct) {
        this.usrAct = usrAct;
    }

    public Date getFechaAct() {
        return fechaAct;
    }

    public void setFechaAct(Date fechaAct) {
        this.fechaAct = fechaAct;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codflt != null ? codflt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof ContFleets)) {
            return false;
        }
        ContFleets other = (ContFleets) object;
        if ((this.codflt == null && other.codflt != null) || (this.codflt != null && !this.codflt.equals(other.codflt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.grant.ContFleets[ codflt=" + codflt + " ]";
    }
    
}
