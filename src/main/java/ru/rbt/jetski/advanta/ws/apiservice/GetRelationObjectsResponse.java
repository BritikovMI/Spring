
package ru.rbt.jetski.advanta.ws.apiservice;

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
 *         &lt;element name="GetRelationObjectsResult" type="{http://tempuri.org/}RelationObjectsListWrapper" minOccurs="0"/>
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
    "getRelationObjectsResult"
})
@XmlRootElement(name = "GetRelationObjectsResponse")
public class GetRelationObjectsResponse {

    @XmlElement(name = "GetRelationObjectsResult")
    protected RelationObjectsListWrapper getRelationObjectsResult;

    /**
     * Gets the value of the getRelationObjectsResult property.
     * 
     * @return
     *     possible object is
     *     {@link RelationObjectsListWrapper }
     *     
     */
    public RelationObjectsListWrapper getGetRelationObjectsResult() {
        return getRelationObjectsResult;
    }

    /**
     * Sets the value of the getRelationObjectsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link RelationObjectsListWrapper }
     *     
     */
    public void setGetRelationObjectsResult(RelationObjectsListWrapper value) {
        this.getRelationObjectsResult = value;
    }

}
