/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Cacheable(false)
@Table(name = "ENG_AC_REGISTRATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngAcRegistration.findAll", query = "SELECT e FROM EngAcRegistration e"),
    @NamedQuery(name = "EngAcRegistration.findByRegistry", query = "SELECT e FROM EngAcRegistration e WHERE e.registry = :registry"),
    @NamedQuery(name = "EngAcRegistration.findByDescription", query = "SELECT e FROM EngAcRegistration e WHERE e.description = :description"),
    @NamedQuery(name = "EngAcRegistration.findByCodflt", query = "SELECT e FROM EngAcRegistration e WHERE e.codflt = :codflt"),
    @NamedQuery(name = "EngAcRegistration.findByLineNumber", query = "SELECT e FROM EngAcRegistration e WHERE e.lineNumber = :lineNumber"),
    @NamedQuery(name = "EngAcRegistration.findByVariableNumber", query = "SELECT e FROM EngAcRegistration e WHERE e.variableNumber = :variableNumber"),
    @NamedQuery(name = "EngAcRegistration.findBySerialNumber", query = "SELECT e FROM EngAcRegistration e WHERE e.serialNumber = :serialNumber"),
    @NamedQuery(name = "EngAcRegistration.findByMfctDate", query = "SELECT e FROM EngAcRegistration e WHERE e.mfctDate = :mfctDate"),
    @NamedQuery(name = "EngAcRegistration.findByTotalTime", query = "SELECT e FROM EngAcRegistration e WHERE e.totalTime = :totalTime"),
    @NamedQuery(name = "EngAcRegistration.findByTotalCycles", query = "SELECT e FROM EngAcRegistration e WHERE e.totalCycles = :totalCycles"),
    @NamedQuery(name = "EngAcRegistration.findByFsn", query = "SELECT e FROM EngAcRegistration e WHERE e.fsn = :fsn"),
    @NamedQuery(name = "EngAcRegistration.findByIsown", query = "SELECT e FROM EngAcRegistration e WHERE e.isown = :isown")})
public class EngAcRegistration implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "REGISTRY")
    private String registry;
    @Size(max = 100)
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CODFLT")
    private String codflt;
    @Size(max = 20)
    @Column(name = "LINE_NUMBER")
    private String lineNumber;
    @Size(max = 20)
    @Column(name = "VARIABLE_NUMBER")
    private String variableNumber;
    @Size(max = 20)
    @Column(name = "SERIAL_NUMBER")
    private String serialNumber;
    @Column(name = "MFCT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date mfctDate;
    @Column(name = "TOTAL_TIME")
    private Long totalTime;
    @Column(name = "TOTAL_CYCLES")
    private Long totalCycles;
    @Size(max = 4)
    @Column(name = "FSN")
    private String fsn;
    @Size(max = 1)
    @Column(name = "ISOWN")
    private String isown;

    public EngAcRegistration() {
        super();
    }

    public EngAcRegistration(String registry) {
        this.registry = registry;
    }

    public EngAcRegistration(String registry, String codflt) {
        this.registry = registry;
        this.codflt = codflt;
    }

    public String getRegistry() {
        return registry;
    }

    public void setRegistry(String registry) {
        this.registry = registry;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCodflt() {
        return codflt;
    }

    public void setCodflt(String codflt) {
        this.codflt = codflt;
    }

    public String getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getVariableNumber() {
        return variableNumber;
    }

    public void setVariableNumber(String variableNumber) {
        this.variableNumber = variableNumber;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Date getMfctDate() {
        return mfctDate;
    }

    public void setMfctDate(Date mfctDate) {
        this.mfctDate = mfctDate;
    }

    public Long getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Long totalTime) {
        this.totalTime = totalTime;
    }

    public Long getTotalCycles() {
        return totalCycles;
    }

    public void setTotalCycles(Long totalCycles) {
        this.totalCycles = totalCycles;
    }

    public String getFsn() {
        return fsn;
    }

    public void setFsn(String fsn) {
        this.fsn = fsn;
    }

    public String getIsown() {
        return isown;
    }

    public void setIsown(String isown) {
        this.isown = isown;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (registry != null ? registry.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EngAcRegistration)) {
            return false;
        }
        EngAcRegistration other = (EngAcRegistration) object;
        if ((this.registry == null && other.registry != null) || (this.registry != null && !this.registry.equals(other.registry))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngAcRegistration[ registry=" + registry + " ]";
    }
    
}
