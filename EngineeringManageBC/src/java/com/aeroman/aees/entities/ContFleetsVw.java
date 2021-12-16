/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities;

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
 * @author ACTIVA_03
 */
@Entity
@Cacheable(false)
@Table(name = "CONT_FLEETS_VW")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContFleetsVw.findAll", query = "SELECT c FROM ContFleetsVw c"),
    @NamedQuery(name = "ContFleetsVw.findByCodflt", query = "SELECT c FROM ContFleetsVw c WHERE c.codflt = :codflt"),
    @NamedQuery(name = "ContFleetsVw.findByDescription", query = "SELECT c FROM ContFleetsVw c WHERE c.description = :description"),
    @NamedQuery(name = "ContFleetsVw.findByTipo", query = "SELECT c FROM ContFleetsVw c WHERE c.tipo = :tipo"),
    @NamedQuery(name = "ContFleetsVw.findByCustomerId", query = "SELECT c FROM ContFleetsVw c WHERE c.customerId = :customerId"),
    @NamedQuery(name = "ContFleetsVw.findByCompany", query = "SELECT c FROM ContFleetsVw c WHERE c.company = :company"),
    @NamedQuery(name = "ContFleetsVw.findByUsrIns", query = "SELECT c FROM ContFleetsVw c WHERE c.usrIns = :usrIns"),
    @NamedQuery(name = "ContFleetsVw.findByFechaIns", query = "SELECT c FROM ContFleetsVw c WHERE c.fechaIns = :fechaIns"),
    @NamedQuery(name = "ContFleetsVw.findByUsrAct", query = "SELECT c FROM ContFleetsVw c WHERE c.usrAct = :usrAct"),
    @NamedQuery(name = "ContFleetsVw.findByFechaAct", query = "SELECT c FROM ContFleetsVw c WHERE c.fechaAct = :fechaAct"),
    @NamedQuery(name = "ContFleetsVw.findByActivo", query = "SELECT c FROM ContFleetsVw c WHERE c.activo = :activo"),
    @NamedQuery(name = "ContFleetsVw.findByTotal", query = "SELECT c FROM ContFleetsVw c WHERE c.total = :total")})
public class ContFleetsVw implements Serializable {
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
    @Column(name = "TOTAL")
    private BigInteger total;

    public ContFleetsVw() {
        super();
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

    public BigInteger getTotal() {
        return total;
    }

    public void setTotal(BigInteger total) {
        this.total = total;
    }
    
}
