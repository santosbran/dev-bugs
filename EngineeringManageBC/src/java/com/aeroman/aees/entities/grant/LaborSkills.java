/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities.grant;

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
 * @author Usuario
 */
@Entity
@Cacheable(false)
@Table(name = "LABOR_SKILLS", catalog = "", schema = "LABOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LaborSkills.findAll", query = "SELECT l FROM LaborSkills l"),
    @NamedQuery(name = "LaborSkills.findBySklCod", query = "SELECT l FROM LaborSkills l WHERE l.sklCod = :sklCod"),
    @NamedQuery(name = "LaborSkills.findBySklDescription", query = "SELECT l FROM LaborSkills l WHERE l.sklDescription = :sklDescription")})
public class LaborSkills implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "SKL_COD")
    private String sklCod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "SKL_DESCRIPTION")
    private String sklDescription;

    public LaborSkills() {
        super();
    }

    public LaborSkills(String sklCod) {
        this.sklCod = sklCod;
    }

    public LaborSkills(String sklCod, String sklDescription) {
        this.sklCod = sklCod;
        this.sklDescription = sklDescription;
    }

    public String getSklCod() {
        return sklCod;
    }

    public void setSklCod(String sklCod) {
        this.sklCod = sklCod;
    }

    public String getSklDescription() {
        return sklDescription;
    }

    public void setSklDescription(String sklDescription) {
        this.sklDescription = sklDescription;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sklCod != null ? sklCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof LaborSkills)) {
            return false;
        }
        LaborSkills other = (LaborSkills) object;
        if ((this.sklCod == null && other.sklCod != null) || (this.sklCod != null && !this.sklCod.equals(other.sklCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.grant.LaborSkills[ sklCod=" + sklCod + " ]";
    }
    
}
