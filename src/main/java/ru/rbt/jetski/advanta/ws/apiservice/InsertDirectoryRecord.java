
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
 *         &lt;element name="directoryTemplateId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="projectId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lstParams" type="{http://tempuri.org/}ArrayOfFieldWrapper" minOccurs="0"/>
 *         &lt;element name="record" type="{http://tempuri.org/}RecordWrapper" minOccurs="0"/>
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
    "directoryTemplateId",
    "projectId",
    "lstParams",
    "record"
})
@XmlRootElement(name = "InsertDirectoryRecord")
public class InsertDirectoryRecord {

    @XmlElement(name = "ASPNETSessionId")
    protected String aspnetSessionId;
    protected String directoryTemplateId;
    protected String projectId;
    protected ArrayOfFieldWrapper lstParams;
    protected RecordWrapper record;

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
     * Gets the value of the directoryTemplateId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDirectoryTemplateId() {
        return directoryTemplateId;
    }

    /**
     * Sets the value of the directoryTemplateId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDirectoryTemplateId(String value) {
        this.directoryTemplateId = value;
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

    /**
     * Gets the value of the record property.
     * 
     * @return
     *     possible object is
     *     {@link RecordWrapper }
     *     
     */
    public RecordWrapper getRecord() {
        return record;
    }

    /**
     * Sets the value of the record property.
     * 
     * @param value
     *     allowed object is
     *     {@link RecordWrapper }
     *     
     */
    public void setRecord(RecordWrapper value) {
        this.record = value;
    }

}
