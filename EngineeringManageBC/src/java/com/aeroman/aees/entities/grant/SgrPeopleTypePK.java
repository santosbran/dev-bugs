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
public class SgrPeopleTypePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "PEOPLE_TYPE_CODE")
    private BigInteger peopleTypeCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SYSTEMID")
    private BigInteger systemid;

    public SgrPeopleTypePK() {
        super();
    }

    public SgrPeopleTypePK(BigInteger peopleTypeCode, BigInteger systemid) {
        this.peopleTypeCode = peopleTypeCode;
        this.systemid = systemid;
    }

    public BigInteger getPeopleTypeCode() {
        return peopleTypeCode;
    }

    public void setPeopleTypeCode(BigInteger peopleTypeCode) {
        this.peopleTypeCode = peopleTypeCode;
    }

    public BigInteger getSystemid() {
        return systemid;
    }

    public void setSystemid(BigInteger systemid) {
        this.systemid = systemid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (peopleTypeCode != null ? peopleTypeCode.hashCode() : 0);
        hash += (systemid != null ? systemid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof SgrPeopleTypePK)) {
            return false;
        }
        SgrPeopleTypePK other = (SgrPeopleTypePK) object;
        if ((this.peopleTypeCode == null && other.peopleTypeCode != null) || (this.peopleTypeCode != null && !this.peopleTypeCode.equals(other.peopleTypeCode))) {
            return false;
        }
        if ((this.systemid == null && other.systemid != null) || (this.systemid != null && !this.systemid.equals(other.systemid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.SgrPeopleTypePK[ peopleTypeCode=" + peopleTypeCode + ", systemid=" + systemid + " ]";
    }
    
}
