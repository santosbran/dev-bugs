
package com.oracle.xmlns.oxp.service.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Clase Java para BIPDataSource complex type.
 * 
 * &lt;p&gt;El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="BIPDataSource"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="JDBCDataSource" type="{http://xmlns.oracle.com/oxp/service/v2}JDBCDataSource"/&amp;gt;
 *         &amp;lt;element name="fileDataSource" type="{http://xmlns.oracle.com/oxp/service/v2}FileDataSource"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BIPDataSource", propOrder = {
    "jdbcDataSource",
    "fileDataSource"
})
public class BIPDataSource {

    @XmlElement(name = "JDBCDataSource", required = true, nillable = true)
    protected JDBCDataSource jdbcDataSource;
    @XmlElement(required = true, nillable = true)
    protected FileDataSource fileDataSource;

    /**
     * Obtiene el valor de la propiedad jdbcDataSource.
     * 
     * @return
     *     possible object is
     *     {@link JDBCDataSource }
     *     
     */
    public JDBCDataSource getJDBCDataSource() {
        return jdbcDataSource;
    }

    /**
     * Define el valor de la propiedad jdbcDataSource.
     * 
     * @param value
     *     allowed object is
     *     {@link JDBCDataSource }
     *     
     */
    public void setJDBCDataSource(JDBCDataSource value) {
        this.jdbcDataSource = value;
    }

    /**
     * Obtiene el valor de la propiedad fileDataSource.
     * 
     * @return
     *     possible object is
     *     {@link FileDataSource }
     *     
     */
    public FileDataSource getFileDataSource() {
        return fileDataSource;
    }

    /**
     * Define el valor de la propiedad fileDataSource.
     * 
     * @param value
     *     allowed object is
     *     {@link FileDataSource }
     *     
     */
    public void setFileDataSource(FileDataSource value) {
        this.fileDataSource = value;
    }

}
