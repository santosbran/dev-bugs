
package com.oracle.xmlns.oxp.service.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Clase Java para ParamNameValues complex type.
 * 
 * &lt;p&gt;El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="ParamNameValues"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="listOfParamNameValues" type="{http://xmlns.oracle.com/oxp/service/v2}ArrayOfParamNameValue"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ParamNameValues", propOrder = {
    "listOfParamNameValues"
})
public class ParamNameValues {

    @XmlElement(required = true, nillable = true)
    protected ArrayOfParamNameValue listOfParamNameValues;

    /**
     * Obtiene el valor de la propiedad listOfParamNameValues.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfParamNameValue }
     *     
     */
    public ArrayOfParamNameValue getListOfParamNameValues() {
        return listOfParamNameValues;
    }

    /**
     * Define el valor de la propiedad listOfParamNameValues.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfParamNameValue }
     *     
     */
    public void setListOfParamNameValues(ArrayOfParamNameValue value) {
        this.listOfParamNameValues = value;
    }

}
