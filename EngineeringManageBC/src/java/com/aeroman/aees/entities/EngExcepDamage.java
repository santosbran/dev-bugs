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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
 * @author mchacon
 */
@Entity
@Table(name = "ENG_EXCEP_DAMAGE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngExcepDamage.findAll", query = "SELECT e FROM EngExcepDamage e")
    , @NamedQuery(name = "EngExcepDamage.findByExcepDamId", query = "SELECT e FROM EngExcepDamage e WHERE e.excepDamId = :excepDamId")
    , @NamedQuery(name = "EngExcepDamage.findByExcepDamName", query = "SELECT e FROM EngExcepDamage e WHERE e.excepDamName = :excepDamName")
    , @NamedQuery(name = "EngExcepDamage.findByExcepDamDesc", query = "SELECT e FROM EngExcepDamage e WHERE e.excepDamDesc = :excepDamDesc")
    , @NamedQuery(name = "EngExcepDamage.findByExcepDamUserAdd", query = "SELECT e FROM EngExcepDamage e WHERE e.excepDamUserAdd = :excepDamUserAdd")
    , @NamedQuery(name = "EngExcepDamage.findByExcepDamDateAdd", query = "SELECT e FROM EngExcepDamage e WHERE e.excepDamDateAdd = :excepDamDateAdd")
    , @NamedQuery(name = "EngExcepDamage.findByExcepDamUserUpd", query = "SELECT e FROM EngExcepDamage e WHERE e.excepDamUserUpd = :excepDamUserUpd")
    , @NamedQuery(name = "EngExcepDamage.findByExcepDamDateUpd", query = "SELECT e FROM EngExcepDamage e WHERE e.excepDamDateUpd = :excepDamDateUpd")})
public class EngExcepDamage implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
      @GeneratedValue (strategy=GenerationType.SEQUENCE,generator="ENG_EXCEP_DAMAGE_SEQ") 
    @SequenceGenerator (name="ENG_EXCEP_DAMAGE_SEQ",sequenceName="ENG_EXCEP_DAMAGE_SEQ",allocationSize=1)
    @Column(name = "EXCEP_DAM_ID")
    private BigDecimal excepDamId;
    @Basic(optional = false)
    @Size(max = 200)
    @Column(name = "EXCEP_DAM_NAME")
    private String excepDamName;
    @Size(max = 2000)
    @Column(name = "EXCEP_DAM_DESC")
    private String excepDamDesc;
    @Size(max = 9)
    @Column(name = "EXCEP_DAM_USER_ADD")
    private String excepDamUserAdd;
    @Column(name = "EXCEP_DAM_DATE_ADD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date excepDamDateAdd;
    @Size(max = 9)
    @Column(name = "EXCEP_DAM_USER_UPD")
    private String excepDamUserUpd;
    @Column(name = "EXCEP_DAM_DATE_UPD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date excepDamDateUpd;

    public EngExcepDamage() {
    }

    public EngExcepDamage(BigDecimal excepDamId) {
        this.excepDamId = excepDamId;
    }

    public EngExcepDamage(BigDecimal excepDamId, String excepDamName) {
        this.excepDamId = excepDamId;
        this.excepDamName = excepDamName;
    }

    public BigDecimal getExcepDamId() {
        return excepDamId;
    }

    public void setExcepDamId(BigDecimal excepDamId) {
        this.excepDamId = excepDamId;
    }

    public String getExcepDamName() {
        return excepDamName;
    }

    public void setExcepDamName(String excepDamName) {
        this.excepDamName = excepDamName;
    }

    public String getExcepDamDesc() {
        return excepDamDesc;
    }

    public void setExcepDamDesc(String excepDamDesc) {
        this.excepDamDesc = excepDamDesc;
    }

    public String getExcepDamUserAdd() {
        return excepDamUserAdd;
    }

    public void setExcepDamUserAdd(String excepDamUserAdd) {
        this.excepDamUserAdd = excepDamUserAdd;
    }

    public Date getExcepDamDateAdd() {
        return excepDamDateAdd;
    }

    public void setExcepDamDateAdd(Date excepDamDateAdd) {
        this.excepDamDateAdd = excepDamDateAdd;
    }

    public String getExcepDamUserUpd() {
        return excepDamUserUpd;
    }

    public void setExcepDamUserUpd(String excepDamUserUpd) {
        this.excepDamUserUpd = excepDamUserUpd;
    }

    public Date getExcepDamDateUpd() {
        return excepDamDateUpd;
    }

    public void setExcepDamDateUpd(Date excepDamDateUpd) {
        this.excepDamDateUpd = excepDamDateUpd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (excepDamId != null ? excepDamId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EngExcepDamage)) {
            return false;
        }
        EngExcepDamage other = (EngExcepDamage) object;
        if ((this.excepDamId == null && other.excepDamId != null) || (this.excepDamId != null && !this.excepDamId.equals(other.excepDamId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngExcepDamage[ excepDamId=" + excepDamId + " ]";
    }
    
}
