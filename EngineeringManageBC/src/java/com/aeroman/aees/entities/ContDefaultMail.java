/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities;

import com.aeroman.aees.entities.grant.SgrCia;
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
 * @author vjuarez
 */
@Entity
@Cacheable(false)
@Table(name = "CONT_DEFAULT_MAIL", catalog = "", schema = "CONT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContDefaultMail.findAll", query = "SELECT c FROM ContDefaultMail c"), 
    @NamedQuery(name = "ContDefaultMail.findByDefId", query = "SELECT c FROM ContDefaultMail c WHERE c.defId = :defId"), 
    @NamedQuery(name = "ContDefaultMail.findByDefMail", query = "SELECT c FROM ContDefaultMail c WHERE c.defMail = :defMail"),
    @NamedQuery(name = "ContDefaultMail.findByDefCiaCode", query = "SELECT c FROM ContDefaultMail c WHERE c.defCiaCode = :defCiaCode"),
    @NamedQuery(name = "ContDefaultMail.findByDefCustomer", query = "SELECT c FROM ContDefaultMail c WHERE c.defCustomer = :defCustomer"), 
    @NamedQuery(name = "ContDefaultMail.findByDefUserAdd", query = "SELECT c FROM ContDefaultMail c WHERE c.defUserAdd = :defUserAdd"), 
    @NamedQuery(name = "ContDefaultMail.findByDefDateAdd", query = "SELECT c FROM ContDefaultMail c WHERE c.defDateAdd = :defDateAdd"), 
    @NamedQuery(name = "ContDefaultMail.findByDefUserUpd", query = "SELECT c FROM ContDefaultMail c WHERE c.defUserUpd = :defUserUpd"), 
    @NamedQuery(name = "ContDefaultMail.findByDefDateUpd", query = "SELECT c FROM ContDefaultMail c WHERE c.defDateUpd = :defDateUpd")})
public class ContDefaultMail implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue (strategy=GenerationType.SEQUENCE,generator="CONT.CONT_DEFAULT_MAIL_SEQ") 
    @SequenceGenerator (name="CONT.CONT_DEFAULT_MAIL_SEQ",sequenceName="CONT.CONT_DEFAULT_MAIL_SEQ",allocationSize=1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "DEF_ID")
    private BigDecimal defId;
    @Size(max = 60)
    @Column(name = "DEF_MAIL")
    private String defMail;
    @JoinColumn(name = "DEF_CIA_CODE", referencedColumnName = "CIA_CODE")
    @ManyToOne(optional = false)
    private SgrCia defCiaCode;
    @JoinColumn(name = "DEF_CUSTOMER", referencedColumnName = "EMC_ID")
    @ManyToOne(optional = false)
    private EngMergeCustomer defCustomer;   
    @Size(max = 50)
    @Column(name = "DEF_USER_ADD")
    private String defUserAdd;
    @Column(name = "DEF_DATE_ADD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date defDateAdd;
    @Size(max = 50)
    @Column(name = "DEF_USER_UPD")
    private String defUserUpd;
    @Column(name = "DEF_DATE_UPD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date defDateUpd;

    public ContDefaultMail() {
        super();
    }

    public ContDefaultMail(BigDecimal defId) {
        this.defId = defId;
    }

    public BigDecimal getDefId() {
        return defId;
    }

    public void setDefId(BigDecimal defId) {
        this.defId = defId;
    }

    public String getDefMail() {
        return defMail;
    }

    public void setDefMail(String defMail) {
        this.defMail = defMail;
    }

    public SgrCia getDefCiaCode() {
        return defCiaCode;
    }

    public void setDefCiaCode(SgrCia defCiaCode) {
        this.defCiaCode = defCiaCode;
    }

    public EngMergeCustomer getDefCustomer() {
        return defCustomer;
    }

    public void setDefCustomer(EngMergeCustomer defCustomer) {
        this.defCustomer = defCustomer;
    }

    public String getDefUserAdd() {
        return defUserAdd;
    }

    public void setDefUserAdd(String defUserAdd) {
        this.defUserAdd = defUserAdd;
    }

    public Date getDefDateAdd() {
        return defDateAdd;
    }

    public void setDefDateAdd(Date defDateAdd) {
        this.defDateAdd = defDateAdd;
    }

    public String getDefUserUpd() {
        return defUserUpd;
    }

    public void setDefUserUpd(String defUserUpd) {
        this.defUserUpd = defUserUpd;
    }

    public Date getDefDateUpd() {
        return defDateUpd;
    }

    public void setDefDateUpd(Date defDateUpd) {
        this.defDateUpd = defDateUpd;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (defId != null ? defId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContDefaultMail)) {
            return false;
        }
        ContDefaultMail other = (ContDefaultMail) object;
        if ((this.defId == null && other.defId != null) || (this.defId != null && !this.defId.equals(other.defId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.ContDefaultMail[ defId=" + defId + " ]";
    }
    
}