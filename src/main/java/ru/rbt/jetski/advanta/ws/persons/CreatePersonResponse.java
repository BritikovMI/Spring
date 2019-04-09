
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
 *         &lt;element name="CreatePersonResult" type="{http://streamline/}ServiceQueryResultOfString" minOccurs="0"/>
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
    "createPersonResult"
})
@XmlRootElement(name = "CreatePersonResponse")
public class CreatePersonResponse {

    @XmlElement(name = "CreatePersonResult")
    protected ServiceQueryResultOfString createPersonResult;

    /**
     * Gets the value of the createPersonResult property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceQueryResultOfString }
     *     
     */
    public ServiceQueryResultOfString getCreatePersonResult() {
        return createPersonResult;
    }

    /**
     * Sets the value of the createPersonResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceQueryResultOfString }
     *     
     */
    public void setCreatePersonResult(ServiceQueryResultOfString value) {
        this.createPersonResult = value;
    }

}
