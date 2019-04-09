
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
 *         &lt;element name="GetClassifierRecordsResult" type="{http://tempuri.org/}RecordsListWrapper" minOccurs="0"/>
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
    "getClassifierRecordsResult"
})
@XmlRootElement(name = "GetClassifierRecordsResponse")
public class GetClassifierRecordsResponse {

    @XmlElement(name = "GetClassifierRecordsResult")
    protected RecordsListWrapper getClassifierRecordsResult;

    /**
     * Gets the value of the getClassifierRecordsResult property.
     * 
     * @return
     *     possible object is
     *     {@link RecordsListWrapper }
     *     
     */
    public RecordsListWrapper getGetClassifierRecordsResult() {
        return getClassifierRecordsResult;
    }

    /**
     * Sets the value of the getClassifierRecordsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link RecordsListWrapper }
     *     
     */
    public void setGetClassifierRecordsResult(RecordsListWrapper value) {
        this.getClassifierRecordsResult = value;
    }

}
