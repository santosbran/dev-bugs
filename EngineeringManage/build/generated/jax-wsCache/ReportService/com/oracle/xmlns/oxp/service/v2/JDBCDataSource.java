
package com.oracle.xmlns.oxp.service.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Clase Java para JDBCDataSource complex type.
 * 
 * &lt;p&gt;El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="JDBCDataSource"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="JDBCDriverClass" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="JDBCDriverType" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="JDBCPassword" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="JDBCURL" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="JDBCUserName" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="dataSourceName" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="postProcessFunc" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="preProcessFunc" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="useProxyAuth" type="{http://www.w3.org/2001/XMLSchema}boolean"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JDBCDataSource", propOrder = {
    "jdbcDriverClass",
    "jdbcDriverType",
    "jdbcPassword",
    "jdbcurl",
    "jdbcUserName",
    "dataSourceName",
    "postProcessFunc",
    "preProcessFunc",
    "useProxyAuth"
})
public class JDBCDataSource {

    @XmlElement(name = "JDBCDriverClass", required = true, nillable = true)
    protected String jdbcDriverClass;
    @XmlElement(name = "JDBCDriverType", required = true, nillable = true)
    protected String jdbcDriverType;
    @XmlElement(name = "JDBCPassword", required = true, nillable = true)
    protected String jdbcPassword;
    @XmlElement(name = "JDBCURL", required = true, nillable = true)
    protected String jdbcurl;
    @XmlElement(name = "JDBCUserName", required = true, nillable = true)
    protected String jdbcUserName;
    @XmlElement(required = true, nillable = true)
    protected String dataSourceName;
    @XmlElement(required = true, nillable = true)
    protected String postProcessFunc;
    @XmlElement(required = true, nillable = true)
    protected String preProcessFunc;
    protected boolean useProxyAuth;

    /**
     * Obtiene el valor de la propiedad jdbcDriverClass.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJDBCDriverClass() {
        return jdbcDriverClass;
    }

    /**
     * Define el valor de la propiedad jdbcDriverClass.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJDBCDriverClass(String value) {
        this.jdbcDriverClass = value;
    }

    /**
     * Obtiene el valor de la propiedad jdbcDriverType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJDBCDriverType() {
        return jdbcDriverType;
    }

    /**
     * Define el valor de la propiedad jdbcDriverType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJDBCDriverType(String value) {
        this.jdbcDriverType = value;
    }

    /**
     * Obtiene el valor de la propiedad jdbcPassword.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJDBCPassword() {
        return jdbcPassword;
    }

    /**
     * Define el valor de la propiedad jdbcPassword.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJDBCPassword(String value) {
        this.jdbcPassword = value;
    }

    /**
     * Obtiene el valor de la propiedad jdbcurl.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJDBCURL() {
        return jdbcurl;
    }

    /**
     * Define el valor de la propiedad jdbcurl.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJDBCURL(String value) {
        this.jdbcurl = value;
    }

    /**
     * Obtiene el valor de la propiedad jdbcUserName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJDBCUserName() {
        return jdbcUserName;
    }

    /**
     * Define el valor de la propiedad jdbcUserName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJDBCUserName(String value) {
        this.jdbcUserName = value;
    }

    /**
     * Obtiene el valor de la propiedad dataSourceName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataSourceName() {
        return dataSourceName;
    }

    /**
     * Define el valor de la propiedad dataSourceName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataSourceName(String value) {
        this.dataSourceName = value;
    }

    /**
     * Obtiene el valor de la propiedad postProcessFunc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostProcessFunc() {
        return postProcessFunc;
    }

    /**
     * Define el valor de la propiedad postProcessFunc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostProcessFunc(String value) {
        this.postProcessFunc = value;
    }

    /**
     * Obtiene el valor de la propiedad preProcessFunc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreProcessFunc() {
        return preProcessFunc;
    }

    /**
     * Define el valor de la propiedad preProcessFunc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreProcessFunc(String value) {
        this.preProcessFunc = value;
    }

    /**
     * Obtiene el valor de la propiedad useProxyAuth.
     * 
     */
    public boolean isUseProxyAuth() {
        return useProxyAuth;
    }

    /**
     * Define el valor de la propiedad useProxyAuth.
     * 
     */
    public void setUseProxyAuth(boolean value) {
        this.useProxyAuth = value;
    }

}
