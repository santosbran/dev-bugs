/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities.grant;

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
 * @author Usuario
 */
@Entity
@Cacheable(false)
@Table(name = "CORE_TRESHHOLD", catalog = "", schema = "CORE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoreTreshhold.findAll", query = "SELECT c FROM CoreTreshhold c"),
    @NamedQuery(name = "CoreTreshhold.findByIdTresh", query = "SELECT c FROM CoreTreshhold c WHERE c.idTresh = :idTresh"),
    @NamedQuery(name = "CoreTreshhold.findBySyst", query = "SELECT c FROM CoreTreshhold c WHERE c.syst = :syst"),
    @NamedQuery(name = "CoreTreshhold.findByOpcion", query = "SELECT c FROM CoreTreshhold c WHERE c.opcion = :opcion"),
    @NamedQuery(name = "CoreTreshhold.findByMini", query = "SELECT c FROM CoreTreshhold c WHERE c.mini = :mini"),
    @NamedQuery(name = "CoreTreshhold.findByMaxi", query = "SELECT c FROM CoreTreshhold c WHERE c.maxi = :maxi"),
    @NamedQuery(name = "CoreTreshhold.findByColor", query = "SELECT c FROM CoreTreshhold c WHERE c.color = :color"),
    @NamedQuery(name = "CoreTreshhold.findByComments", query = "SELECT c FROM CoreTreshhold c WHERE c.comments = :comments")})
public class CoreTreshhold implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TRESH")
    private Long idTresh;
    @Size(max = 50)
    @Column(name = "SYST")
    private String syst;
    @Column(name = "OPCION")
    private Short opcion;
    @Column(name = "MINI")
    private Short mini;
    @Column(name = "MAXI")
    private Short maxi;
    @Size(max = 50)
    @Column(name = "COLOR")
    private String color;
    @Size(max = 500)
    @Column(name = "COMMENTS")
    private String comments;

    public CoreTreshhold() {
        super();
    }

    public CoreTreshhold(Long idTresh) {
        this.idTresh = idTresh;
    }

    public Long getIdTresh() {
        return idTresh;
    }

    public void setIdTresh(Long idTresh) {
        this.idTresh = idTresh;
    }

    public String getSyst() {
        return syst;
    }

    public void setSyst(String syst) {
        this.syst = syst;
    }

    public Short getOpcion() {
        return opcion;
    }

    public void setOpcion(Short opcion) {
        this.opcion = opcion;
    }

    public Short getMini() {
        return mini;
    }

    public void setMini(Short mini) {
        this.mini = mini;
    }

    public Short getMaxi() {
        return maxi;
    }

    public void setMaxi(Short maxi) {
        this.maxi = maxi;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTresh != null ? idTresh.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof CoreTreshhold)) {
            return false;
        }
        CoreTreshhold other = (CoreTreshhold) object;
        if ((this.idTresh == null && other.idTresh != null) || (this.idTresh != null && !this.idTresh.equals(other.idTresh))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.grant.CoreTreshhold[ idTresh=" + idTresh + " ]";
    }
    
}
