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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "ENG_DT_DIM_BY_MANUF")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngDtDimByManuf.findAll", query = "SELECT e FROM EngDtDimByManuf e")
    , @NamedQuery(name = "EngDtDimByManuf.findByDtDimByManufId", query = "SELECT e FROM EngDtDimByManuf e WHERE e.dtDimByManufId = :dtDimByManufId")
    , @NamedQuery(name = "EngDtDimByManuf.findByDtDimByManufName", query = "SELECT e FROM EngDtDimByManuf e WHERE e.dtDimByManufName = :dtDimByManufName")
    , @NamedQuery(name = "EngDtDimByManuf.findByDtDimByManufState", query = "SELECT e FROM EngDtDimByManuf e WHERE e.dtDimByManufState = :dtDimByManufState")
    , @NamedQuery(name = "EngDtDimByManuf.findByDtDimByManufUserAdd", query = "SELECT e FROM EngDtDimByManuf e WHERE e.dtDimByManufUserAdd = :dtDimByManufUserAdd")
    , @NamedQuery(name = "EngDtDimByManuf.findByDtDimByManufDateAdd", query = "SELECT e FROM EngDtDimByManuf e WHERE e.dtDimByManufDateAdd = :dtDimByManufDateAdd")
    , @NamedQuery(name = "EngDtDimByManuf.findByDtDimByManufUserUpd", query = "SELECT e FROM EngDtDimByManuf e WHERE e.dtDimByManufUserUpd = :dtDimByManufUserUpd")
    , @NamedQuery(name = "EngDtDimByManuf.findByDtDimByManufDateUpd", query = "SELECT e FROM EngDtDimByManuf e WHERE e.dtDimByManufDateUpd = :dtDimByManufDateUpd")})
public class EngDtDimByManuf implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
@GeneratedValue (strategy=GenerationType.SEQUENCE,generator="ENG_DT_DIM_BY_MANUF_SEQ") 
    @SequenceGenerator (name="ENG_DT_DIM_BY_MANUF_SEQ",sequenceName="ENG_DT_DIM_BY_MANUF_SEQ",allocationSize=1)
    @Column(name = "DT_DIM_BY_MANUF_ID")
    private BigDecimal dtDimByManufId;
    @Size(max = 1000)
    @Column(name = "DT_DIM_BY_MANUF_NAME")
    private String dtDimByManufName;
    @Size(max = 1)
    @Column(name = "DT_DIM_BY_MANUF_STATE")
    private String dtDimByManufState;
    @Size(max = 9)
    @Column(name = "DT_DIM_BY_MANUF_USER_ADD")
    private String dtDimByManufUserAdd;
    @Column(name = "DT_DIM_BY_MANUF_DATE_ADD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtDimByManufDateAdd;
    @Size(max = 9)
    @Column(name = "DT_DIM_BY_MANUF_USER_UPD")
    private String dtDimByManufUserUpd;
    @Column(name = "DT_DIM_BY_MANUF_DATE_UPD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtDimByManufDateUpd;
    @JoinColumn(name = "DAT_ID", referencedColumnName = "DAT_ID")
    @ManyToOne(optional = false)
    private EngDamageType datId;
    @JoinColumn(name = "DIM_ID", referencedColumnName = "DIM_ID")
    @ManyToOne(optional = false)
    private EngDimension dimId;

    @Size(max = 100)
    @Column(name = "VALUE_DIM")
    private String valueDim;

    
    @Size(max = 20)
    @Column(name = "UBICATION_DIM")
    private String ubicationDim;
    
    @Column(name = "ORDEN")
    private int orden;
    
        @Size(max = 200)
    @Column(name = "COMMENTS")
    private String comments;
    
    public EngDtDimByManuf() {
    }

    public EngDtDimByManuf(BigDecimal dtDimByManufId) {
        this.dtDimByManufId = dtDimByManufId;
    }

    public BigDecimal getDtDimByManufId() {
        return dtDimByManufId;
    }

    public void setDtDimByManufId(BigDecimal dtDimByManufId) {
        this.dtDimByManufId = dtDimByManufId;
    }

    public String getDtDimByManufName() {
        return dtDimByManufName;
    }

    public void setDtDimByManufName(String dtDimByManufName) {
        this.dtDimByManufName = dtDimByManufName;
    }

    public String getDtDimByManufState() {
        return dtDimByManufState;
    }

    public void setDtDimByManufState(String dtDimByManufState) {
        this.dtDimByManufState = dtDimByManufState;
    }

    public String getDtDimByManufUserAdd() {
        return dtDimByManufUserAdd;
    }

    public void setDtDimByManufUserAdd(String dtDimByManufUserAdd) {
        this.dtDimByManufUserAdd = dtDimByManufUserAdd;
    }

    public Date getDtDimByManufDateAdd() {
        return dtDimByManufDateAdd;
    }

    public void setDtDimByManufDateAdd(Date dtDimByManufDateAdd) {
        this.dtDimByManufDateAdd = dtDimByManufDateAdd;
    }

    public String getDtDimByManufUserUpd() {
        return dtDimByManufUserUpd;
    }

    public void setDtDimByManufUserUpd(String dtDimByManufUserUpd) {
        this.dtDimByManufUserUpd = dtDimByManufUserUpd;
    }

    public Date getDtDimByManufDateUpd() {
        return dtDimByManufDateUpd;
    }

    public void setDtDimByManufDateUpd(Date dtDimByManufDateUpd) {
        this.dtDimByManufDateUpd = dtDimByManufDateUpd;
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

    public String getValueDim() {
        return valueDim;
    }

    public void setValueDim(String valueDim) {
        this.valueDim = valueDim;
    }

    public String getUbicationDim() {
        return ubicationDim;
    }

    public void setUbicationDim(String ubicationDim) {
        this.ubicationDim = ubicationDim;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }


    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dtDimByManufId != null ? dtDimByManufId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EngDtDimByManuf)) {
            return false;
        }
        EngDtDimByManuf other = (EngDtDimByManuf) object;
        if ((this.dtDimByManufId == null && other.dtDimByManufId != null) || (this.dtDimByManufId != null && !this.dtDimByManufId.equals(other.dtDimByManufId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngDtDimByManuf[ dtDimByManufId=" + dtDimByManufId + " ]";
    }
    
}
