
package ru.rbt.jetski.advanta.ws.persons;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for ServiceQueryResultOfSlPerson complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServiceQueryResultOfSlPerson">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Errors" type="{http://streamline/}ArrayOfString" minOccurs="0"/>
 *         &lt;element name="Objects" type="{http://streamline/}ArrayOfSlPerson" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceQueryResultOfSlPerson", propOrder = {
    "errors",
    "objects"
})
@XmlSeeAlso({
    PersonQueryResult.class
})
public class ServiceQueryResultOfSlPerson {

    @XmlElement(name = "Errors")
    protected ArrayOfString errors;
    @XmlElement(name = "Objects")
    protected ArrayOfSlPerson objects;

    /**
     * Gets the value of the errors property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getErrors() {
        return errors;
    }

    /**
     * Sets the value of the errors property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setErrors(ArrayOfString value) {
        this.errors = value;
    }

    /**
     * Gets the value of the objects property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfSlPerson }
     *     
     */
    public ArrayOfSlPerson getObjects() {
        return objects;
    }

    /**
     * Sets the value of the objects property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfSlPerson }
     *     
     */
    public void setObjects(ArrayOfSlPerson value) {
        this.objects = value;
    }

}
