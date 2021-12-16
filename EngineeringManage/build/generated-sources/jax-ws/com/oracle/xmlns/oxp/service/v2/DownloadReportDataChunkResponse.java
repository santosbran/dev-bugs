
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
 *         &amp;lt;element name="downloadReportDataChunkReturn" type="{http://xmlns.oracle.com/oxp/service/v2}ReportDataChunk"/&amp;gt;
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
    "downloadReportDataChunkReturn"
})
@XmlRootElement(name = "downloadReportDataChunkResponse")
public class DownloadReportDataChunkResponse {

    @XmlElement(required = true)
    protected ReportDataChunk downloadReportDataChunkReturn;

    /**
     * Obtiene el valor de la propiedad downloadReportDataChunkReturn.
     * 
     * @return
     *     possible object is
     *     {@link ReportDataChunk }
     *     
     */
    public ReportDataChunk getDownloadReportDataChunkReturn() {
        return downloadReportDataChunkReturn;
    }

    /**
     * Define el valor de la propiedad downloadReportDataChunkReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link ReportDataChunk }
     *     
     */
    public void setDownloadReportDataChunkReturn(ReportDataChunk value) {
        this.downloadReportDataChunkReturn = value;
    }

}
