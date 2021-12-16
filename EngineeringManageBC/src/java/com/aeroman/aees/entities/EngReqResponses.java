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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author scruz
 */
@Entity
@Cacheable(false)
@Table(name = "ENG_REQ_RESPONSES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngReqResponses.findAll", query = "SELECT e FROM EngReqResponses e"),
    @NamedQuery(name = "EngReqResponses.findByResId", query = "SELECT e FROM EngReqResponses e WHERE e.resId = :resId"),
    @NamedQuery(name = "EngReqResponses.findByReqMessageid", query = "SELECT e FROM EngReqResponses e WHERE e.reqMessageid = :reqMessageid"),
    @NamedQuery(name = "EngReqResponses.findByResSubject", query = "SELECT e FROM EngReqResponses e WHERE e.resSubject = :resSubject"),
    @NamedQuery(name = "EngReqResponses.findByResBody", query = "SELECT e FROM EngReqResponses e WHERE e.resBody = :resBody"),
    @NamedQuery(name = "EngReqResponses.findByResCodUsrMsg", query = "SELECT e FROM EngReqResponses e WHERE e.resCodUsrMsg = :resCodUsrMsg"),
    @NamedQuery(name = "EngReqResponses.findByResDateMsg", query = "SELECT e FROM EngReqResponses e WHERE e.resDateMsg = :resDateMsg"),
    @NamedQuery(name = "EngReqResponses.findByResEmailsTo", query = "SELECT e FROM EngReqResponses e WHERE e.resEmailsTo = :resEmailsTo"),
    @NamedQuery(name = "EngReqResponses.findByResEmailsCc", query = "SELECT e FROM EngReqResponses e WHERE e.resEmailsCc = :resEmailsCc"),
    @NamedQuery(name = "EngReqResponses.findByResUsrIns", query = "SELECT e FROM EngReqResponses e WHERE e.resUsrIns = :resUsrIns"),
    @NamedQuery(name = "EngReqResponses.findByResDateIns", query = "SELECT e FROM EngReqResponses e WHERE e.resDateIns = :resDateIns"),
    @NamedQuery(name = "EngReqResponses.findByResUsrUpd", query = "SELECT e FROM EngReqResponses e WHERE e.resUsrUpd = :resUsrUpd"),
    @NamedQuery(name = "EngReqResponses.findByResDateUpd", query = "SELECT e FROM EngReqResponses e WHERE e.resDateUpd = :resDateUpd"),
    @NamedQuery(name = "EngReqResponses.findByResAttachFile", query = "SELECT e FROM EngReqResponses e WHERE e.resAttachFile = :resAttachFile"),
    @NamedQuery(name = "EngReqResponses.findByresEmailsToMos", query = "SELECT e FROM EngReqResponses e WHERE e.resEmailsToMos = :resEmailsToMos"),
    @NamedQuery(name = "EngReqResponses.findByresCheck", query = "SELECT e FROM EngReqResponses e WHERE e.resCheck = :resCheck"),
    @NamedQuery(name = "EngReqResponses.findByresRolUser", query = "SELECT e FROM EngReqResponses e WHERE e.resRolUser = :resRolUser")}) 
