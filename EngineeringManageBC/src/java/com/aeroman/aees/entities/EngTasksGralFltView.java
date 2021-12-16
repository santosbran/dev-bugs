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
@Table(name = "ENG_TASKS_GRAL_FLT_VIEW")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngTasksGralFltView.findAll", query = "SELECT e FROM EngTasksGralFltView e"),
    @NamedQuery(name = "EngTasksGralFltView.findByRowId", query = "SELECT e FROM EngTasksGralFltView e WHERE e.rowId = :rowId"),
    @NamedQuery(name = "EngTasksGralFltView.findByFlota", query = "SELECT e FROM EngTasksGralFltView e WHERE e.flota = :flota"),
    @NamedQuery(name = "EngTasksGralFltView.findByNumflota", query = "SELECT e FROM EngTasksGralFltView e WHERE e.numflota = :numflota"),
    @NamedQuery(name = "EngTasksGralFltView.findByColor", query = "SELECT e FROM EngTasksGralFltView e WHERE e.color = :color")})
public class EngTasksGralFltView implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ROW_ID")
    private BigInteger rowId;
    @Size(max = 20)
    @Column(name = "FLOTA")
    private String flota;
    @Column(name = "NUMFLOTA")
    private BigInteger numflota;
    @Size(max = 4000)
    @Column(name = "COLOR")
    private String color;

    public EngTasksGralFltView() {
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
    
}
