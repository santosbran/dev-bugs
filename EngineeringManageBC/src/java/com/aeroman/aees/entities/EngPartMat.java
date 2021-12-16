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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pc
 */
@Entity
@Cacheable(false)
@Table(name = "ENG_PART_MAT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngPartMat.findAll", query = "SELECT e FROM EngPartMat e"),
    @NamedQuery(name = "EngPartMat.findByPmtId", query = "SELECT e FROM EngPartMat e WHERE e.pmtId = :pmtId"),
    @NamedQuery(name = "EngPartMat.findByEoIdord", query = "SELECT e FROM EngPartMat e WHERE e.eoIdord = :eoIdord"),
    @NamedQuery(name = "EngPartMat.findByPmtPo", query = "SELECT e FROM EngPartMat e WHERE e.pmtPo = :pmtPo"),
    @NamedQuery(name = "EngPartMat.findByPmtNumpat", query = "SELECT e FROM EngPartMat e WHERE e.pmtNumpat = :pmtNumpat"),
    @NamedQuery(name = "EngPartMat.findByPmtQuantity", query = "SELECT e FROM EngPartMat e WHERE e.pmtQuantity = :pmtQuantity"),
    @NamedQuery(name = "EngPartMat.findByPmtUnits", query = "SELECT e FROM EngPartMat e WHERE e.pmtUnits = :pmtUnits"),
    @NamedQuery(name = "EngPartMat.findByPmtComments", query = "SELECT e FROM EngPartMat e WHERE e.pmtComments = :pmtComments"),
    @NamedQuery(name = "EngPartMat.findByPmtType", query = "SELECT e FROM EngPartMat e WHERE e.pmtType = :pmtType"),
    @NamedQuery(name = "EngPartMat.findByPmtDescription", query = "SELECT e FROM EngPartMat e WHERE e.pmtDescription = :pmtDescription"),
    @NamedQuery(name = "EngPartMat.findByPmtUserIns", query = "SELECT e FROM EngPartMat e WHERE e.pmtUserIns = :pmtUserIns"),
    @NamedQuery(name = "EngPartMat.findByPmtDateIns", query = "SELECT e FROM EngPartMat e WHERE e.pmtDateIns = :pmtDateIns"),
    @NamedQuery(name = "EngPartMat.findByPmtUserUpd", query = "SELECT e FROM EngPartMat e WHERE e.pmtUserUpd = :pmtUserUpd"),
    @NamedQuery(name = "EngPartMat.findByPmtDateUpd", query = "SELECT e FROM EngPartMat e WHERE e.pmtDateUpd = :pmtDateUpd")})
public class EngPartMat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PMT_ID")
    private Integer pmtId;
    @JoinColumn(name = "EO_IDORD", referencedColumnName = "EO_IDORD")
    @ManyToOne(optional = false)
    private EngOrders eoIdord;
    @Size(max = 15)
    @Column(name = "PMT_PO")
    private String pmtPo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PMT_NUMPAT")
    private String pmtNumpat;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "PMT_QUANTITY")
    private BigDecimal pmtQuantity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PMT_UNITS")
    private short pmtUnits;
    @Size(max = 1000)
    @Column(name = "PMT_COMMENTS")
    private String pmtComments;
    @Size(max = 1)
    @Column(name = "PMT_TYPE")
    private String pmtType;
    @Size(max = 200)
    @Column(name = "PMT_DESCRIPTION")
    private String pmtDescription;
    @Size(max = 30)
    @Column(name = "PMT_USER_INS")
    private String pmtUserIns;
    @Column(name = "PMT_DATE_INS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pmtDateIns;
    @Size(max = 30)
    @Column(name = "PMT_USER_UPD")
    private String pmtUserUpd;
    @Column(name = "PMT_DATE_UPD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pmtDateUpd;

    public EngPartMat() {
        super();
    }

    public EngPartMat(Integer pmtId) {
        this.pmtId = pmtId;
    }

    public EngPartMat(Integer pmtId, EngOrders eoIdord, String pmtNumpat, BigDecimal pmtQuantity, short pmtUnits) {
        this.pmtId = pmtId;
        this.eoIdord = eoIdord;
        this.pmtNumpat = pmtNumpat;
        this.pmtQuantity = pmtQuantity;
        this.pmtUnits = pmtUnits;
    }

    public Integer getPmtId() {
        return pmtId;
    }

    public void setPmtId(Integer pmtId) {
        this.pmtId = pmtId;
    }

    public EngOrders getEoIdord() {
        return eoIdord;
    }

    public void setEoIdord(EngOrders eoIdord) {
        this.eoIdord = eoIdord;
    }

    public String getPmtPo() {
        return pmtPo;
    }

    public void setPmtPo(String pmtPo) {
        this.pmtPo = pmtPo;
    }

    public String getPmtNumpat() {
        return pmtNumpat;
    }

    public void setPmtNumpat(String pmtNumpat) {
        this.pmtNumpat = pmtNumpat;
    }

    public BigDecimal getPmtQuantity() {
        return pmtQuantity;
    }

    public void setPmtQuantity(BigDecimal pmtQuantity) {
        this.pmtQuantity = pmtQuantity;
    }

    public short getPmtUnits() {
        return pmtUnits;
    }

    public void setPmtUnits(short pmtUnits) {
        this.pmtUnits = pmtUnits;
    }

    public String getPmtComments() {
        return pmtComments;
    }

    public void setPmtComments(String pmtComments) {
        this.pmtComments = pmtComments;
    }

    public String getPmtType() {
        return pmtType;
    }

    public void setPmtType(String pmtType) {
        this.pmtType = pmtType;
    }

    public String getPmtDescription() {
        return pmtDescription;
    }

    public void setPmtDescription(String pmtDescription) {
        this.pmtDescription = pmtDescription;
    }

    public String getPmtUserIns() {
        return pmtUserIns;
    }

    public void setPmtUserIns(String pmtUserIns) {
        this.pmtUserIns = pmtUserIns;
    }

    public Date getPmtDateIns() {
        return pmtDateIns;
    }

    public void setPmtDateIns(Date pmtDateIns) {
        this.pmtDateIns = pmtDateIns;
    }

    public String getPmtUserUpd() {
        return pmtUserUpd;
    }

    public void setPmtUserUpd(String pmtUserUpd) {
        this.pmtUserUpd = pmtUserUpd;
    }

    public Date getPmtDateUpd() {
        return pmtDateUpd;
    }

    public void setPmtDateUpd(Date pmtDateUpd) {
        this.pmtDateUpd = pmtDateUpd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pmtId != null ? pmtId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EngPartMat)) {
            return false;
        }
        EngPartMat other = (EngPartMat) object;
        if ((this.pmtId == null && other.pmtId != null) || (this.pmtId != null && !this.pmtId.equals(other.pmtId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngPartMat[ pmtId=" + pmtId + " ]";
    }
    
}
