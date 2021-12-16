/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Cacheable(false)
@Table(name = "ENG_CAT_ACTIVIDADES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngCatActividades.findAll", query = "SELECT e FROM EngCatActividades e"),
    @NamedQuery(name = "EngCatActividades.findByActId", query = "SELECT e FROM EngCatActividades e WHERE e.actId = :actId"),
    @NamedQuery(name = "EngCatActividades.findByActDescripcion", query = "SELECT e FROM EngCatActividades e WHERE e.actDescripcion = :actDescripcion"),
    @NamedQuery(name = "EngCatActividades.findByActCodUsrIns", query = "SELECT e FROM EngCatActividades e WHERE e.actCodUsrIns = :actCodUsrIns"),
    @NamedQuery(name = "EngCatActividades.findByActFechaIns", query = "SELECT e FROM EngCatActividades e WHERE e.actFechaIns = :actFechaIns"),
    @NamedQuery(name = "EngCatActividades.findByActCodUsrAct", query = "SELECT e FROM EngCatActividades e WHERE e.actCodUsrAct = :actCodUsrAct"),
    @NamedQuery(name = "EngCatActividades.findByActFechaAct", query = "SELECT e FROM EngCatActividades e WHERE e.actFechaAct = :actFechaAct")})
public class EngCatActividades implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACT_ID")
    private BigDecimal actId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ACT_DESCRIPCION")
    private String actDescripcion;
    @Size(max = 30)
    @Column(name = "ACT_COD_USR_INS")
    private String actCodUsrIns;
    @Column(name = "ACT_FECHA_INS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actFechaIns;
    @Size(max = 30)
    @Column(name = "ACT_COD_USR_ACT")
    private String actCodUsrAct;
    @Column(name = "ACT_FECHA_ACT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actFechaAct;

    public EngCatActividades() {
        super();
    }

    public EngCatActividades(BigDecimal actId) {
        this.actId = actId;
    }

    public EngCatActividades(BigDecimal actId, String actDescripcion) {
        this.actId = actId;
        this.actDescripcion = actDescripcion;
    }

    public BigDecimal getActId() {
        return actId;
    }

    public void setActId(BigDecimal actId) {
        this.actId = actId;
    }

    public String getActDescripcion() {
        return actDescripcion;
    }

    public void setActDescripcion(String actDescripcion) {
        this.actDescripcion = actDescripcion;
    }

    public String getActCodUsrIns() {
        return actCodUsrIns;
    }

    public void setActCodUsrIns(String actCodUsrIns) {
        this.actCodUsrIns = actCodUsrIns;
    }

    public Date getActFechaIns() {
        return actFechaIns;
    }

    public void setActFechaIns(Date actFechaIns) {
        this.actFechaIns = actFechaIns;
    }

    public String getActCodUsrAct() {
        return actCodUsrAct;
    }

    public void setActCodUsrAct(String actCodUsrAct) {
        this.actCodUsrAct = actCodUsrAct;
    }

    public Date getActFechaAct() {
        return actFechaAct;
    }

    public void setActFechaAct(Date actFechaAct) {
        this.actFechaAct = actFechaAct;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (actId != null ? actId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EngCatActividades)) {
            return false;
        }
        EngCatActividades other = (EngCatActividades) object;
        if ((this.actId == null && other.actId != null) || (this.actId != null && !this.actId.equals(other.actId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngCatActividades[ actId=" + actId + " ]";
    }
    
}
