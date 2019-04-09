
package ru.rbt.jetski.advanta.ws.apiservice;

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
 *         &lt;element name="ChangeDirectoryRecordResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "changeDirectoryRecordResult"
})
@XmlRootElement(name = "ChangeDirectoryRecordResponse")
public class ChangeDirectoryRecordResponse {

    @XmlElement(name = "ChangeDirectoryRecordResult")
    protected String changeDirectoryRecordResult;

    /**
     * Gets the value of the changeDirectoryRecordResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChangeDirectoryRecordResult() {
        return changeDirectoryRecordResult;
    }

    /**
     * Sets the value of the changeDirectoryRecordResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChangeDirectoryRecordResult(String value) {
        this.changeDirectoryRecordResult = value;
    }

}
