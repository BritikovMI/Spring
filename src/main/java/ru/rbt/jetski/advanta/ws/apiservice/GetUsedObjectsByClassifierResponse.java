
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
 *         &lt;element name="GetUsedObjectsByClassifierResult" type="{http://tempuri.org/}DirectoriesListWrapper" minOccurs="0"/>
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
    "getUsedObjectsByClassifierResult"
})
@XmlRootElement(name = "GetUsedObjectsByClassifierResponse")
public class GetUsedObjectsByClassifierResponse {

    @XmlElement(name = "GetUsedObjectsByClassifierResult")
    protected DirectoriesListWrapper getUsedObjectsByClassifierResult;

    /**
     * Gets the value of the getUsedObjectsByClassifierResult property.
     * 
     * @return
     *     possible object is
     *     {@link DirectoriesListWrapper }
     *     
     */
    public DirectoriesListWrapper getGetUsedObjectsByClassifierResult() {
        return getUsedObjectsByClassifierResult;
    }

    /**
     * Sets the value of the getUsedObjectsByClassifierResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link DirectoriesListWrapper }
     *     
     */
    public void setGetUsedObjectsByClassifierResult(DirectoriesListWrapper value) {
        this.getUsedObjectsByClassifierResult = value;
    }

}
