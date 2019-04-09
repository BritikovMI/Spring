
package ru.rbt.jetski.advanta.ws.persons;

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
 *         &lt;element name="GetGroupsResult" type="{http://streamline/}GroupQueryResult" minOccurs="0"/>
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
    "getGroupsResult"
})
@XmlRootElement(name = "GetGroupsResponse")
public class GetGroupsResponse {

    @XmlElement(name = "GetGroupsResult")
    protected GroupQueryResult getGroupsResult;

    /**
     * Gets the value of the getGroupsResult property.
     * 
     * @return
     *     possible object is
     *     {@link GroupQueryResult }
     *     
     */
    public GroupQueryResult getGetGroupsResult() {
        return getGroupsResult;
    }

    /**
     * Sets the value of the getGroupsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GroupQueryResult }
     *     
     */
    public void setGetGroupsResult(GroupQueryResult value) {
        this.getGroupsResult = value;
    }

}
