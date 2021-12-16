/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "ENG_EO_REF")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngEoRef.findAll", query = "SELECT e FROM EngEoRef e"),
    @NamedQuery(name = "EngEoRef.findByRefCompliance", query = "SELECT e FROM EngEoRef e WHERE e.refCompliance = :refCompliance"),
    @NamedQuery(name = "EngEoRef.findByRefComments", query = "SELECT e FROM EngEoRef e WHERE e.refComments = :refComments"),
    @NamedQuery(name = "EngEoRef.findByCodId", query = "SELECT e FROM EngEoRef e WHERE e.engEoRefPK.codId = :codId"),
    @NamedQuery(name = "EngEoRef.findBySecNum", query = "SELECT e FROM EngEoRef e WHERE e.engEoRefPK.secNum = :secNum"),
    @NamedQuery(name = "EngEoRef.findByEoIdord", query = "SELECT e FROM EngEoRef e WHERE e.engEoRefPK.eoIdord = :eoIdord"),
    @NamedQuery(name = "EngEoRef.findByRefReford", query = "SELECT e FROM EngEoRef e WHERE e.refReford = :refReford"),
    @NamedQuery(name = "EngEoRef.findByRefUserIns", query = "SELECT e FROM EngEoRef e WHERE e.refUserIns = :refUserIns"),
    @NamedQuery(name = "EngEoRef.findByRefFechaIns", query = "SELECT e FROM EngEoRef e WHERE e.refFechaIns = :refFechaIns"),
    @NamedQuery(name = "EngEoRef.findByRefUserUpd", query = "SELECT e FROM EngEoRef e WHERE e.refUserUpd = :refUserUpd"),
    @NamedQuery(name = "EngEoRef.findByRefDateUpd", query = "SELECT e FROM EngEoRef e WHERE e.refDateUpd = :refDateUpd")})
public class EngEoRef implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EngEoRefPK engEoRefPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "REF_COMPLIANCE")
    private String refCompliance;
    @Size(max = 2000)
    @Column(name = "REF_COMMENTS")
    private String refComments;
    @Column(name = "REF_REFORD")
    private BigInteger refReford;
    @Size(max = 30)
    @Column(name = "REF_USER_INS")
    private String refUserIns;
    @Column(name = "REF_FECHA_INS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date refFechaIns;
    @Size(max = 30)
    @Column(name = "REF_USER_UPD")
    private String refUserUpd;
    @Column(name = "REF_DATE_UPD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date refDateUpd;

    public EngEoRef() {
        super();
    }

    public EngEoRef(EngEoRefPK engEoRefPK) {
        this.engEoRefPK = engEoRefPK;
    }

    public EngEoRef(EngEoRefPK engEoRefPK, String refCompliance) {
        this.engEoRefPK = engEoRefPK;
        this.refCompliance = refCompliance;
    }

    public EngEoRef(String codId, short secNum, long eoIdord) {
        this.engEoRefPK = new EngEoRefPK(codId, secNum, eoIdord);
    }

    public EngEoRefPK getEngEoRefPK() {
        return engEoRefPK;
    }

    public void setEngEoRefPK(EngEoRefPK engEoRefPK) {
        this.engEoRefPK = engEoRefPK;
    }

    public String getRefCompliance() {
        return refCompliance;
    }

    public void setRefCompliance(String refCompliance) {
        this.refCompliance = refCompliance;
    }

    public String getRefComments() {
        return refComments;
    }

    public void setRefComments(String refComments) {
        this.refComments = refComments;
    }

    public BigInteger getRefReford() {
        return refReford;
    }

    public void setRefReford(BigInteger refReford) {
        this.refReford = refReford;
    }

    public String getRefUserIns() {
        return refUserIns;
    }

    public void setRefUserIns(String refUserIns) {
        this.refUserIns = refUserIns;
    }

    public Date getRefFechaIns() {
        return refFechaIns;
    }

    public void setRefFechaIns(Date refFechaIns) {
        this.refFechaIns = refFechaIns;
    }

    public String getRefUserUpd() {
        return refUserUpd;
    }

    public void setRefUserUpd(String refUserUpd) {
        this.refUserUpd = refUserUpd;
    }

    public Date getRefDateUpd() {
        return refDateUpd;
    }

    public void setRefDateUpd(Date refDateUpd) {
        this.refDateUpd = refDateUpd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (engEoRefPK != null ? engEoRefPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EngEoRef)) {
            return false;
        }
        EngEoRef other = (EngEoRef) object;
        if ((this.engEoRefPK == null && other.engEoRefPK != null) || (this.engEoRefPK != null && !this.engEoRefPK.equals(other.engEoRefPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngEoRef[ engEoRefPK=" + engEoRefPK + " ]";
    }
    
}
