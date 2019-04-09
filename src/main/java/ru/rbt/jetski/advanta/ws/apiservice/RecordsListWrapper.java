
package ru.rbt.jetski.advanta.ws.apiservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RecordsListWrapper complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RecordsListWrapper">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Records" type="{http://tempuri.org/}ArrayOfRecordWrapper" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RecordsListWrapper", propOrder = {
    "records"
})
public class RecordsListWrapper {

    @XmlElement(name = "Records")
    protected ArrayOfRecordWrapper records;

    /**
     * Gets the value of the records property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfRecordWrapper }
     *     
     */
    public ArrayOfRecordWrapper getRecords() {
        return records;
    }

    /**
     * Sets the value of the records property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfRecordWrapper }
     *     
     */
    public void setRecords(ArrayOfRecordWrapper value) {
        this.records = value;
    }

}
