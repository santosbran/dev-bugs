/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Cacheable(false)
@Table(name = "ENG_REQUEST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngRequest.findAll", query = "SELECT e FROM EngRequest e"),
    @NamedQuery(name = "EngRequest.findByReqMessageid", query = "SELECT e FROM EngRequest e WHERE e.reqMessageid = :reqMessageid"),
    @NamedQuery(name = "EngRequest.findByReqModel", query = "SELECT e FROM EngRequest e WHERE e.reqModel = :reqModel"),
    @NamedQuery(name = "EngRequest.findByReqIssuedate", query = "SELECT e FROM EngRequest e WHERE e.reqIssuedate = :reqIssuedate"),
    @NamedQuery(name = "EngRequest.findByAtaNumata", query = "SELECT e FROM EngRequest e WHERE e.ataNumata = :ataNumata"),
    @NamedQuery(name = "EngRequest.findByReqResponsedt", query = "SELECT e FROM EngRequest e WHERE e.reqResponsedt = :reqResponsedt"),
    @NamedQuery(name = "EngRequest.findByReqRegistry", query = "SELECT e FROM EngRequest e WHERE e.reqRegistry = :reqRegistry"),
    @NamedQuery(name = "EngRequest.findByUsrCoduser", query = "SELECT e FROM EngRequest e WHERE e.usrCoduser = :usrCoduser"),
    @NamedQuery(name = "EngRequest.findByReqCorr", query = "SELECT e FROM EngRequest e WHERE e.reqCorr = :reqCorr"),
    @NamedQuery(name = "EngRequest.findByReqRevnr", query = "SELECT e FROM EngRequest e WHERE e.reqRevnr = :reqRevnr"),
    @NamedQuery(name = "EngRequest.findByReqComponent", query = "SELECT e FROM EngRequest e WHERE e.reqComponent = :reqComponent"),
    @NamedQuery(name = "EngRequest.findByReqPn", query = "SELECT e FROM EngRequest e WHERE e.reqPn = :reqPn"),
    @NamedQuery(name = "EngRequest.findByReqSn", query = "SELECT e FROM EngRequest e WHERE e.reqSn = :reqSn"),
    @NamedQuery(name = "EngRequest.findByReqPriority", query = "SELECT e FROM EngRequest e WHERE e.reqPriority = :reqPriority"),
    @NamedQuery(name = "EngRequest.findByReqCausedamage", query = "SELECT e FROM EngRequest e WHERE e.reqCausedamage = :reqCausedamage"),
    @NamedQuery(name = "EngRequest.findByReqExtdamage", query = "SELECT e FROM EngRequest e WHERE e.reqExtdamage = :reqExtdamage"),
    @NamedQuery(name = "EngRequest.findByReqReqdesdmg", query = "SELECT e FROM EngRequest e WHERE e.reqReqdesdmg = :reqReqdesdmg"),
    @NamedQuery(name = "EngRequest.findByReqSketch", query = "SELECT e FROM EngRequest e WHERE e.reqSketch = :reqSketch"),
    @NamedQuery(name = "EngRequest.findByReqNdtreport", query = "SELECT e FROM EngRequest e WHERE e.reqNdtreport = :reqNdtreport"),
    @NamedQuery(name = "EngRequest.findByReqNdtresponse", query = "SELECT e FROM EngRequest e WHERE e.reqNdtresponse = :reqNdtresponse"),
    @NamedQuery(name = "EngRequest.findByReqRepairarea", query = "SELECT e FROM EngRequest e WHERE e.reqRepairarea = :reqRepairarea"),
    @NamedQuery(name = "EngRequest.findByReqDamfound", query = "SELECT e FROM EngRequest e WHERE e.reqDamfound = :reqDamfound"),
    @NamedQuery(name = "EngRequest.findByReqStataircraft", query = "SELECT e FROM EngRequest e WHERE e.reqStataircraft = :reqStataircraft"),
    @NamedQuery(name = "EngRequest.findByReqUsersol", query = "SELECT e FROM EngRequest e WHERE e.reqUsersol = :reqUsersol"),
    @NamedQuery(name = "EngRequest.findByReqUserappr", query = "SELECT e FROM EngRequest e WHERE e.reqUserappr = :reqUserappr"),
    @NamedQuery(name = "EngRequest.findByReqRecivedate", query = "SELECT e FROM EngRequest e WHERE e.reqRecivedate = :reqRecivedate"),
    @NamedQuery(name = "EngRequest.findByReqExtSol", query = "SELECT e FROM EngRequest e WHERE e.reqExtSol = :reqExtSol"),
    @NamedQuery(name = "EngRequest.findByReqStatus", query = "SELECT e FROM EngRequest e WHERE e.reqStatus = :reqStatus"),
    @NamedQuery(name = "EngRequest.findByChkCheckid", query = "SELECT e FROM EngRequest e WHERE e.chkCheckid = :chkCheckid"),
    @NamedQuery(name = "EngRequest.findByReqYear", query = "SELECT e FROM EngRequest e WHERE e.reqYear = :reqYear"),
    @NamedQuery(name = "EngRequest.findByReqOtherref", query = "SELECT e FROM EngRequest e WHERE e.reqOtherref = :reqOtherref"),
    @NamedQuery(name = "EngRequest.findByReqChkRef", query = "SELECT e FROM EngRequest e WHERE e.reqChkRef = :reqChkRef"),
    @NamedQuery(name = "EngRequest.findByReqChkOtheref", query = "SELECT e FROM EngRequest e WHERE e.reqChkOtheref = :reqChkOtheref"),
    @NamedQuery(name = "EngRequest.findByReqActive", query = "SELECT e FROM EngRequest e WHERE e.reqActive = :reqActive"),
    @NamedQuery(name = "EngRequest.findByReqClasRepair", query = "SELECT e FROM EngRequest e WHERE e.reqClasRepair = :reqClasRepair"),
    @NamedQuery(name = "EngRequest.findByReqClasRepair2", query = "SELECT e FROM EngRequest e WHERE e.reqClasRepair2 = :reqClasRepair2"),
    @NamedQuery(name = "EngRequest.findByReqCriticalEsr", query = "SELECT e FROM EngRequest e WHERE e.reqCriticalEsr = :reqCriticalEsr"),
    @NamedQuery(name = "EngRequest.findByReqEngManHrs", query = "SELECT e FROM EngRequest e WHERE e.reqEngManHrs = :reqEngManHrs"),
    @NamedQuery(name = "EngRequest.findByReqOtherCost", query = "SELECT e FROM EngRequest e WHERE e.reqOtherCost = :reqOtherCost"),
    @NamedQuery(name = "EngRequest.findByReqDescCost", query = "SELECT e FROM EngRequest e WHERE e.reqDescCost = :reqDescCost"),
    @NamedQuery(name = "EngRequest.findByReqStatusEng", query = "SELECT e FROM EngRequest e WHERE e.reqStatusEng = :reqStatusEng"),
    @NamedQuery(name = "EngRequest.findByReqAdjCodigo", query = "SELECT e FROM EngRequest e WHERE e.reqAdjCodigo = :reqAdjCodigo"),
    @NamedQuery(name = "EngRequest.findByReqCodIngEnc", query = "SELECT e FROM EngRequest e WHERE e.reqCodIngEnc = :reqCodIngEnc"),
    @NamedQuery(name = "EngRequest.findByReqUsrIns", query = "SELECT e FROM EngRequest e WHERE e.reqUsrIns = :reqUsrIns"),
    @NamedQuery(name = "EngRequest.findByReqFechaIns", query = "SELECT e FROM EngRequest e WHERE e.reqFechaIns = :reqFechaIns"),
    @NamedQuery(name = "EngRequest.findByReqUsrAct", query = "SELECT e FROM EngRequest e WHERE e.reqUsrAct = :reqUsrAct"),
    @NamedQuery(name = "EngRequest.findByReqDateAct", query = "SELECT e FROM EngRequest e WHERE e.reqDateAct = :reqDateAct"),
    @NamedQuery(name = "EngRequest.findByReqReqEnv", query = "SELECT e FROM EngRequest e WHERE e.reqReqEnv = :reqReqEnv"),
    @NamedQuery(name = "EngRequest.findByReqFlagTracking", query = "SELECT e FROM EngRequest e WHERE e.reqFlagTracking = :reqFlagTracking"),
    @NamedQuery(name = "EngRequest.findByReqTail", query = "SELECT e FROM EngRequest e WHERE e.reqTail = :reqTail"),
    @NamedQuery(name = "EngRequest.findByReqCustomer", query = "SELECT e FROM EngRequest e WHERE e.reqCustomer = :reqCustomer"),
    @NamedQuery(name = "EngRequest.findByFltCod", query = "SELECT e FROM EngRequest e WHERE e.fltCod = :fltCod"),
    @NamedQuery(name = "EngRequest.findByLogpage", query = "SELECT e FROM EngRequest e WHERE e.logpage = :logpage"),
    @NamedQuery(name = "EngRequest.findByYearlogpage", query = "SELECT e FROM EngRequest e WHERE e.yearlogpage = :yearlogpage"),
    @NamedQuery(name = "EngRequest.findByNumerologpage", query = "SELECT e FROM EngRequest e WHERE e.numerologpage = :numerologpage"),
    @NamedQuery(name = "EngRequest.findByCompany", query = "SELECT e FROM EngRequest e WHERE e.company = :company"),
    @NamedQuery(name = "EngRequest.findByReqJobcard", query = "SELECT e FROM EngRequest e WHERE e.reqJobcard = :reqJobcard"),
    @NamedQuery(name = "EngRequest.findByReqDimDesc", query = "SELECT e FROM EngRequest e WHERE e.reqDimDesc = :reqDimDesc"),
    @NamedQuery(name = "EngRequest.findByReqRetDescription", query = "SELECT e FROM EngRequest e WHERE e.reqRetDescription = :reqRetDescription")})

