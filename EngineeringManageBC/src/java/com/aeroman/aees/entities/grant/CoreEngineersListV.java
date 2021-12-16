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
@Table(name = "CORE_ENGINEERS_LIST_V", catalog = "", schema = "CORE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoreEngineersListV.findAll", query = "SELECT c FROM CoreEngineersListV c"),
    @NamedQuery(name = "CoreEngineersListV.findByRoleCode", query = "SELECT c FROM CoreEngineersListV c WHERE c.roleCode = :roleCode"),
    @NamedQuery(name = "CoreEngineersListV.findByCiaCode", query = "SELECT c FROM CoreEngineersListV c WHERE c.ciaCode = :ciaCode"),
    @NamedQuery(name = "CoreEngineersListV.findByFullUserName", query = "SELECT c FROM CoreEngineersListV c WHERE c.fullUserName = :fullUserName"),
    @NamedQuery(name = "CoreEngineersListV.findByCodigo86", query = "SELECT c FROM CoreEngineersListV c WHERE c.codigo86 = :codigo86"),
    @NamedQuery(name = "CoreEngineersListV.findByUserType", query = "SELECT c FROM CoreEngineersListV c WHERE c.userType = :userType"),
    @NamedQuery(name = "CoreEngineersListV.findByPuesto", query = "SELECT c FROM CoreEngineersListV c WHERE c.puesto = :puesto"),
    @NamedQuery(name = "CoreEngineersListV.findByDgeCodcgr", query = "SELECT c FROM CoreEngineersListV c WHERE c.dgeCodcgr = :dgeCodcgr"),
    @NamedQuery(name = "CoreEngineersListV.findBySkill", query = "SELECT c FROM CoreEngineersListV c WHERE c.skill = :skill")})
public class CoreEngineersListV implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ROLE_CODE")
    private String roleCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "CIA_CODE")
    private String ciaCode;
    @Size(max = 255)
    @Column(name = "FULL_USER_NAME")
    private String fullUserName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CODIGO86")
    private String codigo86;
    @Size(max = 2)
    @Column(name = "USER_TYPE")
    private String userType;
    @Size(max = 80)
    @Column(name = "PUESTO")
    private String puesto;
    @Size(max = 2)
    @Column(name = "DGE_CODCGR")
    private String dgeCodcgr;
    @Size(max = 5)
    @Column(name = "SKILL")
    private String skill;

    public CoreEngineersListV() {
        super();
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getCiaCode() {
        return ciaCode;
    }

    public void setCiaCode(String ciaCode) {
        this.ciaCode = ciaCode;
    }

    public String getFullUserName() {
        return fullUserName;
    }

    public void setFullUserName(String fullUserName) {
        this.fullUserName = fullUserName;
    }

    public String getCodigo86() {
        return codigo86;
    }

    public void setCodigo86(String codigo86) {
        this.codigo86 = codigo86;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getDgeCodcgr() {
        return dgeCodcgr;
    }

    public void setDgeCodcgr(String dgeCodcgr) {
        this.dgeCodcgr = dgeCodcgr;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
    
}
