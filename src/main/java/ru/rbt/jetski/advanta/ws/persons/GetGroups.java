
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
 *         &lt;element name="ASPNETSessionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "aspnetSessionId"
})
@XmlRootElement(name = "GetGroups")
public class GetGroups {

    @XmlElement(name = "ASPNETSessionId")
    protected String aspnetSessionId;

    /**
     * Gets the value of the aspnetSessionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getASPNETSessionId() {
        return aspnetSessionId;
    }

    /**
     * Sets the value of the aspnetSessionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setASPNETSessionId(String value) {
        this.aspnetSessionId = value;
    }

}