
package cn.gov.ynhrss.baseinfo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for bizenv complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="bizenv">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bizhead" type="{http://www.ynhrss.gov.cn/baseinfo}bizhead"/>
 *         &lt;element name="bizbody" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bizenv", propOrder = {
    "bizhead",
    "bizbody"
})
public class Bizenv {

    @XmlElement(required = true, nillable = true)
    protected Bizhead bizhead;
    @XmlElement(required = true, nillable = true)
    protected String bizbody;

    /**
     * Gets the value of the bizhead property.
     * 
     * @return
     *     possible object is
     *     {@link Bizhead }
     *     
     */
    public Bizhead getBizhead() {
        return bizhead;
    }

    /**
     * Sets the value of the bizhead property.
     * 
     * @param value
     *     allowed object is
     *     {@link Bizhead }
     *     
     */
    public void setBizhead(Bizhead value) {
        this.bizhead = value;
    }

    /**
     * Gets the value of the bizbody property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBizbody() {
        return bizbody;
    }

    /**
     * Sets the value of the bizbody property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBizbody(String value) {
        this.bizbody = value;
    }

}
