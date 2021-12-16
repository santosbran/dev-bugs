
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
 *         &amp;lt;element name="runDataModelInSessionReturn" type="{http://xmlns.oracle.com/oxp/service/v2}ReportResponse"/&amp;gt;
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
    "runDataModelInSessionReturn"
})
@XmlRootElement(name = "runDataModelInSessionResponse")
public class RunDataModelInSessionResponse {

    @XmlElement(required = true)
    protected ReportResponse runDataModelInSessionReturn;

    /**
     * Obtiene el valor de la propiedad runDataModelInSessionReturn.
     * 
     * @return
     *     possible object is
     *     {@link ReportResponse }
     *     
     */
    public ReportResponse getRunDataModelInSessionReturn() {
        return runDataModelInSessionReturn;
    }

    /**
     * Define el valor de la propiedad runDataModelInSessionReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link ReportResponse }
     *     
     */
    public void setRunDataModelInSessionReturn(ReportResponse value) {
        this.runDataModelInSessionReturn = value;
    }

}
