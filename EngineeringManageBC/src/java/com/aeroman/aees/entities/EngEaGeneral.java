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
@Table(name = "ENG_EA_GENERAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngEaGeneral.findAll", query = "SELECT e FROM EngEaGeneral e"),
    @NamedQuery(name = "EngEaGeneral.findByEagId", query = "SELECT e FROM EngEaGeneral e WHERE e.eagId = :eagId"),
    @NamedQuery(name = "EngEaGeneral.findByReqMessageid", query = "SELECT e FROM EngEaGeneral e WHERE e.reqMessageid = :reqMessageid"),
    @NamedQuery(name = "EngEaGeneral.findByEagCorrelative", query = "SELECT e FROM EngEaGeneral e WHERE e.eagCorrelative = :eagCorrelative"),
    @NamedQuery(name = "EngEaGeneral.findByEagYear", query = "SELECT e FROM EngEaGeneral e WHERE e.eagYear = :eagYear"),
    @NamedQuery(name = "EngEaGeneral.findByAegIngComm", query = "SELECT e FROM EngEaGeneral e WHERE e.aegIngComm = :aegIngComm"),
    @NamedQuery(name = "EngEaGeneral.findByEagAta", query = "SELECT e FROM EngEaGeneral e WHERE e.eagAta = :eagAta"),
    @NamedQuery(name = "EngEaGeneral.findByEagDateEmi", query = "SELECT e FROM EngEaGeneral e WHERE e.eagDateEmi = :eagDateEmi"),
    @NamedQuery(name = "EngEaGeneral.findByEagModel", query = "SELECT e FROM EngEaGeneral e WHERE e.eagModel = :eagModel"),
    @NamedQuery(name = "EngEaGeneral.findByEagSn", query = "SELECT e FROM EngEaGeneral e WHERE e.eagSn = :eagSn"),
    @NamedQuery(name = "EngEaGeneral.findByEagCmpSn", query = "SELECT e FROM EngEaGeneral e WHERE e.eagCmpSn = :eagCmpSn"),
    @NamedQuery(name = "EngEaGeneral.findByEagCmpPn", query = "SELECT e FROM EngEaGeneral e WHERE e.eagCmpPn = :eagCmpPn"),
    @NamedQuery(name = "EngEaGeneral.findByEagTitle", query = "SELECT e FROM EngEaGeneral e WHERE e.eagTitle = :eagTitle"),
    @NamedQuery(name = "EngEaGeneral.findByEstEstatus", query = "SELECT e FROM EngEaGeneral e WHERE e.estEstatus = :estEstatus"),
    @NamedQuery(name = "EngEaGeneral.findByAegDateRev", query = "SELECT e FROM EngEaGeneral e WHERE e.aegDateRev = :aegDateRev"),
    @NamedQuery(name = "EngEaGeneral.findByAegRevNum", query = "SELECT e FROM EngEaGeneral e WHERE e.aegRevNum = :aegRevNum"),
    @NamedQuery(name = "EngEaGeneral.findByAegDateCrea", query = "SELECT e FROM EngEaGeneral e WHERE e.aegDateCrea = :aegDateCrea"),
    @NamedQuery(name = "EngEaGeneral.findByAegUsrCrea", query = "SELECT e FROM EngEaGeneral e WHERE e.aegUsrCrea = :aegUsrCrea"),
    @NamedQuery(name = "EngEaGeneral.findByAegDateMod", query = "SELECT e FROM EngEaGeneral e WHERE e.aegDateMod = :aegDateMod"),
    @NamedQuery(name = "EngEaGeneral.findByAegUsrMod", query = "SELECT e FROM EngEaGeneral e WHERE e.aegUsrMod = :aegUsrMod"),
    @NamedQuery(name = "EngEaGeneral.findByEagTail", query = "SELECT e FROM EngEaGeneral e WHERE e.eagTail = :eagTail"),
    @NamedQuery(name = "EngEaGeneral.findByEagCustomer", query = "SELECT e FROM EngEaGeneral e WHERE e.eagCustomer = :eagCustomer"),
    @NamedQuery(name = "EngEaGeneral.findByFltCod", query = "SELECT e FROM EngEaGeneral e WHERE e.fltCod = :fltCod"),
    @NamedQuery(name = "EngEaGeneral.findByCompany", query = "SELECT e FROM EngEaGeneral e WHERE e.company = :company"),
    @NamedQuery(name = "EngEaGeneral.findByFormat", query = "SELECT e FROM EngEaGeneral e WHERE e.format = :format")})
