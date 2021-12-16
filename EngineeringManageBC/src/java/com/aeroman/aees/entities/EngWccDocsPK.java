/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author pc
 */
@Embeddable
public class EngWccDocsPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "WCC_ID")
    private long wccId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "DOC_ID")
    private String docId;

    public EngWccDocsPK() {
        super();
    }

    public EngWccDocsPK(long wccId, String docId) {
        this.wccId = wccId;
        this.docId = docId;
    }

    public long getWccId() {
        return wccId;
    }

    public void setWccId(long wccId) {
        this.wccId = wccId;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash +=  wccId;
        hash += (docId != null ? docId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EngWccDocsPK)) {
            return false;
        }
        EngWccDocsPK other = (EngWccDocsPK) object;
        if (this.wccId != other.wccId) {
            return false;
        }
        if ((this.docId == null && other.docId != null) || (this.docId != null && !this.docId.equals(other.docId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngWccDocsPK[ wccId=" + wccId + ", docId=" + docId + " ]";
    }
    
}
