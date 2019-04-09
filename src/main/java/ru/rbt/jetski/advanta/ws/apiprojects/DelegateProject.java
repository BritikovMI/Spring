
package ru.rbt.jetski.advanta.ws.apiprojects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="projectData" type="{http://streamline/}DelegateProjectDataContract" minOccurs="0"/>
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
    "projectData"
})
@XmlRootElement(name = "DelegateProject")
public class DelegateProject {

    protected DelegateProjectDataContract projectData;

    /**
     * Gets the value of the projectData property.
     * 
     * @return
     *     possible object is
     *     {@link DelegateProjectDataContract }
     *     
     */
    public DelegateProjectDataContract getProjectData() {
        return projectData;
    }

    /**
     * Sets the value of the projectData property.
     * 
     * @param value
     *     allowed object is
     *     {@link DelegateProjectDataContract }
     *     
     */
    public void setProjectData(DelegateProjectDataContract value) {
        this.projectData = value;
    }

}
