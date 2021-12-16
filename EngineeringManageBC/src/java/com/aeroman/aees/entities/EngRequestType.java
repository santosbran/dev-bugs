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
 * @author mpolanco
 */
@Entity
@Table(name = "ENG_REQUEST_TYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngRequestType.findAll", query = "SELECT e FROM EngRequestType e")
    , @NamedQuery(name = "EngRequestType.findByRetId", query = "SELECT e FROM EngRequestType e WHERE e.retId = :retId")
    , @NamedQuery(name = "EngRequestType.findByRetDescription", query = "SELECT e FROM EngRequestType e WHERE e.retDescription = :retDescription")
    , @NamedQuery(name = "EngRequestType.findByRetState", query = "SELECT e FROM EngRequestType e WHERE e.retState = :retState")
    , @NamedQuery(name = "EngRequestType.findByRetUserAdd", query = "SELECT e FROM EngRequestType e WHERE e.retUserAdd = :retUserAdd")
    , @NamedQuery(name = "EngRequestType.findByRetDateAdd", query = "SELECT e FROM EngRequestType e WHERE e.retDateAdd = :retDateAdd")
    , @NamedQuery(name = "EngRequestType.findByRetUserUpd", query = "SELECT e FROM EngRequestType e WHERE e.retUserUpd = :retUserUpd")
    , @NamedQuery(name = "EngRequestType.findByRetDateUpd", query = "SELECT e FROM EngRequestType e WHERE e.retDateUpd = :retDateUpd")
    , @NamedQuery(name = "EngRequestType.findByRetUserDlt", query = "SELECT e FROM EngRequestType e WHERE e.retUserDlt = :retUserDlt")
    , @NamedQuery(name = "EngRequestType.findByRetDateDlt", query = "SELECT e FROM EngRequestType e WHERE e.retDateDlt = :retDateDlt")})
public class EngRequestType implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue (strategy=GenerationType.SEQUENCE,generator="ENG_REQUEST_TYPE_SEQ") 
    @SequenceGenerator (name="ENG_REQUEST_TYPE_SEQ",sequenceName="ENG_REQUEST_TYPE_SEQ",allocationSize=1)
    @Column(name = "RET_ID")
    private BigDecimal retId;
    @Size(max = 200)
    @Column(name = "RET_DESCRIPTION")
    private String retDescription;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "RET_STATE")
    private String retState;
    @Size(max = 9)
    @Column(name = "RET_USER_ADD")
    private String retUserAdd;
    @Column(name = "RET_DATE_ADD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date retDateAdd;
    @Size(max = 9)
    @Column(name = "RET_USER_UPD")
    private String retUserUpd;
    @Column(name = "RET_DATE_UPD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date retDateUpd;
    @Size(max = 9)
    @Column(name = "RET_USER_DLT")
    private String retUserDlt;
    @Column(name = "RET_DATE_DLT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date retDateDlt;

    public EngRequestType() {
    }

    public EngRequestType(BigDecimal retId) {
        this.retId = retId;
    }

    public EngRequestType(BigDecimal retId, String retState) {
        this.retId = retId;
        this.retState = retState;
    }

    public BigDecimal getRetId() {
        return retId;
    }

    public void setRetId(BigDecimal retId) {
        this.retId = retId;
    }

    public String getRetDescription() {
        return retDescription;
    }

    public void setRetDescription(String retDescription) {
        this.retDescription = retDescription;
    }

    public String getRetState() {
        return retState;
    }

    public void setRetState(String retState) {
        this.retState = retState;
    }

    public String getRetUserAdd() {
        return retUserAdd;
    }

    public void setRetUserAdd(String retUserAdd) {
        this.retUserAdd = retUserAdd;
    }

    public Date getRetDateAdd() {
        return retDateAdd;
    }

    public void setRetDateAdd(Date retDateAdd) {
        this.retDateAdd = retDateAdd;
    }

    public String getRetUserUpd() {
        return retUserUpd;
    }

    public void setRetUserUpd(String retUserUpd) {
        this.retUserUpd = retUserUpd;
    }

    public Date getRetDateUpd() {
        return retDateUpd;
    }

    public void setRetDateUpd(Date retDateUpd) {
        this.retDateUpd = retDateUpd;
    }

    public String getRetUserDlt() {
        return retUserDlt;
    }

    public void setRetUserDlt(String retUserDlt) {
        this.retUserDlt = retUserDlt;
    }

    public Date getRetDateDlt() {
        return retDateDlt;
    }

    public void setRetDateDlt(Date retDateDlt) {
        this.retDateDlt = retDateDlt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (retId != null ? retId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EngRequestType)) {
            return false;
        }
        EngRequestType other = (EngRequestType) object;
        if ((this.retId == null && other.retId != null) || (this.retId != null && !this.retId.equals(other.retId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngRequestType[ retId=" + retId + " ]";
    }
    
}
