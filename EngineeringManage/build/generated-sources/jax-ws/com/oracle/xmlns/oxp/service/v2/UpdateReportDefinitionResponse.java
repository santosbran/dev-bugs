
package com.oracle.xmlns.oxp.service.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &amp;lt;element name="updateReportDefinitionReturn" type="{http://www.w3.org/2001/XMLSchema}boolean"/&amp;gt;
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
    "updateReportDefinitionReturn"
})
@XmlRootElement(name = "updateReportDefinitionResponse")
public class UpdateReportDefinitionResponse {

    protected boolean updateReportDefinitionReturn;

    /**
     * Obtiene el valor de la propiedad updateReportDefinitionReturn.
     * 
     */
    public boolean isUpdateReportDefinitionReturn() {
        return updateReportDefinitionReturn;
    }

    /**
     * Define el valor de la propiedad updateReportDefinitionReturn.
     * 
     */
    public void setUpdateReportDefinitionReturn(boolean value) {
        this.updateReportDefinitionReturn = value;
    }

}
