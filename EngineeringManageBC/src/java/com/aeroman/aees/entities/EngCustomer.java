/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
 * @author Usuario
 */
@Entity
@Cacheable(false)
@Table(name = "ENG_CUSTOMER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngCustomer.findAll", query = "SELECT e FROM EngCustomer e"),
    @NamedQuery(name = "EngCustomer.findByEngId", query = "SELECT e FROM EngCustomer e WHERE e.engId = :engId"),
    @NamedQuery(name = "EngCustomer.findByEngName", query = "SELECT e FROM EngCustomer e WHERE e.engName = :engName"),
    @NamedQuery(name = "EngCustomer.findByEngUpdate", query = "SELECT e FROM EngCustomer e WHERE e.engUpdate = :engUpdate"),
    @NamedQuery(name = "EngCustomer.findByEngUserIns", query = "SELECT e FROM EngCustomer e WHERE e.engUserIns = :engUserIns"),
    @NamedQuery(name = "EngCustomer.findByEngDateIns", query = "SELECT e FROM EngCustomer e WHERE e.engDateIns = :engDateIns"),
    @NamedQuery(name = "EngCustomer.findByEngUserMod", query = "SELECT e FROM EngCustomer e WHERE e.engUserMod = :engUserMod"),
    @NamedQuery(name = "EngCustomer.findByEngDateMod", query = "SELECT e FROM EngCustomer e WHERE e.engDateMod = :engDateMod"),
    @NamedQuery(name = "EngCustomer.findByEngCodigoIata", query = "SELECT e FROM EngCustomer e WHERE e.engCodigoIata = :engCodigoIata"),
    @NamedQuery(name = "EngCustomer.findByEngRojo", query = "SELECT e FROM EngCustomer e WHERE e.engRojo = :engRojo"),
    @NamedQuery(name = "EngCustomer.findByEngVerde", query = "SELECT e FROM EngCustomer e WHERE e.engVerde = :engVerde"),
    @NamedQuery(name = "EngCustomer.findByEngAzul", query = "SELECT e FROM EngCustomer e WHERE e.engAzul = :engAzul"),
    @NamedQuery(name = "EngCustomer.findByFltCod", query = "SELECT e FROM EngCustomer e WHERE e.fltCod = :fltCod"),
    @NamedQuery(name = "EngCustomer.findByEngCompany", query = "SELECT e FROM EngCustomer e WHERE e.engCompany = :engCompany")})
public class EngCustomer implements Serializable {

    @OneToMany(mappedBy = "engId")
    private Collection<EngMergeCustomer> engMergeCustomerCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "ENG_ID")
    private String engId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ENG_NAME")
    private String engName;
    @Size(max = 1)
    @Column(name = "ENG_UPDATE")
    private String engUpdate;
    @Size(max = 10)
    @Column(name = "ENG_USER_INS")
    private String engUserIns;
    @Column(name = "ENG_DATE_INS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date engDateIns;
    @Size(max = 10)
    @Column(name = "ENG_USER_MOD")
    private String engUserMod;
    @Size(max = 10)
    @Column(name = "ENG_DATE_MOD")
    private String engDateMod;
    @Size(max = 10)
    @Column(name = "ENG_CODIGO_IATA")
    private String engCodigoIata;
    @Size(max = 3)
    @Column(name = "ENG_ROJO")
    private String engRojo;
    @Size(max = 3)
    @Column(name = "ENG_VERDE")
    private String engVerde;
    @Size(max = 3)
    @Column(name = "ENG_AZUL")
    private String engAzul;
    @Size(max = 20)
    @Column(name = "FLT_COD")
    private String fltCod;
    @Size(max = 5)
    @Column(name = "ENG_COMPANY")
    private String engCompany;

    public EngCustomer() {
        super();
    }

    public EngCustomer(String engId) {
        this.engId = engId;
    }

    public EngCustomer(String engId, String engName) {
        this.engId = engId;
        this.engName = engName;
    }

    public String getEngId() {
        return engId;
    }

    public void setEngId(String engId) {
        this.engId = engId;
    }

    public String getEngName() {
        return engName;
    }

    public void setEngName(String engName) {
        this.engName = engName;
    }

    public String getEngUpdate() {
        return engUpdate;
    }

    public void setEngUpdate(String engUpdate) {
        this.engUpdate = engUpdate;
    }

    public String getEngUserIns() {
        return engUserIns;
    }

    public void setEngUserIns(String engUserIns) {
        this.engUserIns = engUserIns;
    }

    public Date getEngDateIns() {
        return engDateIns;
    }

    public void setEngDateIns(Date engDateIns) {
        this.engDateIns = engDateIns;
    }

    public String getEngUserMod() {
        return engUserMod;
    }

    public void setEngUserMod(String engUserMod) {
        this.engUserMod = engUserMod;
    }

    public String getEngDateMod() {
        return engDateMod;
    }

    public void setEngDateMod(String engDateMod) {
        this.engDateMod = engDateMod;
    }

    public String getEngCodigoIata() {
        return engCodigoIata;
    }

    public void setEngCodigoIata(String engCodigoIata) {
        this.engCodigoIata = engCodigoIata;
    }

    public String getEngRojo() {
        return engRojo;
    }

    public void setEngRojo(String engRojo) {
        this.engRojo = engRojo;
    }

    public String getEngVerde() {
        return engVerde;
    }

    public void setEngVerde(String engVerde) {
        this.engVerde = engVerde;
    }

    public String getEngAzul() {
        return engAzul;
    }

    public void setEngAzul(String engAzul) {
        this.engAzul = engAzul;
    }

    public String getFltCod() {
        return fltCod;
    }

    public void setFltCod(String fltCod) {
        this.fltCod = fltCod;
    }

    public String getEngCompany() {
        return engCompany;
    }

    public void setEngCompany(String engCompany) {
        this.engCompany = engCompany;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (engId != null ? engId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EngCustomer)) {
            return false;
        }
        EngCustomer other = (EngCustomer) object;
        if ((this.engId == null && other.engId != null) || (this.engId != null && !this.engId.equals(other.engId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngCustomer[ engId=" + engId + " ]";
    }
    
    @XmlTransient
    public Collection<EngMergeCustomer> getEngMergeCustomerCollection() {
        return engMergeCustomerCollection;
}

    public void setEngMergeCustomerCollection(Collection<EngMergeCustomer> engMergeCustomerCollection) {
        this.engMergeCustomerCollection = engMergeCustomerCollection;
    }
    
}
