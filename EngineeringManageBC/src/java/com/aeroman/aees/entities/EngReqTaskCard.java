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
 * @author ssibrian
 */
@Entity
@Cacheable(false)
@Table(name = "ENG_REQ_TASK_CARD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngReqTaskCard.findAll", query = "SELECT e FROM EngReqTaskCard e"),
    @NamedQuery(name = "EngReqTaskCard.findByErtIdReg", query = "SELECT e FROM EngReqTaskCard e WHERE e.ertIdReg = :ertIdReg"),
    @NamedQuery(name = "EngReqTaskCard.findByErtLogpage", query = "SELECT e FROM EngReqTaskCard e WHERE e.ertLogpage = :ertLogpage"),
    @NamedQuery(name = "EngReqTaskCard.findByErtTkYear", query = "SELECT e FROM EngReqTaskCard e WHERE e.ertTkYear = :ertTkYear"),
    @NamedQuery(name = "EngReqTaskCard.findByErtTkCorr", query = "SELECT e FROM EngReqTaskCard e WHERE e.ertTkCorr = :ertTkCorr"),
    @NamedQuery(name = "EngReqTaskCard.findByErtPrincipal", query = "SELECT e FROM EngReqTaskCard e WHERE e.ertPrincipal = :ertPrincipal")})
public class EngReqTaskCard implements Serializable {

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
    @JoinColumn(name = "REQ_MESSAGEID", referencedColumnName = "REQ_MESSAGEID")
    @ManyToOne(optional = false)
    private EngRequest reqMessageid;
    @JoinColumn(name = "ID_CARD", referencedColumnName = "ID_CARD")
    @ManyToOne(optional = false)
    private EngTaskCard idCard;
    @Column(name = "TC_STAT")
private String tcSTAT;

@Column(name = "TC_TC")
private String tcTC;

@Column(name = "TC_CRT")
private String tcCRT;

@Column(name = "TC_DESCRIPT")
private String tcDESCRIPT;

@Column(name = "TC_FLOTA")
private String tcFLOTA;

@Column(name = "TC_WC")
private String tcWC;

@Column(name = "TC_EST")
private String tcEST;

@Column(name = "TC_JOBC")
private String tcJOBC;

@Column(name = "TC_WO")
private String tcWO;

@Column(name = "TC_CUS")
private String tcCUS;

@Column(name = "TC_TAIL")
private String tcTAIL;

@Column(name = "TC_TASKCARDTYPE")
private String tcTASKCARDTYPE;

@Column(name = "TC_ROUTINE")
private String tcROUTINE;

@Column(name = "TC_OPERATOR")
private String tcOPERATOR;

@Column(name = "TC_DISCREPANCYID")
private String tcDISCREPANCYID;

@Column(name = "TC_CORRECTIVEID")
private String tcCORRECTIVEID;

    public EngReqTaskCard() {
        super();
    }

    public EngReqTaskCard(BigDecimal ertIdReg) {
        this.ertIdReg = ertIdReg;
    }

    public EngReqTaskCard(BigDecimal ertIdReg, String ertLogpage, BigInteger ertTkYear, BigInteger ertTkCorr) {
        this.ertIdReg = ertIdReg;
        this.ertLogpage = ertLogpage;
        this.ertTkYear = ertTkYear;
        this.ertTkCorr = ertTkCorr;
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

    public EngRequest getReqMessageid() {
        return reqMessageid;
    }

    public void setReqMessageid(EngRequest reqMessageid) {
        this.reqMessageid = reqMessageid;
    }

    public EngTaskCard getIdCard() {
        return idCard;
    }

    public void setIdCard(EngTaskCard idCard) {
        this.idCard = idCard;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ertIdReg != null ? ertIdReg.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EngReqTaskCard)) {
            return false;
        }
        EngReqTaskCard other = (EngReqTaskCard) object;
        if ((this.ertIdReg == null && other.ertIdReg != null) || (this.ertIdReg != null && !this.ertIdReg.equals(other.ertIdReg))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngReqTaskCard[ ertIdReg=" + ertIdReg + " ]";
    }
    
    public String getTcSTAT() {
        return tcSTAT;
    }

    public void setTcSTAT(String tcSTAT) {
        this.tcSTAT = tcSTAT;
    }

    public String getTcTC() {
        return tcTC;
    }

    public void setTcTC(String tcTC) {
        this.tcTC = tcTC;
    }

    public String getTcCRT() {
        return tcCRT;
    }

    public void setTcCRT(String tcCRT) {
        this.tcCRT = tcCRT;
    }

    public String getTcDESCRIPT() {
        return tcDESCRIPT;
    }

    public void setTcDESCRIPT(String tcDESCRIPT) {
        this.tcDESCRIPT = tcDESCRIPT;
    }

    public String getTcFLOTA() {
        return tcFLOTA;
    }

    public void setTcFLOTA(String tcFLOTA) {
        this.tcFLOTA = tcFLOTA;
    }

    public String getTcWC() {
        return tcWC;
    }

    public void setTcWC(String tcWC) {
        this.tcWC = tcWC;
    }

    public String getTcEST() {
        return tcEST;
    }

    public void setTcEST(String tcEST) {
        this.tcEST = tcEST;
    }

    public String getTcJOBC() {
        return tcJOBC;
    }

    public void setTcJOBC(String tcJOBC) {
        this.tcJOBC = tcJOBC;
    }

    public String getTcWO() {
        return tcWO;
    }

    public void setTcWO(String tcWO) {
        this.tcWO = tcWO;
    }

    public String getTcCUS() {
        return tcCUS;
    }

    public void setTcCUS(String tcCUS) {
        this.tcCUS = tcCUS;
    }

    public String getTcTAIL() {
        return tcTAIL;
    }

    public void setTcTAIL(String tcTAIL) {
        this.tcTAIL = tcTAIL;
    }

    public String getTcTASKCARDTYPE() {
        return tcTASKCARDTYPE;
    }

    public void setTcTASKCARDTYPE(String tcTASKCARDTYPE) {
        this.tcTASKCARDTYPE = tcTASKCARDTYPE;
    }

    public String getTcROUTINE() {
        return tcROUTINE;
    }

    public void setTcROUTINE(String tcROUTINE) {
        this.tcROUTINE = tcROUTINE;
    }

    public String getTcOPERATOR() {
        return tcOPERATOR;
    }

    public void setTcOPERATOR(String tcOPERATOR) {
        this.tcOPERATOR = tcOPERATOR;
    }

    public String getTcDISCREPANCYID() {
        return tcDISCREPANCYID;
    }

    public void setTcDISCREPANCYID(String tcDISCREPANCYID) {
        this.tcDISCREPANCYID = tcDISCREPANCYID;
    }

    public String getTcCORRECTIVEID() {
        return tcCORRECTIVEID;
    }

    public void setTcCORRECTIVEID(String tcCORRECTIVEID) {
        this.tcCORRECTIVEID = tcCORRECTIVEID;
    }
    
}
