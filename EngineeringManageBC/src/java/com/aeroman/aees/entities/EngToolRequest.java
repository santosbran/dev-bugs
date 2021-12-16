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
 * @author scruz
 */
@Entity
@Cacheable(false)
@Table(name = "ENG_TOOL_REQUEST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngToolRequest.findAll", query = "SELECT e FROM EngToolRequest e"),
    @NamedQuery(name = "EngToolRequest.findByIdToolReq", query = "SELECT e FROM EngToolRequest e WHERE e.idToolReq = :idToolReq"),
    @NamedQuery(name = "EngToolRequest.findByIdPart", query = "SELECT e FROM EngToolRequest e WHERE e.idPart = :idPart"),
    @NamedQuery(name = "EngToolRequest.findByToolReqDesc", query = "SELECT e FROM EngToolRequest e WHERE e.toolReqDesc = :toolReqDesc"),
    @NamedQuery(name = "EngToolRequest.findByToolReqQty", query = "SELECT e FROM EngToolRequest e WHERE e.toolReqQty = :toolReqQty"),
    @NamedQuery(name = "EngToolRequest.findByToolRequiredDate", query = "SELECT e FROM EngToolRequest e WHERE e.toolRequiredDate = :toolRequiredDate"),
    @NamedQuery(name = "EngToolRequest.findByToolPrice", query = "SELECT e FROM EngToolRequest e WHERE e.toolPrice = :toolPrice"),
    @NamedQuery(name = "EngToolRequest.findByIdFleet", query = "SELECT e FROM EngToolRequest e WHERE e.idFleet = :idFleet"),
    @NamedQuery(name = "EngToolRequest.findByToolLeadTime", query = "SELECT e FROM EngToolRequest e WHERE e.toolLeadTime = :toolLeadTime"),
    @NamedQuery(name = "EngToolRequest.findByToolReqCreationDate", query = "SELECT e FROM EngToolRequest e WHERE e.toolReqCreationDate = :toolReqCreationDate"),
    @NamedQuery(name = "EngToolRequest.findByToolReqCreatedBy", query = "SELECT e FROM EngToolRequest e WHERE e.toolReqCreatedBy = :toolReqCreatedBy"),
    @NamedQuery(name = "EngToolRequest.findByToolReqUpdateDate", query = "SELECT e FROM EngToolRequest e WHERE e.toolReqUpdateDate = :toolReqUpdateDate"),
    @NamedQuery(name = "EngToolRequest.findByToolReqUpdatedBy", query = "SELECT e FROM EngToolRequest e WHERE e.toolReqUpdatedBy = :toolReqUpdatedBy"),
    @NamedQuery(name = "EngToolRequest.findByToolAtt", query = "SELECT e FROM EngToolRequest e WHERE e.toolAtt = :toolAtt"),
    @NamedQuery(name = "EngToolRequest.findByToolQuoteAtt", query = "SELECT e FROM EngToolRequest e WHERE e.toolQuoteAtt = :toolQuoteAtt")})
