
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
 *         &lt;element name="InsertDirectoryRecordResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "insertDirectoryRecordResult"
})
@XmlRootElement(name = "InsertDirectoryRecordResponse")
public class InsertDirectoryRecordResponse {

    @XmlElement(name = "InsertDirectoryRecordResult")
    protected String insertDirectoryRecordResult;

    /**
     * Gets the value of the insertDirectoryRecordResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInsertDirectoryRecordResult() {
        return insertDirectoryRecordResult;
    }

    /**
     * Sets the value of the insertDirectoryRecordResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInsertDirectoryRecordResult(String value) {
        this.insertDirectoryRecordResult = value;
    }

}
