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
 * @author saplic
 */
@Embeddable
public class AecasEsrMhPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "ESR_WO_YEAR")
    private String esrWoYear;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "ESR_WO_ORDER")
    private String esrWoOrder;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "ESR_WO_TASK")
    private String esrWoTask;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "ESR_ACREG")
    private String esrAcreg;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ESR_CUCOD")
    private String esrCucod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ESR_ESR_ID")
    private String esrEsrId;

    public AecasEsrMhPK() {
        super();
    }

    public AecasEsrMhPK(String esrWoYear, String esrWoOrder, String esrWoTask, String esrAcreg, String esrCucod, String esrEsrId) {
        this.esrWoYear = esrWoYear;
        this.esrWoOrder = esrWoOrder;
        this.esrWoTask = esrWoTask;
        this.esrAcreg = esrAcreg;
        this.esrCucod = esrCucod;
        this.esrEsrId = esrEsrId;
    }

    public String getEsrWoYear() {
        return esrWoYear;
    }

    public void setEsrWoYear(String esrWoYear) {
        this.esrWoYear = esrWoYear;
    }

    public String getEsrWoOrder() {
        return esrWoOrder;
    }

    public void setEsrWoOrder(String esrWoOrder) {
        this.esrWoOrder = esrWoOrder;
    }

    public String getEsrWoTask() {
        return esrWoTask;
    }

    public void setEsrWoTask(String esrWoTask) {
        this.esrWoTask = esrWoTask;
    }

    public String getEsrAcreg() {
        return esrAcreg;
    }

    public void setEsrAcreg(String esrAcreg) {
        this.esrAcreg = esrAcreg;
    }

    public String getEsrCucod() {
        return esrCucod;
    }

    public void setEsrCucod(String esrCucod) {
        this.esrCucod = esrCucod;
    }

    public String getEsrEsrId() {
        return esrEsrId;
    }

    public void setEsrEsrId(String esrEsrId) {
        this.esrEsrId = esrEsrId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (esrWoYear != null ? esrWoYear.hashCode() : 0);
        hash += (esrWoOrder != null ? esrWoOrder.hashCode() : 0);
        hash += (esrWoTask != null ? esrWoTask.hashCode() : 0);
        hash += (esrAcreg != null ? esrAcreg.hashCode() : 0);
        hash += (esrCucod != null ? esrCucod.hashCode() : 0);
        hash += (esrEsrId != null ? esrEsrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof AecasEsrMhPK)) {
            return false;
        }
        AecasEsrMhPK other = (AecasEsrMhPK) object;
        if ((this.esrWoYear == null && other.esrWoYear != null) || (this.esrWoYear != null && !this.esrWoYear.equals(other.esrWoYear))) {
            return false;
        }
        if ((this.esrWoOrder == null && other.esrWoOrder != null) || (this.esrWoOrder != null && !this.esrWoOrder.equals(other.esrWoOrder))) {
            return false;
        }
        if ((this.esrWoTask == null && other.esrWoTask != null) || (this.esrWoTask != null && !this.esrWoTask.equals(other.esrWoTask))) {
            return false;
        }
        if ((this.esrAcreg == null && other.esrAcreg != null) || (this.esrAcreg != null && !this.esrAcreg.equals(other.esrAcreg))) {
            return false;
        }
        if ((this.esrCucod == null && other.esrCucod != null) || (this.esrCucod != null && !this.esrCucod.equals(other.esrCucod))) {
            return false;
        }
        if ((this.esrEsrId == null && other.esrEsrId != null) || (this.esrEsrId != null && !this.esrEsrId.equals(other.esrEsrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.AecasEsrMhPK[ esrWoYear=" + esrWoYear + ", esrWoOrder=" + esrWoOrder + ", esrWoTask=" + esrWoTask + ", esrAcreg=" + esrAcreg + ", esrCucod=" + esrCucod + ", esrEsrId=" + esrEsrId + " ]";
    }
    
}
