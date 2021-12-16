/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author saplic
 */
@Entity
@Cacheable(false)
@Table(name = "MSJ_ADJUNTOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MsjAdjuntos.findAll", query = "SELECT m FROM MsjAdjuntos m"),
    @NamedQuery(name = "MsjAdjuntos.findByMsgCodigo", query = "SELECT m FROM MsjAdjuntos m WHERE m.msgCodigo = :msgCodigo"),
    @NamedQuery(name = "MsjAdjuntos.findByMsgCodResponse", query = "SELECT m FROM MsjAdjuntos m WHERE m.msgCodResponse = :msgCodResponse"),
    @NamedQuery(name = "MsjAdjuntos.findByMsgExtension", query = "SELECT m FROM MsjAdjuntos m WHERE m.msgExtension = :msgExtension"),
    @NamedQuery(name = "MsjAdjuntos.findByMsgCodEsr", query = "SELECT m FROM MsjAdjuntos m WHERE m.msgCodEsr = :msgCodEsr"),
    @NamedQuery(name = "MsjAdjuntos.findByMsgNombreArchivo", query = "SELECT m FROM MsjAdjuntos m WHERE m.msgNombreArchivo = :msgNombreArchivo")})
public class MsjAdjuntos implements Serializable {
    @JoinColumn(name = "MSG_COD_RESPONSE", referencedColumnName = "RES_ID")
    @ManyToOne
    private EngReqResponses msgCodResponse;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ADJUNTOS")
    @SequenceGenerator(name = "SEQ_ADJUNTOS", sequenceName = "SEQ_ADJUNTOS", allocationSize = 1)
    @Column(name = "MSG_CODIGO")
    private BigDecimal msgCodigo;    
    
    @Lob
    @Basic(fetch=FetchType.LAZY,optional=true)
    @Column(name = "MSG_ADJUNTO")
    private byte[] msgAdjunto;
    @Size(max = 30)
    @Column(name = "MSG_EXTENSION")
    private String msgExtension;
    @Column(name = "MSG_COD_ESR")
    private BigInteger msgCodEsr;
    @Size(max = 400)
    @Column(name = "MSG_NOMBRE_ARCHIVO")
    private String msgNombreArchivo;
    @Transient
    private String extension;
    @Transient
    private String nombreAcotado;

    public MsjAdjuntos() {
        super();
    }

    public MsjAdjuntos(BigDecimal msgCodigo) {
        this.msgCodigo = msgCodigo;
    }

    public BigDecimal getMsgCodigo() {
        return msgCodigo;
    }

    public void setMsgCodigo(BigDecimal msgCodigo) {
        this.msgCodigo = msgCodigo;
    }

    public byte[] getMsgAdjunto() {
        return msgAdjunto;
    }

    public void setMsgAdjunto(byte[] msgAdjunto) {
        this.msgAdjunto = msgAdjunto;
    }

    public String getMsgExtension() {
        return msgExtension;
    }

    public void setMsgExtension(String msgExtension) {
        this.msgExtension = msgExtension;
    }

    public BigInteger getMsgCodEsr() {
        return msgCodEsr;
    }

    public void setMsgCodEsr(BigInteger msgCodEsr) {
        this.msgCodEsr = msgCodEsr;
    }

    public String getMsgNombreArchivo() {
        return msgNombreArchivo;
    }

    public void setMsgNombreArchivo(String msgNombreArchivo) {
        this.msgNombreArchivo = msgNombreArchivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (msgCodigo != null ? msgCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof MsjAdjuntos)) {
            return false;
        }
        MsjAdjuntos other = (MsjAdjuntos) object;
        if ((this.msgCodigo == null && other.msgCodigo != null) || (this.msgCodigo != null && !this.msgCodigo.equals(other.msgCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.MsjAdjuntos[ msgCodigo=" + msgCodigo + " ]";
    }   

    public EngReqResponses getMsgCodResponse() {
        return msgCodResponse;
    }

    public void setMsgCodResponse(EngReqResponses msgCodResponse) {
        this.msgCodResponse = msgCodResponse;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    } 

    public String getNombreAcotado() {
        return nombreAcotado;
    }

    public void setNombreAcotado(String nombreAcotado) {
        this.nombreAcotado = nombreAcotado;
    }
    
    
}
