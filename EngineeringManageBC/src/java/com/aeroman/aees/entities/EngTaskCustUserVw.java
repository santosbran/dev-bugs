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
 * @author eguevara
 */
@Entity
@Cacheable(false)
@Table(name = "ENG_TASK_CUST_USER_VW")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngTaskCustUserVw.findAll", query = "SELECT e FROM EngTaskCustUserVw e")
    , @NamedQuery(name = "EngTaskCustUserVw.findByCustId", query = "SELECT e FROM EngTaskCustUserVw e WHERE e.custId = :custId")
    , @NamedQuery(name = "EngTaskCustUserVw.findByEngId", query = "SELECT e FROM EngTaskCustUserVw e WHERE e.engId = :engId")
    , @NamedQuery(name = "EngTaskCustUserVw.findByEngName", query = "SELECT e FROM EngTaskCustUserVw e WHERE e.engName = :engName")
    , @NamedQuery(name = "EngTaskCustUserVw.findByColor", query = "SELECT e FROM EngTaskCustUserVw e WHERE e.color = :color")
    , @NamedQuery(name = "EngTaskCustUserVw.findByCompany", query = "SELECT e FROM EngTaskCustUserVw e WHERE e.company = :company")
    , @NamedQuery(name = "EngTaskCustUserVw.findByTasks", query = "SELECT e FROM EngTaskCustUserVw e WHERE e.tasks = :tasks")
    , @NamedQuery(name = "EngTaskCustUserVw.findByUsercode", query = "SELECT e FROM EngTaskCustUserVw e WHERE e.usercode = :usercode")
    , @NamedQuery(name = "EngTaskCustUserVw.findByWorkorder", query = "SELECT e FROM EngTaskCustUserVw e WHERE e.workorder = :workorder")})
public class EngTaskCustUserVw implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "CUST_ID")
    @Id
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
    @Size(max = 50)
    @Column(name = "WORKORDER")
    private String workorder;

    public EngTaskCustUserVw() {
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

    public String getWorkorder() {
        return workorder;
    }

    public void setWorkorder(String workorder) {
        this.workorder = workorder;
    }
    
}
