
package com.oracle.xmlns.oxp.service.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Clase Java para ReportResponse complex type.
 * 
 * &lt;p&gt;El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="ReportResponse"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="metaDataList" type="{http://xmlns.oracle.com/oxp/service/v2}MetaDataList"/&amp;gt;
 *         &amp;lt;element name="reportBytes" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&amp;gt;
 *         &amp;lt;element name="reportContentType" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="reportFileID" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="reportLocale" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReportResponse", propOrder = {
    "metaDataList",
    "reportBytes",
    "reportContentType",
    "reportFileID",
    "reportLocale"
})
public class ReportResponse {

    @XmlElement(required = true, nillable = true)
    protected MetaDataList metaDataList;
    @XmlElement(required = true, nillable = true)
    protected byte[] reportBytes;
    @XmlElement(required = true, nillable = true)
    protected String reportContentType;
    @XmlElement(required = true, nillable = true)
    protected String reportFileID;
    @XmlElement(required = true, nillable = true)
    protected String reportLocale;

    /**
     * Obtiene el valor de la propiedad metaDataList.
     * 
     * @return
     *     possible object is
     *     {@link MetaDataList }
     *     
     */
    public MetaDataList getMetaDataList() {
        return metaDataList;
    }

    /**
     * Define el valor de la propiedad metaDataList.
     * 
     * @param value
     *     allowed object is
     *     {@link MetaDataList }
     *     
     */
    public void setMetaDataList(MetaDataList value) {
        this.metaDataList = value;
    }

    /**
     * Obtiene el valor de la propiedad reportBytes.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getReportBytes() {
        return reportBytes;
    }

    /**
     * Define el valor de la propiedad reportBytes.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setReportBytes(byte[] value) {
        this.reportBytes = value;
    }

    /**
     * Obtiene el valor de la propiedad reportContentType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportContentType() {
        return reportContentType;
    }

    /**
     * Define el valor de la propiedad reportContentType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportContentType(String value) {
        this.reportContentType = value;
    }

    /**
     * Obtiene el valor de la propiedad reportFileID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportFileID() {
        return reportFileID;
    }

    /**
     * Define el valor de la propiedad reportFileID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportFileID(String value) {
        this.reportFileID = value;
    }

    /**
     * Obtiene el valor de la propiedad reportLocale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportLocale() {
        return reportLocale;
    }

    /**
     * Define el valor de la propiedad reportLocale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportLocale(String value) {
        this.reportLocale = value;
    }

}
