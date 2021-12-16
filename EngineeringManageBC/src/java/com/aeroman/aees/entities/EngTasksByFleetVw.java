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
@Table(name = "ENG_TASKS_BY_FLEET_VW")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngTasksByFleetVw.findAll", query = "SELECT e FROM EngTasksByFleetVw e")
    , @NamedQuery(name = "EngTasksByFleetVw.findByFlota", query = "SELECT e FROM EngTasksByFleetVw e WHERE e.flota = :flota")
    , @NamedQuery(name = "EngTasksByFleetVw.findByCompany", query = "SELECT e FROM EngTasksByFleetVw e WHERE e.company = :company")
    , @NamedQuery(name = "EngTasksByFleetVw.findByEagCustomer", query = "SELECT e FROM EngTasksByFleetVw e WHERE e.eagCustomer = :eagCustomer")
    , @NamedQuery(name = "EngTasksByFleetVw.findByTasks", query = "SELECT e FROM EngTasksByFleetVw e WHERE e.tasks = :tasks")
    , @NamedQuery(name = "EngTasksByFleetVw.findByColor", query = "SELECT e FROM EngTasksByFleetVw e WHERE e.color = :color")
    , @NamedQuery(name = "EngTasksByFleetVw.findByWorkorder", query = "SELECT e FROM EngTasksByFleetVw e WHERE e.workorder = :workorder")
    , @NamedQuery(name = "EngTasksByFleetVw.findByCola", query = "SELECT e FROM EngTasksByFleetVw e WHERE e.cola = :cola")
    , @NamedQuery(name = "EngTasksByFleetVw.findByUsercode", query = "SELECT e FROM EngTasksByFleetVw e WHERE e.usercode = :usercode")})
public class EngTasksByFleetVw implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 20)
    @Column(name = "FLOTA")
    @Id
    private String flota;
    @Size(max = 50)
    @Column(name = "COMPANY")
    private String company;
    @Size(max = 20)
    @Column(name = "EAG_CUSTOMER")
    private String eagCustomer;
    @Column(name = "TASKS")
    private BigInteger tasks;
    @Size(max = 4000)
    @Column(name = "COLOR")
    private String color;
    @Size(max = 50)
    @Column(name = "WORKORDER")
    private String workorder;
    @Size(max = 20)
    @Column(name = "COLA")
    private String cola;
    @Size(max = 32)
    @Column(name = "USERCODE")
    private String usercode;

    public EngTasksByFleetVw() {
        super();
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }
    
}
