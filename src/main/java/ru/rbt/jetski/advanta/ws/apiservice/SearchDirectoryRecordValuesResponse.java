
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
 *         &lt;element name="SearchDirectoryRecordValuesResult" type="{http://tempuri.org/}ArrayOfProjectWrapper" minOccurs="0"/>
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
    "searchDirectoryRecordValuesResult"
})
@XmlRootElement(name = "SearchDirectoryRecordValuesResponse")
public class SearchDirectoryRecordValuesResponse {

    @XmlElement(name = "SearchDirectoryRecordValuesResult")
    protected ArrayOfProjectWrapper searchDirectoryRecordValuesResult;

    /**
     * Gets the value of the searchDirectoryRecordValuesResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfProjectWrapper }
     *     
     */
    public ArrayOfProjectWrapper getSearchDirectoryRecordValuesResult() {
        return searchDirectoryRecordValuesResult;
    }

    /**
     * Sets the value of the searchDirectoryRecordValuesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfProjectWrapper }
     *     
     */
    public void setSearchDirectoryRecordValuesResult(ArrayOfProjectWrapper value) {
        this.searchDirectoryRecordValuesResult = value;
    }

}
