
package ru.rbt.jetski.advanta.ws.apiservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for ArrayOfDocumentVersionWrapper complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfDocumentVersionWrapper">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DocumentVersionWrapper" type="{http://tempuri.org/}DocumentVersionWrapper" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfDocumentVersionWrapper", propOrder = {
    "documentVersionWrapper"
})
public class ArrayOfDocumentVersionWrapper {

    @XmlElement(name = "DocumentVersionWrapper", nillable = true)
    protected List<DocumentVersionWrapper> documentVersionWrapper;

    /**
     * Gets the value of the documentVersionWrapper property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the documentVersionWrapper property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocumentVersionWrapper().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocumentVersionWrapper }
     * 
     * 
     */
    public List<DocumentVersionWrapper> getDocumentVersionWrapper() {
        if (documentVersionWrapper == null) {
            documentVersionWrapper = new ArrayList<DocumentVersionWrapper>();
        }
        return this.documentVersionWrapper;
    }

}
