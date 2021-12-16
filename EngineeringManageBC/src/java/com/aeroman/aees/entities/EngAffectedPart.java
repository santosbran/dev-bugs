/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mpolanco
 */
@Entity
@Cacheable(false)
@Table(name = "ENG_AFFECTED_PART")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngAffectedPart.findAll", query = "SELECT e FROM EngAffectedPart e")
    , @NamedQuery(name = "EngAffectedPart.findByAfpId", query = "SELECT e FROM EngAffectedPart e WHERE e.afpId = :afpId")
    , @NamedQuery(name = "EngAffectedPart.findByAfpName", query = "SELECT e FROM EngAffectedPart e WHERE e.afpName = :afpName")
    , @NamedQuery(name = "EngAffectedPart.findByAfpDescription", query = "SELECT e FROM EngAffectedPart e WHERE e.afpDescription = :afpDescription")
    , @NamedQuery(name = "EngAffectedPart.findByAfpState", query = "SELECT e FROM EngAffectedPart e WHERE e.afpState = :afpState")
    , @NamedQuery(name = "EngAffectedPart.findByAfpUserAdd", query = "SELECT e FROM EngAffectedPart e WHERE e.afpUserAdd = :afpUserAdd")
    , @NamedQuery(name = "EngAffectedPart.findByAfpDateAdd", query = "SELECT e FROM EngAffectedPart e WHERE e.afpDateAdd = :afpDateAdd")
    , @NamedQuery(name = "EngAffectedPart.findByAfpUserUpd", query = "SELECT e FROM EngAffectedPart e WHERE e.afpUserUpd = :afpUserUpd")
    , @NamedQuery(name = "EngAffectedPart.findByAfpDateUpd", query = "SELECT e FROM EngAffectedPart e WHERE e.afpDateUpd = :afpDateUpd")
    , @NamedQuery(name = "EngAffectedPart.findByAfpUserDlt", query = "SELECT e FROM EngAffectedPart e WHERE e.afpUserDlt = :afpUserDlt")
    , @NamedQuery(name = "EngAffectedPart.findByAfpDateDlt", query = "SELECT e FROM EngAffectedPart e WHERE e.afpDateDlt = :afpDateDlt")})
public class EngAffectedPart implements Serializable {

    @OneToMany(mappedBy = "reqAfpId")
    private Collection<EngRequest> engRequestCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "afpId")
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue (strategy=GenerationType.SEQUENCE,generator="ENG_AFFECTED_PART_SEQ") 
    @SequenceGenerator (name="ENG_AFFECTED_PART_SEQ",sequenceName="ENG_AFFECTED_PART_SEQ",allocationSize=1)
    @Column(name = "AFP_ID")
    private BigDecimal afpId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "AFP_NAME")
    private String afpName;
    @Size(max = 200)
    @Column(name = "AFP_DESCRIPTION")
    private String afpDescription;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "AFP_STATE")
    private String afpState;
    @Size(max = 9)
    @Column(name = "AFP_USER_ADD")
    private String afpUserAdd;
    @Column(name = "AFP_DATE_ADD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date afpDateAdd;
    @Size(max = 9)
    @Column(name = "AFP_USER_UPD")
    private String afpUserUpd;
    @Column(name = "AFP_DATE_UPD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date afpDateUpd;
    @Size(max = 9)
    @Column(name = "AFP_USER_DLT")
    private String afpUserDlt;
    @Column(name = "AFP_DATE_DLT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date afpDateDlt;

    public EngAffectedPart() {
    }

    public EngAffectedPart(BigDecimal afpId) {
        this.afpId = afpId;
    }

    public EngAffectedPart(BigDecimal afpId, String afpName, String afpState) {
        this.afpId = afpId;
        this.afpName = afpName;
        this.afpState = afpState;
    }

    public BigDecimal getAfpId() {
        return afpId;
    }

    public void setAfpId(BigDecimal afpId) {
        this.afpId = afpId;
    }

    public String getAfpName() {
        return afpName;
    }

    public void setAfpName(String afpName) {
        this.afpName = afpName;
    }

    public String getAfpDescription() {
        return afpDescription;
    }

    public void setAfpDescription(String afpDescription) {
        this.afpDescription = afpDescription;
    }

    public String getAfpState() {
        return afpState;
    }

    public void setAfpState(String afpState) {
        this.afpState = afpState;
    }

    public String getAfpUserAdd() {
        return afpUserAdd;
    }

    public void setAfpUserAdd(String afpUserAdd) {
        this.afpUserAdd = afpUserAdd;
    }

    public Date getAfpDateAdd() {
        return afpDateAdd;
    }

    public void setAfpDateAdd(Date afpDateAdd) {
        this.afpDateAdd = afpDateAdd;
    }

    public String getAfpUserUpd() {
        return afpUserUpd;
    }

    public void setAfpUserUpd(String afpUserUpd) {
        this.afpUserUpd = afpUserUpd;
    }

    public Date getAfpDateUpd() {
        return afpDateUpd;
    }

    public void setAfpDateUpd(Date afpDateUpd) {
        this.afpDateUpd = afpDateUpd;
    }

    public String getAfpUserDlt() {
        return afpUserDlt;
    }

    public void setAfpUserDlt(String afpUserDlt) {
        this.afpUserDlt = afpUserDlt;
    }

    public Date getAfpDateDlt() {
        return afpDateDlt;
    }

    public void setAfpDateDlt(Date afpDateDlt) {
        this.afpDateDlt = afpDateDlt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (afpId != null ? afpId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EngAffectedPart)) {
            return false;
        }
        EngAffectedPart other = (EngAffectedPart) object;
        if ((this.afpId == null && other.afpId != null) || (this.afpId != null && !this.afpId.equals(other.afpId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngAffectedPart[ afpId=" + afpId + " ]";
    }

    @XmlTransient
    public Collection<EngRequest> getEngRequestCollection() {
        return engRequestCollection;
    }

    public void setEngRequestCollection(Collection<EngRequest> engRequestCollection) {
        this.engRequestCollection = engRequestCollection;
    }
    
}