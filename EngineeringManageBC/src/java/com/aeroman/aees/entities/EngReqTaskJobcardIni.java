/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vjuarez
 */
@Entity
@Table(name = "ENG_REQ_TASK_JOBCARD_INI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngReqTaskJobcardIni.findAll", query = "SELECT e FROM EngReqTaskJobcardIni e"),
    @NamedQuery(name = "EngReqTaskJobcardIni.findByErtjIdReg", query = "SELECT e FROM EngReqTaskJobcardIni e WHERE e.ertjIdReg = :ertjIdReg"),
    @NamedQuery(name = "EngReqTaskJobcardIni.findByErtjDescrip", query = "SELECT e FROM EngReqTaskJobcardIni e WHERE e.ertjDescrip = :ertjDescrip")})
public class EngReqTaskJobcardIni implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ERTJ_ID_REG")
    private BigDecimal ertjIdReg;
    @Size(max = 100)
    @Column(name = "ERTJ_DESCRIP")
    private String ertjDescrip;
    @JoinColumn(name = "REQ_MESSAGEID", referencedColumnName = "REQ_MESSAGEID")
    @ManyToOne(optional = false)
    private EngRequest reqMessageid;

    public EngReqTaskJobcardIni() {
        super();
    }

    public EngReqTaskJobcardIni(BigDecimal ertjIdReg) {
        this.ertjIdReg = ertjIdReg;
    }

    public BigDecimal getErtjIdReg() {
        return ertjIdReg;
    }

    public void setErtjIdReg(BigDecimal ertjIdReg) {
        this.ertjIdReg = ertjIdReg;
    }

    public String getErtjDescrip() {
        return ertjDescrip;
    }

    public void setErtjDescrip(String ertjDescrip) {
        this.ertjDescrip = ertjDescrip;
    }

    public EngRequest getReqMessageid() {
        return reqMessageid;
    }

    public void setReqMessageid(EngRequest reqMessageid) {
        this.reqMessageid = reqMessageid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ertjIdReg != null ? ertjIdReg.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EngReqTaskJobcardIni)) {
            return false;
        }
        EngReqTaskJobcardIni other = (EngReqTaskJobcardIni) object;
        if ((this.ertjIdReg == null && other.ertjIdReg != null) || (this.ertjIdReg != null && !this.ertjIdReg.equals(other.ertjIdReg))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngReqTaskJobcardIni[ ertjIdReg=" + ertjIdReg + " ]";
    }
    
}
