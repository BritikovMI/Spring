
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
 *         &lt;element name="GetProjectResourceAssignmentsResult" type="{http://streamline/}ArrayOfResourceAssignmentWrapper" minOccurs="0"/>
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
    "getProjectResourceAssignmentsResult"
})
@XmlRootElement(name = "GetProjectResourceAssignmentsResponse")
public class GetProjectResourceAssignmentsResponse {

    @XmlElement(name = "GetProjectResourceAssignmentsResult")
    protected ArrayOfResourceAssignmentWrapper getProjectResourceAssignmentsResult;

    /**
     * Gets the value of the getProjectResourceAssignmentsResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfResourceAssignmentWrapper }
     *     
     */
    public ArrayOfResourceAssignmentWrapper getGetProjectResourceAssignmentsResult() {
        return getProjectResourceAssignmentsResult;
    }

    /**
     * Sets the value of the getProjectResourceAssignmentsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfResourceAssignmentWrapper }
     *     
     */
    public void setGetProjectResourceAssignmentsResult(ArrayOfResourceAssignmentWrapper value) {
        this.getProjectResourceAssignmentsResult = value;
    }

}
