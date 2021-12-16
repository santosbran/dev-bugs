
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
 *         &amp;lt;element name="removeObjectFromCacheReturn" type="{http://www.w3.org/2001/XMLSchema}boolean"/&amp;gt;
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
    "removeObjectFromCacheReturn"
})
@XmlRootElement(name = "removeObjectFromCacheResponse")
public class RemoveObjectFromCacheResponse {

    protected boolean removeObjectFromCacheReturn;

    /**
     * Obtiene el valor de la propiedad removeObjectFromCacheReturn.
     * 
     */
    public boolean isRemoveObjectFromCacheReturn() {
        return removeObjectFromCacheReturn;
    }

    /**
     * Define el valor de la propiedad removeObjectFromCacheReturn.
     * 
     */
    public void setRemoveObjectFromCacheReturn(boolean value) {
        this.removeObjectFromCacheReturn = value;
    }

}
