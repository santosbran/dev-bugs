
package com.oracle.xmlns.oxp.service.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Clase Java para MetaDataList complex type.
 * 
 * &lt;p&gt;El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="MetaDataList"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="metaDataList" type="{http://xmlns.oracle.com/oxp/service/v2}ArrayOfMetaData"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MetaDataList", propOrder = {
    "metaDataList"
})
public class MetaDataList {

    @XmlElement(required = true, nillable = true)
    protected ArrayOfMetaData metaDataList;

    /**
     * Obtiene el valor de la propiedad metaDataList.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfMetaData }
     *     
     */
    public ArrayOfMetaData getMetaDataList() {
        return metaDataList;
    }

    /**
     * Define el valor de la propiedad metaDataList.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfMetaData }
     *     
     */
    public void setMetaDataList(ArrayOfMetaData value) {
        this.metaDataList = value;
    }

}
