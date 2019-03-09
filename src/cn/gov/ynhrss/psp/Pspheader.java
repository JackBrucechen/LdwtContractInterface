
package cn.gov.ynhrss.psp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for pspheader complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="pspheader">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="srcsysauthtype" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="srcsystoken" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="userauthtype" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="usertoken" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="batchno" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="srcmsgid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="desmsgid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="secretkeyid" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "pspheader", propOrder = {
    "srcsysauthtype",
    "srcsystoken",
    "userauthtype",
    "usertoken",
    "batchno",
    "srcmsgid",
    "desmsgid",
    "secretkeyid"
})
public class Pspheader {

    @XmlElement(required = true, nillable = true)
    protected String srcsysauthtype;
    @XmlElement(required = true, nillable = true)
    protected String srcsystoken;
    @XmlElement(required = true, nillable = true)
    protected String userauthtype;
    @XmlElement(required = true, nillable = true)
    protected String usertoken;
    @XmlElement(required = true, nillable = true)
    protected String batchno;
    @XmlElement(required = true, nillable = true)
    protected String srcmsgid;
    @XmlElement(required = true, nillable = true)
    protected String desmsgid;
    @XmlElement(required = true, nillable = true)
    protected String secretkeyid;

    /**
     * Gets the value of the srcsysauthtype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSrcsysauthtype() {
        return srcsysauthtype;
    }

    /**
     * Sets the value of the srcsysauthtype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSrcsysauthtype(String value) {
        this.srcsysauthtype = value;
    }

    /**
     * Gets the value of the srcsystoken property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSrcsystoken() {
        return srcsystoken;
    }

    /**
     * Sets the value of the srcsystoken property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSrcsystoken(String value) {
        this.srcsystoken = value;
    }

    /**
     * Gets the value of the userauthtype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserauthtype() {
        return userauthtype;
    }

    /**
     * Sets the value of the userauthtype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserauthtype(String value) {
        this.userauthtype = value;
    }

    /**
     * Gets the value of the usertoken property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsertoken() {
        return usertoken;
    }

    /**
     * Sets the value of the usertoken property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsertoken(String value) {
        this.usertoken = value;
    }

    /**
     * Gets the value of the batchno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBatchno() {
        return batchno;
    }

    /**
     * Sets the value of the batchno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBatchno(String value) {
        this.batchno = value;
    }

    /**
     * Gets the value of the srcmsgid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSrcmsgid() {
        return srcmsgid;
    }

    /**
     * Sets the value of the srcmsgid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSrcmsgid(String value) {
        this.srcmsgid = value;
    }

    /**
     * Gets the value of the desmsgid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDesmsgid() {
        return desmsgid;
    }

    /**
     * Sets the value of the desmsgid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDesmsgid(String value) {
        this.desmsgid = value;
    }

    /**
     * Gets the value of the secretkeyid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecretkeyid() {
        return secretkeyid;
    }

    /**
     * Sets the value of the secretkeyid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecretkeyid(String value) {
        this.secretkeyid = value;
    }

}
