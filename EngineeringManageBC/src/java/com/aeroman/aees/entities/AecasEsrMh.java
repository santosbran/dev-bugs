/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author saplic
 */
@Entity
@Cacheable(false)
@Table(name = "AECAS_ESR_MH", catalog = "", schema = "AECAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AecasEsrMh.findAll", query = "SELECT a FROM AecasEsrMh a"),
    @NamedQuery(name = "AecasEsrMh.findByEsrWoYear", query = "SELECT a FROM AecasEsrMh a WHERE a.aecasEsrMhPK.esrWoYear = :esrWoYear"),
    @NamedQuery(name = "AecasEsrMh.findByEsrWoOrder", query = "SELECT a FROM AecasEsrMh a WHERE a.aecasEsrMhPK.esrWoOrder = :esrWoOrder"),
    @NamedQuery(name = "AecasEsrMh.findByEsrWoTask", query = "SELECT a FROM AecasEsrMh a WHERE a.aecasEsrMhPK.esrWoTask = :esrWoTask"),
    @NamedQuery(name = "AecasEsrMh.findByEsrAcreg", query = "SELECT a FROM AecasEsrMh a WHERE a.aecasEsrMhPK.esrAcreg = :esrAcreg"),
    @NamedQuery(name = "AecasEsrMh.findByEsrCucod", query = "SELECT a FROM AecasEsrMh a WHERE a.aecasEsrMhPK.esrCucod = :esrCucod"),
    @NamedQuery(name = "AecasEsrMh.findByEsrEsrId", query = "SELECT a FROM AecasEsrMh a WHERE a.aecasEsrMhPK.esrEsrId = :esrEsrId"),
    @NamedQuery(name = "AecasEsrMh.findByEsrPreliminary", query = "SELECT a FROM AecasEsrMh a WHERE a.esrPreliminary = :esrPreliminary"),
    @NamedQuery(name = "AecasEsrMh.findByEsrFinal", query = "SELECT a FROM AecasEsrMh a WHERE a.esrFinal = :esrFinal"),
    @NamedQuery(name = "AecasEsrMh.findByEsrUsuarioCrea", query = "SELECT a FROM AecasEsrMh a WHERE a.esrUsuarioCrea = :esrUsuarioCrea"),
    @NamedQuery(name = "AecasEsrMh.findByEsrFechaCrea", query = "SELECT a FROM AecasEsrMh a WHERE a.esrFechaCrea = :esrFechaCrea"),
    @NamedQuery(name = "AecasEsrMh.findByEsrUsuarioMod", query = "SELECT a FROM AecasEsrMh a WHERE a.esrUsuarioMod = :esrUsuarioMod"),
    @NamedQuery(name = "AecasEsrMh.findByEsrFechaMod", query = "SELECT a FROM AecasEsrMh a WHERE a.esrFechaMod = :esrFechaMod"),
    @NamedQuery(name = "AecasEsrMh.findByEsrUserFinalMod", query = "SELECT a FROM AecasEsrMh a WHERE a.esrUserFinalMod = :esrUserFinalMod"),
    @NamedQuery(name = "AecasEsrMh.findByEsrFechaFinalMod", query = "SELECT a FROM AecasEsrMh a WHERE a.esrFechaFinalMod = :esrFechaFinalMod"),
    @NamedQuery(name = "AecasEsrMh.findByEsrEngRate", query = "SELECT a FROM AecasEsrMh a WHERE a.esrEngRate = :esrEngRate")})
