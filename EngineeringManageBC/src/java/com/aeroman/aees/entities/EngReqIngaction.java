/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pc
 */
@Entity
@Cacheable(false)
@Table(name = "ENG_REQ_INGACTION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngReqIngaction.findAll", query = "SELECT e FROM EngReqIngaction e"),
    @NamedQuery(name = "EngReqIngaction.findByEinActionId", query = "SELECT e FROM EngReqIngaction e WHERE e.einActionId = :einActionId"),
    @NamedQuery(name = "EngReqIngaction.findByEinDescription", query = "SELECT e FROM EngReqIngaction e WHERE e.einDescription = :einDescription"),
    @NamedQuery(name = "EngReqIngaction.findByEinDate", query = "SELECT e FROM EngReqIngaction e WHERE e.einDate = :einDate"),
    @NamedQuery(name = "EngReqIngaction.findByEinHours", query = "SELECT e FROM EngReqIngaction e WHERE e.einHours = :einHours"),
    @NamedQuery(name = "EngReqIngaction.findByReqMessageid", query = "SELECT e FROM EngReqIngaction e WHERE e.reqMessageid = :reqMessageid"),
    @NamedQuery(name = "EngReqIngaction.findByEinComments", query = "SELECT e FROM EngReqIngaction e WHERE e.einComments = :einComments"),
    @NamedQuery(name = "EngReqIngaction.findByEinRegsort", query = "SELECT e FROM EngReqIngaction e WHERE e.einRegsort = :einRegsort"),
    @NamedQuery(name = "EngReqIngaction.findByEinUserIns", query = "SELECT e FROM EngReqIngaction e WHERE e.einUserIns = :einUserIns"),
    @NamedQuery(name = "EngReqIngaction.findByEinFechaIns", query = "SELECT e FROM EngReqIngaction e WHERE e.einFechaIns = :einFechaIns"),
    @NamedQuery(name = "EngReqIngaction.findByEinUserUpd", query = "SELECT e FROM EngReqIngaction e WHERE e.einUserUpd = :einUserUpd"),
    @NamedQuery(name = "EngReqIngaction.findByEinDateUpd", query = "SELECT e FROM EngReqIngaction e WHERE e.einDateUpd = :einDateUpd"),
    @NamedQuery(name = "EngReqIngaction.findByEinStatus", query = "SELECT e FROM EngReqIngaction e WHERE e.einStatus = :einStatus")})
public class EngReqIngaction implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_REQ_INGACTION")
    @SequenceGenerator(name = "SEQ_REQ_INGACTION", sequenceName = "SEQ_REQ_INGACTION", allocationSize = 1)
    @Column(name = "EIN_ACTION_ID")
    private Integer einActionId;
    @Size(max = 4000)
    @Column(name = "EIN_DESCRIPTION")
    private String einDescription;
    @Column(name = "EIN_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date einDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "EIN_HOURS")
    private BigDecimal einHours;
    @Basic(optional = false)
    @NotNull
    @Column(name = "REQ_MESSAGEID")
    private BigInteger reqMessageid;
    @Size(max = 2000)
    @Column(name = "EIN_COMMENTS")
    private String einComments;
    @Column(name = "EIN_REGSORT")
    private Short einRegsort;
    @Size(max = 30)
    @Column(name = "EIN_USER_INS")
    private String einUserIns;
    @Column(name = "EIN_FECHA_INS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date einFechaIns;
    @Size(max = 30)
    @Column(name = "EIN_USER_UPD")
    private String einUserUpd;
    @Column(name = "EIN_DATE_UPD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date einDateUpd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "EIN_STATUS")
    private String einStatus;
    @Transient
    private String statusIA;

    public EngReqIngaction() {
        super();
    }

    public EngReqIngaction(Integer einActionId) {
        this.einActionId = einActionId;
    }

    public EngReqIngaction(Integer einActionId, BigInteger reqMessageid, String einStatus) {
        this.einActionId = einActionId;
        this.reqMessageid = reqMessageid;
        this.einStatus = einStatus;
    }

    public Integer getEinActionId() {
        return einActionId;
    }

    public void setEinActionId(Integer einActionId) {
        this.einActionId = einActionId;
    }

    public String getEinDescription() {
        return einDescription;
    }

    public void setEinDescription(String einDescription) {
        this.einDescription = einDescription;
    }

    public Date getEinDate() {
        return einDate;
    }

    public void setEinDate(Date einDate) {
        this.einDate = einDate;
    }

    public BigDecimal getEinHours() {
        return einHours;
    }

    public void setEinHours(BigDecimal einHours) {
        this.einHours = einHours;
    }

    public BigInteger getReqMessageid() {
        return reqMessageid;
    }

    public void setReqMessageid(BigInteger reqMessageid) {
        this.reqMessageid = reqMessageid;
    }

    public String getEinComments() {
        return einComments;
    }

    public void setEinComments(String einComments) {
        this.einComments = einComments;
    }

    public Short getEinRegsort() {
        return einRegsort;
    }

    public void setEinRegsort(Short einRegsort) {
        this.einRegsort = einRegsort;
    }

    public String getEinUserIns() {
        return einUserIns;
    }

    public void setEinUserIns(String einUserIns) {
        this.einUserIns = einUserIns;
    }

    public Date getEinFechaIns() {
        return einFechaIns;
    }

    public void setEinFechaIns(Date einFechaIns) {
        this.einFechaIns = einFechaIns;
    }

    public String getEinUserUpd() {
        return einUserUpd;
    }

    public void setEinUserUpd(String einUserUpd) {
        this.einUserUpd = einUserUpd;
    }

    public Date getEinDateUpd() {
        return einDateUpd;
    }

    public void setEinDateUpd(Date einDateUpd) {
        this.einDateUpd = einDateUpd;
    }

    public String getEinStatus() {
        return einStatus;
    }

    public void setEinStatus(String einStatus) {
        this.einStatus = einStatus;
    }

    public String getStatusIA() {
        return statusIA;
    }

    public void setStatusIA(String statusIA) {
        this.statusIA = statusIA;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (einActionId != null ? einActionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EngReqIngaction)) {
            return false;
        }
        EngReqIngaction other = (EngReqIngaction) object;
        if ((this.einActionId == null && other.einActionId != null) || (this.einActionId != null && !this.einActionId.equals(other.einActionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngReqIngaction[ einActionId=" + einActionId + " ]";
    }
    
}
