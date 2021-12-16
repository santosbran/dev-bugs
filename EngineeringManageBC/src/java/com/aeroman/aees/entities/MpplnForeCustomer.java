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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "MPPLN_FORE_CUSTOMER",catalog = "", schema = "MPPLN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MpplnForeCustomer.findAll", query = "SELECT m FROM MpplnForeCustomer m")
    , @NamedQuery(name = "MpplnForeCustomer.findByCstId", query = "SELECT m FROM MpplnForeCustomer m WHERE m.cstId = :cstId")
    , @NamedQuery(name = "MpplnForeCustomer.findByCstCode", query = "SELECT m FROM MpplnForeCustomer m WHERE m.cstCode = :cstCode")
    , @NamedQuery(name = "MpplnForeCustomer.findByCstName", query = "SELECT m FROM MpplnForeCustomer m WHERE m.cstName = :cstName")
    , @NamedQuery(name = "MpplnForeCustomer.findByCstInsertedBy", query = "SELECT m FROM MpplnForeCustomer m WHERE m.cstInsertedBy = :cstInsertedBy")
    , @NamedQuery(name = "MpplnForeCustomer.findByCstInsertDate", query = "SELECT m FROM MpplnForeCustomer m WHERE m.cstInsertDate = :cstInsertDate")
    , @NamedQuery(name = "MpplnForeCustomer.findByCstUpdatedBy", query = "SELECT m FROM MpplnForeCustomer m WHERE m.cstUpdatedBy = :cstUpdatedBy")
    , @NamedQuery(name = "MpplnForeCustomer.findByCstUpdateDate", query = "SELECT m FROM MpplnForeCustomer m WHERE m.cstUpdateDate = :cstUpdateDate")
    , @NamedQuery(name = "MpplnForeCustomer.findByCstColor", query = "SELECT m FROM MpplnForeCustomer m WHERE m.cstColor = :cstColor")
    , @NamedQuery(name = "MpplnForeCustomer.findByCstIataCode", query = "SELECT m FROM MpplnForeCustomer m WHERE m.cstIataCode = :cstIataCode")
    , @NamedQuery(name = "MpplnForeCustomer.findByCstRealFore", query = "SELECT m FROM MpplnForeCustomer m WHERE m.cstRealFore = :cstRealFore")})
public class MpplnForeCustomer implements Serializable {

    @OneToMany(mappedBy = "cstId")
    private Collection<EngMergeCustomer> engMergeCustomerCollection;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CST_ID")
    private BigDecimal cstId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "CST_CODE")
    private String cstCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "CST_NAME")
    private String cstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CST_INSERTED_BY")
    private String cstInsertedBy;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CST_INSERT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cstInsertDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CST_UPDATED_BY")
    private String cstUpdatedBy;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CST_UPDATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cstUpdateDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CST_COLOR")
    private String cstColor;
    @Size(max = 10)
    @Column(name = "CST_IATA_CODE")
    private String cstIataCode;
    @Size(max = 1)
    @Column(name = "CST_REAL_FORE")
    private String cstRealFore;

    public MpplnForeCustomer() {
        super();
    }

    public MpplnForeCustomer(BigDecimal cstId) {
        this.cstId = cstId;
    }

    public MpplnForeCustomer(BigDecimal cstId, String cstCode, String cstName, String cstInsertedBy, Date cstInsertDate, String cstUpdatedBy, Date cstUpdateDate, String cstColor) {
        this.cstId = cstId;
        this.cstCode = cstCode;
        this.cstName = cstName;
        this.cstInsertedBy = cstInsertedBy;
        this.cstInsertDate = cstInsertDate;
        this.cstUpdatedBy = cstUpdatedBy;
        this.cstUpdateDate = cstUpdateDate;
        this.cstColor = cstColor;
    }

    public BigDecimal getCstId() {
        return cstId;
    }

    public void setCstId(BigDecimal cstId) {
        this.cstId = cstId;
    }

    public String getCstCode() {
        return cstCode;
    }

    public void setCstCode(String cstCode) {
        this.cstCode = cstCode;
    }

    public String getCstName() {
        return cstName;
    }

    public void setCstName(String cstName) {
        this.cstName = cstName;
    }

    public String getCstInsertedBy() {
        return cstInsertedBy;
    }

    public void setCstInsertedBy(String cstInsertedBy) {
        this.cstInsertedBy = cstInsertedBy;
    }

    public Date getCstInsertDate() {
        return cstInsertDate;
    }

    public void setCstInsertDate(Date cstInsertDate) {
        this.cstInsertDate = cstInsertDate;
    }

    public String getCstUpdatedBy() {
        return cstUpdatedBy;
    }

    public void setCstUpdatedBy(String cstUpdatedBy) {
        this.cstUpdatedBy = cstUpdatedBy;
    }

    public Date getCstUpdateDate() {
        return cstUpdateDate;
    }

    public void setCstUpdateDate(Date cstUpdateDate) {
        this.cstUpdateDate = cstUpdateDate;
    }

    public String getCstColor() {
        return cstColor;
    }

    public void setCstColor(String cstColor) {
        this.cstColor = cstColor;
    }

    public String getCstIataCode() {
        return cstIataCode;
    }

    public void setCstIataCode(String cstIataCode) {
        this.cstIataCode = cstIataCode;
    }

    public String getCstRealFore() {
        return cstRealFore;
    }

    public void setCstRealFore(String cstRealFore) {
        this.cstRealFore = cstRealFore;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cstId != null ? cstId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MpplnForeCustomer)) {
            return false;
        }
        MpplnForeCustomer other = (MpplnForeCustomer) object;
        if ((this.cstId == null && other.cstId != null) || (this.cstId != null && !this.cstId.equals(other.cstId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.MpplnForeCustomer[ cstId=" + cstId + " ]";
    }
    @XmlTransient
    public Collection<EngMergeCustomer> getEngMergeCustomerCollection() {
        return engMergeCustomerCollection;
    }

    public void setEngMergeCustomerCollection(Collection<EngMergeCustomer> engMergeCustomerCollection) {
        this.engMergeCustomerCollection = engMergeCustomerCollection;
    }
    
}
