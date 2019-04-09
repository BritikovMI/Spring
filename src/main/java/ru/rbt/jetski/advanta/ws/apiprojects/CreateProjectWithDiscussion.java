
package ru.rbt.jetski.advanta.ws.apiprojects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CreateProjectWithDiscussion complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreateProjectWithDiscussion">
 *   &lt;complexContent>
 *     &lt;extension base="{http://streamline/}CreateProjectDataContract">
 *       &lt;sequence>
 *         &lt;element name="DiscussionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateProjectWithDiscussion", propOrder = {
    "discussionId"
})
public class CreateProjectWithDiscussion
    extends CreateProjectDataContract
{

    @XmlElement(name = "DiscussionId")
    protected String discussionId;

    /**
     * Gets the value of the discussionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiscussionId() {
        return discussionId;
    }

    /**
     * Sets the value of the discussionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiscussionId(String value) {
        this.discussionId = value;
    }

}
