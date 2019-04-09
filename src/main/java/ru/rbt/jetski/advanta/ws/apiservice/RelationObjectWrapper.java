
package ru.rbt.jetski.advanta.ws.apiservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RelationObjectWrapper complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RelationObjectWrapper">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RelationTemplateId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IsFirst" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AllowMultipleValues" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RelationObjectWrapper", propOrder = {
    "relationTemplateId",
    "isFirst",
    "title",
    "allowMultipleValues"
})
public class RelationObjectWrapper {

    @XmlElement(name = "RelationTemplateId")
    protected String relationTemplateId;
    @XmlElement(name = "IsFirst")
    protected boolean isFirst;
    @XmlElement(name = "Title")
    protected String title;
    @XmlElement(name = "AllowMultipleValues")
    protected boolean allowMultipleValues;

    /**
     * Gets the value of the relationTemplateId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRelationTemplateId() {
        return relationTemplateId;
    }

    /**
     * Sets the value of the relationTemplateId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRelationTemplateId(String value) {
        this.relationTemplateId = value;
    }

    /**
     * Gets the value of the isFirst property.
     * 
     */
    public boolean isIsFirst() {
        return isFirst;
    }

    /**
     * Sets the value of the isFirst property.
     * 
     */
    public void setIsFirst(boolean value) {
        this.isFirst = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the allowMultipleValues property.
     * 
     */
    public boolean isAllowMultipleValues() {
        return allowMultipleValues;
    }

    /**
     * Sets the value of the allowMultipleValues property.
     * 
     */
    public void setAllowMultipleValues(boolean value) {
        this.allowMultipleValues = value;
    }

}
