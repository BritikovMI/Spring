
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
 *         &lt;element name="GetDataKeyResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "getDataKeyResult"
})
@XmlRootElement(name = "GetDataKeyResponse")
public class GetDataKeyResponse {

    @XmlElement(name = "GetDataKeyResult")
    protected String getDataKeyResult;

    /**
     * Gets the value of the getDataKeyResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetDataKeyResult() {
        return getDataKeyResult;
    }

    /**
     * Sets the value of the getDataKeyResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetDataKeyResult(String value) {
        this.getDataKeyResult = value;
    }

}
