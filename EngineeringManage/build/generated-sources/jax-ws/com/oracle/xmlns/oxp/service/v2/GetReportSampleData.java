
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
 *         &amp;lt;element name="reportAbsolutePath" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="userID" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
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
    "reportAbsolutePath",
    "userID",
    "password"
})
@XmlRootElement(name = "getReportSampleData")
public class GetReportSampleData {

    @XmlElement(required = true)
    protected String reportAbsolutePath;
    @XmlElement(required = true)
    protected String userID;
    @XmlElement(required = true)
    protected String password;

    /**
     * Obtiene el valor de la propiedad reportAbsolutePath.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportAbsolutePath() {
        return reportAbsolutePath;
    }

    /**
     * Define el valor de la propiedad reportAbsolutePath.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportAbsolutePath(String value) {
        this.reportAbsolutePath = value;
    }

    /**
     * Obtiene el valor de la propiedad userID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserID() {
        return userID;
    }

    /**
     * Define el valor de la propiedad userID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserID(String value) {
        this.userID = value;
    }

    /**
     * Obtiene el valor de la propiedad password.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Define el valor de la propiedad password.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

}
