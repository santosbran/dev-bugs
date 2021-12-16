/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author saplic
 */
@Entity
@Cacheable(false)
@Table(name = "AECAS_ADVANCE", catalog = "", schema = "AECAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AecasAdvance.findAll", query = "SELECT a FROM AecasAdvance a"),
    @NamedQuery(name = "AecasAdvance.findByIdAdvance", query = "SELECT a FROM AecasAdvance a WHERE a.idAdvance = :idAdvance"),
    @NamedQuery(name = "AecasAdvance.findByStatusAdvance", query = "SELECT a FROM AecasAdvance a WHERE a.statusAdvance = :statusAdvance"),
    @NamedQuery(name = "AecasAdvance.findBySinceAdvance", query = "SELECT a FROM AecasAdvance a WHERE a.sinceAdvance = :sinceAdvance"),
    @NamedQuery(name = "AecasAdvance.findByUntilAdvance", query = "SELECT a FROM AecasAdvance a WHERE a.untilAdvance = :untilAdvance"),
    @NamedQuery(name = "AecasAdvance.findByAdvanceDesc", query = "SELECT a FROM AecasAdvance a WHERE a.advanceDesc = :advanceDesc"),
    @NamedQuery(name = "AecasAdvance.findByCucod", query = "SELECT a FROM AecasAdvance a WHERE a.cucod = :cucod"),
    @NamedQuery(name = "AecasAdvance.findByGacreg", query = "SELECT a FROM AecasAdvance a WHERE a.gacreg = :gacreg"),
    @NamedQuery(name = "AecasAdvance.findByUserCrea", query = "SELECT a FROM AecasAdvance a WHERE a.userCrea = :userCrea"),
    @NamedQuery(name = "AecasAdvance.findByDateCrea", query = "SELECT a FROM AecasAdvance a WHERE a.dateCrea = :dateCrea"),
    @NamedQuery(name = "AecasAdvance.findByUserModificacion", query = "SELECT a FROM AecasAdvance a WHERE a.userModificacion = :userModificacion"),
    @NamedQuery(name = "AecasAdvance.findByFechaModificacion", query = "SELECT a FROM AecasAdvance a WHERE a.fechaModificacion = :fechaModificacion")})
public class AecasAdvance implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ADVANCE")
    private BigDecimal idAdvance;
    @Column(name = "STATUS_ADVANCE")
    private Character statusAdvance;
    @Column(name = "SINCE_ADVANCE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sinceAdvance;
    @Column(name = "UNTIL_ADVANCE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date untilAdvance;
    @Size(max = 150)
    @Column(name = "ADVANCE_DESC")
    private String advanceDesc;
    @Size(max = 8)
    @Column(name = "CUCOD")
    private String cucod;
    @Size(max = 8)
    @Column(name = "GACREG")
    private String gacreg;
    @Size(max = 20)
    @Column(name = "USER_CREA")
    private String userCrea;
    @Column(name = "DATE_CREA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCrea;
    @Size(max = 20)
    @Column(name = "USER_MODIFICACION")
    private String userModificacion;
    @Column(name = "FECHA_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @OneToMany(mappedBy = "idAdvance")
    private List<AecasEsrMh> aecasEsrMhList;

    public AecasAdvance() {
        super();
    }

    public AecasAdvance(BigDecimal idAdvance) {
        this.idAdvance = idAdvance;
    }

    public BigDecimal getIdAdvance() {
        return idAdvance;
    }

    public void setIdAdvance(BigDecimal idAdvance) {
        this.idAdvance = idAdvance;
    }

    public Character getStatusAdvance() {
        return statusAdvance;
    }

    public void setStatusAdvance(Character statusAdvance) {
        this.statusAdvance = statusAdvance;
    }

    public Date getSinceAdvance() {
        return sinceAdvance;
    }

    public void setSinceAdvance(Date sinceAdvance) {
        this.sinceAdvance = sinceAdvance;
    }

    public Date getUntilAdvance() {
        return untilAdvance;
    }

    public void setUntilAdvance(Date untilAdvance) {
        this.untilAdvance = untilAdvance;
    }

    public String getAdvanceDesc() {
        return advanceDesc;
    }

    public void setAdvanceDesc(String advanceDesc) {
        this.advanceDesc = advanceDesc;
    }

    public String getCucod() {
        return cucod;
    }

    public void setCucod(String cucod) {
        this.cucod = cucod;
    }

    public String getGacreg() {
        return gacreg;
    }

    public void setGacreg(String gacreg) {
        this.gacreg = gacreg;
    }

    public String getUserCrea() {
        return userCrea;
    }

    public void setUserCrea(String userCrea) {
        this.userCrea = userCrea;
    }

    public Date getDateCrea() {
        return dateCrea;
    }

    public void setDateCrea(Date dateCrea) {
        this.dateCrea = dateCrea;
    }

    public String getUserModificacion() {
        return userModificacion;
    }

    public void setUserModificacion(String userModificacion) {
        this.userModificacion = userModificacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    @XmlTransient
    public List<AecasEsrMh> getAecasEsrMhList() {
        return aecasEsrMhList;
    }

    public void setAecasEsrMhList(List<AecasEsrMh> aecasEsrMhList) {
        this.aecasEsrMhList = aecasEsrMhList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAdvance != null ? idAdvance.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof AecasAdvance)) {
            return false;
        }
        AecasAdvance other = (AecasAdvance) object;
        if ((this.idAdvance == null && other.idAdvance != null) || (this.idAdvance != null && !this.idAdvance.equals(other.idAdvance))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.AecasAdvance[ idAdvance=" + idAdvance + " ]";
    }
    
}
