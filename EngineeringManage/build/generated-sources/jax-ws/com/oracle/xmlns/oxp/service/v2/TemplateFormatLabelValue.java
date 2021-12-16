
package com.oracle.xmlns.oxp.service.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Clase Java para TemplateFormatLabelValue complex type.
 * 
 * &lt;p&gt;El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="TemplateFormatLabelValue"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="templateFormatLabel" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="templateFormatValue" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TemplateFormatLabelValue", propOrder = {
    "templateFormatLabel",
    "templateFormatValue"
})
public class TemplateFormatLabelValue {

    @XmlElement(required = true, nillable = true)
    protected String templateFormatLabel;
    @XmlElement(required = true, nillable = true)
    protected String templateFormatValue;

    /**
     * Obtiene el valor de la propiedad templateFormatLabel.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemplateFormatLabel() {
        return templateFormatLabel;
    }

    /**
     * Define el valor de la propiedad templateFormatLabel.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemplateFormatLabel(String value) {
        this.templateFormatLabel = value;
    }

    /**
     * Obtiene el valor de la propiedad templateFormatValue.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemplateFormatValue() {
        return templateFormatValue;
    }

    /**
     * Define el valor de la propiedad templateFormatValue.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemplateFormatValue(String value) {
        this.templateFormatValue = value;
    }

}
