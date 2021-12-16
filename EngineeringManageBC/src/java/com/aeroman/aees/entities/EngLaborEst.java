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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
 * @author pc
 */
@Entity
@Cacheable(false)
@Table(name = "ENG_LABOR_EST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngLaborEst.findAll", query = "SELECT e FROM EngLaborEst e"),
    @NamedQuery(name = "EngLaborEst.findByEoIdord", query = "SELECT e FROM EngLaborEst e WHERE e.engLaborEstPK.eoIdord = :eoIdord"),
    @NamedQuery(name = "EngLaborEst.findBySklCod", query = "SELECT e FROM EngLaborEst e WHERE e.engLaborEstPK.sklCod = :sklCod"),
    @NamedQuery(name = "EngLaborEst.findBySklCrew", query = "SELECT e FROM EngLaborEst e WHERE e.sklCrew = :sklCrew"),
    @NamedQuery(name = "EngLaborEst.findBySklManHours", query = "SELECT e FROM EngLaborEst e WHERE e.sklManHours = :sklManHours"),
    @NamedQuery(name = "EngLaborEst.findBySklElapsed", query = "SELECT e FROM EngLaborEst e WHERE e.sklElapsed = :sklElapsed"),
    @NamedQuery(name = "EngLaborEst.findBySklUserIns", query = "SELECT e FROM EngLaborEst e WHERE e.sklUserIns = :sklUserIns"),
    @NamedQuery(name = "EngLaborEst.findBySklDateIns", query = "SELECT e FROM EngLaborEst e WHERE e.sklDateIns = :sklDateIns"),
    @NamedQuery(name = "EngLaborEst.findBySklUserUpd", query = "SELECT e FROM EngLaborEst e WHERE e.sklUserUpd = :sklUserUpd"),
    @NamedQuery(name = "EngLaborEst.findBySklDateAct", query = "SELECT e FROM EngLaborEst e WHERE e.sklDateAct = :sklDateAct")})
public class EngLaborEst implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EngLaborEstPK engLaborEstPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SKL_CREW")
    private short sklCrew;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "SKL_MAN_HOURS")
    private BigDecimal sklManHours;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "SKL_ELAPSED")
    private String sklElapsed;
    @Size(max = 30)
    @Column(name = "SKL_USER_INS")
    private String sklUserIns;
    @Column(name = "SKL_DATE_INS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sklDateIns;
    @Size(max = 30)
    @Column(name = "SKL_USER_UPD")
    private String sklUserUpd;
    @Column(name = "SKL_DATE_ACT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sklDateAct;

    public EngLaborEst() {
        super();
    }

    public EngLaborEst(EngLaborEstPK engLaborEstPK) {
        this.engLaborEstPK = engLaborEstPK;
    }

    public EngLaborEst(EngLaborEstPK engLaborEstPK, short sklCrew, BigDecimal sklManHours, String sklElapsed) {
        this.engLaborEstPK = engLaborEstPK;
        this.sklCrew = sklCrew;
        this.sklManHours = sklManHours;
        this.sklElapsed = sklElapsed;
    }

    public EngLaborEst(long eoIdord, String sklCod) {
        this.engLaborEstPK = new EngLaborEstPK(eoIdord, sklCod);
    }

    public EngLaborEstPK getEngLaborEstPK() {
        return engLaborEstPK;
    }

    public void setEngLaborEstPK(EngLaborEstPK engLaborEstPK) {
        this.engLaborEstPK = engLaborEstPK;
    }

    public short getSklCrew() {
        return sklCrew;
    }

    public void setSklCrew(short sklCrew) {
        this.sklCrew = sklCrew;
    }

    public BigDecimal getSklManHours() {
        return sklManHours;
    }

    public void setSklManHours(BigDecimal sklManHours) {
        this.sklManHours = sklManHours;
    }

    public String getSklElapsed() {
        return sklElapsed;
    }

    public void setSklElapsed(String sklElapsed) {
        this.sklElapsed = sklElapsed;
    }

    public String getSklUserIns() {
        return sklUserIns;
    }

    public void setSklUserIns(String sklUserIns) {
        this.sklUserIns = sklUserIns;
    }

    public Date getSklDateIns() {
        return sklDateIns;
    }

    public void setSklDateIns(Date sklDateIns) {
        this.sklDateIns = sklDateIns;
    }

    public String getSklUserUpd() {
        return sklUserUpd;
    }

    public void setSklUserUpd(String sklUserUpd) {
        this.sklUserUpd = sklUserUpd;
    }

    public Date getSklDateAct() {
        return sklDateAct;
    }

    public void setSklDateAct(Date sklDateAct) {
        this.sklDateAct = sklDateAct;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (engLaborEstPK != null ? engLaborEstPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EngLaborEst)) {
            return false;
        }
        EngLaborEst other = (EngLaborEst) object;
        if ((this.engLaborEstPK == null && other.engLaborEstPK != null) || (this.engLaborEstPK != null && !this.engLaborEstPK.equals(other.engLaborEstPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngLaborEst[ engLaborEstPK=" + engLaborEstPK + " ]";
    }
    
}
