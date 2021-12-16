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
@Table(name = "ENG_TEMP_DATA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngTempData.findAll", query = "SELECT e FROM EngTempData e")
    , @NamedQuery(name = "EngTempData.findByTedId", query = "SELECT e FROM EngTempData e WHERE e.tedId = :tedId")
    , @NamedQuery(name = "EngTempData.findByTedDescription", query = "SELECT e FROM EngTempData e WHERE e.tedDescription = :tedDescription")
    , @NamedQuery(name = "EngTempData.findByTedState", query = "SELECT e FROM EngTempData e WHERE e.tedState = :tedState")
    , @NamedQuery(name = "EngTempData.findByTedUserAdd", query = "SELECT e FROM EngTempData e WHERE e.tedUserAdd = :tedUserAdd")
    , @NamedQuery(name = "EngTempData.findByTedDateAdd", query = "SELECT e FROM EngTempData e WHERE e.tedDateAdd = :tedDateAdd")
    , @NamedQuery(name = "EngTempData.findByTedUserUpd", query = "SELECT e FROM EngTempData e WHERE e.tedUserUpd = :tedUserUpd")
    , @NamedQuery(name = "EngTempData.findByTedDateUpd", query = "SELECT e FROM EngTempData e WHERE e.tedDateUpd = :tedDateUpd")
    , @NamedQuery(name = "EngTempData.findByTedUserDlt", query = "SELECT e FROM EngTempData e WHERE e.tedUserDlt = :tedUserDlt")
    , @NamedQuery(name = "EngTempData.findByTedDateDlt", query = "SELECT e FROM EngTempData e WHERE e.tedDateDlt = :tedDateDlt")})
public class EngTempData implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue (strategy=GenerationType.SEQUENCE,generator="ENG_TEMP_DATA_SEQ") 
    @SequenceGenerator (name="ENG_TEMP_DATA_SEQ",sequenceName="ENG_TEMP_DATA_SEQ",allocationSize=1)
    @Column(name = "TED_ID")
    private BigDecimal tedId;
    @Size(max = 200)
    @Column(name = "TED_DESCRIPTION")
    private String tedDescription;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "TED_STATE")
    private String tedState;
    @Size(max = 9)
    @Column(name = "TED_USER_ADD")
    private String tedUserAdd;
    @Column(name = "TED_DATE_ADD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tedDateAdd;
    @Size(max = 9)
    @Column(name = "TED_USER_UPD")
    private String tedUserUpd;
    @Column(name = "TED_DATE_UPD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tedDateUpd;
    @Size(max = 9)
    @Column(name = "TED_USER_DLT")
    private String tedUserDlt;
    @Column(name = "TED_DATE_DLT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tedDateDlt;

    public EngTempData() {
    }

    public EngTempData(BigDecimal tedId) {
        this.tedId = tedId;
    }

    public EngTempData(BigDecimal tedId, String tedState) {
        this.tedId = tedId;
        this.tedState = tedState;
    }

    public BigDecimal getTedId() {
        return tedId;
    }

    public void setTedId(BigDecimal tedId) {
        this.tedId = tedId;
    }

    public String getTedDescription() {
        return tedDescription;
    }

    public void setTedDescription(String tedDescription) {
        this.tedDescription = tedDescription;
    }

    public String getTedState() {
        return tedState;
    }

    public void setTedState(String tedState) {
        this.tedState = tedState;
    }

    public String getTedUserAdd() {
        return tedUserAdd;
    }

    public void setTedUserAdd(String tedUserAdd) {
        this.tedUserAdd = tedUserAdd;
    }

    public Date getTedDateAdd() {
        return tedDateAdd;
    }

    public void setTedDateAdd(Date tedDateAdd) {
        this.tedDateAdd = tedDateAdd;
    }

    public String getTedUserUpd() {
        return tedUserUpd;
    }

    public void setTedUserUpd(String tedUserUpd) {
        this.tedUserUpd = tedUserUpd;
    }

    public Date getTedDateUpd() {
        return tedDateUpd;
    }

    public void setTedDateUpd(Date tedDateUpd) {
        this.tedDateUpd = tedDateUpd;
    }

    public String getTedUserDlt() {
        return tedUserDlt;
    }

    public void setTedUserDlt(String tedUserDlt) {
        this.tedUserDlt = tedUserDlt;
    }

    public Date getTedDateDlt() {
        return tedDateDlt;
    }

    public void setTedDateDlt(Date tedDateDlt) {
        this.tedDateDlt = tedDateDlt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tedId != null ? tedId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EngTempData)) {
            return false;
        }
        EngTempData other = (EngTempData) object;
        if ((this.tedId == null && other.tedId != null) || (this.tedId != null && !this.tedId.equals(other.tedId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngTempData[ tedId=" + tedId + " ]";
    }
    
}
