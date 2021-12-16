/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "ENG_EO_STATUS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngEoStatus.findAll", query = "SELECT e FROM EngEoStatus e"),
    @NamedQuery(name = "EngEoStatus.findByStsEoCod", query = "SELECT e FROM EngEoStatus e WHERE e.stsEoCod = :stsEoCod"),
    @NamedQuery(name = "EngEoStatus.findByStsDescription", query = "SELECT e FROM EngEoStatus e WHERE e.stsDescription = :stsDescription"),
    @NamedQuery(name = "EngEoStatus.findByStsCodsuper", query = "SELECT e FROM EngEoStatus e WHERE e.stsCodsuper = :stsCodsuper")})
public class EngEoStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "STS_EO_COD")
    private String stsEoCod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "STS_DESCRIPTION")
    private String stsDescription;
    @Size(max = 1)
    @Column(name = "STS_CODSUPER")
    private String stsCodsuper;
 

    public EngEoStatus() {
        super();
    }

    public EngEoStatus(String stsEoCod) {
        this.stsEoCod = stsEoCod;
    }

    public EngEoStatus(String stsEoCod, String stsDescription) {
        this.stsEoCod = stsEoCod;
        this.stsDescription = stsDescription;
    }

    public String getStsEoCod() {
        return stsEoCod;
    }

    public void setStsEoCod(String stsEoCod) {
        this.stsEoCod = stsEoCod;
    }

    public String getStsDescription() {
        return stsDescription;
    }

    public void setStsDescription(String stsDescription) {
        this.stsDescription = stsDescription;
    }

    public String getStsCodsuper() {
        return stsCodsuper;
    }

    public void setStsCodsuper(String stsCodsuper) {
        this.stsCodsuper = stsCodsuper;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stsEoCod != null ? stsEoCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EngEoStatus)) {
            return false;
        }
        EngEoStatus other = (EngEoStatus) object;
        if ((this.stsEoCod == null && other.stsEoCod != null) || (this.stsEoCod != null && !this.stsEoCod.equals(other.stsEoCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngEoStatus[ stsEoCod=" + stsEoCod + " ]";
    }
    
}
