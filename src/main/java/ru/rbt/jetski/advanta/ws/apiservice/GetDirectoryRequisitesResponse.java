
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
 *         &lt;element name="GetDirectoryRequisitesResult" type="{http://tempuri.org/}DirectoryInfoWrapper" minOccurs="0"/>
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
    "getDirectoryRequisitesResult"
})
@XmlRootElement(name = "GetDirectoryRequisitesResponse")
public class GetDirectoryRequisitesResponse {

    @XmlElement(name = "GetDirectoryRequisitesResult")
    protected DirectoryInfoWrapper getDirectoryRequisitesResult;

    /**
     * Gets the value of the getDirectoryRequisitesResult property.
     * 
     * @return
     *     possible object is
     *     {@link DirectoryInfoWrapper }
     *     
     */
    public DirectoryInfoWrapper getGetDirectoryRequisitesResult() {
        return getDirectoryRequisitesResult;
    }

    /**
     * Sets the value of the getDirectoryRequisitesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link DirectoryInfoWrapper }
     *     
     */
    public void setGetDirectoryRequisitesResult(DirectoryInfoWrapper value) {
        this.getDirectoryRequisitesResult = value;
    }

}
