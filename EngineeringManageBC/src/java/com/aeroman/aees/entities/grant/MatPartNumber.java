/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities.grant;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * @author scruz
 */
@Entity
@Cacheable(false)
@Table(name = "MAT_PART_NUMBER", catalog = "", schema = "MAT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MatPartNumber.findAll", query = "SELECT m FROM MatPartNumber m"),
    @NamedQuery(name = "MatPartNumber.findByIdPart", query = "SELECT m FROM MatPartNumber m WHERE m.idPart = :idPart"),
    @NamedQuery(name = "MatPartNumber.findByPartCode", query = "SELECT m FROM MatPartNumber m WHERE m.partCode = :partCode"),
    @NamedQuery(name = "MatPartNumber.findByPartDesc", query = "SELECT m FROM MatPartNumber m WHERE m.partDesc = :partDesc")})
public class MatPartNumber implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PART")
    private BigDecimal idPart;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PART_CODE")
    private String partCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "PART_DESC")
    private String partDesc;

    public MatPartNumber() {
        super();
    }

    public MatPartNumber(BigDecimal idPart) {
        this.idPart = idPart;
    }

    public MatPartNumber(BigDecimal idPart, String partCode, String partDesc) {
        this.idPart = idPart;
        this.partCode = partCode;
        this.partDesc = partDesc;
    }

    public BigDecimal getIdPart() {
        return idPart;
    }

    public void setIdPart(BigDecimal idPart) {
        this.idPart = idPart;
    }

    public String getPartCode() {
        return partCode;
    }

    public void setPartCode(String partCode) {
        this.partCode = partCode;
    }

    public String getPartDesc() {
        return partDesc;
    }

    public void setPartDesc(String partDesc) {
        this.partDesc = partDesc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPart != null ? idPart.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof MatPartNumber)) {
            return false;
        }
        MatPartNumber other = (MatPartNumber) object;
        if ((this.idPart == null && other.idPart != null) || (this.idPart != null && !this.idPart.equals(other.idPart))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.grant.MatPartNumber[ idPart=" + idPart + " ]";
    }
    
}
