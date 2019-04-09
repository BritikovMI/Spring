
package ru.rbt.jetski.advanta.ws.login;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="cr" type="{http://streamline/}CredentialRequest" minOccurs="0"/>
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
    "cr"
})
@XmlRootElement(name = "IssueCredential")
public class IssueCredential {

    protected CredentialRequest cr;

    /**
     * Gets the value of the cr property.
     * 
     * @return
     *     possible object is
     *     {@link CredentialRequest }
     *     
     */
    public CredentialRequest getCr() {
        return cr;
    }

    /**
     * Sets the value of the cr property.
     * 
     * @param value
     *     allowed object is
     *     {@link CredentialRequest }
     *     
     */
    public void setCr(CredentialRequest value) {
        this.cr = value;
    }

}
