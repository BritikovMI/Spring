
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
 *         &lt;element name="GetProjectsUidsByTypeResult" type="{http://streamline/}ArrayOfProjectWrapper" minOccurs="0"/>
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
    "getProjectsUidsByTypeResult"
})
@XmlRootElement(name = "GetProjectsUidsByTypeResponse")
public class GetProjectsUidsByTypeResponse {

    @XmlElement(name = "GetProjectsUidsByTypeResult")
    protected ArrayOfProjectWrapper getProjectsUidsByTypeResult;

    /**
     * Gets the value of the getProjectsUidsByTypeResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfProjectWrapper }
     *     
     */
    public ArrayOfProjectWrapper getGetProjectsUidsByTypeResult() {
        return getProjectsUidsByTypeResult;
    }

    /**
     * Sets the value of the getProjectsUidsByTypeResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfProjectWrapper }
     *     
     */
    public void setGetProjectsUidsByTypeResult(ArrayOfProjectWrapper value) {
        this.getProjectsUidsByTypeResult = value;
    }

}
