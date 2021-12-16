/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pc
 */
@Entity
@Cacheable(false)
@Table(name = "ENG_WORK_TYPES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngWorkTypes.findAll", query = "SELECT e FROM EngWorkTypes e"),
    @NamedQuery(name = "EngWorkTypes.findByWtyCod", query = "SELECT e FROM EngWorkTypes e WHERE e.wtyCod = :wtyCod"),
    @NamedQuery(name = "EngWorkTypes.findByWtyDescription", query = "SELECT e FROM EngWorkTypes e WHERE e.wtyDescription = :wtyDescription")})
public class EngWorkTypes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "WTY_COD")
    private String wtyCod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "WTY_DESCRIPTION")
    private String wtyDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "wtyCod")
    private List<EngOrders> engOrdersList;

    public EngWorkTypes() {
        super();
    }

    public EngWorkTypes(String wtyCod) {
        this.wtyCod = wtyCod;
    }

    public EngWorkTypes(String wtyCod, String wtyDescription) {
        this.wtyCod = wtyCod;
        this.wtyDescription = wtyDescription;
    }

    public String getWtyCod() {
        return wtyCod;
    }

    public void setWtyCod(String wtyCod) {
        this.wtyCod = wtyCod;
    }

    public String getWtyDescription() {
        return wtyDescription;
    }

    public void setWtyDescription(String wtyDescription) {
        this.wtyDescription = wtyDescription;
    }

    @XmlTransient
    public List<EngOrders> getEngOrdersList() {
        return engOrdersList;
    }

    public void setEngOrdersList(List<EngOrders> engOrdersList) {
        this.engOrdersList = engOrdersList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (wtyCod != null ? wtyCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EngWorkTypes)) {
            return false;
        }
        EngWorkTypes other = (EngWorkTypes) object;
        if ((this.wtyCod == null && other.wtyCod != null) || (this.wtyCod != null && !this.wtyCod.equals(other.wtyCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngWorkTypes[ wtyCod=" + wtyCod + " ]";
    }
    
}
