/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
 * @author pc
 */
@Entity
@Cacheable(false)
@Table(name = "ENG_INSTRUCTIONS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngInstructions.findAll", query = "SELECT e FROM EngInstructions e"),
    @NamedQuery(name = "EngInstructions.findByInsId", query = "SELECT e FROM EngInstructions e WHERE e.insId = :insId"),
    @NamedQuery(name = "EngInstructions.findByInsUserIns", query = "SELECT e FROM EngInstructions e WHERE e.insUserIns = :insUserIns"),
    @NamedQuery(name = "EngInstructions.findByInsDateIns", query = "SELECT e FROM EngInstructions e WHERE e.insDateIns = :insDateIns"),
    @NamedQuery(name = "EngInstructions.findByInsUserUpd", query = "SELECT e FROM EngInstructions e WHERE e.insUserUpd = :insUserUpd"),
    @NamedQuery(name = "EngInstructions.findByInsDateUpd", query = "SELECT e FROM EngInstructions e WHERE e.insDateUpd = :insDateUpd")})
public class EngInstructions implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "INS_ID")
    private Integer insId;
    @Lob
    @Basic(fetch=FetchType.LAZY,optional=true)
    @Column(name = "DOC_BODY")
    private byte[] docBody;
    @Size(max = 30)
    @Column(name = "INS_USER_INS")
    private String insUserIns;
    @Column(name = "INS_DATE_INS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insDateIns;
    @Size(max = 30)
    @Column(name = "INS_USER_UPD")
    private String insUserUpd;
    @Column(name = "INS_DATE_UPD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insDateUpd;
    @JoinColumn(name = "EOS_IDORD", referencedColumnName = "EO_IDORD")
    @ManyToOne(optional = false)
    private EngOrders eosIdord;

    public EngInstructions() {
        super();
    }

    public EngInstructions(Integer insId) {
        this.insId = insId;
    }

    public Integer getInsId() {
        return insId;
    }

    public void setInsId(Integer insId) {
        this.insId = insId;
    }

    public byte[] getDocBody() {
        return docBody;
    }

    public void setDocBody(byte[] docBody) {
        this.docBody = docBody;
    }

    public String getInsUserIns() {
        return insUserIns;
    }

    public void setInsUserIns(String insUserIns) {
        this.insUserIns = insUserIns;
    }

    public Date getInsDateIns() {
        return insDateIns;
    }

    public void setInsDateIns(Date insDateIns) {
        this.insDateIns = insDateIns;
    }

    public String getInsUserUpd() {
        return insUserUpd;
    }

    public void setInsUserUpd(String insUserUpd) {
        this.insUserUpd = insUserUpd;
    }

    public Date getInsDateUpd() {
        return insDateUpd;
    }

    public void setInsDateUpd(Date insDateUpd) {
        this.insDateUpd = insDateUpd;
    }

    public EngOrders getEosIdord() {
        return eosIdord;
    }

    public void setEosIdord(EngOrders eosIdord) {
        this.eosIdord = eosIdord;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (insId != null ? insId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EngInstructions)) {
            return false;
        }
        EngInstructions other = (EngInstructions) object;
        if ((this.insId == null && other.insId != null) || (this.insId != null && !this.insId.equals(other.insId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngInstructions[ insId=" + insId + " ]";
    }
    
}
