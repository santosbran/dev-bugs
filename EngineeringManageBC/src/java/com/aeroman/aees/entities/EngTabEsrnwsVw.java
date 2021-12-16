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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vjuarez
 */
@Entity
@Cacheable(false)
@Table(name = "ENG_TAB_ESRNWS_VW")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngTabEsrnwsVw.findAll", query = "SELECT e FROM EngTabEsrnwsVw e"),
    @NamedQuery(name = "EngTabEsrnwsVw.findByDisplayCol1", query = "SELECT e FROM EngTabEsrnwsVw e WHERE e.displayCol1 = :displayCol1"),
    @NamedQuery(name = "EngTabEsrnwsVw.findByReqMessageid", query = "SELECT e FROM EngTabEsrnwsVw e WHERE e.reqMessageid = :reqMessageid"),
    @NamedQuery(name = "EngTabEsrnwsVw.findByProbdesc", query = "SELECT e FROM EngTabEsrnwsVw e WHERE e.probdesc = :probdesc"),
    @NamedQuery(name = "EngTabEsrnwsVw.findByEsr", query = "SELECT e FROM EngTabEsrnwsVw e WHERE e.esr = :esr"),
    @NamedQuery(name = "EngTabEsrnwsVw.findByIssuedate", query = "SELECT e FROM EngTabEsrnwsVw e WHERE e.issuedate = :issuedate"),
    @NamedQuery(name = "EngTabEsrnwsVw.findByDisposition", query = "SELECT e FROM EngTabEsrnwsVw e WHERE e.disposition = :disposition"),
    @NamedQuery(name = "EngTabEsrnwsVw.findByNumata", query = "SELECT e FROM EngTabEsrnwsVw e WHERE e.numata = :numata"),
    @NamedQuery(name = "EngTabEsrnwsVw.findByClasrepair", query = "SELECT e FROM EngTabEsrnwsVw e WHERE e.clasrepair = :clasrepair"),
    @NamedQuery(name = "EngTabEsrnwsVw.findByReqStatus", query = "SELECT e FROM EngTabEsrnwsVw e WHERE e.reqStatus = :reqStatus"),
    @NamedQuery(name = "EngTabEsrnwsVw.findByReqIngeniero", query = "SELECT e FROM EngTabEsrnwsVw e WHERE e.reqIngeniero = :reqIngeniero"),
    @NamedQuery(name = "EngTabEsrnwsVw.findByAirCraft", query = "SELECT e FROM EngTabEsrnwsVw e WHERE e.airCraft = :airCraft"),
    @NamedQuery(name = "EngTabEsrnwsVw.findBycodigo86", query = "SELECT e FROM EngTabEsrnwsVw e WHERE e.codigo86 = :codigo86"),
    @NamedQuery(name = "EngTabEsrnwsVw.findBychkWo", query = "SELECT e FROM EngTabEsrnwsVw e WHERE e.chkWo = :chkWo"),
    @NamedQuery(name = "EngTabEsrnwsVw.findByreqJobcard", query = "SELECT e FROM EngTabEsrnwsVw e WHERE e.reqJobcard = :reqJobcard"),
    @NamedQuery(name = "EngTabEsrnwsVw.findByreqCodIngEnc", query = "SELECT e FROM EngTabEsrnwsVw e WHERE e.reqCodIngEnc = :reqCodIngEnc"),
    @NamedQuery(name = "EngTabEsrnwsVw.findByActor", query = "SELECT e FROM EngTabEsrnwsVw e WHERE e.actor = :actor"),
    @NamedQuery(name = "EngTabEsrnwsVw.findByCompany", query = "SELECT e FROM EngTabEsrnwsVw e WHERE e.company = :company"),
    @NamedQuery(name = "EngTabEsrnwsVw.findByCard", query = "SELECT e FROM EngTabEsrnwsVw e WHERE e.card = :card"),
    @NamedQuery(name = "EngTabEsrnwsVw.findByreview", query = "SELECT e FROM EngTabEsrnwsVw e WHERE e.review = :review"),
    @NamedQuery(name = "EngTabEsrnwsVw.findByrolUser", query = "SELECT e FROM EngTabEsrnwsVw e WHERE e.rolUser = :rolUser")}) 
