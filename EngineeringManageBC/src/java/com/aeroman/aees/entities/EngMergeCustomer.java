/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities;

import com.aeroman.aees.entities.grant.SgrCia;
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
@Table(name = "ENG_MERGE_CUSTOMER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngMergeCustomer.findAll", query = "SELECT e FROM EngMergeCustomer e")
    , @NamedQuery(name = "EngMergeCustomer.findByEmcId", query = "SELECT e FROM EngMergeCustomer e WHERE e.emcId = :emcId")
    , @NamedQuery(name = "EngMergeCustomer.findByCstId", query = "SELECT e FROM EngMergeCustomer e WHERE e.cstId = :cstId")
    , @NamedQuery(name = "EngMergeCustomer.findByCiaCode", query = "SELECT e FROM EngMergeCustomer e WHERE e.ciaCode = :ciaCode")
    , @NamedQuery(name = "EngMergeCustomer.findByEmcUserAdd", query = "SELECT e FROM EngMergeCustomer e WHERE e.emcUserAdd = :emcUserAdd")
    , @NamedQuery(name = "EngMergeCustomer.findByEmcDateAdd", query = "SELECT e FROM EngMergeCustomer e WHERE e.emcDateAdd = :emcDateAdd")
    , @NamedQuery(name = "EngMergeCustomer.findByEmcUserUpd", query = "SELECT e FROM EngMergeCustomer e WHERE e.emcUserUpd = :emcUserUpd")
    , @NamedQuery(name = "EngMergeCustomer.findByEmcDateUpd", query = "SELECT e FROM EngMergeCustomer e WHERE e.emcDateUpd = :emcDateUpd")})
public class EngMergeCustomer implements Serializable {
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "defCustomer")
    private Collection<ContDefaultMail> contDefaultMailCollection;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENG_MERGE_CUSTOMER_SEQ")
    @SequenceGenerator(name = "ENG_MERGE_CUSTOMER_SEQ", sequenceName = "ENG_MERGE_CUSTOMER_SEQ", allocationSize = 1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "EMC_ID")
    private BigDecimal emcId;  
    @Size(max = 50)
    @Column(name = "EMC_USER_ADD")
    private String emcUserAdd;
    @Column(name = "EMC_DATE_ADD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date emcDateAdd;
    @Size(max = 50)
    @Column(name = "EMC_USER_UPD")
    private String emcUserUpd;
    @Column(name = "EMC_DATE_UPD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date emcDateUpd;
    @JoinColumn(name = "ENG_ID", referencedColumnName = "ENG_ID")
    @ManyToOne
    private EngCustomer engId;
    @JoinColumn(name = "CST_ID", referencedColumnName = "CST_ID")
    @ManyToOne
    private MpplnForeCustomer cstId;
    @JoinColumn(name = "CIA_CODE", referencedColumnName = "CIA_CODE")
    @ManyToOne
    private SgrCia ciaCode;
    @Size(max = 5)
    @Column(name = "EMC_MERGE")
    private String emcMerge;
    

    public EngMergeCustomer() {
        super();
    }

    public EngMergeCustomer(BigDecimal emcId) {
        this.emcId = emcId;
    }

    public BigDecimal getEmcId() {
        return emcId;
    }

    public void setEmcId(BigDecimal emcId) {
        this.emcId = emcId;
    }

    public MpplnForeCustomer getCstId() {
        return cstId;
    }

    public void setCstId(MpplnForeCustomer cstId) {
        this.cstId = cstId;
    }

    public SgrCia getCiaCode() {
        return ciaCode;
    }

    public void setCiaCode(SgrCia ciaCode) {
        this.ciaCode = ciaCode;
    }

    public String getEmcUserAdd() {
        return emcUserAdd;
    }

    public void setEmcUserAdd(String emcUserAdd) {
        this.emcUserAdd = emcUserAdd;
    }

    public Date getEmcDateAdd() {
        return emcDateAdd;
    }

    public void setEmcDateAdd(Date emcDateAdd) {
        this.emcDateAdd = emcDateAdd;
    }

    public String getEmcUserUpd() {
        return emcUserUpd;
    }

    public void setEmcUserUpd(String emcUserUpd) {
        this.emcUserUpd = emcUserUpd;
    }

    public Date getEmcDateUpd() {
        return emcDateUpd;
    }

    public void setEmcDateUpd(Date emcDateUpd) {
        this.emcDateUpd = emcDateUpd;
    }

    public EngCustomer getEngId() {
        return engId;
    }

    public void setEngId(EngCustomer engId) {
        this.engId = engId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emcId != null ? emcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EngMergeCustomer)) {
            return false;
        }
        EngMergeCustomer other = (EngMergeCustomer) object;
        if ((this.emcId == null && other.emcId != null) || (this.emcId != null && !this.emcId.equals(other.emcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngMergeCustomer[ emcId=" + emcId + " ]";
    }

    public String getEmcMerge() {
        return emcMerge;
    }

    public void setEmcMerge(String emcMerge) {
        this.emcMerge = emcMerge;
    }
    @XmlTransient
    public Collection<ContDefaultMail> getEngMergeCustomerCollection() {
        return contDefaultMailCollection;
    }

    public void setEngMergeCustomerCollection(Collection<ContDefaultMail> contDefaultMailCollection) {
        this.contDefaultMailCollection = contDefaultMailCollection;
    }
    
}
