
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
 *         &amp;lt;element name="uploadReportDataChunkInSessionReturn" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
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
    "uploadReportDataChunkInSessionReturn"
})
@XmlRootElement(name = "uploadReportDataChunkInSessionResponse")
public class UploadReportDataChunkInSessionResponse {

    @XmlElement(required = true)
    protected String uploadReportDataChunkInSessionReturn;

    /**
     * Obtiene el valor de la propiedad uploadReportDataChunkInSessionReturn.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUploadReportDataChunkInSessionReturn() {
        return uploadReportDataChunkInSessionReturn;
    }

    /**
     * Define el valor de la propiedad uploadReportDataChunkInSessionReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUploadReportDataChunkInSessionReturn(String value) {
        this.uploadReportDataChunkInSessionReturn = value;
    }

}
