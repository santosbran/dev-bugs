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
@Table(name = "CORE_DPTO", catalog = "", schema = "CORE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoreDpto.findAll", query = "SELECT c FROM CoreDpto c"),
    @NamedQuery(name = "CoreDpto.findByDptCod", query = "SELECT c FROM CoreDpto c WHERE c.dptCod = :dptCod"),
    @NamedQuery(name = "CoreDpto.findByDptDescription", query = "SELECT c FROM CoreDpto c WHERE c.dptDescription = :dptDescription"),
    @NamedQuery(name = "CoreDpto.findByDptActive", query = "SELECT c FROM CoreDpto c WHERE c.dptActive = :dptActive")})
public class CoreDpto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DPT_COD")
    private Short dptCod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DPT_DESCRIPTION")
    private String dptDescription;
    @Size(max = 1)
    @Column(name = "DPT_ACTIVE")
    private String dptActive;

    public CoreDpto() {
        super();
    }

    public CoreDpto(Short dptCod) {
        this.dptCod = dptCod;
    }

    public CoreDpto(Short dptCod, String dptDescription) {
        this.dptCod = dptCod;
        this.dptDescription = dptDescription;
    }

    public Short getDptCod() {
        return dptCod;
    }

    public void setDptCod(Short dptCod) {
        this.dptCod = dptCod;
    }

    public String getDptDescription() {
        return dptDescription;
    }

    public void setDptDescription(String dptDescription) {
        this.dptDescription = dptDescription;
    }

    public String getDptActive() {
        return dptActive;
    }

    public void setDptActive(String dptActive) {
        this.dptActive = dptActive;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dptCod != null ? dptCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof CoreDpto)) {
            return false;
        }
        CoreDpto other = (CoreDpto) object;
        if ((this.dptCod == null && other.dptCod != null) || (this.dptCod != null && !this.dptCod.equals(other.dptCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.grant.CoreDpto[ dptCod=" + dptCod + " ]";
    }
    
}
