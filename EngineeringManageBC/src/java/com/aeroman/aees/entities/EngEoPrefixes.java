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
@Table(name = "ENG_EO_PREFIXES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngEoPrefixes.findAll", query = "SELECT e FROM EngEoPrefixes e"),
    @NamedQuery(name = "EngEoPrefixes.findByPreCod", query = "SELECT e FROM EngEoPrefixes e WHERE e.preCod = :preCod"),
    @NamedQuery(name = "EngEoPrefixes.findByPreDescription", query = "SELECT e FROM EngEoPrefixes e WHERE e.preDescription = :preDescription")})
public class EngEoPrefixes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "PRE_COD")
    private String preCod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PRE_DESCRIPTION")
    private String preDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eoCodpre")
    private List<EngOrders> engOrdersList;

    public EngEoPrefixes() {
        super();
    }

    public EngEoPrefixes(String preCod) {
        this.preCod = preCod;
    }

    public EngEoPrefixes(String preCod, String preDescription) {
        this.preCod = preCod;
        this.preDescription = preDescription;
    }

    public String getPreCod() {
        return preCod;
    }

    public void setPreCod(String preCod) {
        this.preCod = preCod;
    }

    public String getPreDescription() {
        return preDescription;
    }

    public void setPreDescription(String preDescription) {
        this.preDescription = preDescription;
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
        hash += (preCod != null ? preCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EngEoPrefixes)) {
            return false;
        }
        EngEoPrefixes other = (EngEoPrefixes) object;
        if ((this.preCod == null && other.preCod != null) || (this.preCod != null && !this.preCod.equals(other.preCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngEoPrefixes[ preCod=" + preCod + " ]";
    }
    
}
