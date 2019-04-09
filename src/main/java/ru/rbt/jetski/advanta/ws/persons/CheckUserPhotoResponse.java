
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
 *         &lt;element name="CheckUserPhotoResult" type="{http://streamline/}ServiceQueryResultOfString" minOccurs="0"/>
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
    "checkUserPhotoResult"
})
@XmlRootElement(name = "CheckUserPhotoResponse")
public class CheckUserPhotoResponse {

    @XmlElement(name = "CheckUserPhotoResult")
    protected ServiceQueryResultOfString checkUserPhotoResult;

    /**
     * Gets the value of the checkUserPhotoResult property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceQueryResultOfString }
     *     
     */
    public ServiceQueryResultOfString getCheckUserPhotoResult() {
        return checkUserPhotoResult;
    }

    /**
     * Sets the value of the checkUserPhotoResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceQueryResultOfString }
     *     
     */
    public void setCheckUserPhotoResult(ServiceQueryResultOfString value) {
        this.checkUserPhotoResult = value;
    }

}
