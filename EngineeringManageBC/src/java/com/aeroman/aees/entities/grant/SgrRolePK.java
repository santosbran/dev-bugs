/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities.grant;

import java.io.Serializable;
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
public class SgrRolePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ROLE_CODE")
    private String roleCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SYSTEMID")
    private long systemid;

    public SgrRolePK() {
        super();
    }

    public SgrRolePK(String roleCode, long systemid) {
        this.roleCode = roleCode;
        this.systemid = systemid;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleCode != null ? roleCode.hashCode() : 0);
        hash +=  systemid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof SgrRolePK)) {
            return false;
        }
        SgrRolePK other = (SgrRolePK) object;
        if ((this.roleCode == null && other.roleCode != null) || (this.roleCode != null && !this.roleCode.equals(other.roleCode))) {
            return false;
        }
        if (this.systemid != other.systemid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.SgrRolePK[ roleCode=" + roleCode + ", systemid=" + systemid + " ]";
    }
    
}
