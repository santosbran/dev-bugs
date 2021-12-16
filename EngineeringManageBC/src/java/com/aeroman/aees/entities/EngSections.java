/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
 * @author pc
 */
@Entity
@Cacheable(false)
@Table(name = "ENG_SECTIONS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngSections.findAll", query = "SELECT e FROM EngSections e"),
    @NamedQuery(name = "EngSections.findBySecNum", query = "SELECT e FROM EngSections e WHERE e.engSectionsPK.secNum = :secNum"),
    @NamedQuery(name = "EngSections.findBySecDescription", query = "SELECT e FROM EngSections e WHERE e.secDescription = :secDescription"),
    @NamedQuery(name = "EngSections.findBySecApliesEo", query = "SELECT e FROM EngSections e WHERE e.secApliesEo = :secApliesEo"),
    @NamedQuery(name = "EngSections.findByDocId", query = "SELECT e FROM EngSections e WHERE e.engSectionsPK.docId = :docId"),
    @NamedQuery(name = "EngSections.findBySecApplicationType", query = "SELECT e FROM EngSections e WHERE e.secApplicationType = :secApplicationType"),
    @NamedQuery(name = "EngSections.findBySecStatus", query = "SELECT e FROM EngSections e WHERE e.secStatus = :secStatus"),
    @NamedQuery(name = "EngSections.findBySecReferences", query = "SELECT e FROM EngSections e WHERE e.secReferences = :secReferences"),
    @NamedQuery(name = "EngSections.findBySecStatusDate", query = "SELECT e FROM EngSections e WHERE e.secStatusDate = :secStatusDate"),
    @NamedQuery(name = "EngSections.findBySecAdEffectivity", query = "SELECT e FROM EngSections e WHERE e.secAdEffectivity = :secAdEffectivity"),
    @NamedQuery(name = "EngSections.findBySecEffectivityDate", query = "SELECT e FROM EngSections e WHERE e.secEffectivityDate = :secEffectivityDate"),
    @NamedQuery(name = "EngSections.findBySecExecInterval", query = "SELECT e FROM EngSections e WHERE e.secExecInterval = :secExecInterval"),
    @NamedQuery(name = "EngSections.findBySecReason", query = "SELECT e FROM EngSections e WHERE e.secReason = :secReason"),
    @NamedQuery(name = "EngSections.findBySecIdpar", query = "SELECT e FROM EngSections e WHERE e.secIdpar = :secIdpar"),
    @NamedQuery(name = "EngSections.findBySecNumdocPt", query = "SELECT e FROM EngSections e WHERE e.secNumdocPt = :secNumdocPt"),
    @NamedQuery(name = "EngSections.findByAtaNumata", query = "SELECT e FROM EngSections e WHERE e.ataNumata = :ataNumata"),
    @NamedQuery(name = "EngSections.findBySecRevDate", query = "SELECT e FROM EngSections e WHERE e.secRevDate = :secRevDate"),
    @NamedQuery(name = "EngSections.findBySecRevnr", query = "SELECT e FROM EngSections e WHERE e.secRevnr = :secRevnr"),
    @NamedQuery(name = "EngSections.findBySecDelivery", query = "SELECT e FROM EngSections e WHERE e.secDelivery = :secDelivery"),
    @NamedQuery(name = "EngSections.findBySecManufactured", query = "SELECT e FROM EngSections e WHERE e.secManufactured = :secManufactured"),
    @NamedQuery(name = "EngSections.findBySecOwnertech", query = "SELECT e FROM EngSections e WHERE e.secOwnertech = :secOwnertech"),
    @NamedQuery(name = "EngSections.findBySecParent", query = "SELECT e FROM EngSections e WHERE e.secParent = :secParent"),
    @NamedQuery(name = "EngSections.findBySecCorrev", query = "SELECT e FROM EngSections e WHERE e.secCorrev = :secCorrev"),
    @NamedQuery(name = "EngSections.findBySecArea", query = "SELECT e FROM EngSections e WHERE e.secArea = :secArea"),
    @NamedQuery(name = "EngSections.findBySecDhistorica", query = "SELECT e FROM EngSections e WHERE e.secDhistorica = :secDhistorica"),
    @NamedQuery(name = "EngSections.findBySecCompania", query = "SELECT e FROM EngSections e WHERE e.secCompania = :secCompania"),
    @NamedQuery(name = "EngSections.findBySecCountry", query = "SELECT e FROM EngSections e WHERE e.secCountry = :secCountry"),
    @NamedQuery(name = "EngSections.findBySecYear", query = "SELECT e FROM EngSections e WHERE e.secYear = :secYear"),
    @NamedQuery(name = "EngSections.findBySecCorr", query = "SELECT e FROM EngSections e WHERE e.secCorr = :secCorr"),
    @NamedQuery(name = "EngSections.findBySecCorreata", query = "SELECT e FROM EngSections e WHERE e.secCorreata = :secCorreata"),
    @NamedQuery(name = "EngSections.findBySecActivo", query = "SELECT e FROM EngSections e WHERE e.secActivo = :secActivo"),
    @NamedQuery(name = "EngSections.findBySecEffectivityComments", query = "SELECT e FROM EngSections e WHERE e.secEffectivityComments = :secEffectivityComments"),
    @NamedQuery(name = "EngSections.findBySecFormsComments", query = "SELECT e FROM EngSections e WHERE e.secFormsComments = :secFormsComments"),
    @NamedQuery(name = "EngSections.findBySecCotCost", query = "SELECT e FROM EngSections e WHERE e.secCotCost = :secCotCost"),
    @NamedQuery(name = "EngSections.findBySecCia", query = "SELECT e FROM EngSections e WHERE e.secCia = :secCia"),
    @NamedQuery(name = "EngSections.findBySecReceptionDate", query = "SELECT e FROM EngSections e WHERE e.secReceptionDate = :secReceptionDate")})
