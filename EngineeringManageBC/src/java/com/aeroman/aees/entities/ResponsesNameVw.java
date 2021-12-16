package com.aeroman.aees.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Cacheable(false)
@Table(name="RESPONSES_NAME_VW")
@XmlRootElement
@NamedQueries({@javax.persistence.NamedQuery(name="ResponsesNameVw.findAll", query="SELECT r FROM ResponsesNameVw r"), @javax.persistence.NamedQuery(name="ResponsesNameVw.findByResId", query="SELECT r FROM ResponsesNameVw r WHERE r.resId = :resId"), @javax.persistence.NamedQuery(name="ResponsesNameVw.findByReqMessageid", query="SELECT r FROM ResponsesNameVw r WHERE r.reqMessageid = :reqMessageid"), @javax.persistence.NamedQuery(name="ResponsesNameVw.findByResSubject", query="SELECT r FROM ResponsesNameVw r WHERE r.resSubject = :resSubject"), @javax.persistence.NamedQuery(name="ResponsesNameVw.findByResBody", query="SELECT r FROM ResponsesNameVw r WHERE r.resBody = :resBody"), @javax.persistence.NamedQuery(name="ResponsesNameVw.findByResCodUsrMsg", query="SELECT r FROM ResponsesNameVw r WHERE r.resCodUsrMsg = :resCodUsrMsg"), @javax.persistence.NamedQuery(name="ResponsesNameVw.findByResDateMsg", query="SELECT r FROM ResponsesNameVw r WHERE r.resDateMsg = :resDateMsg"), @javax.persistence.NamedQuery(name="ResponsesNameVw.findByResEmailsTo", query="SELECT r FROM ResponsesNameVw r WHERE r.resEmailsTo = :resEmailsTo"), @javax.persistence.NamedQuery(name="ResponsesNameVw.findByResEmailsCc", query="SELECT r FROM ResponsesNameVw r WHERE r.resEmailsCc = :resEmailsCc"), @javax.persistence.NamedQuery(name="ResponsesNameVw.findByResUsrIns", query="SELECT r FROM ResponsesNameVw r WHERE r.resUsrIns = :resUsrIns"), @javax.persistence.NamedQuery(name="ResponsesNameVw.findByResDateIns", query="SELECT r FROM ResponsesNameVw r WHERE r.resDateIns = :resDateIns"), @javax.persistence.NamedQuery(name="ResponsesNameVw.findByResUsrUpd", query="SELECT r FROM ResponsesNameVw r WHERE r.resUsrUpd = :resUsrUpd"), @javax.persistence.NamedQuery(name="ResponsesNameVw.findByResDateUpd", query="SELECT r FROM ResponsesNameVw r WHERE r.resDateUpd = :resDateUpd"), @javax.persistence.NamedQuery(name="ResponsesNameVw.findByResAttachFile", query="SELECT r FROM ResponsesNameVw r WHERE r.resAttachFile = :resAttachFile"), @javax.persistence.NamedQuery(name="ResponsesNameVw.findByPrimerNombre", query="SELECT r FROM ResponsesNameVw r WHERE r.primerNombre = :primerNombre"), @javax.persistence.NamedQuery(name="ResponsesNameVw.findBySegundoNombre", query="SELECT r FROM ResponsesNameVw r WHERE r.segundoNombre = :segundoNombre"), @javax.persistence.NamedQuery(name="ResponsesNameVw.findByPrimerApellido", query="SELECT r FROM ResponsesNameVw r WHERE r.primerApellido = :primerApellido"), @javax.persistence.NamedQuery(name="ResponsesNameVw.findBySegundoApellido", query="SELECT r FROM ResponsesNameVw r WHERE r.segundoApellido = :segundoApellido"), @javax.persistence.NamedQuery(name="ResponsesNameVw.findByFullUserName", query="SELECT r FROM ResponsesNameVw r WHERE r.fullUserName = :fullUserName")})
public class ResponsesNameVw  implements Serializable
{
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional=false)
  @NotNull
  @Column(name="RES_ID")
  private BigDecimal resId;
  @Basic(optional=false)
  @NotNull
  @Column(name="REQ_MESSAGEID")
  private BigDecimal reqMessageid;
   
  @Basic(optional=false)
  @Column(name="RES_CORR_ESR")
  private String resCorrEsr;
  
  @Basic(optional=false)
  @NotNull
  @Size(min=1, max=400)
  @Column(name="RES_SUBJECT")
  private String resSubject;
  @Basic(optional=false)
  @NotNull
  @Size(min=1, max=4000)
  @Column(name="RES_BODY")
  private String resBody;
  @Basic(optional=false)
  @NotNull
  @Size(min=1, max=30)
  @Column(name="RES_COD_USR_MSG")
  private String resCodUsrMsg;
  @Basic(optional=false)
  @NotNull
  @Column(name="RES_DATE_MSG")
  @Temporal(TemporalType.TIMESTAMP)
  private Date resDateMsg;
  @Basic(optional=false)
  @NotNull
  @Size(min=1, max=500)
  @Column(name="RES_EMAILS_TO")
  private String resEmailsTo;
  @Size(max=4000)
  @Column(name="RES_EMAILS_CC")
  private String resEmailsCc;
  @Size(max=30)
  @Column(name="RES_USR_INS")
  private String resUsrIns;
  @Column(name="RES_DATE_INS")
  @Temporal(TemporalType.TIMESTAMP)
  private Date resDateIns;
  @Size(max=30)
  @Column(name="RES_USR_UPD")
  private String resUsrUpd;
  @Column(name="RES_DATE_UPD")
  @Temporal(TemporalType.TIMESTAMP)
  private Date resDateUpd;
  @Size(max=1)
  @Column(name="RES_ATTACH_FILE")
  private String resAttachFile;
  @Size(max=1)
  @Column(name="TIENE_ARCHIVOS")
  private String tieneArchivos;
  @Size(max=255)
  @Column(name="PRIMER_NOMBRE")
  private String primerNombre;
  @Size(max=255)
  @Column(name="SEGUNDO_NOMBRE")
  private String segundoNombre;
  @Size(max=255)
  @Column(name="PRIMER_APELLIDO")
  private String primerApellido;
  @Size(max=255)
  @Column(name="SEGUNDO_APELLIDO")
  private String segundoApellido;
  @Size(max=255)
  @Column(name="FULL_USER_NAME")
  private String fullUserName;
  @Size(max=5)
  @Column(name="RES_CHECK")
  private String resCheck;
  @Size(max=50)
  @Column(name="RES_ROL_USER")
  private String resRolUser;
  
  public ResponsesNameVw() {
      super();
  }
  
  public BigDecimal getResId()
  {
    return resId;
  }
  
  public void setResId(BigDecimal resId) {
    this.resId = resId;
  }
  
  public BigDecimal getReqMessageid() {
    return reqMessageid;
  }
  
  public void setReqMessageid(BigDecimal reqMessageid) {
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
  
  public String getTieneArchivos() {
    return tieneArchivos;
  }
  
  public void setTieneArchivos(String tieneArchivos) {
    this.tieneArchivos = tieneArchivos;
  }
  
  public String getPrimerNombre()
  {
    return primerNombre;
  }
  
  public void setPrimerNombre(String primerNombre) {
    this.primerNombre = primerNombre;
  }
  
  public String getSegundoNombre() {
    return segundoNombre;
  }
  
  public void setSegundoNombre(String segundoNombre) {
    this.segundoNombre = segundoNombre;
  }
  
  public String getPrimerApellido() {
    return primerApellido;
  }
  
  public void setPrimerApellido(String primerApellido) {
    this.primerApellido = primerApellido;
  }
  
  public String getSegundoApellido() {
    return segundoApellido;
  }
  
  public void setSegundoApellido(String segundoApellido) {
    this.segundoApellido = segundoApellido;
  }
  
  public String getFullUserName() {
    return fullUserName;
  }
  
  public void setFullUserName(String fullUserName) {
    this.fullUserName = fullUserName;
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

    public String getResCorrEsr() {
        return resCorrEsr;
    }

    public void setResCorrEsr(String resCorrEsr) {
        this.resCorrEsr = resCorrEsr;
    }
   
  
}