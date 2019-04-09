
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
 *         &lt;element name="GetRecordsResult" type="{http://tempuri.org/}RecordsListWrapper" minOccurs="0"/>
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
    "getRecordsResult"
})
@XmlRootElement(name = "GetRecordsResponse")
public class GetRecordsResponse {

    @XmlElement(name = "GetRecordsResult")
    protected RecordsListWrapper getRecordsResult;

    /**
     * Gets the value of the getRecordsResult property.
     * 
     * @return
     *     possible object is
     *     {@link RecordsListWrapper }
     *     
     */
    public RecordsListWrapper getGetRecordsResult() {
        return getRecordsResult;
    }

    /**
     * Sets the value of the getRecordsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link RecordsListWrapper }
     *     
     */
    public void setGetRecordsResult(RecordsListWrapper value) {
        this.getRecordsResult = value;
    }

}
