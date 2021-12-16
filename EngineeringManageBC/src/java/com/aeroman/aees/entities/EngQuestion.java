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
 * @author vjuarez
 */
@Entity
@Cacheable(false)
@Table(name = "ENG_QUESTION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngQuestion.findAll", query = "SELECT e FROM EngQuestion e"),
    @NamedQuery(name = "EngQuestion.findByQueId", query = "SELECT e FROM EngQuestion e WHERE e.queId = :queId"),
    @NamedQuery(name = "EngQuestion.findByQueName", query = "SELECT e FROM EngQuestion e WHERE e.queName = :queName"),
    @NamedQuery(name = "EngQuestion.findByQueDescription", query = "SELECT e FROM EngQuestion e WHERE e.queDescription = :queDescription"),
    @NamedQuery(name = "EngQuestion.findByQueUserIns", query = "SELECT e FROM EngQuestion e WHERE e.queUserIns = :queUserIns"),
    @NamedQuery(name = "EngQuestion.findByQueDateIns", query = "SELECT e FROM EngQuestion e WHERE e.queDateIns = :queDateIns"),
    @NamedQuery(name = "EngQuestion.findByQueUserUpd", query = "SELECT e FROM EngQuestion e WHERE e.queUserUpd = :queUserUpd"),
    @NamedQuery(name = "EngQuestion.findByQueDateUpd", query = "SELECT e FROM EngQuestion e WHERE e.queDateUpd = :queDateUpd")})
public class EngQuestion implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "queId")
    private Collection<EngDamageQuestion> engDamageQuestionCollection;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
     @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENG_QUESTION_SEQ")
    @SequenceGenerator(name = "ENG_QUESTION_SEQ", sequenceName = "ENG_QUESTION_SEQ", allocationSize = 1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUE_ID")
    private BigDecimal queId;
    @Size(max = 500)
    @Column(name = "QUE_NAME")
    private String queName;
    @Size(max = 500)
    @Column(name = "QUE_DESCRIPTION")
    private String queDescription;
    @Size(max = 50)
    @Column(name = "QUE_USER_INS")
    private String queUserIns;
    @Column(name = "QUE_DATE_INS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date queDateIns;
    @Size(max = 50)
    @Column(name = "QUE_USER_UPD")
    private String queUserUpd;
    @Column(name = "QUE_DATE_UPD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date queDateUpd;

    public EngQuestion() {
    }

    public EngQuestion(BigDecimal queId) {
        this.queId = queId;
    }

    public BigDecimal getQueId() {
        return queId;
    }

    public void setQueId(BigDecimal queId) {
        this.queId = queId;
    }

    public String getQueName() {
        return queName;
    }

    public void setQueName(String queName) {
        this.queName = queName;
    }

    public String getQueDescription() {
        return queDescription;
    }

    public void setQueDescription(String queDescription) {
        this.queDescription = queDescription;
    }

    public String getQueUserIns() {
        return queUserIns;
    }

    public void setQueUserIns(String queUserIns) {
        this.queUserIns = queUserIns;
    }

    public Date getQueDateIns() {
        return queDateIns;
    }

    public void setQueDateIns(Date queDateIns) {
        this.queDateIns = queDateIns;
    }

    public String getQueUserUpd() {
        return queUserUpd;
    }

    public void setQueUserUpd(String queUserUpd) {
        this.queUserUpd = queUserUpd;
    }

    public Date getQueDateUpd() {
        return queDateUpd;
    }

    public void setQueDateUpd(Date queDateUpd) {
        this.queDateUpd = queDateUpd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (queId != null ? queId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EngQuestion)) {
            return false;
        }
        EngQuestion other = (EngQuestion) object;
        if ((this.queId == null && other.queId != null) || (this.queId != null && !this.queId.equals(other.queId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngQuestion[ queId=" + queId + " ]";
    }

    @XmlTransient
    public Collection<EngDamageQuestion> getEngDamageQuestionCollection() {
        return engDamageQuestionCollection;
    }

    public void setEngDamageQuestionCollection(Collection<EngDamageQuestion> engDamageQuestionCollection) {
        this.engDamageQuestionCollection = engDamageQuestionCollection;
    }
    
}
