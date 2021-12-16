/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * @author APLICATIVA_01
 */
@Entity
@Cacheable(false)
@Table(name = "ENG_HCHECK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngHcheck.findAll", query = "SELECT e FROM EngHcheck e"),
    @NamedQuery(name = "EngHcheck.findByCheckid", query = "SELECT e FROM EngHcheck e WHERE e.checkid = :checkid"),
    @NamedQuery(name = "EngHcheck.findByModel", query = "SELECT e FROM EngHcheck e WHERE e.model = :model"),
    @NamedQuery(name = "EngHcheck.findByRegistry", query = "SELECT e FROM EngHcheck e WHERE e.registry = :registry"),
    @NamedQuery(name = "EngHcheck.findByStartdate", query = "SELECT e FROM EngHcheck e WHERE e.startdate = :startdate"),
    @NamedQuery(name = "EngHcheck.findByFinishdate", query = "SELECT e FROM EngHcheck e WHERE e.finishdate = :finishdate"),
    @NamedQuery(name = "EngHcheck.findByTtsn", query = "SELECT e FROM EngHcheck e WHERE e.ttsn = :ttsn"),
    @NamedQuery(name = "EngHcheck.findByTcsn", query = "SELECT e FROM EngHcheck e WHERE e.tcsn = :tcsn"),
    @NamedQuery(name = "EngHcheck.findByVn", query = "SELECT e FROM EngHcheck e WHERE e.vn = :vn"),
    @NamedQuery(name = "EngHcheck.findByLn", query = "SELECT e FROM EngHcheck e WHERE e.ln = :ln"),
    @NamedQuery(name = "EngHcheck.findBySn", query = "SELECT e FROM EngHcheck e WHERE e.sn = :sn"),
    @NamedQuery(name = "EngHcheck.findByBn", query = "SELECT e FROM EngHcheck e WHERE e.bn = :bn"),
    @NamedQuery(name = "EngHcheck.findByChecktype", query = "SELECT e FROM EngHcheck e WHERE e.checktype = :checktype"),
    @NamedQuery(name = "EngHcheck.findByUserc", query = "SELECT e FROM EngHcheck e WHERE e.userc = :userc"),
    @NamedQuery(name = "EngHcheck.findByClosed", query = "SELECT e FROM EngHcheck e WHERE e.closed = :closed"),
    @NamedQuery(name = "EngHcheck.findByCorrtype", query = "SELECT e FROM EngHcheck e WHERE e.corrtype = :corrtype"),
    @NamedQuery(name = "EngHcheck.findByHchecktype", query = "SELECT e FROM EngHcheck e WHERE e.hchecktype = :hchecktype"),
    @NamedQuery(name = "EngHcheck.findByDhistorica", query = "SELECT e FROM EngHcheck e WHERE e.dhistorica = :dhistorica"),
    @NamedQuery(name = "EngHcheck.findByWo", query = "SELECT e FROM EngHcheck e WHERE e.wo = :wo"),
    @NamedQuery(name = "EngHcheck.findByArrivaldate", query = "SELECT e FROM EngHcheck e WHERE e.arrivaldate = :arrivaldate"),
    @NamedQuery(name = "EngHcheck.findByGroundtime", query = "SELECT e FROM EngHcheck e WHERE e.groundtime = :groundtime"),
    @NamedQuery(name = "EngHcheck.findByHangmanrespon", query = "SELECT e FROM EngHcheck e WHERE e.hangmanrespon = :hangmanrespon"),
    @NamedQuery(name = "EngHcheck.findByHangrespon", query = "SELECT e FROM EngHcheck e WHERE e.hangrespon = :hangrespon"),
    @NamedQuery(name = "EngHcheck.findByCommrespon", query = "SELECT e FROM EngHcheck e WHERE e.commrespon = :commrespon"),
    @NamedQuery(name = "EngHcheck.findByProdcontrespon", query = "SELECT e FROM EngHcheck e WHERE e.prodcontrespon = :prodcontrespon"),
    @NamedQuery(name = "EngHcheck.findByWarehrespon", query = "SELECT e FROM EngHcheck e WHERE e.warehrespon = :warehrespon"),
    @NamedQuery(name = "EngHcheck.findByShopsrespon", query = "SELECT e FROM EngHcheck e WHERE e.shopsrespon = :shopsrespon"),
    @NamedQuery(name = "EngHcheck.findByPurchrespon", query = "SELECT e FROM EngHcheck e WHERE e.purchrespon = :purchrespon"),
    @NamedQuery(name = "EngHcheck.findByPlannrespon", query = "SELECT e FROM EngHcheck e WHERE e.plannrespon = :plannrespon"),
    @NamedQuery(name = "EngHcheck.findByEnginrespon", query = "SELECT e FROM EngHcheck e WHERE e.enginrespon = :enginrespon"),
    @NamedQuery(name = "EngHcheck.findByPowplantrespon", query = "SELECT e FROM EngHcheck e WHERE e.powplantrespon = :powplantrespon"),
    @NamedQuery(name = "EngHcheck.findByQarespon", query = "SELECT e FROM EngHcheck e WHERE e.qarespon = :qarespon"),
    @NamedQuery(name = "EngHcheck.findByQcrespon", query = "SELECT e FROM EngHcheck e WHERE e.qcrespon = :qcrespon"),
    @NamedQuery(name = "EngHcheck.findByMsn", query = "SELECT e FROM EngHcheck e WHERE e.msn = :msn"),
    @NamedQuery(name = "EngHcheck.findByYear", query = "SELECT e FROM EngHcheck e WHERE e.year = :year"),
    @NamedQuery(name = "EngHcheck.findByEngManHrs", query = "SELECT e FROM EngHcheck e WHERE e.engManHrs = :engManHrs"),
    @NamedQuery(name = "EngHcheck.findByIdengact", query = "SELECT e FROM EngHcheck e WHERE e.idengact = :idengact"),
    @NamedQuery(name = "EngHcheck.findByClosedEng", query = "SELECT e FROM EngHcheck e WHERE e.closedEng = :closedEng"),
    @NamedQuery(name = "EngHcheck.findByDescription", query = "SELECT e FROM EngHcheck e WHERE e.description = :description"),
    @NamedQuery(name = "EngHcheck.findByUsrIns", query = "SELECT e FROM EngHcheck e WHERE e.usrIns = :usrIns"),
    @NamedQuery(name = "EngHcheck.findByFechaIns", query = "SELECT e FROM EngHcheck e WHERE e.fechaIns = :fechaIns"),
    @NamedQuery(name = "EngHcheck.findByUsrAct", query = "SELECT e FROM EngHcheck e WHERE e.usrAct = :usrAct"),
    @NamedQuery(name = "EngHcheck.findByFechaAct", query = "SELECT e FROM EngHcheck e WHERE e.fechaAct = :fechaAct"),
    @NamedQuery(name = "EngHcheck.findByWoYear", query = "SELECT e FROM EngHcheck e WHERE e.woYear = :woYear"),
    @NamedQuery(name = "EngHcheck.findByWoCorr", query = "SELECT e FROM EngHcheck e WHERE e.woCorr = :woCorr"),
    @NamedQuery(name = "EngHcheck.findByWoItem", query = "SELECT e FROM EngHcheck e WHERE e.woItem = :woItem")})
