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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "ENG_ENGREQ_ADJ")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngEngreqAdj.findAll", query = "SELECT e FROM EngEngreqAdj e"),
    @NamedQuery(name = "EngEngreqAdj.findByAdjId", query = "SELECT e FROM EngEngreqAdj e WHERE e.adjId = :adjId"),
    @NamedQuery(name = "EngEngreqAdj.findByAdjExtension", query = "SELECT e FROM EngEngreqAdj e WHERE e.adjExtension = :adjExtension")})
public class EngEngreqAdj implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ADJ_ID")
    private BigDecimal adjId;
    @Lob
    @Column(name = "ADJ_DOCUMENTO")
    private Serializable adjDocumento;
    @Size(max = 30)
    @Column(name = "ADJ_EXTENSION")
    private String adjExtension;
    @JoinColumn(name = "REQ_MESSAGEID", referencedColumnName = "REQ_MESSAGEID")
    //@ManyToOne(optional = false)//@ManyToOne(optional = false)
    private EngRequest reqMessageid;

    public EngEngreqAdj() {
        super();
    }

    public EngEngreqAdj(BigDecimal adjId) {
        this.adjId = adjId;
    }

    public BigDecimal getAdjId() {
        return adjId;
    }

    public void setAdjId(BigDecimal adjId) {
        this.adjId = adjId;
    }

    public Serializable getAdjDocumento() {
        return adjDocumento;
    }

    public void setAdjDocumento(Serializable adjDocumento) {
        this.adjDocumento = adjDocumento;
    }

    public String getAdjExtension() {
        return adjExtension;
    }

    public void setAdjExtension(String adjExtension) {
        this.adjExtension = adjExtension;
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
        hash += (adjId != null ? adjId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EngEngreqAdj)) {
            return false;
        }
        EngEngreqAdj other = (EngEngreqAdj) object;
        if ((this.adjId == null && other.adjId != null) || (this.adjId != null && !this.adjId.equals(other.adjId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngEngreqAdj[ adjId=" + adjId + " ]";
    }
    
}
