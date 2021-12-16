
package com.oracle.xmlns.oxp.service.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Clase Java para MobileAppDefinition complex type.
 * 
 * &lt;p&gt;El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="MobileAppDefinition"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="ESSJobName" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="ESSPackageName" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="autoRun" type="{http://www.w3.org/2001/XMLSchema}boolean"/&amp;gt;
 *         &amp;lt;element name="cacheDocument" type="{http://www.w3.org/2001/XMLSchema}boolean"/&amp;gt;
 *         &amp;lt;element name="controledByExtApp" type="{http://www.w3.org/2001/XMLSchema}boolean"/&amp;gt;
 *         &amp;lt;element name="dataModelURL" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="defaultOutputFormat" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="defaultTemplateId" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="diagnostics" type="{http://www.w3.org/2001/XMLSchema}boolean"/&amp;gt;
 *         &amp;lt;element name="listOfTemplateFormatsLabelValues" type="{http://xmlns.oracle.com/oxp/service/v2}ArrayOfMobileTemplateFormatsLabelValues"/&amp;gt;
 *         &amp;lt;element name="onLine" type="{http://www.w3.org/2001/XMLSchema}boolean"/&amp;gt;
 *         &amp;lt;element name="openLinkInNewWindow" type="{http://www.w3.org/2001/XMLSchema}boolean"/&amp;gt;
 *         &amp;lt;element name="parameterColumns" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="parameterNames" type="{http://xmlns.oracle.com/oxp/service/v2}ArrayOfString"/&amp;gt;
 *         &amp;lt;element name="reportDefnTitle" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="reportDescription" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="reportName" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="reportParameterNameValues" type="{http://xmlns.oracle.com/oxp/service/v2}ArrayOfParamNameValue"/&amp;gt;
 *         &amp;lt;element name="reportType" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="showControls" type="{http://www.w3.org/2001/XMLSchema}boolean"/&amp;gt;
 *         &amp;lt;element name="showReportLinks" type="{http://www.w3.org/2001/XMLSchema}boolean"/&amp;gt;
 *         &amp;lt;element name="templateIds" type="{http://xmlns.oracle.com/oxp/service/v2}ArrayOfString"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MobileAppDefinition", propOrder = {
    "essJobName",
    "essPackageName",
    "autoRun",
    "cacheDocument",
    "controledByExtApp",
    "dataModelURL",
    "defaultOutputFormat",
    "defaultTemplateId",
    "diagnostics",
    "listOfTemplateFormatsLabelValues",
    "onLine",
    "openLinkInNewWindow",
    "parameterColumns",
    "parameterNames",
    "reportDefnTitle",
    "reportDescription",
    "reportName",
    "reportParameterNameValues",
    "reportType",
    "showControls",
    "showReportLinks",
    "templateIds"
})
public class MobileAppDefinition {

    @XmlElement(name = "ESSJobName", required = true, nillable = true)
    protected String essJobName;
    @XmlElement(name = "ESSPackageName", required = true, nillable = true)
    protected String essPackageName;
    protected boolean autoRun;
    protected boolean cacheDocument;
    protected boolean controledByExtApp;
    @XmlElement(required = true, nillable = true)
    protected String dataModelURL;
    @XmlElement(required = true, nillable = true)
    protected String defaultOutputFormat;
    @XmlElement(required = true, nillable = true)
    protected String defaultTemplateId;
    protected boolean diagnostics;
    @XmlElement(required = true, nillable = true)
    protected ArrayOfMobileTemplateFormatsLabelValues listOfTemplateFormatsLabelValues;
    protected boolean onLine;
    protected boolean openLinkInNewWindow;
    protected int parameterColumns;
    @XmlElement(required = true, nillable = true)
    protected ArrayOfString parameterNames;
    @XmlElement(required = true, nillable = true)
    protected String reportDefnTitle;
    @XmlElement(required = true, nillable = true)
    protected String reportDescription;
    @XmlElement(required = true, nillable = true)
    protected String reportName;
    @XmlElement(required = true, nillable = true)
    protected ArrayOfParamNameValue reportParameterNameValues;
    @XmlElement(required = true, nillable = true)
    protected String reportType;
    protected boolean showControls;
    protected boolean showReportLinks;
    @XmlElement(required = true, nillable = true)
    protected ArrayOfString templateIds;

    /**
     * Obtiene el valor de la propiedad essJobName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getESSJobName() {
        return essJobName;
    }

    /**
     * Define el valor de la propiedad essJobName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setESSJobName(String value) {
        this.essJobName = value;
    }

    /**
     * Obtiene el valor de la propiedad essPackageName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getESSPackageName() {
        return essPackageName;
    }

    /**
     * Define el valor de la propiedad essPackageName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setESSPackageName(String value) {
        this.essPackageName = value;
    }

    /**
     * Obtiene el valor de la propiedad autoRun.
     * 
     */
    public boolean isAutoRun() {
        return autoRun;
    }

    /**
     * Define el valor de la propiedad autoRun.
     * 
     */
    public void setAutoRun(boolean value) {
        this.autoRun = value;
    }

    /**
     * Obtiene el valor de la propiedad cacheDocument.
     * 
     */
    public boolean isCacheDocument() {
        return cacheDocument;
    }

    /**
     * Define el valor de la propiedad cacheDocument.
     * 
     */
    public void setCacheDocument(boolean value) {
        this.cacheDocument = value;
    }

    /**
     * Obtiene el valor de la propiedad controledByExtApp.
     * 
     */
    public boolean isControledByExtApp() {
        return controledByExtApp;
    }

