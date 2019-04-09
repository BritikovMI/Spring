
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
 *         &lt;element name="GetProjectResult" type="{http://streamline/}ProjectWrapper" minOccurs="0"/>
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
    "getProjectResult"
})
@XmlRootElement(name = "GetProjectResponse")
public class GetProjectResponse {

    @XmlElement(name = "GetProjectResult")
    protected ProjectWrapper getProjectResult;

    /**
     * Gets the value of the getProjectResult property.
     * 
     * @return
     *     possible object is
     *     {@link ProjectWrapper }
     *     
     */
    public ProjectWrapper getGetProjectResult() {
        return getProjectResult;
    }

    /**
     * Sets the value of the getProjectResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProjectWrapper }
     *     
     */
    public void setGetProjectResult(ProjectWrapper value) {
        this.getProjectResult = value;
    }

}
