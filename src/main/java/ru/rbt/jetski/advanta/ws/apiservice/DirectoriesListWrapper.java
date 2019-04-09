
package ru.rbt.jetski.advanta.ws.apiservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DirectoriesListWrapper complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DirectoriesListWrapper">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Directories" type="{http://tempuri.org/}ArrayOfDirectoryWrapper" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DirectoriesListWrapper", propOrder = {
    "directories"
})
public class DirectoriesListWrapper {

    @XmlElement(name = "Directories")
    protected ArrayOfDirectoryWrapper directories;

    /**
     * Gets the value of the directories property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfDirectoryWrapper }
     *     
     */
    public ArrayOfDirectoryWrapper getDirectories() {
        return directories;
    }

    /**
     * Sets the value of the directories property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfDirectoryWrapper }
     *     
     */
    public void setDirectories(ArrayOfDirectoryWrapper value) {
        this.directories = value;
    }

}
