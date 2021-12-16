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
public class EngApprovalEspPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACF_ID")
    private short acfId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "FLT_COD")
    private String fltCod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GRP_ID")
    private short grpId;

    public EngApprovalEspPK() {
        super();
    }

    public EngApprovalEspPK(short acfId, String fltCod, short grpId) {
        this.acfId = acfId;
        this.fltCod = fltCod;
        this.grpId = grpId;
    }

    public short getAcfId() {
        return acfId;
    }

    public void setAcfId(short acfId) {
        this.acfId = acfId;
    }

    public String getFltCod() {
        return fltCod;
    }

    public void setFltCod(String fltCod) {
        this.fltCod = fltCod;
    }

    public short getGrpId() {
        return grpId;
    }

    public void setGrpId(short grpId) {
        this.grpId = grpId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) acfId;
        hash += (fltCod != null ? fltCod.hashCode() : 0);
        hash += (int) grpId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EngApprovalEspPK)) {
            return false;
        }
        EngApprovalEspPK other = (EngApprovalEspPK) object;
        if (this.acfId != other.acfId) {
            return false;
        }
        if ((this.fltCod == null && other.fltCod != null) || (this.fltCod != null && !this.fltCod.equals(other.fltCod))) {
            return false;
        }
        if (this.grpId != other.grpId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngApprovalEspPK[ acfId=" + acfId + ", fltCod=" + fltCod + ", grpId=" + grpId + " ]";
    }
    
}
