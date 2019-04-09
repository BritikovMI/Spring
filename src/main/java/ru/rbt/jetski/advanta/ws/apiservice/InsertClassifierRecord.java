
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
 *         &lt;element name="classifierId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="parentId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lstParams" type="{http://tempuri.org/}ArrayOfFieldWrapper" minOccurs="0"/>
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
    "classifierId",
    "name",
    "parentId",
    "lstParams"
})
@XmlRootElement(name = "InsertClassifierRecord")
public class InsertClassifierRecord {

    @XmlElement(name = "ASPNETSessionId")
    protected String aspnetSessionId;
    protected String classifierId;
    protected String name;
    protected String parentId;
    protected ArrayOfFieldWrapper lstParams;

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
     * Gets the value of the classifierId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClassifierId() {
        return classifierId;
    }

    /**
     * Sets the value of the classifierId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClassifierId(String value) {
        this.classifierId = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the parentId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * Sets the value of the parentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParentId(String value) {
        this.parentId = value;
    }

    /**
     * Gets the value of the lstParams property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfFieldWrapper }
     *     
     */
    public ArrayOfFieldWrapper getLstParams() {
        return lstParams;
    }

    /**
     * Sets the value of the lstParams property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfFieldWrapper }
     *     
     */
    public void setLstParams(ArrayOfFieldWrapper value) {
        this.lstParams = value;
    }

}