public class EngRequest implements Serializable {
    
    @Size(max = 4000)
    @Column(name = "REQ_REFFOUND")
    private String reqReffound;
    @Size(max = 4000)
    @Column(name = "REQ_ACTION_ING")
    private String reqActionIng;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reqMessageid")
    private Collection<EngRequestQuestionIni> engRequestQuestionIniCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reqMessageid")
    private Collection<EngDentIni> engDentIniCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reqMessageid")
    private Collection<EngDent> engDentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reqMessageid")
    private Collection<EngRequestQuestion> engRequestQuestionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "redIdRequest")
    private List<EngRequestDimenIni> engRequestDimenIniList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reqMessageid")
    private List<EngReqTaskCardIni> engReqTaskCardIniList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reqMessageid")
    private Collection<EngReqTaskJobcardIni> engReqTaskJobcardIniCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "redIdRequest")
    private Collection<EngRequestDimenManuf> engRequestDimenCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRequest")
    
    
    @JoinColumn(name = "REQ_AFP_ID", referencedColumnName = "AFP_ID")
    @ManyToOne
    private EngAffectedPart reqAfpId;
    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reqMessageid")
    private Collection<EngReqTaskJobcard> engReqTaskJobcardCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reqMessageid")
    private List<EngReqTaskCard> engReqTaskCardList;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ESR")
    @SequenceGenerator(name = "SEQ_ESR", sequenceName = "SEQ_ESR", allocationSize = 1)
    @Column(name = "REQ_MESSAGEID")
    private BigInteger reqMessageid;
    @Size(max = 50)
    @Column(name = "REQ_MODEL")
    private String reqModel;
    @Column(name = "REQ_ISSUEDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reqIssuedate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ATA_NUMATA")
    private short ataNumata;
    @Column(name = "REQ_DUEDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reqDuedate;
    @Column(name = "REQ_RESPONSEDT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reqResponsedt;
    @Size(max = 20)
    @Column(name = "REQ_REGISTRY")
    private String reqRegistry;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
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
    
    @Size(max = 100)
    @Column(name = "REQ_DAMFOUND")
    private String reqDamfound;
    @Size(max = 100)
    @Column(name = "REQ_STATAIRCRAFT")
    private String reqStataircraft;
   
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
    
    @Size(max = 3)
    @Column(name = "REQ_STATUS")
    private String reqStatus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CHK_CHECKID")
    private short chkCheckid;
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
    @Size(max = 4000)
    @Column(name = "REQ_CLAS_REPAIR2")
    private String reqClasRepair2;
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
    @Transient
    private String workOrderMostrar;
    @Transient
    private String fullNombreAttendance;
    @Transient
    private String numeroEsr;
    @Size(max = 150)
    @Column(name = "REQ_DISCREPORIDOC")
    private String reqDiscreporidoc;
    @Size(max = 4000)
    @Column(name = "REQ_DIM_DESC")
    private String reqDimDesc;
    @Size(max = 4000)
    @Column(name = "REQ_RET_DESCRIPTION")
    private String reqRetDescription;
    @Size(max = 4000)
    @Column(name = "REQ_PROBDESC")
    private String reqProbdesc;
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
   
    @Column(name = "ENG_TIPO_SOLICITUD")
    private String engTipoSolcitud;    
    @Column(name = "ENG_MODEL_SOLICITUD")
    private String engModelSolcitud;  
     
    
     @Column(name = "ENG_DESCRIPTION")
    private String engDescription;  
    public EngRequest() {
        super();
    }

    public EngRequest(BigInteger reqMessageid) {
        this.reqMessageid = reqMessageid;
    }

    public EngRequest(BigInteger reqMessageid, short ataNumata, String usrCoduser, short chkCheckid) {
        this.reqMessageid = reqMessageid;
        this.ataNumata = ataNumata;
        this.usrCoduser = usrCoduser;
        this.chkCheckid = chkCheckid;
    }

    public BigInteger getReqMessageid() {
        return reqMessageid;
    }

    public void setReqMessageid(BigInteger reqMessageid) {
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

    public short getAtaNumata() {
        return ataNumata;
    }

    public void setAtaNumata(short ataNumata) {
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

    public String getReqStatus() {
        return reqStatus;
    }

    public void setReqStatus(String reqStatus) {
        this.reqStatus = reqStatus;
    }

    public short getChkCheckid() {
        return chkCheckid;
    }

    public void setChkCheckid(short chkCheckid) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reqMessageid != null ? reqMessageid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EngRequest)) {
            return false;
        }
        EngRequest other = (EngRequest) object;
        if ((this.reqMessageid == null && other.reqMessageid != null) || (this.reqMessageid != null && !this.reqMessageid.equals(other.reqMessageid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngRequest[ reqMessageid=" + reqMessageid + " ]";
    }

    @XmlTransient
    public List<EngReqTaskCard> getEngReqTaskCardList() {
        return engReqTaskCardList;
    }

    public void setEngReqTaskCardList(List<EngReqTaskCard> engReqTaskCardList) {
        this.engReqTaskCardList = engReqTaskCardList;
    }

    public String getWorkOrderMostrar() {
        return workOrderMostrar;
    }

    public void setWorkOrderMostrar(String workOrderMostrar) {
        this.workOrderMostrar = workOrderMostrar;
    }

    public String getFullNombreAttendance() {
        return fullNombreAttendance;
    }

    public void setFullNombreAttendance(String fullNombreAttendance) {
        this.fullNombreAttendance = fullNombreAttendance;
    }

    public String getNumeroEsr() {
        return numeroEsr;
    }

    public void setNumeroEsr(String numeroEsr) {
        this.numeroEsr = numeroEsr;
    }

    public String getReqJobcard() {
        return reqJobcard;
    }

    public void setReqJobcard(String reqJobcard) {
        this.reqJobcard = reqJobcard;
    }
    
    @XmlTransient
    public Collection<EngReqTaskJobcard> getEngReqTaskJobcardCollection() {
        return engReqTaskJobcardCollection;
    }

    public void setEngReqTaskJobcardCollection(Collection<EngReqTaskJobcard> engReqTaskJobcardCollection) {
        this.engReqTaskJobcardCollection = engReqTaskJobcardCollection;
    }

    public String getReqDiscreporidoc() {
        return reqDiscreporidoc;
    }

    public void setReqDiscreporidoc(String reqDiscreporidoc) {
        this.reqDiscreporidoc = reqDiscreporidoc;
    }

    public EngAffectedPart getReqAfpId() {
        return reqAfpId;
    }

    public void setReqAfpId(EngAffectedPart reqAfpId) {
        this.reqAfpId = reqAfpId;
    }


    public String getReqProbdesc() {
        return reqProbdesc;
    }

    public void setReqProbdesc(String reqProbdesc) {
        this.reqProbdesc = reqProbdesc;
    }
    

    @XmlTransient
    public Collection<EngRequestDimenManuf> getEngRequestDimenCollection() {
        return engRequestDimenCollection;
    }

    public void setEngRequestDimenCollection(Collection<EngRequestDimenManuf> engRequestDimenCollection) {
        this.engRequestDimenCollection = engRequestDimenCollection;
    }

    @XmlTransient
    public Collection<EngReqTaskJobcardIni> getEngReqTaskJobcardIniCollection() {
        return engReqTaskJobcardIniCollection;
    }

    public void setEngReqTaskJobcardIniCollection(Collection<EngReqTaskJobcardIni> engReqTaskJobcardIniCollection) {
        this.engReqTaskJobcardIniCollection = engReqTaskJobcardIniCollection;
    }

    @XmlTransient
    public List<EngRequestDimenIni> getEngRequestDimenIniList() {
        return engRequestDimenIniList;
    }

    public void setEngRequestDimenIniList(List<EngRequestDimenIni> engRequestDimenIniList) {
        this.engRequestDimenIniList = engRequestDimenIniList;
    }

    @XmlTransient
    public List<EngReqTaskCardIni> getEngReqTaskCardIniList() {
        return engReqTaskCardIniList;
    }

    public void setEngReqTaskCardIniList(List<EngReqTaskCardIni> engReqTaskCardIniList) {
        this.engReqTaskCardIniList = engReqTaskCardIniList;
    }

    public String getReqDimDesc() {
        return reqDimDesc;
    }

    public void setReqDimDesc(String reqDimDesc) {
        this.reqDimDesc = reqDimDesc;
    }

    public String getReqClasRepair2() {
        return reqClasRepair2;
    }

    public void setReqClasRepair2(String reqClasRepair2) {
        this.reqClasRepair2 = reqClasRepair2;
    }
    

    @XmlTransient
    public Collection<EngRequestQuestion> getEngRequestQuestionCollection() {
        return engRequestQuestionCollection;
    }

    public void setEngRequestQuestionCollection(Collection<EngRequestQuestion> engRequestQuestionCollection) {
        this.engRequestQuestionCollection = engRequestQuestionCollection;
    }

    @XmlTransient
    public Collection<EngDent> getEngDentCollection() {
        return engDentCollection;
    }

    public void setEngDentCollection(Collection<EngDent> engDentCollection) {
        this.engDentCollection = engDentCollection;
    }

    public String getReqRetDescription() {
        return reqRetDescription;
    }

    public void setReqRetDescription(String reqRetDescription) {
        this.reqRetDescription = reqRetDescription;
    }
   
    @XmlTransient
    public Collection<EngDentIni> getEngDentIniCollection() {
        return engDentIniCollection;
    }

    public void setEngDentIniCollection(Collection<EngDentIni> engDentIniCollection) {
        this.engDentIniCollection = engDentIniCollection;
    }   

    @XmlTransient
    public Collection<EngRequestQuestionIni> getEngRequestQuestionIniCollection() {
        return engRequestQuestionIniCollection;
    }

    public void setEngRequestQuestionIniCollection(Collection<EngRequestQuestionIni> engRequestQuestionIniCollection) {
        this.engRequestQuestionIniCollection = engRequestQuestionIniCollection;
    }
    
    public String getReqReffound() {
        return reqReffound;
    }

    public void setReqReffound(String reqReffound) {
        this.reqReffound = reqReffound;
    }

    public String getReqActionIng() {
        return reqActionIng;
    }

    public void setReqActionIng(String reqActionIng) {
        this.reqActionIng = reqActionIng;
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
    
    public String getEngTipoSolcitud() {
        return engTipoSolcitud;
    }

    public void setEngTipoSolcitud(String engTipoSolcitud) {
        this.engTipoSolcitud = engTipoSolcitud;
    }

    public String getEngModelSolcitud() {
        return engModelSolcitud;
    }

    public void setEngModelSolcitud(String engModelSolcitud) {
        this.engModelSolcitud = engModelSolcitud;
    }

    public String getEngDescription() {
        return engDescription;
    }

    public void setEngDescription(String engDescription) {
        this.engDescription = engDescription;
    }
    
    

    }
