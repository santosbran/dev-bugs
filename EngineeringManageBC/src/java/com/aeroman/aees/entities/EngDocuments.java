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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "ENG_DOCUMENTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngDocuments.findAll", query = "SELECT e FROM EngDocuments e"),
    @NamedQuery(name = "EngDocuments.findByDocId", query = "SELECT e FROM EngDocuments e WHERE e.docId = :docId"),
    @NamedQuery(name = "EngDocuments.findByDocDescription", query = "SELECT e FROM EngDocuments e WHERE e.docDescription = :docDescription"),
    @NamedQuery(name = "EngDocuments.findByDocCreationDate", query = "SELECT e FROM EngDocuments e WHERE e.docCreationDate = :docCreationDate"),
    @NamedQuery(name = "EngDocuments.findByDocDocket", query = "SELECT e FROM EngDocuments e WHERE e.docDocket = :docDocket"),
    @NamedQuery(name = "EngDocuments.findByDotCod", query = "SELECT e FROM EngDocuments e WHERE e.dotCod = :dotCod"),
    @NamedQuery(name = "EngDocuments.findByDocAmendment", query = "SELECT e FROM EngDocuments e WHERE e.docAmendment = :docAmendment"),
    @NamedQuery(name = "EngDocuments.findByDocKey", query = "SELECT e FROM EngDocuments e WHERE e.docKey = :docKey"),
    @NamedQuery(name = "EngDocuments.findByDocUserIns", query = "SELECT e FROM EngDocuments e WHERE e.docUserIns = :docUserIns"),
    @NamedQuery(name = "EngDocuments.findByDocNumdoc", query = "SELECT e FROM EngDocuments e WHERE e.docNumdoc = :docNumdoc"),
    @NamedQuery(name = "EngDocuments.findByDocDateEffectivity", query = "SELECT e FROM EngDocuments e WHERE e.docDateEffectivity = :docDateEffectivity"),
    @NamedQuery(name = "EngDocuments.findByDocAdEffectivity", query = "SELECT e FROM EngDocuments e WHERE e.docAdEffectivity = :docAdEffectivity"),
    @NamedQuery(name = "EngDocuments.findByDocCnNumber", query = "SELECT e FROM EngDocuments e WHERE e.docCnNumber = :docCnNumber"),
    @NamedQuery(name = "EngDocuments.findByDocName", query = "SELECT e FROM EngDocuments e WHERE e.docName = :docName"),
    @NamedQuery(name = "EngDocuments.findByDocNumata", query = "SELECT e FROM EngDocuments e WHERE e.docNumata = :docNumata"),
    @NamedQuery(name = "EngDocuments.findByDocManufacturer", query = "SELECT e FROM EngDocuments e WHERE e.docManufacturer = :docManufacturer"),
    @NamedQuery(name = "EngDocuments.findByDocBiweekly", query = "SELECT e FROM EngDocuments e WHERE e.docBiweekly = :docBiweekly"),
    @NamedQuery(name = "EngDocuments.findByDocSuperseded", query = "SELECT e FROM EngDocuments e WHERE e.docSuperseded = :docSuperseded"),
    @NamedQuery(name = "EngDocuments.findByDocStatus", query = "SELECT e FROM EngDocuments e WHERE e.docStatus = :docStatus"),
    @NamedQuery(name = "EngDocuments.findByDocAdNumber", query = "SELECT e FROM EngDocuments e WHERE e.docAdNumber = :docAdNumber"),
    @NamedQuery(name = "EngDocuments.findByDocAnNumber", query = "SELECT e FROM EngDocuments e WHERE e.docAnNumber = :docAnNumber"),
    @NamedQuery(name = "EngDocuments.findByDocLbaNumber", query = "SELECT e FROM EngDocuments e WHERE e.docLbaNumber = :docLbaNumber")})
