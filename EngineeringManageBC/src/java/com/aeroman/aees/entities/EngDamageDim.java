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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author casa
 */
@Entity
@Cacheable(false)
@Table(name = "ENG_DAMAGE_DIM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngDamageDim.findAll", query = "SELECT e FROM EngDamageDim e")
    , @NamedQuery(name = "EngDamageDim.findByDxdId", query = "SELECT e FROM EngDamageDim e WHERE e.dxdId = :dxdId")
    , @NamedQuery(name = "EngDamageDim.findByDxdState", query = "SELECT e FROM EngDamageDim e WHERE e.dxdState = :dxdState")
    , @NamedQuery(name = "EngDamageDim.findByDxdUserAdd", query = "SELECT e FROM EngDamageDim e WHERE e.dxdUserAdd = :dxdUserAdd")
    , @NamedQuery(name = "EngDamageDim.findByDxdDateAdd", query = "SELECT e FROM EngDamageDim e WHERE e.dxdDateAdd = :dxdDateAdd")
    , @NamedQuery(name = "EngDamageDim.findByDxdUserUpd", query = "SELECT e FROM EngDamageDim e WHERE e.dxdUserUpd = :dxdUserUpd")
    , @NamedQuery(name = "EngDamageDim.findByDxdDateUpd", query = "SELECT e FROM EngDamageDim e WHERE e.dxdDateUpd = :dxdDateUpd")
    , @NamedQuery(name = "EngDamageDim.findByDxdUserDlt", query = "SELECT e FROM EngDamageDim e WHERE e.dxdUserDlt = :dxdUserDlt")
    , @NamedQuery(name = "EngDamageDim.findByDxdDateDlt", query = "SELECT e FROM EngDamageDim e WHERE e.dxdDateDlt = :dxdDateDlt")})
public class EngDamageDim implements Serializable {
//
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "redIdDimension")
//    private List<EngRequestDimenIni> engRequestDimenIniList;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "redIdDimension")
//    private Collection<EngRequestDimen> engRequestDimenCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDimension")
    private static final long serialVersionUID = 1L;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue (strategy=GenerationType.SEQUENCE,generator="ENG_DAMAGE_DIM_SEQ") 
    @SequenceGenerator (name="ENG_DAMAGE_DIM_SEQ",sequenceName="ENG_DAMAGE_DIM_SEQ",allocationSize=1)
    @Column(name = "DXD_ID")
    private BigDecimal dxdId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "DXD_STATE")
    private String dxdState;
    @Size(max = 9)
    @Column(name = "DXD_USER_ADD")
    private String dxdUserAdd;
    @Column(name = "DXD_DATE_ADD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dxdDateAdd;
    @Size(max = 9)
    @Column(name = "DXD_USER_UPD")
    private String dxdUserUpd;
    @Column(name = "DXD_DATE_UPD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dxdDateUpd;
    @Size(max = 9)
    @Column(name = "DXD_USER_DLT")
    private String dxdUserDlt;
    @Column(name = "DXD_DATE_DLT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dxdDateDlt;
    @Size(max = 1000)
    @Column(name = "DXD_NOTA")
    private String dxdNota;
    @JoinColumn(name = "DAT_ID", referencedColumnName = "DAT_ID")
    @ManyToOne
    private EngDamageType datId;
    @JoinColumn(name = "DIM_ID", referencedColumnName = "DIM_ID")
    @ManyToOne
    private EngDimension dimId;
    @JoinColumn(name = "ARCTYP_ID", referencedColumnName = "ARCTYP_ID")
    @ManyToOne(optional = false)
    private CoreAircraftType arctypId;

    public EngDamageDim() {
        super();
    }

    public EngDamageDim(BigDecimal dxdId) {
        this.dxdId = dxdId;
    }

    public EngDamageDim(BigDecimal dxdId, String dxdState) {
        this.dxdId = dxdId;
        this.dxdState = dxdState;
    }

    public BigDecimal getDxdId() {
        return dxdId;
    }

    public void setDxdId(BigDecimal dxdId) {
        this.dxdId = dxdId;
    }

    public String getDxdState() {
        return dxdState;
    }

    public void setDxdState(String dxdState) {
        this.dxdState = dxdState;
    }

    public String getDxdUserAdd() {
        return dxdUserAdd;
    }

    public void setDxdUserAdd(String dxdUserAdd) {
        this.dxdUserAdd = dxdUserAdd;
    }

    public Date getDxdDateAdd() {
        return dxdDateAdd;
    }

    public void setDxdDateAdd(Date dxdDateAdd) {
        this.dxdDateAdd = dxdDateAdd;
    }

    public String getDxdUserUpd() {
        return dxdUserUpd;
    }

    public void setDxdUserUpd(String dxdUserUpd) {
        this.dxdUserUpd = dxdUserUpd;
    }

    public Date getDxdDateUpd() {
        return dxdDateUpd;
    }

    public void setDxdDateUpd(Date dxdDateUpd) {
        this.dxdDateUpd = dxdDateUpd;
    }

    public String getDxdUserDlt() {
        return dxdUserDlt;
    }

    public void setDxdUserDlt(String dxdUserDlt) {
        this.dxdUserDlt = dxdUserDlt;
    }

    public Date getDxdDateDlt() {
        return dxdDateDlt;
    }

    public void setDxdDateDlt(Date dxdDateDlt) {
        this.dxdDateDlt = dxdDateDlt;
    }

    public EngDamageType getDatId() {
        return datId;
    }

    public void setDatId(EngDamageType datId) {
        this.datId = datId;
    }

    public EngDimension getDimId() {
        return dimId;
    }

    public void setDimId(EngDimension dimId) {
        this.dimId = dimId;
    }

    public CoreAircraftType getArctypId() {
        return arctypId;
    }

    public void setArctypId(CoreAircraftType arctypId) {
        this.arctypId = arctypId;
    } 
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dxdId != null ? dxdId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EngDamageDim)) {
            return false;
        }
        EngDamageDim other = (EngDamageDim) object;
        if ((this.dxdId == null && other.dxdId != null) || (this.dxdId != null && !this.dxdId.equals(other.dxdId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngDamageDim[ dxdId=" + dxdId + " ]";
    }

    //    @XmlTransient
//    public Collection<EngRequestDimen> getEngRequestDimenCollection() {
//        return engRequestDimenCollection;
//    }
//
//    public void setEngRequestDimenCollection(Collection<EngRequestDimen> engRequestDimenCollection) {
//        this.engRequestDimenCollection = engRequestDimenCollection;
//    }

    //    @XmlTransient
//    public List<EngRequestDimenIni> getEngRequestDimenIniList() {
//        return engRequestDimenIniList;
//    }
//
//    public void setEngRequestDimenIniList(List<EngRequestDimenIni> engRequestDimenIniList) {
//        this.engRequestDimenIniList = engRequestDimenIniList;
//    }

    public String getDxdNota() {
        return dxdNota;
    }

    public void setDxdNota(String dxdNota) {
        this.dxdNota = dxdNota;
    }
    
}
