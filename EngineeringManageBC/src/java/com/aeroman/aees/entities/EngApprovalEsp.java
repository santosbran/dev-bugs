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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "ENG_APPROVAL_ESP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngApprovalEsp.findAll", query = "SELECT e FROM EngApprovalEsp e"),
    @NamedQuery(name = "EngApprovalEsp.findByAcfId", query = "SELECT e FROM EngApprovalEsp e WHERE e.engApprovalEspPK.acfId = :acfId"),
    @NamedQuery(name = "EngApprovalEsp.findByFltCod", query = "SELECT e FROM EngApprovalEsp e WHERE e.engApprovalEspPK.fltCod = :fltCod"),
    @NamedQuery(name = "EngApprovalEsp.findByGrpId", query = "SELECT e FROM EngApprovalEsp e WHERE e.engApprovalEspPK.grpId = :grpId"),
    @NamedQuery(name = "EngApprovalEsp.findByAspApprovalOrder", query = "SELECT e FROM EngApprovalEsp e WHERE e.aspApprovalOrder = :aspApprovalOrder"),
    @NamedQuery(name = "EngApprovalEsp.findByAspSpecialApp", query = "SELECT e FROM EngApprovalEsp e WHERE e.aspSpecialApp = :aspSpecialApp"),
    @NamedQuery(name = "EngApprovalEsp.findByAspUsrIns", query = "SELECT e FROM EngApprovalEsp e WHERE e.aspUsrIns = :aspUsrIns"),
    @NamedQuery(name = "EngApprovalEsp.findByAspDateIns", query = "SELECT e FROM EngApprovalEsp e WHERE e.aspDateIns = :aspDateIns"),
    @NamedQuery(name = "EngApprovalEsp.findByAspUsrUpd", query = "SELECT e FROM EngApprovalEsp e WHERE e.aspUsrUpd = :aspUsrUpd"),
    @NamedQuery(name = "EngApprovalEsp.findByAspDateUpd", query = "SELECT e FROM EngApprovalEsp e WHERE e.aspDateUpd = :aspDateUpd")})
public class EngApprovalEsp implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EngApprovalEspPK engApprovalEspPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ASP_APPROVAL_ORDER")
    private short aspApprovalOrder;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ASP_SPECIAL_APP")
    private String aspSpecialApp;
    @Size(max = 30)
    @Column(name = "ASP_USR_INS")
    private String aspUsrIns;
    @Column(name = "ASP_DATE_INS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date aspDateIns;
    @Size(max = 30)
    @Column(name = "ASP_USR_UPD")
    private String aspUsrUpd;
    @Column(name = "ASP_DATE_UPD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date aspDateUpd;

    public EngApprovalEsp() {
        super();
    }
    

    public EngApprovalEsp(EngApprovalEspPK engApprovalEspPK) {
        this.engApprovalEspPK = engApprovalEspPK;
    }

    public EngApprovalEsp(EngApprovalEspPK engApprovalEspPK, short aspApprovalOrder, String aspSpecialApp) {
        this.engApprovalEspPK = engApprovalEspPK;
        this.aspApprovalOrder = aspApprovalOrder;
        this.aspSpecialApp = aspSpecialApp;
    }

    public EngApprovalEsp(short acfId, String fltCod, short grpId) {
        this.engApprovalEspPK = new EngApprovalEspPK(acfId, fltCod, grpId);
    }

    public EngApprovalEspPK getEngApprovalEspPK() {
        return engApprovalEspPK;
    }

    public void setEngApprovalEspPK(EngApprovalEspPK engApprovalEspPK) {
        this.engApprovalEspPK = engApprovalEspPK;
    }

    public short getAspApprovalOrder() {
        return aspApprovalOrder;
    }

    public void setAspApprovalOrder(short aspApprovalOrder) {
        this.aspApprovalOrder = aspApprovalOrder;
    }

    public String getAspSpecialApp() {
        return aspSpecialApp;
    }

    public void setAspSpecialApp(String aspSpecialApp) {
        this.aspSpecialApp = aspSpecialApp;
    }

    public String getAspUsrIns() {
        return aspUsrIns;
    }

    public void setAspUsrIns(String aspUsrIns) {
        this.aspUsrIns = aspUsrIns;
    }

    public Date getAspDateIns() {
        return aspDateIns;
    }

    public void setAspDateIns(Date aspDateIns) {
        this.aspDateIns = aspDateIns;
    }

    public String getAspUsrUpd() {
        return aspUsrUpd;
    }

    public void setAspUsrUpd(String aspUsrUpd) {
        this.aspUsrUpd = aspUsrUpd;
    }

    public Date getAspDateUpd() {
        return aspDateUpd;
    }

    public void setAspDateUpd(Date aspDateUpd) {
        this.aspDateUpd = aspDateUpd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (engApprovalEspPK != null ? engApprovalEspPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EngApprovalEsp)) {
            return false;
        }
        EngApprovalEsp other = (EngApprovalEsp) object;
        if ((this.engApprovalEspPK == null && other.engApprovalEspPK != null) || (this.engApprovalEspPK != null && !this.engApprovalEspPK.equals(other.engApprovalEspPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngApprovalEsp[ engApprovalEspPK=" + engApprovalEspPK + " ]";
    }
    
}
