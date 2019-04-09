
package ru.rbt.jetski.advanta.ws.persons;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LinkUserToADResult" type="{http://streamline/}ServiceQueryResultOfString" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "linkUserToADResult"
})
@XmlRootElement(name = "LinkUserToADResponse")
public class LinkUserToADResponse {

    @XmlElement(name = "LinkUserToADResult")
    protected ServiceQueryResultOfString linkUserToADResult;

    /**
     * Gets the value of the linkUserToADResult property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceQueryResultOfString }
     *     
     */
    public ServiceQueryResultOfString getLinkUserToADResult() {
        return linkUserToADResult;
    }

    /**
     * Sets the value of the linkUserToADResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceQueryResultOfString }
     *     
     */
    public void setLinkUserToADResult(ServiceQueryResultOfString value) {
        this.linkUserToADResult = value;
    }

}
