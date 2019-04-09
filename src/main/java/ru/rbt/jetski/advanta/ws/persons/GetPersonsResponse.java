
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
 *         &lt;element name="GetPersonsResult" type="{http://streamline/}PersonQueryResult" minOccurs="0"/>
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
    "getPersonsResult"
})
@XmlRootElement(name = "GetPersonsResponse")
public class GetPersonsResponse {

    @XmlElement(name = "GetPersonsResult")
    protected PersonQueryResult getPersonsResult;

    /**
     * Gets the value of the getPersonsResult property.
     * 
     * @return
     *     possible object is
     *     {@link PersonQueryResult }
     *     
     */
    public PersonQueryResult getGetPersonsResult() {
        return getPersonsResult;
    }

    /**
     * Sets the value of the getPersonsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonQueryResult }
     *     
     */
    public void setGetPersonsResult(PersonQueryResult value) {
        this.getPersonsResult = value;
    }

}
