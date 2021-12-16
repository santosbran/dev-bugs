
package com.oracle.xmlns.oxp.service.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Clase Java para ReportRequest complex type.
 * 
 * &lt;p&gt;El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="ReportRequest"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="XDOPropertyList" type="{http://xmlns.oracle.com/oxp/service/v2}MetaDataList"/&amp;gt;
 *         &amp;lt;element name="attributeCalendar" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="attributeFormat" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="attributeLocale" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="attributeTemplate" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="attributeTimezone" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="attributeUILocale" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="byPassCache" type="{http://www.w3.org/2001/XMLSchema}boolean"/&amp;gt;
 *         &amp;lt;element name="dynamicDataSource" type="{http://xmlns.oracle.com/oxp/service/v2}BIPDataSource"/&amp;gt;
 *         &amp;lt;element name="flattenXML" type="{http://www.w3.org/2001/XMLSchema}boolean"/&amp;gt;
 *         &amp;lt;element name="parameterNameValues" type="{http://xmlns.oracle.com/oxp/service/v2}ParamNameValues"/&amp;gt;
 *         &amp;lt;element name="reportAbsolutePath" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="reportData" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&amp;gt;
 *         &amp;lt;element name="reportOutputPath" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="reportRawData" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="sizeOfDataChunkDownload" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReportRequest", propOrder = {
    "xdoPropertyList",
    "attributeCalendar",
    "attributeFormat",
    "attributeLocale",
    "attributeTemplate",
    "attributeTimezone",
    "attributeUILocale",
    "byPassCache",
    "dynamicDataSource",
    "flattenXML",
    "parameterNameValues",
    "reportAbsolutePath",
    "reportData",
    "reportOutputPath",
    "reportRawData",
    "sizeOfDataChunkDownload"
})
public class ReportRequest {

    @XmlElement(name = "XDOPropertyList", required = true, nillable = true)
    protected MetaDataList xdoPropertyList;
    @XmlElement(required = true, nillable = true)
    protected String attributeCalendar;
    @XmlElement(required = true, nillable = true)
    protected String attributeFormat;
    @XmlElement(required = true, nillable = true)
    protected String attributeLocale;
    @XmlElement(required = true, nillable = true)
    protected String attributeTemplate;
    @XmlElement(required = true, nillable = true)
    protected String attributeTimezone;
    @XmlElement(required = true, nillable = true)
    protected String attributeUILocale;
    protected boolean byPassCache;
    @XmlElement(required = true, nillable = true)
    protected BIPDataSource dynamicDataSource;
    protected boolean flattenXML;
    @XmlElement(required = true, nillable = true)
    protected ParamNameValues parameterNameValues;
    @XmlElement(required = true, nillable = true)
    protected String reportAbsolutePath;
    @XmlElement(required = true, nillable = true)
    protected byte[] reportData;
    @XmlElement(required = true, nillable = true)
    protected String reportOutputPath;
    @XmlElement(required = true, nillable = true)
    protected String reportRawData;
    protected int sizeOfDataChunkDownload;

    /**
     * Obtiene el valor de la propiedad xdoPropertyList.
     * 
     * @return
     *     possible object is
     *     {@link MetaDataList }
     *     
     */
    public MetaDataList getXDOPropertyList() {
        return xdoPropertyList;
    }

    /**
     * Define el valor de la propiedad xdoPropertyList.
     * 
     * @param value
     *     allowed object is
     *     {@link MetaDataList }
     *     
     */
    public void setXDOPropertyList(MetaDataList value) {
        this.xdoPropertyList = value;
    }

