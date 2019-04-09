
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
 *         &lt;element name="GetDirectoryInfoResult" type="{http://tempuri.org/}DirectoryInfoWrapper" minOccurs="0"/>
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
    "getDirectoryInfoResult"
})
@XmlRootElement(name = "GetDirectoryInfoResponse")
public class GetDirectoryInfoResponse {

    @XmlElement(name = "GetDirectoryInfoResult")
    protected DirectoryInfoWrapper getDirectoryInfoResult;

    /**
     * Gets the value of the getDirectoryInfoResult property.
     * 
     * @return
     *     possible object is
     *     {@link DirectoryInfoWrapper }
     *     
     */
    public DirectoryInfoWrapper getGetDirectoryInfoResult() {
        return getDirectoryInfoResult;
    }

    /**
     * Sets the value of the getDirectoryInfoResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link DirectoryInfoWrapper }
     *     
     */
    public void setGetDirectoryInfoResult(DirectoryInfoWrapper value) {
        this.getDirectoryInfoResult = value;
    }

}
