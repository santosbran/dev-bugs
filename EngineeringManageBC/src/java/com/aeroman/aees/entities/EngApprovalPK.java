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
public class EngApprovalPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "EO_IDORD")
    private long eoIdord;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDACF")
    private short idacf;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "FLT_COD")
    private String fltCod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GRP_ID")
    private short grpId;

    public EngApprovalPK() {
        super();
    }

    public EngApprovalPK(long eoIdord, short idacf, String fltCod, short grpId) {
        this.eoIdord = eoIdord;
        this.idacf = idacf;
        this.fltCod = fltCod;
        this.grpId = grpId;
    }

    public long getEoIdord() {
        return eoIdord;
    }

    public void setEoIdord(long eoIdord) {
        this.eoIdord = eoIdord;
    }

    public short getIdacf() {
        return idacf;
    }

    public void setIdacf(short idacf) {
        this.idacf = idacf;
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
        hash += (int) eoIdord;
        hash += (int) idacf;
        hash += (fltCod != null ? fltCod.hashCode() : 0);
        hash += (int) grpId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EngApprovalPK)) {
            return false;
        }
        EngApprovalPK other = (EngApprovalPK) object;
        if (this.eoIdord != other.eoIdord) {
            return false;
        }
        if (this.idacf != other.idacf) {
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
        return "com.aeroman.aees.entities.EngApprovalPK[ eoIdord=" + eoIdord + ", idacf=" + idacf + ", fltCod=" + fltCod + ", grpId=" + grpId + " ]";
    }
    
}
