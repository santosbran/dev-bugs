
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
 *         &amp;lt;element name="updateMobileAppDefinitionInSessionReturn" type="{http://www.w3.org/2001/XMLSchema}boolean"/&amp;gt;
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
    "updateMobileAppDefinitionInSessionReturn"
})
@XmlRootElement(name = "updateMobileAppDefinitionInSessionResponse")
public class UpdateMobileAppDefinitionInSessionResponse {

    protected boolean updateMobileAppDefinitionInSessionReturn;

    /**
     * Obtiene el valor de la propiedad updateMobileAppDefinitionInSessionReturn.
     * 
     */
    public boolean isUpdateMobileAppDefinitionInSessionReturn() {
        return updateMobileAppDefinitionInSessionReturn;
    }

    /**
     * Define el valor de la propiedad updateMobileAppDefinitionInSessionReturn.
     * 
     */
    public void setUpdateMobileAppDefinitionInSessionReturn(boolean value) {
        this.updateMobileAppDefinitionInSessionReturn = value;
    }

}
