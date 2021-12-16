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
@Table(name = "ENG_USER_SKILL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngUserSkill.findAll", query = "SELECT e FROM EngUserSkill e"),
    @NamedQuery(name = "EngUserSkill.findByUsklCod", query = "SELECT e FROM EngUserSkill e WHERE e.usklCod = :usklCod"),
    @NamedQuery(name = "EngUserSkill.findByIsklNameskill", query = "SELECT e FROM EngUserSkill e WHERE e.isklNameskill = :isklNameskill"),
    @NamedQuery(name = "EngUserSkill.findByUsklActive", query = "SELECT e FROM EngUserSkill e WHERE e.usklActive = :usklActive")})
public class EngUserSkill implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "USKL_COD")
    private Short usklCod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ISKL_NAMESKILL")
    private String isklNameskill;
    @Size(max = 1)
    @Column(name = "USKL_ACTIVE")
    private String usklActive;

    public EngUserSkill() {
        super();
    }

    public EngUserSkill(Short usklCod) {
        this.usklCod = usklCod;
    }

    public EngUserSkill(Short usklCod, String isklNameskill) {
        this.usklCod = usklCod;
        this.isklNameskill = isklNameskill;
    }

    public Short getUsklCod() {
        return usklCod;
    }

    public void setUsklCod(Short usklCod) {
        this.usklCod = usklCod;
    }

    public String getIsklNameskill() {
        return isklNameskill;
    }

    public void setIsklNameskill(String isklNameskill) {
        this.isklNameskill = isklNameskill;
    }

    public String getUsklActive() {
        return usklActive;
    }

    public void setUsklActive(String usklActive) {
        this.usklActive = usklActive;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usklCod != null ? usklCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EngUserSkill)) {
            return false;
        }
        EngUserSkill other = (EngUserSkill) object;
        if ((this.usklCod == null && other.usklCod != null) || (this.usklCod != null && !this.usklCod.equals(other.usklCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngUserSkill[ usklCod=" + usklCod + " ]";
    }
    
}
