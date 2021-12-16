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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vjuarez
 */
@Entity
@Cacheable(false)
@Table(name = "CORE_AIRCRAFT_TYPE",catalog = "", schema = "CORE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoreAircraftType.findAll", query = "SELECT c FROM CoreAircraftType c"),
    @NamedQuery(name = "CoreAircraftType.findByArctypId", query = "SELECT c FROM CoreAircraftType c WHERE c.arctypId = :arctypId"),
    @NamedQuery(name = "CoreAircraftType.findByArctypCode", query = "SELECT c FROM CoreAircraftType c WHERE c.arctypCode = :arctypCode"),
    @NamedQuery(name = "CoreAircraftType.findByArctypDesc", query = "SELECT c FROM CoreAircraftType c WHERE c.arctypDesc = :arctypDesc"),
    @NamedQuery(name = "CoreAircraftType.findByArctypCreatedBy", query = "SELECT c FROM CoreAircraftType c WHERE c.arctypCreatedBy = :arctypCreatedBy"),
    @NamedQuery(name = "CoreAircraftType.findByArctypCreationDate", query = "SELECT c FROM CoreAircraftType c WHERE c.arctypCreationDate = :arctypCreationDate"),
    @NamedQuery(name = "CoreAircraftType.findByArctypUpdatedBy", query = "SELECT c FROM CoreAircraftType c WHERE c.arctypUpdatedBy = :arctypUpdatedBy"),
    @NamedQuery(name = "CoreAircraftType.findByArctypUpdateDate", query = "SELECT c FROM CoreAircraftType c WHERE c.arctypUpdateDate = :arctypUpdateDate")})
public class CoreAircraftType implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation AIRCRAFT_TYPE_SEQ
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AIRCRAFT_TYPE_SEQ")
    @SequenceGenerator(name = "AIRCRAFT_TYPE_SEQ", sequenceName = "AIRCRAFT_TYPE_SEQ", allocationSize = 1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ARCTYP_ID")
    private BigDecimal arctypId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "ARCTYP_CODE")
    private String arctypCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "ARCTYP_DESC")
    private String arctypDesc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ARCTYP_CREATED_BY")
    private String arctypCreatedBy;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ARCTYP_CREATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date arctypCreationDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ARCTYP_UPDATED_BY")
    private String arctypUpdatedBy;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ARCTYP_UPDATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date arctypUpdateDate;

    public CoreAircraftType() {
        super();
    }

    public CoreAircraftType(BigDecimal arctypId) {
        this.arctypId = arctypId;
    }

    public CoreAircraftType(BigDecimal arctypId, String arctypCode, String arctypDesc, String arctypCreatedBy, Date arctypCreationDate, String arctypUpdatedBy, Date arctypUpdateDate) {
        this.arctypId = arctypId;
        this.arctypCode = arctypCode;
        this.arctypDesc = arctypDesc;
        this.arctypCreatedBy = arctypCreatedBy;
        this.arctypCreationDate = arctypCreationDate;
        this.arctypUpdatedBy = arctypUpdatedBy;
        this.arctypUpdateDate = arctypUpdateDate;
    }

    public BigDecimal getArctypId() {
        return arctypId;
    }

    public void setArctypId(BigDecimal arctypId) {
        this.arctypId = arctypId;
    }

    public String getArctypCode() {
        return arctypCode;
    }

    public void setArctypCode(String arctypCode) {
        this.arctypCode = arctypCode;
    }

    public String getArctypDesc() {
        return arctypDesc;
    }

    public void setArctypDesc(String arctypDesc) {
        this.arctypDesc = arctypDesc;
    }

    public String getArctypCreatedBy() {
        return arctypCreatedBy;
    }

    public void setArctypCreatedBy(String arctypCreatedBy) {
        this.arctypCreatedBy = arctypCreatedBy;
    }

    public Date getArctypCreationDate() {
        return arctypCreationDate;
    }

    public void setArctypCreationDate(Date arctypCreationDate) {
        this.arctypCreationDate = arctypCreationDate;
    }

    public String getArctypUpdatedBy() {
        return arctypUpdatedBy;
    }

    public void setArctypUpdatedBy(String arctypUpdatedBy) {
        this.arctypUpdatedBy = arctypUpdatedBy;
    }

    public Date getArctypUpdateDate() {
        return arctypUpdateDate;
    }

    public void setArctypUpdateDate(Date arctypUpdateDate) {
        this.arctypUpdateDate = arctypUpdateDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (arctypId != null ? arctypId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoreAircraftType)) {
            return false;
        }
        CoreAircraftType other = (CoreAircraftType) object;
        if ((this.arctypId == null && other.arctypId != null) || (this.arctypId != null && !this.arctypId.equals(other.arctypId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.CoreAircraftType[ arctypId=" + arctypId + " ]";
    }
    
}
