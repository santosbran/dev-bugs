/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities;

import java.io.Serializable;
import java.math.BigInteger;
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
 * @author ssibrian
 */
@Entity
@Cacheable(false)
@Table(name = "ENG_TASKS_BY_CUSTOMER_FLT_VW")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngTasksByCustomerFltVw.findAll", query = "SELECT e FROM EngTasksByCustomerFltVw e"),
    @NamedQuery(name = "EngTasksByCustomerFltVw.findByNumId", query = "SELECT e FROM EngTasksByCustomerFltVw e WHERE e.numId = :numId"),
    @NamedQuery(name = "EngTasksByCustomerFltVw.findByEngId", query = "SELECT e FROM EngTasksByCustomerFltVw e WHERE e.engId = :engId"),
    @NamedQuery(name = "EngTasksByCustomerFltVw.findByEngName", query = "SELECT e FROM EngTasksByCustomerFltVw e WHERE e.engName = :engName"),
    @NamedQuery(name = "EngTasksByCustomerFltVw.findByColor", query = "SELECT e FROM EngTasksByCustomerFltVw e WHERE e.color = :color"),
    @NamedQuery(name = "EngTasksByCustomerFltVw.findByCompany", query = "SELECT e FROM EngTasksByCustomerFltVw e WHERE e.company = :company"),
    @NamedQuery(name = "EngTasksByCustomerFltVw.findByTasks", query = "SELECT e FROM EngTasksByCustomerFltVw e WHERE e.tasks = :tasks"),
    @NamedQuery(name = "EngTasksByCustomerFltVw.findByCola", query = "SELECT e FROM EngTasksByCustomerFltVw e WHERE e.cola = :cola"),
    @NamedQuery(name = "EngTasksByCustomerFltVw.findByWorkorder", query = "SELECT e FROM EngTasksByCustomerFltVw e WHERE e.workorder = :workorder")})
public class EngTasksByCustomerFltVw implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "NUM_ID")
    private BigInteger numId;
    @Size(max = 20)
    @Column(name = "ENG_ID")
    private String engId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ENG_NAME")
    private String engName;
    @Size(max = 4000)
    @Column(name = "COLOR")
    private String color;
    @Size(max = 50)
    @Column(name = "COMPANY")
    private String company;
    @Column(name = "TASKS")
    private BigInteger tasks;
    @Size(max = 50)
    @Column(name = "WORKORDER")
    private String workorder;//anadido por cambio en la forma que se muestra el inicio del manager
    @Size(max = 20)
    @Column(name = "COLA")
    private String cola;//anadido por cambio en la forma que se muestra el inicio del manager

    public EngTasksByCustomerFltVw() {
        super();
    }

    public BigInteger getNumId() {
        return numId;
    }

    public void setNumId(BigInteger numId) {
        this.numId = numId;
    }

    public String getEngId() {
        return engId;
    }

    public void setEngId(String engId) {
        this.engId = engId;
    }

    public String getEngName() {
        return engName;
    }

    public void setEngName(String engName) {
        this.engName = engName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public BigInteger getTasks() {
        return tasks;
    }

    public void setTasks(BigInteger tasks) {
        this.tasks = tasks;
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
