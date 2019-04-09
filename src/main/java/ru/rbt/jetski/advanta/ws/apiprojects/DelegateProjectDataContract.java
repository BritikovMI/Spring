
package ru.rbt.jetski.advanta.ws.apiprojects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DelegateProjectDataContract complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DelegateProjectDataContract">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ASPNETSessionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProjectId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DelegateUserId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DelegateOwnerId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AutoAccept" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DelegateProjectDataContract", propOrder = {
    "aspnetSessionId",
    "projectId",
    "delegateUserId",
    "delegateOwnerId",
    "autoAccept"
})
public class DelegateProjectDataContract {

    @XmlElement(name = "ASPNETSessionId")
    protected String aspnetSessionId;
    @XmlElement(name = "ProjectId")
    protected String projectId;
    @XmlElement(name = "DelegateUserId")
    protected String delegateUserId;
    @XmlElement(name = "DelegateOwnerId")
    protected String delegateOwnerId;
    @XmlElement(name = "AutoAccept", required = true, type = Boolean.class, nillable = true)
    protected Boolean autoAccept;

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
     * Gets the value of the delegateUserId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDelegateUserId() {
        return delegateUserId;
    }

    /**
     * Sets the value of the delegateUserId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDelegateUserId(String value) {
        this.delegateUserId = value;
    }

    /**
     * Gets the value of the delegateOwnerId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDelegateOwnerId() {
        return delegateOwnerId;
    }

    /**
     * Sets the value of the delegateOwnerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDelegateOwnerId(String value) {
        this.delegateOwnerId = value;
    }

    /**
     * Gets the value of the autoAccept property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAutoAccept() {
        return autoAccept;
    }

    /**
     * Sets the value of the autoAccept property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAutoAccept(Boolean value) {
        this.autoAccept = value;
    }

}
