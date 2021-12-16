/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities;

import java.io.Serializable;
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
 * @author pc
 */
@Entity
@Cacheable(false)
@Table(name = "ENG_REQ_STATUS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngReqStatus.findAll", query = "SELECT e FROM EngReqStatus e"),
    @NamedQuery(name = "EngReqStatus.findByEstId", query = "SELECT e FROM EngReqStatus e WHERE e.estId = :estId"),
    @NamedQuery(name = "EngReqStatus.findByEstCode", query = "SELECT e FROM EngReqStatus e WHERE e.estCode = :estCode"),
    @NamedQuery(name = "EngReqStatus.findByEstDesc", query = "SELECT e FROM EngReqStatus e WHERE e.estDesc = :estDesc"),
    @NamedQuery(name = "EngReqStatus.findByEstStatus", query = "SELECT e FROM EngReqStatus e WHERE e.estStatus = :estStatus"),
    @NamedQuery(name = "EngReqStatus.findByEstFechaIns", query = "SELECT e FROM EngReqStatus e WHERE e.estFechaIns = :estFechaIns"),
    @NamedQuery(name = "EngReqStatus.findByEstUserIns", query = "SELECT e FROM EngReqStatus e WHERE e.estUserIns = :estUserIns"),
    @NamedQuery(name = "EngReqStatus.findByEstFechaAct", query = "SELECT e FROM EngReqStatus e WHERE e.estFechaAct = :estFechaAct"),
    @NamedQuery(name = "EngReqStatus.findByEstUserAct", query = "SELECT e FROM EngReqStatus e WHERE e.estUserAct = :estUserAct"),
    @NamedQuery(name = "EngReqStatus.findByEstIdactor", query = "SELECT e FROM EngReqStatus e WHERE e.estIdactor = :estIdactor")})
public class EngReqStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EST_ID")
    private BigInteger estId;    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "EST_CODE")
    private String estCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "EST_DESC")
    private String estDesc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "EST_STATUS")
    private String estStatus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EST_FECHA_INS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date estFechaIns;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "EST_USER_INS")
    private String estUserIns;
    @Column(name = "EST_FECHA_ACT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date estFechaAct;
    @Size(max = 20)
    @Column(name = "EST_USER_ACT")
    private String estUserAct;
    @JoinColumn(name = "EST_IDACTOR", referencedColumnName = "ACT_ID")
    @ManyToOne
    private EngActor estIdactor;

    public EngReqStatus() {
        super();
    }

    public EngReqStatus(String estCode) {
        this.estCode = estCode;
    }

    public EngReqStatus(String estCode, BigInteger estId, String estDesc, String estStatus, Date estFechaIns, String estUserIns) {
        this.estCode = estCode;
        this.estId = estId;
        this.estDesc = estDesc;
        this.estStatus = estStatus;
        this.estFechaIns = estFechaIns;
        this.estUserIns = estUserIns;
    }

    public BigInteger getEstId() {
        return estId;
    }

    public void setEstId(BigInteger estId) {
        this.estId = estId;
    }

    public String getEstCode() {
        return estCode;
    }

    public void setEstCode(String estCode) {
        this.estCode = estCode;
    }

    public String getEstDesc() {
        return estDesc;
    }

    public void setEstDesc(String estDesc) {
        this.estDesc = estDesc;
    }

    public String getEstStatus() {
        return estStatus;
    }

    public void setEstStatus(String estStatus) {
        this.estStatus = estStatus;
    }

    public Date getEstFechaIns() {
        return estFechaIns;
    }

    public void setEstFechaIns(Date estFechaIns) {
        this.estFechaIns = estFechaIns;
    }

    public String getEstUserIns() {
        return estUserIns;
    }

    public void setEstUserIns(String estUserIns) {
        this.estUserIns = estUserIns;
    }

    public Date getEstFechaAct() {
        return estFechaAct;
    }

    public void setEstFechaAct(Date estFechaAct) {
        this.estFechaAct = estFechaAct;
    }

    public String getEstUserAct() {
        return estUserAct;
    }

    public void setEstUserAct(String estUserAct) {
        this.estUserAct = estUserAct;
    }

    public EngActor getEstIdactor() {
        return estIdactor;
    }

    public void setEstIdactor(EngActor estIdactor) {
        this.estIdactor = estIdactor;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estCode != null ? estCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EngReqStatus)) {
            return false;
        }
        EngReqStatus other = (EngReqStatus) object;
        if ((this.estCode == null && other.estCode != null) || (this.estCode != null && !this.estCode.equals(other.estCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngReqStatus[ estCode=" + estCode + " ]";
    }
    
}
