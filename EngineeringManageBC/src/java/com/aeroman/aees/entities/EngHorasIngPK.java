/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Saplic16
 */
@Embeddable
public class EngHorasIngPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "HIN_ID")
    private BigInteger hinId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "REQ_MESSAGEID")
    private BigInteger reqMessageid;

    public EngHorasIngPK() {
        super();
    }

    public EngHorasIngPK(BigInteger hinId, BigInteger reqMessageid) {
        this.hinId = hinId;
        this.reqMessageid = reqMessageid;
    }

    public BigInteger getHinId() {
        return hinId;
    }

    public void setHinId(BigInteger hinId) {
        this.hinId = hinId;
    }

    public BigInteger getReqMessageid() {
        return reqMessageid;
    }

    public void setReqMessageid(BigInteger reqMessageid) {
        this.reqMessageid = reqMessageid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hinId != null ? hinId.hashCode() : 0);
        hash += (reqMessageid != null ? reqMessageid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EngHorasIngPK)) {
            return false;
        }
        EngHorasIngPK other = (EngHorasIngPK) object;
        if ((this.hinId == null && other.hinId != null) || (this.hinId != null && !this.hinId.equals(other.hinId))) {
            return false;
        }
        if ((this.reqMessageid == null && other.reqMessageid != null) || (this.reqMessageid != null && !this.reqMessageid.equals(other.reqMessageid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngHorasIngPK[ hinId=" + hinId + ", reqMessageid=" + reqMessageid + " ]";
    }
    
}
