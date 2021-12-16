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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vjuarez
 */
@Entity
@Cacheable(false)
@Table(name = "ENG_ESR_PROV")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngEsrProv.findAll", query = "SELECT e FROM EngEsrProv e"),
    @NamedQuery(name = "EngEsrProv.findByIdpord", query = "SELECT e FROM EngEsrProv e WHERE e.idpord = :idpord"),
    @NamedQuery(name = "EngEsrProv.findByMessageid", query = "SELECT e FROM EngEsrProv e WHERE e.messageid = :messageid"),
    @NamedQuery(name = "EngEsrProv.findByNumeo", query = "SELECT e FROM EngEsrProv e WHERE e.numeo = :numeo"),
    @NamedQuery(name = "EngEsrProv.findByUserIns", query = "SELECT e FROM EngEsrProv e WHERE e.userIns = :userIns"),
    @NamedQuery(name = "EngEsrProv.findByFechaIns", query = "SELECT e FROM EngEsrProv e WHERE e.fechaIns = :fechaIns"),
    @NamedQuery(name = "EngEsrProv.findByUserAct", query = "SELECT e FROM EngEsrProv e WHERE e.userAct = :userAct"),
    @NamedQuery(name = "EngEsrProv.findByFechaAct", query = "SELECT e FROM EngEsrProv e WHERE e.fechaAct = :fechaAct"),
    @NamedQuery(name = "EngEsrProv.findByApproved", query = "SELECT e FROM EngEsrProv e WHERE e.approved = :approved")})
public class EngEsrProv implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENG_ESR_PROV_SEQ")
    @SequenceGenerator(name = "ENG_ESR_PROV_SEQ", sequenceName = "ENG_ESR_PROV_SEQ", allocationSize = 1)
    @Column(name = "IDPORD")
    private Integer idpord;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MESSAGEID")
    private int messageid;
    @Size(max = 40)
    @Column(name = "NUMEO")
    private String numeo;
    @Size(max = 30)
    @Column(name = "USER_INS")
    private String userIns;
    @Column(name = "FECHA_INS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIns;
    @Size(max = 30)
    @Column(name = "USER_ACT")
    private String userAct;
    @Column(name = "FECHA_ACT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAct;
    @Size(max = 1)
    @Column(name = "APPROVED")
    private String approved;

    public EngEsrProv() {
        super();
    }

    public EngEsrProv(Integer idpord) {
        this.idpord = idpord;
    }

    public EngEsrProv(Integer idpord, int messageid) {
        this.idpord = idpord;
        this.messageid = messageid;
    }

    public Integer getIdpord() {
        return idpord;
    }

    public void setIdpord(Integer idpord) {
        this.idpord = idpord;
    }

    public int getMessageid() {
        return messageid;
    }

    public void setMessageid(int messageid) {
        this.messageid = messageid;
    }

    public String getNumeo() {
        return numeo;
    }

    public void setNumeo(String numeo) {
        this.numeo = numeo;
    }

    public String getUserIns() {
        return userIns;
    }

    public void setUserIns(String userIns) {
        this.userIns = userIns;
    }

    public Date getFechaIns() {
        return fechaIns;
    }

    public void setFechaIns(Date fechaIns) {
        this.fechaIns = fechaIns;
    }

    public String getUserAct() {
        return userAct;
    }

    public void setUserAct(String userAct) {
        this.userAct = userAct;
    }

    public Date getFechaAct() {
        return fechaAct;
    }

    public void setFechaAct(Date fechaAct) {
        this.fechaAct = fechaAct;
    }

    public String getApproved() {
        return approved;
    }

    public void setApproved(String approved) {
        this.approved = approved;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpord != null ? idpord.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EngEsrProv)) {
            return false;
        }
        EngEsrProv other = (EngEsrProv) object;
        if ((this.idpord == null && other.idpord != null) || (this.idpord != null && !this.idpord.equals(other.idpord))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngEsrProv[ idpord=" + idpord + " ]";
    }
    
}
