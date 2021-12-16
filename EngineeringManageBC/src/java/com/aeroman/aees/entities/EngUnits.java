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
@Table(name = "ENG_UNITS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngUnits.findAll", query = "SELECT e FROM EngUnits e"),
    @NamedQuery(name = "EngUnits.findByIduni", query = "SELECT e FROM EngUnits e WHERE e.iduni = :iduni"),
    @NamedQuery(name = "EngUnits.findByName", query = "SELECT e FROM EngUnits e WHERE e.name = :name")})
public class EngUnits implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDUNI")
    private Short iduni;
    @Size(max = 50)
    @Column(name = "NAME")
    private String name;

    public EngUnits() {
        super();
    }

    public EngUnits(Short iduni) {
        this.iduni = iduni;
    }

    public Short getIduni() {
        return iduni;
    }

    public void setIduni(Short iduni) {
        this.iduni = iduni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iduni != null ? iduni.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EngUnits)) {
            return false;
        }
        EngUnits other = (EngUnits) object;
        if ((this.iduni == null && other.iduni != null) || (this.iduni != null && !this.iduni.equals(other.iduni))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngUnits[ iduni=" + iduni + " ]";
    }
    
}
