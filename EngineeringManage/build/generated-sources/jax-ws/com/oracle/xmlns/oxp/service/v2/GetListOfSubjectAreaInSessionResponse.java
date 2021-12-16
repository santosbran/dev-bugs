
package com.oracle.xmlns.oxp.service.v2;

import java.util.ArrayList;
import java.util.List;
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
 *         &amp;lt;element name="getListOfSubjectAreaInSessionReturn" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/&amp;gt;
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
    "getListOfSubjectAreaInSessionReturn"
})
@XmlRootElement(name = "getListOfSubjectAreaInSessionResponse")
public class GetListOfSubjectAreaInSessionResponse {

    @XmlElement(required = true)
    protected List<String> getListOfSubjectAreaInSessionReturn;

    /**
     * Gets the value of the getListOfSubjectAreaInSessionReturn property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the getListOfSubjectAreaInSessionReturn property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getGetListOfSubjectAreaInSessionReturn().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getGetListOfSubjectAreaInSessionReturn() {
        if (getListOfSubjectAreaInSessionReturn == null) {
            getListOfSubjectAreaInSessionReturn = new ArrayList<String>();
        }
        return this.getListOfSubjectAreaInSessionReturn;
    }

}
