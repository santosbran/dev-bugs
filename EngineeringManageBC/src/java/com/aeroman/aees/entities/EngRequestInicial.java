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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author firaheta
 */
@Entity
@Cacheable(false)
@Table(name = "ENG_REQUEST_INICIAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngRequestInicial.findAll", query = "SELECT e FROM EngRequestInicial e"),
    @NamedQuery(name = "EngRequestInicial.findByReqMessageid", query = "SELECT e FROM EngRequestInicial e WHERE e.reqMessageid = :reqMessageid"),
    @NamedQuery(name = "EngRequestInicial.findByReqModel", query = "SELECT e FROM EngRequestInicial e WHERE e.reqModel = :reqModel"),
    @NamedQuery(name = "EngRequestInicial.findByReqIssuedate", query = "SELECT e FROM EngRequestInicial e WHERE e.reqIssuedate = :reqIssuedate"),
    @NamedQuery(name = "EngRequestInicial.findByAtaNumata", query = "SELECT e FROM EngRequestInicial e WHERE e.ataNumata = :ataNumata"),
    @NamedQuery(name = "EngRequestInicial.findByReqDuedate", query = "SELECT e FROM EngRequestInicial e WHERE e.reqDuedate = :reqDuedate"),
    @NamedQuery(name = "EngRequestInicial.findByReqResponsedt", query = "SELECT e FROM EngRequestInicial e WHERE e.reqResponsedt = :reqResponsedt"),
    @NamedQuery(name = "EngRequestInicial.findByReqRegistry", query = "SELECT e FROM EngRequestInicial e WHERE e.reqRegistry = :reqRegistry"),
    @NamedQuery(name = "EngRequestInicial.findByUsrCoduser", query = "SELECT e FROM EngRequestInicial e WHERE e.usrCoduser = :usrCoduser"),
    @NamedQuery(name = "EngRequestInicial.findByReqCorr", query = "SELECT e FROM EngRequestInicial e WHERE e.reqCorr = :reqCorr"),
    @NamedQuery(name = "EngRequestInicial.findByReqRevnr", query = "SELECT e FROM EngRequestInicial e WHERE e.reqRevnr = :reqRevnr"),
    @NamedQuery(name = "EngRequestInicial.findByReqComponent", query = "SELECT e FROM EngRequestInicial e WHERE e.reqComponent = :reqComponent"),
    @NamedQuery(name = "EngRequestInicial.findByReqPn", query = "SELECT e FROM EngRequestInicial e WHERE e.reqPn = :reqPn"),
    @NamedQuery(name = "EngRequestInicial.findByReqSn", query = "SELECT e FROM EngRequestInicial e WHERE e.reqSn = :reqSn"),
    @NamedQuery(name = "EngRequestInicial.findByReqPriority", query = "SELECT e FROM EngRequestInicial e WHERE e.reqPriority = :reqPriority"),
    @NamedQuery(name = "EngRequestInicial.findByReqCausedamage", query = "SELECT e FROM EngRequestInicial e WHERE e.reqCausedamage = :reqCausedamage"),
    @NamedQuery(name = "EngRequestInicial.findByReqExtdamage", query = "SELECT e FROM EngRequestInicial e WHERE e.reqExtdamage = :reqExtdamage"),
    @NamedQuery(name = "EngRequestInicial.findByReqReqdesdmg", query = "SELECT e FROM EngRequestInicial e WHERE e.reqReqdesdmg = :reqReqdesdmg"),
    @NamedQuery(name = "EngRequestInicial.findByReqSketch", query = "SELECT e FROM EngRequestInicial e WHERE e.reqSketch = :reqSketch"),
    @NamedQuery(name = "EngRequestInicial.findByReqNdtreport", query = "SELECT e FROM EngRequestInicial e WHERE e.reqNdtreport = :reqNdtreport"),
    @NamedQuery(name = "EngRequestInicial.findByReqNdtresponse", query = "SELECT e FROM EngRequestInicial e WHERE e.reqNdtresponse = :reqNdtresponse"),
    @NamedQuery(name = "EngRequestInicial.findByReqRepairarea", query = "SELECT e FROM EngRequestInicial e WHERE e.reqRepairarea = :reqRepairarea"),
    @NamedQuery(name = "EngRequestInicial.findByReqReffound", query = "SELECT e FROM EngRequestInicial e WHERE e.reqReffound = :reqReffound"),
    @NamedQuery(name = "EngRequestInicial.findByReqDamfound", query = "SELECT e FROM EngRequestInicial e WHERE e.reqDamfound = :reqDamfound"),
    @NamedQuery(name = "EngRequestInicial.findByReqStataircraft", query = "SELECT e FROM EngRequestInicial e WHERE e.reqStataircraft = :reqStataircraft"),
    @NamedQuery(name = "EngRequestInicial.findByReqProbdesc", query = "SELECT e FROM EngRequestInicial e WHERE e.reqProbdesc = :reqProbdesc"),
    @NamedQuery(name = "EngRequestInicial.findByReqUsersol", query = "SELECT e FROM EngRequestInicial e WHERE e.reqUsersol = :reqUsersol"),
    @NamedQuery(name = "EngRequestInicial.findByReqUserappr", query = "SELECT e FROM EngRequestInicial e WHERE e.reqUserappr = :reqUserappr"),
    @NamedQuery(name = "EngRequestInicial.findByReqRecivedate", query = "SELECT e FROM EngRequestInicial e WHERE e.reqRecivedate = :reqRecivedate"),
    @NamedQuery(name = "EngRequestInicial.findByReqExtSol", query = "SELECT e FROM EngRequestInicial e WHERE e.reqExtSol = :reqExtSol"),
    @NamedQuery(name = "EngRequestInicial.findByReqActionIng", query = "SELECT e FROM EngRequestInicial e WHERE e.reqActionIng = :reqActionIng"),
    @NamedQuery(name = "EngRequestInicial.findByReqStatus", query = "SELECT e FROM EngRequestInicial e WHERE e.reqStatus = :reqStatus"),
    @NamedQuery(name = "EngRequestInicial.findByChkCheckid", query = "SELECT e FROM EngRequestInicial e WHERE e.chkCheckid = :chkCheckid"),
    @NamedQuery(name = "EngRequestInicial.findByReqYear", query = "SELECT e FROM EngRequestInicial e WHERE e.reqYear = :reqYear"),
    @NamedQuery(name = "EngRequestInicial.findByReqOtherref", query = "SELECT e FROM EngRequestInicial e WHERE e.reqOtherref = :reqOtherref"),
    @NamedQuery(name = "EngRequestInicial.findByReqChkRef", query = "SELECT e FROM EngRequestInicial e WHERE e.reqChkRef = :reqChkRef"),
    @NamedQuery(name = "EngRequestInicial.findByReqChkOtheref", query = "SELECT e FROM EngRequestInicial e WHERE e.reqChkOtheref = :reqChkOtheref"),
    @NamedQuery(name = "EngRequestInicial.findByReqActive", query = "SELECT e FROM EngRequestInicial e WHERE e.reqActive = :reqActive"),
    @NamedQuery(name = "EngRequestInicial.findByReqClasRepair", query = "SELECT e FROM EngRequestInicial e WHERE e.reqClasRepair = :reqClasRepair"),
    @NamedQuery(name = "EngRequestInicial.findByReqCriticalEsr", query = "SELECT e FROM EngRequestInicial e WHERE e.reqCriticalEsr = :reqCriticalEsr"),
    @NamedQuery(name = "EngRequestInicial.findByReqEngManHrs", query = "SELECT e FROM EngRequestInicial e WHERE e.reqEngManHrs = :reqEngManHrs"),
    @NamedQuery(name = "EngRequestInicial.findByReqOtherCost", query = "SELECT e FROM EngRequestInicial e WHERE e.reqOtherCost = :reqOtherCost"),
    @NamedQuery(name = "EngRequestInicial.findByReqDescCost", query = "SELECT e FROM EngRequestInicial e WHERE e.reqDescCost = :reqDescCost"),
    @NamedQuery(name = "EngRequestInicial.findByReqStatusEng", query = "SELECT e FROM EngRequestInicial e WHERE e.reqStatusEng = :reqStatusEng"),
    @NamedQuery(name = "EngRequestInicial.findByReqAdjCodigo", query = "SELECT e FROM EngRequestInicial e WHERE e.reqAdjCodigo = :reqAdjCodigo"),
    @NamedQuery(name = "EngRequestInicial.findByReqCodIngEnc", query = "SELECT e FROM EngRequestInicial e WHERE e.reqCodIngEnc = :reqCodIngEnc"),
    @NamedQuery(name = "EngRequestInicial.findByReqUsrIns", query = "SELECT e FROM EngRequestInicial e WHERE e.reqUsrIns = :reqUsrIns"),
    @NamedQuery(name = "EngRequestInicial.findByReqFechaIns", query = "SELECT e FROM EngRequestInicial e WHERE e.reqFechaIns = :reqFechaIns"),
    @NamedQuery(name = "EngRequestInicial.findByReqUsrAct", query = "SELECT e FROM EngRequestInicial e WHERE e.reqUsrAct = :reqUsrAct"),
    @NamedQuery(name = "EngRequestInicial.findByReqDateAct", query = "SELECT e FROM EngRequestInicial e WHERE e.reqDateAct = :reqDateAct"),
    @NamedQuery(name = "EngRequestInicial.findByReqReqEnv", query = "SELECT e FROM EngRequestInicial e WHERE e.reqReqEnv = :reqReqEnv"),    
    @NamedQuery(name = "EngRequestInicial.findByReqFlagTracking", query = "SELECT e FROM EngRequestInicial e WHERE e.reqFlagTracking = :reqFlagTracking"),
    @NamedQuery(name = "EngRequestInicial.findByReqTail", query = "SELECT e FROM EngRequestInicial e WHERE e.reqTail = :reqTail"),
    @NamedQuery(name = "EngRequestInicial.findByReqCustomer", query = "SELECT e FROM EngRequestInicial e WHERE e.reqCustomer = :reqCustomer"),
    @NamedQuery(name = "EngRequestInicial.findByFltCod", query = "SELECT e FROM EngRequestInicial e WHERE e.fltCod = :fltCod"),
    @NamedQuery(name = "EngRequestInicial.findByLogpage", query = "SELECT e FROM EngRequestInicial e WHERE e.logpage = :logpage"),
    @NamedQuery(name = "EngRequestInicial.findByYearlogpage", query = "SELECT e FROM EngRequestInicial e WHERE e.yearlogpage = :yearlogpage"),
    @NamedQuery(name = "EngRequestInicial.findByNumerologpage", query = "SELECT e FROM EngRequestInicial e WHERE e.numerologpage = :numerologpage"),
    @NamedQuery(name = "EngRequestInicial.findByCompany", query = "SELECT e FROM EngRequestInicial e WHERE e.company = :company"),
    @NamedQuery(name = "EngRequestInicial.findByReqJobcard", query = "SELECT e FROM EngRequestInicial e WHERE e.reqJobcard = :reqJobcard"),
    @NamedQuery(name = "EngRequestInicial.findByReqDimDesc", query = "SELECT e FROM EngRequestInicial e WHERE e.reqDimDesc = :reqDimDesc")})
