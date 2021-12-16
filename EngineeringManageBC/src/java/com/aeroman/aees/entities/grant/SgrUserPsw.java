/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities.grant;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
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
@Table(name = "SGR_USER_PSW", catalog = "", schema = "PROCESOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SgrUserPsw.findAll", query = "SELECT s FROM SgrUserPsw s"),
    @NamedQuery(name = "SgrUserPsw.findByUserId", query = "SELECT s FROM SgrUserPsw s WHERE s.userId = :userId"),
    @NamedQuery(name = "SgrUserPsw.findByDefinitionDate", query = "SELECT s FROM SgrUserPsw s WHERE s.definitionDate = :definitionDate"),
    @NamedQuery(name = "SgrUserPsw.findByPws", query = "SELECT s FROM SgrUserPsw s WHERE s.pws = :pws"),
    @NamedQuery(name = "SgrUserPsw.findByStatus", query = "SELECT s FROM SgrUserPsw s WHERE s.status = :status")})
public class SgrUserPsw implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "USER_ID")
    private BigDecimal userId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DEFINITION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date definitionDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PWS")
    private String pws;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "STATUS")
    private String status;
    @JoinColumn(name = "USER_CREA_MOD", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private SgrUser userCreaMod;
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private SgrUser sgrUser;

    public SgrUserPsw() {
        super();
    }

    public SgrUserPsw(BigDecimal userId) {
        this.userId = userId;
    }

    public SgrUserPsw(BigDecimal userId, Date definitionDate, String pws, String status) {
        this.userId = userId;
        this.definitionDate = definitionDate;
        this.pws = pws;
        this.status = status;
    }

    public BigDecimal getUserId() {
        return userId;
    }

    public void setUserId(BigDecimal userId) {
        this.userId = userId;
    }

    public Date getDefinitionDate() {
        return definitionDate;
    }

    public void setDefinitionDate(Date definitionDate) {
        this.definitionDate = definitionDate;
    }

    public String getPws() {
        return pws;
    }

    public void setPws(String pws) {
        this.pws = pws;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public SgrUser getUserCreaMod() {
        return userCreaMod;
    }

    public void setUserCreaMod(SgrUser userCreaMod) {
        this.userCreaMod = userCreaMod;
    }

    public SgrUser getSgrUser() {
        return sgrUser;
    }

    public void setSgrUser(SgrUser sgrUser) {
        this.sgrUser = sgrUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof SgrUserPsw)) {
            return false;
        }
        SgrUserPsw other = (SgrUserPsw) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.SgrUserPsw[ userId=" + userId + " ]";
    }
    
}
