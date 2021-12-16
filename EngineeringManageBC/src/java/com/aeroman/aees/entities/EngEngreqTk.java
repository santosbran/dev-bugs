/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
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
 * @author pc
 */
@Entity
@Cacheable(false)
@Table(name = "ENG_ENGREQ_TK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngEngreqTk.findAll", query = "SELECT e FROM EngEngreqTk e"),
    @NamedQuery(name = "EngEngreqTk.findByErtIdReg", query = "SELECT e FROM EngEngreqTk e WHERE e.ertIdReg = :ertIdReg"),
    @NamedQuery(name = "EngEngreqTk.findByErtLogpage", query = "SELECT e FROM EngEngreqTk e WHERE e.ertLogpage = :ertLogpage"),
    @NamedQuery(name = "EngEngreqTk.findByErtTkYear", query = "SELECT e FROM EngEngreqTk e WHERE e.ertTkYear = :ertTkYear"),
    @NamedQuery(name = "EngEngreqTk.findByErtTkCorr", query = "SELECT e FROM EngEngreqTk e WHERE e.ertTkCorr = :ertTkCorr"),
    @NamedQuery(name = "EngEngreqTk.findByErtPrincipal", query = "SELECT e FROM EngEngreqTk e WHERE e.ertPrincipal = :ertPrincipal")})
public class EngEngreqTk implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ERT_ID_REG")
    private BigDecimal ertIdReg;
    @Size(max = 2000)
    @Column(name = "ERT_LOGPAGE")
    private String ertLogpage;
    @Size(max = 4)
    @Column(name = "ERT_TK_YEAR")
    private String ertTkYear;
    @Size(max = 90)
    @Column(name = "ERT_TK_CORR")
    private String ertTkCorr;
    @Size(max = 1)
    @Column(name = "ERT_PRINCIPAL")
    private String ertPrincipal;
    @JoinColumn(name = "REQ_MESSAGEID", referencedColumnName = "REQ_MESSAGEID")
    @ManyToOne
    private EngRequest reqMessageid;

    public EngEngreqTk() {
        super();
    }

    public EngEngreqTk(BigDecimal ertIdReg) {
        this.ertIdReg = ertIdReg;
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

    public String getErtTkYear() {
        return ertTkYear;
    }

    public void setErtTkYear(String ertTkYear) {
        this.ertTkYear = ertTkYear;
    }

    public String getErtTkCorr() {
        return ertTkCorr;
    }

    public void setErtTkCorr(String ertTkCorr) {
        this.ertTkCorr = ertTkCorr;
    }

    public String getErtPrincipal() {
        return ertPrincipal;
    }

    public void setErtPrincipal(String ertPrincipal) {
        this.ertPrincipal = ertPrincipal;
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
        
        if (!(object instanceof EngEngreqTk)) {
            return false;
        }
        EngEngreqTk other = (EngEngreqTk) object;
        if ((this.ertIdReg == null && other.ertIdReg != null) || (this.ertIdReg != null && !this.ertIdReg.equals(other.ertIdReg))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngEngreqTk[ ertIdReg=" + ertIdReg + " ]";
    }
    
}
