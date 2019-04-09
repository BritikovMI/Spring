
package ru.rbt.jetski.advanta.ws.apiprojects;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for CreateProjectDataContract complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="CreateProjectDataContract">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ASPNETSessionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ParentProjectId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProjectTypeId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProjectName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Order" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ProjectOwnerId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProjectResponsibleId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PlannedStartDateSerialized" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PlannedStartDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="PlannedEndDateSerialized" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PlannedEndDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="Fields" type="{http://streamline/}ArrayOfFieldWrapper" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateProjectDataContract", propOrder = {
        "aspnetSessionId",
        "parentProjectId",
        "projectTypeId",
        "projectName",
        "order",
        "projectOwnerId",
        "projectResponsibleId",
        "plannedStartDateSerialized",
        "plannedStartDate",
        "plannedEndDateSerialized",
        "plannedEndDate",
        "fields"
})
@XmlSeeAlso({
        CreateProjectWithDiscussion.class
})
public class CreateProjectDataContract {

    @XmlElement(name = "ASPNETSessionId")
    protected String aspnetSessionId;
    @XmlElement(name = "ParentProjectId")
    protected String parentProjectId;
    @XmlElement(name = "ProjectTypeId")
    protected String projectTypeId;
    @XmlElement(name = "ProjectName")
    protected String projectName;
    @XmlElement(name = "Order")
    protected int order;
    @XmlElement(name = "ProjectOwnerId")
    protected String projectOwnerId;
    @XmlElement(name = "ProjectResponsibleId")
    protected String projectResponsibleId;
    @XmlElement(name = "PlannedStartDateSerialized")
    protected String plannedStartDateSerialized;
    @XmlElement(name = "PlannedStartDate", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar plannedStartDate;
    @XmlElement(name = "PlannedEndDateSerialized")
    protected String plannedEndDateSerialized;
    @XmlElement(name = "PlannedEndDate", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar plannedEndDate;
    @XmlElement(name = "Fields")
    protected ArrayOfFieldWrapper fields;

    /**
     * Gets the value of the aspnetSessionId property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getASPNETSessionId() {
        return aspnetSessionId;
    }

    /**
     * Sets the value of the aspnetSessionId property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setASPNETSessionId(String value) {
        this.aspnetSessionId = value;
    }

    /**
     * Gets the value of the parentProjectId property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getParentProjectId() {
        return parentProjectId;
    }

    /**
     * Sets the value of the parentProjectId property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setParentProjectId(String value) {
        this.parentProjectId = value;
    }

    /**
     * Gets the value of the projectTypeId property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getProjectTypeId() {
        return projectTypeId;
    }

    /**
     * Sets the value of the projectTypeId property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setProjectTypeId(String value) {
        this.projectTypeId = value;
    }

    /**
     * Gets the value of the projectName property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * Sets the value of the projectName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setProjectName(String value) {
        this.projectName = value;
    }

    /**
     * Gets the value of the order property.
     */
    public int getOrder() {
        return order;
    }

    /**
     * Sets the value of the order property.
     */
    public void setOrder(int value) {
        this.order = value;
    }

    /**
     * Gets the value of the projectOwnerId property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getProjectOwnerId() {
        return projectOwnerId;
    }

    /**
     * Sets the value of the projectOwnerId property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setProjectOwnerId(String value) {
        this.projectOwnerId = value;
    }

    /**
     * Gets the value of the projectResponsibleId property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getProjectResponsibleId() {
        return projectResponsibleId;
    }

    /**
     * Sets the value of the projectResponsibleId property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setProjectResponsibleId(String value) {
        this.projectResponsibleId = value;
    }

    /**
     * Gets the value of the plannedStartDateSerialized property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPlannedStartDateSerialized() {
        return plannedStartDateSerialized;
    }

    /**
     * Sets the value of the plannedStartDateSerialized property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPlannedStartDateSerialized(String value) {
        this.plannedStartDateSerialized = value;
    }

    /**
     * Gets the value of the plannedStartDate property.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getPlannedStartDate() {
        return plannedStartDate;
    }

    /**
     * Sets the value of the plannedStartDate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setPlannedStartDate(XMLGregorianCalendar value) {
        this.plannedStartDate = value;
    }

    /**
     * Gets the value of the plannedEndDateSerialized property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPlannedEndDateSerialized() {
        return plannedEndDateSerialized;
    }

    /**
     * Sets the value of the plannedEndDateSerialized property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPlannedEndDateSerialized(String value) {
        this.plannedEndDateSerialized = value;
    }

    /**
     * Gets the value of the plannedEndDate property.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getPlannedEndDate() {
        return plannedEndDate;
    }

    /**
     * Sets the value of the plannedEndDate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setPlannedEndDate(XMLGregorianCalendar value) {
        this.plannedEndDate = value;
    }

    /**
     * Gets the value of the fields property.
     *
     * @return possible object is
     * {@link ArrayOfFieldWrapper }
     */
    public ArrayOfFieldWrapper getFields() {
        return fields;
    }

    /**
     * Sets the value of the fields property.
     *
     * @param value allowed object is
     *              {@link ArrayOfFieldWrapper }
     */
    public void setFields(ArrayOfFieldWrapper value) {
        this.fields = value;
    }

}
