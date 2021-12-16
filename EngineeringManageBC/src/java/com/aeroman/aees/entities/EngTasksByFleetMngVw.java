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
 * @author ssibrian
 */
@Entity
@Cacheable(false)
@Table(name = "ENG_TASKS_BY_FLEET_MNG_VW")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngTasksByFleetMngVw.findAll", query = "SELECT e FROM EngTasksByFleetMngVw e"),
    @NamedQuery(name = "EngTasksByFleetMngVw.findByRowId", query = "SELECT e FROM EngTasksByFleetMngVw e WHERE e.rowId = :rowId"),
    @NamedQuery(name = "EngTasksByFleetMngVw.findByCompany", query = "SELECT e FROM EngTasksByFleetMngVw e WHERE e.company = :company"),
    @NamedQuery(name = "EngTasksByFleetMngVw.findByNumflota", query = "SELECT e FROM EngTasksByFleetMngVw e WHERE e.numflota = :numflota"),
    @NamedQuery(name = "EngTasksByFleetMngVw.findByColor", query = "SELECT e FROM EngTasksByFleetMngVw e WHERE e.color = :color"),
    @NamedQuery(name = "EngTasksByFleetMngVw.findByWorkorder", query = "SELECT e FROM EngTasksByFleetMngVw e WHERE e.workorder = :workorder"),
    @NamedQuery(name = "EngTasksByFleetMngVw.findByCola", query = "SELECT e FROM EngTasksByFleetMngVw e WHERE e.cola = :cola")})
public class EngTasksByFleetMngVw implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ROW_ID")
    private BigInteger rowId;
    @Size(max = 50)
    @Column(name = "COMPANY")
    private String company;
    @Column(name = "NUMFLOTA")
    private BigInteger numflota;
    @Size(max = 4000)
    @Column(name = "COLOR")
    private String color;
    @Size(max = 50)
    @Column(name = "WORKORDER")
    private String workorder;//anadido por cambio en la forma que se muestra el inicio del manager
    @Size(max = 20)
    @Column(name = "COLA")
    private String cola;//anadido por cambio en la forma que se muestra el inicio del manager
    
    public EngTasksByFleetMngVw() {
        super();
    }

    public BigInteger getRowId() {
        return rowId;
    }

    public void setRowId(BigInteger rowId) {
        this.rowId = rowId;
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
