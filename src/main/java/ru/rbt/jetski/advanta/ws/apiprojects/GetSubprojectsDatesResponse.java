
package ru.rbt.jetski.advanta.ws.apiprojects;

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
 *         &lt;element name="GetSubprojectsDatesResult" type="{http://streamline/}ArrayOfProjectWrapper" minOccurs="0"/>
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
    "getSubprojectsDatesResult"
})
@XmlRootElement(name = "GetSubprojectsDatesResponse")
public class GetSubprojectsDatesResponse {

    @XmlElement(name = "GetSubprojectsDatesResult")
    protected ArrayOfProjectWrapper getSubprojectsDatesResult;

    /**
     * Gets the value of the getSubprojectsDatesResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfProjectWrapper }
     *     
     */
    public ArrayOfProjectWrapper getGetSubprojectsDatesResult() {
        return getSubprojectsDatesResult;
    }

    /**
     * Sets the value of the getSubprojectsDatesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfProjectWrapper }
     *     
     */
    public void setGetSubprojectsDatesResult(ArrayOfProjectWrapper value) {
        this.getSubprojectsDatesResult = value;
    }

}
