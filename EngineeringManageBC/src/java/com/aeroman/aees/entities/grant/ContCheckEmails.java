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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Cacheable(false)
@Table(name = "CONT_CHECK_EMAILS", catalog = "", schema = "CONT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContCheckEmails.findAll", query = "SELECT c FROM ContCheckEmails c"),
    @NamedQuery(name = "ContCheckEmails.findByContCheckEmailsId", query = "SELECT c FROM ContCheckEmails c WHERE c.contCheckEmailsId = :contCheckEmailsId"),
    @NamedQuery(name = "ContCheckEmails.findByCemEmail", query = "SELECT c FROM ContCheckEmails c WHERE c.cemEmail = :cemEmail"),
    @NamedQuery(name = "ContCheckEmails.findByCemCodUsrIns", query = "SELECT c FROM ContCheckEmails c WHERE c.cemCodUsrIns = :cemCodUsrIns"),
    @NamedQuery(name = "ContCheckEmails.findByCemFechaIns", query = "SELECT c FROM ContCheckEmails c WHERE c.cemFechaIns = :cemFechaIns"),
    @NamedQuery(name = "ContCheckEmails.findByCemCodUsrAct", query = "SELECT c FROM ContCheckEmails c WHERE c.cemCodUsrAct = :cemCodUsrAct"),
    @NamedQuery(name = "ContCheckEmails.findByCemFechaAct", query = "SELECT c FROM ContCheckEmails c WHERE c.cemFechaAct = :cemFechaAct")})
public class ContCheckEmails implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue (strategy=GenerationType.SEQUENCE,generator="CONT.CONT_CHECK_EMAILS_SEQ") 
    @SequenceGenerator (name="CONT.CONT_CHECK_EMAILS_SEQ",sequenceName="CONT.CONT_CHECK_EMAILS_SEQ",allocationSize=1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONT_CHECK_EMAILS_ID")
    private BigDecimal contCheckEmailsId;
    @Size(max = 60)
    @Column(name = "CEM_EMAIL")
    private String cemEmail;
    @Size(max = 30)
    @Column(name = "CEM_COD_USR_INS")
    private String cemCodUsrIns;
    @Column(name = "CEM_FECHA_INS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cemFechaIns;
    @Size(max = 30)
    @Column(name = "CEM_COD_USR_ACT")
    private String cemCodUsrAct;
    @Column(name = "CEM_FECHA_ACT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cemFechaAct;
    @JoinColumn(name = "CONT_CHECK_ID", referencedColumnName = "CONT_CHECK_ID")
    @ManyToOne(optional = false)
    private ContCheck contCheckId;

    public ContCheckEmails() {
        super();
    }

    public ContCheckEmails(BigDecimal contCheckEmailsId) {
        this.contCheckEmailsId = contCheckEmailsId;
    }

    public BigDecimal getContCheckEmailsId() {
        return contCheckEmailsId;
    }

    public void setContCheckEmailsId(BigDecimal contCheckEmailsId) {
        this.contCheckEmailsId = contCheckEmailsId;
    }

    public String getCemEmail() {
        return cemEmail;
    }

    public void setCemEmail(String cemEmail) {
        this.cemEmail = cemEmail;
    }

    public String getCemCodUsrIns() {
        return cemCodUsrIns;
    }

    public void setCemCodUsrIns(String cemCodUsrIns) {
        this.cemCodUsrIns = cemCodUsrIns;
    }

    public Date getCemFechaIns() {
        return cemFechaIns;
    }

    public void setCemFechaIns(Date cemFechaIns) {
        this.cemFechaIns = cemFechaIns;
    }

    public String getCemCodUsrAct() {
        return cemCodUsrAct;
    }

    public void setCemCodUsrAct(String cemCodUsrAct) {
        this.cemCodUsrAct = cemCodUsrAct;
    }

    public Date getCemFechaAct() {
        return cemFechaAct;
    }

    public void setCemFechaAct(Date cemFechaAct) {
        this.cemFechaAct = cemFechaAct;
    }

    public ContCheck getContCheckId() {
        return contCheckId;
    }

    public void setContCheckId(ContCheck contCheckId) {
        this.contCheckId = contCheckId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contCheckEmailsId != null ? contCheckEmailsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof ContCheckEmails)) {
            return false;
        }
        ContCheckEmails other = (ContCheckEmails) object;
        if ((this.contCheckEmailsId == null && other.contCheckEmailsId != null) || (this.contCheckEmailsId != null && !this.contCheckEmailsId.equals(other.contCheckEmailsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.grant.ContCheckEmails[ contCheckEmailsId=" + contCheckEmailsId + " ]";
    }
    
}
