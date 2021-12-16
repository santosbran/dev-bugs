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
@Table(name = "ENG_TASKS_BY_FLT_USER_VW")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngTasksByFltUserVw.findAll", query = "SELECT e FROM EngTasksByFltUserVw e")
    , @NamedQuery(name = "EngTasksByFltUserVw.findByRowId", query = "SELECT e FROM EngTasksByFltUserVw e WHERE e.rowId = :rowId")
    , @NamedQuery(name = "EngTasksByFltUserVw.findByFlota", query = "SELECT e FROM EngTasksByFltUserVw e WHERE e.flota = :flota")
    , @NamedQuery(name = "EngTasksByFltUserVw.findByCompany", query = "SELECT e FROM EngTasksByFltUserVw e WHERE e.company = :company")
    , @NamedQuery(name = "EngTasksByFltUserVw.findByNumflota", query = "SELECT e FROM EngTasksByFltUserVw e WHERE e.numflota = :numflota")
    , @NamedQuery(name = "EngTasksByFltUserVw.findByColor", query = "SELECT e FROM EngTasksByFltUserVw e WHERE e.color = :color")
    , @NamedQuery(name = "EngTasksByFltUserVw.findByUsercode", query = "SELECT e FROM EngTasksByFltUserVw e WHERE e.usercode = :usercode")
    , @NamedQuery(name = "EngTasksByFltUserVw.findByWorkorder", query = "SELECT e FROM EngTasksByFltUserVw e WHERE e.workorder = :workorder")
    , @NamedQuery(name = "EngTasksByFltUserVw.findByCola", query = "SELECT e FROM EngTasksByFltUserVw e WHERE e.cola = :cola")})
public class EngTasksByFltUserVw implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "ROW_ID")
    @Id
    private BigInteger rowId;
    @Size(max = 20)
    @Column(name = "FLOTA")
    private String flota;
    @Size(max = 50)
    @Column(name = "COMPANY")
    private String company;
    @Column(name = "NUMFLOTA")
    private BigInteger numflota;
    @Size(max = 4000)
    @Column(name = "COLOR")
    private String color;
    @Size(max = 32)
    @Column(name = "USERCODE")
    private String usercode;
    @Size(max = 50)
    @Column(name = "WORKORDER")
    private String workorder;
    @Size(max = 20)
    @Column(name = "COLA")
    private String cola;

    public EngTasksByFltUserVw() {
        super();
    }

    public BigInteger getRowId() {
        return rowId;
    }

    public void setRowId(BigInteger rowId) {
        this.rowId = rowId;
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

    public String getCola() {
        return cola;
    }

    public void setCola(String cola) {
        this.cola = cola;
    }
    
}
