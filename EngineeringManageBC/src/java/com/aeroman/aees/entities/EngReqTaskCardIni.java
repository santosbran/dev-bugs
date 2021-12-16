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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vjuarez
 */
@Entity
@Table(name = "ENG_REQ_TASK_CARD_INI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngReqTaskCardIni.findAll", query = "SELECT e FROM EngReqTaskCardIni e"),
    @NamedQuery(name = "EngReqTaskCardIni.findByErtIdReg", query = "SELECT e FROM EngReqTaskCardIni e WHERE e.ertIdReg = :ertIdReg"),
    @NamedQuery(name = "EngReqTaskCardIni.findByErtLogpage", query = "SELECT e FROM EngReqTaskCardIni e WHERE e.ertLogpage = :ertLogpage"),
    @NamedQuery(name = "EngReqTaskCardIni.findByErtTkYear", query = "SELECT e FROM EngReqTaskCardIni e WHERE e.ertTkYear = :ertTkYear"),
    @NamedQuery(name = "EngReqTaskCardIni.findByErtTkCorr", query = "SELECT e FROM EngReqTaskCardIni e WHERE e.ertTkCorr = :ertTkCorr"),
    @NamedQuery(name = "EngReqTaskCardIni.findByErtPrincipal", query = "SELECT e FROM EngReqTaskCardIni e WHERE e.ertPrincipal = :ertPrincipal"),
    @NamedQuery(name = "EngReqTaskCardIni.findByIdCard", query = "SELECT e FROM EngReqTaskCardIni e WHERE e.idCard = :idCard")})
public class EngReqTaskCardIni implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ERT_ID_REG")
    private BigDecimal ertIdReg;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 90)
    @Column(name = "ERT_LOGPAGE")
    private String ertLogpage;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ERT_TK_YEAR")
    private BigInteger ertTkYear;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ERT_TK_CORR")
    private BigInteger ertTkCorr;
    @Size(max = 100)
    @Column(name = "ERT_PRINCIPAL")
    private String ertPrincipal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CARD")
    private BigInteger idCard;
    @JoinColumn(name = "REQ_MESSAGEID", referencedColumnName = "REQ_MESSAGEID")
    @ManyToOne(optional = false)
    private EngRequest reqMessageid;

    public EngReqTaskCardIni() {
    }

    public EngReqTaskCardIni(BigDecimal ertIdReg) {
        this.ertIdReg = ertIdReg;
    }

    public EngReqTaskCardIni(BigDecimal ertIdReg, String ertLogpage, BigInteger ertTkYear, BigInteger ertTkCorr, BigInteger idCard) {
        this.ertIdReg = ertIdReg;
        this.ertLogpage = ertLogpage;
        this.ertTkYear = ertTkYear;
        this.ertTkCorr = ertTkCorr;
        this.idCard = idCard;
    }

    public BigDecimal getErtIdReg() {
        return ertIdReg;
    }

    public void setErtIdReg(BigDecimal ertIdReg) {
        this.ertIdReg = ertIdReg;
    }

    public String getErtLogpage() {
        return ertLogpage;
    }

    public void setErtLogpage(String ertLogpage) {
        this.ertLogpage = ertLogpage;
    }

    public BigInteger getErtTkYear() {
        return ertTkYear;
    }

    public void setErtTkYear(BigInteger ertTkYear) {
        this.ertTkYear = ertTkYear;
    }

    public BigInteger getErtTkCorr() {
        return ertTkCorr;
    }

    public void setErtTkCorr(BigInteger ertTkCorr) {
        this.ertTkCorr = ertTkCorr;
    }

    public String getErtPrincipal() {
        return ertPrincipal;
    }

    public void setErtPrincipal(String ertPrincipal) {
        this.ertPrincipal = ertPrincipal;
    }

    public BigInteger getIdCard() {
        return idCard;
    }

    public void setIdCard(BigInteger idCard) {
        this.idCard = idCard;
    }

    public EngRequest getReqMessageid() {
        return reqMessageid;
    }

    public void setReqMessageid(EngRequest reqMessageid) {
        this.reqMessageid = reqMessageid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ertIdReg != null ? ertIdReg.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EngReqTaskCardIni)) {
            return false;
        }
        EngReqTaskCardIni other = (EngReqTaskCardIni) object;
        if ((this.ertIdReg == null && other.ertIdReg != null) || (this.ertIdReg != null && !this.ertIdReg.equals(other.ertIdReg))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngReqTaskCardIni[ ertIdReg=" + ertIdReg + " ]";
    }
    
}
