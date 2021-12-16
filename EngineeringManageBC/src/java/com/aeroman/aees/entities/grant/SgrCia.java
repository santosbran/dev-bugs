/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities.grant;

import com.aeroman.aees.entities.EngMergeCustomer;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author saplic
 */
@Entity
@Cacheable(false)
@Table(name = "SGR_CIA", catalog = "", schema = "PROCESOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SgrCia.findAll", query = "SELECT s FROM SgrCia s"),
    @NamedQuery(name = "SgrCia.findByCiaCode", query = "SELECT s FROM SgrCia s WHERE s.ciaCode = :ciaCode"),
    @NamedQuery(name = "SgrCia.findByCiaName", query = "SELECT s FROM SgrCia s WHERE s.ciaName = :ciaName"),
    @NamedQuery(name = "SgrCia.findByCiaSegment1", query = "SELECT s FROM SgrCia s WHERE s.ciaSegment1 = :ciaSegment1"),
    @NamedQuery(name = "SgrCia.findByCiaCurrencyDefault", query = "SELECT s FROM SgrCia s WHERE s.ciaCurrencyDefault = :ciaCurrencyDefault"),
    @NamedQuery(name = "SgrCia.findByCiaLogo", query = "SELECT s FROM SgrCia s WHERE s.ciaLogo = :ciaLogo"),
    @NamedQuery(name = "SgrCia.findByCiaType", query = "SELECT s FROM SgrCia s WHERE s.ciaType = :ciaType"),
    @NamedQuery(name = "SgrCia.findByCiaLogoBlob", query = "SELECT s FROM SgrCia s WHERE s.ciaLogoBlob = :ciaLogoBlob"),
    @NamedQuery(name = "SgrCia.findByCiaLogoExt", query = "SELECT s FROM SgrCia s WHERE s.ciaLogoExt = :ciaLogoExt"),
    @NamedQuery(name = "SgrCia.findByciaAcceso", query = "SELECT s FROM SgrCia s WHERE s.ciaAcceso = :ciaAcceso")})

public class SgrCia implements Serializable {
    @OneToMany(mappedBy = "ciaCode")
    private Collection<EngMergeCustomer> engMergeCustomerCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "CIA_CODE")
    private String ciaCode;
    @Size(max = 500)
    @Column(name = "CIA_NAME")
    private String ciaName;
    @Size(max = 20)
    @Column(name = "CIA_SEGMENT1")
    private String ciaSegment1;
    @Size(max = 15)
    @Column(name = "CIA_CURRENCY_DEFAULT")
    private String ciaCurrencyDefault;
    @Size(max = 1000)
    @Column(name = "CIA_LOGO")
    private String ciaLogo;
    @Size(max = 1)
    @Column(name = "CIA_TYPE")
    private String ciaType;
    @Lob
    @Basic(fetch=FetchType.LAZY,optional=true)
    @Column(name = "CIA_LOGO_BLOB")
    private byte[] ciaLogoBlob;
    @Size(max = 10)
    @Column(name = "CIA_LOGO_EXT")
    private String ciaLogoExt;
    @Column (name = "CIA_ACCESO")
    private BigDecimal ciaAcceso;
    @Transient
    private String logoBase64;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sgrCia")
    private List<SgrRoleCia> sgrRoleCiaList;

    public SgrCia() {
        super();
    }

    public SgrCia(String ciaCode) {
        this.ciaCode = ciaCode;
    }

    public String getCiaCode() {
        return ciaCode;
    }

    public void setCiaCode(String ciaCode) {
        this.ciaCode = ciaCode;
    }

    public String getCiaName() {
        return ciaName;
    }

    public void setCiaName(String ciaName) {
        this.ciaName = ciaName;
    }

    public String getCiaSegment1() {
        return ciaSegment1;
    }

    public void setCiaSegment1(String ciaSegment1) {
        this.ciaSegment1 = ciaSegment1;
    }

    public String getCiaCurrencyDefault() {
        return ciaCurrencyDefault;
    }

    public void setCiaCurrencyDefault(String ciaCurrencyDefault) {
        this.ciaCurrencyDefault = ciaCurrencyDefault;
    }

    public String getCiaLogo() {
        return ciaLogo;
    }

    public void setCiaLogo(String ciaLogo) {
        this.ciaLogo = ciaLogo;
    }

    public byte[] getCiaLogoBlob() {
        return ciaLogoBlob;
    }

    public void setCiaLogoBlob(byte[] ciaLogoBlob) {
        this.ciaLogoBlob = ciaLogoBlob;
    }

    public String getCiaLogoExt() {
        return ciaLogoExt;
    }

    public void setCiaLogoExt(String ciaLogoExt) {
        this.ciaLogoExt = ciaLogoExt;
    }

    public String getLogoBase64() {
        return logoBase64;
    }

    public void setLogoBase64(String logoBase64) {
        this.logoBase64 = logoBase64;
    }   

    public BigDecimal getCiaAcceso() {
        return ciaAcceso;
    }

    public void setCiaAcceso(BigDecimal ciaAcceso) {
        this.ciaAcceso = ciaAcceso;
    }
    
    @XmlTransient
    public List<SgrRoleCia> getSgrRoleCiaList() {
        return sgrRoleCiaList;
    }

    public void setSgrRoleCiaList(List<SgrRoleCia> sgrRoleCiaList) {
        this.sgrRoleCiaList = sgrRoleCiaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ciaCode != null ? ciaCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof SgrCia)) {
            return false;
        }
        SgrCia other = (SgrCia) object;
        if ((this.ciaCode == null && other.ciaCode != null) || (this.ciaCode != null && !this.ciaCode.equals(other.ciaCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.SgrCia[ ciaCode=" + ciaCode + " ]";
    }
    
    public String getCiaType() {
        return ciaType;
    }

    public void setCiaType(String ciaType) {
        this.ciaType = ciaType;
    }
    
    @XmlTransient
    public Collection<EngMergeCustomer> getEngMergeCustomerCollection() {
        return engMergeCustomerCollection;
    }

    public void setEngMergeCustomerCollection(Collection<EngMergeCustomer> engMergeCustomerCollection) {
        this.engMergeCustomerCollection = engMergeCustomerCollection;
    }
}
