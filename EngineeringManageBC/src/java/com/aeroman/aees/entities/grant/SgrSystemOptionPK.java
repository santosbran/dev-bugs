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
public class SgrSystemOptionPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "OPTION_CODE")
    private BigInteger optionCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SYSTEMID")
    private long systemid;

    public SgrSystemOptionPK() {
        super();
    }

    public SgrSystemOptionPK(BigInteger optionCode, long systemid) {
        this.optionCode = optionCode;
        this.systemid = systemid;
    }

    public BigInteger getOptionCode() {
        return optionCode;
    }

    public void setOptionCode(BigInteger optionCode) {
        this.optionCode = optionCode;
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
        hash += (optionCode != null ? optionCode.hashCode() : 0);
        hash += systemid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof SgrSystemOptionPK)) {
            return false;
        }
        SgrSystemOptionPK other = (SgrSystemOptionPK) object;
        if ((this.optionCode == null && other.optionCode != null) || (this.optionCode != null && !this.optionCode.equals(other.optionCode))) {
            return false;
        }
        if (this.systemid != other.systemid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.SgrSystemOptionPK[ optionCode=" + optionCode + ", systemid=" + systemid + " ]";
    }
    
}
