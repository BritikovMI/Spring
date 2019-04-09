
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
 *         &lt;element name="InsertObjectToProjectRelationResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "insertObjectToProjectRelationResult"
})
@XmlRootElement(name = "InsertObjectToProjectRelationResponse")
public class InsertObjectToProjectRelationResponse {

    @XmlElement(name = "InsertObjectToProjectRelationResult")
    protected String insertObjectToProjectRelationResult;

    /**
     * Gets the value of the insertObjectToProjectRelationResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInsertObjectToProjectRelationResult() {
        return insertObjectToProjectRelationResult;
    }

    /**
     * Sets the value of the insertObjectToProjectRelationResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInsertObjectToProjectRelationResult(String value) {
        this.insertObjectToProjectRelationResult = value;
    }

}
