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
import javax.persistence.Lob;
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
@Table(name = "ENG_ORDERS_VW")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngOrdersVw.findAll", query = "SELECT e FROM EngOrdersVw e"),
    @NamedQuery(name = "EngOrdersVw.findByEoIdord", query = "SELECT e FROM EngOrdersVw e WHERE e.eoIdord = :eoIdord"),
    @NamedQuery(name = "EngOrdersVw.findByEoRev", query = "SELECT e FROM EngOrdersVw e WHERE e.eoRev = :eoRev"),
    @NamedQuery(name = "EngOrdersVw.findByEoReptType", query = "SELECT e FROM EngOrdersVw e WHERE e.eoReptType = :eoReptType"),
    @NamedQuery(name = "EngOrdersVw.findByEoReptInt", query = "SELECT e FROM EngOrdersVw e WHERE e.eoReptInt = :eoReptInt"),
    @NamedQuery(name = "EngOrdersVw.findByEoRevRecord", query = "SELECT e FROM EngOrdersVw e WHERE e.eoRevRecord = :eoRevRecord"),
    @NamedQuery(name = "EngOrdersVw.findByEoRas", query = "SELECT e FROM EngOrdersVw e WHERE e.eoRas = :eoRas"),
    @NamedQuery(name = "EngOrdersVw.findByEoRevDate", query = "SELECT e FROM EngOrdersVw e WHERE e.eoRevDate = :eoRevDate"),
    @NamedQuery(name = "EngOrdersVw.findByEoStc", query = "SELECT e FROM EngOrdersVw e WHERE e.eoStc = :eoStc"),
    @NamedQuery(name = "EngOrdersVw.findByStsEoCod", query = "SELECT e FROM EngOrdersVw e WHERE e.stsEoCod = :stsEoCod"),
    @NamedQuery(name = "EngOrdersVw.findByEoSubject", query = "SELECT e FROM EngOrdersVw e WHERE e.eoSubject = :eoSubject"),
    @NamedQuery(name = "EngOrdersVw.findByEoSummary", query = "SELECT e FROM EngOrdersVw e WHERE e.eoSummary = :eoSummary"),
    @NamedQuery(name = "EngOrdersVw.findByEoDistlistCmt", query = "SELECT e FROM EngOrdersVw e WHERE e.eoDistlistCmt = :eoDistlistCmt"),
    @NamedQuery(name = "EngOrdersVw.findByEoEngAssmnt", query = "SELECT e FROM EngOrdersVw e WHERE e.eoEngAssmnt = :eoEngAssmnt"),
    @NamedQuery(name = "EngOrdersVw.findByEoWarranty", query = "SELECT e FROM EngOrdersVw e WHERE e.eoWarranty = :eoWarranty"),
    @NamedQuery(name = "EngOrdersVw.findByEoExeDate", query = "SELECT e FROM EngOrdersVw e WHERE e.eoExeDate = :eoExeDate"),
    @NamedQuery(name = "EngOrdersVw.findByEoExeInterval", query = "SELECT e FROM EngOrdersVw e WHERE e.eoExeInterval = :eoExeInterval"),
    @NamedQuery(name = "EngOrdersVw.findByEoIntUnit", query = "SELECT e FROM EngOrdersVw e WHERE e.eoIntUnit = :eoIntUnit"),
    @NamedQuery(name = "EngOrdersVw.findByEoEffectWb", query = "SELECT e FROM EngOrdersVw e WHERE e.eoEffectWb = :eoEffectWb"),
    @NamedQuery(name = "EngOrdersVw.findByEoLbs", query = "SELECT e FROM EngOrdersVw e WHERE e.eoLbs = :eoLbs"),
    @NamedQuery(name = "EngOrdersVw.findByEoLbsIn", query = "SELECT e FROM EngOrdersVw e WHERE e.eoLbsIn = :eoLbsIn"),
    @NamedQuery(name = "EngOrdersVw.findByEoMajorForm", query = "SELECT e FROM EngOrdersVw e WHERE e.eoMajorForm = :eoMajorForm"),
    @NamedQuery(name = "EngOrdersVw.findByEoMinor", query = "SELECT e FROM EngOrdersVw e WHERE e.eoMinor = :eoMinor"),
    @NamedQuery(name = "EngOrdersVw.findByEoMaterials", query = "SELECT e FROM EngOrdersVw e WHERE e.eoMaterials = :eoMaterials"),
    @NamedQuery(name = "EngOrdersVw.findByEoNotRequired", query = "SELECT e FROM EngOrdersVw e WHERE e.eoNotRequired = :eoNotRequired"),
    @NamedQuery(name = "EngOrdersVw.findByEoUpdTecrec", query = "SELECT e FROM EngOrdersVw e WHERE e.eoUpdTecrec = :eoUpdTecrec"),
    @NamedQuery(name = "EngOrdersVw.findByEoIncAffPub", query = "SELECT e FROM EngOrdersVw e WHERE e.eoIncAffPub = :eoIncAffPub"),
    @NamedQuery(name = "EngOrdersVw.findByActCod", query = "SELECT e FROM EngOrdersVw e WHERE e.actCod = :actCod"),
    @NamedQuery(name = "EngOrdersVw.findByEoReqToInspec", query = "SELECT e FROM EngOrdersVw e WHERE e.eoReqToInspec = :eoReqToInspec"),
    @NamedQuery(name = "EngOrdersVw.findByEoComments", query = "SELECT e FROM EngOrdersVw e WHERE e.eoComments = :eoComments"),
    @NamedQuery(name = "EngOrdersVw.findByEoAlertDate", query = "SELECT e FROM EngOrdersVw e WHERE e.eoAlertDate = :eoAlertDate"),
    @NamedQuery(name = "EngOrdersVw.findByEoSpecialTool", query = "SELECT e FROM EngOrdersVw e WHERE e.eoSpecialTool = :eoSpecialTool"),
    @NamedQuery(name = "EngOrdersVw.findByEoNdtequipment", query = "SELECT e FROM EngOrdersVw e WHERE e.eoNdtequipment = :eoNdtequipment"),
    @NamedQuery(name = "EngOrdersVw.findByEoFeedback", query = "SELECT e FROM EngOrdersVw e WHERE e.eoFeedback = :eoFeedback"),
    @NamedQuery(name = "EngOrdersVw.findByEoNewInspInt", query = "SELECT e FROM EngOrdersVw e WHERE e.eoNewInspInt = :eoNewInspInt"),
    @NamedQuery(name = "EngOrdersVw.findByEoOther", query = "SELECT e FROM EngOrdersVw e WHERE e.eoOther = :eoOther"),
    @NamedQuery(name = "EngOrdersVw.findByEoCorrelative", query = "SELECT e FROM EngOrdersVw e WHERE e.eoCorrelative = :eoCorrelative"),
    @NamedQuery(name = "EngOrdersVw.findByEoCreationDate", query = "SELECT e FROM EngOrdersVw e WHERE e.eoCreationDate = :eoCreationDate"),
    @NamedQuery(name = "EngOrdersVw.findByEoYear", query = "SELECT e FROM EngOrdersVw e WHERE e.eoYear = :eoYear"),
    @NamedQuery(name = "EngOrdersVw.findByEoCodpre", query = "SELECT e FROM EngOrdersVw e WHERE e.eoCodpre = :eoCodpre"),
    @NamedQuery(name = "EngOrdersVw.findByAtaNumata", query = "SELECT e FROM EngOrdersVw e WHERE e.ataNumata = :ataNumata"),
    @NamedQuery(name = "EngOrdersVw.findByFltCod", query = "SELECT e FROM EngOrdersVw e WHERE e.fltCod = :fltCod"),
    @NamedQuery(name = "EngOrdersVw.findByPriCod", query = "SELECT e FROM EngOrdersVw e WHERE e.priCod = :priCod"),
    @NamedQuery(name = "EngOrdersVw.findByWtyCod", query = "SELECT e FROM EngOrdersVw e WHERE e.wtyCod = :wtyCod"),
    @NamedQuery(name = "EngOrdersVw.findByEoIdnot", query = "SELECT e FROM EngOrdersVw e WHERE e.eoIdnot = :eoIdnot"),
    @NamedQuery(name = "EngOrdersVw.findByEoManHourCost", query = "SELECT e FROM EngOrdersVw e WHERE e.eoManHourCost = :eoManHourCost"),
    @NamedQuery(name = "EngOrdersVw.findByEoDocType", query = "SELECT e FROM EngOrdersVw e WHERE e.eoDocType = :eoDocType"),
    @NamedQuery(name = "EngOrdersVw.findByEoAd", query = "SELECT e FROM EngOrdersVw e WHERE e.eoAd = :eoAd"),
    @NamedQuery(name = "EngOrdersVw.findByEoCn", query = "SELECT e FROM EngOrdersVw e WHERE e.eoCn = :eoCn"),
    @NamedQuery(name = "EngOrdersVw.findByEoOwner", query = "SELECT e FROM EngOrdersVw e WHERE e.eoOwner = :eoOwner"),
    @NamedQuery(name = "EngOrdersVw.findByEoCodstseo", query = "SELECT e FROM EngOrdersVw e WHERE e.eoCodstseo = :eoCodstseo"),
    @NamedQuery(name = "EngOrdersVw.findByEoMajorref", query = "SELECT e FROM EngOrdersVw e WHERE e.eoMajorref = :eoMajorref"),
    @NamedQuery(name = "EngOrdersVw.findByEoCoc", query = "SELECT e FROM EngOrdersVw e WHERE e.eoCoc = :eoCoc"),
    @NamedQuery(name = "EngOrdersVw.findByEoCompDate", query = "SELECT e FROM EngOrdersVw e WHERE e.eoCompDate = :eoCompDate"),
    @NamedQuery(name = "EngOrdersVw.findByEoRecepDate", query = "SELECT e FROM EngOrdersVw e WHERE e.eoRecepDate = :eoRecepDate"),
    @NamedQuery(name = "EngOrdersVw.findByEoUsrIns", query = "SELECT e FROM EngOrdersVw e WHERE e.eoUsrIns = :eoUsrIns"),
    @NamedQuery(name = "EngOrdersVw.findByEoDateIns", query = "SELECT e FROM EngOrdersVw e WHERE e.eoDateIns = :eoDateIns"),
    @NamedQuery(name = "EngOrdersVw.findByEoUsrUpd", query = "SELECT e FROM EngOrdersVw e WHERE e.eoUsrUpd = :eoUsrUpd"),
    @NamedQuery(name = "EngOrdersVw.findByEoDateUpd", query = "SELECT e FROM EngOrdersVw e WHERE e.eoDateUpd = :eoDateUpd"),
    @NamedQuery(name = "EngOrdersVw.findByCodflt", query = "SELECT e FROM EngOrdersVw e WHERE e.codflt = :codflt"),
    @NamedQuery(name = "EngOrdersVw.findByDescription", query = "SELECT e FROM EngOrdersVw e WHERE e.description = :description"),
    @NamedQuery(name = "EngOrdersVw.findByTipo", query = "SELECT e FROM EngOrdersVw e WHERE e.tipo = :tipo"),
    @NamedQuery(name = "EngOrdersVw.findByCustomerId", query = "SELECT e FROM EngOrdersVw e WHERE e.customerId = :customerId"),
    @NamedQuery(name = "EngOrdersVw.findByCompany", query = "SELECT e FROM EngOrdersVw e WHERE e.company = :company"),
    @NamedQuery(name = "EngOrdersVw.findByUsrIns", query = "SELECT e FROM EngOrdersVw e WHERE e.usrIns = :usrIns"),
    @NamedQuery(name = "EngOrdersVw.findByFechaIns", query = "SELECT e FROM EngOrdersVw e WHERE e.fechaIns = :fechaIns"),
    @NamedQuery(name = "EngOrdersVw.findByUsrAct", query = "SELECT e FROM EngOrdersVw e WHERE e.usrAct = :usrAct"),
    @NamedQuery(name = "EngOrdersVw.findByFechaAct", query = "SELECT e FROM EngOrdersVw e WHERE e.fechaAct = :fechaAct"),
    @NamedQuery(name = "EngOrdersVw.findByActivo", query = "SELECT e FROM EngOrdersVw e WHERE e.activo = :activo")})
