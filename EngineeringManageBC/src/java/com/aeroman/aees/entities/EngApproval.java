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
@Table(name = "ENG_APPROVAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngApproval.findAll", query = "SELECT e FROM EngApproval e"),
    @NamedQuery(name = "EngApproval.findByEoIdord", query = "SELECT e FROM EngApproval e WHERE e.engApprovalPK.eoIdord = :eoIdord"),
    @NamedQuery(name = "EngApproval.findByIdacf", query = "SELECT e FROM EngApproval e WHERE e.engApprovalPK.idacf = :idacf"),
    @NamedQuery(name = "EngApproval.findByFltCod", query = "SELECT e FROM EngApproval e WHERE e.engApprovalPK.fltCod = :fltCod"),
    @NamedQuery(name = "EngApproval.findByGrpId", query = "SELECT e FROM EngApproval e WHERE e.engApprovalPK.grpId = :grpId"),
    @NamedQuery(name = "EngApproval.findByAppApprovalDate", query = "SELECT e FROM EngApproval e WHERE e.appApprovalDate = :appApprovalDate"),
    @NamedQuery(name = "EngApproval.findByAppStatus", query = "SELECT e FROM EngApproval e WHERE e.appStatus = :appStatus"),
    @NamedQuery(name = "EngApproval.findByAppCodusr", query = "SELECT e FROM EngApproval e WHERE e.appCodusr = :appCodusr"),
    @NamedQuery(name = "EngApproval.findByAppSignStatus", query = "SELECT e FROM EngApproval e WHERE e.appSignStatus = :appSignStatus")})
public class EngApproval implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EngApprovalPK engApprovalPK;
    @Column(name = "APP_APPROVAL_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date appApprovalDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "APP_STATUS")
    private String appStatus;
    @Size(max = 30)
    @Column(name = "APP_CODUSR")
    private String appCodusr;
    @Size(max = 3)
    @Column(name = "APP_SIGN_STATUS")
    private String appSignStatus;

    public EngApproval() {
        super();
    }

    public EngApproval(EngApprovalPK engApprovalPK) {
        this.engApprovalPK = engApprovalPK;
    }

    public EngApproval(EngApprovalPK engApprovalPK, String appStatus) {
        this.engApprovalPK = engApprovalPK;
        this.appStatus = appStatus;
    }

    public EngApproval(long eoIdord, short idacf, String fltCod, short grpId) {
        this.engApprovalPK = new EngApprovalPK(eoIdord, idacf, fltCod, grpId);
    }

    public EngApprovalPK getEngApprovalPK() {
        return engApprovalPK;
    }

    public void setEngApprovalPK(EngApprovalPK engApprovalPK) {
        this.engApprovalPK = engApprovalPK;
    }

    public Date getAppApprovalDate() {
        return appApprovalDate;
    }

    public void setAppApprovalDate(Date appApprovalDate) {
        this.appApprovalDate = appApprovalDate;
    }

    public String getAppStatus() {
        return appStatus;
    }

    public void setAppStatus(String appStatus) {
        this.appStatus = appStatus;
    }

    public String getAppCodusr() {
        return appCodusr;
    }

    public void setAppCodusr(String appCodusr) {
        this.appCodusr = appCodusr;
    }

    public String getAppSignStatus() {
        return appSignStatus;
    }

    public void setAppSignStatus(String appSignStatus) {
        this.appSignStatus = appSignStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (engApprovalPK != null ? engApprovalPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EngApproval)) {
            return false;
        }
        EngApproval other = (EngApproval) object;
        if ((this.engApprovalPK == null && other.engApprovalPK != null) || (this.engApprovalPK != null && !this.engApprovalPK.equals(other.engApprovalPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngApproval[ engApprovalPK=" + engApprovalPK + " ]";
    }
    
}
