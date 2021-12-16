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
@Table(name = "ENG_GROUPS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngGroups.findAll", query = "SELECT e FROM EngGroups e"),
    @NamedQuery(name = "EngGroups.findByIdgrp", query = "SELECT e FROM EngGroups e WHERE e.idgrp = :idgrp"),
    @NamedQuery(name = "EngGroups.findByName", query = "SELECT e FROM EngGroups e WHERE e.name = :name")})
public class EngGroups implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDGRP")
    private Short idgrp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NAME")
    private String name;

    public EngGroups() {
        super();
    }

    public EngGroups(Short idgrp) {
        this.idgrp = idgrp;
    }

    public EngGroups(Short idgrp, String name) {
        this.idgrp = idgrp;
        this.name = name;
    }

    public Short getIdgrp() {
        return idgrp;
    }

    public void setIdgrp(Short idgrp) {
        this.idgrp = idgrp;
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
        hash += (idgrp != null ? idgrp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EngGroups)) {
            return false;
        }
        EngGroups other = (EngGroups) object;
        if ((this.idgrp == null && other.idgrp != null) || (this.idgrp != null && !this.idgrp.equals(other.idgrp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngGroups[ idgrp=" + idgrp + " ]";
    }
    
}
