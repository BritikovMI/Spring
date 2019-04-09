
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
 *         &lt;element name="GetGroupsWithPersonsIdsAllowedToWriteDiscussionResult" type="{http://streamline/}ArrayOfPersonsGroupWrapper" minOccurs="0"/>
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
    "getGroupsWithPersonsIdsAllowedToWriteDiscussionResult"
})
@XmlRootElement(name = "GetGroupsWithPersonsIdsAllowedToWriteDiscussionResponse")
public class GetGroupsWithPersonsIdsAllowedToWriteDiscussionResponse {

    @XmlElement(name = "GetGroupsWithPersonsIdsAllowedToWriteDiscussionResult")
    protected ArrayOfPersonsGroupWrapper getGroupsWithPersonsIdsAllowedToWriteDiscussionResult;

    /**
     * Gets the value of the getGroupsWithPersonsIdsAllowedToWriteDiscussionResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfPersonsGroupWrapper }
     *     
     */
    public ArrayOfPersonsGroupWrapper getGetGroupsWithPersonsIdsAllowedToWriteDiscussionResult() {
        return getGroupsWithPersonsIdsAllowedToWriteDiscussionResult;
    }

    /**
     * Sets the value of the getGroupsWithPersonsIdsAllowedToWriteDiscussionResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfPersonsGroupWrapper }
     *     
     */
    public void setGetGroupsWithPersonsIdsAllowedToWriteDiscussionResult(ArrayOfPersonsGroupWrapper value) {
        this.getGroupsWithPersonsIdsAllowedToWriteDiscussionResult = value;
    }

}
