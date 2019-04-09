
package ru.rbt.jetski.advanta.ws.apiservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RelationObjectsListWrapper complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RelationObjectsListWrapper">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RelationObjects" type="{http://tempuri.org/}ArrayOfRelationObjectWrapper" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RelationObjectsListWrapper", propOrder = {
    "relationObjects"
})
public class RelationObjectsListWrapper {

    @XmlElement(name = "RelationObjects")
    protected ArrayOfRelationObjectWrapper relationObjects;

    /**
     * Gets the value of the relationObjects property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfRelationObjectWrapper }
     *     
     */
    public ArrayOfRelationObjectWrapper getRelationObjects() {
        return relationObjects;
    }

    /**
     * Sets the value of the relationObjects property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfRelationObjectWrapper }
     *     
     */
    public void setRelationObjects(ArrayOfRelationObjectWrapper value) {
        this.relationObjects = value;
    }

}
