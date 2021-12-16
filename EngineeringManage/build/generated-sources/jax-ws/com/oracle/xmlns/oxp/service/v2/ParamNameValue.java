
package com.oracle.xmlns.oxp.service.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Clase Java para ParamNameValue complex type.
 * 
 * &lt;p&gt;El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="ParamNameValue"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="UIType" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="dataType" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="dateFormatString" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="dateFrom" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="dateTo" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="defaultValue" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="fieldSize" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="label" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="lovLabels" type="{http://xmlns.oracle.com/oxp/service/v2}ArrayOfString"/&amp;gt;
 *         &amp;lt;element name="multiValuesAllowed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&amp;gt;
 *         &amp;lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="refreshParamOnChange" type="{http://www.w3.org/2001/XMLSchema}boolean"/&amp;gt;
 *         &amp;lt;element name="selectAll" type="{http://www.w3.org/2001/XMLSchema}boolean"/&amp;gt;
 *         &amp;lt;element name="templateParam" type="{http://www.w3.org/2001/XMLSchema}boolean"/&amp;gt;
 *         &amp;lt;element name="useNullForAll" type="{http://www.w3.org/2001/XMLSchema}boolean"/&amp;gt;
 *         &amp;lt;element name="values" type="{http://xmlns.oracle.com/oxp/service/v2}ArrayOfString"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ParamNameValue", propOrder = {
    "uiType",
    "dataType",
    "dateFormatString",
    "dateFrom",
    "dateTo",
    "defaultValue",
    "fieldSize",
    "label",
    "lovLabels",
    "multiValuesAllowed",
    "name",
    "refreshParamOnChange",
    "selectAll",
    "templateParam",
    "useNullForAll",
    "values"
})
public class ParamNameValue {

    @XmlElement(name = "UIType", required = true, nillable = true)
    protected String uiType;
    @XmlElement(required = true, nillable = true)
    protected String dataType;
    @XmlElement(required = true, nillable = true)
    protected String dateFormatString;
    @XmlElement(required = true, nillable = true)
    protected String dateFrom;
    @XmlElement(required = true, nillable = true)
    protected String dateTo;
    @XmlElement(required = true, nillable = true)
    protected String defaultValue;
    @XmlElement(required = true, nillable = true)
    protected String fieldSize;
    @XmlElement(required = true, nillable = true)
    protected String label;
    @XmlElement(required = true, nillable = true)
    protected ArrayOfString lovLabels;
    protected boolean multiValuesAllowed;
    @XmlElement(required = true, nillable = true)
    protected String name;
    protected boolean refreshParamOnChange;
    protected boolean selectAll;
    protected boolean templateParam;
    protected boolean useNullForAll;
    @XmlElement(required = true, nillable = true)
    protected ArrayOfString values;

    /**
     * Obtiene el valor de la propiedad uiType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUIType() {
        return uiType;
    }

    /**
     * Define el valor de la propiedad uiType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUIType(String value) {
        this.uiType = value;
    }

    /**
     * Obtiene el valor de la propiedad dataType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataType() {
        return dataType;
    }

    /**
     * Define el valor de la propiedad dataType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataType(String value) {
        this.dataType = value;
    }

    /**
     * Obtiene el valor de la propiedad dateFormatString.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateFormatString() {
        return dateFormatString;
    }

    /**
     * Define el valor de la propiedad dateFormatString.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateFormatString(String value) {
        this.dateFormatString = value;
    }

    /**
     * Obtiene el valor de la propiedad dateFrom.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateFrom() {
        return dateFrom;
    }

    /**
     * Define el valor de la propiedad dateFrom.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateFrom(String value) {
        this.dateFrom = value;
    }

    /**
     * Obtiene el valor de la propiedad dateTo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateTo() {
        return dateTo;
    }

    /**
     * Define el valor de la propiedad dateTo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateTo(String value) {
        this.dateTo = value;
    }

    /**
     * Obtiene el valor de la propiedad defaultValue.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefaultValue() {
        return defaultValue;
    }

    /**
     * Define el valor de la propiedad defaultValue.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefaultValue(String value) {
        this.defaultValue = value;
    }

    /**
     * Obtiene el valor de la propiedad fieldSize.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFieldSize() {
        return fieldSize;
    }

    /**
     * Define el valor de la propiedad fieldSize.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFieldSize(String value) {
        this.fieldSize = value;
    }

    /**
     * Obtiene el valor de la propiedad label.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLabel() {
        return label;
    }

    /**
     * Define el valor de la propiedad label.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLabel(String value) {
        this.label = value;
    }

    /**
     * Obtiene el valor de la propiedad lovLabels.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getLovLabels() {
        return lovLabels;
    }

    /**
     * Define el valor de la propiedad lovLabels.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setLovLabels(ArrayOfString value) {
        this.lovLabels = value;
    }

    /**
     * Obtiene el valor de la propiedad multiValuesAllowed.
     * 
     */
    public boolean isMultiValuesAllowed() {
        return multiValuesAllowed;
    }

    /**
     * Define el valor de la propiedad multiValuesAllowed.
     * 
     */
    public void setMultiValuesAllowed(boolean value) {
        this.multiValuesAllowed = value;
    }

    /**
     * Obtiene el valor de la propiedad name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Define el valor de la propiedad name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Obtiene el valor de la propiedad refreshParamOnChange.
     * 
     */
    public boolean isRefreshParamOnChange() {
        return refreshParamOnChange;
    }

    /**
     * Define el valor de la propiedad refreshParamOnChange.
     * 
     */
    public void setRefreshParamOnChange(boolean value) {
        this.refreshParamOnChange = value;
    }

    /**
     * Obtiene el valor de la propiedad selectAll.
     * 
     */
    public boolean isSelectAll() {
        return selectAll;
    }

    /**
     * Define el valor de la propiedad selectAll.
     * 
     */
    public void setSelectAll(boolean value) {
        this.selectAll = value;
    }

    /**
     * Obtiene el valor de la propiedad templateParam.
     * 
     */
    public boolean isTemplateParam() {
        return templateParam;
    }

    /**
     * Define el valor de la propiedad templateParam.
     * 
     */
    public void setTemplateParam(boolean value) {
        this.templateParam = value;
    }

    /**
     * Obtiene el valor de la propiedad useNullForAll.
     * 
     */
    public boolean isUseNullForAll() {
        return useNullForAll;
    }

    /**
     * Define el valor de la propiedad useNullForAll.
     * 
     */
    public void setUseNullForAll(boolean value) {
        this.useNullForAll = value;
    }

    /**
     * Obtiene el valor de la propiedad values.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getValues() {
        return values;
    }

    /**
     * Define el valor de la propiedad values.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setValues(ArrayOfString value) {
        this.values = value;
    }

}
