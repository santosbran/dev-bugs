/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities.grant;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author saplic
 */
@Entity
@Cacheable(false)
@Table(name = "SGR_USER_ROLE", catalog = "", schema = "PROCESOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SgrUserRole.findAll", query = "SELECT s FROM SgrUserRole s"),
    @NamedQuery(name = "SgrUserRole.findByRoleCode", query = "SELECT s FROM SgrUserRole s WHERE s.sgrUserRolePK.roleCode = :roleCode"),
    @NamedQuery(name = "SgrUserRole.findBySystemid", query = "SELECT s FROM SgrUserRole s WHERE s.sgrUserRolePK.systemid = :systemid"),
    @NamedQuery(name = "SgrUserRole.findByUserId", query = "SELECT s FROM SgrUserRole s WHERE s.sgrUserRolePK.userId = :userId"),
    @NamedQuery(name = "SgrUserRole.findByDefinitionDate", query = "SELECT s FROM SgrUserRole s WHERE s.definitionDate = :definitionDate"),
    @NamedQuery(name = "SgrUserRole.findByExpiredDate", query = "SELECT s FROM SgrUserRole s WHERE s.expiredDate = :expiredDate"),
    @NamedQuery(name = "SgrUserRole.findByStatus", query = "SELECT s FROM SgrUserRole s WHERE s.status = :status"),
    @NamedQuery(name = "SgrUserRole.findByCiaCode", query = "SELECT s FROM SgrUserRole s WHERE s.sgrUserRolePK.ciaCode = :ciaCode")})
public class SgrUserRole implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SgrUserRolePK sgrUserRolePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DEFINITION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date definitionDate;
    @Column(name = "EXPIRED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expiredDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "STATUS")
    private String status;
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SgrUser sgrUser;
    @JoinColumns({
        @JoinColumn(name = "ROLE_CODE", referencedColumnName = "ROLE_CODE", insertable = false, updatable = false),
        @JoinColumn(name = "SYSTEMID", referencedColumnName = "SYSTEMID", insertable = false, updatable = false),
        @JoinColumn(name = "CIA_CODE", referencedColumnName = "CIA_CODE", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private SgrRoleCia sgrRoleCia;

    public SgrUserRole() {
        super();
    }

    public SgrUserRole(SgrUserRolePK sgrUserRolePK) {
        this.sgrUserRolePK = sgrUserRolePK;
    }

    public SgrUserRole(SgrUserRolePK sgrUserRolePK, Date definitionDate, String status) {
        this.sgrUserRolePK = sgrUserRolePK;
        this.definitionDate = definitionDate;
        this.status = status;
    }

    public SgrUserRole(String roleCode, long systemid, BigInteger userId, String ciaCode) {
        this.sgrUserRolePK = new SgrUserRolePK(roleCode, systemid, userId, ciaCode);
    }

    public SgrUserRolePK getSgrUserRolePK() {
        return sgrUserRolePK;
    }

    public void setSgrUserRolePK(SgrUserRolePK sgrUserRolePK) {
        this.sgrUserRolePK = sgrUserRolePK;
    }

    public Date getDefinitionDate() {
        return definitionDate;
    }

    public void setDefinitionDate(Date definitionDate) {
        this.definitionDate = definitionDate;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public SgrUser getSgrUser() {
        return sgrUser;
    }

    public void setSgrUser(SgrUser sgrUser) {
        this.sgrUser = sgrUser;
    }

    public SgrRoleCia getSgrRoleCia() {
        return sgrRoleCia;
    }

    public void setSgrRoleCia(SgrRoleCia sgrRoleCia) {
        this.sgrRoleCia = sgrRoleCia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sgrUserRolePK != null ? sgrUserRolePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof SgrUserRole)) {
            return false;
        }
        SgrUserRole other = (SgrUserRole) object;
        if ((this.sgrUserRolePK == null && other.sgrUserRolePK != null) || (this.sgrUserRolePK != null && !this.sgrUserRolePK.equals(other.sgrUserRolePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.SgrUserRole[ sgrUserRolePK=" + sgrUserRolePK + " ]";
    }
    
}
