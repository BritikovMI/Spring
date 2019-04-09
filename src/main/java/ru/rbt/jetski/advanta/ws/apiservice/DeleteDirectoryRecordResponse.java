
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
 *         &lt;element name="DeleteDirectoryRecordResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "deleteDirectoryRecordResult"
})
@XmlRootElement(name = "DeleteDirectoryRecordResponse")
public class DeleteDirectoryRecordResponse {

    @XmlElement(name = "DeleteDirectoryRecordResult")
    protected String deleteDirectoryRecordResult;

    /**
     * Gets the value of the deleteDirectoryRecordResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeleteDirectoryRecordResult() {
        return deleteDirectoryRecordResult;
    }

    /**
     * Sets the value of the deleteDirectoryRecordResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeleteDirectoryRecordResult(String value) {
        this.deleteDirectoryRecordResult = value;
    }

}
