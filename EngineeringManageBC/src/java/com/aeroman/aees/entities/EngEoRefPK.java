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
public class EngEoRefPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "COD_ID")
    private String codId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEC_NUM")
    private short secNum;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EO_IDORD")
    private long eoIdord;

    public EngEoRefPK() {
        super();
    }

    public EngEoRefPK(String codId, short secNum, long eoIdord) {
        this.codId = codId;
        this.secNum = secNum;
        this.eoIdord = eoIdord;
    }

    public String getCodId() {
        return codId;
    }

    public void setCodId(String codId) {
        this.codId = codId;
    }

    public short getSecNum() {
        return secNum;
    }

    public void setSecNum(short secNum) {
        this.secNum = secNum;
    }

    public long getEoIdord() {
        return eoIdord;
    }

    public void setEoIdord(long eoIdord) {
        this.eoIdord = eoIdord;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codId != null ? codId.hashCode() : 0);
        hash +=  secNum;
        hash +=  eoIdord;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EngEoRefPK)) {
            return false;
        }
        EngEoRefPK other = (EngEoRefPK) object;
        if ((this.codId == null && other.codId != null) || (this.codId != null && !this.codId.equals(other.codId))) {
            return false;
        }
        if (this.secNum != other.secNum) {
            return false;
        }
        if (this.eoIdord != other.eoIdord) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngEoRefPK[ codId=" + codId + ", secNum=" + secNum + ", eoIdord=" + eoIdord + " ]";
    }
    
}
