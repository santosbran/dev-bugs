/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
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
@Cacheable(false)
@Table(name = "ENG_ACTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngActor.findAll", query = "SELECT e FROM EngActor e"),
    @NamedQuery(name = "EngActor.findByActId", query = "SELECT e FROM EngActor e WHERE e.actId = :actId"),
    @NamedQuery(name = "EngActor.findByActCode", query = "SELECT e FROM EngActor e WHERE e.actCode = :actCode"),
    @NamedQuery(name = "EngActor.findByActName", query = "SELECT e FROM EngActor e WHERE e.actName = :actName")})
public class EngActor implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENG_ACTOR_SEQ")
    @SequenceGenerator(name = "ENG_ACTOR_SEQ", sequenceName = "ENG_ACTOR_SEQ", allocationSize = 1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACT_ID")
    private BigDecimal actId;
    @Size(max = 4)
    @Column(name = "ACT_CODE")
    private String actCode;
    @Size(max = 200)
    @Column(name = "ACT_NAME")
    private String actName;

    public EngActor() {
        super();
    }

    public EngActor(BigDecimal actId) {
        this.actId = actId;
    }

    public BigDecimal getActId() {
        return actId;
    }

    public void setActId(BigDecimal actId) {
        this.actId = actId;
    }

    public String getActCode() {
        return actCode;
    }

    public void setActCode(String actCode) {
        this.actCode = actCode;
    }

    public String getActName() {
        return actName;
    }

    public void setActName(String actName) {
        this.actName = actName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (actId != null ? actId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EngActor)) {
            return false;
        }
        EngActor other = (EngActor) object;
        if ((this.actId == null && other.actId != null) || (this.actId != null && !this.actId.equals(other.actId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngActor[ actId=" + actId + " ]";
    }
    
}
