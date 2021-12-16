/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities.grant;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author saplic
 */
@Entity
@Cacheable(false)
@Table(name = "SGR_ROLE_CIA", catalog = "", schema = "PROCESOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SgrRoleCia.findAll", query = "SELECT s FROM SgrRoleCia s"),
    @NamedQuery(name = "SgrRoleCia.findByRoleCode", query = "SELECT s FROM SgrRoleCia s WHERE s.sgrRoleCiaPK.roleCode = :roleCode"),
    @NamedQuery(name = "SgrRoleCia.findBySystemid", query = "SELECT s FROM SgrRoleCia s WHERE s.sgrRoleCiaPK.systemid = :systemid"),
    @NamedQuery(name = "SgrRoleCia.findByCiaCode", query = "SELECT s FROM SgrRoleCia s WHERE s.sgrRoleCiaPK.ciaCode = :ciaCode")})
public class SgrRoleCia implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SgrRoleCiaPK sgrRoleCiaPK;
    @ManyToMany(mappedBy = "sgrRoleCiaList")
    private List<SgrSystemOption> sgrSystemOptionList;
    @JoinColumns({
        @JoinColumn(name = "ROLE_CODE", referencedColumnName = "ROLE_CODE", insertable = false, updatable = false),
        @JoinColumn(name = "SYSTEMID", referencedColumnName = "SYSTEMID", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private SgrRole sgrRole;
    @JoinColumn(name = "CIA_CODE", referencedColumnName = "CIA_CODE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SgrCia sgrCia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sgrRoleCia")
    private List<SgrUserRole> sgrUserRoleList;

    public SgrRoleCia() {
        super();
    }

    public SgrRoleCia(SgrRoleCiaPK sgrRoleCiaPK) {
        this.sgrRoleCiaPK = sgrRoleCiaPK;
    }

    public SgrRoleCia(String roleCode, long systemid, String ciaCode) {
        this.sgrRoleCiaPK = new SgrRoleCiaPK(roleCode, systemid, ciaCode);
    }

    public SgrRoleCiaPK getSgrRoleCiaPK() {
        return sgrRoleCiaPK;
    }

    public void setSgrRoleCiaPK(SgrRoleCiaPK sgrRoleCiaPK) {
        this.sgrRoleCiaPK = sgrRoleCiaPK;
    }

    @XmlTransient
    public List<SgrSystemOption> getSgrSystemOptionList() {
        return sgrSystemOptionList;
    }

    public void setSgrSystemOptionList(List<SgrSystemOption> sgrSystemOptionList) {
        this.sgrSystemOptionList = sgrSystemOptionList;
    }

    public SgrRole getSgrRole() {
        return sgrRole;
    }

    public void setSgrRole(SgrRole sgrRole) {
        this.sgrRole = sgrRole;
    }

    public SgrCia getSgrCia() {
        return sgrCia;
    }

    public void setSgrCia(SgrCia sgrCia) {
        this.sgrCia = sgrCia;
    }

    @XmlTransient
    public List<SgrUserRole> getSgrUserRoleList() {
        return sgrUserRoleList;
    }

    public void setSgrUserRoleList(List<SgrUserRole> sgrUserRoleList) {
        this.sgrUserRoleList = sgrUserRoleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sgrRoleCiaPK != null ? sgrRoleCiaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof SgrRoleCia)) {
            return false;
        }
        SgrRoleCia other = (SgrRoleCia) object;
        if ((this.sgrRoleCiaPK == null && other.sgrRoleCiaPK != null) || (this.sgrRoleCiaPK != null && !this.sgrRoleCiaPK.equals(other.sgrRoleCiaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.SgrRoleCia[ sgrRoleCiaPK=" + sgrRoleCiaPK + " ]";
    }
    
}
