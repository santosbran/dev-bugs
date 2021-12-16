/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * @author saplic
 */
@Entity
@Cacheable(false)
@Table(name = "ENG_CARGA_ESR_WO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngCargaEsrWo.findAll", query = "SELECT e FROM EngCargaEsrWo e"),
    @NamedQuery(name = "EngCargaEsrWo.findByCargaRegistry", query = "SELECT e FROM EngCargaEsrWo e WHERE e.cargaRegistry = :cargaRegistry"),
    @NamedQuery(name = "EngCargaEsrWo.findByCargaWo", query = "SELECT e FROM EngCargaEsrWo e WHERE e.cargaWo = :cargaWo"),
    @NamedQuery(name = "EngCargaEsrWo.findByCargaCierrewo", query = "SELECT e FROM EngCargaEsrWo e WHERE e.cargaCierrewo = :cargaCierrewo"),
    @NamedQuery(name = "EngCargaEsrWo.findByCargaNumEsr", query = "SELECT e FROM EngCargaEsrWo e WHERE e.cargaNumEsr = :cargaNumEsr"),
    @NamedQuery(name = "EngCargaEsrWo.findByCargaStdEsr", query = "SELECT e FROM EngCargaEsrWo e WHERE e.cargaStdEsr = :cargaStdEsr"),
    @NamedQuery(name = "EngCargaEsrWo.findByCargaCstmEsr", query = "SELECT e FROM EngCargaEsrWo e WHERE e.cargaCstmEsr = :cargaCstmEsr"),
    @NamedQuery(name = "EngCargaEsrWo.findByCargaCrealEsr", query = "SELECT e FROM EngCargaEsrWo e WHERE e.cargaCrealEsr = :cargaCrealEsr"),
    @NamedQuery(name = "EngCargaEsrWo.findByCargaIng", query = "SELECT e FROM EngCargaEsrWo e WHERE e.cargaIng = :cargaIng"),
    @NamedQuery(name = "EngCargaEsrWo.findByCargaOntime", query = "SELECT e FROM EngCargaEsrWo e WHERE e.cargaOntime = :cargaOntime"),
    @NamedQuery(name = "EngCargaEsrWo.findByCargaUsr", query = "SELECT e FROM EngCargaEsrWo e WHERE e.cargaUsr = :cargaUsr"),
    @NamedQuery(name = "EngCargaEsrWo.findByCargaUsrDate", query = "SELECT e FROM EngCargaEsrWo e WHERE e.cargaUsrDate = :cargaUsrDate"),
    @NamedQuery(name = "EngCargaEsrWo.findByCargaWoStd", query = "SELECT e FROM EngCargaEsrWo e WHERE e.cargaWoStd = :cargaWoStd"),
    @NamedQuery(name = "EngCargaEsrWo.findByCargaStdCode", query = "SELECT e FROM EngCargaEsrWo e WHERE e.cargaStdCode = :cargaStdCode"),
    @NamedQuery(name = "EngCargaEsrWo.findByCargaId", query = "SELECT e FROM EngCargaEsrWo e WHERE e.cargaId = :cargaId")})
