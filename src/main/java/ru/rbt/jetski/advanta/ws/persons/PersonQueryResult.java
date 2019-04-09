
package ru.rbt.jetski.advanta.ws.persons;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PersonQueryResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PersonQueryResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://streamline/}ServiceQueryResultOfSlPerson">
 *       &lt;sequence>
 *         &lt;element name="Persons" type="{http://streamline/}ArrayOfSlPerson" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PersonQueryResult", propOrder = {
    "persons"
})
public class PersonQueryResult
    extends ServiceQueryResultOfSlPerson
{

    @XmlElement(name = "Persons")
    protected ArrayOfSlPerson persons;

    /**
     * Gets the value of the persons property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfSlPerson }
     *     
     */
    public ArrayOfSlPerson getPersons() {
        return persons;
    }

    /**
     * Sets the value of the persons property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfSlPerson }
     *     
     */
    public void setPersons(ArrayOfSlPerson value) {
        this.persons = value;
    }

}
