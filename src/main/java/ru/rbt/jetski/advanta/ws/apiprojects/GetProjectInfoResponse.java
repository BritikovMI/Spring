
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
 *         &lt;element name="GetProjectInfoResult" type="{http://streamline/}ProjectWrapper" minOccurs="0"/>
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
    "getProjectInfoResult"
})
@XmlRootElement(name = "GetProjectInfoResponse")
public class GetProjectInfoResponse {

    @XmlElement(name = "GetProjectInfoResult")
    protected ProjectWrapper getProjectInfoResult;

    /**
     * Gets the value of the getProjectInfoResult property.
     * 
     * @return
     *     possible object is
     *     {@link ProjectWrapper }
     *     
     */
    public ProjectWrapper getGetProjectInfoResult() {
        return getProjectInfoResult;
    }

    /**
     * Sets the value of the getProjectInfoResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProjectWrapper }
     *     
     */
    public void setGetProjectInfoResult(ProjectWrapper value) {
        this.getProjectInfoResult = value;
    }

}
