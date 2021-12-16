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
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "SGR_SISTEMA", catalog = "", schema = "PROCESOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SgrSistema.findAll", query = "SELECT s FROM SgrSistema s"),
    @NamedQuery(name = "SgrSistema.findBySystemid", query = "SELECT s FROM SgrSistema s WHERE s.systemid = :systemid"),
    @NamedQuery(name = "SgrSistema.findByStatus", query = "SELECT s FROM SgrSistema s WHERE s.status = :status"),
    @NamedQuery(name = "SgrSistema.findBySystemName", query = "SELECT s FROM SgrSistema s WHERE s.systemName = :systemName"),
    @NamedQuery(name = "SgrSistema.findByValidationType", query = "SELECT s FROM SgrSistema s WHERE s.validationType = :validationType"),
    @NamedQuery(name = "SgrSistema.findByTimeout", query = "SELECT s FROM SgrSistema s WHERE s.timeout = :timeout"),
    @NamedQuery(name = "SgrSistema.findBySecurityControl", query = "SELECT s FROM SgrSistema s WHERE s.securityControl = :securityControl"),
    @NamedQuery(name = "SgrSistema.findByContentpath", query = "SELECT s FROM SgrSistema s WHERE s.contentpath = :contentpath"),
    @NamedQuery(name = "SgrSistema.findByInitialaction", query = "SELECT s FROM SgrSistema s WHERE s.initialaction = :initialaction"),
    @NamedQuery(name = "SgrSistema.findByIsWl", query = "SELECT s FROM SgrSistema s WHERE s.isWl = :isWl"),
    @NamedQuery(name = "SgrSistema.findByPuerto", query = "SELECT s FROM SgrSistema s WHERE s.puerto = :puerto")})
public class SgrSistema implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sgrSistema")
    private List<SgrAppOptionsGroup> sgrAppOptionsGroupList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sgrSistema")
    private List<SgrSystemOption> sgrSystemOptionList;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SYSTEMID")
    private Long systemid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "STATUS")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "SYSTEM_NAME")
    private String systemName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "VALIDATION_TYPE")
    private String validationType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIMEOUT")
    private long timeout;
    @Size(max = 2)
    @Column(name = "SECURITY_CONTROL")
    private String securityControl;
    @Size(max = 20)
    @Column(name = "CONTENTPATH")
    private String contentpath;
    @Size(max = 100)
    @Column(name = "INITIALACTION")
    private String initialaction;
    @Size(max = 1)
    @Column(name = "IS_WL")
    private String isWl;
    @Size(max = 4)
    @Column(name = "PUERTO")
    private String puerto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sgrSistema")
    private List<SgrRole> sgrRoleList;
    @JoinColumn(name = "USER_ID_OWNER", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private SgrUser userIdOwner;

    public SgrSistema() {
        super();
    }

    public SgrSistema(Long systemid) {
        this.systemid = systemid;
    }

    public SgrSistema(Long systemid, String status, String systemName, String validationType, long timeout) {
        this.systemid = systemid;
        this.status = status;
        this.systemName = systemName;
        this.validationType = validationType;
        this.timeout = timeout;
    }

    public Long getSystemid() {
        return systemid;
    }

    public void setSystemid(Long systemid) {
        this.systemid = systemid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getValidationType() {
        return validationType;
    }

    public void setValidationType(String validationType) {
        this.validationType = validationType;
    }

    public long getTimeout() {
        return timeout;
    }

    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }

    public String getSecurityControl() {
        return securityControl;
    }

    public void setSecurityControl(String securityControl) {
        this.securityControl = securityControl;
    }

    public String getContentpath() {
        return contentpath;
    }

    public void setContentpath(String contentpath) {
        this.contentpath = contentpath;
    }

    public String getInitialaction() {
        return initialaction;
    }

    public void setInitialaction(String initialaction) {
        this.initialaction = initialaction;
    }

    public String getIsWl() {
        return isWl;
    }

    public void setIsWl(String isWl) {
        this.isWl = isWl;
    }

    public String getPuerto() {
        return puerto;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    @XmlTransient
    public List<SgrRole> getSgrRoleList() {
        return sgrRoleList;
    }

    public void setSgrRoleList(List<SgrRole> sgrRoleList) {
        this.sgrRoleList = sgrRoleList;
    }

    public SgrUser getUserIdOwner() {
        return userIdOwner;
    }

    public void setUserIdOwner(SgrUser userIdOwner) {
        this.userIdOwner = userIdOwner;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (systemid != null ? systemid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof SgrSistema)) {
            return false;
        }
        SgrSistema other = (SgrSistema) object;
        if ((this.systemid == null && other.systemid != null) || (this.systemid != null && !this.systemid.equals(other.systemid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.SgrSistema[ systemid=" + systemid + " ]";
    }

    @XmlTransient
    public List<SgrAppOptionsGroup> getSgrAppOptionsGroupList() {
        return sgrAppOptionsGroupList;
    }

    public void setSgrAppOptionsGroupList(List<SgrAppOptionsGroup> sgrAppOptionsGroupList) {
        this.sgrAppOptionsGroupList = sgrAppOptionsGroupList;
    }

    @XmlTransient
    public List<SgrSystemOption> getSgrSystemOptionList() {
        return sgrSystemOptionList;
    }

    public void setSgrSystemOptionList(List<SgrSystemOption> sgrSystemOptionList) {
        this.sgrSystemOptionList = sgrSystemOptionList;
    }
    
}
