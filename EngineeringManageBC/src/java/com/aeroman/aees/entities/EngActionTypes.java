/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
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
@Cacheable(false)
@Table(name = "ENG_ACTION_TYPES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngActionTypes.findAll", query = "SELECT e FROM EngActionTypes e"),
    @NamedQuery(name = "EngActionTypes.findByCodact", query = "SELECT e FROM EngActionTypes e WHERE e.codact = :codact"),
    @NamedQuery(name = "EngActionTypes.findByDescription", query = "SELECT e FROM EngActionTypes e WHERE e.description = :description")})
public class EngActionTypes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "CODACT")
    private String codact;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "DESCRIPTION")
    private String description;

    public EngActionTypes() {
        super();
    }

    public EngActionTypes(String codact) {
        this.codact = codact;
    }

    public EngActionTypes(String codact, String description) {
        this.codact = codact;
        this.description = description;
    }

    public String getCodact() {
        return codact;
    }

    public void setCodact(String codact) {
        this.codact = codact;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codact != null ? codact.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EngActionTypes)) {
            return false;
        }
        EngActionTypes other = (EngActionTypes) object;
        if ((this.codact == null && other.codact != null) || (this.codact != null && !this.codact.equals(other.codact))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngActionTypes[ codact=" + codact + " ]";
    }
    
}
