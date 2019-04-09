
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
 *         &lt;element name="GetProjectsResult" type="{http://streamline/}ArrayOfProjectWrapper" minOccurs="0"/>
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
    "getProjectsResult"
})
@XmlRootElement(name = "GetProjectsResponse")
public class GetProjectsResponse {

    @XmlElement(name = "GetProjectsResult")
    protected ArrayOfProjectWrapper getProjectsResult;

    /**
     * Gets the value of the getProjectsResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfProjectWrapper }
     *     
     */
    public ArrayOfProjectWrapper getGetProjectsResult() {
        return getProjectsResult;
    }

    /**
     * Sets the value of the getProjectsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfProjectWrapper }
     *     
     */
    public void setGetProjectsResult(ArrayOfProjectWrapper value) {
        this.getProjectsResult = value;
    }

}
