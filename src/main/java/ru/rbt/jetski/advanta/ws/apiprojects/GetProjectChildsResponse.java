
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
 *         &lt;element name="GetProjectChildsResult" type="{http://streamline/}ArrayOfProjectChildWrapper" minOccurs="0"/>
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
    "getProjectChildsResult"
})
@XmlRootElement(name = "GetProjectChildsResponse")
public class GetProjectChildsResponse {

    @XmlElement(name = "GetProjectChildsResult")
    protected ArrayOfProjectChildWrapper getProjectChildsResult;

    /**
     * Gets the value of the getProjectChildsResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfProjectChildWrapper }
     *     
     */
    public ArrayOfProjectChildWrapper getGetProjectChildsResult() {
        return getProjectChildsResult;
    }

    /**
     * Sets the value of the getProjectChildsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfProjectChildWrapper }
     *     
     */
    public void setGetProjectChildsResult(ArrayOfProjectChildWrapper value) {
        this.getProjectChildsResult = value;
    }

}
