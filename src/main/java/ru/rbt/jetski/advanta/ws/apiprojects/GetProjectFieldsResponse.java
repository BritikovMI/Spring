
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
 *         &lt;element name="GetProjectFieldsResult" type="{http://streamline/}ArrayOfProjectFieldWrapper" minOccurs="0"/>
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
    "getProjectFieldsResult"
})
@XmlRootElement(name = "GetProjectFieldsResponse")
public class GetProjectFieldsResponse {

    @XmlElement(name = "GetProjectFieldsResult")
    protected ArrayOfProjectFieldWrapper getProjectFieldsResult;

    /**
     * Gets the value of the getProjectFieldsResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfProjectFieldWrapper }
     *     
     */
    public ArrayOfProjectFieldWrapper getGetProjectFieldsResult() {
        return getProjectFieldsResult;
    }

    /**
     * Sets the value of the getProjectFieldsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfProjectFieldWrapper }
     *     
     */
    public void setGetProjectFieldsResult(ArrayOfProjectFieldWrapper value) {
        this.getProjectFieldsResult = value;
    }

}
