
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
 *         &lt;element name="ASPNETSessionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="directoryRecordObjectID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="projectId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="relationTemplateID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "aspnetSessionId",
    "directoryRecordObjectID",
    "projectId",
    "relationTemplateID"
})
@XmlRootElement(name = "InsertObjectToProjectRelation")
public class InsertObjectToProjectRelation {

    @XmlElement(name = "ASPNETSessionId")
    protected String aspnetSessionId;
    protected String directoryRecordObjectID;
    protected String projectId;
    protected String relationTemplateID;

    /**
     * Gets the value of the aspnetSessionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getASPNETSessionId() {
        return aspnetSessionId;
    }

    /**
     * Sets the value of the aspnetSessionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setASPNETSessionId(String value) {
        this.aspnetSessionId = value;
    }

    /**
     * Gets the value of the directoryRecordObjectID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDirectoryRecordObjectID() {
        return directoryRecordObjectID;
    }

    /**
     * Sets the value of the directoryRecordObjectID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDirectoryRecordObjectID(String value) {
        this.directoryRecordObjectID = value;
    }

    /**
     * Gets the value of the projectId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProjectId() {
        return projectId;
    }

    /**
     * Sets the value of the projectId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProjectId(String value) {
        this.projectId = value;
    }

    /**
     * Gets the value of the relationTemplateID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRelationTemplateID() {
        return relationTemplateID;
    }

    /**
     * Sets the value of the relationTemplateID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRelationTemplateID(String value) {
        this.relationTemplateID = value;
    }

}
