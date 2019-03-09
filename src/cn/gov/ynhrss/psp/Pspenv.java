
package cn.gov.ynhrss.psp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for pspenv complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="pspenv">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="psppilot" type="{http://www.ynhrss.gov.cn/psp}psppilot"/>
 *         &lt;element name="pspheader" type="{http://www.ynhrss.gov.cn/psp}pspheader"/>
 *         &lt;element name="pspbody" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pspenv", propOrder = {
    "psppilot",
    "pspheader",
    "pspbody"
})
public class Pspenv {

    @XmlElement(required = true, nillable = true)
    protected Psppilot psppilot;
    @XmlElement(required = true, nillable = true)
    protected Pspheader pspheader;
    @XmlElement(required = true, nillable = true)
    protected String pspbody;

    /**
     * Gets the value of the psppilot property.
     * 
     * @return
     *     possible object is
     *     {@link Psppilot }
     *     
     */
    public Psppilot getPsppilot() {
        return psppilot;
    }

    /**
     * Sets the value of the psppilot property.
     * 
     * @param value
     *     allowed object is
     *     {@link Psppilot }
     *     
     */
    public void setPsppilot(Psppilot value) {
        this.psppilot = value;
    }

    /**
     * Gets the value of the pspheader property.
     * 
     * @return
     *     possible object is
     *     {@link Pspheader }
     *     
     */
    public Pspheader getPspheader() {
        return pspheader;
    }

    /**
     * Sets the value of the pspheader property.
     * 
     * @param value
     *     allowed object is
     *     {@link Pspheader }
     *     
     */
    public void setPspheader(Pspheader value) {
        this.pspheader = value;
    }

    /**
     * Gets the value of the pspbody property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPspbody() {
        return pspbody;
    }

    /**
     * Sets the value of the pspbody property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPspbody(String value) {
        this.pspbody = value;
    }

}
