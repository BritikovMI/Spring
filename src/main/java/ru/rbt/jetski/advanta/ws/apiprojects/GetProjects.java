
package ru.rbt.jetski.advanta.ws.apiprojects;

import javax.xml.bind.annotation.*;


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
 *         &lt;element name="ASPNETSessionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="filterWrappers" type="{http://streamline/}ArrayOfFilterWrapper" minOccurs="0"/>
 *         &lt;element name="sortWrappers" type="{http://streamline/}ArrayOfSortWrapper" minOccurs="0"/>
 *         &lt;element name="Hierarchical" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "aspnetSessionId",
    "filterWrappers",
    "sortWrappers",
    "hierarchical"
})
@XmlRootElement(name = "GetProjects")
public class GetProjects {

    @XmlElement(name = "ASPNETSessionId")
    protected String aspnetSessionId;
    protected ArrayOfFilterWrapper filterWrappers;
    protected ArrayOfSortWrapper sortWrappers;
    @XmlElement(name = "Hierarchical")
    protected boolean hierarchical;

    /**
     * Gets the value of the aspnetSessionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getASPNETSessionId() {
        return aspnetSessionId;
    }

    /**
     * Sets the value of the aspnetSessionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setASPNETSessionId(String value) {
        this.aspnetSessionId = value;
    }

    /**
     * Gets the value of the filterWrappers property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfFilterWrapper }
     *     
     */
    public ArrayOfFilterWrapper getFilterWrappers() {
        return filterWrappers;
    }

    /**
     * Sets the value of the filterWrappers property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfFilterWrapper }
     *     
     */
    public void setFilterWrappers(ArrayOfFilterWrapper value) {
        this.filterWrappers = value;
    }

    /**
     * Gets the value of the sortWrappers property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfSortWrapper }
     *     
     */
    public ArrayOfSortWrapper getSortWrappers() {
        return sortWrappers;
    }

    /**
     * Sets the value of the sortWrappers property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfSortWrapper }
     *     
     */
    public void setSortWrappers(ArrayOfSortWrapper value) {
        this.sortWrappers = value;
    }

    /**
     * Gets the value of the hierarchical property.
     * 
     */
    public boolean isHierarchical() {
        return hierarchical;
    }

    /**
     * Sets the value of the hierarchical property.
     * 
     */
    public void setHierarchical(boolean value) {
        this.hierarchical = value;
    }

}
