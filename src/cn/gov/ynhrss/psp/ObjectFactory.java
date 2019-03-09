
package cn.gov.ynhrss.psp;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cn.gov.ynhrss.psp package. 
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

    private final static QName _Pspenv_QNAME = new QName("http://www.ynhrss.gov.cn/psp", "pspenv");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cn.gov.ynhrss.psp
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Pspenv }
     * 
     */
    public Pspenv createPspenv() {
        return new Pspenv();
    }

    /**
     * Create an instance of {@link Pspheader }
     * 
     */
    public Pspheader createPspheader() {
        return new Pspheader();
    }

    /**
     * Create an instance of {@link Psppilot }
     * 
     */
    public Psppilot createPsppilot() {
        return new Psppilot();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Pspenv }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ynhrss.gov.cn/psp", name = "pspenv")
    public JAXBElement<Pspenv> createPspenv(Pspenv value) {
        return new JAXBElement<Pspenv>(_Pspenv_QNAME, Pspenv.class, null, value);
    }

}
