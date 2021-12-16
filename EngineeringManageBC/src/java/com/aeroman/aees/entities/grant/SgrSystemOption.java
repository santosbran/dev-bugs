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
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "SGR_SYSTEM_OPTION", catalog = "", schema = "PROCESOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SgrSystemOption.findAll", query = "SELECT s FROM SgrSystemOption s"),
    @NamedQuery(name = "SgrSystemOption.findByOptionCode", query = "SELECT s FROM SgrSystemOption s WHERE s.sgrSystemOptionPK.optionCode = :optionCode"),
    @NamedQuery(name = "SgrSystemOption.findBySystemid", query = "SELECT s FROM SgrSystemOption s WHERE s.sgrSystemOptionPK.systemid = :systemid"),
    @NamedQuery(name = "SgrSystemOption.findByOptionName", query = "SELECT s FROM SgrSystemOption s WHERE s.optionName = :optionName"),
    @NamedQuery(name = "SgrSystemOption.findByOptionLink", query = "SELECT s FROM SgrSystemOption s WHERE s.optionLink = :optionLink"),
    @NamedQuery(name = "SgrSystemOption.findByOptionTarget", query = "SELECT s FROM SgrSystemOption s WHERE s.optionTarget = :optionTarget"),
    @NamedQuery(name = "SgrSystemOption.findByOptionOnclick", query = "SELECT s FROM SgrSystemOption s WHERE s.optionOnclick = :optionOnclick"),
    @NamedQuery(name = "SgrSystemOption.findByOptionOnmouseover", query = "SELECT s FROM SgrSystemOption s WHERE s.optionOnmouseover = :optionOnmouseover"),
    @NamedQuery(name = "SgrSystemOption.findByOptionOnmouseout", query = "SELECT s FROM SgrSystemOption s WHERE s.optionOnmouseout = :optionOnmouseout"),
    @NamedQuery(name = "SgrSystemOption.findByOptionTooltip", query = "SELECT s FROM SgrSystemOption s WHERE s.optionTooltip = :optionTooltip"),
    @NamedQuery(name = "SgrSystemOption.findByOptionAncho", query = "SELECT s FROM SgrSystemOption s WHERE s.optionAncho = :optionAncho"),
    @NamedQuery(name = "SgrSystemOption.findByOptionLargo", query = "SELECT s FROM SgrSystemOption s WHERE s.optionLargo = :optionLargo"),
    @NamedQuery(name = "SgrSystemOption.findByOptionForward", query = "SELECT s FROM SgrSystemOption s WHERE s.optionForward = :optionForward"),
    @NamedQuery(name = "SgrSystemOption.findByOptionAction", query = "SELECT s FROM SgrSystemOption s WHERE s.optionAction = :optionAction"),
    @NamedQuery(name = "SgrSystemOption.findByVisible", query = "SELECT s FROM SgrSystemOption s WHERE s.visible = :visible"),
    @NamedQuery(name = "SgrSystemOption.findByIsexception", query = "SELECT s FROM SgrSystemOption s WHERE s.isexception = :isexception"),
    @NamedQuery(name = "SgrSystemOption.findByOptionOrden", query = "SELECT s FROM SgrSystemOption s WHERE s.optionOrden = :optionOrden")})
