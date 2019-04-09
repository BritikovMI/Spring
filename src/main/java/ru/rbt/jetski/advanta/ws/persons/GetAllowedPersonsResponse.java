
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
 *         &lt;element name="GetAllowedPersonsResult" type="{http://streamline/}PersonQueryResult" minOccurs="0"/>
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
    "getAllowedPersonsResult"
})
@XmlRootElement(name = "GetAllowedPersonsResponse")
public class GetAllowedPersonsResponse {

    @XmlElement(name = "GetAllowedPersonsResult")
    protected PersonQueryResult getAllowedPersonsResult;

    /**
     * Gets the value of the getAllowedPersonsResult property.
     * 
     * @return
     *     possible object is
     *     {@link PersonQueryResult }
     *     
     */
    public PersonQueryResult getGetAllowedPersonsResult() {
        return getAllowedPersonsResult;
    }

    /**
     * Sets the value of the getAllowedPersonsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonQueryResult }
     *     
     */
    public void setGetAllowedPersonsResult(PersonQueryResult value) {
        this.getAllowedPersonsResult = value;
    }

}
