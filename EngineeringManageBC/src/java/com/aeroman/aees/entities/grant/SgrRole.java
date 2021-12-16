/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities.grant;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
@Table(name = "SGR_ROLE", catalog = "", schema = "PROCESOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SgrRole.findAll", query = "SELECT s FROM SgrRole s"),
    @NamedQuery(name = "SgrRole.findByRoleCode", query = "SELECT s FROM SgrRole s WHERE s.sgrRolePK.roleCode = :roleCode"),
    @NamedQuery(name = "SgrRole.findBySystemid", query = "SELECT s FROM SgrRole s WHERE s.sgrRolePK.systemid = :systemid"),
    @NamedQuery(name = "SgrRole.findByRoleDesc", query = "SELECT s FROM SgrRole s WHERE s.roleDesc = :roleDesc")})
public class SgrRole implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sgrRole")
    private List<SgrRoleCia> sgrRoleCiaList;
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SgrRolePK sgrRolePK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ROLE_DESC")
    private String roleDesc;
    @JoinColumn(name = "SYSTEMID", referencedColumnName = "SYSTEMID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SgrSistema sgrSistema;

    public SgrRole() {
        super();
    }

    public SgrRole(SgrRolePK sgrRolePK) {
        this.sgrRolePK = sgrRolePK;
    }

    public SgrRole(SgrRolePK sgrRolePK, String roleDesc) {
        this.sgrRolePK = sgrRolePK;
        this.roleDesc = roleDesc;
    }

    public SgrRole(String roleCode, long systemid) {
        this.sgrRolePK = new SgrRolePK(roleCode, systemid);
    }

    public SgrRolePK getSgrRolePK() {
        return sgrRolePK;
    }

    public void setSgrRolePK(SgrRolePK sgrRolePK) {
        this.sgrRolePK = sgrRolePK;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public SgrSistema getSgrSistema() {
        return sgrSistema;
    }

    public void setSgrSistema(SgrSistema sgrSistema) {
        this.sgrSistema = sgrSistema;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sgrRolePK != null ? sgrRolePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof SgrRole)) {
            return false;
        }
        SgrRole other = (SgrRole) object;
        if ((this.sgrRolePK == null && other.sgrRolePK != null) || (this.sgrRolePK != null && !this.sgrRolePK.equals(other.sgrRolePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.SgrRole[ sgrRolePK=" + sgrRolePK + " ]";
    }

    @XmlTransient
    public List<SgrRoleCia> getSgrRoleCiaList() {
        return sgrRoleCiaList;
    }

    public void setSgrRoleCiaList(List<SgrRoleCia> sgrRoleCiaList) {
        this.sgrRoleCiaList = sgrRoleCiaList;
    }
    
}