public class EngDocuments implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "DOC_ID")
    private String docId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3000)
    @Column(name = "DOC_DESCRIPTION")
    private String docDescription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DOC_CREATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date docCreationDate;
    @Size(max = 12)
    @Column(name = "DOC_DOCKET")
    private String docDocket;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "DOT_COD")
    private String dotCod;
    @Size(max = 8)
    @Column(name = "DOC_AMENDMENT")
    private String docAmendment;
    @Size(max = 3)
    @Column(name = "DOC_KEY")
    private String docKey;
    @Size(max = 32)
    @Column(name = "DOC_USER_INS")
    private String docUserIns;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "DOC_NUMDOC")
    private String docNumdoc;
    @Column(name = "DOC_DATE_EFFECTIVITY")
    @Temporal(TemporalType.TIMESTAMP)
    private Date docDateEffectivity;
    @Size(max = 3000)
    @Column(name = "DOC_AD_EFFECTIVITY")
    private String docAdEffectivity;
    @Size(max = 20)
    @Column(name = "DOC_CN_NUMBER")
    private String docCnNumber;
    @Size(max = 300)
    @Column(name = "DOC_NAME")
    private String docName;
    @Column(name = "DOC_NUMATA")
    private Short docNumata;
    @Size(max = 150)
    @Column(name = "DOC_MANUFACTURER")
    private String docManufacturer;
    @Column(name = "DOC_BIWEEKLY")
    private BigInteger docBiweekly;
    @Size(max = 20)
    @Column(name = "DOC_SUPERSEDED")
    private String docSuperseded;
    @Size(max = 20)
    @Column(name = "DOC_STATUS")
    private String docStatus;
    @Lob
    @Column(name = "DOC_FLEET")
    private Serializable docFleet;
    @Size(max = 20)
    @Column(name = "DOC_AD_NUMBER")
    private String docAdNumber;
    @Size(max = 20)
    @Column(name = "DOC_AN_NUMBER")
    private String docAnNumber;
    @Size(max = 20)
    @Column(name = "DOC_LBA_NUMBER")
    private String docLbaNumber;

    public EngDocuments() {
        super();
    }

    public EngDocuments(String docId) {
        this.docId = docId;
    }

    public EngDocuments(String docId, String docDescription, Date docCreationDate, String dotCod, String docNumdoc) {
        this.docId = docId;
        this.docDescription = docDescription;
        this.docCreationDate = docCreationDate;
        this.dotCod = dotCod;
        this.docNumdoc = docNumdoc;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public String getDocDescription() {
        return docDescription;
    }

    public void setDocDescription(String docDescription) {
        this.docDescription = docDescription;
    }

    public Date getDocCreationDate() {
        return docCreationDate;
    }

    public void setDocCreationDate(Date docCreationDate) {
        this.docCreationDate = docCreationDate;
    }

    public String getDocDocket() {
        return docDocket;
    }

    public void setDocDocket(String docDocket) {
        this.docDocket = docDocket;
    }

    public String getDotCod() {
        return dotCod;
    }

    public void setDotCod(String dotCod) {
        this.dotCod = dotCod;
    }

    public String getDocAmendment() {
        return docAmendment;
    }

    public void setDocAmendment(String docAmendment) {
        this.docAmendment = docAmendment;
    }

    public String getDocKey() {
        return docKey;
    }

    public void setDocKey(String docKey) {
        this.docKey = docKey;
    }

    public String getDocUserIns() {
        return docUserIns;
    }

    public void setDocUserIns(String docUserIns) {
        this.docUserIns = docUserIns;
    }

    public String getDocNumdoc() {
        return docNumdoc;
    }

    public void setDocNumdoc(String docNumdoc) {
        this.docNumdoc = docNumdoc;
    }

    public Date getDocDateEffectivity() {
        return docDateEffectivity;
    }

    public void setDocDateEffectivity(Date docDateEffectivity) {
        this.docDateEffectivity = docDateEffectivity;
    }

    public String getDocAdEffectivity() {
        return docAdEffectivity;
    }

    public void setDocAdEffectivity(String docAdEffectivity) {
        this.docAdEffectivity = docAdEffectivity;
    }

    public String getDocCnNumber() {
        return docCnNumber;
    }

    public void setDocCnNumber(String docCnNumber) {
        this.docCnNumber = docCnNumber;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public Short getDocNumata() {
        return docNumata;
    }

    public void setDocNumata(Short docNumata) {
        this.docNumata = docNumata;
    }

    public String getDocManufacturer() {
        return docManufacturer;
    }

    public void setDocManufacturer(String docManufacturer) {
        this.docManufacturer = docManufacturer;
    }

    public BigInteger getDocBiweekly() {
        return docBiweekly;
    }

    public void setDocBiweekly(BigInteger docBiweekly) {
        this.docBiweekly = docBiweekly;
    }

    public String getDocSuperseded() {
        return docSuperseded;
    }

    public void setDocSuperseded(String docSuperseded) {
        this.docSuperseded = docSuperseded;
    }

    public String getDocStatus() {
        return docStatus;
    }

    public void setDocStatus(String docStatus) {
        this.docStatus = docStatus;
    }

    public Serializable getDocFleet() {
        return docFleet;
    }

    public void setDocFleet(Serializable docFleet) {
        this.docFleet = docFleet;
    }

    public String getDocAdNumber() {
        return docAdNumber;
    }

    public void setDocAdNumber(String docAdNumber) {
        this.docAdNumber = docAdNumber;
    }

    public String getDocAnNumber() {
        return docAnNumber;
    }

    public void setDocAnNumber(String docAnNumber) {
        this.docAnNumber = docAnNumber;
    }

    public String getDocLbaNumber() {
        return docLbaNumber;
    }

    public void setDocLbaNumber(String docLbaNumber) {
        this.docLbaNumber = docLbaNumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (docId != null ? docId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EngDocuments)) {
            return false;
        }
        EngDocuments other = (EngDocuments) object;
        if ((this.docId == null && other.docId != null) || (this.docId != null && !this.docId.equals(other.docId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngDocuments[ docId=" + docId + " ]";
    }
    
}
