
package com.oracle.xmlns.oxp.service.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Clase Java para FileDataSource complex type.
 * 
 * &lt;p&gt;El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="FileDataSource"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="dynamicDataSourcePath" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="temporaryDataSource" type="{http://www.w3.org/2001/XMLSchema}boolean"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FileDataSource", propOrder = {
    "dynamicDataSourcePath",
    "temporaryDataSource"
})
public class FileDataSource {

    @XmlElement(required = true, nillable = true)
    protected String dynamicDataSourcePath;
    protected boolean temporaryDataSource;

    /**
     * Obtiene el valor de la propiedad dynamicDataSourcePath.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDynamicDataSourcePath() {
        return dynamicDataSourcePath;
    }

    /**
     * Define el valor de la propiedad dynamicDataSourcePath.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDynamicDataSourcePath(String value) {
        this.dynamicDataSourcePath = value;
    }

    /**
     * Obtiene el valor de la propiedad temporaryDataSource.
     * 
     */
    public boolean isTemporaryDataSource() {
        return temporaryDataSource;
    }

    /**
     * Define el valor de la propiedad temporaryDataSource.
     * 
     */
    public void setTemporaryDataSource(boolean value) {
        this.temporaryDataSource = value;
    }

}
