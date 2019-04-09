
package ru.rbt.jetski.advanta.ws.apiprojects;

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
 *         &lt;element name="ChangeParentResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "changeParentResult"
})
@XmlRootElement(name = "ChangeParentResponse")
public class ChangeParentResponse {

    @XmlElement(name = "ChangeParentResult")
    protected String changeParentResult;

    /**
     * Gets the value of the changeParentResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChangeParentResult() {
        return changeParentResult;
    }

    /**
     * Sets the value of the changeParentResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChangeParentResult(String value) {
        this.changeParentResult = value;
    }

}
