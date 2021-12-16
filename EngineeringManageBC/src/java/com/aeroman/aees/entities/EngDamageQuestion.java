/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author vjuarez
 */
@Entity
@Cacheable(false)
@Table(name = "ENG_DAMAGE_QUESTION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngDamageQuestion.findAll", query = "SELECT e FROM EngDamageQuestion e"),
    @NamedQuery(name = "EngDamageQuestion.findByDxqId", query = "SELECT e FROM EngDamageQuestion e WHERE e.dxqId = :dxqId"),
    @NamedQuery(name = "EngDamageQuestion.findByDxqUserIns", query = "SELECT e FROM EngDamageQuestion e WHERE e.dxqUserIns = :dxqUserIns"),
    @NamedQuery(name = "EngDamageQuestion.findByDxqDateIns", query = "SELECT e FROM EngDamageQuestion e WHERE e.dxqDateIns = :dxqDateIns"),
    @NamedQuery(name = "EngDamageQuestion.findByDxqUserUpd", query = "SELECT e FROM EngDamageQuestion e WHERE e.dxqUserUpd = :dxqUserUpd"),
    @NamedQuery(name = "EngDamageQuestion.findByDxqDateUpd", query = "SELECT e FROM EngDamageQuestion e WHERE e.dxqDateUpd = :dxqDateUpd")})
public class EngDamageQuestion implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dxqId")
    private Collection<EngRequestQuestionIni> engRequestQuestionIniCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dxqId")
    private Collection<EngRequestQuestion> engRequestQuestionCollection;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENG_DAMAGE_QUESTION_SEQ")
    @SequenceGenerator(name = "ENG_DAMAGE_QUESTION_SEQ", sequenceName = "ENG_DAMAGE_QUESTION_SEQ", allocationSize = 1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "DXQ_ID")
    private BigDecimal dxqId;
    @Size(max = 50)
    @Column(name = "DXQ_USER_INS")
    private String dxqUserIns;
    @Column(name = "DXQ_DATE_INS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dxqDateIns;
    @Size(max = 50)
    @Column(name = "DXQ_USER_UPD")
    private String dxqUserUpd;
    @Column(name = "DXQ_DATE_UPD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dxqDateUpd;
    @JoinColumn(name = "DAT_ID", referencedColumnName = "DAT_ID")
    @ManyToOne(optional = false)
    private EngDamageType datId;
    @JoinColumn(name = "QUE_ID", referencedColumnName = "QUE_ID")
    @ManyToOne(optional = false)
    private EngQuestion queId;
    @JoinColumn(name = "ARCTYP_ID", referencedColumnName = "ARCTYP_ID")
    @ManyToOne(optional = false)
    private CoreAircraftType arctypId;
    @Transient
    private String response;

    public EngDamageQuestion() {
    }

    public EngDamageQuestion(BigDecimal dxqId) {
        this.dxqId = dxqId;
    }

    public BigDecimal getDxqId() {
        return dxqId;
    }

    public void setDxqId(BigDecimal dxqId) {
        this.dxqId = dxqId;
    }

    public String getDxqUserIns() {
        return dxqUserIns;
    }

    public void setDxqUserIns(String dxqUserIns) {
        this.dxqUserIns = dxqUserIns;
    }

    public Date getDxqDateIns() {
        return dxqDateIns;
    }

    public void setDxqDateIns(Date dxqDateIns) {
        this.dxqDateIns = dxqDateIns;
    }

    public String getDxqUserUpd() {
        return dxqUserUpd;
    }

    public void setDxqUserUpd(String dxqUserUpd) {
        this.dxqUserUpd = dxqUserUpd;
    }

    public Date getDxqDateUpd() {
        return dxqDateUpd;
    }

    public void setDxqDateUpd(Date dxqDateUpd) {
        this.dxqDateUpd = dxqDateUpd;
    }

    public EngDamageType getDatId() {
        return datId;
    }

    public void setDatId(EngDamageType datId) {
        this.datId = datId;
    }

    public EngQuestion getQueId() {
        return queId;
    }

    public void setQueId(EngQuestion queId) {
        this.queId = queId;
    }

    public CoreAircraftType getArctypId() {
        return arctypId;
    }

    public void setArctypId(CoreAircraftType arctypId) {
        this.arctypId = arctypId;
    }
    

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dxqId != null ? dxqId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EngDamageQuestion)) {
            return false;
        }
        EngDamageQuestion other = (EngDamageQuestion) object;
        if ((this.dxqId == null && other.dxqId != null) || (this.dxqId != null && !this.dxqId.equals(other.dxqId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngDamageQuestion[ dxqId=" + dxqId + " ]";
    }

    @XmlTransient
    public Collection<EngRequestQuestion> getEngRequestQuestionCollection() {
        return engRequestQuestionCollection;
    }

    public void setEngRequestQuestionCollection(Collection<EngRequestQuestion> engRequestQuestionCollection) {
        this.engRequestQuestionCollection = engRequestQuestionCollection;
    }

    @XmlTransient
    public Collection<EngRequestQuestionIni> getEngRequestQuestionIniCollection() {
        return engRequestQuestionIniCollection;
    }

    public void setEngRequestQuestionIniCollection(Collection<EngRequestQuestionIni> engRequestQuestionIniCollection) {
        this.engRequestQuestionIniCollection = engRequestQuestionIniCollection;
    }

    }
