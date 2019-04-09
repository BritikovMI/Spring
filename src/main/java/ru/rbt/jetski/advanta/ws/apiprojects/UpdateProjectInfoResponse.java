
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
 *         &lt;element name="UpdateProjectInfoResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "updateProjectInfoResult"
})
@XmlRootElement(name = "UpdateProjectInfoResponse")
public class UpdateProjectInfoResponse {

    @XmlElement(name = "UpdateProjectInfoResult")
    protected String updateProjectInfoResult;

    /**
     * Gets the value of the updateProjectInfoResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUpdateProjectInfoResult() {
        return updateProjectInfoResult;
    }

    /**
     * Sets the value of the updateProjectInfoResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUpdateProjectInfoResult(String value) {
        this.updateProjectInfoResult = value;
    }

}