public class EngHcheck implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CHECKID")
    private Short checkid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "MODEL")
    private String model;
    @Size(max = 20)
    @Column(name = "REGISTRY")
    private String registry;
    @Column(name = "STARTDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startdate;
    @Column(name = "FINISHDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date finishdate;
    @Column(name = "TTSN")
    private Integer ttsn;
    @Column(name = "TCSN")
    private Integer tcsn;
    @Size(max = 22)
    @Column(name = "VN")
    private String vn;
    @Size(max = 22)
    @Column(name = "LN")
    private String ln;
    @Size(max = 22)
    @Column(name = "SN")
    private String sn;
    @Size(max = 22)
    @Column(name = "BN")
    private String bn;
    @Size(max = 50)
    @Column(name = "CHECKTYPE")
    private String checktype;
    @Size(max = 100)
    @Column(name = "USERC")
    private String userc;
    @Size(max = 1)
    @Column(name = "CLOSED")
    private String closed;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CORRTYPE")
    private short corrtype;
    @Size(max = 50)
    @Column(name = "HCHECKTYPE")
    private String hchecktype;
    @Size(max = 1)
    @Column(name = "DHISTORICA")
    private String dhistorica;
    @Size(max = 50)
    @Column(name = "WO")
    private String wo;
    @Column(name = "ARRIVALDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date arrivaldate;
    @Size(max = 20)
    @Column(name = "GROUNDTIME")
    private String groundtime;
    @Size(max = 30)
    @Column(name = "HANGMANRESPON")
    private String hangmanrespon;
    @Size(max = 30)
    @Column(name = "HANGRESPON")
    private String hangrespon;
    @Size(max = 30)
    @Column(name = "COMMRESPON")
    private String commrespon;
    @Size(max = 30)
    @Column(name = "PRODCONTRESPON")
    private String prodcontrespon;
    @Size(max = 30)
    @Column(name = "WAREHRESPON")
    private String warehrespon;
    @Size(max = 30)
    @Column(name = "SHOPSRESPON")
    private String shopsrespon;
    @Size(max = 30)
    @Column(name = "PURCHRESPON")
    private String purchrespon;
    @Size(max = 30)
    @Column(name = "PLANNRESPON")
    private String plannrespon;
    @Size(max = 30)
    @Column(name = "ENGINRESPON")
    private String enginrespon;
    @Size(max = 30)
    @Column(name = "POWPLANTRESPON")
    private String powplantrespon;
    @Size(max = 30)
    @Column(name = "QARESPON")
    private String qarespon;
    @Size(max = 30)
    @Column(name = "QCRESPON")
    private String qcrespon;
    @Size(max = 22)
    @Column(name = "MSN")
    private String msn;
    @Size(max = 4)
    @Column(name = "YEAR")
    private String year;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ENG_MAN_HRS")
    private BigDecimal engManHrs;
    @Column(name = "IDENGACT")
    private Short idengact;
    @Size(max = 1)
    @Column(name = "CLOSED_ENG")
    private String closedEng;
    @Size(max = 20)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 30)
    @Column(name = "USR_INS")
    private String usrIns;
    @Column(name = "FECHA_INS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIns;
    @Size(max = 30)
    @Column(name = "USR_ACT")
    private String usrAct;
    @Column(name = "FECHA_ACT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAct;
    @Column(name = "WO_YEAR")
    private Short woYear;
    @Column(name = "WO_CORR")
    private Integer woCorr;
    @Column(name = "WO_ITEM")
    private Short woItem;

    public EngHcheck() {
        super();
    }

    public EngHcheck(Short checkid) {
        this.checkid = checkid;
    }

    public EngHcheck(Short checkid, String model, short corrtype) {
        this.checkid = checkid;
        this.model = model;
        this.corrtype = corrtype;
    }

    public Short getCheckid() {
        return checkid;
    }

    public void setCheckid(Short checkid) {
        this.checkid = checkid;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegistry() {
        return registry;
    }

    public void setRegistry(String registry) {
        this.registry = registry;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getFinishdate() {
        return finishdate;
    }

    public void setFinishdate(Date finishdate) {
        this.finishdate = finishdate;
    }

    public Integer getTtsn() {
        return ttsn;
    }

    public void setTtsn(Integer ttsn) {
        this.ttsn = ttsn;
    }

    public Integer getTcsn() {
        return tcsn;
    }

    public void setTcsn(Integer tcsn) {
        this.tcsn = tcsn;
    }

    public String getVn() {
        return vn;
    }

    public void setVn(String vn) {
        this.vn = vn;
    }

    public String getLn() {
        return ln;
    }

    public void setLn(String ln) {
        this.ln = ln;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getBn() {
        return bn;
    }

    public void setBn(String bn) {
        this.bn = bn;
    }

    public String getChecktype() {
        return checktype;
    }

    public void setChecktype(String checktype) {
        this.checktype = checktype;
    }

    public String getUserc() {
        return userc;
    }

    public void setUserc(String userc) {
        this.userc = userc;
    }

    public String getClosed() {
        return closed;
    }

    public void setClosed(String closed) {
        this.closed = closed;
    }

    public short getCorrtype() {
        return corrtype;
    }

    public void setCorrtype(short corrtype) {
        this.corrtype = corrtype;
    }

    public String getHchecktype() {
        return hchecktype;
    }

    public void setHchecktype(String hchecktype) {
        this.hchecktype = hchecktype;
    }

    public String getDhistorica() {
        return dhistorica;
    }

    public void setDhistorica(String dhistorica) {
        this.dhistorica = dhistorica;
    }

    public String getWo() {
        return wo;
    }

    public void setWo(String wo) {
        this.wo = wo;
    }

    public Date getArrivaldate() {
        return arrivaldate;
    }

    public void setArrivaldate(Date arrivaldate) {
        this.arrivaldate = arrivaldate;
    }

    public String getGroundtime() {
        return groundtime;
    }

    public void setGroundtime(String groundtime) {
        this.groundtime = groundtime;
    }

    public String getHangmanrespon() {
        return hangmanrespon;
    }

    public void setHangmanrespon(String hangmanrespon) {
        this.hangmanrespon = hangmanrespon;
    }

    public String getHangrespon() {
        return hangrespon;
    }

    public void setHangrespon(String hangrespon) {
        this.hangrespon = hangrespon;
    }

    public String getCommrespon() {
        return commrespon;
    }

    public void setCommrespon(String commrespon) {
        this.commrespon = commrespon;
    }

    public String getProdcontrespon() {
        return prodcontrespon;
    }

    public void setProdcontrespon(String prodcontrespon) {
        this.prodcontrespon = prodcontrespon;
    }

    public String getWarehrespon() {
        return warehrespon;
    }

    public void setWarehrespon(String warehrespon) {
        this.warehrespon = warehrespon;
    }

    public String getShopsrespon() {
        return shopsrespon;
    }

    public void setShopsrespon(String shopsrespon) {
        this.shopsrespon = shopsrespon;
    }

    public String getPurchrespon() {
        return purchrespon;
    }

    public void setPurchrespon(String purchrespon) {
        this.purchrespon = purchrespon;
    }

    public String getPlannrespon() {
        return plannrespon;
    }

    public void setPlannrespon(String plannrespon) {
        this.plannrespon = plannrespon;
    }

    public String getEnginrespon() {
        return enginrespon;
    }

    public void setEnginrespon(String enginrespon) {
        this.enginrespon = enginrespon;
    }

    public String getPowplantrespon() {
        return powplantrespon;
    }

    public void setPowplantrespon(String powplantrespon) {
        this.powplantrespon = powplantrespon;
    }

    public String getQarespon() {
        return qarespon;
    }

    public void setQarespon(String qarespon) {
        this.qarespon = qarespon;
    }

    public String getQcrespon() {
        return qcrespon;
    }

    public void setQcrespon(String qcrespon) {
        this.qcrespon = qcrespon;
    }

    public String getMsn() {
        return msn;
    }

    public void setMsn(String msn) {
        this.msn = msn;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public BigDecimal getEngManHrs() {
        return engManHrs;
    }

    public void setEngManHrs(BigDecimal engManHrs) {
        this.engManHrs = engManHrs;
    }

    public Short getIdengact() {
        return idengact;
    }

    public void setIdengact(Short idengact) {
        this.idengact = idengact;
    }

    public String getClosedEng() {
        return closedEng;
    }

    public void setClosedEng(String closedEng) {
        this.closedEng = closedEng;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUsrIns() {
        return usrIns;
    }

    public void setUsrIns(String usrIns) {
        this.usrIns = usrIns;
    }

    public Date getFechaIns() {
        return fechaIns;
    }

    public void setFechaIns(Date fechaIns) {
        this.fechaIns = fechaIns;
    }

    public String getUsrAct() {
        return usrAct;
    }

    public void setUsrAct(String usrAct) {
        this.usrAct = usrAct;
    }

    public Date getFechaAct() {
        return fechaAct;
    }

    public void setFechaAct(Date fechaAct) {
        this.fechaAct = fechaAct;
    }

    public Short getWoYear() {
        return woYear;
    }

    public void setWoYear(Short woYear) {
        this.woYear = woYear;
    }

    public Integer getWoCorr() {
        return woCorr;
    }

    public void setWoCorr(Integer woCorr) {
        this.woCorr = woCorr;
    }

    public Short getWoItem() {
        return woItem;
    }

    public void setWoItem(Short woItem) {
        this.woItem = woItem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (checkid != null ? checkid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EngHcheck)) {
            return false;
        }
        EngHcheck other = (EngHcheck) object;
        if ((this.checkid == null && other.checkid != null) || (this.checkid != null && !this.checkid.equals(other.checkid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngHcheck[ checkid=" + checkid + " ]";
    }
    
}