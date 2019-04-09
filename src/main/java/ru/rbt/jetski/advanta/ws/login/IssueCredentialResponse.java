
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
 *         &lt;element name="IssueCredentialResult" type="{http://streamline/}CredentialInfo" minOccurs="0"/>
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
    "issueCredentialResult"
})
@XmlRootElement(name = "IssueCredentialResponse")
public class IssueCredentialResponse {

    @XmlElement(name = "IssueCredentialResult")
    protected CredentialInfo issueCredentialResult;

    /**
     * Gets the value of the issueCredentialResult property.
     * 
     * @return
     *     possible object is
     *     {@link CredentialInfo }
     *     
     */
    public CredentialInfo getIssueCredentialResult() {
        return issueCredentialResult;
    }

    /**
     * Sets the value of the issueCredentialResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link CredentialInfo }
     *     
     */
    public void setIssueCredentialResult(CredentialInfo value) {
        this.issueCredentialResult = value;
    }

}
