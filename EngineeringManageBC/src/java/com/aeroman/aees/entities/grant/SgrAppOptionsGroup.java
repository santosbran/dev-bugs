/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities.grant;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "SGR_APP_OPTIONS_GROUP", catalog = "", schema = "PROCESOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SgrAppOptionsGroup.findAll", query = "SELECT s FROM SgrAppOptionsGroup s"),
    @NamedQuery(name = "SgrAppOptionsGroup.findByOptionsGroupCode", query = "SELECT s FROM SgrAppOptionsGroup s WHERE s.sgrAppOptionsGroupPK.optionsGroupCode = :optionsGroupCode"),
    @NamedQuery(name = "SgrAppOptionsGroup.findBySystemid", query = "SELECT s FROM SgrAppOptionsGroup s WHERE s.sgrAppOptionsGroupPK.systemid = :systemid"),
    @NamedQuery(name = "SgrAppOptionsGroup.findByOptionsGroupName", query = "SELECT s FROM SgrAppOptionsGroup s WHERE s.optionsGroupName = :optionsGroupName"),
    @NamedQuery(name = "SgrAppOptionsGroup.findByOptionsGroupDad", query = "SELECT s FROM SgrAppOptionsGroup s WHERE s.optionsGroupDad = :optionsGroupDad"),
    @NamedQuery(name = "SgrAppOptionsGroup.findByOptionsGroupNameI", query = "SELECT s FROM SgrAppOptionsGroup s WHERE s.optionsGroupNameI = :optionsGroupNameI"),
    @NamedQuery(name = "SgrAppOptionsGroup.findByOptionOrden", query = "SELECT s FROM SgrAppOptionsGroup s WHERE s.optionOrden = :optionOrden")})
public class SgrAppOptionsGroup implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SgrAppOptionsGroupPK sgrAppOptionsGroupPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "OPTIONS_GROUP_NAME")
    private String optionsGroupName;
    @Column(name = "OPTIONS_GROUP_DAD")
    private BigInteger optionsGroupDad;
    @Size(max = 50)
    @Column(name = "OPTIONS_GROUP_NAME_I")
    private String optionsGroupNameI;
    @Column(name = "OPTION_ORDEN")
    private BigInteger optionOrden;
    @JoinColumn(name = "SYSTEMID", referencedColumnName = "SYSTEMID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SgrSistema sgrSistema;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sgrAppOptionsGroup")
    private List<SgrSystemOption> sgrSystemOptionList;

    public SgrAppOptionsGroup() {
        super();
    }

    public SgrAppOptionsGroup(SgrAppOptionsGroupPK sgrAppOptionsGroupPK) {
        this.sgrAppOptionsGroupPK = sgrAppOptionsGroupPK;
    }

    public SgrAppOptionsGroup(SgrAppOptionsGroupPK sgrAppOptionsGroupPK, String optionsGroupName) {
        this.sgrAppOptionsGroupPK = sgrAppOptionsGroupPK;
        this.optionsGroupName = optionsGroupName;
    }

    public SgrAppOptionsGroup(BigInteger optionsGroupCode, long systemid) {
        this.sgrAppOptionsGroupPK = new SgrAppOptionsGroupPK(optionsGroupCode, systemid);
    }

    public SgrAppOptionsGroupPK getSgrAppOptionsGroupPK() {
        return sgrAppOptionsGroupPK;
    }

    public void setSgrAppOptionsGroupPK(SgrAppOptionsGroupPK sgrAppOptionsGroupPK) {
        this.sgrAppOptionsGroupPK = sgrAppOptionsGroupPK;
    }

    public String getOptionsGroupName() {
        return optionsGroupName;
    }

    public void setOptionsGroupName(String optionsGroupName) {
        this.optionsGroupName = optionsGroupName;
    }

    public BigInteger getOptionsGroupDad() {
        return optionsGroupDad;
    }

    public void setOptionsGroupDad(BigInteger optionsGroupDad) {
        this.optionsGroupDad = optionsGroupDad;
    }

    public String getOptionsGroupNameI() {
        return optionsGroupNameI;
    }

    public void setOptionsGroupNameI(String optionsGroupNameI) {
        this.optionsGroupNameI = optionsGroupNameI;
    }

    public BigInteger getOptionOrden() {
        return optionOrden;
    }

    public void setOptionOrden(BigInteger optionOrden) {
        this.optionOrden = optionOrden;
    }

    public SgrSistema getSgrSistema() {
        return sgrSistema;
    }

    public void setSgrSistema(SgrSistema sgrSistema) {
        this.sgrSistema = sgrSistema;
    }

    @XmlTransient
    public List<SgrSystemOption> getSgrSystemOptionList() {
        return sgrSystemOptionList;
    }

    public void setSgrSystemOptionList(List<SgrSystemOption> sgrSystemOptionList) {
        this.sgrSystemOptionList = sgrSystemOptionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sgrAppOptionsGroupPK != null ? sgrAppOptionsGroupPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof SgrAppOptionsGroup)) {
            return false;
        }
        SgrAppOptionsGroup other = (SgrAppOptionsGroup) object;
        if ((this.sgrAppOptionsGroupPK == null && other.sgrAppOptionsGroupPK != null) || (this.sgrAppOptionsGroupPK != null && !this.sgrAppOptionsGroupPK.equals(other.sgrAppOptionsGroupPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.SgrAppOptionsGroup[ sgrAppOptionsGroupPK=" + sgrAppOptionsGroupPK + " ]";
    }
    
}
