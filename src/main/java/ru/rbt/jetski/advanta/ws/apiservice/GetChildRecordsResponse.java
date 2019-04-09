
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
 *         &lt;element name="GetChildRecordsResult" type="{http://tempuri.org/}RecordsListWrapper" minOccurs="0"/>
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
    "getChildRecordsResult"
})
@XmlRootElement(name = "GetChildRecordsResponse")
public class GetChildRecordsResponse {

    @XmlElement(name = "GetChildRecordsResult")
    protected RecordsListWrapper getChildRecordsResult;

    /**
     * Gets the value of the getChildRecordsResult property.
     * 
     * @return
     *     possible object is
     *     {@link RecordsListWrapper }
     *     
     */
    public RecordsListWrapper getGetChildRecordsResult() {
        return getChildRecordsResult;
    }

    /**
     * Sets the value of the getChildRecordsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link RecordsListWrapper }
     *     
     */
    public void setGetChildRecordsResult(RecordsListWrapper value) {
        this.getChildRecordsResult = value;
    }

}
