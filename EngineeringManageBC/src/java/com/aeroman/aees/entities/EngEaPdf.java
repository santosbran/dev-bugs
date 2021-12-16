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
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
 * @author pc
 */
@Entity
@Cacheable(false)
@Table(name = "ENG_EA_PDF")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngEaPdf.findAll", query = "SELECT e FROM EngEaPdf e"),
    @NamedQuery(name = "EngEaPdf.findByPdfId", query = "SELECT e FROM EngEaPdf e WHERE e.pdfId = :pdfId"),
    @NamedQuery(name = "EngEaPdf.findByEagId", query = "SELECT e FROM EngEaPdf e WHERE e.eagId = :eagId"),
    @NamedQuery(name = "EngEaPdf.findByPdfFilename", query = "SELECT e FROM EngEaPdf e WHERE e.pdfFilename = :pdfFilename"),
    @NamedQuery(name = "EngEaPdf.findByPdfType", query = "SELECT e FROM EngEaPdf e WHERE e.pdfType = :pdfType"),
    @NamedQuery(name = "EngEaPdf.findByPdfEstatus", query = "SELECT e FROM EngEaPdf e WHERE e.pdfEstatus = :pdfEstatus"),
    @NamedQuery(name = "EngEaPdf.findByPdfDateChr", query = "SELECT e FROM EngEaPdf e WHERE e.pdfDateChr = :pdfDateChr"),
    @NamedQuery(name = "EngEaPdf.findByPdfUsrChr", query = "SELECT e FROM EngEaPdf e WHERE e.pdfUsrChr = :pdfUsrChr"),
    @NamedQuery(name = "EngEaPdf.findByPdfDateSend", query = "SELECT e FROM EngEaPdf e WHERE e.pdfDateSend = :pdfDateSend"),
    @NamedQuery(name = "EngEaPdf.findByPdfUsrSend", query = "SELECT e FROM EngEaPdf e WHERE e.pdfUsrSend = :pdfUsrSend"),
    @NamedQuery(name = "EngEaPdf.findByPdfComent", query = "SELECT e FROM EngEaPdf e WHERE e.pdfComent = :pdfComent"),
    @NamedQuery(name = "EngEaPdf.findByPdfEstatusEnviado", query = "SELECT e FROM EngEaPdf e WHERE e.pdfEstatusEnviado = :pdfEstatusEnviado")})
public class EngEaPdf implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENG_EA_PDF_SEQ")
    @SequenceGenerator(name = "ENG_EA_PDF_SEQ", sequenceName = "ENG_EA_PDF_SEQ", allocationSize = 1)
    @NotNull
    @Column(name = "PDF_ID")
    private BigDecimal pdfId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EAG_ID")
    private BigInteger eagId;
    @Size(max = 4000)
    @Column(name = "PDF_FILENAME")
    private String pdfFilename;
    @Column(name = "PDF_TYPE")
    private Short pdfType;
    @Lob
    @Basic(fetch=FetchType.LAZY,optional=true)
    @Column(name = "PDF_FILE")
    private byte[] pdfFile;
    @Size(max = 3)
    @Column(name = "PDF_ESTATUS")
    private String pdfEstatus;
    @Column(name = "PDF_DATE_CHR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pdfDateChr;
    @Size(max = 30)
    @Column(name = "PDF_USR_CHR")
    private String pdfUsrChr;
    @Column(name = "PDF_DATE_SEND")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pdfDateSend;
    @Size(max = 30)
    @Column(name = "PDF_USR_SEND")
    private String pdfUsrSend;
    @Size(max = 2000)
    @Column(name = "PDF_COMENT")
    private String pdfComent;
    @Size(max = 20)
    @Column(name = "PDF_ESTATUS_ENVIADO")
    private String pdfEstatusEnviado;

    public EngEaPdf() {
        super();
    }

    public EngEaPdf(BigDecimal pdfId) {
        this.pdfId = pdfId;
    }

    public EngEaPdf(BigDecimal pdfId, BigInteger eagId) {
        this.pdfId = pdfId;
        this.eagId = eagId;
    }

    public BigDecimal getPdfId() {
        return pdfId;
    }

    public void setPdfId(BigDecimal pdfId) {
        this.pdfId = pdfId;
    }

    public BigInteger getEagId() {
        return eagId;
    }

    public void setEagId(BigInteger eagId) {
        this.eagId = eagId;
    }

    public String getPdfFilename() {
        return pdfFilename;
    }

    public void setPdfFilename(String pdfFilename) {
        this.pdfFilename = pdfFilename;
    }

    public Short getPdfType() {
        return pdfType;
    }

    public void setPdfType(Short pdfType) {
        this.pdfType = pdfType;
    }

    public byte[] getPdfFile() {
        return pdfFile;
    }

    public void setPdfFile(byte[] pdfFile) {
        this.pdfFile = pdfFile;
    }

    public String getPdfEstatus() {
        return pdfEstatus;
    }

    public void setPdfEstatus(String pdfEstatus) {
        this.pdfEstatus = pdfEstatus;
    }

    public Date getPdfDateChr() {
        return pdfDateChr;
    }

    public void setPdfDateChr(Date pdfDateChr) {
        this.pdfDateChr = pdfDateChr;
    }

    public String getPdfUsrChr() {
        return pdfUsrChr;
    }

    public void setPdfUsrChr(String pdfUsrChr) {
        this.pdfUsrChr = pdfUsrChr;
    }

    public Date getPdfDateSend() {
        return pdfDateSend;
    }

    public void setPdfDateSend(Date pdfDateSend) {
        this.pdfDateSend = pdfDateSend;
    }

    public String getPdfUsrSend() {
        return pdfUsrSend;
    }

    public void setPdfUsrSend(String pdfUsrSend) {
        this.pdfUsrSend = pdfUsrSend;
    }

    public String getPdfComent() {
        return pdfComent;
    }

    public void setPdfComent(String pdfComent) {
        this.pdfComent = pdfComent;
    }

    public String getPdfEstatusEnviado() {
        return pdfEstatusEnviado;
    }

    public void setPdfEstatusEnviado(String pdfEstatusEnviado) {
        this.pdfEstatusEnviado = pdfEstatusEnviado;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pdfId != null ? pdfId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EngEaPdf)) {
            return false;
        }
        EngEaPdf other = (EngEaPdf) object;
        if ((this.pdfId == null && other.pdfId != null) || (this.pdfId != null && !this.pdfId.equals(other.pdfId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngEaPdf[ pdfId=" + pdfId + " ]";
    }
    
}
