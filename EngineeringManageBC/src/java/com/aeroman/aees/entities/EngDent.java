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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "ENG_DENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngDent.findAll", query = "SELECT e FROM EngDent e"),
    @NamedQuery(name = "EngDent.findByDenId", query = "SELECT e FROM EngDent e WHERE e.denId = :denId"),
    @NamedQuery(name = "EngDent.findByDenDiscrepancy", query = "SELECT e FROM EngDent e WHERE e.denDiscrepancy = :denDiscrepancy"),
    @NamedQuery(name = "EngDent.findByDenRefEvaluated", query = "SELECT e FROM EngDent e WHERE e.denRefEvaluated = :denRefEvaluated"),
    @NamedQuery(name = "EngDent.findByDenAttachments", query = "SELECT e FROM EngDent e WHERE e.denAttachments = :denAttachments"),
    @NamedQuery(name = "EngDent.findByDenReqAct", query = "SELECT e FROM EngDent e WHERE e.denReqAct = :denReqAct"),
    @NamedQuery(name = "EngDent.findByDenDateTime", query = "SELECT e FROM EngDent e WHERE e.denDateTime = :denDateTime"),
    @NamedQuery(name = "EngDent.findByDenTemplateData", query = "SELECT e FROM EngDent e WHERE e.denTemplateData = :denTemplateData"),
    @NamedQuery(name = "EngDent.findByDenAircraftGround", query = "SELECT e FROM EngDent e WHERE e.denAircraftGround = :denAircraftGround"),
    @NamedQuery(name = "EngDent.findByDenCritical", query = "SELECT e FROM EngDent e WHERE e.denCritical = :denCritical")})
public class EngDent implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @GeneratedValue (strategy=GenerationType.SEQUENCE,generator="ENG_DENT_SEQ") 
    @SequenceGenerator (name="ENG_DENT_SEQ",sequenceName="ENG_DENT_SEQ",allocationSize=1)
    @NotNull
    @Column(name = "DEN_ID")
    private BigDecimal denId;
    @Size(max = 500)
    @Column(name = "DEN_DISCREPANCY")
    private String denDiscrepancy;
    @Size(max = 500)
    @Column(name = "DEN_REF_EVALUATED")
    private String denRefEvaluated;
    @Column(name = "DEN_ATTACHMENTS")
    private BigInteger denAttachments;
    @Size(max = 500)
    @Column(name = "DEN_REQ_ACT")
    private String denReqAct;
    @Column(name = "DEN_DATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date denDateTime;
    @Size(max = 500)
    @Column(name = "DEN_TEMPLATE_DATA")
    private String denTemplateData;
    @Size(max = 1)
    @Column(name = "DEN_AIRCRAFT_GROUND")
    private String denAircraftGround;
    @Size(max = 1)
    @Column(name = "DEN_CRITICAL")
    private String denCritical;
    @JoinColumn(name = "DAT_ID", referencedColumnName = "DAT_ID")
    @ManyToOne(optional = false)
    private EngDamageType datId;
    @JoinColumn(name = "REQ_MESSAGEID", referencedColumnName = "REQ_MESSAGEID")
    @ManyToOne(optional = false)
    private EngRequest reqMessageid;

    public EngDent() {
        super();
    }

    public EngDent(BigDecimal denId) {
        this.denId = denId;
    }

    public BigDecimal getDenId() {
        return denId;
    }

    public void setDenId(BigDecimal denId) {
        this.denId = denId;
    }

    public String getDenDiscrepancy() {
        return denDiscrepancy;
    }

    public void setDenDiscrepancy(String denDiscrepancy) {
        this.denDiscrepancy = denDiscrepancy;
    }

    public String getDenRefEvaluated() {
        return denRefEvaluated;
    }

    public void setDenRefEvaluated(String denRefEvaluated) {
        this.denRefEvaluated = denRefEvaluated;
    }

    public BigInteger getDenAttachments() {
        return denAttachments;
    }

    public void setDenAttachments(BigInteger denAttachments) {
        this.denAttachments = denAttachments;
    }

    public String getDenReqAct() {
        return denReqAct;
    }

    public void setDenReqAct(String denReqAct) {
        this.denReqAct = denReqAct;
    }

    public Date getDenDateTime() {
        return denDateTime;
    }

    public void setDenDateTime(Date denDateTime) {
        this.denDateTime = denDateTime;
    }

    public String getDenTemplateData() {
        return denTemplateData;
    }

    public void setDenTemplateData(String denTemplateData) {
        this.denTemplateData = denTemplateData;
    }

    public String getDenAircraftGround() {
        return denAircraftGround;
    }

    public void setDenAircraftGround(String denAircraftGround) {
        this.denAircraftGround = denAircraftGround;
    }

    public String getDenCritical() {
        return denCritical;
    }

    public void setDenCritical(String denCritical) {
        this.denCritical = denCritical;
    }

    public EngDamageType getDatId() {
        return datId;
    }

    public void setDatId(EngDamageType datId) {
        this.datId = datId;
    }

    public EngRequest getReqMessageid() {
        return reqMessageid;
    }

    public void setReqMessageid(EngRequest reqMessageid) {
        this.reqMessageid = reqMessageid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (denId != null ? denId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EngDent)) {
            return false;
        }
        EngDent other = (EngDent) object;
        if ((this.denId == null && other.denId != null) || (this.denId != null && !this.denId.equals(other.denId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngDent[ denId=" + denId + " ]";
    }
    
}
