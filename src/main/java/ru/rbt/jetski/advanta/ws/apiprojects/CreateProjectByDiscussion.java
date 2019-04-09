
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
 *         &lt;element name="newProject" type="{http://streamline/}CreateProjectWithDiscussion" minOccurs="0"/>
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
    "newProject"
})
@XmlRootElement(name = "CreateProjectByDiscussion")
public class CreateProjectByDiscussion {

    protected CreateProjectWithDiscussion newProject;

    /**
     * Gets the value of the newProject property.
     * 
     * @return
     *     possible object is
     *     {@link CreateProjectWithDiscussion }
     *     
     */
    public CreateProjectWithDiscussion getNewProject() {
        return newProject;
    }

    /**
     * Sets the value of the newProject property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreateProjectWithDiscussion }
     *     
     */
    public void setNewProject(CreateProjectWithDiscussion value) {
        this.newProject = value;
    }

}
