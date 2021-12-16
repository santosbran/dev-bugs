/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities.grant;

import java.io.Serializable;
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

/**
 *
 * @author Usuario
 */
@Entity
@Cacheable(false)
@Table(name = "CONT_ATAS", catalog = "", schema = "CONT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContAtas.findAll", query = "SELECT c FROM ContAtas c"),
    @NamedQuery(name = "ContAtas.findByAtaNumata", query = "SELECT c FROM ContAtas c WHERE c.ataNumata = :ataNumata"),
    @NamedQuery(name = "ContAtas.findByAtaDescription", query = "SELECT c FROM ContAtas c WHERE c.ataDescription = :ataDescription"),
    @NamedQuery(name = "ContAtas.findByAtaCoduskill", query = "SELECT c FROM ContAtas c WHERE c.ataCoduskill = :ataCoduskill"),
    @NamedQuery(name = "ContAtas.findByAtaUsrIns", query = "SELECT c FROM ContAtas c WHERE c.ataUsrIns = :ataUsrIns"),
    @NamedQuery(name = "ContAtas.findByAtaDateIns", query = "SELECT c FROM ContAtas c WHERE c.ataDateIns = :ataDateIns"),
    @NamedQuery(name = "ContAtas.findByAtaUsrUpd", query = "SELECT c FROM ContAtas c WHERE c.ataUsrUpd = :ataUsrUpd"),
    @NamedQuery(name = "ContAtas.findByReqDateUpd", query = "SELECT c FROM ContAtas c WHERE c.reqDateUpd = :reqDateUpd")})
public class ContAtas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ATA_NUMATA")
    private Short ataNumata;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "ATA_DESCRIPTION")
    private String ataDescription;
    @Column(name = "ATA_CODUSKILL")
    private Short ataCoduskill;
    @Size(max = 30)
    @Column(name = "ATA_USR_INS")
    private String ataUsrIns;
    @Column(name = "ATA_DATE_INS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ataDateIns;
    @Size(max = 30)
    @Column(name = "ATA_USR_UPD")
    private String ataUsrUpd;
    @Column(name = "REQ_DATE_UPD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reqDateUpd;

    public ContAtas() {
        super();
    }

    public ContAtas(Short ataNumata) {
        this.ataNumata = ataNumata;
    }

    public ContAtas(Short ataNumata, String ataDescription) {
        this.ataNumata = ataNumata;
        this.ataDescription = ataDescription;
    }

    public Short getAtaNumata() {
        return ataNumata;
    }

    public void setAtaNumata(Short ataNumata) {
        this.ataNumata = ataNumata;
    }

    public String getAtaDescription() {
        return ataDescription;
    }

    public void setAtaDescription(String ataDescription) {
        this.ataDescription = ataDescription;
    }

    public Short getAtaCoduskill() {
        return ataCoduskill;
    }

    public void setAtaCoduskill(Short ataCoduskill) {
        this.ataCoduskill = ataCoduskill;
    }

    public String getAtaUsrIns() {
        return ataUsrIns;
    }

    public void setAtaUsrIns(String ataUsrIns) {
        this.ataUsrIns = ataUsrIns;
    }

    public Date getAtaDateIns() {
        return ataDateIns;
    }

    public void setAtaDateIns(Date ataDateIns) {
        this.ataDateIns = ataDateIns;
    }

    public String getAtaUsrUpd() {
        return ataUsrUpd;
    }

    public void setAtaUsrUpd(String ataUsrUpd) {
        this.ataUsrUpd = ataUsrUpd;
    }

    public Date getReqDateUpd() {
        return reqDateUpd;
    }

    public void setReqDateUpd(Date reqDateUpd) {
        this.reqDateUpd = reqDateUpd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ataNumata != null ? ataNumata.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof ContAtas)) {
            return false;
        }
        ContAtas other = (ContAtas) object;
        if ((this.ataNumata == null && other.ataNumata != null) || (this.ataNumata != null && !this.ataNumata.equals(other.ataNumata))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.grant.ContAtas[ ataNumata=" + ataNumata + " ]";
    }
    
}
