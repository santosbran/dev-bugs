
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
 *         &amp;lt;element name="getReportDefinitionInSessionReturn" type="{http://xmlns.oracle.com/oxp/service/v2}ReportDefinition"/&amp;gt;
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
    "getReportDefinitionInSessionReturn"
})
@XmlRootElement(name = "getReportDefinitionInSessionResponse")
public class GetReportDefinitionInSessionResponse {

    @XmlElement(required = true)
    protected ReportDefinition getReportDefinitionInSessionReturn;

    /**
     * Obtiene el valor de la propiedad getReportDefinitionInSessionReturn.
     * 
     * @return
     *     possible object is
     *     {@link ReportDefinition }
     *     
     */
    public ReportDefinition getGetReportDefinitionInSessionReturn() {
        return getReportDefinitionInSessionReturn;
    }

    /**
     * Define el valor de la propiedad getReportDefinitionInSessionReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link ReportDefinition }
     *     
     */
    public void setGetReportDefinitionInSessionReturn(ReportDefinition value) {
        this.getReportDefinitionInSessionReturn = value;
    }

}
