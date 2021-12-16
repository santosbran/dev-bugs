
package com.aeroman.core.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Clase Java para coreCreate complex type.
 * 
 * &lt;p&gt;El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="coreCreate"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="coreFamPJ" type="{http://webservice.core.aeroman.com/}coreAircraftFamPJ" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "coreCreate", propOrder = {
    "coreFamPJ"
})
public class CoreCreate {

    protected CoreAircraftFamPJ coreFamPJ;

    /**
     * Obtiene el valor de la propiedad coreFamPJ.
     * 
     * @return
     *     possible object is
     *     {@link CoreAircraftFamPJ }
     *     
     */
    public CoreAircraftFamPJ getCoreFamPJ() {
        return coreFamPJ;
    }

    /**
     * Define el valor de la propiedad coreFamPJ.
     * 
     * @param value
     *     allowed object is
     *     {@link CoreAircraftFamPJ }
     *     
     */
    public void setCoreFamPJ(CoreAircraftFamPJ value) {
        this.coreFamPJ = value;
    }

}
