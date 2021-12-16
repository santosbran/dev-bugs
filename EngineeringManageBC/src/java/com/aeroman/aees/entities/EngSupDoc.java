/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities;

import java.io.Serializable;
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
@Table(name = "ENG_SUP_DOC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngSupDoc.findAll", query = "SELECT e FROM EngSupDoc e"),
    @NamedQuery(name = "EngSupDoc.findBySdoId", query = "SELECT e FROM EngSupDoc e WHERE e.sdoId = :sdoId"),
    @NamedQuery(name = "EngSupDoc.findBySdoDocNumber", query = "SELECT e FROM EngSupDoc e WHERE e.sdoDocNumber = :sdoDocNumber"),
    @NamedQuery(name = "EngSupDoc.findBySdoType", query = "SELECT e FROM EngSupDoc e WHERE e.sdoType = :sdoType"),
    @NamedQuery(name = "EngSupDoc.findBySdoSubject", query = "SELECT e FROM EngSupDoc e WHERE e.sdoSubject = :sdoSubject"),
    @NamedQuery(name = "EngSupDoc.findByEoIdord", query = "SELECT e FROM EngSupDoc e WHERE e.eoIdord = :eoIdord"),
    @NamedQuery(name = "EngSupDoc.findBySdoUserIns", query = "SELECT e FROM EngSupDoc e WHERE e.sdoUserIns = :sdoUserIns"),
    @NamedQuery(name = "EngSupDoc.findBySdoDateIns", query = "SELECT e FROM EngSupDoc e WHERE e.sdoDateIns = :sdoDateIns"),
    @NamedQuery(name = "EngSupDoc.findBySdoUserUpd", query = "SELECT e FROM EngSupDoc e WHERE e.sdoUserUpd = :sdoUserUpd"),
    @NamedQuery(name = "EngSupDoc.findBySdoDateUpd", query = "SELECT e FROM EngSupDoc e WHERE e.sdoDateUpd = :sdoDateUpd")})
public class EngSupDoc implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SDO_ID")
    private Integer sdoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "SDO_DOC_NUMBER")
    private String sdoDocNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "SDO_TYPE")
    private String sdoType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "SDO_SUBJECT")
    private String sdoSubject;
    @JoinColumn(name = "EO_IDORD", referencedColumnName = "EO_IDORD")
    @ManyToOne(optional = false)
    //@Column(name = "EO_IDORD")
    private EngOrders eoIdord;
    @Size(max = 30)
    @Column(name = "SDO_USER_INS")
    private String sdoUserIns;
    @Column(name = "SDO_DATE_INS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sdoDateIns;
    @Size(max = 30)
    @Column(name = "SDO_USER_UPD")
    private String sdoUserUpd;
    @Column(name = "SDO_DATE_UPD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sdoDateUpd;

    public EngSupDoc() {
        super();
                
    }

    public EngSupDoc(Integer sdoId) {
        this.sdoId = sdoId;
    }

    public EngSupDoc(Integer sdoId, String sdoDocNumber, String sdoType, String sdoSubject, EngOrders eoIdord) {
        this.sdoId = sdoId;
        this.sdoDocNumber = sdoDocNumber;
        this.sdoType = sdoType;
        this.sdoSubject = sdoSubject;
        this.eoIdord = eoIdord;
    }

    public Integer getSdoId() {
        return sdoId;
    }

    public void setSdoId(Integer sdoId) {
        this.sdoId = sdoId;
    }

    public String getSdoDocNumber() {
        return sdoDocNumber;
    }

    public void setSdoDocNumber(String sdoDocNumber) {
        this.sdoDocNumber = sdoDocNumber;
    }

    public String getSdoType() {
        return sdoType;
    }

    public void setSdoType(String sdoType) {
        this.sdoType = sdoType;
    }

    public String getSdoSubject() {
        return sdoSubject;
    }

    public void setSdoSubject(String sdoSubject) {
        this.sdoSubject = sdoSubject;
    }

    public EngOrders getEoIdord() {
        return eoIdord;
    }

    public void setEoIdord(EngOrders eoIdord) {
        this.eoIdord = eoIdord;
    }

    public String getSdoUserIns() {
        return sdoUserIns;
    }

    public void setSdoUserIns(String sdoUserIns) {
        this.sdoUserIns = sdoUserIns;
    }

    public Date getSdoDateIns() {
        return sdoDateIns;
    }

    public void setSdoDateIns(Date sdoDateIns) {
        this.sdoDateIns = sdoDateIns;
    }

    public String getSdoUserUpd() {
        return sdoUserUpd;
    }

    public void setSdoUserUpd(String sdoUserUpd) {
        this.sdoUserUpd = sdoUserUpd;
    }

    public Date getSdoDateUpd() {
        return sdoDateUpd;
    }

    public void setSdoDateUpd(Date sdoDateUpd) {
        this.sdoDateUpd = sdoDateUpd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sdoId != null ? sdoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EngSupDoc)) {
            return false;
        }
        EngSupDoc other = (EngSupDoc) object;
        if ((this.sdoId == null && other.sdoId != null) || (this.sdoId != null && !this.sdoId.equals(other.sdoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngSupDoc[ sdoId=" + sdoId + " ]";
    }
    
}