public class EngSections implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EngSectionsPK engSectionsPK;
    @Size(max = 1000)
    @Column(name = "SEC_DESCRIPTION")
    private String secDescription;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SEC_APLIES_EO")
    private String secApliesEo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "SEC_APPLICATION_TYPE")
    private String secApplicationType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "SEC_STATUS")
    private String secStatus;
    @Size(max = 200)
    @Column(name = "SEC_REFERENCES")
    private String secReferences;
    @Column(name = "SEC_STATUS_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date secStatusDate;
    @Size(max = 600)
    @Column(name = "SEC_AD_EFFECTIVITY")
    private String secAdEffectivity;
    @Column(name = "SEC_EFFECTIVITY_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date secEffectivityDate;
    @Size(max = 200)
    @Column(name = "SEC_EXEC_INTERVAL")
    private String secExecInterval;
    @Size(max = 1000)
    @Column(name = "SEC_REASON")
    private String secReason;
    @Size(max = 8)
    @Column(name = "SEC_IDPAR")
    private String secIdpar;
    @Size(max = 100)
    @Column(name = "SEC_NUMDOC_PT")
    private String secNumdocPt;
    @Column(name = "ATA_NUMATA")
    private Short ataNumata;
    @Column(name = "SEC_REV_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date secRevDate;
    @Size(max = 10)
    @Column(name = "SEC_REVNR")
    private String secRevnr;
    @Column(name = "SEC_DELIVERY")
    @Temporal(TemporalType.TIMESTAMP)
    private Date secDelivery;
    @Size(max = 100)
    @Column(name = "SEC_MANUFACTURED")
    private String secManufactured;
    @Size(max = 60)
    @Column(name = "SEC_OWNERTECH")
    private String secOwnertech;
    @Column(name = "SEC_PARENT")
    private Long secParent;
    @Column(name = "SEC_CORREV")
    private Integer secCorrev;
    @Size(max = 100)
    @Column(name = "SEC_AREA")
    private String secArea;
    @Size(max = 1)
    @Column(name = "SEC_DHISTORICA")
    private String secDhistorica;
    @Size(max = 3)
    @Column(name = "SEC_COMPANIA")
    private String secCompania;
    @Size(max = 3)
    @Column(name = "SEC_COUNTRY")
    private String secCountry;
    @Size(max = 4)
    @Column(name = "SEC_YEAR")
    private String secYear;
    @Size(max = 6)
    @Column(name = "SEC_CORR")
    private String secCorr;
    @Column(name = "SEC_CORREATA")
    private BigInteger secCorreata;
    @Size(max = 1)
    @Column(name = "SEC_ACTIVO")
    private String secActivo;
    @Size(max = 1000)
    @Column(name = "SEC_EFFECTIVITY_COMMENTS")
    private String secEffectivityComments;
    @Size(max = 500)
    @Column(name = "SEC_FORMS_COMMENTS")
    private String secFormsComments;
    @Size(max = 10)
    @Column(name = "SEC_COT_COST")
    private String secCotCost;
    @Size(max = 5)
    @Column(name = "SEC_CIA")
    private String secCia;
    @Column(name = "SEC_RECEPTION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date secReceptionDate;

    public EngSections() {
        super();
    }

    public EngSections(EngSectionsPK engSectionsPK) {
        this.engSectionsPK = engSectionsPK;
    }

    public EngSections(EngSectionsPK engSectionsPK, String secApliesEo, String secApplicationType, String secStatus) {
        this.engSectionsPK = engSectionsPK;
        this.secApliesEo = secApliesEo;
        this.secApplicationType = secApplicationType;
        this.secStatus = secStatus;
    }

    public EngSections(short secNum, String docId) {
        this.engSectionsPK = new EngSectionsPK(secNum, docId);
    }

    public EngSectionsPK getEngSectionsPK() {
        return engSectionsPK;
    }

    public void setEngSectionsPK(EngSectionsPK engSectionsPK) {
        this.engSectionsPK = engSectionsPK;
    }

    public String getSecDescription() {
        return secDescription;
    }

    public void setSecDescription(String secDescription) {
        this.secDescription = secDescription;
    }

    public String getSecApliesEo() {
        return secApliesEo;
    }

    public void setSecApliesEo(String secApliesEo) {
        this.secApliesEo = secApliesEo;
    }

    public String getSecApplicationType() {
        return secApplicationType;
    }

    public void setSecApplicationType(String secApplicationType) {
        this.secApplicationType = secApplicationType;
    }

    public String getSecStatus() {
        return secStatus;
    }

    public void setSecStatus(String secStatus) {
        this.secStatus = secStatus;
    }

    public String getSecReferences() {
        return secReferences;
    }

    public void setSecReferences(String secReferences) {
        this.secReferences = secReferences;
    }

    public Date getSecStatusDate() {
        return secStatusDate;
    }

    public void setSecStatusDate(Date secStatusDate) {
        this.secStatusDate = secStatusDate;
    }

    public String getSecAdEffectivity() {
        return secAdEffectivity;
    }

    public void setSecAdEffectivity(String secAdEffectivity) {
        this.secAdEffectivity = secAdEffectivity;
    }

    public Date getSecEffectivityDate() {
        return secEffectivityDate;
    }

    public void setSecEffectivityDate(Date secEffectivityDate) {
        this.secEffectivityDate = secEffectivityDate;
    }

    public String getSecExecInterval() {
        return secExecInterval;
    }

    public void setSecExecInterval(String secExecInterval) {
        this.secExecInterval = secExecInterval;
    }

    public String getSecReason() {
        return secReason;
    }

    public void setSecReason(String secReason) {
        this.secReason = secReason;
    }

    public String getSecIdpar() {
        return secIdpar;
    }

    public void setSecIdpar(String secIdpar) {
        this.secIdpar = secIdpar;
    }

    public String getSecNumdocPt() {
        return secNumdocPt;
    }

    public void setSecNumdocPt(String secNumdocPt) {
        this.secNumdocPt = secNumdocPt;
    }

    public Short getAtaNumata() {
        return ataNumata;
    }

    public void setAtaNumata(Short ataNumata) {
        this.ataNumata = ataNumata;
    }

    public Date getSecRevDate() {
        return secRevDate;
    }

    public void setSecRevDate(Date secRevDate) {
        this.secRevDate = secRevDate;
    }

    public String getSecRevnr() {
        return secRevnr;
    }

    public void setSecRevnr(String secRevnr) {
        this.secRevnr = secRevnr;
    }

    public Date getSecDelivery() {
        return secDelivery;
    }

    public void setSecDelivery(Date secDelivery) {
        this.secDelivery = secDelivery;
    }

    public String getSecManufactured() {
        return secManufactured;
    }

    public void setSecManufactured(String secManufactured) {
        this.secManufactured = secManufactured;
    }

    public String getSecOwnertech() {
        return secOwnertech;
    }

    public void setSecOwnertech(String secOwnertech) {
        this.secOwnertech = secOwnertech;
    }

    public Long getSecParent() {
        return secParent;
    }

    public void setSecParent(Long secParent) {
        this.secParent = secParent;
    }

    public Integer getSecCorrev() {
        return secCorrev;
    }

    public void setSecCorrev(Integer secCorrev) {
        this.secCorrev = secCorrev;
    }

    public String getSecArea() {
        return secArea;
    }

    public void setSecArea(String secArea) {
        this.secArea = secArea;
    }

    public String getSecDhistorica() {
        return secDhistorica;
    }

    public void setSecDhistorica(String secDhistorica) {
        this.secDhistorica = secDhistorica;
    }

    public String getSecCompania() {
        return secCompania;
    }

    public void setSecCompania(String secCompania) {
        this.secCompania = secCompania;
    }

    public String getSecCountry() {
        return secCountry;
    }

    public void setSecCountry(String secCountry) {
        this.secCountry = secCountry;
    }

    public String getSecYear() {
        return secYear;
    }

    public void setSecYear(String secYear) {
        this.secYear = secYear;
    }

    public String getSecCorr() {
        return secCorr;
    }

    public void setSecCorr(String secCorr) {
        this.secCorr = secCorr;
    }

    public BigInteger getSecCorreata() {
        return secCorreata;
    }

    public void setSecCorreata(BigInteger secCorreata) {
        this.secCorreata = secCorreata;
    }

    public String getSecActivo() {
        return secActivo;
    }

    public void setSecActivo(String secActivo) {
        this.secActivo = secActivo;
    }

    public String getSecEffectivityComments() {
        return secEffectivityComments;
    }

    public void setSecEffectivityComments(String secEffectivityComments) {
        this.secEffectivityComments = secEffectivityComments;
    }

    public String getSecFormsComments() {
        return secFormsComments;
    }

    public void setSecFormsComments(String secFormsComments) {
        this.secFormsComments = secFormsComments;
    }

    public String getSecCotCost() {
        return secCotCost;
    }

    public void setSecCotCost(String secCotCost) {
        this.secCotCost = secCotCost;
    }

    public String getSecCia() {
        return secCia;
    }

    public void setSecCia(String secCia) {
        this.secCia = secCia;
    }

    public Date getSecReceptionDate() {
        return secReceptionDate;
    }

    public void setSecReceptionDate(Date secReceptionDate) {
        this.secReceptionDate = secReceptionDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (engSectionsPK != null ? engSectionsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EngSections)) {
            return false;
        }
        EngSections other = (EngSections) object;
        if ((this.engSectionsPK == null && other.engSectionsPK != null) || (this.engSectionsPK != null && !this.engSectionsPK.equals(other.engSectionsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngSections[ engSectionsPK=" + engSectionsPK + " ]";
    }
    
}
