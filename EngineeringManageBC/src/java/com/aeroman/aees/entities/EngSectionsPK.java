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
public class EngSectionsPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEC_NUM")
    private short secNum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "DOC_ID")
    private String docId;

    public EngSectionsPK() {
        super();
    }

    public EngSectionsPK(short secNum, String docId) {
        this.secNum = secNum;
        this.docId = docId;
    }

    public short getSecNum() {
        return secNum;
    }

    public void setSecNum(short secNum) {
        this.secNum = secNum;
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
        hash +=  secNum;
        hash += (docId != null ? docId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EngSectionsPK)) {
            return false;
        }
        EngSectionsPK other = (EngSectionsPK) object;
        if (this.secNum != other.secNum) {
            return false;
        }
        if ((this.docId == null && other.docId != null) || (this.docId != null && !this.docId.equals(other.docId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngSectionsPK[ secNum=" + secNum + ", docId=" + docId + " ]";
    }
    
}
