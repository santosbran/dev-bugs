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
 * @author pc
 */
@Entity
@Cacheable(false)
@Table(name = "ENG_EA_HRS_INS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngEaHrsIns.findAll", query = "SELECT e FROM EngEaHrsIns e"),
    @NamedQuery(name = "EngEaHrsIns.findByEhiId", query = "SELECT e FROM EngEaHrsIns e WHERE e.ehiId = :ehiId"),
    @NamedQuery(name = "EngEaHrsIns.findByEhiName", query = "SELECT e FROM EngEaHrsIns e WHERE e.ehiName = :ehiName"),
    @NamedQuery(name = "EngEaHrsIns.findByEhiCodUsrIns", query = "SELECT e FROM EngEaHrsIns e WHERE e.ehiCodUsrIns = :ehiCodUsrIns"),
    @NamedQuery(name = "EngEaHrsIns.findByEhiDateIns", query = "SELECT e FROM EngEaHrsIns e WHERE e.ehiDateIns = :ehiDateIns"),
    @NamedQuery(name = "EngEaHrsIns.findByEhiCodUsrUpd", query = "SELECT e FROM EngEaHrsIns e WHERE e.ehiCodUsrUpd = :ehiCodUsrUpd"),
    @NamedQuery(name = "EngEaHrsIns.findByEhiDateUpd", query = "SELECT e FROM EngEaHrsIns e WHERE e.ehiDateUpd = :ehiDateUpd")})
public class EngEaHrsIns implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EHI_ID")
    private BigDecimal ehiId;
    @Size(max = 400)
    @Column(name = "EHI_NAME")
    private String ehiName;
    @Size(max = 30)
    @Column(name = "EHI_COD_USR_INS")
    private String ehiCodUsrIns;
    @Column(name = "EHI_DATE_INS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ehiDateIns;
    @Size(max = 30)
    @Column(name = "EHI_COD_USR_UPD")
    private String ehiCodUsrUpd;
    @Column(name = "EHI_DATE_UPD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ehiDateUpd;

    public EngEaHrsIns() {
        super();
    }

    public EngEaHrsIns(BigDecimal ehiId) {
        this.ehiId = ehiId;
    }

    public BigDecimal getEhiId() {
        return ehiId;
    }

    public void setEhiId(BigDecimal ehiId) {
        this.ehiId = ehiId;
    }

    public String getEhiName() {
        return ehiName;
    }

    public void setEhiName(String ehiName) {
        this.ehiName = ehiName;
    }

    public String getEhiCodUsrIns() {
        return ehiCodUsrIns;
    }

    public void setEhiCodUsrIns(String ehiCodUsrIns) {
        this.ehiCodUsrIns = ehiCodUsrIns;
    }

    public Date getEhiDateIns() {
        return ehiDateIns;
    }

    public void setEhiDateIns(Date ehiDateIns) {
        this.ehiDateIns = ehiDateIns;
    }

    public String getEhiCodUsrUpd() {
        return ehiCodUsrUpd;
    }

    public void setEhiCodUsrUpd(String ehiCodUsrUpd) {
        this.ehiCodUsrUpd = ehiCodUsrUpd;
    }

    public Date getEhiDateUpd() {
        return ehiDateUpd;
    }

    public void setEhiDateUpd(Date ehiDateUpd) {
        this.ehiDateUpd = ehiDateUpd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ehiId != null ? ehiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EngEaHrsIns)) {
            return false;
        }
        EngEaHrsIns other = (EngEaHrsIns) object;
        if ((this.ehiId == null && other.ehiId != null) || (this.ehiId != null && !this.ehiId.equals(other.ehiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngEaHrsIns[ ehiId=" + ehiId + " ]";
    }
    
}
