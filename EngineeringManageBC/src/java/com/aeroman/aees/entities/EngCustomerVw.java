/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ACTIVA_03
 */
@Entity
@Cacheable(false)
@Table(name = "ENG_CUSTOMER_VW")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngCustomerVw.findAll", query = "SELECT e FROM EngCustomerVw e"),
    @NamedQuery(name = "EngCustomerVw.findByCliente", query = "SELECT e FROM EngCustomerVw e WHERE e.cliente = :cliente"),
    @NamedQuery(name = "EngCustomerVw.findByTotal", query = "SELECT e FROM EngCustomerVw e WHERE e.total = :total")})
public class EngCustomerVw implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 8)
    @Column(name = "CLIENTE")
    @Id
    private String cliente;
    @Column(name = "TOTAL")
    private BigInteger total;

    public EngCustomerVw() {
        super();
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public BigInteger getTotal() {
        return total;
    }

    public void setTotal(BigInteger total) {
        this.total = total;
    }
    
}

