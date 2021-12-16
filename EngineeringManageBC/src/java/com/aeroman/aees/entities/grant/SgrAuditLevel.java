/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities.grant;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author saplic
 */
@Entity
@Cacheable(false)
@Table(name = "SGR_AUDIT_LEVEL", catalog = "", schema = "PROCESOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SgrAuditLevel.findAll", query = "SELECT s FROM SgrAuditLevel s"),
    @NamedQuery(name = "SgrAuditLevel.findByAuditLevel", query = "SELECT s FROM SgrAuditLevel s WHERE s.auditLevel = :auditLevel"),
    @NamedQuery(name = "SgrAuditLevel.findByAuditLevelName", query = "SELECT s FROM SgrAuditLevel s WHERE s.auditLevelName = :auditLevelName")})
public class SgrAuditLevel implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "AUDIT_LEVEL")
    private BigDecimal auditLevel;
    @Size(max = 50)
    @Column(name = "AUDIT_LEVEL_NAME")
    private String auditLevelName;
    @OneToMany(mappedBy = "auditLevel")
    private List<SgrSystemOption> sgrSystemOptionList;

    public SgrAuditLevel() {
        super();
    }

    public SgrAuditLevel(BigDecimal auditLevel) {
        this.auditLevel = auditLevel;
    }

    public BigDecimal getAuditLevel() {
        return auditLevel;
    }

    public void setAuditLevel(BigDecimal auditLevel) {
        this.auditLevel = auditLevel;
    }

    public String getAuditLevelName() {
        return auditLevelName;
    }

    public void setAuditLevelName(String auditLevelName) {
        this.auditLevelName = auditLevelName;
    }

    @XmlTransient
    public List<SgrSystemOption> getSgrSystemOptionList() {
        return sgrSystemOptionList;
    }

    public void setSgrSystemOptionList(List<SgrSystemOption> sgrSystemOptionList) {
        this.sgrSystemOptionList = sgrSystemOptionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (auditLevel != null ? auditLevel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof SgrAuditLevel)) {
            return false;
        }
        SgrAuditLevel other = (SgrAuditLevel) object;
        if ((this.auditLevel == null && other.auditLevel != null) || (this.auditLevel != null && !this.auditLevel.equals(other.auditLevel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.SgrAuditLevel[ auditLevel=" + auditLevel + " ]";
    }
    
}
