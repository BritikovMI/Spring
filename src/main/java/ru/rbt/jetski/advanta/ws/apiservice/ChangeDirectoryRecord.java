
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
 *         &lt;element name="directoryRecordId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "directoryRecordId",
    "lstParams",
    "record"
})
@XmlRootElement(name = "ChangeDirectoryRecord")
public class ChangeDirectoryRecord {

    @XmlElement(name = "ASPNETSessionId")
    protected String aspnetSessionId;
    protected String directoryRecordId;
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
     * Gets the value of the directoryRecordId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDirectoryRecordId() {
        return directoryRecordId;
    }

    /**
     * Sets the value of the directoryRecordId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDirectoryRecordId(String value) {
        this.directoryRecordId = value;
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
