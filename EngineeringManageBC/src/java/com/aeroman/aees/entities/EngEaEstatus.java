/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
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
@Cacheable(false)
@Table(name = "ENG_EA_ESTATUS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngEaEstatus.findAll", query = "SELECT e FROM EngEaEstatus e"),
    @NamedQuery(name = "EngEaEstatus.findByEaeId", query = "SELECT e FROM EngEaEstatus e WHERE e.eaeId = :eaeId"),
    @NamedQuery(name = "EngEaEstatus.findByEaeType", query = "SELECT e FROM EngEaEstatus e WHERE e.eaeType = :eaeType"),
    @NamedQuery(name = "EngEaEstatus.findByEaeEstName", query = "SELECT e FROM EngEaEstatus e WHERE e.eaeEstName = :eaeEstName")})
public class EngEaEstatus implements Serializable {
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estEstatus")
    private Collection<EngEaGeneral> engEaGeneralCollection;
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "EAE_ID")
    private String eaeId;
    @Size(max = 3)
    @Column(name = "EAE_TYPE")
    private String eaeType;
    @Size(max = 50)
    @Column(name = "EAE_EST_NAME")
    private String eaeEstName;
   

    public EngEaEstatus() {
        super();
    }

    public EngEaEstatus(String eaeId) {
        this.eaeId = eaeId;
    }

    public String getEaeId() {
        return eaeId;
    }

    public void setEaeId(String eaeId) {
        this.eaeId = eaeId;
    }

    public String getEaeType() {
        return eaeType;
    }

    public void setEaeType(String eaeType) {
        this.eaeType = eaeType;
    }

    public String getEaeEstName() {
        return eaeEstName;
    }

    public void setEaeEstName(String eaeEstName) {
        this.eaeEstName = eaeEstName;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eaeId != null ? eaeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EngEaEstatus)) {
            return false;
        }
        EngEaEstatus other = (EngEaEstatus) object;
        if ((this.eaeId == null && other.eaeId != null) || (this.eaeId != null && !this.eaeId.equals(other.eaeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngEaEstatus[ eaeId=" + eaeId + " ]";
    }

    public Iterable<EngEaEstatus> getListado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @XmlTransient
    public Collection<EngEaGeneral> getEngEaGeneralCollection() {
        return engEaGeneralCollection;
    }

    public void setEngEaGeneralCollection(Collection<EngEaGeneral> engEaGeneralCollection) {
        this.engEaGeneralCollection = engEaGeneralCollection;
    }
    
}