public class EngReqResponses implements Serializable {
    @OneToMany(mappedBy = "msgCodResponse")
    private Collection<MsjAdjuntos> msjAdjuntosCollection;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RES_ID")
    private BigDecimal resId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "REQ_MESSAGEID")
    private BigInteger reqMessageid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "RES_SUBJECT")
    private String resSubject;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4000)
    @Column(name = "RES_BODY")
    private String resBody;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "RES_COD_USR_MSG")
    private String resCodUsrMsg;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RES_DATE_MSG")
    @Temporal(TemporalType.TIMESTAMP)
    private Date resDateMsg;
    @Size(max = 4000)
    @Column(name = "RES_EMAILS_TO")
    private String resEmailsTo;
    @Size(max = 4000)
    @Column(name = "RES_EMAILS_CC")
    private String resEmailsCc;
    @Size(max = 30)
    @Column(name = "RES_USR_INS")
    private String resUsrIns;
    @Column(name = "RES_DATE_INS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date resDateIns;
    @Size(max = 30)
    @Column(name = "RES_USR_UPD")
    private String resUsrUpd;
    @Column(name = "RES_DATE_UPD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date resDateUpd;
    @Size(max = 1)
    @Column(name = "RES_ATTACH_FILE")
    private String resAttachFile;
    @Size(max =4000)
    @Column(name = "RES_EMAILS_TO_MOS")
    private String resEmailsToMos;
    @Size(max =5)
    @Column(name = "RES_CHECK")
    private String resCheck;
    @Size(max =50)
    @Column(name = "RES_ROL_USER")
    private String resRolUser;
    
    //Campos agregados para requerimiento: 82042
    @Size(max =20)
    @Column(name = "RES_COD_MSJ")
    private String resCodMsj;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "RES_CORR_ESR")
    private BigInteger resCorrEsr;
    
    @Size(max =1)
    @Column(name = "RES_RESP_PRI")
    private String resRespPri;
    
    @Size(max =80)
    @Column(name = "RES_SEG_ENG")
    private String resSegEng;
    
    @Size(max =1)
    @Column(name = "RES_FIRST_RESP")
    private String resFirstResp;

    public EngReqResponses() {
        super();
    }

    public EngReqResponses(BigDecimal resId) {
        this.resId = resId;
    }

    public EngReqResponses(BigDecimal resId, BigInteger reqMessageid, String resSubject, String resBody, String resCodUsrMsg, Date resDateMsg) {
        this.resId = resId;
        this.reqMessageid = reqMessageid;
        this.resSubject = resSubject;
        this.resBody = resBody;
        this.resCodUsrMsg = resCodUsrMsg;
        this.resDateMsg = resDateMsg;
        
    }

    public BigDecimal getResId() {
        return resId;
    }

    public void setResId(BigDecimal resId) {
        this.resId = resId;
    }

    public BigInteger getReqMessageid() {
        return reqMessageid;
    }

    public void setReqMessageid(BigInteger reqMessageid) {
        this.reqMessageid = reqMessageid;
    }

    public String getResSubject() {
        return resSubject;
    }

    public void setResSubject(String resSubject) {
        this.resSubject = resSubject;
    }

    public String getResBody() {
        return resBody;
    }

    public void setResBody(String resBody) {
        this.resBody = resBody;
    }

    public String getResCodUsrMsg() {
        return resCodUsrMsg;
    }

    public void setResCodUsrMsg(String resCodUsrMsg) {
        this.resCodUsrMsg = resCodUsrMsg;
    }

    public Date getResDateMsg() {
        return resDateMsg;
    }

    public void setResDateMsg(Date resDateMsg) {
        this.resDateMsg = resDateMsg;
    }

    public String getResEmailsTo() {
        return resEmailsTo;
    }

    public void setResEmailsTo(String resEmailsTo) {
        this.resEmailsTo = resEmailsTo;
    }

    public String getResEmailsCc() {
        return resEmailsCc;
    }

    public void setResEmailsCc(String resEmailsCc) {
        this.resEmailsCc = resEmailsCc;
    }

    public String getResUsrIns() {
        return resUsrIns;
    }

    public void setResUsrIns(String resUsrIns) {
        this.resUsrIns = resUsrIns;
    }

    public Date getResDateIns() {
        return resDateIns;
    }

    public void setResDateIns(Date resDateIns) {
        this.resDateIns = resDateIns;
    }

    public String getResUsrUpd() {
        return resUsrUpd;
    }

    public void setResUsrUpd(String resUsrUpd) {
        this.resUsrUpd = resUsrUpd;
    }

    public Date getResDateUpd() {
        return resDateUpd;
    }

    public void setResDateUpd(Date resDateUpd) {
        this.resDateUpd = resDateUpd;
    }

    public String getResAttachFile() {
        return resAttachFile;
    }

    public void setResAttachFile(String resAttachFile) {
        this.resAttachFile = resAttachFile;
    }

    public String getResEmailsToMos() {
        return resEmailsToMos;
    }

    public void setResEmailsToMos(String resEmailsToMos) {
        this.resEmailsToMos = resEmailsToMos;
    }   

    public String getResCheck() {
        return resCheck;
    }

    public void setResCheck(String resCheck) {
        this.resCheck = resCheck;
    }

    public String getResRolUser() {
        return resRolUser;
    }

    public void setResRolUser(String resRolUser) {
        this.resRolUser = resRolUser;
    }
    
    public String getResCodMsj() {
        return resCodMsj;
    }

    public void setResCodMsj(String resCodMsj) {
        this.resCodMsj = resCodMsj;
    }

    public BigInteger getResCorrEsr() {
        return resCorrEsr;
    }

    public void setResCorrEsr(BigInteger resCorrEsr) {
        this.resCorrEsr = resCorrEsr;
    }

    public String getResRespPri() {
        return resRespPri;
    }

    public void setResRespPri(String resRespPri) {
        this.resRespPri = resRespPri;
    }

    public String getResSegEng() {
        return resSegEng;
    }

    public void setResSegEng(String resSegEng) {
        this.resSegEng = resSegEng;
    }

    public String getResFirstResp() {
        return resFirstResp;
    }

    public void setResFirstResp(String resFirstResp) {
        this.resFirstResp = resFirstResp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (resId != null ? resId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof EngReqResponses)) {
            return false;
        }
        EngReqResponses other = (EngReqResponses) object;
        return !((this.resId == null && other.resId != null) || (this.resId != null && !this.resId.equals(other.resId)));
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngReqResponses[ resId=" + resId + " ]";
    }

    @XmlTransient
    public Collection<MsjAdjuntos> getMsjAdjuntosCollection() {
        return msjAdjuntosCollection;
    }

    public void setMsjAdjuntosCollection(Collection<MsjAdjuntos> msjAdjuntosCollection) {
        this.msjAdjuntosCollection = msjAdjuntosCollection;
    }
    
}
