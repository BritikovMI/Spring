
package ru.rbt.jetski.advanta.ws.login;

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
 *         &lt;element name="PersonalIndicatorsResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "personalIndicatorsResult"
})
@XmlRootElement(name = "PersonalIndicatorsResponse")
public class PersonalIndicatorsResponse {

    @XmlElement(name = "PersonalIndicatorsResult")
    protected String personalIndicatorsResult;

    /**
     * Gets the value of the personalIndicatorsResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPersonalIndicatorsResult() {
        return personalIndicatorsResult;
    }

    /**
     * Sets the value of the personalIndicatorsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPersonalIndicatorsResult(String value) {
        this.personalIndicatorsResult = value;
    }

}
