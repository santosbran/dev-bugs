/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
 * @author mpolanco
 */
@Entity
@Table(name = "ENG_REPAIR_CLASSIF")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngRepairClassif.findAll", query = "SELECT e FROM EngRepairClassif e")
    , @NamedQuery(name = "EngRepairClassif.findByRetId", query = "SELECT e FROM EngRepairClassif e WHERE e.idRepClassif = :idRepClassif")
    , @NamedQuery(name = "EngRepairClassif.findByRetDescription", query = "SELECT e FROM EngRepairClassif e WHERE e.nameRepClassif = :nameRepClassif")
    
})
public class EngRepairClassif implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue (strategy=GenerationType.SEQUENCE,generator="ENG_REPAIR_CLASSIF_SEQ") 
    @SequenceGenerator (name="ENG_REPAIR_CLASSIF_SEQ",sequenceName="ENG_REPAIR_CLASSIF_SEQ",allocationSize=1)
    @Column(name = "ID_REP_CLASSIF")
    private BigDecimal idRepClassif;
    @Size(max = 50)
    @Column(name = "NAME_REP_CLASSIF")
    private String nameRepClassif;
    
    public EngRepairClassif() {
    }
    

    public EngRepairClassif(BigDecimal idRepClassif) {
        this.idRepClassif = idRepClassif;
    }

    public EngRepairClassif(BigDecimal idRepClassif, String nameRepClassif) {
        this.idRepClassif = idRepClassif;
        this.nameRepClassif = nameRepClassif;
    }

    public BigDecimal getIdRepClassif() {
        return idRepClassif;
    }

    public void setIdRepClassif(BigDecimal idRepClassif) {
        this.idRepClassif = idRepClassif;
    }

    public String getNameRepClassif() {
        return nameRepClassif;
    }

    public void setNameRepClassif(String nameRepClassif) {
        this.nameRepClassif = nameRepClassif;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRepClassif != null ? idRepClassif.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof EngRepairClassif)) {
            return false;
        }
        EngRepairClassif other = (EngRepairClassif) object;
        if ((this.idRepClassif == null && other.idRepClassif != null) || (this.idRepClassif != null && !this.idRepClassif.equals(other.idRepClassif))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngRepairClassif[ idRepClassif=" + idRepClassif + " ]";
    }
    
}