    /**
     * Define el valor de la propiedad controledByExtApp.
     * 
     */
    public void setControledByExtApp(boolean value) {
        this.controledByExtApp = value;
    }

    /**
     * Obtiene el valor de la propiedad dataModelURL.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataModelURL() {
        return dataModelURL;
    }

    /**
     * Define el valor de la propiedad dataModelURL.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataModelURL(String value) {
        this.dataModelURL = value;
    }

    /**
     * Obtiene el valor de la propiedad defaultOutputFormat.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefaultOutputFormat() {
        return defaultOutputFormat;
    }

    /**
     * Define el valor de la propiedad defaultOutputFormat.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefaultOutputFormat(String value) {
        this.defaultOutputFormat = value;
    }

    /**
     * Obtiene el valor de la propiedad defaultTemplateId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefaultTemplateId() {
        return defaultTemplateId;
    }

    /**
     * Define el valor de la propiedad defaultTemplateId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefaultTemplateId(String value) {
        this.defaultTemplateId = value;
    }

    /**
     * Obtiene el valor de la propiedad diagnostics.
     * 
     */
    public boolean isDiagnostics() {
        return diagnostics;
    }

    /**
     * Define el valor de la propiedad diagnostics.
     * 
     */
    public void setDiagnostics(boolean value) {
        this.diagnostics = value;
    }

    /**
     * Obtiene el valor de la propiedad listOfTemplateFormatsLabelValues.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfMobileTemplateFormatsLabelValues }
     *     
     */
    public ArrayOfMobileTemplateFormatsLabelValues getListOfTemplateFormatsLabelValues() {
        return listOfTemplateFormatsLabelValues;
    }

    /**
     * Define el valor de la propiedad listOfTemplateFormatsLabelValues.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfMobileTemplateFormatsLabelValues }
     *     
     */
    public void setListOfTemplateFormatsLabelValues(ArrayOfMobileTemplateFormatsLabelValues value) {
        this.listOfTemplateFormatsLabelValues = value;
    }

    /**
     * Obtiene el valor de la propiedad onLine.
     * 
     */
    public boolean isOnLine() {
        return onLine;
    }

    /**
     * Define el valor de la propiedad onLine.
     * 
     */
    public void setOnLine(boolean value) {
        this.onLine = value;
    }

    /**
     * Obtiene el valor de la propiedad openLinkInNewWindow.
     * 
     */
    public boolean isOpenLinkInNewWindow() {
        return openLinkInNewWindow;
    }

    /**
     * Define el valor de la propiedad openLinkInNewWindow.
     * 
     */
    public void setOpenLinkInNewWindow(boolean value) {
        this.openLinkInNewWindow = value;
    }

    /**
     * Obtiene el valor de la propiedad parameterColumns.
     * 
     */
    public int getParameterColumns() {
        return parameterColumns;
    }

    /**
     * Define el valor de la propiedad parameterColumns.
     * 
     */
    public void setParameterColumns(int value) {
        this.parameterColumns = value;
    }

    /**
     * Obtiene el valor de la propiedad parameterNames.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getParameterNames() {
        return parameterNames;
    }

    /**
     * Define el valor de la propiedad parameterNames.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setParameterNames(ArrayOfString value) {
        this.parameterNames = value;
    }

    /**
     * Obtiene el valor de la propiedad reportDefnTitle.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportDefnTitle() {
        return reportDefnTitle;
    }

    /**
     * Define el valor de la propiedad reportDefnTitle.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportDefnTitle(String value) {
        this.reportDefnTitle = value;
    }

    /**
     * Obtiene el valor de la propiedad reportDescription.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportDescription() {
        return reportDescription;
    }

    /**
     * Define el valor de la propiedad reportDescription.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportDescription(String value) {
        this.reportDescription = value;
    }

    /**
     * Obtiene el valor de la propiedad reportName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportName() {
        return reportName;
    }

    /**
     * Define el valor de la propiedad reportName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportName(String value) {
        this.reportName = value;
    }

    /**
     * Obtiene el valor de la propiedad reportParameterNameValues.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfParamNameValue }
     *     
     */
    public ArrayOfParamNameValue getReportParameterNameValues() {
        return reportParameterNameValues;
    }

    /**
     * Define el valor de la propiedad reportParameterNameValues.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfParamNameValue }
     *     
     */
    public void setReportParameterNameValues(ArrayOfParamNameValue value) {
        this.reportParameterNameValues = value;
    }

    /**
     * Obtiene el valor de la propiedad reportType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportType() {
        return reportType;
    }

    /**
     * Define el valor de la propiedad reportType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportType(String value) {
        this.reportType = value;
    }

    /**
     * Obtiene el valor de la propiedad showControls.
     * 
     */
    public boolean isShowControls() {
        return showControls;
    }

    /**
     * Define el valor de la propiedad showControls.
     * 
     */
    public void setShowControls(boolean value) {
        this.showControls = value;
    }

    /**
     * Obtiene el valor de la propiedad showReportLinks.
     * 
     */
    public boolean isShowReportLinks() {
        return showReportLinks;
    }

    /**
     * Define el valor de la propiedad showReportLinks.
     * 
     */
    public void setShowReportLinks(boolean value) {
        this.showReportLinks = value;
    }

    /**
     * Obtiene el valor de la propiedad templateIds.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getTemplateIds() {
        return templateIds;
    }

    /**
     * Define el valor de la propiedad templateIds.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setTemplateIds(ArrayOfString value) {
        this.templateIds = value;
    }

}
