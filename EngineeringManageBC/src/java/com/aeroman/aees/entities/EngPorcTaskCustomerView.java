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
 * @author ssibrian
 */
@Entity
@Cacheable(false)
@Table(name = "ENG_PORC_TASK_CUSTOMER_VIEW")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngPorcTaskCustomerView.findAll", query = "SELECT e FROM EngPorcTaskCustomerView e"),
    @NamedQuery(name = "EngPorcTaskCustomerView.findByEagCustomer", query = "SELECT e FROM EngPorcTaskCustomerView e WHERE e.eagCustomer = :eagCustomer"),
    @NamedQuery(name = "EngPorcTaskCustomerView.findByTotalPorCliente", query = "SELECT e FROM EngPorcTaskCustomerView e WHERE e.totalPorCliente = :totalPorCliente"),
    @NamedQuery(name = "EngPorcTaskCustomerView.findByTotal", query = "SELECT e FROM EngPorcTaskCustomerView e WHERE e.total = :total"),
    @NamedQuery(name = "EngPorcTaskCustomerView.findByPorcCliente", query = "SELECT e FROM EngPorcTaskCustomerView e WHERE e.porcCliente = :porcCliente")})
public class EngPorcTaskCustomerView implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @Size(max = 20)
    @Column(name = "EAG_CUSTOMER")
    private String eagCustomer;
    @Column(name = "TOTAL_POR_CLIENTE")
    private BigInteger totalPorCliente;
    @Column(name = "TOTAL")
    private BigInteger total;
    @Column(name = "PORC_CLIENTE")
    private BigInteger porcCliente;

    public EngPorcTaskCustomerView() {
        super();
    }

    public String getEagCustomer() {
        return eagCustomer;
    }

    public void setEagCustomer(String eagCustomer) {
        this.eagCustomer = eagCustomer;
    }

    public BigInteger getTotalPorCliente() {
        return totalPorCliente;
    }

    public void setTotalPorCliente(BigInteger totalPorCliente) {
        this.totalPorCliente = totalPorCliente;
    }

    public BigInteger getTotal() {
        return total;
    }

    public void setTotal(BigInteger total) {
        this.total = total;
    }

    public BigInteger getPorcCliente() {
        return porcCliente;
    }

    public void setPorcCliente(BigInteger porcCliente) {
        this.porcCliente = porcCliente;
    }
    
}
