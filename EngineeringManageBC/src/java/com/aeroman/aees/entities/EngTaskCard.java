/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ssibrian
 */
@Entity
@Cacheable(false)
@Table(name = "ENG_TASK_CARD", catalog = "", schema = "CONT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngTaskCard.findAll", query = "SELECT e FROM EngTaskCard e"),
    @NamedQuery(name = "EngTaskCard.findByIdCard", query = "SELECT e FROM EngTaskCard e WHERE e.idCard = :idCard"),
    @NamedQuery(name = "EngTaskCard.findByChkCheckid", query = "SELECT e FROM EngTaskCard e WHERE e.chkCheckid = :chkCheckid"),
    @NamedQuery(name = "EngTaskCard.findByTcYear", query = "SELECT e FROM EngTaskCard e WHERE e.tcYear = :tcYear"),
    @NamedQuery(name = "EngTaskCard.findByTcCorr", query = "SELECT e FROM EngTaskCard e WHERE e.tcCorr = :tcCorr"),
    @NamedQuery(name = "EngTaskCard.findByTcDescription", query = "SELECT e FROM EngTaskCard e WHERE e.tcDescription = :tcDescription")})
public class EngTaskCard implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CARD")
    private Integer idCard;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CHK_CHECKID")
    private int chkCheckid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TC_YEAR")
    private short tcYear;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TC_CORR")
    private int tcCorr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "TC_DESCRIPTION")
    private String tcDescription;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCard")
    private List<EngReqTaskCard> engReqTaskCardList;

    public EngTaskCard() {
        super();
    }

    public EngTaskCard(Integer idCard) {
        this.idCard = idCard;
    }

    public EngTaskCard(Integer idCard, int chkCheckid, short tcYear, int tcCorr, String tcDescription) {
        this.idCard = idCard;
        this.chkCheckid = chkCheckid;
        this.tcYear = tcYear;
        this.tcCorr = tcCorr;
        this.tcDescription = tcDescription;
    }

    public Integer getIdCard() {
        return idCard;
    }

    public void setIdCard(Integer idCard) {
        this.idCard = idCard;
    }

    public int getChkCheckid() {
        return chkCheckid;
    }

    public void setChkCheckid(int chkCheckid) {
        this.chkCheckid = chkCheckid;
    }

    public short getTcYear() {
        return tcYear;
    }

    public void setTcYear(short tcYear) {
        this.tcYear = tcYear;
    }

    public int getTcCorr() {
        return tcCorr;
    }

    public void setTcCorr(int tcCorr) {
        this.tcCorr = tcCorr;
    }

    public String getTcDescription() {
        return tcDescription;
    }

    public void setTcDescription(String tcDescription) {
        this.tcDescription = tcDescription;
    }

    @XmlTransient
    public List<EngReqTaskCard> getEngReqTaskCardList() {
        return engReqTaskCardList;
    }

    public void setEngReqTaskCardList(List<EngReqTaskCard> engReqTaskCardList) {
        this.engReqTaskCardList = engReqTaskCardList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCard != null ? idCard.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EngTaskCard)) {
            return false;
        }
        EngTaskCard other = (EngTaskCard) object;
        if ((this.idCard == null && other.idCard != null) || (this.idCard != null && !this.idCard.equals(other.idCard))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngTaskCard[ idCard=" + idCard + " ]";
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
