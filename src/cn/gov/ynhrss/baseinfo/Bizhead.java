
package cn.gov.ynhrss.baseinfo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for bizhead complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="bizhead">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="srcmsgid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="desmsgid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="srcsysid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="srcsystoken" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dessysid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="serviceid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="statuscode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="statusmsg" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="operid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="opertoken" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="batchno" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bizhead", propOrder = {
    "version",
    "srcmsgid",
    "desmsgid",
    "srcsysid",
    "srcsystoken",
    "dessysid",
    "serviceid",
    "statuscode",
    "statusmsg",
    "operid",
    "opertoken",
    "batchno"
})
public class Bizhead {

    @XmlElement(required = true, nillable = true)
    protected String version;
    @XmlElement(required = true, nillable = true)
    protected String srcmsgid;
    @XmlElement(required = true, nillable = true)
    protected String desmsgid;
    @XmlElement(required = true, nillable = true)
    protected String srcsysid;
    @XmlElement(required = true, nillable = true)
    protected String srcsystoken;
    @XmlElement(required = true, nillable = true)
    protected String dessysid;
    @XmlElement(required = true, nillable = true)
    protected String serviceid;
    @XmlElement(required = true, nillable = true)
    protected String statuscode;
    @XmlElement(required = true, nillable = true)
    protected String statusmsg;
    @XmlElement(required = true, nillable = true)
    protected String operid;
    @XmlElement(required = true, nillable = true)
    protected String opertoken;
    @XmlElement(required = true, nillable = true)
    protected String batchno;

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
     * Gets the value of the dessysid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDessysid() {
        return dessysid;
    }

    /**
     * Sets the value of the dessysid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDessysid(String value) {
        this.dessysid = value;
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
     * Gets the value of the statusmsg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusmsg() {
        return statusmsg;
    }

    /**
     * Sets the value of the statusmsg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusmsg(String value) {
        this.statusmsg = value;
    }

    /**
     * Gets the value of the operid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperid() {
        return operid;
    }

    /**
     * Sets the value of the operid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperid(String value) {
        this.operid = value;
    }

    /**
     * Gets the value of the opertoken property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpertoken() {
        return opertoken;
    }

    /**
     * Sets the value of the opertoken property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpertoken(String value) {
        this.opertoken = value;
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

}