    /**
     * Obtiene el valor de la propiedad attributeCalendar.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttributeCalendar() {
        return attributeCalendar;
    }

    /**
     * Define el valor de la propiedad attributeCalendar.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttributeCalendar(String value) {
        this.attributeCalendar = value;
    }

    /**
     * Obtiene el valor de la propiedad attributeFormat.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttributeFormat() {
        return attributeFormat;
    }

    /**
     * Define el valor de la propiedad attributeFormat.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttributeFormat(String value) {
        this.attributeFormat = value;
    }

    /**
     * Obtiene el valor de la propiedad attributeLocale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttributeLocale() {
        return attributeLocale;
    }

    /**
     * Define el valor de la propiedad attributeLocale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttributeLocale(String value) {
        this.attributeLocale = value;
    }

    /**
     * Obtiene el valor de la propiedad attributeTemplate.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttributeTemplate() {
        return attributeTemplate;
    }

    /**
     * Define el valor de la propiedad attributeTemplate.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttributeTemplate(String value) {
        this.attributeTemplate = value;
    }

    /**
     * Obtiene el valor de la propiedad attributeTimezone.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttributeTimezone() {
        return attributeTimezone;
    }

    /**
     * Define el valor de la propiedad attributeTimezone.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttributeTimezone(String value) {
        this.attributeTimezone = value;
    }

    /**
     * Obtiene el valor de la propiedad attributeUILocale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttributeUILocale() {
        return attributeUILocale;
    }

    /**
     * Define el valor de la propiedad attributeUILocale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttributeUILocale(String value) {
        this.attributeUILocale = value;
    }

    /**
     * Obtiene el valor de la propiedad byPassCache.
     * 
     */
    public boolean isByPassCache() {
        return byPassCache;
    }

    /**
     * Define el valor de la propiedad byPassCache.
     * 
     */
    public void setByPassCache(boolean value) {
        this.byPassCache = value;
    }

    /**
     * Obtiene el valor de la propiedad dynamicDataSource.
     * 
     * @return
     *     possible object is
     *     {@link BIPDataSource }
     *     
     */
    public BIPDataSource getDynamicDataSource() {
        return dynamicDataSource;
    }

    /**
     * Define el valor de la propiedad dynamicDataSource.
     * 
     * @param value
     *     allowed object is
     *     {@link BIPDataSource }
     *     
     */
    public void setDynamicDataSource(BIPDataSource value) {
        this.dynamicDataSource = value;
    }

    /**
     * Obtiene el valor de la propiedad flattenXML.
     * 
     */
    public boolean isFlattenXML() {
        return flattenXML;
    }

    /**
     * Define el valor de la propiedad flattenXML.
     * 
     */
    public void setFlattenXML(boolean value) {
        this.flattenXML = value;
    }

    /**
     * Obtiene el valor de la propiedad parameterNameValues.
     * 
     * @return
     *     possible object is
     *     {@link ParamNameValues }
     *     
     */
    public ParamNameValues getParameterNameValues() {
        return parameterNameValues;
    }

    /**
     * Define el valor de la propiedad parameterNameValues.
     * 
     * @param value
     *     allowed object is
     *     {@link ParamNameValues }
     *     
     */
    public void setParameterNameValues(ParamNameValues value) {
        this.parameterNameValues = value;
    }

    /**
     * Obtiene el valor de la propiedad reportAbsolutePath.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportAbsolutePath() {
        return reportAbsolutePath;
    }

    /**
     * Define el valor de la propiedad reportAbsolutePath.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportAbsolutePath(String value) {
        this.reportAbsolutePath = value;
    }

    /**
     * Obtiene el valor de la propiedad reportData.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getReportData() {
        return reportData;
    }

    /**
     * Define el valor de la propiedad reportData.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setReportData(byte[] value) {
        this.reportData = value;
    }

    /**
     * Obtiene el valor de la propiedad reportOutputPath.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportOutputPath() {
        return reportOutputPath;
    }

    /**
     * Define el valor de la propiedad reportOutputPath.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportOutputPath(String value) {
        this.reportOutputPath = value;
    }

    /**
     * Obtiene el valor de la propiedad reportRawData.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportRawData() {
        return reportRawData;
    }

    /**
     * Define el valor de la propiedad reportRawData.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportRawData(String value) {
        this.reportRawData = value;
    }

    /**
     * Obtiene el valor de la propiedad sizeOfDataChunkDownload.
     * 
     */
    public int getSizeOfDataChunkDownload() {
        return sizeOfDataChunkDownload;
    }

    /**
     * Define el valor de la propiedad sizeOfDataChunkDownload.
     * 
     */
    public void setSizeOfDataChunkDownload(int value) {
        this.sizeOfDataChunkDownload = value;
    }

}
