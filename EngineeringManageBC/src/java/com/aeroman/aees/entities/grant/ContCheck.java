/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities.grant;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.NotNull;

/**
 *
 * @author Usuario
 */
@Entity
@Cacheable(false)
@Table(name = "CONT_CHECK", catalog = "", schema = "CONT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContCheck.findAll", query = "SELECT c FROM ContCheck c"),
    @NamedQuery(name = "ContCheck.findByContCheckId", query = "SELECT c FROM ContCheck c WHERE c.contCheckId = :contCheckId"),
    @NamedQuery(name = "ContCheck.findByChkModel", query = "SELECT c FROM ContCheck c WHERE c.chkModel = :chkModel"),
    @NamedQuery(name = "ContCheck.findByChkRegistry", query = "SELECT c FROM ContCheck c WHERE c.chkRegistry = :chkRegistry"),
    @NamedQuery(name = "ContCheck.findByChkStartdate", query = "SELECT c FROM ContCheck c WHERE c.chkStartdate = :chkStartdate"),
    @NamedQuery(name = "ContCheck.findByChkFinishdate", query = "SELECT c FROM ContCheck c WHERE c.chkFinishdate = :chkFinishdate"),
    @NamedQuery(name = "ContCheck.findByChkTtsn", query = "SELECT c FROM ContCheck c WHERE c.chkTtsn = :chkTtsn"),
    @NamedQuery(name = "ContCheck.findByChkTcsn", query = "SELECT c FROM ContCheck c WHERE c.chkTcsn = :chkTcsn"),
    @NamedQuery(name = "ContCheck.findByChkVn", query = "SELECT c FROM ContCheck c WHERE c.chkVn = :chkVn"),
    @NamedQuery(name = "ContCheck.findByChkLn", query = "SELECT c FROM ContCheck c WHERE c.chkLn = :chkLn"),
    @NamedQuery(name = "ContCheck.findByChkSn", query = "SELECT c FROM ContCheck c WHERE c.chkSn = :chkSn"),
    @NamedQuery(name = "ContCheck.findByChkBn", query = "SELECT c FROM ContCheck c WHERE c.chkBn = :chkBn"),
    @NamedQuery(name = "ContCheck.findByChkChecktype", query = "SELECT c FROM ContCheck c WHERE c.chkChecktype = :chkChecktype"),
    @NamedQuery(name = "ContCheck.findByChkUserc", query = "SELECT c FROM ContCheck c WHERE c.chkUserc = :chkUserc"),
    @NamedQuery(name = "ContCheck.findByChkClosed", query = "SELECT c FROM ContCheck c WHERE c.chkClosed = :chkClosed"),
    @NamedQuery(name = "ContCheck.findByChkCorrtype", query = "SELECT c FROM ContCheck c WHERE c.chkCorrtype = :chkCorrtype"),
    @NamedQuery(name = "ContCheck.findByChkChecktype1", query = "SELECT c FROM ContCheck c WHERE c.chkChecktype1 = :chkChecktype1"),
    @NamedQuery(name = "ContCheck.findByChkDhistorica", query = "SELECT c FROM ContCheck c WHERE c.chkDhistorica = :chkDhistorica"),
    @NamedQuery(name = "ContCheck.findByChkWo", query = "SELECT c FROM ContCheck c WHERE c.chkWo = :chkWo"),
    @NamedQuery(name = "ContCheck.findByChkArrivaldate", query = "SELECT c FROM ContCheck c WHERE c.chkArrivaldate = :chkArrivaldate"),
    @NamedQuery(name = "ContCheck.findByChkGroundtime", query = "SELECT c FROM ContCheck c WHERE c.chkGroundtime = :chkGroundtime"),
    @NamedQuery(name = "ContCheck.findByChkHangmanrespon", query = "SELECT c FROM ContCheck c WHERE c.chkHangmanrespon = :chkHangmanrespon"),
    @NamedQuery(name = "ContCheck.findByChkHangrespon", query = "SELECT c FROM ContCheck c WHERE c.chkHangrespon = :chkHangrespon"),
    @NamedQuery(name = "ContCheck.findByChkCommrespon", query = "SELECT c FROM ContCheck c WHERE c.chkCommrespon = :chkCommrespon"),
    @NamedQuery(name = "ContCheck.findByChkProdcontrespon", query = "SELECT c FROM ContCheck c WHERE c.chkProdcontrespon = :chkProdcontrespon"),
    @NamedQuery(name = "ContCheck.findByChkWarehrespon", query = "SELECT c FROM ContCheck c WHERE c.chkWarehrespon = :chkWarehrespon"),
    @NamedQuery(name = "ContCheck.findByChkShopsrespon", query = "SELECT c FROM ContCheck c WHERE c.chkShopsrespon = :chkShopsrespon"),
    @NamedQuery(name = "ContCheck.findByChkPurchrespon", query = "SELECT c FROM ContCheck c WHERE c.chkPurchrespon = :chkPurchrespon"),
    @NamedQuery(name = "ContCheck.findByChkPlannrespon", query = "SELECT c FROM ContCheck c WHERE c.chkPlannrespon = :chkPlannrespon"),
    @NamedQuery(name = "ContCheck.findByChkEnginrespon", query = "SELECT c FROM ContCheck c WHERE c.chkEnginrespon = :chkEnginrespon"),
    @NamedQuery(name = "ContCheck.findByChkPowplantres", query = "SELECT c FROM ContCheck c WHERE c.chkPowplantres = :chkPowplantres"),
    @NamedQuery(name = "ContCheck.findByChkQarespon", query = "SELECT c FROM ContCheck c WHERE c.chkQarespon = :chkQarespon"),
    @NamedQuery(name = "ContCheck.findByChkQcrespon", query = "SELECT c FROM ContCheck c WHERE c.chkQcrespon = :chkQcrespon"),
    @NamedQuery(name = "ContCheck.findByChkMsn", query = "SELECT c FROM ContCheck c WHERE c.chkMsn = :chkMsn"),
    @NamedQuery(name = "ContCheck.findByChkYear", query = "SELECT c FROM ContCheck c WHERE c.chkYear = :chkYear"),
    @NamedQuery(name = "ContCheck.findByChkEngManHrs", query = "SELECT c FROM ContCheck c WHERE c.chkEngManHrs = :chkEngManHrs"),
    @NamedQuery(name = "ContCheck.findByChkIdengact", query = "SELECT c FROM ContCheck c WHERE c.chkIdengact = :chkIdengact"),
    @NamedQuery(name = "ContCheck.findByChkClosedEng", query = "SELECT c FROM ContCheck c WHERE c.chkClosedEng = :chkClosedEng"),
    @NamedQuery(name = "ContCheck.findByChkDescription", query = "SELECT c FROM ContCheck c WHERE c.chkDescription = :chkDescription"),
    @NamedQuery(name = "ContCheck.findByChkUsrIns", query = "SELECT c FROM ContCheck c WHERE c.chkUsrIns = :chkUsrIns"),
    @NamedQuery(name = "ContCheck.findByChkDateIns", query = "SELECT c FROM ContCheck c WHERE c.chkDateIns = :chkDateIns"),
    @NamedQuery(name = "ContCheck.findByChkUsrUpd", query = "SELECT c FROM ContCheck c WHERE c.chkUsrUpd = :chkUsrUpd"),
    @NamedQuery(name = "ContCheck.findByChkDateUpd", query = "SELECT c FROM ContCheck c WHERE c.chkDateUpd = :chkDateUpd"),
    @NamedQuery(name = "ContCheck.findByChkWoYear", query = "SELECT c FROM ContCheck c WHERE c.chkWoYear = :chkWoYear"),
    @NamedQuery(name = "ContCheck.findByChkWoCorr", query = "SELECT c FROM ContCheck c WHERE c.chkWoCorr = :chkWoCorr"),
    @NamedQuery(name = "ContCheck.findByChkWoItem", query = "SELECT c FROM ContCheck c WHERE c.chkWoItem = :chkWoItem"),
    @NamedQuery(name = "ContCheck.findByChkAc", query = "SELECT c FROM ContCheck c WHERE c.chkAc = :chkAc"),
    @NamedQuery(name = "ContCheck.findByChkCucod", query = "SELECT c FROM ContCheck c WHERE c.chkCucod = :chkCucod"),
    @NamedQuery(name = "ContCheck.findByCheckCompany", query = "SELECT c FROM ContCheck c WHERE c.CheckCompany = :CheckCompany"),
    @NamedQuery(name = "ContCheck.findByChkHangarDef", query = "SELECT c FROM ContCheck c WHERE c.ChkHangarDef = :ChkHangarDef")})
