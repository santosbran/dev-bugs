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
@Table(name = "ENG_TASKS_BY_FLEET_CUST_VW")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngTasksByFleetCustVw.findAll", query = "SELECT e FROM EngTasksByFleetCustVw e"),
    @NamedQuery(name = "EngTasksByFleetCustVw.findByRowId", query = "SELECT e FROM EngTasksByFleetCustVw e WHERE e.rowId = :rowId"),
    @NamedQuery(name = "EngTasksByFleetCustVw.findByCompany", query = "SELECT e FROM EngTasksByFleetCustVw e WHERE e.company = :company"),
    @NamedQuery(name = "EngTasksByFleetCustVw.findByNumflota", query = "SELECT e FROM EngTasksByFleetCustVw e WHERE e.numflota = :numflota"),
    @NamedQuery(name = "EngTasksByFleetCustVw.findByColor", query = "SELECT e FROM EngTasksByFleetCustVw e WHERE e.color = :color"),
    @NamedQuery(name = "EngTasksByFleetCustVw.findByEagCustomer", query = "SELECT e FROM EngTasksByFleetCustVw e WHERE e.eagCustomer = :eagCustomer")})
public class EngTasksByFleetCustVw implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ROW_ID")
    private BigInteger rowId;
    @Size(max = 50)
    @Column(name = "COMPANY")
    private String company;
    @Column(name = "NUMFLOTA")
    private BigInteger numflota;
    @Size(max = 4000)
    @Column(name = "COLOR")
    private String color;
    @Size(max = 20)
    @Column(name = "EAG_CUSTOMER")
    private String eagCustomer;
    @Size(max = 50)
    @Column(name = "WORKORDER")
    private String workorder;//anadido por cambio en la forma que se muestra el inicio del manager
    @Size(max = 20)
    @Column(name = "COLA")
    private String cola;//anadido por cambio en la forma que se muestra el inicio del manager

    public EngTasksByFleetCustVw() {
        super();
    }

    public BigInteger getRowId() {
        return rowId;
    }

    public void setRowId(BigInteger rowId) {
        this.rowId = rowId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public BigInteger getNumflota() {
        return numflota;
    }

    public void setNumflota(BigInteger numflota) {
        this.numflota = numflota;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEagCustomer() {
        return eagCustomer;
    }

    public void setEagCustomer(String eagCustomer) {
        this.eagCustomer = eagCustomer;
    }

    public String getWorkorder() {
        return workorder;
    }

    public void setWorkorder(String workorder) {
        this.workorder = workorder;
    }

    public String getCola() {
        return cola;
    }

    public void setCola(String cola) {
        this.cola = cola;
    }
    
}
