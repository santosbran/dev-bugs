/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pc
 */
@Entity
@Cacheable(false)
@Table(name = "ENG_WCC_DOCS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngWccDocs.findAll", query = "SELECT e FROM EngWccDocs e"),
    @NamedQuery(name = "EngWccDocs.findByWccId", query = "SELECT e FROM EngWccDocs e WHERE e.engWccDocsPK.wccId = :wccId"),
    @NamedQuery(name = "EngWccDocs.findByDocId", query = "SELECT e FROM EngWccDocs e WHERE e.engWccDocsPK.docId = :docId"),
    @NamedQuery(name = "EngWccDocs.findBySecNum", query = "SELECT e FROM EngWccDocs e WHERE e.secNum = :secNum")})
public class EngWccDocs implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EngWccDocsPK engWccDocsPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEC_NUM")
    private short secNum;

    public EngWccDocs() {
        super();
    }

    public EngWccDocs(EngWccDocsPK engWccDocsPK) {
        this.engWccDocsPK = engWccDocsPK;
    }

    public EngWccDocs(EngWccDocsPK engWccDocsPK, short secNum) {
        this.engWccDocsPK = engWccDocsPK;
        this.secNum = secNum;
    }

    public EngWccDocs(long wccId, String docId) {
        this.engWccDocsPK = new EngWccDocsPK(wccId, docId);
    }

    public EngWccDocsPK getEngWccDocsPK() {
        return engWccDocsPK;
    }

    public void setEngWccDocsPK(EngWccDocsPK engWccDocsPK) {
        this.engWccDocsPK = engWccDocsPK;
    }

    public short getSecNum() {
        return secNum;
    }

    public void setSecNum(short secNum) {
        this.secNum = secNum;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (engWccDocsPK != null ? engWccDocsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EngWccDocs)) {
            return false;
        }
        EngWccDocs other = (EngWccDocs) object;
        if ((this.engWccDocsPK == null && other.engWccDocsPK != null) || (this.engWccDocsPK != null && !this.engWccDocsPK.equals(other.engWccDocsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngWccDocs[ engWccDocsPK=" + engWccDocsPK + " ]";
    }
    
}
