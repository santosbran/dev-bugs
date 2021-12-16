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
 * @author Usuario
 */
@Entity
@Cacheable(false)
@Table(name = "CORE_USERS_VW")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoreUsersVw.findAll", query = "SELECT c FROM CoreUsersVw c"),
    @NamedQuery(name = "CoreUsersVw.findByUsrCodusr", query = "SELECT c FROM CoreUsersVw c WHERE c.usrCodusr = :usrCodusr"),
    @NamedQuery(name = "CoreUsersVw.findByUsrName", query = "SELECT c FROM CoreUsersVw c WHERE c.usrName = :usrName"),
    @NamedQuery(name = "CoreUsersVw.findByUsrSuperuser", query = "SELECT c FROM CoreUsersVw c WHERE c.usrSuperuser = :usrSuperuser"),
    @NamedQuery(name = "CoreUsersVw.findByUsrEmail", query = "SELECT c FROM CoreUsersVw c WHERE c.usrEmail = :usrEmail"),
    @NamedQuery(name = "CoreUsersVw.findByUsrInitials", query = "SELECT c FROM CoreUsersVw c WHERE c.usrInitials = :usrInitials"),
    @NamedQuery(name = "CoreUsersVw.findByUsrTelefono1", query = "SELECT c FROM CoreUsersVw c WHERE c.usrTelefono1 = :usrTelefono1"),
    @NamedQuery(name = "CoreUsersVw.findByUsrFax1", query = "SELECT c FROM CoreUsersVw c WHERE c.usrFax1 = :usrFax1"),
    @NamedQuery(name = "CoreUsersVw.findByDptCod", query = "SELECT c FROM CoreUsersVw c WHERE c.dptCod = :dptCod"),
    @NamedQuery(name = "CoreUsersVw.findBySklCod", query = "SELECT c FROM CoreUsersVw c WHERE c.sklCod = :sklCod"),
    @NamedQuery(name = "CoreUsersVw.findByUsrPosition", query = "SELECT c FROM CoreUsersVw c WHERE c.usrPosition = :usrPosition"),
    @NamedQuery(name = "CoreUsersVw.findByUsrMobile", query = "SELECT c FROM CoreUsersVw c WHERE c.usrMobile = :usrMobile"),
    @NamedQuery(name = "CoreUsersVw.findByUsrPassword1", query = "SELECT c FROM CoreUsersVw c WHERE c.usrPassword1 = :usrPassword1"),
    @NamedQuery(name = "CoreUsersVw.findByUsrCompany", query = "SELECT c FROM CoreUsersVw c WHERE c.usrCompany = :usrCompany"),
    @NamedQuery(name = "CoreUsersVw.findByUsrType", query = "SELECT c FROM CoreUsersVw c WHERE c.usrType = :usrType"),
    @NamedQuery(name = "CoreUsersVw.findByUsrCodRol", query = "SELECT c FROM CoreUsersVw c WHERE c.usrCodRol = :usrCodRol"),
    @NamedQuery(name = "CoreUsersVw.findByUsrFirstEnter", query = "SELECT c FROM CoreUsersVw c WHERE c.usrFirstEnter = :usrFirstEnter"),
    @NamedQuery(name = "CoreUsersVw.findByUsrPassword", query = "SELECT c FROM CoreUsersVw c WHERE c.usrPassword = :usrPassword"),
    @NamedQuery(name = "CoreUsersVw.findByUsrCodAux", query = "SELECT c FROM CoreUsersVw c WHERE c.usrCodAux = :usrCodAux"),
    @NamedQuery(name = "CoreUsersVw.findByTotalactividades", query = "SELECT c FROM CoreUsersVw c WHERE c.totalactividades = :totalactividades"),
    @NamedQuery(name = "CoreUsersVw.findByFltCod", query = "SELECT c FROM CoreUsersVw c WHERE c.fltCod = :fltCod")})
