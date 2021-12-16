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
import javax.validation.constraints.Size;

/**
 *
 * @author saplic
 */
@Embeddable
public class SgrUserRolePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ROLE_CODE")
    private String roleCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SYSTEMID")
    private long systemid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USER_ID")
    private BigInteger userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "CIA_CODE")
    private String ciaCode;

    public SgrUserRolePK() {
        super();
    }

    public SgrUserRolePK(String roleCode, long systemid, BigInteger userId, String ciaCode) {
        this.roleCode = roleCode;
        this.systemid = systemid;
        this.userId = userId;
        this.ciaCode = ciaCode;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public long getSystemid() {
        return systemid;
    }

    public void setSystemid(long systemid) {
        this.systemid = systemid;
    }

    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

    public String getCiaCode() {
        return ciaCode;
    }

    public void setCiaCode(String ciaCode) {
        this.ciaCode = ciaCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleCode != null ? roleCode.hashCode() : 0);
        hash +=  systemid;
        hash += (userId != null ? userId.hashCode() : 0);
        hash += (ciaCode != null ? ciaCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof SgrUserRolePK)) {
            return false;
        }
        SgrUserRolePK other = (SgrUserRolePK) object;
        if ((this.roleCode == null && other.roleCode != null) || (this.roleCode != null && !this.roleCode.equals(other.roleCode))) {
            return false;
        }
        if (this.systemid != other.systemid) {
            return false;
        }
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        if ((this.ciaCode == null && other.ciaCode != null) || (this.ciaCode != null && !this.ciaCode.equals(other.ciaCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.SgrUserRolePK[ roleCode=" + roleCode + ", systemid=" + systemid + ", userId=" + userId + ", ciaCode=" + ciaCode + " ]";
    }
    
}
