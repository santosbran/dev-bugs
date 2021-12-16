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
import java.util.List;
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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author casa
 */
@Entity
@Cacheable(false)
@Table(name = "ENG_DIMENSION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngDimension.findAll", query = "SELECT e FROM EngDimension e")
    , @NamedQuery(name = "EngDimension.findByDimId", query = "SELECT e FROM EngDimension e WHERE e.dimId = :dimId")
    , @NamedQuery(name = "EngDimension.findByDimName", query = "SELECT e FROM EngDimension e WHERE e.dimName = :dimName")
    , @NamedQuery(name = "EngDimension.findByDimDescription", query = "SELECT e FROM EngDimension e WHERE e.dimDescription = :dimDescription")
    , @NamedQuery(name = "EngDimension.findByDimState", query = "SELECT e FROM EngDimension e WHERE e.dimState = :dimState")
    , @NamedQuery(name = "EngDimension.findByDimUserAdd", query = "SELECT e FROM EngDimension e WHERE e.dimUserAdd = :dimUserAdd")
    , @NamedQuery(name = "EngDimension.findByDimDateAdd", query = "SELECT e FROM EngDimension e WHERE e.dimDateAdd = :dimDateAdd")
    , @NamedQuery(name = "EngDimension.findByDimUserUpd", query = "SELECT e FROM EngDimension e WHERE e.dimUserUpd = :dimUserUpd")
    , @NamedQuery(name = "EngDimension.findByDimDateUpd", query = "SELECT e FROM EngDimension e WHERE e.dimDateUpd = :dimDateUpd")
    , @NamedQuery(name = "EngDimension.findByDimUserDlt", query = "SELECT e FROM EngDimension e WHERE e.dimUserDlt = :dimUserDlt")
    , @NamedQuery(name = "EngDimension.findByDimDateDlt", query = "SELECT e FROM EngDimension e WHERE e.dimDateDlt = :dimDateDlt")})
public class EngDimension implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dimId")
    private List<EngDtDimByManuf> engDtDimByManufList;
    
    @OneToMany(mappedBy = "dimId")
    private static final long serialVersionUID = 1L;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue (strategy=GenerationType.SEQUENCE,generator="ENG_DIMENSION_SEQ") 
    @SequenceGenerator (name="ENG_DIMENSION_SEQ",sequenceName="ENG_DIMENSION_SEQ",allocationSize=1)
    @Column(name = "DIM_ID")
    private BigDecimal dimId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "DIM_NAME")
    private String dimName;
    @Size(max = 200)
    @Column(name = "DIM_DESCRIPTION")
    private String dimDescription;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "DIM_STATE")
    private String dimState;
    @Size(max = 9)
    @Column(name = "DIM_USER_ADD")
    private String dimUserAdd;
    @Column(name = "DIM_DATE_ADD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dimDateAdd;
    @Size(max = 9)
    @Column(name = "DIM_USER_UPD")
    private String dimUserUpd;
    @Column(name = "DIM_DATE_UPD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dimDateUpd;
    @Size(max = 9)
    @Column(name = "DIM_USER_DLT")
    private String dimUserDlt;
    @Column(name = "DIM_DATE_DLT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dimDateDlt;
    @OneToMany(mappedBy = "dimId")
    private Collection<EngDamageDim> engDamageDimCollection;
    @Transient
    private String oli;
    @Transient
    private String mesure;
    @Size(max = 50)
    @Column(name = "TYPE_CONTROL")
    private String typeControl;
    

    public EngDimension() {
    }

    public EngDimension(BigDecimal dimId) {
        this.dimId = dimId;
    }

    public EngDimension(BigDecimal dimId, String dimName, String dimState) {
        this.dimId = dimId;
        this.dimName = dimName;
        this.dimState = dimState;
    }

    public BigDecimal getDimId() {
        return dimId;
    }

    public void setDimId(BigDecimal dimId) {
        this.dimId = dimId;
    }

    public String getDimName() {
        return dimName;
    }

    public void setDimName(String dimName) {
        this.dimName = dimName;
    }

    public String getDimDescription() {
        return dimDescription;
    }

    public void setDimDescription(String dimDescription) {
        this.dimDescription = dimDescription;
    }

    public String getDimState() {
        return dimState;
    }

    public void setDimState(String dimState) {
        this.dimState = dimState;
    }

    public String getDimUserAdd() {
        return dimUserAdd;
    }

    public void setDimUserAdd(String dimUserAdd) {
        this.dimUserAdd = dimUserAdd;
    }

    public Date getDimDateAdd() {
        return dimDateAdd;
    }

    public void setDimDateAdd(Date dimDateAdd) {
        this.dimDateAdd = dimDateAdd;
    }

    public String getDimUserUpd() {
        return dimUserUpd;
    }

    public void setDimUserUpd(String dimUserUpd) {
        this.dimUserUpd = dimUserUpd;
    }

    public Date getDimDateUpd() {
        return dimDateUpd;
    }

    public void setDimDateUpd(Date dimDateUpd) {
        this.dimDateUpd = dimDateUpd;
    }

    public String getDimUserDlt() {
        return dimUserDlt;
    }

    public void setDimUserDlt(String dimUserDlt) {
        this.dimUserDlt = dimUserDlt;
    }

    public Date getDimDateDlt() {
        return dimDateDlt;
    }

    public void setDimDateDlt(Date dimDateDlt) {
        this.dimDateDlt = dimDateDlt;
    }

    public String getOli() {
        return oli;
    }

    public void setOli(String oli) {
        this.oli = oli;
    }

    public String getMesure() {
        return mesure;
    }

    public void setMesure(String mesure) {
        this.mesure = mesure;
    }
    

    @XmlTransient
    public Collection<EngDamageDim> getEngDamageDimCollection() {
        return engDamageDimCollection;
    }

    public void setEngDamageDimCollection(Collection<EngDamageDim> engDamageDimCollection) {
        this.engDamageDimCollection = engDamageDimCollection;
    }
    
     public String getTypeControl() {
        return typeControl;
    }

    public void setTypeControl(String typeControl) {
        this.typeControl = typeControl;
    }
    
      @XmlTransient
    public List<EngDtDimByManuf> getEngDtDimByManufList() {
        return engDtDimByManufList;
    }

    public void setEngDtDimByManufList(List<EngDtDimByManuf> engDtDimByManufList) {
        this.engDtDimByManufList = engDtDimByManufList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dimId != null ? dimId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EngDimension)) {
            return false;
        }
        EngDimension other = (EngDimension) object;
        if ((this.dimId == null && other.dimId != null) || (this.dimId != null && !this.dimId.equals(other.dimId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngDimension[ dimId=" + dimId + " ]";
    }    
}
