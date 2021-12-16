/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Cacheable(false)
@Table(name = "ENG_HORAS_ING_VW")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngHorasIngVw.findAll", query = "SELECT e FROM EngHorasIngVw e"),
    @NamedQuery(name = "EngHorasIngVw.findByNesr", query = "SELECT e FROM EngHorasIngVw e WHERE e.nesr = :nesr"),
    @NamedQuery(name = "EngHorasIngVw.findByYear", query = "SELECT e FROM EngHorasIngVw e WHERE e.year = :year"),
    @NamedQuery(name = "EngHorasIngVw.findByMessageid", query = "SELECT e FROM EngHorasIngVw e WHERE e.messageid = :messageid"),
    @NamedQuery(name = "EngHorasIngVw.findBySubject", query = "SELECT e FROM EngHorasIngVw e WHERE e.subject = :subject"),
    @NamedQuery(name = "EngHorasIngVw.findByFacturar", query = "SELECT e FROM EngHorasIngVw e WHERE e.facturar = :facturar"),
    @NamedQuery(name = "EngHorasIngVw.findBySeleccion", query = "SELECT e FROM EngHorasIngVw e WHERE e.seleccion = :seleccion"),
    @NamedQuery(name = "EngHorasIngVw.findByExportado", query = "SELECT e FROM EngHorasIngVw e WHERE e.exportado = :exportado"),
    @NamedQuery(name = "EngHorasIngVw.findByOpened", query = "SELECT e FROM EngHorasIngVw e WHERE e.opened = :opened"),
    @NamedQuery(name = "EngHorasIngVw.findByClosed", query = "SELECT e FROM EngHorasIngVw e WHERE e.closed = :closed"),
    @NamedQuery(name = "EngHorasIngVw.findByComboindex", query = "SELECT e FROM EngHorasIngVw e WHERE e.comboindex = :comboindex"),
    @NamedQuery(name = "EngHorasIngVw.findBySumhours", query = "SELECT e FROM EngHorasIngVw e WHERE e.sumhours = :sumhours"),
    @NamedQuery(name = "EngHorasIngVw.findByHinId", query = "SELECT e FROM EngHorasIngVw e WHERE e.hinId = :hinId")})
public class EngHorasIngVw implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Size(max = 54)
    @Column(name = "NESR")
    private String nesr;
    @Column(name = "YEAR")
    private BigInteger year;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MESSAGEID")
    private BigInteger messageid;
    @Size(max = 4000)
    @Column(name = "SUBJECT")
    private String subject;
    @Size(max = 40)
    @Column(name = "FACTURAR")
    private String facturar;
    @Size(max = 1)
    @Column(name = "SELECCION")
    private String seleccion;
    @Size(max = 3)
    @Column(name = "EXPORTADO")
    private String exportado;
    @Size(max = 20)
    @Column(name = "OPENED")
    private String opened;
    @Size(max = 20)
    @Column(name = "CLOSED")
    private String closed;
    @Column(name = "COMBOINDEX")
    private BigInteger comboindex;
    @Column(name = "SUMHOURS")
    private BigInteger sumhours;
    @Column(name = "HIN_ID")
    private BigInteger hinId;

    public EngHorasIngVw() {
        super();
    }

    public String getNesr() {
        return nesr;
    }

    public void setNesr(String nesr) {
        this.nesr = nesr;
    }

    public BigInteger getYear() {
        return year;
    }

    public void setYear(BigInteger year) {
        this.year = year;
    }

    public BigInteger getMessageid() {
        return messageid;
    }

    public void setMessageid(BigInteger messageid) {
        this.messageid = messageid;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getFacturar() {
        return facturar;
    }

    public void setFacturar(String facturar) {
        this.facturar = facturar;
    }

    public String getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(String seleccion) {
        this.seleccion = seleccion;
    }

    public String getExportado() {
        return exportado;
    }

    public void setExportado(String exportado) {
        this.exportado = exportado;
    }

    public String getOpened() {
        return opened;
    }

    public void setOpened(String opened) {
        this.opened = opened;
    }

    public String getClosed() {
        return closed;
    }

    public void setClosed(String closed) {
        this.closed = closed;
    }

    public BigInteger getComboindex() {
        return comboindex;
    }

    public void setComboindex(BigInteger comboindex) {
        this.comboindex = comboindex;
    }

    public BigInteger getSumhours() {
        return sumhours;
    }

    public void setSumhours(BigInteger sumhours) {
        this.sumhours = sumhours;
    }

    public BigInteger getHinId() {
        return hinId;
    }

    public void setHinId(BigInteger hinId) {
        this.hinId = hinId;
    }
    
}
