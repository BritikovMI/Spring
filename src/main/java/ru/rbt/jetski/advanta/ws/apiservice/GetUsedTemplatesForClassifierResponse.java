
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
 *         &lt;element name="GetUsedTemplatesForClassifierResult" type="{http://tempuri.org/}DirectoriesListWrapper" minOccurs="0"/>
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
    "getUsedTemplatesForClassifierResult"
})
@XmlRootElement(name = "GetUsedTemplatesForClassifierResponse")
public class GetUsedTemplatesForClassifierResponse {

    @XmlElement(name = "GetUsedTemplatesForClassifierResult")
    protected DirectoriesListWrapper getUsedTemplatesForClassifierResult;

    /**
     * Gets the value of the getUsedTemplatesForClassifierResult property.
     * 
     * @return
     *     possible object is
     *     {@link DirectoriesListWrapper }
     *     
     */
    public DirectoriesListWrapper getGetUsedTemplatesForClassifierResult() {
        return getUsedTemplatesForClassifierResult;
    }

    /**
     * Sets the value of the getUsedTemplatesForClassifierResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link DirectoriesListWrapper }
     *     
     */
    public void setGetUsedTemplatesForClassifierResult(DirectoriesListWrapper value) {
        this.getUsedTemplatesForClassifierResult = value;
    }

}
