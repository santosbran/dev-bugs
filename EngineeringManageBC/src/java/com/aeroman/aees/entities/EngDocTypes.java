/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities;

import java.io.Serializable;
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
 * @author pc
 */
@Entity
@Cacheable(false)
@Table(name = "ENG_DOC_TYPES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngDocTypes.findAll", query = "SELECT e FROM EngDocTypes e"),
    @NamedQuery(name = "EngDocTypes.findByDotCod", query = "SELECT e FROM EngDocTypes e WHERE e.dotCod = :dotCod"),
    @NamedQuery(name = "EngDocTypes.findByDotCreatesEo", query = "SELECT e FROM EngDocTypes e WHERE e.dotCreatesEo = :dotCreatesEo"),
    @NamedQuery(name = "EngDocTypes.findByDotDescription", query = "SELECT e FROM EngDocTypes e WHERE e.dotDescription = :dotDescription"),
    @NamedQuery(name = "EngDocTypes.findByDotSpecialApp", query = "SELECT e FROM EngDocTypes e WHERE e.dotSpecialApp = :dotSpecialApp"),
    @NamedQuery(name = "EngDocTypes.findByDotOrderRef", query = "SELECT e FROM EngDocTypes e WHERE e.dotOrderRef = :dotOrderRef"),
    @NamedQuery(name = "EngDocTypes.findByDotModDevelop", query = "SELECT e FROM EngDocTypes e WHERE e.dotModDevelop = :dotModDevelop")})
public class EngDocTypes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "DOT_COD")
    private String dotCod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "DOT_CREATES_EO")
    private String dotCreatesEo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DOT_DESCRIPTION")
    private String dotDescription;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "DOT_SPECIAL_APP")
    private String dotSpecialApp;
    @Column(name = "DOT_ORDER_REF")
    private Integer dotOrderRef;
    @Size(max = 1)
    @Column(name = "DOT_MOD_DEVELOP")
    private String dotModDevelop;

    public EngDocTypes() {
        super();
    }

    public EngDocTypes(String dotCod) {
        this.dotCod = dotCod;
    }

    public EngDocTypes(String dotCod, String dotCreatesEo, String dotDescription, String dotSpecialApp) {
        this.dotCod = dotCod;
        this.dotCreatesEo = dotCreatesEo;
        this.dotDescription = dotDescription;
        this.dotSpecialApp = dotSpecialApp;
    }

    public String getDotCod() {
        return dotCod;
    }

    public void setDotCod(String dotCod) {
        this.dotCod = dotCod;
    }

    public String getDotCreatesEo() {
        return dotCreatesEo;
    }

    public void setDotCreatesEo(String dotCreatesEo) {
        this.dotCreatesEo = dotCreatesEo;
    }

    public String getDotDescription() {
        return dotDescription;
    }

    public void setDotDescription(String dotDescription) {
        this.dotDescription = dotDescription;
    }

    public String getDotSpecialApp() {
        return dotSpecialApp;
    }

    public void setDotSpecialApp(String dotSpecialApp) {
        this.dotSpecialApp = dotSpecialApp;
    }

    public Integer getDotOrderRef() {
        return dotOrderRef;
    }

    public void setDotOrderRef(Integer dotOrderRef) {
        this.dotOrderRef = dotOrderRef;
    }

    public String getDotModDevelop() {
        return dotModDevelop;
    }

    public void setDotModDevelop(String dotModDevelop) {
        this.dotModDevelop = dotModDevelop;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dotCod != null ? dotCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EngDocTypes)) {
            return false;
        }
        EngDocTypes other = (EngDocTypes) object;
        if ((this.dotCod == null && other.dotCod != null) || (this.dotCod != null && !this.dotCod.equals(other.dotCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngDocTypes[ dotCod=" + dotCod + " ]";
    }
    
}
