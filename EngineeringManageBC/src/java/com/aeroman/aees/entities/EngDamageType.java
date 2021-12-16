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
 * @author mpolanco
 */
@Entity
@Cacheable(false)
@Table(name = "ENG_DAMAGE_TYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngDamageType.findAll", query = "SELECT e FROM EngDamageType e")
    , @NamedQuery(name = "EngDamageType.findByDatId", query = "SELECT e FROM EngDamageType e WHERE e.datId = :datId")
    , @NamedQuery(name = "EngDamageType.findByDatName", query = "SELECT e FROM EngDamageType e WHERE e.datName = :datName")
    , @NamedQuery(name = "EngDamageType.findByDatDescription", query = "SELECT e FROM EngDamageType e WHERE e.datDescription = :datDescription")
    , @NamedQuery(name = "EngDamageType.findByDatState", query = "SELECT e FROM EngDamageType e WHERE e.datState = :datState")
    , @NamedQuery(name = "EngDamageType.findByDatUserAdd", query = "SELECT e FROM EngDamageType e WHERE e.datUserAdd = :datUserAdd")
    , @NamedQuery(name = "EngDamageType.findByDatDateAdd", query = "SELECT e FROM EngDamageType e WHERE e.datDateAdd = :datDateAdd")
    , @NamedQuery(name = "EngDamageType.findByDatUserUpd", query = "SELECT e FROM EngDamageType e WHERE e.datUserUpd = :datUserUpd")
    , @NamedQuery(name = "EngDamageType.findByDatDateUpd", query = "SELECT e FROM EngDamageType e WHERE e.datDateUpd = :datDateUpd")
    , @NamedQuery(name = "EngDamageType.findByDatUserDlt", query = "SELECT e FROM EngDamageType e WHERE e.datUserDlt = :datUserDlt")
    , @NamedQuery(name = "EngDamageType.findByDatDateDlt", query = "SELECT e FROM EngDamageType e WHERE e.datDateDlt = :datDateDlt")})
public class EngDamageType implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "datId")
    private Collection<EngDentIni> engDentIniCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "datId")
    private Collection<EngDent> engDentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "datId")
    private Collection<EngDamageQuestion> engDamageQuestionCollection;

    

    @OneToMany(mappedBy = "datId")
    private Collection<EngDamageDim> engDamageDimCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "datId")
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue (strategy=GenerationType.SEQUENCE,generator="ENG_DAMAGE_TYPE_SEQ") 
    @SequenceGenerator (name="ENG_DAMAGE_TYPE_SEQ",sequenceName="ENG_DAMAGE_TYPE_SEQ",allocationSize=1)
    @Column(name = "DAT_ID")
    private BigDecimal datId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "DAT_NAME")
    private String datName;
    @Size(max = 200)
    @Column(name = "DAT_DESCRIPTION")
    private String datDescription;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "DAT_STATE")
    private String datState;
    @Size(max = 9)
    @Column(name = "DAT_USER_ADD")
    private String datUserAdd;
    @Column(name = "DAT_DATE_ADD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datDateAdd;
    @Size(max = 9)
    @Column(name = "DAT_USER_UPD")
    private String datUserUpd;
    @Column(name = "DAT_DATE_UPD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datDateUpd;
    @Size(max = 9)
    @Column(name = "DAT_USER_DLT")
    private String datUserDlt;
    @Column(name = "DAT_DATE_DLT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datDateDlt;

    public EngDamageType() {
        super();
    }

    public EngDamageType(BigDecimal datId) {
        this.datId = datId;
    }

    public EngDamageType(BigDecimal datId, String datName, String datState) {
        this.datId = datId;
        this.datName = datName;
        this.datState = datState;
    }

    public BigDecimal getDatId() {
        return datId;
    }

    public void setDatId(BigDecimal datId) {
        this.datId = datId;
    }

    public String getDatName() {
        return datName;
    }

    public void setDatName(String datName) {
        this.datName = datName;
    }

    public String getDatDescription() {
        return datDescription;
    }

    public void setDatDescription(String datDescription) {
        this.datDescription = datDescription;
    }

    public String getDatState() {
        return datState;
    }

    public void setDatState(String datState) {
        this.datState = datState;
    }

    public String getDatUserAdd() {
        return datUserAdd;
    }

    public void setDatUserAdd(String datUserAdd) {
        this.datUserAdd = datUserAdd;
    }

    public Date getDatDateAdd() {
        return datDateAdd;
    }

    public void setDatDateAdd(Date datDateAdd) {
        this.datDateAdd = datDateAdd;
    }

    public String getDatUserUpd() {
        return datUserUpd;
    }

    public void setDatUserUpd(String datUserUpd) {
        this.datUserUpd = datUserUpd;
    }

    public Date getDatDateUpd() {
        return datDateUpd;
    }

    public void setDatDateUpd(Date datDateUpd) {
        this.datDateUpd = datDateUpd;
    }

    public String getDatUserDlt() {
        return datUserDlt;
    }

    public void setDatUserDlt(String datUserDlt) {
        this.datUserDlt = datUserDlt;
    }

    public Date getDatDateDlt() {
        return datDateDlt;
    }

    public void setDatDateDlt(Date datDateDlt) {
        this.datDateDlt = datDateDlt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (datId != null ? datId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EngDamageType)) {
            return false;
        }
        EngDamageType other = (EngDamageType) object;
        if ((this.datId == null && other.datId != null) || (this.datId != null && !this.datId.equals(other.datId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngDamageType[ datId=" + datId + " ]";
    }

    @XmlTransient
    public Collection<EngDamageDim> getEngDamageDimCollection() {
        return engDamageDimCollection;
    }

    public void setEngDamageDimCollection(Collection<EngDamageDim> engDamageDimCollection) {
        this.engDamageDimCollection = engDamageDimCollection;
    }

    

    @XmlTransient
    public Collection<EngDamageQuestion> getEngDamageQuestionCollection() {
        return engDamageQuestionCollection;
    }

    public void setEngDamageQuestionCollection(Collection<EngDamageQuestion> engDamageQuestionCollection) {
        this.engDamageQuestionCollection = engDamageQuestionCollection;
    }

    @XmlTransient
    public Collection<EngDent> getEngDentCollection() {
        return engDentCollection;
    }

    public void setEngDentCollection(Collection<EngDent> engDentCollection) {
        this.engDentCollection = engDentCollection;
    }

    @XmlTransient
    public Collection<EngDentIni> getEngDentIniCollection() {
        return engDentIniCollection;
    }

    public void setEngDentIniCollection(Collection<EngDentIni> engDentIniCollection) {
        this.engDentIniCollection = engDentIniCollection;
    }

    }
