
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
 *         &lt;element name="GetPersonsXmlResult" type="{http://streamline/}UsersListWrapper" minOccurs="0"/>
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
    "getPersonsXmlResult"
})
@XmlRootElement(name = "GetPersonsXmlResponse")
public class GetPersonsXmlResponse {

    @XmlElement(name = "GetPersonsXmlResult")
    protected UsersListWrapper getPersonsXmlResult;

    /**
     * Gets the value of the getPersonsXmlResult property.
     * 
     * @return
     *     possible object is
     *     {@link UsersListWrapper }
     *     
     */
    public UsersListWrapper getGetPersonsXmlResult() {
        return getPersonsXmlResult;
    }

    /**
     * Sets the value of the getPersonsXmlResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link UsersListWrapper }
     *     
     */
    public void setGetPersonsXmlResult(UsersListWrapper value) {
        this.getPersonsXmlResult = value;
    }

}
