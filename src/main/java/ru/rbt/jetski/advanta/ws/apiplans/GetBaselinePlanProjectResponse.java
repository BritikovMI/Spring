
package ru.rbt.jetski.advanta.ws.apiplans;

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
 *         &lt;element name="GetBaselinePlanProjectResult" type="{http://streamline/}BaselinePlanWrapper" minOccurs="0"/>
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
    "getBaselinePlanProjectResult"
})
@XmlRootElement(name = "GetBaselinePlanProjectResponse")
public class GetBaselinePlanProjectResponse {

    @XmlElement(name = "GetBaselinePlanProjectResult")
    protected BaselinePlanWrapper getBaselinePlanProjectResult;

    /**
     * Gets the value of the getBaselinePlanProjectResult property.
     * 
     * @return
     *     possible object is
     *     {@link BaselinePlanWrapper }
     *     
     */
    public BaselinePlanWrapper getGetBaselinePlanProjectResult() {
        return getBaselinePlanProjectResult;
    }

    /**
     * Sets the value of the getBaselinePlanProjectResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link BaselinePlanWrapper }
     *     
     */
    public void setGetBaselinePlanProjectResult(BaselinePlanWrapper value) {
        this.getBaselinePlanProjectResult = value;
    }

}
