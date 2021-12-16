
package com.oracle.xmlns.oxp.service.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Clase Java para MetaData complex type.
 * 
 * &lt;p&gt;El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="MetaData"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="metaDataName" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="metaDataValue" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MetaData", propOrder = {
    "metaDataName",
    "metaDataValue"
})
public class MetaData {

    @XmlElement(required = true, nillable = true)
    protected String metaDataName;
    @XmlElement(required = true, nillable = true)
    protected String metaDataValue;

    /**
     * Obtiene el valor de la propiedad metaDataName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMetaDataName() {
        return metaDataName;
    }

    /**
     * Define el valor de la propiedad metaDataName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMetaDataName(String value) {
        this.metaDataName = value;
    }

    /**
     * Obtiene el valor de la propiedad metaDataValue.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMetaDataValue() {
        return metaDataValue;
    }

    /**
     * Define el valor de la propiedad metaDataValue.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMetaDataValue(String value) {
        this.metaDataValue = value;
    }

}