public class ContCheck implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONT_CHECK_ID")
    private BigDecimal contCheckId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CHK_MODEL")
    private String chkModel;
    @Size(max = 20)
    @Column(name = "CHK_REGISTRY")
    private String chkRegistry;
    @Column(name = "CHK_STARTDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date chkStartdate;
    @Column(name = "CHK_FINISHDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date chkFinishdate;
    @Column(name = "CHK_TTSN")
    private BigDecimal chkTtsn;
    @Column(name = "CHK_TCSN")
    private Integer chkTcsn;
    @Size(max = 22)
    @Column(name = "CHK_VN")
    private String chkVn;
    @Size(max = 22)
    @Column(name = "CHK_LN")
    private String chkLn;
    @Size(max = 22)
    @Column(name = "CHK_SN")
    private String chkSn;
    @Size(max = 22)
    @Column(name = "CHK_BN")
    private String chkBn;
    @Size(max = 50)
    @Column(name = "CHK_CHECKTYPE")
    private String chkChecktype;
    @Size(max = 100)
    @Column(name = "CHK_USERC")
    private String chkUserc;
    @Size(max = 1)
    @Column(name = "CHK_CLOSED")
    private String chkClosed;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CHK_CORRTYPE")
    private BigDecimal chkCorrtype;
    @Size(max = 50)
    @Column(name = "CHK_CHECKTYPE_1")
    private String chkChecktype1;
    @Size(max = 1)
    @Column(name = "CHK_DHISTORICA")
    private String chkDhistorica;
    @Size(max = 50)
    @Column(name = "CHK_WO")
    private String chkWo;
    @Column(name = "CHK_ARRIVALDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date chkArrivaldate;
    @Size(max = 20)
    @Column(name = "CHK_GROUNDTIME")
    private String chkGroundtime;
    @Size(max = 30)
    @Column(name = "CHK_HANGMANRESPON")
    private String chkHangmanrespon;
    @Size(max = 30)
    @Column(name = "CHK_HANGRESPON")
    private String chkHangrespon;
    @Size(max = 30)
    @Column(name = "CHK_COMMRESPON")
    private String chkCommrespon;
    @Size(max = 30)
    @Column(name = "CHK_PRODCONTRESPON")
    private String chkProdcontrespon;
    @Size(max = 30)
    @Column(name = "CHK_WAREHRESPON")
    private String chkWarehrespon;
    @Size(max = 30)
    @Column(name = "CHK_SHOPSRESPON")
    private String chkShopsrespon;
    @Size(max = 30)
    @Column(name = "CHK_PURCHRESPON")
    private String chkPurchrespon;
    @Size(max = 30)
    @Column(name = "CHK_PLANNRESPON")
    private String chkPlannrespon;
    @Size(max = 30)
    @Column(name = "CHK_ENGINRESPON")
    private String chkEnginrespon;
    @Size(max = 30)
    @Column(name = "CHK_POWPLANTRES")
    private String chkPowplantres;
    @Size(max = 30)
    @Column(name = "CHK_QARESPON")
    private String chkQarespon;
    @Size(max = 30)
    @Column(name = "CHK_QCRESPON")
    private String chkQcrespon;
    @Size(max = 22)
    @Column(name = "CHK_MSN")
    private String chkMsn;
    @Size(max = 4)
    @Column(name = "CHK_YEAR")
    private String chkYear;
    @Column(name = "CHK_ENG_MAN_HRS")
    private double chkEngManHrs;
    @Column(name = "CHK_IDENGACT")
    private BigDecimal chkIdengact;
    @Size(max = 1)
    @Column(name = "CHK_CLOSED_ENG")
    private String chkClosedEng;
    @Size(max = 20)
    @Column(name = "CHK_DESCRIPTION")
    private String chkDescription;
    @Size(max = 30)
    @Column(name = "CHK_USR_INS")
    private String chkUsrIns;
    @Column(name = "CHK_DATE_INS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date chkDateIns;
    @Size(max = 30)
    @Column(name = "CHK_USR_UPD")
    private String chkUsrUpd;
    @Column(name = "CHK_DATE_UPD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date chkDateUpd;
    @Column(name = "CHK_WO_YEAR")
    private BigDecimal chkWoYear;
    @Column(name = "CHK_WO_CORR")
    private Integer chkWoCorr;
    @Column(name = "CHK_WO_ITEM")
    private BigDecimal chkWoItem;
    @Size(max = 30)
    @Column(name = "CHK_AC")
    private String chkAc;
    @Size(max = 10)
    @Column(name = "CHK_CUCOD")
    private String chkCucod;
    @Size(max = 50)
    @Column(name = "CHECK_COMPANY")
    private String CheckCompany;
    @Size(max = 100)
    @Column(name = "CHK_HANGAR_DEF")
    private String ChkHangarDef;
    @Column(name = "MANUFACTURER")
    private String manufacturer;
    

    public ContCheck() {
        super();
    }

    public ContCheck(BigDecimal contCheckId) {
        this.contCheckId = contCheckId;
    }

    public ContCheck(BigDecimal contCheckId, String chkModel, BigDecimal chkCorrtype) {
        this.contCheckId = contCheckId;
        this.chkModel = chkModel;
        this.chkCorrtype = chkCorrtype;
    }

    public BigDecimal getContCheckId() {
        return contCheckId;
    }

    public void setContCheckId(BigDecimal contCheckId) {
        this.contCheckId = contCheckId;
    }

    public String getChkModel() {
        return chkModel;
    }

    public void setChkModel(String chkModel) {
        this.chkModel = chkModel;
    }

    public String getChkRegistry() {
        return chkRegistry;
    }

    public void setChkRegistry(String chkRegistry) {
        this.chkRegistry = chkRegistry;
    }

    public Date getChkStartdate() {
        return chkStartdate;
    }

    public void setChkStartdate(Date chkStartdate) {
        this.chkStartdate = chkStartdate;
    }

    public Date getChkFinishdate() {
        return chkFinishdate;
    }

    public void setChkFinishdate(Date chkFinishdate) {
        this.chkFinishdate = chkFinishdate;
    }

    public BigDecimal getChkTtsn() {
        return chkTtsn;
    }

    public void setChkTtsn(BigDecimal chkTtsn) {
        this.chkTtsn = chkTtsn;
    }

    public Integer getChkTcsn() {
        return chkTcsn;
    }

    public void setChkTcsn(Integer chkTcsn) {
        this.chkTcsn = chkTcsn;
    }

    public String getChkVn() {
        return chkVn;
    }

    public void setChkVn(String chkVn) {
        this.chkVn = chkVn;
    }

    public String getChkLn() {
        return chkLn;
    }

    public void setChkLn(String chkLn) {
        this.chkLn = chkLn;
    }

    public String getChkSn() {
        return chkSn;
    }

    public void setChkSn(String chkSn) {
        this.chkSn = chkSn;
    }

    public String getChkBn() {
        return chkBn;
    }

    public void setChkBn(String chkBn) {
        this.chkBn = chkBn;
    }

    public String getChkChecktype() {
        return chkChecktype;
    }

    public void setChkChecktype(String chkChecktype) {
        this.chkChecktype = chkChecktype;
    }

    public String getChkUserc() {
        return chkUserc;
    }

    public void setChkUserc(String chkUserc) {
        this.chkUserc = chkUserc;
    }

    public String getChkClosed() {
        return chkClosed;
    }

    public void setChkClosed(String chkClosed) {
        this.chkClosed = chkClosed;
    }

    public BigDecimal getChkCorrtype() {
        return chkCorrtype;
    }

    public void setChkCorrtype(BigDecimal chkCorrtype) {
        this.chkCorrtype = chkCorrtype;
    }

    public String getChkChecktype1() {
        return chkChecktype1;
    }

    public void setChkChecktype1(String chkChecktype1) {
        this.chkChecktype1 = chkChecktype1;
    }

    public String getChkDhistorica() {
        return chkDhistorica;
    }

    public void setChkDhistorica(String chkDhistorica) {
        this.chkDhistorica = chkDhistorica;
    }

    public String getChkWo() {
        return chkWo;
    }

    public void setChkWo(String chkWo) {
        this.chkWo = chkWo;
    }

    public Date getChkArrivaldate() {
        return chkArrivaldate;
    }

    public void setChkArrivaldate(Date chkArrivaldate) {
        this.chkArrivaldate = chkArrivaldate;
    }

    public String getChkGroundtime() {
        return chkGroundtime;
    }

    public void setChkGroundtime(String chkGroundtime) {
        this.chkGroundtime = chkGroundtime;
    }

    public String getChkHangmanrespon() {
        return chkHangmanrespon;
    }

    public void setChkHangmanrespon(String chkHangmanrespon) {
        this.chkHangmanrespon = chkHangmanrespon;
    }

    public String getChkHangrespon() {
        return chkHangrespon;
    }

    public void setChkHangrespon(String chkHangrespon) {
        this.chkHangrespon = chkHangrespon;
    }

    public String getChkCommrespon() {
        return chkCommrespon;
    }

    public void setChkCommrespon(String chkCommrespon) {
        this.chkCommrespon = chkCommrespon;
    }

    public String getChkProdcontrespon() {
        return chkProdcontrespon;
    }

    public void setChkProdcontrespon(String chkProdcontrespon) {
        this.chkProdcontrespon = chkProdcontrespon;
    }

    public String getChkWarehrespon() {
        return chkWarehrespon;
    }

    public void setChkWarehrespon(String chkWarehrespon) {
        this.chkWarehrespon = chkWarehrespon;
    }

    public String getChkShopsrespon() {
        return chkShopsrespon;
    }

    public void setChkShopsrespon(String chkShopsrespon) {
        this.chkShopsrespon = chkShopsrespon;
    }

    public String getChkPurchrespon() {
        return chkPurchrespon;
    }

    public void setChkPurchrespon(String chkPurchrespon) {
        this.chkPurchrespon = chkPurchrespon;
    }

    public String getChkPlannrespon() {
        return chkPlannrespon;
    }

    public void setChkPlannrespon(String chkPlannrespon) {
        this.chkPlannrespon = chkPlannrespon;
    }

    public String getChkEnginrespon() {
        return chkEnginrespon;
    }

    public void setChkEnginrespon(String chkEnginrespon) {
        this.chkEnginrespon = chkEnginrespon;
    }

    public String getChkPowplantres() {
        return chkPowplantres;
    }

    public void setChkPowplantres(String chkPowplantres) {
        this.chkPowplantres = chkPowplantres;
    }

    public String getChkQarespon() {
        return chkQarespon;
    }

    public void setChkQarespon(String chkQarespon) {
        this.chkQarespon = chkQarespon;
    }

    public String getChkQcrespon() {
        return chkQcrespon;
    }

    public void setChkQcrespon(String chkQcrespon) {
        this.chkQcrespon = chkQcrespon;
    }

    public String getChkMsn() {
        return chkMsn;
    }

    public void setChkMsn(String chkMsn) {
        this.chkMsn = chkMsn;
    }

    public String getChkYear() {
        return chkYear;
    }

    public void setChkYear(String chkYear) {
        this.chkYear = chkYear;
    }

    public double getChkEngManHrs() {
        return chkEngManHrs;
    }

    public void setChkEngManHrs(double chkEngManHrs) {
        this.chkEngManHrs = chkEngManHrs;
    }

    public BigDecimal getChkIdengact() {
        return chkIdengact;
    }

    public void setChkIdengact(BigDecimal chkIdengact) {
        this.chkIdengact = chkIdengact;
    }

    public String getChkClosedEng() {
        return chkClosedEng;
    }

    public void setChkClosedEng(String chkClosedEng) {
        this.chkClosedEng = chkClosedEng;
    }

    public String getChkDescription() {
        return chkDescription;
    }

    public void setChkDescription(String chkDescription) {
        this.chkDescription = chkDescription;
    }

    public String getChkUsrIns() {
        return chkUsrIns;
    }

    public void setChkUsrIns(String chkUsrIns) {
        this.chkUsrIns = chkUsrIns;
    }

    public Date getChkDateIns() {
        return chkDateIns;
    }

    public void setChkDateIns(Date chkDateIns) {
        this.chkDateIns = chkDateIns;
    }

    public String getChkUsrUpd() {
        return chkUsrUpd;
    }

    public void setChkUsrUpd(String chkUsrUpd) {
        this.chkUsrUpd = chkUsrUpd;
    }

    public Date getChkDateUpd() {
        return chkDateUpd;
    }

    public void setChkDateUpd(Date chkDateUpd) {
        this.chkDateUpd = chkDateUpd;
    }

    public BigDecimal getChkWoYear() {
        return chkWoYear;
    }

    public void setChkWoYear(BigDecimal chkWoYear) {
        this.chkWoYear = chkWoYear;
    }

    public Integer getChkWoCorr() {
        return chkWoCorr;
    }

    public void setChkWoCorr(Integer chkWoCorr) {
        this.chkWoCorr = chkWoCorr;
    }

    public BigDecimal getChkWoItem() {
        return chkWoItem;
    }

    public void setChkWoItem(BigDecimal chkWoItem) {
        this.chkWoItem = chkWoItem;
    }

    public String getChkAc() {
        return chkAc;
    }

    public void setChkAc(String chkAc) {
        this.chkAc = chkAc;
    }

    public String getChkCucod() {
        return chkCucod;
    }

    public void setChkCucod(String chkCucod) {
        this.chkCucod = chkCucod;
    }

    public String getCheckCompany() {
        return CheckCompany;
    }

    public void setCheckCompany(String CheckCompany) {
        this.CheckCompany = CheckCompany;
    }

    public String getChkHangarDef() {
        return ChkHangarDef;
    }

    public void setChkHangarDef(String ChkHangarDef) {
        this.ChkHangarDef = ChkHangarDef;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contCheckId != null ? contCheckId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof ContCheck)) {
            return false;
        }
        ContCheck other = (ContCheck) object;
        if ((this.contCheckId == null && other.contCheckId != null) || (this.contCheckId != null && !this.contCheckId.equals(other.contCheckId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.ContCheck[ contCheckId=" + contCheckId + " ]";
    }
    
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
