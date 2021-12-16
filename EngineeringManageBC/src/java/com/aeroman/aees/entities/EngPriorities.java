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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
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
@Table(name = "ENG_PRIORITIES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngPriorities.findAll", query = "SELECT e FROM EngPriorities e"),
    @NamedQuery(name = "EngPriorities.findByPriCod", query = "SELECT e FROM EngPriorities e WHERE e.priCod = :priCod"),
    @NamedQuery(name = "EngPriorities.findByPriDescription", query = "SELECT e FROM EngPriorities e WHERE e.priDescription = :priDescription")})
public class EngPriorities implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "toolRequestPrioriy")
    private List<EngToolRequest> engToolRequestList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PRIORITY")
    @SequenceGenerator(name = "SEQ_PRIORITY", sequenceName = "SEQ_PRIORITY", allocationSize = 1)
    @Column(name = "PRI_COD")
    private Short priCod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "PRI_DESCRIPTION")
    private String priDescription;
    @OneToMany(mappedBy = "priCod")
    private List<EngOrders> engOrdersList;

    public EngPriorities() {
        super();
    }

    public EngPriorities(Short priCod) {
        this.priCod = priCod;
    }

    public EngPriorities(Short priCod, String priDescription) {
        this.priCod = priCod;
        this.priDescription = priDescription;
    }

    public Short getPriCod() {
        return priCod;
    }

    public void setPriCod(Short priCod) {
        this.priCod = priCod;
    }

    public String getPriDescription() {
        return priDescription;
    }

    public void setPriDescription(String priDescription) {
        this.priDescription = priDescription;
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
        hash += (priCod != null ? priCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EngPriorities)) {
            return false;
        }
        EngPriorities other = (EngPriorities) object;
        if ((this.priCod == null && other.priCod != null) || (this.priCod != null && !this.priCod.equals(other.priCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngPriorities[ priCod=" + priCod + " ]";
    }

    @XmlTransient
    public List<EngToolRequest> getEngToolRequestList() {
        return engToolRequestList;
    }

    public void setEngToolRequestList(List<EngToolRequest> engToolRequestList) {
        this.engToolRequestList = engToolRequestList;
    }
    
}
