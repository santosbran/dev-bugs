
package com.oracle.xmlns.oxp.service.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Clase Java para anonymous complex type.
 * 
 * &lt;p&gt;El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="getXDOSchemaReturn" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getXDOSchemaReturn"
})
@XmlRootElement(name = "getXDOSchemaResponse")
public class GetXDOSchemaResponse {

    @XmlElement(required = true)
    protected byte[] getXDOSchemaReturn;

    /**
     * Obtiene el valor de la propiedad getXDOSchemaReturn.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getGetXDOSchemaReturn() {
        return getXDOSchemaReturn;
    }

    /**
     * Define el valor de la propiedad getXDOSchemaReturn.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setGetXDOSchemaReturn(byte[] value) {
        this.getXDOSchemaReturn = value;
    }

}
