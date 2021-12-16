/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author saplic11
 */
@Entity
@Cacheable(false)
@Table(name = "ENG_HOURS_VW")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngHoursVw.findAll", query = "SELECT e FROM EngHoursVw e"),
    @NamedQuery(name = "EngHoursVw.findByRowId", query = "SELECT e FROM EngHoursVw e WHERE e.rowId = :rowId"),
    @NamedQuery(name = "EngHoursVw.findByHinId", query = "SELECT e FROM EngHoursVw e WHERE e.hinId = :hinId"),
    @NamedQuery(name = "EngHoursVw.findByNesr", query = "SELECT e FROM EngHoursVw e WHERE e.nesr = :nesr"),
    @NamedQuery(name = "EngHoursVw.findBySubject", query = "SELECT e FROM EngHoursVw e WHERE e.subject = :subject"),
    @NamedQuery(name = "EngHoursVw.findByEa", query = "SELECT e FROM EngHoursVw e WHERE e.ea = :ea"),
    @NamedQuery(name = "EngHoursVw.findBySumhours", query = "SELECT e FROM EngHoursVw e WHERE e.sumhours = :sumhours"),
    @NamedQuery(name = "EngHoursVw.findByCorr", query = "SELECT e FROM EngHoursVw e WHERE e.corr = :corr"),
    @NamedQuery(name = "EngHoursVw.findByItem", query = "SELECT e FROM EngHoursVw e WHERE e.item = :item"),
    @NamedQuery(name = "EngHoursVw.findByReqMessageid", query = "SELECT e FROM EngHoursVw e WHERE e.reqMessageid = :reqMessageid"),
    @NamedQuery(name = "EngHoursVw.findByChkYear", query = "SELECT e FROM EngHoursVw e WHERE e.chkYear = :chkYear"),
    @NamedQuery(name = "EngHoursVw.findByFacturar", query = "SELECT e FROM EngHoursVw e WHERE e.facturar = :facturar"),
    @NamedQuery(name = "EngHoursVw.findBySelection", query = "SELECT e FROM EngHoursVw e WHERE e.selection = :selection"),
    @NamedQuery(name = "EngHoursVw.findByExported", query = "SELECT e FROM EngHoursVw e WHERE e.exported = :exported"),
    @NamedQuery(name = "EngHoursVw.findByComboindex", query = "SELECT e FROM EngHoursVw e WHERE e.comboindex = :comboindex"),
    @NamedQuery(name = "EngHoursVw.findByCheckid", query = "SELECT e FROM EngHoursVw e WHERE e.checkid = :checkid"),
    @NamedQuery(name = "EngHoursVw.findByReqTail", query = "SELECT e FROM EngHoursVw e WHERE e.reqTail = :reqTail"),
    @NamedQuery(name = "EngHoursVw.findByCustomer", query = "SELECT e FROM EngHoursVw e WHERE e.customer = :customer")})
public class EngHoursVw implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "ROW_ID")
    @Id
    private BigInteger rowId;
    @Column(name = "HIN_ID")
    private BigInteger hinId;
    @Size(max = 54)
    @Column(name = "NESR")
    private String nesr;
    @Size(max = 4000)
    @Column(name = "SUBJECT")
    private String subject;
    @Size(max = 400)
    @Column(name = "EA")
    private String ea;
    @Column(name = "SUMHOURS")
    private BigDecimal sumhours;
    @Column(name = "CORR")
    private Integer corr;
    @Column(name = "ITEM")
    private Short item;
    @Basic(optional = false)
    @NotNull
    @Column(name = "REQ_MESSAGEID")
    private BigInteger reqMessageid;
    @Column(name = "CHK_YEAR")
    private Short chkYear;
    @Column(name = "FACTURAR")
    private BigDecimal facturar;
    @Size(max = 1)
    @Column(name = "SELECTION")
    private String selection;
    @Size(max = 3)
    @Column(name = "EXPORTED")
    private String exported;
    @Column(name = "COMBOINDEX")
    private BigInteger comboindex;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CHECKID")
    private short checkid;
    @Size(max = 20)
    @Column(name = "REQ_TAIL")
    private String reqTail;
    @Size(max = 20)
    @Column(name = "CUSTOMER")
    private String customer;
    @Column(name = "JOBCARD")
    private String jobcard;

    public EngHoursVw() {
        super();
    }

    public BigInteger getRowId() {
        return rowId;
    }

    public void setRowId(BigInteger rowId) {
        this.rowId = rowId;
    }

    public BigInteger getHinId() {
        return hinId;
    }

    public void setHinId(BigInteger hinId) {
        this.hinId = hinId;
    }

    public String getNesr() {
        return nesr;
    }

    public void setNesr(String nesr) {
        this.nesr = nesr;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getEa() {
        return ea;
    }

    public void setEa(String ea) {
        this.ea = ea;
    }

    public BigDecimal getSumhours() {
        return sumhours;
    }

    public void setSumhours(BigDecimal sumhours) {
        this.sumhours = sumhours;
    }

    public Integer getCorr() {
        return corr;
    }

    public void setCorr(Integer corr) {
        this.corr = corr;
    }

    public Short getItem() {
        return item;
    }

    public void setItem(Short item) {
        this.item = item;
    }

    public BigInteger getReqMessageid() {
        return reqMessageid;
    }

    public void setReqMessageid(BigInteger reqMessageid) {
        this.reqMessageid = reqMessageid;
    }

    public Short getChkYear() {
        return chkYear;
    }

    public void setChkYear(Short chkYear) {
        this.chkYear = chkYear;
    }

    public BigDecimal getFacturar() {
        return facturar;
    }

    public void setFacturar(BigDecimal facturar) {
        this.facturar = facturar;
    }

    public String getSelection() {
        return selection;
    }

    public void setSelection(String selection) {
        this.selection = selection;
    }

    public String getExported() {
        return exported;
    }

    public void setExported(String exported) {
        this.exported = exported;
    }

    public BigInteger getComboindex() {
        return comboindex;
    }

    public void setComboindex(BigInteger comboindex) {
        this.comboindex = comboindex;
    }

    public short getCheckid() {
        return checkid;
    }

    public void setCheckid(short checkid) {
        this.checkid = checkid;
    }

    public String getReqTail() {
        return reqTail;
    }

    public void setReqTail(String reqTail) {
        this.reqTail = reqTail;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getJobcard() {
        return jobcard;
    }

    public void setJobcard(String jobcard) {
        this.jobcard = jobcard;
    }
        
}
