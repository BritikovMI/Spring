
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
 *         &lt;element name="EditPersonResult" type="{http://streamline/}ServiceQueryResultOfString" minOccurs="0"/>
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
    "editPersonResult"
})
@XmlRootElement(name = "EditPersonResponse")
public class EditPersonResponse {

    @XmlElement(name = "EditPersonResult")
    protected ServiceQueryResultOfString editPersonResult;

    /**
     * Gets the value of the editPersonResult property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceQueryResultOfString }
     *     
     */
    public ServiceQueryResultOfString getEditPersonResult() {
        return editPersonResult;
    }

    /**
     * Sets the value of the editPersonResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceQueryResultOfString }
     *     
     */
    public void setEditPersonResult(ServiceQueryResultOfString value) {
        this.editPersonResult = value;
    }

}
