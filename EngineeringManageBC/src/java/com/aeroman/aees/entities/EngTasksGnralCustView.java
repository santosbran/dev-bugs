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
@Table(name = "ENG_TASKS_GNRAL_CUST_VIEW")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngTasksGnralCustView.findAll", query = "SELECT e FROM EngTasksGnralCustView e"),
    @NamedQuery(name = "EngTasksGnralCustView.findByCustId", query = "SELECT e FROM EngTasksGnralCustView e WHERE e.custId = :custId"),
    @NamedQuery(name = "EngTasksGnralCustView.findByEngId", query = "SELECT e FROM EngTasksGnralCustView e WHERE e.engId = :engId"),
    @NamedQuery(name = "EngTasksGnralCustView.findByEngName", query = "SELECT e FROM EngTasksGnralCustView e WHERE e.engName = :engName"),
    @NamedQuery(name = "EngTasksGnralCustView.findByTasks", query = "SELECT e FROM EngTasksGnralCustView e WHERE e.tasks = :tasks"),
    @NamedQuery(name = "EngTasksGnralCustView.findByColor", query = "SELECT e FROM EngTasksGnralCustView e WHERE e.color = :color")})
public class EngTasksGnralCustView implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "CUST_ID")
    private BigInteger custId;
    @Size(max = 20)
    @Column(name = "ENG_ID")
    private String engId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ENG_NAME")
    private String engName;
    @Column(name = "TASKS")
    private BigInteger tasks;
    @Size(max = 4000)
    @Column(name = "COLOR")
    private String color;

    public EngTasksGnralCustView() {
        super();
    }

    public BigInteger getCustId() {
        return custId;
    }

    public void setCustId(BigInteger custId) {
        this.custId = custId;
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
    
}
