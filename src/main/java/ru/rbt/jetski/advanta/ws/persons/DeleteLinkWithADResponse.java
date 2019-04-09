
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
 *         &lt;element name="DeleteLinkWithADResult" type="{http://streamline/}ServiceQueryResultOfString" minOccurs="0"/>
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
    "deleteLinkWithADResult"
})
@XmlRootElement(name = "DeleteLinkWithADResponse")
public class DeleteLinkWithADResponse {

    @XmlElement(name = "DeleteLinkWithADResult")
    protected ServiceQueryResultOfString deleteLinkWithADResult;

    /**
     * Gets the value of the deleteLinkWithADResult property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceQueryResultOfString }
     *     
     */
    public ServiceQueryResultOfString getDeleteLinkWithADResult() {
        return deleteLinkWithADResult;
    }

    /**
     * Sets the value of the deleteLinkWithADResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceQueryResultOfString }
     *     
     */
    public void setDeleteLinkWithADResult(ServiceQueryResultOfString value) {
        this.deleteLinkWithADResult = value;
    }

}
