/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
 * @author Usuario
 */
@Entity
@Cacheable(false)
@Table(name = "ENG_TASK_LIST_VIEW")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngTaskListView.findAll", query = "SELECT e FROM EngTaskListView e"),
    @NamedQuery(name = "EngTaskListView.findByEsr", query = "SELECT e FROM EngTaskListView e WHERE e.esr = :esr"),
    @NamedQuery(name = "EngTaskListView.findByCheckid", query = "SELECT e FROM EngTaskListView e WHERE e.checkid = :checkid"),
    @NamedQuery(name = "EngTaskListView.findByWoorder", query = "SELECT e FROM EngTaskListView e WHERE e.woorder = :woorder"),
    @NamedQuery(name = "EngTaskListView.findByCompany", query = "SELECT e FROM EngTaskListView e WHERE e.company = :company"),
    @NamedQuery(name = "EngTaskListView.findByReqFechaIns", query = "SELECT e FROM EngTaskListView e WHERE e.reqFechaIns = :reqFechaIns"),
    @NamedQuery(name = "EngTaskListView.findByReqProbdesc", query = "SELECT e FROM EngTaskListView e WHERE e.reqProbdesc = :reqProbdesc"),
    @NamedQuery(name = "EngTaskListView.findByReqCustomer", query = "SELECT e FROM EngTaskListView e WHERE e.reqCustomer = :reqCustomer"),
    @NamedQuery(name = "EngTaskListView.findByReqRegistry", query = "SELECT e FROM EngTaskListView e WHERE e.reqRegistry = :reqRegistry"),
    @NamedQuery(name = "EngTaskListView.findByUsrCoduser", query = "SELECT e FROM EngTaskListView e WHERE e.usrCoduser = :usrCoduser"),
    @NamedQuery(name = "EngTaskListView.findByReqStatus", query = "SELECT e FROM EngTaskListView e WHERE e.reqStatus = :reqStatus"),
    @NamedQuery(name = "EngTaskListView.findByFullUserName", query = "SELECT e FROM EngTaskListView e WHERE e.fullUserName = :fullUserName"),
    @NamedQuery(name = "EngTaskListView.findByFlota", query = "SELECT e FROM EngTaskListView e WHERE e.flota = :flota"),
    @NamedQuery(name = "EngTaskListView.findByReqUsrIns", query = "SELECT e FROM EngTaskListView e WHERE e.reqUsrIns = :reqUsrIns"),
    @NamedQuery(name = "EngTaskListView.findByTieneHijos", query = "SELECT e FROM EngTaskListView e WHERE e.tieneHijos = :tieneHijos"),
    @NamedQuery(name = "EngTaskListView.findByWorkorder", query = "SELECT e FROM EngTaskListView e WHERE e.workorder = :workorder"),
    @NamedQuery(name = "EngTaskListView.findByreqJobcard", query = "SELECT e FROM EngTaskListView e WHERE e.reqJobcard = :reqJobcard")})
public class EngTaskListView implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESR")
    private BigInteger esr;
    @Column(name = "CHECKID")
    private BigDecimal checkid;
    
    @Size(max = 178)
    @Column(name = "WOORDER")
    private String woorder;
    @Size(max = 50)
    @Column(name = "COMPANY")
    private String company;
    @Column(name = "REQ_FECHA_INS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reqFechaIns;
    @Size(max = 4000)
    @Column(name = "REQ_PROBDESC")
    private String reqProbdesc;
    @Size(max = 20)
    @Column(name = "REQ_CUSTOMER")
    private String reqCustomer;
    @Size(max = 20)
    @Column(name = "REQ_REGISTRY")
    private String reqRegistry;
    @Size(max = 30)
    @Column(name = "USR_CODUSER")
    private String usrCoduser;
    @Size(max = 3)
    @Column(name = "REQ_STATUS")
    private String reqStatus;
    @Size(max = 255)
    @Column(name = "FULL_USER_NAME")
    private String fullUserName;
    @Size(max = 20)
    @Column(name = "FLOTA")
    private String flota;
    @Size(max = 30)
    @Column(name = "REQ_USR_INS")
    private String reqUsrIns;
    @Column(name = "TIENE_HIJOS")
    private BigInteger tieneHijos;
    @Size(max = 50)
    @Column(name = "WORKORDER")
    private String workorder;//anadido por cambio en la forma que se muestra el inicio del manager
    @Size(max = 4000)
    @Column(name = "REQ_JOBCARD")
    private String reqJobcard;
    

    public EngTaskListView() {
        super();
    }

    public BigInteger getEsr() {
        return esr;
    }

    public void setEsr(BigInteger esr) {
        this.esr = esr;
    }

    public String getWoorder() {
        return woorder;
    }

    public void setWoorder(String woorder) {
        this.woorder = woorder;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Date getReqFechaIns() {
        return reqFechaIns;
    }

    public void setReqFechaIns(Date reqFechaIns) {
        this.reqFechaIns = reqFechaIns;
    }

    public String getReqProbdesc() {
        return reqProbdesc;
    }

    public void setReqProbdesc(String reqProbdesc) {
        this.reqProbdesc = reqProbdesc;
    }

    public String getReqCustomer() {
        return reqCustomer;
    }

    public void setReqCustomer(String reqCustomer) {
        this.reqCustomer = reqCustomer;
    }

    public String getReqRegistry() {
        return reqRegistry;
    }

    public void setReqRegistry(String reqRegistry) {
        this.reqRegistry = reqRegistry;
    }

    public String getUsrCoduser() {
        return usrCoduser;
    }

    public void setUsrCoduser(String usrCoduser) {
        this.usrCoduser = usrCoduser;
    }

    public String getReqStatus() {
        return reqStatus;
    }

    public void setReqStatus(String reqStatus) {
        this.reqStatus = reqStatus;
    }

    public String getFullUserName() {
        return fullUserName;
    }

    public void setFullUserName(String fullUserName) {
        this.fullUserName = fullUserName;
    }

    public String getFlota() {
        return flota;
    }

    public void setFlota(String flota) {
        this.flota = flota;
    }

    public String getReqUsrIns() {
        return reqUsrIns;
    }

    public void setReqUsrIns(String reqUsrIns) {
        this.reqUsrIns = reqUsrIns;
    }

    public BigInteger getTieneHijos() {
        return tieneHijos;
    }

    public void setTieneHijos(BigInteger tieneHijos) {
        this.tieneHijos = tieneHijos;
    }

    public String getWorkorder() {
        return workorder;
    }

    public void setWorkorder(String workorder) {
        this.workorder = workorder;
    }

    public String getReqJobcard() {
        return reqJobcard;
    }

    public void setReqJobcard(String reqJobcard) {
        this.reqJobcard = reqJobcard;
    }

    public BigDecimal getCheckid() {
        return checkid;
    }

    public void setCheckid(BigDecimal checkid) {
        this.checkid = checkid;
    }
    
    
}
