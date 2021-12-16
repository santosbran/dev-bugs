/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Cacheable(false)
@Table(name = "ENG_EA_EO_REQ_VW")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngEaEoReqVw.findAll", query = "SELECT e FROM EngEaEoReqVw e"),
    @NamedQuery(name = "EngEaEoReqVw.findByProceso", query = "SELECT e FROM EngEaEoReqVw e WHERE e.proceso = :proceso"),
    @NamedQuery(name = "EngEaEoReqVw.findByIdregistro", query = "SELECT e FROM EngEaEoReqVw e WHERE e.idregistro = :idregistro"),
    @NamedQuery(name = "EngEaEoReqVw.findByDescripcion", query = "SELECT e FROM EngEaEoReqVw e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "EngEaEoReqVw.findByUsername", query = "SELECT e FROM EngEaEoReqVw e WHERE e.username = :username"),
    @NamedQuery(name = "EngEaEoReqVw.findByNum", query = "SELECT e FROM EngEaEoReqVw e WHERE e.num = :num"),
    @NamedQuery(name = "EngEaEoReqVw.findByCompany", query = "SELECT e FROM EngEaEoReqVw e WHERE e.company = :company"),
    @NamedQuery(name = "EngEaEoReqVw.findByFlota", query = "SELECT e FROM EngEaEoReqVw e WHERE e.flota = :flota"),
    @NamedQuery(name = "EngEaEoReqVw.findByFechacrea", query = "SELECT e FROM EngEaEoReqVw e WHERE e.fechacrea = :fechacrea")})
public class EngEaEoReqVw implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 46)
    @Column(name = "PROCESO")
    @Id
    private String proceso;
    @Column(name = "IDREGISTRO")
    private BigInteger idregistro;
    @Size(max = 4000)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Size(max = 32)
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "NUM")
    private BigInteger num;
    @Size(max = 50)
    @Column(name = "COMPANY")
    private String company;
    @Size(max = 20)
    @Column(name = "FLOTA")
    private String flota;
    @Column(name = "FECHACREA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacrea;

    public EngEaEoReqVw() {
        super();
    }

    public String getProceso() {
        return proceso;
    }

    public void setProceso(String proceso) {
        this.proceso = proceso;
    }

    public BigInteger getIdregistro() {
        return idregistro;
    }

    public void setIdregistro(BigInteger idregistro) {
        this.idregistro = idregistro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public BigInteger getNum() {
        return num;
    }

    public void setNum(BigInteger num) {
        this.num = num;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getFlota() {
        return flota;
    }

    public void setFlota(String flota) {
        this.flota = flota;
    }

    public Date getFechacrea() {
        return fechacrea;
    }

    public void setFechacrea(Date fechacrea) {
        this.fechacrea = fechacrea;
    }
    
}