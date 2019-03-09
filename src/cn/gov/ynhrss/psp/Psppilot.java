
package cn.gov.ynhrss.psp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for psppilot complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="psppilot">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="srcsysid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="userid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="serviceid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="invokedatetime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="encryptkeymode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="bodyencryptedflag" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="districtid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="encryptedkey" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="statuscode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="statusmessage" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "psppilot", propOrder = {
    "version",
    "srcsysid",
    "userid",
    "serviceid",
    "invokedatetime",
    "encryptkeymode",
    "bodyencryptedflag",
    "districtid",
    "encryptedkey",
    "statuscode",
    "statusmessage"
})
public class Psppilot {

    @XmlElement(required = true, nillable = true)
    protected String version;
    @XmlElement(required = true, nillable = true)
    protected String srcsysid;
    @XmlElement(required = true, nillable = true)
    protected String userid;
    @XmlElement(required = true, nillable = true)
    protected String serviceid;
    @XmlElement(required = true, nillable = true)
    protected String invokedatetime;
    @XmlElement(required = true, nillable = true)
    protected String encryptkeymode;
    @XmlElement(required = true, nillable = true)
    protected String bodyencryptedflag;
    @XmlElement(required = true, nillable = true)
    protected String districtid;
    @XmlElement(required = true, nillable = true)
    protected String encryptedkey;
    @XmlElement(required = true, nillable = true)
    protected String statuscode;
    @XmlElement(required = true, nillable = true)
    protected String statusmessage;

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Gets the value of the srcsysid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSrcsysid() {
        return srcsysid;
    }

    /**
     * Sets the value of the srcsysid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSrcsysid(String value) {
        this.srcsysid = value;
    }

    /**
     * Gets the value of the userid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserid() {
        return userid;
    }

    /**
     * Sets the value of the userid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserid(String value) {
        this.userid = value;
    }

    /**
     * Gets the value of the serviceid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceid() {
        return serviceid;
    }

    /**
     * Sets the value of the serviceid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceid(String value) {
        this.serviceid = value;
    }

    /**
     * Gets the value of the invokedatetime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvokedatetime() {
        return invokedatetime;
    }

    /**
     * Sets the value of the invokedatetime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvokedatetime(String value) {
        this.invokedatetime = value;
    }

    /**
     * Gets the value of the encryptkeymode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEncryptkeymode() {
        return encryptkeymode;
    }

    /**
     * Sets the value of the encryptkeymode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEncryptkeymode(String value) {
        this.encryptkeymode = value;
    }

    /**
     * Gets the value of the bodyencryptedflag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBodyencryptedflag() {
        return bodyencryptedflag;
    }

    /**
     * Sets the value of the bodyencryptedflag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBodyencryptedflag(String value) {
        this.bodyencryptedflag = value;
    }

    /**
     * Gets the value of the districtid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDistrictid() {
        return districtid;
    }

    /**
     * Sets the value of the districtid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDistrictid(String value) {
        this.districtid = value;
    }

    /**
     * Gets the value of the encryptedkey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEncryptedkey() {
        return encryptedkey;
    }

    /**
     * Sets the value of the encryptedkey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEncryptedkey(String value) {
        this.encryptedkey = value;
    }

    /**
     * Gets the value of the statuscode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatuscode() {
        return statuscode;
    }

    /**
     * Sets the value of the statuscode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatuscode(String value) {
        this.statuscode = value;
    }

    /**
     * Gets the value of the statusmessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusmessage() {
        return statusmessage;
    }

    /**
     * Sets the value of the statusmessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusmessage(String value) {
        this.statusmessage = value;
    }

}
