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
import javax.persistence.Cacheable;
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
 * @author Saplic16
 */
@Entity
@Cacheable(false)
@Table(name = "ENG_HORAS_ING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngHorasIng.findAll", query = "SELECT e FROM EngHorasIng e"),
    @NamedQuery(name = "EngHorasIng.findByHinId", query = "SELECT e FROM EngHorasIng e WHERE e.engHorasIngPK.hinId = :hinId"),
    @NamedQuery(name = "EngHorasIng.findByHinWoYear", query = "SELECT e FROM EngHorasIng e WHERE e.hinWoYear = :hinWoYear"),
    @NamedQuery(name = "EngHorasIng.findByHinWoCorr", query = "SELECT e FROM EngHorasIng e WHERE e.hinWoCorr = :hinWoCorr"),
    @NamedQuery(name = "EngHorasIng.findByHinWoTask", query = "SELECT e FROM EngHorasIng e WHERE e.hinWoTask = :hinWoTask"),
    @NamedQuery(name = "EngHorasIng.findByReqMessageid", query = "SELECT e FROM EngHorasIng e WHERE e.engHorasIngPK.reqMessageid = :reqMessageid"),
    @NamedQuery(name = "EngHorasIng.findByHinHrsReals", query = "SELECT e FROM EngHorasIng e WHERE e.hinHrsReals = :hinHrsReals"),
    @NamedQuery(name = "EngHorasIng.findByHinHrsBill", query = "SELECT e FROM EngHorasIng e WHERE e.hinHrsBill = :hinHrsBill"),
    @NamedQuery(name = "EngHorasIng.findByHinSelection", query = "SELECT e FROM EngHorasIng e WHERE e.hinSelection = :hinSelection"),
    @NamedQuery(name = "EngHorasIng.findByHinExported", query = "SELECT e FROM EngHorasIng e WHERE e.hinExported = :hinExported"),
    @NamedQuery(name = "EngHorasIng.findByEhiId", query = "SELECT e FROM EngHorasIng e WHERE e.ehiId = :ehiId"),
    @NamedQuery(name = "EngHorasIng.findByHinCodUsrIns", query = "SELECT e FROM EngHorasIng e WHERE e.hinCodUsrIns = :hinCodUsrIns"),
    @NamedQuery(name = "EngHorasIng.findByHinDateIns", query = "SELECT e FROM EngHorasIng e WHERE e.hinDateIns = :hinDateIns"),
    @NamedQuery(name = "EngHorasIng.findByHinCodUsrUpd", query = "SELECT e FROM EngHorasIng e WHERE e.hinCodUsrUpd = :hinCodUsrUpd"),
    @NamedQuery(name = "EngHorasIng.findByHinDateUpd", query = "SELECT e FROM EngHorasIng e WHERE e.hinDateUpd = :hinDateUpd")})
public class EngHorasIng implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EngHorasIngPK engHorasIngPK;
    @Column(name = "HIN_WO_YEAR")
    private BigInteger hinWoYear;
    @Column(name = "HIN_WO_CORR")
    private BigInteger hinWoCorr;
    @Column(name = "HIN_WO_TASK")
    private BigInteger hinWoTask;
    @Column(name = "HIN_HRS_REALS")
    private BigDecimal hinHrsReals;
    @Column(name = "HIN_HRS_BILL")
    private BigDecimal hinHrsBill;
    @Size(max = 1)
    @Column(name = "HIN_SELECTION")
    private String hinSelection;
    @Size(max = 3)
    @Column(name = "HIN_EXPORTED")
    private String hinExported;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EHI_ID")
    private BigInteger ehiId;
    @Size(max = 30)
    @Column(name = "HIN_COD_USR_INS")
    private String hinCodUsrIns;
    @Column(name = "HIN_DATE_INS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hinDateIns;
    @Size(max = 30)
    @Column(name = "HIN_COD_USR_UPD")
    private String hinCodUsrUpd;
    @Column(name = "HIN_DATE_UPD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hinDateUpd;

    public EngHorasIng() {
        super();
    }

    public EngHorasIng(EngHorasIngPK engHorasIngPK) {
        this.engHorasIngPK = engHorasIngPK;
    }

    public EngHorasIng(EngHorasIngPK engHorasIngPK, BigInteger ehiId) {
        this.engHorasIngPK = engHorasIngPK;
        this.ehiId = ehiId;
    }

    public EngHorasIng(BigInteger hinId, BigInteger reqMessageid) {
        this.engHorasIngPK = new EngHorasIngPK(hinId, reqMessageid);
    }

    public EngHorasIngPK getEngHorasIngPK() {
        return engHorasIngPK;
    }

    public void setEngHorasIngPK(EngHorasIngPK engHorasIngPK) {
        this.engHorasIngPK = engHorasIngPK;
    }

    public BigInteger getHinWoYear() {
        return hinWoYear;
    }

    public void setHinWoYear(BigInteger hinWoYear) {
        this.hinWoYear = hinWoYear;
    }

    public BigInteger getHinWoCorr() {
        return hinWoCorr;
    }

    public void setHinWoCorr(BigInteger hinWoCorr) {
        this.hinWoCorr = hinWoCorr;
    }

    public BigInteger getHinWoTask() {
        return hinWoTask;
    }

    public void setHinWoTask(BigInteger hinWoTask) {
        this.hinWoTask = hinWoTask;
    }

    public BigDecimal getHinHrsReals() {
        return hinHrsReals;
    }

    public void setHinHrsReals(BigDecimal hinHrsReals) {
        this.hinHrsReals = hinHrsReals;
    }

    public BigDecimal getHinHrsBill() {
        return hinHrsBill;
    }

    public void setHinHrsBill(BigDecimal hinHrsBill) {
        this.hinHrsBill = hinHrsBill;
    }

    public String getHinSelection() {
        return hinSelection;
    }

    public void setHinSelection(String hinSelection) {
        this.hinSelection = hinSelection;
    }

    public String getHinExported() {
        return hinExported;
    }

    public void setHinExported(String hinExported) {
        this.hinExported = hinExported;
    }

    public BigInteger getEhiId() {
        return ehiId;
    }

    public void setEhiId(BigInteger ehiId) {
        this.ehiId = ehiId;
    }

    public String getHinCodUsrIns() {
        return hinCodUsrIns;
    }

    public void setHinCodUsrIns(String hinCodUsrIns) {
        this.hinCodUsrIns = hinCodUsrIns;
    }

    public Date getHinDateIns() {
        return hinDateIns;
    }

    public void setHinDateIns(Date hinDateIns) {
        this.hinDateIns = hinDateIns;
    }

    public String getHinCodUsrUpd() {
        return hinCodUsrUpd;
    }

    public void setHinCodUsrUpd(String hinCodUsrUpd) {
        this.hinCodUsrUpd = hinCodUsrUpd;
    }

    public Date getHinDateUpd() {
        return hinDateUpd;
    }

    public void setHinDateUpd(Date hinDateUpd) {
        this.hinDateUpd = hinDateUpd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (engHorasIngPK != null ? engHorasIngPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EngHorasIng)) {
            return false;
        }
        EngHorasIng other = (EngHorasIng) object;
        if ((this.engHorasIngPK == null && other.engHorasIngPK != null) || (this.engHorasIngPK != null && !this.engHorasIngPK.equals(other.engHorasIngPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngHorasIng[ engHorasIngPK=" + engHorasIngPK + " ]";
    }
    
}
