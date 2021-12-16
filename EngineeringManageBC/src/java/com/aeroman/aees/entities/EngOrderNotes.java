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
@Table(name = "ENG_ORDER_NOTES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngOrderNotes.findAll", query = "SELECT e FROM EngOrderNotes e"),
    @NamedQuery(name = "EngOrderNotes.findByIdnot", query = "SELECT e FROM EngOrderNotes e WHERE e.idnot = :idnot"),
    @NamedQuery(name = "EngOrderNotes.findByName", query = "SELECT e FROM EngOrderNotes e WHERE e.name = :name")})
public class EngOrderNotes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDNOT")
    private Short idnot;
    @Size(max = 100)
    @Column(name = "NAME")
    private String name;

    public EngOrderNotes() {
        super();
    }

    public EngOrderNotes(Short idnot) {
        this.idnot = idnot;
    }

    public Short getIdnot() {
        return idnot;
    }

    public void setIdnot(Short idnot) {
        this.idnot = idnot;
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
        hash += (idnot != null ? idnot.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EngOrderNotes)) {
            return false;
        }
        EngOrderNotes other = (EngOrderNotes) object;
        if ((this.idnot == null && other.idnot != null) || (this.idnot != null && !this.idnot.equals(other.idnot))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngOrderNotes[ idnot=" + idnot + " ]";
    }
    
}
