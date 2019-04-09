
package ru.rbt.jetski.advanta.ws.apiprojects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DocumentFieldWrapper complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DocumentFieldWrapper">
 *   &lt;complexContent>
 *     &lt;extension base="{http://streamline/}FieldWrapper">
 *       &lt;sequence>
 *         &lt;element name="DocumentName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DocumentBody" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DocumentContentType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentFieldWrapper", propOrder = {
    "documentName",
    "documentBody",
    "documentContentType"
})
public class DocumentFieldWrapper
    extends FieldWrapper
{

    @XmlElement(name = "DocumentName")
    protected String documentName;
    @XmlElement(name = "DocumentBody")
    protected String documentBody;
    @XmlElement(name = "DocumentContentType")
    protected String documentContentType;

    /**
     * Gets the value of the documentName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentName() {
        return documentName;
    }

    /**
     * Sets the value of the documentName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentName(String value) {
        this.documentName = value;
    }

    /**
     * Gets the value of the documentBody property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentBody() {
        return documentBody;
    }

    /**
     * Sets the value of the documentBody property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentBody(String value) {
        this.documentBody = value;
    }

    /**
     * Gets the value of the documentContentType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentContentType() {
        return documentContentType;
    }

    /**
     * Sets the value of the documentContentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentContentType(String value) {
        this.documentContentType = value;
    }

}
