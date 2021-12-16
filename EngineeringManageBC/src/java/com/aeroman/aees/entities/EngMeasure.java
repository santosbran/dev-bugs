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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vjuarez
 */
@Entity
@Table(name = "ENG_MEASURE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngMeasure.findAll", query = "SELECT e FROM EngMeasure e"),
    @NamedQuery(name = "EngMeasure.findByEngId", query = "SELECT e FROM EngMeasure e WHERE e.engId = :engId"),
    @NamedQuery(name = "EngMeasure.findByEngMeasure", query = "SELECT e FROM EngMeasure e WHERE e.engMeasure = :engMeasure")})
public class EngMeasure implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue (strategy=GenerationType.SEQUENCE,generator="ENG_MEASURE_SEQ") 
    @SequenceGenerator (name="ENG_MEASURE_SEQ",sequenceName="ENG_MEASURE_SEQ",allocationSize=1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ENG_ID")
    private BigDecimal engId;
    @Size(max = 50)
    @Column(name = "ENG_MEASURE")
    private String engMeasure;

    public EngMeasure() {
        super();
    }

    public EngMeasure(BigDecimal engId) {
        this.engId = engId;
    }

    public BigDecimal getEngId() {
        return engId;
    }

    public void setEngId(BigDecimal engId) {
        this.engId = engId;
    }

    public String getEngMeasure() {
        return engMeasure;
    }

    public void setEngMeasure(String engMeasure) {
        this.engMeasure = engMeasure;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (engId != null ? engId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EngMeasure)) {
            return false;
        }
        EngMeasure other = (EngMeasure) object;
        if ((this.engId == null && other.engId != null) || (this.engId != null && !this.engId.equals(other.engId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngMeasure[ engId=" + engId + " ]";
    }
    
}
