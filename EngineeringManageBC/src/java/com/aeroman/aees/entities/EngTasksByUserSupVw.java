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
@Table(name = "ENG_TASKS_BY_USER_SUP_VW")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngTasksByUserSupVw.findAll", query = "SELECT e FROM EngTasksByUserSupVw e")
    , @NamedQuery(name = "EngTasksByUserSupVw.findByRowId", query = "SELECT e FROM EngTasksByUserSupVw e WHERE e.rowId = :rowId")
    , @NamedQuery(name = "EngTasksByUserSupVw.findByUsercode", query = "SELECT e FROM EngTasksByUserSupVw e WHERE e.usercode = :usercode")
    , @NamedQuery(name = "EngTasksByUserSupVw.findByUserName", query = "SELECT e FROM EngTasksByUserSupVw e WHERE e.userName = :userName")
    , @NamedQuery(name = "EngTasksByUserSupVw.findByCompany", query = "SELECT e FROM EngTasksByUserSupVw e WHERE e.company = :company")
    , @NamedQuery(name = "EngTasksByUserSupVw.findByTask", query = "SELECT e FROM EngTasksByUserSupVw e WHERE e.task = :task")
    , @NamedQuery(name = "EngTasksByUserSupVw.findByColor", query = "SELECT e FROM EngTasksByUserSupVw e WHERE e.color = :color")})
public class EngTasksByUserSupVw implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "ROW_ID")
    @Id
    private BigInteger rowId;
    @Size(max = 32)
    @Column(name = "USERCODE")
    private String usercode;
    @Size(max = 511)
    @Column(name = "USER_NAME")
    private String userName;
    @Size(max = 50)
    @Column(name = "COMPANY")
    private String company;
    @Column(name = "TASK")
    private BigInteger task;
    @Size(max = 4000)
    @Column(name = "COLOR")
    private String color;

    public EngTasksByUserSupVw() {
        super();
    }

    public BigInteger getRowId() {
        return rowId;
    }

    public void setRowId(BigInteger rowId) {
        this.rowId = rowId;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public BigInteger getTask() {
        return task;
    }

    public void setTask(BigInteger task) {
        this.task = task;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
}
