
package ru.rbt.jetski.advanta.ws.apiprojects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="project" type="{http://streamline/}GetGroupsWithPersonsIdsAllowedToWriteDiscussionDataContract" minOccurs="0"/>
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
    "project"
})
@XmlRootElement(name = "GetGroupsWithPersonsIdsAllowedToWriteDiscussion")
public class GetGroupsWithPersonsIdsAllowedToWriteDiscussion {

    protected GetGroupsWithPersonsIdsAllowedToWriteDiscussionDataContract project;

    /**
     * Gets the value of the project property.
     * 
     * @return
     *     possible object is
     *     {@link GetGroupsWithPersonsIdsAllowedToWriteDiscussionDataContract }
     *     
     */
    public GetGroupsWithPersonsIdsAllowedToWriteDiscussionDataContract getProject() {
        return project;
    }

    /**
     * Sets the value of the project property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetGroupsWithPersonsIdsAllowedToWriteDiscussionDataContract }
     *     
     */
    public void setProject(GetGroupsWithPersonsIdsAllowedToWriteDiscussionDataContract value) {
        this.project = value;
    }

}
