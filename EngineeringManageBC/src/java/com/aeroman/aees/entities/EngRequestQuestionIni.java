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
@Table(name = "ENG_REQUEST_QUESTION_INI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngRequestQuestionIni.findAll", query = "SELECT e FROM EngRequestQuestionIni e"),
    @NamedQuery(name = "EngRequestQuestionIni.findByReqId", query = "SELECT e FROM EngRequestQuestionIni e WHERE e.reqId = :reqId"),
    @NamedQuery(name = "EngRequestQuestionIni.findByReqValue", query = "SELECT e FROM EngRequestQuestionIni e WHERE e.reqValue = :reqValue"),
    @NamedQuery(name = "EngRequestQuestionIni.findByReqUserIns", query = "SELECT e FROM EngRequestQuestionIni e WHERE e.reqUserIns = :reqUserIns"),
    @NamedQuery(name = "EngRequestQuestionIni.findByReqDateIns", query = "SELECT e FROM EngRequestQuestionIni e WHERE e.reqDateIns = :reqDateIns"),
    @NamedQuery(name = "EngRequestQuestionIni.findByReqUserUpd", query = "SELECT e FROM EngRequestQuestionIni e WHERE e.reqUserUpd = :reqUserUpd"),
    @NamedQuery(name = "EngRequestQuestionIni.findByReqDateUpd", query = "SELECT e FROM EngRequestQuestionIni e WHERE e.reqDateUpd = :reqDateUpd")})
public class EngRequestQuestionIni implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENG_QUESTION_INI_SEQ")
    @SequenceGenerator(name = "ENG_QUESTION_INI_SEQ", sequenceName = "ENG_QUESTION_INI_SEQ", allocationSize = 1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "REQ_ID")
    private BigDecimal reqId;
    @Size(max = 500)
    @Column(name = "REQ_VALUE")
    private String reqValue;
    @Size(max = 9)
    @Column(name = "REQ_USER_INS")
    private String reqUserIns;
    @Column(name = "REQ_DATE_INS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reqDateIns;
    @Size(max = 9)
    @Column(name = "REQ_USER_UPD")
    private String reqUserUpd;
    @Column(name = "REQ_DATE_UPD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reqDateUpd;
    @JoinColumn(name = "DXQ_ID", referencedColumnName = "DXQ_ID")
    @ManyToOne(optional = false)
    private EngDamageQuestion dxqId;
    @JoinColumn(name = "REQ_MESSAGEID", referencedColumnName = "REQ_MESSAGEID")
    @ManyToOne(optional = false)
    private EngRequest reqMessageid;

    public EngRequestQuestionIni() {
        super();
    }

    public EngRequestQuestionIni(BigDecimal reqId) {
        this.reqId = reqId;
    }

    public BigDecimal getReqId() {
        return reqId;
    }

    public void setReqId(BigDecimal reqId) {
        this.reqId = reqId;
    }

    public String getReqValue() {
        return reqValue;
    }

    public void setReqValue(String reqValue) {
        this.reqValue = reqValue;
    }

    public String getReqUserIns() {
        return reqUserIns;
    }

    public void setReqUserIns(String reqUserIns) {
        this.reqUserIns = reqUserIns;
    }

    public Date getReqDateIns() {
        return reqDateIns;
    }

    public void setReqDateIns(Date reqDateIns) {
        this.reqDateIns = reqDateIns;
    }

    public String getReqUserUpd() {
        return reqUserUpd;
    }

    public void setReqUserUpd(String reqUserUpd) {
        this.reqUserUpd = reqUserUpd;
    }

    public Date getReqDateUpd() {
        return reqDateUpd;
    }

    public void setReqDateUpd(Date reqDateUpd) {
        this.reqDateUpd = reqDateUpd;
    }

    public EngDamageQuestion getDxqId() {
        return dxqId;
    }

    public void setDxqId(EngDamageQuestion dxqId) {
        this.dxqId = dxqId;
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
        hash += (reqId != null ? reqId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EngRequestQuestionIni)) {
            return false;
        }
        EngRequestQuestionIni other = (EngRequestQuestionIni) object;
        if ((this.reqId == null && other.reqId != null) || (this.reqId != null && !this.reqId.equals(other.reqId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngRequestQuestionIni[ reqId=" + reqId + " ]";
    }
    
}
