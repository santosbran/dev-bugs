/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities;

import java.io.Serializable;
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
@Table(name = "ENG_APPROVAL_CONFIG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngApprovalConfig.findAll", query = "SELECT e FROM EngApprovalConfig e"),
    @NamedQuery(name = "EngApprovalConfig.findByAcfId", query = "SELECT e FROM EngApprovalConfig e WHERE e.acfId = :acfId"),
    @NamedQuery(name = "EngApprovalConfig.findByAcfDescription", query = "SELECT e FROM EngApprovalConfig e WHERE e.acfDescription = :acfDescription"),
    @NamedQuery(name = "EngApprovalConfig.findByAcfUseStart", query = "SELECT e FROM EngApprovalConfig e WHERE e.acfUseStart = :acfUseStart"),
    @NamedQuery(name = "EngApprovalConfig.findByAcfUseEnd", query = "SELECT e FROM EngApprovalConfig e WHERE e.acfUseEnd = :acfUseEnd"),
    @NamedQuery(name = "EngApprovalConfig.findByFltCod", query = "SELECT e FROM EngApprovalConfig e WHERE e.fltCod = :fltCod"),
    @NamedQuery(name = "EngApprovalConfig.findByAcfUsrIns", query = "SELECT e FROM EngApprovalConfig e WHERE e.acfUsrIns = :acfUsrIns"),
    @NamedQuery(name = "EngApprovalConfig.findByAcfDateIns", query = "SELECT e FROM EngApprovalConfig e WHERE e.acfDateIns = :acfDateIns"),
    @NamedQuery(name = "EngApprovalConfig.findByAcfUsrUpd", query = "SELECT e FROM EngApprovalConfig e WHERE e.acfUsrUpd = :acfUsrUpd"),
    @NamedQuery(name = "EngApprovalConfig.findByAcfDateUpd", query = "SELECT e FROM EngApprovalConfig e WHERE e.acfDateUpd = :acfDateUpd")})
public class EngApprovalConfig implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACF_ID")
    private String acfId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ACF_DESCRIPTION")
    private String acfDescription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACF_USE_START")
    @Temporal(TemporalType.TIMESTAMP)
    private Date acfUseStart;
    @Column(name = "ACF_USE_END")
    @Temporal(TemporalType.TIMESTAMP)
    private Date acfUseEnd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "FLT_COD")
    private String fltCod;
    @Size(max = 30)
    @Column(name = "ACF_USR_INS")
    private String acfUsrIns;
    @Column(name = "ACF_DATE_INS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date acfDateIns;
    @Size(max = 30)
    @Column(name = "ACF_USR_UPD")
    private String acfUsrUpd;
    @Column(name = "ACF_DATE_UPD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date acfDateUpd;

    public EngApprovalConfig() {
        super();
    }

    public EngApprovalConfig(String acfId) {
        this.acfId = acfId;
    }

    public EngApprovalConfig(String acfId, String acfDescription, Date acfUseStart, String fltCod) {
        this.acfId = acfId;
        this.acfDescription = acfDescription;
        this.acfUseStart = acfUseStart;
        this.fltCod = fltCod;
    }

    public String getAcfId() {
        return acfId;
    }

    public void setAcfId(String acfId) {
        this.acfId = acfId;
    }

    public String getAcfDescription() {
        return acfDescription;
    }

    public void setAcfDescription(String acfDescription) {
        this.acfDescription = acfDescription;
    }

    public Date getAcfUseStart() {
        return acfUseStart;
    }

    public void setAcfUseStart(Date acfUseStart) {
        this.acfUseStart = acfUseStart;
    }

    public Date getAcfUseEnd() {
        return acfUseEnd;
    }

    public void setAcfUseEnd(Date acfUseEnd) {
        this.acfUseEnd = acfUseEnd;
    }

    public String getFltCod() {
        return fltCod;
    }

    public void setFltCod(String fltCod) {
        this.fltCod = fltCod;
    }

    public String getAcfUsrIns() {
        return acfUsrIns;
    }

    public void setAcfUsrIns(String acfUsrIns) {
        this.acfUsrIns = acfUsrIns;
    }

    public Date getAcfDateIns() {
        return acfDateIns;
    }

    public void setAcfDateIns(Date acfDateIns) {
        this.acfDateIns = acfDateIns;
    }

    public String getAcfUsrUpd() {
        return acfUsrUpd;
    }

    public void setAcfUsrUpd(String acfUsrUpd) {
        this.acfUsrUpd = acfUsrUpd;
    }

    public Date getAcfDateUpd() {
        return acfDateUpd;
    }

    public void setAcfDateUpd(Date acfDateUpd) {
        this.acfDateUpd = acfDateUpd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (acfId != null ? acfId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EngApprovalConfig)) {
            return false;
        }
        EngApprovalConfig other = (EngApprovalConfig) object;
        if ((this.acfId == null && other.acfId != null) || (this.acfId != null && !this.acfId.equals(other.acfId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngApprovalConfig[ acfId=" + acfId + " ]";
    }
    
}
