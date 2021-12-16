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
 * @author pc
 */
@Entity
@Cacheable(false)
@Table(name = "ENG_AFFECTED_PUBS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngAffectedPubs.findAll", query = "SELECT e FROM EngAffectedPubs e"),
    @NamedQuery(name = "EngAffectedPubs.findByPubId", query = "SELECT e FROM EngAffectedPubs e WHERE e.pubId = :pubId"),
    @NamedQuery(name = "EngAffectedPubs.findByPubDescription", query = "SELECT e FROM EngAffectedPubs e WHERE e.pubDescription = :pubDescription"),
    @NamedQuery(name = "EngAffectedPubs.findByEoIdord", query = "SELECT e FROM EngAffectedPubs e WHERE e.eoIdord = :eoIdord"),
    @NamedQuery(name = "EngAffectedPubs.findByPubChapter", query = "SELECT e FROM EngAffectedPubs e WHERE e.pubChapter = :pubChapter"),
    @NamedQuery(name = "EngAffectedPubs.findByPubUserIns", query = "SELECT e FROM EngAffectedPubs e WHERE e.pubUserIns = :pubUserIns"),
    @NamedQuery(name = "EngAffectedPubs.findByPubDateIns", query = "SELECT e FROM EngAffectedPubs e WHERE e.pubDateIns = :pubDateIns"),
    @NamedQuery(name = "EngAffectedPubs.findByPubUserUpd", query = "SELECT e FROM EngAffectedPubs e WHERE e.pubUserUpd = :pubUserUpd"),
    @NamedQuery(name = "EngAffectedPubs.findByPubDateUpd", query = "SELECT e FROM EngAffectedPubs e WHERE e.pubDateUpd = :pubDateUpd")})
public class EngAffectedPubs implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PUB_ID")
    private Integer pubId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PUB_DESCRIPTION")
    private String pubDescription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EO_IDORD")
    private long eoIdord;
    @Size(max = 30)
    @Column(name = "PUB_CHAPTER")
    private String pubChapter;
    @Size(max = 30)
    @Column(name = "PUB_USER_INS")
    private String pubUserIns;
    @Column(name = "PUB_DATE_INS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pubDateIns;
    @Size(max = 30)
    @Column(name = "PUB_USER_UPD")
    private String pubUserUpd;
    @Column(name = "PUB_DATE_UPD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pubDateUpd;

    public EngAffectedPubs() {
        super();
    }

    public EngAffectedPubs(Integer pubId) {
        this.pubId = pubId;
    }

    public EngAffectedPubs(Integer pubId, String pubDescription, long eoIdord) {
        this.pubId = pubId;
        this.pubDescription = pubDescription;
        this.eoIdord = eoIdord;
    }

    public Integer getPubId() {
        return pubId;
    }

    public void setPubId(Integer pubId) {
        this.pubId = pubId;
    }

    public String getPubDescription() {
        return pubDescription;
    }

    public void setPubDescription(String pubDescription) {
        this.pubDescription = pubDescription;
    }

    public long getEoIdord() {
        return eoIdord;
    }

    public void setEoIdord(long eoIdord) {
        this.eoIdord = eoIdord;
    }

    public String getPubChapter() {
        return pubChapter;
    }

    public void setPubChapter(String pubChapter) {
        this.pubChapter = pubChapter;
    }

    public String getPubUserIns() {
        return pubUserIns;
    }

    public void setPubUserIns(String pubUserIns) {
        this.pubUserIns = pubUserIns;
    }

    public Date getPubDateIns() {
        return pubDateIns;
    }

    public void setPubDateIns(Date pubDateIns) {
        this.pubDateIns = pubDateIns;
    }

    public String getPubUserUpd() {
        return pubUserUpd;
    }

    public void setPubUserUpd(String pubUserUpd) {
        this.pubUserUpd = pubUserUpd;
    }

    public Date getPubDateUpd() {
        return pubDateUpd;
    }

    public void setPubDateUpd(Date pubDateUpd) {
        this.pubDateUpd = pubDateUpd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pubId != null ? pubId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EngAffectedPubs)) {
            return false;
        }
        EngAffectedPubs other = (EngAffectedPubs) object;
        if ((this.pubId == null && other.pubId != null) || (this.pubId != null && !this.pubId.equals(other.pubId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngAffectedPubs[ pubId=" + pubId + " ]";
    }
    
}
