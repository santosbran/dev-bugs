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
public class EngLaborEstPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "EO_IDORD")
    private long eoIdord;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "SKL_COD")
    private String sklCod;

    public EngLaborEstPK() {
        super();
    }

    public EngLaborEstPK(long eoIdord, String sklCod) {
        this.eoIdord = eoIdord;
        this.sklCod = sklCod;
    }

    public long getEoIdord() {
        return eoIdord;
    }

    public void setEoIdord(long eoIdord) {
        this.eoIdord = eoIdord;
    }

    public String getSklCod() {
        return sklCod;
    }

    public void setSklCod(String sklCod) {
        this.sklCod = sklCod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += eoIdord;
        hash += (sklCod != null ? sklCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EngLaborEstPK)) {
            return false;
        }
        EngLaborEstPK other = (EngLaborEstPK) object;
        if (this.eoIdord != other.eoIdord) {
            return false;
        }
        if ((this.sklCod == null && other.sklCod != null) || (this.sklCod != null && !this.sklCod.equals(other.sklCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngLaborEstPK[ eoIdord=" + eoIdord + ", sklCod=" + sklCod + " ]";
    }
    
}
