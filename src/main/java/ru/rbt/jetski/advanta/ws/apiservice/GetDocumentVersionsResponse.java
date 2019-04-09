
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
 *         &lt;element name="GetDocumentVersionsResult" type="{http://tempuri.org/}ArrayOfDocumentVersionWrapper" minOccurs="0"/>
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
    "getDocumentVersionsResult"
})
@XmlRootElement(name = "GetDocumentVersionsResponse")
public class GetDocumentVersionsResponse {

    @XmlElement(name = "GetDocumentVersionsResult")
    protected ArrayOfDocumentVersionWrapper getDocumentVersionsResult;

    /**
     * Gets the value of the getDocumentVersionsResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfDocumentVersionWrapper }
     *     
     */
    public ArrayOfDocumentVersionWrapper getGetDocumentVersionsResult() {
        return getDocumentVersionsResult;
    }

    /**
     * Sets the value of the getDocumentVersionsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfDocumentVersionWrapper }
     *     
     */
    public void setGetDocumentVersionsResult(ArrayOfDocumentVersionWrapper value) {
        this.getDocumentVersionsResult = value;
    }

}
