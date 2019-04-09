
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
 *         &lt;element name="SearchDirectoryRecordsByStatusResult" type="{http://tempuri.org/}ArrayOfProjectWrapper" minOccurs="0"/>
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
    "searchDirectoryRecordsByStatusResult"
})
@XmlRootElement(name = "SearchDirectoryRecordsByStatusResponse")
public class SearchDirectoryRecordsByStatusResponse {

    @XmlElement(name = "SearchDirectoryRecordsByStatusResult")
    protected ArrayOfProjectWrapper searchDirectoryRecordsByStatusResult;

    /**
     * Gets the value of the searchDirectoryRecordsByStatusResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfProjectWrapper }
     *     
     */
    public ArrayOfProjectWrapper getSearchDirectoryRecordsByStatusResult() {
        return searchDirectoryRecordsByStatusResult;
    }

    /**
     * Sets the value of the searchDirectoryRecordsByStatusResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfProjectWrapper }
     *     
     */
    public void setSearchDirectoryRecordsByStatusResult(ArrayOfProjectWrapper value) {
        this.searchDirectoryRecordsByStatusResult = value;
    }

}
