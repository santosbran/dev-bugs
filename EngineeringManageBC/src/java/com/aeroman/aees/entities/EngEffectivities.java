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
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "ENG_EFFECTIVITIES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngEffectivities.findAll", query = "SELECT e FROM EngEffectivities e"),
    @NamedQuery(name = "EngEffectivities.findByEffId", query = "SELECT e FROM EngEffectivities e WHERE e.effId = :effId"),
    @NamedQuery(name = "EngEffectivities.findByEoIdord", query = "SELECT e FROM EngEffectivities e WHERE e.eoIdord = :eoIdord"),
    @NamedQuery(name = "EngEffectivities.findByRegRegister", query = "SELECT e FROM EngEffectivities e WHERE e.regRegister = :regRegister"),
    @NamedQuery(name = "EngEffectivities.findByEffMsn", query = "SELECT e FROM EngEffectivities e WHERE e.effMsn = :effMsn"),
    @NamedQuery(name = "EngEffectivities.findByEffFsn", query = "SELECT e FROM EngEffectivities e WHERE e.effFsn = :effFsn"),
    @NamedQuery(name = "EngEffectivities.findByEffAcModel", query = "SELECT e FROM EngEffectivities e WHERE e.effAcModel = :effAcModel"),
    @NamedQuery(name = "EngEffectivities.findByEffComments", query = "SELECT e FROM EngEffectivities e WHERE e.effComments = :effComments"),
    @NamedQuery(name = "EngEffectivities.findByEffUserIns", query = "SELECT e FROM EngEffectivities e WHERE e.effUserIns = :effUserIns"),
    @NamedQuery(name = "EngEffectivities.findByEffDateIns", query = "SELECT e FROM EngEffectivities e WHERE e.effDateIns = :effDateIns"),
    @NamedQuery(name = "EngEffectivities.findByEffUserUpd", query = "SELECT e FROM EngEffectivities e WHERE e.effUserUpd = :effUserUpd"),
    @NamedQuery(name = "EngEffectivities.findByEffDateUpd", query = "SELECT e FROM EngEffectivities e WHERE e.effDateUpd = :effDateUpd")})
public class EngEffectivities implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EFF_ID")
    private Integer effId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EO_IDORD")
    private long eoIdord;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "REG_REGISTER")
    private String regRegister;
    @Column(name = "EFF_MSN")
    private BigInteger effMsn;
    @Column(name = "EFF_FSN")
    private BigInteger effFsn;
    @Column(name = "EFF_AC_MODEL")
    private BigInteger effAcModel;
    @Size(max = 240)
    @Column(name = "EFF_COMMENTS")
    private String effComments;
    @Size(max = 30)
    @Column(name = "EFF_USER_INS")
    private String effUserIns;
    @Column(name = "EFF_DATE_INS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date effDateIns;
    @Size(max = 30)
    @Column(name = "EFF_USER_UPD")
    private String effUserUpd;
    @Column(name = "EFF_DATE_UPD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date effDateUpd;

    public EngEffectivities() {
        super();
    }

    public EngEffectivities(Integer effId) {
        this.effId = effId;
    }

    public EngEffectivities(Integer effId, long eoIdord, String regRegister) {
        this.effId = effId;
        this.eoIdord = eoIdord;
        this.regRegister = regRegister;
    }

    public Integer getEffId() {
        return effId;
    }

    public void setEffId(Integer effId) {
        this.effId = effId;
    }

    public long getEoIdord() {
        return eoIdord;
    }

    public void setEoIdord(long eoIdord) {
        this.eoIdord = eoIdord;
    }

    public String getRegRegister() {
        return regRegister;
    }

    public void setRegRegister(String regRegister) {
        this.regRegister = regRegister;
    }

    public BigInteger getEffMsn() {
        return effMsn;
    }

    public void setEffMsn(BigInteger effMsn) {
        this.effMsn = effMsn;
    }

    public BigInteger getEffFsn() {
        return effFsn;
    }

    public void setEffFsn(BigInteger effFsn) {
        this.effFsn = effFsn;
    }

    public BigInteger getEffAcModel() {
        return effAcModel;
    }

    public void setEffAcModel(BigInteger effAcModel) {
        this.effAcModel = effAcModel;
    }

    public String getEffComments() {
        return effComments;
    }

    public void setEffComments(String effComments) {
        this.effComments = effComments;
    }

    public String getEffUserIns() {
        return effUserIns;
    }

    public void setEffUserIns(String effUserIns) {
        this.effUserIns = effUserIns;
    }

    public Date getEffDateIns() {
        return effDateIns;
    }

    public void setEffDateIns(Date effDateIns) {
        this.effDateIns = effDateIns;
    }

    public String getEffUserUpd() {
        return effUserUpd;
    }

    public void setEffUserUpd(String effUserUpd) {
        this.effUserUpd = effUserUpd;
    }

    public Date getEffDateUpd() {
        return effDateUpd;
    }

    public void setEffDateUpd(Date effDateUpd) {
        this.effDateUpd = effDateUpd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (effId != null ? effId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EngEffectivities)) {
            return false;
        }
        EngEffectivities other = (EngEffectivities) object;
        if ((this.effId == null && other.effId != null) || (this.effId != null && !this.effId.equals(other.effId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngEffectivities[ effId=" + effId + " ]";
    }
    
}
