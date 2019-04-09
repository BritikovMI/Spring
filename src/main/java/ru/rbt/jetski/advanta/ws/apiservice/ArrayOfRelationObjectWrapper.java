
package ru.rbt.jetski.advanta.ws.apiservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for ArrayOfRelationObjectWrapper complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfRelationObjectWrapper">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RelationObjectWrapper" type="{http://tempuri.org/}RelationObjectWrapper" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfRelationObjectWrapper", propOrder = {
    "relationObjectWrapper"
})
public class ArrayOfRelationObjectWrapper {

    @XmlElement(name = "RelationObjectWrapper", nillable = true)
    protected List<RelationObjectWrapper> relationObjectWrapper;

    /**
     * Gets the value of the relationObjectWrapper property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the relationObjectWrapper property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRelationObjectWrapper().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RelationObjectWrapper }
     * 
     * 
     */
    public List<RelationObjectWrapper> getRelationObjectWrapper() {
        if (relationObjectWrapper == null) {
            relationObjectWrapper = new ArrayList<RelationObjectWrapper>();
        }
        return this.relationObjectWrapper;
    }

}