public class SgrSystemOption implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SgrSystemOptionPK sgrSystemOptionPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "OPTION_NAME")
    private String optionName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4000)
    @Column(name = "OPTION_LINK")
    private String optionLink;
    @Size(max = 80)
    @Column(name = "OPTION_TARGET")
    private String optionTarget;
    @Size(max = 100)
    @Column(name = "OPTION_ONCLICK")
    private String optionOnclick;
    @Size(max = 100)
    @Column(name = "OPTION_ONMOUSEOVER")
    private String optionOnmouseover;
    @Size(max = 100)
    @Column(name = "OPTION_ONMOUSEOUT")
    private String optionOnmouseout;
    @Size(max = 200)
    @Column(name = "OPTION_TOOLTIP")
    private String optionTooltip;
    @Size(max = 10)
    @Column(name = "OPTION_ANCHO")
    private String optionAncho;
    @Size(max = 10)
    @Column(name = "OPTION_LARGO")
    private String optionLargo;
    @Size(max = 200)
    @Column(name = "OPTION_FORWARD")
    private String optionForward;
    @Size(max = 200)
    @Column(name = "OPTION_ACTION")
    private String optionAction;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "VISIBLE")
    private String visible;
    @Size(max = 2)
    @Column(name = "ISEXCEPTION")
    private String isexception;
    @Column(name = "OPTION_ORDEN")
    private BigInteger optionOrden;
    @JoinTable(name = "SGR_OPTION_ROLES", joinColumns = {
        @JoinColumn(name = "OPTION_CODE", referencedColumnName = "OPTION_CODE"),
        @JoinColumn(name = "SYSTEMID", referencedColumnName = "SYSTEMID")}, inverseJoinColumns = {
        @JoinColumn(name = "ROLE_CODE", referencedColumnName = "ROLE_CODE"),
        @JoinColumn(name = "SYSTEMID", referencedColumnName = "SYSTEMID"),
        @JoinColumn(name = "CIA_CODE", referencedColumnName = "CIA_CODE")})
    @ManyToMany
    private List<SgrRoleCia> sgrRoleCiaList;
    @OneToMany(mappedBy = "sgrSystemOption1")
    private List<SgrSystemOption> sgrSystemOptionList;
    @JoinColumns({
        @JoinColumn(name = "OPTION_DAD", referencedColumnName = "OPTION_CODE"),
        @JoinColumn(name = "SYSTEMID_DAD", referencedColumnName = "SYSTEMID")})
    @ManyToOne
    private SgrSystemOption sgrSystemOption1;
    @JoinColumn(name = "SYSTEMID", referencedColumnName = "SYSTEMID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SgrSistema sgrSistema;
    @JoinColumn(name = "AUDIT_LEVEL", referencedColumnName = "AUDIT_LEVEL")
    @ManyToOne
    private SgrAuditLevel auditLevel;
    @JoinColumns({
        @JoinColumn(name = "OPTIONS_GROUP_CODE", referencedColumnName = "OPTIONS_GROUP_CODE"),
        @JoinColumn(name = "SYSTEMID", referencedColumnName = "SYSTEMID", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private SgrAppOptionsGroup sgrAppOptionsGroup;

    public SgrSystemOption() {
        super();
    }

    public SgrSystemOption(SgrSystemOptionPK sgrSystemOptionPK) {
        this.sgrSystemOptionPK = sgrSystemOptionPK;
    }

    public SgrSystemOption(SgrSystemOptionPK sgrSystemOptionPK, String optionName, String optionLink, String visible) {
        this.sgrSystemOptionPK = sgrSystemOptionPK;
        this.optionName = optionName;
        this.optionLink = optionLink;
        this.visible = visible;
    }

    public SgrSystemOption(BigInteger optionCode, long systemid) {
        this.sgrSystemOptionPK = new SgrSystemOptionPK(optionCode, systemid);
    }

    public SgrSystemOptionPK getSgrSystemOptionPK() {
        return sgrSystemOptionPK;
    }

    public void setSgrSystemOptionPK(SgrSystemOptionPK sgrSystemOptionPK) {
        this.sgrSystemOptionPK = sgrSystemOptionPK;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public String getOptionLink() {
        return optionLink;
    }

    public void setOptionLink(String optionLink) {
        this.optionLink = optionLink;
    }

    public String getOptionTarget() {
        return optionTarget;
    }

    public void setOptionTarget(String optionTarget) {
        this.optionTarget = optionTarget;
    }

    public String getOptionOnclick() {
        return optionOnclick;
    }

    public void setOptionOnclick(String optionOnclick) {
        this.optionOnclick = optionOnclick;
    }

    public String getOptionOnmouseover() {
        return optionOnmouseover;
    }

    public void setOptionOnmouseover(String optionOnmouseover) {
        this.optionOnmouseover = optionOnmouseover;
    }

    public String getOptionOnmouseout() {
        return optionOnmouseout;
    }

    public void setOptionOnmouseout(String optionOnmouseout) {
        this.optionOnmouseout = optionOnmouseout;
    }

    public String getOptionTooltip() {
        return optionTooltip;
    }

    public void setOptionTooltip(String optionTooltip) {
        this.optionTooltip = optionTooltip;
    }

    public String getOptionAncho() {
        return optionAncho;
    }

    public void setOptionAncho(String optionAncho) {
        this.optionAncho = optionAncho;
    }

    public String getOptionLargo() {
        return optionLargo;
    }

    public void setOptionLargo(String optionLargo) {
        this.optionLargo = optionLargo;
    }

    public String getOptionForward() {
        return optionForward;
    }

    public void setOptionForward(String optionForward) {
        this.optionForward = optionForward;
    }

    public String getOptionAction() {
        return optionAction;
    }

    public void setOptionAction(String optionAction) {
        this.optionAction = optionAction;
    }

    public String getVisible() {
        return visible;
    }

    public void setVisible(String visible) {
        this.visible = visible;
    }

    public String getIsexception() {
        return isexception;
    }

    public void setIsexception(String isexception) {
        this.isexception = isexception;
    }

    public BigInteger getOptionOrden() {
        return optionOrden;
    }

    public void setOptionOrden(BigInteger optionOrden) {
        this.optionOrden = optionOrden;
    }

    @XmlTransient
    public List<SgrRoleCia> getSgrRoleCiaList() {
        return sgrRoleCiaList;
    }

    public void setSgrRoleCiaList(List<SgrRoleCia> sgrRoleCiaList) {
        this.sgrRoleCiaList = sgrRoleCiaList;
    }

    @XmlTransient
    public List<SgrSystemOption> getSgrSystemOptionList() {
        return sgrSystemOptionList;
    }

    public void setSgrSystemOptionList(List<SgrSystemOption> sgrSystemOptionList) {
        this.sgrSystemOptionList = sgrSystemOptionList;
    }

    public SgrSystemOption getSgrSystemOption() {
        return sgrSystemOption1;
    }

    public void setSgrSystemOption(SgrSystemOption sgrSystemOption) {
        this.sgrSystemOption1 = sgrSystemOption;
    }

    public SgrSistema getSgrSistema() {
        return sgrSistema;
    }

    public void setSgrSistema(SgrSistema sgrSistema) {
        this.sgrSistema = sgrSistema;
    }

    public SgrAuditLevel getAuditLevel() {
        return auditLevel;
    }

    public void setAuditLevel(SgrAuditLevel auditLevel) {
        this.auditLevel = auditLevel;
    }

    public SgrAppOptionsGroup getSgrAppOptionsGroup() {
        return sgrAppOptionsGroup;
    }

    public void setSgrAppOptionsGroup(SgrAppOptionsGroup sgrAppOptionsGroup) {
        this.sgrAppOptionsGroup = sgrAppOptionsGroup;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sgrSystemOptionPK != null ? sgrSystemOptionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof SgrSystemOption)) {
            return false;
        }
        SgrSystemOption other = (SgrSystemOption) object;
        if ((this.sgrSystemOptionPK == null && other.sgrSystemOptionPK != null) || (this.sgrSystemOptionPK != null && !this.sgrSystemOptionPK.equals(other.sgrSystemOptionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.SgrSystemOption[ sgrSystemOptionPK=" + sgrSystemOptionPK + " ]";
    }
    
}
