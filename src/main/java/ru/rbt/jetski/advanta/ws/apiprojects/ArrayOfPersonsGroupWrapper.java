
package ru.rbt.jetski.advanta.ws.apiprojects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for ArrayOfPersonsGroupWrapper complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfPersonsGroupWrapper">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PersonsGroupWrapper" type="{http://streamline/}PersonsGroupWrapper" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfPersonsGroupWrapper", propOrder = {
    "personsGroupWrapper"
})
public class ArrayOfPersonsGroupWrapper {

    @XmlElement(name = "PersonsGroupWrapper", nillable = true)
    protected List<PersonsGroupWrapper> personsGroupWrapper;

    /**
     * Gets the value of the personsGroupWrapper property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the personsGroupWrapper property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPersonsGroupWrapper().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PersonsGroupWrapper }
     * 
     * 
     */
    public List<PersonsGroupWrapper> getPersonsGroupWrapper() {
        if (personsGroupWrapper == null) {
            personsGroupWrapper = new ArrayList<PersonsGroupWrapper>();
        }
        return this.personsGroupWrapper;
    }

}
