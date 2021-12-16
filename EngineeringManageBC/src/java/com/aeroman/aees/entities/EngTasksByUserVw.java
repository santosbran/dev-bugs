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
@Table(name = "ENG_TASKS_BY_USER_VW")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngTasksByUserVw.findAll", query = "SELECT e FROM EngTasksByUserVw e")
    , @NamedQuery(name = "EngTasksByUserVw.findByProceso", query = "SELECT e FROM EngTasksByUserVw e WHERE e.proceso = :proceso")
    , @NamedQuery(name = "EngTasksByUserVw.findByUsercode", query = "SELECT e FROM EngTasksByUserVw e WHERE e.usercode = :usercode")
    , @NamedQuery(name = "EngTasksByUserVw.findByUserName", query = "SELECT e FROM EngTasksByUserVw e WHERE e.userName = :userName")
    , @NamedQuery(name = "EngTasksByUserVw.findByCompany", query = "SELECT e FROM EngTasksByUserVw e WHERE e.company = :company")
    , @NamedQuery(name = "EngTasksByUserVw.findByEagCustomer", query = "SELECT e FROM EngTasksByUserVw e WHERE e.eagCustomer = :eagCustomer")
    , @NamedQuery(name = "EngTasksByUserVw.findByFlota", query = "SELECT e FROM EngTasksByUserVw e WHERE e.flota = :flota")
    , @NamedQuery(name = "EngTasksByUserVw.findByTasks", query = "SELECT e FROM EngTasksByUserVw e WHERE e.tasks = :tasks")
    , @NamedQuery(name = "EngTasksByUserVw.findByColor", query = "SELECT e FROM EngTasksByUserVw e WHERE e.color = :color")
    , @NamedQuery(name = "EngTasksByUserVw.findByWorkorder", query = "SELECT e FROM EngTasksByUserVw e WHERE e.workorder = :workorder")
    , @NamedQuery(name = "EngTasksByUserVw.findByCola", query = "SELECT e FROM EngTasksByUserVw e WHERE e.cola = :cola")})
public class EngTasksByUserVw implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 45)
    @Column(name = "PROCESO")
    @Id
    private String proceso;
    @Size(max = 32)
    @Column(name = "USERCODE")
    private String usercode;
    @Size(max = 511)
    @Column(name = "USER_NAME")
    private String userName;
    @Size(max = 50)
    @Column(name = "COMPANY")
    private String company;
    @Size(max = 20)
    @Column(name = "EAG_CUSTOMER")
    private String eagCustomer;
    @Size(max = 20)
    @Column(name = "FLOTA")
    private String flota;
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

    public EngTasksByUserVw() {
        super();
    }

    public String getProceso() {
        return proceso;
    }

    public void setProceso(String proceso) {
        this.proceso = proceso;
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

    public String getEagCustomer() {
        return eagCustomer;
    }

    public void setEagCustomer(String eagCustomer) {
        this.eagCustomer = eagCustomer;
    }

    public String getFlota() {
        return flota;
    }

    public void setFlota(String flota) {
        this.flota = flota;
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
    
}
