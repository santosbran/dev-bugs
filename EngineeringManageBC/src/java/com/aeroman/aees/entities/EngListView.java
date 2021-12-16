/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities;

import java.io.Serializable;
import java.math.BigInteger;
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
 * @author ssibrian
 */
@Entity
@Cacheable(false)
@Table(name = "ENG_LIST_VIEW")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngListView.findAll", query = "SELECT e FROM EngListView e"),
    @NamedQuery(name = "EngListView.findByRowId", query = "SELECT e FROM EngListView e WHERE e.rowId = :rowId"),
    @NamedQuery(name = "EngListView.findByRoleCode", query = "SELECT e FROM EngListView e WHERE e.roleCode = :roleCode"),
    @NamedQuery(name = "EngListView.findByCiaCode", query = "SELECT e FROM EngListView e WHERE e.ciaCode = :ciaCode"),
    @NamedQuery(name = "EngListView.findByFullUserName", query = "SELECT e FROM EngListView e WHERE e.fullUserName = :fullUserName"),
    @NamedQuery(name = "EngListView.findByCodigo86", query = "SELECT e FROM EngListView e WHERE e.codigo86 = :codigo86"),
    @NamedQuery(name = "EngListView.findByUserType", query = "SELECT e FROM EngListView e WHERE e.userType = :userType"),
    @NamedQuery(name = "EngListView.findByPuesto", query = "SELECT e FROM EngListView e WHERE e.puesto = :puesto"),
    @NamedQuery(name = "EngListView.findByDgeCodcgr", query = "SELECT e FROM EngListView e WHERE e.dgeCodcgr = :dgeCodcgr"),
    @NamedQuery(name = "EngListView.findBySkill", query = "SELECT e FROM EngListView e WHERE e.skill = :skill")})
public class EngListView implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ROW_ID")
    private BigInteger rowId;
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
    @Size(max = 20)
    @Column(name = "PRIMER_APELLIDO")
    private String primerApellido;
    @Size(max = 20)
    @Column(name = "SEGUNDO_APELLIDO")
    private String segundoApellido;
    @Size(max = 20)
    @Column(name = "PRIMER_NOMBRE")
    private String primerNombre;
    @Size(max = 20)
    @Column(name = "SEGUNDO_NOMBRE")
    private String segundoNombre;

    public EngListView() {
        super();
    }

    public BigInteger getRowId() {
        return rowId;
    }

    public void setRowId(BigInteger rowId) {
        this.rowId = rowId;
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

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }
    
}