public class CoreUsersVw implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "USR_CODUSR")
    private String usrCodusr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "USR_NAME")
    private String usrName;
    @Size(max = 1)
    @Column(name = "USR_SUPERUSER")
    private String usrSuperuser;
    @Size(max = 200)
    @Column(name = "USR_EMAIL")
    private String usrEmail;
    @Size(max = 3)
    @Column(name = "USR_INITIALS")
    private String usrInitials;
    @Size(max = 200)
    @Column(name = "USR_TELEFONO1")
    private String usrTelefono1;
    @Size(max = 200)
    @Column(name = "USR_FAX1")
    private String usrFax1;
    @Column(name = "DPT_COD")
    private Short dptCod;
    @Column(name = "SKL_COD")
    private Short sklCod;
    @Size(max = 50)
    @Column(name = "USR_POSITION")
    private String usrPosition;
    @Size(max = 20)
    @Column(name = "USR_MOBILE")
    private String usrMobile;
    @Size(max = 50)
    @Column(name = "USR_PASSWORD_1")
    private String usrPassword1;
    @Size(max = 50)
    @Column(name = "USR_COMPANY")
    private String usrCompany;
    @Size(max = 2)
    @Column(name = "USR_TYPE")
    private String usrType;
    @Size(max = 2)
    @Column(name = "USR_COD_ROL")
    private String usrCodRol;
    @Size(max = 1)
    @Column(name = "USR_FIRST_ENTER")
    private String usrFirstEnter;
    @Size(max = 60)
    @Column(name = "USR_PASSWORD")
    private String usrPassword;
    @Size(max = 30)
    @Column(name = "USR_COD_AUX")
    private String usrCodAux;
    @Column(name = "TOTALACTIVIDADES")
    private BigInteger totalactividades;
    @Size(max = 20)
    @Column(name = "FLT_COD")
    private String fltCod;

    public CoreUsersVw() {
        super();
    }

    public String getUsrCodusr() {
        return usrCodusr;
    }

    public void setUsrCodusr(String usrCodusr) {
        this.usrCodusr = usrCodusr;
    }

    public String getUsrName() {
        return usrName;
    }

    public void setUsrName(String usrName) {
        this.usrName = usrName;
    }

    public String getUsrSuperuser() {
        return usrSuperuser;
    }

    public void setUsrSuperuser(String usrSuperuser) {
        this.usrSuperuser = usrSuperuser;
    }

    public String getUsrEmail() {
        return usrEmail;
    }

    public void setUsrEmail(String usrEmail) {
        this.usrEmail = usrEmail;
    }

    public String getUsrInitials() {
        return usrInitials;
    }

    public void setUsrInitials(String usrInitials) {
        this.usrInitials = usrInitials;
    }

    public String getUsrTelefono1() {
        return usrTelefono1;
    }

    public void setUsrTelefono1(String usrTelefono1) {
        this.usrTelefono1 = usrTelefono1;
    }

    public String getUsrFax1() {
        return usrFax1;
    }

    public void setUsrFax1(String usrFax1) {
        this.usrFax1 = usrFax1;
    }

    public Short getDptCod() {
        return dptCod;
    }

    public void setDptCod(Short dptCod) {
        this.dptCod = dptCod;
    }

    public Short getSklCod() {
        return sklCod;
    }

    public void setSklCod(Short sklCod) {
        this.sklCod = sklCod;
    }

    public String getUsrPosition() {
        return usrPosition;
    }

    public void setUsrPosition(String usrPosition) {
        this.usrPosition = usrPosition;
    }

    public String getUsrMobile() {
        return usrMobile;
    }

    public void setUsrMobile(String usrMobile) {
        this.usrMobile = usrMobile;
    }

    public String getUsrPassword1() {
        return usrPassword1;
    }

    public void setUsrPassword1(String usrPassword1) {
        this.usrPassword1 = usrPassword1;
    }

    public String getUsrCompany() {
        return usrCompany;
    }

    public void setUsrCompany(String usrCompany) {
        this.usrCompany = usrCompany;
    }

    public String getUsrType() {
        return usrType;
    }

    public void setUsrType(String usrType) {
        this.usrType = usrType;
    }

    public String getUsrCodRol() {
        return usrCodRol;
    }

    public void setUsrCodRol(String usrCodRol) {
        this.usrCodRol = usrCodRol;
    }

    public String getUsrFirstEnter() {
        return usrFirstEnter;
    }

    public void setUsrFirstEnter(String usrFirstEnter) {
        this.usrFirstEnter = usrFirstEnter;
    }

    public String getUsrPassword() {
        return usrPassword;
    }

    public void setUsrPassword(String usrPassword) {
        this.usrPassword = usrPassword;
    }

    public String getUsrCodAux() {
        return usrCodAux;
    }

    public void setUsrCodAux(String usrCodAux) {
        this.usrCodAux = usrCodAux;
    }

    public BigInteger getTotalactividades() {
        return totalactividades;
    }

    public void setTotalactividades(BigInteger totalactividades) {
        this.totalactividades = totalactividades;
    }

    public String getFltCod() {
        return fltCod;
    }

    public void setFltCod(String fltCod) {
        this.fltCod = fltCod;
    }
    
}
