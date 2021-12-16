
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
 *         &amp;lt;element name="reportName" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="folderAbsolutePathURL" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="dataModelURL" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="templateFileName" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="templateData" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&amp;gt;
 *         &amp;lt;element name="XLIFFFileName" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="XLIFFData" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&amp;gt;
 *         &amp;lt;element name="updateFlag" type="{http://www.w3.org/2001/XMLSchema}boolean"/&amp;gt;
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
    "reportName",
    "folderAbsolutePathURL",
    "dataModelURL",
    "templateFileName",
    "templateData",
    "xliffFileName",
    "xliffData",
    "updateFlag",
    "userID",
    "password"
})
@XmlRootElement(name = "createReport")
public class CreateReport {

    @XmlElement(required = true)
    protected String reportName;
    @XmlElement(required = true)
    protected String folderAbsolutePathURL;
    @XmlElement(required = true)
    protected String dataModelURL;
    @XmlElement(required = true)
    protected String templateFileName;
    @XmlElement(required = true)
    protected byte[] templateData;
    @XmlElement(name = "XLIFFFileName", required = true)
    protected String xliffFileName;
    @XmlElement(name = "XLIFFData", required = true)
    protected byte[] xliffData;
    protected boolean updateFlag;
    @XmlElement(required = true)
    protected String userID;
    @XmlElement(required = true)
    protected String password;

    /**
     * Obtiene el valor de la propiedad reportName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportName() {
        return reportName;
    }

    /**
     * Define el valor de la propiedad reportName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportName(String value) {
        this.reportName = value;
    }

    /**
     * Obtiene el valor de la propiedad folderAbsolutePathURL.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFolderAbsolutePathURL() {
        return folderAbsolutePathURL;
    }

    /**
     * Define el valor de la propiedad folderAbsolutePathURL.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFolderAbsolutePathURL(String value) {
        this.folderAbsolutePathURL = value;
    }

    /**
     * Obtiene el valor de la propiedad dataModelURL.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataModelURL() {
        return dataModelURL;
    }

    /**
     * Define el valor de la propiedad dataModelURL.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataModelURL(String value) {
        this.dataModelURL = value;
    }

    /**
     * Obtiene el valor de la propiedad templateFileName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemplateFileName() {
        return templateFileName;
    }

    /**
     * Define el valor de la propiedad templateFileName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemplateFileName(String value) {
        this.templateFileName = value;
    }

    /**
     * Obtiene el valor de la propiedad templateData.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getTemplateData() {
        return templateData;
    }

    /**
     * Define el valor de la propiedad templateData.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setTemplateData(byte[] value) {
        this.templateData = value;
    }

    /**
     * Obtiene el valor de la propiedad xliffFileName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXLIFFFileName() {
        return xliffFileName;
    }

    /**
     * Define el valor de la propiedad xliffFileName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXLIFFFileName(String value) {
        this.xliffFileName = value;
    }

    /**
     * Obtiene el valor de la propiedad xliffData.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getXLIFFData() {
        return xliffData;
    }

    /**
     * Define el valor de la propiedad xliffData.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setXLIFFData(byte[] value) {
        this.xliffData = value;
    }

    /**
     * Obtiene el valor de la propiedad updateFlag.
     * 
     */
    public boolean isUpdateFlag() {
        return updateFlag;
    }

    /**
     * Define el valor de la propiedad updateFlag.
     * 
     */
    public void setUpdateFlag(boolean value) {
        this.updateFlag = value;
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
