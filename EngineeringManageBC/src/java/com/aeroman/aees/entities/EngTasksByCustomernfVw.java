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
@Table(name = "ENG_TASKS_BY_CUSTOMERNF_VW")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngTasksByCustomernfVw.findAll", query = "SELECT e FROM EngTasksByCustomernfVw e"),
    @NamedQuery(name = "EngTasksByCustomernfVw.findByNumId", query = "SELECT e FROM EngTasksByCustomernfVw e WHERE e.numId = :numId"),
    @NamedQuery(name = "EngTasksByCustomernfVw.findByEngId", query = "SELECT e FROM EngTasksByCustomernfVw e WHERE e.engId = :engId"),
    @NamedQuery(name = "EngTasksByCustomernfVw.findByEngName", query = "SELECT e FROM EngTasksByCustomernfVw e WHERE e.engName = :engName"),
    @NamedQuery(name = "EngTasksByCustomernfVw.findByColor", query = "SELECT e FROM EngTasksByCustomernfVw e WHERE e.color = :color"),
    @NamedQuery(name = "EngTasksByCustomernfVw.findByCompany", query = "SELECT e FROM EngTasksByCustomernfVw e WHERE e.company = :company"),
    @NamedQuery(name = "EngTasksByCustomernfVw.findByTasks", query = "SELECT e FROM EngTasksByCustomernfVw e WHERE e.tasks = :tasks")})
public class EngTasksByCustomernfVw implements Serializable {

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

    public EngTasksByCustomernfVw() {
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
    
}