public class EngTabEsrnwsVw implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "DISPLAY_COL1")
    private BigInteger displayCol1;
    @Column(name = "CHECKID")
    private BigDecimal checkid;
    @Id
    @Basic(optional = false)   
    @Column(name = "REQ_MESSAGEID")
    private BigInteger reqMessageid;
    @Size(max = 4000)
    @Column(name = "PROBDESC")
    private String probdesc;
    @Size(max = 54)
    @Column(name = "ESR")
    private String esr;
    @Column(name = "ISSUEDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date issuedate;
    @Size(max = 4000)
    @Column(name = "DISPOSITION")
    private String disposition;
    @Size(max = 4000)
    @Column(name = "NUMATA")
    private String numata;
    @Size(max = 4000)
    @Column(name = "CLASREPAIR")
    private String clasrepair;
    @Size(max = 3)
    @Column(name = "REQ_STATUS")
    private String reqStatus;
    @Size(max = 4000)
    @Column(name = "REQ_INGENIERO")
    private String reqIngeniero;
    @Size(max = 40)
    @Column(name = "AIRCRAFT")
    private String airCraft;
    @Size(max = 40)
    @Column(name = "CODIGO86")
    private String codigo86;
    @Size(max = 40)
    @Column(name = "CHK_WO")
    private String chkWo;
    @Size(max = 4000)
    @Column(name = "REQ_JOBCARD")
    private String reqJobcard;
    @Size(max = 4000)
    @Column(name = "REQ_COD_ING_ENC")
    private String reqCodIngEnc;
    @Size(max = 4000)
    @Column(name = "ACTOR")
    private String actor;
    @Size(max = 50)
    @Column(name = "COMPANY")
    private String company;
    @Size(max = 4000)
    @Column(name = "CARD")
    private String card;
    @Size(max = 5)
    @Column(name = "REVIEW")
    private String review;
    @Size(max = 50)
    @Column(name = "ROL_USER")
    private String rolUser; 
    @Column(name = "TIPO_SOLICITUD")
    private String tipoSolicitud; 
    
    public EngTabEsrnwsVw() {
        super();
    }

    public BigInteger getDisplayCol1() {
        return displayCol1;
    }

    public void setDisplayCol1(BigInteger displayCol1) {
        this.displayCol1 = displayCol1;
    }

    public BigInteger getReqMessageid() {
        return reqMessageid;
    }

    public void setReqMessageid(BigInteger reqMessageid) {
        this.reqMessageid = reqMessageid;
    }

    public String getProbdesc() {
        return probdesc;
    }

    public void setProbdesc(String probdesc) {
        this.probdesc = probdesc;
    }

    public String getEsr() {
        return esr;
    }

    public void setEsr(String esr) {
        this.esr = esr;
    }

    public Date getIssuedate() {
        return issuedate;
    }

    public void setIssuedate(Date issuedate) {
        this.issuedate = issuedate;
    }

    public String getDisposition() {
        return disposition;
    }

    public void setDisposition(String disposition) {
        this.disposition = disposition;
    }

    public String getNumata() {
        return numata;
    }

    public void setNumata(String numata) {
        this.numata = numata;
    }

    public String getClasrepair() {
        return clasrepair;
    }

    public void setClasrepair(String clasrepair) {
        this.clasrepair = clasrepair;
    }

    public String getReqStatus() {
        return reqStatus;
    }

    public void setReqStatus(String reqStatus) {
        this.reqStatus = reqStatus;
    }

    public String getReqIngeniero() {
        return reqIngeniero;
    }

    public void setReqIngeniero(String reqIngeniero) {
        this.reqIngeniero = reqIngeniero;
    }

    public String getAirCraft() {
        return airCraft;
    }

    public void setAirCraft(String airCraft) {
        this.airCraft = airCraft;
    } 

    public String getCodigo86() {
        return codigo86;
    }

    public void setCodigo86(String codigo86) {
        this.codigo86 = codigo86;
    }

    public String getChkWo() {
        return chkWo;
    }

    public void setChkWo(String chkWo) {
        this.chkWo = chkWo;
    }

    public String getReqJobcard() {
        return reqJobcard;
    }

    public void setReqJobcard(String reqJobcard) {
        this.reqJobcard = reqJobcard;
    }

    public String getReqCodIngEnc() {
        return reqCodIngEnc;
    }

    public void setReqCodIngEnc(String reqCodIngEnc) {
        this.reqCodIngEnc = reqCodIngEnc;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public BigDecimal getCheckid() {
        return checkid;
    }

    public void setCheckid(BigDecimal checkid) {
        this.checkid = checkid;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getRolUser() {
        return rolUser;
    }

    public void setRolUser(String rolUser) {
        this.rolUser = rolUser;
    }
    
    public String getTipoSolicitud() {
        return tipoSolicitud;
    }

    public void setTipoSolicitud(String tipoSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
    }

    
    
    
}
