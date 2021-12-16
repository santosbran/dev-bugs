/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities;

import java.io.Serializable;
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
 * @author vjuarez
 */
@Entity
@Cacheable(false)
@Table(name = "SEARCH_ESR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SearchEsr.findAll", query = "SELECT s FROM SearchEsr s")
    , @NamedQuery(name = "SearchEsr.findByReqMessageid", query = "SELECT s FROM SearchEsr s WHERE s.reqMessageid = :reqMessageid")
    , @NamedQuery(name = "SearchEsr.findByChkCheckid", query = "SELECT s FROM SearchEsr s WHERE s.chkCheckid = :chkCheckid")
    , @NamedQuery(name = "SearchEsr.findByReqRegistry", query = "SELECT s FROM SearchEsr s WHERE s.reqRegistry = :reqRegistry")
    , @NamedQuery(name = "SearchEsr.findByAtaNumata", query = "SELECT s FROM SearchEsr s WHERE s.ataNumata = :ataNumata")
    , @NamedQuery(name = "SearchEsr.findByReqCodIngEnc", query = "SELECT s FROM SearchEsr s WHERE s.reqCodIngEnc = :reqCodIngEnc")
    , @NamedQuery(name = "SearchEsr.findByReqPn", query = "SELECT s FROM SearchEsr s WHERE s.reqPn = :reqPn")
    , @NamedQuery(name = "SearchEsr.findByReqAfpId", query = "SELECT s FROM SearchEsr s WHERE s.reqAfpId = :reqAfpId")
    , @NamedQuery(name = "SearchEsr.findByReqEsr", query = "SELECT s FROM SearchEsr s WHERE s.reqEsr = :reqEsr")
    , @NamedQuery(name = "SearchEsr.findByReqAta", query = "SELECT s FROM SearchEsr s WHERE s.reqAta = :reqAta")
    , @NamedQuery(name = "SearchEsr.findByChkModel", query = "SELECT s FROM SearchEsr s WHERE s.chkModel = :chkModel")
    , @NamedQuery(name = "SearchEsr.findByChkWo", query = "SELECT s FROM SearchEsr s WHERE s.chkWo = :chkWo")
    , @NamedQuery(name = "SearchEsr.findByReqCustomer", query = "SELECT s FROM SearchEsr s WHERE s.reqCustomer = :reqCustomer")
    , @NamedQuery(name = "SearchEsr.findByReqCodName", query = "SELECT s FROM SearchEsr s WHERE s.reqCodName = :reqCodName")
    , @NamedQuery(name = "SearchEsr.findByAfpName", query = "SELECT s FROM SearchEsr s WHERE s.afpName = :afpName")
    , @NamedQuery(name = "SearchEsr.findBycompany", query = "SELECT s FROM SearchEsr s WHERE s.company = :company")})
public class SearchEsr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "REQ_MESSAGEID")
    @Id
    private BigInteger reqMessageid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CHK_CHECKID")
    private short chkCheckid;
    @Size(max = 20)
    @Column(name = "REQ_REGISTRY")
    private String reqRegistry;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ATA_NUMATA")
    private short ataNumata;
    @Size(max = 30)
    @Column(name = "REQ_COD_ING_ENC")
    private String reqCodIngEnc;
    @Size(max = 50)
    @Column(name = "REQ_PN")
    private String reqPn;
    @Column(name = "REQ_AFP_ID")
    private BigInteger reqAfpId;
    @Size(max = 54)
    @Column(name = "REQ_ESR")
    private String reqEsr;
    @Size(max = 1041)
    @Column(name = "REQ_ATA")
    private String reqAta;
    @Size(max = 20)
    @Column(name = "CHK_MODEL")
    private String chkModel;
    @Size(max = 50)
    @Column(name = "CHK_WO")
    private String chkWo;
    @Size(max = 20)
    @Column(name = "REQ_CUSTOMER")
    private String reqCustomer;
    @Size(max = 286)
    @Column(name = "REQ_COD_NAME")
    private String reqCodName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "AFP_NAME")
    private String afpName;
    @Size(min = 1, max = 200)
    @Column(name = "COMPANY")
    private String company;

    public SearchEsr() {
        super();
    }

    public BigInteger getReqMessageid() {
        return reqMessageid;
    }

    public void setReqMessageid(BigInteger reqMessageid) {
        this.reqMessageid = reqMessageid;
    }

    public short getChkCheckid() {
        return chkCheckid;
    }

    public void setChkCheckid(short chkCheckid) {
        this.chkCheckid = chkCheckid;
    }

    public String getReqRegistry() {
        return reqRegistry;
    }

    public void setReqRegistry(String reqRegistry) {
        this.reqRegistry = reqRegistry;
    }

    public short getAtaNumata() {
        return ataNumata;
    }

    public void setAtaNumata(short ataNumata) {
        this.ataNumata = ataNumata;
    }

    public String getReqCodIngEnc() {
        return reqCodIngEnc;
    }

    public void setReqCodIngEnc(String reqCodIngEnc) {
        this.reqCodIngEnc = reqCodIngEnc;
    }

    public String getReqPn() {
        return reqPn;
    }

    public void setReqPn(String reqPn) {
        this.reqPn = reqPn;
    }

    public BigInteger getReqAfpId() {
        return reqAfpId;
    }

    public void setReqAfpId(BigInteger reqAfpId) {
        this.reqAfpId = reqAfpId;
    }

    public String getReqEsr() {
        return reqEsr;
    }

    public void setReqEsr(String reqEsr) {
        this.reqEsr = reqEsr;
    }

    public String getReqAta() {
        return reqAta;
    }

    public void setReqAta(String reqAta) {
        this.reqAta = reqAta;
    }

    public String getChkModel() {
        return chkModel;
    }

    public void setChkModel(String chkModel) {
        this.chkModel = chkModel;
    }

    public String getChkWo() {
        return chkWo;
    }

    public void setChkWo(String chkWo) {
        this.chkWo = chkWo;
    }

    public String getReqCustomer() {
        return reqCustomer;
    }

    public void setReqCustomer(String reqCustomer) {
        this.reqCustomer = reqCustomer;
    }

    public String getReqCodName() {
        return reqCodName;
    }

    public void setReqCodName(String reqCodName) {
        this.reqCodName = reqCodName;
    }

    public String getAfpName() {
        return afpName;
    }

    public void setAfpName(String afpName) {
        this.afpName = afpName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
    
}