public class EngRequestInicial implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "REQ_MESSAGEID")
    private BigDecimal reqMessageid;
    @Size(max = 50)
    @Column(name = "REQ_MODEL")
    private String reqModel;
    @Column(name = "REQ_ISSUEDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reqIssuedate;
    @Column(name = "ATA_NUMATA")
    private Short ataNumata;
    @Column(name = "REQ_DUEDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reqDuedate;
    @Column(name = "REQ_RESPONSEDT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reqResponsedt;
    @Size(max = 20)
    @Column(name = "REQ_REGISTRY")
    private String reqRegistry;
    @Size(max = 30)
    @Column(name = "USR_CODUSER")
    private String usrCoduser;
    @Size(max = 6)
    @Column(name = "REQ_CORR")
    private String reqCorr;
    @Size(max = 4)
    @Column(name = "REQ_REVNR")
    private String reqRevnr;
    @Size(max = 50)
    @Column(name = "REQ_COMPONENT")
    private String reqComponent;
    @Size(max = 50)
    @Column(name = "REQ_PN")
    private String reqPn;
    @Size(max = 50)
    @Column(name = "REQ_SN")
    private String reqSn;
    @Size(max = 1)
    @Column(name = "REQ_PRIORITY")
    private String reqPriority;
    @Size(max = 1)
    @Column(name = "REQ_CAUSEDAMAGE")
    private String reqCausedamage;
    @Size(max = 1)
    @Column(name = "REQ_EXTDAMAGE")
    private String reqExtdamage;
    @Size(max = 1)
    @Column(name = "REQ_REQDESDMG")
    private String reqReqdesdmg;
    @Size(max = 1)
    @Column(name = "REQ_SKETCH")
    private String reqSketch;
    @Size(max = 1)
    @Column(name = "REQ_NDTREPORT")
    private String reqNdtreport;
    @Column(name = "REQ_NDTRESPONSE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reqNdtresponse;
    @Size(max = 1)
    @Column(name = "REQ_REPAIRAREA")
    private String reqRepairarea;
    @Size(max = 20)
    @Column(name = "REQ_REFFOUND")
    private String reqReffound;
    @Size(max = 100)
    @Column(name = "REQ_DAMFOUND")
    private String reqDamfound;
    @Size(max = 100)
    @Column(name = "REQ_STATAIRCRAFT")
    private String reqStataircraft;
    @Size(max = 4000)
    @Column(name = "REQ_PROBDESC")
    private String reqProbdesc;
    @Size(max = 50)
    @Column(name = "REQ_USERSOL")
    private String reqUsersol;
    @Size(max = 50)
    @Column(name = "REQ_USERAPPR")
    private String reqUserappr;
    @Column(name = "REQ_RECIVEDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reqRecivedate;
    @Size(max = 15)
    @Column(name = "REQ_EXT_SOL")
    private String reqExtSol;
    @Size(max = 4000)
    @Column(name = "REQ_ACTION_ING")
    private String reqActionIng;
    @Size(max = 3)
    @Column(name = "REQ_STATUS")
    private String reqStatus;
    @Column(name = "CHK_CHECKID")
    private Short chkCheckid;
    @Size(max = 4)
    @Column(name = "REQ_YEAR")
    private String reqYear;
    @Size(max = 20)
    @Column(name = "REQ_OTHERREF")
    private String reqOtherref;
    @Size(max = 1)
    @Column(name = "REQ_CHK_REF")
    private String reqChkRef;
    @Size(max = 1)
    @Column(name = "REQ_CHK_OTHEREF")
    private String reqChkOtheref;
    @Size(max = 1)
    @Column(name = "REQ_ACTIVE")
    private String reqActive;
    @Size(max = 4000)
    @Column(name = "REQ_CLAS_REPAIR")
    private String reqClasRepair;
    @Size(max = 1)
    @Column(name = "REQ_CRITICAL_ESR")
    private String reqCriticalEsr;
    @Column(name = "REQ_ENG_MAN_HRS")
    private BigDecimal reqEngManHrs;
    @Column(name = "REQ_OTHER_COST")
    private BigInteger reqOtherCost;
    @Size(max = 200)
    @Column(name = "REQ_DESC_COST")
    private String reqDescCost;
    @Size(max = 1)
    @Column(name = "REQ_STATUS_ENG")
    private String reqStatusEng;
    @Column(name = "REQ_ADJ_CODIGO")
    private BigInteger reqAdjCodigo;
    @Size(max = 30)
    @Column(name = "REQ_COD_ING_ENC")
    private String reqCodIngEnc;
    @Size(max = 30)
    @Column(name = "REQ_USR_INS")
    private String reqUsrIns;
    @Column(name = "REQ_FECHA_INS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reqFechaIns;
    @Size(max = 30)
    @Column(name = "REQ_USR_ACT")
    private String reqUsrAct;
    @Column(name = "REQ_DATE_ACT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reqDateAct;
    @Size(max = 1)
    @Column(name = "REQ_REQ_ENV")
    private String reqReqEnv;
    @Column(name = "REQ_DUE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reqDueDate2;
    @Size(max = 1000)
    @Column(name = "REQ_FLAG_TRACKING")
    private String reqFlagTracking;
    @Size(max = 20)
    @Column(name = "REQ_TAIL")
    private String reqTail;
    @Size(max = 20)
    @Column(name = "REQ_CUSTOMER")
    private String reqCustomer;
    @Size(max = 20)
    @Column(name = "FLT_COD")
    private String fltCod;
    @Size(max = 100)
    @Column(name = "LOGPAGE")
    private String logpage;
    @Size(max = 4)
    @Column(name = "YEARLOGPAGE")
    private String yearlogpage;
    @Size(max = 90)
    @Column(name = "NUMEROLOGPAGE")
    private String numerologpage;
    @Size(max = 50)
    @Column(name = "COMPANY")
    private String company;
    @Size(max = 100)
    @Column(name = "REQ_JOBCARD")
    private String reqJobcard;
    @Size(max = 4000)
    @Column(name = "REQ_DIM_DESC")
    private String reqDimDesc;
    @Size(max = 4000)
    @Column(name = "REQ_RET_DESCRIPTION")
    private String reqRetDescription;
    
    @Size(max = 4000)
    @Column(name = "REQ_CLAS_REPAIR2")
    private String reqClasRepair2;
    @Size(max = 50)
    @Column(name = "REQ_COMPLETE")
    private String reqComplete;
    @Size(max = 50)
    @Column(name = "REQ_REASON")
    private String reqReason;
    @Size(max = 50)
    @Column(name = "REQ_CRITICAL")
    private String reqCritical;
    @Size(max = 50)
    @Column(name = "REQ_AOG")
    private String reqAog;
    @Column(name = "ENG_COMP_PN")
    private String engCompPn;    
    @Column(name = "ENG_COMP_CHK")
    private String engCompChk;     
    @Column(name = "ENG_DISCRE_REQ")
    private String engDiscreReq;    
    @Column(name = "ENG_REFER_EVAL")
    private String engReferVal;    
    
    @Column(name = "ENG_DAMAGE_TYPE")
    private String engDamageType;
    
      @Column(name = "ENG_REQUEST_OTHER")
    private String engRequestOther;
   
    
    
    @JoinColumn(name = "REQ_AFP_ID", referencedColumnName = "AFP_ID")
    @ManyToOne
    private EngAffectedPart reqAfpId;
    @JoinColumn(name = "REQ_DAT_ID", referencedColumnName = "DAT_ID")
    @ManyToOne
    private EngDamageType reqDatId;
    @Size(max = 150)
    @Column(name = "REQ_DISCREPORIDOC")
    private String reqDiscreporidoc;
    
    public EngRequestInicial() {
        super();
    }

    public EngRequestInicial(BigDecimal reqMessageid) {
        this.reqMessageid = reqMessageid;
    }

    public BigDecimal getReqMessageid() {
        return reqMessageid;
    }

    public void setReqMessageid(BigDecimal reqMessageid) {
        this.reqMessageid = reqMessageid;
    }

    public String getReqModel() {
        return reqModel;
    }

    public void setReqModel(String reqModel) {
        this.reqModel = reqModel;
    }

    public Date getReqIssuedate() {
        return reqIssuedate;
    }

    public void setReqIssuedate(Date reqIssuedate) {
        this.reqIssuedate = reqIssuedate;
    }

    public Short getAtaNumata() {
        return ataNumata;
    }

    public void setAtaNumata(Short ataNumata) {
        this.ataNumata = ataNumata;
    }

    public Date getReqDuedate() {
        return reqDuedate;
    }

    public void setReqDuedate(Date reqDuedate) {
        this.reqDuedate = reqDuedate;
    }

    public Date getReqResponsedt() {
        return reqResponsedt;
    }

    public void setReqResponsedt(Date reqResponsedt) {
        this.reqResponsedt = reqResponsedt;
    }

    public String getReqRegistry() {
        return reqRegistry;
    }

    public void setReqRegistry(String reqRegistry) {
        this.reqRegistry = reqRegistry;
    }

    public String getUsrCoduser() {
        return usrCoduser;
    }

    public void setUsrCoduser(String usrCoduser) {
        this.usrCoduser = usrCoduser;
    }

    public String getReqCorr() {
        return reqCorr;
    }

    public void setReqCorr(String reqCorr) {
        this.reqCorr = reqCorr;
    }

    public String getReqRevnr() {
        return reqRevnr;
    }

    public void setReqRevnr(String reqRevnr) {
        this.reqRevnr = reqRevnr;
    }

    public String getReqComponent() {
        return reqComponent;
    }

    public void setReqComponent(String reqComponent) {
        this.reqComponent = reqComponent;
    }

    public String getReqPn() {
        return reqPn;
    }

    public void setReqPn(String reqPn) {
        this.reqPn = reqPn;
    }

    public String getReqSn() {
        return reqSn;
    }

    public void setReqSn(String reqSn) {
        this.reqSn = reqSn;
    }

    public String getReqPriority() {
        return reqPriority;
    }

    public void setReqPriority(String reqPriority) {
        this.reqPriority = reqPriority;
    }

    public String getReqCausedamage() {
        return reqCausedamage;
    }

    public void setReqCausedamage(String reqCausedamage) {
        this.reqCausedamage = reqCausedamage;
    }

    public String getReqExtdamage() {
        return reqExtdamage;
    }

    public void setReqExtdamage(String reqExtdamage) {
        this.reqExtdamage = reqExtdamage;
    }

    public String getReqReqdesdmg() {
        return reqReqdesdmg;
    }

    public void setReqReqdesdmg(String reqReqdesdmg) {
        this.reqReqdesdmg = reqReqdesdmg;
    }

    public String getReqSketch() {
        return reqSketch;
    }

    public void setReqSketch(String reqSketch) {
        this.reqSketch = reqSketch;
    }

    public String getReqNdtreport() {
        return reqNdtreport;
    }

    public void setReqNdtreport(String reqNdtreport) {
        this.reqNdtreport = reqNdtreport;
    }

    public Date getReqNdtresponse() {
        return reqNdtresponse;
    }

    public void setReqNdtresponse(Date reqNdtresponse) {
        this.reqNdtresponse = reqNdtresponse;
    }

    public String getReqRepairarea() {
        return reqRepairarea;
    }

    public void setReqRepairarea(String reqRepairarea) {
        this.reqRepairarea = reqRepairarea;
    }

    public String getReqReffound() {
        return reqReffound;
    }

    public void setReqReffound(String reqReffound) {
        this.reqReffound = reqReffound;
    }

    public String getReqDamfound() {
        return reqDamfound;
    }

    public void setReqDamfound(String reqDamfound) {
        this.reqDamfound = reqDamfound;
    }

    public String getReqStataircraft() {
        return reqStataircraft;
    }

    public void setReqStataircraft(String reqStataircraft) {
        this.reqStataircraft = reqStataircraft;
    }

    public String getReqProbdesc() {
        return reqProbdesc;
    }

    public void setReqProbdesc(String reqProbdesc) {
        this.reqProbdesc = reqProbdesc;
    }

    public String getReqUsersol() {
        return reqUsersol;
    }

    public void setReqUsersol(String reqUsersol) {
        this.reqUsersol = reqUsersol;
    }

    public String getReqUserappr() {
        return reqUserappr;
    }

    public void setReqUserappr(String reqUserappr) {
        this.reqUserappr = reqUserappr;
    }

    public Date getReqRecivedate() {
        return reqRecivedate;
    }

    public void setReqRecivedate(Date reqRecivedate) {
        this.reqRecivedate = reqRecivedate;
    }

    public String getReqExtSol() {
        return reqExtSol;
    }

    public void setReqExtSol(String reqExtSol) {
        this.reqExtSol = reqExtSol;
    }

    public String getReqActionIng() {
        return reqActionIng;
    }

    public void setReqActionIng(String reqActionIng) {
        this.reqActionIng = reqActionIng;
    }

    public String getReqStatus() {
        return reqStatus;
    }

    public void setReqStatus(String reqStatus) {
        this.reqStatus = reqStatus;
    }

    public Short getChkCheckid() {
        return chkCheckid;
    }

    public void setChkCheckid(Short chkCheckid) {
        this.chkCheckid = chkCheckid;
    }

    public String getReqYear() {
        return reqYear;
    }

    public void setReqYear(String reqYear) {
        this.reqYear = reqYear;
    }

    public String getReqOtherref() {
        return reqOtherref;
    }

    public void setReqOtherref(String reqOtherref) {
        this.reqOtherref = reqOtherref;
    }

    public String getReqChkRef() {
        return reqChkRef;
    }

    public void setReqChkRef(String reqChkRef) {
        this.reqChkRef = reqChkRef;
    }

    public String getReqChkOtheref() {
        return reqChkOtheref;
    }

    public void setReqChkOtheref(String reqChkOtheref) {
        this.reqChkOtheref = reqChkOtheref;
    }

    public String getReqActive() {
        return reqActive;
    }

    public void setReqActive(String reqActive) {
        this.reqActive = reqActive;
    }

    public String getReqClasRepair() {
        return reqClasRepair;
    }

    public void setReqClasRepair(String reqClasRepair) {
        this.reqClasRepair = reqClasRepair;
    }

    public String getReqCriticalEsr() {
        return reqCriticalEsr;
    }

    public void setReqCriticalEsr(String reqCriticalEsr) {
        this.reqCriticalEsr = reqCriticalEsr;
    }

    public BigDecimal getReqEngManHrs() {
        return reqEngManHrs;
    }

    public void setReqEngManHrs(BigDecimal reqEngManHrs) {
        this.reqEngManHrs = reqEngManHrs;
    }

    public BigInteger getReqOtherCost() {
        return reqOtherCost;
    }

    public void setReqOtherCost(BigInteger reqOtherCost) {
        this.reqOtherCost = reqOtherCost;
    }

    public String getReqDescCost() {
        return reqDescCost;
    }

    public void setReqDescCost(String reqDescCost) {
        this.reqDescCost = reqDescCost;
    }

    public String getReqStatusEng() {
        return reqStatusEng;
    }

    public void setReqStatusEng(String reqStatusEng) {
        this.reqStatusEng = reqStatusEng;
    }

    public BigInteger getReqAdjCodigo() {
        return reqAdjCodigo;
    }

    public void setReqAdjCodigo(BigInteger reqAdjCodigo) {
        this.reqAdjCodigo = reqAdjCodigo;
    }

    public String getReqCodIngEnc() {
        return reqCodIngEnc;
    }

    public void setReqCodIngEnc(String reqCodIngEnc) {
        this.reqCodIngEnc = reqCodIngEnc;
    }

    public String getReqUsrIns() {
        return reqUsrIns;
    }

    public void setReqUsrIns(String reqUsrIns) {
        this.reqUsrIns = reqUsrIns;
    }

    public Date getReqFechaIns() {
        return reqFechaIns;
    }

    public void setReqFechaIns(Date reqFechaIns) {
        this.reqFechaIns = reqFechaIns;
    }

    public String getReqUsrAct() {
        return reqUsrAct;
    }

    public void setReqUsrAct(String reqUsrAct) {
        this.reqUsrAct = reqUsrAct;
    }

    public Date getReqDateAct() {
        return reqDateAct;
    }

    public void setReqDateAct(Date reqDateAct) {
        this.reqDateAct = reqDateAct;
    }

    public String getReqReqEnv() {
        return reqReqEnv;
    }

    public void setReqReqEnv(String reqReqEnv) {
        this.reqReqEnv = reqReqEnv;
    }

    public Date getReqDueDate2() {
        return reqDueDate2;
    }

    public void setReqDueDate2(Date reqDueDate2) {
        this.reqDueDate2 = reqDueDate2;
    }

    
    public String getReqFlagTracking() {
        return reqFlagTracking;
    }

    public void setReqFlagTracking(String reqFlagTracking) {
        this.reqFlagTracking = reqFlagTracking;
    }

    public String getReqTail() {
        return reqTail;
    }

    public void setReqTail(String reqTail) {
        this.reqTail = reqTail;
    }

    public String getReqCustomer() {
        return reqCustomer;
    }

    public void setReqCustomer(String reqCustomer) {
        this.reqCustomer = reqCustomer;
    }

    public String getFltCod() {
        return fltCod;
    }

    public void setFltCod(String fltCod) {
        this.fltCod = fltCod;
    }

    public String getLogpage() {
        return logpage;
    }

    public void setLogpage(String logpage) {
        this.logpage = logpage;
    }

    public String getYearlogpage() {
        return yearlogpage;
    }

    public void setYearlogpage(String yearlogpage) {
        this.yearlogpage = yearlogpage;
    }

    public String getNumerologpage() {
        return numerologpage;
    }

    public void setNumerologpage(String numerologpage) {
        this.numerologpage = numerologpage;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getReqJobcard() {
        return reqJobcard;
    }

    public void setReqJobcard(String reqJobcard) {
        this.reqJobcard = reqJobcard;
    }

    public EngAffectedPart getReqAfpId() {
        return reqAfpId;
    }

    public void setReqAfpId(EngAffectedPart reqAfpId) {
        this.reqAfpId = reqAfpId;
    }

    public EngDamageType getReqDatId() {
        return reqDatId;
    }

    public void setReqDatId(EngDamageType reqDatId) {
        this.reqDatId = reqDatId;
    }

    public String getReqDiscreporidoc() {
        return reqDiscreporidoc;
    }

    public void setReqDiscreporidoc(String reqDiscreporidoc) {
        this.reqDiscreporidoc = reqDiscreporidoc;
    }

    public String getReqDimDesc() {
        return reqDimDesc;
    }

    public void setReqDimDesc(String reqDimDesc) {
        this.reqDimDesc = reqDimDesc;
    }

    public String getReqRetDescription() {
        return reqRetDescription;
    }

    public void setReqRetDescription(String reqRetDescription) {
        this.reqRetDescription = reqRetDescription;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reqMessageid != null ? reqMessageid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EngRequestInicial)) {
            return false;
        }
        EngRequestInicial other = (EngRequestInicial) object;
        if ((this.reqMessageid == null && other.reqMessageid != null) || (this.reqMessageid != null && !this.reqMessageid.equals(other.reqMessageid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngRequestInicial[ reqMessageid=" + reqMessageid + " ]";
    }
    
    public String getReqClasRepair2() {
        return reqClasRepair2;
    }

    public void setReqClasRepair2(String reqClasRepair2) {
        this.reqClasRepair2 = reqClasRepair2;
    }

    public String getReqComplete() {
        return reqComplete;
    }

    public void setReqComplete(String reqComplete) {
        this.reqComplete = reqComplete;
    }

    public String getReqReason() {
        return reqReason;
    }

    public void setReqReason(String reqReason) {
        this.reqReason = reqReason;
    }

    public String getReqCritical() {
        return reqCritical;
    }

    public void setReqCritical(String reqCritical) {
        this.reqCritical = reqCritical;
    }

    public String getReqAog() {
        return reqAog;
    }

    public void setReqAog(String reqAog) {
        this.reqAog = reqAog;
    }

    public String getEngCompPn() {
        return engCompPn;
    }

    public void setEngCompPn(String engCompPn) {
        this.engCompPn = engCompPn;
    }

    public String getEngCompChk() {
        return engCompChk;
    }

    public void setEngCompChk(String engCompChk) {
        this.engCompChk = engCompChk;
    }

    public String getEngDiscreReq() {
        return engDiscreReq;
    }

    public void setEngDiscreReq(String engDiscreReq) {
        this.engDiscreReq = engDiscreReq;
    }

    public String getEngReferVal() {
        return engReferVal;
    }

    public void setEngReferVal(String engReferVal) {
        this.engReferVal = engReferVal;
    }

    public String getEngDamageType() {
        return engDamageType;
    }

    public void setEngDamageType(String engDamageType) {
        this.engDamageType = engDamageType;
    }

    public String getEngRequestOther() {
        return engRequestOther;
    }

    public void setEngRequestOther(String engRequestOther) {
        this.engRequestOther = engRequestOther;
    }
    
    
    
    
}
