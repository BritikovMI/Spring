
package ru.rbt.jetski.advanta.ws.persons;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for ArrayOfSlPerson complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfSlPerson">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SlPerson" type="{http://streamline/}SlPerson" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfSlPerson", propOrder = {
    "slPerson"
})
public class ArrayOfSlPerson {

    @XmlElement(name = "SlPerson", nillable = true)
    protected List<SlPerson> slPerson;

    /**
     * Gets the value of the slPerson property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the slPerson property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSlPerson().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SlPerson }
     * 
     * 
     */
    public List<SlPerson> getSlPerson() {
        if (slPerson == null) {
            slPerson = new ArrayList<SlPerson>();
        }
        return this.slPerson;
    }

}