public class EngOrdersVw implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EO_IDORD")
    @Id
    private long eoIdord;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EO_REV")
    private short eoRev;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EO_REPT_TYPE")
    private short eoReptType;
    @Size(max = 500)
    @Column(name = "EO_REPT_INT")
    private String eoReptInt;
    @Size(max = 2000)
    @Column(name = "EO_REV_RECORD")
    private String eoRevRecord;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "EO_RAS")
    private String eoRas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EO_REV_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date eoRevDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "EO_STC")
    private String eoStc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "STS_EO_COD")
    private String stsEoCod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "EO_SUBJECT")
    private String eoSubject;
    @Size(max = 4000)
    @Column(name = "EO_SUMMARY")
    private String eoSummary;
    @Size(max = 300)
    @Column(name = "EO_DISTLIST_CMT")
    private String eoDistlistCmt;
    @Size(max = 4000)
    @Column(name = "EO_ENG_ASSMNT")
    private String eoEngAssmnt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "EO_WARRANTY")
    private String eoWarranty;
    @Size(max = 200)
    @Column(name = "EO_EXE_DATE")
    private String eoExeDate;
    @Size(max = 500)
    @Column(name = "EO_EXE_INTERVAL")
    private String eoExeInterval;
    @Size(max = 3)
    @Column(name = "EO_INT_UNIT")
    private String eoIntUnit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "EO_EFFECT_WB")
    private String eoEffectWb;
    @Size(max = 15)
    @Column(name = "EO_LBS")
    private String eoLbs;
    @Size(max = 15)
    @Column(name = "EO_LBS_IN")
    private String eoLbsIn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "EO_MAJOR_FORM")
    private String eoMajorForm;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "EO_MINOR")
    private String eoMinor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "EO_MATERIALS")
    private String eoMaterials;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "EO_NOT_REQUIRED")
    private String eoNotRequired;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "EO_UPD_TECREC")
    private String eoUpdTecrec;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "EO_INC_AFF_PUB")
    private String eoIncAffPub;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "ACT_COD")
    private String actCod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "EO_REQ_TO_INSPEC")
    private String eoReqToInspec;
    @Size(max = 4000)
    @Column(name = "EO_COMMENTS")
    private String eoComments;
    @Column(name = "EO_ALERT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date eoAlertDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "EO_SPECIAL_TOOL")
    private String eoSpecialTool;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "EO_NDTEQUIPMENT")
    private String eoNdtequipment;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "EO_FEEDBACK")
    private String eoFeedback;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "EO_NEW_INSP_INT")
    private String eoNewInspInt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "EO_OTHER")
    private String eoOther;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EO_CORRELATIVE")
    private short eoCorrelative;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EO_CREATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date eoCreationDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EO_YEAR")
    private short eoYear;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "EO_CODPRE")
    private String eoCodpre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ATA_NUMATA")
    private short ataNumata;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "FLT_COD")
    private String fltCod;
    @Column(name = "PRI_COD")
    private Short priCod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "WTY_COD")
    private String wtyCod;
    @Column(name = "EO_IDNOT")
    private Short eoIdnot;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "EO_MAN_HOUR_COST")
    private BigDecimal eoManHourCost;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "EO_DOC_TYPE")
    private String eoDocType;
    @Lob
    @Size(max = 0)
    @Column(name = "EO_SPECIAL_INST")
    private String eoSpecialInst;
    @Size(max = 30)
    @Column(name = "EO_AD")
    private String eoAd;
    @Size(max = 30)
    @Column(name = "EO_CN")
    private String eoCn;
    @Size(max = 32)
    @Column(name = "EO_OWNER")
    private String eoOwner;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "EO_CODSTSEO")
    private String eoCodstseo;
    @Size(max = 10)
    @Column(name = "EO_MAJORREF")
    private String eoMajorref;
    @Column(name = "EO_COC")
    private Character eoCoc;
    @Column(name = "EO_COMP_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date eoCompDate;
    @Column(name = "EO_RECEP_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date eoRecepDate;
    @Size(max = 30)
    @Column(name = "EO_USR_INS")
    private String eoUsrIns;
    @Column(name = "EO_DATE_INS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date eoDateIns;
    @Size(max = 30)
    @Column(name = "EO_USR_UPD")
    private String eoUsrUpd;
    @Column(name = "EO_DATE_UPD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date eoDateUpd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CODFLT")
    private String codflt;
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
    @Size(max = 30)
    @Column(name = "USR_INS")
    private String usrIns;
    @Column(name = "FECHA_INS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIns;
    @Size(max = 30)
    @Column(name = "USR_ACT")
    private String usrAct;
    @Column(name = "FECHA_ACT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAct;
    @Size(max = 1)
    @Column(name = "ACTIVO")
    private String activo;

    public EngOrdersVw() {
        super();
    }

    public long getEoIdord() {
        return eoIdord;
    }

    public void setEoIdord(long eoIdord) {
        this.eoIdord = eoIdord;
    }

    public short getEoRev() {
        return eoRev;
    }

    public void setEoRev(short eoRev) {
        this.eoRev = eoRev;
    }

    public short getEoReptType() {
        return eoReptType;
    }

    public void setEoReptType(short eoReptType) {
        this.eoReptType = eoReptType;
    }

    public String getEoReptInt() {
        return eoReptInt;
    }

    public void setEoReptInt(String eoReptInt) {
        this.eoReptInt = eoReptInt;
    }

    public String getEoRevRecord() {
        return eoRevRecord;
    }

    public void setEoRevRecord(String eoRevRecord) {
        this.eoRevRecord = eoRevRecord;
    }

    public String getEoRas() {
        return eoRas;
    }

    public void setEoRas(String eoRas) {
        this.eoRas = eoRas;
    }

    public Date getEoRevDate() {
        return eoRevDate;
    }

    public void setEoRevDate(Date eoRevDate) {
        this.eoRevDate = eoRevDate;
    }

    public String getEoStc() {
        return eoStc;
    }

    public void setEoStc(String eoStc) {
        this.eoStc = eoStc;
    }

    public String getStsEoCod() {
        return stsEoCod;
    }

    public void setStsEoCod(String stsEoCod) {
        this.stsEoCod = stsEoCod;
    }

    public String getEoSubject() {
        return eoSubject;
    }

    public void setEoSubject(String eoSubject) {
        this.eoSubject = eoSubject;
    }

    public String getEoSummary() {
        return eoSummary;
    }

    public void setEoSummary(String eoSummary) {
        this.eoSummary = eoSummary;
    }

    public String getEoDistlistCmt() {
        return eoDistlistCmt;
    }

    public void setEoDistlistCmt(String eoDistlistCmt) {
        this.eoDistlistCmt = eoDistlistCmt;
    }

    public String getEoEngAssmnt() {
        return eoEngAssmnt;
    }

    public void setEoEngAssmnt(String eoEngAssmnt) {
        this.eoEngAssmnt = eoEngAssmnt;
    }

    public String getEoWarranty() {
        return eoWarranty;
    }

    public void setEoWarranty(String eoWarranty) {
        this.eoWarranty = eoWarranty;
    }

    public String getEoExeDate() {
        return eoExeDate;
    }

    public void setEoExeDate(String eoExeDate) {
        this.eoExeDate = eoExeDate;
    }

    public String getEoExeInterval() {
        return eoExeInterval;
    }

    public void setEoExeInterval(String eoExeInterval) {
        this.eoExeInterval = eoExeInterval;
    }

    public String getEoIntUnit() {
        return eoIntUnit;
    }

    public void setEoIntUnit(String eoIntUnit) {
        this.eoIntUnit = eoIntUnit;
    }

    public String getEoEffectWb() {
        return eoEffectWb;
    }

    public void setEoEffectWb(String eoEffectWb) {
        this.eoEffectWb = eoEffectWb;
    }

    public String getEoLbs() {
        return eoLbs;
    }

    public void setEoLbs(String eoLbs) {
        this.eoLbs = eoLbs;
    }

    public String getEoLbsIn() {
        return eoLbsIn;
    }

    public void setEoLbsIn(String eoLbsIn) {
        this.eoLbsIn = eoLbsIn;
    }

    public String getEoMajorForm() {
        return eoMajorForm;
    }

    public void setEoMajorForm(String eoMajorForm) {
        this.eoMajorForm = eoMajorForm;
    }

    public String getEoMinor() {
        return eoMinor;
    }

    public void setEoMinor(String eoMinor) {
        this.eoMinor = eoMinor;
    }

    public String getEoMaterials() {
        return eoMaterials;
    }

    public void setEoMaterials(String eoMaterials) {
        this.eoMaterials = eoMaterials;
    }

    public String getEoNotRequired() {
        return eoNotRequired;
    }

    public void setEoNotRequired(String eoNotRequired) {
        this.eoNotRequired = eoNotRequired;
    }

    public String getEoUpdTecrec() {
        return eoUpdTecrec;
    }

    public void setEoUpdTecrec(String eoUpdTecrec) {
        this.eoUpdTecrec = eoUpdTecrec;
    }

    public String getEoIncAffPub() {
        return eoIncAffPub;
    }

    public void setEoIncAffPub(String eoIncAffPub) {
        this.eoIncAffPub = eoIncAffPub;
    }

    public String getActCod() {
        return actCod;
    }

    public void setActCod(String actCod) {
        this.actCod = actCod;
    }

    public String getEoReqToInspec() {
        return eoReqToInspec;
    }

    public void setEoReqToInspec(String eoReqToInspec) {
        this.eoReqToInspec = eoReqToInspec;
    }

    public String getEoComments() {
        return eoComments;
    }

    public void setEoComments(String eoComments) {
        this.eoComments = eoComments;
    }

    public Date getEoAlertDate() {
        return eoAlertDate;
    }

    public void setEoAlertDate(Date eoAlertDate) {
        this.eoAlertDate = eoAlertDate;
    }

    public String getEoSpecialTool() {
        return eoSpecialTool;
    }

    public void setEoSpecialTool(String eoSpecialTool) {
        this.eoSpecialTool = eoSpecialTool;
    }

    public String getEoNdtequipment() {
        return eoNdtequipment;
    }

    public void setEoNdtequipment(String eoNdtequipment) {
        this.eoNdtequipment = eoNdtequipment;
    }

    public String getEoFeedback() {
        return eoFeedback;
    }

    public void setEoFeedback(String eoFeedback) {
        this.eoFeedback = eoFeedback;
    }

    public String getEoNewInspInt() {
        return eoNewInspInt;
    }

    public void setEoNewInspInt(String eoNewInspInt) {
        this.eoNewInspInt = eoNewInspInt;
    }

    public String getEoOther() {
        return eoOther;
    }

    public void setEoOther(String eoOther) {
        this.eoOther = eoOther;
    }

    public short getEoCorrelative() {
        return eoCorrelative;
    }

    public void setEoCorrelative(short eoCorrelative) {
        this.eoCorrelative = eoCorrelative;
    }

    public Date getEoCreationDate() {
        return eoCreationDate;
    }

    public void setEoCreationDate(Date eoCreationDate) {
        this.eoCreationDate = eoCreationDate;
    }

    public short getEoYear() {
        return eoYear;
    }

    public void setEoYear(short eoYear) {
        this.eoYear = eoYear;
    }

    public String getEoCodpre() {
        return eoCodpre;
    }

    public void setEoCodpre(String eoCodpre) {
        this.eoCodpre = eoCodpre;
    }

    public short getAtaNumata() {
        return ataNumata;
    }

    public void setAtaNumata(short ataNumata) {
        this.ataNumata = ataNumata;
    }

    public String getFltCod() {
        return fltCod;
    }

    public void setFltCod(String fltCod) {
        this.fltCod = fltCod;
    }

    public Short getPriCod() {
        return priCod;
    }

    public void setPriCod(Short priCod) {
        this.priCod = priCod;
    }

    public String getWtyCod() {
        return wtyCod;
    }

    public void setWtyCod(String wtyCod) {
        this.wtyCod = wtyCod;
    }

    public Short getEoIdnot() {
        return eoIdnot;
    }

    public void setEoIdnot(Short eoIdnot) {
        this.eoIdnot = eoIdnot;
    }

    public BigDecimal getEoManHourCost() {
        return eoManHourCost;
    }

    public void setEoManHourCost(BigDecimal eoManHourCost) {
        this.eoManHourCost = eoManHourCost;
    }

    public String getEoDocType() {
        return eoDocType;
    }

    public void setEoDocType(String eoDocType) {
        this.eoDocType = eoDocType;
    }

    public String getEoSpecialInst() {
        return eoSpecialInst;
    }

    public void setEoSpecialInst(String eoSpecialInst) {
        this.eoSpecialInst = eoSpecialInst;
    }

    public String getEoAd() {
        return eoAd;
    }

    public void setEoAd(String eoAd) {
        this.eoAd = eoAd;
    }

    public String getEoCn() {
        return eoCn;
    }

    public void setEoCn(String eoCn) {
        this.eoCn = eoCn;
    }

    public String getEoOwner() {
        return eoOwner;
    }

    public void setEoOwner(String eoOwner) {
        this.eoOwner = eoOwner;
    }

    public String getEoCodstseo() {
        return eoCodstseo;
    }

    public void setEoCodstseo(String eoCodstseo) {
        this.eoCodstseo = eoCodstseo;
    }

    public String getEoMajorref() {
        return eoMajorref;
    }

    public void setEoMajorref(String eoMajorref) {
        this.eoMajorref = eoMajorref;
    }

    public Character getEoCoc() {
        return eoCoc;
    }

    public void setEoCoc(Character eoCoc) {
        this.eoCoc = eoCoc;
    }

    public Date getEoCompDate() {
        return eoCompDate;
    }

    public void setEoCompDate(Date eoCompDate) {
        this.eoCompDate = eoCompDate;
    }

    public Date getEoRecepDate() {
        return eoRecepDate;
    }

    public void setEoRecepDate(Date eoRecepDate) {
        this.eoRecepDate = eoRecepDate;
    }

    public String getEoUsrIns() {
        return eoUsrIns;
    }

    public void setEoUsrIns(String eoUsrIns) {
        this.eoUsrIns = eoUsrIns;
    }

    public Date getEoDateIns() {
        return eoDateIns;
    }

    public void setEoDateIns(Date eoDateIns) {
        this.eoDateIns = eoDateIns;
    }

    public String getEoUsrUpd() {
        return eoUsrUpd;
    }

    public void setEoUsrUpd(String eoUsrUpd) {
        this.eoUsrUpd = eoUsrUpd;
    }

    public Date getEoDateUpd() {
        return eoDateUpd;
    }

    public void setEoDateUpd(Date eoDateUpd) {
        this.eoDateUpd = eoDateUpd;
    }

    public String getCodflt() {
        return codflt;
    }

    public void setCodflt(String codflt) {
        this.codflt = codflt;
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

    public String getUsrIns() {
        return usrIns;
    }

    public void setUsrIns(String usrIns) {
        this.usrIns = usrIns;
    }

    public Date getFechaIns() {
        return fechaIns;
    }

    public void setFechaIns(Date fechaIns) {
        this.fechaIns = fechaIns;
    }

    public String getUsrAct() {
        return usrAct;
    }

    public void setUsrAct(String usrAct) {
        this.usrAct = usrAct;
    }

    public Date getFechaAct() {
        return fechaAct;
    }

    public void setFechaAct(Date fechaAct) {
        this.fechaAct = fechaAct;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }
    
}
