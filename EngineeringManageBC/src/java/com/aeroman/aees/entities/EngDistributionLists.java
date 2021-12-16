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
@Table(name = "ENG_DISTRIBUTION_LISTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngDistributionLists.findAll", query = "SELECT e FROM EngDistributionLists e"),
    @NamedQuery(name = "EngDistributionLists.findByEoIdord", query = "SELECT e FROM EngDistributionLists e WHERE e.engDistributionListsPK.eoIdord = :eoIdord"),
    @NamedQuery(name = "EngDistributionLists.findByDlcId", query = "SELECT e FROM EngDistributionLists e WHERE e.engDistributionListsPK.dlcId = :dlcId"),
    @NamedQuery(name = "EngDistributionLists.findByDlValue", query = "SELECT e FROM EngDistributionLists e WHERE e.dlValue = :dlValue"),
    @NamedQuery(name = "EngDistributionLists.findByDlComments", query = "SELECT e FROM EngDistributionLists e WHERE e.dlComments = :dlComments"),
    @NamedQuery(name = "EngDistributionLists.findByDlUserIns", query = "SELECT e FROM EngDistributionLists e WHERE e.dlUserIns = :dlUserIns"),
    @NamedQuery(name = "EngDistributionLists.findByDlDateIns", query = "SELECT e FROM EngDistributionLists e WHERE e.dlDateIns = :dlDateIns"),
    @NamedQuery(name = "EngDistributionLists.findByDlUserUpd", query = "SELECT e FROM EngDistributionLists e WHERE e.dlUserUpd = :dlUserUpd"),
    @NamedQuery(name = "EngDistributionLists.findByDlDateUpd", query = "SELECT e FROM EngDistributionLists e WHERE e.dlDateUpd = :dlDateUpd")})
public class EngDistributionLists implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EngDistributionListsPK engDistributionListsPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "DL_VALUE")
    private String dlValue;
    @Size(max = 100)
    @Column(name = "DL_COMMENTS")
    private String dlComments;
    @Size(max = 30)
    @Column(name = "DL_USER_INS")
    private String dlUserIns;
    @Column(name = "DL_DATE_INS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dlDateIns;
    @Size(max = 30)
    @Column(name = "DL_USER_UPD")
    private String dlUserUpd;
    @Column(name = "DL_DATE_UPD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dlDateUpd;

    public EngDistributionLists() {
        super();
    }

    public EngDistributionLists(EngDistributionListsPK engDistributionListsPK) {
        this.engDistributionListsPK = engDistributionListsPK;
    }

    public EngDistributionLists(EngDistributionListsPK engDistributionListsPK, String dlValue) {
        this.engDistributionListsPK = engDistributionListsPK;
        this.dlValue = dlValue;
    }

    public EngDistributionLists(long eoIdord, int dlcId) {
        this.engDistributionListsPK = new EngDistributionListsPK(eoIdord, dlcId);
    }

    public EngDistributionListsPK getEngDistributionListsPK() {
        return engDistributionListsPK;
    }

    public void setEngDistributionListsPK(EngDistributionListsPK engDistributionListsPK) {
        this.engDistributionListsPK = engDistributionListsPK;
    }

    public String getDlValue() {
        return dlValue;
    }

    public void setDlValue(String dlValue) {
        this.dlValue = dlValue;
    }

    public String getDlComments() {
        return dlComments;
    }

    public void setDlComments(String dlComments) {
        this.dlComments = dlComments;
    }

    public String getDlUserIns() {
        return dlUserIns;
    }

    public void setDlUserIns(String dlUserIns) {
        this.dlUserIns = dlUserIns;
    }

    public Date getDlDateIns() {
        return dlDateIns;
    }

    public void setDlDateIns(Date dlDateIns) {
        this.dlDateIns = dlDateIns;
    }

    public String getDlUserUpd() {
        return dlUserUpd;
    }

    public void setDlUserUpd(String dlUserUpd) {
        this.dlUserUpd = dlUserUpd;
    }

    public Date getDlDateUpd() {
        return dlDateUpd;
    }

    public void setDlDateUpd(Date dlDateUpd) {
        this.dlDateUpd = dlDateUpd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (engDistributionListsPK != null ? engDistributionListsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EngDistributionLists)) {
            return false;
        }
        EngDistributionLists other = (EngDistributionLists) object;
        if ((this.engDistributionListsPK == null && other.engDistributionListsPK != null) || (this.engDistributionListsPK != null && !this.engDistributionListsPK.equals(other.engDistributionListsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngDistributionLists[ engDistributionListsPK=" + engDistributionListsPK + " ]";
    }
    
}
