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
@Table(name = "ENG_DISTLIST_CONFIG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngDistlistConfig.findAll", query = "SELECT e FROM EngDistlistConfig e"),
    @NamedQuery(name = "EngDistlistConfig.findByDlcId", query = "SELECT e FROM EngDistlistConfig e WHERE e.dlcId = :dlcId"),
    @NamedQuery(name = "EngDistlistConfig.findByDlcDescription", query = "SELECT e FROM EngDistlistConfig e WHERE e.dlcDescription = :dlcDescription"),
    @NamedQuery(name = "EngDistlistConfig.findByDlcStatus", query = "SELECT e FROM EngDistlistConfig e WHERE e.dlcStatus = :dlcStatus")})
public class EngDistlistConfig implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DLC_ID")
    private Integer dlcId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DLC_DESCRIPTION")
    private String dlcDescription;
    @Size(max = 3)
    @Column(name = "DLC_STATUS")
    private String dlcStatus;

    public EngDistlistConfig() {
        super();
    }

    public EngDistlistConfig(Integer dlcId) {
        this.dlcId = dlcId;
    }

    public EngDistlistConfig(Integer dlcId, String dlcDescription) {
        this.dlcId = dlcId;
        this.dlcDescription = dlcDescription;
    }

    public Integer getDlcId() {
        return dlcId;
    }

    public void setDlcId(Integer dlcId) {
        this.dlcId = dlcId;
    }

    public String getDlcDescription() {
        return dlcDescription;
    }

    public void setDlcDescription(String dlcDescription) {
        this.dlcDescription = dlcDescription;
    }

    public String getDlcStatus() {
        return dlcStatus;
    }

    public void setDlcStatus(String dlcStatus) {
        this.dlcStatus = dlcStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dlcId != null ? dlcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EngDistlistConfig)) {
            return false;
        }
        EngDistlistConfig other = (EngDistlistConfig) object;
        if ((this.dlcId == null && other.dlcId != null) || (this.dlcId != null && !this.dlcId.equals(other.dlcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngDistlistConfig[ dlcId=" + dlcId + " ]";
    }
    
}
