
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
 *         &lt;element name="GetDirectoriesListResult" type="{http://tempuri.org/}DirectoriesListWrapper" minOccurs="0"/>
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
    "getDirectoriesListResult"
})
@XmlRootElement(name = "GetDirectoriesListResponse")
public class GetDirectoriesListResponse {

    @XmlElement(name = "GetDirectoriesListResult")
    protected DirectoriesListWrapper getDirectoriesListResult;

    /**
     * Gets the value of the getDirectoriesListResult property.
     * 
     * @return
     *     possible object is
     *     {@link DirectoriesListWrapper }
     *     
     */
    public DirectoriesListWrapper getGetDirectoriesListResult() {
        return getDirectoriesListResult;
    }

    /**
     * Sets the value of the getDirectoriesListResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link DirectoriesListWrapper }
     *     
     */
    public void setGetDirectoriesListResult(DirectoriesListWrapper value) {
        this.getDirectoriesListResult = value;
    }

}
