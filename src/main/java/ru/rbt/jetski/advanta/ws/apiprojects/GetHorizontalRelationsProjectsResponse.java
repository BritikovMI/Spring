
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
 *         &lt;element name="GetHorizontalRelationsProjectsResult" type="{http://streamline/}ArrayOfRelationdWrapper" minOccurs="0"/>
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
    "getHorizontalRelationsProjectsResult"
})
@XmlRootElement(name = "GetHorizontalRelationsProjectsResponse")
public class GetHorizontalRelationsProjectsResponse {

    @XmlElement(name = "GetHorizontalRelationsProjectsResult")
    protected ArrayOfRelationdWrapper getHorizontalRelationsProjectsResult;

    /**
     * Gets the value of the getHorizontalRelationsProjectsResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfRelationdWrapper }
     *     
     */
    public ArrayOfRelationdWrapper getGetHorizontalRelationsProjectsResult() {
        return getHorizontalRelationsProjectsResult;
    }

    /**
     * Sets the value of the getHorizontalRelationsProjectsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfRelationdWrapper }
     *     
     */
    public void setGetHorizontalRelationsProjectsResult(ArrayOfRelationdWrapper value) {
        this.getHorizontalRelationsProjectsResult = value;
    }

}
