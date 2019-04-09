
package ru.rbt.jetski.advanta.ws.login;

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
 *         &lt;element name="IssueLoginUrlResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "issueLoginUrlResult"
})
@XmlRootElement(name = "IssueLoginUrlResponse")
public class IssueLoginUrlResponse {

    @XmlElement(name = "IssueLoginUrlResult")
    protected String issueLoginUrlResult;

    /**
     * Gets the value of the issueLoginUrlResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIssueLoginUrlResult() {
        return issueLoginUrlResult;
    }

    /**
     * Sets the value of the issueLoginUrlResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssueLoginUrlResult(String value) {
        this.issueLoginUrlResult = value;
    }

}
