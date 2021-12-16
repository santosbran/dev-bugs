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
@Table(name = "ENG_CIA_COLOR_VW")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngCiaColorVw.findAll", query = "SELECT e FROM EngCiaColorVw e"),
    @NamedQuery(name = "EngCiaColorVw.findByCompany", query = "SELECT e FROM EngCiaColorVw e WHERE e.company = :company"),
    @NamedQuery(name = "EngCiaColorVw.findByColor", query = "SELECT e FROM EngCiaColorVw e WHERE e.color = :color"),
    @NamedQuery(name = "EngCiaColorVw.findByTotal", query = "SELECT e FROM EngCiaColorVw e WHERE e.total = :total")})
public class EngCiaColorVw implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Size(max = 50)
    @Column(name = "COMPANY")
    private String company;
    @Size(max = 4000)
    @Column(name = "COLOR")
    private String color;
    @Column(name = "TOTAL")
    private BigInteger total;

    public EngCiaColorVw() {
        super();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public BigInteger getTotal() {
        return total;
    }

    public void setTotal(BigInteger total) {
        this.total = total;
    }
    
}
