/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities.grant;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author saplic
 */
@Entity
@Cacheable(false)
@Table(name = "SGR_PEOPLE_TYPE", catalog = "", schema = "PROCESOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SgrPeopleType.findAll", query = "SELECT s FROM SgrPeopleType s"),
    @NamedQuery(name = "SgrPeopleType.findByPeopleTypeCode", query = "SELECT s FROM SgrPeopleType s WHERE s.sgrPeopleTypePK.peopleTypeCode = :peopleTypeCode"),
    @NamedQuery(name = "SgrPeopleType.findByPeopleTypeName", query = "SELECT s FROM SgrPeopleType s WHERE s.peopleTypeName = :peopleTypeName"),
    @NamedQuery(name = "SgrPeopleType.findBySystemid", query = "SELECT s FROM SgrPeopleType s WHERE s.sgrPeopleTypePK.systemid = :systemid")})
public class SgrPeopleType implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SgrPeopleTypePK sgrPeopleTypePK;
    @Size(max = 150)
    @Column(name = "PEOPLE_TYPE_NAME")
    private String peopleTypeName;
    @JoinTable(name = "SGR_USER_PEOPLE_TYPE", joinColumns = {
        @JoinColumn(name = "PEOPLE_TYPE_CODE", referencedColumnName = "PEOPLE_TYPE_CODE"),
        @JoinColumn(name = "SYSTEMID", referencedColumnName = "SYSTEMID")}, inverseJoinColumns = {
        @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")})
    @ManyToMany
    private List<SgrUser> sgrUserList;

    public SgrPeopleType() {
        super();
    }

    public SgrPeopleType(SgrPeopleTypePK sgrPeopleTypePK) {
        this.sgrPeopleTypePK = sgrPeopleTypePK;
    }

    public SgrPeopleType(BigInteger peopleTypeCode, BigInteger systemid) {
        this.sgrPeopleTypePK = new SgrPeopleTypePK(peopleTypeCode, systemid);
    }

    public SgrPeopleTypePK getSgrPeopleTypePK() {
        return sgrPeopleTypePK;
    }

    public void setSgrPeopleTypePK(SgrPeopleTypePK sgrPeopleTypePK) {
        this.sgrPeopleTypePK = sgrPeopleTypePK;
    }

    public String getPeopleTypeName() {
        return peopleTypeName;
    }

    public void setPeopleTypeName(String peopleTypeName) {
        this.peopleTypeName = peopleTypeName;
    }

    @XmlTransient
    public List<SgrUser> getSgrUserList() {
        return sgrUserList;
    }

    public void setSgrUserList(List<SgrUser> sgrUserList) {
        this.sgrUserList = sgrUserList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sgrPeopleTypePK != null ? sgrPeopleTypePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof SgrPeopleType)) {
            return false;
        }
        SgrPeopleType other = (SgrPeopleType) object;
        if ((this.sgrPeopleTypePK == null && other.sgrPeopleTypePK != null) || (this.sgrPeopleTypePK != null && !this.sgrPeopleTypePK.equals(other.sgrPeopleTypePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.SgrPeopleType[ sgrPeopleTypePK=" + sgrPeopleTypePK + " ]";
    }
    
}
