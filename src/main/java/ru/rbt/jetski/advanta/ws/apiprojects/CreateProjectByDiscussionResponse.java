
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
 *         &lt;element name="CreateProjectByDiscussionResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "createProjectByDiscussionResult"
})
@XmlRootElement(name = "CreateProjectByDiscussionResponse")
public class CreateProjectByDiscussionResponse {

    @XmlElement(name = "CreateProjectByDiscussionResult")
    protected String createProjectByDiscussionResult;

    /**
     * Gets the value of the createProjectByDiscussionResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreateProjectByDiscussionResult() {
        return createProjectByDiscussionResult;
    }

    /**
     * Sets the value of the createProjectByDiscussionResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreateProjectByDiscussionResult(String value) {
        this.createProjectByDiscussionResult = value;
    }

}
