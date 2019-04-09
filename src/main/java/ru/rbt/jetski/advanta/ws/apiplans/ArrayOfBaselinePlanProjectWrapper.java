
package ru.rbt.jetski.advanta.ws.apiplans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for ArrayOfBaselinePlanProjectWrapper complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfBaselinePlanProjectWrapper">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BaselinePlanProjectWrapper" type="{http://streamline/}BaselinePlanProjectWrapper" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfBaselinePlanProjectWrapper", propOrder = {
    "baselinePlanProjectWrapper"
})
public class ArrayOfBaselinePlanProjectWrapper {

    @XmlElement(name = "BaselinePlanProjectWrapper", nillable = true)
    protected List<BaselinePlanProjectWrapper> baselinePlanProjectWrapper;

    /**
     * Gets the value of the baselinePlanProjectWrapper property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the baselinePlanProjectWrapper property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBaselinePlanProjectWrapper().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BaselinePlanProjectWrapper }
     * 
     * 
     */
    public List<BaselinePlanProjectWrapper> getBaselinePlanProjectWrapper() {
        if (baselinePlanProjectWrapper == null) {
            baselinePlanProjectWrapper = new ArrayList<BaselinePlanProjectWrapper>();
        }
        return this.baselinePlanProjectWrapper;
    }

}
