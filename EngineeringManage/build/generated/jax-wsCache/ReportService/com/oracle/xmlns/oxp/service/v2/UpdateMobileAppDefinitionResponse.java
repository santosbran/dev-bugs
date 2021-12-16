
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
 *         &amp;lt;element name="updateMobileAppDefinitionReturn" type="{http://www.w3.org/2001/XMLSchema}boolean"/&amp;gt;
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
    "updateMobileAppDefinitionReturn"
})
@XmlRootElement(name = "updateMobileAppDefinitionResponse")
public class UpdateMobileAppDefinitionResponse {

    protected boolean updateMobileAppDefinitionReturn;

    /**
     * Obtiene el valor de la propiedad updateMobileAppDefinitionReturn.
     * 
     */
    public boolean isUpdateMobileAppDefinitionReturn() {
        return updateMobileAppDefinitionReturn;
    }

    /**
     * Define el valor de la propiedad updateMobileAppDefinitionReturn.
     * 
     */
    public void setUpdateMobileAppDefinitionReturn(boolean value) {
        this.updateMobileAppDefinitionReturn = value;
    }

}
