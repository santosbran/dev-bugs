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
 * @author Usuario
 */
@Entity
@Cacheable(false)
@Table(name = "ENG_TASKS_CUST_USER_NF_VW")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngTasksCustUserNfVw.findAll", query = "SELECT e FROM EngTasksCustUserNfVw e"),
    @NamedQuery(name = "EngTasksCustUserNfVw.findByCustId", query = "SELECT e FROM EngTasksCustUserNfVw e WHERE e.custId = :custId"),
    @NamedQuery(name = "EngTasksCustUserNfVw.findByEngId", query = "SELECT e FROM EngTasksCustUserNfVw e WHERE e.engId = :engId"),
    @NamedQuery(name = "EngTasksCustUserNfVw.findByEngName", query = "SELECT e FROM EngTasksCustUserNfVw e WHERE e.engName = :engName"),
    @NamedQuery(name = "EngTasksCustUserNfVw.findByColor", query = "SELECT e FROM EngTasksCustUserNfVw e WHERE e.color = :color"),
    @NamedQuery(name = "EngTasksCustUserNfVw.findByCompany", query = "SELECT e FROM EngTasksCustUserNfVw e WHERE e.company = :company"),
    @NamedQuery(name = "EngTasksCustUserNfVw.findByTasks", query = "SELECT e FROM EngTasksCustUserNfVw e WHERE e.tasks = :tasks"),
    @NamedQuery(name = "EngTasksCustUserNfVw.findByUsername", query = "SELECT e FROM EngTasksCustUserNfVw e WHERE e.usercode = :username")})
public class EngTasksCustUserNfVw implements Serializable {
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
    @Size(max = 4000)
    @Column(name = "COLOR")
    private String color;
    @Size(max = 50)
    @Column(name = "COMPANY")
    private String company;
    @Column(name = "TASKS")
    private BigInteger tasks;
    @Size(max = 32)
    @Column(name = "USERCODE")
    private String usercode;

    public EngTasksCustUserNfVw() {
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

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    
    
}
