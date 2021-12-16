/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities;

import java.io.Serializable;
import java.math.BigInteger;
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
 * @author pc
 */
@Entity
@Cacheable(false)
@Table(name = "ENG_ESR_ORD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngEsrOrd.findAll", query = "SELECT e FROM EngEsrOrd e"),
    @NamedQuery(name = "EngEsrOrd.findByEsoId", query = "SELECT e FROM EngEsrOrd e WHERE e.esoId = :esoId"),
    @NamedQuery(name = "EngEsrOrd.findByEsoMessageid", query = "SELECT e FROM EngEsrOrd e WHERE e.esoMessageid = :esoMessageid"),
    @NamedQuery(name = "EngEsrOrd.findByEoIdord", query = "SELECT e FROM EngEsrOrd e WHERE e.eoIdord = :eoIdord"),
    @NamedQuery(name = "EngEsrOrd.findByEsoUsrIns", query = "SELECT e FROM EngEsrOrd e WHERE e.esoUsrIns = :esoUsrIns"),
    @NamedQuery(name = "EngEsrOrd.findByEsoDateIns", query = "SELECT e FROM EngEsrOrd e WHERE e.esoDateIns = :esoDateIns"),
    @NamedQuery(name = "EngEsrOrd.findByEsoUsrUpd", query = "SELECT e FROM EngEsrOrd e WHERE e.esoUsrUpd = :esoUsrUpd"),
    @NamedQuery(name = "EngEsrOrd.findByEsoDateUpd", query = "SELECT e FROM EngEsrOrd e WHERE e.esoDateUpd = :esoDateUpd")})
public class EngEsrOrd implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESO_ID")
    private Integer esoId;
    @Column(name = "ESO_MESSAGEID")
    private BigInteger esoMessageid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EO_IDORD")
    private long eoIdord;
    @Size(max = 30)
    @Column(name = "ESO_USR_INS")
    private String esoUsrIns;
    @Column(name = "ESO_DATE_INS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date esoDateIns;
    @Size(max = 30)
    @Column(name = "ESO_USR_UPD")
    private String esoUsrUpd;
    @Column(name = "ESO_DATE_UPD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date esoDateUpd;

    public EngEsrOrd() {
        super();
    }

    public EngEsrOrd(Integer esoId) {
        this.esoId = esoId;
    }

    public EngEsrOrd(Integer esoId, long eoIdord) {
        this.esoId = esoId;
        this.eoIdord = eoIdord;
    }

    public Integer getEsoId() {
        return esoId;
    }

    public void setEsoId(Integer esoId) {
        this.esoId = esoId;
    }

    public BigInteger getEsoMessageid() {
        return esoMessageid;
    }

    public void setEsoMessageid(BigInteger esoMessageid) {
        this.esoMessageid = esoMessageid;
    }

    public long getEoIdord() {
        return eoIdord;
    }

    public void setEoIdord(long eoIdord) {
        this.eoIdord = eoIdord;
    }

    public String getEsoUsrIns() {
        return esoUsrIns;
    }

    public void setEsoUsrIns(String esoUsrIns) {
        this.esoUsrIns = esoUsrIns;
    }

    public Date getEsoDateIns() {
        return esoDateIns;
    }

    public void setEsoDateIns(Date esoDateIns) {
        this.esoDateIns = esoDateIns;
    }

    public String getEsoUsrUpd() {
        return esoUsrUpd;
    }

    public void setEsoUsrUpd(String esoUsrUpd) {
        this.esoUsrUpd = esoUsrUpd;
    }

    public Date getEsoDateUpd() {
        return esoDateUpd;
    }

    public void setEsoDateUpd(Date esoDateUpd) {
        this.esoDateUpd = esoDateUpd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (esoId != null ? esoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EngEsrOrd)) {
            return false;
        }
        EngEsrOrd other = (EngEsrOrd) object;
        if ((this.esoId == null && other.esoId != null) || (this.esoId != null && !this.esoId.equals(other.esoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngEsrOrd[ esoId=" + esoId + " ]";
    }
    
}
