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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author firaheta
 */
@Entity
@Cacheable(false)
@Table(name = "ENG_UPLOAD_PLANTILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngUploadPlantilla.findAll", query = "SELECT e FROM EngUploadPlantilla e"),
    @NamedQuery(name = "EngUploadPlantilla.findByIdDocument", query = "SELECT e FROM EngUploadPlantilla e WHERE e.idDocument = :idDocument"),
    @NamedQuery(name = "EngUploadPlantilla.findByNameDocument", query = "SELECT e FROM EngUploadPlantilla e WHERE e.nameDocument = :nameDocument"),
    @NamedQuery(name = "EngUploadPlantilla.findByExtenDocument", query = "SELECT e FROM EngUploadPlantilla e WHERE e.extenDocument = :extenDocument")})
public class EngUploadPlantilla implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENG_UPLOAD_PLANTILLA_SEQ")
    @SequenceGenerator(name = "ENG_UPLOAD_PLANTILLA_SEQ", sequenceName = "ENG_UPLOAD_PLANTILLA_SEQ", allocationSize = 1)
    @Column(name = "ID_DOCUMENT")
    private Long idDocument;
   @Lob
    @Basic(fetch=FetchType.LAZY,optional=true)
    @Column(name = "BODY_DOCUMENT")
    private byte[] bodyDocument;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "NAME_DOCUMENT")
    private String nameDocument;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "EXTEN_DOCUMENT")
    private String extenDocument;

    public EngUploadPlantilla() {
        super();
    }

    public EngUploadPlantilla(Long idDocument) {
        this.idDocument = idDocument;
    }

    public EngUploadPlantilla(Long idDocument, byte[]  bodyDocument, String nameDocument, String extenDocument) {
        this.idDocument = idDocument;
        this.bodyDocument = bodyDocument;
        this.nameDocument = nameDocument;
        this.extenDocument = extenDocument;
    }

    public Long getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(Long idDocument) {
        this.idDocument = idDocument;
    }

    public byte[] getBodyDocument() {
        return bodyDocument;
    }

    public void setBodyDocument(byte[] bodyDocument) {
        this.bodyDocument = bodyDocument;
    }

    public String getNameDocument() {
        return nameDocument;
    }

    public void setNameDocument(String nameDocument) {
        this.nameDocument = nameDocument;
    }

    public String getExtenDocument() {
        return extenDocument;
    }

    public void setExtenDocument(String extenDocument) {
        this.extenDocument = extenDocument;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDocument != null ? idDocument.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EngUploadPlantilla)) {
            return false;
        }
        EngUploadPlantilla other = (EngUploadPlantilla) object;
        if ((this.idDocument == null && other.idDocument != null) || (this.idDocument != null && !this.idDocument.equals(other.idDocument))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngUploadPlantilla[ idDocument=" + idDocument + " ]";
    }
    
}
