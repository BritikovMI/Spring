
package ru.rbt.jetski.advanta.ws.login;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.rbt.ru.rbt.jetski.advanta.ws.login package.
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AuthenticationResponse_QNAME = new QName("http://streamline/", "AuthenticationResponse");
    private final static QName _String_QNAME = new QName("http://streamline/", "string");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.rbt.ru.rbt.jetski.advanta.ws.login
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AuthenticateResponse }
     * 
     */
    public AuthenticateResponse createAuthenticateResponse() {
        return new AuthenticateResponse();
    }

    /**
     * Create an instance of {@link AuthenticationResponse }
     * 
     */
    public AuthenticationResponse createAuthenticationResponse() {
        return new AuthenticationResponse();
    }

    /**
     * Create an instance of {@link IssueCredentialResponse }
     * 
     */
    public IssueCredentialResponse createIssueCredentialResponse() {
        return new IssueCredentialResponse();
    }

    /**
     * Create an instance of {@link CredentialInfo }
     * 
     */
    public CredentialInfo createCredentialInfo() {
        return new CredentialInfo();
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link PersonalIndicatorsResponse }
     * 
     */
    public PersonalIndicatorsResponse createPersonalIndicatorsResponse() {
        return new PersonalIndicatorsResponse();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link Authenticate }
     * 
     */
    public Authenticate createAuthenticate() {
        return new Authenticate();
    }

    /**
     * Create an instance of {@link GetDataKeyResponse }
     * 
     */
    public GetDataKeyResponse createGetDataKeyResponse() {
        return new GetDataKeyResponse();
    }

    /**
     * Create an instance of {@link PersonalIndicators }
     * 
     */
    public PersonalIndicators createPersonalIndicators() {
        return new PersonalIndicators();
    }

    /**
     * Create an instance of {@link GetDataKey }
     * 
     */
    public GetDataKey createGetDataKey() {
        return new GetDataKey();
    }

    /**
     * Create an instance of {@link IssueLoginUrl }
     * 
     */
    public IssueLoginUrl createIssueLoginUrl() {
        return new IssueLoginUrl();
    }

    /**
     * Create an instance of {@link IssueCredential }
     * 
     */
    public IssueCredential createIssueCredential() {
        return new IssueCredential();
    }

    /**
     * Create an instance of {@link CredentialRequest }
     * 
     */
    public CredentialRequest createCredentialRequest() {
        return new CredentialRequest();
    }

    /**
     * Create an instance of {@link IssueLoginUrlResponse }
     * 
     */
    public IssueLoginUrlResponse createIssueLoginUrlResponse() {
        return new IssueLoginUrlResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AuthenticationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://streamline/", name = "AuthenticationResponse")
    public JAXBElement<AuthenticationResponse> createAuthenticationResponse(AuthenticationResponse value) {
        return new JAXBElement<AuthenticationResponse>(_AuthenticationResponse_QNAME, AuthenticationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://streamline/", name = "string")
    public JAXBElement<String> createString(String value) {
        return new JAXBElement<String>(_String_QNAME, String.class, null, value);
    }

}
