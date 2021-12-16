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

/**
 *
 * @author pc
 */
@Embeddable
public class EngDistributionListsPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "EO_IDORD")
    private long eoIdord;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DLC_ID")
    private int dlcId;

    public EngDistributionListsPK() {
        super();
    }

    public EngDistributionListsPK(long eoIdord, int dlcId) {
        this.eoIdord = eoIdord;
        this.dlcId = dlcId;
    }

    public long getEoIdord() {
        return eoIdord;
    }

    public void setEoIdord(long eoIdord) {
        this.eoIdord = eoIdord;
    }

    public int getDlcId() {
        return dlcId;
    }

    public void setDlcId(int dlcId) {
        this.dlcId = dlcId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash +=  eoIdord;
        hash +=  dlcId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EngDistributionListsPK)) {
            return false;
        }
        EngDistributionListsPK other = (EngDistributionListsPK) object;
        if (this.eoIdord != other.eoIdord) {
            return false;
        }
        if (this.dlcId != other.dlcId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngDistributionListsPK[ eoIdord=" + eoIdord + ", dlcId=" + dlcId + " ]";
    }
    
}
