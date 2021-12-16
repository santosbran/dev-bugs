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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Cacheable(false)
@Table(name = "ENG_ESR_DOCUMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngEsrDocument.findAll", query = "SELECT e FROM EngEsrDocument e"),
    @NamedQuery(name = "EngEsrDocument.findByIdDocu", query = "SELECT e FROM EngEsrDocument e WHERE e.idDocu = :idDocu"),
    @NamedQuery(name = "EngEsrDocument.findByReqMessageid", query = "SELECT e FROM EngEsrDocument e WHERE e.reqMessageid = :reqMessageid"),
    @NamedQuery(name = "EngEsrDocument.findByNameDocu", query = "SELECT e FROM EngEsrDocument e WHERE e.nameDocu = :nameDocu"),
    @NamedQuery(name = "EngEsrDocument.findByExtenDocu", query = "SELECT e FROM EngEsrDocument e WHERE e.extenDocu = :extenDocu")})
public class EngEsrDocument implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ESR_DOCUMENT")
    @SequenceGenerator(name = "SEQ_ESR_DOCUMENT", sequenceName = "SEQ_ESR_DOCUMENT", allocationSize = 1)
    @Basic(optional = false)
    @NotNull    
    @Column(name = "ID_DOCU")
    private Short idDocu;
    @Column(name = "REQ_MESSAGEID")
    private Short reqMessageid;
    @Lob
    @Basic(fetch=FetchType.LAZY,optional=true)
    @Column(name = "BODY_DOCU")
    private byte[] bodyDocu;
    @Size(max = 200)
    @Column(name = "NAME_DOCU")
    private String nameDocu;
    @Size(max = 50)
    @Column(name = "EXTEN_DOCU")
    private String extenDocu;
    @Transient
    private String nombreAcotado;
    @Transient
    private String extension;
   
    public EngEsrDocument() {
        super();
    }

    public EngEsrDocument(Short idDocu) {
        this.idDocu = idDocu;
    }

    public Short getIdDocu() {
        return idDocu;
    }

    public void setIdDocu(Short idDocu) {
        this.idDocu = idDocu;
    }

    public Short getReqMessageid() {
        return reqMessageid;
    }

    public void setReqMessageid(Short reqMessageid) {
        this.reqMessageid = reqMessageid;
    }

    public byte[] getBodyDocu() {
        return bodyDocu;
    }

    public void setBodyDocu(byte[] bodyDocu) {
        this.bodyDocu = bodyDocu;
    }

    public String getNameDocu() {
        return nameDocu;
    }

    public void setNameDocu(String nameDocu) {
        this.nameDocu = nameDocu;
    }

    public String getExtenDocu() {
        return extenDocu;
    }

    public void setExtenDocu(String extenDocu) {
        this.extenDocu = extenDocu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDocu != null ? idDocu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EngEsrDocument)) {
            return false;
        }
        EngEsrDocument other = (EngEsrDocument) object;
        if ((this.idDocu == null && other.idDocu != null) || (this.idDocu != null && !this.idDocu.equals(other.idDocu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngEsrDocument[ idDocu=" + idDocu + " ]";
    }

    public String getNombreAcotado() {
        return nombreAcotado;
    }

    public void setNombreAcotado(String nombreAcotado) {
        this.nombreAcotado = nombreAcotado;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
    
}