public class AecasEsrMh implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AecasEsrMhPK aecasEsrMhPK;
    @Column(name = "ESR_PRELIMINARY")
    private BigInteger esrPreliminary;
    @Column(name = "ESR_FINAL")
    private BigDecimal esrFinal;
    @Size(max = 20)
    @Column(name = "ESR_USUARIO_CREA")
    private String esrUsuarioCrea;
    @Column(name = "ESR_FECHA_CREA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date esrFechaCrea;
    @Size(max = 20)
    @Column(name = "ESR_USUARIO_MOD")
    private String esrUsuarioMod;
    @Column(name = "ESR_FECHA_MOD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date esrFechaMod;
    @Size(max = 20)
    @Column(name = "ESR_USER_FINAL_MOD")
    private String esrUserFinalMod;
    @Column(name = "ESR_FECHA_FINAL_MOD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date esrFechaFinalMod;
    @Column(name = "ESR_ENG_RATE")
    private BigInteger esrEngRate;
    @JoinColumn(name = "ID_ADVANCE", referencedColumnName = "ID_ADVANCE")
    @ManyToOne
    private AecasAdvance idAdvance;

    public AecasEsrMh() {
        super();
    }

    public AecasEsrMh(AecasEsrMhPK aecasEsrMhPK) {
        this.aecasEsrMhPK = aecasEsrMhPK;
    }

    public AecasEsrMh(String esrWoYear, String esrWoOrder, String esrWoTask, String esrAcreg, String esrCucod, String esrEsrId) {
        this.aecasEsrMhPK = new AecasEsrMhPK(esrWoYear, esrWoOrder, esrWoTask, esrAcreg, esrCucod, esrEsrId);
    }

    public AecasEsrMhPK getAecasEsrMhPK() {
        return aecasEsrMhPK;
    }

    public void setAecasEsrMhPK(AecasEsrMhPK aecasEsrMhPK) {
        this.aecasEsrMhPK = aecasEsrMhPK;
    }

    public BigInteger getEsrPreliminary() {
        return esrPreliminary;
    }

    public void setEsrPreliminary(BigInteger esrPreliminary) {
        this.esrPreliminary = esrPreliminary;
    }

    public BigDecimal getEsrFinal() {
        return esrFinal;
    }

    public void setEsrFinal(BigDecimal esrFinal) {
        this.esrFinal = esrFinal;
    }

    public String getEsrUsuarioCrea() {
        return esrUsuarioCrea;
    }

    public void setEsrUsuarioCrea(String esrUsuarioCrea) {
        this.esrUsuarioCrea = esrUsuarioCrea;
    }

    public Date getEsrFechaCrea() {
        return esrFechaCrea;
    }

    public void setEsrFechaCrea(Date esrFechaCrea) {
        this.esrFechaCrea = esrFechaCrea;
    }

    public String getEsrUsuarioMod() {
        return esrUsuarioMod;
    }

    public void setEsrUsuarioMod(String esrUsuarioMod) {
        this.esrUsuarioMod = esrUsuarioMod;
    }

    public Date getEsrFechaMod() {
        return esrFechaMod;
    }

    public void setEsrFechaMod(Date esrFechaMod) {
        this.esrFechaMod = esrFechaMod;
    }

    public String getEsrUserFinalMod() {
        return esrUserFinalMod;
    }

    public void setEsrUserFinalMod(String esrUserFinalMod) {
        this.esrUserFinalMod = esrUserFinalMod;
    }

    public Date getEsrFechaFinalMod() {
        return esrFechaFinalMod;
    }

    public void setEsrFechaFinalMod(Date esrFechaFinalMod) {
        this.esrFechaFinalMod = esrFechaFinalMod;
    }

    public BigInteger getEsrEngRate() {
        return esrEngRate;
    }

    public void setEsrEngRate(BigInteger esrEngRate) {
        this.esrEngRate = esrEngRate;
    }

    public AecasAdvance getIdAdvance() {
        return idAdvance;
    }

    public void setIdAdvance(AecasAdvance idAdvance) {
        this.idAdvance = idAdvance;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aecasEsrMhPK != null ? aecasEsrMhPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof AecasEsrMh)) {
            return false;
        }
        AecasEsrMh other = (AecasEsrMh) object;
        if ((this.aecasEsrMhPK == null && other.aecasEsrMhPK != null) || (this.aecasEsrMhPK != null && !this.aecasEsrMhPK.equals(other.aecasEsrMhPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.AecasEsrMh[ aecasEsrMhPK=" + aecasEsrMhPK + " ]";
    }
    
}