public class EngCargaEsrWo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CARGA_REGISTRY")
    private String cargaRegistry;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CARGA_WO")
    private String cargaWo;
    @Column(name = "CARGA_CIERREWO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cargaCierrewo;
    @Size(max = 20)
    @Column(name = "CARGA_NUM_ESR")
    private String cargaNumEsr;
    @Size(max = 100)
    @Column(name = "CARGA_STD_ESR")
    private String cargaStdEsr;
    @Column(name = "CARGA_CSTM_ESR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cargaCstmEsr;
    @Column(name = "CARGA_CREAL_ESR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cargaCrealEsr;
    @Size(max = 50)
    @Column(name = "CARGA_ING")
    private String cargaIng;
    @Size(max = 20)
    @Column(name = "CARGA_ONTIME")
    private String cargaOntime;
    @Size(max = 20)
    @Column(name = "CARGA_USR")
    private String cargaUsr;
    @Size(max = 20)
    @Column(name = "CARGA_USR_DATE")
    private String cargaUsrDate;
    @Size(max = 20)
    @Column(name = "CARGA_WO_STD")
    private String cargaWoStd;
    @Size(max = 3)
    @Column(name = "CARGA_STD_CODE")
    private String cargaStdCode;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CARGA_ID")
    private BigDecimal cargaId;

    public EngCargaEsrWo() {
        super();
    }

    public EngCargaEsrWo(BigDecimal cargaId) {
        this.cargaId = cargaId;
    }

    public EngCargaEsrWo(BigDecimal cargaId, String cargaRegistry, String cargaWo) {
        this.cargaId = cargaId;
        this.cargaRegistry = cargaRegistry;
        this.cargaWo = cargaWo;
    }

    public String getCargaRegistry() {
        return cargaRegistry;
    }

    public void setCargaRegistry(String cargaRegistry) {
        this.cargaRegistry = cargaRegistry;
    }

    public String getCargaWo() {
        return cargaWo;
    }

    public void setCargaWo(String cargaWo) {
        this.cargaWo = cargaWo;
    }

    public Date getCargaCierrewo() {
        return cargaCierrewo;
    }

    public void setCargaCierrewo(Date cargaCierrewo) {
        this.cargaCierrewo = cargaCierrewo;
    }

    public String getCargaNumEsr() {
        return cargaNumEsr;
    }

    public void setCargaNumEsr(String cargaNumEsr) {
        this.cargaNumEsr = cargaNumEsr;
    }

    public String getCargaStdEsr() {
        return cargaStdEsr;
    }

    public void setCargaStdEsr(String cargaStdEsr) {
        this.cargaStdEsr = cargaStdEsr;
    }

    public Date getCargaCstmEsr() {
        return cargaCstmEsr;
    }

    public void setCargaCstmEsr(Date cargaCstmEsr) {
        this.cargaCstmEsr = cargaCstmEsr;
    }

    public Date getCargaCrealEsr() {
        return cargaCrealEsr;
    }

    public void setCargaCrealEsr(Date cargaCrealEsr) {
        this.cargaCrealEsr = cargaCrealEsr;
    }

    public String getCargaIng() {
        return cargaIng;
    }

    public void setCargaIng(String cargaIng) {
        this.cargaIng = cargaIng;
    }

    public String getCargaOntime() {
        return cargaOntime;
    }

    public void setCargaOntime(String cargaOntime) {
        this.cargaOntime = cargaOntime;
    }

    public String getCargaUsr() {
        return cargaUsr;
    }

    public void setCargaUsr(String cargaUsr) {
        this.cargaUsr = cargaUsr;
    }

    public String getCargaUsrDate() {
        return cargaUsrDate;
    }

    public void setCargaUsrDate(String cargaUsrDate) {
        this.cargaUsrDate = cargaUsrDate;
    }

    public String getCargaWoStd() {
        return cargaWoStd;
    }

    public void setCargaWoStd(String cargaWoStd) {
        this.cargaWoStd = cargaWoStd;
    }

    public String getCargaStdCode() {
        return cargaStdCode;
    }

    public void setCargaStdCode(String cargaStdCode) {
        this.cargaStdCode = cargaStdCode;
    }

    public BigDecimal getCargaId() {
        return cargaId;
    }

    public void setCargaId(BigDecimal cargaId) {
        this.cargaId = cargaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cargaId != null ? cargaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EngCargaEsrWo)) {
            return false;
        }
        EngCargaEsrWo other = (EngCargaEsrWo) object;
        if ((this.cargaId == null && other.cargaId != null) || (this.cargaId != null && !this.cargaId.equals(other.cargaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngCargaEsrWo[ cargaId=" + cargaId + " ]";
    }
    
}
