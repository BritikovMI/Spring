
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
 *         &lt;element name="UpdateProjectFieldsResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "updateProjectFieldsResult"
})
@XmlRootElement(name = "UpdateProjectFieldsResponse")
public class UpdateProjectFieldsResponse {

    @XmlElement(name = "UpdateProjectFieldsResult")
    protected String updateProjectFieldsResult;

    /**
     * Gets the value of the updateProjectFieldsResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUpdateProjectFieldsResult() {
        return updateProjectFieldsResult;
    }

    /**
     * Sets the value of the updateProjectFieldsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUpdateProjectFieldsResult(String value) {
        this.updateProjectFieldsResult = value;
    }

}
