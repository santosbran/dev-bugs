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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author mchacon
 */
@Entity
@Cacheable(false)
@Table(name = "ENG_REQUEST_DIMEN_MANUF")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngRequestDimenManuf.findAll", query = "SELECT e FROM EngRequestDimenManuf e")
    , @NamedQuery(name = "EngRequestDimenManuf.findByRedId", query = "SELECT e FROM EngRequestDimenManuf e WHERE e.redId = :redId")
    , @NamedQuery(name = "EngRequestDimenManuf.findByRedState", query = "SELECT e FROM EngRequestDimenManuf e WHERE e.redState = :redState")
    , @NamedQuery(name = "EngRequestDimenManuf.findByRedUserAdd", query = "SELECT e FROM EngRequestDimenManuf e WHERE e.redUserAdd = :redUserAdd")
    , @NamedQuery(name = "EngRequestDimenManuf.findByRedDateAdd", query = "SELECT e FROM EngRequestDimenManuf e WHERE e.redDateAdd = :redDateAdd")
    , @NamedQuery(name = "EngRequestDimenManuf.findByRedUserUpd", query = "SELECT e FROM EngRequestDimenManuf e WHERE e.redUserUpd = :redUserUpd")
    , @NamedQuery(name = "EngRequestDimenManuf.findByRedDateUpd", query = "SELECT e FROM EngRequestDimenManuf e WHERE e.redDateUpd = :redDateUpd")
    , @NamedQuery(name = "EngRequestDimenManuf.findByRedUserDlt", query = "SELECT e FROM EngRequestDimenManuf e WHERE e.redUserDlt = :redUserDlt")
    , @NamedQuery(name = "EngRequestDimenManuf.findByRedDateDlt", query = "SELECT e FROM EngRequestDimenManuf e WHERE e.redDateDlt = :redDateDlt")
    , @NamedQuery(name = "EngRequestDimenManuf.findByRedMeasure", query = "SELECT e FROM EngRequestDimenManuf e WHERE e.redMeasure = :redMeasure")
    , @NamedQuery(name = "EngRequestDimenManuf.findByRedOther", query = "SELECT e FROM EngRequestDimenManuf e WHERE e.redOther = :redOther")})

public class EngRequestDimenManuf  implements Serializable {
    
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Size(max = 250)   
    @Column(name = "RED_VALOR_TEXT")
    private String redValorText;
@Size(max = 250)   
    @Column(name = "RED_VALOR_CHECK")
    private String redValorCheck;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENG_REQUEST_DIMEN_MANUF_SEC")
    @SequenceGenerator(name = "ENG_REQUEST_DIMEN_MANUF_SEC", sequenceName = "ENG_REQUEST_DIMEN_MANUF_SEC", allocationSize = 1)
    @Column(name = "RED_ID")
    private BigDecimal redId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "RED_STATE")
    private String redState;
    @Size(max = 9)
    @Column(name = "RED_USER_ADD")
    private String redUserAdd;
    @Column(name = "RED_DATE_ADD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date redDateAdd;
    @Size(max = 9)
    @Column(name = "RED_USER_UPD")
    private String redUserUpd;
    @Column(name = "RED_DATE_UPD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date redDateUpd;
    @Size(max = 9)
    @Column(name = "RED_USER_DLT")
    private String redUserDlt;
    @Column(name = "RED_DATE_DLT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date redDateDlt;
    @JoinColumn(name = "RED_ID_DIMENSION", referencedColumnName = "DT_DIM_BY_MANUF_ID")
    @ManyToOne(optional = false)
    private EngDtDimByManuf redIdDimension;
    @JoinColumn(name = "RED_ID_REQUEST", referencedColumnName = "REQ_MESSAGEID")
    @ManyToOne(optional = false)
    private EngRequest redIdRequest;
    @Size(max = 50)
    @Column(name = "RED_MEASURE")
    private String redMeasure;   
    @Size(max = 500)
    @Column(name = "RED_OTHER")
    private String redOther;
    

    public EngRequestDimenManuf() {
        super();
    }

    public EngRequestDimenManuf(BigDecimal redId) {
        this.redId = redId;
    }

    public EngRequestDimenManuf(BigDecimal redId, String redState) {
        this.redId = redId;
        this.redState = redState;
    }

    public BigDecimal getRedId() {
        return redId;
    }

    public void setRedId(BigDecimal redId) {
        this.redId = redId;
    }

    public String getRedState() {
        return redState;
    }

    public void setRedState(String redState) {
        this.redState = redState;
    }

    public String getRedUserAdd() {
        return redUserAdd;
    }

    public void setRedUserAdd(String redUserAdd) {
        this.redUserAdd = redUserAdd;
    }

    public Date getRedDateAdd() {
        return redDateAdd;
    }

    public void setRedDateAdd(Date redDateAdd) {
        this.redDateAdd = redDateAdd;
    }

    public String getRedUserUpd() {
        return redUserUpd;
    }

    public void setRedUserUpd(String redUserUpd) {
        this.redUserUpd = redUserUpd;
    }

    public Date getRedDateUpd() {
        return redDateUpd;
    }

    public void setRedDateUpd(Date redDateUpd) {
        this.redDateUpd = redDateUpd;
    }

    public String getRedUserDlt() {
        return redUserDlt;
    }

    public void setRedUserDlt(String redUserDlt) {
        this.redUserDlt = redUserDlt;
    }

    public Date getRedDateDlt() {
        return redDateDlt;
    }

    public void setRedDateDlt(Date redDateDlt) {
        this.redDateDlt = redDateDlt;
    }

    public EngDtDimByManuf getRedIdDimension() {
        return redIdDimension;
    }

    public void setRedIdDimension(EngDtDimByManuf redIdDimension) {
        this.redIdDimension = redIdDimension;
    }

    public EngRequest getRedIdRequest() {
        return redIdRequest;
    }

    public void setRedIdRequest(EngRequest redIdRequest) {
        this.redIdRequest = redIdRequest;
    }

    public String getRedMeasure() {
        return redMeasure;
    }

    public void setRedMeasure(String redMeasure) {
        this.redMeasure = redMeasure;
    }
    
    public String getRedOther() {
        return redOther;
    }

    public void setRedOther(String redOther) {
        this.redOther = redOther;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (redId != null ? redId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EngRequestDimenManuf)) {
            return false;
        }
        EngRequestDimenManuf other = (EngRequestDimenManuf) object;
        if ((this.redId == null && other.redId != null) || (this.redId != null && !this.redId.equals(other.redId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngRequestDimenManuf[ redId=" + redId + " ]";
    }

    public String getRedValorText() {
        return redValorText;
    }

    public void setRedValorText(String redValorText) {
        this.redValorText = redValorText;
    }

    public String getRedValorCheck() {
        return redValorCheck;
    }

    public void setRedValorCheck(String redValorCheck) {
        this.redValorCheck = redValorCheck;
    }

    

    
}
