
package com.aeroman.core.webservice;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * &lt;p&gt;Clase Java para coreAircraftFam complex type.
 * 
 * &lt;p&gt;El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="coreAircraftFam"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="arcfamCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="arcfamCreatedBy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="arcfamCreationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="arcfamDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="arcfamId" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="arcfamTramaFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="arcfamTramaId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="arcfamUpdateDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="arcfamUpdatedBy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="selectFiltro" type="{http://www.w3.org/2001/XMLSchema}boolean"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "coreAircraftFam", propOrder = {
    "arcfamCode",
    "arcfamCreatedBy",
    "arcfamCreationDate",
    "arcfamDesc",
    "arcfamId",
    "arcfamTramaFlag",
    "arcfamTramaId",
    "arcfamUpdateDate",
    "arcfamUpdatedBy",
    "selectFiltro"
})
public class CoreAircraftFam {

    protected String arcfamCode;
    protected String arcfamCreatedBy;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar arcfamCreationDate;
    protected String arcfamDesc;
    protected BigDecimal arcfamId;
    protected String arcfamTramaFlag;
    protected String arcfamTramaId;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar arcfamUpdateDate;
    protected String arcfamUpdatedBy;
    protected boolean selectFiltro;

    /**
     * Obtiene el valor de la propiedad arcfamCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArcfamCode() {
        return arcfamCode;
    }

    /**
     * Define el valor de la propiedad arcfamCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArcfamCode(String value) {
        this.arcfamCode = value;
    }

    /**
     * Obtiene el valor de la propiedad arcfamCreatedBy.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArcfamCreatedBy() {
        return arcfamCreatedBy;
    }

    /**
     * Define el valor de la propiedad arcfamCreatedBy.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArcfamCreatedBy(String value) {
        this.arcfamCreatedBy = value;
    }

    /**
     * Obtiene el valor de la propiedad arcfamCreationDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getArcfamCreationDate() {
        return arcfamCreationDate;
    }

    /**
     * Define el valor de la propiedad arcfamCreationDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setArcfamCreationDate(XMLGregorianCalendar value) {
        this.arcfamCreationDate = value;
    }

    /**
     * Obtiene el valor de la propiedad arcfamDesc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArcfamDesc() {
        return arcfamDesc;
    }

    /**
     * Define el valor de la propiedad arcfamDesc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArcfamDesc(String value) {
        this.arcfamDesc = value;
    }

    /**
     * Obtiene el valor de la propiedad arcfamId.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getArcfamId() {
        return arcfamId;
    }

    /**
     * Define el valor de la propiedad arcfamId.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setArcfamId(BigDecimal value) {
        this.arcfamId = value;
    }

    /**
     * Obtiene el valor de la propiedad arcfamTramaFlag.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArcfamTramaFlag() {
        return arcfamTramaFlag;
    }

    /**
     * Define el valor de la propiedad arcfamTramaFlag.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArcfamTramaFlag(String value) {
        this.arcfamTramaFlag = value;
    }

    /**
     * Obtiene el valor de la propiedad arcfamTramaId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArcfamTramaId() {
        return arcfamTramaId;
    }

    /**
     * Define el valor de la propiedad arcfamTramaId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArcfamTramaId(String value) {
        this.arcfamTramaId = value;
    }

    /**
     * Obtiene el valor de la propiedad arcfamUpdateDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getArcfamUpdateDate() {
        return arcfamUpdateDate;
    }

    /**
     * Define el valor de la propiedad arcfamUpdateDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setArcfamUpdateDate(XMLGregorianCalendar value) {
        this.arcfamUpdateDate = value;
    }

    /**
     * Obtiene el valor de la propiedad arcfamUpdatedBy.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArcfamUpdatedBy() {
        return arcfamUpdatedBy;
    }

    /**
     * Define el valor de la propiedad arcfamUpdatedBy.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArcfamUpdatedBy(String value) {
        this.arcfamUpdatedBy = value;
    }

    /**
     * Obtiene el valor de la propiedad selectFiltro.
     * 
     */
    public boolean isSelectFiltro() {
        return selectFiltro;
    }

    /**
     * Define el valor de la propiedad selectFiltro.
     * 
     */
    public void setSelectFiltro(boolean value) {
        this.selectFiltro = value;
    }

}