public class EngEaGeneral implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENG_EA_GENERAL_SEQ")
    @SequenceGenerator(name = "ENG_EA_GENERAL_SEQ", sequenceName = "ENG_EA_GENERAL_SEQ", allocationSize = 1)
    @NotNull
    @Column(name = "EAG_ID")
    private BigDecimal eagId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "REQ_MESSAGEID")
    private BigInteger reqMessageid;
    @Size(max = 6)
    @Column(name = "EAG_CORRELATIVE")
    private String eagCorrelative;
    @Column(name = "EAG_YEAR")
    private BigInteger eagYear;
    @Size(max = 30)
    @Column(name = "AEG_ING_COMM")
    private String aegIngComm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EAG_ATA")
    private short eagAta;
    @Column(name = "EAG_DATE_EMI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date eagDateEmi;
    @Size(max = 50)
    @Column(name = "EAG_MODEL")
    private String eagModel;
    @Size(max = 50)
    @Column(name = "EAG_SN")
    private String eagSn;
    @Size(max = 50)
    @Column(name = "EAG_CMP_SN")
    private String eagCmpSn;
    @Size(max = 50)
    @Column(name = "EAG_CMP_PN")
    private String eagCmpPn;
    @Size(max = 4000)
    @Column(name = "EAG_TITLE")
    private String eagTitle;
    @JoinColumn(name = "EST_ESTATUS", referencedColumnName = "EAE_ID")
    @ManyToOne(optional = false)
    private EngEaEstatus estEstatus;
    @Column(name = "AEG_DATE_REV")
    @Temporal(TemporalType.TIMESTAMP)
    private Date aegDateRev;
    @Column(name = "AEG_REV_NUM")
    private BigInteger aegRevNum;
    @Column(name = "AEG_NUM_PART")
    private BigInteger aegNumPart;    
    @Column(name = "AEG_DATE_CREA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date aegDateCrea;
    @Size(max = 30)
    @Column(name = "AEG_USR_CREA")
    private String aegUsrCrea;
    @Column(name = "AEG_DATE_MOD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date aegDateMod;
    @Size(max = 30)
    @Column(name = "AEG_USR_MOD")
    private String aegUsrMod;
    @Size(max = 20)
    @Column(name = "EAG_TAIL")
    private String eagTail;
    @Size(max = 20)
    @Column(name = "EAG_CUSTOMER")
    private String eagCustomer;
    @Size(max = 20)
    @Column(name = "FLT_COD")
    private String fltCod;
    @Size(max = 50)
    @Column(name = "COMPANY")
    private String company;
    @Size(max = 4000)
    @Column(name = "FORMAT")
    private String format;    
    @Size(max = 1000)
    @Column(name = "EAG_DESCRIPTION")
    private String eagDescription; 
    @Transient
    private boolean chkReparar= false;
    @Transient
    private boolean chkModAlte =false;
    @Transient
    private boolean chkinspeccion =false;
    @Transient
    private boolean chkpermanet =false;
    @Transient
    private boolean chkInterim =false;
    @Transient
    private boolean chktimelimited =false;
    @Transient
    private boolean chkMayor =false;
    @Transient
    private boolean chkMenor =false;
    @Transient
    private String numeroEsr;
    @Transient
    private String numeroEa;
    @Transient
    private String workOrderMostrar;
    @Transient
    private String yearEA;
    @Transient
    private String userEA;
    @Transient
    private String esrEA;

    public EngEaGeneral() {
        super();
    }

    public EngEaGeneral(BigDecimal eagId) {
        this.eagId = eagId;
    }

    public EngEaGeneral(BigDecimal eagId, BigInteger reqMessageid, short eagAta, EngEaEstatus estEstatus) {
        this.eagId = eagId;
        this.reqMessageid = reqMessageid;
        this.eagAta = eagAta;
        this.estEstatus = estEstatus;
    }

    public BigDecimal getEagId() {
        return eagId;
    }

    public void setEagId(BigDecimal eagId) {
        this.eagId = eagId;
    }

    public BigInteger getReqMessageid() {
        return reqMessageid;
    }

    public void setReqMessageid(BigInteger reqMessageid) {
        this.reqMessageid = reqMessageid;
    }

    public String getEagCorrelative() {
        return eagCorrelative;
    }

    public void setEagCorrelative(String eagCorrelative) {
        this.eagCorrelative = eagCorrelative;
    }

    public BigInteger getEagYear() {
        return eagYear;
    }

    public void setEagYear(BigInteger eagYear) {
        this.eagYear = eagYear;
    }

    public String getAegIngComm() {
        return aegIngComm;
    }

    public void setAegIngComm(String aegIngComm) {
        this.aegIngComm = aegIngComm;
    }

    public short getEagAta() {
        return eagAta;
    }

    public void setEagAta(short eagAta) {
        this.eagAta = eagAta;
    }

    public Date getEagDateEmi() {
        return eagDateEmi;
    }

    public void setEagDateEmi(Date eagDateEmi) {
        this.eagDateEmi = eagDateEmi;
    }

    public String getEagModel() {
        return eagModel;
    }

    public void setEagModel(String eagModel) {
        this.eagModel = eagModel;
    }

    public String getEagSn() {
        return eagSn;
    }

    public void setEagSn(String eagSn) {
        this.eagSn = eagSn;
    }

    public String getEagCmpSn() {
        return eagCmpSn;
    }

    public void setEagCmpSn(String eagCmpSn) {
        this.eagCmpSn = eagCmpSn;
    }

    public String getEagCmpPn() {
        return eagCmpPn;
    }

    public void setEagCmpPn(String eagCmpPn) {
        this.eagCmpPn = eagCmpPn;
    }

    public String getEagTitle() {
        return eagTitle;
    }

    public void setEagTitle(String eagTitle) {
        this.eagTitle = eagTitle;
    }

    public EngEaEstatus getEstEstatus() {
        return estEstatus;
    }

    public void setEstEstatus(EngEaEstatus estEstatus) {
        this.estEstatus = estEstatus;
    }

    public Date getAegDateRev() {
        return aegDateRev;
    }

    public void setAegDateRev(Date aegDateRev) {
        this.aegDateRev = aegDateRev;
    }

    public BigInteger getAegRevNum() {
        return aegRevNum;
    }

    public void setAegRevNum(BigInteger aegRevNum) {
        this.aegRevNum = aegRevNum;
    }

    public Date getAegDateCrea() {
        return aegDateCrea;
    }

    public void setAegDateCrea(Date aegDateCrea) {
        this.aegDateCrea = aegDateCrea;
    }

    public String getAegUsrCrea() {
        return aegUsrCrea;
    }

    public void setAegUsrCrea(String aegUsrCrea) {
        this.aegUsrCrea = aegUsrCrea;
    }

    public Date getAegDateMod() {
        return aegDateMod;
    }

    public void setAegDateMod(Date aegDateMod) {
        this.aegDateMod = aegDateMod;
    }

    public String getAegUsrMod() {
        return aegUsrMod;
    }

    public void setAegUsrMod(String aegUsrMod) {
        this.aegUsrMod = aegUsrMod;
    }

    public String getEagTail() {
        return eagTail;
    }

    public void setEagTail(String eagTail) {
        this.eagTail = eagTail;
    }

    public String getEagCustomer() {
        return eagCustomer;
    }

    public void setEagCustomer(String eagCustomer) {
        this.eagCustomer = eagCustomer;
    }

    public String getFltCod() {
        return fltCod;
    }

    public void setFltCod(String fltCod) {
        this.fltCod = fltCod;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public boolean isChkReparar() {
        return chkReparar;
    }

    public void setChkReparar(boolean chkReparar) {
        this.chkReparar = chkReparar;
    }

    public boolean isChkModAlte() {
        return chkModAlte;
    }

    public void setChkModAlte(boolean chkModAlte) {
        this.chkModAlte = chkModAlte;
    }

    public boolean isChkinspeccion() {
        return chkinspeccion;
    }

    public void setChkinspeccion(boolean chkinspeccion) {
        this.chkinspeccion = chkinspeccion;
    }

    public boolean isChkpermanet() {
        return chkpermanet;
    }

    public void setChkpermanet(boolean chkpermanet) {
        this.chkpermanet = chkpermanet;
    }

    public boolean isChkInterim() {
        return chkInterim;
    }

    public void setChkInterim(boolean chkInterim) {
        this.chkInterim = chkInterim;
    }

    public boolean isChktimelimited() {
        return chktimelimited;
    }

    public void setChktimelimited(boolean chktimelimited) {
        this.chktimelimited = chktimelimited;
    }

    public boolean isChkMayor() {
        return chkMayor;
    }

    public void setChkMayor(boolean chkMayor) {
        this.chkMayor = chkMayor;
    }

    public boolean isChkMenor() {
        return chkMenor;
    }

    public void setChkMenor(boolean chkMenor) {
        this.chkMenor = chkMenor;
    }

    public String getNumeroEsr() {
        return numeroEsr;
    }

    public void setNumeroEsr(String numeroEsr) {
        this.numeroEsr = numeroEsr;
    }

    public String getNumeroEa() {
        return numeroEa;
    }

    public void setNumeroEa(String numeroEa) {
        this.numeroEa = numeroEa;
    }

    public String getWorkOrderMostrar() {
        return workOrderMostrar;
    }

    public void setWorkOrderMostrar(String workOrderMostrar) {
        this.workOrderMostrar = workOrderMostrar;
    }

    public BigInteger getAegNumPart() {
        return aegNumPart;
    }

    public void setAegNumPart(BigInteger aegNumPart) {
        this.aegNumPart = aegNumPart;
    }

    public String getYearEA() {
        return yearEA;
    }

    public void setYearEA(String yearEA) {
        this.yearEA = yearEA;
    }

    public String getUserEA() {
        return userEA;
    }

    public void setUserEA(String userEA) {
        this.userEA = userEA;
    }    

    public String getEsrEA() {
        return esrEA;
    }

    public void setEsrEA(String esrEA) {
        this.esrEA = esrEA;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eagId != null ? eagId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EngEaGeneral)) {
            return false;
        }
        EngEaGeneral other = (EngEaGeneral) object;
        if ((this.eagId == null && other.eagId != null) || (this.eagId != null && !this.eagId.equals(other.eagId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngEaGeneral[ eagId=" + eagId + " ]";
    }

    public String getEagDescription() {
        return eagDescription;
    }

    public void setEagDescription(String eagDescription) {
        this.eagDescription = eagDescription;
    }
    
}
