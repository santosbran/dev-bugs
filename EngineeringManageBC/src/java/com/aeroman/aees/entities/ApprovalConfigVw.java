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
@Table(name = "APPROVAL_CONFIG_VW")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ApprovalConfigVw.findAll", query = "SELECT a FROM ApprovalConfigVw a"),
    @NamedQuery(name = "ApprovalConfigVw.findByAcfId", query = "SELECT a FROM ApprovalConfigVw a WHERE a.acfId = :acfId"),
    @NamedQuery(name = "ApprovalConfigVw.findByAcfDescription", query = "SELECT a FROM ApprovalConfigVw a WHERE a.acfDescription = :acfDescription"),
    @NamedQuery(name = "ApprovalConfigVw.findByAcfUseStart", query = "SELECT a FROM ApprovalConfigVw a WHERE a.acfUseStart = :acfUseStart"),
    @NamedQuery(name = "ApprovalConfigVw.findByAcfUseEnd", query = "SELECT a FROM ApprovalConfigVw a WHERE a.acfUseEnd = :acfUseEnd"),
    @NamedQuery(name = "ApprovalConfigVw.findByFltCod", query = "SELECT a FROM ApprovalConfigVw a WHERE a.fltCod = :fltCod"),
    @NamedQuery(name = "ApprovalConfigVw.findByAcfUsrIns", query = "SELECT a FROM ApprovalConfigVw a WHERE a.acfUsrIns = :acfUsrIns"),
    @NamedQuery(name = "ApprovalConfigVw.findByAcfDateIns", query = "SELECT a FROM ApprovalConfigVw a WHERE a.acfDateIns = :acfDateIns"),
    @NamedQuery(name = "ApprovalConfigVw.findByAcfUsrUpd", query = "SELECT a FROM ApprovalConfigVw a WHERE a.acfUsrUpd = :acfUsrUpd"),
    @NamedQuery(name = "ApprovalConfigVw.findByAcfDateUpd", query = "SELECT a FROM ApprovalConfigVw a WHERE a.acfDateUpd = :acfDateUpd"),
    @NamedQuery(name = "ApprovalConfigVw.findByDescription", query = "SELECT a FROM ApprovalConfigVw a WHERE a.description = :description"),
    @NamedQuery(name = "ApprovalConfigVw.findByTipo", query = "SELECT a FROM ApprovalConfigVw a WHERE a.tipo = :tipo"),
    @NamedQuery(name = "ApprovalConfigVw.findByCustomerId", query = "SELECT a FROM ApprovalConfigVw a WHERE a.customerId = :customerId"),
    @NamedQuery(name = "ApprovalConfigVw.findByCompany", query = "SELECT a FROM ApprovalConfigVw a WHERE a.company = :company")})
public class ApprovalConfigVw implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACF_ID")
    @Id
    private short acfId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ACF_DESCRIPTION")
    private String acfDescription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACF_USE_START")
    @Temporal(TemporalType.TIMESTAMP)
    private Date acfUseStart;
    @Column(name = "ACF_USE_END")
    @Temporal(TemporalType.TIMESTAMP)
    private Date acfUseEnd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "FLT_COD")
    private String fltCod;
    @Size(max = 30)
    @Column(name = "ACF_USR_INS")
    private String acfUsrIns;
    @Column(name = "ACF_DATE_INS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date acfDateIns;
    @Size(max = 30)
    @Column(name = "ACF_USR_UPD")
    private String acfUsrUpd;
    @Column(name = "ACF_DATE_UPD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date acfDateUpd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 20)
    @Column(name = "TIPO")
    private String tipo;
    @Column(name = "CUSTOMER_ID")
    private BigInteger customerId;
    @Size(max = 2)
    @Column(name = "COMPANY")
    private String company;

    public ApprovalConfigVw() {
        super();
    }

    public short getAcfId() {
        return acfId;
    }

    public void setAcfId(short acfId) {
        this.acfId = acfId;
    }

    public String getAcfDescription() {
        return acfDescription;
    }

    public void setAcfDescription(String acfDescription) {
        this.acfDescription = acfDescription;
    }

    public Date getAcfUseStart() {
        return acfUseStart;
    }

    public void setAcfUseStart(Date acfUseStart) {
        this.acfUseStart = acfUseStart;
    }

    public Date getAcfUseEnd() {
        return acfUseEnd;
    }

    public void setAcfUseEnd(Date acfUseEnd) {
        this.acfUseEnd = acfUseEnd;
    }

    public String getFltCod() {
        return fltCod;
    }

    public void setFltCod(String fltCod) {
        this.fltCod = fltCod;
    }

    public String getAcfUsrIns() {
        return acfUsrIns;
    }

    public void setAcfUsrIns(String acfUsrIns) {
        this.acfUsrIns = acfUsrIns;
    }

    public Date getAcfDateIns() {
        return acfDateIns;
    }

    public void setAcfDateIns(Date acfDateIns) {
        this.acfDateIns = acfDateIns;
    }

    public String getAcfUsrUpd() {
        return acfUsrUpd;
    }

    public void setAcfUsrUpd(String acfUsrUpd) {
        this.acfUsrUpd = acfUsrUpd;
    }

    public Date getAcfDateUpd() {
        return acfDateUpd;
    }

    public void setAcfDateUpd(Date acfDateUpd) {
        this.acfDateUpd = acfDateUpd;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BigInteger getCustomerId() {
        return customerId;
    }

    public void setCustomerId(BigInteger customerId) {
        this.customerId = customerId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
    
}
