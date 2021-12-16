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
 * @author eguevara
 */
@Entity
@Cacheable(false)
@Table(name = "ENG_TASK_FLEET_USER_VW")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngTaskFleetUserVw.findAll", query = "SELECT e FROM EngTaskFleetUserVw e")
    , @NamedQuery(name = "EngTaskFleetUserVw.findByIdflota", query = "SELECT e FROM EngTaskFleetUserVw e WHERE e.idflota = :idflota")
    , @NamedQuery(name = "EngTaskFleetUserVw.findByFlota", query = "SELECT e FROM EngTaskFleetUserVw e WHERE e.flota = :flota")
    , @NamedQuery(name = "EngTaskFleetUserVw.findByCompany", query = "SELECT e FROM EngTaskFleetUserVw e WHERE e.company = :company")
    , @NamedQuery(name = "EngTaskFleetUserVw.findByEagCustomer", query = "SELECT e FROM EngTaskFleetUserVw e WHERE e.eagCustomer = :eagCustomer")
    , @NamedQuery(name = "EngTaskFleetUserVw.findByTasks", query = "SELECT e FROM EngTaskFleetUserVw e WHERE e.tasks = :tasks")
    , @NamedQuery(name = "EngTaskFleetUserVw.findByUsercode", query = "SELECT e FROM EngTaskFleetUserVw e WHERE e.usercode = :usercode")
    , @NamedQuery(name = "EngTaskFleetUserVw.findByColor", query = "SELECT e FROM EngTaskFleetUserVw e WHERE e.color = :color")})
public class EngTaskFleetUserVw implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "IDFLOTA")
    @Id
    private BigInteger idflota;
    @Size(max = 20)
    @Column(name = "FLOTA")
    private String flota;
    @Size(max = 50)
    @Column(name = "COMPANY")
    private String company;
    @Size(max = 20)
    @Column(name = "EAG_CUSTOMER")
    private String eagCustomer;
    @Column(name = "TASKS")
    private BigInteger tasks;
    @Size(max = 32)
    @Column(name = "USERCODE")
    private String usercode;
    @Size(max = 4000)
    @Column(name = "COLOR")
    private String color;

    public EngTaskFleetUserVw() {
        super();
    }

    public BigInteger getIdflota() {
        return idflota;
    }

    public void setIdflota(BigInteger idflota) {
        this.idflota = idflota;
    }

    public String getFlota() {
        return flota;
    }

    public void setFlota(String flota) {
        this.flota = flota;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEagCustomer() {
        return eagCustomer;
    }

    public void setEagCustomer(String eagCustomer) {
        this.eagCustomer = eagCustomer;
    }

    public BigInteger getTasks() {
        return tasks;
    }

    public void setTasks(BigInteger tasks) {
        this.tasks = tasks;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
}
