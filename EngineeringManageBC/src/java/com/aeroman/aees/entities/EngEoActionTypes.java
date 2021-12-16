/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "ENG_EO_ACTION_TYPES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngEoActionTypes.findAll", query = "SELECT e FROM EngEoActionTypes e"),
    @NamedQuery(name = "EngEoActionTypes.findByActCod", query = "SELECT e FROM EngEoActionTypes e WHERE e.actCod = :actCod"),
    @NamedQuery(name = "EngEoActionTypes.findByActDescription", query = "SELECT e FROM EngEoActionTypes e WHERE e.actDescription = :actDescription")})
public class EngEoActionTypes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "ACT_COD")
    private String actCod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ACT_DESCRIPTION")
    private String actDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "actCod")
    private List<EngOrders> engOrdersList;

    public EngEoActionTypes() {
        super();
    }

    public EngEoActionTypes(String actCod) {
        this.actCod = actCod;
    }

    public EngEoActionTypes(String actCod, String actDescription) {
        this.actCod = actCod;
        this.actDescription = actDescription;
    }

    public String getActCod() {
        return actCod;
    }

    public void setActCod(String actCod) {
        this.actCod = actCod;
    }

    public String getActDescription() {
        return actDescription;
    }

    public void setActDescription(String actDescription) {
        this.actDescription = actDescription;
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
        hash += (actCod != null ? actCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EngEoActionTypes)) {
            return false;
        }
        EngEoActionTypes other = (EngEoActionTypes) object;
        if ((this.actCod == null && other.actCod != null) || (this.actCod != null && !this.actCod.equals(other.actCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngEoActionTypes[ actCod=" + actCod + " ]";
    }
    
}