public class EngToolRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TOOL_PART")
    @SequenceGenerator(name = "SEQ_TOOL_PART", sequenceName = "SEQ_TOOL_PART", allocationSize = 1)
    @Column(name = "ID_TOOL_REQ")
    private BigDecimal idToolReq;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PART")
    private BigInteger idPart;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "TOOL_REQ_DESC")
    private String toolReqDesc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOOL_REQ_QTY")
    private BigInteger toolReqQty;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOOL_REQUIRED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date toolRequiredDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOOL_PRICE")
    private double toolPrice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_FLEET")
    private BigInteger idFleet;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOOL_LEAD_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date toolLeadTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOOL_REQ_CREATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date toolReqCreationDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "TOOL_REQ_CREATED_BY")
    private String toolReqCreatedBy;
    @Column(name = "TOOL_REQ_UPDATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date toolReqUpdateDate;
    @Size(max = 10)
    @Column(name = "TOOL_REQ_UPDATED_BY")
    private String toolReqUpdatedBy;
    @Column(name = "TOOL_ATT")
    private BigInteger toolAtt;
    @Column(name = "TOOL_QUOTE_ATT")
    private BigInteger toolQuoteAtt;
    @JoinColumn(name = "TOOL_REQUEST_PRIORIY", referencedColumnName = "PRI_COD")
    @ManyToOne(optional = false)
    private EngPriorities toolRequestPrioriy;

    public EngToolRequest() {
    }

    public EngToolRequest(BigDecimal idToolReq) {
        this.idToolReq = idToolReq;
    }

    
    public BigDecimal getIdToolReq() {
        return idToolReq;
    }

    public void setIdToolReq(BigDecimal idToolReq) {
        this.idToolReq = idToolReq;
    }

    public BigInteger getIdPart() {
        return idPart;
    }

    public void setIdPart(BigInteger idPart) {
        this.idPart = idPart;
    }

    public String getToolReqDesc() {
        return toolReqDesc;
    }

    public void setToolReqDesc(String toolReqDesc) {
        this.toolReqDesc = toolReqDesc;
    }

    public BigInteger getToolReqQty() {
        return toolReqQty;
    }

    public void setToolReqQty(BigInteger toolReqQty) {
        this.toolReqQty = toolReqQty;
    }

    public Date getToolRequiredDate() {
        return toolRequiredDate;
    }

    public void setToolRequiredDate(Date toolRequiredDate) {
        this.toolRequiredDate = toolRequiredDate;
    }

    public double getToolPrice() {
        return toolPrice;
    }

    public void setToolPrice(double toolPrice) {
        this.toolPrice = toolPrice;
    }

    public BigInteger getIdFleet() {
        return idFleet;
    }

    public void setIdFleet(BigInteger idFleet) {
        this.idFleet = idFleet;
    }

    public Date getToolLeadTime() {
        return toolLeadTime;
    }

    public void setToolLeadTime(Date toolLeadTime) {
        this.toolLeadTime = toolLeadTime;
    }

    public Date getToolReqCreationDate() {
        return toolReqCreationDate;
    }

    public void setToolReqCreationDate(Date toolReqCreationDate) {
        this.toolReqCreationDate = toolReqCreationDate;
    }

    public String getToolReqCreatedBy() {
        return toolReqCreatedBy;
    }

    public void setToolReqCreatedBy(String toolReqCreatedBy) {
        this.toolReqCreatedBy = toolReqCreatedBy;
    }

    public Date getToolReqUpdateDate() {
        return toolReqUpdateDate;
    }

    public void setToolReqUpdateDate(Date toolReqUpdateDate) {
        this.toolReqUpdateDate = toolReqUpdateDate;
    }

    public String getToolReqUpdatedBy() {
        return toolReqUpdatedBy;
    }

    public void setToolReqUpdatedBy(String toolReqUpdatedBy) {
        this.toolReqUpdatedBy = toolReqUpdatedBy;
    }

    public BigInteger getToolAtt() {
        return toolAtt;
    }

    public void setToolAtt(BigInteger toolAtt) {
        this.toolAtt = toolAtt;
    }

    public BigInteger getToolQuoteAtt() {
        return toolQuoteAtt;
    }

    public void setToolQuoteAtt(BigInteger toolQuoteAtt) {
        this.toolQuoteAtt = toolQuoteAtt;
    }

    public EngPriorities getToolRequestPrioriy() {
        return toolRequestPrioriy;
    }

    public void setToolRequestPrioriy(EngPriorities toolRequestPrioriy) {
        this.toolRequestPrioriy = toolRequestPrioriy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idToolReq != null ? idToolReq.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EngToolRequest)) {
            return false;
        }
        EngToolRequest other = (EngToolRequest) object;
        if ((this.idToolReq == null && other.idToolReq != null) || (this.idToolReq != null && !this.idToolReq.equals(other.idToolReq))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngToolRequest[ idToolReq=" + idToolReq + " ]";
    }
    
}
