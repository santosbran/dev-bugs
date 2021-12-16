/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities.grant;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author saplic
 */
@Embeddable
public class SgrAppOptionsGroupPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "OPTIONS_GROUP_CODE")
    private BigInteger optionsGroupCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SYSTEMID")
    private long systemid;

    public SgrAppOptionsGroupPK() {
        super();
    }

    public SgrAppOptionsGroupPK(BigInteger optionsGroupCode, long systemid) {
        this.optionsGroupCode = optionsGroupCode;
        this.systemid = systemid;
    }

    public BigInteger getOptionsGroupCode() {
        return optionsGroupCode;
    }

    public void setOptionsGroupCode(BigInteger optionsGroupCode) {
        this.optionsGroupCode = optionsGroupCode;
    }

    public long getSystemid() {
        return systemid;
    }

    public void setSystemid(long systemid) {
        this.systemid = systemid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (optionsGroupCode != null ? optionsGroupCode.hashCode() : 0);
        hash +=  systemid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof SgrAppOptionsGroupPK)) {
            return false;
        }
        SgrAppOptionsGroupPK other = (SgrAppOptionsGroupPK) object;
        if ((this.optionsGroupCode == null && other.optionsGroupCode != null) || (this.optionsGroupCode != null && !this.optionsGroupCode.equals(other.optionsGroupCode))) {
            return false;
        }
        if (this.systemid != other.systemid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.SgrAppOptionsGroupPK[ optionsGroupCode=" + optionsGroupCode + ", systemid=" + systemid + " ]";
    }
    
}
